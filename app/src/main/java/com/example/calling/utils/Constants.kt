package com.example.calling.utils

import android.util.Base64

object Constants {
    const val KEY_NAME = "NAME"
    const val KEY_ID = "ID"
    const val KEY_UID = "KEY_UID"
    const val ACCOUNT_TYPE = "ACCOUNT_TYPE"

    //const val BASE_URL = "http://10.32.128.203/dett/v1/loginUser.php"
    //const val BASE_URL = "jdbc:mysql://85.114.100.114/"
    //const val BASE_URL = "http://10.27.52.254/dett/v1/registerUser.php"
    //const val BASE_URL = "http://10.32.130.1/dett/v1/"
    //const val BASE_URL = "http://10.27.55.150/dett/v1/"
    const val BASE_URL = "http://192.168.137.1/dett/v1/"
    const val LOGIN_URL = BASE_URL + "loginUser.php"
    const val REGISTER_URL = BASE_URL + "registerUser.php"
    val AUTH = "Basic" + Base64.encodeToString("moomen:9124279".toByteArray(), Base64.NO_WRAP)
}