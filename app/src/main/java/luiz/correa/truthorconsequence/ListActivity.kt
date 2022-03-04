package luiz.correa.truthorconsequence

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import luiz.correa.truthorconsequence.databinding.ActivityListBinding

class ListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.edt2.isEnabled = false
        binding.edt3.isEnabled = false
        binding.edt4.isEnabled = false
        binding.edt5.isEnabled = false
        binding.edt6.isEnabled = false
        binding.edt7.isEnabled = false
        binding.edt8.isEnabled = false
        binding.edt9.isEnabled = false
        binding.edt10.isEnabled = false
        enableField()

    }
    fun draw(view : View) {

        val arrayList = ArrayList<String>()

        arrayList.add( binding.edt1.text.toString())
        arrayList.add( binding.edt2.text.toString())
        arrayList.add( binding.edt3.text.toString())
        arrayList.add( binding.edt4.text.toString())

        arrayList.add( binding.edt5.text.toString())
        arrayList.add( binding.edt6.text.toString())
        arrayList.add( binding.edt7.text.toString())
        arrayList.add( binding.edt8.text.toString())

        arrayList.add( binding.edt9.text.toString())
        arrayList.add( binding.edt10.text.toString())



        val intent = Intent(this,PieChartActivity::class.java)
        intent.putStringArrayListExtra("arrayList",arrayList)
        startActivity(intent)
    }

    private fun enableField() {
        binding.edt1.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                if(binding.edt1.text.toString() != "") {
                    binding.edt2.isEnabled = true
                  }
            }
        })
        closeKeyboard()

        binding.edt2.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                if(binding.edt2.text.toString() != "") {
                    binding.edt3.isEnabled = true
                }
            }
        })
        closeKeyboard()

        binding.edt3.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                if(binding.edt3.text.toString() != "") {
                   binding.edt4.isEnabled = true
                }
            }
        })
        closeKeyboard()

        binding.edt4.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                if(binding.edt4.text.toString() != "") {
                    binding.edt5.isEnabled = true
                }
            }
        })
        closeKeyboard()

        binding.edt5.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                if(binding.edt5.text.toString() != "") {
                    binding.edt6.isEnabled = true
                }
            }
        })
        closeKeyboard()

        binding.edt6.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                if(binding.edt6.text.toString() != "") {
                    binding.edt7.isEnabled = true
                }
            }
        })
        closeKeyboard()

        binding.edt7.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                if(binding.edt7.text.toString() != "") {
                    binding.edt8.isEnabled = true
                }
            }
        })
        closeKeyboard()

        binding.edt8.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                if(binding.edt8.text.toString() != "") {
                    binding.edt9.isEnabled = true
                }
            }
        })
        closeKeyboard()

        binding.edt9.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                if(binding.edt9.text.toString() != "") {
                    binding.edt10.isEnabled = true
                }
            }
        })
        closeKeyboard()
    }


    private fun closeKeyboard() {
        val view = currentFocus
        view?.let {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(it.windowToken, 0)
        }
    }

}