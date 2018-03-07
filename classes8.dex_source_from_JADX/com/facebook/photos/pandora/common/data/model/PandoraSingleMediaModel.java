package com.facebook.photos.pandora.common.data.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.photos.pandora.protocols.PandoraQueryModels.PandoraMediaModel;

/* compiled from: composer_attachment */
public class PandoraSingleMediaModel extends PandoraDataModel {
    public static final Creator<PandoraSingleMediaModel> CREATOR = new C18491();
    public PandoraMediaModel f17370a;

    /* compiled from: composer_attachment */
    final class C18491 implements Creator<PandoraSingleMediaModel> {
        C18491() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PandoraSingleMediaModel(parcel);
        }

        public final Object[] newArray(int i) {
            return new PandoraSingleMediaModel[i];
        }
    }

    public PandoraSingleMediaModel(PandoraMediaModel pandoraMediaModel) {
        this.f17370a = pandoraMediaModel;
    }

    public PandoraSingleMediaModel(Parcel parcel) {
        this.f17370a = (PandoraMediaModel) FlatBufferModelHelper.a(parcel);
    }

    public final PandoraDataModelType mo1041a() {
        return PandoraDataModelType.SINGLE_MEDIA;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        FlatBufferModelHelper.a(parcel, this.f17370a);
    }
}
