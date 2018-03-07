package com.facebook.messaging.attachments;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.facebook.ui.media.attachments.MediaResource;
import com.google.common.base.Preconditions;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: p2p_cancel_edit_card */
public class OtherAttachmentData implements Parcelable {
    public static final Creator<OtherAttachmentData> CREATOR = new C08571();
    public final String f7752a;
    public final String f7753b;
    public final int f7754c;
    @Nullable
    public final MediaResource f7755d;
    public final String f7756e;
    @Nullable
    public final String f7757f;

    /* compiled from: p2p_cancel_edit_card */
    final class C08571 implements Creator<OtherAttachmentData> {
        C08571() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new OtherAttachmentData(parcel);
        }

        public final Object[] newArray(int i) {
            return new OtherAttachmentData[i];
        }
    }

    public static OtherAttachmentDataBuilder newBuilder() {
        return new OtherAttachmentDataBuilder();
    }

    OtherAttachmentData(OtherAttachmentDataBuilder otherAttachmentDataBuilder) {
        this.f7752a = (String) Preconditions.checkNotNull(otherAttachmentDataBuilder.f7758a);
        this.f7753b = (String) Preconditions.checkNotNull(otherAttachmentDataBuilder.f7759b);
        this.f7755d = otherAttachmentDataBuilder.f7760c;
        this.f7756e = (String) Preconditions.checkNotNull(otherAttachmentDataBuilder.f7761d);
        this.f7757f = otherAttachmentDataBuilder.f7762e;
        this.f7754c = ((Integer) Preconditions.checkNotNull(Integer.valueOf(otherAttachmentDataBuilder.f7763f.intValue()))).intValue();
    }

    public OtherAttachmentData(Parcel parcel) {
        this.f7752a = parcel.readString();
        this.f7753b = parcel.readString();
        this.f7755d = (MediaResource) parcel.readParcelable(MediaResource.class.getClassLoader());
        this.f7756e = parcel.readString();
        this.f7757f = parcel.readString();
        this.f7754c = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7752a);
        parcel.writeString(this.f7753b);
        parcel.writeParcelable(this.f7755d, i);
        parcel.writeString(this.f7756e);
        parcel.writeString(this.f7757f);
        parcel.writeInt(this.f7754c);
    }
}
