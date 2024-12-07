package com.bugs.tokkaiiii.userservice.repository

import org.jooq.generated.tables.pojos.BugsUser

interface UserRepository {

    fun saveUser(user: BugsUser):Long?

    fun findById(id:Long):BugsUser?

    fun findByEmail(email: String): BugsUser?

}