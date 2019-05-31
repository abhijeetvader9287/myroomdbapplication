package com.abhijeet.myroomdbapplication.Database.DBDaos;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.abhijeet.myroomdbapplication.Database.DBModels.NotificationModel;

import java.util.List;
/**
 * The interface Notifications model dao.
 */
@Dao
public interface NotificationsModelDao {
    /**
     * Insert message data long.
     *
     * @param obj the obj
     * @return the long
     */
    @Insert
    long insertMessageData(NotificationModel obj);
    /**
     * Update message.
     *
     * @param obj the obj
     */
    @Update
    public void updateMessage(NotificationModel obj);
    /**
     * Gets all notification.
     *
     * @return the all notification
     */
    @Query("SELECT * FROM NotificationModel ORDER BY id ASC")
    List<NotificationModel> getAllNotification();
    /**
     * Gets messages.
     *
     * @param isMessage the is message
     * @return the messages
     */
    @Query("SELECT * FROM NotificationModel WHERE NotificationModel.isMessage=:isMessage ORDER BY id DESC ")
    List<NotificationModel> getMessages(int isMessage);
    /**
     * Gets notification object.
     *
     * @param id the id
     * @return the notification object
     */
    @Query("SELECT * FROM NotificationModel WHERE id LIKE :id ")
    NotificationModel getNotificationObject(int id);
    /**
     * Delete notification model.
     *
     * @param obj the obj
     */
    @Delete
    void deleteNotificationModel(NotificationModel obj);
    /**
     * Delete older.
     *
     * @param tendaysbefore the tendaysbefore
     */
    @Query("Delete   FROM NotificationModel WHERE NotificationModel.date<=:tendaysbefore  ")
    void deleteOlder(long tendaysbefore);
    /**
     * Delete all.
     */
    @Query("Delete   FROM NotificationModel")
    void deleteAll();
}