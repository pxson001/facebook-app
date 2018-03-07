package com.facebook.feedplugins.socialgood;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.props.FeedProps;
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
/* compiled from: box-none */
public class FundraiserPersonToCharityAttachmentGroupPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStoryAttachment>, Void, HasPositionInformation> {
    private static FundraiserPersonToCharityAttachmentGroupPartDefinition f9468g;
    private static final Object f9469h = new Object();
    private final GatekeeperStoreImpl f9470a;
    private final FundraiserPageAttachmentHeaderPartDefinition f9471b;
    private final FundraiserPageAttachmentBodyPartDefinition f9472c;
    private final FundraiserPersonToCharityAttachmentFacepilePartDefinition f9473d;
    public final Lazy<FbErrorReporter> f9474e;
    public final Lazy<AnalyticsLogger> f9475f;

    private static FundraiserPersonToCharityAttachmentGroupPartDefinition m10005b(InjectorLike injectorLike) {
        return new FundraiserPersonToCharityAttachmentGroupPartDefinition(FundraiserPageAttachmentHeaderPartDefinition.a(injectorLike), FundraiserPersonToCharityAttachmentFacepilePartDefinition.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), FundraiserPageAttachmentBodyPartDefinition.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 494), IdBasedSingletonScopeProvider.b(injectorLike, 175));
    }

    public final Object m10006a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        baseMultiRowSubParts.a(this.f9471b, feedProps);
        baseMultiRowSubParts.a(this.f9472c, feedProps);
        baseMultiRowSubParts.a(this.f9473d, feedProps);
        return null;
    }

    public final boolean m10007a(Object obj) {
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) ((FeedProps) obj).a;
        if (!this.f9470a.a(840, false)) {
            return false;
        }
        boolean z;
        ArrayList arrayList = new ArrayList();
        if (graphQLStoryAttachment == null) {
            arrayList.add("no_attachment");
        } else if (graphQLStoryAttachment.z() == null) {
            arrayList.add("no_target");
        } else {
            if (graphQLStoryAttachment.z().cV() == null || TextUtils.isEmpty(graphQLStoryAttachment.z().cV().a())) {
                arrayList.add("no_charity_text");
            }
            if (TextUtils.isEmpty(graphQLStoryAttachment.z().av())) {
                arrayList.add("no_fundraiser_title");
            }
            if (TextUtils.isEmpty(graphQLStoryAttachment.z().jJ())) {
                arrayList.add("no_amount_raised");
            }
            if (graphQLStoryAttachment.z().et() == null) {
                arrayList.add("no_profile_picture");
            }
            if (graphQLStoryAttachment.z().dp() == null) {
                arrayList.add("no_campaign_id");
            }
        }
        if (arrayList.isEmpty()) {
            ((AnalyticsLogger) this.f9475f.get()).a(SocialGoodLogHelper.c(graphQLStoryAttachment.z().dp()));
            z = true;
        } else {
            ((AbstractFbErrorReporter) this.f9474e.get()).b("fundraiser_share_attachment_error", StringUtil.b(", ", new Object[]{arrayList}));
            z = false;
        }
        return z;
    }

    @Inject
    public FundraiserPersonToCharityAttachmentGroupPartDefinition(FundraiserPageAttachmentHeaderPartDefinition fundraiserPageAttachmentHeaderPartDefinition, FundraiserPersonToCharityAttachmentFacepilePartDefinition fundraiserPersonToCharityAttachmentFacepilePartDefinition, GatekeeperStore gatekeeperStore, FundraiserPageAttachmentBodyPartDefinition fundraiserPageAttachmentBodyPartDefinition, Lazy<FbErrorReporter> lazy, Lazy<AnalyticsLogger> lazy2) {
        this.f9471b = fundraiserPageAttachmentHeaderPartDefinition;
        this.f9473d = fundraiserPersonToCharityAttachmentFacepilePartDefinition;
        this.f9470a = gatekeeperStore;
        this.f9472c = fundraiserPageAttachmentBodyPartDefinition;
        this.f9474e = lazy;
        this.f9475f = lazy2;
    }

    public static FundraiserPersonToCharityAttachmentGroupPartDefinition m10004a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FundraiserPersonToCharityAttachmentGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9469h) {
                FundraiserPersonToCharityAttachmentGroupPartDefinition fundraiserPersonToCharityAttachmentGroupPartDefinition;
                if (a2 != null) {
                    fundraiserPersonToCharityAttachmentGroupPartDefinition = (FundraiserPersonToCharityAttachmentGroupPartDefinition) a2.a(f9469h);
                } else {
                    fundraiserPersonToCharityAttachmentGroupPartDefinition = f9468g;
                }
                if (fundraiserPersonToCharityAttachmentGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10005b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9469h, b3);
                        } else {
                            f9468g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = fundraiserPersonToCharityAttachmentGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
