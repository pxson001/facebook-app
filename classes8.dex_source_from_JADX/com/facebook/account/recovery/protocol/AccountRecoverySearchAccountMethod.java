package com.facebook.account.recovery.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.account.recovery.model.AccountCandidateModel;
import com.facebook.account.recovery.model.AccountCandidatesSummary;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.device_id.UniqueIdForDeviceHolderImpl;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: load_entity_page_failure */
public class AccountRecoverySearchAccountMethod implements ApiMethod<AccountRecoverySearchAccountMethodParams, Result> {
    private final UniqueIdForDeviceHolderImpl f10311a;

    @AutoGenJsonDeserializer
    @JsonDeserialize(using = AccountRecoverySearchAccountMethod_ResultDeserializer.class)
    /* compiled from: load_entity_page_failure */
    public class Result implements Parcelable {
        public static final Creator<Result> CREATOR = new C10931();
        @JsonProperty("data")
        private List<AccountCandidateModel> mAccountCandidates;
        @JsonProperty("summary")
        private AccountCandidatesSummary mSummary;

        /* compiled from: load_entity_page_failure */
        final class C10931 implements Creator<Result> {
            C10931() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new Result(parcel);
            }

            public final Object[] newArray(int i) {
                return new Result[i];
            }
        }

        public Result() {
            this.mAccountCandidates = new ArrayList();
            this.mSummary = new AccountCandidatesSummary();
        }

        public Result(Parcel parcel) {
            this.mAccountCandidates = parcel.createTypedArrayList(AccountCandidateModel.CREATOR);
        }

        public final int m12109a() {
            return this.mSummary.m12102a();
        }

        public final ImmutableList<AccountCandidateModel> m12110b() {
            return this.mAccountCandidates == null ? RegularImmutableList.a : ImmutableList.copyOf(this.mAccountCandidates);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeTypedList(this.mAccountCandidates);
            parcel.writeParcelable(this.mSummary, i);
        }
    }

    public final ApiRequest m12111a(Object obj) {
        AccountRecoverySearchAccountMethodParams accountRecoverySearchAccountMethodParams = (AccountRecoverySearchAccountMethodParams) obj;
        List arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("q", accountRecoverySearchAccountMethodParams.f10313b));
        arrayList.add(new BasicNameValuePair("friend_name", accountRecoverySearchAccountMethodParams.f10314c));
        arrayList.add(new BasicNameValuePair("qs", accountRecoverySearchAccountMethodParams.f10315d));
        arrayList.add(new BasicNameValuePair("summary", "true"));
        arrayList.add(new BasicNameValuePair("device_id", this.f10311a.a()));
        return new ApiRequest("accountRecoverySearch", "GET", "recover_accounts", RequestPriority.INTERACTIVE, arrayList, ApiResponseType.JSONPARSER);
    }

    @Inject
    public AccountRecoverySearchAccountMethod(UniqueIdForDeviceHolderImpl uniqueIdForDeviceHolderImpl) {
        this.f10311a = uniqueIdForDeviceHolderImpl;
    }

    public final Object m12112a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return (Result) apiResponse.d().a(Result.class);
    }
}
