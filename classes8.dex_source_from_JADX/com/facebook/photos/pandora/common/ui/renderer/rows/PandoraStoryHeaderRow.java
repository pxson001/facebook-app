package com.facebook.photos.pandora.common.ui.renderer.rows;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.photos.pandora.common.data.model.PandoraDataModel;

/* compiled from: com.google.android.gms.cast.internal.ICastDeviceControllerListener */
public class PandoraStoryHeaderRow extends PandoraRendererRow {
    public static final Creator<PandoraStoryHeaderRow> CREATOR = new C18601();
    public final PandoraDataModel f17509a;

    /* compiled from: com.google.android.gms.cast.internal.ICastDeviceControllerListener */
    final class C18601 implements Creator<PandoraStoryHeaderRow> {
        C18601() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PandoraStoryHeaderRow(parcel);
        }

        public final Object[] newArray(int i) {
            return new PandoraStoryHeaderRow[i];
        }
    }

    public PandoraStoryHeaderRow(Parcel parcel) {
        this.f17509a = (PandoraDataModel) parcel.readParcelable(PandoraDataModel.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f17509a, i);
    }
}
