plugins {
    id("base-rest-api")
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":database"))
    implementation(project(":rest-clients"))
}
