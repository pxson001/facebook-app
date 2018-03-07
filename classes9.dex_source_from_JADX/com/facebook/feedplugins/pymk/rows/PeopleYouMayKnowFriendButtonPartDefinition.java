package com.facebook.feedplugins.pymk.rows;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.StringRes;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.environment.CanFriendPerson;
import com.facebook.feed.environment.CanFriendPerson.FriendshipStatus;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageSwitcherPartDefinition.Controller;
import com.facebook.feedplugins.friendingcommon.SmartButtonPartDefinition;
import com.facebook.feedplugins.pymk.PeopleYouMayKnowPersistentState.FriendshipContextStateKey;
import com.facebook.feedplugins.pymk.PeopleYouMayKnowPersistentState.FriendshipPersistentState;
import com.facebook.feedplugins.pymk.PeopleYouMayKnowPersistentState.QPContextStateKey;
import com.facebook.feedplugins.pymk.PeopleYouMayKnowPersistentState.QPPersistentState;
import com.facebook.feedplugins.pymk.PymkGatekeepers;
import com.facebook.feedplugins.pymk.quickpromotion.QuickPromotionFeedPYMKController;
import com.facebook.friends.constants.FriendingLocation;
import com.facebook.friends.controllers.interfaces.FriendingButtonControllerCallback;
import com.facebook.friends.ui.SmartButtonLite;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.graphql.model.PeopleYouMayKnowFeedUnit;
import com.facebook.graphql.model.PeopleYouMayKnowFeedUnitItem;
import com.facebook.graphql.model.conversion.FeedUnitItemProfileHelper;
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
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.multirow.parts.ContentDescriptionPartDefinition;
import com.facebook.multirow.parts.VisibilityPartDefinition;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.fasterxml.jackson.databind.node.ArrayNode;
import javax.inject.Inject;

@ContextScoped
/* compiled from: TIME_LIMIT_REACHED_SUCCESS */
public class PeopleYouMayKnowFriendButtonPartDefinition<E extends CanFriendPerson & HasInvalidate & HasPersistentState> extends BaseSinglePartDefinition<Props, Void, E, SmartButtonLite> {
    private static PeopleYouMayKnowFriendButtonPartDefinition f24782j;
    private static final Object f24783k = new Object();
    private final AllCapsTransformationMethod f24784a;
    public final AnalyticsLogger f24785b;
    private final ClickListenerPartDefinition f24786c;
    private final ContentDescriptionPartDefinition f24787d;
    public final NewsFeedAnalyticsEventBuilder f24788e;
    private final PymkGatekeepers f24789f;
    private final SmartButtonPartDefinition f24790g;
    private final Resources f24791h;
    private final VisibilityPartDefinition<E> f24792i;

