import org.gradle.api.publish.maven.MavenPublication
import org.gradle.kotlin.dsl.`maven-publish`
import org.gradle.kotlin.dsl.signing
import java.util.*

plugins {
    `maven-publish`
    signing
}

// Stub secrets to let the project sync and build without the publication values set up
ext["signKeyId"] = null
ext["signPassword"] = null
ext["signSecretKey"] = null
ext["ossrhUsername"] = null
ext["ossrhPassword"] = null

// Grabbing secrets from local.properties file or from environment variables, which could be used on CI
val secretPropsFile = project.rootProject.file("local.properties")
if (secretPropsFile.exists()) {
    secretPropsFile.reader().use {
        Properties().apply {
            load(it)
        }
    }.onEach { (name, value) ->
        ext[name.toString()] = value
    }
} else {
    ext["signKeyId"] = System.getenv("SIGN_KEY_ID")
    ext["signPassword"] = System.getenv("SIGN_PASSWORD")
    ext["signSecretKey"] = System.getenv("SIGN_SECRET_KEY")
    ext["ossrhUsername"] = System.getenv("OSSRH_USERNAME")
    ext["ossrhPassword"] = System.getenv("OSSRH_PASSWORD")
}

//val javadocJar by tasks.registering(Jar::class) {
//    archiveClassifier.set("javadoc")
//}

fun getExtraString(name: String) = ext[name]?.toString()

publishing {
    // Configure maven central repository
    repositories {
        maven {
            name = "sonatype"
            setUrl("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/")
            credentials {
                username = getExtraString("ossrhUsername")
                password = getExtraString("ossrhPassword")
            }
        }
    }

    // Configure all publications
    publications.withType<MavenPublication> {
        // Stub javadoc.jar artifact
//        artifact(javadocJar.get())

        // Provide artifacts information requited by Maven Central
        pom {
            name.set("Hog")
            description.set("A simple log library for KMM")
            url.set("https://github.com/K-Huntun/Hog")

            licenses {
                license {
                    name.set("MIT")
                    url.set("https://opensource.org/licenses/MIT")
                }
            }
            developers {
                developer {
                    id.set("https://github.com/heiha100")
                    name.set("heiha")
                    email.set("01sr@outlook.com")
                }
            }
            scm {
                url.set("https://github.com/K-Huntun/Hog")
            }
        }
    }
}

// Signing artifacts. Signing.* extra properties values will be used
signing {
    useInMemoryPgpKeys(getExtraString("signKeyId"), getExtraString("signSecretKey"), getExtraString("signPassword"))
    sign(publishing.publications)
}