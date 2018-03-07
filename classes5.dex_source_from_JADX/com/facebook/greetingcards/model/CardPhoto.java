package com.facebook.greetingcards.model;

import android.graphics.PointF;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.ipc.media.MediaItem;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: TRIGHT;)V */
public class CardPhoto implements Parcelable {
    public static final Creator<CardPhoto> CREATOR = new C12881();
    public final Uri f13513a;
    public final Type f13514b;
    public final String f13515c;
    public final MediaItem f13516d;
    public final PointF f13517e;

    /* compiled from: TRIGHT;)V */
    final class C12881 implements Creator<CardPhoto> {
        C12881() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new CardPhoto(parcel);
        }

        public final Object[] newArray(int i) {
            return new CardPhoto[i];
        }
    }

    /* compiled from: TRIGHT;)V */
    public enum Type {
        LOCAL,
        LOCAL_UPLOADED,
        REMOTE
    }

    public static CardPhoto m22712a(MediaItem mediaItem) {
        return new CardPhoto(mediaItem.m23456f(), Type.LOCAL, null, mediaItem, null);
    }

    public static CardPhoto m22711a(Uri uri, String str, @Nullable PointF pointF) {
        return new CardPhoto(uri, Type.REMOTE, str, null, pointF);
    }

    public CardPhoto(Uri uri, Type type, String str, MediaItem mediaItem, PointF pointF) {
        this.f13513a = uri;
        this.f13515c = str;
        this.f13514b = type;
        this.f13516d = mediaItem;
        this.f13517e = pointF;
    }

    public CardPhoto(Parcel parcel) {
        this.f13513a = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f13514b = Type.valueOf(parcel.readString());
        this.f13515c = parcel.readString();
        this.f13516d = (MediaItem) parcel.readParcelable(MediaItem.class.getClassLoader());
        float readFloat = parcel.readFloat();
        float readFloat2 = parcel.readFloat();
        if (readFloat == -1.0f || readFloat2 == -1.0f) {
            this.f13517e = null;
        } else {
            this.f13517e = new PointF(readFloat, readFloat2);
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f13513a, i);
        parcel.writeString(this.f13514b.name());
        parcel.writeString(this.f13515c);
        parcel.writeParcelable(this.f13516d, i);
        if (this.f13517e != null) {
            parcel.writeFloat(this.f13517e.x);
            parcel.writeFloat(this.f13517e.y);
            return;
        }
        parcel.writeFloat(-1.0f);
        parcel.writeFloat(-1.0f);
    }
}
