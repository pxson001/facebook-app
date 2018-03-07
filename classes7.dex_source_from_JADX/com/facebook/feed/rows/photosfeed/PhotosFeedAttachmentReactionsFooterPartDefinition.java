package com.facebook.feed.rows.photosfeed;

import android.content.Context;
import android.view.View;
import com.facebook.common.futures.DisposableFutureCallback;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.composer.activity.ComposerLauncherImpl;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.ui.FlyoutLauncher$FlyoutContext;
import com.facebook.feedback.reactions.abtest.ReactionsExperimentUtil;
import com.facebook.feedback.reactions.data.FeedbackReaction;
import com.facebook.feedback.reactions.ui.FeedbackFooterMode;
import com.facebook.feedback.reactions.ui.FeedbackReactionsController;
import com.facebook.feedback.reactions.ui.FloatingReactionsLauncher;
import com.facebook.feedback.reactions.ui.ReactionMutateListener;
import com.facebook.feedback.reactions.ui.logging.ReactionsFooterInteractionLogger;
import com.facebook.feedback.reactions.ui.logging.ReactionsFooterInteractionLoggerProvider;
import com.facebook.feedback.reactions.ui.logging.ReactionsNuxLogger;
import com.facebook.feedback.reactions.ui.overlay.ReactionsDockOverlay;
import com.facebook.feedback.reactions.ui.overlay.ReactionsDockOverlay.DockTheme;
import com.facebook.feedback.reactions.util.FeedbackReactionsUtils;
import com.facebook.feedplugins.base.footer.rows.FooterButtonClickListenerPartDefinition;
import com.facebook.feedplugins.base.footer.ui.Footer.ButtonClickedListener;
import com.facebook.feedplugins.base.footer.ui.Footer.FooterButtonId;
import com.facebook.feedplugins.feedbackreactions.ui.ReactionsFooterBinderUtil;
import com.facebook.feedplugins.feedbackreactions.ui.ReactionsFooterSpringKey;
import com.facebook.feedplugins.feedbackreactions.ui.ReactionsFooterView;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.ipc.composer.model.ComposerSourceType;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.photos.data.protocol.PhotosMetadataConversionHelper;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.MediaMetadata;
import com.facebook.sounds.FBSoundUtil;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringSystem;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: accessibilityLiveRegion */
public class PhotosFeedAttachmentReactionsFooterPartDefinition<E extends HasPersistentState & CanLaunchPhotosFeedFlyout & CanLikePhotosFeedImage & CanReactToPhotosFeeedImage, V extends ReactionsFooterView> extends MultiRowSinglePartDefinition<MediaMetadata, State, E, V> {
    private static final InterstitialTrigger f20096a = new InterstitialTrigger(Action.UFI_CLICKED);
    private static PhotosFeedAttachmentReactionsFooterPartDefinition f20097p;
    private static final Object f20098q = new Object();
    private final FooterButtonClickListenerPartDefinition f20099b;
    private final SpringSystem f20100c;
    private final Lazy<FBSoundUtil> f20101d;
    private final InterstitialManager f20102e;
    private final ReactionsNuxLogger f20103f;
    private final ReactionsFooterInteractionLoggerProvider f20104g;
    private final ReactionsDockOverlay f20105h;
    private final FeedbackReactionsController f20106i;
    public final FeedbackReactionsUtils f20107j;
    private final ReactionsExperimentUtil f20108k;
    public final Context f20109l;
    public final ComposerLauncher f20110m;
    public final FloatingReactionsLauncher f20111n;
    public final Lazy<IFeedIntentBuilder> f20112o;

