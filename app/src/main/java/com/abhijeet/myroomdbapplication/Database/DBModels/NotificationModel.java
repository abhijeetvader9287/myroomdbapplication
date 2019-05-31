package com.abhijeet.myroomdbapplication.Database.DBModels;
import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;
/**
 * The type Notification model.
 */
@Entity(tableName = "NotificationModel")
public class NotificationModel implements Parcelable {
    /**
     * The constant CREATOR.
     */
    public static final Creator<NotificationModel> CREATOR = new Creator<NotificationModel>() {
        @Override
        public NotificationModel createFromParcel(Parcel in) {
            return new NotificationModel(in);
        }

        @Override
        public NotificationModel[] newArray(int size) {
            return new NotificationModel[size];
        }
    };
    /**
     * The Id.
     */
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    int id;
    /**
     * The Notification id.
     */
    @ColumnInfo(name = "notificationId")
    int notificationId;
    /**
     * The Title.
     */
    @ColumnInfo(name = "title")
    String title;
    /**
     * The Message.
     */
    @ColumnInfo(name = "message")
    String message;
    /**
     * The Date.
     */
    @ColumnInfo(name = "date")
    long date;
    /**
     * The Type.
     */
    @ColumnInfo(name = "type")
    String type;
    /**
     * The Is message.
     */
    @ColumnInfo(name = "isMessage")
    boolean isMessage;
    /**
     * The Image url.
     */
    @ColumnInfo(name = "imageUrl")
    String imageUrl;
    /**
     * The Details.
     */
    @ColumnInfo(name = "details")
    String details;

    /**
     * Instantiates a new Notification model.
     */
    public NotificationModel() {
    }

    /**
     * Instantiates a new Notification model.
     *
     * @param in the in
     */
    protected NotificationModel(Parcel in) {
        id = in.readInt();
        notificationId = in.readInt();
        title = in.readString();
        message = in.readString();
        date = in.readLong();
        type = in.readString();
        isMessage = in.readByte() != 0;
        imageUrl = in.readString();
        details = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(notificationId);
        dest.writeString(title);
        dest.writeString(message);
        dest.writeLong(date);
        dest.writeString(type);
        dest.writeByte((byte) (isMessage ? 1 : 0));
        dest.writeString(imageUrl);
        dest.writeString(details);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets notification id.
     *
     * @return the notification id
     */
    public int getNotificationId() {
        return notificationId;
    }

    /**
     * Sets notification id.
     *
     * @param notificationId the notification id
     */
    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }

    /**
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets title.
     *
     * @param title the title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Gets date.
     *
     * @return the date
     */
    public long getDate() {
        return date;
    }

    /**
     * Sets date.
     *
     * @param date the date
     */
    public void setDate(long date) {
        this.date = date;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Is message boolean.
     *
     * @return the boolean
     */
    public boolean isMessage() {
        return isMessage;
    }

    /**
     * Sets message.
     *
     * @param message the message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Sets is message.
     *
     * @param message the message
     */
    public void setIsMessage(boolean message) {
        isMessage = message;
    }

    /**
     * Gets image url.
     *
     * @return the image url
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * Sets image url.
     *
     * @param imageUrl the image url
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * Gets details.
     *
     * @return the details
     */
    public String getDetails() {
        return details;
    }

    /**
     * Sets details.
     *
     * @param details the details
     */
    public void setDetails(String details) {
        this.details = details;
    }
}