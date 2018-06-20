import android.app.Application

/**
 * @author Ankit Kumar (ankitdroiddeveloper@gmail.com) on 20/06/2018 (MM/DD/YYYY)
 */
class MVPvsMVVMApp : Application() {
    override fun onCreate() {
        super.onCreate()
        ObjectGraphImpl.init(this);
    }
}