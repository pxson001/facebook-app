package com.facebook.api.feed;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.common.util.JSONUtil;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.StoryVisibility;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: attribution_app_metadata */
public class HideFeedStoryMethod implements ApiMethod<Params, Boolean> {

    /* compiled from: attribution_app_metadata */
    public class Params implements Parcelable {
        public static final Creator<Params> CREATOR = new C09441();
        public GraphQLObjectType f8705a;
        public String f8706b;
        public String f8707c;
        public StoryVisibility f8708d;
        public boolean f8709e;
        public String f8710f;
        public int f8711g;
        public String f8712h;

        /* compiled from: attribution_app_metadata */
        final class C09441 implements Creator<Params> {
            C09441() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new Params(parcel);
            }

            public final Object[] newArray(int i) {
                return new Params[i];
            }
        }

        public Params(GraphQLObjectType graphQLObjectType, String str, String str2, StoryVisibility storyVisibility, boolean z, String str3, int i, String str4) {
            this.f8705a = (GraphQLObjectType) Preconditions.checkNotNull(graphQLObjectType);
            if (storyVisibility.isHiddenOrVisible()) {
                Preconditions.checkNotNull(str);
            }
            this.f8706b = str;
            this.f8707c = str2;
            this.f8708d = storyVisibility;
            this.f8709e = z;
            this.f8710f = str3;
            this.f8711g = i;
            this.f8712h = str4;
        }

        public Params(Parcel parcel) {
            this.f8705a = (GraphQLObjectType) parcel.readParcelable(GraphQLObjectType.class.getClassLoader());
            this.f8706b = parcel.readString();
            this.f8707c = parcel.readString();
            this.f8708d = StoryVisibility.valueOf(parcel.readString());
            this.f8709e = ParcelUtil.m3827a(parcel);
            this.f8710f = parcel.readString();
            this.f8711g = parcel.readInt();
            this.f8712h = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.f8705a, i);
            parcel.writeString(this.f8706b);
            parcel.writeString(this.f8707c);
            parcel.writeString(this.f8708d.toString());
            ParcelUtil.m3826a(parcel, this.f8709e);
            parcel.writeString(this.f8710f);
            parcel.writeInt(this.f8711g);
            parcel.writeString(this.f8712h);
        }

        public int describeContents() {
            return 0;
        }
    }

    public final ApiRequest m14649a(Object obj) {
        Params params = (Params) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("hideable_token", params.f8706b));
        a.add(new BasicNameValuePair("tracking", params.f8707c));
        a.add(new BasicNameValuePair("feed_story_visibility", params.f8708d.getRequestParamValue()));
        a.add(new BasicNameValuePair("format", "json"));
        return new ApiRequest("hideStory", "POST", "multifeed_reports", a, ApiResponseType.JSON);
    }

    public final Object m14650a(Object obj, ApiResponse apiResponse) {
        return Boolean.valueOf(JSONUtil.g(apiResponse.c()));
    }
}
