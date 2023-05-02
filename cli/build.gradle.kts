plugins {
    kotlin("multiplatform")
}

kotlin {
    jvmToolchain(11)

    macosX64 {
        binaries {
            executable {
                baseName = "example_x64"
                entryPoint = "main"
            }
        }
    }
    macosArm64 {
        binaries {
            executable {
                baseName = "example"
                entryPoint = "main"
            }
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(":library"))

                /*
                 * | SNAPSHOT               | Status | Maven group defined in...       | gradle-maven-publish-plugin version |
                 * |------------------------|--------|---------------------------------|-------------------------------------|
                 * | 6.4.1-3c7da21-SNAPSHOT | Broken | `gradle.properties` via `GROUP` | 0.25.2                              |
                 * | 6.4.1-f1d2a0d-SNAPSHOT | Works  | `build.gradle.kts` via `group`  | 0.25.2                              |
                 * | 6.4.1-51793c4-SNAPSHOT | Works  | `gradle.properties` via `GROUP` | 0.22.0                              |
                 */
                implementation("com.juul.tuulbox:encoding:6.4.1-f1d2a0d-SNAPSHOT") // Broken
//                implementation("com.juul.tuulbox:encoding:6.4.1-3c7da21-SNAPSHOT") // Working
//                implementation("com.juul.tuulbox:encoding:6.4.1-51793c4-SNAPSHOT") // Working
            }
        }
    }
}
