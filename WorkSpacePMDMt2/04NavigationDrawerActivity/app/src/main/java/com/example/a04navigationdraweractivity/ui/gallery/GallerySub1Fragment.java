package com.example.a04navigationdraweractivity.ui.gallery;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a04navigationdraweractivity.R;
import com.example.a04navigationdraweractivity.databinding.FragmentGalleryBinding;
import com.example.a04navigationdraweractivity.databinding.FragmentGallerySub1Binding;

public class GallerySub1Fragment extends Fragment {

    private FragmentGallerySub1Binding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentGallerySub1Binding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnIrASub2.setOnClickListener(v ->
                Navigation.findNavController(view).navigate(R.id.galerySub2Fragment));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}