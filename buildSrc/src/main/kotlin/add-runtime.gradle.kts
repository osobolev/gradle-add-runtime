plugins {
    id("lib")
}

configurations.testRuntimeClasspath {
    resolutionStrategy.dependencySubstitution {
        all(Action {
            val it = this
            val requested = it.requested
            if (requested is ProjectComponentSelector) {
                val refProject = findProject(requested.projectPath)!!
                if (refProject.plugins.findPlugin("api-lib") != null) {
                    it.useTarget(variant(requested) {
                        capabilities {
                            requireCapability("${refProject.group}:${refProject.name}-add-impl")
                        }
                    })
                }
            }
        })
    }
}
