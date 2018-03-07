package com.facebook.messaging.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.messaging.model.messages.MessageDraft;
import com.facebook.messaging.model.threadkey.ThreadKey;

/* compiled from: contact_upload_session_close */
public class SaveDraftParams implements Parcelable {
    public static final Creator<SaveDraftParams> CREATOR = new C20501();
    public final ThreadKey f17281a;
    public final MessageDraft f17282b;

    /* compiled from: contact_upload_session_close */
    final class C20501 implements Creator<SaveDraftParams> {
        C20501() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SaveDraftParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new SaveDraftParams[i];
        }
    }

    public SaveDraftParams(ThreadKey threadKey, MessageDraft messageDraft) {
        this.f17281a = threadKey;
        this.f17282b = messageDraft;
    }

    SaveDraftParams(Parcel parcel) {
        this.f17281a = (ThreadKey) parcel.readParcelable(ThreadKey.class.getClassLoader());
        this.f17282b = (MessageDraft) parcel.readParcelable(MessageDraft.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f17281a, i);
        parcel.writeParcelable(this.f17282b, i);
    }
}
