package com.example.mycafe;

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
import android.widget.Toast;

public class AddMoneyDialogFragment extends DialogFragment {
    private EditText et_want_save_money;
    private AddMoneyListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = requireActivity().getLayoutInflater();

        View view = inflater.inflate(R.layout.fragment_add_money_dialog, null);

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(view)
                // Add action buttons
                .setPositiveButton(R.string.add, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                        String money = et_want_save_money.getText().toString();
                        listener.appleTexts(money);
                        Toast.makeText(getContext(), "加值成功", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        AddMoneyDialogFragment.this.getDialog().cancel();
                    }
                });


        et_want_save_money = view.findViewById(R.id.et_want_save_money);

        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            listener = (AddMoneyListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement AddMoneyListener");
        }
    }

    public interface AddMoneyListener{
        void appleTexts(String money);
    }
}