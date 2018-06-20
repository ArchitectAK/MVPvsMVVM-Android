package com.cogitator.mvpvsmvvm_android.domain

import android.content.Context
import com.cogitator.common.ObjectGraph
import com.cogitator.common.modules.ICheckInModule
import com.cogitator.common.modules.IAuthModule
import com.cogitator.common.modules.IUserModule
import com.cogitator.mvpvsmvvm_android.data.FirebaseAuthManager
import com.cogitator.mvpvsmvvm_android.domain.modules.UserModuleImpl


/**
 * @author Ankit Kumar (ankitdroiddeveloper@gmail.com) on 20/06/2018 (MM/DD/YYYY)
 */
class ObjectGraphIMPL(_context: Context) : ObjectGraph() {

    fun clean() {
        graph = null
    }

    private lateinit var userModule: IUserModule
    private lateinit var authModule: IAuthModule
    private lateinit var checkInModule: ICheckInModule

    init {
        graph = ObjectGraphIMPL(_context)

        userModule = UserModuleImpl()

        authModule = AuthModuleImpl(FirebaseAuthManager())

        checkInModule = CheckInModuleImpl()
        checkInModule.init()

    }

    override fun getUserModule(): IUserModule {
        return userModule
    }

    override fun getAuthModule(): IAuthModule {
        return authModule
    }

    override fun getCheckInModule(): ICheckInModule {
        return checkInModule
    }
}