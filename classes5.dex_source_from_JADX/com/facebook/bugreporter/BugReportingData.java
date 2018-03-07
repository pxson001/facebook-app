package com.facebook.bugreporter;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import java.io.File;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: android.media.metadata.NUM_TRACKS */
public class BugReportingData {
    private static BugReportingData f10631a;
    public File f10632b;
    public List<Bitmap> f10633c;
    @Nullable
    public Bundle f10634d;
    @Nullable
    public Context f10635e;
    public ImmutableMap<String, String> f10636f;
    public ImmutableSet<BugReportExtraFileMapProvider> f10637g;
    public BugReportSource f10638h;
    public File f10639i;

    protected BugReportingData() {
    }

    public static BugReportingData m18659a() {
        if (f10631a == null) {
            f10631a = new BugReportingData();
        }
        return f10631a;
    }

    public final File m18660b() {
        return this.f10632b;
    }

    public final ImmutableSet<BugReportExtraFileMapProvider> m18661g() {
        return this.f10637g;
    }

    public final File m18662i() {
        return this.f10639i;
    }
}
