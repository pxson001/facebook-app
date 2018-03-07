package com.facebook.messaging.payment.service.model.eligibility;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.parcels.ParcelUtil;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import javax.annotation.concurrent.Immutable;

@AutoGenJsonDeserializer
@JsonDeserialize(using = FetchP2PSendEligibilityResultDeserializer.class)
@Immutable
/* compiled from: fetch_thread_with_participants_key */
public class FetchP2PSendEligibilityResult implements Parcelable {
    public static final Creator<FetchP2PSendEligibilityResult> CREATOR = new C16821();
    @JsonProperty("can_viewer_send_money")
    private final boolean mCanSend;

    /* compiled from: fetch_thread_with_participants_key */
    final class C16821 implements Creator<FetchP2PSendEligibilityResult> {
        C16821() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchP2PSendEligibilityResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchP2PSendEligibilityResult[i];
        }
    }

    public FetchP2PSendEligibilityResult() {
        this.mCanSend = false;
    }

    public FetchP2PSendEligibilityResult(Boolean bool) {
        this.mCanSend = bool.booleanValue();
    }

    public FetchP2PSendEligibilityResult(Parcel parcel) {
        this.mCanSend = ParcelUtil.a(parcel);
    }

    public final boolean m15170a() {
        return this.mCanSend;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtil.a(parcel, this.mCanSend);
    }
}
