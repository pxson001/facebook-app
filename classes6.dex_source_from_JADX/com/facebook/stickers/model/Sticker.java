package com.facebook.stickers.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: senderID */
public class Sticker implements Parcelable {
    public static final Creator<Sticker> CREATOR = new C03001();
    public final String f4938a;
    public final String f4939b;
    @Nullable
    public final Uri f4940c;
    @Nullable
    public final Uri f4941d;
    @Nullable
    public final Uri f4942e;
    @Nullable
    public final Uri f4943f;
    @Nullable
    public final Uri f4944g;
    @Nullable
    public final Uri f4945h;

    /* compiled from: senderID */
    final class C03001 implements Creator<Sticker> {
        C03001() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new Sticker(parcel);
        }

        public final Object[] newArray(int i) {
            return new Sticker[i];
        }
    }

    Sticker(String str, String str2, Uri uri, @Nullable Uri uri2, @Nullable Uri uri3, @Nullable Uri uri4, @Nullable Uri uri5, @Nullable Uri uri6) {
        this.f4938a = (String) Preconditions.checkNotNull(str);
        this.f4939b = (String) Preconditions.checkNotNull(str2);
        this.f4940c = (Uri) Preconditions.checkNotNull(uri);
        this.f4941d = uri2;
        this.f4942e = uri3;
        this.f4943f = uri4;
        this.f4944g = uri5;
        this.f4945h = uri6;
    }

    public Sticker(Parcel parcel) {
        this.f4938a = parcel.readString();
        this.f4939b = parcel.readString();
        this.f4940c = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f4941d = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f4942e = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f4943f = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f4944g = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f4945h = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
    }

    public String toString() {
        return "Sticker{id='" + this.f4938a + '\'' + ", packId='" + this.f4939b + '\'' + ", staticWebUri=" + this.f4940c + ", staticDiskUri=" + this.f4941d + ", animatedWebUri=" + this.f4942e + ", animatedDiskUri=" + this.f4943f + ", previewWebUri=" + this.f4944g + ", previewDiskUri=" + this.f4945h + '}';
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4938a);
        parcel.writeString(this.f4939b);
        parcel.writeParcelable(this.f4940c, i);
        parcel.writeParcelable(this.f4941d, i);
        parcel.writeParcelable(this.f4942e, i);
        parcel.writeParcelable(this.f4943f, i);
        parcel.writeParcelable(this.f4944g, i);
        parcel.writeParcelable(this.f4945h, i);
    }
}
