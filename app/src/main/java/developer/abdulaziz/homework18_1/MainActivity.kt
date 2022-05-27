package developer.abdulaziz.homework18_1

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.*
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.snackbar.Snackbar
import developer.abdulaziz.homework18_1.databinding.*
import kotlinx.android.synthetic.main.bottom_item.view.*
import kotlinx.android.synthetic.main.fragment_dialog.*
import java.time.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @SuppressLint("InflateParams")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val thiss = this@MainActivity

        binding.apply {
            alertDialog.setOnClickListener {
                val alertDial = AlertDialog.Builder(thiss)
                alertDial.setTitle("Alert Dialog")
                val list = arrayOf("Abdulaziz", "Abdulahad", "Abdusamid", "Ramibek")
                alertDial.setSingleChoiceItems(
                    list, 0
                ) { _, p1 -> Toast.makeText(thiss, list[p1], Toast.LENGTH_SHORT).show() }
                alertDial.setPositiveButton(
                    "Ha"
                ) { _, _ -> Toast.makeText(thiss, "Malades", Toast.LENGTH_SHORT).show() }
                alertDial.setNegativeButton(
                    "Yo'q"
                ) { _, _ -> Toast.makeText(thiss, "Jinni", Toast.LENGTH_SHORT).show() }
                alertDial.setNeutralButton(
                    "Orqaga"
                ) { _, _ -> Toast.makeText(thiss, "Kalla bormi ?", Toast.LENGTH_SHORT).show() }
                alertDial.show()
            }
            customDialog.setOnClickListener {
                val customDialog = AlertDialog.Builder(
                    thiss
                    /**, R.style.NewDialog*/
                ).create()
                val itemDialog = ItemCustomDialogBinding.inflate(layoutInflater)
                customDialog.setView(itemDialog.root)
                customDialog.setTitle("Custom Dialog")
                customDialog.show()
                itemDialog.exit.setOnClickListener {
                    if (itemDialog.togri.isChecked) {
                        Toast.makeText(thiss, "To'g'ri", Toast.LENGTH_SHORT).show()
                        customDialog.cancel()
                    } else {
                        Toast.makeText(thiss, "Noto'g'ri", Toast.LENGTH_SHORT).show()
                        customDialog.cancel()
                    }
                }
            }
            fragmentDialog.setOnClickListener {
                val dialog = DialogFragment()
                dialog.show(supportFragmentManager.beginTransaction(), "fragment")
                dialog.cancel.setOnClickListener {
                    dialog.dismiss()
                }
            }
            datePickerDialog.setOnClickListener {
                val data = DatePickerDialog(thiss)
                data.setOnDateSetListener { _, p1, p2, p3 ->
                    Toast.makeText(thiss, "$p3 day, $p2 month, $p1 year", Toast.LENGTH_SHORT).show()
                }
                data.updateDate(
                    LocalDate.now().year,
                    LocalDate.now().monthValue - 1,
                    LocalDate.now().dayOfMonth
                )
                data.setTitle("Date Picker Dialog")
                data.show()
            }
            timePickerDialog.setOnClickListener {
                val time = TimePickerDialog(
                    thiss,
                    { _, p1, p2 ->
                        Toast.makeText(thiss, "$p1 hours $p2 minute", Toast.LENGTH_SHORT).show()
                    }, 23, 59, true
                )
                time.updateTime(LocalTime.now().hour + 5, LocalTime.now().minute)
                time.setTitle("Time Picker Dialog")
                time.show()
            }
            bottomSheetDialog.setOnClickListener {
                val bottom = BottomSheetDialog(thiss)
                bottom.setTitle("Bottom Sheet Dialog")
                val item = layoutInflater.inflate(R.layout.bottom_item, null, false)
                item.kotlin.setOnClickListener {
                    Toast.makeText(thiss, "Kotlin is Very Great", Toast.LENGTH_SHORT).show()
                    bottom.cancel()
                }
                item.java.setOnClickListener {
                    Toast.makeText(thiss, "Java is Very Good", Toast.LENGTH_SHORT).show()
                    bottom.cancel()
                }
                item.c2plus.setOnClickListener {
                    Toast.makeText(thiss, "C++ is Great", Toast.LENGTH_SHORT).show()
                    bottom.cancel()
                }
                bottom.setContentView(item)
                bottom.show()
            }
            snackbar.setOnClickListener {
                val snackbar = Snackbar.make(it, "10000 so'm pul", Snackbar.LENGTH_LONG)
                snackbar.setAction(
                    "Ok"
                ) { Toast.makeText(thiss, "Clicked", Toast.LENGTH_SHORT).show() }
                snackbar.show()
            }
            home2.setOnClickListener {
                val customDialog = AlertDialog.Builder(root.context, R.style.NewDialog).create()
                val itemDialog = ItemCustomBinding.inflate(layoutInflater)
                customDialog.setView(itemDialog.root)
                customDialog.show()
                itemDialog.cancel.setOnClickListener {
                    customDialog.cancel()
                    linear.setBackgroundColor(Color.WHITE)
                }
                itemDialog.retry.setOnClickListener { }
                linear.setBackgroundColor(Color.parseColor("#656565"))
            }
            home3.setOnClickListener {
                val customDialog = AlertDialog.Builder(root.context).create()
                val itemDialog = ItemBinding.inflate(layoutInflater)
                customDialog.setView(itemDialog.root)
                customDialog.show()
                itemDialog.cancel.setOnClickListener {
                    Toast.makeText(root.context, "Canceled", Toast.LENGTH_SHORT).show()
                    customDialog.cancel()
                }
                itemDialog.okay.setOnClickListener {
                    Toast.makeText(root.context, "Very Good", Toast.LENGTH_SHORT).show()
                    customDialog.cancel()
                }
            }
        }

    }
}