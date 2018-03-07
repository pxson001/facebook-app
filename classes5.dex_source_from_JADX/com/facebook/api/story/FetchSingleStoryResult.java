package com.facebook.api.story;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.fbservice.results.BaseResult;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.GraphQLStory;

/* compiled from: android_place_picker_context_menu */
public class FetchSingleStoryResult extends BaseResult implements Parcelable {
    public static final Creator<FetchSingleStoryResult> CREATOR = new C09851();
    public final GraphQLStory f10263a;

    /* compiled from: android_place_picker_context_menu */
    final class C09851 implements Creator<FetchSingleStoryResult> {
        C09851() {
        }

        public final Object[] newArray(int i) {
            return new FetchSingleStoryResult[i];
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchSingleStoryResult(parcel);
        }
    }

    public FetchSingleStoryResult(GraphQLStory graphQLStory, DataFreshnessResult dataFreshnessResult, long j) {
        super(dataFreshnessResult, j);
        this.f10263a = graphQLStory;
    }

    public FetchSingleStoryResult(Parcel parcel) {
        super(parcel);
        this.f10263a = (GraphQLStory) FlatBufferModelHelper.m4278a(parcel);
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        FlatBufferModelHelper.m4288a(parcel, this.f10263a);
    }

    public int describeContents() {
        return 0;
    }
}
