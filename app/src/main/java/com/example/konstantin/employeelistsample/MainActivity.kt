package com.example.konstantin.employeelistsample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers

const val TAG = "[DEBUG]"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "entered onResume")
        requestEmployeeData()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        //onSuccess
                        { response ->
                            val worker = response.first()
                            val specialty = worker.specialty.first()

                            Log.d(TAG, "Имя: ${worker.fName}")
                            Log.d(TAG, "Фамилия: ${worker.lName}")
                            Log.d(TAG, "День рождения: ${worker.birthday}")
                            Log.d(TAG, "Аватар: ${worker.avatarUrl}")
                            Log.d(TAG, "ID должности: ${specialty.specialtyId}")
                            Log.d(TAG, "Должность: ${specialty.name}")
                        },
                        //onError
                        { error ->
                            Log.d(TAG, "error: ${error.localizedMessage}")
                        }
                )
    }
}
