package com.facebook.messaging.media.upload.udp;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.annotation.concurrent.Immutable;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: last_get_pinned_threads_update_time_ms */
public class UDPConnectionMethod implements ApiMethod<UDPConnectionParams, UDPServerConfig> {

    @Immutable
    /* compiled from: last_get_pinned_threads_update_time_ms */
    public class UDPConnectionParams implements Parcelable {
        public static final Creator<UDPConnectionParams> CREATOR = new C13481();
        public final long f12171a;

        /* compiled from: last_get_pinned_threads_update_time_ms */
        final class C13481 implements Creator<UDPConnectionParams> {
            C13481() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new UDPConnectionParams(parcel.readLong());
            }

            public final Object[] newArray(int i) {
                return new UDPConnectionParams[i];
            }
        }

        public UDPConnectionParams(long j) {
            this.f12171a = j;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.f12171a);
        }
    }

    public static UDPConnectionMethod m12677a(InjectorLike injectorLike) {
        return new UDPConnectionMethod();
    }

    public final ApiRequest m12678a(Object obj) {
        UDPConnectionParams uDPConnectionParams = (UDPConnectionParams) obj;
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "udp_upload";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = "/me/udp_uploads";
        newBuilder = newBuilder;
        Builder builder = ImmutableList.builder();
        builder.c(new BasicNameValuePair("user_id", Long.toString(uDPConnectionParams.f12171a)));
        newBuilder.g = builder.b();
        newBuilder = newBuilder;
        newBuilder.k = ApiResponseType.JSON;
        return newBuilder.C();
    }

    public final Object m12679a(Object obj, ApiResponse apiResponse) {
        return UDPServerConfig.m12706a(apiResponse.c());
    }
}
