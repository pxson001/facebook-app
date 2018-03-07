package com.facebook.pages.app.data.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.fbservice.results.BaseResult;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.GraphQLNode;
import com.google.common.base.Objects;

/* compiled from: surface_first_card_cached_early_fetch */
public class FetchPageContactResult extends BaseResult implements Parcelable {
    public static final Creator<FetchPageContactResult> CREATOR = new C01631();
    private final GraphQLNode f1210a;

    /* compiled from: surface_first_card_cached_early_fetch */
    final class C01631 implements Creator<FetchPageContactResult> {
        C01631() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchPageContactResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchPageContactResult[i];
        }
    }

    public FetchPageContactResult(Parcel parcel) {
        super(parcel);
        this.f1210a = (GraphQLNode) FlatBufferModelHelper.a(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        FlatBufferModelHelper.a(parcel, this.f1210a);
    }

    public String toString() {
        return Objects.toStringHelper(this).toString();
    }
}
