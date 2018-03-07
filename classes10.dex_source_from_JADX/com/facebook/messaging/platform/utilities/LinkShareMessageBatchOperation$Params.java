package com.facebook.messaging.platform.utilities;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.share.model.ShareItem;
import java.io.IOException;

/* compiled from: registration_flow_state */
public class LinkShareMessageBatchOperation$Params implements Parcelable {
    public static final Creator<LinkShareMessageBatchOperation$Params> CREATOR = new C05711();
    public final ShareItem f3655a;

    /* compiled from: registration_flow_state */
    final class C05711 implements Creator<LinkShareMessageBatchOperation$Params> {
        C05711() {
        }

        public final Object createFromParcel(Parcel parcel) {
            try {
                return new LinkShareMessageBatchOperation$Params(parcel);
            } catch (IOException e) {
                return null;
            }
        }

        public final Object[] newArray(int i) {
            return new LinkShareMessageBatchOperation$Params[i];
        }
    }

    public LinkShareMessageBatchOperation$Params(ShareItem shareItem) {
        this.f3655a = shareItem;
    }

    public LinkShareMessageBatchOperation$Params(Parcel parcel) {
        this.f3655a = (ShareItem) parcel.readParcelable(ShareItem.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f3655a, i);
    }
}
