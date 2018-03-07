package com.facebook.friendsnearby.ui;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.crowdsourcing.enums.CrowdsourcingFieldType;
import com.facebook.crowdsourcing.protocol.graphql.CrowdsourcingLocationFeedbackMutations.CrowdsourcingUnknownRegionClaimString;
import com.facebook.crowdsourcing.protocol.graphql.CrowdsourcingLocationFeedbackMutations.CrowdsourcingWrongRegionReportString;
import com.facebook.crowdsourcing.protocol.graphql.CrowdsourcingLocationFeedbackMutationsModels.CrowdsourcingUnknownRegionClaimModel;
import com.facebook.crowdsourcing.protocol.graphql.CrowdsourcingLocationFeedbackMutationsModels.CrowdsourcingWrongRegionReportModel;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.fbui.menu.PopoverMenu;
import com.facebook.fig.menu.FigPopoverMenuWindow;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryInterfaces.FriendsNearbyLocationSharingFields.NearbyFriendsRegion;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryModels.FriendsNearbyLocationSharingFieldsModel.NearbyFriendsRegionModel;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.calls.CrowdsourcingCreateClaimInputData;
import com.facebook.graphql.calls.CrowdsourcingCreateClaimInputData.Action;
import com.facebook.graphql.calls.CrowdsourcingCreateClaimInputData.Endpoint;
import com.facebook.graphql.calls.CrowdsourcingCreateClaimInputData.EntryPoint;
import com.facebook.graphql.calls.CrowdsourcingCreateClaimInputData.Sentiment;
import com.facebook.graphql.calls.CrowdsourcingRegionReportIncorrectInputData;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.InjectorLike;
import com.facebook.location.ImmutableLocation;
import com.facebook.location.LocationAgeUtil;
import com.facebook.offlinemode.common.OfflineQueryBehavior;
import com.facebook.ui.futures.TasksManager;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: You must provide a caller context */
public class FriendsNearbyDashboardActionButtonHandler {
    public final TasksManager<String> f20809a;
    public final GraphQLQueryExecutor f20810b;
    public final AbstractFbErrorReporter f20811c;
    private final GatekeeperStoreImpl f20812d;
    public final LocationAgeUtil f20813e;
    public final FriendsNearbyDashboardAnalyticsLogger f20814f;

    /* compiled from: You must provide a caller context */
    public class C29543 extends AbstractDisposableFutureCallback<GraphQLResult<CrowdsourcingWrongRegionReportModel>> {
        final /* synthetic */ FriendsNearbyDashboardActionButtonHandler f20807a;

        public C29543(FriendsNearbyDashboardActionButtonHandler friendsNearbyDashboardActionButtonHandler) {
            this.f20807a = friendsNearbyDashboardActionButtonHandler;
        }

        protected final void m21691a(Throwable th) {
            this.f20807a.f20811c.a("nearby_friends_self_view_wrong_region_feedback_fail", th);
        }
    }

    /* compiled from: You must provide a caller context */
    class C29554 extends AbstractDisposableFutureCallback<GraphQLResult<CrowdsourcingUnknownRegionClaimModel>> {
        final /* synthetic */ FriendsNearbyDashboardActionButtonHandler f20808a;

        C29554(FriendsNearbyDashboardActionButtonHandler friendsNearbyDashboardActionButtonHandler) {
            this.f20808a = friendsNearbyDashboardActionButtonHandler;
        }

        protected final void m21693a(Throwable th) {
            this.f20808a.f20811c.a("nearby_friends_self_view_unknown_region_feedback_fail", th);
        }
    }

    /* compiled from: You must provide a caller context */
    public class FeedbackConfirmDialogFragment extends DialogFragment {
        public final Dialog m21694c(Bundle bundle) {
            Context context = getContext();
            return new Builder(context).a(2131242037).b(2131242038).a(context.getString(2131230726), null).a();
        }
    }

