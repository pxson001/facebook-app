package com.facebook.push.mqtt.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.push.mqtt.ipc.MqttPublishArrivedListener.Stub;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: heisman_camera_intent_data */
public class StickySubscribeTopic implements Parcelable {
    public static final Creator<StickySubscribeTopic> CREATOR = new C05221();
    public final SubscribeTopic f11054a;
    private final SubscribeWhen f11055b;
    private final String f11056c;
    @Nullable
    private final MqttPublishArrivedListener f11057d;

    /* compiled from: heisman_camera_intent_data */
    final class C05221 implements Creator<StickySubscribeTopic> {
        C05221() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new StickySubscribeTopic((SubscribeTopic) parcel.readParcelable(SubscribeTopic.class.getClassLoader()), SubscribeWhen.fromOrdinal(parcel.readInt()), parcel.readString(), Stub.a(parcel.readStrongBinder()));
        }

        public final Object[] newArray(int i) {
            return new StickySubscribeTopic[i];
        }
    }

    /* compiled from: heisman_camera_intent_data */
    public enum SubscribeWhen {
        SUBSCRIBE_ALWAYS,
        SUBSCRIBE_ON_DEVICE_USE;

        public static SubscribeWhen fromOrdinal(int i) {
            return values()[i];
        }
    }

    public StickySubscribeTopic(SubscribeTopic subscribeTopic, SubscribeWhen subscribeWhen, String str, @Nullable MqttPublishArrivedListener mqttPublishArrivedListener) {
        this.f11054a = (SubscribeTopic) Preconditions.checkNotNull(subscribeTopic);
        this.f11055b = (SubscribeWhen) Preconditions.checkNotNull(subscribeWhen);
        this.f11056c = (String) Preconditions.checkNotNull(str);
        this.f11057d = mqttPublishArrivedListener;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        StickySubscribeTopic stickySubscribeTopic = (StickySubscribeTopic) obj;
        if (Objects.equal(this.f11056c, stickySubscribeTopic.f11056c) && Objects.equal(this.f11057d, stickySubscribeTopic.f11057d) && Objects.equal(this.f11055b, stickySubscribeTopic.f11055b) && Objects.equal(this.f11054a, stickySubscribeTopic.f11054a)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.f11056c, this.f11057d, this.f11055b, this.f11054a});
    }

    public String toString() {
        return Objects.toStringHelper(this).add("topic", this.f11054a).add("when", this.f11055b).add("category", this.f11056c).add("listener", this.f11057d != null ? "non-null" : "null").toString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f11054a, i);
        parcel.writeInt(this.f11055b.ordinal());
        parcel.writeString(this.f11056c);
        parcel.writeStrongInterface(this.f11057d);
    }
}
