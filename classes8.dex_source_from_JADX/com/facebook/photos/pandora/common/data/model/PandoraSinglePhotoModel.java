package com.facebook.photos.pandora.common.data.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.GraphQLPhoto;

/* compiled from: composer_asset_count */
public class PandoraSinglePhotoModel extends PandoraDataModel {
    public static final Creator<PandoraSinglePhotoModel> CREATOR = new C18501();
    public final GraphQLPhoto f17371a;

    /* compiled from: composer_asset_count */
    final class C18501 implements Creator<PandoraSinglePhotoModel> {
        C18501() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PandoraSinglePhotoModel(parcel);
        }

        public final Object[] newArray(int i) {
            return new PandoraSinglePhotoModel[i];
        }
    }

    public PandoraSinglePhotoModel(Parcel parcel) {
        this.f17371a = (GraphQLPhoto) FlatBufferModelHelper.a(parcel);
    }

    public final PandoraDataModelType mo1041a() {
        return PandoraDataModelType.SINGLE_PHOTO;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        FlatBufferModelHelper.a(parcel, this.f17371a);
    }
}
