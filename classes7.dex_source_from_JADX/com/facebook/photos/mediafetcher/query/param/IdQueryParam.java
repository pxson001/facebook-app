package com.facebook.photos.mediafetcher.query.param;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.photos.mediafetcher.interfaces.QueryParam;
import com.google.common.base.Preconditions;

/* compiled from: key_load_suggest_edits_header */
public class IdQueryParam extends QueryParam {
    public static final Creator<IdQueryParam> CREATOR = new C09021();
    public final String f10637a;

    /* compiled from: key_load_suggest_edits_header */
    final class C09021 implements Creator<IdQueryParam> {
        C09021() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new IdQueryParam(parcel.readString());
        }

        public final Object[] newArray(int i) {
            return new IdQueryParam[i];
        }
    }

    public IdQueryParam(String str) {
        this.f10637a = (String) Preconditions.checkNotNull(str);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f10637a);
    }
}
