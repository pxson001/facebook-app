package com.facebook.messaging.business.attachments.model;

import android.net.Uri;
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
/* compiled from: view_holder */
public class PlatformGenericAttachmentItem implements Parcelable {
    public static final Creator<PlatformGenericAttachmentItem> CREATOR = new C00611();
    public final String f447a;
    public final String f448b;
    @Nullable
    public final String f449c;
    @Nullable
    public final Uri f450d;
    @Nullable
    public final String f451e;
    public final int f452f;
    @Nullable
    public final String f453g;
    @Nullable
    public final String f454h;
    @Nullable
    public final String f455i;
    @Nullable
    public final String f456j;
    public final ImmutableList<CallToAction> f457k;
    @Nullable
    public final Uri f458l;
    @Nullable
    public final Uri f459m;

    /* compiled from: view_holder */
    final class C00611 implements Creator<PlatformGenericAttachmentItem> {
        C00611() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PlatformGenericAttachmentItem(parcel);
        }

        public final Object[] newArray(int i) {
            return new PlatformGenericAttachmentItem[i];
        }
    }

    public PlatformGenericAttachmentItem(PlatformGenericAttachmentItemBuilder platformGenericAttachmentItemBuilder) {
        this.f447a = (String) Preconditions.checkNotNull(platformGenericAttachmentItemBuilder.f460a);
        this.f448b = (String) Preconditions.checkNotNull(platformGenericAttachmentItemBuilder.f461b);
        this.f449c = platformGenericAttachmentItemBuilder.f462c;
        this.f450d = platformGenericAttachmentItemBuilder.f463d;
        this.f451e = platformGenericAttachmentItemBuilder.f464e;
        this.f452f = platformGenericAttachmentItemBuilder.f465f;
        this.f453g = platformGenericAttachmentItemBuilder.f466g;
        this.f454h = platformGenericAttachmentItemBuilder.f467h;
        this.f455i = platformGenericAttachmentItemBuilder.f468i;
        this.f456j = platformGenericAttachmentItemBuilder.f469j;
        Collection collection = platformGenericAttachmentItemBuilder.f470k;
        if (collection == null) {
            collection = Collections.EMPTY_LIST;
        }
        this.f457k = ImmutableList.copyOf(collection);
        this.f458l = platformGenericAttachmentItemBuilder.f471l;
        this.f459m = platformGenericAttachmentItemBuilder.f472m;
    }

    public PlatformGenericAttachmentItem(Parcel parcel) {
        this.f447a = parcel.readString();
        this.f448b = parcel.readString();
        this.f449c = parcel.readString();
        this.f450d = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f451e = parcel.readString();
        this.f452f = parcel.readInt();
        this.f453g = parcel.readString();
        this.f454h = parcel.readString();
        this.f455i = parcel.readString();
        this.f456j = parcel.readString();
        Collection readArrayList = parcel.readArrayList(CallToAction.class.getClassLoader());
        if (readArrayList == null) {
            readArrayList = Collections.EMPTY_LIST;
        }
        this.f457k = ImmutableList.copyOf(readArrayList);
        this.f458l = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f459m = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f447a);
        parcel.writeString(this.f448b);
        parcel.writeString(this.f449c);
        parcel.writeParcelable(this.f450d, i);
        parcel.writeString(this.f451e);
        parcel.writeInt(this.f452f);
        parcel.writeString(this.f453g);
        parcel.writeString(this.f454h);
        parcel.writeString(this.f455i);
        parcel.writeString(this.f456j);
        parcel.writeList(this.f457k);
        parcel.writeParcelable(this.f458l, i);
        parcel.writeParcelable(this.f459m, i);
    }
}
