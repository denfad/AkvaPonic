package ru.denfad.akva;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.denfad.akva.models.Data;
import ru.denfad.akva.network.NetworkService;

public class TemperatureFragment extends Fragment {

    private TextView ph,temperature;

    public TemperatureFragment(){}

    public static TemperatureFragment newInstance(){
        return new TemperatureFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.temperature_fragment, container, false);

        ph = rootView.findViewById(R.id.ph);
        temperature = rootView.findViewById(R.id.temperature);

        new MyTimer(2000,1000).start();

        return rootView;
    }

    private class MyTimer extends CountDownTimer{

        /**
         * @param millisInFuture    The number of millis in the future from the call
         *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
         *                          is called.
         * @param countDownInterval The interval along the way to receive
         *                          {@link #onTick(long)} callbacks.
         */
        public MyTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            NetworkService.getInstance()
                    .getJSONApi()
                    .getDiagnoses()
                    .enqueue(new Callback<Data>() {
                        @Override
                        public void onResponse(Call<Data> call, Response<Data> response) {
                            ph.setText("Показатель PH: "+response.body().getPh());
                            temperature.setText("Температура: "+response.body().getTemperature()+"°");
                        }

                        @Override
                        public void onFailure(Call<Data> call, Throwable t) {
                            ph.setText("Показатель PH: 6.5");
                            temperature.setText("Температура: 25°");
                        }
                    });
        }

        @Override
        public void onFinish() {
            new MyTimer(2000,2000).start();
        }
    }
}
