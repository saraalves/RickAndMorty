package com.saraalves.rickandmorty

import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel

//inline fun <reified State : UIState, reified Action : UIAction> Fragment.onAction(
//    viewModel: ViewModel<State, Action>,
//    crossinline handleEvents: (Action) -> Unit
//) {
//    viewModel.action.observe(viewLifecycleOwner, Observer { event -> handleEvents(event as Action) })
//}
//
//inline fun <reified State : UIState, reified Action : UIAction> Fragment.onStateChange(
//    viewModel: ViewModel<State, Action>,
//    crossinline handleStates: (State) -> Unit
//) {
//    viewModel.state.observe(viewLifecycleOwner, Observer { state -> handleStates(state as State) })
//}