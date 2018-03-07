package com.facebook.feedplugins.feedbackreactions.ui.nux;

import android.view.View;
import com.facebook.feedback.reactions.abtest.ExperimentsForReactionsTestModule;
import com.facebook.feedback.reactions.abtest.ReactionsExperimentUtil;
import com.facebook.feedback.reactions.util.FeedbackReactionsUtils;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.inject.InjectorLike;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.qe.api.ExposureLogging;
import com.facebook.qe.api.Liveness;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: Story clear not supported yet */
public class ReactionsRetargetNuxInterstitialController extends ReactionsNuxInterstitialController {
    private static volatile ReactionsRetargetNuxInterstitialController f23132d;
    private final FeedbackReactionsUtils f23133a;
    private final ReactionsExperimentUtil f23134b;
    private final ReactionsNuxControllerDelegate f23135c;

    public static com.facebook.feedplugins.feedbackreactions.ui.nux.ReactionsRetargetNuxInterstitialController m25555a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f23132d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feedplugins.feedbackreactions.ui.nux.ReactionsRetargetNuxInterstitialController.class;
        monitor-enter(r1);
        r0 = f23132d;	 Catch:{ all -> 0x003a }
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
        r0 = m25556b(r0);	 Catch:{ all -> 0x0035 }
        f23132d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f23132d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedplugins.feedbackreactions.ui.nux.ReactionsRetargetNuxInterstitialController.a(com.facebook.inject.InjectorLike):com.facebook.feedplugins.feedbackreactions.ui.nux.ReactionsRetargetNuxInterstitialController");
    }

    private static ReactionsRetargetNuxInterstitialController m25556b(InjectorLike injectorLike) {
        return new ReactionsRetargetNuxInterstitialController(FeedbackReactionsUtils.a(injectorLike), ReactionsExperimentUtil.a(injectorLike), ReactionsNuxControllerDelegate.a(injectorLike));
    }

    @Inject
    public ReactionsRetargetNuxInterstitialController(FeedbackReactionsUtils feedbackReactionsUtils, ReactionsExperimentUtil reactionsExperimentUtil, ReactionsNuxControllerDelegate reactionsNuxControllerDelegate) {
        this.f23133a = feedbackReactionsUtils;
        this.f23134b = reactionsExperimentUtil;
        this.f23135c = reactionsNuxControllerDelegate;
    }

    public final String m25560b() {
        return "4131";
    }

    public final long hI_() {
        return 86400000;
    }

    public final InterstitialControllerState m25557a(InterstitialTrigger interstitialTrigger) {
        return this.f23135c.a(this);
    }

    public final ImmutableList<InterstitialTrigger> m25561c() {
        return ReactionsNuxControllerDelegate.a();
    }

    protected final boolean m25559a(int i) {
        return i == 1 || i == 2;
    }

    public final void m25558a(View view, GraphQLFeedback graphQLFeedback) {
        int f = this.f23133a.f();
        if (f == 1) {
            this.f23135c.a(view);
        } else if (f == 2) {
            this.f23135c.a(view, graphQLFeedback);
        }
        if (this.f23134b.b.a(Liveness.Live, ExposureLogging.Off, ExperimentsForReactionsTestModule.g, false)) {
            ReactionsNuxControllerDelegate reactionsNuxControllerDelegate = this.f23135c;
            reactionsNuxControllerDelegate.c = new ReactionsLongTapGestureNuxPopover(view.getContext());
            ReactionsLongTapGestureNuxPopover reactionsLongTapGestureNuxPopover = reactionsNuxControllerDelegate.c;
            ReactionsLongTapGestureNuxPopover.m25551b(reactionsLongTapGestureNuxPopover);
            reactionsLongTapGestureNuxPopover.f(view);
            reactionsLongTapGestureNuxPopover.f23130o.start();
        }
    }
}
