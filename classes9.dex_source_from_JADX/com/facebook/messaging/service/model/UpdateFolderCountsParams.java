package com.facebook.messaging.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.messaging.model.folders.FolderName;

/* compiled from: confirmation_fragment_tag */
public class UpdateFolderCountsParams implements Parcelable {
    public static final Creator<UpdateFolderCountsParams> CREATOR = new C20631();
    public final FolderName f17336a;
    public final int f17337b;
    public final int f17338c;

    /* compiled from: confirmation_fragment_tag */
    final class C20631 implements Creator<UpdateFolderCountsParams> {
        C20631() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new UpdateFolderCountsParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new UpdateFolderCountsParams[i];
        }
    }

    public UpdateFolderCountsParams(FolderName folderName, int i, int i2) {
        this.f17336a = folderName;
        this.f17337b = i;
        this.f17338c = i2;
    }

    public UpdateFolderCountsParams(Parcel parcel) {
        this.f17336a = (FolderName) parcel.readSerializable();
        this.f17337b = parcel.readInt();
        this.f17338c = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeSerializable(this.f17336a);
        parcel.writeInt(this.f17337b);
        parcel.writeInt(this.f17338c);
    }
}
