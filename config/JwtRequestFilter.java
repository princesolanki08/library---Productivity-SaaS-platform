//package com.selfstudy.library.config;
//
//import com.selfstudy.library.utils.JwtUtil;
//import com.selfstudy.library.entities.User;
//import com.selfstudy.library.repositories.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//import io.jsonwebtoken.ExpiredJwtException;
//
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@Component
//public class JwtRequestFilter extends OncePerRequestFilter {
//
//    @Autowired
//    private JwtUtil jwtUtil;
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request,
//                                    HttpServletResponse response,
//                                    FilterChain chain) throws ServletException, IOException {
//        final String requestTokenHeader = request.getHeader("Authorization");
//
//        String username = null;
//        String jwtToken = null;
//
//        if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
//            jwtToken = requestTokenHeader.substring(7);
//            try {
//                username = jwtUtil.extractUsername(jwtToken);
//            } catch (ExpiredJwtException e) {
//                logger.warn("JWT Token has expired");
// 
//            } catch (Exception e) {
//                logger.error("Unable to parse JWT Token");
//            }
//        }
//
//        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//            User user = userRepository.findByUsername(username).orElse(null);
//
//            if (user != null && jwtUtil.validateToken(jwtToken, user.getUsername())) {
//                UsernamePasswordAuthenticationToken authentication =
////                        new UsernamePasswordAuthenticationToken(user, null, null);
//                		new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
//                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//
//                SecurityContextHolder.getContext().setAuthentication(authentication);
//            }
//        }
//        chain.doFilter(request, response);
//    }
//}      ye purana hai

package com.selfstudy.library.config;

import com.selfstudy.library.utils.JwtUtil;
import com.selfstudy.library.entities.User;
import com.selfstudy.library.repositories.UserRepository;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private UserRepository userRepository;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {

		final String requestTokenHeader = request.getHeader("Authorization");

		String username = null;
		String jwtToken = null;

		if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {

			jwtToken = requestTokenHeader.substring(7);

			try {
				username = jwtUtil.extractUsername(jwtToken);
			} catch (ExpiredJwtException e) {
				logger.warn("JWT Token has expired");
			} catch (Exception e) {
				logger.error("Unable to parse JWT Token");
			}
		}

		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

			User userEntity = userRepository.findByUsername(username).orElse(null);

			if (userEntity != null) {

				UserDetails userDetails = new org.springframework.security.core.userdetails.User(
						userEntity.getUsername(), userEntity.getPassword(), new ArrayList<>());

				if (jwtUtil.validateToken(jwtToken, userDetails.getUsername())) {

					UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
							userDetails, null, userDetails.getAuthorities());

					authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

					SecurityContextHolder.getContext().setAuthentication(authentication);
				}
			}
		}

		chain.doFilter(request, response);
	}
}
