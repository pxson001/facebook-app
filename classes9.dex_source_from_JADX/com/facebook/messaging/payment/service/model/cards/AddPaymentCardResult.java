package com.facebook.messaging.payment.service.model.cards;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@AutoGenJsonDeserializer
@JsonDeserialize(using = AddPaymentCardResultDeserializer.class)
@Immutable
/* compiled from: first_contacts */
public class AddPaymentCardResult implements Parcelable {
    public static final Creator<AddPaymentCardResult> CREATOR = new C16681();
    @JsonProperty("credential_id")
    public final String credentialId;
    @JsonProperty("encoded_credential_id")
    public final String encodedCredentialId;
    @JsonProperty("follow_up_action_button_text")
    @Nullable
    public final String followUpActionButtonText;
    @JsonProperty("follow_up_action_text")
    @Nullable
    public final String followUpActionText;
    @JsonProperty("follow_up_action_type")
    @Nullable
    public final String followUpActionType;
    @JsonProperty("follow_up_action_url")
    @Nullable
    public final String followUpActionUrl;

    /* compiled from: first_contacts */
    final class C16681 implements Creator<AddPaymentCardResult> {
        C16681() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new AddPaymentCardResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new AddPaymentCardResult[i];
        }
    }

    public static AddPaymentCardResultBuilder newBuilder() {
        return new AddPaymentCardResultBuilder();
    }

    private AddPaymentCardResult() {
        this.credentialId = null;
        this.encodedCredentialId = null;
        this.followUpActionType = null;
        this.followUpActionText = null;
        this.followUpActionUrl = null;
        this.followUpActionButtonText = null;
    }

    public AddPaymentCardResult(Parcel parcel) {
        this.credentialId = parcel.readString();
        this.encodedCredentialId = parcel.readString();
        this.followUpActionType = parcel.readString();
        this.followUpActionText = parcel.readString();
        this.followUpActionUrl = parcel.readString();
        this.followUpActionButtonText = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.credentialId);
        parcel.writeString(this.encodedCredentialId);
        parcel.writeString(this.followUpActionType);
        parcel.writeString(this.followUpActionText);
        parcel.writeString(this.followUpActionUrl);
        parcel.writeString(this.followUpActionButtonText);
    }
}
