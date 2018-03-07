package com.facebook.messaging.notify;

import android.os.Parcel;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.GroupMessageInfo;
import com.facebook.messaging.notify.MessagingNotification.Type;
import com.facebook.messaging.push.ServerMessageAlertFlags;
import com.facebook.push.PushProperty;
import com.facebook.push.PushSource;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: invoice_id */
public abstract class NewMessageNotification extends MessagingNotification {
    public final String f12733b;
    public final Message f12734c;
    @Nullable
    public final ThreadKey f12735d;
    public final GroupMessageInfo f12736e;
    public final PresenceLevel f12737f;
    public final PushProperty f12738g;
    public final AlertDisposition f12739h;
    public final ServerMessageAlertFlags f12740i;
    public final MessengerUserStatus f12741k;

    /* compiled from: invoice_id */
    public enum MessengerUserStatus {
        IS_MESSENGER_USER,
        IS_NOT_MESSENGER_USER,
        UNKNOWN
    }

    /* compiled from: invoice_id */
    public enum PresenceLevel {
        IN_APP_ACTIVE_10S,
        IN_APP_ACTIVE_30S,
        IN_APP_IDLE,
        NOT_IN_APP
    }

    public abstract int mo505a();

    NewMessageNotification(@Nullable String str, Message message, ThreadKey threadKey, @Nullable GroupMessageInfo groupMessageInfo, @Nullable PresenceLevel presenceLevel, PushProperty pushProperty, @Nullable AlertDisposition alertDisposition, ServerMessageAlertFlags serverMessageAlertFlags, MessengerUserStatus messengerUserStatus) {
        super(Type.NEW_MESSAGE);
        this.f12733b = str;
        this.f12734c = message;
        this.f12735d = threadKey;
        this.f12736e = groupMessageInfo;
        this.f12737f = presenceLevel;
        this.f12738g = pushProperty;
        this.f12739h = alertDisposition;
        this.f12740i = serverMessageAlertFlags;
        this.f12741k = messengerUserStatus;
    }

    protected NewMessageNotification(Parcel parcel) {
        super(parcel);
        this.f12733b = parcel.readString();
        this.f12734c = (Message) parcel.readParcelable(Message.class.getClassLoader());
        this.f12736e = (GroupMessageInfo) parcel.readParcelable(GroupMessageInfo.class.getClassLoader());
        this.f12737f = (PresenceLevel) parcel.readSerializable();
        this.f12738g = (PushProperty) parcel.readParcelable(PushProperty.class.getClassLoader());
        this.f12740i = (ServerMessageAlertFlags) parcel.readParcelable(ServerMessageAlertFlags.class.getClassLoader());
        this.f12739h = null;
        this.f12741k = (MessengerUserStatus) parcel.readSerializable();
        this.f12735d = ThreadKey.a(parcel.readString());
    }

    public final boolean m13125b() {
        return this.f12738g.a != PushSource.MQTT || (this.f12740i != null && this.f12740i.f16401d);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Preconditions.checkState(this.f12739h == null);
        super.m13110a(parcel);
        parcel.writeString(this.f12733b);
        parcel.writeParcelable(this.f12734c, i);
        parcel.writeParcelable(this.f12736e, i);
        parcel.writeSerializable(this.f12737f);
        parcel.writeParcelable(this.f12738g, i);
        parcel.writeParcelable(this.f12740i, i);
        parcel.writeSerializable(this.f12741k);
        parcel.writeString(this.f12735d == null ? null : this.f12735d.toString());
    }
}
