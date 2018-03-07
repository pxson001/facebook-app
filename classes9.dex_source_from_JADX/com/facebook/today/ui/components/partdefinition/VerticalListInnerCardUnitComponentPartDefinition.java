package com.facebook.today.ui.components.partdefinition;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.analytics.MultiRowPerfLoggerMethodAutoProvider;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.rows.core.analytics.MultiRowPerfLogger;
import com.facebook.feed.rows.core.binding.Binder;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.parts.ViewGroupRenderer;
import com.facebook.graphql.enums.GraphQLReactionUnitComponentStyle;
import com.facebook.graphql.enums.GraphQLStorySeenState;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.MultiRowGroupPartDefinition;
import com.facebook.multirow.api.SinglePartDefinitionWithViewType;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLInterfaces.NotificationsEdgeFields;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.common.ReactionUnitComponentStyleMapper;
import com.facebook.reaction.common.ReactionUnitValidator;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitStaticAggregationComponentFields;
import com.facebook.today.common.HasNotifications;
import com.facebook.widget.CustomViewUtils;
import javax.inject.Inject;

@ContextScoped
/* compiled from: transfer_theme */
public class VerticalListInnerCardUnitComponentPartDefinition<E extends HasContext & HasNotifications> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, State, E, LinearLayout> {
    public static final ViewType f1356a = new C01361();
    private static VerticalListInnerCardUnitComponentPartDefinition f1357e;
    private static final Object f1358f = new Object();
    private final MultiRowPerfLogger f1359b;
    private final ReactionUnitComponentStyleMapper f1360c;
    private final ReactionUnitValidator f1361d;

    /* compiled from: transfer_theme */
    final class C01361 extends ViewType {
        C01361() {
        }

        public final View m1486a(Context context) {
            View linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(1);
            linearLayout.setLayoutParams(new LayoutParams(-1, -2));
            return linearLayout;
        }
    }

    /* compiled from: transfer_theme */
    public class State {
        public final Drawable f1353a;
        public final Binder<ViewGroup> f1354b;
        public final SinglePartDefinitionWithViewType f1355c;

        public State(Drawable drawable, Binder<ViewGroup> binder, SinglePartDefinitionWithViewType singlePartDefinitionWithViewType) {
            this.f1353a = drawable;
            this.f1354b = binder;
            this.f1355c = singlePartDefinitionWithViewType;
        }
    }

    private static VerticalListInnerCardUnitComponentPartDefinition m1488b(InjectorLike injectorLike) {
        return new VerticalListInnerCardUnitComponentPartDefinition(MultiRowPerfLoggerMethodAutoProvider.a(injectorLike), ReactionUnitComponentStyleMapper.a(injectorLike), ReactionUnitValidator.b(injectorLike));
    }

    public final Object m1490a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        HasContext hasContext = (HasContext) anyEnvironment;
        SinglePartDefinitionWithViewType a = ViewGroupRenderer.a((MultiRowGroupPartDefinition) this.f1360c.a(GraphQLReactionUnitComponentStyle.VERTICAL_COMPONENTS_LIST), f1356a, hasContext.getContext(), this.f1359b);
        NotificationsEdgeFields a2 = ((HasNotifications) hasContext).a(reactionUnitComponentNode.c);
        Object obj2 = (a2 == null || a2.k().au() != GraphQLStorySeenState.SEEN_AND_READ) ? null : 1;
        return new State(obj2 != null ? hasContext.getContext().getResources().getDrawable(2130843045) : hasContext.getContext().getResources().getDrawable(2130843046), (Binder) a.a(subParts, reactionUnitComponentNode, hasContext), a);
    }

    public final /* bridge */ /* synthetic */ void m1491a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1273885630);
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        State state = (State) obj2;
        HasContext hasContext = (HasContext) anyEnvironment;
        LinearLayout linearLayout = (LinearLayout) view;
        CustomViewUtils.b(linearLayout, state.f1353a);
        state.f1355c.a(reactionUnitComponentNode, state.f1354b, hasContext, linearLayout);
        Logger.a(8, EntryType.MARK_POP, -1867217594, a);
    }

    public final boolean m1492a(Object obj) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        return "SUCCESS".equals(this.f1361d.a(reactionUnitComponentNode)) && (reactionUnitComponentNode.b instanceof ReactionUnitStaticAggregationComponentFields);
    }

    public final void m1493b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        State state = (State) obj2;
        state.f1355c.b((ReactionUnitComponentNode) obj, state.f1354b, (HasContext) anyEnvironment, (LinearLayout) view);
    }

    public static VerticalListInnerCardUnitComponentPartDefinition m1487a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            VerticalListInnerCardUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f1358f) {
                VerticalListInnerCardUnitComponentPartDefinition verticalListInnerCardUnitComponentPartDefinition;
                if (a2 != null) {
                    verticalListInnerCardUnitComponentPartDefinition = (VerticalListInnerCardUnitComponentPartDefinition) a2.a(f1358f);
                } else {
                    verticalListInnerCardUnitComponentPartDefinition = f1357e;
                }
                if (verticalListInnerCardUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m1488b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f1358f, b3);
                        } else {
                            f1357e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = verticalListInnerCardUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public VerticalListInnerCardUnitComponentPartDefinition(MultiRowPerfLogger multiRowPerfLogger, ReactionUnitComponentStyleMapper reactionUnitComponentStyleMapper, ReactionUnitValidator reactionUnitValidator) {
        this.f1359b = multiRowPerfLogger;
        this.f1360c = reactionUnitComponentStyleMapper;
        this.f1361d = reactionUnitValidator;
    }

    public final ViewType m1489a() {
        return f1356a;
    }
}
