package com.example.utsppapb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.DatePicker
import android.widget.Spinner
import android.widget.TimePicker
import android.widget.TextView
import androidx.core.view.get
import com.example.utsppapb.HomePageActivity.Companion.EXTRA_IMG
import com.example.utsppapb.HomePageActivity.Companion.EXTRA_TITLE
import com.example.utsppapb.LoginPageActivity.Companion.EXTRA_NAME
import com.example.utsppapb.databinding.PaymentPageBinding

class PaymentPageActivity : AppCompatActivity() {
    private lateinit var binding: PaymentPageBinding

    companion object{
        const val EXTRA_BIOSKOP = "itemBioskopSelect"
        const val EXTRA_SEAT = "itemSeatSelect"
        const val EXTRA_PAY = "itemPaySelect"
        const val EXTRA_BANK = "itemBankSelect"
        const val EXTRA_TIME =  "time"
        const val EXTRA_PRIZE = "prize"
        const val EXTRA_ADDED_PRIZE = "added_prize"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = PaymentPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val title = intent.getStringExtra(EXTRA_TITLE)
        val img = intent.getIntExtra(EXTRA_IMG, 0)
        val name = intent.getStringExtra(EXTRA_NAME)

        with(binding){
            val bioskop = findViewById<Spinner>(R.id.bioskop)
            val itemBioskop = arrayOf("Lippo Plaza Cinepolis","Sleman City Hall XXI",
                "Empire XXI Gejayan", "Ambarukmo XXI", "CGV Pakuwon Mall")
            val adapterBioskop = ArrayAdapter(this@PaymentPageActivity, android.R.layout.simple_spinner_item, itemBioskop)
            adapterBioskop.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            bioskop.adapter = adapterBioskop

            val seat = findViewById<Spinner>(R.id.seat)
            val itemSeat = arrayOf("Regular", "Premium", "Exclusive")
            val adapterSeat = ArrayAdapter(this@PaymentPageActivity, android.R.layout.simple_spinner_item, itemSeat)
            adapterSeat.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            seat.adapter = adapterSeat

            val payment = findViewById<Spinner>(R.id.payment)
            val itemPay = arrayOf("Bank", "Dana", "Ovo", "Gopay")
            val adapterPayment = ArrayAdapter(this@PaymentPageActivity, android.R.layout.simple_spinner_item, itemPay)
            adapterPayment.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            payment.adapter = adapterPayment

            val bank = findViewById<Spinner>(R.id.bank)
            val itemBank = arrayOf("BCA", "BNI", "BRI", "Mandiri", "BSI")
            val adapterBank = ArrayAdapter(this@PaymentPageActivity, android.R.layout.simple_spinner_item, itemBank)
            adapterBank.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            bank.adapter = adapterBank

            val datePicker = findViewById<DatePicker>(R.id.tanggal)
            val timePicker = findViewById<TimePicker>(R.id.time)

            val tahun = datePicker.year
            val bulan = datePicker.month + 1
            val hari = datePicker.dayOfMonth
            val tanggal = "$hari/$bulan/$tahun"

            val jam = timePicker.hour
            val menit = timePicker.minute
            val waktu = "$jam:$menit"
            val dateTime = "$tanggal, $waktu"

            val textView = findViewById<TextView>(R.id.jenis_seat)
            val prize = findViewById<TextView>(R.id.prize)
            val finPrize = findViewById<TextView>(R.id.final_prize)
            val itemPrize = mapOf(
                itemSeat[0] to 40000,
                itemSeat[1] to 50000,
                itemSeat[2] to 60000)

            bioskop.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View?,
                    position: Int,
                    id: Long) {
                    val selectedBioskop = bioskop[position]
                    Log.d("SelectedBioskop", selectedBioskop.toString())
                }

                override fun onNothingSelected(parent: AdapterView<*>) {

                }
            }

            seat.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                    val selectedItem = parent.getItemAtPosition(position).toString()
                    val selectedPrize = itemPrize[selectedItem]
                    val addedPrize = 2000
                    val totalPrize = addedPrize + selectedPrize!!

                    textView.text = "$selectedItem"
                    prize.text = "Rp. " + selectedPrize.toString()
                    finPrize.text = "Rp. " + totalPrize.toString()
                }
                override fun onNothingSelected(parent: AdapterView<*>) {
                }
            }

            val numb = findViewById<TextView>(R.id.number)
            payment.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                    val selectedItem = parent.getItemAtPosition(position).toString()
                    if (selectedItem == "Bank") {
                        bank.visibility = View.VISIBLE
                        numb.visibility = View.VISIBLE
                    } else {
                        bank.visibility = View.GONE
                        numb.visibility = View.GONE
                    }
                }
                override fun onNothingSelected(parent: AdapterView<*>) {
                }
            }

            val selectedPrize = itemPrize[itemSeatSelect]
            val addedPrize = 2000

            backButton.setOnClickListener{
                val intentPaymentPageActivity =
                    Intent(this@PaymentPageActivity, HomePageActivity::class.java)
                intentPaymentPageActivity.putExtra(EXTRA_NAME, name)
                startActivity(intentPaymentPageActivity)
            }
            buttonOrder.setOnClickListener {
                val intentPaymentPageActivity =
                    Intent(this@PaymentPageActivity, OrderPageActivity::class.java)
                intentPaymentPageActivity.putExtra(EXTRA_BIOSKOP, itemBioskopSelect)
                intentPaymentPageActivity.putExtra(EXTRA_SEAT, itemSeatSelect)
                intentPaymentPageActivity.putExtra(EXTRA_PAY, itemPaySelect)
                intentPaymentPageActivity.putExtra(EXTRA_BANK, itemBankSelect)
                intentPaymentPageActivity.putExtra(EXTRA_TIME, dateTime)
                intentPaymentPageActivity.putExtra(EXTRA_PRIZE, selectedPrize)
                intentPaymentPageActivity.putExtra(EXTRA_ADDED_PRIZE, addedPrize)
                intentPaymentPageActivity.putExtra(EXTRA_TITLE, title)
                intentPaymentPageActivity.putExtra(EXTRA_IMG, img)
                intentPaymentPageActivity.putExtra(EXTRA_NAME, name)
                startActivity(intentPaymentPageActivity)
            }
        }
    }
}