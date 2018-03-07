package com.facebook.megaphone.fetcher;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.fbservice.results.BaseResult;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.GraphQLMegaphone;
import javax.annotation.Nullable;

/* compiled from: ttype */
public class MegaphoneWithLayoutResult extends BaseResult implements Parcelable {
    public static final Creator<MegaphoneWithLayoutResult> CREATOR = new C01261();
    @Nullable
    public final GraphQLMegaphone f1304a;
    @Nullable
    public final String f1305b;

    /* compiled from: ttype */
    final class C01261 implements Creator<MegaphoneWithLayoutResult> {
        C01261() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new MegaphoneWithLayoutResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new MegaphoneWithLayoutResult[i];
        }
    }

    public MegaphoneWithLayoutResult(Parcel parcel) {
        super(parcel);
        this.f1304a = (GraphQLMegaphone) FlatBufferModelHelper.a(parcel);
        this.f1305b = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        FlatBufferModelHelper.a(parcel, this.f1304a);
        parcel.writeString(this.f1305b);
    }

    public int describeContents() {
        return 0;
    }
}
