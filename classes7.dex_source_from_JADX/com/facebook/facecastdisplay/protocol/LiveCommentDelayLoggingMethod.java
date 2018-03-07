package com.facebook.facecastdisplay.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: sticker_count */
public class LiveCommentDelayLoggingMethod implements ApiMethod<Params, Void> {

    /* compiled from: sticker_count */
    public class Params implements Parcelable {
        public static final Creator<Params> CREATOR = new C02811();
        public String f3273a;
        public double f3274b;

        /* compiled from: sticker_count */
        final class C02811 implements Creator<Params> {
            C02811() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new Params(parcel);
            }

            public final Object[] newArray(int i) {
                return new Params[i];
            }
        }

        public Params(String str, double d) {
            this.f3273a = str;
            this.f3274b = d;
        }

        public Params(Parcel parcel) {
            this.f3273a = parcel.readString();
            this.f3274b = parcel.readDouble();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f3273a);
            parcel.writeDouble(this.f3274b);
        }
    }

    public final ApiRequest m4042a(Object obj) {
        Params params = (Params) obj;
        List arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("format", "json"));
        arrayList.add(new BasicNameValuePair("comment_id", params.f3273a));
        arrayList.add(new BasicNameValuePair("client_time", String.valueOf(params.f3274b)));
        ApiRequestBuilder apiRequestBuilder = new ApiRequestBuilder();
        apiRequestBuilder.b = "facecast_live_comment_delay_logging_events";
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.c = "POST";
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.d = "me/facecast_live_comment_delay_logging_events";
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.g = arrayList;
        ApiRequestBuilder apiRequestBuilder2 = apiRequestBuilder;
        apiRequestBuilder2.k = ApiResponseType.JSON;
        return apiRequestBuilder2.C();
    }

    @Nullable
    public final Object m4043a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return null;
    }
}
