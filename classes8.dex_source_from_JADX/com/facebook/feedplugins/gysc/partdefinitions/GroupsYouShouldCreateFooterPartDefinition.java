package com.facebook.feedplugins.gysc.partdefinitions;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.common.util.CollectionUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.feedplugins.base.footer.ui.OneButtonFooterView;
import com.facebook.graphql.model.GraphQLGroupsYouShouldCreateFeedUnit;
import com.facebook.groups.fb4a.groupshub.abtest.ExperimentsForFB4AGroupsHubAbtestModule;
import com.facebook.groups.fb4a.groupshub.abtest.FB4AGroupsHubExperiments;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.multirow.parts.ResourceIdTextPartDefinition;
import com.facebook.qe.api.Liveness;
import javax.inject.Inject;

@ContextScoped
/* compiled from: friendversary_card_collage_ipb */
public class GroupsYouShouldCreateFooterPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLGroupsYouShouldCreateFeedUnit>, Void, HasPositionInformation, OneButtonFooterView> {
    private static final PaddingStyle f12806a;
    private static GroupsYouShouldCreateFooterPartDefinition f12807h;
    private static final Object f12808i = new Object();
    public final SecureContextHelper f12809b;
    private final ClickListenerPartDefinition f12810c;
    private final ResourceIdTextPartDefinition f12811d;
    private final BackgroundPartDefinition f12812e;
    public UriIntentMapper f12813f;
    private FB4AGroupsHubExperiments f12814g;

    /* compiled from: friendversary_card_collage_ipb */
    public class C13341 implements OnClickListener {
        final /* synthetic */ GroupsYouShouldCreateFooterPartDefinition f12805a;

        public C13341(GroupsYouShouldCreateFooterPartDefinition groupsYouShouldCreateFooterPartDefinition) {
            this.f12805a = groupsYouShouldCreateFooterPartDefinition;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1920870480);
            Intent a2 = this.f12805a.f12813f.a(view.getContext(), FBLinks.E);
            a2.putExtra("extra_navigation_source", "gysc");
            this.f12805a.f12809b.a(a2, view.getContext());
            Logger.a(2, EntryType.UI_INPUT_END, -1447098906, a);
        }
    }

    private static GroupsYouShouldCreateFooterPartDefinition m14588b(InjectorLike injectorLike) {
        return new GroupsYouShouldCreateFooterPartDefinition((SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), ClickListenerPartDefinition.a(injectorLike), ResourceIdTextPartDefinition.a(injectorLike), BackgroundPartDefinition.a(injectorLike), (UriIntentMapper) Fb4aUriIntentMapper.a(injectorLike), FB4AGroupsHubExperiments.m15493a(injectorLike));
    }

    public final Object m14590a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f12812e, new StylingData((FeedProps) obj, f12806a));
        subParts.a(this.f12810c, new C13341(this));
        subParts.a(2131559974, this.f12811d, Integer.valueOf(2131235583));
        return null;
    }

    public final boolean m14591a(Object obj) {
        FeedProps feedProps = (FeedProps) obj;
        if (feedProps.a == null) {
            return false;
        }
        return CollectionUtil.b(((GraphQLGroupsYouShouldCreateFeedUnit) feedProps.a).l()) && this.f12814g.m15496c() && this.f12814g.f13859b.a(Liveness.Live, ExperimentsForFB4AGroupsHubAbtestModule.f13855d, false);
    }

    static {
        Builder g = Builder.g();
        g.b = 4.0f;
        f12806a = g.i();
    }

    @Inject
    public GroupsYouShouldCreateFooterPartDefinition(SecureContextHelper secureContextHelper, ClickListenerPartDefinition clickListenerPartDefinition, ResourceIdTextPartDefinition resourceIdTextPartDefinition, BackgroundPartDefinition backgroundPartDefinition, UriIntentMapper uriIntentMapper, FB4AGroupsHubExperiments fB4AGroupsHubExperiments) {
        this.f12809b = secureContextHelper;
        this.f12810c = clickListenerPartDefinition;
        this.f12811d = resourceIdTextPartDefinition;
        this.f12812e = backgroundPartDefinition;
        this.f12813f = uriIntentMapper;
        this.f12814g = fB4AGroupsHubExperiments;
    }

    public static GroupsYouShouldCreateFooterPartDefinition m14587a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GroupsYouShouldCreateFooterPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12808i) {
                GroupsYouShouldCreateFooterPartDefinition groupsYouShouldCreateFooterPartDefinition;
                if (a2 != null) {
                    groupsYouShouldCreateFooterPartDefinition = (GroupsYouShouldCreateFooterPartDefinition) a2.a(f12808i);
                } else {
                    groupsYouShouldCreateFooterPartDefinition = f12807h;
                }
                if (groupsYouShouldCreateFooterPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14588b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12808i, b3);
                        } else {
                            f12807h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = groupsYouShouldCreateFooterPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType<OneButtonFooterView> m14589a() {
        return OneButtonFooterView.a;
    }
}
