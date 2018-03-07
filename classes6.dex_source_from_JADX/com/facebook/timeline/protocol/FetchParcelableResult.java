package com.facebook.timeline.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.fbservice.results.BaseResult;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;

/* compiled from: deltaAdminTextMessage */
public class FetchParcelableResult extends BaseResult implements Parcelable {
    public static final Creator<FetchParcelableResult> CREATOR = new C12871();
    public final Object f17641a;
    public final ResultSource f17642b;
    public String f17643c = null;

    /* compiled from: deltaAdminTextMessage */
    final class C12871 implements Creator<FetchParcelableResult> {
        C12871() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchParcelableResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchParcelableResult[i];
        }
    }

    public FetchParcelableResult(Parcel parcel) {
        super(parcel);
        this.f17641a = FlatBufferModelHelper.a(parcel);
        this.f17642b = (ResultSource) parcel.readParcelable(ResultSource.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        FlatBufferModelHelper.a(parcel, (Flattenable) this.f17641a);
        parcel.writeParcelable(this.f17642b, i);
    }
}
