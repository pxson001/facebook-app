package com.facebook.http.interfaces;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.debug.log.BLog;
import javax.annotation.Nullable;

/* compiled from: release */
public enum RequestPriority implements Parcelable {
    INTERACTIVE(0),
    NON_INTERACTIVE(1),
    CAN_WAIT(2),
    UNNECESSARY(3),
    UNUSED_REQUEST_PRIORITY(999);
    
    public static final Creator<RequestPriority> CREATOR = null;
    public static final RequestPriority DEFAULT_PRIORITY = null;
    private static final Class<?> TAG = null;
    private final int requestPriority;

    /* compiled from: release */
    final class C03251 implements Creator<RequestPriority> {
        C03251() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return RequestPriority.getPriorityFromString(parcel.readString());
        }

        public final Object[] newArray(int i) {
            return new RequestPriority[i];
        }
    }

    static {
        DEFAULT_PRIORITY = NON_INTERACTIVE;
        TAG = RequestPriority.class;
        CREATOR = new C03251();
    }

    private RequestPriority(int i) {
        this.requestPriority = i;
    }

    public final int getNumericValue() {
        return this.requestPriority;
    }

    public final boolean isHigherPriorityThan(@Nullable RequestPriority requestPriority) {
        if (requestPriority != null && requestPriority.getNumericValue() >= getNumericValue()) {
            return false;
        }
        return true;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name());
    }

    public static int getNumericValueFromString(String str) {
        for (RequestPriority requestPriority : values()) {
            if (requestPriority.toString().equals(str)) {
                return requestPriority.getNumericValue();
            }
        }
        BLog.b(TAG, "Do not recognize priority %s. Defaulting to -1.", new Object[]{str});
        return -1;
    }

    public static RequestPriority getPriorityFromString(String str) {
        try {
            return valueOf(str);
        } catch (IllegalArgumentException e) {
            BLog.b(TAG, "Do not recognize priority %s. Defaulting to %s.", new Object[]{str, DEFAULT_PRIORITY.name()});
            return DEFAULT_PRIORITY;
        }
    }

    public static RequestPriority fromNumericValue(int i, RequestPriority requestPriority) {
        for (RequestPriority requestPriority2 : values()) {
            if (requestPriority2.getNumericValue() == i) {
                return requestPriority2;
            }
        }
        return requestPriority;
    }
}
