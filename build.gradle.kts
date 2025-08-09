import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.9.0"
    `java-library`
    `maven-publish`
}

group = "com.parceladolara"
version = "v3.1.8"

repositories {
    mavenCentral()
}

// Include the generated uniffi bindings in the source set
kotlin {
    sourceSets {
        main {
            kotlin.srcDirs("src/main/kotlin")
        }
    }
}

dependencies {
    implementation("net.java.dev.jna:jna:5.13.0")

    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.0")
}

tasks.test {
    useJUnitPlatform()
    // Skip tests by default since they require the native library
    onlyIf { project.hasProperty("runTests") }

    // The NativeLibraryLoader will handle loading libraries from JAR resources or fallback paths

    // Show test output
    testLogging {
        events("passed", "skipped", "failed", "standardOut", "standardError")
        exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
        showStandardStreams = false
    }

    doFirst {
        println("Running tests using embedded native libraries via NativeLibraryLoader.")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

kotlin {
    jvmToolchain(17)
}

// Task to generate or check uniffi bindings
tasks.register("generateUniffiBindings") {
    description = "Check uniffi bindings for Kotlin"

    doLast {
        val bindingsFile = file("src/main/kotlin/com/parceladolara/paymentplan/internal/payment_plan_uniffi.kt")
        if (!bindingsFile.exists()) {
            throw GradleException(
                "UniFFI bindings not found.\n" +
                "This repository is a standalone copy from the main Payment Plan project:\n" +
                "https://github.com/ParceladoLara/payment-plan\n" +
                "For building from source and generating bindings, please refer to the main repository."
            )
        }
        println("✅ UniFFI bindings found and ready.")
    }
}

tasks.named("compileKotlin") {
    dependsOn("generateUniffiBindings")
}


publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])

            artifactId = "payment-plan-kotlin-sdk"

            pom {
                name.set("Payment Plan Kotlin SDK")
                description.set("Kotlin SDK for payment plan calculations")
                url.set("https://github.com/ParceladoLara/payment-plan-kotlin-sdk")

                developers {
                    developer {
                        id.set("parceladolara")
                        name.set("Parcelado Lara")
                        email.set("it-group@lara.app.br")
                    }
                }
            }
        }
    }
}
