package com.facebook.redspace.analytics;

import android.support.annotation.Nullable;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.common.time.Clock;
import com.facebook.common.util.StringUtil;
import com.facebook.redspace.analytics.logger.RedSpaceLogger;
import javax.inject.Inject;

/* compiled from: ProfilePicFromLowRes */
public class RedSpaceGridOpenListener {
    private final RedSpaceLogger f11756a;
    private final Clock f11757b;
    private long f11758c;
    private String f11759d;

    @Inject
    public RedSpaceGridOpenListener(RedSpaceLogger redSpaceLogger, Clock clock) {
        this.f11756a = redSpaceLogger;
        this.f11757b = clock;
    }

    public final void m12195a(boolean z, int i) {
        if (z) {
            m12193a("icon", Integer.valueOf(i));
        }
    }

    public final void m12194a(int i) {
        String str;
        switch (i) {
            case 1:
                str = "friend_view";
                break;
            case 2:
                str = "person_list";
                break;
            default:
                return;
        }
        m12193a(str, null);
    }

    private void m12193a(String str, @Nullable Integer num) {
        long a = this.f11757b.a();
        if (!StringUtil.a(this.f11759d, str) || a - this.f11758c > 500) {
            HoneyClientEventFast a2 = this.f11756a.b.a("open_grid_view", false);
            if (a2.a()) {
                a2.a("redspace");
                a2.a("source", str);
                a2.a("badge_count", num);
                a2.b();
            }
            this.f11758c = a;
            this.f11759d = str;
        }
    }
}
