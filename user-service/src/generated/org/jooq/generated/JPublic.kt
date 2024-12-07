/*
 * This file is generated by jOOQ.
 */
package org.jooq.generated


import kotlin.collections.List

import org.jooq.Catalog
import org.jooq.Table
import org.jooq.generated.tables.JBugsUser
import org.jooq.impl.SchemaImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class JPublic : SchemaImpl("public", DefaultCatalog.DEFAULT_CATALOG) {
    public companion object {

        /**
         * The reference instance of <code>public</code>
         */
        val PUBLIC: JPublic = JPublic()
    }

    /**
     * The table <code>public.bugs_user</code>.
     */
    val BUGS_USER: JBugsUser get() = JBugsUser.BUGS_USER

    override fun getCatalog(): Catalog = DefaultCatalog.DEFAULT_CATALOG

    override fun getTables(): List<Table<*>> = listOf(
        JBugsUser.BUGS_USER
    )
}
