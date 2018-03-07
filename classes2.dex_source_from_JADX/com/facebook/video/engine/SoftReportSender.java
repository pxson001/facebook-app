package com.facebook.video.engine;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.errorreporting.SoftErrorBuilder;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.MonotonicClock;
import com.facebook.xconfig.core.XConfigReader;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.List;

@VisibleForTesting
/* compiled from: iorg_fb4a_url */
public class SoftReportSender {
    public final DefaultAndroidThreadUtil f19442a;
    public final MonotonicClock f19443b;
    private final AbstractFbErrorReporter f19444c;
    private final int f19445d;
    private final int f19446e;
    private final XConfigReader f19447f;
    private Throwable f19448g;
    private List<String> f19449h = Lists.m1297a(10);
    private int f19450i = 1;
    private String f19451j;
    private String f19452k;
    public boolean f19453l;
    public long f19454m = 0;

    public SoftReportSender(DefaultAndroidThreadUtil defaultAndroidThreadUtil, MonotonicClock monotonicClock, AbstractFbErrorReporter abstractFbErrorReporter, int i, int i2, XConfigReader xConfigReader) {
        this.f19442a = (DefaultAndroidThreadUtil) Preconditions.checkNotNull(defaultAndroidThreadUtil);
        this.f19443b = (MonotonicClock) Preconditions.checkNotNull(monotonicClock);
        this.f19444c = (AbstractFbErrorReporter) Preconditions.checkNotNull(abstractFbErrorReporter);
        this.f19445d = i;
        this.f19446e = i2;
        this.f19447f = xConfigReader;
    }

    public final void m27137a(String str, String str2, String str3, Throwable th) {
        boolean z = true;
        boolean z2 = (this.f19451j == null || this.f19451j.equals(str)) ? false : true;
        if (this.f19452k == null || this.f19452k.equals(str2)) {
            z = false;
        }
        if (z2 || r1) {
            m27136a(false, FlushReason.ID_CHANGED);
        }
        this.f19451j = str;
        this.f19452k = str2;
        if (this.f19448g == null) {
            this.f19448g = th;
        }
        this.f19449h.add(str3);
        m27135a(this);
    }

    private void m27136a(boolean z, FlushReason flushReason) {
        if (!(this.f19444c == null || this.f19449h.isEmpty())) {
            String str;
            StringBuilder stringBuilder = new StringBuilder(200);
            for (String str2 : this.f19449h) {
                if (str2 == null) {
                    str2 = "(null)";
                }
                if (stringBuilder.length() + str2.length() > 920) {
                    break;
                }
                if (stringBuilder.length() > 0) {
                    stringBuilder.append(',');
                }
                stringBuilder.append("'");
                stringBuilder.append(str2);
                stringBuilder.append("'");
            }
            str2 = StringFormatUtil.formatStrLocaleSafe("{'count':%d,'reason':'%s','msgs':[%s]}", Integer.valueOf(this.f19449h.size()), flushReason, stringBuilder.toString());
            String formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe("VideoPlayerError.%s.%d", this.f19452k, Integer.valueOf(this.f19450i));
            int a = this.f19447f.m2683a(ErrorSamplingXConfig.c, 1000);
            SoftErrorBuilder a2 = SoftError.a(formatStrLocaleSafe, str2);
            a2.c = this.f19448g;
            a2 = a2;
            a2.e = a;
            this.f19444c.mo336a(a2.g());
        }
        this.f19449h.clear();
        this.f19448g = null;
        this.f19454m = 0;
        if (z) {
            this.f19450i = Math.min(this.f19450i * this.f19445d, this.f19446e);
        } else {
            this.f19450i = 1;
        }
    }

    public static void m27135a(SoftReportSender softReportSender) {
        if (softReportSender.f19454m != 0 && softReportSender.f19443b.now() > softReportSender.f19454m) {
            softReportSender.m27136a(false, FlushReason.TIMEOUT);
        }
        if (!softReportSender.f19449h.isEmpty()) {
            if (softReportSender.f19451j == null || softReportSender.f19452k == null) {
                softReportSender.m27136a(false, FlushReason.ID_NULL);
            } else if (softReportSender.f19449h.size() >= softReportSender.f19450i) {
                softReportSender.m27136a(true, FlushReason.COUNT);
            }
            if (softReportSender.f19454m == 0) {
                softReportSender.f19454m = softReportSender.f19443b.now() + 5000;
            }
            if (!softReportSender.f19453l) {
                softReportSender.f19442a.m1653a(new 1(softReportSender), Math.max(0, softReportSender.f19454m - softReportSender.f19443b.now()));
                softReportSender.f19453l = true;
            }
        }
    }
}
