package com.example.calculator

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.mozilla.javascript.Context
import org.mozilla.javascript.Scriptable

class CalculatorViewModel : ViewModel() {

    private val _equaltionText = MutableLiveData("")
    val equationText: LiveData<String> = _equaltionText

    private val _resultText = MutableLiveData("0")
    val resultText: LiveData<String> = _resultText


    fun onButtonClick(btn: String) {
        Log.i("Clicked Button", btn)

        _equaltionText.value?.let {
            if (btn == "AC") {
                _equaltionText.value = ""
                _resultText.value = "0"
                return
            }

            if (btn == "C") {
                if (it.isNotEmpty()) {
                    _equaltionText.value = it.substring(0, it.length - 1)
                }
                return
            }

            if (btn == "=") {
                _equaltionText.value = _resultText.value
                return
            }

            _equaltionText.value = it + btn

            try {
                _resultText.value = calculateResult(_equaltionText.value.toString())
            } catch (_ : Exception) {}

        }
    }

    fun calculateResult(equation: String) : String {
        val context : Context = Context.enter()
        context.optimizationLevel = -1
        val scriptable : Scriptable = context.initStandardObjects()
        var finalResult = context.evaluateString(scriptable, equation, "Javascript", 1, null).toString()
        if (finalResult.endsWith(".0")) {
            finalResult = finalResult.replace(".0", "")
        }
        return finalResult
    }

}