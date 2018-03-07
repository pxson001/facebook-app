package com.facebook.friends.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: matched_pos */
public class AddFriendListMemberMethod implements ApiMethod<Params, Void> {

    /* compiled from: matched_pos */
    public class Params implements Parcelable {
        public final long f10668a;
        public final long f10669b;

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.f10668a);
            parcel.writeLong(this.f10669b);
        }
    }

    public final ApiRequest m16775a(Object obj) {
        Params params = (Params) obj;
        String a = StringFormatUtil.a("%s/members/%s", new Object[]{Long.valueOf(params.f10668a), Long.valueOf(params.f10669b)});
        List a2 = Lists.a();
        a2.add(new BasicNameValuePair("format", "json"));
        return new ApiRequest("addFriendListMember", "POST", a, a2, ApiResponseType.JSON);
    }

    public final Object m16776a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return null;
    }
}
