package com.facebook.messaging.attachments;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.util.StringUtil;
import com.facebook.ui.media.attachments.MediaResource;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: p2p_cancel_settings */
public class ImageAttachmentData implements Parcelable, DownloadableAttachment {
    public static final Creator<ImageAttachmentData> CREATOR = new C08551();
    private static final Class<?> f7725i = ImageAttachmentData.class;
    public final ImageAttachmentUris f7726a;
    @Nullable
    public final ImageAttachmentUris f7727b;
    public final int f7728c;
    public final int f7729d;
    @Nullable
    public final String f7730e;
    @Nullable
    public final MediaResource f7731f;
    public final boolean f7732g;
    public final String f7733h;

    /* compiled from: p2p_cancel_settings */
    final class C08551 implements Creator<ImageAttachmentData> {
        C08551() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ImageAttachmentData(parcel);
        }

        public final Object[] newArray(int i) {
            return new ImageAttachmentData[i];
        }
    }

    /* compiled from: p2p_cancel_settings */
    public enum Orientation {
        LANDSCAPE,
        PORTRAIT,
        SQUARE,
        UNKNOWN
    }

    public ImageAttachmentData(ImageAttachmentDataBuilder imageAttachmentDataBuilder) {
        this.f7726a = (ImageAttachmentUris) Preconditions.checkNotNull(imageAttachmentDataBuilder.f7734a);
        this.f7727b = imageAttachmentDataBuilder.f7735b;
        this.f7728c = imageAttachmentDataBuilder.f7736c;
        this.f7729d = imageAttachmentDataBuilder.f7737d;
        this.f7731f = imageAttachmentDataBuilder.f7738e;
        this.f7730e = imageAttachmentDataBuilder.f7739f;
        this.f7732g = imageAttachmentDataBuilder.f7740g;
        this.f7733h = imageAttachmentDataBuilder.f7741h;
    }

    public ImageAttachmentData(Parcel parcel) {
        this.f7726a = (ImageAttachmentUris) parcel.readParcelable(ImageAttachmentUris.class.getClassLoader());
        this.f7727b = (ImageAttachmentUris) parcel.readParcelable(ImageAttachmentUris.class.getClassLoader());
        this.f7728c = parcel.readInt();
        this.f7729d = parcel.readInt();
        this.f7731f = (MediaResource) parcel.readParcelable(MediaResource.class.getClassLoader());
        this.f7730e = parcel.readString();
        this.f7732g = parcel.readInt() == 1;
        this.f7733h = parcel.readString();
    }

    public final boolean m8024b() {
        return this.f7728c > 0 && this.f7729d > 0;
    }

    public final Orientation m8025c() {
        if (!m8024b()) {
            return Orientation.UNKNOWN;
        }
        if (this.f7728c == this.f7729d) {
            return Orientation.SQUARE;
        }
        if (this.f7728c < this.f7729d) {
            return Orientation.PORTRAIT;
        }
        return Orientation.LANDSCAPE;
    }

    public final boolean mo286a() {
        return !StringUtil.a(this.f7730e);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f7726a, i);
        parcel.writeParcelable(this.f7727b, i);
        parcel.writeInt(this.f7728c);
        parcel.writeInt(this.f7729d);
        parcel.writeParcelable(this.f7731f, i);
        parcel.writeString(this.f7730e);
        parcel.writeInt(this.f7732g ? 1 : 0);
        parcel.writeString(this.f7733h);
    }
}
