package com.facebook.feedback.ui;

import android.view.View;
import com.facebook.fbui.popover.PopoverWindow.Position;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.feedback.abtest.ExperimentsForFeedbackTestModule;
import com.facebook.feedback.ui.VideoCommentInterstitialController.C04701;
import com.facebook.feedback.ui.VideoCommentInterstitialController.C04712;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.inject.InjectorLike;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;

/* compiled from: seenState */
public class CommentComposerNuxHelper {
    public static final InterstitialTrigger f4192a = new InterstitialTrigger(Action.FEEDBACK_COMPOSER_INIT);
    private final InterstitialManager f4193b;
    private final QeAccessor f4194c;

    public static CommentComposerNuxHelper m4819a(InjectorLike injectorLike) {
        return new CommentComposerNuxHelper(InterstitialManager.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public CommentComposerNuxHelper(InterstitialManager interstitialManager, QeAccessor qeAccessor) {
        this.f4193b = interstitialManager;
        this.f4194c = qeAccessor;
    }

    public final boolean m4821a() {
        VideoCommentInterstitialController videoCommentInterstitialController = (VideoCommentInterstitialController) this.f4193b.a(f4192a, VideoCommentInterstitialController.class);
        if (videoCommentInterstitialController == null) {
            return false;
        }
        this.f4193b.a().a(videoCommentInterstitialController.m5331b());
        if (videoCommentInterstitialController.f4801f == null || videoCommentInterstitialController.f4800e == null) {
            videoCommentInterstitialController.f4801f = new Tooltip(videoCommentInterstitialController.f4797b, 2);
            videoCommentInterstitialController.f4801f.t = -1;
            videoCommentInterstitialController.f4801f.a(new C04701(videoCommentInterstitialController));
            videoCommentInterstitialController.f4801f.a(Position.ABOVE);
            videoCommentInterstitialController.f4801f.b(videoCommentInterstitialController.f4797b.getString(2131233354));
            videoCommentInterstitialController.f4800e = new C04712(videoCommentInterstitialController);
        }
        videoCommentInterstitialController.f4798c.a();
        videoCommentInterstitialController.f4801f.f(videoCommentInterstitialController.f4803h);
        return true;
    }

    public final void m4820a(GraphQLFeedback graphQLFeedback, View view) {
        boolean z = false;
        VideoCommentInterstitialController videoCommentInterstitialController = (VideoCommentInterstitialController) this.f4193b.a("4181");
        if (CommentComposerHelper.m4817d(graphQLFeedback) && this.f4194c.a(ExperimentsForFeedbackTestModule.ae, false)) {
            z = true;
        }
        videoCommentInterstitialController.f4802g = z;
        videoCommentInterstitialController.f4803h = view;
    }
}
