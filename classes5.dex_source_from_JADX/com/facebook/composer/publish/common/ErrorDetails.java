package com.facebook.composer.publish.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.parcels.ParcelUtil;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.Objects;

@AutoGenJsonDeserializer
@JsonDeserialize(using = ErrorDetailsDeserializer.class)
/* compiled from: add */
public class ErrorDetails implements Parcelable {
    public static final Creator<ErrorDetails> CREATOR = new C10831();
    @JsonProperty("error_code")
    public final int errorCode;
    @JsonProperty("error_subcode")
    public final int errorSubcode;
    @JsonProperty("is_retriable")
    public final boolean isRetriable;
    @JsonProperty("sentry_warning_with_user_confirmation_required")
    public final boolean isSentryWarningWithUserConfirmationRequired;
    @JsonProperty("video_transcoding_error")
    public final boolean isVideoTranscodingError;
    @JsonProperty("log_message")
    public final String logMessage;
    @JsonProperty("message")
    public final String userMessage;
    @JsonProperty("user_title")
    public final String userTitle;

    /* compiled from: add */
    final class C10831 implements Creator<ErrorDetails> {
        C10831() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ErrorDetails(parcel);
        }

        public final Object[] newArray(int i) {
            return new ErrorDetails[i];
        }
    }

    /* compiled from: add */
    public class Builder {
        public boolean f11504a = true;
        public String f11505b = "";
        public String f11506c = "";
        public int f11507d = 0;
        public int f11508e = 0;
        public boolean f11509f = false;
        public String f11510g = "";
        public boolean f11511h = false;

        public final Builder m19654a(boolean z) {
            this.f11504a = z;
            return this;
        }

        public final Builder m19653a(String str) {
            if (str == null) {
                str = "";
            }
            this.f11505b = str;
            return this;
        }

        public final ErrorDetails m19655a() {
            return new ErrorDetails(this);
        }
    }

    private ErrorDetails() {
        this(new Builder());
    }

    public ErrorDetails(Builder builder) {
        this.isRetriable = builder.f11504a;
        this.userMessage = builder.f11505b;
        this.logMessage = builder.f11506c;
        this.errorCode = builder.f11507d;
        this.errorSubcode = builder.f11508e;
        this.isSentryWarningWithUserConfirmationRequired = builder.f11509f;
        this.userTitle = builder.f11510g;
        this.isVideoTranscodingError = builder.f11511h;
    }

    public ErrorDetails(Parcel parcel) {
        this.isRetriable = ParcelUtil.m3827a(parcel);
        this.userMessage = parcel.readString();
        this.logMessage = parcel.readString();
        this.errorCode = parcel.readInt();
        this.errorSubcode = parcel.readInt();
        this.isSentryWarningWithUserConfirmationRequired = ParcelUtil.m3827a(parcel);
        this.userTitle = parcel.readString();
        this.isVideoTranscodingError = ParcelUtil.m3827a(parcel);
    }

    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtil.m3826a(parcel, this.isRetriable);
        parcel.writeString(this.userMessage);
        parcel.writeString(this.logMessage);
        parcel.writeInt(this.errorCode);
        parcel.writeInt(this.errorSubcode);
        ParcelUtil.m3826a(parcel, this.isSentryWarningWithUserConfirmationRequired);
        parcel.writeString(this.userTitle);
        ParcelUtil.m3826a(parcel, this.isVideoTranscodingError);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ErrorDetails)) {
            return false;
        }
        ErrorDetails errorDetails = (ErrorDetails) obj;
        if (Objects.equal(Boolean.valueOf(this.isRetriable), Boolean.valueOf(errorDetails.isRetriable)) && Objects.equal(this.userMessage, errorDetails.userMessage) && Objects.equal(this.logMessage, errorDetails.logMessage) && this.errorCode == errorDetails.errorCode && this.errorSubcode == errorDetails.errorSubcode && Objects.equal(Boolean.valueOf(this.isSentryWarningWithUserConfirmationRequired), Boolean.valueOf(errorDetails.isSentryWarningWithUserConfirmationRequired)) && Objects.equal(this.userTitle, errorDetails.userTitle)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{Boolean.valueOf(this.isRetriable), this.userMessage, this.logMessage, Integer.valueOf(this.errorCode), Integer.valueOf(this.errorSubcode), Boolean.valueOf(this.isSentryWarningWithUserConfirmationRequired), this.userTitle});
    }
}
