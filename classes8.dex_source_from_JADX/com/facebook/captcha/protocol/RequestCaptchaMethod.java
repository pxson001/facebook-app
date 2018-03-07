package com.facebook.captcha.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.util.JSONUtil;
import com.facebook.device_id.UniqueIdForDeviceHolderImpl;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: is_auto_provision_cta */
public class RequestCaptchaMethod implements ApiMethod<Void, Result> {
    private final UniqueIdForDeviceHolderImpl f10669a;

    @AutoGenJsonDeserializer
    @JsonDeserialize(using = RequestCaptchaMethod_ResultDeserializer.class)
    /* compiled from: is_auto_provision_cta */
    public class Result implements Parcelable {
        public static final Creator<Result> CREATOR = new C11351();
        private final String f10667a;
        private final String f10668b;

        /* compiled from: is_auto_provision_cta */
        final class C11351 implements Creator<Result> {
            C11351() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new Result(parcel);
            }

            public final Object[] newArray(int i) {
                return new Result[i];
            }
        }

        public Result(String str, String str2) {
            this.f10667a = str;
            this.f10668b = str2;
        }

        public Result(Parcel parcel) {
            this.f10667a = parcel.readString();
            this.f10668b = parcel.readString();
        }

        public final String m12602a() {
            return this.f10667a;
        }

        public final String m12603b() {
            return this.f10668b;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f10667a);
            parcel.writeString(this.f10668b);
        }
    }

    @Inject
    public RequestCaptchaMethod(UniqueIdForDeviceHolderImpl uniqueIdForDeviceHolderImpl) {
        this.f10669a = uniqueIdForDeviceHolderImpl;
    }

    public final ApiRequest m12604a(Object obj) {
        List arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("device_id", this.f10669a.a()));
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "requestCaptcha";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = "captcha/challenges";
        newBuilder = newBuilder;
        newBuilder.g = arrayList;
        ApiRequestBuilder a = newBuilder.a(RequestPriority.INTERACTIVE);
        a.k = ApiResponseType.JSON;
        return a.C();
    }

    public final Object m12605a(Object obj, ApiResponse apiResponse) {
        JsonNode c = apiResponse.c();
        return new Result(JSONUtil.b(c.b("persist_data")), JSONUtil.b(c.b("url")));
    }
}
