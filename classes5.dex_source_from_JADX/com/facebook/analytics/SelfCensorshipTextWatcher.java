package com.facebook.analytics;

import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import javax.inject.Inject;

/* compiled from: timeline_pymk */
public class SelfCensorshipTextWatcher implements TextWatcher {
    private AnalyticsLogger f1876a;
    public SelfCensorshipTextWatcherEventBuilder f1877b;
    public int f1878c = 0;
    public Handler f1879d = new Handler();
    public Runnable f1880e;
    public boolean f1881f;

    /* compiled from: timeline_pymk */
    class C01281 implements Runnable {
        final /* synthetic */ SelfCensorshipTextWatcher f1875a;

        C01281(SelfCensorshipTextWatcher selfCensorshipTextWatcher) {
            this.f1875a = selfCensorshipTextWatcher;
        }

        public void run() {
            SelfCensorshipTextWatcher selfCensorshipTextWatcher = this.f1875a;
            selfCensorshipTextWatcher.f1878c++;
            selfCensorshipTextWatcher.f1881f = false;
            if (selfCensorshipTextWatcher.f1880e != null) {
                HandlerDetour.a(selfCensorshipTextWatcher.f1879d, selfCensorshipTextWatcher.f1880e);
                selfCensorshipTextWatcher.f1880e = null;
            }
            selfCensorshipTextWatcher.f1877b.f1851d = 0;
        }
    }

    @Inject
    public SelfCensorshipTextWatcher(AnalyticsLogger analyticsLogger, SelfCensorshipTextWatcherEventBuilder selfCensorshipTextWatcherEventBuilder) {
        this.f1876a = analyticsLogger;
        this.f1877b = selfCensorshipTextWatcherEventBuilder;
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (!this.f1881f && i3 >= i2) {
            Object obj = null;
            int i4 = 0;
            for (int i5 = 0; i5 < charSequence.length(); i5++) {
                if (charSequence.charAt(i5) != ' ') {
                    i4++;
                }
                if (i4 >= 5) {
                    obj = 1;
                    break;
                }
            }
            if (obj != null) {
                HoneyClientEvent a = this.f1877b.mo482a();
                if (a != null) {
                    this.f1876a.c(a);
                    this.f1881f = true;
                    m2562c();
                }
            }
        }
    }

    public void afterTextChanged(Editable editable) {
    }

    private void m2562c() {
        this.f1880e = new C01281(this);
        HandlerDetour.b(this.f1879d, this.f1880e, 600000, 1005915613);
    }
}
