package io.wookoo.flyticketssearch

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import io.wookoo.flyticketssearch.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)

//        val appBarConfiguration = AppBarConfiguration(
//            setOf(
//                R.id.navigation_fly,
//                R.id.navigation_hotels,
//                R.id.navigation_short,
//                R.id.navigation_notifications,
//                R.id.navigation_profile
//            )
//        )

        navView.setupWithNavController(navController)
    }
}
