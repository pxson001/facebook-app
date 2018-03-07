package com.facebook.common.callercontext;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.analytics.tagging.AnalyticsActivity;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: settings */
public class CallerContext implements Parcelable {
    public static final Creator<CallerContext> CREATOR = new C02481();
    public static final CallerContext f5180a = new CallerContext();
    public final String f5181b;
    private final String f5182c;
    private final String f5183d;
    private final String f5184e;

    /* compiled from: settings */
    final class C02481 implements Creator<CallerContext> {
        C02481() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new CallerContext(parcel);
        }

        public final Object[] newArray(int i) {
            return new CallerContext[i];
        }
    }

    private CallerContext() {
        this.f5181b = null;
        this.f5182c = null;
        this.f5183d = null;
        this.f5184e = null;
    }

    private CallerContext(Class<?> cls, @Nullable String str, @Nullable String str2, @Nullable String str3) {
        Preconditions.checkNotNull(cls);
        this.f5181b = cls.getName();
        this.f5182c = str;
        this.f5184e = str2;
        this.f5183d = str3;
    }

    protected CallerContext(Parcel parcel) {
        this.f5181b = parcel.readString();
        this.f5184e = parcel.readString();
        this.f5182c = parcel.readString();
        this.f5183d = parcel.readString();
    }

    private CallerContext(String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        this.f5181b = str;
        this.f5182c = str2;
        this.f5184e = str3;
        this.f5183d = str4;
    }

    public static CallerContext m9060a(Class<?> cls) {
        return new CallerContext((Class) cls, null, null, null);
    }

    public static CallerContext m9061a(Class<?> cls, @Nullable String str) {
        return new CallerContext((Class) cls, str, str, str);
    }

    public static CallerContext m9064b(Class<?> cls, @Nullable String str) {
        return new CallerContext((Class) cls, null, str, null);
    }

    public static CallerContext m9062a(Class<?> cls, @Nullable String str, @Nullable String str2) {
        return new CallerContext((Class) cls, str, str2, str);
    }

    public static CallerContext m9065b(Class<?> cls, @Nullable String str, @Nullable String str2) {
        return new CallerContext((Class) cls, str, null, str2);
    }

    public static CallerContext m9063a(Class<?> cls, @Nullable String str, @Nullable String str2, @Nullable String str3) {
        return new CallerContext((Class) cls, str, str2, str3);
    }

    public static CallerContext m9059a(CallerContext callerContext, @Nullable String str) {
        return callerContext.f5184e != null ? callerContext : new CallerContext(callerContext.f5181b, callerContext.f5182c, str, callerContext.f5183d);
    }

    public static CallerContext m9058a(Context context) {
        if (context == null) {
            return null;
        }
        Class cls = context.getClass();
        if (!AnalyticsActivity.class.isAssignableFrom(cls)) {
            return m9061a(cls, "unknown");
        }
        CallerContext callerContext;
        AnalyticsActivity analyticsActivity = (AnalyticsActivity) context;
        if (analyticsActivity == null) {
            callerContext = null;
        } else {
            callerContext = m9061a(analyticsActivity.getClass(), analyticsActivity.am_());
        }
        return callerContext;
    }

    public final String m9066a() {
        return this.f5181b;
    }

    public final String m9067b() {
        return this.f5184e == null ? "unknown" : this.f5184e;
    }

    public final String m9068c() {
        return this.f5182c == null ? "unknown" : this.f5182c;
    }

    public final String m9069d() {
        return this.f5183d == null ? "unknown" : this.f5183d;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f5181b);
        parcel.writeString(this.f5184e);
        parcel.writeString(this.f5182c);
        parcel.writeString(this.f5183d);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return Objects.toStringHelper((Object) this).add("Calling Class Name", this.f5181b).add("Analytics Tag", this.f5182c).add("Feature tag", this.f5184e).add("Module Analytics Tag", this.f5183d).toString();
    }

    public int hashCode() {
        return Objects.hashCode(this.f5181b, this.f5182c, this.f5184e, this.f5183d);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof CallerContext)) {
            return false;
        }
        CallerContext callerContext = (CallerContext) obj;
        if (Objects.equal(this.f5181b, callerContext.f5181b) && Objects.equal(this.f5182c, callerContext.f5182c) && Objects.equal(this.f5184e, callerContext.f5184e) && Objects.equal(this.f5183d, callerContext.f5183d)) {
            return true;
        }
        return false;
    }
}
