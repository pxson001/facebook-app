package com.facebook.crowdsourcing.feather;

import android.content.Context;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.composer.publish.common.PublishPostParams;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.crowdsourcing.abtest.ExperimentsForCrowdsourcingAbTestModule;
import com.facebook.crowdsourcing.feather.graphql.FeatherQueryHelper;
import com.facebook.crowdsourcing.logging.CrowdEntryPoint;
import com.facebook.crowdsourcing.logging.SuggestEditsAnalyticsLogger;
import com.facebook.crowdsourcing.protocol.graphql.PlaceQuestionFragmentsModels.PlaceQuestionFieldsModel;
import com.facebook.funnellogger.FunnelLoggerImpl;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Optional;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: max_cache_age */
public class FeatherManager {
    @Inject
    public AbstractFbErrorReporter f14931a;
    @Inject
    public FeatherQueryHelper f14932b;
    @Inject
    public SecureContextHelper f14933c;
    @Inject
    SuggestEditsAnalyticsLogger f14934d;
    @Inject
    QeAccessor f14935e;
    @Inject
    public FunnelLoggerImpl f14936f;
    public long f14937g;
    public String f14938h;
    public String f14939i;
    public ImmutableList<PlaceQuestionFieldsModel> f14940j;

    public static FeatherManager m21372b(InjectorLike injectorLike) {
        FeatherManager featherManager = new FeatherManager();
        AbstractFbErrorReporter a = FbErrorReporterImpl.m2317a(injectorLike);
        FeatherQueryHelper featherQueryHelper = new FeatherQueryHelper();
        GraphQLQueryExecutor a2 = GraphQLQueryExecutor.m10435a(injectorLike);
        featherQueryHelper.f14941a = TasksManager.m14550b(injectorLike);
        featherQueryHelper.f14942b = a2;
        featherManager.m21371a(a, featherQueryHelper, DefaultSecureContextHelper.m4636a(injectorLike), SuggestEditsAnalyticsLogger.m21377a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike), FunnelLoggerImpl.m8018a(injectorLike));
        return featherManager;
    }

    public final boolean m21374a(String str) {
        return (Strings.isNullOrEmpty(str) || !str.equals(this.f14938h) || this.f14940j.isEmpty()) ? false : true;
    }

    public final void m21373a(Context context, PublishPostParams publishPostParams) {
        this.f14937g = System.nanoTime();
        if (publishPostParams.isCheckin && !Strings.isNullOrEmpty(publishPostParams.placeTag) && "post_check_in".equals(this.f14935e.mo581a(ExperimentsForCrowdsourcingAbTestModule.a, "none"))) {
            this.f14936f.m8033a(FunnelRegistry.f21153S);
            this.f14936f.m8043b(FunnelRegistry.f21153S, "checked_in");
            this.f14934d.m21380a(CrowdEntryPoint.FEATHER_POST_COMPOSE, Optional.of(publishPostParams.placeTag));
            String str = publishPostParams.placeTag;
            CrowdEntryPoint crowdEntryPoint = CrowdEntryPoint.FEATHER_POST_COMPOSE;
            this.f14936f.m8043b(FunnelRegistry.f21153S, "fetch_start");
            this.f14932b.m21375a(context, str, new 2(this, context, str, crowdEntryPoint));
        }
    }

    private void m21371a(AbstractFbErrorReporter abstractFbErrorReporter, FeatherQueryHelper featherQueryHelper, SecureContextHelper secureContextHelper, SuggestEditsAnalyticsLogger suggestEditsAnalyticsLogger, QeAccessor qeAccessor, FunnelLoggerImpl funnelLoggerImpl) {
        this.f14931a = abstractFbErrorReporter;
        this.f14932b = featherQueryHelper;
        this.f14933c = secureContextHelper;
        this.f14934d = suggestEditsAnalyticsLogger;
        this.f14935e = qeAccessor;
        this.f14936f = funnelLoggerImpl;
    }
}
