package com.facebook.reaction.feed.unitcomponents.subpart;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.events.model.Event;
import com.facebook.events.mutators.PrivateEventsRsvpMutator;
import com.facebook.events.mutators.PublicEventsRsvpMutator;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.feed.environment.HasContext;
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
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.feed.unitcomponents.subpart.ReactionSingleActionSelectorPartDefinition.Props;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Strings;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: [0-9]* */
public class ReactionJoinEventActionPartDefinition<E extends HasContext & HasReactionAnalyticsParams & HasReactionInteractionTracker & HasReactionSession> extends BaseSinglePartDefinition<Props, Void, E, LinearLayout> implements MultiRowPartWithIsNeeded<Props, E> {
    private static ReactionJoinEventActionPartDefinition f20646j;
    private static final Object f20647k = new Object();
    private final ClickListenerPartDefinition f20648a;
    private final GlyphColorizer f20649b;
    private final HighlightViewOnTouchListenerPartDefinition f20650c;
    public final PrivateEventsRsvpMutator f20651d;
    public final PublicEventsRsvpMutator f20652e;
    private final ReactionDrawableIconPartDefinition f20653f;
    public final TasksManager f20654g;
    private final TextAppearancePartDefinition f20655h;
    private final TextPartDefinition f20656i;

    private static ReactionJoinEventActionPartDefinition m24334b(InjectorLike injectorLike) {
        return new ReactionJoinEventActionPartDefinition(ClickListenerPartDefinition.a(injectorLike), GlyphColorizer.a(injectorLike), HighlightViewOnTouchListenerPartDefinition.a(injectorLike), PrivateEventsRsvpMutator.b(injectorLike), PublicEventsRsvpMutator.b(injectorLike), ReactionDrawableIconPartDefinition.m24306a(injectorLike), TasksManager.b(injectorLike), TextAppearancePartDefinition.a(injectorLike), TextPartDefinition.a(injectorLike));
    }

