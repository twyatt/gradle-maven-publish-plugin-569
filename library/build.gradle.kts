plugins {
    kotlin("multiplatform")
}

kotlin {
    macosX64()
    macosArm64()

    sourceSets {
        val commonMain by getting {
            dependencies {
                api("com.juul.tuulbox:encoding:6.4.0")
            }
        }
    }
}
