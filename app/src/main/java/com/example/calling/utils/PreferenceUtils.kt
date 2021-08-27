package com.example.calling.utils

import android.content.Context
import android.preference.PreferenceManager

object PreferenceUtils {
    fun saveName(name: String?, context: Context?): Boolean {
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        val editor = preferences.edit()
        editor.putString(Constants.KEY_NAME, name)
        editor.apply()
        return true
    }

    fun getName(context: Context?): String? {
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        return preferences.getString(Constants.KEY_NAME, null)
    }

    fun saveID(userId: String?, context: Context?): Boolean {
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        val editor = preferences.edit()
        editor.putString(Constants.KEY_ID, userId)
        editor.apply()
        return true
    }

    fun getID(context: Context?): String? {
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        return preferences.getString(Constants.KEY_ID, null)
    }

    fun saveUid(userUid: String?, context: Context?): Boolean {
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        val editor = preferences.edit()
        editor.putString(Constants.KEY_UID, userUid)
        editor.apply()
        return true
    }

    fun getUid(context: Context?): String? {
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        return preferences.getString(Constants.KEY_UID, null)
    }

    fun saveAccountType(accountType: String?, context: Context?): Boolean {
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        val editor = preferences.edit()
        editor.putString(Constants.ACCOUNT_TYPE, accountType)
        editor.apply()
        return true
    }

    fun getAccountType(context: Context?): String? {
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        return preferences.getString(Constants.ACCOUNT_TYPE, null)
    }
}