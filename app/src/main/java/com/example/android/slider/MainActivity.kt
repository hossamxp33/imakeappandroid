package com.example.android.slider
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import com.example.android.slider.datalayer.usecases.SettingsUseCase
import com.example.android.slider.ui.splash.SplashUi
import kotlinx.android.synthetic.main.activity_main.*
import java.io.Serializable






class MainActivity : AppCompatActivity(),Serializable {

    var settings_data: List<SettingsUseCase>? = null
    lateinit var viewModel: UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       buttomNavigationView.setOnNavigationItemSelectedListener ( listener)
        buttomNavigationView.setSelectedItemId(R.id.nav_home)

        val intent: Intent? = getIntent()
        // val bundle:Bundle?=getIntent()?.extras
      //  settings_data = intent?.getSerializableExtra(SplashUi.SETTINGUSECASEkEY) as List<SettingsUseCase>
       // print(settings_data)

    }
    //add navigation button
    private val listener =
        BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
            var selectFragment: Fragment? = null
            when (menuItem.itemId) {
                R.id.nav_home -> selectFragment = HomeFragment()
                R.id.nav_buy -> selectFragment = BuyFragment()
                R.id.nav_more -> selectFragment = MoreFragment()
                R.id.nav_offers->selectFragment= OffersFragment()
            }
            assert(selectFragment != null)
            supportFragmentManager.beginTransaction().replace(
                R.id.fragment,
                selectFragment!!
            ).commit()
            true
        }
}