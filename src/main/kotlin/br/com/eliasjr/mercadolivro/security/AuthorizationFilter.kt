package br.com.eliasjr.mercadolivro.security

import br.com.eliasjr.mercadolivro.exception.AuthenticationException
import br.com.eliasjr.mercadolivro.service.UserDetailsCustomerService
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class AuthorizationFilter(
    authenticationManager: AuthenticationManager,
    private val userDetails: UserDetailsCustomerService,
    private val jwtUtil: JwtUtil
) : BasicAuthenticationFilter(authenticationManager) {

    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, chain: FilterChain) {
        val authorization = request.getHeader("Authorization")
        if (authorization != null && authorization.startsWith("Bearer ")) {
            SecurityContextHolder.getContext().authentication = getAuthentication(authorization.split(" ")[1])
        }
        chain.doFilter(request, response)
    }

    private fun getAuthentication(token: String): UsernamePasswordAuthenticationToken {
        if (!jwtUtil.isValidToken(token)) {
            throw AuthenticationException("Token inválido", "999")
        }

        val subject = jwtUtil.getSubject(token)
        val customer = userDetails.loadUserByUsername(subject)
        return UsernamePasswordAuthenticationToken(subject, null, customer.authorities)
    }


}