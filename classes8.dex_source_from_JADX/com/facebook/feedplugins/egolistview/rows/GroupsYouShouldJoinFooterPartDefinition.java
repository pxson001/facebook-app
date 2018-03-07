package com.facebook.feedplugins.egolistview.rows;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.base.activity.ReactFragmentActivity;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.feedplugins.base.footer.ui.OneButtonFooterView;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.graphql.model.GroupsYouShouldJoinFeedUnit;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.multirow.parts.ResourceIdTextPartDefinition;
import com.facebook.tools.dextr.runtime.LogUtils;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: gravity_undo_hide_place_tips */
public class GroupsYouShouldJoinFooterPartDefinition<E extends HasPositionInformation & HasFeedListType> extends MultiRowSinglePartDefinition<FeedProps<? extends GroupsYouShouldJoinFeedUnit>, Void, E, OneButtonFooterView> {
    public static final ViewType f12043a = new C12891();
    private static final PaddingStyle f12044b;
    private static GroupsYouShouldJoinFooterPartDefinition f12045i;
    private static final Object f12046j = new Object();
    public final Provider<ComponentName> f12047c;
    public final SecureContextHelper f12048d;
    private final ClickListenerPartDefinition f12049e;
    private final ResourceIdTextPartDefinition f12050f;
    private final BackgroundPartDefinition f12051g;
    public final AnalyticsLogger f12052h;

    /* compiled from: gravity_undo_hide_place_tips */
    final class C12891 extends ViewType {
        C12891() {
        }

        public final View m14088a(Context context) {
            return new OneButtonFooterView(context);
        }
    }

    private static GroupsYouShouldJoinFooterPartDefinition m14090b(InjectorLike injectorLike) {
        return new GroupsYouShouldJoinFooterPartDefinition((SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), ClickListenerPartDefinition.a(injectorLike), ResourceIdTextPartDefinition.a(injectorLike), IdBasedProvider.a(injectorLike, 13), BackgroundPartDefinition.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    public final Object m14092a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        HasPositionInformation hasPositionInformation = (HasPositionInformation) anyEnvironment;
        Flattenable flattenable = feedProps.a;
        subParts.a(this.f12051g, new StylingData(feedProps, f12044b));
        ClickListenerPartDefinition clickListenerPartDefinition = this.f12049e;
        final FeedListType c = ((HasFeedListType) hasPositionInformation).c();
        subParts.a(clickListenerPartDefinition, new OnClickListener(this) {
            final /* synthetic */ GroupsYouShouldJoinFooterPartDefinition f12042b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1389844098);
                String name = (c == null || c.a() == null) ? null : c.a().name();
                HoneyClientEvent honeyClientEvent = new HoneyClientEvent("gysj_see_all_click");
                honeyClientEvent.c = "native_newsfeed";
                honeyClientEvent = honeyClientEvent;
                if (name != null) {
                    honeyClientEvent.b("feed_name", name);
                }
                this.f12042b.f12052h.a(honeyClientEvent);
                Intent component = new Intent().setComponent((ComponentName) this.f12042b.f12047c.get());
                component.putExtra("target_fragment", ContentFragmentType.GROUPS_DISCOVER_FRAGMENT.ordinal());
                component.putExtra("extra_navigation_source", "gysj");
                this.f12042b.f12048d.a(component, view.getContext());
                LogUtils.a(-618113001, a);
            }
        });
        subParts.a(2131559974, this.f12050f, Integer.valueOf(2131233486));
        return null;
    }

    static {
        Builder g = Builder.g();
        g.b = 4.0f;
        f12044b = g.i();
    }

    public static GroupsYouShouldJoinFooterPartDefinition m14089a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GroupsYouShouldJoinFooterPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12046j) {
                GroupsYouShouldJoinFooterPartDefinition groupsYouShouldJoinFooterPartDefinition;
                if (a2 != null) {
                    groupsYouShouldJoinFooterPartDefinition = (GroupsYouShouldJoinFooterPartDefinition) a2.a(f12046j);
                } else {
                    groupsYouShouldJoinFooterPartDefinition = f12045i;
                }
                if (groupsYouShouldJoinFooterPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14090b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12046j, b3);
                        } else {
                            f12045i = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = groupsYouShouldJoinFooterPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public GroupsYouShouldJoinFooterPartDefinition(SecureContextHelper secureContextHelper, ClickListenerPartDefinition clickListenerPartDefinition, ResourceIdTextPartDefinition resourceIdTextPartDefinition, @ReactFragmentActivity Provider<ComponentName> provider, BackgroundPartDefinition backgroundPartDefinition, AnalyticsLogger analyticsLogger) {
        this.f12048d = secureContextHelper;
        this.f12049e = clickListenerPartDefinition;
        this.f12050f = resourceIdTextPartDefinition;
        this.f12047c = provider;
        this.f12051g = backgroundPartDefinition;
        this.f12052h = analyticsLogger;
    }

    public final ViewType m14091a() {
        return f12043a;
    }

    public final boolean m14093a(Object obj) {
        return true;
    }
}
