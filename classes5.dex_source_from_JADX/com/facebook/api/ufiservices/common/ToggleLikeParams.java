package com.facebook.api.ufiservices.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLFeedback;
import javax.annotation.Nullable;

/* compiled from: android_nearby_friends_self_view_context_menu */
public class ToggleLikeParams implements Parcelable {
    public static final Creator<ToggleLikeParams> CREATOR = new C09951();
    public final String f10325a;
    public final boolean f10326b;
    public final GraphQLActor f10327c;
    public final FeedbackLoggingParams f10328d;
    @Nullable
    public final GraphQLFeedback f10329e;
    @Nullable
    public final String f10330f;

    /* compiled from: android_nearby_friends_self_view_context_menu */
    final class C09951 implements Creator<ToggleLikeParams> {
        C09951() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ToggleLikeParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new ToggleLikeParams[i];
        }
    }

    public ToggleLikeParams(String str, boolean z, GraphQLActor graphQLActor, FeedbackLoggingParams feedbackLoggingParams, @Nullable GraphQLFeedback graphQLFeedback, @Nullable String str2) {
        this.f10325a = str;
        this.f10326b = z;
        this.f10327c = graphQLActor;
        this.f10328d = feedbackLoggingParams;
        this.f10329e = graphQLFeedback;
        this.f10330f = str2;
    }

    public ToggleLikeParams(Parcel parcel) {
        this.f10325a = parcel.readString();
        this.f10327c = (GraphQLActor) FlatBufferModelHelper.m4278a(parcel);
        this.f10326b = parcel.readInt() == 1;
        this.f10328d = (FeedbackLoggingParams) parcel.readParcelable(FeedbackLoggingParams.class.getClassLoader());
        this.f10329e = (GraphQLFeedback) FlatBufferModelHelper.m4278a(parcel);
        this.f10330f = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f10325a);
        FlatBufferModelHelper.m4288a(parcel, this.f10327c);
        parcel.writeInt(this.f10326b ? 1 : 0);
        parcel.writeParcelable(this.f10328d, i);
        FlatBufferModelHelper.m4288a(parcel, this.f10329e);
        parcel.writeString(this.f10330f);
    }
}
