plugins {
    id("base-rest-api")
    kotlin("plugin.jpa") version "1.9.23"
}

dependencies {
    implementation(project(":domain"))
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    runtimeOnly("org.postgresql:postgresql")
}