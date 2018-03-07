package com.facebook.share.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.share.model.ShareContent;

/* compiled from: oups/gridtab */
public class ShareFeedContent extends ShareContent<ShareFeedContent, Object> {
    public static final Creator<ShareFeedContent> CREATOR = new C06161();
    private final String f4571a;
    private final String f4572b;
    private final String f4573c;
    private final String f4574d;
    private final String f4575e;
    private final String f4576f;
    private final String f4577g;

    /* compiled from: oups/gridtab */
    final class C06161 implements Creator<ShareFeedContent> {
        C06161() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ShareFeedContent(parcel);
        }

        public final Object[] newArray(int i) {
            return new ShareFeedContent[i];
        }
    }

    ShareFeedContent(Parcel parcel) {
        super(parcel);
        this.f4571a = parcel.readString();
        this.f4572b = parcel.readString();
        this.f4573c = parcel.readString();
        this.f4574d = parcel.readString();
        this.f4575e = parcel.readString();
        this.f4576f = parcel.readString();
        this.f4577g = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f4571a);
        parcel.writeString(this.f4572b);
        parcel.writeString(this.f4573c);
        parcel.writeString(this.f4574d);
        parcel.writeString(this.f4575e);
        parcel.writeString(this.f4576f);
        parcel.writeString(this.f4577g);
    }
}
