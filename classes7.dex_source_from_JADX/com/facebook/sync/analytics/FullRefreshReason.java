package com.facebook.sync.analytics;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.util.StringUtil;
import javax.annotation.Nullable;

/* compiled from: feedback_top_level_comments */
public class FullRefreshReason implements Parcelable {
    public static final Creator<FullRefreshReason> CREATOR = new C10581();
    public static final FullRefreshReason f14425a = new FullRefreshReason(Type.NO_EXISTING_SYNC_TOKEN);
    public static final FullRefreshReason f14426b = new FullRefreshReason(Type.NO_EXISTING_SEQUENCE_ID);
    public static final FullRefreshReason f14427c = new FullRefreshReason(Type.USER_REQUESTED);
    public static final FullRefreshReason f14428d = new FullRefreshReason(Type.RECOVERY_FROM_UNCAUGHT_EXCEPTION);
    public static final FullRefreshReason f14429e = new FullRefreshReason(Type.MISSED_DELTA);
    public static final FullRefreshReason f14430f = new FullRefreshReason(Type.GATEKEEPER_CHANGED);
    public static final FullRefreshReason f14431g = new FullRefreshReason(Type.NONE);
    final Type f14432h;
    @Nullable
    final String f14433i;

    /* compiled from: feedback_top_level_comments */
    final class C10581 implements Creator<FullRefreshReason> {
        C10581() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FullRefreshReason(parcel);
        }

        public final Object[] newArray(int i) {
            return new FullRefreshReason[i];
        }
    }

    /* compiled from: feedback_top_level_comments */
    public enum Type {
        NO_EXISTING_SYNC_TOKEN,
        NO_EXISTING_SEQUENCE_ID,
        DELTA_FORCED_FETCH_NO_ARGS,
        UNCAUGHT_EXCEPTION,
        RECOVERY_FROM_UNCAUGHT_EXCEPTION,
        MISSED_DELTA,
        ERROR_CODE_FROM_SERVER,
        USER_REQUESTED,
        GATEKEEPER_CHANGED,
        NONE
    }

    private FullRefreshReason(Type type) {
        this(type, null);
    }

    private FullRefreshReason(Type type, @Nullable String str) {
        this.f14432h = type;
        this.f14433i = str;
    }

    public FullRefreshReason(Parcel parcel) {
        this.f14432h = (Type) parcel.readSerializable();
        this.f14433i = parcel.readString();
    }

    public String toString() {
        String str = this.f14432h.toString() + ":";
        return this.f14433i == null ? str : str + this.f14433i;
    }

    public static FullRefreshReason m18331a(String str) {
        if (StringUtil.a(str)) {
            return f14431g;
        }
        String[] split = str.split(":", 2);
        if (split.length != 2) {
            return f14431g;
        }
        try {
            return new FullRefreshReason(Type.valueOf(split[0]), split[1]);
        } catch (Exception e) {
            return f14431g;
        }
    }

    public static FullRefreshReason m18329a(long j) {
        return new FullRefreshReason(Type.DELTA_FORCED_FETCH_NO_ARGS, "firstDeltaSequenceId = " + j);
    }

    public static FullRefreshReason m18330a(Exception exception) {
        return new FullRefreshReason(Type.UNCAUGHT_EXCEPTION, "exception = " + exception.getMessage());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeSerializable(this.f14432h);
        parcel.writeString(this.f14433i);
    }
}
