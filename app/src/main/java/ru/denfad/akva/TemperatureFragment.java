package ru.denfad.akva;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class TemperatureFragment extends Fragment {

    public TemperatureFragment(){}

    public static TemperatureFragment newInstance(){
        return new TemperatureFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.temperature_fragment, container, false);


        return rootView;
    }
}
