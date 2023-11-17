package com.pilot.calculateadmin.auth

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class AuthenticationController(
    val authenticationService: AuthenticationService
) {

    @PostMapping("/api/v1/auth/register")
    fun join(@RequestBody request: AuthenticationRequest): ResponseEntity<AuthenticationResponse> {
        return ResponseEntity.ok(authenticationService.register(request.toAdminMember()))
    }

    @PostMapping("/api/v1/auth/authenticate")
    fun authentication(@RequestBody request: AuthenticationRequest): ResponseEntity<AuthenticationResponse> {
        return ResponseEntity.ok(authenticationService.authenticate(request.toAdminMember()))
    }
}