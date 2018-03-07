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
import com.facebook.feed.util.event.StoryEvents$OutboundClickedEvent;
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
/* compiled from: messenger_sticker_reply_hint_android */
public class SavedQuickReturnTooltipTrigger<E extends HasAnchoredTooltipProvider & HasInvalidate & HasPersistentState> implements FeedReturnListener<StoryEvents$OutboundClickedEvent>, MenuButtonTooltipTrigger<E> {
    private static final InterstitialTrigger f13707a = new InterstitialTrigger(Action.FEED_STORY_CARET);
    private static SavedQuickReturnTooltipTrigger f13708h;
    private static final Object f13709i = new Object();
    public final Resources f13710b;
    private final InterstitialManager f13711c;
    private final FeedReturnDetector f13712d;
    public final CaretNuxTooltipDelegateProvider f13713e;
    public final QeAccessor f13714f;
    private E f13715g;

    private static SavedQuickReturnTooltipTrigger m20147b(InjectorLike injectorLike) {
        return new SavedQuickReturnTooltipTrigger(ResourcesMethodAutoProvider.m6510a(injectorLike), InterstitialManager.m8082a(injectorLike), FeedReturnDetector.m14488a(injectorLike), (CaretNuxTooltipDelegateProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(CaretNuxTooltipDelegateProvider.class), QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    public final void mo2658a(AnyEnvironment anyEnvironment) {
        this.f13715g = (HasAnchoredTooltipProvider) anyEnvironment;
        this.f13712d.m14492a((FeedReturnListener) this);
    }

    @Inject
    public SavedQuickReturnTooltipTrigger(Resources resources, InterstitialManager interstitialManager, FeedReturnDetector feedReturnDetector, CaretNuxTooltipDelegateProvider caretNuxTooltipDelegateProvider, QeAccessor qeAccessor) {
        this.f13710b = resources;
        this.f13711c = interstitialManager;
        this.f13712d = feedReturnDetector;
        this.f13713e = caretNuxTooltipDelegateProvider;
        this.f13714f = qeAccessor;
    }

    public static SavedQuickReturnTooltipTrigger m20146a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SavedQuickReturnTooltipTrigger b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f13709i) {
                SavedQuickReturnTooltipTrigger savedQuickReturnTooltipTrigger;
                if (a2 != null) {
                    savedQuickReturnTooltipTrigger = (SavedQuickReturnTooltipTrigger) a2.mo818a(f13709i);
                } else {
                    savedQuickReturnTooltipTrigger = f13708h;
                }
                if (savedQuickReturnTooltipTrigger == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m20147b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f13709i, b3);
                        } else {
                            f13708h = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = savedQuickReturnTooltipTrigger;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final boolean mo2660c() {
        return this.f13711c.m8127b(f13707a);
    }

    public final void mo2659b() {
        this.f13715g = null;
        this.f13712d.m14494b((FeedReturnListener) this);
    }

    public final void mo2662a(FeedEvent feedEvent, long j) {
        HasAnchoredTooltipProvider hasAnchoredTooltipProvider = this.f13715g;
        StoryEvents$OutboundClickedEvent storyEvents$OutboundClickedEvent = (StoryEvents$OutboundClickedEvent) feedEvent;
        Builder builder = ImmutableSet.builder();
        if (!StringUtil.m3589a(storyEvents$OutboundClickedEvent.f13913a)) {
            builder.m4813c(storyEvents$OutboundClickedEvent.f13913a);
        }
        if (!StringUtil.m3589a(storyEvents$OutboundClickedEvent.f13914b)) {
            builder.m4813c(storyEvents$OutboundClickedEvent.f13914b);
        }
        hasAnchoredTooltipProvider.mo2431a((CaretNuxTooltipDelegateBase) this.f13713e.m20136a(this.f13714f.mo580a(ExperimentsForSavedGatingModule.b, 2131232741, this.f13710b), Long.valueOf(j), builder.m4812b(), GraphQLStorySaveNuxType.LINK_WELCOME));
    }

    public final Class<StoryEvents$OutboundClickedEvent> mo2661a() {
        return StoryEvents$OutboundClickedEvent.class;
    }
}
