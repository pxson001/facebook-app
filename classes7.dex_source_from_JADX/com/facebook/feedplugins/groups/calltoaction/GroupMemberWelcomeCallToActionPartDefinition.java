package com.facebook.feedplugins.groups.calltoaction;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.calltoaction.ActionLinkCallToActionPartDefinition;
import com.facebook.feedplugins.calltoaction.ActionLinkCallToActionPartDefinition$Props;
import com.facebook.feedplugins.calltoaction.ActionLinkCallToActionView;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.model.ActionLinkHelper;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryActionLink;
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
import javax.inject.Inject;

@ContextScoped
/* compiled from: SWIPING_FRAME */
public class GroupMemberWelcomeCallToActionPartDefinition<E extends FeedEnvironment> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, ActionLinkCallToActionView> {
    private static GroupMemberWelcomeCallToActionPartDefinition f23493f;
    private static final Object f23494g = new Object();
    private final ActionLinkCallToActionPartDefinition<E> f23495a;
    private final AnalyticsLogger f23496b;
    public final Context f23497c;
    public final FbUriIntentHandler f23498d;
    private final GatekeeperStoreImpl f23499e;

    private static GroupMemberWelcomeCallToActionPartDefinition m25760b(InjectorLike injectorLike) {
        return new GroupMemberWelcomeCallToActionPartDefinition(ActionLinkCallToActionPartDefinition.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), (Context) injectorLike.getInstance(Context.class), FbUriIntentHandler.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    public final Object m25762a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        final GraphQLStoryActionLink a = ActionLinkHelper.a((GraphQLStory) feedProps.a, -1260727392);
        subParts.a(this.f23495a, ActionLinkCallToActionPartDefinition$Props.m25513a(feedProps, a, null, new OnClickListener(this) {
            final /* synthetic */ GroupMemberWelcomeCallToActionPartDefinition f23492b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 861684214);
                GroupMemberWelcomeCallToActionPartDefinition.m25759a(this.f23492b, "android_groups_new_member_exp_cta_click");
                this.f23492b.f23498d.a(this.f23492b.f23497c, StringFormatUtil.formatStrLocaleSafe(FBLinks.u, a.I().k()));
                Logger.a(2, EntryType.UI_INPUT_END, 1943368116, a);
            }
        }, null, null, a.t().a(), true));
        m25759a(this, "android_groups_new_member_exp_cta_imp");
        return null;
    }

    public final boolean m25763a(Object obj) {
        GraphQLStoryActionLink a = ActionLinkHelper.a((GraphQLStory) ((FeedProps) obj).a, -1260727392);
        return (a == null || a.I() == null || a.I().a() == null || a.I().a().g() != -1455915066 || !this.f23499e.a(91, false)) ? false : true;
    }

    @Inject
    public GroupMemberWelcomeCallToActionPartDefinition(ActionLinkCallToActionPartDefinition actionLinkCallToActionPartDefinition, AnalyticsLogger analyticsLogger, Context context, FbUriIntentHandler fbUriIntentHandler, GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f23495a = actionLinkCallToActionPartDefinition;
        this.f23496b = analyticsLogger;
        this.f23497c = context;
        this.f23498d = fbUriIntentHandler;
        this.f23499e = gatekeeperStoreImpl;
    }

    public static GroupMemberWelcomeCallToActionPartDefinition m25758a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GroupMemberWelcomeCallToActionPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23494g) {
                GroupMemberWelcomeCallToActionPartDefinition groupMemberWelcomeCallToActionPartDefinition;
                if (a2 != null) {
                    groupMemberWelcomeCallToActionPartDefinition = (GroupMemberWelcomeCallToActionPartDefinition) a2.a(f23494g);
                } else {
                    groupMemberWelcomeCallToActionPartDefinition = f23493f;
                }
                if (groupMemberWelcomeCallToActionPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m25760b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23494g, b3);
                        } else {
                            f23493f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = groupMemberWelcomeCallToActionPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m25761a() {
        return ActionLinkCallToActionView.f23054h;
    }

    public static void m25759a(GroupMemberWelcomeCallToActionPartDefinition groupMemberWelcomeCallToActionPartDefinition, String str) {
        if (str != null) {
            groupMemberWelcomeCallToActionPartDefinition.f23496b.a(new HoneyClientEvent(str));
        }
    }
}
