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
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import ru.denfad.akva.models.Fish;

public class FishFragment extends Fragment {

    private boolean fishType = true;
    private Repository repository = Repository.getInstance();
    public FishFragment(){}

    public static FishFragment newInstance(){
        return new FishFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fish_fragment, container, false);

        RecyclerView list = rootView.findViewById(R.id.fish_list);
        FishAdapter fishAdapter = new FishAdapter(getContext());
        list.setAdapter(fishAdapter);

        FloatingActionButton add = rootView.findViewById(R.id.add_fish);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(FishProfileFragment.newInstance(null));
            }
        });

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
            final Fish fish = repository.getFish(position);
            holder.fishImg.setImageResource(fishType ? R.drawable.ic_fish : R.drawable.ic_fish_red);
            holder.ageView.setText("До зрелости "+fish.getStay()+" недели(я)");
            holder.nameView.setText(fish.getName());
            holder.card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    loadFragment(FishProfileFragment.newInstance(fish));
                }
            });
            if(position%2 == 0) fishType = !fishType;
        }

        @Override
        public int getItemCount() {
            return repository.getSizeFish();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            public final TextView nameView, ageView;
            public final ImageView fishImg;
            public final CardView card;
            ViewHolder(View view){
                super(view);
                nameView = (TextView) view.findViewById(R.id.fish_name);
                ageView = (TextView) view.findViewById(R.id.fish_age);
                fishImg = view.findViewById(R.id.img_fish);
                card = view.findViewById(R.id.fish_card);
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
