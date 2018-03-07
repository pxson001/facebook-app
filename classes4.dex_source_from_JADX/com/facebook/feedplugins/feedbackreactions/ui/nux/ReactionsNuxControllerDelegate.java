package com.facebook.feedplugins.feedbackreactions.ui.nux;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.feedback.reactions.ui.ReactionsNuxTokensDrawable;
import com.facebook.feedback.reactions.util.FeedbackReactionsUtils;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: release_number DESC */
public final class ReactionsNuxControllerDelegate {
    private static volatile ReactionsNuxControllerDelegate f3502d;
    private final FeedbackReactionsUtils f3503a;
    private final Provider<ReactionsNuxTokensDrawable> f3504b;
    public ReactionsLongTapGestureNuxPopover f3505c;

    public static com.facebook.feedplugins.feedbackreactions.ui.nux.ReactionsNuxControllerDelegate m3792a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f3502d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feedplugins.feedbackreactions.ui.nux.ReactionsNuxControllerDelegate.class;
        monitor-enter(r1);
        r0 = f3502d;	 Catch:{ all -> 0x003a }
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
        r0 = m3795b(r0);	 Catch:{ all -> 0x0035 }
        f3502d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f3502d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedplugins.feedbackreactions.ui.nux.ReactionsNuxControllerDelegate.a(com.facebook.inject.InjectorLike):com.facebook.feedplugins.feedbackreactions.ui.nux.ReactionsNuxControllerDelegate");
    }

    private static ReactionsNuxControllerDelegate m3795b(InjectorLike injectorLike) {
        return new ReactionsNuxControllerDelegate(FeedbackReactionsUtils.a(injectorLike), IdBasedProvider.a(injectorLike, 6101));
    }

    @Inject
    public ReactionsNuxControllerDelegate(FeedbackReactionsUtils feedbackReactionsUtils, Provider<ReactionsNuxTokensDrawable> provider) {
        this.f3503a = feedbackReactionsUtils;
        this.f3504b = provider;
    }

    public static ImmutableList<InterstitialTrigger> m3793a() {
        return ImmutableList.of(new InterstitialTrigger(Action.UFI_CLICKED));
    }

    public final InterstitialControllerState m3796a(ReactionsNuxInterstitialController reactionsNuxInterstitialController) {
        if (reactionsNuxInterstitialController.mo279a(this.f3503a.f())) {
            return this.f3503a.a() ? InterstitialControllerState.INELIGIBLE : InterstitialControllerState.ELIGIBLE;
        } else {
            return InterstitialControllerState.INELIGIBLE;
        }
    }

    public final void m3797a(View view) {
        Tooltip tooltip = new Tooltip(view.getContext(), 2);
        m3794a(tooltip);
        tooltip.mo538a(view);
    }

    public final void m3798a(View view, GraphQLFeedback graphQLFeedback) {
        Tooltip toolTipWithCompoundDrawable = new ToolTipWithCompoundDrawable(view.getContext(), 1);
        m3794a(toolTipWithCompoundDrawable);
        toolTipWithCompoundDrawable.m6256a((CharSequence) " ");
        ReactionsNuxTokensDrawable reactionsNuxTokensDrawable = (ReactionsNuxTokensDrawable) this.f3504b.get();
        reactionsNuxTokensDrawable.a(graphQLFeedback);
        ((TextView) toolTipWithCompoundDrawable.f5798g.findViewById(2131561858)).setCompoundDrawablesRelativeWithIntrinsicBounds(reactionsNuxTokensDrawable, null, null, null);
        toolTipWithCompoundDrawable.mo538a(view);
    }

    private void m3794a(Tooltip tooltip) {
        Context context = tooltip.getContext();
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(2131431936);
        tooltip.m6276a(dimensionPixelSize, 0, dimensionPixelSize, 0);
        tooltip.f5777t = -1;
        tooltip.m6256a(context.getResources().getString(2131235949));
        tooltip.m6259b(context.getResources().getString(2131235951));
        tooltip.m6286b(0.2f);
        tooltip.f5789H = new 1(this);
    }
}
