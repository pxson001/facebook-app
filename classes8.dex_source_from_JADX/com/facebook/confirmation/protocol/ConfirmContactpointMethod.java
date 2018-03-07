package com.facebook.confirmation.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.growth.model.Contactpoint;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.Lists;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: instant_article_vpv */
public class ConfirmContactpointMethod implements ApiMethod<Params, Boolean> {

    /* compiled from: instant_article_vpv */
    public class Params implements Parcelable {
        public static final Creator<Params> CREATOR = new C11641();
        public final Contactpoint f10781a;
        public final String f10782b;
        public final ConfirmationSource f10783c;

        /* compiled from: instant_article_vpv */
        final class C11641 implements Creator<Params> {
            C11641() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new Params(parcel);
            }

            public final Object[] newArray(int i) {
                return new Params[i];
            }
        }

        public Params(Contactpoint contactpoint, String str, ConfirmationSource confirmationSource) {
            this.f10781a = contactpoint;
            this.f10782b = str;
            if (confirmationSource == null) {
                confirmationSource = ConfirmationSource.UNKNOWN;
            }
            this.f10783c = confirmationSource;
        }

        public Params(Parcel parcel) {
            this.f10781a = (Contactpoint) parcel.readParcelable(Contactpoint.class.getClassLoader());
            this.f10782b = parcel.readString();
            this.f10783c = ConfirmationSource.safeValueOf(parcel.readString());
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.f10781a, i);
            parcel.writeString(this.f10782b);
            parcel.writeString(this.f10783c.name());
        }
    }

    public static ConfirmContactpointMethod m12731a(InjectorLike injectorLike) {
        return new ConfirmContactpointMethod();
    }

    public final ApiRequest m12732a(Object obj) {
        Params params = (Params) obj;
        NameValuePair[] nameValuePairArr = new NameValuePair[]{new BasicNameValuePair("normalized_contactpoint", params.f10781a.normalized), new BasicNameValuePair("contactpoint_type", params.f10781a.type.name()), new BasicNameValuePair("code", params.f10782b), new BasicNameValuePair("source", params.f10783c.name()), new BasicNameValuePair("format", "json")};
        return new ApiRequest("confirmContactpoint", "POST", "method/user.confirmcontactpoint", Lists.a(nameValuePairArr), ApiResponseType.JSON);
    }

    public final Object m12733a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return Boolean.valueOf(apiResponse.c().F());
    }
}
