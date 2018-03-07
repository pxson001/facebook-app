package com.facebook.messaging.payment.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.MoreObjects;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: home.php.* */
public class VerificationFollowUpAction implements Parcelable {
    public static final Creator<VerificationFollowUpAction> CREATOR = new C14881();
    @Nullable
    public final String f13262a;
    @Nullable
    public final String f13263b;
    @Nullable
    public final String f13264c;
    @Nullable
    public final String f13265d;

    /* compiled from: home.php.* */
    final class C14881 implements Creator<VerificationFollowUpAction> {
        C14881() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new VerificationFollowUpAction(parcel);
        }

        public final Object[] newArray(int i) {
            return new VerificationFollowUpAction[i];
        }
    }

    public VerificationFollowUpAction(VerificationFollowUpActionBuilder verificationFollowUpActionBuilder) {
        this.f13262a = verificationFollowUpActionBuilder.f13266a;
        this.f13263b = verificationFollowUpActionBuilder.f13267b;
        this.f13264c = verificationFollowUpActionBuilder.f13268c;
        this.f13265d = verificationFollowUpActionBuilder.f13269d;
    }

    public VerificationFollowUpAction(Parcel parcel) {
        this.f13262a = parcel.readString();
        this.f13263b = parcel.readString();
        this.f13264c = parcel.readString();
        this.f13265d = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f13262a);
        parcel.writeString(this.f13263b);
        parcel.writeString(this.f13264c);
        parcel.writeString(this.f13265d);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("actionType", this.f13262a).add("actionText", this.f13263b).add("actionUrl", this.f13264c).add("actionButtonText", this.f13265d).toString();
    }
}
