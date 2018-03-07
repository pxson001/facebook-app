package com.facebook.feedplugins.feedbackreactions.ui;

import android.view.View;
import com.facebook.feed.rows.core.FeedListName;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.feedback.reactions.abtest.ReactionsExperimentUtil;
import com.facebook.feedback.reactions.data.FeedbackReaction;
import com.facebook.feedback.reactions.ui.FeedbackFooterMode;
import com.facebook.feedback.reactions.ui.FeedbackReactionsController;
import com.facebook.feedback.reactions.ui.ReactionMutateListener;
import com.facebook.feedback.reactions.ui.logging.ReactionsFooterInteractionLogger;
import com.facebook.feedback.reactions.ui.logging.ReactionsNuxLogger;
import com.facebook.feedback.reactions.ui.logging.ReactionsNuxLogger.ClickTarget;
import com.facebook.feedback.reactions.ui.overlay.ReactionsDockOverlay;
import com.facebook.feedback.reactions.ui.overlay.ReactionsDockOverlay.DockTheme;
import com.facebook.feedback.reactions.util.FeedbackReactionsUtils;
import com.facebook.feedplugins.feedbackreactions.ui.nux.ReactionsNuxInterstitialController;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.inject.Lazy;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.sounds.FBSoundUtil;
import com.facebook.springs.Spring;
import com.google.common.collect.ImmutableList;

/* compiled from: get_prepay_details */
public class ReactionsFooterBinderUtil {

    /* compiled from: get_prepay_details */
    /* synthetic */ class C09121 {
        static final /* synthetic */ int[] f22423a = new int[FeedListName.values().length];

        static {
            try {
                f22423a[FeedListName.VIDEO_CHANNEL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f22423a[FeedListName.VIDEO_HOME.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public static void m30329a(ReactionsFooterView reactionsFooterView, GraphQLFeedback graphQLFeedback, ReactionMutateListener reactionMutateListener, Spring spring, ReactionsFooterInteractionLogger reactionsFooterInteractionLogger, FeedbackReactionsController feedbackReactionsController, DockTheme dockTheme, ImmutableList<FeedbackReaction> immutableList) {
        FeedbackReaction a = feedbackReactionsController.m29087a(FeedbackReaction.m29190a(graphQLFeedback).intValue());
        reactionsFooterView.f22302m = reactionMutateListener;
        reactionsFooterView.setReaction(a);
        reactionsFooterView.setFadeStateSpring(spring);
        reactionsFooterInteractionLogger.m30291a(a);
        reactionsFooterView.f22304o = reactionsFooterInteractionLogger;
        reactionsFooterView.f22306q = dockTheme;
        reactionsFooterView.f22307r = immutableList;
    }

    public static void m30330a(Lazy<FBSoundUtil> lazy, FeedbackReaction feedbackReaction) {
        if (feedbackReaction != FeedbackReaction.f21476c) {
            ((FBSoundUtil) lazy.get()).b("like_main");
        }
    }

    public static boolean m30331a(InterstitialManager interstitialManager, FeedbackReactionsUtils feedbackReactionsUtils, ReactionsExperimentUtil reactionsExperimentUtil, InterstitialTrigger interstitialTrigger, ReactionsNuxLogger reactionsNuxLogger, String str, GraphQLFeedback graphQLFeedback, View view, FeedbackReaction feedbackReaction) {
        if (feedbackReaction.f21478e != 1 || feedbackReactionsUtils.m29076a()) {
            return false;
        }
        reactionsExperimentUtil.m10412e();
        ReactionsNuxInterstitialController reactionsNuxInterstitialController = (ReactionsNuxInterstitialController) interstitialManager.m8118a(interstitialTrigger, ReactionsNuxInterstitialController.class);
        if (reactionsNuxInterstitialController == null) {
            return false;
        }
        reactionsNuxInterstitialController.a(view, graphQLFeedback);
        reactionsNuxLogger.m29082a(str, graphQLFeedback.z_(), ClickTarget.FOOTER, reactionsNuxInterstitialController.b());
        interstitialManager.m8121a().a(reactionsNuxInterstitialController.b());
        return true;
    }

    public static DockTheme m30327a(FeedListType feedListType) {
        switch (C09121.f22423a[feedListType.mo2419a().ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return DockTheme.DARK;
            default:
                return DockTheme.LIGHT;
        }
    }

    public static void m30328a(ReactionsFooterView reactionsFooterView, ReactionsDockOverlay reactionsDockOverlay) {
        if (reactionsFooterView.f22301l == FeedbackFooterMode.REACTIONS) {
            reactionsDockOverlay.m29062a();
            reactionsFooterView.m30235a(FeedbackFooterMode.DEFAULT, true);
        } else {
            reactionsFooterView.m30235a(FeedbackFooterMode.DEFAULT, false);
        }
        reactionsFooterView.mo3251a();
    }
}
