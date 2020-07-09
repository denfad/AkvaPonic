package ru.denfad.akva;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class PlantFragment extends Fragment {

    private Repository repository = Repository.getInstance();

    public PlantFragment(){}

    public static PlantFragment newInstance(){
        return new PlantFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.leaf_fragment, container, false);

        RecyclerView list = rootView.findViewById(R.id.leaf_list);
        PlantAdapter plantAdapter = new PlantAdapter(getContext());
        list.setAdapter(plantAdapter);

        FloatingActionButton add = rootView.findViewById(R.id.add_plant);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(PlantProfileFragment.newInstance(null));
            }
        });
        return rootView;
    }

    private class PlantAdapter extends RecyclerView.Adapter<PlantAdapter.ViewHolder>{

        private LayoutInflater inflater;

        PlantAdapter(Context context){
            this.inflater = LayoutInflater.from(context);
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = inflater.inflate(R.layout.leaf_item, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
            holder.ageView.setText("До зрелости "+repository.getPlant(position).getStay()+" дня(ей)");
            holder.nameView.setText(repository.getPlant(position).getName());
            holder.card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    loadFragment(PlantProfileFragment.newInstance(repository.getPlant(position)));
                }
            });
        }

        @Override
        public int getItemCount() {
            return repository.getSizePlants();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            public final TextView nameView, ageView;
            public final CardView card;
            ViewHolder(View view){
                super(view);
                nameView = (TextView) view.findViewById(R.id.leaf_name);
                ageView = (TextView) view.findViewById(R.id.leaf_age);
                card = view.findViewById(R.id.plant_card);
            }
        }
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.replace(R.id.fl_content, fragment);
        ft.commit();
    }
}
