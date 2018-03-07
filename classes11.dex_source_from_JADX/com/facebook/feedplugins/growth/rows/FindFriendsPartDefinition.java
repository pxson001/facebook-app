package com.facebook.feedplugins.growth.rows;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.persistence.ContextStateKey;
import com.facebook.feedplugins.growth.ui.FindFriendsView;
import com.facebook.friending.center.constants.FriendsCenterSource;
import com.facebook.friending.center.constants.FriendsCenterTabType;
import com.facebook.friends.abtest.ExperimentsForFriendsExperimentModule;
import com.facebook.friends.navigator.FriendingNavigator;
import com.facebook.funnellogger.FunnelDefinition;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.graphql.model.GraphQLFindFriendsFeedUnit;
import com.facebook.growth.logging.FriendFinderAnalyticsLogger;
import com.facebook.growth.logging.FriendFinderAnalyticsLogger.EventType;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.intent.feed.DefaultFeedIntentBuilder;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.LogUtils;
import javax.inject.Inject;

@ContextScoped
/* compiled from: date_content */
public class FindFriendsPartDefinition<E extends HasPositionInformation & HasPersistentState> extends MultiRowSinglePartDefinition<GraphQLFindFriendsFeedUnit, Void, E, FindFriendsView> {
    public static final ViewType<FindFriendsView> f7756a = new C09851();
    private static FindFriendsPartDefinition f7757j;
    private static final Object f7758k = new Object();
    public final IFeedIntentBuilder f7759b;
    public final FbUriIntentHandler f7760c;
    public final SecureContextHelper f7761d;
    private final ClickListenerPartDefinition f7762e;
    public final FriendFinderAnalyticsLogger f7763f;
    public final QeAccessor f7764g;
    public final FriendingNavigator f7765h;
    public final String f7766i = SafeUUIDGenerator.a().toString();

    /* compiled from: date_content */
    final class C09851 extends ViewType<FindFriendsView> {
        C09851() {
        }

        public final View m8928a(Context context) {
            return new FindFriendsView(context);
        }
    }

    /* compiled from: date_content */
    public class C09862 implements OnClickListener {
        final /* synthetic */ FindFriendsPartDefinition f7753a;

        public C09862(FindFriendsPartDefinition findFriendsPartDefinition) {
            this.f7753a = findFriendsPartDefinition;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 538437626);
            FriendFinderAnalyticsLogger friendFinderAnalyticsLogger = this.f7753a.f7763f;
            String str = this.f7753a.f7766i;
            friendFinderAnalyticsLogger.a.c(FriendFinderAnalyticsLogger.b(EventType.FIND_FRIENDS_CLICKED.getEventName()).b("empty_feed_uuid", str).b("unit", "find_friends"));
            FunnelDefinition funnelDefinition = FunnelRegistry.c;
            funnelDefinition.d = false;
            funnelDefinition.c = 600;
            friendFinderAnalyticsLogger.b.a(FunnelRegistry.c);
            if (this.f7753a.f7765h.a() || !this.f7753a.f7764g.a(ExperimentsForFriendsExperimentModule.c, false)) {
                this.f7753a.f7761d.a(this.f7753a.f7759b.a(), view.getContext());
            } else {
                this.f7753a.f7760c.a(view.getContext(), StringFormatUtil.formatStrLocaleSafe(FBLinks.cd, FriendsCenterSource.CI_PROMOTION_EMPTY_FEED.name(), FriendsCenterTabType.SUGGESTIONS.name()));
            }
            LogUtils.a(-706135702, a);
        }
    }

    /* compiled from: date_content */
    public class FindFriendsContextStateKey implements ContextStateKey<String, Boolean> {
        private final String f7754a;
        private final boolean f7755b;

        public FindFriendsContextStateKey(String str, boolean z) {
            this.f7754a = FindFriendsContextStateKey.class.getSimpleName() + str;
            this.f7755b = z;
        }

        public final Object m8929a() {
            return Boolean.valueOf(this.f7755b);
        }

        public final Object m8930b() {
            return this.f7754a;
        }
    }

    private static FindFriendsPartDefinition m8932b(InjectorLike injectorLike) {
        return new FindFriendsPartDefinition((IFeedIntentBuilder) DefaultFeedIntentBuilder.a(injectorLike), FbUriIntentHandler.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), ClickListenerPartDefinition.a(injectorLike), FriendFinderAnalyticsLogger.a(injectorLike), FriendingNavigator.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    public final Object m8934a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        GraphQLFindFriendsFeedUnit graphQLFindFriendsFeedUnit = (GraphQLFindFriendsFeedUnit) obj;
        HasPositionInformation hasPositionInformation = (HasPositionInformation) anyEnvironment;
        subParts.a(2131561995, this.f7762e, new C09862(this));
        FindFriendsContextStateKey findFriendsContextStateKey = new FindFriendsContextStateKey(graphQLFindFriendsFeedUnit.g(), false);
        if (!((Boolean) ((HasPersistentState) hasPositionInformation).a(findFriendsContextStateKey, graphQLFindFriendsFeedUnit)).booleanValue()) {
            FriendFinderAnalyticsLogger friendFinderAnalyticsLogger = this.f7763f;
            String str = this.f7766i;
            friendFinderAnalyticsLogger.a.c(FriendFinderAnalyticsLogger.b(EventType.FIND_FRIENDS_SHOWN.getEventName()).b("empty_feed_uuid", str).b("unit", "find_friends"));
            ((HasPersistentState) hasPositionInformation).a(findFriendsContextStateKey, Boolean.valueOf(true));
        }
        return null;
    }

    public static FindFriendsPartDefinition m8931a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FindFriendsPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f7758k) {
                FindFriendsPartDefinition findFriendsPartDefinition;
                if (a2 != null) {
                    findFriendsPartDefinition = (FindFriendsPartDefinition) a2.a(f7758k);
                } else {
                    findFriendsPartDefinition = f7757j;
                }
                if (findFriendsPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m8932b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f7758k, b3);
                        } else {
                            f7757j = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = findFriendsPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public FindFriendsPartDefinition(IFeedIntentBuilder iFeedIntentBuilder, FbUriIntentHandler fbUriIntentHandler, SecureContextHelper secureContextHelper, ClickListenerPartDefinition clickListenerPartDefinition, FriendFinderAnalyticsLogger friendFinderAnalyticsLogger, FriendingNavigator friendingNavigator, QeAccessor qeAccessor) {
        this.f7759b = iFeedIntentBuilder;
        this.f7760c = fbUriIntentHandler;
        this.f7761d = secureContextHelper;
        this.f7762e = clickListenerPartDefinition;
        this.f7763f = friendFinderAnalyticsLogger;
        this.f7765h = friendingNavigator;
        this.f7764g = qeAccessor;
    }

    public final ViewType<FindFriendsView> m8933a() {
        return f7756a;
    }

    public final boolean m8935a(Object obj) {
        return true;
    }
}
