package com.facebook.api.feed;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.util.JSONUtil;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.model.GraphQLNegativeFeedbackAction;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: attachments */
public class NegativeFeedbackActionOnFeedMethod implements ApiMethod<Params, String> {

    /* compiled from: attachments */
    public class Params implements Parcelable {
        public static final Creator<Params> CREATOR = new C09471();
        public GraphQLObjectType f8717a;
        public String f8718b;
        public String f8719c;
        public String f8720d;
        public String f8721e;
        public int f8722f;
        public GraphQLNegativeFeedbackAction f8723g;
        public String f8724h;
        public boolean f8725i;
        public String f8726j;

        /* compiled from: attachments */
        final class C09471 implements Creator<Params> {
            C09471() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new Params(parcel);
            }

            public final Object[] newArray(int i) {
                return new Params[i];
            }
        }

        public Params(ParamsBuilder paramsBuilder) {
            this.f8717a = paramsBuilder.f8727a;
            this.f8718b = paramsBuilder.f8728b;
            this.f8719c = paramsBuilder.f8729c;
            this.f8720d = paramsBuilder.f8730d;
            this.f8721e = paramsBuilder.f8731e;
            this.f8722f = paramsBuilder.f8732f;
            this.f8723g = paramsBuilder.f8733g;
            this.f8724h = paramsBuilder.f8734h;
            this.f8725i = paramsBuilder.f8735i;
            this.f8726j = paramsBuilder.f8736j;
        }

        public Params(Parcel parcel) {
            this.f8717a = (GraphQLObjectType) parcel.readParcelable(GraphQLObjectType.class.getClassLoader());
            this.f8718b = parcel.readString();
            this.f8719c = parcel.readString();
            this.f8720d = parcel.readString();
            this.f8721e = parcel.readString();
            this.f8722f = parcel.readInt();
            this.f8723g = (GraphQLNegativeFeedbackAction) FlatBufferModelHelper.m4278a(parcel);
            this.f8724h = parcel.readString();
            this.f8725i = parcel.readByte() != (byte) 0;
            this.f8726j = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.f8717a, i);
            parcel.writeString(this.f8718b);
            parcel.writeString(this.f8719c);
            parcel.writeString(this.f8720d);
            parcel.writeString(this.f8721e);
            parcel.writeInt(this.f8722f);
            FlatBufferModelHelper.m4288a(parcel, this.f8723g);
            parcel.writeString(this.f8724h);
            parcel.writeByte((byte) (this.f8725i ? 1 : 0));
            parcel.writeString(this.f8726j);
        }

        public int describeContents() {
            return 0;
        }
    }

    /* compiled from: attachments */
    public class ParamsBuilder {
        public GraphQLObjectType f8727a;
        public String f8728b;
        public String f8729c;
        public String f8730d;
        public String f8731e;
        public int f8732f;
        public GraphQLNegativeFeedbackAction f8733g;
        public String f8734h;
        public boolean f8735i;
        public String f8736j;
    }

    public final ApiRequest m14652a(Object obj) {
        Params params = (Params) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("hideable_token", params.f8718b));
        a.add(new BasicNameValuePair("story_graphql_token", params.f8719c));
        a.add(new BasicNameValuePair("action", params.f8723g.b().name()));
        a.add(new BasicNameValuePair("story_location", params.f8724h));
        a.add(new BasicNameValuePair("undo", String.valueOf(params.f8725i)));
        a.add(new BasicNameValuePair("tracking", params.f8720d));
        a.add(new BasicNameValuePair("action_path", params.f8726j));
        a.add(new BasicNameValuePair("format", "json"));
        return new ApiRequest("negativeFeedbackActionOnFeedStory", "POST", "multifeed_afro_actions", a, ApiResponseType.JSON);
    }

    public final Object m14653a(Object obj, ApiResponse apiResponse) {
        return JSONUtil.a(apiResponse.c().b("action_path"), "");
    }
}
