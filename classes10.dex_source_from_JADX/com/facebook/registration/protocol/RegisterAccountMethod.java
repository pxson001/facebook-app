package com.facebook.registration.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.FbObjectMapper;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.device_id.UniqueIdForDeviceHolderImpl;
import com.facebook.growth.sem.SemTrackingLogger;
import com.facebook.http.common.BootstrapRequestName;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.registration.model.RegistrationFormData;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.List;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: joinable_status */
public class RegisterAccountMethod implements ApiMethod<RegistrationFormData, Result> {
    private final FbObjectMapper f8919a;
    private final String f8920b;
    private final UniqueIdForDeviceHolderImpl f8921c;
    private final SemTrackingLogger f8922d;

    @AutoGenJsonDeserializer
    @JsonDeserialize(using = RegisterAccountMethod_ResultDeserializer.class)
    /* compiled from: joinable_status */
    public class Result implements Parcelable {
        public static final Creator<Result> CREATOR = new C13621();
        @JsonProperty("account_type")
        public final String accountType;
        @JsonProperty("completion_url")
        public final String completionUrl;
        @JsonProperty("session_info")
        public final SessionInfo sessionInfo;
        @JsonProperty("new_user_id")
        public final String userId;

        /* compiled from: joinable_status */
        final class C13621 implements Creator<Result> {
            C13621() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new Result(parcel);
            }

            public final Object[] newArray(int i) {
                return new Result[i];
            }
        }

        public Result() {
            this.accountType = null;
            this.completionUrl = null;
            this.userId = null;
            this.sessionInfo = null;
        }

        public Result(Parcel parcel) {
            this.accountType = parcel.readString();
            this.completionUrl = parcel.readString();
            this.userId = parcel.readString();
            this.sessionInfo = (SessionInfo) parcel.readParcelable(SessionInfo.class.getClassLoader());
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.accountType);
            parcel.writeString(this.completionUrl);
            parcel.writeString(this.userId);
            parcel.writeParcelable(this.sessionInfo, i);
        }
    }

    @AutoGenJsonDeserializer
    @JsonDeserialize(using = RegisterAccountMethod_SessionInfoDeserializer.class)
    /* compiled from: joinable_status */
    public class SessionInfo implements Parcelable {
        public static final Creator<SessionInfo> CREATOR = new C13631();
        @JsonProperty("access_token")
        public final String accessToken;
        @JsonProperty("confirmed")
        public final boolean confirmed;
        @JsonProperty("secret")
        public final String secret;
        @JsonProperty("session_key")
        public final String sessionKey;
        @JsonProperty("uid")
        public final String uid;

        /* compiled from: joinable_status */
        final class C13631 implements Creator<SessionInfo> {
            C13631() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new SessionInfo(parcel);
            }

            public final Object[] newArray(int i) {
                return new SessionInfo[i];
            }
        }

        public SessionInfo() {
            this.sessionKey = null;
            this.uid = null;
            this.secret = null;
            this.accessToken = null;
            this.confirmed = false;
        }

        public SessionInfo(Parcel parcel) {
            this.sessionKey = parcel.readString();
            this.uid = parcel.readString();
            this.secret = parcel.readString();
            this.accessToken = parcel.readString();
            this.confirmed = ParcelUtil.a(parcel);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.sessionKey);
            parcel.writeString(this.uid);
            parcel.writeString(this.secret);
            parcel.writeString(this.accessToken);
            ParcelUtil.a(parcel, this.confirmed);
        }
    }

    public final ApiRequest m8902a(Object obj) {
        List r = ((RegistrationFormData) obj).r();
        r.add(new BasicNameValuePair("return_multiple_errors", "true"));
        r.add(new BasicNameValuePair("attempt_login", "true"));
        r.add(new BasicNameValuePair("reg_instance", this.f8920b));
        r.add(new BasicNameValuePair("device_id", this.f8921c.a()));
        r.add(new BasicNameValuePair("format", "json"));
        r.add(new BasicNameValuePair("skip_session_info", "true"));
        String str = null;
        try {
            str = this.f8922d.a(true);
        } catch (Exception e) {
        }
        r.add(new BasicNameValuePair("advertising_id", str));
        return ApiRequest.newBuilder().a(BootstrapRequestName.REGISTER_ACCOUNT.requestNameString).c("POST").d("method/user.register").a(RequestPriority.INTERACTIVE).a(r).a(ApiResponseType.JSON).C();
    }

    @Inject
    public RegisterAccountMethod(FbObjectMapper fbObjectMapper, String str, UniqueIdForDeviceHolderImpl uniqueIdForDeviceHolderImpl, SemTrackingLogger semTrackingLogger) {
        this.f8919a = fbObjectMapper;
        this.f8920b = str;
        this.f8921c = uniqueIdForDeviceHolderImpl;
        this.f8922d = semTrackingLogger;
    }

    public final Object m8903a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return (Result) this.f8919a.a(apiResponse.c().c(), this.f8919a._typeFactory.a(Result.class));
    }
}
