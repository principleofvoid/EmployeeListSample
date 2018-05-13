package com.example.konstantin.employeelistsample
import com.google.gson.annotations.SerializedName

data class EmployeeData(
    @SerializedName("response") val response: List<Response>
)

data class Response(
    @SerializedName("f_name") val fName: String,
    @SerializedName("l_name") val lName: String,
    @SerializedName("birthday") val birthday: String,
    @SerializedName("avatr_url") val avatarUrl: String,
    @SerializedName("specialty") val specialty: List<Specialty>
)

data class Specialty(
    @SerializedName("specialty_id") val specialtyId: Int,
    @SerializedName("name") val name: String
)