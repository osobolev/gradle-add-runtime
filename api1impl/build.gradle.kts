plugins {
    `lib`
}

dependencies {
    api(project(":api1"))
    implementation("org.postgresql:postgresql:42.2.9")
}
