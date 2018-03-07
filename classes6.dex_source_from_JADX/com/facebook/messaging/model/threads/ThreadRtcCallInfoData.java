package com.facebook.messaging.model.threads;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.util.StringUtil;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: update-photo-order */
public class ThreadRtcCallInfoData implements Parcelable {
    public static final Creator<ThreadRtcCallInfoData> CREATOR = new C01251();
    public static final ThreadRtcCallInfoData f2290a = new ThreadRtcCallInfoData(CallState.UNKNOWN, null, null);
    public final CallState f2291b;
    @Nullable
    public final String f2292c;
    @Nullable
    public final String f2293d;

    /* compiled from: update-photo-order */
    final class C01251 implements Creator<ThreadRtcCallInfoData> {
        C01251() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ThreadRtcCallInfoData(parcel);
        }

        public final Object[] newArray(int i) {
            return new ThreadRtcCallInfoData[i];
        }
    }

    /* compiled from: update-photo-order */
    public class Builder {
        public CallState f2287a = CallState.UNKNOWN;
        @Nullable
        public String f2288b;
        @Nullable
        public String f2289c;

        public final Builder m3560a(String str) {
            this.f2287a = CallState.UNKNOWN;
            for (CallState callState : CallState.values()) {
                if (callState.equalsName(str)) {
                    this.f2287a = callState;
                    break;
                }
            }
            return this;
        }

        public final Builder m3561b(String str) {
            this.f2288b = str;
            return this;
        }

        public final Builder m3562c(String str) {
            this.f2289c = str;
            return this;
        }

        public final ThreadRtcCallInfoData m3563d() {
            return new ThreadRtcCallInfoData(this);
        }
    }

    @Immutable
    /* compiled from: update-photo-order */
    public enum CallState {
        NO_ONGOING_CALL("NO_ONGOING_CALL"),
        AUDIO_GROUP_CALL("AUDIO_GROUP_CALL"),
        VIDEO_GROUP_CALL("VIDEO_GROUP_CALL"),
        UNKNOWN("UNKNOWN");
        
        private final String state;

        private CallState(String str) {
            this.state = str;
        }

        public final boolean equalsName(String str) {
            return str != null && this.state.equals(str);
        }

        public final String toString() {
            return this.state;
        }
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    private ThreadRtcCallInfoData(CallState callState, @Nullable String str, @Nullable String str2) {
        this.f2291b = callState;
        this.f2292c = str;
        this.f2293d = str2;
    }

    public ThreadRtcCallInfoData(Builder builder) {
        this.f2291b = builder.f2287a;
        this.f2292c = builder.f2288b;
        this.f2293d = builder.f2289c;
    }

    public ThreadRtcCallInfoData(Parcel parcel) {
        this.f2291b = (CallState) parcel.readSerializable();
        this.f2292c = parcel.readString();
        this.f2293d = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public int hashCode() {
        int hashCode = this.f2291b.hashCode();
        if (this.f2292c != null) {
            hashCode = (hashCode * 31) + this.f2292c.hashCode();
        }
        if (this.f2293d != null) {
            return (hashCode * 31) + this.f2293d.hashCode();
        }
        return hashCode;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ThreadRtcCallInfoData threadRtcCallInfoData = (ThreadRtcCallInfoData) obj;
        if (this.f2291b == threadRtcCallInfoData.f2291b && StringUtil.a(this.f2292c, threadRtcCallInfoData.f2292c) && StringUtil.a(this.f2293d, threadRtcCallInfoData.f2293d)) {
            return true;
        }
        return false;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeSerializable(this.f2291b);
        parcel.writeString(this.f2292c);
        parcel.writeString(this.f2293d);
    }

    public final boolean m3564a() {
        return this.f2291b == CallState.AUDIO_GROUP_CALL || this.f2291b == CallState.VIDEO_GROUP_CALL;
    }

    public final boolean m3565b() {
        return this.f2291b == CallState.VIDEO_GROUP_CALL;
    }
}
