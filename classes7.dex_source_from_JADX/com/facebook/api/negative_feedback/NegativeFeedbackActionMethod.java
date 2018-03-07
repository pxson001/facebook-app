package com.facebook.api.negative_feedback;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: video_channels */
public class NegativeFeedbackActionMethod implements ApiMethod<Params, Void> {

    /* compiled from: video_channels */
    public class Params implements Parcelable {
        public static final Creator<Params> CREATOR = new C00551();
        public String f599a;

        /* compiled from: video_channels */
        final class C00551 implements Creator<Params> {
            C00551() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new Params(parcel);
            }

            public final Object[] newArray(int i) {
                return new Params[i];
            }
        }

        public Params(ParamsBuilder paramsBuilder) {
            this.f599a = paramsBuilder.f600a;
        }

        public Params(Parcel parcel) {
            this.f599a = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f599a);
        }

        public int describeContents() {
            return 0;
        }
    }

    /* compiled from: video_channels */
    public class ParamsBuilder {
        public String f600a;
    }

    public final ApiRequest m702a(Object obj) {
        Params params = (Params) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("action_node_token", params.f599a));
        a.add(new BasicNameValuePair("format", "json"));
        return new ApiRequest("negativeFeedbackActions", "POST", "negative_feedback_actions", RequestPriority.INTERACTIVE, a, ApiResponseType.JSON);
    }

    public final Object m703a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return null;
    }
}
