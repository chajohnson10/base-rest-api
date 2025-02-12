plugins {
    `kotlin-dsl`
}


repositories {
    gradlePluginPortal()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-gradle-plugin:3.2.4")
    implementation("io.spring.gradle:dependency-management-plugin:1.1.4")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.23")
    implementation("org.jetbrains.kotlin:kotlin-allopen:1.9.23")
    implementation("org.jetbrains.kotlin:kotlin-serialization:1.9.23")
    implementation("org.jlleitschuh.gradle:ktlint-gradle:11.3.1")
}