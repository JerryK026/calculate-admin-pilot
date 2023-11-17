package com.pilot.calculateadmin.auth

import com.pilot.calculateadmin.config.JwtService
import com.pilot.calculateadmin.member.AdminMember
import com.pilot.calculateadmin.member.AdminMemberRepository
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.lang.IllegalArgumentException

@Service
class AuthenticationService(
    val adminMemberRepository: AdminMemberRepository,
    val passwordEncoder: PasswordEncoder,
    val jwtService: JwtService,
    val authenticationManager: AuthenticationManager
) {

    fun register(adminMember: AdminMember): AuthenticationResponse {
        AdminMember(
            null,
            adminMember.email,
            passwordEncoder.encode(adminMember.memberPassword),
            adminMember.name,
            adminMember.phoneNumber,
            adminMember.role
        )
        adminMemberRepository.save(adminMember)
        val jwtToken = jwtService.generateToken(adminMember)
        return AuthenticationResponse(jwtToken)
    }

    fun authenticate(adminMember: AdminMember): AuthenticationResponse {
        authenticationManager.authenticate(
            UsernamePasswordAuthenticationToken(
                adminMember.email,
                adminMember.memberPassword
            )
        )
        val adminMember = adminMemberRepository.findByEmail(adminMember.email)
            ?: throw IllegalArgumentException("등록되지 않은 회원입니다. 요청한 이메일 : ${adminMember.email}")
        val jwtToken = jwtService.generateToken(adminMember)
        return AuthenticationResponse(jwtToken)
    }
}