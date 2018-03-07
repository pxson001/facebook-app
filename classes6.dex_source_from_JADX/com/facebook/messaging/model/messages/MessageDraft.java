package com.facebook.messaging.model.messages;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.ui.media.attachments.MediaResource;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.List;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: upload_settings_version */
public class MessageDraft implements Parcelable {
    public static final Creator<MessageDraft> CREATOR = new C00961();
    public final String f2102a;
    public final int f2103b;
    public final List<MediaResource> f2104c;
    public final String f2105d;

    /* compiled from: upload_settings_version */
    final class C00961 implements Creator<MessageDraft> {
        C00961() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new MessageDraft(parcel);
        }

        public final Object[] newArray(int i) {
            return new MessageDraft[i];
        }
    }

    public MessageDraft(Parcel parcel) {
        this.f2102a = parcel.readString();
        this.f2103b = parcel.readInt();
        this.f2104c = parcel.readArrayList(MediaResource.class.getClassLoader());
        this.f2105d = parcel.readString();
    }

    public MessageDraft(String str, int i, List<MediaResource> list, String str2) {
        Preconditions.checkNotNull(list);
        this.f2102a = str;
        this.f2103b = i;
        this.f2104c = list;
        this.f2105d = str2;
    }

    public MessageDraft(String str, int i, String str2) {
        this.f2102a = str;
        this.f2103b = i;
        this.f2104c = Lists.a();
        this.f2105d = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MessageDraft)) {
            return false;
        }
        MessageDraft messageDraft = (MessageDraft) obj;
        if (Objects.equal(this.f2102a, messageDraft.f2102a) && Objects.equal(this.f2104c, messageDraft.f2104c) && Objects.equal(this.f2105d, messageDraft.f2105d) && this.f2103b == messageDraft.f2103b) {
            return true;
        }
        return false;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2102a);
        parcel.writeInt(this.f2103b);
        parcel.writeList(this.f2104c);
        parcel.writeString(this.f2105d);
    }
}
