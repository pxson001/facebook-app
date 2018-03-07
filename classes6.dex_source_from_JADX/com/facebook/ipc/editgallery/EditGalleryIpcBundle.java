package com.facebook.ipc.editgallery;

import android.graphics.RectF;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.photos.creativeediting.model.CreativeEditingData;
import com.google.common.base.Strings;

/* compiled from: leftParticipantFbId */
public class EditGalleryIpcBundle implements Parcelable {
    public static final Creator<EditGalleryIpcBundle> CREATOR = new C07431();
    public static String f11617a = "edit_gallery_ipc_bundle_extra_key";
    public final Uri f11618b;
    public final int f11619c;
    public final String f11620d;
    public final CreativeEditingData f11621e;
    public final String f11622f;
    public final RectF f11623g;
    public final String f11624h;

    /* compiled from: leftParticipantFbId */
    final class C07431 implements Creator<EditGalleryIpcBundle> {
        C07431() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new EditGalleryIpcBundle(parcel);
        }

        public final Object[] newArray(int i) {
            return new EditGalleryIpcBundle[i];
        }
    }

    /* compiled from: leftParticipantFbId */
    public class Builder {
        public Uri f11610a;
        public int f11611b;
        public String f11612c;
        public CreativeEditingData f11613d;
        public String f11614e;
        public RectF f11615f;
        public String f11616g;

        public static Builder m18335a(EditGalleryIpcBundle editGalleryIpcBundle) {
            Builder builder = new Builder();
            builder.f11610a = editGalleryIpcBundle.f11618b;
            builder = builder;
            builder.f11611b = editGalleryIpcBundle.f11619c;
            builder = builder;
            builder.f11612c = editGalleryIpcBundle.f11620d;
            builder = builder;
            builder.f11613d = editGalleryIpcBundle.f11621e;
            builder = builder;
            builder.f11614e = editGalleryIpcBundle.f11622f;
            builder = builder;
            builder.f11615f = editGalleryIpcBundle.f11623g;
            builder = builder;
            builder.f11616g = editGalleryIpcBundle.f11624h;
            return builder;
        }

        public final EditGalleryIpcBundle m18336a() {
            if (Strings.isNullOrEmpty(this.f11612c)) {
                this.f11612c = SafeUUIDGenerator.a().toString();
            }
            return new EditGalleryIpcBundle(this.f11610a, this.f11611b, this.f11612c, this.f11613d, this.f11614e, this.f11615f, this.f11616g);
        }
    }

    private EditGalleryIpcBundle(Uri uri, int i, String str, CreativeEditingData creativeEditingData, String str2, RectF rectF, String str3) {
        this.f11618b = uri;
        this.f11619c = i;
        this.f11620d = str;
        this.f11621e = creativeEditingData;
        this.f11622f = str2;
        this.f11623g = rectF;
        this.f11624h = str3;
    }

    public EditGalleryIpcBundle(Parcel parcel) {
        this.f11618b = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f11619c = parcel.readInt();
        this.f11620d = parcel.readString();
        this.f11621e = (CreativeEditingData) parcel.readParcelable(CreativeEditingData.class.getClassLoader());
        this.f11622f = parcel.readString();
        this.f11623g = (RectF) parcel.readParcelable(RectF.class.getClassLoader());
        this.f11624h = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f11618b, i);
        parcel.writeInt(this.f11619c);
        parcel.writeString(this.f11620d);
        parcel.writeParcelable(this.f11621e, i);
        parcel.writeString(this.f11622f);
        parcel.writeParcelable(this.f11623g, i);
        parcel.writeString(this.f11624h);
    }

    public final Uri m18337a() {
        return this.f11618b;
    }

    public final int m18338b() {
        return this.f11619c;
    }

    public final String m18339c() {
        return this.f11620d;
    }

    public final CreativeEditingData m18340d() {
        return this.f11621e;
    }

    public final String m18341g() {
        return this.f11624h;
    }
}
