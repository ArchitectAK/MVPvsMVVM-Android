package com.cogitator.mvpvsmvvm_android.data.check_in

import com.cogitator.common.models.CheckIn
import com.google.firebase.database.Exclude
import java.util.HashMap
import java.util.Map

/**
 * @author Ankit Kumar (ankitdroiddeveloper@gmail.com) on 3/7/18 (MM/DD/YYYY)
 */
class EntityTranslator {


    @Exclude
    fun toMap(checkIn: CheckIn): Map<String, Any> {

        val readWriteMap = hashMapOf("email" to checkIn.email,
                "checkInMessage" to checkIn.checkInMessage,
                "timestamp" to checkIn.timestamp)
        return HashMap(readWriteMap)
    }
}