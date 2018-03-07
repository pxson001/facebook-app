package com.facebook.facecastdisplay.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: statusToUpdate */
public class MutateLiveScribeMethod implements ApiMethod<Params, Void> {

    /* compiled from: statusToUpdate */
    public class Params implements Parcelable {
        public static final Creator<Params> CREATOR = new C02841();
        public String f3279a;
        public String f3280b;
        public String f3281c;
        public boolean f3282d;

        /* compiled from: statusToUpdate */
        final class C02841 implements Creator<Params> {
            C02841() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new Params(parcel);
            }

            public final Object[] newArray(int i) {
                return new Params[i];
            }
        }

        public Params(String str, String str2, String str3, boolean z) {
            this.f3279a = str;
            this.f3280b = str2;
            this.f3281c = str3;
            this.f3282d = z;
        }

        public Params(Parcel parcel) {
            this.f3279a = parcel.readString();
            this.f3280b = parcel.readString();
            this.f3281c = parcel.readString();
            this.f3282d = ParcelUtil.a(parcel);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f3279a);
            parcel.writeString(this.f3280b);
            parcel.writeString(this.f3281c);
            ParcelUtil.a(parcel, this.f3282d);
        }
    }

    public final ApiRequest m4048a(Object obj) {
        String str;
        Params params = (Params) obj;
        List arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("format", "json"));
        arrayList.add(new BasicNameValuePair("live_video_id", params.f3279a));
        arrayList.add(new BasicNameValuePair("broadcaster_id", params.f3280b));
        arrayList.add(new BasicNameValuePair("surface", params.f3281c));
        ApiRequestBuilder apiRequestBuilder = new ApiRequestBuilder();
        apiRequestBuilder.b = "live_video_subscriptions";
        ApiRequestBuilder apiRequestBuilder2 = apiRequestBuilder;
        if (params.f3282d) {
            str = "POST";
        } else {
            str = "DELETE";
        }
        apiRequestBuilder2.c = str;
        apiRequestBuilder = apiRequestBuilder2;
        apiRequestBuilder.d = "me/live_video_subscriptions";
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.g = arrayList;
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.k = ApiResponseType.JSON;
        return apiRequestBuilder.C();
    }

    public final Object m4049a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return null;
    }
}
