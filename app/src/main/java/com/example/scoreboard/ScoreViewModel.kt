package com.example.scoreboard

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScoreViewModel: ViewModel() {
    private var _myList = MutableLiveData<MutableList<User>?>()
    val myList: MutableLiveData<MutableList<User>?> get() = _myList

    fun addUser(user: User){
        val list = _myList.value
        list?.add(user)
        _myList.value = list
    }
    private var _scoreA = MutableLiveData<Int>()
    val scoreA: MutableLiveData<Int> get() = _scoreA
    private var _scoreB = MutableLiveData<Int>()
    val scoreB: MutableLiveData<Int> get() = _scoreB
    var _text = MutableLiveData<String>()
    val text: MutableLiveData<String> get() = _text

    fun checkWinnerTeam(){
        if ((scoreA.value?:0 ) > (scoreB.value?:0)){
            _text.value = "Team A is Winner"
        }
        else _text.value = "Team B is Winner"
    }
    fun incrementScoreTeamA(){
        val currentScore = _scoreA.value?:0
        _scoreA.value = currentScore+1
    }
    fun incrementScoreTeamB(){
        val currentScore = _scoreB.value?:0
        _scoreB.value = currentScore+1
    }
}