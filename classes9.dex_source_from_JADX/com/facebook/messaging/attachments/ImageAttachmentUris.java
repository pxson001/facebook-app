package com.facebook.messaging.attachments;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: p2p_cancel_request */
public class ImageAttachmentUris implements Parcelable {
    public static final Creator<ImageAttachmentUris> CREATOR = new C08561();
    public final Uri f7742a;
    @Nullable
    public final Uri f7743b;
    @Nullable
    public final Uri f7744c;
    @Nullable
    public final Uri f7745d;
    @Nullable
    public final Uri f7746e;

    /* compiled from: p2p_cancel_request */
    final class C08561 implements Creator<ImageAttachmentUris> {
        C08561() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ImageAttachmentUris(parcel);
        }

        public final Object[] newArray(int i) {
            return new ImageAttachmentUris[i];
        }
    }

    ImageAttachmentUris(ImageAttachmentUrisBuilder imageAttachmentUrisBuilder) {
        this.f7742a = (Uri) Preconditions.checkNotNull(imageAttachmentUrisBuilder.f7747a);
        this.f7743b = imageAttachmentUrisBuilder.f7748b;
        this.f7744c = imageAttachmentUrisBuilder.f7749c;
        this.f7745d = imageAttachmentUrisBuilder.f7750d;
        this.f7746e = imageAttachmentUrisBuilder.f7751e;
    }

    private ImageAttachmentUris(Uri uri) {
        this.f7742a = (Uri) Preconditions.checkNotNull(uri);
        this.f7743b = null;
        this.f7744c = null;
        this.f7745d = null;
        this.f7746e = null;
    }

    public ImageAttachmentUris(Parcel parcel) {
        this.f7742a = (Uri) parcel.readParcelable(null);
        this.f7743b = (Uri) parcel.readParcelable(null);
        this.f7744c = (Uri) parcel.readParcelable(null);
        this.f7745d = (Uri) parcel.readParcelable(null);
        this.f7746e = (Uri) parcel.readParcelable(null);
    }

    public static ImageAttachmentUrisBuilder newBuilder() {
        return new ImageAttachmentUrisBuilder();
    }

    public static ImageAttachmentUris m8027a(Uri uri) {
        return new ImageAttachmentUris(uri);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f7742a, i);
        parcel.writeParcelable(this.f7743b, i);
        parcel.writeParcelable(this.f7744c, i);
        parcel.writeParcelable(this.f7745d, i);
        parcel.writeParcelable(this.f7746e, i);
    }
}
