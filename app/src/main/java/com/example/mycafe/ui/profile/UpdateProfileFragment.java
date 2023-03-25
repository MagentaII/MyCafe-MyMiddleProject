package com.example.mycafe.ui.profile;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import android.view.LayoutInflater;
import android.view.View;

import com.example.mycafe.R;

public class UpdateProfileFragment extends DialogFragment {


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = requireActivity().getLayoutInflater();

        View view = inflater.inflate(R.layout.fragment_update_profile, null);

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(view)
                // Add action buttons
                .setPositiveButton(R.string.update, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {


                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        UpdateProfileFragment.this.getDialog().cancel();
                    }
                });



        return builder.create();
    }




}