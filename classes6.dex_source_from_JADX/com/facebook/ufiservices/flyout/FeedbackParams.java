package com.facebook.ufiservices.flyout;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.api.ufiservices.common.CommentOrderType;
import com.facebook.api.ufiservices.common.FeedbackDisplayType;
import com.facebook.api.ufiservices.common.FeedbackLoggingParams;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.ipc.media.MediaItem;
import javax.annotation.Nullable;

/* compiled from: d82ab2fec1d5ab756e172fe1cec08a89 */
public class FeedbackParams implements Parcelable {
    public static final Creator<FeedbackParams> CREATOR = new C13101();
    public GraphQLFeedback f18057a;
    public GraphQLComment f18058b;
    public FeedProps<GraphQLStory> f18059c;
    public String f18060d;
    public String f18061e;
    public String f18062f;
    public FeedbackLoggingParams f18063g;
    public boolean f18064h;
    public boolean f18065i;
    public boolean f18066j;
    public Long f18067k;
    public MediaItem f18068l;
    public String f18069m;
    public String f18070n;
    public CommentOrderType f18071o;
    public boolean f18072p;
    public boolean f18073q;
    public boolean f18074r;

    /* compiled from: d82ab2fec1d5ab756e172fe1cec08a89 */
    final class C13101 implements Creator<FeedbackParams> {
        C13101() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FeedbackParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new FeedbackParams[i];
        }
    }

    /* compiled from: d82ab2fec1d5ab756e172fe1cec08a89 */
    public class Builder {
        public GraphQLFeedback f18039a;
        public GraphQLComment f18040b;
        public FeedProps<GraphQLStory> f18041c;
        public String f18042d;
        public String f18043e;
        public String f18044f;
        public FeedbackLoggingParams f18045g;
        public boolean f18046h;
        public boolean f18047i;
        public boolean f18048j;
        public long f18049k;
        public MediaItem f18050l;
        public String f18051m;
        public String f18052n;
        public CommentOrderType f18053o;
        public boolean f18054p;
        public boolean f18055q;
        public boolean f18056r;

        public static Builder m26550a(FeedbackParams feedbackParams) {
            Builder builder = new Builder();
            builder.f18039a = feedbackParams.f18057a;
            builder.f18040b = feedbackParams.f18058b;
            builder.f18042d = feedbackParams.m26555g();
            builder.f18043e = feedbackParams.m26554d();
            builder.f18044f = feedbackParams.f18062f;
            builder.f18045g = feedbackParams.f18063g;
            builder.f18046h = feedbackParams.f18064h;
            builder.f18047i = feedbackParams.f18065i;
            builder.f18048j = feedbackParams.f18066j;
            builder.m26551a(feedbackParams.f18067k);
            builder.f18050l = feedbackParams.f18068l;
            builder.f18051m = feedbackParams.f18069m;
            builder.f18052n = feedbackParams.f18070n;
            builder.f18053o = feedbackParams.f18071o;
            builder.f18054p = feedbackParams.f18072p;
            builder.f18055q = feedbackParams.f18073q;
            builder.f18056r = feedbackParams.f18074r;
            builder.f18041c = feedbackParams.f18059c;
            return builder;
        }

        public final Builder m26551a(Long l) {
            if (l != null) {
                this.f18049k = l.longValue();
            }
            return this;
        }

        public final FeedbackParams m26552a() {
            return new FeedbackParams(this);
        }
    }

    public FeedbackParams(Parcel parcel) {
        this.f18057a = (GraphQLFeedback) FlatBufferModelHelper.a(parcel);
        this.f18058b = (GraphQLComment) FlatBufferModelHelper.a(parcel);
        this.f18060d = parcel.readString();
        this.f18061e = parcel.readString();
        this.f18062f = parcel.readString();
        this.f18063g = (FeedbackLoggingParams) parcel.readParcelable(FeedbackLoggingParams.class.getClassLoader());
        this.f18064h = ParcelUtil.a(parcel);
        this.f18065i = ParcelUtil.a(parcel);
        this.f18066j = ParcelUtil.a(parcel);
        this.f18067k = Long.valueOf(parcel.readLong());
        this.f18068l = (MediaItem) parcel.readParcelable(MediaItem.class.getClassLoader());
        this.f18069m = parcel.readString();
        this.f18070n = parcel.readString();
        this.f18071o = (CommentOrderType) parcel.readSerializable();
        this.f18072p = ParcelUtil.a(parcel);
        this.f18073q = ParcelUtil.a(parcel);
        this.f18074r = ParcelUtil.a(parcel);
        this.f18059c = (FeedProps) parcel.readParcelable(GraphQLStory.class.getClassLoader());
    }

    public FeedbackParams(Builder builder) {
        this.f18057a = builder.f18039a;
        this.f18058b = builder.f18040b;
        this.f18060d = builder.f18042d;
        this.f18061e = builder.f18043e;
        this.f18062f = builder.f18044f;
        this.f18063g = builder.f18045g;
        this.f18064h = builder.f18046h;
        this.f18065i = builder.f18047i;
        this.f18066j = builder.f18048j;
        this.f18067k = Long.valueOf(builder.f18049k);
        this.f18068l = builder.f18050l;
        this.f18069m = builder.f18051m;
        this.f18070n = builder.f18052n;
        this.f18071o = builder.f18053o;
        this.f18072p = builder.f18054p;
        this.f18073q = builder.f18055q;
        this.f18074r = builder.f18056r;
        this.f18059c = builder.f18041c;
    }

    public void writeToParcel(Parcel parcel, int i) {
        FlatBufferModelHelper.a(parcel, this.f18057a);
        FlatBufferModelHelper.a(parcel, this.f18058b);
        parcel.writeString(m26555g());
        parcel.writeString(m26554d());
        parcel.writeString(this.f18062f);
        parcel.writeParcelable(this.f18063g, i);
        ParcelUtil.a(parcel, this.f18064h);
        ParcelUtil.a(parcel, this.f18065i);
        ParcelUtil.a(parcel, this.f18066j);
        parcel.writeLong(this.f18067k.longValue());
        parcel.writeParcelable(this.f18068l, i);
        parcel.writeString(this.f18069m);
        parcel.writeString(this.f18070n);
        parcel.writeSerializable(this.f18071o);
        ParcelUtil.a(parcel, this.f18072p);
        ParcelUtil.a(parcel, this.f18073q);
        ParcelUtil.a(parcel, this.f18074r);
        parcel.writeParcelable(this.f18059c, i);
    }

    @Nullable
    public final String m26554d() {
        if (this.f18057a != null) {
            return this.f18057a.j();
        }
        return this.f18061e;
    }

    public final void m26553a(FeedbackDisplayType feedbackDisplayType) {
        com.facebook.api.ufiservices.common.FeedbackLoggingParams.Builder a = com.facebook.api.ufiservices.common.FeedbackLoggingParams.Builder.a(this.f18063g);
        a.d = feedbackDisplayType;
        this.f18063g = a.a();
    }

    @Nullable
    public final String m26555g() {
        if (this.f18057a != null) {
            return this.f18057a.z_();
        }
        return this.f18060d;
    }

    public final String m26556h() {
        if (this.f18063g == null) {
            return "unknown";
        }
        return this.f18063g.c;
    }

    public int describeContents() {
        return 0;
    }

    public final String m26557u() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Feedback Id: ").append(m26555g()).append("\n");
        stringBuilder.append("Legacy Api Post Id: ").append(m26554d()).append("\n");
        stringBuilder.append("Parent Feedback Id: ").append(this.f18062f).append("\n");
        stringBuilder.append("Show Likers: ").append(this.f18066j).append("\n");
        stringBuilder.append("Group Id: ").append(this.f18067k).append("\n");
        stringBuilder.append("Show Keyboard On First Load: ").append(this.f18065i).append("\n");
        stringBuilder.append("Scroll To Bottom On First Load: ").append(this.f18064h).append("\n");
        stringBuilder.append("Focused Comment Id: ").append(this.f18069m).append("\n");
        stringBuilder.append("Focused Comment Parent Id: ").append(this.f18070n).append("\n");
        stringBuilder.append("Comment Order Type: ").append(this.f18071o).append("\n");
        stringBuilder.append("Include Comments Disabled Fields: ").append(this.f18072p).append("\n");
        stringBuilder.append("ShouldFetchPrivateReplyContext: ").append(this.f18073q).append("\n");
        stringBuilder.append("IsOptimisticPost: ").append(this.f18074r).append("\n");
        if (this.f18059c != null) {
            stringBuilder.append("DeepStory CacheId: ").append(((GraphQLStory) this.f18059c.a).g()).append("\n");
        }
        stringBuilder.append(this.f18063g.i());
        return stringBuilder.toString();
    }

    public final Bundle m26558v() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("feedbackParams", this);
        return bundle;
    }
}
