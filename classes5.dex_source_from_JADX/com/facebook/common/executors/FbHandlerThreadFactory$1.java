package com.facebook.common.executors;

import android.os.Looper;
import android.util.Log;
import android.util.Printer;
import com.facebook.common.executors.BackgroundWorkLogger.StatsCollector;
import com.facebook.debug.log.BLog;
import java.util.regex.Matcher;

/* compiled from: standalone_url */
class FbHandlerThreadFactory$1 implements Printer {
    final /* synthetic */ Looper f2557a;
    final /* synthetic */ String f2558b;
    final /* synthetic */ FbHandlerThreadFactory f2559c;
    private StatsCollector f2560d;

    FbHandlerThreadFactory$1(FbHandlerThreadFactory fbHandlerThreadFactory, Looper looper, String str) {
        this.f2559c = fbHandlerThreadFactory;
        this.f2557a = looper;
        this.f2558b = str;
    }

    public void println(String str) {
        if (this.f2559c.c.a()) {
            String group;
            Matcher matcher = FbHandlerThreadFactory.b.matcher(str);
            if (matcher.matches()) {
                String group2 = matcher.group(1);
                group = matcher.group(2);
                String group3 = matcher.group(3);
                int parseInt = Integer.parseInt(matcher.group(4));
                if (group == null) {
                    group = group2;
                }
                group = group + "/" + group3 + "/" + parseInt;
            } else {
                group = null;
            }
            String str2 = group;
            if (str2 != null) {
                this.f2560d = this.f2559c.c.a("HandlerThread", this.f2558b + "/" + str2);
                this.f2560d.a();
                return;
            } else if (this.f2560d != null) {
                this.f2560d.a(true);
                this.f2560d = null;
                return;
            } else if (BLog.b(6)) {
                Log.e(FbHandlerThreadFactory.a.getSimpleName(), "Expecting start log. Str: " + str);
                return;
            } else {
                return;
            }
        }
        FbHandlerThreadFactory fbHandlerThreadFactory = this.f2559c;
        FbHandlerThreadFactory.a(this.f2557a);
    }
}
