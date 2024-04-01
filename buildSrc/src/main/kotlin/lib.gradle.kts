plugins {
    `java-library`
}

group = "test"
version = "1.0"

repositories {
    mavenCentral()
}

fun shouldAddImpl(projectPath: String, conf: String): Boolean {
    return projectPath == ":main" && conf == "testRuntimeClasspath";
}

configurations.all {
    val conf = this
    resolutionStrategy.dependencySubstitution {
        all {
            val it = this
            val requested = this.requested
            if (requested is ProjectComponentSelector && requested.requestedCapabilities.isEmpty()) {
                val refProject = findProject(requested.projectPath)!!
                if (refProject.plugins.findPlugin("api-lib") != null) {
                    val variantName = if (shouldAddImpl(project.path, conf.name)) "my-impl" else "my-api"
                    it.useTarget(variant(requested) {
                        capabilities {
                            requireCapability("${refProject.group}:${refProject.name}-${variantName}")
                        }
                    })
                }
            }
        }
    }
}
