package com.facebook.api.growth;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: send_delivery_receipt_batch */
public class UserSetContactInfoMethod implements ApiMethod<Params, Boolean> {

    /* compiled from: send_delivery_receipt_batch */
    public class Params implements Parcelable {
        public static final Creator<Params> CREATOR = new C03631();
        public final String f4032a;
        public final boolean f4033b;

        /* compiled from: send_delivery_receipt_batch */
        final class C03631 implements Creator<Params> {
            C03631() {
            }

            public final Object createFromParcel(Parcel parcel) {
                boolean z = true;
                String readString = parcel.readString();
                if (parcel.readInt() != 1) {
                    z = false;
                }
                return new Params(readString, z);
            }

            public final Object[] newArray(int i) {
                return new Params[i];
            }
        }

        public Params(String str, boolean z) {
            this.f4032a = str;
            this.f4033b = z;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f4032a);
            parcel.writeInt(this.f4033b ? 1 : 0);
        }
    }

    public final ApiRequest m3916a(Object obj) {
        Params params = (Params) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("cell", params.f4032a));
        a.add(new BasicNameValuePair("quiet", params.f4033b ? "true" : "false"));
        a.add(new BasicNameValuePair("format", "JSON"));
        return new ApiRequest("user_set_contact_info", "POST", "method/user.setContactInfo", a, ApiResponseType.JSON);
    }

    public final Object m3917a(Object obj, ApiResponse apiResponse) {
        JsonNode c = apiResponse.c();
        if (c.p()) {
            return Boolean.valueOf(c.F());
        }
        throw new Exception("Invalid response: boolean expected");
    }
}
