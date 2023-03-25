package com.example.mycafe.ui.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.mycafe.databinding.FragmentGalleryBinding;

public class ProfileFragment extends Fragment {

    private FragmentGalleryBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ProfileViewModel profileViewModel =
                new ViewModelProvider(this).get(ProfileViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialogUpdate();
            }
        });


        return root;
    }

    public void openDialogUpdate(){
        DialogFragment newFragment = new UpdateProfileFragment();
        newFragment.show(getParentFragmentManager(),"update");

    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}