package com.pilot.calculateadmin.common

import jakarta.persistence.EntityListeners
import jakarta.persistence.MappedSuperclass
import org.hibernate.envers.Audited
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
@Audited
abstract class BaseEntity {
    @CreatedDate
    val createdDateTime: LocalDateTime = LocalDateTime.now()
    @LastModifiedDate
    var updatedDateTime: LocalDateTime = LocalDateTime.now()
        protected set
}