package com.facebook.pages.common.friendinviter.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: csc_digits */
public class SendPageLikeInviteMethod implements ApiMethod<Params, Void> {

    /* compiled from: csc_digits */
    public class Params implements Parcelable {
        public static final Creator<Params> CREATOR = new C17951();
        public final String f16564a;
        public final String f16565b;

        /* compiled from: csc_digits */
        final class C17951 implements Creator<Params> {
            C17951() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new Params(parcel);
            }

            public final Object[] newArray(int i) {
                return new Params[i];
            }
        }

        public Params(String str, String str2) {
            this.f16564a = str;
            this.f16565b = str2;
        }

        public Params(Parcel parcel) {
            this.f16564a = parcel.readString();
            this.f16565b = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f16564a);
            parcel.writeString(this.f16565b);
        }

        public int describeContents() {
            return 0;
        }
    }

    public final ApiRequest m19566a(Object obj) {
        Params params = (Params) obj;
        Preconditions.checkNotNull(params, "Params cannot be null!");
        Preconditions.checkNotNull(params.f16565b, "InviteeId can't be null!");
        Preconditions.checkNotNull(params.f16564a);
        List arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("invitee_id", String.valueOf(params.f16565b)));
        return new ApiRequest("SendPageLikeInviteMethod", "POST", params.f16564a + "/invited", arrayList, ApiResponseType.JSON);
    }

    public final Object m19567a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return null;
    }
}
