package com.facebook.base.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.facebook.base.fragment.NavigableFragment.Listener;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.util.ExceptionUtil;
import com.facebook.debug.log.BLog;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;

/* compiled from: suggest_icon_1 */
public class AbstractNavigableFragment extends FbFragment implements NavigableFragment {
    private static final Class<?> f2429b = AbstractNavigableFragment.class;
    protected Listener f2430a;
    public Intent f2431c;
    private Intent f2432d;
    private String f2433e;
    private AbstractFbErrorReporter f2434f;
    public boolean f2435g = false;

    public void m3528c(Bundle bundle) {
        super.c(bundle);
        this.f2433e = ExceptionUtil.a(new Throwable());
        this.f2434f = (AbstractFbErrorReporter) FbErrorReporterImpl.a(an());
    }

    public final void m3525G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -435070811);
        super.G();
        if (this.f2432d != null) {
            m3524c(this.f2432d);
            this.f2432d = null;
        }
        if (!this.f2435g) {
            q_();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1636888093, a);
    }

    protected void q_() {
    }

    public void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1738238018);
        super.mY_();
        this.f2435g = false;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1407653586, a);
    }

    private void m3524c(Intent intent) {
        this.f2432d = null;
        String str;
        if (this.f2435g) {
            str = getClass().getName() + ": Fragment already finished";
            if (this.f2431c != null) {
                str = str + " with saved intent: " + this.f2431c;
            }
            BLog.b(f2429b, str);
            this.f2434f.a("FRAGMENT_NAVIGATION", str);
            return;
        }
        if (this.f2430a == null) {
            str = getClass().getName() + ": No navigation listener set; saving intent.  Created at:\n" + this.f2433e;
            BLog.b(f2429b, str, new Throwable());
            this.f2434f.a("FRAGMENT_NAVIGATION", str);
            this.f2431c = intent;
        } else {
            this.f2430a.mo564a(this, intent);
        }
        this.f2435g = true;
    }

    public final void mo563a(final Listener listener) {
        this.f2430a = listener;
        if (listener != null && this.f2431c != null) {
            String str = getClass().getName() + ": Saved intent found: " + this.f2431c;
            BLog.b(f2429b, str, new Throwable());
            this.f2434f.a("FRAGMENT_NAVIGATION", str);
            HandlerDetour.a(new Handler(), new Runnable(this) {
                final /* synthetic */ AbstractNavigableFragment f2428b;

                public void run() {
                    listener.mo564a(this.f2428b, this.f2428b.f2431c);
                    this.f2428b.f2431c = null;
                }
            }, -1035879536);
        }
    }

    public final void m3527b(Intent intent) {
        if (this.y) {
            m3524c(intent);
        } else {
            this.f2432d = intent;
        }
    }
}
