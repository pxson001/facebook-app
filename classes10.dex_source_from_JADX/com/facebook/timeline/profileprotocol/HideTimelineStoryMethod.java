package com.facebook.timeline.profileprotocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: feed_filter_pages */
public class HideTimelineStoryMethod implements ApiMethod<Params, Void> {

    /* compiled from: feed_filter_pages */
    public class Params implements Parcelable {
        public static final Creator<Params> CREATOR = new C17331();
        public String f12093a;
        public boolean f12094b;

        /* compiled from: feed_filter_pages */
        final class C17331 implements Creator<Params> {
            C17331() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new Params(parcel);
            }

            public final Object[] newArray(int i) {
                return new Params[i];
            }
        }

        public Params(Parcel parcel) {
            this.f12093a = parcel.readString();
            this.f12094b = ParcelUtil.a(parcel);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f12093a);
            ParcelUtil.a(parcel, this.f12094b);
        }

        public String toString() {
            return Objects.toStringHelper(this).add("method", "HideTimelineStoryMethod").add("storyId", String.valueOf(this.f12093a)).add("hidden", String.valueOf(this.f12094b)).toString();
        }
    }

    public final ApiRequest m12096a(Object obj) {
        String str;
        Params params = (Params) obj;
        List a = Lists.a();
        if (params.f12094b) {
            str = "hidden";
        } else {
            str = "normal";
        }
        a.add(new BasicNameValuePair("timeline_visibility", str));
        a.add(new BasicNameValuePair("format", "json"));
        return new ApiRequest("hideStory", "POST", params.f12093a, a, ApiResponseType.JSON);
    }

    public final Object m12097a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return null;
    }
}
