package com.facebook.messaging.model.share;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.util.Locale;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: upload-video-chunk-cancel */
public class ShareMedia implements Parcelable {
    public static final Creator<ShareMedia> CREATOR = new C01091();
    public final Type f2208a;
    @Nullable
    public final String f2209b;
    @Nullable
    public final String f2210c;
    @Nullable
    public final String f2211d;

    /* compiled from: upload-video-chunk-cancel */
    final class C01091 implements Creator<ShareMedia> {
        C01091() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ShareMedia(parcel);
        }

        public final Object[] newArray(int i) {
            return new ShareMedia[i];
        }
    }

    /* compiled from: upload-video-chunk-cancel */
    public enum Type implements Parcelable {
        PHOTO,
        VIDEO,
        LINK,
        UNKNOWN;
        
        public static final Creator<Type> CREATOR = null;

        /* compiled from: upload-video-chunk-cancel */
        final class C01101 implements Creator<Type> {
            C01101() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return Type.values()[parcel.readInt()];
            }

            public final Object[] newArray(int i) {
                return new Type[i];
            }
        }

        static {
            CREATOR = new C01101();
        }

        public static Type fromString(String str) {
            try {
                return valueOf(str.toUpperCase(Locale.US));
            } catch (NullPointerException e) {
                return UNKNOWN;
            } catch (IllegalArgumentException e2) {
                return UNKNOWN;
            }
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(ordinal());
        }
    }

    ShareMedia(ShareMediaBuilder shareMediaBuilder) {
        Preconditions.checkNotNull(shareMediaBuilder.f2212a);
        this.f2209b = shareMediaBuilder.f2213b;
        this.f2208a = shareMediaBuilder.f2212a;
        this.f2210c = shareMediaBuilder.f2214c;
        this.f2211d = shareMediaBuilder.f2215d;
    }

    public ShareMedia(Parcel parcel) {
        this.f2209b = parcel.readString();
        this.f2208a = (Type) parcel.readParcelable(Type.class.getClassLoader());
        this.f2210c = parcel.readString();
        this.f2211d = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2209b);
        parcel.writeParcelable(this.f2208a, i);
        parcel.writeString(this.f2210c);
        parcel.writeString(this.f2211d);
    }

    public String toString() {
        return Objects.toStringHelper(ShareMedia.class).add("href", this.f2209b).add("type", this.f2208a.toString()).add("src", this.f2210c).add("playableSrc", this.f2211d).toString();
    }
}
