package com.cogitator.mvpvsmvvm_android.data

import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import org.jetbrains.annotations.Nullable


/**
 * @author Ankit Kumar (ankitdroiddeveloper@gmail.com) on 20/06/2018 (MM/DD/YYYY)
 */
class FirebaseAuthManager {
    private var mAuth: FirebaseAuth = FirebaseAuth.getInstance()
    private var mAuthListener: FirebaseAuth.AuthStateListener? = null

    private var user: FirebaseUser? = null

    private var authStateListener: AuthStateListener? = null

    init {
        mAuthListener = FirebaseAuth.AuthStateListener { firebaseAuth ->
            val _user = firebaseAuth.currentUser

            if (_user != null) {
                // User is signed in
                user = _user
            } else {
                // User is signed out
                user = null
            }

            if (authStateListener != null) authStateListener!!.onAuthorized(_user != null)
        }
    }

    fun subscribe() {
        mAuth.addAuthStateListener(mAuthListener!!)
    }

    fun unSubscribe() {
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener!!)
        }
    }

    fun createUserWithEmailAndPassword(email: String, password: String, @Nullable onCompleteListener: OnCompleteListener<AuthResult>?) {
        val resultTask = mAuth.createUserWithEmailAndPassword(email, password)
        if (onCompleteListener != null) {
            resultTask.addOnCompleteListener(onCompleteListener)
        }
    }

    fun signInWithEmailAndPassword(email: String, password: String, @Nullable onCompleteListener: OnCompleteListener<AuthResult>?) {
        val resultTask = mAuth.signInWithEmailAndPassword(email, password)
        if (onCompleteListener != null) {
            resultTask.addOnCompleteListener(onCompleteListener)
        }
    }

    fun signOut() {
        mAuth.signOut()
    }

    fun setAuthStateListener(_authStateListener: AuthStateListener) {
        authStateListener = _authStateListener
    }

    @Nullable
    fun getUser(): FirebaseUser? {
        return user
    }

    interface AuthStateListener {
        fun onAuthorized(isAuthorized: Boolean)
    }
}