package com.facebook.messaging.media.mediapicker.dialog;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.ipc.media.MediaItem;
import com.facebook.ipc.media.MediaItem.MediaType;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.photos.base.media.PhotoItem;
import com.facebook.photos.base.media.VideoItem;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ui.media.attachments.MediaResource.Type;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: lyft */
public class PickMediaDialogParams implements Parcelable {
    public static final Creator<PickMediaDialogParams> CREATOR = new C13211();
    public final PickMediaSource f11769a;
    public final CropImageParams f11770b;
    public final boolean f11771c;
    public final ImmutableSet<Type> f11772d;
    public final MediaResource f11773e;
    public final boolean f11774f;
    public final ArrayList<MediaItem> f11775g;
    public final ThreadKey f11776h;
    public final String f11777i;

    /* compiled from: lyft */
    final class C13211 implements Creator<PickMediaDialogParams> {
        C13211() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PickMediaDialogParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new PickMediaDialogParams[i];
        }
    }

    /* compiled from: lyft */
    /* synthetic */ class C13222 {
        static final /* synthetic */ int[] f11768a = new int[MediaType.values().length];

        static {
            try {
                f11768a[MediaType.PHOTO.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f11768a[MediaType.VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    PickMediaDialogParams(PickMediaDialogParamsBuilder pickMediaDialogParamsBuilder) {
        Preconditions.checkNotNull(pickMediaDialogParamsBuilder.f11778a);
        Preconditions.checkNotNull(pickMediaDialogParamsBuilder.f11781d);
        this.f11769a = pickMediaDialogParamsBuilder.f11778a;
        this.f11770b = pickMediaDialogParamsBuilder.f11779b;
        this.f11771c = pickMediaDialogParamsBuilder.f11780c;
        this.f11772d = ImmutableSet.copyOf(pickMediaDialogParamsBuilder.f11781d);
        this.f11773e = pickMediaDialogParamsBuilder.f11782e;
        this.f11774f = pickMediaDialogParamsBuilder.f11783f;
        this.f11775g = pickMediaDialogParamsBuilder.f11784g;
        this.f11776h = pickMediaDialogParamsBuilder.f11785h;
        this.f11777i = pickMediaDialogParamsBuilder.f11786i;
    }

    public PickMediaDialogParams(Parcel parcel) {
        this.f11769a = (PickMediaSource) parcel.readSerializable();
        this.f11770b = (CropImageParams) parcel.readParcelable(CropImageParams.class.getClassLoader());
        this.f11771c = ParcelUtil.a(parcel);
        this.f11772d = (ImmutableSet) parcel.readSerializable();
        this.f11773e = (MediaResource) parcel.readParcelable(MediaResource.class.getClassLoader());
        this.f11774f = ParcelUtil.a(parcel);
        this.f11776h = (ThreadKey) parcel.readParcelable(ThreadKey.class.getClassLoader());
        this.f11777i = parcel.readString();
        int readInt = parcel.readInt();
        if (readInt > 0) {
            this.f11775g = Lists.a();
            for (int i = 0; i < readInt; i++) {
                switch (C13222.f11768a[((MediaType) parcel.readSerializable()).ordinal()]) {
                    case 1:
                        this.f11775g.add(PhotoItem.CREATOR.createFromParcel(parcel));
                        break;
                    case 2:
                        this.f11775g.add(VideoItem.CREATOR.createFromParcel(parcel));
                        break;
                    default:
                        break;
                }
            }
            return;
        }
        this.f11775g = null;
    }

    public static PickMediaDialogParamsBuilder newBuilder() {
        return new PickMediaDialogParamsBuilder();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeSerializable(this.f11769a);
        parcel.writeParcelable(this.f11770b, i);
        ParcelUtil.a(parcel, this.f11771c);
        parcel.writeSerializable(this.f11772d);
        parcel.writeParcelable(this.f11773e, i);
        ParcelUtil.a(parcel, this.f11774f);
        parcel.writeParcelable(this.f11776h, i);
        parcel.writeString(this.f11777i);
        if (this.f11775g == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(this.f11775g.size());
        int size = this.f11775g.size();
        for (int i2 = 0; i2 < size; i2++) {
            MediaItem mediaItem = (MediaItem) this.f11775g.get(i2);
            parcel.writeSerializable(mediaItem.l());
            mediaItem.writeToParcel(parcel, i);
        }
    }
}
