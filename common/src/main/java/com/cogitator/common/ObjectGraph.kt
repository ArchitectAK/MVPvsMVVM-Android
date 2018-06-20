package com.cogitator.common

/**
 * @author Ankit Kumar (ankitdroiddeveloper@gmail.com) on 18/06/2018 (MM/DD/YYYY)
 */
abstract class ObjectGraph : IObjectGraph {
    /*protected*/  var graph: IObjectGraph? = null

    fun getInstance(): IObjectGraph? {
        return graph
    }

}