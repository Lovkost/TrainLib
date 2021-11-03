package com.example.trainlib

class MainPresenter(val view: MainView) {
    val model = CountersModel()

    fun counterClick(id: Int){
        when(id){
            R.id.btn_counter1 -> {
                val nextValue = model.next(0)
                view.setFirstCount(nextValue)
            }
            R.id.btn_counter2 -> {
                val nextValue = model.next(1)
                view.setSecondCount(nextValue)
            }
            R.id.btn_counter3 -> {
                val nextValue = model.next(2)
                view.setThirdCount(nextValue)
            }
        }
    }
}