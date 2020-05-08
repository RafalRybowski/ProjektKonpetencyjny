package pl.lodz.project.task

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import pl.lodz.project.R

class TaskFragment : Fragment() {
//TODO Rozszerzyć o interface Task

    //inicjalizacja presentera by lazy

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.task_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //dodanie do przycisku event na nacisniecie
        //zainicjalizowanie recycler View
    }
}