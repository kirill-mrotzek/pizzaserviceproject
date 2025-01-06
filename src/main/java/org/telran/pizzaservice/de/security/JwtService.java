package org.telran.pizzaservice.de.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.telran.pizzaservice.de.entity.User;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    private final SecretKey secretKey;

    public JwtService(@Value("${jwttoket.signing.key}") String jwtSecretKey) { //читаем подпись токена из application.properties
        this.secretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecretKey));
    }

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        if (userDetails instanceof User user) {
            claims.put("userId", user);
            claims.put("login", user.getLogin());
            claims.put("role", user.getRole().name());

        }
        return generateToken(userDetails, claims);
    }

private String generateToken(UserDetails userDetails, Map<String, Object> claims) {
    return Jwts.builder()
            .claims()
            .issuedAt(new Date()) //дата выдачи токена
            .expiration(new Date(System.currentTimeMillis() + (1000 * 86400))) //токен истечет через сутки после выдачи
            .subject(userDetails.getUsername()) //кому выдан токен
            .add(claims)
            .and()
            .signWith(secretKey) //подписываем токен секретным ключом
            .compact();
}

    public String extractUserName(String jwt) {
        return exrtactClaim(jwt, Claims::getSubject); //кому выдан токен
    }

    public boolean isTokenValid(String jwt, UserDetails userDetails) {
        String userName = extractUserName(jwt); //извлекаем имя пользователя через метод extractUserName

        // userName, Expired
        return userDetails.getUsername().equals(userName) &&
                !isExpired(jwt); //проверяем валидность токена
    }

    private boolean isExpired(String jwt) {
        return extractExpiration(jwt).before(new Date()); //извлекаем дату окончания действия токена и сравниваем с текущей датой
    }

    private Date extractExpiration(String jwt) { //метод извлечения из токена даты окончания срока действия
        return exrtactClaim(jwt, Claims::getExpiration);
    }

    private <T> T exrtactClaim(String token, Function<Claims, T> claimsResolver) { //метод для извлечения конкретного вида данных из токена
        Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    //Extract all data from token
    private Claims extractAllClaims(String token) { //метод для извлечения ВСЕХ данных из токена
        return Jwts.parser()
                .setSigningKey(secretKey) //используем токен, подписанный секретным ключом(=подписью токена)
                .build()
                .parseClaimsJws(token)
                .getPayload();
    }

}
