plugins {
    id("base-rest-api")
    id("io.ktor.plugin") version "2.3.10"
}

dependencies {
    implementation(project(":domain"))
    implementation("io.ktor:ktor-client-core")
    implementation("io.ktor:ktor-client-cio")
    implementation("io.ktor:ktor-client-content-negotiation")
    implementation("io.ktor:ktor-serialization-kotlinx-json")
}