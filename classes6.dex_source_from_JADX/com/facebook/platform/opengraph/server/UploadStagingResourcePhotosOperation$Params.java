package com.facebook.platform.opengraph.server;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.collect.ImmutableMap;
import java.io.IOException;

/* compiled from: ff794e661764309c506def0febf6e9b5 */
public class UploadStagingResourcePhotosOperation$Params implements Parcelable {
    public static final Creator<UploadStagingResourcePhotosOperation$Params> CREATOR = new C09831();
    public final ImmutableMap<Uri, Bitmap> f14924a;

    /* compiled from: ff794e661764309c506def0febf6e9b5 */
    final class C09831 implements Creator<UploadStagingResourcePhotosOperation$Params> {
        C09831() {
        }

        public final Object createFromParcel(Parcel parcel) {
            try {
                return new UploadStagingResourcePhotosOperation$Params(parcel);
            } catch (IOException e) {
                return null;
            }
        }

        public final Object[] newArray(int i) {
            return new UploadStagingResourcePhotosOperation$Params[i];
        }
    }

    public UploadStagingResourcePhotosOperation$Params(ImmutableMap<Uri, Bitmap> immutableMap) {
        this.f14924a = immutableMap;
    }

    public UploadStagingResourcePhotosOperation$Params(Parcel parcel) {
        this.f14924a = (ImmutableMap) parcel.readSerializable();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeSerializable(this.f14924a);
    }
}
