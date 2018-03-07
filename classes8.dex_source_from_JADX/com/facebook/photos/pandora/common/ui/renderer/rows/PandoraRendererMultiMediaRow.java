package com.facebook.photos.pandora.common.ui.renderer.rows;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.modelutil.ImmutableListHelper;
import com.facebook.photos.pandora.protocols.PandoraQueryModels.PandoraMediaModel;
import com.google.common.collect.ImmutableList;

/* compiled from: com.google.android.gms.cast.metadata.ALBUM_TITLE */
public class PandoraRendererMultiMediaRow extends PandoraRendererRow {
    public static final Creator<PandoraRendererMultiMediaRow> CREATOR = new C18561();
    public final ImmutableList<PandoraMultiMediaStoryEntry> f17502a;

    /* compiled from: com.google.android.gms.cast.metadata.ALBUM_TITLE */
    final class C18561 implements Creator<PandoraRendererMultiMediaRow> {
        C18561() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PandoraRendererMultiMediaRow(parcel);
        }

        public final Object[] newArray(int i) {
            return new PandoraRendererMultiMediaRow[i];
        }
    }

    /* compiled from: com.google.android.gms.cast.metadata.ALBUM_TITLE */
    public class PandoraMultiMediaStoryEntry implements Parcelable {
        public static final Creator<PandoraMultiMediaStoryEntry> CREATOR = new C18571();
        public final PandoraMediaModel f17498a;
        public final double f17499b;
        public final PhotoEntryType f17500c;
        public boolean f17501d;

        /* compiled from: com.google.android.gms.cast.metadata.ALBUM_TITLE */
        final class C18571 implements Creator<PandoraMultiMediaStoryEntry> {
            C18571() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new PandoraMultiMediaStoryEntry(parcel);
            }

            public final Object[] newArray(int i) {
                return new PandoraMultiMediaStoryEntry[i];
            }
        }

        /* compiled from: com.google.android.gms.cast.metadata.ALBUM_TITLE */
        public enum PhotoEntryType {
            SQUARE,
            PORTRAIT,
            LANDSCAPE
        }

        public PandoraMultiMediaStoryEntry(PandoraMediaModel pandoraMediaModel, double d) {
            PhotoEntryType photoEntryType;
            this.f17498a = pandoraMediaModel;
            this.f17499b = d;
            this.f17501d = false;
            if (pandoraMediaModel.D() == null) {
                photoEntryType = null;
            } else if (((float) pandoraMediaModel.D().c()) >= ((float) pandoraMediaModel.D().a()) * 1.1f) {
                photoEntryType = PhotoEntryType.LANDSCAPE;
            } else if (((float) pandoraMediaModel.D().a()) >= ((float) pandoraMediaModel.D().c()) * 1.1f) {
                photoEntryType = PhotoEntryType.PORTRAIT;
            } else {
                photoEntryType = PhotoEntryType.SQUARE;
            }
            this.f17500c = photoEntryType;
        }

        public PandoraMultiMediaStoryEntry(Parcel parcel) {
            this.f17498a = (PandoraMediaModel) FlatBufferModelHelper.a(parcel);
            this.f17499b = parcel.readDouble();
            this.f17501d = ParcelUtil.a(parcel);
            this.f17500c = (PhotoEntryType) ParcelUtil.c(parcel, PhotoEntryType.class);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            FlatBufferModelHelper.a(parcel, this.f17498a);
            parcel.writeDouble(this.f17499b);
            ParcelUtil.a(parcel, this.f17501d);
            ParcelUtil.a(parcel, this.f17500c);
        }
    }

    public PandoraRendererMultiMediaRow(ImmutableList<PandoraMultiMediaStoryEntry> immutableList) {
        this.f17502a = immutableList;
    }

    public PandoraRendererMultiMediaRow(Parcel parcel) {
        this.f17502a = ImmutableListHelper.a(parcel.readArrayList(PandoraMultiMediaStoryEntry.class.getClassLoader()));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.f17502a);
    }
}
