package com.pilot.calculateadmin.auth

import com.pilot.calculateadmin.member.AdminMember
import com.pilot.calculateadmin.member.Role

data class AuthenticationRequest(
    val email: String,
    val password: String,
    val name: String,
    val phoneNumber: String,
    val role: Role
) {
    fun toAdminMember(): AdminMember {
        return AdminMember(null, email, password, name, phoneNumber, role)
    }
}