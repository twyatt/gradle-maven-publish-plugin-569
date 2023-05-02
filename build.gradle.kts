buildscript {
    repositories {
        mavenCentral()
    }
}

plugins {
    kotlin("multiplatform") version "1.8.20" apply false
}

allprojects {
    repositories {
        mavenLocal()
        mavenCentral()
        maven("https://oss.sonatype.org/content/repositories/snapshots")
    }
}
