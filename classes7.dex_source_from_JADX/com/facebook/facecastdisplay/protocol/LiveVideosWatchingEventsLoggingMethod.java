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

/* compiled from: status_message */
public class LiveVideosWatchingEventsLoggingMethod implements ApiMethod<Params, Void> {

    /* compiled from: status_message */
    public class Params implements Parcelable {
        public static final Creator<Params> CREATOR = new C02831();
        public String f3277a;
        public int f3278b;

        /* compiled from: status_message */
        final class C02831 implements Creator<Params> {
            C02831() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new Params(parcel);
            }

            public final Object[] newArray(int i) {
                return new Params[i];
            }
        }

        public Params(String str, int i) {
            this.f3277a = str;
            this.f3278b = i;
        }

        public Params(Parcel parcel) {
            this.f3277a = parcel.readString();
            this.f3278b = parcel.readInt();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f3277a);
            parcel.writeInt(this.f3278b);
        }
    }

    public final ApiRequest m4046a(Object obj) {
        Params params = (Params) obj;
        List arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("format", "json"));
        arrayList.add(new BasicNameValuePair("video_id", params.f3277a));
        arrayList.add(new BasicNameValuePair("timespent_watching_video", String.valueOf(params.f3278b)));
        ApiRequestBuilder apiRequestBuilder = new ApiRequestBuilder();
        apiRequestBuilder.b = "live_videos_watching_events";
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.c = "POST";
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.d = "live_videos_watching_events";
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.g = arrayList;
        ApiRequestBuilder apiRequestBuilder2 = apiRequestBuilder;
        apiRequestBuilder2.k = ApiResponseType.JSON;
        return apiRequestBuilder2.C();
    }

    @Nullable
    public final Object m4047a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return null;
    }
}
