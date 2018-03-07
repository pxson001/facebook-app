package com.facebook.account.recovery.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.util.JSONUtil;
import com.facebook.device_id.UniqueIdForDeviceHolderImpl;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.RegularImmutableList;
import java.util.List;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;

/* compiled from: list_elements */
public class AccountRecoverySendConfirmationCodeMethod implements ApiMethod<Params, Boolean> {
    private final UniqueIdForDeviceHolderImpl f10319a;

    /* compiled from: list_elements */
    public class Params implements Parcelable {
        public static final Creator<Params> CREATOR = new C10951();
        public final String f10317a;
        public final List<String> f10318b;

        /* compiled from: list_elements */
        final class C10951 implements Creator<Params> {
            C10951() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new Params(parcel);
            }

            public final Object[] newArray(int i) {
                return new Params[i];
            }
        }

        public Params(String str, List<String> list) {
            this.f10317a = str;
            this.f10318b = list;
        }

        public Params(Parcel parcel) {
            this.f10317a = parcel.readString();
            this.f10318b = parcel.createStringArrayList();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f10317a);
            parcel.writeStringList(this.f10318b);
        }
    }

    public final ApiRequest m12116a(Object obj) {
        ImmutableList immutableList;
        Params params = (Params) obj;
        List a = Lists.a();
        String str = params.f10317a;
        if (params.f10318b == null) {
            immutableList = RegularImmutableList.a;
        } else {
            immutableList = ImmutableList.copyOf(params.f10318b);
        }
        List<String> list = immutableList;
        if (!list.isEmpty()) {
            String str2 = "contactpoints";
            JSONArray jSONArray = new JSONArray();
            for (String put : list) {
                jSONArray.put(put);
            }
            a.add(new BasicNameValuePair(str2, jSONArray.toString()));
        }
        a.add(new BasicNameValuePair("device_id", this.f10319a.a()));
        return new ApiRequest("accountRecoverySendConfirmationCode", "POST", str + "/recovery_codes", RequestPriority.INTERACTIVE, a, ApiResponseType.JSON);
    }

    @Inject
    public AccountRecoverySendConfirmationCodeMethod(UniqueIdForDeviceHolderImpl uniqueIdForDeviceHolderImpl) {
        this.f10319a = uniqueIdForDeviceHolderImpl;
    }

    public final Object m12117a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return Boolean.valueOf(JSONUtil.g(apiResponse.c().f("success")));
    }
}
