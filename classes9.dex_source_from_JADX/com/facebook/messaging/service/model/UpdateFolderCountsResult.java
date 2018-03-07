package com.facebook.messaging.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.messaging.model.folders.FolderCounts;

/* compiled from: confirmation_dialogue */
public class UpdateFolderCountsResult implements Parcelable {
    public static final Creator<UpdateFolderCountsResult> CREATOR = new C20641();
    public final FolderCounts f17339a;

    /* compiled from: confirmation_dialogue */
    final class C20641 implements Creator<UpdateFolderCountsResult> {
        C20641() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new UpdateFolderCountsResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new UpdateFolderCountsResult[i];
        }
    }

    public UpdateFolderCountsResult(FolderCounts folderCounts) {
        this.f17339a = folderCounts;
    }

    public UpdateFolderCountsResult(Parcel parcel) {
        this.f17339a = (FolderCounts) parcel.readParcelable(FolderCounts.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f17339a, i);
    }
}
