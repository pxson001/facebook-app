package com.facebook.composer.publish.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.GraphQLStory;

/* compiled from: actors */
public class PendingStoryPersistentData implements Parcelable {
    public static final Creator<PendingStoryPersistentData> CREATOR = new C10861();
    public final GraphQLStory f11523a;
    public final PostParamsWrapper f11524b;

    /* compiled from: actors */
    final class C10861 implements Creator<PendingStoryPersistentData> {
        C10861() {
        }

        public final Object[] newArray(int i) {
            return new PendingStoryPersistentData[i];
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PendingStoryPersistentData(parcel);
        }
    }

    public PendingStoryPersistentData(GraphQLStory graphQLStory, PostParamsWrapper postParamsWrapper) {
        this.f11523a = graphQLStory;
        this.f11524b = postParamsWrapper;
    }

    public PendingStoryPersistentData(Parcel parcel) {
        this.f11523a = (GraphQLStory) FlatBufferModelHelper.m4278a(parcel);
        this.f11524b = (PostParamsWrapper) parcel.readParcelable(PostParamsWrapper.class.getClassLoader());
    }

    public void writeToParcel(Parcel parcel, int i) {
        FlatBufferModelHelper.m4288a(parcel, this.f11523a);
        parcel.writeParcelable(this.f11524b, i);
    }

    public int describeContents() {
        return 0;
    }
}