    /* compiled from: TIME_LIMIT_REACHED_SUCCESS */
    /* synthetic */ class C29882 {
        static final /* synthetic */ int[] f24777a = new int[GraphQLFriendshipStatus.values().length];

        static {
            try {
                f24777a[GraphQLFriendshipStatus.CAN_REQUEST.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f24777a[GraphQLFriendshipStatus.INCOMING_REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f24777a[GraphQLFriendshipStatus.OUTGOING_REQUEST.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f24777a[GraphQLFriendshipStatus.ARE_FRIENDS.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* compiled from: TIME_LIMIT_REACHED_SUCCESS */
    public class Props {
        public final PeopleYouMayKnowFeedUnit f24778a;
        public final PeopleYouMayKnowFeedUnitItem f24779b;
        public final FriendshipPersistentState f24780c;
        public final Controller f24781d;

        public Props(PeopleYouMayKnowFeedUnit peopleYouMayKnowFeedUnit, PeopleYouMayKnowFeedUnitItem peopleYouMayKnowFeedUnitItem, FriendshipPersistentState friendshipPersistentState, Controller controller) {
            this.f24778a = peopleYouMayKnowFeedUnit;
            this.f24779b = peopleYouMayKnowFeedUnitItem;
            this.f24780c = friendshipPersistentState;
            this.f24781d = controller;
        }
    }

    private static PeopleYouMayKnowFriendButtonPartDefinition m26619b(InjectorLike injectorLike) {
        return new PeopleYouMayKnowFriendButtonPartDefinition(AllCapsTransformationMethod.b(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), ClickListenerPartDefinition.a(injectorLike), ContentDescriptionPartDefinition.a(injectorLike), NewsFeedAnalyticsEventBuilder.a(injectorLike), PymkGatekeepers.m26572a(injectorLike), SmartButtonPartDefinition.m26544a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), VisibilityPartDefinition.a(injectorLike));
    }

    public final Object m26620a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final Props props = (Props) obj;
        final CanFriendPerson canFriendPerson = (CanFriendPerson) anyEnvironment;
        if (m26617a(props.f24780c.f24683a)) {
            com.facebook.feedplugins.friendingcommon.SmartButtonPartDefinition.Props b = m26618b(props.f24780c.f24683a);
            subParts.a(this.f24787d, b.f24646a);
            ClickListenerPartDefinition clickListenerPartDefinition = this.f24786c;
            final FriendshipPersistentState friendshipPersistentState = props.f24780c;
            subParts.a(clickListenerPartDefinition, new OnClickListener(this) {
                final /* synthetic */ PeopleYouMayKnowFriendButtonPartDefinition f24776d;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 421964350);
                    GraphQLProfile a2 = FeedUnitItemProfileHelper.a(props.f24779b);
                    if (a2 == null) {
                        Logger.a(2, EntryType.UI_INPUT_END, 118048829, a);
                        return;
                    }
                    final FriendshipContextStateKey friendshipContextStateKey = new FriendshipContextStateKey(props.f24779b.l(), friendshipPersistentState.f24683a);
                    if (friendshipPersistentState.f24683a == GraphQLFriendshipStatus.CAN_REQUEST) {
                        HoneyAnalyticsEvent honeyAnalyticsEvent;
                        NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder = this.f24776d.f24788e;
                        ArrayNode a3 = GraphQLHelper.a(props.f24779b, props.f24778a);
                        if (NewsFeedAnalyticsEventBuilder.B(a3)) {
                            honeyAnalyticsEvent = null;
                        } else {
                            HoneyClientEvent a4 = new HoneyClientEvent("pymk_add").a("tracking", a3);
                            a4.c = "native_newsfeed";
                            honeyAnalyticsEvent = a4;
                        }
                        this.f24776d.f24785b.c(honeyAnalyticsEvent);
                        props.f24781d.a();
                    }
                    PeopleYouMayKnowFriendButtonPartDefinition peopleYouMayKnowFriendButtonPartDefinition = this.f24776d;
                    PeopleYouMayKnowFriendButtonPartDefinition.m26616a(canFriendPerson, props.f24778a);
                    FriendshipStatus a5 = canFriendPerson.a(a2.b(), a2.U(), FriendingLocation.PYMK_FEED, friendshipPersistentState.f24683a, new FriendingButtonControllerCallback(this) {
                        final /* synthetic */ C29871 f24772b;

                        public final void m26613a() {
                            ((HasPersistentState) canFriendPerson).a(friendshipContextStateKey, friendshipPersistentState);
                            ((HasInvalidate) canFriendPerson).a(new Object[]{props.f24778a});
                        }
                    });
                    ((HasPersistentState) canFriendPerson).a(friendshipContextStateKey, new FriendshipPersistentState(a5.a, a5.b));
                    ((HasInvalidate) canFriendPerson).a(new Object[]{props.f24778a});
                    LogUtils.a(-1190393258, a);
                }
            });
            subParts.a(this.f24790g, b);
        }
        subParts.a(this.f24792i, Integer.valueOf(m26617a(props.f24780c.f24683a) ? 0 : 8));
        return null;
    }

    public static PeopleYouMayKnowFriendButtonPartDefinition m26614a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PeopleYouMayKnowFriendButtonPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24783k) {
                PeopleYouMayKnowFriendButtonPartDefinition peopleYouMayKnowFriendButtonPartDefinition;
                if (a2 != null) {
                    peopleYouMayKnowFriendButtonPartDefinition = (PeopleYouMayKnowFriendButtonPartDefinition) a2.a(f24783k);
                } else {
                    peopleYouMayKnowFriendButtonPartDefinition = f24782j;
                }
                if (peopleYouMayKnowFriendButtonPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m26619b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24783k, b3);
                        } else {
                            f24782j = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = peopleYouMayKnowFriendButtonPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PeopleYouMayKnowFriendButtonPartDefinition(AllCapsTransformationMethod allCapsTransformationMethod, AnalyticsLogger analyticsLogger, ClickListenerPartDefinition clickListenerPartDefinition, ContentDescriptionPartDefinition contentDescriptionPartDefinition, NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder, PymkGatekeepers pymkGatekeepers, SmartButtonPartDefinition smartButtonPartDefinition, Resources resources, VisibilityPartDefinition visibilityPartDefinition) {
        this.f24784a = allCapsTransformationMethod;
        this.f24785b = analyticsLogger;
        this.f24786c = clickListenerPartDefinition;
        this.f24787d = contentDescriptionPartDefinition;
        this.f24788e = newsFeedAnalyticsEventBuilder;
        this.f24789f = pymkGatekeepers;
        this.f24790g = smartButtonPartDefinition;
        this.f24791h = resources;
        this.f24792i = visibilityPartDefinition;
    }

    private static boolean m26617a(GraphQLFriendshipStatus graphQLFriendshipStatus) {
        return graphQLFriendshipStatus == GraphQLFriendshipStatus.CAN_REQUEST || graphQLFriendshipStatus == GraphQLFriendshipStatus.ARE_FRIENDS || graphQLFriendshipStatus == GraphQLFriendshipStatus.INCOMING_REQUEST || graphQLFriendshipStatus == GraphQLFriendshipStatus.OUTGOING_REQUEST;
    }

    public static void m26616a(E e, FeedUnit feedUnit) {
        QPContextStateKey qPContextStateKey = new QPContextStateKey(feedUnit.g(), new QPPersistentState(true, QuickPromotionFeedPYMKController.a));
        ((HasPersistentState) e).a(qPContextStateKey, feedUnit);
        ((HasPersistentState) e).a(qPContextStateKey, new QPPersistentState(true, QuickPromotionFeedPYMKController.a));
    }

    private com.facebook.feedplugins.friendingcommon.SmartButtonPartDefinition.Props m26618b(GraphQLFriendshipStatus graphQLFriendshipStatus) {
        int i;
        int i2;
        CharSequence a;
        int i3;
        CharSequence a2;
        Integer num = null;
        int i4 = 0;
        boolean z = this.f24789f.f24692a;
        boolean z2 = this.f24789f.f24693b;
        boolean z3 = this.f24789f.f24694c;
        boolean z4 = this.f24789f.f24695d;
        Integer valueOf = Integer.valueOf(0);
        int i5;
        switch (C29882.f24777a[graphQLFriendshipStatus.ordinal()]) {
            case 1:
            case 2:
                if (z) {
                    num = Integer.valueOf(this.f24791h.getColor(2131361920));
                    i5 = 2130840349;
                } else if (z2) {
                    num = Integer.valueOf(this.f24791h.getColor(2131362107));
                    i5 = 2130840351;
                } else if (z3) {
                    num = Integer.valueOf(this.f24791h.getColor(2131364083));
                    i5 = 2130840352;
                } else if (z4) {
                    num = Integer.valueOf(this.f24791h.getColor(2131362106));
                    i5 = 2130840353;
                } else {
                    i4 = 2130772401;
                    i5 = 0;
                }
                i = 2130840447;
                i2 = i5;
                int i6 = i4;
                a = m26615a(2131233212);
                i3 = i6;
                valueOf = num;
                a2 = m26615a(2131233213);
                break;
            case 3:
                CharSequence a3;
                CharSequence a4;
                if (z || z3 || z4) {
                    a3 = m26615a(2131233214);
                    a4 = m26615a(2131230727);
                    num = Integer.valueOf(this.f24791h.getColor(2131362106));
                    i5 = 0;
                    i4 = 2130840353;
                } else if (z2) {
                    a3 = m26615a(2131233214);
                    a4 = m26615a(2131230727);
                    num = Integer.valueOf(this.f24791h.getColor(2131362107));
                    i5 = 0;
                    i4 = 2130840351;
                } else {
                    a3 = m26615a(2131230727);
                    i5 = 2130772404;
                    Integer valueOf2 = Integer.valueOf(this.f24791h.getColor(2131361935));
                    a4 = null;
                    num = valueOf2;
                }
                i2 = i4;
                a = a3;
                valueOf = num;
                a2 = a4;
                i = 2130839891;
                i3 = i5;
                break;
            case 4:
                Integer valueOf3;
                if (z || z3 || z4) {
                    valueOf3 = Integer.valueOf(this.f24791h.getColor(2131362106));
                    i5 = 0;
                    i4 = 2130840353;
                } else if (z2) {
                    valueOf3 = Integer.valueOf(this.f24791h.getColor(2131362107));
                    i5 = 0;
                    i4 = 2130840351;
                } else {
                    valueOf3 = Integer.valueOf(this.f24791h.getColor(2131361935));
                    i5 = 2130772404;
                }
                i2 = i4;
                a = m26615a(2131233209);
                i3 = i5;
                valueOf = valueOf3;
                i = 2130840452;
                break;
            default:
                i2 = 0;
                i3 = 0;
                i = 0;
                a = null;
                break;
        }
        return new com.facebook.feedplugins.friendingcommon.SmartButtonPartDefinition.Props(a, a2, i, valueOf, i3, i2);
    }

    private CharSequence m26615a(@StringRes int i) {
        return this.f24784a.getTransformation(this.f24791h.getString(i), null);
    }
}
