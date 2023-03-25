package com.example.mycafe.ui.login;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.example.mycafe.R;

public class LoginDialogFragment extends DialogFragment {

    private EditText et_username;
    private EditText et_password;
    private LoginDialogFragment.loginListener listener;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.fragment_login_dialog, null);
        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(view)
                // Add action button
                .setPositiveButton(R.string.signin, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                        String username = et_username.getText().toString();
                        String password = et_password.getText().toString();
                        listener.appleTexts(username, password);
                    }
                })
                .setNegativeButton(R.string.clear, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                })
                .setNeutralButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        LoginDialogFragment.this.getDialog().cancel();
                    }
                });

        et_username = view.findViewById(R.id.et_username);
        et_password = view.findViewById(R.id.et_password);

        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            listener = (LoginDialogFragment.loginListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement AddMoneyListener");
        }
    }

    public interface loginListener{
        void appleTexts(String username, String password);
    }

}
