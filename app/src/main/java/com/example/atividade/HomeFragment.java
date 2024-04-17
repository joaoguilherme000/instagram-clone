package com.example.atividade;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.atividade.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = binding.layoutHome;
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        List<PostAdapter.Post> postList = new ArrayList<>();
        postList.add(new PostAdapter.Post(R.drawable.post_image1));
        postList.add(new PostAdapter.Post(R.drawable.post_image2));
        postList.add(new PostAdapter.Post(R.drawable.post_image3));

        RecyclerView.Adapter adapter = new PostAdapter(postList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}