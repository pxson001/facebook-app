package com.facebook.messaging.quickcam;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.messaging.keyboard.AbstractComposerKeyboard;
import com.facebook.messaging.model.threadkey.ThreadKey;
import java.util.Map;

/* compiled from: deltaPaymentMethodUpdated */
public class QuickCamKeyboard extends AbstractComposerKeyboard<QuickCamKeyboardView> {
    private final Context f16501a;

    public QuickCamKeyboard(Context context) {
        this.f16501a = context;
    }

    public final void m16536a(ThreadKey threadKey) {
        ((QuickCamKeyboardView) this.a).as = threadKey;
    }

    public final void m16537a(Map<String, Integer> map) {
        ((QuickCamKeyboardView) this.a).m16610a((Map) map);
    }

    public final void m16539c() {
        ((QuickCamKeyboardView) this.a).m16613f();
    }

    public final void m16540d() {
        ((QuickCamKeyboardView) this.a).m16614g();
    }

    public final void m16541f() {
        ((QuickCamKeyboardView) this.a).m16613f();
    }

    public final void m16542g() {
        ((QuickCamKeyboardView) this.a).f16580q.m6382b();
        ((QuickCamKeyboardView) this.a).aE = false;
    }

    public final void m16543h() {
        QuickCamKeyboardView quickCamKeyboardView = (QuickCamKeyboardView) this.a;
        quickCamKeyboardView.f16580q.m6381a(quickCamKeyboardView.f16583t.f6116a);
        ((QuickCamKeyboardView) this.a).aE = true;
    }

    public final boolean m16544j() {
        return ((QuickCamKeyboardView) this.a).m16615h();
    }

    protected final View m16538b(ViewGroup viewGroup) {
        return new QuickCamKeyboardView(this.f16501a);
    }

    public final int m16545k() {
        return 48;
    }
}
