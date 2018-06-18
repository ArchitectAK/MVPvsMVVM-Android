package com.cogitator.common.modules

import com.cogitator.common.models.Credential
import com.cogitator.common.models.User

/**
 * @author Ankit Kumar (ankitdroiddeveloper@gmail.com) on 18/06/2018 (MM/DD/YYYY)
 */
interface IUserModule {
    fun getTestCredential(): Credential

    fun setUser(_user: User)

    fun getUser(): User
}