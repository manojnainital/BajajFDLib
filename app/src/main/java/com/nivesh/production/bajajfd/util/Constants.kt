package com.nivesh.production.bajajfd.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.ConnectivityManager.TYPE_ETHERNET
import android.net.ConnectivityManager.TYPE_WIFI
import android.net.NetworkCapabilities.*
import android.os.Build
import android.provider.ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE
import android.util.Patterns
import com.nivesh.production.bajajfd.BajajApplication
import java.util.regex.Matcher
import java.util.regex.Pattern

class Constants() {

    companion object {
        const val BASE_URL ="put your base url here"
        /**
         *Before use this method write following code in model class
        app:Application(in activity and model)
        changes in hasInternetConnection
        val connectivityManager = getApplication<NewsApplication>().getSystemService(....

         **/

        //internet check
        private fun isNetworkAvailable(): Boolean {
            val connectivityManager = BajajApplication().getSystemService(
                Context.CONNECTIVITY_SERVICE
            ) as ConnectivityManager
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

                val activeNetwork = connectivityManager.activeNetwork ?: return false
                val capabilities =
                    connectivityManager.getNetworkCapabilities(activeNetwork) ?: return false
                return when {
                    capabilities.hasTransport(TRANSPORT_WIFI) -> true
                    capabilities.hasTransport(TRANSPORT_CELLULAR) -> true
                    capabilities.hasTransport(TRANSPORT_ETHERNET) -> true
                    else -> false
                }
            } else {
                connectivityManager.activeNetworkInfo?.run {
                    return when (type) {
                        TYPE_WIFI -> true
                        TYPE_MOBILE -> true
                        TYPE_ETHERNET -> true
                        else -> false
                    }
                }
            }
            return false
        }
        //phone number
        private fun checkValidPhoneNumber(phoneText: String?): String? {

            if (phoneText != null) {
                if(!phoneText.matches(".*[0-9].*".toRegex())){
                    return "Must be all Digits"
                }
            }
            if (phoneText != null) {
                if(phoneText.length != 10){
                    return "Must be 10 Digits"
                }
            }
            return null
        }

        //valid email check
        private fun isValidEmail(emailText:String?): String? {

            if(!emailText?.let { Patterns.EMAIL_ADDRESS.matcher(it).matches() }!!)
            {
                return "Invalid Email Address"
            }
            return null
        }
        //valid Name Check
        private fun isValidName(nameText: String?): String {
            val pattern = Pattern.compile(("^[a-zA-Z\\s]{2,70}$"))
            val matcher = pattern.matcher(nameText)
            if (!matcher.matches()) {
                return "Enter Valid Name"
            }
            return ""

        }
        //validPanCard
        private fun isValidPanCardNo(panCardNo: String?): Boolean {
            // Regex to check valid PAN Card number.
            val regex = "[A-Z]{5}[0-9]{4}[A-Z]{1}"
            // Compile the ReGex
            val p = Pattern.compile(regex)
            // If the PAN Card number
            // is empty return false
            if (panCardNo == null) {
                return false
            }
            // Pattern class contains matcher() method
            // to find matching between given
            // PAN Card number using regular expression.
            val m = p.matcher(panCardNo)
            // Return if the PAN Card number
            // matched the ReGex
            return m.matches()
        }
        //is Indian mobile Number
        private  fun isIndianMobileNo(mobileNumber: String?): Boolean {
            //(0/91): number starts with (0/91)
            //[7-9]: starting of the number may contain a digit between 0 to 9
            //[0-9]: then contains digits 0 to 9
            val pattern: Pattern = Pattern.compile("^[6-9]\\d{9}$")
            //the matcher() method creates a matcher that will match the given input against this pattern
            val match: Matcher = pattern.matcher(mobileNumber)
            //returns a boolean value
            return match.matches()
        }
    }
}