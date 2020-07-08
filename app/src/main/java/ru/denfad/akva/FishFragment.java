package ru.denfad.akva;

import android.content.Context;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

public class FishFragment extends Fragment {

    private boolean fishType = true;
    private String[] names = {"Дима","Вика","Миша","Альберт","Антон","Ксюша","Андрей","Максим","Женя","Юра","Сергей"};
    private int[] age = {1,1,1,2,3,3,3,3,4,4,4,5,5,6,7};
    public FishFragment(){}

    public static FishFragment newInstance(){
        return new FishFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fish_fragment, container, false);

        RecyclerView list = rootView.findViewById(R.id.fish_list);
        FishAdapter fishAdapter = new FishAdapter(getContext());
        list.setAdapter(fishAdapter);

        return rootView;
    }

    private class FishAdapter extends RecyclerView.Adapter<FishAdapter.ViewHolder>{

        private LayoutInflater inflater;

        FishAdapter(Context context){
            this.inflater = LayoutInflater.from(context);
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = inflater.inflate(R.layout.fish_item, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.fishImg.setImageResource(fishType ? R.drawable.ic_fish : R.drawable.ic_fish_red);
            holder.ageView.setText("До зрелости "+age[position]+" недели(я)");
            holder.nameView.setText(names[position]);
            if(position%2 == 0) fishType = !fishType;
        }

        @Override
        public int getItemCount() {
            return names.length;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            public final TextView nameView, ageView;
            public final ImageView fishImg;
            ViewHolder(View view){
                super(view);
                nameView = (TextView) view.findViewById(R.id.fish_name);
                ageView = (TextView) view.findViewById(R.id.fish_age);
                fishImg = view.findViewById(R.id.img_fish);
            }
        }
    }
}
