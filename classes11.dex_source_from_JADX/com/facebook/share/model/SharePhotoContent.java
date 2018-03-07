package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: onscore */
public final class SharePhotoContent extends ShareContent<SharePhotoContent, Object> {
    public static final Creator<SharePhotoContent> CREATOR = new C06251();
    private final List<SharePhoto> f4608a;

    /* compiled from: onscore */
    final class C06251 implements Creator<SharePhotoContent> {
        C06251() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SharePhotoContent(parcel);
        }

        public final Object[] newArray(int i) {
            return new SharePhotoContent[i];
        }
    }

    SharePhotoContent(Parcel parcel) {
        super(parcel);
        List arrayList = new ArrayList();
        parcel.readTypedList(arrayList, SharePhoto.CREATOR);
        this.f4608a = Collections.unmodifiableList(arrayList);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        List<SharePhoto> list = this.f4608a;
        List arrayList = new ArrayList();
        for (SharePhoto add : list) {
            arrayList.add(add);
        }
        parcel.writeTypedList(arrayList);
    }
}
