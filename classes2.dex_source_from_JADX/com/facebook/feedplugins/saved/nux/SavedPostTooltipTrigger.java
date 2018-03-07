package com.facebook.feedplugins.saved.nux;

import android.content.Context;
import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.feed.environment.HasAnchoredTooltipProvider;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.tooltip.FeedReturnDetector;
import com.facebook.feed.tooltip.FeedReturnDetector.FeedReturnListener;
import com.facebook.feed.tooltip.MenuButtonTooltipTrigger;
import com.facebook.feed.util.event.FeedEvent;
import com.facebook.feed.util.event.StoryEvents$PermalinkClickedEvent;
import com.facebook.graphql.enums.GraphQLStorySaveNuxType;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.saved.gating.feature.ExperimentsForSavedGatingModule;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;
import javax.inject.Inject;

@ContextScoped
/* compiled from: messenger_sticker_search_android */
public class SavedPostTooltipTrigger<E extends HasAnchoredTooltipProvider & HasInvalidate & HasPersistentState> implements FeedReturnListener<StoryEvents$PermalinkClickedEvent>, MenuButtonTooltipTrigger<E> {
    private static final InterstitialTrigger f13698a = new InterstitialTrigger(Action.FEED_STORY_CARET);
    private static SavedPostTooltipTrigger f13699h;
    private static final Object f13700i = new Object();
    public final Resources f13701b;
    private final InterstitialManager f13702c;
    private final FeedReturnDetector f13703d;
    public final CaretNuxTooltipDelegateProvider f13704e;
    public final QeAccessor f13705f;
    private E f13706g;

    private static SavedPostTooltipTrigger m20138b(InjectorLike injectorLike) {
        return new SavedPostTooltipTrigger(ResourcesMethodAutoProvider.m6510a(injectorLike), InterstitialManager.m8082a(injectorLike), FeedReturnDetector.m14488a(injectorLike), (CaretNuxTooltipDelegateProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(CaretNuxTooltipDelegateProvider.class), QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    public final void mo2658a(AnyEnvironment anyEnvironment) {
        this.f13706g = (HasAnchoredTooltipProvider) anyEnvironment;
        this.f13703d.m14492a((FeedReturnListener) this);
    }

    @Inject
    public SavedPostTooltipTrigger(Resources resources, InterstitialManager interstitialManager, FeedReturnDetector feedReturnDetector, CaretNuxTooltipDelegateProvider caretNuxTooltipDelegateProvider, QeAccessor qeAccessor) {
        this.f13701b = resources;
        this.f13702c = interstitialManager;
        this.f13703d = feedReturnDetector;
        this.f13704e = caretNuxTooltipDelegateProvider;
        this.f13705f = qeAccessor;
    }

    public static SavedPostTooltipTrigger m20137a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SavedPostTooltipTrigger b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f13700i) {
                SavedPostTooltipTrigger savedPostTooltipTrigger;
                if (a2 != null) {
                    savedPostTooltipTrigger = (SavedPostTooltipTrigger) a2.mo818a(f13700i);
                } else {
                    savedPostTooltipTrigger = f13699h;
                }
                if (savedPostTooltipTrigger == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m20138b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f13700i, b3);
                        } else {
                            f13699h = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = savedPostTooltipTrigger;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final boolean mo2660c() {
        return this.f13702c.m8127b(f13698a);
    }

    public final void mo2659b() {
        this.f13706g = null;
        this.f13703d.m14494b((FeedReturnListener) this);
    }

    public final void mo2662a(FeedEvent feedEvent, long j) {
        HasAnchoredTooltipProvider hasAnchoredTooltipProvider = this.f13706g;
        StoryEvents$PermalinkClickedEvent storyEvents$PermalinkClickedEvent = (StoryEvents$PermalinkClickedEvent) feedEvent;
        Builder builder = ImmutableSet.builder();
        if (!StringUtil.m3589a(storyEvents$PermalinkClickedEvent.f13911a)) {
            builder.m4813c(storyEvents$PermalinkClickedEvent.f13911a);
        }
        if (!StringUtil.m3589a(storyEvents$PermalinkClickedEvent.f13912b)) {
            builder.m4813c(storyEvents$PermalinkClickedEvent.f13912b);
        }
        hasAnchoredTooltipProvider.mo2431a((CaretNuxTooltipDelegateBase) this.f13704e.m20136a(this.f13705f.mo580a(ExperimentsForSavedGatingModule.d, 2131232743, this.f13701b), Long.valueOf(j), builder.m4812b(), GraphQLStorySaveNuxType.POST_SAVE_WELCOME));
    }

    public final Class<StoryEvents$PermalinkClickedEvent> mo2661a() {
        return StoryEvents$PermalinkClickedEvent.class;
    }
}
