package com.pilot.calculateadmin.member

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.history.RevisionRepository

interface AdminMemberRepositoryImpl :
    AdminMemberRepository,
    JpaRepository<AdminMember, Long>,
    RevisionRepository<AdminMember, Long, Long> {
    override fun findByEmail(email: String): AdminMember?
}