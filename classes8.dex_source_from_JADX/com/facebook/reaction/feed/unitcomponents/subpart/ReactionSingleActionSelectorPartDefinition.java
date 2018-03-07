package com.facebook.reaction.feed.unitcomponents.subpart;

import android.content.Context;
import android.widget.LinearLayout;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.graphql.enums.GraphQLReactionStoryActionStyle;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.MultiRowPartWithIsNeeded;
import com.facebook.multirow.api.SinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionAnalyticsParams;
import com.facebook.reaction.feed.environment.HasReactionInteractionTracker;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionStoryAttachmentActionFragmentModel;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;

@ContextScoped
/* compiled from: ZeroRatingCancel */
public class ReactionSingleActionSelectorPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasInvalidate & HasPersistentState & HasReactionAnalyticsParams & HasReactionInteractionTracker & HasReactionSession & HasPrefetcher & HasRowKey> extends BaseSinglePartDefinition<Props, Void, E, LinearLayout> implements MultiRowPartWithIsNeeded<Props, E> {
    private static ReactionSingleActionSelectorPartDefinition f20672k;
    private static final Object f20673l = new Object();
    public final Map<GraphQLReactionStoryActionStyle, SinglePartDefinition> f20674a = new HashMap();
    private final AbstractFbErrorReporter f20675b;
    public final ReactionEventRSVPActionPartDefinition f20676c;
    public final ReactionHideEventActionPartDefinition<E> f20677d;
    public final ReactionHideRichNotifActionPartDefinition f20678e;
    public final ReactionJoinEventActionPartDefinition<E> f20679f;
    public final ReactionActionListOpenBottomMenuPartDefinition<E> f20680g;
    public final ReactionActionListSaveActionPartDefinition<E> f20681h;
    public final ReactionActionListSaveOgObjectActionPartDefinition<E> f20682i;
    private final ReactionActionListSingleActionPartDefinition<E> f20683j;

    /* compiled from: ZeroRatingCancel */
    public class Props {
        public final ReactionStoryAttachmentActionFragmentModel f20670a;
        public final ReactionUnitComponentNode f20671b;

        public Props(ReactionStoryAttachmentActionFragmentModel reactionStoryAttachmentActionFragmentModel, ReactionUnitComponentNode reactionUnitComponentNode) {
            this.f20670a = reactionStoryAttachmentActionFragmentModel;
            this.f20671b = reactionUnitComponentNode;
        }
    }

    private static ReactionSingleActionSelectorPartDefinition m24352b(InjectorLike injectorLike) {
        return new ReactionSingleActionSelectorPartDefinition((AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), ReactionEventRSVPActionPartDefinition.m24310a(injectorLike), ReactionHideEventActionPartDefinition.m24316a(injectorLike), ReactionHideRichNotifActionPartDefinition.m24321a(injectorLike), ReactionJoinEventActionPartDefinition.m24332a(injectorLike), ReactionActionListOpenBottomMenuPartDefinition.m24269a(injectorLike), ReactionActionListSaveActionPartDefinition.m24275a(injectorLike), ReactionActionListSaveOgObjectActionPartDefinition.m24287a(injectorLike), ReactionActionListSingleActionPartDefinition.m24291a(injectorLike));
    }

    public final Object m24353a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        subParts.a(m24350a(props.f20670a.j()), props);
        return null;
    }

    public static ReactionSingleActionSelectorPartDefinition m24351a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionSingleActionSelectorPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20673l) {
                ReactionSingleActionSelectorPartDefinition reactionSingleActionSelectorPartDefinition;
                if (a2 != null) {
                    reactionSingleActionSelectorPartDefinition = (ReactionSingleActionSelectorPartDefinition) a2.a(f20673l);
                } else {
                    reactionSingleActionSelectorPartDefinition = f20672k;
                }
                if (reactionSingleActionSelectorPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m24352b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20673l, b3);
                        } else {
                            f20672k = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionSingleActionSelectorPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public ReactionSingleActionSelectorPartDefinition(AbstractFbErrorReporter abstractFbErrorReporter, ReactionEventRSVPActionPartDefinition reactionEventRSVPActionPartDefinition, ReactionHideEventActionPartDefinition reactionHideEventActionPartDefinition, ReactionHideRichNotifActionPartDefinition reactionHideRichNotifActionPartDefinition, ReactionJoinEventActionPartDefinition reactionJoinEventActionPartDefinition, ReactionActionListOpenBottomMenuPartDefinition reactionActionListOpenBottomMenuPartDefinition, ReactionActionListSaveActionPartDefinition reactionActionListSaveActionPartDefinition, ReactionActionListSaveOgObjectActionPartDefinition reactionActionListSaveOgObjectActionPartDefinition, ReactionActionListSingleActionPartDefinition reactionActionListSingleActionPartDefinition) {
        this.f20675b = abstractFbErrorReporter;
        this.f20676c = reactionEventRSVPActionPartDefinition;
        this.f20677d = reactionHideEventActionPartDefinition;
        this.f20678e = reactionHideRichNotifActionPartDefinition;
        this.f20679f = reactionJoinEventActionPartDefinition;
        this.f20680g = reactionActionListOpenBottomMenuPartDefinition;
        this.f20681h = reactionActionListSaveActionPartDefinition;
        this.f20682i = reactionActionListSaveOgObjectActionPartDefinition;
        this.f20683j = reactionActionListSingleActionPartDefinition;
        this.f20674a.put(GraphQLReactionStoryActionStyle.GOING_TO_EVENT, this.f20676c);
        this.f20674a.put(GraphQLReactionStoryActionStyle.HIDE_EVENT_SUGGESTION, this.f20677d);
        this.f20674a.put(GraphQLReactionStoryActionStyle.UNHIGHLIGHT_RICH_NOTIF, this.f20678e);
        this.f20674a.put(GraphQLReactionStoryActionStyle.JOIN_EVENT, this.f20679f);
        this.f20674a.put(GraphQLReactionStoryActionStyle.MAYBE_GOING_TO_EVENT, this.f20676c);
        this.f20674a.put(GraphQLReactionStoryActionStyle.NOT_GOING_TO_EVENT, this.f20676c);
        this.f20674a.put(GraphQLReactionStoryActionStyle.OPEN_VERTICAL_ACTION_SHEET, this.f20680g);
        this.f20674a.put(GraphQLReactionStoryActionStyle.SAVE_OG_OBJECT, this.f20682i);
        this.f20674a.put(GraphQLReactionStoryActionStyle.SAVE_PAGE, this.f20681h);
    }

    public final boolean m24354a(Props props) {
        SinglePartDefinition a = m24350a(props.f20670a.j());
        if (a instanceof MultiRowPartWithIsNeeded) {
            return ((MultiRowPartWithIsNeeded) a).a(props);
        }
        this.f20675b.b(getClass().getSimpleName(), "Action subpart does not implement MultiRowPartWithIsNeeded");
        return false;
    }

    private SinglePartDefinition m24350a(GraphQLReactionStoryActionStyle graphQLReactionStoryActionStyle) {
        if (this.f20674a.containsKey(graphQLReactionStoryActionStyle)) {
            return (SinglePartDefinition) this.f20674a.get(graphQLReactionStoryActionStyle);
        }
        return this.f20683j;
    }
}
