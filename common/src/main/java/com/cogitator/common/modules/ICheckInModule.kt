package com.cogitator.common.modules

import com.cogitator.common.models.CheckIn



/**
 * @author Ankit Kumar (ankitdroiddeveloper@gmail.com) on 18/06/2018 (MM/DD/YYYY)
 */
interface ICheckInModule {
    fun init()

    fun leftNewCheckIn(_checkIn: CheckIn, _callback: Callback)

    fun loadAllCheckIn(_callback: Callback)

    fun getAllCheckInList(): List<CheckIn>

    fun loadCheckInByEmail(_email: String, _callback: Callback)

    fun getMyCheckInList(): List<CheckIn>

     interface Callback {
        fun onResult(isSuccess: Boolean, _msg: String)
    }

}