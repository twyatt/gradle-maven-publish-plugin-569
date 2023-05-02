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
                implementation("com.juul.tuulbox:encoding:6.4.1-f1d2a0d-SNAPSHOT") // Broken
//                implementation("com.juul.tuulbox:encoding:6.4.1-3c7da21-SNAPSHOT") // Working
            }
        }
    }
}
