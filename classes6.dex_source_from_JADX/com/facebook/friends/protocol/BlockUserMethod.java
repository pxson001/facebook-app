package com.facebook.friends.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;

/* compiled from: matchedPos */
public class BlockUserMethod implements ApiMethod<Params, Void> {

    /* compiled from: matchedPos */
    public class Params implements Parcelable {
        public static final Creator<Params> CREATOR = new C06611();
        public final long f10672a;
        public final long f10673b;
        public final boolean f10674c;
        @Nullable
        public final List<String> f10675d;

        /* compiled from: matchedPos */
        final class C06611 implements Creator<Params> {
            C06611() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new Params(parcel);
            }

            public final Object[] newArray(int i) {
                return new Params[i];
            }
        }

        public Params(long j, long j2) {
            this.f10673b = j;
            this.f10672a = j2;
            this.f10674c = false;
            this.f10675d = null;
        }

        public Params(Parcel parcel) {
            this.f10673b = parcel.readLong();
            boolean[] zArr = new boolean[1];
            parcel.readBooleanArray(zArr);
            this.f10674c = zArr[0];
            if (this.f10674c) {
                this.f10672a = -1;
                this.f10675d = new ArrayList();
                parcel.readStringList(this.f10675d);
                return;
            }
            this.f10672a = parcel.readLong();
            this.f10675d = null;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.f10673b);
            parcel.writeBooleanArray(new boolean[]{this.f10674c});
            if (this.f10674c) {
                parcel.writeStringList(this.f10675d);
            } else {
                parcel.writeLong(this.f10672a);
            }
        }
    }

    public final ApiRequest m16783a(Object obj) {
        String jSONArray;
        Params params = (Params) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("format", "json"));
        String str = "uid";
        if (params.f10674c) {
            List<String> list = params.f10675d;
            JSONArray jSONArray2 = new JSONArray();
            for (String put : list) {
                jSONArray2.put(put);
            }
            jSONArray = jSONArray2.toString();
        } else {
            jSONArray = String.valueOf(params.f10672a);
        }
        a.add(new BasicNameValuePair(str, jSONArray));
        return new ApiRequest("blockUser", "POST", StringFormatUtil.formatStrLocaleSafe("%d/blocked", Long.valueOf(params.f10673b)), a, ApiResponseType.JSON);
    }

    public final Object m16784a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return null;
    }
}
