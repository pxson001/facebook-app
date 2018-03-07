package com.facebook.abtest.qe.bootstrap.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Absent;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: photo_taken_in_last_n_minutes */
public class QuickExperimentInfo extends BasicQuickExperimentInfo implements Parcelable {
    public static final Creator<QuickExperimentInfo> CREATOR = new C04221();
    public ImmutableMap<String, String> f10002g;
    public final QuickExperimentParameters f10003h;

    /* compiled from: photo_taken_in_last_n_minutes */
    public class Builder extends com.facebook.abtest.qe.bootstrap.data.BasicQuickExperimentInfo.Builder {
        public Map<String, String> f9995g;

        public final /* synthetic */ com.facebook.abtest.qe.bootstrap.data.BasicQuickExperimentInfo.Builder mo1960a(String str) {
            return m15040e(str);
        }

        public final /* synthetic */ com.facebook.abtest.qe.bootstrap.data.BasicQuickExperimentInfo.Builder mo1961a(boolean z) {
            return m15037c(z);
        }

        public final /* synthetic */ com.facebook.abtest.qe.bootstrap.data.BasicQuickExperimentInfo.Builder mo1962b(String str) {
            return m15041f(str);
        }

        public final /* synthetic */ com.facebook.abtest.qe.bootstrap.data.BasicQuickExperimentInfo.Builder mo1963b(boolean z) {
            return m15039d(z);
        }

        public final /* synthetic */ com.facebook.abtest.qe.bootstrap.data.BasicQuickExperimentInfo.Builder mo1964c(String str) {
            return m15042g(str);
        }

        public final /* synthetic */ com.facebook.abtest.qe.bootstrap.data.BasicQuickExperimentInfo.Builder mo1965d(String str) {
            return m15043h(str);
        }

        public final Builder m15040e(String str) {
            super.mo1960a(str);
            return this;
        }

        public final Builder m15041f(String str) {
            super.mo1962b(str);
            return this;
        }

        public final Builder m15037c(boolean z) {
            super.mo1961a(z);
            return this;
        }

        public final Builder m15039d(boolean z) {
            super.mo1963b(z);
            return this;
        }

        public final Builder m15042g(String str) {
            super.mo1964c(str);
            return this;
        }

        public final Builder m15043h(String str) {
            super.mo1965d(str);
            return this;
        }

        public final Builder m15032a(Map<String, String> map) {
            this.f9995g = map;
            return this;
        }

        public final QuickExperimentInfo m15033a() {
            return new QuickExperimentInfo(this);
        }
    }

    /* compiled from: photo_taken_in_last_n_minutes */
    final class C04221 implements Creator<QuickExperimentInfo> {
        C04221() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new QuickExperimentInfo(parcel);
        }

        public final Object[] newArray(int i) {
            return new QuickExperimentInfo[i];
        }
    }

    protected QuickExperimentInfo(Builder builder) {
        super(builder);
        this.f10002g = ImmutableMap.copyOf(builder.f9995g);
        this.f10003h = new QuickExperimentParameters(this.f10004a, this.f10006c, this.f10007d, this.f10008e, this.f10002g);
    }

    public final String m15051a() {
        return this.f10004a;
    }

    public final String m15052b() {
        return this.f10008e;
    }

    public QuickExperimentInfo(Parcel parcel) {
        boolean z = true;
        com.facebook.abtest.qe.bootstrap.data.BasicQuickExperimentInfo.Builder a = new com.facebook.abtest.qe.bootstrap.data.BasicQuickExperimentInfo.Builder().mo1960a(parcel.readString()).mo1962b(parcel.readString()).mo1961a(parcel.readInt() == 1);
        if (parcel.readInt() != 1) {
            z = false;
        }
        super(a.mo1963b(z).mo1964c(parcel.readString()).mo1965d(parcel.readString()));
        this.f10002g = ImmutableMap.copyOf(parcel.readHashMap(QuickExperimentInfo.class.getClassLoader()));
        this.f10003h = new QuickExperimentParameters(this.f10004a, this.f10006c, this.f10007d, this.f10008e, this.f10002g);
    }

    public final String m15053c() {
        return this.f10005b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        parcel.writeString(this.f10004a);
        parcel.writeString(this.f10008e);
        parcel.writeInt(this.f10006c ? 1 : 0);
        if (!this.f10007d) {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeString(this.f10005b);
        parcel.writeString(this.f10009f);
        parcel.writeMap(this.f10002g);
    }

    public final Map<String, String> m15054f() {
        return this.f10002g;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof QuickExperimentInfo)) {
            return false;
        }
        QuickExperimentInfo quickExperimentInfo = (QuickExperimentInfo) obj;
        boolean z = false;
        if ((this != null || quickExperimentInfo == null) && ((quickExperimentInfo != null || this == null) && Objects.equal(this.f10008e, quickExperimentInfo.f10008e) && Objects.equal(this.f10009f, quickExperimentInfo.f10009f) && Objects.equal(this.f10004a, quickExperimentInfo.f10004a) && this.f10006c == quickExperimentInfo.f10006c && this.f10007d == quickExperimentInfo.f10007d && Objects.equal(this.f10002g, quickExperimentInfo.f10002g) && Objects.equal(this.f10005b, quickExperimentInfo.f10005b))) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        return Objects.hashCode(this.f10008e, this.f10009f, this.f10004a, Boolean.valueOf(this.f10006c), Boolean.valueOf(this.f10007d), this.f10002g, this.f10005b);
    }

    public final Optional<String> m15050a(String str) {
        if (this.f10008e.equals("local_default_group")) {
            return Absent.INSTANCE;
        }
        String str2 = (String) this.f10002g.get(str);
        if (str2 == null) {
            return Absent.INSTANCE;
        }
        return Optional.of(str2);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f10004a).append("/Group:").append(this.f10008e).append("/Experiment:").append(this.f10006c).append("/InDeployGroup:").append(this.f10007d).append("/Locale:").append(this.f10009f).append("/customStrings: ");
        Iterator it = this.f10002g.entrySet().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            stringBuilder.append("\n").append((String) entry.getKey()).append(": ").append((String) entry.getValue());
        }
        return stringBuilder.toString();
    }
}
