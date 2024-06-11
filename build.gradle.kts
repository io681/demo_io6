import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
	application
	java
	id("checkstyle")
	id("org.springframework.boot") version "3.2.5"
	id("io.spring.dependency-management") version "1.1.4"
	id("io.freefair.lombok") version "8.6"
	jacoco
}

group = "ru.io6"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_21
}
application { mainClass.set("ru.io6.demo.DemoApplication") }

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-webflux")
	implementation("org.springframework.boot:spring-boot-devtools")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	runtimeOnly("com.h2database:h2:2.2.224")
	implementation("org.postgresql:postgresql:42.6.0")
	implementation("net.javacrumbs.json-unit:json-unit-assertj:3.2.2")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation(platform("org.junit:junit-bom:5.10.1"))
	testImplementation("org.junit.jupiter:junit-jupiter:5.10.1")
}
tasks.test {
	useJUnitPlatform()
	// https://technology.lastminute.com/junit5-kotlin-and-gradle-dsl/
	testLogging {
		exceptionFormat = TestExceptionFormat.FULL
		events = mutableSetOf(TestLogEvent.FAILED, TestLogEvent.PASSED, TestLogEvent.SKIPPED)
		// showStackTraces = true
		// showCauses = true
		showStandardStreams = true
	}

	finalizedBy(tasks.jacocoTestReport)
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.jacocoTestReport { reports { xml.required.set(true) } }
