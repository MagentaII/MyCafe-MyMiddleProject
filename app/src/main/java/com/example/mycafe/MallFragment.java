package com.example.mycafe;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.mycafe.databinding.FragmentMallBinding;

public class MallFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    private FragmentMallBinding binding;
    private com.example.mycafe.databinding.FragmentMallBinding fragmentMallBinding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentMallBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //Toast.makeText(getContext(),"This is mall fragment",Toast.LENGTH_LONG).show();
        return inflater.inflate(R.layout.fragment_mall, null);
        //return root;


    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Spinner spinner = (Spinner) getView().findViewById(R.id.planets_spinner);
        // Spinner spinner = (Spinner) FindViewById(R.id.planets_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout

        fragmentMallBinding = this.binding;
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(binding.getRoot().getContext(), R.array.planets_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);
    }
    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        ImageView img = (ImageView) getView().findViewById(R.id.planet_imageView);
        // img.setImageResource(R.drawable.mercury);

        switch(pos) {
            case 0:
                img.setImageResource(R.drawable.drink1); break;
            case 1:
                img.setImageResource(R.drawable.drink2); break;
            case 2:
                img.setImageResource(R.drawable.drink3); break;
            case 3:
                img.setImageResource(R.drawable.drink4); break;

        }
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}