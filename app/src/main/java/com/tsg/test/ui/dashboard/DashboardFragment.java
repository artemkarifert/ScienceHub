package com.tsg.test.ui.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.tsg.test.Descpiption;
import com.tsg.test.MainActivity;
import com.tsg.test.R;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        ImageView firstMode = root.findViewById(R.id.imageView6);
        firstMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent((MainActivity)getContext(), Descpiption.class);
                intent.putExtra("name", "Стрик");
                intent.putExtra("descpiption", "На протяжении всей игры будут подкидываться" +
                        " разные вопросы из абсолютно разных тематик. Будьте на чеку и продержитесь" +
                        " как можно дольше!");
                intent.putExtra("path", 2);
                startActivity(intent);
            }
        });
        
        return root;
    }
}