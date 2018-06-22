package com.cogitator.common.modules

import com.cogitator.common.models.Credential
import com.cogitator.common.models.User

/**
 * @author Ankit Kumar (ankitdroiddeveloper@gmail.com) on 18/06/2018 (MM/DD/YYYY)
 */
interface IAuthModule {
    fun setCredential(credential: Credential)
    fun getCredential(): Credential

    fun start()

    fun stop()

    fun register(email: String, password: String, callback: Callback)

    fun signIn(email: String, password: String, callback: Callback)

    fun signOut(callback: Callback)

     interface Callback {
        fun onComplete(isSuccessful: Boolean, _msg: String)
    }

    fun setSessionListener(sessionCallback: SessionCallback)

     interface SessionCallback {
        fun onAuthState(isAuthorized: Boolean)
    }

    fun getUser(): User?
}