package pl.lodz.project.task

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pl.lodz.project.utils.remote.RetrofitClient
import pl.lodz.project.utils.remote.task.TaskServices

//piszemy wszystko po angielsku fiutki
class TaskPresenter {
//TODO 1 .przekazac Fragment przez interfejs
//TODO 2. Rozszerzyć clase o CoroutineScope. Rozszerznie to bedzie kazało wam zainicjalizowac
// zmiene coroutineContext, zainicjalizowac na Watek IO

    private val service by lazy {
        RetrofitClient.getClient().create(TaskServices::class.java)
    }

    fun unButtonPressed(/*co tu przekazac?*/){
        launch {
            //wykonac tutaj funkcje pobierania tasków
            withContext(Dispatchers.Main) {
                //wywolac tutaj funkcje z widoku
            }
        }
    }


    //TODO co zrobić jeżeli sie nie połaczysz z serwerem?
    //TODO co zrobić jezeli zwrócicie bład 400 badz 203 i etc
}