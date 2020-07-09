package ru.denfad.akva;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import ru.denfad.akva.models.Fish;
import ru.denfad.akva.models.Plant;

public class PlantProfileFragment extends Fragment {

    private Plant plant;
    private Repository repository = Repository.getInstance();

    public PlantProfileFragment(Plant plant){
        this.plant = plant;
    }

    public static PlantProfileFragment newInstance(Plant plant){
        return new PlantProfileFragment(plant);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.plant_profile_fragment, container, false);
        final EditText name = rootView.findViewById(R.id.plant_name);
        final EditText date = rootView.findViewById(R.id.plant_date);
        final EditText stay = rootView.findViewById(R.id.plant_stay);
        final EditText deviants = rootView.findViewById(R.id.plant_about);
        final ImageButton back = rootView.findViewById(R.id.back);

        if(plant!=null){
            name.setText(plant.getName());
            name.setKeyListener(null);
            date.setText("День посадки: "+plant.getDate());
            date.setKeyListener(null);
            stay.setText("До зрелости: "+plant.getStay()+" дней");
            stay.setKeyListener(null);
            deviants.setText("Дефекты: "+plant.getDeviants());
            deviants.setKeyListener(null);
        }

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(PlantFragment.newInstance());
                if(plant==null){
                    if(!name.getText().toString().equals("")) repository.addPlant(new Plant(name.getText().toString(),date.getText().toString(), Integer.valueOf(stay.getText().toString()),deviants.getText().toString()));
                }
            }
        });
        return rootView;
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.replace(R.id.fl_content, fragment);
        ft.commit();
    }
}
