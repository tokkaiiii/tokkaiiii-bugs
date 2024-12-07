package com.bugs.tokkaiiii.userservice.repository

import org.jooq.Configuration
import org.jooq.DSLContext
import org.jooq.generated.tables.JBugsUser
import org.jooq.generated.tables.daos.BugsUserDao
import org.jooq.generated.tables.pojos.BugsUser
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryImpl(
    private val dslContext: DSLContext,
    configuration: Configuration
) : UserRepository {
    private val BUGS_USER: JBugsUser = JBugsUser.BUGS_USER
    private val bugsUserDao = BugsUserDao(configuration)

    override fun saveUser(user: BugsUser):Long? {
        return dslContext.insertInto(
            BUGS_USER,
            BUGS_USER.EMAIL,
            BUGS_USER.USERNAME,
            BUGS_USER.PASSWORD,
            BUGS_USER.CREATED_AT,
            BUGS_USER.UPDATED_AT
        ).values(user.email, user.username, user.password, user.createdAt,user.updatedAt)
            .returningResult(BUGS_USER.ID).fetchOneInto(Long::class.java)
    }
}