package com.bugs.tokkaiiii.userservice.service

import org.jooq.generated.tables.pojos.BugsUser

interface UserService {

    fun saveUser(user: BugsUser): Long?

}