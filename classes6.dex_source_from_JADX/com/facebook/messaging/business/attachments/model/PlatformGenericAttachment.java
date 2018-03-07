package com.facebook.messaging.business.attachments.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.messaging.business.common.calltoaction.model.CallToAction;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.Collection;
import java.util.Collections;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: viewed */
public class PlatformGenericAttachment implements Parcelable {
    public static final Creator<PlatformGenericAttachment> CREATOR = new C00601();
    public final String f437a;
    @Nullable
    public final String f438b;
    @Nullable
    public final LogoImage f439c;
    public final ImmutableList<CallToAction> f440d;
    public final PlatformGenericAttachmentItem f441e;

    /* compiled from: viewed */
    final class C00601 implements Creator<PlatformGenericAttachment> {
        C00601() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PlatformGenericAttachment(parcel);
        }

        public final Object[] newArray(int i) {
            return new PlatformGenericAttachment[i];
        }
    }

    public PlatformGenericAttachment(PlatformGenericAttachmentBuilder platformGenericAttachmentBuilder) {
        this.f437a = (String) Preconditions.checkNotNull(platformGenericAttachmentBuilder.f442a);
        this.f438b = platformGenericAttachmentBuilder.f443b;
        this.f439c = platformGenericAttachmentBuilder.f444c;
        Collection collection = platformGenericAttachmentBuilder.f445d;
        if (collection == null) {
            collection = Collections.EMPTY_LIST;
        }
        this.f440d = ImmutableList.copyOf(collection);
        this.f441e = platformGenericAttachmentBuilder.f446e;
    }

    public PlatformGenericAttachment(Parcel parcel) {
        this.f437a = parcel.readString();
        this.f438b = parcel.readString();
        this.f439c = (LogoImage) parcel.readParcelable(LogoImage.class.getClassLoader());
        Collection readArrayList = parcel.readArrayList(CallToAction.class.getClassLoader());
        if (readArrayList == null) {
            readArrayList = Collections.EMPTY_LIST;
        }
        this.f440d = ImmutableList.copyOf(readArrayList);
        this.f441e = (PlatformGenericAttachmentItem) parcel.readParcelable(PlatformGenericAttachmentItem.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f437a);
        parcel.writeString(this.f438b);
        parcel.writeParcelable(this.f439c, i);
        parcel.writeList(this.f440d);
        parcel.writeParcelable(this.f441e, i);
    }
}
