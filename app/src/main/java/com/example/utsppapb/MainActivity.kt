//package com.example.prakmobileuts
//
//import android.content.Intent
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.util.Log
//import android.view.View
//import android.widget.AdapterView
//import android.widget.ArrayAdapter
//import com.example.prakmobileuts.databinding.ActivityCheckoutavengerBinding
//
//
//class Checkoutavenger : AppCompatActivity() {
//    private lateinit var binding: ActivityCheckoutavengerBinding
//    private var selectedBioskop: String = " "
//    private var selectedJenisseat: String = " "
//    private var selectedJenispembayaran: String = " "
//    private var selectedBank: String = " "
//    val hargakursi = mapOf(
//        "Regular" to 35000,
//        "Executive" to 50000,
//        "Couple" to 50000,
//        "Premiere" to 100000,
//        "Suite" to 500000
//    )
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityCheckoutavengerBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        val bioskop = resources.getStringArray(R.array.bioskop)
//        val jenisseat = resources.getStringArray(R.array.jenisseat)
//        val jenispembayaran = resources.getStringArray(R.array.jenispembayaran)
//        val bank = resources.getStringArray(R.array.bank)
//        val gambar = intent.getIntExtra(Detailsavenger.gambarkur, 0)
//
//        with(binding) {
//            val ambiljudul = intent.getStringExtra(Detailsavenger.judulkur)
//            judul.text = ambiljudul
//
//            val ambilgenre = intent.getStringExtra(Detailsavenger.genrekur)
//            genre.text = ambilgenre
//
//            val adapterBioskop =
//                ArrayAdapter(this@Checkoutavenger, android.R.layout.simple_spinner_item, bioskop)
//            spinnerbioskop.adapter = adapterBioskop
//
//            val adapterJenisseat =
//                ArrayAdapter(this@Checkoutavenger, android.R.layout.simple_spinner_item, jenisseat)
//            spinnerseat.adapter = adapterJenisseat
//
//            val adapterJenispembayaran = ArrayAdapter(
//                this@Checkoutavenger, android.R.layout.simple_spinner_item, jenispembayaran
//            )
//            spinnerpembayaran.adapter = adapterJenispembayaran
//
//            val adapterBank =
//                ArrayAdapter(this@Checkoutavenger, android.R.layout.simple_spinner_item, bank)
//            spinnerbank.adapter = adapterBank
//
//            val tanggal = binding.tanggal
//
//            spinnerbioskop.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
//                override fun onItemSelected(
//                    parent: AdapterView<*>,
//                    view: View?,
//                    position: Int,
//                    id: Long
//                ) {
//                    selectedBioskop = bioskop[position]
//                    Log.d("SelectedBioskop", selectedBioskop)
//                }
//
//                override fun onNothingSelected(parent: AdapterView<*>) {
//
//                }
//            }
//
//            spinnerseat.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
//                override fun onItemSelected(
//                    parent: AdapterView<*>,
//                    view: View?,
//                    position: Int,
//                    id: Long
//                ) {
//                    selectedJenisseat = jenisseat[position]
//                    val selectedPrice = hargakursi[selectedJenisseat]
//                    if (selectedPrice != null) {
//                        jenistempat.text = selectedJenisseat
//                        hargaseat.text = "Rp" + selectedPrice.toString()
//                        val fee = 4000
//                        val ppn = (selectedPrice * 10 / 100)
//                        hargapenanganan.text = "Rp"+fee.toString()
//                        hargappn.text = "Rp"+ppn.toString()
//                        val sum = fee + selectedPrice + ppn
//                        hargatotal.text = "Rp"+sum.toString()
//                    }
//                    Log.d("SelectedJenisseat", selectedJenisseat)
//                }
//
//                override fun onNothingSelected(parent: AdapterView<*>) {
//
//                }
//            }
//
//            spinnerpembayaran.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
//                override fun onItemSelected(
//                    parent: AdapterView<*>,
//                    view: View?,
//                    position: Int,
//                    id: Long
//                ) {
//                    selectedJenispembayaran = jenispembayaran[position]
//                    if (selectedJenispembayaran == "Bank") {
//                        spinnerbank.visibility = View.VISIBLE
//                        nomorkartu.visibility = View.VISIBLE
//                    } else {
//                        spinnerbank.visibility = View.GONE
//                        nomorkartu.visibility = View.GONE
//                    }
//                    Log.d("SelectedJenispembayaran", selectedJenispembayaran)
//                }
//
//                override fun onNothingSelected(parent: AdapterView<*>) {
//
//                }
//            }
//
//            spinnerbank.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
//                override fun onItemSelected(
//                    parent: AdapterView<*>,
//                    view: View?,
//                    position: Int,
//                    id: Long
//                ) {
//                    selectedBank = bank[position]
//                    Log.d("SelectedBank", selectedBank)
//                }
//
//                override fun onNothingSelected(parent: AdapterView<*>) {
//
//                }
//            }
//
//
//            val bayar = binding.bayar
//            val datePicker = binding.tanggal
//
//
//            backbutton.setOnClickListener {
//                val intent = Intent(this@Checkoutavenger, Dashboard::class.java)
//                startActivity(intent)
//            }
//
//            bayar.setOnClickListener {
//                val intent = Intent(this@Checkoutavenger, Receipt::class.java)
//                val judulFilm = binding.judul.text.toString()
//                val genreFilm = binding.genre.text.toString()
//                val selectedBioskop = bioskop[spinnerbioskop.selectedItemPosition]
//                val selectedJenisseat = jenisseat[spinnerseat.selectedItemPosition]
//                val selectedHarga = hargakursi[selectedJenisseat]
//                val selectedJenispembayaran = jenispembayaran[spinnerpembayaran.selectedItemPosition]
//                val selectedBank = bank[spinnerbank.selectedItemPosition]
//                val sumfee = 4000 + (selectedHarga!! *10/100)
//
//                val day = datePicker.dayOfMonth
//                val month = datePicker.month + 1
//                val year = datePicker.year
//                val date = String.format("%02d/%02d/%04d", day, month, year)
//
//                intent.putExtra("JUDUL_EXTRA", judulFilm)
//                intent.putExtra("GENRE_EXTRA", genreFilm)
//                intent.putExtra("BIOSKOP_EXTRA", selectedBioskop)
//                intent.putExtra("JENISSEAT_EXTRA", selectedJenisseat)
//                intent.putExtra("JENISPEMBAYARAN_EXTRA", selectedJenispembayaran)
//                intent.putExtra("BANK_EXTRA", selectedBank)
//                intent.putExtra("TANGGAL_EXTRA", date)
//                intent.putExtra("HARGA_EXTRA", selectedHarga)
//                intent.putExtra("FEE_EXTRA", sumfee)
//                intent.putExtra("GAMBAR_EXTRA", gambar)
//
//                startActivity(intent)
//
//
//            }
//        }
//    }
//}