package com.facebook.feedplugins.socialgood;

import android.content.Context;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.socialgood.ipc.SocialGoodLogHelper;
import java.util.ArrayList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: browser_disabled_setting_change */
public class FundraiserPageAttachmentGroupPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStoryAttachment>, Void, HasPositionInformation> {
    private static FundraiserPageAttachmentGroupPartDefinition f9445f;
    private static final Object f9446g = new Object();
    private final FundraiserPageAttachmentHeaderPartDefinition f9447a;
    private final FundraiserPageAttachmentBodyPartDefinition f9448b;
    private final GatekeeperStoreImpl f9449c;
    public final Lazy<FbErrorReporter> f9450d;
    public final Lazy<AnalyticsLogger> f9451e;

    private static FundraiserPageAttachmentGroupPartDefinition m9998b(InjectorLike injectorLike) {
        return new FundraiserPageAttachmentGroupPartDefinition(FundraiserPageAttachmentHeaderPartDefinition.a(injectorLike), FundraiserPageAttachmentBodyPartDefinition.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 494), IdBasedSingletonScopeProvider.b(injectorLike, 175));
    }

    public final Object m9999a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        Flattenable flattenable = feedProps.a;
        baseMultiRowSubParts.a(this.f9447a, feedProps);
        baseMultiRowSubParts.a(this.f9448b, feedProps);
        return null;
    }

    public final boolean m10000a(Object obj) {
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) ((FeedProps) obj).a;
        if (!this.f9449c.a(839, false)) {
            return false;
        }
        boolean z;
        ArrayList arrayList = new ArrayList();
        if (graphQLStoryAttachment == null) {
            arrayList.add("no_attachment");
        } else if (graphQLStoryAttachment.z() == null) {
            arrayList.add("no_target");
        } else if (graphQLStoryAttachment.z().au() == null) {
            arrayList.add("no_campaign");
        } else {
            if (graphQLStoryAttachment.z().au().B() == null || StringUtil.a(graphQLStoryAttachment.z().au().B().a())) {
                arrayList.add("no_charity_text");
            }
            if (StringUtil.a(graphQLStoryAttachment.z().au().m())) {
                arrayList.add("no_fundraiser_title");
            }
            if (StringUtil.a(graphQLStoryAttachment.z().au().j())) {
                arrayList.add("no_amount_raised");
            }
            if (graphQLStoryAttachment.z().au().w() == null) {
                arrayList.add("no_profile_picture");
            }
            if (graphQLStoryAttachment.z().au().u() == null) {
                arrayList.add("no_campaign_id");
            }
        }
        if (arrayList.isEmpty()) {
            ((AnalyticsLogger) this.f9451e.get()).a(SocialGoodLogHelper.c(graphQLStoryAttachment.z().au().u()));
            z = true;
        } else {
            ((AbstractFbErrorReporter) this.f9450d.get()).b("fundraiser_share_attachment_error", StringUtil.b(", ", new Object[]{arrayList}));
            z = false;
        }
        return z;
    }

    @Inject
    public FundraiserPageAttachmentGroupPartDefinition(FundraiserPageAttachmentHeaderPartDefinition fundraiserPageAttachmentHeaderPartDefinition, FundraiserPageAttachmentBodyPartDefinition fundraiserPageAttachmentBodyPartDefinition, GatekeeperStore gatekeeperStore, Lazy<FbErrorReporter> lazy, Lazy<AnalyticsLogger> lazy2) {
        this.f9447a = fundraiserPageAttachmentHeaderPartDefinition;
        this.f9448b = fundraiserPageAttachmentBodyPartDefinition;
        this.f9449c = gatekeeperStore;
        this.f9450d = lazy;
        this.f9451e = lazy2;
    }

    public static FundraiserPageAttachmentGroupPartDefinition m9997a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FundraiserPageAttachmentGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9446g) {
                FundraiserPageAttachmentGroupPartDefinition fundraiserPageAttachmentGroupPartDefinition;
                if (a2 != null) {
                    fundraiserPageAttachmentGroupPartDefinition = (FundraiserPageAttachmentGroupPartDefinition) a2.a(f9446g);
                } else {
                    fundraiserPageAttachmentGroupPartDefinition = f9445f;
                }
                if (fundraiserPageAttachmentGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9998b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9446g, b3);
                        } else {
                            f9445f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = fundraiserPageAttachmentGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
