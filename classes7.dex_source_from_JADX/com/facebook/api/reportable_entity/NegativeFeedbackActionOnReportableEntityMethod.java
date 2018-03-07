package com.facebook.api.reportable_entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.graphql.enums.GraphQLNegativeFeedbackActionType;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: video_broadcast_seal_key */
public class NegativeFeedbackActionOnReportableEntityMethod implements ApiMethod<Params, Void> {

    /* compiled from: video_broadcast_seal_key */
    public class Params implements Parcelable {
        public static final Creator<Params> CREATOR = new C00571();
        public GraphQLNegativeFeedbackActionType f614a;
        public String f615b;
        public String f616c;
        public Boolean f617d;

        /* compiled from: video_broadcast_seal_key */
        final class C00571 implements Creator<Params> {
            C00571() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new Params(parcel);
            }

            public final Object[] newArray(int i) {
                return new Params[i];
            }
        }

        public Params(ParamsBuilder paramsBuilder) {
            this.f614a = paramsBuilder.f618a;
            this.f615b = paramsBuilder.f619b;
            this.f616c = paramsBuilder.f620c;
            this.f617d = paramsBuilder.f621d;
        }

        public Params(Parcel parcel) {
            this.f614a = GraphQLNegativeFeedbackActionType.fromString(parcel.readString());
            this.f615b = parcel.readString();
            this.f616c = parcel.readString();
            this.f617d = Boolean.valueOf(parcel.readString());
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f614a.name());
            parcel.writeString(this.f615b);
            parcel.writeString(this.f616c);
            parcel.writeString(this.f617d.toString());
        }

        public int describeContents() {
            return 0;
        }
    }

    /* compiled from: video_broadcast_seal_key */
    public class ParamsBuilder {
        public GraphQLNegativeFeedbackActionType f618a;
        public String f619b;
        public String f620c;
        public Boolean f621d;
    }

    public final ApiRequest m710a(Object obj) {
        Params params = (Params) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("reportable_ent_token", params.f615b));
        a.add(new BasicNameValuePair("story_location", params.f616c));
        a.add(new BasicNameValuePair("action", params.f614a.name()));
        a.add(new BasicNameValuePair("undo", params.f617d.toString()));
        a.add(new BasicNameValuePair("format", "json"));
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "negativeFeedbackActionOnReportableEntity";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = "reportable_ent_nfx_actions";
        newBuilder = newBuilder;
        newBuilder.g = a;
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.k = ApiResponseType.JSON;
        return apiRequestBuilder.C();
    }

    public final Object m711a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return null;
    }
}
