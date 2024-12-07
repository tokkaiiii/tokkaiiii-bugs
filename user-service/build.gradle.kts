import org.jooq.meta.jaxb.ForcedType

//import org.jooq.meta.jaxb.*
val jooqVersion: String by extra("3.19.5")
plugins {
	kotlin("jvm") version "1.9.25"
	kotlin("plugin.spring") version "1.9.25"
	id("org.springframework.boot") version "3.4.0"
	id("io.spring.dependency-management") version "1.1.6"
	id("nu.studer.jooq") version "9.0"
}

group = "com.bugs.tokkaiiii"
version = "0.0.1"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}



dependencies {
	implementation("org.springframework.boot:spring-boot-starter-jooq")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.springframework.kafka:spring-kafka")
	compileOnly("org.projectlombok:lombok")
	runtimeOnly("org.postgresql:postgresql")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
	testImplementation("org.springframework.kafka:spring-kafka-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
	jooqGenerator(project(":jOOQ-custom"))
	jooqGenerator("org.jooq:jooq")
	jooqGenerator("org.jooq:jooq-meta")
}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}



sourceSets {
	main {
		kotlin {
			srcDirs(listOf("src/main/kotlin", "src/generated"))
		}
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

val dbUser: String = System.getProperty("db-user") ?: "bugs"
val dbPassword: String = System.getProperty("db-passwd") ?: "bugs"

jooq {
	configurations {
		create("tokkaiiii-bugs") {
			generateSchemaSourceOnCompilation.set(false)

			jooqConfiguration.apply {
				jdbc.apply {
					driver = "org.postgresql.Driver"
					url = "jdbc:postgresql://localhost:15432/tokkaiiii-bugs"
					user = dbUser
					password = dbPassword
				}
				generator.apply {
					name = "org.jooq.codegen.KotlinGenerator"
					database.apply {
						name = "org.jooq.meta.postgres.PostgresDatabase"
						inputSchema = "public"

						forcedTypes = listOf(
							ForcedType().apply {
								userType = "java.lang.Long"
								includeTypes = "bigint"
							},
							ForcedType().apply {
								userType = "java.lang.Integer"
								includeTypes = "integer"
							},
							ForcedType().apply {
								userType = "java.lang.Integer"
								includeTypes = "smallint"
							}
						)

					}

					generate.apply {
						isDaos = true
						isRecords = true
						isFluentSetters = true
						isJavaTimeTypes = true
						isDeprecated = false
					}
					target.apply {
						directory = "src/generated"
					}
					strategy.name = "com.bugs.tokkaiiii.jooq.custom.generator.JPrefixGeneratorStrategy"
				}
			}
		}
	}
}
