package com.pilot.calculateadmin.member

interface AdminMemberRepository {
    fun findByEmail(email: String) : AdminMember?
    fun save(adminMember: AdminMember) : AdminMember
}