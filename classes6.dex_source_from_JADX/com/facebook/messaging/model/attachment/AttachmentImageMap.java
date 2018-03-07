package com.facebook.messaging.model.attachment;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.collect.ImmutableMap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: v2.6/ */
public class AttachmentImageMap implements Parcelable {
    public static final Creator<AttachmentImageMap> CREATOR = new C00761();
    public final ImmutableMap<AttachmentImageType, ImageUrl> f1882a;

    /* compiled from: v2.6/ */
    final class C00761 implements Creator<AttachmentImageMap> {
        C00761() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new AttachmentImageMap(parcel);
        }

        public final Object[] newArray(int i) {
            return new AttachmentImageMap[i];
        }
    }

    AttachmentImageMap(AttachmentImageMapBuilder attachmentImageMapBuilder) {
        this.f1882a = ImmutableMap.copyOf(attachmentImageMapBuilder.f1883a);
    }

    public AttachmentImageMap(Parcel parcel) {
        this.f1882a = ImmutableMap.copyOf(parcel.readHashMap(AttachmentImageType.class.getClassLoader()));
    }

    public static AttachmentImageMapBuilder newBuilder() {
        return new AttachmentImageMapBuilder();
    }

    @Nullable
    public final ImageUrl m3259a(AttachmentImageType attachmentImageType) {
        return (ImageUrl) this.f1882a.get(attachmentImageType);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeMap(this.f1882a);
    }
}
