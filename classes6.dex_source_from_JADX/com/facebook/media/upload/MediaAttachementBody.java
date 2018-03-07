package com.facebook.media.upload;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.http.entity.mime.apache.FormBodyPart;
import com.facebook.http.protocol.ByteArrayBody;
import com.google.common.base.Preconditions;

/* compiled from: keyword_cost */
public class MediaAttachementBody implements Parcelable {
    public static final Creator<MediaAttachementBody> CREATOR = new C07571();
    String f11887a;
    byte[] f11888b;
    String f11889c;
    String f11890d;

    /* compiled from: keyword_cost */
    final class C07571 implements Creator<MediaAttachementBody> {
        C07571() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new MediaAttachementBody(parcel);
        }

        public final Object[] newArray(int i) {
            return new MediaAttachementBody[i];
        }
    }

    public MediaAttachementBody(String str, byte[] bArr, String str2, String str3) {
        Preconditions.checkArgument(bArr != null, "Attachement must have data");
        this.f11887a = str;
        this.f11888b = bArr;
        this.f11889c = str2;
        this.f11890d = str3;
    }

    public MediaAttachementBody(Parcel parcel) {
        this.f11887a = parcel.readString();
        this.f11888b = new byte[parcel.readInt()];
        parcel.readByteArray(this.f11888b);
        this.f11889c = parcel.readString();
        this.f11890d = parcel.readString();
    }

    public final FormBodyPart m18846a() {
        return new FormBodyPart(this.f11887a, new ByteArrayBody(this.f11888b, this.f11889c, this.f11890d));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f11887a);
        parcel.writeInt(this.f11888b.length);
        parcel.writeByteArray(this.f11888b);
        parcel.writeString(this.f11889c);
        parcel.writeString(this.f11890d);
    }
}
