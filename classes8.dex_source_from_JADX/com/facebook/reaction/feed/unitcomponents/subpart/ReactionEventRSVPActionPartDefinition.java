package com.facebook.reaction.feed.unitcomponents.subpart;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.executors.Handler_ForUiThreadMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.events.model.Event;
import com.facebook.events.mutators.PrivateEventsRsvpMutator;
import com.facebook.events.mutators.PublicEventsRsvpMutator;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import com.facebook.graphql.enums.GraphQLEventWatchStatus;
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
import com.facebook.multirow.parts.TextAppearancePartDefinition;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.reaction.analytics.ReactionAnalytics.UnitInteractionType;
import com.facebook.reaction.feed.environment.HasReactionAnalyticsParams;
import com.facebook.reaction.feed.environment.HasReactionInteractionTracker;
import com.facebook.reaction.feed.persistentstate.ReactionActionListHighlightComponentKey;
import com.facebook.reaction.feed.persistentstate.ReactionActionListHighlightPersistentState;
import com.facebook.reaction.feed.unitcomponents.subpart.ReactionSingleActionSelectorPartDefinition.Props;
import com.facebook.today.common.HasNotifications;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: [[REVIEW_LENGTH]] */
public class ReactionEventRSVPActionPartDefinition<E extends HasInvalidate & HasNotifications & HasPersistentState & HasReactionAnalyticsParams & HasReactionInteractionTracker> extends BaseSinglePartDefinition<Props, Void, E, View> implements MultiRowPartWithIsNeeded<Props, E> {
    private static ReactionEventRSVPActionPartDefinition f20596i;
    private static final Object f20597j = new Object();
    private final ClickListenerPartDefinition f20598a;
    private final ReactionDrawableIconPartDefinition f20599b;
    private final Handler f20600c;
    private final HighlightViewOnTouchListenerPartDefinition f20601d;
    public final PrivateEventsRsvpMutator f20602e;
    public final PublicEventsRsvpMutator f20603f;
    private final TextAppearancePartDefinition f20604g;
    private final TextPartDefinition f20605h;

