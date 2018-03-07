package com.facebook.photos.pandora.common.data.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.GraphQLStory;

/* compiled from: composer_configuration */
public class PandoraMultiPhotoStoryModel extends PandoraDataModel {
    public static final Creator<PandoraMultiPhotoStoryModel> CREATOR = new C18481();
    public final GraphQLStory f17369a;

    /* compiled from: composer_configuration */
    final class C18481 implements Creator<PandoraMultiPhotoStoryModel> {
        C18481() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PandoraMultiPhotoStoryModel(parcel);
        }

        public final Object[] newArray(int i) {
            return new PandoraMultiPhotoStoryModel[i];
        }
    }

    public PandoraMultiPhotoStoryModel(Parcel parcel) {
        this.f17369a = (GraphQLStory) FlatBufferModelHelper.a(parcel);
    }

    public final PandoraDataModelType mo1041a() {
        return PandoraDataModelType.MULTI_PHOTO_STORY;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        FlatBufferModelHelper.a(parcel, this.f17369a);
    }
}
