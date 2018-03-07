package com.facebook.common.manifest;

import android.content.Context;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Pattern;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;

@ThreadSafe
/* compiled from: si_cancel_all */
public class AppBuildInfoReader {
    public static AppBuildInfo f2704a;
    public static final Pattern f2705e = Pattern.compile("^[0-9]+L$");
    private final Context f2706b;
    private final String f2707c;
    private final ManifestReader f2708d;

    @Inject
    public AppBuildInfoReader(Context context, ManifestReader manifestReader) {
        this.f2706b = context;
        if (manifestReader == null) {
            throw new NullPointerException();
        }
        this.f2708d = manifestReader;
        this.f2707c = this.f2706b.getPackageName();
    }

    public final AppBuildInfo m3813a() {
        return m3811a(this.f2707c);
    }

    private AppBuildInfo m3811a(String str) {
        Object obj;
        String a = m3812a("com.facebook.versioncontrol.revision", str);
        String a2 = m3812a("com.facebook.versioncontrol.branch", str);
        String a3 = m3812a("com.facebook.build_time", str);
        long j = 0;
        String str2 = "";
        if (a3 == null || !f2705e.matcher(a3).matches()) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            j = Long.parseLong(a3.substring(0, a3.length() - 1));
            DateFormat dateTimeInstance = DateFormat.getDateTimeInstance(1, 0, Locale.US);
            dateTimeInstance.setTimeZone(TimeZone.getTimeZone("PST8PDT"));
            str2 = dateTimeInstance.format(new Date(j));
        }
        return new AppBuildInfo(a, a2, j, str2);
    }

    private String m3812a(String str, String str2) {
        String a = this.f2708d.a(str, str2);
        return a == null ? "" : a;
    }
}
