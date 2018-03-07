package com.facebook.reaction.feed.unitcomponents.subpart;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.events.mutators.EventsSuggestionMutator;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.graphql.enums.GraphQLReactionStoryActionStyle;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.MultiRowPartWithIsNeeded;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.multirow.parts.HighlightViewOnTouchListenerPartDefinition;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.reaction.action.ReactionActionHandler;
import com.facebook.reaction.action.ReactionActionIconMapper;
import com.facebook.reaction.analytics.ReactionAnalytics.UnitInteractionType;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionInteractionTracker;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.feed.persistentstate.ReactionHScrollComponentKey;
import com.facebook.reaction.feed.persistentstate.ReactionHScrollComponentPersistentState;
import com.facebook.reaction.feed.unitcomponents.subpart.ReactionSingleActionSelectorPartDefinition.Props;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLInterfaces.ReactionStoryAttachmentActionCommonFragment;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionStoryAttachmentActionFragmentModel;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: [See More]  */
public class ReactionHideEventActionPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasInvalidate & HasPersistentState & HasReactionInteractionTracker & HasReactionSession> extends BaseSinglePartDefinition<Props, Void, E, View> implements MultiRowPartWithIsNeeded<Props, E> {
    private static ReactionHideEventActionPartDefinition f20609h;
    private static final Object f20610i = new Object();
    private final ReactionActionHandler f20611a;
    private final ReactionActionIconMapper f20612b;
    private final ClickListenerPartDefinition f20613c;
    private final ReactionDrawableIconPartDefinition f20614d;
    public final EventsSuggestionMutator f20615e;
    private final HighlightViewOnTouchListenerPartDefinition f20616f;
    private final TextPartDefinition f20617g;

    private static ReactionHideEventActionPartDefinition m24318b(InjectorLike injectorLike) {
        return new ReactionHideEventActionPartDefinition(ReactionActionHandler.m22673a(injectorLike), ReactionActionIconMapper.m22679a(injectorLike), ClickListenerPartDefinition.a(injectorLike), ReactionDrawableIconPartDefinition.m24306a(injectorLike), EventsSuggestionMutator.b(injectorLike), HighlightViewOnTouchListenerPartDefinition.a(injectorLike), TextPartDefinition.a(injectorLike));
    }

    public final Object m24319a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final Props props = (Props) obj;
        final CanLaunchReactionIntent canLaunchReactionIntent = (CanLaunchReactionIntent) anyEnvironment;
        subParts.a(2131566665, this.f20614d, new ReactionDrawableIconPartDefinition.Props(this.f20612b.m22681a(props.f20670a.j())));
        subParts.a(2131566666, this.f20617g, props.f20670a.fU_().a());
        subParts.a(this.f20613c, new OnClickListener(this) {
            final /* synthetic */ ReactionHideEventActionPartDefinition f20608c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -573037335);
                ReactionHScrollComponentPersistentState reactionHScrollComponentPersistentState = (ReactionHScrollComponentPersistentState) ((HasPersistentState) canLaunchReactionIntent).a(new ReactionHScrollComponentKey(props.f20671b.f18863c), props.f20671b);
                reactionHScrollComponentPersistentState.m23190a(props.f20671b.f18862b.U());
                ((HasReactionInteractionTracker) canLaunchReactionIntent).kE_().mo984a(props.f20671b.f18863c, props.f20671b.f18864d, null, UnitInteractionType.HIDE_EVENT_SUGGESTION_TAP);
                this.f20608c.f20615e.a(props.f20670a.M().eL_(), "MOBILE_TODAY_TAB");
                Object obj = 1;
                if (reactionHScrollComponentPersistentState.f19175e > 1 || reactionHScrollComponentPersistentState.f19171a == null) {
                    obj = null;
                }
                if (obj != null) {
                    ReactionHideEventActionPartDefinition.m24317a(this.f20608c, reactionHScrollComponentPersistentState.f19171a, canLaunchReactionIntent, props.f20671b);
                }
                ((HasInvalidate) canLaunchReactionIntent).hL_();
                Logger.a(2, EntryType.UI_INPUT_END, -75702176, a);
            }
        });
        subParts.a(this.f20616f, null);
        return null;
    }

    public final boolean m24320a(Object obj) {
        Props props = (Props) obj;
        return (props.f20670a.j() != GraphQLReactionStoryActionStyle.HIDE_EVENT_SUGGESTION || Strings.isNullOrEmpty(props.f20671b.f18862b.U()) || props.f20670a.M() == null || Strings.isNullOrEmpty(props.f20670a.M().eL_()) || props.f20670a.fU_() == null || Strings.isNullOrEmpty(props.f20670a.fU_().a())) ? false : true;
    }

    public static ReactionHideEventActionPartDefinition m24316a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionHideEventActionPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20610i) {
                ReactionHideEventActionPartDefinition reactionHideEventActionPartDefinition;
                if (a2 != null) {
                    reactionHideEventActionPartDefinition = (ReactionHideEventActionPartDefinition) a2.a(f20610i);
                } else {
                    reactionHideEventActionPartDefinition = f20609h;
                }
                if (reactionHideEventActionPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m24318b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20610i, b3);
                        } else {
                            f20609h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionHideEventActionPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public ReactionHideEventActionPartDefinition(ReactionActionHandler reactionActionHandler, ReactionActionIconMapper reactionActionIconMapper, ClickListenerPartDefinition clickListenerPartDefinition, ReactionDrawableIconPartDefinition reactionDrawableIconPartDefinition, EventsSuggestionMutator eventsSuggestionMutator, HighlightViewOnTouchListenerPartDefinition highlightViewOnTouchListenerPartDefinition, TextPartDefinition textPartDefinition) {
        this.f20611a = reactionActionHandler;
        this.f20612b = reactionActionIconMapper;
        this.f20613c = clickListenerPartDefinition;
        this.f20614d = reactionDrawableIconPartDefinition;
        this.f20615e = eventsSuggestionMutator;
        this.f20616f = highlightViewOnTouchListenerPartDefinition;
        this.f20617g = textPartDefinition;
    }

    public static void m24317a(ReactionHideEventActionPartDefinition reactionHideEventActionPartDefinition, ReactionStoryAttachmentActionFragmentModel reactionStoryAttachmentActionFragmentModel, CanLaunchReactionIntent canLaunchReactionIntent, ReactionUnitComponentNode reactionUnitComponentNode) {
        canLaunchReactionIntent.mo695a(reactionUnitComponentNode.f18863c, reactionUnitComponentNode.f18864d, reactionHideEventActionPartDefinition.f20611a.m22678a((ReactionStoryAttachmentActionCommonFragment) reactionStoryAttachmentActionFragmentModel, ((HasContext) canLaunchReactionIntent).getContext(), null, ((HasReactionSession) canLaunchReactionIntent).mo704p().f18658a, ((HasReactionSession) canLaunchReactionIntent).mo704p().f18660c, reactionUnitComponentNode.f18863c, reactionUnitComponentNode.f18861a, reactionUnitComponentNode.f18864d));
    }
}
