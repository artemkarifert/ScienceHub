package com.tsg.test.ui.notifications;

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

public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                ViewModelProviders.of(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);


        ImageView imageView = root.findViewById(R.id.game);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent((MainActivity)getContext(), Descpiption.class);
                intent.putExtra("name", "УмДва");
                intent.putExtra("descpiption", "Простейшие математические примеры вызывают" +
                        " желание потянуться к калькулятору? С помощью этой игры вы научитесь щелкать" +
                        " примеры как орешки и стать самым настоящим знатоком!");

                startActivity(intent);
            }
        });

        return root;
    }
}