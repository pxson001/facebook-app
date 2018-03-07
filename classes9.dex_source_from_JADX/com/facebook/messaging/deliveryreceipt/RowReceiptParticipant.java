package com.facebook.messaging.deliveryreceipt;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.messaging.model.messages.ParticipantInfo;
import com.google.common.base.Objects;
import java.util.Comparator;

/* compiled from: markMultipleThreads */
public class RowReceiptParticipant implements Parcelable {
    public static final Creator<RowReceiptParticipant> CREATOR = new C11982();
    public static final Comparator<RowReceiptParticipant> f10868a = new C11971();
    public final ParticipantInfo f10869b;
    public final long f10870c;

    /* compiled from: markMultipleThreads */
    final class C11971 implements Comparator<RowReceiptParticipant> {
        C11971() {
        }

        public final int compare(Object obj, Object obj2) {
            RowReceiptParticipant rowReceiptParticipant = (RowReceiptParticipant) obj;
            RowReceiptParticipant rowReceiptParticipant2 = (RowReceiptParticipant) obj2;
            if (rowReceiptParticipant.f10870c < rowReceiptParticipant2.f10870c) {
                return 1;
            }
            if (rowReceiptParticipant.f10870c > rowReceiptParticipant2.f10870c) {
                return -1;
            }
            return ParticipantInfo.a.compare(rowReceiptParticipant.f10869b, rowReceiptParticipant2.f10869b);
        }
    }

    /* compiled from: markMultipleThreads */
    final class C11982 implements Creator<RowReceiptParticipant> {
        C11982() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new RowReceiptParticipant(parcel);
        }

        public final Object[] newArray(int i) {
            return new RowReceiptParticipant[i];
        }
    }

    public RowReceiptParticipant(ParticipantInfo participantInfo, long j) {
        this.f10869b = participantInfo;
        this.f10870c = j;
    }

    public RowReceiptParticipant(Parcel parcel) {
        this.f10869b = (ParticipantInfo) parcel.readValue(ParticipantInfo.class.getClassLoader());
        this.f10870c = parcel.readLong();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.f10869b);
        parcel.writeLong(this.f10870c);
    }

    public String toString() {
        return Objects.toStringHelper(RowReceiptParticipant.class).add("participantInfo", this.f10869b).add("readTimestampMs", this.f10870c).toString();
    }
}
