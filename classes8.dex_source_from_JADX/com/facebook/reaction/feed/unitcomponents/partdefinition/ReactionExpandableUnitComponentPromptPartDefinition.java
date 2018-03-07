package com.facebook.reaction.feed.unitcomponents.partdefinition;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.MultiRowPartWithIsNeeded;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.api.renderers.SimpleRenderer;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.multirow.parts.HighlightViewOnTouchListenerPartDefinition;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.reaction.analytics.ReactionAnalytics.UnitInteractionType;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.common.ReactionUnitComponentStyleMapper;
import com.facebook.reaction.common.ReactionUnitComponentUtil;
import com.facebook.reaction.feed.environment.HasReactionInteractionTracker;
import com.facebook.reaction.feed.persistentstate.ReactionExpandableComponentKey;
import com.facebook.reaction.feed.persistentstate.ReactionExpandableComponentPersistentState;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitComponentModel;
import com.google.common.base.Strings;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: aldrin_status_last_fetch_success_time */
public class ReactionExpandableUnitComponentPromptPartDefinition<E extends HasContext & HasInvalidate & HasPersistentState & HasReactionInteractionTracker> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, State, E, RelativeLayout> {
    public static final ViewType f19661a = ViewType.a(2130906638);
    private static ReactionExpandableUnitComponentPromptPartDefinition f19662g;
    private static final Object f19663h = new Object();
    private final AllCapsTransformationMethod f19664b;
    private final ClickListenerPartDefinition f19665c;
    private final HighlightViewOnTouchListenerPartDefinition f19666d;
    private final TextPartDefinition f19667e;
    private final ReactionUnitComponentStyleMapper f19668f;

    /* compiled from: aldrin_status_last_fetch_success_time */
    public class State {
        public final SimpleRenderer f19659a;
        public final ViewType f19660b;

        public State(SimpleRenderer simpleRenderer, ViewType viewType) {
            this.f19659a = simpleRenderer;
            this.f19660b = viewType;
        }
    }

    private static ReactionExpandableUnitComponentPromptPartDefinition m23584b(InjectorLike injectorLike) {
        return new ReactionExpandableUnitComponentPromptPartDefinition(AllCapsTransformationMethod.b(injectorLike), ClickListenerPartDefinition.a(injectorLike), HighlightViewOnTouchListenerPartDefinition.a(injectorLike), TextPartDefinition.a(injectorLike), ReactionUnitComponentStyleMapper.m22890a(injectorLike));
    }

    @Nullable
    public final Object m23586a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        final HasContext hasContext = (HasContext) anyEnvironment;
        C21261 c21261 = new OnClickListener(this) {
            final /* synthetic */ ReactionExpandableUnitComponentPromptPartDefinition f19658c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1949423057);
                ((ReactionExpandableComponentPersistentState) ((HasPersistentState) hasContext).a(new ReactionExpandableComponentKey(reactionUnitComponentNode.f18863c), reactionUnitComponentNode)).f19167a = true;
                ((HasReactionInteractionTracker) hasContext).kE_().mo984a(reactionUnitComponentNode.f18863c, reactionUnitComponentNode.f18864d, null, UnitInteractionType.INLINE_EXPANSION_TAP);
                ((HasInvalidate) hasContext).hL_();
                Logger.a(2, EntryType.UI_INPUT_END, 1625392901, a);
            }
        };
        CharSequence transformation = this.f19664b.getTransformation(((ReactionUnitComponentModel) reactionUnitComponentNode.f18862b).dl().a(), null);
        subParts.a(2131566668, this.f19665c, c21261);
        subParts.a(2131566668, this.f19666d, null);
        subParts.a(2131566668, this.f19667e, transformation);
        ReactionUnitComponentNode a = ReactionUnitComponentUtil.m22895a(reactionUnitComponentNode);
        MultiRowPartWithIsNeeded a2 = this.f19668f.m22892a(a.f18862b.a());
        if (!(a2 instanceof MultiRowSinglePartDefinition)) {
            return null;
        }
        MultiRowSinglePartDefinition multiRowSinglePartDefinition = (MultiRowSinglePartDefinition) a2;
        SimpleRenderer simpleRenderer = new SimpleRenderer(multiRowSinglePartDefinition, hasContext);
        simpleRenderer.a(a);
        return new State(simpleRenderer, multiRowSinglePartDefinition.a());
    }

    public final /* bridge */ /* synthetic */ void m23587a(Object obj, @Nullable Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1927240265);
        State state = (State) obj2;
        HasContext hasContext = (HasContext) anyEnvironment;
        RelativeLayout relativeLayout = (RelativeLayout) view;
        if (state != null) {
            View a2 = state.f19660b.a(hasContext.getContext());
            state.f19659a.a(a2);
            relativeLayout.addView(a2, 0, new LayoutParams(-1, -2));
        }
        Logger.a(8, EntryType.MARK_POP, 813970487, a);
    }

    public final boolean m23588a(Object obj) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        ReactionUnitComponentFields reactionUnitComponentFields = reactionUnitComponentNode.f18862b;
        if (!(reactionUnitComponentFields instanceof ReactionUnitComponentModel)) {
            return false;
        }
        ReactionUnitComponentModel reactionUnitComponentModel = (ReactionUnitComponentModel) reactionUnitComponentFields;
        return (reactionUnitComponentModel.dl() == null || Strings.isNullOrEmpty(reactionUnitComponentModel.dl().a()) || ReactionUnitComponentUtil.m22895a(reactionUnitComponentNode) == null) ? false : true;
    }

    public final void m23589b(Object obj, @Nullable Object obj2, AnyEnvironment anyEnvironment, View view) {
        RelativeLayout relativeLayout = (RelativeLayout) view;
        if (((State) obj2) != null) {
            relativeLayout.removeViewAt(0);
        }
    }

    public static ReactionExpandableUnitComponentPromptPartDefinition m23583a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionExpandableUnitComponentPromptPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19663h) {
                ReactionExpandableUnitComponentPromptPartDefinition reactionExpandableUnitComponentPromptPartDefinition;
                if (a2 != null) {
                    reactionExpandableUnitComponentPromptPartDefinition = (ReactionExpandableUnitComponentPromptPartDefinition) a2.a(f19663h);
                } else {
                    reactionExpandableUnitComponentPromptPartDefinition = f19662g;
                }
                if (reactionExpandableUnitComponentPromptPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23584b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19663h, b3);
                        } else {
                            f19662g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionExpandableUnitComponentPromptPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public ReactionExpandableUnitComponentPromptPartDefinition(AllCapsTransformationMethod allCapsTransformationMethod, ClickListenerPartDefinition clickListenerPartDefinition, HighlightViewOnTouchListenerPartDefinition highlightViewOnTouchListenerPartDefinition, TextPartDefinition textPartDefinition, ReactionUnitComponentStyleMapper reactionUnitComponentStyleMapper) {
        this.f19664b = allCapsTransformationMethod;
        this.f19665c = clickListenerPartDefinition;
        this.f19666d = highlightViewOnTouchListenerPartDefinition;
        this.f19667e = textPartDefinition;
        this.f19668f = reactionUnitComponentStyleMapper;
    }

    public final ViewType m23585a() {
        return f19661a;
    }
}
