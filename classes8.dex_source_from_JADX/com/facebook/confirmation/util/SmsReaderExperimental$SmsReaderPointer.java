package com.facebook.confirmation.util;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@AutoGenJsonDeserializer
@JsonDeserialize(using = SmsReaderExperimental_SmsReaderPointerDeserializer.class)
/* compiled from: inline_action_type */
public class SmsReaderExperimental$SmsReaderPointer implements Parcelable {
    public static final Creator<SmsReaderExperimental$SmsReaderPointer> CREATOR = new C11661();
    @JsonProperty("mms_id")
    public long mmsId;
    @JsonProperty("sms_id")
    public long smsId;

    /* compiled from: inline_action_type */
    final class C11661 implements Creator<SmsReaderExperimental$SmsReaderPointer> {
        C11661() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SmsReaderExperimental$SmsReaderPointer(parcel);
        }

        public final Object[] newArray(int i) {
            return new SmsReaderExperimental$SmsReaderPointer[i];
        }
    }

    public SmsReaderExperimental$SmsReaderPointer() {
        this(-1, -1);
    }

    public SmsReaderExperimental$SmsReaderPointer(long j, long j2) {
        this.smsId = j;
        this.mmsId = j2;
    }

    public SmsReaderExperimental$SmsReaderPointer(Parcel parcel) {
        this.smsId = parcel.readLong();
        this.mmsId = parcel.readLong();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.smsId);
        parcel.writeLong(this.mmsId);
    }
}
