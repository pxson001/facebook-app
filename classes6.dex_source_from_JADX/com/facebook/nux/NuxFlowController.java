package com.facebook.nux;

import com.facebook.debug.log.BLog;
import com.facebook.nux.BaseNuxFlowActivity.C07921;

/* compiled from: isSICheckInMqttFailed */
public class NuxFlowController {
    public final NuxFlow f12212a;
    private final C07921 f12213b;
    public int f12214c = 0;

    public NuxFlowController(NuxFlow nuxFlow, C07921 c07921) {
        this.f12212a = nuxFlow;
        this.f12213b = c07921;
    }

    public final void m19130a() {
        NuxScreen nuxScreen = (NuxScreen) this.f12212a.f12209c.get(this.f12214c);
        this.f12214c++;
        if (this.f12214c >= this.f12212a.f12209c.size()) {
            this.f12213b.m19115a();
            return;
        }
        NuxScreen nuxScreen2 = (NuxScreen) this.f12212a.f12209c.get(this.f12214c);
        BaseNuxFlowActivity baseNuxFlowActivity = this.f12213b.f12196a;
        int i = baseNuxFlowActivity.f12203u.k;
        if (i < baseNuxFlowActivity.f12202t.m19118b() - 1) {
            baseNuxFlowActivity.f12203u.a(i + 1, true);
        } else {
            BLog.a(BaseNuxFlowActivity.f12198p, "Cannot go to next fragment");
        }
    }

    public final void m19131b() {
        this.f12213b.m19115a();
    }

    public final void m19132c() {
        m19129a(false);
    }

    public final void m19133d() {
        this.f12213b.m19116b();
    }

    public final void m19134e() {
        m19129a(true);
    }

    private void m19129a(boolean z) {
        NuxScreen nuxScreen = (NuxScreen) this.f12212a.f12209c.get(this.f12214c);
        this.f12214c--;
        if (this.f12214c < 0) {
            this.f12213b.m19116b();
            return;
        }
        NuxScreen nuxScreen2 = (NuxScreen) this.f12212a.f12209c.get(this.f12214c);
        BaseNuxFlowActivity baseNuxFlowActivity = this.f12213b.f12196a;
        int i = baseNuxFlowActivity.f12203u.k;
        if (i > 0) {
            baseNuxFlowActivity.f12203u.a(i - 1, true);
        } else {
            BLog.a(BaseNuxFlowActivity.f12198p, "Cannot go back to previous fragment");
        }
    }
}
