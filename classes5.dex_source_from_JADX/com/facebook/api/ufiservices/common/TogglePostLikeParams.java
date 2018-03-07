package com.facebook.api.ufiservices.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLFeedback;
import javax.annotation.Nullable;

/* compiled from: android_mark_duplicates */
public class TogglePostLikeParams implements Parcelable {
    public static final Creator<TogglePostLikeParams> CREATOR = new C09971();
    @Nullable
    public final String f10347a;
    public final boolean f10348b;
    public final GraphQLActor f10349c;
    public final FeedbackLoggingParams f10350d;
    @Nullable
    public final GraphQLFeedback f10351e;
    @Nullable
    public final String f10352f;

    /* compiled from: android_mark_duplicates */
    final class C09971 implements Creator<TogglePostLikeParams> {
        C09971() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new TogglePostLikeParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new TogglePostLikeParams[i];
        }
    }

    /* compiled from: android_mark_duplicates */
    public class Builder {
        public String f10341a;
        public boolean f10342b;
        public GraphQLActor f10343c;
        public FeedbackLoggingParams f10344d;
        public GraphQLFeedback f10345e;
        private String f10346f;

        public final Builder m18428a(boolean z) {
            this.f10342b = z;
            return this;
        }

        public final Builder m18426a(GraphQLActor graphQLActor) {
            this.f10343c = graphQLActor;
            return this;
        }

        public final Builder m18425a(FeedbackLoggingParams feedbackLoggingParams) {
            this.f10344d = feedbackLoggingParams;
            return this;
        }

        public final Builder m18427a(GraphQLFeedback graphQLFeedback) {
            this.f10345e = graphQLFeedback;
            return this;
        }

        public final TogglePostLikeParams m18429a() {
            return new TogglePostLikeParams(this.f10341a, this.f10342b, this.f10343c, this.f10344d, this.f10345e, this.f10346f);
        }
    }

    protected TogglePostLikeParams(@Nullable String str, boolean z, GraphQLActor graphQLActor, FeedbackLoggingParams feedbackLoggingParams, @Nullable GraphQLFeedback graphQLFeedback, @Nullable String str2) {
        this.f10347a = str;
        this.f10348b = z;
        this.f10349c = graphQLActor;
        this.f10350d = feedbackLoggingParams;
        this.f10351e = graphQLFeedback;
        this.f10352f = str2;
    }

    public TogglePostLikeParams(Parcel parcel) {
        this.f10347a = parcel.readString();
        this.f10349c = (GraphQLActor) FlatBufferModelHelper.m4278a(parcel);
        this.f10348b = parcel.readInt() == 1;
        this.f10350d = (FeedbackLoggingParams) parcel.readParcelable(FeedbackLoggingParams.class.getClassLoader());
        this.f10351e = (GraphQLFeedback) FlatBufferModelHelper.m4278a(parcel);
        this.f10352f = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f10347a);
        FlatBufferModelHelper.m4288a(parcel, this.f10349c);
        parcel.writeInt(this.f10348b ? 1 : 0);
        parcel.writeParcelable(this.f10350d, i);
        FlatBufferModelHelper.m4288a(parcel, this.f10351e);
        parcel.writeString(this.f10352f);
    }

    public static Builder m18430a() {
        return new Builder();
    }

    public final ToggleLikeParams m18431b() {
        String str;
        if (this.f10347a != null) {
            str = this.f10347a;
        } else if (this.f10351e != null) {
            str = this.f10351e.j();
        } else {
            throw new IllegalArgumentException("missing both likeableId and legacyApiPostid");
        }
        return new ToggleLikeParams(str, this.f10348b, this.f10349c, this.f10350d, this.f10351e, null);
    }
}
