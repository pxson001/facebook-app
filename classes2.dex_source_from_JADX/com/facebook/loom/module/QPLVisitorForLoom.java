package com.facebook.loom.module;

import android.annotation.SuppressLint;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.util.TriState;
import com.facebook.loom.core.TraceControl;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.quicklog.QuickEvent;
import com.facebook.quicklog.QuickEventListener;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import java.util.ArrayList;
import javax.inject.Inject;

/* compiled from: upsell */
public class QPLVisitorForLoom implements QuickEventListener {
    private final ThreadLocal<StringBuilder> f1581a = new ThreadLocal();
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<AppStateManager> f1582b = UltralightRuntime.f368b;

    public final void mo489a(QuickEvent quickEvent) {
        TraceControl traceControl = TraceControl.b;
        boolean a = traceControl.a(1, 0, quickEvent, 0);
        String c = traceControl.c();
        if (c != "AAAAAAAAAAA") {
            quickEvent.m1004a("loom_id", c);
        }
        long g = m3186g(quickEvent);
        if (!quickEvent.f472n) {
            g |= 281474976710656L;
        }
        if (a) {
            g |= 562949953421312L;
        }
        m3183a(quickEvent, g);
        m3184b(quickEvent, g);
        Logger.a(4, EntryType.QPL_START, quickEvent.f465g, g);
    }

    public final void mo490b(QuickEvent quickEvent) {
        mo489a(quickEvent);
    }

    public final void mo491c(QuickEvent quickEvent) {
        if (quickEvent.f480v && ((AppStateManager) this.f1582b.get()).m2263k() == TriState.YES) {
            mo492d(quickEvent);
            return;
        }
        long f = m3185f(quickEvent);
        if (!quickEvent.f472n) {
            f |= 281474976710656L;
        }
        m3183a(quickEvent, f);
        m3184b(quickEvent, f);
        Logger.a(4, EntryType.QPL_END, quickEvent.f465g, f);
        TraceControl traceControl = TraceControl.b;
        if (traceControl != null) {
            traceControl.a(9, quickEvent, 0);
        }
    }

    public final void mo492d(QuickEvent quickEvent) {
        long g = m3186g(quickEvent);
        if (!quickEvent.f472n) {
            g |= 281474976710656L;
        }
        Logger.a(4, EntryType.QPL_CANCEL, quickEvent.f465g, g);
        TraceControl traceControl = TraceControl.b;
        if (traceControl != null) {
            traceControl.b(9, quickEvent, 0);
        }
    }

    public final void mo493e(QuickEvent quickEvent) {
        Logger.a(4, EntryType.QPL_NOTE, quickEvent.f465g, m3185f(quickEvent));
    }

    private static long m3185f(QuickEvent quickEvent) {
        return m3186g(quickEvent) | ((long) quickEvent.f478t);
    }

    private static long m3186g(QuickEvent quickEvent) {
        return (((long) quickEvent.f460b) << 16) & 281474976645120L;
    }

    @SuppressLint({"BadMethodUse-java.lang.String.length"})
    private void m3183a(QuickEvent quickEvent, long j) {
        int i = 0;
        ArrayList arrayList = quickEvent.f477s;
        if (arrayList != null) {
            StringBuilder stringBuilder;
            StringBuilder stringBuilder2 = (StringBuilder) this.f1581a.get();
            if (stringBuilder2 == null) {
                stringBuilder2 = new StringBuilder();
                this.f1581a.set(stringBuilder2);
                stringBuilder = stringBuilder2;
            } else {
                stringBuilder = stringBuilder2;
            }
            stringBuilder.setLength(0);
            while (i < arrayList.size()) {
                String str = (String) arrayList.get(i);
                if (str == null || stringBuilder.length() + str.length() > 1024) {
                    break;
                }
                if (str.length() > 0) {
                    if (i != 0) {
                        stringBuilder.append(",");
                    }
                    stringBuilder.append(str);
                }
                i++;
            }
            String stringBuilder3 = stringBuilder.toString();
            Logger.a(4, EntryType.QPL_TAG, quickEvent.f465g, j, "tags", stringBuilder3);
        }
    }

    @SuppressLint({"BadMethodUse-java.lang.String.length"})
    private static void m3184b(QuickEvent quickEvent, long j) {
        int i = 0;
        ArrayList arrayList = quickEvent.f476r;
        if (arrayList != null) {
            int i2 = 0;
            while (i < arrayList.size() - 1) {
                String str = (String) arrayList.get(i);
                String str2 = (String) arrayList.get(i + 1);
                if (str != null && str2 != null && (str.length() + str2.length()) + i2 <= 2048) {
                    if (str.length() > 0 && str2.length() > 0 && !str.equals("loom_id")) {
                        int length = i2 + (str.length() + str2.length());
                        Logger.a(4, EntryType.QPL_ANNOTATION, quickEvent.f465g, j, str, str2);
                        i2 = length;
                    }
                    i += 2;
                } else {
                    return;
                }
            }
        }
    }
}
