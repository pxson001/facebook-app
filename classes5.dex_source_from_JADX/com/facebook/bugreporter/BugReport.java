package com.facebook.bugreporter;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.reviews.protocol.graphql.UserReviewsFragmentsParsers.UserReviewsParser;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: android.speech.extra.MAX_RESULTS */
public class BugReport implements Parcelable, Flattenable {
    public static final Creator<BugReport> CREATOR = new C10011();
    public Uri f10405a;
    public String f10406b;
    public Uri f10407c;
    public ImmutableList<Uri> f10408d;
    public ImmutableMap<String, String> f10409e;
    public ImmutableMap<String, String> f10410f;
    public String f10411g;
    public String f10412h;
    public String f10413i;
    public String f10414j;
    public String f10415k;
    public String f10416l;
    public String f10417m;
    public String f10418n;
    public String f10419o;
    public String f10420p;
    public BugReportSource f10421q;
    public String f10422r;
    public int f10423s;
    public ImmutableMap<String, String> f10424t;
    public String f10425u;
    public String f10426v;
    public String f10427w;

    /* compiled from: android.speech.extra.MAX_RESULTS */
    final class C10011 implements Creator<BugReport> {
        C10011() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new BugReport(parcel);
        }

        public final Object[] newArray(int i) {
            return new BugReport[i];
        }
    }

    BugReport(BugReportBuilder bugReportBuilder) {
        this.f10405a = bugReportBuilder.f10439a;
        this.f10406b = bugReportBuilder.f10440b;
        this.f10407c = bugReportBuilder.f10441c;
        this.f10408d = bugReportBuilder.m18540d();
        this.f10409e = bugReportBuilder.f10443e;
        this.f10424t = bugReportBuilder.f10444f;
        this.f10411g = bugReportBuilder.f10446h;
        this.f10412h = bugReportBuilder.f10447i;
        this.f10413i = bugReportBuilder.f10448j;
        this.f10414j = bugReportBuilder.f10449k;
        this.f10415k = bugReportBuilder.f10450l;
        this.f10416l = bugReportBuilder.f10451m;
        this.f10417m = bugReportBuilder.f10452n;
        this.f10418n = bugReportBuilder.f10453o;
        this.f10419o = bugReportBuilder.f10454p;
        this.f10420p = bugReportBuilder.f10455q;
        this.f10421q = bugReportBuilder.f10456r;
        this.f10410f = bugReportBuilder.f10445g;
        this.f10422r = bugReportBuilder.f10457s;
        this.f10423s = bugReportBuilder.f10458t;
        this.f10425u = bugReportBuilder.f10459u;
        this.f10426v = bugReportBuilder.f10460v;
        this.f10427w = bugReportBuilder.f10461w;
        m18501a(this.f10405a, false);
        int size = this.f10408d.size();
        for (int i = 0; i < size; i++) {
            m18501a((Uri) this.f10408d.get(i), true);
        }
        m18501a(this.f10407c, true);
        Preconditions.checkNotNull(this.f10411g);
    }

    private static void m18501a(Uri uri, boolean z) {
        if (!z) {
            Preconditions.checkNotNull(uri);
        }
        if (uri != null) {
            Preconditions.checkArgument("file".equals(uri.getScheme()));
            Preconditions.checkArgument(uri.isAbsolute());
        }
    }

    public BugReport(Parcel parcel) {
        this.f10405a = (Uri) parcel.readParcelable(null);
        this.f10406b = parcel.readString();
        this.f10407c = (Uri) parcel.readParcelable(null);
        this.f10411g = parcel.readString();
        this.f10412h = parcel.readString();
        this.f10413i = parcel.readString();
        this.f10414j = parcel.readString();
        this.f10415k = parcel.readString();
        this.f10416l = parcel.readString();
        this.f10417m = parcel.readString();
        this.f10418n = parcel.readString();
        this.f10419o = parcel.readString();
        this.f10420p = parcel.readString();
        this.f10421q = (BugReportSource) parcel.readSerializable();
        this.f10422r = parcel.readString();
        this.f10427w = parcel.readString();
        Collection b = Lists.b();
        parcel.readTypedList(b, Uri.CREATOR);
        this.f10408d = ImmutableList.copyOf(b);
        this.f10409e = m18500a(parcel);
        this.f10424t = m18500a(parcel);
        Map c = Maps.c();
        parcel.readMap(c, BugReport.class.getClassLoader());
        this.f10410f = ImmutableMap.copyOf(c);
        this.f10423s = parcel.readInt();
        this.f10425u = parcel.readString();
        this.f10426v = parcel.readString();
    }

    private static ImmutableMap<String, String> m18500a(Parcel parcel) {
        Builder builder = ImmutableMap.builder();
        int readInt = parcel.readInt();
        for (int i = 0; i < readInt; i++) {
            builder.b(parcel.readString(), parcel.readString());
        }
        return builder.b();
    }

    public BugReport(ByteBuffer byteBuffer) {
        UserReviewsParser.a(this, byteBuffer, FlatBuffer.a(byteBuffer));
    }

    public static BugReportBuilder newBuilder() {
        return new BugReportBuilder();
    }

    public final Uri m18504a() {
        return this.f10405a;
    }

    public final String m18506b() {
        return this.f10406b;
    }

    public final Uri m18507c() {
        return this.f10407c;
    }

    public final ImmutableList<Uri> m18508d() {
        return this.f10408d;
    }

    public final ImmutableMap<String, String> m18509e() {
        return this.f10409e;
    }

    public final ImmutableMap<String, String> m18510f() {
        return this.f10424t;
    }

    public final String m18511g() {
        return this.f10411g;
    }

    public final String m18512h() {
        return this.f10412h;
    }

    public final String m18513i() {
        return this.f10413i;
    }

    public final String m18514j() {
        return this.f10414j;
    }

    public final String m18515k() {
        return this.f10415k;
    }

    @Nullable
    public final String m18516l() {
        return this.f10416l;
    }

    @Nullable
    public final String m18517m() {
        return this.f10417m;
    }

    public final String m18518n() {
        return this.f10418n;
    }

    public final String m18519o() {
        return this.f10419o;
    }

    public final String m18520p() {
        return this.f10420p;
    }

    public final BugReportSource m18521q() {
        return this.f10421q;
    }

    public final String m18522r() {
        return this.f10422r;
    }

    public final int m18523s() {
        return this.f10423s;
    }

    public final String m18524v() {
        return this.f10427w;
    }

    public final ImmutableMap<String, String> m18525w() {
        return this.f10410f;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f10405a, i);
        parcel.writeString(this.f10406b);
        parcel.writeParcelable(this.f10407c, i);
        parcel.writeString(this.f10411g);
        parcel.writeString(this.f10412h);
        parcel.writeString(this.f10413i);
        parcel.writeString(this.f10414j);
        parcel.writeString(this.f10415k);
        parcel.writeString(this.f10416l);
        parcel.writeString(this.f10417m);
        parcel.writeString(this.f10418n);
        parcel.writeString(this.f10419o);
        parcel.writeString(this.f10420p);
        parcel.writeSerializable(this.f10421q);
        parcel.writeString(this.f10422r);
        parcel.writeString(this.f10427w);
        parcel.writeTypedList(this.f10408d);
        m18502a(parcel, this.f10409e);
        m18502a(parcel, this.f10424t);
        parcel.writeMap(this.f10410f);
        parcel.writeInt(this.f10423s);
        parcel.writeString(this.f10425u);
        parcel.writeString(this.f10426v);
    }

    private static void m18502a(Parcel parcel, ImmutableMap<String, String> immutableMap) {
        if (immutableMap != null) {
            parcel.writeInt(immutableMap.size());
            Iterator it = immutableMap.entrySet().iterator();
            while (it.hasNext()) {
                Entry entry = (Entry) it.next();
                parcel.writeString((String) entry.getKey());
                parcel.writeString((String) entry.getValue());
            }
            return;
        }
        parcel.writeInt(0);
    }

    public final int m18503a(FlatBufferBuilder flatBufferBuilder) {
        return UserReviewsParser.a(this, flatBufferBuilder);
    }

    public final void m18505a(MutableFlatBuffer mutableFlatBuffer, int i) {
        throw new UnsupportedOperationException("initFromMutableFlatBuffer is not supported");
    }
}
