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

/* compiled from: mTimelineCoverPhoto */
public class RemoveFriendListMemberMethod implements ApiMethod<Params, Void> {

    /* compiled from: mTimelineCoverPhoto */
    public class Params implements Parcelable {
        public final long f10827a;
        public final long f10828b;

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.f10827a);
            parcel.writeLong(this.f10828b);
        }
    }

    public final ApiRequest m17410a(Object obj) {
        Params params = (Params) obj;
        String a = StringFormatUtil.a("%s/members/%s", new Object[]{Long.valueOf(params.f10827a), Long.valueOf(params.f10828b)});
        List a2 = Lists.a();
        a2.add(new BasicNameValuePair("format", "json"));
        return new ApiRequest("removeFriendListMember", "DELETE", a, a2, ApiResponseType.JSON);
    }

    public final Object m17411a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return null;
    }
}
