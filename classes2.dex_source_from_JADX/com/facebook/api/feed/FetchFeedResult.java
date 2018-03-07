package com.facebook.api.feed;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.api.feed.data.FetchPortion;
import com.facebook.fbservice.results.BaseResult;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.GraphQLFeedHomeStories;
import com.facebook.graphql.model.GraphQLFeedHomeStories.Builder;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLPageInfo;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

/* compiled from: mAccessibilityDelegate */
public class FetchFeedResult extends BaseResult implements Parcelable {
    public static final Creator<FetchFeedResult> CREATOR = new C06921();
    private static final GraphQLFeedHomeStories f15755e;
    public final FetchFeedParams f15756a;
    public final GraphQLFeedHomeStories f15757b;
    public final boolean f15758c;
    public final FetchPortion f15759d;

    /* compiled from: mAccessibilityDelegate */
    final class C06921 implements Creator<FetchFeedResult> {
        C06921() {
        }

        public final Object[] newArray(int i) {
            return new FetchFeedResult[i];
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchFeedResult(parcel);
        }
    }

    static {
        Builder builder = new Builder();
        builder.f15744i = GraphQLHelper.m22460a(null, null, false, false);
        f15755e = builder.m22424a();
    }

    public FetchFeedResult(FetchFeedParams fetchFeedParams, GraphQLFeedHomeStories graphQLFeedHomeStories, DataFreshnessResult dataFreshnessResult, long j, boolean z, FetchPortion fetchPortion) {
        super(dataFreshnessResult, j);
        this.f15756a = fetchFeedParams;
        this.f15757b = graphQLFeedHomeStories;
        this.f15758c = z;
        this.f15759d = fetchPortion;
    }

    public FetchFeedResult(FetchFeedParams fetchFeedParams, GraphQLFeedHomeStories graphQLFeedHomeStories, DataFreshnessResult dataFreshnessResult, long j, boolean z) {
        this(fetchFeedParams, graphQLFeedHomeStories, dataFreshnessResult, j, z, FetchPortion.FULL);
    }

    public FetchFeedResult(FetchFeedParams fetchFeedParams, ImmutableList<GraphQLFeedUnitEdge> immutableList, GraphQLPageInfo graphQLPageInfo, String str, DataFreshnessResult dataFreshnessResult, long j, boolean z) {
        this(fetchFeedParams, new Builder().m22421a((ImmutableList) immutableList).m22420a(graphQLPageInfo).m22422a(str).m22424a(), dataFreshnessResult, j, z);
    }

    public static FetchFeedResult m22436a(FetchFeedParams fetchFeedParams) {
        return new FetchFeedResult(fetchFeedParams, f15755e, DataFreshnessResult.NO_DATA, -1, false);
    }

    public FetchFeedResult(Parcel parcel) {
        super(parcel);
        this.f15756a = (FetchFeedParams) parcel.readParcelable(FetchFeedParams.class.getClassLoader());
        this.f15757b = (GraphQLFeedHomeStories) FlatBufferModelHelper.a(parcel);
        this.f15758c = parcel.readByte() == (byte) 1;
        this.f15759d = FetchPortion.FULL;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.f15756a, i);
        FlatBufferModelHelper.a(parcel, this.f15757b);
        parcel.writeByte((byte) (this.f15758c ? 1 : 0));
    }

    public final GraphQLFeedHomeStories m22438c() {
        return this.f15757b;
    }

    public final ImmutableList<GraphQLFeedUnitEdge> m22439d() {
        return this.f15757b.m22430k();
    }

    public final GraphQLPageInfo m22440e() {
        return this.f15757b.m22433n();
    }

    public final String m22441f() {
        return this.f15757b.m22429j();
    }

    public final FetchFeedParams m22442g() {
        return this.f15756a;
    }

    public final boolean m22443i() {
        return this.f15758c;
    }

    public String toString() {
        return Objects.toStringHelper(FetchFeedResult.class).add("params", this.f15756a).add("result", this.f15757b).add("clientTimeMs", this.clientTimeMs).add("freshness", (Object) this.freshness).toString();
    }

    public final FetchFeedResult m22437a(FetchFeedParams fetchFeedParams, FetchFeedResult fetchFeedResult) {
        Preconditions.checkNotNull(fetchFeedResult, "FetchFeedResult.mergeContinuous received null chunk");
        GraphQLFeedHomeStories graphQLFeedHomeStories = this.f15757b;
        GraphQLFeedHomeStories graphQLFeedHomeStories2 = fetchFeedResult.f15757b;
        Preconditions.checkNotNull(graphQLFeedHomeStories2, "FetchFeedResult.mergeContiguousHomeFeedStories received null chunk");
        Builder builder = new Builder();
        builder.f15741f = ImmutableList.builder().m1065b(graphQLFeedHomeStories.m22430k()).m1065b(graphQLFeedHomeStories2.m22430k()).m1068b();
        builder = builder;
        builder.f15744i = GraphQLHelper.m22459a(graphQLFeedHomeStories.m22433n(), graphQLFeedHomeStories2.m22433n());
        builder = builder;
        builder.f15740e = graphQLFeedHomeStories.m22429j();
        builder = builder;
        builder.f15739d = graphQLFeedHomeStories.m22425a() + graphQLFeedHomeStories2.m22425a();
        builder = builder;
        builder.f15745j = graphQLFeedHomeStories.m22434o();
        builder = builder;
        builder.f15746k = graphQLFeedHomeStories.m22435p();
        builder = builder;
        builder.f15742g = ImmutableList.builder().m1065b(graphQLFeedHomeStories.m22431l()).m1065b(graphQLFeedHomeStories2.m22431l()).m1068b();
        graphQLFeedHomeStories2 = builder.m22424a();
        DataFreshnessResult dataFreshnessResult = fetchFeedResult.freshness;
        long j = fetchFeedResult.clientTimeMs;
        boolean z = this.f15758c && fetchFeedResult.f15758c;
        return new FetchFeedResult(fetchFeedParams, graphQLFeedHomeStories2, dataFreshnessResult, j, z);
    }
}
