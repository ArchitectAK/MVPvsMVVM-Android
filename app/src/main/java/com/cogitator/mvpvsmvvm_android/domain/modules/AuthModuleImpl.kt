package com.cogitator.mvpvsmvvm_android.domain.modules

import android.support.annotation.Nullable
import com.cogitator.common.models.Credential
import com.cogitator.common.models.User
import com.cogitator.common.modules.IAuthModule
import com.cogitator.mvpvsmvvm_android.data.FirebaseAuthManager
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult


/**
 * @author Ankit Kumar (ankitdroiddeveloper@gmail.com) on 22/06/2018 (MM/DD/YYYY)
 */
class AuthModuleImpl(val firebaseAuthManager: FirebaseAuthManager) : IAuthModule {

    private var registerCallback: IAuthModule.Callback? = null

    private var signInCallback: IAuthModule.Callback? = null
    private var signOutCallback: IAuthModule.Callback? = null


    private lateinit var credential: Credential

    override fun setCredential(credential: Credential) {
        this.credential = credential
    }

    override fun getCredential(): Credential {
        return credential
    }

    override fun start() {
        firebaseAuthManager.subscribe()
    }

    override fun stop() {
        firebaseAuthManager.unSubscribe()
    }

    override fun register(email: String, password: String, callback: IAuthModule.Callback) {
        registerCallback = callback

        // TODO: 23-Feb-17 validate email, pass;

        firebaseAuthManager.createUserWithEmailAndPassword(email, password, OnCompleteListener<AuthResult> { task ->
            val exception = task.exception
            printStackTrace(exception)
            if (registerCallback != null) {
                registerCallback!!.onComplete(task.isSuccessful, if (exception != null) exception.message!! else "")
            }
        })
    }

    override fun signIn(email: String, password: String, callback: IAuthModule.Callback) {
        signInCallback = callback

        // TODO: 23-Feb-17 validate email, pass;

        firebaseAuthManager.signInWithEmailAndPassword(email, password, OnCompleteListener<AuthResult> { task ->
            val exception = task.exception
            printStackTrace(exception)
            if (signInCallback != null) {
                signInCallback!!.onComplete(task.isSuccessful, if (exception != null) exception.message!! else "")
            }
        })
    }

    override fun signOut(callback: IAuthModule.Callback) {
        signOutCallback = callback
        firebaseAuthManager.signOut()
        if (signOutCallback != null) signOutCallback!!.onComplete(true, "" /*todo*/)
    }

    override fun setSessionListener(sessionCallback: IAuthModule.SessionCallback) {
        firebaseAuthManager.setAuthStateListener(object : FirebaseAuthManager.AuthStateListener {
            override fun onAuthorized(isAuthorized: Boolean) {
                sessionCallback.onAuthState(isAuthorized)
            }
        })
    }

    override fun getUser(): User? {
        val firebaseUser = firebaseAuthManager.getUser()
        return if (firebaseUser == null)
            null
        else
            User(firebaseUser.uid, firebaseUser.email!!)

    }

    private fun printStackTrace(@Nullable exception: Exception?) {
        if (exception != null) {
            try {
                throw exception
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }
    }

}