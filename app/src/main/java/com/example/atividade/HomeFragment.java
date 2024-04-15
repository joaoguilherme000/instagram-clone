package com.example.atividade;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.atividade.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = binding.layoutHome;
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        // Create list of Post objects
        List<PostAdapter.Post> postList = new ArrayList<>();
        postList.add(new PostAdapter.Post(R.drawable.post_image1));
        postList.add(new PostAdapter.Post(R.drawable.post_image2));
        postList.add(new PostAdapter.Post(R.drawable.post_image3));

        // Create and set adapter with the list of posts
        adapter = new PostAdapter(postList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}