package com.facebook.feedplugins.saved.nux;

import android.content.Context;
import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.feed.environment.HasAnchoredTooltipProvider;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.tooltip.MenuButtonTooltipTrigger;
import com.facebook.feed.tooltip.OnlyMeShareDetector;
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
import com.facebook.saved.analytics.SaveAnalyticsLogger;
import com.facebook.ufiservices.event.UfiEvents$ShareStoryPublishEvent;
import com.facebook.xconfig.core.XConfigReader;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;
import javax.inject.Inject;

@ContextScoped
/* compiled from: messenger_sync_get_diffs */
public class SavedOnlyMeShareTooltipTrigger<E extends HasAnchoredTooltipProvider & HasInvalidate & HasPersistentState> implements MenuButtonTooltipTrigger<E> {
    private static final InterstitialTrigger f13681a = new InterstitialTrigger(Action.FEED_STORY_ONLY_ME_SHARE);
    private static SavedOnlyMeShareTooltipTrigger f13682g;
    private static final Object f13683h = new Object();
    private final InterstitialManager f13684b;
    private final OnlyMeShareDetector f13685c;
    public final OnlyMeShareNuxTooltipDelegateProvider f13686d;
    public final Resources f13687e;
    private E f13688f;

    private static SavedOnlyMeShareTooltipTrigger m20117b(InjectorLike injectorLike) {
        return new SavedOnlyMeShareTooltipTrigger(ResourcesMethodAutoProvider.m6510a(injectorLike), InterstitialManager.m8082a(injectorLike), OnlyMeShareDetector.m14884a(injectorLike), (OnlyMeShareNuxTooltipDelegateProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(OnlyMeShareNuxTooltipDelegateProvider.class));
    }

    public final void mo2658a(AnyEnvironment anyEnvironment) {
        this.f13688f = (HasAnchoredTooltipProvider) anyEnvironment;
        this.f13685c.f9858b.add(this);
    }

    @Inject
    public SavedOnlyMeShareTooltipTrigger(Resources resources, InterstitialManager interstitialManager, OnlyMeShareDetector onlyMeShareDetector, OnlyMeShareNuxTooltipDelegateProvider onlyMeShareNuxTooltipDelegateProvider) {
        this.f13687e = resources;
        this.f13684b = interstitialManager;
        this.f13685c = onlyMeShareDetector;
        this.f13686d = onlyMeShareNuxTooltipDelegateProvider;
    }

    public final boolean mo2660c() {
        return this.f13684b.m8127b(f13681a);
    }

    public static SavedOnlyMeShareTooltipTrigger m20116a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SavedOnlyMeShareTooltipTrigger b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f13683h) {
                SavedOnlyMeShareTooltipTrigger savedOnlyMeShareTooltipTrigger;
                if (a2 != null) {
                    savedOnlyMeShareTooltipTrigger = (SavedOnlyMeShareTooltipTrigger) a2.mo818a(f13683h);
                } else {
                    savedOnlyMeShareTooltipTrigger = f13682g;
                }
                if (savedOnlyMeShareTooltipTrigger == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m20117b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f13683h, b3);
                        } else {
                            f13682g = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = savedOnlyMeShareTooltipTrigger;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final void mo2659b() {
        this.f13688f = null;
        this.f13685c.f9858b.remove(this);
    }

    public final void m20119a(UfiEvents$ShareStoryPublishEvent ufiEvents$ShareStoryPublishEvent) {
        HasAnchoredTooltipProvider hasAnchoredTooltipProvider = this.f13688f;
        Builder builder = ImmutableSet.builder();
        if (!StringUtil.m3589a(ufiEvents$ShareStoryPublishEvent.f14038a)) {
            builder.m4813c(ufiEvents$ShareStoryPublishEvent.f14038a);
        }
        if (!StringUtil.m3589a(ufiEvents$ShareStoryPublishEvent.f14040c)) {
            builder.m4813c(ufiEvents$ShareStoryPublishEvent.f14040c);
        }
        InjectorLike injectorLike = this.f13686d;
        String string = this.f13687e.getString(2131232746);
        hasAnchoredTooltipProvider.mo2431a((CaretNuxTooltipDelegateBase) new OnlyMeShareNuxTooltipDelegate(string, builder.m4812b(), XConfigReader.m2681a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike), SaveAnalyticsLogger.m13117a(injectorLike), InterstitialManager.m8082a(injectorLike)));
    }
}
