package com.facebook.accessibility;

import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import com.facebook.common.android.AccessibilityManagerMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: show_360_photo_view_in_vr */
public class ViewAccessibilityHelper {
    private static volatile ViewAccessibilityHelper f4898b;
    private final AccessibilityManager f4899a;

    public static com.facebook.accessibility.ViewAccessibilityHelper m8774a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f4898b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.accessibility.ViewAccessibilityHelper.class;
        monitor-enter(r1);
        r0 = f4898b;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m8775b(r0);	 Catch:{ all -> 0x0035 }
        f4898b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4898b;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.accessibility.ViewAccessibilityHelper.a(com.facebook.inject.InjectorLike):com.facebook.accessibility.ViewAccessibilityHelper");
    }

    private static ViewAccessibilityHelper m8775b(InjectorLike injectorLike) {
        return new ViewAccessibilityHelper(AccessibilityManagerMethodAutoProvider.m8780b(injectorLike));
    }

    @Inject
    public ViewAccessibilityHelper(AccessibilityManager accessibilityManager) {
        this.f4899a = accessibilityManager;
    }

    public final void m8777a(View view) {
        m8776b(view, null);
    }

    public final void m8779a(View view, CharSequence charSequence) {
        m8776b(view, charSequence);
    }

    public final void m8778a(View view, int i) {
        if (!this.f4899a.isEnabled()) {
            return;
        }
        if (VERSION.SDK_INT >= 16) {
            view.setImportantForAccessibility(i);
            return;
        }
        if (ViewCompat.m10952b(view)) {
            view.setAccessibilityDelegate(null);
            if (view.getTag(2131558568) != null) {
                view.setClickable(((Boolean) view.getTag(2131558568)).booleanValue());
                view.setFocusable(((Boolean) view.getTag(2131558569)).booleanValue());
                view.setLongClickable(((Boolean) view.getTag(2131558570)).booleanValue());
                view.setContentDescription((String) view.getTag(2131558571));
            }
        }
        if (i == 1) {
            view.setFocusable(true);
        } else if (i == 2 || i == 4) {
            view.setAccessibilityDelegate(new 1(this, i, view));
        }
    }

    private void m8776b(View view, @Nullable CharSequence charSequence) {
        if (this.f4899a.isEnabled()) {
            ViewParent parent = view.getParent();
            if (parent != null) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain(16384);
                ViewCompat.m10942a(view, obtain);
                if (charSequence != null) {
                    obtain.getText().add(charSequence);
                    obtain.setContentDescription(null);
                }
                parent.requestSendAccessibilityEvent(view, obtain);
            }
        }
    }
}
