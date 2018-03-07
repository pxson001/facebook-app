package com.facebook.feedplugins.placetips;

import android.content.Context;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.time.TimeConversions;
import com.facebook.common.util.TriState;
import com.facebook.crowdsourcing.abtest.ExperimentsForCrowdsourcingAbTestModule;
import com.facebook.crowdsourcing.feather.FeatherManager;
import com.facebook.crowdsourcing.feather.FeatherManager.1;
import com.facebook.crowdsourcing.logging.CrowdEndpoint;
import com.facebook.crowdsourcing.logging.CrowdEntryPoint;
import com.facebook.crowdsourcing.logging.SuggestEditsAnalyticsLogger;
import com.facebook.feedplugins.placetips.graphql.SuggestifierQuestionVoteMutation.SuggestifierQuestionVoteMutationString;
import com.facebook.funnellogger.FunnelLogger;
import com.facebook.funnellogger.FunnelLoggerImpl;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.SuggestifierQuestionVoteInputData;
import com.facebook.graphql.calls.SuggestifierQuestionVoteInputData.LocationData;
import com.facebook.graphql.calls.SuggestifierQuestionVoteInputData.Sentiment;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.offlinemode.common.OfflineQueryBehavior;
import com.facebook.placetips.bootstrap.PresenceDescription;
import com.facebook.placetips.bootstrap.PresenceSource;
import com.facebook.placetips.bootstrap.PresenceSourceType;
import com.facebook.placetips.common.graphql.LocationTriggerWithReactionUnitsGraphQLModels.LocationTriggerWithReactionUnitsModel.UnitsModel.EventsModel;
import com.facebook.placetips.common.graphql.LocationTriggerWithReactionUnitsGraphQLModels.LocationTriggerWithReactionUnitsModel.UnitsModel.EventsModel.EventModel;
import com.facebook.placetips.logging.PlaceTipsAnalyticsEvent;
import com.facebook.placetips.logging.PlaceTipsAnalyticsLogger;
import com.facebook.placetips.presence.PagePresenceManager;
import com.facebook.placetips.upsell.PlaceTipsUpsellAnalyticsLogger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: max_child_depth */
public class PlaceTipsFeedUnitBinder {
    public static final String f14915a = PlaceTipsFeedUnitBinder.class.getSimpleName();
    public final AbstractFbErrorReporter f14916b;
    private final GatekeeperStoreImpl f14917c;
    private final GraphQLQueryExecutor f14918d;
    private final PlaceTipsAnalyticsLogger f14919e;
    public final PlaceTipsUpsellAnalyticsLogger f14920f;
    public final Provider<Boolean> f14921g;
    public final Provider<TriState> f14922h;
    private final Lazy<PagePresenceManager> f14923i;
    private final TasksManager f14924j;
    private final Clock f14925k;
    public final QeAccessor f14926l;
    public final FeatherManager f14927m;
    public final SuggestEditsAnalyticsLogger f14928n;
    public final FunnelLoggerImpl f14929o;
    @Nullable
    public Boolean f14930p;

