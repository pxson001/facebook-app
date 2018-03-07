package com.facebook.messaging.payment.service.model.sync;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@AutoGenJsonDeserializer
@JsonDeserialize(using = FetchIrisSequenceIdResultDeserializer.class)
@Immutable
/* compiled from: fetchTransactionListMethod */
public class FetchIrisSequenceIdResult implements Parcelable {
    public static final Creator<FetchIrisSequenceIdResult> CREATOR = new C16981();
    @JsonProperty("iris_sequence_id")
    private final String mIrisSequenceId;

    /* compiled from: fetchTransactionListMethod */
    final class C16981 implements Creator<FetchIrisSequenceIdResult> {
        C16981() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchIrisSequenceIdResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchIrisSequenceIdResult[i];
        }
    }

    public FetchIrisSequenceIdResult(@Nullable String str) {
        this.mIrisSequenceId = str;
    }

    public FetchIrisSequenceIdResult(Parcel parcel) {
        this.mIrisSequenceId = parcel.readString();
    }

    private FetchIrisSequenceIdResult() {
        this.mIrisSequenceId = null;
    }

    @Nullable
    public final String m15196a() {
        return this.mIrisSequenceId;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mIrisSequenceId);
    }
}
