package com.facebook.ipc.editgallery;

import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.bitmaps.Dimension;
import com.facebook.photos.creativeediting.model.StickerParams;
import javax.annotation.Nullable;

/* compiled from: learn_more */
public class EditGalleryZoomCropParams implements Parcelable {
    public static final Creator<EditGalleryZoomCropParams> CREATOR = new C07451();
    public static final Dimension f11658a = new Dimension(180, 180);
    public static final Dimension f11659b = new Dimension(-1, -1);
    @Nullable
    public final RectF f11660c;
    @Nullable
    public final StickerParams f11661d;
    public final float f11662e;
    public final float f11663f;
    public final Dimension f11664g;

    /* compiled from: learn_more */
    final class C07451 implements Creator<EditGalleryZoomCropParams> {
        C07451() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new EditGalleryZoomCropParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new EditGalleryZoomCropParams[i];
        }
    }

    /* compiled from: learn_more */
    public class Builder {
        @Nullable
        public RectF f11653a;
        @Nullable
        public StickerParams f11654b;
        public float f11655c = 0.9f;
        public float f11656d = 1.0f;
        public Dimension f11657e = EditGalleryZoomCropParams.f11659b;

        public Builder(EditGalleryZoomCropParams editGalleryZoomCropParams) {
            this.f11653a = editGalleryZoomCropParams.f11660c;
            this.f11654b = editGalleryZoomCropParams.f11661d;
            this.f11655c = editGalleryZoomCropParams.f11662e;
            this.f11656d = editGalleryZoomCropParams.f11663f;
            this.f11657e = editGalleryZoomCropParams.f11664g;
        }

        public final EditGalleryZoomCropParams m18349a() {
            return new EditGalleryZoomCropParams(this);
        }
    }

    public EditGalleryZoomCropParams(Builder builder) {
        this.f11660c = builder.f11653a;
        this.f11661d = builder.f11654b;
        this.f11662e = builder.f11655c;
        this.f11663f = builder.f11656d;
        this.f11664g = builder.f11657e;
    }

    public EditGalleryZoomCropParams(Parcel parcel) {
        this.f11660c = (RectF) parcel.readParcelable(RectF.class.getClassLoader());
        this.f11661d = (StickerParams) parcel.readParcelable(StickerParams.class.getClassLoader());
        this.f11662e = parcel.readFloat();
        this.f11663f = parcel.readFloat();
        this.f11664g = new Dimension(parcel.readInt(), parcel.readInt());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f11660c, i);
        parcel.writeParcelable(this.f11661d, i);
        parcel.writeFloat(this.f11662e);
        parcel.writeFloat(this.f11663f);
        parcel.writeInt(this.f11664g.b);
        parcel.writeInt(this.f11664g.a);
    }
}
