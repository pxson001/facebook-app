package com.facebook.auth.login;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.google.common.collect.RegularImmutableList;
import com.instagram.common.json.annotation.JsonType;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: tag_expansion_education */
public class CheckApprovedMachineMethod implements ApiMethod<CheckApprovedMachineParams, Result> {

    @AutoGenJsonDeserializer
    @JsonType
    /* compiled from: tag_expansion_education */
    public class ApprovalStatus implements Parcelable {
        public static final Creator<ApprovalStatus> CREATOR = new C01411();
        public Boolean f2285a;

        /* compiled from: tag_expansion_education */
        final class C01411 implements Creator<ApprovalStatus> {
            C01411() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new ApprovalStatus(parcel);
            }

            public final Object[] newArray(int i) {
                return new ApprovalStatus[i];
            }
        }

        public ApprovalStatus() {
            this.f2285a = Boolean.valueOf(false);
        }

        public ApprovalStatus(Parcel parcel) {
            this.f2285a = Boolean.valueOf(parcel.readByte() != (byte) 0);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeByte((byte) (this.f2285a.booleanValue() ? 1 : 0));
        }
    }

    @AutoGenJsonDeserializer
    @JsonType
    /* compiled from: tag_expansion_education */
    public class Result implements Parcelable {
        public static final Creator<Result> CREATOR = new C01421();
        public List<ApprovalStatus> f2286a;

        /* compiled from: tag_expansion_education */
        final class C01421 implements Creator<Result> {
            C01421() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new Result(parcel);
            }

            public final Object[] newArray(int i) {
                return new Result[i];
            }
        }

        public Result() {
            this.f2286a = RegularImmutableList.a;
        }

        public Result(Parcel parcel) {
            parcel.readTypedList(this.f2286a, ApprovalStatus.CREATOR);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeTypedList(this.f2286a);
        }
    }

    public final ApiRequest m3176a(Object obj) {
        CheckApprovedMachineParams checkApprovedMachineParams = (CheckApprovedMachineParams) obj;
        List arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("u", String.valueOf(checkApprovedMachineParams.a)));
        arrayList.add(new BasicNameValuePair("m", checkApprovedMachineParams.b));
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "checkApprovedMachine";
        newBuilder = newBuilder;
        newBuilder.c = "GET";
        newBuilder = newBuilder;
        newBuilder.d = "check_approved_machine";
        newBuilder = newBuilder;
        newBuilder.g = arrayList;
        ApiRequestBuilder a = newBuilder.a(RequestPriority.INTERACTIVE);
        a.k = ApiResponseType.JSONPARSER;
        return a.C();
    }

    public final Object m3177a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return (Result) apiResponse.d().a(Result.class);
    }
}
