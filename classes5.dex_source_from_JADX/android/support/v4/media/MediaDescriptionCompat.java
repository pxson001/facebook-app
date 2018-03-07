package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;

/* compiled from: viewer_favorited */
public final class MediaDescriptionCompat implements Parcelable {
    public static final Creator<MediaDescriptionCompat> CREATOR = new C00131();
    public final String f238a;
    public final CharSequence f239b;
    public final CharSequence f240c;
    public final CharSequence f241d;
    public final Bitmap f242e;
    public final Uri f243f;
    public final Bundle f244g;
    public Object f245h;

    /* compiled from: viewer_favorited */
    final class C00131 implements Creator<MediaDescriptionCompat> {
        C00131() {
        }

        public final Object createFromParcel(Parcel parcel) {
            if (VERSION.SDK_INT < 21) {
                return new MediaDescriptionCompat(parcel);
            }
            MediaDescriptionCompat mediaDescriptionCompat;
            Object createFromParcel = MediaDescription.CREATOR.createFromParcel(parcel);
            if (createFromParcel == null || VERSION.SDK_INT < 21) {
                mediaDescriptionCompat = null;
            } else {
                Builder builder = new Builder();
                builder.f231a = MediaDescriptionCompatApi21.m270a(createFromParcel);
                builder.f232b = MediaDescriptionCompatApi21.m272b(createFromParcel);
                builder.f233c = MediaDescriptionCompatApi21.m273c(createFromParcel);
                builder.f234d = MediaDescriptionCompatApi21.m274d(createFromParcel);
                builder.f235e = MediaDescriptionCompatApi21.m275e(createFromParcel);
                builder.f236f = MediaDescriptionCompatApi21.m276f(createFromParcel);
                builder.f237g = MediaDescriptionCompatApi21.m277g(createFromParcel);
                mediaDescriptionCompat = new MediaDescriptionCompat(builder.f231a, builder.f232b, builder.f233c, builder.f234d, builder.f235e, builder.f236f, builder.f237g);
                mediaDescriptionCompat.f245h = createFromParcel;
            }
            return mediaDescriptionCompat;
        }

        public final Object[] newArray(int i) {
            return new MediaDescriptionCompat[i];
        }
    }

    /* compiled from: viewer_favorited */
    public final class Builder {
        public String f231a;
        public CharSequence f232b;
        public CharSequence f233c;
        public CharSequence f234d;
        public Bitmap f235e;
        public Uri f236f;
        public Bundle f237g;
    }

    private MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle) {
        this.f238a = str;
        this.f239b = charSequence;
        this.f240c = charSequence2;
        this.f241d = charSequence3;
        this.f242e = bitmap;
        this.f243f = uri;
        this.f244g = bundle;
    }

    public MediaDescriptionCompat(Parcel parcel) {
        this.f238a = parcel.readString();
        this.f239b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f240c = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f241d = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f242e = (Bitmap) parcel.readParcelable(null);
        this.f243f = (Uri) parcel.readParcelable(null);
        this.f244g = parcel.readBundle();
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        if (VERSION.SDK_INT < 21) {
            parcel.writeString(this.f238a);
            TextUtils.writeToParcel(this.f239b, parcel, i);
            TextUtils.writeToParcel(this.f240c, parcel, i);
            TextUtils.writeToParcel(this.f241d, parcel, i);
            parcel.writeParcelable(this.f242e, i);
            parcel.writeParcelable(this.f243f, i);
            parcel.writeBundle(this.f244g);
            return;
        }
        Object obj;
        if (this.f245h != null || VERSION.SDK_INT < 21) {
            obj = this.f245h;
        } else {
            obj = new android.media.MediaDescription.Builder();
            android.support.v4.media.MediaDescriptionCompatApi21.Builder.m267a(obj, this.f238a);
            android.support.v4.media.MediaDescriptionCompatApi21.Builder.m266a(obj, this.f239b);
            android.support.v4.media.MediaDescriptionCompatApi21.Builder.m268b(obj, this.f240c);
            android.support.v4.media.MediaDescriptionCompatApi21.Builder.m269c(obj, this.f241d);
            android.support.v4.media.MediaDescriptionCompatApi21.Builder.m263a(obj, this.f242e);
            android.support.v4.media.MediaDescriptionCompatApi21.Builder.m264a(obj, this.f243f);
            android.support.v4.media.MediaDescriptionCompatApi21.Builder.m265a(obj, this.f244g);
            this.f245h = android.support.v4.media.MediaDescriptionCompatApi21.Builder.m262a(obj);
            obj = this.f245h;
        }
        MediaDescriptionCompatApi21.m271a(obj, parcel, i);
    }

    public final String toString() {
        return this.f239b + ", " + this.f240c + ", " + this.f241d;
    }
}
