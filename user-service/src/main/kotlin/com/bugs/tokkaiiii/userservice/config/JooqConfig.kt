package com.bugs.tokkaiiii.userservice.config

import org.jooq.conf.ExecuteWithoutWhere.THROW
import org.springframework.boot.autoconfigure.jooq.DefaultConfigurationCustomizer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class JooqConfig {
    @Bean
    fun jooqDefaultConfigurationCustomizer(): DefaultConfigurationCustomizer =
        DefaultConfigurationCustomizer { customizer ->
            customizer.settings()
                .withExecuteDeleteWithoutWhere(THROW)
                .withExecuteUpdateWithoutWhere(THROW)
                .withRenderSchema(false)}
}