package com.facebook.feedplugins.saved.nux;

import android.content.Context;
import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.feed.environment.HasAnchoredTooltipProvider;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.tooltip.TooltipDelegate;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.tooltip.MenuButtonTooltipTrigger;
import com.facebook.feed.ui.fullscreenvideoplayer.FeedFullScreenVideoElapsedMonitor;
import com.facebook.feed.video.FeedFullScreenParams;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.graphql.enums.GraphQLStorySaveNuxType;
import com.facebook.graphql.model.GraphQLStory;
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
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;
import com.google.common.collect.RegularImmutableSet;
import javax.inject.Inject;

@ContextScoped
/* compiled from: messenger_sticker_preview_dialog_android */
public class SavedVideoQuickReturnTooltipTrigger<E extends HasAnchoredTooltipProvider & HasInvalidate & HasPersistentState> implements MenuButtonTooltipTrigger<E> {
    private static final InterstitialTrigger f13716a = new InterstitialTrigger(Action.FEED_STORY_CARET);
    private static SavedVideoQuickReturnTooltipTrigger f13717h;
    private static final Object f13718i = new Object();
    private final Resources f13719b;
    private final InterstitialManager f13720c;
    private final FeedFullScreenVideoElapsedMonitor f13721d;
    private final CaretNuxTooltipDelegateProvider f13722e;
    private final QeAccessor f13723f;
    private E f13724g;

    private static SavedVideoQuickReturnTooltipTrigger m20155b(InjectorLike injectorLike) {
        return new SavedVideoQuickReturnTooltipTrigger(ResourcesMethodAutoProvider.m6510a(injectorLike), InterstitialManager.m8082a(injectorLike), FeedFullScreenVideoElapsedMonitor.m20160a(injectorLike), (CaretNuxTooltipDelegateProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(CaretNuxTooltipDelegateProvider.class), QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    public final void mo2658a(AnyEnvironment anyEnvironment) {
        this.f13724g = (HasAnchoredTooltipProvider) anyEnvironment;
        this.f13721d.f13730d.add(this);
    }

    @Inject
    public SavedVideoQuickReturnTooltipTrigger(Resources resources, InterstitialManager interstitialManager, FeedFullScreenVideoElapsedMonitor feedFullScreenVideoElapsedMonitor, CaretNuxTooltipDelegateProvider caretNuxTooltipDelegateProvider, QeAccessor qeAccessor) {
        this.f13719b = resources;
        this.f13720c = interstitialManager;
        this.f13721d = feedFullScreenVideoElapsedMonitor;
        this.f13722e = caretNuxTooltipDelegateProvider;
        this.f13723f = qeAccessor;
    }

    public static SavedVideoQuickReturnTooltipTrigger m20154a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SavedVideoQuickReturnTooltipTrigger b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f13718i) {
                SavedVideoQuickReturnTooltipTrigger savedVideoQuickReturnTooltipTrigger;
                if (a2 != null) {
                    savedVideoQuickReturnTooltipTrigger = (SavedVideoQuickReturnTooltipTrigger) a2.mo818a(f13718i);
                } else {
                    savedVideoQuickReturnTooltipTrigger = f13717h;
                }
                if (savedVideoQuickReturnTooltipTrigger == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m20155b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f13718i, b3);
                        } else {
                            f13717h = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = savedVideoQuickReturnTooltipTrigger;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final boolean mo2660c() {
        return this.f13720c.m8127b(f13716a);
    }

    public final void mo2659b() {
        this.f13724g = null;
        this.f13721d.f13730d.remove(this);
    }

    public final void m20156a(FeedFullScreenParams feedFullScreenParams, long j) {
        ImmutableSet immutableSet;
        if (feedFullScreenParams == null || feedFullScreenParams.b == null) {
            immutableSet = RegularImmutableSet.f688a;
        } else {
            Builder builder = ImmutableSet.builder();
            FeedProps e = AttachmentProps.m28715e(feedFullScreenParams.b);
            GraphQLStory graphQLStory = (GraphQLStory) e.f13444a;
            if (!StringUtil.m3589a(graphQLStory.mo2507g())) {
                builder.m4813c(graphQLStory.mo2507g());
            }
            ImmutableList d = e.m19808d();
            int size = d.size();
            for (int i = 0; i < size; i++) {
                Flattenable flattenable = (Flattenable) d.get(i);
                if (!(flattenable instanceof GraphQLStory)) {
                    break;
                }
                graphQLStory = (GraphQLStory) flattenable;
                if (!StringUtil.m3589a(graphQLStory.mo2507g())) {
                    builder.m4813c(graphQLStory.mo2507g());
                }
            }
            immutableSet = builder.m4812b();
        }
        ImmutableSet immutableSet2 = immutableSet;
        if (!immutableSet2.isEmpty()) {
            this.f13724g.mo2431a(m20153a(immutableSet2, j));
        }
    }

    private TooltipDelegate m20153a(ImmutableSet<String> immutableSet, long j) {
        return this.f13722e.m20136a(this.f13723f.mo580a(ExperimentsForSavedGatingModule.e, 2131232742, this.f13719b), Long.valueOf(j), immutableSet, GraphQLStorySaveNuxType.VIDEO_WELCOME);
    }
}
