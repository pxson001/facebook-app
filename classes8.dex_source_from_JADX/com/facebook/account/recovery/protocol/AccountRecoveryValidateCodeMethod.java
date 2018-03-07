package com.facebook.account.recovery.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.device_id.UniqueIdForDeviceHolderImpl;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: linkshim_link_extra */
public class AccountRecoveryValidateCodeMethod implements ApiMethod<Params, String> {
    private final UniqueIdForDeviceHolderImpl f10324a;

    /* compiled from: linkshim_link_extra */
    public class Params implements Parcelable {
        public static final Creator<Params> CREATOR = new C10961();
        public final String f10320a;
        public final String f10321b;
        public final String f10322c;
        public final String f10323d;

        /* compiled from: linkshim_link_extra */
        final class C10961 implements Creator<Params> {
            C10961() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new Params(parcel);
            }

            public final Object[] newArray(int i) {
                return new Params[i];
            }
        }

        public Params(String str, String str2, String str3, boolean z) {
            this.f10320a = str;
            this.f10321b = str2;
            this.f10322c = str3;
            this.f10323d = String.valueOf(z);
        }

        public Params(Parcel parcel) {
            this.f10320a = parcel.readString();
            this.f10321b = parcel.readString();
            this.f10322c = parcel.readString();
            this.f10323d = parcel.readString();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f10320a);
            parcel.writeString(this.f10321b);
            parcel.writeString(this.f10322c);
            parcel.writeString(this.f10323d);
        }
    }

    public final ApiRequest m12118a(Object obj) {
        Params params = (Params) obj;
        List a = Lists.a();
        String str = params.f10320a;
        a.add(new BasicNameValuePair("code", params.f10321b));
        a.add(new BasicNameValuePair("new_password", params.f10322c));
        a.add(new BasicNameValuePair("device_id", this.f10324a.a()));
        a.add(new BasicNameValuePair("terminate_other_sessions", params.f10323d));
        return new ApiRequest("accountRecoveryValidateCode", "POST", str, RequestPriority.INTERACTIVE, a, ApiResponseType.JSON);
    }

    @Inject
    public AccountRecoveryValidateCodeMethod(UniqueIdForDeviceHolderImpl uniqueIdForDeviceHolderImpl) {
        this.f10324a = uniqueIdForDeviceHolderImpl;
    }

    public final Object m12119a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        JsonNode b = apiResponse.c().b("id");
        return b == null ? "" : b.B();
    }
}
