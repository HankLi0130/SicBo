package dev.hankli.sicbo.round

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import dev.hankli.sicbo.R
import dev.hankli.sicbo.SharedViewModel
import dev.hankli.sicbo.databinding.FragmentRoundBinding
import dev.hankli.sicbo.model.Round

class RoundFragment : Fragment(R.layout.fragment_round) {

    private val sharedViewModel: SharedViewModel by activityViewModels()

    private var _binding: FragmentRoundBinding? = null
    private val binding get() = _binding!!

    private val roundAdapter = RoundAdapter()

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

        binding.floatingButton.setOnClickListener {
            findNavController().navigate(
                RoundFragmentDirections.actionRoundFragmentToEditRoundFragment()
            )
        }

        binding.bottomAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.clear_all -> {
                    sharedViewModel.removeAllRounds()
                    true
                }
                else -> false
            }
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