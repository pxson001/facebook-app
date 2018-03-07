package com.facebook.captcha.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.util.JSONUtil;
import com.facebook.device_id.UniqueIdForDeviceHolderImpl;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: isTrickyBin */
public class SolveCaptchaMethod implements ApiMethod<Params, Boolean> {
    private final UniqueIdForDeviceHolderImpl f10673a;

    /* compiled from: isTrickyBin */
    public class Params implements Parcelable {
        public static final Creator<Params> CREATOR = new C11361();
        public final String f10671a;
        public final String f10672b;

        /* compiled from: isTrickyBin */
        final class C11361 implements Creator<Params> {
            C11361() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new Params(parcel);
            }

            public final Object[] newArray(int i) {
                return new Params[i];
            }
        }

        public Params(String str, String str2) {
            this.f10671a = str;
            this.f10672b = str2;
        }

        public Params(Parcel parcel) {
            this.f10671a = parcel.readString();
            this.f10672b = parcel.readString();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f10671a);
            parcel.writeString(this.f10672b);
        }
    }

    public final ApiRequest m12608a(Object obj) {
        Params params = (Params) obj;
        List arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("persist_data", params.f10671a));
        arrayList.add(new BasicNameValuePair("input", params.f10672b));
        arrayList.add(new BasicNameValuePair("device_id", this.f10673a.a()));
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "validateCaptcha";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = "captcha/validations";
        newBuilder = newBuilder;
        newBuilder.g = arrayList;
        ApiRequestBuilder a = newBuilder.a(RequestPriority.INTERACTIVE);
        a.k = ApiResponseType.JSON;
        return a.C();
    }

    @Inject
    public SolveCaptchaMethod(UniqueIdForDeviceHolderImpl uniqueIdForDeviceHolderImpl) {
        this.f10673a = uniqueIdForDeviceHolderImpl;
    }

    public final Object m12609a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return Boolean.valueOf(JSONUtil.g(apiResponse.c().f("success")));
    }
}
