package com.facebook.friends.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: mThreadKey */
public class SetNotificationPreferenceMethod implements ApiMethod<Params, Void> {

    /* compiled from: mThreadKey */
    public class Params implements Parcelable {
        public static final Creator<Params> CREATOR = new C06651();
        public final long f10829a;
        public final boolean f10830b;

        /* compiled from: mThreadKey */
        final class C06651 implements Creator<Params> {
            C06651() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new Params(parcel);
            }

            public final Object[] newArray(int i) {
                return new Params[i];
            }
        }

        public Params(long j, boolean z) {
            this.f10829a = j;
            this.f10830b = z;
        }

        public Params(Parcel parcel) {
            boolean z = true;
            this.f10829a = parcel.readLong();
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.f10830b = z;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.f10829a);
            parcel.writeInt(this.f10830b ? 1 : 0);
        }
    }

    public final ApiRequest m17412a(Object obj) {
        Params params = (Params) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("notifier_id", String.valueOf(params.f10829a)));
        a.add(new BasicNameValuePair("enable", String.valueOf(params.f10830b)));
        a.add(new BasicNameValuePair("format", "json"));
        return new ApiRequest("subscribeToProfile", "POST", "me/notify_me", a, ApiResponseType.JSON);
    }

    public final Object m17413a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return null;
    }
}
