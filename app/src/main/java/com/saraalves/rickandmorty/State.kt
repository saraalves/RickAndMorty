package com.saraalves.rickandmorty

import androidx.lifecycle.LiveData

//class State<State : UIState>(initialState: State) {
//
//    private val _state = ViewModelPlugins.factory.createMutableLiveData(initialState)
//    val state: LiveData<State> = _state
//
//    fun setState(state: (State) -> State) {
//        // As we always set a initial state and setter is private and
//        // always set a non null value, value can never be null.
//        _state.value = state(_state.value!!)
//    }
//}