package com.omit.security;

import com.omit.domain.Authority;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Component
public class JwtProvider {
    @Value("${jwt.secret.key}")
    private String salt;

    private Key secretKey;

    private final long exp = 1000L *60 *60;

    private final JpaUserDetailService userDetailService;

    @PostConstruct
    protected void init(){
        secretKey = Keys.hmacShaKeyFor(salt.getBytes(StandardCharsets.UTF_8));
    }

    //jwt 생성
    public String createToken(String account, List<Authority> roles){
        Claims claims= Jwts.claims().setSubject(account); //jwt payload에 저장되는 정보 명시
        claims.put("role",roles);
        Date now = new Date();

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime()+exp))
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact();
    }

    //권한 정보 추출
    //spring security 인증 과정에서 권한 확인을 위함
    public Authentication getAuthentication(String token){
        UserDetails userDetails=userDetailService.loadUserByUsername(this.getUserid(token));
        return  new UsernamePasswordAuthenticationToken(userDetails,"",userDetails.getAuthorities());
    }

    //토큰에 담겨있는 userid 추출
    public String getUserid(String token){
        return Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token).getBody().getSubject();
    }

    //Authorization Header를 통해 인증
    public String resolveToken(HttpServletRequest request){
        return request.getHeader("Authorization");
    }

    //토큰 검증
    public boolean validateToken(String token){
        try{
            //Bearer 검증
            if (!token.substring(0,"BEARER".length()).equalsIgnoreCase("BEARER")){
                return false;
            } else{
                token=token.split(" ")[1].trim();
            }
            Jws<Claims> claimsJWs = Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token);

            //만료되었다면 false
            return !claimsJWs.getBody().getExpiration().before(new Date());
        }catch(Exception e){
            return false;
        }
    }

}
