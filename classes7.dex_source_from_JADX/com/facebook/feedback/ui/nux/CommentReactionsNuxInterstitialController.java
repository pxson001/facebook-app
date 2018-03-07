package com.facebook.feedback.ui.nux;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.feedback.reactions.abtest.ExperimentsForReactionsTestModule;
import com.facebook.feedback.reactions.ui.ReactionsNuxTokensDrawable;
import com.facebook.feedback.reactions.util.FeedbackReactionsUtils;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.interstitial.manager.BaseInterstitialController;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.qe.api.ExposureLogging;
import com.facebook.qe.api.Liveness;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: ridge_session_view */
public class CommentReactionsNuxInterstitialController extends BaseInterstitialController {
    private static volatile CommentReactionsNuxInterstitialController f4827c;
    private final FeedbackReactionsUtils f4828a;
    private final Provider<ReactionsNuxTokensDrawable> f4829b;

    /* compiled from: ridge_session_view */
    class ToolTipWithCompoundDrawable extends Tooltip {
        public ToolTipWithCompoundDrawable(Context context, int i) {
            super(context, i);
        }
    }

    public static com.facebook.feedback.ui.nux.CommentReactionsNuxInterstitialController m5366a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4827c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feedback.ui.nux.CommentReactionsNuxInterstitialController.class;
        monitor-enter(r1);
        r0 = f4827c;	 Catch:{ all -> 0x003a }
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
        r0 = m5368b(r0);	 Catch:{ all -> 0x0035 }
        f4827c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4827c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedback.ui.nux.CommentReactionsNuxInterstitialController.a(com.facebook.inject.InjectorLike):com.facebook.feedback.ui.nux.CommentReactionsNuxInterstitialController");
    }

    private static CommentReactionsNuxInterstitialController m5368b(InjectorLike injectorLike) {
        return new CommentReactionsNuxInterstitialController(FeedbackReactionsUtils.a(injectorLike), IdBasedProvider.a(injectorLike, 6101));
    }

    @Inject
    public CommentReactionsNuxInterstitialController(FeedbackReactionsUtils feedbackReactionsUtils, Provider<ReactionsNuxTokensDrawable> provider) {
        this.f4828a = feedbackReactionsUtils;
        this.f4829b = provider;
    }

    public final String m5372b() {
        return "4239";
    }

    public final InterstitialControllerState m5370a(InterstitialTrigger interstitialTrigger) {
        return this.f4828a.c() ? InterstitialControllerState.INELIGIBLE : InterstitialControllerState.ELIGIBLE;
    }

    public final ImmutableList<InterstitialTrigger> m5373c() {
        return ImmutableList.of(new InterstitialTrigger(Action.COMMENT_UFI_LIKE_CLICKED));
    }

    public final long hI_() {
        return 86400000;
    }

    public final void m5371a(View view, GraphQLFeedback graphQLFeedback) {
        int i;
        String a = this.f4828a.b.b.a(Liveness.Live, ExposureLogging.Off, ExperimentsForReactionsTestModule.c, "OLD_TOOLTIP_TEXT");
        if ("OLD_TOOLTIP_TEXT".equalsIgnoreCase(a)) {
            i = 0;
        } else if ("TOOLTIP_ICONS_TEXT".equalsIgnoreCase(a)) {
            i = 2;
        } else {
            i = 3;
        }
        int i2 = i;
        if (i2 == 0) {
            Tooltip tooltip = new Tooltip(view.getContext(), 2);
            m5367a(tooltip);
            tooltip.a(view);
        } else if (i2 == 2) {
            m5369b(view, graphQLFeedback);
        }
    }

    private void m5369b(View view, GraphQLFeedback graphQLFeedback) {
        Tooltip toolTipWithCompoundDrawable = new ToolTipWithCompoundDrawable(view.getContext(), 1);
        m5367a(toolTipWithCompoundDrawable);
        toolTipWithCompoundDrawable.a(" ");
        ReactionsNuxTokensDrawable reactionsNuxTokensDrawable = (ReactionsNuxTokensDrawable) this.f4829b.get();
        reactionsNuxTokensDrawable.m4526a(graphQLFeedback);
        ((TextView) toolTipWithCompoundDrawable.g.findViewById(2131561858)).setCompoundDrawablesRelativeWithIntrinsicBounds(reactionsNuxTokensDrawable, null, null, null);
        toolTipWithCompoundDrawable.a(view);
    }

    public static void m5367a(Tooltip tooltip) {
        Context context = tooltip.getContext();
        tooltip.t = -1;
        tooltip.a(context.getResources().getString(2131235950));
        tooltip.b(context.getResources().getString(2131235951));
        tooltip.b(0.2f);
    }
}
