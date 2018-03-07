package com.facebook.fbtrace;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.debug.log.BLog;
import com.facebook.fbtrace.utils.FbTraceId;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: render_state */
public class FbTraceNode implements Parcelable {
    public static final Creator<FbTraceNode> CREATOR = new C03201();
    public static final FbTraceNode f7566a = new FbTraceNode("invalid_id", "invalid_id", "invalid_id");
    private static final Class<?> f7567e = FbTraceNode.class;
    public final String f7568b;
    public final String f7569c;
    public final String f7570d;

    /* compiled from: render_state */
    final class C03201 implements Creator<FbTraceNode> {
        C03201() {
        }

        public final Object createFromParcel(Parcel parcel) {
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            if (Objects.equal(readString, "invalid_id")) {
                return FbTraceNode.f7566a;
            }
            return new FbTraceNode(readString, readString2, readString3);
        }

        public final Object[] newArray(int i) {
            return new FbTraceNode[i];
        }
    }

    public FbTraceNode(String str, String str2, @Nullable String str3) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(str2);
        this.f7568b = str;
        this.f7569c = str2;
        this.f7570d = str3;
    }

    static FbTraceNode m12157a(String str) {
        if (Objects.equal(str, "invalid_id")) {
            return f7566a;
        }
        return new FbTraceNode(str, FbTraceId.m1022a(), null);
    }

    static FbTraceNode m12158b(String str) {
        try {
            long[] a = FbTraceId.m1025a(str);
            return new FbTraceNode(FbTraceId.m1023a(a[0]), FbTraceId.m1023a(a[1]), null);
        } catch (Throwable e) {
            BLog.a(f7567e, e, "invalid FbTrace metadata: %s", new Object[]{str});
        } catch (Throwable e2) {
            BLog.a(f7567e, e2, "invalid FbTrace metadata: %s", new Object[]{str});
        }
        return f7566a;
    }

    public final String m12159a() {
        return this.f7568b + this.f7569c;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7568b);
        parcel.writeString(this.f7569c);
        parcel.writeString(this.f7570d);
    }
}
