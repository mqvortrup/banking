repositories {
    mavenCentral()
}

version = "0.0.1"
group = "qm.banking"

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.6.2")
    "implementation"(project(":domain"))
}

plugins {
    kotlin("jvm")
    idea
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}