    public static PlaceTipsFeedUnitBinder m21368b(InjectorLike injectorLike) {
        return new PlaceTipsFeedUnitBinder(FbErrorReporterImpl.m2317a(injectorLike), GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike), GraphQLQueryExecutor.m10435a(injectorLike), PlaceTipsAnalyticsLogger.m21246a(injectorLike), PlaceTipsUpsellAnalyticsLogger.m21331a(injectorLike), IdBasedProvider.m1811a(injectorLike, 4262), IdBasedProvider.m1811a(injectorLike, 640), IdBasedSingletonScopeProvider.m1810b(injectorLike, 3009), TasksManager.m14550b(injectorLike), SystemClockMethodAutoProvider.m1498a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike), FeatherManager.m21372b(injectorLike), SuggestEditsAnalyticsLogger.m21377a(injectorLike), FunnelLoggerImpl.m8018a(injectorLike));
    }

    @Inject
    public PlaceTipsFeedUnitBinder(FbErrorReporter fbErrorReporter, GatekeeperStore gatekeeperStore, GraphQLQueryExecutor graphQLQueryExecutor, PlaceTipsAnalyticsLogger placeTipsAnalyticsLogger, PlaceTipsUpsellAnalyticsLogger placeTipsUpsellAnalyticsLogger, Provider<Boolean> provider, Provider<TriState> provider2, Lazy<PagePresenceManager> lazy, TasksManager tasksManager, Clock clock, QeAccessor qeAccessor, FeatherManager featherManager, SuggestEditsAnalyticsLogger suggestEditsAnalyticsLogger, FunnelLogger funnelLogger) {
        this.f14916b = fbErrorReporter;
        this.f14917c = gatekeeperStore;
        this.f14918d = graphQLQueryExecutor;
        this.f14919e = placeTipsAnalyticsLogger;
        this.f14920f = placeTipsUpsellAnalyticsLogger;
        this.f14921g = provider;
        this.f14922h = provider2;
        this.f14923i = lazy;
        this.f14924j = tasksManager;
        this.f14925k = clock;
        this.f14926l = qeAccessor;
        this.f14927m = featherManager;
        this.f14928n = suggestEditsAnalyticsLogger;
        this.f14929o = funnelLogger;
    }

    public final void m21369a(PresenceDescription presenceDescription, PlaceTipsFeedUnitView placeTipsFeedUnitView) {
        PresenceSourceType presenceSourceType = null;
        placeTipsFeedUnitView.a();
        placeTipsFeedUnitView.setTitle(presenceDescription.b());
        placeTipsFeedUnitView.setSubText(presenceDescription.c());
        placeTipsFeedUnitView.setIconImage(null);
        if (this.f14930p == null) {
            boolean z = ((Boolean) this.f14921g.get()).booleanValue() && ((TriState) this.f14922h.get()).asBoolean(false);
            this.f14930p = Boolean.valueOf(z);
        }
        if (this.f14930p.booleanValue()) {
            presenceSourceType = presenceDescription.l();
        }
        placeTipsFeedUnitView.setSourceText(presenceSourceType);
        m21367a(placeTipsFeedUnitView, presenceDescription);
        this.f14919e.m21257a(PlaceTipsAnalyticsEvent.FEED_UNIT_VPV, presenceDescription.l(), presenceDescription.i(), presenceDescription.d());
    }

    public final void m21370a(EventsModel eventsModel, PlaceTipsFeedUnitView placeTipsFeedUnitView) {
        placeTipsFeedUnitView.a();
        EventModel eventModel = (EventModel) Preconditions.checkNotNull(eventsModel.a());
        placeTipsFeedUnitView.setTitle(eventsModel.b());
        placeTipsFeedUnitView.setSubText(null);
        placeTipsFeedUnitView.setSourceText(null);
        if (eventModel.c() != null) {
            placeTipsFeedUnitView.setIconImage(eventModel.c().mo2924b());
        } else {
            placeTipsFeedUnitView.setIconImage(null);
        }
        this.f14919e.m21257a(PlaceTipsAnalyticsEvent.EVENT_TIP_VIEW, PresenceSourceType.GPS, eventModel.b(), false);
    }

    private void m21367a(PlaceTipsFeedUnitView placeTipsFeedUnitView, PresenceDescription presenceDescription) {
        if (presenceDescription.d() && presenceDescription.i() != null && this.f14917c.m2189a(1055, false)) {
            if ("place_tip".equals(this.f14926l.mo581a(ExperimentsForCrowdsourcingAbTestModule.a, "none"))) {
                FeatherManager featherManager = this.f14927m;
                Context context = placeTipsFeedUnitView.getContext();
                String i = presenceDescription.i();
                featherManager.f14936f.m8033a(FunnelRegistry.f21153S);
                featherManager.f14936f.m8043b(FunnelRegistry.f21153S, "prefetch_start");
                featherManager.f14932b.m21375a(context, i, new 1(featherManager, i));
            }
            placeTipsFeedUnitView.setFooterView(new PlaceTipsFooterQuestionView(placeTipsFeedUnitView.getContext(), presenceDescription.e(), presenceDescription.f(), this.f14926l.mo596a(ExperimentsForCrowdsourcingAbTestModule.b, true), new 1(this, presenceDescription, placeTipsFeedUnitView)));
        }
    }

    public static void m21366a(PlaceTipsFeedUnitBinder placeTipsFeedUnitBinder, PresenceDescription presenceDescription, Sentiment sentiment) {
        SuggestifierQuestionVoteInputData suggestifierQuestionVoteInputData = new SuggestifierQuestionVoteInputData();
        suggestifierQuestionVoteInputData.m11397a("endpoint", CrowdEndpoint.SUGGESTIFIER_VOTING.getFullName());
        GraphQlCallInput graphQlCallInput = suggestifierQuestionVoteInputData;
        graphQlCallInput.m11397a("entry_point", CrowdEntryPoint.PLACE_TIPS.getFullName());
        graphQlCallInput = graphQlCallInput;
        graphQlCallInput.m11397a("page_id", presenceDescription.i());
        graphQlCallInput = graphQlCallInput;
        graphQlCallInput.m11395a("sentiment", (Enum) sentiment);
        graphQlCallInput = graphQlCallInput;
        graphQlCallInput.m11397a("suggetifier_response_id", presenceDescription.o());
        graphQlCallInput = graphQlCallInput;
        graphQlCallInput.m11393a("location_data", placeTipsFeedUnitBinder.m21365a(presenceDescription));
        graphQlCallInput = graphQlCallInput;
        TypedGraphQLMutationString suggestifierQuestionVoteMutationString = new SuggestifierQuestionVoteMutationString();
        suggestifierQuestionVoteMutationString.m11310a("input", graphQlCallInput);
        placeTipsFeedUnitBinder.f14924j.m14553a((Object) "submit_suggestifier_answer", placeTipsFeedUnitBinder.f14918d.m10449a(GraphQLRequest.m11588a(suggestifierQuestionVoteMutationString), OfflineQueryBehavior.b), new 2(placeTipsFeedUnitBinder));
    }

    private LocationData m21365a(PresenceDescription presenceDescription) {
        int intValue;
        double doubleValue;
        double d = 0.0d;
        PresenceSource k = presenceDescription.k();
        LocationData locationData = new LocationData();
        if (k.b() != null) {
            intValue = k.b().intValue();
        } else {
            intValue = 0;
        }
        locationData.m11396a("pulsar_rssi", Integer.valueOf(intValue));
        GraphQlCallInput graphQlCallInput = locationData;
        if (k.c() != null) {
            doubleValue = k.c().doubleValue();
        } else {
            doubleValue = 0.0d;
        }
        graphQlCallInput.m11394a("latitude", Double.valueOf(doubleValue));
        graphQlCallInput = graphQlCallInput;
        if (k.d() != null) {
            doubleValue = k.d().doubleValue();
        } else {
            doubleValue = 0.0d;
        }
        graphQlCallInput.m11394a("longitude", Double.valueOf(doubleValue));
        GraphQlCallInput graphQlCallInput2 = graphQlCallInput;
        graphQlCallInput2.m11396a("client_current_time", Integer.valueOf((int) TimeConversions.m11973m(this.f14925k.mo211a())));
        graphQlCallInput2 = graphQlCallInput2;
        graphQlCallInput2.m11396a("client_location_time", Integer.valueOf((int) (presenceDescription.a() / 1000)));
        graphQlCallInput = graphQlCallInput2;
        if (k.e() != null) {
            doubleValue = k.e().doubleValue();
        } else {
            doubleValue = 0.0d;
        }
        graphQlCallInput.m11394a("horizontal_accuracy", Double.valueOf(doubleValue));
        graphQlCallInput2 = graphQlCallInput;
        if (k.e() != null) {
            d = k.e().doubleValue();
        }
        graphQlCallInput2.m11394a("vertical_accuracy", Double.valueOf(d));
        return graphQlCallInput2;
    }
}
