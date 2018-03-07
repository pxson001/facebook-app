package com.facebook.confirmation.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.growth.model.Contactpoint;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: instant_article_link_entity */
public class OpenIDConnectEmailConfirmationMethod implements ApiMethod<Params, Boolean> {

    /* compiled from: instant_article_link_entity */
    public class Params implements Parcelable {
        public static final Creator<Params> CREATOR = new C11651();
        public final Contactpoint f10784a;
        public final String f10785b;
        public final OpenIDConnectFlow f10786c;
        public final OpenIDConnectProvider f10787d;

        /* compiled from: instant_article_link_entity */
        final class C11651 implements Creator<Params> {
            C11651() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new Params(parcel);
            }

            public final Object[] newArray(int i) {
                return new Params[i];
            }
        }

        public Params(Contactpoint contactpoint, String str, OpenIDConnectFlow openIDConnectFlow, OpenIDConnectProvider openIDConnectProvider) {
            this.f10784a = contactpoint;
            this.f10785b = str;
            this.f10786c = openIDConnectFlow;
            this.f10787d = openIDConnectProvider;
        }

        public Params(Parcel parcel) {
            this.f10784a = (Contactpoint) parcel.readParcelable(Contactpoint.class.getClassLoader());
            this.f10785b = parcel.readString();
            this.f10786c = OpenIDConnectFlow.valueOf(parcel.readString());
            this.f10787d = OpenIDConnectProvider.valueOf(parcel.readString());
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.f10784a, i);
            parcel.writeString(this.f10785b);
            parcel.writeString(this.f10786c.name());
            parcel.writeString(this.f10787d.name());
        }
    }

    public static OpenIDConnectEmailConfirmationMethod m12736a(InjectorLike injectorLike) {
        return new OpenIDConnectEmailConfirmationMethod();
    }

    public final ApiRequest m12737a(Object obj) {
        Params params = (Params) obj;
        List a = Lists.a(new NameValuePair[]{new BasicNameValuePair("email", params.f10784a.normalized), new BasicNameValuePair("id_token", params.f10785b), new BasicNameValuePair("flow", params.f10786c.name), new BasicNameValuePair("provider", params.f10787d.name)});
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "openidConnectEmailConfirmation";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = "auth/openidconnect_email_confirmation";
        newBuilder = newBuilder.a(RequestPriority.INTERACTIVE);
        newBuilder.g = a;
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.k = ApiResponseType.JSON;
        return apiRequestBuilder.C();
    }

    public final Object m12738a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        JsonNode b = apiResponse.c().b("success");
        return Boolean.valueOf(b != null ? b.F() : false);
    }
}
