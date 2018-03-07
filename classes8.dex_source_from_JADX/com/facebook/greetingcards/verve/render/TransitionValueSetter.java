package com.facebook.greetingcards.verve.render;

import android.support.v4.util.SparseArrayCompat;
import android.view.View;
import com.facebook.greetingcards.verve.mutablemodel.Transition;
import com.facebook.greetingcards.verve.mutablemodel.Transition.ViewAnim;

/* compiled from: view_state */
public class TransitionValueSetter {
    public SparseArrayCompat<View> f396a = this.f405g;
    public Transition f397b;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m374a(double r9) {
        /*
        r8 = this;
        r0 = r8.f397b;
        r3 = r0.f361a;
        r4 = r3.size();
        r0 = 0;
        r2 = r0;
    L_0x000a:
        if (r2 >= r4) goto L_0x00df;
    L_0x000c:
        r0 = r3.get(r2);
        r0 = (com.facebook.greetingcards.verve.mutablemodel.Transition.ViewAnim) r0;
        r1 = com.facebook.greetingcards.verve.render.TransitionValueSetter.C00441.f395a;
        r5 = r0.f356a;
        r5 = r5.ordinal();
        r1 = r1[r5];
        switch(r1) {
            case 1: goto L_0x0056;
            case 2: goto L_0x009a;
            default: goto L_0x001f;
        };
    L_0x001f:
        r1 = r8.f396a;
        r5 = r0.f357b;
        r5 = r5.f340a;
        r1 = r1.a(r5);
        r1 = (android.view.View) r1;
        m366a(r1, r0, r9);
        m367b(r1, r0, r9);
        m368c(r1, r0, r9);
        m369d(r1, r0, r9);
        m370e(r1, r0, r9);
        m371f(r1, r0, r9);
        m372g(r1, r0, r9);
        m373h(r1, r0, r9);
    L_0x0043:
        r0 = r1;
    L_0x0044:
        r1 = r0 instanceof com.facebook.greetingcards.verve.render.VerveGroupView;
        if (r1 == 0) goto L_0x0052;
    L_0x0048:
        r0 = (com.facebook.greetingcards.verve.render.VerveGroupView) r0;
        r7 = r0.f417a;
        r0 = r7;
        r7 = r0.f401c;
        r7.m374a(r9);
    L_0x0052:
        r0 = r2 + 1;
        r2 = r0;
        goto L_0x000a;
    L_0x0056:
        r1 = r8.f396a;
        r5 = r0.f358c;
        r5 = r5.f340a;
        r1 = r1.a(r5);
        r1 = (android.view.View) r1;
        r5 = r0.f357b;
        r5 = r5.rotation;
        if (r5 == 0) goto L_0x006b;
    L_0x0068:
        m366a(r1, r0, r9);
    L_0x006b:
        r5 = r0.f357b;
        r5 = r5.opacity;
        if (r5 == 0) goto L_0x0074;
    L_0x0071:
        m367b(r1, r0, r9);
    L_0x0074:
        r5 = r0.f357b;
        r5 = r5.position;
        if (r5 == 0) goto L_0x0080;
    L_0x007a:
        m368c(r1, r0, r9);
        m369d(r1, r0, r9);
    L_0x0080:
        r5 = r0.f357b;
        r5 = r5.anchor;
        if (r5 == 0) goto L_0x008c;
    L_0x0086:
        m370e(r1, r0, r9);
        m371f(r1, r0, r9);
    L_0x008c:
        r5 = r0.f357b;
        r5 = r5.size;
        if (r5 == 0) goto L_0x0043;
    L_0x0092:
        m372g(r1, r0, r9);
        m373h(r1, r0, r9);
        r0 = r1;
        goto L_0x0044;
    L_0x009a:
        r1 = r8.f396a;
        r5 = r0.f357b;
        r5 = r5.f340a;
        r1 = r1.a(r5);
        r1 = (android.view.View) r1;
        r5 = r0.f358c;
        r5 = r5.rotation;
        if (r5 == 0) goto L_0x00af;
    L_0x00ac:
        m366a(r1, r0, r9);
    L_0x00af:
        r5 = r0.f358c;
        r5 = r5.opacity;
        if (r5 == 0) goto L_0x00b8;
    L_0x00b5:
        m367b(r1, r0, r9);
    L_0x00b8:
        r5 = r0.f358c;
        r5 = r5.position;
        if (r5 == 0) goto L_0x00c4;
    L_0x00be:
        m368c(r1, r0, r9);
        m369d(r1, r0, r9);
    L_0x00c4:
        r5 = r0.f358c;
        r5 = r5.anchor;
        if (r5 == 0) goto L_0x00d0;
    L_0x00ca:
        m370e(r1, r0, r9);
        m371f(r1, r0, r9);
    L_0x00d0:
        r5 = r0.f358c;
        r5 = r5.size;
        if (r5 == 0) goto L_0x0043;
    L_0x00d6:
        m372g(r1, r0, r9);
        m373h(r1, r0, r9);
        r0 = r1;
        goto L_0x0044;
    L_0x00df:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.greetingcards.verve.render.TransitionValueSetter.a(double):void");
    }

    private static void m366a(View view, ViewAnim viewAnim, double d) {
        view.setRotation(m365a(d, viewAnim.f357b.m294a(), viewAnim.f358c.m294a()));
    }

    private static void m367b(View view, ViewAnim viewAnim, double d) {
        view.setAlpha(m365a(d, viewAnim.f357b.m295b(), viewAnim.f358c.m295b()));
    }

    private static void m368c(View view, ViewAnim viewAnim, double d) {
        view.setX(m365a(d, viewAnim.f357b.m303j(), viewAnim.f358c.m303j()));
    }

    private static void m369d(View view, ViewAnim viewAnim, double d) {
        view.setY(m365a(d, viewAnim.f357b.m304k(), viewAnim.f358c.m304k()));
    }

    private static void m370e(View view, ViewAnim viewAnim, double d) {
        view.setPivotX(m365a(d, viewAnim.f357b.m305l(), viewAnim.f358c.m305l()));
    }

    private static void m371f(View view, ViewAnim viewAnim, double d) {
        view.setPivotY(m365a(d, viewAnim.f357b.m306m(), viewAnim.f358c.m306m()));
    }

    private static void m372g(View view, ViewAnim viewAnim, double d) {
        ViewPropertiesUtil.m412a(view, m365a(d, viewAnim.f357b.m301h(), viewAnim.f358c.m301h()));
    }

    private static void m373h(View view, ViewAnim viewAnim, double d) {
        ViewPropertiesUtil.m414b(view, m365a(d, viewAnim.f357b.m302i(), viewAnim.f358c.m302i()));
    }

    private static float m365a(double d, float f, float f2) {
        return (float) ((((double) (f2 - f)) * d) + ((double) f));
    }
}
