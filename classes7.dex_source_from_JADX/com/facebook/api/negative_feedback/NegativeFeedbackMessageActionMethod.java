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

/* compiled from: video_caption_items */
public class NegativeFeedbackMessageActionMethod implements ApiMethod<Params, Void> {

    /* compiled from: video_caption_items */
    public class Params implements Parcelable {
        public static final Creator<Params> CREATOR = new C00561();
        public String f603a;
        public String f604b;
        public String f605c;

        /* compiled from: video_caption_items */
        final class C00561 implements Creator<Params> {
            C00561() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new Params(parcel);
            }

            public final Object[] newArray(int i) {
                return new Params[i];
            }
        }

        public Params(ParamsBuilder paramsBuilder) {
            this.f603a = paramsBuilder.f606a;
            this.f604b = paramsBuilder.f607b;
            this.f605c = paramsBuilder.f608c;
        }

        public Params(Parcel parcel) {
            this.f603a = parcel.readString();
            this.f604b = parcel.readString();
            this.f605c = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f603a);
            parcel.writeString(this.f604b);
            parcel.writeString(this.f605c);
        }

        public int describeContents() {
            return 0;
        }
    }

    /* compiled from: video_caption_items */
    public class ParamsBuilder {
        public String f606a;
        public String f607b;
        public String f608c;
    }

    public final ApiRequest m705a(Object obj) {
        Params params = (Params) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("action_node_token", params.f603a));
        a.add(new BasicNameValuePair("message_body", params.f604b));
        a.add(new BasicNameValuePair("recipient_id", params.f605c));
        a.add(new BasicNameValuePair("format", "json"));
        return new ApiRequest("negativeFeedbackMessageActions", "POST", "negative_feedback_message_actions", RequestPriority.INTERACTIVE, a, ApiResponseType.JSON);
    }

    public final Object m706a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return null;
    }
}
