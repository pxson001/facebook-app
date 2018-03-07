package com.facebook.messaging.sharedimage;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.photos.service.MediaMessageItem;
import com.facebook.messaging.sharedimage.graphql.SharedImageHistoryQueryModels.PhotoNodeInfoModel;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ui.media.attachments.MediaResource.Source;
import com.facebook.ui.media.attachments.MediaResource.Type;
import com.facebook.ui.media.attachments.MediaResourceBuilder;
import com.facebook.user.model.UserKey;
import javax.annotation.Nullable;

/* compiled from: quick_reply_send */
public class SharedImage implements Parcelable, MediaMessageItem {
    public static final Creator<SharedImage> CREATOR = new C06021();
    public final int f4002a;
    public final int f4003b;
    public boolean f4004c = false;
    public Uri f4005d = null;
    private final MediaResource f4006e;
    private final String f4007f;
    private final String f4008g;
    private final String f4009h;
    private final String f4010i;

    /* compiled from: quick_reply_send */
    final class C06021 implements Creator<SharedImage> {
        C06021() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SharedImage((MediaResource) parcel.readParcelable(MediaResource.class.getClassLoader()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        public final Object[] newArray(int i) {
            return new SharedImage[i];
        }
    }

    public SharedImage(MediaResource mediaResource, String str, String str2, String str3, String str4) {
        this.f4006e = mediaResource;
        this.f4007f = str;
        this.f4008g = str2;
        this.f4009h = str3;
        this.f4010i = str4;
        this.f4002a = mediaResource.j;
        this.f4003b = mediaResource.k;
    }

    public static SharedImage m3720a(PhotoNodeInfoModel photoNodeInfoModel) {
        String k;
        String j;
        String j2;
        String a;
        if (photoNodeInfoModel.k() != null) {
            k = photoNodeInfoModel.k().k();
            j = photoNodeInfoModel.k().j();
        } else {
            j = null;
            k = null;
        }
        if (photoNodeInfoModel.n() != null) {
            j2 = photoNodeInfoModel.n().j();
            a = photoNodeInfoModel.n().k() == null ? "" : photoNodeInfoModel.n().k().a();
        } else {
            a = null;
            j2 = null;
        }
        MediaResourceBuilder a2 = MediaResource.a();
        a2.b = Type.PHOTO;
        a2 = a2;
        a2.c = Source.SHARED_MEDIA;
        a2 = a2;
        a2.d = Uri.parse(photoNodeInfoModel.l().a());
        a2 = a2;
        a2.a = Uri.parse(photoNodeInfoModel.a().a());
        a2 = a2;
        a2.s = photoNodeInfoModel.m();
        a2 = a2;
        a2.h = (int) photoNodeInfoModel.o().a();
        a2 = a2;
        a2.i = (int) photoNodeInfoModel.o().j();
        a2 = a2;
        a2.y = photoNodeInfoModel.j() * 1000;
        return new SharedImage(a2.C(), k, j, j2, a);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f4006e, i);
        parcel.writeString(this.f4007f);
        parcel.writeString(this.f4008g);
        parcel.writeString(this.f4009h);
        parcel.writeString(this.f4010i);
    }

    public final MediaResource m3727e() {
        return this.f4006e;
    }

    public final int m3724b() {
        return this.f4003b;
    }

    public final int m3725c() {
        return this.f4002a;
    }

    public final Uri m3726d() {
        return (this.f4005d == null || !this.f4004c) ? m3727e().c : this.f4005d;
    }

    public final void m3721a(Uri uri) {
        this.f4005d = uri;
    }

    public final void m3722a(boolean z) {
        this.f4004c = z;
    }

    public final boolean m3723a() {
        return this.f4004c;
    }

    @Nullable
    public final String m3728f() {
        return this.f4007f;
    }

    @Nullable
    public final UserKey m3729g() {
        return this.f4008g == null ? null : UserKey.b(this.f4008g);
    }

    public final String m3730h() {
        return this.f4010i;
    }

    public final Message m3731i() {
        return null;
    }

    public boolean equals(Object obj) {
        if (obj instanceof SharedImage) {
            return ((SharedImage) obj).m3727e().u.equals(this.f4006e.u);
        }
        return false;
    }

    public int hashCode() {
        return this.f4006e.u.hashCode();
    }
}
