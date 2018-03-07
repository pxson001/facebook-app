package com.facebook.feedplugins.feedbackreactions.ui.nux;

import android.view.View;
import com.facebook.feedback.reactions.util.FeedbackReactionsUtils;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.inject.InjectorLike;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: reliabilities_serialization_failed */
public class ReactionsLaunchNuxInterstitialController extends ReactionsNuxInterstitialController {
    private static volatile ReactionsLaunchNuxInterstitialController f3499c;
    private final FeedbackReactionsUtils f3500a;
    private final ReactionsNuxControllerDelegate f3501b;

    public static com.facebook.feedplugins.feedbackreactions.ui.nux.ReactionsLaunchNuxInterstitialController m3781a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f3499c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feedplugins.feedbackreactions.ui.nux.ReactionsLaunchNuxInterstitialController.class;
        monitor-enter(r1);
        r0 = f3499c;	 Catch:{ all -> 0x003a }
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
        r0 = m3782b(r0);	 Catch:{ all -> 0x0035 }
        f3499c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f3499c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedplugins.feedbackreactions.ui.nux.ReactionsLaunchNuxInterstitialController.a(com.facebook.inject.InjectorLike):com.facebook.feedplugins.feedbackreactions.ui.nux.ReactionsLaunchNuxInterstitialController");
    }

    private static ReactionsLaunchNuxInterstitialController m3782b(InjectorLike injectorLike) {
        return new ReactionsLaunchNuxInterstitialController(FeedbackReactionsUtils.a(injectorLike), ReactionsNuxControllerDelegate.m3792a(injectorLike));
    }

    @Inject
    public ReactionsLaunchNuxInterstitialController(FeedbackReactionsUtils feedbackReactionsUtils, ReactionsNuxControllerDelegate reactionsNuxControllerDelegate) {
        this.f3500a = feedbackReactionsUtils;
        this.f3501b = reactionsNuxControllerDelegate;
    }

    public final String m3786b() {
        return "3754";
    }

    public final InterstitialControllerState m3783a(InterstitialTrigger interstitialTrigger) {
        return this.f3501b.m3796a((ReactionsNuxInterstitialController) this);
    }

    public final long hI_() {
        return 86400000;
    }

    public final ImmutableList<InterstitialTrigger> m3787c() {
        return ReactionsNuxControllerDelegate.m3793a();
    }

    protected final boolean mo279a(int i) {
        return i == 0;
    }

    public final void mo278a(View view, GraphQLFeedback graphQLFeedback) {
        if (this.f3500a.f() == 0) {
            this.f3501b.m3797a(view);
        }
    }
}
