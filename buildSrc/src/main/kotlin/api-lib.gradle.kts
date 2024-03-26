plugins {
    id("lib")
}

java {
    registerFeature("addImpl") {
        usingSourceSet(sourceSets["main"])
    }
}

dependencies {
    "addImplRuntimeElements"(project(":${project.name}impl"))
}
