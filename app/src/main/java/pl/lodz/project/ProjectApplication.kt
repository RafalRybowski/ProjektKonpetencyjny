package pl.lodz.project

import android.app.Application
import pl.lodz.project.remote.RetrofitClient

class ProjectApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        //TODO change baseUrl
        RetrofitClient.createClient("http:/192.168.1.107:3000/")
    }
}