package com.facebook.messaging.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.ParticipantInfo;
import com.facebook.user.model.UserIdentifier;
import com.google.common.collect.ImmutableList;
import java.util.List;

/* compiled from: contact_info_form_fragment_tag */
public class SendMessageByRecipientsParams implements Parcelable {
    public static final Creator<SendMessageByRecipientsParams> CREATOR = new C20571();
    public final String f17304a;
    public final Message f17305b;
    public final ImmutableList<UserIdentifier> f17306c;
    public boolean f17307d = false;

    /* compiled from: contact_info_form_fragment_tag */
    final class C20571 implements Creator<SendMessageByRecipientsParams> {
        C20571() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SendMessageByRecipientsParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new SendMessageByRecipientsParams[i];
        }
    }

    public SendMessageByRecipientsParams(String str, Message message, List<UserIdentifier> list) {
        this.f17304a = str;
        this.f17305b = message;
        this.f17306c = ImmutableList.copyOf(list);
    }

    public SendMessageByRecipientsParams(Parcel parcel) {
        this.f17304a = parcel.readString();
        this.f17305b = (Message) parcel.readParcelable(Message.class.getClassLoader());
        this.f17306c = ImmutableList.copyOf(parcel.readArrayList(ParticipantInfo.class.getClassLoader()));
    }

    public final Message m17178a() {
        return this.f17305b;
    }

    public final boolean m17179d() {
        return this.f17307d;
    }

    public final ImmutableList<UserIdentifier> m17180e() {
        return this.f17306c;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f17304a);
        parcel.writeParcelable(this.f17305b, i);
        parcel.writeList(this.f17306c);
    }
}
