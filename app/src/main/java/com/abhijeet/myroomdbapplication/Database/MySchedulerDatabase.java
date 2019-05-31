package com.abhijeet.myroomdbapplication.Database;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.abhijeet.myroomdbapplication.Database.DBDaos.NotificationsModelDao;
import com.abhijeet.myroomdbapplication.Database.DBModels.NotificationModel;
/**
 * The type Parapay database.
 */
@Database(entities = {NotificationModel.class}, version = 1, exportSchema = false)
public abstract class MySchedulerDatabase extends RoomDatabase {
    private static MySchedulerDatabase INSTANCE;

    /**
     * Gets app database.
     *
     * @param context the context
     * @return the app database
     */
    public static MySchedulerDatabase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), MySchedulerDatabase.class, "MySchedulerDatabase")
                            .allowMainThreadQueries()
                            .build();
        }
        return INSTANCE;
    }

    /**
     * Destroy instance.
     */
    public static void destroyInstance() {
        INSTANCE = null;
    }

    /**
     * Notifications model dao notifications model dao.
     *
     * @return the notifications model dao
     */
    public abstract NotificationsModelDao notificationsModelDao();
}