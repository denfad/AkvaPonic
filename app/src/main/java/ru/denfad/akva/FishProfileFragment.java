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

import com.google.android.material.bottomnavigation.BottomNavigationView;

import ru.denfad.akva.models.Fish;

public class FishProfileFragment extends Fragment {

    private  Fish fish;
    private Repository repository = Repository.getInstance();

    public FishProfileFragment(Fish fish){
        this.fish = fish;
    }

    public static FishProfileFragment newInstance(Fish fish){
        return new FishProfileFragment(fish);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fish_profile_fragment, container, false);
        final EditText name = rootView.findViewById(R.id.fish_name);
        final EditText date = rootView.findViewById(R.id.fish_date);
        final EditText stay = rootView.findViewById(R.id.fish_stay);
        final EditText about = rootView.findViewById(R.id.fish_about);
        final ImageButton back = rootView.findViewById(R.id.back);

        if(fish!=null){
            name.setText(fish.getName());
            name.setKeyListener(null);
            date.setText("День рождения: "+fish.getDate());
            date.setKeyListener(null);
            stay.setText("До зрелости: "+fish.getStay()+" недель(и)");
            stay.setKeyListener(null);
            about.setText("Приметы: "+fish.getAbout());
            about.setKeyListener(null);
        }

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(FishFragment.newInstance());
                if(fish==null){
                    if(!name.getText().toString().equals("")) repository.addFish(new Fish(name.getText().toString(),date.getText().toString(), Integer.valueOf(stay.getText().toString()),about.getText().toString()));
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
