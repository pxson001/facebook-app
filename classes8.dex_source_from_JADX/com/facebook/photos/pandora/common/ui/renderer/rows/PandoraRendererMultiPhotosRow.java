package com.facebook.photos.pandora.common.ui.renderer.rows;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.GraphQLPhoto;
import com.facebook.graphql.modelutil.ImmutableListHelper;
import com.facebook.photos.pandora.common.data.model.PandoraDataModel;
import com.google.common.collect.ImmutableList;

/* compiled from: com.google.android.gms.cast.metadata.ALBUM_ARTIST */
public class PandoraRendererMultiPhotosRow extends PandoraRendererRow {
    public static final Creator<PandoraRendererMultiPhotosRow> CREATOR = new C18581();
    public final ImmutableList<PandoraMultiPhotoStoryEntry> f17508a;

    /* compiled from: com.google.android.gms.cast.metadata.ALBUM_ARTIST */
    final class C18581 implements Creator<PandoraRendererMultiPhotosRow> {
        C18581() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PandoraRendererMultiPhotosRow(parcel);
        }

        public final Object[] newArray(int i) {
            return new PandoraRendererMultiPhotosRow[i];
        }
    }

    /* compiled from: com.google.android.gms.cast.metadata.ALBUM_ARTIST */
    public class PandoraMultiPhotoStoryEntry implements Parcelable {
        public static final Creator<PandoraMultiPhotoStoryEntry> CREATOR = new C18591();
        public final PandoraDataModel f17503a;
        public final GraphQLPhoto f17504b;
        public final double f17505c;
        public boolean f17506d;
        public PhotoEntryType f17507e;

        /* compiled from: com.google.android.gms.cast.metadata.ALBUM_ARTIST */
        final class C18591 implements Creator<PandoraMultiPhotoStoryEntry> {
            C18591() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new PandoraMultiPhotoStoryEntry(parcel);
            }

            public final Object[] newArray(int i) {
                return new PandoraMultiPhotoStoryEntry[i];
            }
        }

        /* compiled from: com.google.android.gms.cast.metadata.ALBUM_ARTIST */
        public enum PhotoEntryType {
            SQUARE,
            PORTRAIT,
            LANDSCAPE
        }

        public PandoraMultiPhotoStoryEntry(PandoraDataModel pandoraDataModel, GraphQLPhoto graphQLPhoto, double d) {
            this.f17503a = pandoraDataModel;
            this.f17504b = graphQLPhoto;
            this.f17505c = d;
            this.f17506d = false;
        }

        public PandoraMultiPhotoStoryEntry(Parcel parcel) {
            this.f17503a = (PandoraDataModel) parcel.readParcelable(PandoraDataModel.class.getClassLoader());
            this.f17504b = (GraphQLPhoto) FlatBufferModelHelper.a(parcel);
            this.f17505c = parcel.readDouble();
            this.f17506d = ParcelUtil.a(parcel);
        }

        public final PhotoEntryType m21486a() {
            if (this.f17504b == null || this.f17504b.L() == null) {
                return null;
            }
            if (this.f17507e != null) {
                return this.f17507e;
            }
            if (((float) this.f17504b.L().c()) >= ((float) this.f17504b.L().a()) * 1.1f) {
                this.f17507e = PhotoEntryType.LANDSCAPE;
                return this.f17507e;
            } else if (((float) this.f17504b.L().a()) >= ((float) this.f17504b.L().c()) * 1.1f) {
                this.f17507e = PhotoEntryType.PORTRAIT;
                return this.f17507e;
            } else {
                this.f17507e = PhotoEntryType.SQUARE;
                return this.f17507e;
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.f17503a, i);
            FlatBufferModelHelper.a(parcel, this.f17504b);
            parcel.writeDouble(this.f17505c);
            ParcelUtil.a(parcel, this.f17506d);
        }
    }

    public PandoraRendererMultiPhotosRow(ImmutableList<PandoraMultiPhotoStoryEntry> immutableList) {
        this.f17508a = immutableList;
    }

    public PandoraRendererMultiPhotosRow(Parcel parcel) {
        this.f17508a = ImmutableListHelper.a(parcel.readArrayList(PandoraMultiPhotoStoryEntry.class.getClassLoader()));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.f17508a);
    }
}
