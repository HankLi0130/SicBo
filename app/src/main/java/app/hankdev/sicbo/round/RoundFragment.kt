package app.hankdev.sicbo.round

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import app.hankdev.sicbo.R
import app.hankdev.sicbo.SharedViewModel
import app.hankdev.sicbo.databinding.FragmentRoundBinding
import app.hankdev.sicbo.model.Round

class RoundFragment : Fragment(R.layout.fragment_round) {

    private val sharedViewModel: SharedViewModel by activityViewModels()

    private var _binding: FragmentRoundBinding? = null
    private val binding get() = _binding!!

    private val roundAdapter = RoundAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRoundBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedViewModel.roundsData.observe(viewLifecycleOwner) {
            roundAdapter.items = it
            roundAdapter.notifyDataSetChanged()
        }

        binding.list.run {
            adapter = roundAdapter.apply {
                removeItemListener = ::removeItem
            }
            setHasFixedSize(true)
            addItemDecoration(
                DividerItemDecoration(requireContext(), DividerItemDecoration.HORIZONTAL)
            )
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.fragment_round, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.add_round -> {
                findNavController().navigate(
                    RoundFragmentDirections.actionRoundFragmentToEditRoundFragment()
                )
                true
            }
            R.id.clear_all -> {
                sharedViewModel.removeAllRounds()
                true
            }
            else -> false
        }
    }

    private fun removeItem(round: Round) {
        sharedViewModel.removeRound(round)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}