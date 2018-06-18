package com.cogitator.common

import com.cogitator.common.modules.ICheckInModule
import com.cogitator.common.modules.IAuthModule
import com.cogitator.common.modules.IUserModule


/**
 * @author Ankit Kumar (ankitdroiddeveloper@gmail.com) on 18/06/2018 (MM/DD/YYYY)
 */
interface IObjectGraph {
    fun getUserModule(): IUserModule

    fun getAuthModule(): IAuthModule

    fun getCheckInModule(): ICheckInModule
}