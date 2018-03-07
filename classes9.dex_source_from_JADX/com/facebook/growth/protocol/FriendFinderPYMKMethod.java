package com.facebook.growth.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.api.growth.contactimporter.PhonebookLookupResultContact;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.ipc.katana.findfriends.CIFlow;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.RegularImmutableList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;

/* compiled from: p2p_platform_context */
public class FriendFinderPYMKMethod implements ApiMethod<Params, Result> {

    /* compiled from: p2p_platform_context */
    public class Params implements Parcelable {
        public static final Creator<Params> CREATOR = new C08391();
        public final int f7518a;
        public final String f7519b;
        public final CIFlow f7520c;
        public final List<String> f7521d;

        /* compiled from: p2p_platform_context */
        final class C08391 implements Creator<Params> {
            C08391() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new Params(parcel);
            }

            public final Object[] newArray(int i) {
                return new Params[i];
            }
        }

        public Params(int i, String str, CIFlow cIFlow, List<String> list) {
            this.f7518a = i;
            this.f7519b = str;
            this.f7520c = cIFlow;
            this.f7521d = list;
        }

        public Params(Parcel parcel) {
            this.f7518a = parcel.readInt();
            this.f7519b = parcel.readString();
            this.f7520c = (CIFlow) parcel.readSerializable();
            this.f7521d = Lists.a();
            parcel.readStringList(this.f7521d);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f7518a);
            parcel.writeString(this.f7519b);
            parcel.writeSerializable(this.f7520c);
            parcel.writeStringList(this.f7521d);
        }
    }

    @AutoGenJsonDeserializer
    @JsonDeserialize(using = FriendFinderPYMKMethod_ResultDeserializer.class)
    /* compiled from: p2p_platform_context */
    public class Result implements Parcelable {
        public static final Creator<Result> CREATOR = new C08401();
        @JsonProperty("friendable")
        private final List<PhonebookLookupResultContact> mPymk;

        /* compiled from: p2p_platform_context */
        final class C08401 implements Creator<Result> {
            C08401() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new Result(parcel);
            }

            public final Object[] newArray(int i) {
                return new Result[i];
            }
        }

        public Result() {
            this.mPymk = RegularImmutableList.a;
        }

        public Result(Parcel parcel) {
            this.mPymk = Lists.a();
            parcel.readTypedList(this.mPymk, PhonebookLookupResultContact.CREATOR);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeTypedList(this.mPymk);
        }

        public final List<PhonebookLookupResultContact> m7817a() {
            return ImmutableList.copyOf(this.mPymk);
        }
    }

    public final ApiRequest m7818a(Object obj) {
        Params params = (Params) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("format", "json"));
        a.add(new BasicNameValuePair("pic_size", Integer.toString(params.f7518a)));
        a.add(new BasicNameValuePair("session_ID", params.f7519b));
        CIFlow cIFlow = params.f7520c;
        if (!(cIFlow == null || cIFlow.equals(CIFlow.UNKNOWN))) {
            a.add(new BasicNameValuePair("flow", cIFlow.value));
        }
        List<String> copyOf = ImmutableList.copyOf(params.f7521d);
        if (!copyOf.isEmpty()) {
            String str = "excluded_ids";
            JSONArray jSONArray = new JSONArray();
            for (String put : copyOf) {
                jSONArray.put(put);
            }
            a.add(new BasicNameValuePair(str, jSONArray.toString()));
        }
        return new ApiRequest("FriendFinderPymk", "POST", "method/friendfinder.pymk", a, ApiResponseType.JSONPARSER);
    }

    public final Object m7819a(Object obj, ApiResponse apiResponse) {
        return (Result) apiResponse.d().a(Result.class);
    }
}
