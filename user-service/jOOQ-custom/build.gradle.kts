val jooqVersion: String by rootProject.extra
plugins {
    kotlin("jvm")
}

group = "com.bugs.tokkaiiii"
version = "0.0.1"

repositories {
    mavenCentral()
}

dependencies {
    dependencies {
        implementation ("org.jooq:jooq-codegen:$jooqVersion")
        implementation("org.postgresql:postgresql:42.5.4")
    }
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}