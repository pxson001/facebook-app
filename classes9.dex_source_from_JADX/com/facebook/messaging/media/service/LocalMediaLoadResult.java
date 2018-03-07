package com.facebook.messaging.media.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.ui.media.attachments.MediaResource;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: lockscreen_cam_is_open */
public class LocalMediaLoadResult implements Parcelable {
    public static final Creator<LocalMediaLoadResult> CREATOR = new C13351();
    public final ImmutableList<MediaResource> f11820a;

    /* compiled from: lockscreen_cam_is_open */
    final class C13351 implements Creator<LocalMediaLoadResult> {
        C13351() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new LocalMediaLoadResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new LocalMediaLoadResult[i];
        }
    }

    public LocalMediaLoadResult(List<MediaResource> list) {
        this.f11820a = ImmutableList.copyOf(list);
    }

    public LocalMediaLoadResult(Parcel parcel) {
        this.f11820a = ParcelUtil.a(parcel, MediaResource.CREATOR);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.f11820a);
    }
}
