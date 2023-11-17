package com.pilot.calculateadmin.member

import com.pilot.calculateadmin.common.BaseEntity
import jakarta.persistence.*
import org.hibernate.envers.Audited
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

@Entity
@Audited
class AdminMember(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var email: String,
    var memberPassword: String,
    var name: String,
    var phoneNumber: String,
    @Enumerated(EnumType.STRING)
    var role: Role
) : BaseEntity(), UserDetails {
    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return mutableListOf(SimpleGrantedAuthority(role.name))
    }

    override fun getPassword(): String {
        return memberPassword
    }

    override fun getUsername(): String {
        return email
    }

    // TODO: 공부
    override fun isAccountNonExpired(): Boolean {
        return true
    }

    // TODO: 공부
    override fun isAccountNonLocked(): Boolean {
        return true
    }

    // TODO: 공부
    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    // TODO: 공부
    override fun isEnabled(): Boolean {
        return true
    }

}