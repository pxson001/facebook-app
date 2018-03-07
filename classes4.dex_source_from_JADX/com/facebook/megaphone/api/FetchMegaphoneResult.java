package com.facebook.megaphone.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.fbservice.results.BaseResult;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.GraphQLMegaphone;
import javax.annotation.Nullable;

/* compiled from: fbns_lite/ */
public class FetchMegaphoneResult extends BaseResult implements Parcelable {
    public static final Creator<FetchMegaphoneResult> CREATOR = new C05811();
    @Nullable
    public final GraphQLMegaphone f11971a;

    /* compiled from: fbns_lite/ */
    final class C05811 implements Creator<FetchMegaphoneResult> {
        C05811() {
        }

        public final Object[] newArray(int i) {
            return new FetchMegaphoneResult[0];
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchMegaphoneResult(parcel);
        }
    }

    public FetchMegaphoneResult(@Nullable GraphQLMegaphone graphQLMegaphone, DataFreshnessResult dataFreshnessResult, long j) {
        super(dataFreshnessResult, j);
        this.f11971a = graphQLMegaphone;
    }

    public FetchMegaphoneResult(Parcel parcel) {
        super(parcel);
        this.f11971a = (GraphQLMegaphone) FlatBufferModelHelper.a(parcel);
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        FlatBufferModelHelper.a(parcel, this.f11971a);
    }

    public int describeContents() {
        return 0;
    }
}
