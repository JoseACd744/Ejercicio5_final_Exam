package com.isa.platform.upc.Ejercicio5.shared.util;

import com.isa.platform.upc.Ejercicio5.users.model.entity.Role;
import com.isa.platform.upc.Ejercicio5.users.model.enums.ERole;
import com.isa.platform.upc.Ejercicio5.users.repository.IRoleRepository;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.util.StringUtils;

import javax.crypto.SecretKey;
import java.util.Collection;
import java.util.List;
/**
 * The Utilities class provides utility methods for user security and authentication.
 *
 * @version 1.0
 * @author Jose Arenas Conde
 * @since 30/11/2023
 * @see com.isa.platform.upc.Ejercicio5.users.model.entity.Role
 * @see com.isa.platform.upc.Ejercicio5.users.model.enums.ERole
 * @see com.isa.platform.upc.Ejercicio5.users.repository.IRoleRepository
 * @see io.jsonwebtoken.io.Decoders
 * @see io.jsonwebtoken.security.Keys
 * @see jakarta.servlet.http.HttpServletRequest
 * @see org.springframework.security.core.GrantedAuthority
 * @see org.springframework.security.core.authority.SimpleGrantedAuthority
 * @see org.springframework.security.core.userdetails.User
 * @see org.springframework.util.StringUtils
 */
@Slf4j
public class Utilities {
    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String BEARER_PREFIX = "Bearer ";

    /**
     * This method is used to get the JWT token from the Authorization header of the HTTP request.
     *
     * @param request The HTTP request.
     * @return The JWT token, or null if the Authorization header does not contain a JWT token.
     */
    static public String getJwtTokenFromRequest(HttpServletRequest request) {
        String jwtTokenFromHeader = request.getHeader(AUTHORIZATION_HEADER);

        if (StringUtils.hasText(jwtTokenFromHeader) && jwtTokenFromHeader.startsWith(BEARER_PREFIX)) {
            return jwtTokenFromHeader.substring(BEARER_PREFIX.length());
        }

        return null;
    }

    /**
     * This method is used to map roles to a list of GrantedAuthority.
     *
     * @param roles The roles to map.
     * @return A list of GrantedAuthority.
     */
    static public List<SimpleGrantedAuthority> mapRoles(Collection<Role> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName().name()))
                .toList();
    }

    /**
     * This method is used to get the roles of the authenticated user.
     *
     * @param authenticatedUser The authenticated user.
     * @return A list of roles.
     */
    static public List<String> getRoles(User authenticatedUser) {
        return authenticatedUser.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .toList();
    }

    /**
     * This method is used to generate a secret HMAC key from the secret that will be used to sign and verify tokens.
     *
     * @param secret The secret.
     * @return The secret HMAC key.
     */
    static public SecretKey getKey(String secret) {
        byte[] secretBytes = Decoders.BASE64URL.decode(secret);
        return Keys.hmacShaKeyFor(secretBytes);
    }

    /**
     * This method is used to insert a role if it does not exist.
     *
     * @param repository The role repository.
     * @param roleName The name of the role.
     */
    static public void insertRoleIfNotFound(IRoleRepository repository, ERole roleName) {
        if (!repository.existsByName(roleName)) {
            var newRole = new Role();
            newRole.setName(roleName);

            repository.save(newRole);
            log.info("Role {} inserted", roleName);
        }
    }
}