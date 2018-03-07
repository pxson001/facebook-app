package com.facebook.instantshopping;

import android.content.Context;
import com.facebook.inject.InjectorLike;
import com.facebook.instantshopping.abtest.ExperimentsForInstantShoppingAbtestModule;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.rapidfeedback.RapidFeedbackController;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: SmsTakeoverRecentReadOnlyThreadViewBannerEligibleFilterPredicate */
public class InstantShoppingSurveyController {
    private static volatile InstantShoppingSurveyController f23465f;
    public final RapidFeedbackController f23466a;
    public final QeAccessor f23467b;
    public boolean f23468c = false;
    public boolean f23469d = false;
    public boolean f23470e = false;

    public static com.facebook.instantshopping.InstantShoppingSurveyController m24787a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f23465f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.instantshopping.InstantShoppingSurveyController.class;
        monitor-enter(r1);
        r0 = f23465f;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m24788b(r0);	 Catch:{ all -> 0x0035 }
        f23465f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f23465f;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.instantshopping.InstantShoppingSurveyController.a(com.facebook.inject.InjectorLike):com.facebook.instantshopping.InstantShoppingSurveyController");
    }

    private static InstantShoppingSurveyController m24788b(InjectorLike injectorLike) {
        return new InstantShoppingSurveyController((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), RapidFeedbackController.b(injectorLike));
    }

    @Inject
    public InstantShoppingSurveyController(QeAccessor qeAccessor, RapidFeedbackController rapidFeedbackController) {
        this.f23467b = qeAccessor;
        this.f23466a = rapidFeedbackController;
    }

    public final void m24789a(String str, String str2, Context context) {
        String a;
        if (str == null || str2 != null) {
            if (str2 != null) {
                if (this.f23469d && !this.f23470e) {
                    a = this.f23467b.a(ExperimentsForInstantShoppingAbtestModule.j, null);
                    if (!(a == null || a.equals("0"))) {
                        this.f23466a.a(a, context);
                    }
                }
            }
        } else if (this.f23468c && !this.f23469d) {
            a = this.f23467b.a(ExperimentsForInstantShoppingAbtestModule.k, null);
            if (a != null && !a.equals("0")) {
                this.f23466a.a(a, context);
            }
        }
    }
}
