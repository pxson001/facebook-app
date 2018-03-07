package com.facebook.messaging.notify;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.GroupMessageInfo;
import com.facebook.messaging.notify.NewMessageNotification.MessengerUserStatus;
import com.facebook.messaging.notify.NewMessageNotification.PresenceLevel;
import com.facebook.messaging.push.ServerMessageAlertFlags;
import com.facebook.push.PushProperty;
import javax.annotation.Nullable;

/* compiled from: irisSeqId */
public class NewDefaultMessageNotification extends NewMessageNotification {
    public static final Creator<NewMessageNotification> CREATOR = new C14301();

    /* compiled from: irisSeqId */
    final class C14301 implements Creator<NewMessageNotification> {
        C14301() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new NewDefaultMessageNotification(parcel);
        }

        public final Object[] newArray(int i) {
            return new NewMessageNotification[i];
        }
    }

    public NewDefaultMessageNotification(@Nullable String str, Message message, ThreadKey threadKey, @Nullable GroupMessageInfo groupMessageInfo, @Nullable PresenceLevel presenceLevel, PushProperty pushProperty, @Nullable AlertDisposition alertDisposition, ServerMessageAlertFlags serverMessageAlertFlags, MessengerUserStatus messengerUserStatus) {
        super(str, message, threadKey, groupMessageInfo, presenceLevel, pushProperty, alertDisposition, serverMessageAlertFlags, messengerUserStatus);
    }

    public NewDefaultMessageNotification(Parcel parcel) {
        super(parcel);
    }

    public final int mo505a() {
        return 10000;
    }
}
