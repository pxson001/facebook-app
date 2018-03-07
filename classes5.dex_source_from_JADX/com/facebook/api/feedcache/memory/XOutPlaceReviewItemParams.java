package com.facebook.api.feedcache.memory;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.GraphQLPlaceReviewFeedUnit;
import com.facebook.graphql.model.GraphQLPlaceReviewFeedUnitItem;
import com.facebook.graphql.model.ItemListFeedUnitImpl;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.annotation.Nullable;

/* compiled from: approximate_new_unit_count */
public class XOutPlaceReviewItemParams implements Parcelable {
    public static final Creator<?> CREATOR = new C09591();
    public final String f8827a;
    public final GraphQLPlaceReviewFeedUnit f8828b;
    public final ImmutableList<String> f8829c;

    /* compiled from: approximate_new_unit_count */
    final class C09591 implements Creator<XOutPlaceReviewItemParams> {
        C09591() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new XOutPlaceReviewItemParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new XOutPlaceReviewItemParams[i];
        }
    }

    public XOutPlaceReviewItemParams(Parcel parcel) {
        this.f8827a = parcel.readString();
        this.f8828b = (GraphQLPlaceReviewFeedUnit) FlatBufferModelHelper.m4278a(parcel);
        this.f8829c = ImmutableList.copyOf(parcel.createStringArrayList());
    }

    public XOutPlaceReviewItemParams(String str, @Nullable GraphQLPlaceReviewFeedUnit graphQLPlaceReviewFeedUnit) {
        this.f8827a = str;
        this.f8828b = graphQLPlaceReviewFeedUnit;
        Builder builder = ImmutableList.builder();
        if (graphQLPlaceReviewFeedUnit != null) {
            ImmutableList a = ItemListFeedUnitImpl.a(graphQLPlaceReviewFeedUnit);
            int size = a.size();
            for (int i = 0; i < size; i++) {
                builder.c(((GraphQLPlaceReviewFeedUnitItem) a.get(i)).m20904l().ae());
            }
        }
        this.f8829c = builder.b();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f8827a);
        FlatBufferModelHelper.m4288a(parcel, this.f8828b);
        parcel.writeStringList(this.f8829c);
    }
}
