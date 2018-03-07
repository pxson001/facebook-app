package com.facebook.messaging.business.nativesignup.protocol.methods;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.google.common.collect.ImmutableList;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: multipart/form-data */
public class ProxyLoginMethod implements ApiMethod<Params, Void> {
    private static final Class<?> f8909a = ProxyLoginMethod.class;

    /* compiled from: multipart/form-data */
    public class Params implements Parcelable {
        public static final Creator<Params> CREATOR = new C10131();
        public final String f8907a;
        public final String f8908b;

        /* compiled from: multipart/form-data */
        final class C10131 implements Creator<Params> {
            C10131() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new Params(parcel);
            }

            public final Object[] newArray(int i) {
                return new Params[i];
            }
        }

        public Params(String str, String str2) {
            this.f8907a = str;
            this.f8908b = str2;
        }

        public Params(Parcel parcel) {
            this.f8907a = parcel.readString();
            this.f8908b = parcel.readString();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f8907a);
            parcel.writeString(this.f8908b);
        }
    }

    public final ApiRequest m9169a(Object obj) {
        Params params = (Params) obj;
        ImmutableList of = ImmutableList.of(new BasicNameValuePair("proxied_app_id", params.f8907a), new BasicNameValuePair("permissions", params.f8908b));
        of.toString();
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "proxyLogin";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = "/v2.5/auth/proxy_login";
        newBuilder = newBuilder;
        newBuilder.g = of;
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.k = ApiResponseType.JSON;
        return apiRequestBuilder.a(RequestPriority.INTERACTIVE).C();
    }

    public final Object m9170a(Object obj, ApiResponse apiResponse) {
        apiResponse.c().B();
        return null;
    }
}
