package com.facebook.api.feed;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.api.feedtype.FeedType;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.graphql.modelutil.ImmutableListHelper;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;

/* compiled from: select count( */
public class FetchFeedParams implements Parcelable {
    public static final Creator<FetchFeedParams> CREATOR = new C02681();
    public final DataFreshnessParam f5783a;
    public final FeedType f5784b;
    public final int f5785c;
    public final String f5786d;
    public final String f5787e;
    public FetchFeedCause f5788f;
    public final String f5789g;
    public final FeedFetchContext f5790h;
    public final ImmutableList<String> f5791i;
    public final CallerContext f5792j;
    public final boolean f5793k;
    public final boolean f5794l;
    public long f5795m = 0;
    public long f5796n = 0;
    public final boolean f5797o;
    public final FetchTypeForLogging f5798p;

    /* compiled from: select count( */
    final class C02681 implements Creator<FetchFeedParams> {
        C02681() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchFeedParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchFeedParams[i];
        }
    }

    /* compiled from: select count( */
    public enum FetchFeedCause {
        WARM_START("warm"),
        POLLING("nsp"),
        BACK_TO_BACK_PTR("back_to_back_manual"),
        PULL_TO_REFRESH("manual"),
        ERROR_RETRY("auto"),
        SCROLLING("auto"),
        INITIALIZATION("auto"),
        AUTO_REFRESH("auto"),
        PREFETCH("background"),
        UNKNOWN("auto"),
        RERANK("rerank"),
        INITIALIZATION_RERANK("rerank"),
        SKIP_TAIL_GAP("skip_tail_gap");
        
        private final String name;

        private FetchFeedCause(String str) {
            this.name = str;
        }

        public final String toString() {
            return this.name;
        }

        public final boolean isManual() {
            return this == PULL_TO_REFRESH || this == BACK_TO_BACK_PTR;
        }

        public final boolean needsReranking() {
            return this == PULL_TO_REFRESH || this == RERANK || this == BACK_TO_BACK_PTR;
        }

        public final boolean isAutoRefresh() {
            return this == AUTO_REFRESH || this == WARM_START || this == POLLING;
        }

        public final boolean needsEmptyReranking() {
            return isAutoRefresh() || this == INITIALIZATION;
        }

        public final boolean isFreshFeedNewStoriesEligible() {
            return this == PULL_TO_REFRESH || this == BACK_TO_BACK_PTR || this == ERROR_RETRY || this == RERANK;
        }

        public final boolean isInitialization() {
            return this == INITIALIZATION || this == INITIALIZATION_RERANK;
        }

        public final boolean isNewStoriesFetch() {
            return this == PULL_TO_REFRESH || this == BACK_TO_BACK_PTR || this == ERROR_RETRY || this == INITIALIZATION || this == AUTO_REFRESH || this == POLLING || this == WARM_START;
        }
    }

    /* compiled from: select count( */
    public enum FetchTypeForLogging {
        HEAD,
        CHUNKED_INITIAL,
        CHUNKED_REMAINDER,
        TAIL,
        UNSET
    }

    public FetchFeedParams(FetchFeedParamsBuilder fetchFeedParamsBuilder) {
        this.f5783a = fetchFeedParamsBuilder.f5799a;
        this.f5784b = fetchFeedParamsBuilder.f5800b;
        this.f5785c = fetchFeedParamsBuilder.f5801c;
        this.f5786d = fetchFeedParamsBuilder.f5805g;
        this.f5787e = fetchFeedParamsBuilder.f5804f;
        this.f5791i = fetchFeedParamsBuilder.f5812n;
        this.f5788f = fetchFeedParamsBuilder.f5807i;
        this.f5797o = fetchFeedParamsBuilder.f5808j;
        this.f5789g = fetchFeedParamsBuilder.f5806h;
        this.f5798p = fetchFeedParamsBuilder.f5809k;
        this.f5790h = fetchFeedParamsBuilder.f5810l;
        this.f5792j = fetchFeedParamsBuilder.f5811m;
        this.f5793k = fetchFeedParamsBuilder.f5813o;
        this.f5794l = fetchFeedParamsBuilder.f5814p;
        this.f5795m = fetchFeedParamsBuilder.f5802d;
        this.f5796n = fetchFeedParamsBuilder.f5803e;
    }

    public static FetchFeedParamsBuilder newBuilder() {
        return new FetchFeedParamsBuilder();
    }

    public FetchFeedParams(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.f5783a = DataFreshnessParam.valueOf(parcel.readString());
        this.f5784b = (FeedType) parcel.readParcelable(FeedType.class.getClassLoader());
        this.f5785c = parcel.readInt();
        this.f5786d = parcel.readString();
        this.f5787e = parcel.readString();
        this.f5788f = FetchFeedCause.valueOf(parcel.readString());
        this.f5797o = parcel.readByte() == (byte) 1;
        this.f5789g = parcel.readString();
        this.f5798p = FetchTypeForLogging.valueOf(parcel.readString());
        this.f5790h = (FeedFetchContext) parcel.readParcelable(FeedFetchContext.class.getClassLoader());
        this.f5792j = (CallerContext) parcel.readParcelable(CallerContext.class.getClassLoader());
        this.f5791i = ImmutableListHelper.m21625a(parcel.createStringArrayList());
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f5793k = z;
        if (parcel.readByte() != (byte) 1) {
            z2 = false;
        }
        this.f5794l = z2;
        this.f5796n = parcel.readLong();
    }

    public final String m9910c() {
        return this.f5786d;
    }

    public final String m9911d() {
        return this.f5787e;
    }

    public final DataFreshnessParam m9912e() {
        return this.f5783a;
    }

    public final FeedType m9913f() {
        return this.f5784b;
    }

    public final FetchFeedCause m9914h() {
        return this.f5788f;
    }

    public final boolean m9915i() {
        return this.f5797o;
    }

    public final FetchTypeForLogging m9916j() {
        return this.f5798p;
    }

    public final FeedFetchContext m9917k() {
        return this.f5790h;
    }

    public final CallerContext m9918l() {
        return this.f5792j;
    }

    public final boolean m9919m() {
        return this.f5793k;
    }

    public final boolean m9920n() {
        return this.f5794l;
    }

    public final long m9921o() {
        return this.f5795m;
    }

    public final long m9922p() {
        return this.f5796n;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        byte b;
        byte b2 = (byte) 1;
        parcel.writeString(this.f5783a.toString());
        parcel.writeParcelable(this.f5784b, i);
        parcel.writeInt(this.f5785c);
        parcel.writeString(this.f5786d);
        parcel.writeString(this.f5787e);
        parcel.writeString(this.f5788f.name());
        parcel.writeByte(this.f5797o ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f5789g);
        parcel.writeString(this.f5798p.toString());
        parcel.writeParcelable(this.f5790h, i);
        parcel.writeParcelable(this.f5792j, i);
        parcel.writeStringList(this.f5791i);
        if (this.f5793k) {
            b = (byte) 1;
        } else {
            b = (byte) 0;
        }
        parcel.writeByte(b);
        if (!this.f5794l) {
            b2 = (byte) 0;
        }
        parcel.writeByte(b2);
        parcel.writeLong(this.f5796n);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FetchFeedParams)) {
            return false;
        }
        FetchFeedParams fetchFeedParams = (FetchFeedParams) obj;
        if (Objects.equal(fetchFeedParams.f5783a, this.f5783a) && Objects.equal(fetchFeedParams.f5787e, this.f5787e) && Objects.equal(fetchFeedParams.f5786d, this.f5786d) && Objects.equal(fetchFeedParams.f5784b, this.f5784b) && Objects.equal(Integer.valueOf(fetchFeedParams.f5785c), Integer.valueOf(this.f5785c)) && fetchFeedParams.f5788f == this.f5788f && fetchFeedParams.f5797o == this.f5797o && Objects.equal(fetchFeedParams.f5798p, this.f5798p) && Objects.equal(fetchFeedParams.f5789g, this.f5789g) && fetchFeedParams.f5790h.equals(this.f5790h) && Objects.equal(fetchFeedParams.f5792j, this.f5792j) && Objects.equal(fetchFeedParams.f5791i, this.f5791i) && fetchFeedParams.f5793k == this.f5793k && fetchFeedParams.f5794l == this.f5794l && Objects.equal(Long.valueOf(fetchFeedParams.f5796n), Long.valueOf(this.f5796n))) {
            return true;
        }
        return false;
    }

    public String toString() {
        return Objects.toStringHelper((Object) this).add("Freshness", this.f5783a.toString()).add("Type", this.f5784b.toString()).add("FirstItems", this.f5785c).add("Before", this.f5786d).add("After", this.f5787e).add("FetchFeedCause", this.f5788f.toString()).add("PreferChunked", String.valueOf(this.f5797o)).add("FetchTypeForLogging", this.f5798p.toString()).add("ClientQueryID", this.f5789g).add("ViewContext", this.f5790h.toString()).add("CallerContext", this.f5792j).add("RecentVpvs", this.f5791i).add("NoSkipping", this.f5793k).add("AllowGaps", this.f5794l).add("MaxStoryStalenessTime", this.f5796n).toString();
    }

    public int hashCode() {
        return Objects.hashCode(this.f5783a, Integer.valueOf(this.f5785c), this.f5784b, this.f5787e, this.f5786d, this.f5788f, Boolean.valueOf(this.f5797o), this.f5798p, this.f5789g, this.f5791i, Boolean.valueOf(this.f5793k), Boolean.valueOf(this.f5794l), Long.valueOf(this.f5796n));
    }
}
