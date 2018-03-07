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
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: mTriggerPrivacyOption */
public class PokeUserMethod implements ApiMethod<Params, Void> {

    /* compiled from: mTriggerPrivacyOption */
    public class Params implements Parcelable {
        public static final Creator<Params> CREATOR = new C06641();
        public final long f10825a;
        public final long f10826b;

        /* compiled from: mTriggerPrivacyOption */
        final class C06641 implements Creator<Params> {
            C06641() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new Params(parcel);
            }

            public final Object[] newArray(int i) {
                return new Params[i];
            }
        }

        public Params(long j, long j2) {
            this.f10826b = j;
            this.f10825a = j2;
        }

        public Params(Parcel parcel) {
            this.f10826b = parcel.readLong();
            this.f10825a = parcel.readLong();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.f10826b);
            parcel.writeLong(this.f10825a);
        }
    }

    /* compiled from: mTriggerPrivacyOption */
    public enum PokeError {
        API_EC_POKE_INVALID_RECIP(510),
        API_EC_POKE_OUTSTANDING(511),
        API_EC_POKE_RATE(512),
        API_EC_POKE_USER_BLOCKED(513);
        
        private final int id;

        private PokeError(int i) {
            this.id = i;
        }

        public final int getErrorCode() {
            return this.id;
        }
    }

    public final ApiRequest m17408a(Object obj) {
        Params params = (Params) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("format", "json"));
        return new ApiRequest("poke", "POST", StringFormatUtil.formatStrLocaleSafe("%d/pokes", Long.valueOf(params.f10825a)), a, ApiResponseType.JSON);
    }

    public final Object m17409a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return null;
    }
}