    /* compiled from: [[REVIEW_LENGTH]] */
    /* synthetic */ class C21854 {
        static final /* synthetic */ int[] f20595a = new int[GraphQLReactionStoryActionStyle.values().length];

        static {
            try {
                f20595a[GraphQLReactionStoryActionStyle.GOING_TO_EVENT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f20595a[GraphQLReactionStoryActionStyle.MAYBE_GOING_TO_EVENT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f20595a[GraphQLReactionStoryActionStyle.NOT_GOING_TO_EVENT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    private static ReactionEventRSVPActionPartDefinition m24313b(InjectorLike injectorLike) {
        return new ReactionEventRSVPActionPartDefinition(Handler_ForUiThreadMethodAutoProvider.b(injectorLike), ClickListenerPartDefinition.a(injectorLike), ReactionDrawableIconPartDefinition.m24306a(injectorLike), HighlightViewOnTouchListenerPartDefinition.a(injectorLike), PrivateEventsRsvpMutator.b(injectorLike), PublicEventsRsvpMutator.b(injectorLike), TextAppearancePartDefinition.a(injectorLike), TextPartDefinition.a(injectorLike));
    }

    public final Object m24314a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        HasInvalidate hasInvalidate = (HasInvalidate) anyEnvironment;
        subParts.a(this.f20598a, m24308a(props, hasInvalidate));
        subParts.a(2131566666, this.f20605h, props.f20670a.fU_().a());
        subParts.a(this.f20601d, null);
        subParts.a(2131566665, this.f20599b, new ReactionDrawableIconPartDefinition.Props(null));
        ReactionActionListHighlightPersistentState reactionActionListHighlightPersistentState = (ReactionActionListHighlightPersistentState) ((HasPersistentState) hasInvalidate).a(new ReactionActionListHighlightComponentKey(props.f20671b.f18863c), props.f20671b);
        if (reactionActionListHighlightPersistentState.f19154a != null) {
            subParts.a(2131566666, this.f20604g, Integer.valueOf(reactionActionListHighlightPersistentState.f19154a.equals(String.valueOf(props.f20670a.hashCode())) ? 2131625817 : 2131625818));
        }
        return null;
    }

    public final boolean m24315a(Object obj) {
        Props props = (Props) obj;
        return ((props.f20670a.j() != GraphQLReactionStoryActionStyle.GOING_TO_EVENT && props.f20670a.j() != GraphQLReactionStoryActionStyle.MAYBE_GOING_TO_EVENT && props.f20670a.j() != GraphQLReactionStoryActionStyle.NOT_GOING_TO_EVENT) || props.f20670a.M() == null || Strings.isNullOrEmpty(props.f20670a.M().eL_()) || props.f20670a.M().p() == null || props.f20670a.fU_() == null || Strings.isNullOrEmpty(props.f20670a.fU_().a())) ? false : true;
    }

    public static ReactionEventRSVPActionPartDefinition m24310a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionEventRSVPActionPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20597j) {
                ReactionEventRSVPActionPartDefinition reactionEventRSVPActionPartDefinition;
                if (a2 != null) {
                    reactionEventRSVPActionPartDefinition = (ReactionEventRSVPActionPartDefinition) a2.a(f20597j);
                } else {
                    reactionEventRSVPActionPartDefinition = f20596i;
                }
                if (reactionEventRSVPActionPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m24313b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20597j, b3);
                        } else {
                            f20596i = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionEventRSVPActionPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public ReactionEventRSVPActionPartDefinition(Handler handler, ClickListenerPartDefinition clickListenerPartDefinition, ReactionDrawableIconPartDefinition reactionDrawableIconPartDefinition, HighlightViewOnTouchListenerPartDefinition highlightViewOnTouchListenerPartDefinition, PrivateEventsRsvpMutator privateEventsRsvpMutator, PublicEventsRsvpMutator publicEventsRsvpMutator, TextAppearancePartDefinition textAppearancePartDefinition, TextPartDefinition textPartDefinition) {
        this.f20600c = handler;
        this.f20598a = clickListenerPartDefinition;
        this.f20599b = reactionDrawableIconPartDefinition;
        this.f20601d = highlightViewOnTouchListenerPartDefinition;
        this.f20602e = privateEventsRsvpMutator;
        this.f20603f = publicEventsRsvpMutator;
        this.f20604g = textAppearancePartDefinition;
        this.f20605h = textPartDefinition;
    }

    private OnClickListener m24308a(Props props, E e) {
        String str;
        String str2 = ((HasReactionAnalyticsParams) e).mo706r() == null ? "unknown" : ((HasReactionAnalyticsParams) e).mo706r().f18809a;
        String str3 = ((HasReactionAnalyticsParams) e).mo706r() == null ? "unknown" : ((HasReactionAnalyticsParams) e).mo706r().f18810b;
        if (((HasReactionAnalyticsParams) e).mo706r() == null) {
            str = "unknown";
        } else {
            str = ((HasReactionAnalyticsParams) e).mo706r().f18811c;
        }
        if (Event.a(props.f20670a.M().p())) {
            return m24309a(props, e, str2, str3, str);
        }
        return m24312b(props, e, str2, str3, str);
    }

    private OnClickListener m24309a(Props props, E e, String str, String str2, String str3) {
        GraphQLEventGuestStatus graphQLEventGuestStatus;
        UnitInteractionType unitInteractionType = null;
        switch (C21854.f20595a[props.f20670a.j().ordinal()]) {
            case 1:
                graphQLEventGuestStatus = GraphQLEventGuestStatus.GOING;
                unitInteractionType = UnitInteractionType.EVENT_CARD_GOING_TAP;
                break;
            case 2:
                graphQLEventGuestStatus = GraphQLEventGuestStatus.MAYBE;
                unitInteractionType = UnitInteractionType.EVENT_CARD_MAYBE_TAP;
                break;
            case 3:
                graphQLEventGuestStatus = GraphQLEventGuestStatus.NOT_GOING;
                unitInteractionType = UnitInteractionType.EVENT_CARD_NOT_GOING_TAP;
                break;
            default:
                graphQLEventGuestStatus = null;
                break;
        }
        final Props props2 = props;
        final String str4 = str;
        final String str5 = str2;
        final String str6 = str3;
        final E e2 = e;
        return new OnClickListener(this) {
            final /* synthetic */ ReactionEventRSVPActionPartDefinition f20582h;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -260552986);
                this.f20582h.f20602e.a(props2.f20670a.M().eL_(), graphQLEventGuestStatus, str4, str5, str6, props2.f20671b.f18864d);
                ReactionEventRSVPActionPartDefinition.m24311a(this.f20582h, props2, e2, unitInteractionType);
                Logger.a(2, EntryType.UI_INPUT_END, 1842132064, a);
            }
        };
    }

    private OnClickListener m24312b(Props props, E e, String str, String str2, String str3) {
        GraphQLEventWatchStatus graphQLEventWatchStatus;
        UnitInteractionType unitInteractionType = null;
        switch (C21854.f20595a[props.f20670a.j().ordinal()]) {
            case 1:
                graphQLEventWatchStatus = GraphQLEventWatchStatus.GOING;
                unitInteractionType = UnitInteractionType.EVENT_CARD_GOING_TAP;
                break;
            case 2:
                graphQLEventWatchStatus = GraphQLEventWatchStatus.WATCHED;
                unitInteractionType = UnitInteractionType.EVENT_CARD_INTERESTED_TAP;
                break;
            case 3:
                graphQLEventWatchStatus = GraphQLEventWatchStatus.UNWATCHED;
                unitInteractionType = UnitInteractionType.EVENT_CARD_UNWATCHED_TAP;
                break;
            default:
                graphQLEventWatchStatus = null;
                break;
        }
        final Props props2 = props;
        final String str4 = str;
        final String str5 = str2;
        final String str6 = str3;
        final E e2 = e;
        return new OnClickListener(this) {
            final /* synthetic */ ReactionEventRSVPActionPartDefinition f20590h;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1293644175);
                this.f20590h.f20603f.a(props2.f20670a.M().eL_(), graphQLEventWatchStatus, str4, str5, str6, props2.f20671b.f18864d);
                ReactionEventRSVPActionPartDefinition.m24311a(this.f20590h, props2, e2, unitInteractionType);
                Logger.a(2, EntryType.UI_INPUT_END, 1932397713, a);
            }
        };
    }

    public static void m24311a(ReactionEventRSVPActionPartDefinition reactionEventRSVPActionPartDefinition, Props props, final HasInvalidate hasInvalidate, UnitInteractionType unitInteractionType) {
        final String str = props.f20671b.f18863c;
        final FeedProps c = FeedProps.c(props.f20671b);
        ReactionActionListHighlightPersistentState reactionActionListHighlightPersistentState = (ReactionActionListHighlightPersistentState) ((HasPersistentState) hasInvalidate).a(new ReactionActionListHighlightComponentKey(str), props.f20671b);
        if (reactionActionListHighlightPersistentState.f19154a == null) {
            HandlerDetour.b(reactionEventRSVPActionPartDefinition.f20600c, new Runnable(reactionEventRSVPActionPartDefinition) {
                final /* synthetic */ ReactionEventRSVPActionPartDefinition f20594d;

                public void run() {
                    if (((HasNotifications) hasInvalidate).mo977a(str, true)) {
                        hasInvalidate.a(new FeedProps[]{c});
                    }
                }
            }, 2000, 1514329658);
        }
        reactionActionListHighlightPersistentState.f19154a = String.valueOf(props.f20670a.hashCode());
        hasInvalidate.a(new FeedProps[]{c});
        ((HasNotifications) hasInvalidate).mo978b(props.f20671b.f18863c);
        ((HasReactionInteractionTracker) hasInvalidate).kE_().mo984a(props.f20671b.f18863c, props.f20671b.f18864d, null, unitInteractionType);
    }
}
