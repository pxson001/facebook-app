package com.facebook.composer.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.analytics.CurationMechanism;
import com.facebook.analytics.CurationSurface;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.facebook.ipc.media.MediaItem;
import com.google.common.base.Strings;
import javax.annotation.Nonnull;

/* compiled from: placeEstimator cannot be null */
public class PostReviewParams implements Parcelable {
    public static final Creator<PostReviewParams> CREATOR = new C04681();
    public final String f7933a;
    public final long f7934b;
    public final String f7935c;
    public final GraphQLPrivacyOption f7936d;
    public final int f7937e;
    public final CurationMechanism f7938f;
    public final CurationSurface f7939g;
    public final MediaItem f7940h;
    public final int f7941i;

    /* compiled from: placeEstimator cannot be null */
    final class C04681 implements Creator<PostReviewParams> {
        C04681() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PostReviewParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new PostReviewParams[0];
        }
    }

    /* compiled from: placeEstimator cannot be null */
    public class Builder {
        public String f7924a;
        public final long f7925b;
        public String f7926c;
        public GraphQLPrivacyOption f7927d;
        public int f7928e;
        public CurationMechanism f7929f;
        public CurationSurface f7930g;
        public MediaItem f7931h;
        public int f7932i;

        public Builder(long j, @Nonnull GraphQLPrivacyOption graphQLPrivacyOption, int i, @Nonnull CurationMechanism curationMechanism, @Nonnull CurationSurface curationSurface) {
            this.f7925b = j;
            this.f7927d = graphQLPrivacyOption;
            this.f7928e = i;
            this.f7929f = curationMechanism;
            this.f7930g = curationSurface;
        }

        public final Builder m11494a(int i) {
            this.f7932i = i;
            return this;
        }

        public static Builder m11493a(PostReviewParams postReviewParams) {
            Builder builder = new Builder(postReviewParams.f7934b, postReviewParams.f7936d, postReviewParams.f7937e, postReviewParams.f7938f, postReviewParams.f7939g);
            builder.f7924a = postReviewParams.f7933a;
            Builder builder2 = builder;
            builder2.f7926c = postReviewParams.f7935c;
            builder2 = builder2;
            builder2.f7931h = postReviewParams.f7940h;
            builder2 = builder2;
            builder2.f7932i = postReviewParams.f7941i;
            return builder2;
        }

        public final PostReviewParams m11495a() {
            return new PostReviewParams(this);
        }
    }

    public PostReviewParams(Builder builder) {
        this.f7933a = Strings.nullToEmpty(builder.f7924a);
        this.f7934b = builder.f7925b;
        this.f7935c = builder.f7926c;
        this.f7936d = builder.f7927d;
        this.f7937e = builder.f7928e;
        this.f7938f = builder.f7929f;
        this.f7939g = builder.f7930g;
        this.f7940h = builder.f7931h;
        this.f7941i = builder.f7932i;
    }

    public PostReviewParams(Parcel parcel) {
        this.f7933a = parcel.readString();
        this.f7934b = parcel.readLong();
        this.f7935c = parcel.readString();
        this.f7936d = (GraphQLPrivacyOption) FlatBufferModelHelper.a(parcel);
        this.f7937e = parcel.readInt();
        this.f7938f = (CurationMechanism) ParcelUtil.c(parcel, CurationMechanism.class);
        this.f7939g = (CurationSurface) ParcelUtil.c(parcel, CurationSurface.class);
        this.f7940h = (MediaItem) parcel.readParcelable(MediaItem.class.getClassLoader());
        this.f7941i = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7933a);
        parcel.writeLong(this.f7934b);
        parcel.writeString(this.f7935c);
        FlatBufferModelHelper.a(parcel, this.f7936d);
        parcel.writeInt(this.f7937e);
        ParcelUtil.a(parcel, this.f7938f);
        ParcelUtil.a(parcel, this.f7939g);
        parcel.writeParcelable(this.f7940h, 0);
        parcel.writeInt(this.f7941i);
    }
}
