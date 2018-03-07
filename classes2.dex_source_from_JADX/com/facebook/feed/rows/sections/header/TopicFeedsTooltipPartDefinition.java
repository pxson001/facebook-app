package com.facebook.feed.rows.sections.header;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.popover.PopoverWindow.Position;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.feed.environment.CanShowAnchoredTooltip;
import com.facebook.feed.topicfeeds.nux.TopicFeedsTooltipInterstitialController;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.interstitial.manager.InterstitialController;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: huge_picture_size */
public class TopicFeedsTooltipPartDefinition<V extends View & CanShowAnchoredTooltip> extends BaseSinglePartDefinition<FeedUnit, State, AnyEnvironment, V> {
    private static final InterstitialTrigger f20666a = new InterstitialTrigger(Action.FEED_STORY_CARET);
    private static TopicFeedsTooltipPartDefinition f20667d;
    private static final Object f20668e = new Object();
    public final Context f20669b;
    private final InterstitialManager f20670c;

    /* compiled from: huge_picture_size */
    public class State {
        public Tooltip f21767a;

        public State(Tooltip tooltip) {
            this.f21767a = tooltip;
        }
    }

    private static TopicFeedsTooltipPartDefinition m28421b(InjectorLike injectorLike) {
        return new TopicFeedsTooltipPartDefinition((Context) injectorLike.getInstance(Context.class), InterstitialManager.m8082a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        return new State(m28420b((FeedUnit) obj));
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 439841967);
        m28419a((State) obj2, view);
        Logger.a(8, EntryType.MARK_POP, -1479629654, a);
    }

    @Inject
    public TopicFeedsTooltipPartDefinition(Context context, InterstitialManager interstitialManager) {
        this.f20669b = context;
        this.f20670c = interstitialManager;
    }

    public static TopicFeedsTooltipPartDefinition m28418a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            TopicFeedsTooltipPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20668e) {
                TopicFeedsTooltipPartDefinition topicFeedsTooltipPartDefinition;
                if (a2 != null) {
                    topicFeedsTooltipPartDefinition = (TopicFeedsTooltipPartDefinition) a2.mo818a(f20668e);
                } else {
                    topicFeedsTooltipPartDefinition = f20667d;
                }
                if (topicFeedsTooltipPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28421b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20668e, b3);
                        } else {
                            f20667d = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = topicFeedsTooltipPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    private static void m28419a(State state, V v) {
        if (state.f21767a != null) {
            ((CanShowAnchoredTooltip) v).mo3090a(state.f21767a);
            state.f21767a = null;
        }
    }

    @Nullable
    private Tooltip m28420b(FeedUnit feedUnit) {
        GraphQLStory graphQLStory = (GraphQLStory) feedUnit;
        if (graphQLStory.m22340Z() == null || graphQLStory.m22340Z().m24195a() == null || graphQLStory.m22340Z().m24195a().isEmpty()) {
            return null;
        }
        InterstitialController a = this.f20670c.m8118a(f20666a, TopicFeedsTooltipInterstitialController.class);
        if (a == null) {
            return null;
        }
        this.f20670c.m8121a().a(a.mo1173b());
        Tooltip tooltip = new Tooltip(this.f20669b, 2);
        tooltip.b(this.f20669b.getResources().getString(2131233657));
        tooltip.t = -1;
        tooltip.a(Position.BELOW);
        return tooltip;
    }
}
