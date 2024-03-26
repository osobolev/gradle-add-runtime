plugins {
    id("lib")
}

java {
    registerFeature("addImpl") {
        usingSourceSet(sourceSets["main"])
    }
}

dependencies {
    "addImplRuntimeOnly"(project(":${project.name}impl"))
}