    public static FriendsNearbyDashboardActionButtonHandler m21695a(InjectorLike injectorLike) {
        return new FriendsNearbyDashboardActionButtonHandler(TasksManager.b(injectorLike), GraphQLQueryExecutor.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), LocationAgeUtil.a(injectorLike), FriendsNearbyDashboardAnalyticsLogger.m21698a(injectorLike));
    }

    @Inject
    public FriendsNearbyDashboardActionButtonHandler(TasksManager tasksManager, GraphQLQueryExecutor graphQLQueryExecutor, AbstractFbErrorReporter abstractFbErrorReporter, GatekeeperStoreImpl gatekeeperStoreImpl, LocationAgeUtil locationAgeUtil, FriendsNearbyDashboardAnalyticsLogger friendsNearbyDashboardAnalyticsLogger) {
        this.f20809a = tasksManager;
        this.f20810b = graphQLQueryExecutor;
        this.f20811c = abstractFbErrorReporter;
        this.f20812d = gatekeeperStoreImpl;
        this.f20813e = locationAgeUtil;
        this.f20814f = friendsNearbyDashboardAnalyticsLogger;
    }

    public final void m21697a(View view, FragmentManager fragmentManager, long j, NearbyFriendsRegion nearbyFriendsRegion, Optional<ImmutableLocation> optional) {
        Preconditions.checkNotNull(nearbyFriendsRegion);
        Preconditions.checkNotNull(nearbyFriendsRegion.m21286a());
        Preconditions.checkNotNull(nearbyFriendsRegion.m21288b());
        Context context = view.getContext();
        String a = nearbyFriendsRegion.m21286a().m21273a();
        FigPopoverMenuWindow figPopoverMenuWindow = new FigPopoverMenuWindow(context);
        PopoverMenu c = figPopoverMenuWindow.c();
        final FragmentManager fragmentManager2 = fragmentManager;
        final long j2 = j;
        final NearbyFriendsRegionModel nearbyFriendsRegionModel = nearbyFriendsRegion;
        final Optional<ImmutableLocation> optional2 = optional;
        c.a(context.getString(2131242033), context.getString(2131242034, new Object[]{a})).setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
            final /* synthetic */ FriendsNearbyDashboardActionButtonHandler f20802e;

            public boolean onMenuItemClick(MenuItem menuItem) {
                this.f20802e.f20814f.m21708d();
                new FeedbackConfirmDialogFragment().a(fragmentManager2, "feedback_confirm_dialog");
                FriendsNearbyDashboardActionButtonHandler friendsNearbyDashboardActionButtonHandler = this.f20802e;
                long j = j2;
                NearbyFriendsRegionModel nearbyFriendsRegionModel = nearbyFriendsRegionModel;
                Optional optional = optional2;
                if (optional.isPresent()) {
                    ImmutableLocation immutableLocation = (ImmutableLocation) optional.get();
                    GraphQlQueryString crowdsourcingWrongRegionReportString = new CrowdsourcingWrongRegionReportString();
                    CrowdsourcingRegionReportIncorrectInputData crowdsourcingRegionReportIncorrectInputData = new CrowdsourcingRegionReportIncorrectInputData();
                    crowdsourcingRegionReportIncorrectInputData.a("region_id", nearbyFriendsRegionModel.m21288b().m21281b());
                    crowdsourcingRegionReportIncorrectInputData.a("latitude", Double.valueOf(immutableLocation.a()));
                    crowdsourcingRegionReportIncorrectInputData.a("longitude", Double.valueOf(immutableLocation.b()));
                    crowdsourcingRegionReportIncorrectInputData.a("accuracy_meters", Double.valueOf(((Float) immutableLocation.c().or(Float.valueOf(0.0f))).doubleValue()));
                    crowdsourcingRegionReportIncorrectInputData.a("age_seconds", Double.valueOf(((double) friendsNearbyDashboardActionButtonHandler.f20813e.a(immutableLocation)) / 1000.0d));
                    crowdsourcingWrongRegionReportString.a("input", crowdsourcingRegionReportIncorrectInputData);
                    friendsNearbyDashboardActionButtonHandler.f20809a.a("wrong_region_feedback" + j, friendsNearbyDashboardActionButtonHandler.f20810b.a(GraphQLRequest.a(crowdsourcingWrongRegionReportString), OfflineQueryBehavior.b), new C29543(friendsNearbyDashboardActionButtonHandler));
                } else {
                    friendsNearbyDashboardActionButtonHandler.f20811c.a("nearby_friends_self_view_fetch_location_fail", "Failed to fetch location for feedback");
                }
                return true;
            }
        });
        fragmentManager2 = fragmentManager;
        j2 = j;
        nearbyFriendsRegionModel = nearbyFriendsRegion;
        c.a(context.getString(2131242035), context.getString(2131242036, new Object[]{a})).setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
            final /* synthetic */ FriendsNearbyDashboardActionButtonHandler f20806d;

            public boolean onMenuItemClick(MenuItem menuItem) {
                this.f20806d.f20814f.m21710e();
                new FeedbackConfirmDialogFragment().a(fragmentManager2, "feedback_confirm_dialog");
                FriendsNearbyDashboardActionButtonHandler.m21696a(this.f20806d, j2, nearbyFriendsRegionModel);
                return true;
            }
        });
        figPopoverMenuWindow.a(true);
        figPopoverMenuWindow.f(view);
    }

    public static void m21696a(FriendsNearbyDashboardActionButtonHandler friendsNearbyDashboardActionButtonHandler, long j, NearbyFriendsRegionModel nearbyFriendsRegionModel) {
        ImmutableList c = nearbyFriendsRegionModel.m21289c();
        if (c.isEmpty()) {
            friendsNearbyDashboardActionButtonHandler.f20811c.a("nearby_friends_self_view_region_topic_id_empty", "Region topic id is empty");
            return;
        }
        int size = c.size();
        for (int i = 0; i < size; i++) {
            String str = (String) c.get(i);
            GraphQlQueryString crowdsourcingUnknownRegionClaimString = new CrowdsourcingUnknownRegionClaimString();
            CrowdsourcingCreateClaimInputData crowdsourcingCreateClaimInputData = new CrowdsourcingCreateClaimInputData();
            ObjectNode a = new ObjectNode(JsonNodeFactory.a).a("hub_id", str);
            crowdsourcingCreateClaimInputData.a(Long.toString(j));
            crowdsourcingCreateClaimInputData.b(nearbyFriendsRegionModel.m21288b().m21281b());
            crowdsourcingCreateClaimInputData.c(Long.toString(CrowdsourcingFieldType.PLACE_TOPIC.getValue()));
            crowdsourcingCreateClaimInputData.d(a.toString());
            crowdsourcingCreateClaimInputData.a(Sentiment.DISAGREE);
            crowdsourcingCreateClaimInputData.a(Action.VOTE);
            crowdsourcingCreateClaimInputData.a(Endpoint.ANDROID_NEARBY_FRIENDS_SELF_VIEW_UNKNOWN_REGION);
            crowdsourcingCreateClaimInputData.a(EntryPoint.ANDROID_NEARBY_FRIENDS_SELF_VIEW_CONTEXT_MENU);
            crowdsourcingUnknownRegionClaimString.a("input", crowdsourcingCreateClaimInputData);
            friendsNearbyDashboardActionButtonHandler.f20809a.a("unknown_region_feedback" + j + str, friendsNearbyDashboardActionButtonHandler.f20810b.a(GraphQLRequest.a(crowdsourcingUnknownRegionClaimString), OfflineQueryBehavior.b), new C29554(friendsNearbyDashboardActionButtonHandler));
        }
    }
}
