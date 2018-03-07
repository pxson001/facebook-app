package com.facebook.messaging.platform.utilities;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.share.model.ShareItem;
import java.io.IOException;

/* compiled from: registration_flow_exit */
public class OpenGraphMessageBatchOperation$Params implements Parcelable {
    public static final Creator<OpenGraphMessageBatchOperation$Params> CREATOR = new C05721();
    public final ShareItem f3656a;
    public final Bundle f3657b;
    public final String f3658c;

    /* compiled from: registration_flow_exit */
    final class C05721 implements Creator<OpenGraphMessageBatchOperation$Params> {
        C05721() {
        }

        public final Object createFromParcel(Parcel parcel) {
            try {
                return new OpenGraphMessageBatchOperation$Params(parcel);
            } catch (IOException e) {
                return null;
            }
        }

        public final Object[] newArray(int i) {
            return new OpenGraphMessageBatchOperation$Params[i];
        }
    }

    public OpenGraphMessageBatchOperation$Params(ShareItem shareItem, Bundle bundle, String str) {
        this.f3656a = shareItem;
        this.f3657b = bundle;
        this.f3658c = str;
    }

    public OpenGraphMessageBatchOperation$Params(Parcel parcel) {
        this.f3656a = (ShareItem) parcel.readParcelable(ShareItem.class.getClassLoader());
        this.f3657b = parcel.readBundle();
        this.f3658c = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f3656a, i);
        parcel.writeBundle(this.f3657b);
        parcel.writeString(this.f3658c);
    }
}
