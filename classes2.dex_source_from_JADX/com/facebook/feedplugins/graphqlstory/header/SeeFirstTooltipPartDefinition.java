package com.facebook.feedplugins.graphqlstory.header;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.popover.PopoverWindow.Position;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.feed.seefirst.SeeFirstNuxInterstitialController;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StoryActorHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
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
/* compiled from: http.proxyHost */
public class SeeFirstTooltipPartDefinition<V extends View & CanShowSeeFirstIndicator> extends BaseSinglePartDefinition<FeedUnit, State, AnyEnvironment, V> {
    private static final InterstitialTrigger f20785a = new InterstitialTrigger(Action.SEE_FIRST_INDICATOR);
    private static SeeFirstTooltipPartDefinition f20786d;
    private static final Object f20787e = new Object();
    public final Context f20788b;
    private final InterstitialManager f20789c;

    private static SeeFirstTooltipPartDefinition m28504b(InjectorLike injectorLike) {
        return new SeeFirstTooltipPartDefinition((Context) injectorLike.getInstance(Context.class), InterstitialManager.m8082a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Tooltip b = m28503b((FeedUnit) obj);
        return new State(b != null, b);
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -567497810);
        State state = (State) obj2;
        if (state.a) {
            state.a = false;
            view.post(new 1(this, view, state));
        }
        Logger.a(8, EntryType.MARK_POP, -223466756, a);
    }

    @Inject
    public SeeFirstTooltipPartDefinition(Context context, InterstitialManager interstitialManager) {
        this.f20788b = context;
        this.f20789c = interstitialManager;
    }

    public static SeeFirstTooltipPartDefinition m28502a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SeeFirstTooltipPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20787e) {
                SeeFirstTooltipPartDefinition seeFirstTooltipPartDefinition;
                if (a2 != null) {
                    seeFirstTooltipPartDefinition = (SeeFirstTooltipPartDefinition) a2.mo818a(f20787e);
                } else {
                    seeFirstTooltipPartDefinition = f20786d;
                }
                if (seeFirstTooltipPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28504b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20787e, b3);
                        } else {
                            f20786d = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = seeFirstTooltipPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Nullable
    private Tooltip m28503b(FeedUnit feedUnit) {
        GraphQLActor b = StoryActorHelper.m27492b((GraphQLStory) feedUnit);
        if (b == null || b.aa() == null || this.f20789c.m8118a(f20785a, SeeFirstNuxInterstitialController.class) == null) {
            return null;
        }
        Tooltip tooltip = new Tooltip(this.f20788b, 2);
        tooltip.a(this.f20788b.getResources().getString(2131233597, new Object[]{r1}));
        tooltip.t = -1;
        tooltip.a(Position.BELOW);
        return tooltip;
    }
}
