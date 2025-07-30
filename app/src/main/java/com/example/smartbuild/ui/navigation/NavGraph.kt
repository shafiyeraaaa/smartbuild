package com.example.smartbuild.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.smartbuild.ui.screens.*
import com.example.smartbuild.viewmodel.ScheduleViewModel

@Composable
fun NavGraph(
    navController: NavHostController,
    viewModel: ScheduleViewModel
) {
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            HomeScreen(navController = navController)
        }
        composable("notifications") {
            NotificationScreen(navController = navController)
        }
        composable("schedule") {
            ScheduleScreen(navController = navController, viewModel = viewModel)
        }
        composable("add_task") {
            AddTaskScreen(navController = navController)
        }
        composable("inspection_screen") {
            InspectionScreen(onBackClick = { navController.popBackStack() })
        }
        composable("cost_screen") {
            CostScreen(onBackClick = { navController.popBackStack() })
        }
        composable("report_screen") {
            ReportScreen(onBackClick = { navController.popBackStack() })
        }
        composable("weather_screen") {
            WeatherScreen(onBackClick = { navController.popBackStack() })
        }
        composable("tracking_screen") {
            TrackingScreen(onBackClick = { navController.popBackStack() })
        }
        composable("productivity_screen") {
            ProductivityScreen(onBackClick = { navController.popBackStack() })
        }
        composable("safety_screen") {
            SafetyScreen(onBackClick = { navController.popBackStack() })
        }
        composable("calendar_screen") {
            ProjectCalendarScreen(navController)
        }
        composable("storage_screen") {
            StorageScreen(navController)
        }
        composable("camera_screen") {
            CameraScreen(navController)
        }
        composable("profile_screen") {
            ProfileScreen(navController)
        }
        composable("location_screen") {
            SearchScreen(navController)
        }
    }
}
