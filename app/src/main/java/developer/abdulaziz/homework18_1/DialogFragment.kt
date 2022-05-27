package developer.abdulaziz.homework18_1

import android.os.Bundle
import android.view.*
import androidx.fragment.app.DialogFragment
import developer.abdulaziz.homework18_1.databinding.FragmentDialogBinding
import kotlinx.android.synthetic.main.fragment_dialog.*

class DialogFragment : DialogFragment() {
    private lateinit var binding: FragmentDialogBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDialogBinding.inflate(layoutInflater)

        binding.next.setOnClickListener {
            if (edt.text.toString().isNotEmpty()) {
                edt.visibility = View.INVISIBLE
                cancel.visibility = View.INVISIBLE
                next.visibility = View.INVISIBLE
                text.text = edt.text.toString()
            }
        }

        return binding.root
    }
}