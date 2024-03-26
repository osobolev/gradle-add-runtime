plugins {
    id("lib")
}

sourceSets {
    create("api") {
        java.srcDir("api-src/main/java")
    }
}

java {
    registerFeature("addImpl") {
        usingSourceSet(sourceSets["api"])
    }
}

dependencies {
    "apiRuntimeOnly"(project(":${project.name}impl"))
}
