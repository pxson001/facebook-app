package com.facebook.photos.upload.operation;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: glBindTexture  */
public class UploadRecords implements Parcelable {
    public static final Creator<UploadRecords> CREATOR = new C08881();
    public final Map<String, UploadRecord> f13832a;

    /* compiled from: glBindTexture  */
    final class C08881 implements Creator<UploadRecords> {
        C08881() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new UploadRecords(parcel);
        }

        public final Object[] newArray(int i) {
            return new UploadRecords[i];
        }
    }

    public UploadRecords(Map<String, UploadRecord> map) {
        this.f13832a = map;
    }

    public UploadRecords(Parcel parcel) {
        this.f13832a = Maps.c();
        parcel.readMap(this.f13832a, getClass().getClassLoader());
    }

    public final ImmutableMap<String, UploadRecord> m21600a() {
        return ImmutableMap.copyOf(this.f13832a);
    }

    @Nullable
    public final UploadRecord m21599a(String str) {
        return (UploadRecord) this.f13832a.get(str);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeMap(this.f13832a);
    }

    public int describeContents() {
        return 0;
    }
}