    /* compiled from: accessibilityLiveRegion */
    /* synthetic */ class C17383 {
        static final /* synthetic */ int[] f20090a = new int[FooterButtonId.values().length];

        static {
            try {
                f20090a[FooterButtonId.LIKE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f20090a[FooterButtonId.COMMENT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f20090a[FooterButtonId.SHARE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* compiled from: accessibilityLiveRegion */
    public class State {
        public final ReactionMutateListener f20091a;
        public final Spring f20092b;
        public final GraphQLFeedback f20093c;
        public final ReactionsFooterInteractionLogger f20094d;
        public final ImmutableList<FeedbackReaction> f20095e;

        public State(ReactionMutateListener reactionMutateListener, Spring spring, GraphQLFeedback graphQLFeedback, ReactionsFooterInteractionLogger reactionsFooterInteractionLogger, ImmutableList<FeedbackReaction> immutableList) {
            this.f20091a = reactionMutateListener;
            this.f20092b = spring;
            this.f20093c = graphQLFeedback;
            this.f20094d = reactionsFooterInteractionLogger;
            this.f20095e = immutableList;
        }
    }

    private static PhotosFeedAttachmentReactionsFooterPartDefinition m23270b(InjectorLike injectorLike) {
        return new PhotosFeedAttachmentReactionsFooterPartDefinition(FooterButtonClickListenerPartDefinition.a(injectorLike), SpringSystem.b(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 10994), InterstitialManager.a(injectorLike), ReactionsNuxLogger.a(injectorLike), (ReactionsFooterInteractionLoggerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ReactionsFooterInteractionLoggerProvider.class), ReactionsDockOverlay.a(injectorLike), FeedbackReactionsController.a(injectorLike), FeedbackReactionsUtils.a(injectorLike), ReactionsExperimentUtil.a(injectorLike), (Context) injectorLike.getInstance(Context.class), (ComposerLauncher) ComposerLauncherImpl.a(injectorLike), FloatingReactionsLauncher.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 2347));
    }

    public final Object m23272a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final MediaMetadata mediaMetadata = (MediaMetadata) obj;
        final HasPersistentState hasPersistentState = (HasPersistentState) anyEnvironment;
        final GraphQLFeedback a = PhotosMetadataConversionHelper.a(mediaMetadata.C());
        subParts.a(this.f20099b, new ButtonClickedListener(this) {
            final /* synthetic */ PhotosFeedAttachmentReactionsFooterPartDefinition f20086d;

            public final void m23262a(View view, FooterButtonId footerButtonId) {
                this.f20086d.m23265a(view, footerButtonId, a, mediaMetadata, hasPersistentState);
            }
        });
        return new State(new ReactionMutateListener(this) {
            final /* synthetic */ PhotosFeedAttachmentReactionsFooterPartDefinition f20089c;

            public final void m23263a(View view, FeedbackReaction feedbackReaction, DisposableFutureCallback disposableFutureCallback) {
                if (feedbackReaction != FeedbackReaction.d) {
                    this.f20089c.f20107j.b();
                    ((CanReactToPhotosFeeedImage) hasPersistentState).mo1486a(a, feedbackReaction, disposableFutureCallback);
                    if (feedbackReaction.e == 11) {
                        this.f20089c.f20111n.a(view);
                    }
                }
            }
        }, (Spring) hasPersistentState.a(new ReactionsFooterSpringKey(mediaMetadata.d(), this.f20100c), new CacheableEntityWrapper(mediaMetadata.d())), a, this.f20104g.a(a.z_(), a.z_(), "photos_feed"), this.f20106i.a(a.K()));
    }

    public final /* bridge */ /* synthetic */ void m23273a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -323175866);
        m23268a((State) obj2, (ReactionsFooterView) view);
        Logger.a(8, EntryType.MARK_POP, 611148141, a);
    }

    public final void m23275b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ReactionsFooterBinderUtil.a((ReactionsFooterView) view, this.f20105h);
    }

    public static PhotosFeedAttachmentReactionsFooterPartDefinition m23264a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PhotosFeedAttachmentReactionsFooterPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20098q) {
                PhotosFeedAttachmentReactionsFooterPartDefinition photosFeedAttachmentReactionsFooterPartDefinition;
                if (a2 != null) {
                    photosFeedAttachmentReactionsFooterPartDefinition = (PhotosFeedAttachmentReactionsFooterPartDefinition) a2.a(f20098q);
                } else {
                    photosFeedAttachmentReactionsFooterPartDefinition = f20097p;
                }
                if (photosFeedAttachmentReactionsFooterPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23270b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20098q, b3);
                        } else {
                            f20097p = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = photosFeedAttachmentReactionsFooterPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PhotosFeedAttachmentReactionsFooterPartDefinition(FooterButtonClickListenerPartDefinition footerButtonClickListenerPartDefinition, SpringSystem springSystem, Lazy<FBSoundUtil> lazy, InterstitialManager interstitialManager, ReactionsNuxLogger reactionsNuxLogger, ReactionsFooterInteractionLoggerProvider reactionsFooterInteractionLoggerProvider, ReactionsDockOverlay reactionsDockOverlay, FeedbackReactionsController feedbackReactionsController, FeedbackReactionsUtils feedbackReactionsUtils, ReactionsExperimentUtil reactionsExperimentUtil, Context context, ComposerLauncher composerLauncher, FloatingReactionsLauncher floatingReactionsLauncher, Lazy<IFeedIntentBuilder> lazy2) {
        this.f20099b = footerButtonClickListenerPartDefinition;
        this.f20100c = springSystem;
        this.f20101d = lazy;
        this.f20102e = interstitialManager;
        this.f20103f = reactionsNuxLogger;
        this.f20104g = reactionsFooterInteractionLoggerProvider;
        this.f20105h = reactionsDockOverlay;
        this.f20106i = feedbackReactionsController;
        this.f20107j = feedbackReactionsUtils;
        this.f20108k = reactionsExperimentUtil;
        this.f20109l = context;
        this.f20110m = composerLauncher;
        this.f20111n = floatingReactionsLauncher;
        this.f20112o = lazy2;
    }

    public final ViewType m23271a() {
        return ReactionsFooterView.h;
    }

    private void m23265a(View view, FooterButtonId footerButtonId, GraphQLFeedback graphQLFeedback, MediaMetadata mediaMetadata, E e) {
        switch (C17383.f20090a[footerButtonId.ordinal()]) {
            case 1:
                m23266a(view, graphQLFeedback, (HasPersistentState) e);
                return;
            case 2:
                m23267a(view, mediaMetadata, (HasPersistentState) e);
                return;
            case 3:
                this.f20110m.a(null, ((IFeedIntentBuilder) this.f20112o.get()).a(mediaMetadata.d(), ComposerSourceType.PHOTOS_FEED).setIsFireAndForget(true).a(), this.f20109l);
                return;
            default:
                return;
        }
    }

    private static void m23267a(View view, MediaMetadata mediaMetadata, E e) {
        ((CanLaunchPhotosFeedFlyout) e).mo1484a(PhotosMetadataConversionHelper.a(mediaMetadata.C()), view, FlyoutLauncher$FlyoutContext.PHOTOS_FEED_FOOTER);
    }

    private void m23266a(View view, GraphQLFeedback graphQLFeedback, E e) {
        FeedbackReaction d = graphQLFeedback.S() == 0 ? this.f20106i.d() : FeedbackReaction.c;
        ReactionsFooterBinderUtil.a(this.f20101d, d);
        ReactionsFooterBinderUtil.a(this.f20102e, this.f20107j, this.f20108k, f20096a, this.f20103f, "photos_feed", graphQLFeedback, view, d);
        ((CanReactToPhotosFeeedImage) e).mo1486a(graphQLFeedback, d, null);
    }

    private void m23268a(State state, V v) {
        v.setIsLiked(state.f20093c.S() == 1);
        ReactionsFooterBinderUtil.a(v, state.f20093c, state.f20091a, state.f20092b, state.f20094d, this.f20106i, DockTheme.LIGHT, state.f20095e);
        v.a(FeedbackFooterMode.DEFAULT, true);
    }

    public final boolean m23274a(Object obj) {
        return true;
    }
}
