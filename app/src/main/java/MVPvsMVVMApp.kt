import android.app.Application
import com.cogitator.com
import com.cogitator.mvpvsmvvm_android.domain.ObjectGraphIMPL

/**
 * @author Ankit Kumar (ankitdroiddeveloper@gmail.com) on 20/06/2018 (MM/DD/YYYY)
 */
class MVPvsMVVMApp : Application() {
    override fun onCreate() {
        super.onCreate()
        ObjectGraphIMPL(this)
    }

    override fun onTerminate() {
        super.onTerminate()
        ObjectGraphIMPL(this).clean()
    }

}