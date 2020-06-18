package pl.lodz.project

import android.app.Application
import pl.lodz.project.utils.remote.RetrofitClient

class ProjectApplication: Application() {

    companion object{
        const val serverUrl = "http://192.168.0.166:3000"
    }

    override fun onCreate() {
        super.onCreate()
        RetrofitClient.createClient(serverUrl)
    }
}