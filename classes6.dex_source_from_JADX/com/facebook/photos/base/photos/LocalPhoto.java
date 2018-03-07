package com.facebook.photos.base.photos;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.ipc.media.MediaIdKey;
import com.facebook.photos.base.photos.Photo.PhotoSize;
import com.facebook.photos.base.tagging.FaceBox;
import com.facebook.photos.base.tagging.Tag;
import com.facebook.photos.base.tagging.TagTarget;
import com.facebook.photos.base.tagging.TaggablePhoto;
import com.facebook.ui.images.base.UrlImageProcessor;
import com.facebook.ui.images.cache.ImageCacheKey.Options;
import com.facebook.ui.images.cache.ImageCacheKey.OptionsBuilder;
import com.facebook.ui.images.fetch.FetchImageParams;
import com.facebook.ui.images.fetch.FetchImageParams.Builder;
import com.google.common.collect.Lists;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: initial_slideshow_data */
public class LocalPhoto extends TaggablePhoto implements Parcelable {
    public static final Creator<LocalPhoto> CREATOR = new C08041();
    public String f12748d;
    public int f12749e;
    public boolean f12750f;
    private MediaIdKey f12751g;

    /* compiled from: initial_slideshow_data */
    final class C08041 implements Creator<LocalPhoto> {
        public final Object createFromParcel(Parcel parcel) {
            int readInt = parcel.readInt();
            List a = Lists.a();
            for (int i = 0; i < readInt; i++) {
                a.add((Tag) parcel.readParcelable(Tag.class.getClassLoader()));
            }
            List<Tag> list = a;
            List b = LocalPhoto.m20127b(parcel);
            for (Tag tag : list) {
                tag.f12786a = C08041.m20122a(b, tag.f12786a);
            }
            return new LocalPhoto(parcel, parcel.readLong(), (List) list, b);
        }

        C08041() {
        }

        public final Object[] newArray(int i) {
            return new LocalPhoto[i];
        }

        private static TagTarget m20122a(@Nullable List<FaceBox> list, TagTarget tagTarget) {
            if (list == null || !(tagTarget instanceof FaceBox)) {
                return tagTarget;
            }
            FaceBox faceBox = (FaceBox) tagTarget;
            for (FaceBox faceBox2 : list) {
                if (faceBox.f12765a.equals(faceBox2.f12765a)) {
                    return faceBox2;
                }
            }
            return tagTarget;
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        List<Tag> list = this.f12747d;
        if (list != null) {
            parcel.writeInt(list.size());
            for (Tag writeParcelable : list) {
                parcel.writeParcelable(writeParcelable, i);
            }
        } else {
            parcel.writeInt(0);
        }
        if (this.f12746c == null) {
            parcel.writeInt(-1);
        } else {
            List<FaceBox> list2 = this.f12746c;
            parcel.writeInt(list2.size());
            for (FaceBox writeParcelable2 : list2) {
                parcel.writeParcelable(writeParcelable2, i);
            }
        }
        parcel.writeLong(this.f12744a);
        parcel.writeInt(this.f12749e);
        parcel.writeString(this.f12748d);
        ParcelUtil.a(parcel, this.f12750f);
    }

    public LocalPhoto(long j, List<Tag> list, List<FaceBox> list2, String str, int i) {
        super(j, list, list2);
        this.f12748d = str;
        this.f12749e = i;
        this.f12750f = false;
        this.f12751g = new MediaIdKey(this.f12748d, j);
    }

    private LocalPhoto(Parcel parcel, long j, List<Tag> list, List<FaceBox> list2) {
        super(j, list, list2);
        this.f12749e = parcel.readInt();
        this.f12748d = parcel.readString();
        this.f12750f = ParcelUtil.a(parcel);
        this.f12751g = new MediaIdKey(this.f12748d, j);
    }

    @Nullable
    public static final List<FaceBox> m20127b(Parcel parcel) {
        int readInt = parcel.readInt();
        if (readInt == -1) {
            return null;
        }
        List<FaceBox> a = Lists.a();
        for (int i = 0; i < readInt; i++) {
            a.add((FaceBox) parcel.readParcelable(FaceBox.class.getClassLoader()));
        }
        return a;
    }

    public final MediaIdKey mo1094a() {
        return this.f12751g;
    }

    public final int m20130c() {
        return this.f12749e;
    }

    @Nullable
    private static FetchImageParams m20126a(String str, int i, PhotoSize photoSize) {
        boolean z = true;
        if (str == null) {
            return null;
        }
        UrlImageProcessor localPhotoImageProcessor;
        OptionsBuilder newBuilder = Options.newBuilder();
        switch (photoSize) {
            case SCREENNAIL:
                newBuilder.a(true);
                localPhotoImageProcessor = new LocalPhotoImageProcessor(i, PhotoSize.SCREENNAIL);
                break;
            case THUMBNAIL:
                newBuilder.a(240, 240);
                localPhotoImageProcessor = new LocalPhotoImageProcessor(i, PhotoSize.THUMBNAIL);
                break;
            default:
                throw new IllegalArgumentException("unknown size: " + photoSize);
        }
        if (photoSize != PhotoSize.THUMBNAIL) {
            z = false;
        }
        newBuilder.e = z;
        Options f = newBuilder.f();
        Builder a = FetchImageParams.a(Uri.parse("file://" + str));
        a.d = localPhotoImageProcessor;
        Builder builder = a;
        builder.e = f;
        return builder.a();
    }

    @Deprecated
    @Nullable
    public final FetchImageParams mo1095a(PhotoSize photoSize) {
        return m20126a(this.f12748d, this.f12749e, photoSize);
    }

    public int describeContents() {
        return 0;
    }

    public final boolean m20131d() {
        return this.f12750f;
    }
}
