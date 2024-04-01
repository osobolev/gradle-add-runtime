plugins {
    id("lib")
}

sourceSets {
    create("myApi") {
        java.srcDir("api-src/main/java")
    }
    create("myImpl") {
        java.srcDir("impl-src/main/java")
    }
}

java {
    registerFeature("myApi") {
        usingSourceSet(sourceSets["myApi"])
    }
    registerFeature("myImpl") {
        usingSourceSet(sourceSets["myImpl"])
    }
}

dependencies {
    "myImplApi"(project(project.path)) {
        capabilities {
            requireCapability("${project.group}:${project.name}-my-api")
        }
    }
}
