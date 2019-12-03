package com.example.android.guesstheword.screens.score

import android.text.format.DateUtils
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class ScoreViewModel (finalScore: Int) : ViewModel() {
    // The final score
    private val _score = MutableLiveData<Int>()
    private val _eventPlayAgain = MutableLiveData<Boolean>()
    val eventPlayAgain: LiveData<Boolean>
        get() = _eventPlayAgain

    // Countdown time
    private val _currentTime = MutableLiveData<Long>()
    val currentTime: LiveData<Long>
        get() = _currentTime

    val newResult = Transformations.map(currentTime) { time ->
        // Do some transformation on the input live data
        "Current time is :" + DateUtils.formatElapsedTime(time).length
        // and return the new value

    }

    val score: LiveData<Int>
        get() = _score
    init {
        Log.i("ScoreViewModel", "Final score is $finalScore")
        _score.value = finalScore

    }
    fun onPlayAgain() {
        _eventPlayAgain.value = true
    }
    fun onPlayAgainComplete() {
        _eventPlayAgain.value = false
    }
}