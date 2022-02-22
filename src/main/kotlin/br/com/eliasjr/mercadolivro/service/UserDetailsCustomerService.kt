package br.com.eliasjr.mercadolivro.service

import br.com.eliasjr.mercadolivro.exception.AuthenticationException
import br.com.eliasjr.mercadolivro.repository.CustomerRepository
import br.com.eliasjr.mercadolivro.security.UserCustomerDetails
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserDetailsCustomerService(
    private val customerRepository: CustomerRepository
) : UserDetailsService {

    override fun loadUserByUsername(id: String): UserDetails {
        val customer = customerRepository.findById(id.toInt())
            .orElseThrow { AuthenticationException("Usuario nao encontrado", "999") }
        return UserCustomerDetails(customer)
    }
}