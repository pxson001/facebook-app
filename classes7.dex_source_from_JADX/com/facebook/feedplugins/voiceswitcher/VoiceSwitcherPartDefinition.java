package com.facebook.feedplugins.voiceswitcher;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.feedplugins.base.blingbar.BlingBarAnimationsPartDefinition;
import com.facebook.feedplugins.base.blingbar.BlingBarPartDefinition;
import com.facebook.feedplugins.base.blingbar.BlingBarPartDefinition.Props;
import com.facebook.feedplugins.voiceswitcher.abtest.ExperimentsForVoiceSwitcherPluginModule;
import com.facebook.feedplugins.voiceswitcher.ui.VoiceSwitcherView;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;

@ContextScoped
/* compiled from: SHARE */
public class VoiceSwitcherPartDefinition<E extends HasPositionInformation & HasPersistentState> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, VoiceSwitcherView> {
    public static final ViewType f23841a = new C20561();
    public static final PaddingStyle f23842b = Builder.g().i();
    private static VoiceSwitcherPartDefinition f23843h;
    private static final Object f23844i = new Object();
    private final ClickListenerPartDefinition f23845c;
    private final BlingBarPartDefinition f23846d;
    private final BackgroundPartDefinition f23847e;
    private final TextPartDefinition f23848f;
    private final QeAccessor f23849g;

    /* compiled from: SHARE */
    final class C20561 extends ViewType {
        C20561() {
        }

        public final View m25991a(Context context) {
            return new VoiceSwitcherView(context);
        }
    }

    /* compiled from: SHARE */
    class C20572 implements OnClickListener {
        final /* synthetic */ VoiceSwitcherPartDefinition f23840a;

        C20572(VoiceSwitcherPartDefinition voiceSwitcherPartDefinition) {
            this.f23840a = voiceSwitcherPartDefinition;
        }

        public void onClick(View view) {
            Logger.a(2, EntryType.UI_INPUT_END, -1789527637, Logger.a(2, EntryType.UI_INPUT_START, 2001231431));
        }
    }

    private static VoiceSwitcherPartDefinition m25993b(InjectorLike injectorLike) {
        return new VoiceSwitcherPartDefinition(ClickListenerPartDefinition.a(injectorLike), BlingBarPartDefinition.m25426a(injectorLike), BackgroundPartDefinition.a(injectorLike), TextPartDefinition.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    public final Object m25995a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
        subParts.a(this.f23847e, new StylingData(feedProps, f23842b));
        subParts.a(this.f23846d, new Props(feedProps, BlingBarAnimationsPartDefinition.m25423a(graphQLStory)));
        subParts.a(2131568447, this.f23848f, "Default Voice");
        subParts.a(2131568447, this.f23845c, new C20572(this));
        return null;
    }

    public final boolean m25996a(Object obj) {
        GraphQLStory graphQLStory = (GraphQLStory) ((FeedProps) obj).a;
        return this.f23849g.a(ExperimentsForVoiceSwitcherPluginModule.f23850a, false) && graphQLStory.l() != null && graphQLStory.l().b();
    }

    public static VoiceSwitcherPartDefinition m25992a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            VoiceSwitcherPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23844i) {
                VoiceSwitcherPartDefinition voiceSwitcherPartDefinition;
                if (a2 != null) {
                    voiceSwitcherPartDefinition = (VoiceSwitcherPartDefinition) a2.a(f23844i);
                } else {
                    voiceSwitcherPartDefinition = f23843h;
                }
                if (voiceSwitcherPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m25993b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23844i, b3);
                        } else {
                            f23843h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = voiceSwitcherPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public VoiceSwitcherPartDefinition(ClickListenerPartDefinition clickListenerPartDefinition, BlingBarPartDefinition blingBarPartDefinition, BackgroundPartDefinition backgroundPartDefinition, TextPartDefinition textPartDefinition, QeAccessor qeAccessor) {
        this.f23845c = clickListenerPartDefinition;
        this.f23846d = blingBarPartDefinition;
        this.f23847e = backgroundPartDefinition;
        this.f23848f = textPartDefinition;
        this.f23849g = qeAccessor;
    }

    public final ViewType m25994a() {
        return f23841a;
    }
}
