package com.bugs.tokkaiiii.jooq.custom.generator

import org.jooq.codegen.DefaultGeneratorStrategy
import org.jooq.codegen.GeneratorStrategy
import org.jooq.codegen.GeneratorStrategy.Mode.DEFAULT
import org.jooq.meta.Definition

class JPrefixGeneratorStrategy : DefaultGeneratorStrategy() {
    override fun getJavaClassName(definition: Definition?, mode: GeneratorStrategy.Mode?): String {
        return when (mode) {
            DEFAULT -> "J" + super.getJavaClassName(definition, mode)
            else -> super.getJavaClassName(definition, mode)
        }
    }
}