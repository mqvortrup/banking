repositories {
    mavenCentral()
}

version = "0.0.1"
group = "qm.banking"

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.apache.ignite:ignite-core:2.7.6")
    testImplementation("org.junit.jupiter:junit-jupiter:5.6.2")
    "implementation"(project(":domain"))
    "implementation"(project(":singlepayments"))
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
