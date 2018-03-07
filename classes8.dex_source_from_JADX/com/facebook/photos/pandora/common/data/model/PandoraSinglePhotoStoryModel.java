package com.facebook.photos.pandora.common.data.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.GraphQLStory;

/* compiled from: compose */
public class PandoraSinglePhotoStoryModel extends PandoraDataModel {
    public static final Creator<PandoraSinglePhotoStoryModel> CREATOR = new C18511();
    public final GraphQLStory f17372a;

    /* compiled from: compose */
    final class C18511 implements Creator<PandoraSinglePhotoStoryModel> {
        C18511() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PandoraSinglePhotoStoryModel(parcel);
        }

        public final Object[] newArray(int i) {
            return new PandoraSinglePhotoStoryModel[i];
        }
    }

    public PandoraSinglePhotoStoryModel(Parcel parcel) {
        this.f17372a = (GraphQLStory) FlatBufferModelHelper.a(parcel);
    }

    public final PandoraDataModelType mo1041a() {
        return PandoraDataModelType.SINGLE_PHOTO_STORY;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        FlatBufferModelHelper.a(parcel, this.f17372a);
    }
}