    public final Object m24339a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        String str;
        Props props = (Props) obj;
        HasContext hasContext = (HasContext) anyEnvironment;
        final boolean a = Event.a(props.f20670a.M().o());
        final GraphQLEventGuestStatus q = props.f20670a.M().q();
        final GraphQLEventWatchStatus t = props.f20670a.M().t();
        final String str2 = ((HasReactionAnalyticsParams) hasContext).mo706r() == null ? "unknown" : ((HasReactionAnalyticsParams) hasContext).mo706r().f18809a;
        final String str3 = ((HasReactionAnalyticsParams) hasContext).mo706r() == null ? "unknown" : ((HasReactionAnalyticsParams) hasContext).mo706r().f18810b;
        if (((HasReactionAnalyticsParams) hasContext).mo706r() == null) {
            str = "unknown";
        } else {
            str = ((HasReactionAnalyticsParams) hasContext).mo706r().f18811c;
        }
        final Props props2 = props;
        final HasContext hasContext2 = hasContext;
        subParts.a(this.f20648a, new OnClickListener(this) {
            final /* synthetic */ ReactionJoinEventActionPartDefinition f20645i;

            /* compiled from: [0-9]* */
            class C21891 extends AbstractDisposableFutureCallback {
                final /* synthetic */ C21901 f20636a;

                C21891(C21901 c21901) {
                    this.f20636a = c21901;
                }

                protected final void m24329a(Object obj) {
                }

                protected final void m24330a(Throwable th) {
                }
            }

            public void onClick(View view) {
                ListenableFuture a;
                int a2 = Logger.a(2, EntryType.UI_INPUT_START, 1443588243);
                String eL_;
                if (a) {
                    GraphQLEventGuestStatus graphQLEventGuestStatus;
                    PrivateEventsRsvpMutator privateEventsRsvpMutator = this.f20645i.f20651d;
                    eL_ = props2.f20670a.M().eL_();
                    GraphQLEventGuestStatus graphQLEventGuestStatus2 = q;
                    if (graphQLEventGuestStatus2 == GraphQLEventGuestStatus.GOING || graphQLEventGuestStatus2 == GraphQLEventGuestStatus.MAYBE) {
                        graphQLEventGuestStatus = GraphQLEventGuestStatus.NOT_GOING;
                    } else {
                        graphQLEventGuestStatus = GraphQLEventGuestStatus.GOING;
                    }
                    a = privateEventsRsvpMutator.a(eL_, graphQLEventGuestStatus, str2, str3, str, props2.f20671b.f18864d);
                } else {
                    GraphQLEventWatchStatus graphQLEventWatchStatus;
                    PublicEventsRsvpMutator publicEventsRsvpMutator = this.f20645i.f20652e;
                    eL_ = props2.f20670a.M().eL_();
                    GraphQLEventWatchStatus graphQLEventWatchStatus2 = t;
                    if (graphQLEventWatchStatus2 == GraphQLEventWatchStatus.GOING || graphQLEventWatchStatus2 == GraphQLEventWatchStatus.WATCHED) {
                        graphQLEventWatchStatus = GraphQLEventWatchStatus.UNWATCHED;
                    } else {
                        graphQLEventWatchStatus = GraphQLEventWatchStatus.WATCHED;
                    }
                    a = publicEventsRsvpMutator.a(eL_, graphQLEventWatchStatus, str2, str3, str, props2.f20671b.f18864d);
                }
                if (a != null) {
                    this.f20645i.f20654g.a(this, a, new C21891(this));
                }
                ((HasReactionInteractionTracker) hasContext2).kE_().mo984a(props2.f20671b.f18863c, props2.f20671b.f18864d, null, UnitInteractionType.JOIN_EVENT_TAP);
                LogUtils.a(-357361385, a2);
            }
        });
        subParts.a(2131566665, this.f20653f, new ReactionDrawableIconPartDefinition.Props(a ? m24336c(q) : m24337c(t)));
        subParts.a(2131566666, this.f20655h, Integer.valueOf(m24335b(a, q, t) ? 2131625819 : 2131625820));
        Context context = hasContext.getContext();
        int i = a ? m24338d(q) ? 2131233837 : q == GraphQLEventGuestStatus.MAYBE ? 2131233838 : q == GraphQLEventGuestStatus.NOT_GOING ? 2131233839 : 2131233841 : t == GraphQLEventWatchStatus.GOING ? 2131233837 : 2131233840;
        subParts.a(2131566666, this.f20656i, context.getString(i));
        subParts.a(this.f20650c, null);
        return null;
    }

    public final boolean m24340a(Object obj) {
        Props props = (Props) obj;
        return (props.f20670a.j() != GraphQLReactionStoryActionStyle.JOIN_EVENT || props.f20670a.M() == null || Strings.isNullOrEmpty(props.f20670a.M().eL_())) ? false : true;
    }

    public static ReactionJoinEventActionPartDefinition m24332a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionJoinEventActionPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20647k) {
                ReactionJoinEventActionPartDefinition reactionJoinEventActionPartDefinition;
                if (a2 != null) {
                    reactionJoinEventActionPartDefinition = (ReactionJoinEventActionPartDefinition) a2.a(f20647k);
                } else {
                    reactionJoinEventActionPartDefinition = f20646j;
                }
                if (reactionJoinEventActionPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m24334b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20647k, b3);
                        } else {
                            f20646j = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionJoinEventActionPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public ReactionJoinEventActionPartDefinition(ClickListenerPartDefinition clickListenerPartDefinition, GlyphColorizer glyphColorizer, HighlightViewOnTouchListenerPartDefinition highlightViewOnTouchListenerPartDefinition, PrivateEventsRsvpMutator privateEventsRsvpMutator, PublicEventsRsvpMutator publicEventsRsvpMutator, ReactionDrawableIconPartDefinition reactionDrawableIconPartDefinition, TasksManager tasksManager, TextAppearancePartDefinition textAppearancePartDefinition, TextPartDefinition textPartDefinition) {
        this.f20648a = clickListenerPartDefinition;
        this.f20653f = reactionDrawableIconPartDefinition;
        this.f20649b = glyphColorizer;
        this.f20650c = highlightViewOnTouchListenerPartDefinition;
        this.f20651d = privateEventsRsvpMutator;
        this.f20652e = publicEventsRsvpMutator;
        this.f20654g = tasksManager;
        this.f20655h = textAppearancePartDefinition;
        this.f20656i = textPartDefinition;
    }

    private Drawable m24337c(@Nullable GraphQLEventWatchStatus graphQLEventWatchStatus) {
        if (graphQLEventWatchStatus == GraphQLEventWatchStatus.GOING) {
            return m24331a(2130839774);
        }
        if (graphQLEventWatchStatus == GraphQLEventWatchStatus.WATCHED) {
            return m24331a(2130839850);
        }
        return m24333b(2130839850);
    }

    private Drawable m24336c(@Nullable GraphQLEventGuestStatus graphQLEventGuestStatus) {
        if (m24338d(graphQLEventGuestStatus)) {
            return m24331a(2130839774);
        }
        if (graphQLEventGuestStatus == GraphQLEventGuestStatus.MAYBE) {
            return m24331a(2130839846);
        }
        return m24333b(2130839846);
    }

    private Drawable m24331a(int i) {
        return this.f20649b.a(i, -10972929);
    }

    private Drawable m24333b(int i) {
        return this.f20649b.a(i, -7235677);
    }

    private static boolean m24335b(boolean z, @Nullable GraphQLEventGuestStatus graphQLEventGuestStatus, @Nullable GraphQLEventWatchStatus graphQLEventWatchStatus) {
        if (z) {
            if (m24338d(graphQLEventGuestStatus) || graphQLEventGuestStatus == GraphQLEventGuestStatus.MAYBE) {
                return true;
            }
            return false;
        } else if (graphQLEventWatchStatus == GraphQLEventWatchStatus.WATCHED || graphQLEventWatchStatus == GraphQLEventWatchStatus.GOING) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean m24338d(@Nullable GraphQLEventGuestStatus graphQLEventGuestStatus) {
        return graphQLEventGuestStatus == GraphQLEventGuestStatus.GOING || graphQLEventGuestStatus == GraphQLEventGuestStatus.HOST;
    }
}
