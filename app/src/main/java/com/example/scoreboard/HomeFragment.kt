package com.example.scoreboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.scoreboard.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val viewModel: ScoreViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.scoreA.observe(viewLifecycleOwner, Observer {
            binding.teamAScore.text = it.toString()
        })
        viewModel.scoreB.observe(viewLifecycleOwner, Observer {
            binding.teamBScore.text = it.toString()
        })
        binding.increaseTeamA.setOnClickListener{
            viewModel.incrementScoreTeamA()
        }
        binding.increaseTeamB.setOnClickListener{
            viewModel.incrementScoreTeamB()
        }
        binding.result.setOnClickListener{
            viewModel.checkWinnerTeam()
            findNavController().navigate(R.id.blankFragment02)
        }
    }
}