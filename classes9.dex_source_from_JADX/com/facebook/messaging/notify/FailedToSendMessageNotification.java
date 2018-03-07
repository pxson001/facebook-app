package com.facebook.messaging.notify;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.notify.MessagingNotification.Type;
import javax.annotation.Nullable;

/* compiled from: isNeeded for  */
public class FailedToSendMessageNotification extends MessagingNotification {
    public static final Creator<FailedToSendMessageNotification> CREATOR = new C14211();
    @Nullable
    public final ThreadKey f12654a;
    public final FailureReason f12655b;
    public boolean f12656c;

    /* compiled from: isNeeded for  */
    final class C14211 implements Creator<FailedToSendMessageNotification> {
        C14211() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FailedToSendMessageNotification(parcel);
        }

        public final Object[] newArray(int i) {
            return new FailedToSendMessageNotification[i];
        }
    }

    /* compiled from: isNeeded for  */
    public enum FailureReason {
        UNKNOWN,
        CAPTIVE_PORTAL,
        RESTRICTED_BACKGROUND_MODE,
        LONG_QUEUE_TIME,
        MEDIA_UPLOAD_FILE_NOT_FOUND_LOW_DISK_SPACE
    }

    public FailedToSendMessageNotification(ThreadKey threadKey, FailureReason failureReason) {
        super(Type.FAILED_TO_SEND);
        this.f12654a = threadKey;
        this.f12655b = failureReason;
    }

    public FailedToSendMessageNotification(Parcel parcel) {
        super(parcel);
        this.f12654a = ThreadKey.a(parcel.readString());
        this.f12656c = ParcelUtil.a(parcel);
        this.f12655b = (FailureReason) ParcelUtil.c(parcel, FailureReason.class);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.m13110a(parcel);
        parcel.writeString(this.f12654a == null ? "" : this.f12654a.toString());
        ParcelUtil.a(parcel, this.f12656c);
        ParcelUtil.a(parcel, this.f12655b);
    }
}
