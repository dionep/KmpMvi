plugins {
    kotlin("plugin.serialization")
}

setupMultiplatform()
setupKittensBinaries()

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                api(project(":shared:mvi"))
                implementation(Deps.Badoo.Reaktive.Utils)
                implementation(Deps.Badoo.Reaktive.Reaktive)
                implementation(Deps.Jetbrains.Kotlinx.Serialization.RuntimeCommon)
            }
        }

        commonTest {
            dependencies {
                implementation(Deps.Badoo.Reaktive.ReaktiveTesting)
            }
        }

        androidMain {
            dependencies {
                implementation(Deps.Jetbrains.Kotlinx.Serialization.Runtime)
            }
        }

        iosCommonMain {
            dependencies {
                implementation(Deps.Jetbrains.Kotlinx.Serialization.RuntimeNative)
            }
        }
    }
}
