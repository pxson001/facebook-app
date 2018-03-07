package com.facebook.bugreporter;

import android.net.Uri;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import java.util.List;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: android.remoteinput.resultsData */
public class BugReportBuilder {
    public Uri f10439a;
    public String f10440b;
    public Uri f10441c;
    public List<Uri> f10442d;
    public ImmutableMap<String, String> f10443e;
    public ImmutableMap<String, String> f10444f;
    public ImmutableMap<String, String> f10445g;
    public String f10446h;
    public String f10447i;
    public String f10448j = null;
    public String f10449k;
    public String f10450l;
    public String f10451m;
    public String f10452n;
    public String f10453o;
    public String f10454p;
    public String f10455q;
    public BugReportSource f10456r;
    public String f10457s;
    public int f10458t;
    public String f10459u;
    public String f10460v;
    public String f10461w;

    public final BugReportBuilder m18534a(Uri uri) {
        this.f10439a = uri;
        return this;
    }

    public final BugReportBuilder m18537b(Uri uri) {
        this.f10441c = uri;
        return this;
    }

    public final ImmutableList<Uri> m18540d() {
        return ImmutableList.copyOf(this.f10442d);
    }

    public final BugReportBuilder m18535a(BugReport bugReport) {
        this.f10439a = bugReport.f10405a;
        this.f10440b = bugReport.f10406b;
        this.f10441c = bugReport.f10407c;
        this.f10442d = Lists.a(bugReport.f10408d);
        this.f10443e = bugReport.f10409e;
        this.f10444f = bugReport.f10424t;
        this.f10446h = bugReport.f10411g;
        this.f10447i = bugReport.f10412h;
        this.f10448j = bugReport.f10413i;
        this.f10449k = bugReport.f10414j;
        this.f10450l = bugReport.f10415k;
        this.f10451m = bugReport.f10416l;
        this.f10452n = bugReport.f10417m;
        this.f10453o = bugReport.f10418n;
        this.f10454p = bugReport.f10419o;
        this.f10455q = bugReport.f10420p;
        this.f10456r = bugReport.f10421q;
        this.f10445g = bugReport.f10410f;
        this.f10457s = bugReport.f10422r;
        this.f10458t = bugReport.f10423s;
        this.f10459u = bugReport.f10425u;
        this.f10460v = bugReport.f10426v;
        this.f10461w = bugReport.f10427w;
        return this;
    }

    public final BugReportBuilder m18536a(ImmutableMap<String, String> immutableMap) {
        this.f10443e = immutableMap;
        return this;
    }

    public final BugReportBuilder m18538b(ImmutableMap<String, String> immutableMap) {
        this.f10444f = immutableMap;
        return this;
    }

    public final BugReportBuilder m18539c(String str) {
        this.f10457s = str;
        return this;
    }

    public final BugReportBuilder m18533a(int i) {
        this.f10458t = i;
        return this;
    }

    public final BugReportBuilder m18541n(String str) {
        this.f10461w = str;
        return this;
    }

    public final BugReport m18542x() {
        return new BugReport(this);
    }
}
