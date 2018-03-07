package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: orygallerysurvey */
public abstract class ShareContent<P extends ShareContent, E> implements ShareModel {
    private final Uri f4567a;
    private final List<String> f4568b;
    private final String f4569c;
    private final String f4570d;

    protected ShareContent(Parcel parcel) {
        this.f4567a = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        List arrayList = new ArrayList();
        parcel.readStringList(arrayList);
        if (arrayList.size() == 0) {
            arrayList = null;
        } else {
            arrayList = Collections.unmodifiableList(arrayList);
        }
        this.f4568b = arrayList;
        this.f4569c = parcel.readString();
        this.f4570d = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f4567a, 0);
        parcel.writeStringList(this.f4568b);
        parcel.writeString(this.f4569c);
        parcel.writeString(this.f4570d);
    }
}
