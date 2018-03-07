package com.facebook.photos.pandora.common.ui.renderer;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.graphql.modelutil.ImmutableListHelper;
import com.facebook.photos.pandora.common.ui.renderer.rows.PandoraRendererRow;
import com.google.common.collect.ImmutableList;

/* compiled from: com.google.android.gms.cast.metadata.WIDTH */
public class PandoraRendererResult implements Parcelable {
    public static final Creator<PandoraRendererResult> CREATOR = new C18541();
    public final ImmutableList<PandoraRendererRow> f17472a;

    /* compiled from: com.google.android.gms.cast.metadata.WIDTH */
    final class C18541 implements Creator<PandoraRendererResult> {
        C18541() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PandoraRendererResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new PandoraRendererResult[i];
        }
    }

    public PandoraRendererResult(ImmutableList<PandoraRendererRow> immutableList) {
        this.f17472a = immutableList;
    }

    public PandoraRendererResult(Parcel parcel) {
        this.f17472a = ImmutableListHelper.a(parcel.readArrayList(PandoraRendererRow.class.getClassLoader()));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.f17472a);
    }
}
