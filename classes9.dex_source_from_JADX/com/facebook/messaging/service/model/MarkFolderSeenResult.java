package com.facebook.messaging.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.messaging.model.folders.FolderName;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: content_uri */
public class MarkFolderSeenResult implements Parcelable {
    public static final Creator<MarkFolderSeenResult> CREATOR = new C20361();
    public final long f17196a;
    public final FolderName f17197b;

    /* compiled from: content_uri */
    final class C20361 implements Creator<MarkFolderSeenResult> {
        C20361() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new MarkFolderSeenResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new MarkFolderSeenResult[i];
        }
    }

    public MarkFolderSeenResult(FolderName folderName, long j) {
        this.f17196a = j;
        this.f17197b = folderName;
    }

    public MarkFolderSeenResult(Parcel parcel) {
        this.f17196a = parcel.readLong();
        this.f17197b = (FolderName) parcel.readSerializable();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f17196a);
        parcel.writeSerializable(this.f17197b);
    }
}
