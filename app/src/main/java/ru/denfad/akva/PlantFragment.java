package ru.denfad.akva;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

public class PlantFragment extends Fragment {

    private String[] names = {"Базилик","Кресс-салат","Мята","Базилик","Базилик","Кресс-салат","Мята","Мята","Базилик","Мята","Кресс-салат"};
    private int[] age = {1,1,1,2,3,3,3,3,4,4,4,5,5,6,7};
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
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.ageView.setText("До зрелости "+age[position]+" дня(ей)");
            holder.nameView.setText(names[position]);
        }

        @Override
        public int getItemCount() {
            return names.length;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            public final TextView nameView, ageView;
            ViewHolder(View view){
                super(view);
                nameView = (TextView) view.findViewById(R.id.leaf_name);
                ageView = (TextView) view.findViewById(R.id.leaf_age);
            }
        }
    }
}
