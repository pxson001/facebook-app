package com.facebook.messaging.notify;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.MessageUtil;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.GroupMessageInfo;
import com.facebook.messaging.notify.NewMessageNotification.MessengerUserStatus;
import com.facebook.messaging.notify.NewMessageNotification.PresenceLevel;
import com.facebook.messaging.push.ServerMessageAlertFlags;
import com.facebook.push.PushProperty;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: invoice */
public class NewEphemeralMessageNotification extends NewMessageNotification {
    public static final Creator<NewEphemeralMessageNotification> CREATOR = new C14311();
    public final long f12742a;

    /* compiled from: invoice */
    final class C14311 implements Creator<NewEphemeralMessageNotification> {
        C14311() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new NewEphemeralMessageNotification(parcel);
        }

        public final Object[] newArray(int i) {
            return new NewEphemeralMessageNotification[i];
        }
    }

    public NewEphemeralMessageNotification(@Nullable String str, Message message, ThreadKey threadKey, @Nullable GroupMessageInfo groupMessageInfo, @Nullable PresenceLevel presenceLevel, PushProperty pushProperty, @Nullable AlertDisposition alertDisposition, ServerMessageAlertFlags serverMessageAlertFlags, MessengerUserStatus messengerUserStatus) {
        super(str, message, threadKey, groupMessageInfo, presenceLevel, pushProperty, alertDisposition, serverMessageAlertFlags, messengerUserStatus);
        Preconditions.checkArgument(MessageUtil.V(message));
        this.f12742a = ((long) message.J.intValue()) + message.c;
    }

    public NewEphemeralMessageNotification(Parcel parcel) {
        super(parcel);
        this.f12742a = parcel.readLong();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeLong(this.f12742a);
    }

    public final int mo505a() {
        return 10023;
    }
}
