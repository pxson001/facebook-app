package com.facebook.feedplugins.saved.nux;

import android.content.Context;
import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.feed.environment.HasAnchoredTooltipProvider;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.tooltip.MenuButtonTooltipTrigger;
import com.facebook.feed.tooltip.PhotoReturnDetector;
import com.facebook.feed.util.event.StoryEvents$PhotoClickedEvent;
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
/* compiled from: messenger_stickerstore_new_badge_android */
public class SavedPhotoTooltipTrigger<E extends HasAnchoredTooltipProvider & HasInvalidate & HasPersistentState> implements MenuButtonTooltipTrigger<E> {
    private static final InterstitialTrigger f13689a = new InterstitialTrigger(Action.FEED_STORY_CARET);
    private static SavedPhotoTooltipTrigger f13690h;
    private static final Object f13691i = new Object();
    public final Resources f13692b;
    private final InterstitialManager f13693c;
    private final PhotoReturnDetector f13694d;
    public final CaretNuxTooltipDelegateProvider f13695e;
    public final QeAccessor f13696f;
    private E f13697g;

    private static SavedPhotoTooltipTrigger m20131b(InjectorLike injectorLike) {
        return new SavedPhotoTooltipTrigger(ResourcesMethodAutoProvider.m6510a(injectorLike), InterstitialManager.m8082a(injectorLike), PhotoReturnDetector.m15064a(injectorLike), (CaretNuxTooltipDelegateProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(CaretNuxTooltipDelegateProvider.class), QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    public final void mo2658a(AnyEnvironment anyEnvironment) {
        this.f13697g = (HasAnchoredTooltipProvider) anyEnvironment;
        this.f13694d.f10021b.add(this);
    }

    @Inject
    public SavedPhotoTooltipTrigger(Resources resources, InterstitialManager interstitialManager, PhotoReturnDetector photoReturnDetector, CaretNuxTooltipDelegateProvider caretNuxTooltipDelegateProvider, QeAccessor qeAccessor) {
        this.f13692b = resources;
        this.f13693c = interstitialManager;
        this.f13694d = photoReturnDetector;
        this.f13695e = caretNuxTooltipDelegateProvider;
        this.f13696f = qeAccessor;
    }

    public final boolean mo2660c() {
        return this.f13693c.m8127b(f13689a);
    }

    public static SavedPhotoTooltipTrigger m20130a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SavedPhotoTooltipTrigger b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f13691i) {
                SavedPhotoTooltipTrigger savedPhotoTooltipTrigger;
                if (a2 != null) {
                    savedPhotoTooltipTrigger = (SavedPhotoTooltipTrigger) a2.mo818a(f13691i);
                } else {
                    savedPhotoTooltipTrigger = f13690h;
                }
                if (savedPhotoTooltipTrigger == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m20131b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f13691i, b3);
                        } else {
                            f13690h = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = savedPhotoTooltipTrigger;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final void mo2659b() {
        this.f13697g = null;
        this.f13694d.f10021b.remove(this);
    }

    public final void m20132a(StoryEvents$PhotoClickedEvent storyEvents$PhotoClickedEvent, long j) {
        HasAnchoredTooltipProvider hasAnchoredTooltipProvider = this.f13697g;
        Builder builder = ImmutableSet.builder();
        if (!StringUtil.m3589a(storyEvents$PhotoClickedEvent.f14034a)) {
            builder.m4813c(storyEvents$PhotoClickedEvent.f14034a);
        }
        if (!StringUtil.m3589a(storyEvents$PhotoClickedEvent.f14035b)) {
            builder.m4813c(storyEvents$PhotoClickedEvent.f14035b);
        }
        hasAnchoredTooltipProvider.mo2431a((CaretNuxTooltipDelegateBase) this.f13695e.m20136a(this.f13696f.mo580a(ExperimentsForSavedGatingModule.c, 2131232744, this.f13692b), Long.valueOf(j), builder.m4812b(), GraphQLStorySaveNuxType.PHOTO_WELCOME));
    }
}
