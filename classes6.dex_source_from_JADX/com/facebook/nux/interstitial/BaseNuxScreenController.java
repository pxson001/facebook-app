package com.facebook.nux.interstitial;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.view.ViewGroup;
import com.facebook.nux.NuxFlowController;
import com.facebook.nux.NuxScreen;

/* compiled from: isPermanentlyClosed */
public class BaseNuxScreenController {
    private NuxScreen f12250a;
    public NuxFlowController f12251b;
    public ViewGroup f12252c;
    private Intent f12253d;
    private FragmentManager f12254e;

    public void m19147a(NuxScreen nuxScreen, NuxFlowController nuxFlowController, ViewGroup viewGroup, Intent intent, FragmentManager fragmentManager) {
        this.f12250a = nuxScreen;
        this.f12251b = nuxFlowController;
        this.f12252c = viewGroup;
        this.f12253d = intent;
        this.f12254e = fragmentManager;
    }

    public void m19146a() {
        this.f12251b.m19132c();
    }

    public void m19148b() {
        this.f12251b.m19130a();
    }

    public void m19149c() {
        this.f12251b.m19134e();
    }
}
