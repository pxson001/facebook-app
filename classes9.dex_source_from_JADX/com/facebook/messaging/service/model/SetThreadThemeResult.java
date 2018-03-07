package com.facebook.messaging.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadCustomization;
import com.google.common.base.Preconditions;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: connect */
public class SetThreadThemeResult implements Parcelable {
    public final ThreadKey f17331a;
    public final ThreadCustomization f17332b;

    public SetThreadThemeResult(SetThreadThemeResultBuilder setThreadThemeResultBuilder) {
        this.f17331a = (ThreadKey) Preconditions.checkNotNull(setThreadThemeResultBuilder.f17333a);
        this.f17332b = (ThreadCustomization) Preconditions.checkNotNull(setThreadThemeResultBuilder.f17334b);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f17331a, i);
        parcel.writeParcelable(this.f17332b, i);
    }
}
