plugins {
    `lib`
}

dependencies {
    implementation(project(":sub2"))

    testImplementation("junit:junit:4.13.2")
} 

tasks.test {
    testLogging.showStandardStreams = true
}

tasks.register("runMain", JavaExec::class) {
    mainClass.set("Main")
    classpath(sourceSets["main"].runtimeClasspath)
}
