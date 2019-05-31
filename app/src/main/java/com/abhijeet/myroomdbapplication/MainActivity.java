package com.abhijeet.myroomdbapplication;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.abhijeet.myroomdbapplication.Database.DBModels.NotificationModel;
import com.abhijeet.myroomdbapplication.Database.MySchedulerDatabase;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
public class MainActivity extends AppCompatActivity {
    @BindView(R.id.recyclerView_MesssageListFragment)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        MySchedulerDatabase mDatabase;
        mDatabase = MySchedulerDatabase.getAppDatabase(this);
        NotificationModel objNotification = new NotificationModel();
        objNotification.setMessage("test");
        objNotification.setTitle("test");
        try {
            objNotification.setDate(1);
            objNotification.setDetails("test");
            objNotification.setIsMessage(true);
            objNotification.setImageUrl("test");
            objNotification.setNotificationId(1);
            objNotification.setType("test");
            long dd = mDatabase.notificationsModelDao().insertMessageData(objNotification);
            System.out.println("DB Insert : " + dd);
            ArrayList<NotificationModel> arrMessages = (ArrayList<NotificationModel>) mDatabase.notificationsModelDao().getMessages(1);
            MessageAdapter messageAdapter = new MessageAdapter(this, arrMessages);
            recyclerView.setLayoutManager(new LinearLayoutManager(this
                    , LinearLayoutManager.VERTICAL
                    , false));
            recyclerView.setAdapter(messageAdapter);
        } catch (Exception e) {
        }
    }
}
