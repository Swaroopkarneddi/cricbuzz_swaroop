package com.example.cricbuzz_swaroop

object loginandregisterTest {
    fun checkusername(name:String):Boolean{
        if (name.isEmpty()){
            return false
        }
        if(name.length<4){
            return false
        }
        return true
    }
    fun checkpassword(pass:String):Boolean{
        if (pass.isEmpty()){
            return false
        }
        if (pass.length<6){
            return false
        }

        return true
    }
}