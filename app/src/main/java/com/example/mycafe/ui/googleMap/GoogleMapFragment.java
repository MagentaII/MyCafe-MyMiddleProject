package com.example.mycafe.ui.googleMap;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mycafe.R;
import com.example.mycafe.databinding.FragmentGoogleMapBinding;

public class GoogleMapFragment extends Fragment {

    private FragmentGoogleMapBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentGoogleMapBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Map point based on address
        Uri location = Uri.parse("geo:0,0?q=高科大第一校區");
        // Or map point based on latitude/longitude
        // Uri location = Uri.parse("geo:37.422219,-122.08364?z=14"); // z param is zoom level
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
        startActivity(mapIntent);

        Toast.makeText(getContext(), "GMap", Toast.LENGTH_SHORT).show();
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}