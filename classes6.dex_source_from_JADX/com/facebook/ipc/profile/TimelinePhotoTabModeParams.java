package com.facebook.ipc.profile;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: latestActionId */
public class TimelinePhotoTabModeParams implements Parcelable {
    public static final Creator<TimelinePhotoTabModeParams> CREATOR = new C07471();
    private final TimelinePhotoEditMode f11676a;
    public final long f11677b;

    /* compiled from: latestActionId */
    final class C07471 implements Creator<TimelinePhotoTabModeParams> {
        C07471() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new TimelinePhotoTabModeParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new TimelinePhotoTabModeParams[i];
        }
    }

    public TimelinePhotoTabModeParams(TimelinePhotoEditMode timelinePhotoEditMode, long j) {
        this.f11676a = timelinePhotoEditMode;
        this.f11677b = j;
    }

    public TimelinePhotoTabModeParams(Parcel parcel) {
        this.f11676a = (TimelinePhotoEditMode) parcel.readSerializable();
        this.f11677b = parcel.readLong();
    }

    public final boolean m18359a() {
        return this.f11676a == TimelinePhotoEditMode.VIEWING_MODE;
    }

    public final boolean m18360c() {
        return this.f11676a == TimelinePhotoEditMode.EDIT_PROFILE_PIC;
    }

    public final boolean m18361d() {
        return this.f11676a == TimelinePhotoEditMode.EDIT_COVER_PHOTO;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeSerializable(this.f11676a);
        parcel.writeLong(this.f11677b);
    }
}
