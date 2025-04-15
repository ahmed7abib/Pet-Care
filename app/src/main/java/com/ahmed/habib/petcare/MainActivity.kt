package com.ahmed.habib.petcare

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ahmed.habib.petcare.features.dashboard.DashboardScreen
import com.ahmed.habib.petcare.features.getStarted.GetStartedScreen
import com.ahmed.habib.petcare.features.register.RegisterScreen
import com.ahmed.habib.petcare.features.splash.SplashScreen
import com.ahmed.habib.petcare.features.verifyCode.VerifyCodeScreen
import com.ahmed.habib.petcare.ui.theme.PetCareTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent { PetCareTheme { MainApp() } }
    }
}

@Composable
fun MainApp() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(startDestination) {
            SplashScreen {
                navController.navigate(getStartedDestination)
            }
        }

        composable(getStartedDestination) {
            GetStartedScreen(
                onGetStartedClick = { navController.navigate(registerDestination) },
                onSignUpLaterClick = { navController.navigate(dashboardDestination) }
            )
        }

        composable(registerDestination) { RegisterScreen { navController.navigate(verifyDestination) } }

        composable(verifyDestination) {
            VerifyCodeScreen {
                navController.navigate(
                    dashboardDestination
                )
            }
        }

        composable(dashboardDestination) { DashboardScreen() }
    }
}

const val startDestination = "SPLASH_SCREEN"
const val getStartedDestination = "GET_STARTED_SCREEN_DESTINATION"
const val registerDestination = "REGISTER_SCREEN_DESTINATION"
const val verifyDestination = "VERIFY_SCREEN_DESTINATION"
const val dashboardDestination = "DASHBOARD_SCREEN_DESTINATION"