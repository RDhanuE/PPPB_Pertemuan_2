package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

/*
    Important!
    tambahkan buildFeatures{viewBinding = true} pada build.gradle.kts (Module:app) terlebih dahulu
    agar dapat menggunakan binding, kemudian sync ulang gradle. Proses ini membutuhkan jaringan
    internet.

    Menginisialisasi binding agar dapat memanggil fungsi inflate.
*/
    private lateinit var binding: ActivityMainBinding
    private var number = 0
/*
    Cara lain mengambil komponen dari activity_main adalah dengan menggunakan findViewById

    R merupakan package res(ources). id merupakan komponen id dari komponen yang dicari, dimana id
    ini diisi melalui android:id
    val count = findViewById<TextView>(R.id.count)
*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

/*
    line dibawah ini berfungsi untuk meng "inflate" activity_main. Yang dimaksud dari inflate adalah
    mengubah bentuk activity_main dari XML menjadi object binding yang dapat diakses dengan mudah.
    layoutInflater adalah sistem yang bertugas merubah layout XML menjadi object binding
    setContentView(binding.root) berfungsi menetapkan tampilan yang digunakan, dimana binding.root
    akan mengambil dari object binding milik main_activity
*/

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

/*
    logic dari button dan tampilan count. with(binding) digunakan untuk meringkas code block di
    dalamnya.
*/

        with(binding){
            buttonCount.setOnClickListener{
                number++
                count.text = number.toString()
            }

/*
            logic dari button toast untuk menampilkan tinggi, berat, serta angka sekarang
            Penambahan logic untuk menghitung berat badan (pada pria) apakah ideal atau tidak

 */
            buttonToast.setOnClickListener{
                var tinggi = Integer.parseInt(inputTinggi.text.toString())
                var berat = Integer.parseInt(inputBerat.text.toString())

                Toast.makeText(this@MainActivity, "Berat anda : ${inputBerat.text} kg\n" +
                        "Tinggi anda : ${inputTinggi.text} cm",
                    Toast.LENGTH_SHORT
                ).show()

                if(berat <=  (tinggi - 100) - (tinggi - 100) * 0.1){
                    Toast.makeText(this@MainActivity,"Berat badan anda ideal", Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(this@MainActivity,"Berat badan anda tidak ideal", Toast.LENGTH_SHORT
                    ).show()
                }

                Toast.makeText(this@MainActivity, "Angka anda sekarang : $number",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}