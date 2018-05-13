package com.example.konstantin.employeelistsample

import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

fun requestEmployeeData(): Single<List<Response>> = employeeDataService.getEmployeeData()
        .subscribeOn(Schedulers.io())
        .map { it.response }