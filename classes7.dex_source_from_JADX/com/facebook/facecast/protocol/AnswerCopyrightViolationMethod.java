package com.facebook.facecast.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.google.common.collect.ImmutableList;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: ban_user_and_delete_comment_ */
public class AnswerCopyrightViolationMethod implements ApiMethod<Params, Void> {

    /* compiled from: ban_user_and_delete_comment_ */
    public class Params implements Parcelable {
        public static final Creator<Params> CREATOR = new C16251();
        public final String f18760a;
        public final boolean f18761b;

        /* compiled from: ban_user_and_delete_comment_ */
        final class C16251 implements Creator<Params> {
            C16251() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new Params(parcel);
            }

            public final Object[] newArray(int i) {
                return new Params[i];
            }
        }

        public Params(String str, boolean z) {
            this.f18760a = str;
            this.f18761b = z;
        }

        public Params(Parcel parcel) {
            boolean z = true;
            this.f18760a = parcel.readString();
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.f18761b = z;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f18760a);
            parcel.writeInt(this.f18761b ? 1 : 0);
        }
    }

    public final ApiRequest m22302a(Object obj) {
        String str;
        Params params = (Params) obj;
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "graphCopyrightViolation";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = "v2.3/" + params.f18760a;
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        String str2 = "copyrights_violation_dialog_state";
        if (params.f18761b) {
            str = "BROADCASTER_CLAIMED_RIGHTS";
        } else {
            str = "BROADCAST_WAS_STOPPED";
        }
        apiRequestBuilder.g = ImmutableList.of(new BasicNameValuePair(str2, str));
        newBuilder = apiRequestBuilder;
        newBuilder.k = ApiResponseType.JSON;
        return newBuilder.C();
    }

    public final Object m22303a(Object obj, ApiResponse apiResponse) {
        return null;
    }
}
