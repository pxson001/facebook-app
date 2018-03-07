package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.share.model.ShareOpenGraphAction.Builder;

/* compiled from: open_friend_view */
public final class ShareOpenGraphContent extends ShareContent<ShareOpenGraphContent, Object> {
    public static final Creator<ShareOpenGraphContent> CREATOR = new C06221();
    private final ShareOpenGraphAction f4598a;
    private final String f4599b;

    /* compiled from: open_friend_view */
    final class C06221 implements Creator<ShareOpenGraphContent> {
        C06221() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ShareOpenGraphContent(parcel);
        }

        public final Object[] newArray(int i) {
            return new ShareOpenGraphContent[i];
        }
    }

    ShareOpenGraphContent(Parcel parcel) {
        super(parcel);
        this.f4598a = new ShareOpenGraphAction(new Builder().m5828a(parcel));
        this.f4599b = parcel.readString();
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.f4598a, 0);
        parcel.writeString(this.f4599b);
    }
}
