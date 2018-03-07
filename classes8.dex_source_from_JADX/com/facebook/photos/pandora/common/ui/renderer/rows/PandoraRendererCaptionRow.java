package com.facebook.photos.pandora.common.ui.renderer.rows;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: com.google.android.gms.cast.metadata.BROADCAST_DATE */
public class PandoraRendererCaptionRow extends PandoraRendererRow {
    public static final Creator<PandoraRendererMultiPhotosRow> CREATOR = new C18551();
    public final String f17497a;

    /* compiled from: com.google.android.gms.cast.metadata.BROADCAST_DATE */
    final class C18551 implements Creator<PandoraRendererMultiPhotosRow> {
        C18551() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PandoraRendererMultiPhotosRow(parcel);
        }

        public final Object[] newArray(int i) {
            return new PandoraRendererMultiPhotosRow[i];
        }
    }

    public PandoraRendererCaptionRow(String str) {
        this.f17497a = str;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f17497a);
    }
}
