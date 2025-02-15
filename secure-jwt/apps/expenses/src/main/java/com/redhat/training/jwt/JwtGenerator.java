package com.redhat.training.jwt;

import java.util.Arrays;
import java.util.HashSet;

import io.smallrye.jwt.build.Jwt;

public class JwtGenerator {

    private static final String ISSUER = "https://example.com/redhattraining";

    public static String generateJwtForRegularUser( String username ) {
        return Jwt.issuer( ISSUER )
                .upn( username + "@example.com" )
                .subject(username)
                .audience("expenses.example.com")
                .claim("locale", "en_US")
                .groups(new HashSet<>(Arrays.asList("USER")))
                .sign();
    }

    public static String generateJwtForAdmin( String username ) {
        return Jwt.issuer( ISSUER )
                .upn( username + "@example.com" )
                .subject( username )
                .claim( "locale", "en_US" )
                .groups(new HashSet<>(Arrays.asList("USER","ADMIN")))
                .sign();
    }
}
