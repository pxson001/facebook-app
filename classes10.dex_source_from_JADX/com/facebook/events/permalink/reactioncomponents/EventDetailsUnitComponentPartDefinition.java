package com.facebook.events.permalink.reactioncomponents;

import android.content.Context;
import android.content.res.Resources;
import android.text.Spannable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.sections.text.ExpandingContentTextPersistentState;
import com.facebook.graphql.querybuilder.convertible.DefaultGraphQLConversionHelper;
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
import com.facebook.reaction.common.ReactionAnalyticsParams;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.environment.HasReactionAnalyticsParams;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitComponentFieldsModel.MessageModel;
import com.facebook.ufiservices.util.LinkifyUtil;
import com.facebook.ufiservices.util.LinkifyUtilConverter;
import com.facebook.widget.text.BetterLinkMovementMethod;
import com.facebook.widget.text.BetterTextView;
import javax.inject.Inject;

@ContextScoped
/* compiled from: background_location_traveling_nux_actor_info_abnormal */
public class EventDetailsUnitComponentPartDefinition<E extends HasContext & HasInvalidate & HasPersistentState & HasReactionAnalyticsParams & HasReactionSession> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, State, E, BetterTextView> {
    public static final ViewType f18810a = new C26711();
    private static EventDetailsUnitComponentPartDefinition f18811f;
    private static final Object f18812g = new Object();
    private final AnalyticsLogger f18813b;
    public final BetterLinkMovementMethod f18814c;
    private final LinkifyUtil f18815d;
    private final String f18816e;

    /* compiled from: background_location_traveling_nux_actor_info_abnormal */
    final class C26711 extends ViewType {
        C26711() {
        }

        public final View m19106a(Context context) {
            BetterTextView betterTextView = (BetterTextView) LayoutInflater.from(context).inflate(2130906662, null);
            betterTextView.setMovementMethod(BetterLinkMovementMethod.getInstance());
            return betterTextView;
        }
    }

    /* compiled from: background_location_traveling_nux_actor_info_abnormal */
    public class State {
        public final ExpandingContentTextPersistentState f18808a;
        public final Spannable f18809b;

        public State(ExpandingContentTextPersistentState expandingContentTextPersistentState, Spannable spannable) {
            this.f18808a = expandingContentTextPersistentState;
            this.f18809b = spannable;
        }
    }

    private static EventDetailsUnitComponentPartDefinition m19110b(InjectorLike injectorLike) {
        return new EventDetailsUnitComponentPartDefinition(AnalyticsLoggerMethodAutoProvider.a(injectorLike), BetterLinkMovementMethod.a(injectorLike), LinkifyUtil.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike));
    }

    private Spannable m19107a(Spannable spannable, final ExpandingContentTextPersistentState expandingContentTextPersistentState, final ReactionUnitComponentNode reactionUnitComponentNode, final E e) {
        if (expandingContentTextPersistentState.a) {
            return spannable;
        }
        Spannable a = this.f18815d.a(spannable, new OnClickListener(this) {
            final /* synthetic */ EventDetailsUnitComponentPartDefinition f18807d;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 929598941);
                expandingContentTextPersistentState.a = true;
                ((HasInvalidate) e).a(new Object[]{reactionUnitComponentNode});
                EventDetailsUnitComponentPartDefinition.m19109a(this.f18807d, e);
                Logger.a(2, EntryType.UI_INPUT_END, 1090366782, a);
            }
        }, this.f18816e);
        return a != null ? a : spannable;
    }

    public final Object m19112a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        HasContext hasContext = (HasContext) anyEnvironment;
        ExpandingContentTextPersistentState expandingContentTextPersistentState = (ExpandingContentTextPersistentState) ((HasPersistentState) hasContext).a(new EventDetailsSeeMoreStateKey(reactionUnitComponentNode.b.U()), reactionUnitComponentNode);
        return new State(expandingContentTextPersistentState, m19107a(this.f18815d.a(LinkifyUtilConverter.c(DefaultGraphQLConversionHelper.a(reactionUnitComponentNode.b.bv())), true, null), expandingContentTextPersistentState, reactionUnitComponentNode, hasContext));
    }

    public final boolean m19114a(Object obj) {
        MessageModel bv = ((ReactionUnitComponentNode) obj).b.bv();
        return (bv == null || StringUtil.a(bv.a())) ? false : true;
    }

    public final void m19115b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((BetterTextView) view).setText("");
    }

    public static EventDetailsUnitComponentPartDefinition m19108a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            EventDetailsUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f18812g) {
                EventDetailsUnitComponentPartDefinition eventDetailsUnitComponentPartDefinition;
                if (a2 != null) {
                    eventDetailsUnitComponentPartDefinition = (EventDetailsUnitComponentPartDefinition) a2.a(f18812g);
                } else {
                    eventDetailsUnitComponentPartDefinition = f18811f;
                }
                if (eventDetailsUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m19110b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f18812g, b3);
                        } else {
                            f18811f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = eventDetailsUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public EventDetailsUnitComponentPartDefinition(AnalyticsLogger analyticsLogger, BetterLinkMovementMethod betterLinkMovementMethod, LinkifyUtil linkifyUtil, Resources resources) {
        this.f18813b = analyticsLogger;
        this.f18814c = betterLinkMovementMethod;
        this.f18815d = linkifyUtil;
        this.f18816e = resources.getString(2131237261);
    }

    public final ViewType m19111a() {
        return f18810a;
    }

    public static void m19109a(EventDetailsUnitComponentPartDefinition eventDetailsUnitComponentPartDefinition, HasContext hasContext) {
        HoneyClientEventFast a = eventDetailsUnitComponentPartDefinition.f18813b.a("android_event_permalink_details_toggle_expansion", false);
        if (a.a()) {
            ReactionAnalyticsParams r = ((HasReactionAnalyticsParams) hasContext).r();
            if (r != null) {
                a.a("ref_module", r.a).a("ref_mechanism", r.b).a("action_mechanism", r.d);
            }
            a.a("source_module", ((HasReactionSession) hasContext).p().c).a("surface", ((HasReactionSession) hasContext).p().c).a("source_entity_id", ((HasReactionSession) hasContext).p().v()).b();
        }
    }
}
