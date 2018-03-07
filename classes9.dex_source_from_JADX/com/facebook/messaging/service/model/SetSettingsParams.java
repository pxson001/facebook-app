package com.facebook.messaging.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.messaging.model.threads.NotificationSetting;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: connections */
public class SetSettingsParams implements Parcelable {
    public static final Creator<SetSettingsParams> CREATOR = new C20611();
    public boolean f17327a;
    public NotificationSetting f17328b;

    /* compiled from: connections */
    final class C20611 implements Creator<SetSettingsParams> {
        C20611() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SetSettingsParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new SetSettingsParams[i];
        }
    }

    SetSettingsParams(SetSettingsParamsBuilder setSettingsParamsBuilder) {
        this.f17327a = setSettingsParamsBuilder.f17329a;
        this.f17328b = setSettingsParamsBuilder.f17330b;
    }

    public SetSettingsParams(Parcel parcel) {
        this.f17327a = parcel.readInt() != 0;
        this.f17328b = (NotificationSetting) parcel.readParcelable(NotificationSetting.class.getClassLoader());
    }

    public final NotificationSetting m17190b() {
        return this.f17328b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f17327a ? 1 : 0);
        parcel.writeParcelable(this.f17328b, i);
    }
}
