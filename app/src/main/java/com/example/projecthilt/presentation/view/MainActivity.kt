package com.example.projecthilt.presentation.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.projecthilt.R
import com.example.projecthilt.databinding.ActivityMainBinding
import com.example.projecthilt.presentation.viewmodel.UsersViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val usersViewModel: UsersViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)



        usersViewModel.users.observe(this) {
            var listResult = ""
            it.forEach {
                var firstName = it.firstName
                var lastName = it.lastName
                var age = it.age
                listResult += "+ $firstName - $lastName - $age \n"
            }
            binding.textView.text = listResult
        }


    }
}