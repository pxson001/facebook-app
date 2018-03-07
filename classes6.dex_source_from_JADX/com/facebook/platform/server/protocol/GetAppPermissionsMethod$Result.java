package com.facebook.platform.server.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.collect.Lists;
import java.util.List;

/* compiled from: fetch_real_story_ */
public class GetAppPermissionsMethod$Result implements Parcelable {
    public static final Creator<GetAppPermissionsMethod$Result> CREATOR = new C09871();
    public final boolean f14937a;
    public final List<String> f14938b;

    /* compiled from: fetch_real_story_ */
    final class C09871 implements Creator<GetAppPermissionsMethod$Result> {
        C09871() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GetAppPermissionsMethod$Result(parcel);
        }

        public final Object[] newArray(int i) {
            return new GetAppPermissionsMethod$Result[i];
        }
    }

    public GetAppPermissionsMethod$Result(boolean z, List<String> list) {
        this.f14937a = z;
        this.f14938b = list;
    }

    public GetAppPermissionsMethod$Result(Parcel parcel) {
        boolean z = true;
        if (parcel.readByte() != (byte) 1) {
            z = false;
        }
        this.f14937a = z;
        this.f14938b = Lists.a();
        parcel.readStringList(this.f14938b);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte((byte) (this.f14937a ? 1 : 0));
        parcel.writeStringList(this.f14938b);
    }
}
