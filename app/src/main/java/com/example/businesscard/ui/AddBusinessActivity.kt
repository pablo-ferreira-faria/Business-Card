package com.example.businesscard.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.businesscard.R
import com.example.businesscard.app
import com.example.businesscard.data.businessCard
import com.example.businesscard.databinding.ActivityAddBusinessBinding

class  AddBusinessActivity : AppCompatActivity() {

    private val binding by lazy{ ActivityAddBusinessBinding.inflate(layoutInflater)}

    private val mainViewModel: MainViewModel by viewModels{
        MainViewModelFactory((application as app).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        insertListener()
    }
    private fun insertListener(){
        binding.btnClose.setOnClickListener{
          finish()
        }
        binding.btnConfirm.setOnClickListener{
            val businessCard = businessCard(
                nome = binding.tilNome.editText?.text.toString(),
                empresa = binding.tilEmpresa.editText?.text.toString(),
                telefone = binding.tilTelefone.editText?.text.toString(),
                email = binding.tilEmail.editText?.text.toString(),
                fundoPersonalizado = binding.tilCor.editText?.text.toString()
            )
            mainViewModel.insert(businessCard)
            Toast.makeText(this, R.string.label_show_success, Toast.LENGTH_SHORT).show()
            finish()

        }

    }

}