package com.facebook.api.ufiservices.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.GraphQLActor;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: android_minimal_screen_form_height */
public class TogglePageLikeParams implements Parcelable {
    public static final Creator<TogglePageLikeParams> CREATOR = new C09961();
    public final String f10336a;
    public final boolean f10337b;
    public final GraphQLActor f10338c;
    public final FeedbackLoggingParams f10339d;
    @Nullable
    public final String f10340e;

    /* compiled from: android_minimal_screen_form_height */
    final class C09961 implements Creator<TogglePageLikeParams> {
        C09961() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new TogglePageLikeParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new TogglePageLikeParams[i];
        }
    }

    /* compiled from: android_minimal_screen_form_height */
    public class Builder {
        public String f10331a;
        public boolean f10332b;
        public GraphQLActor f10333c;
        public FeedbackLoggingParams f10334d;
        public String f10335e;

        public final Builder m18420a(String str) {
            this.f10331a = str;
            return this;
        }

        public final Builder m18421a(boolean z) {
            this.f10332b = z;
            return this;
        }

        public final Builder m18419a(GraphQLActor graphQLActor) {
            this.f10333c = graphQLActor;
            return this;
        }

        public final Builder m18418a(FeedbackLoggingParams feedbackLoggingParams) {
            this.f10334d = feedbackLoggingParams;
            return this;
        }

        public final Builder m18423b(String str) {
            this.f10335e = str;
            return this;
        }

        public final TogglePageLikeParams m18422a() {
            Preconditions.checkNotNull(this.f10331a);
            return new TogglePageLikeParams(this.f10331a, this.f10332b, this.f10333c, this.f10334d, this.f10335e);
        }
    }

    protected TogglePageLikeParams(String str, boolean z, GraphQLActor graphQLActor, FeedbackLoggingParams feedbackLoggingParams, String str2) {
        this.f10336a = str;
        this.f10337b = z;
        this.f10338c = graphQLActor;
        this.f10339d = feedbackLoggingParams;
        this.f10340e = str2;
    }

    public TogglePageLikeParams(Parcel parcel) {
        this.f10336a = parcel.readString();
        this.f10338c = (GraphQLActor) FlatBufferModelHelper.m4278a(parcel);
        this.f10337b = parcel.readInt() == 1;
        this.f10339d = (FeedbackLoggingParams) parcel.readParcelable(FeedbackLoggingParams.class.getClassLoader());
        this.f10340e = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f10336a);
        FlatBufferModelHelper.m4288a(parcel, this.f10338c);
        parcel.writeInt(this.f10337b ? 1 : 0);
        parcel.writeParcelable(this.f10339d, i);
        parcel.writeString(this.f10340e);
    }

    public static Builder m18424a() {
        return new Builder();
    }
}
