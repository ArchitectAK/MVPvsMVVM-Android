package com.cogitator.mvpvsmvvm_android.domain.modules

import com.cogitator.common.models.Credential
import com.cogitator.common.models.User
import com.cogitator.common.modules.IUserModule

/**
 * @author Ankit Kumar (ankitdroiddeveloper@gmail.com) on 20/06/2018 (MM/DD/YYYY)
 */
class UserModuleImpl : IUserModule {
    private var user: User? = null
    override fun getTestCredential(): Credential {
        return Credential("test-user@test-mail.com", "testpass")
    }

    override fun setUser(_user: User?) {
        user = _user
    }

    override fun getUser(): User? {
        return user
    }
}