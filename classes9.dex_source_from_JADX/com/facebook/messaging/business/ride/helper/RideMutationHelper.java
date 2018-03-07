package com.facebook.messaging.business.ride.helper;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.facebook.common.android.InputMethodManagerMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.fbservice.ops.DialogBasedProgressIndicator;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.RideCancelInputData;
import com.facebook.graphql.calls.RideRequestCreateInputData;
import com.facebook.graphql.calls.RideRequestCreateInputData.Destination;
import com.facebook.graphql.calls.RideRequestCreateInputData.Origin;
import com.facebook.graphql.enums.GraphQLRideRequestOutcome;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.business.common.helper.BusinessMessageDialogHelper;
import com.facebook.messaging.business.ride.analytics.RideAnalyticsLogger;
import com.facebook.messaging.business.ride.graphql.RideMutaions.RideCancelMutationString;
import com.facebook.messaging.business.ride.graphql.RideMutaions.RideRequestMutationString;
import com.facebook.messaging.business.ride.graphql.RideMutaionsModels.RideCancelMutationModel;
import com.facebook.messaging.business.ride.graphql.RideMutaionsModels.RideRequestMutationModel;
import com.facebook.messaging.business.ride.graphql.RideMutaionsModels.RideRequestMutationModel.SurgeEstimateModel;
import com.facebook.messaging.business.ride.graphql.RideMutaionsModels.RideSignupMessageMutationModel;
import com.facebook.messaging.business.ride.view.RideRequestFragment;
import com.facebook.messaging.business.ride.view.RideRequestFragment.C10976;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.facebook.widget.text.BetterEditTextView;
import com.facebook.widget.text.BetterTextView;
import com.google.common.base.Strings;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;

/* compiled from: moments_invite_clicked */
public class RideMutationHelper {
    public static final String f9194a = RideMutationHelper.class.getSimpleName();
    public final Context f9195b;
    public final AbstractFbErrorReporter f9196c;
    public final GraphQLQueryExecutor f9197d;
    public final ExecutorService f9198e;
    public final InputMethodManager f9199f;
    public final BusinessMessageDialogHelper f9200g;
    public final RideAnalyticsLogger f9201h;
    public ListenableFuture<GraphQLResult<RideRequestMutationModel>> f9202i;
    public ListenableFuture<GraphQLResult<RideCancelMutationModel>> f9203j;
    public ListenableFuture<GraphQLResult<RideSignupMessageMutationModel>> f9204k;
    private DialogBasedProgressIndicator f9205l;
    @GuardedBy("ui-thread")
    public C10976 f9206m;

    /* compiled from: moments_invite_clicked */
    public class AnonymousClass10 implements OnClickListener {
        final /* synthetic */ String f9177a;
        final /* synthetic */ RideMutationHelper f9178b;

        public AnonymousClass10(RideMutationHelper rideMutationHelper, String str) {
            this.f9178b = rideMutationHelper;
            this.f9177a = str;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f9178b.m9717a(this.f9177a);
        }
    }

    /* compiled from: moments_invite_clicked */
    class C10532 implements FutureCallback<GraphQLResult<RideCancelMutationModel>> {
        final /* synthetic */ RideMutationHelper f9181a;

        C10532(RideMutationHelper rideMutationHelper) {
            this.f9181a = rideMutationHelper;
        }

        public void onSuccess(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            RideMutationHelper.m9713b(this.f9181a);
            this.f9181a.f9203j = null;
            if (graphQLResult == null || graphQLResult.e == null || ((RideCancelMutationModel) graphQLResult.e).m9378j() == null) {
                this.f9181a.f9196c.a(RideMutationHelper.f9194a, "Get wrong ride cancel mutation result");
                this.f9181a.f9200g.m9019a();
            } else if (((RideCancelMutationModel) graphQLResult.e).m9378j() == GraphQLRideRequestOutcome.SUCCESS) {
                this.f9181a.f9200g.m9020a(this.f9181a.f9195b.getString(2131240753));
            } else if (!Strings.isNullOrEmpty(((RideCancelMutationModel) graphQLResult.e).m9377a())) {
                this.f9181a.f9200g.m9020a(((RideCancelMutationModel) graphQLResult.e).m9377a());
            }
        }

        public void onFailure(Throwable th) {
            RideMutationHelper.m9713b(this.f9181a);
            this.f9181a.f9203j = null;
            this.f9181a.f9200g.m9019a();
            this.f9181a.f9196c.a(RideMutationHelper.f9194a, "Can't get ride cancel mutation result", th);
        }
    }

    /* compiled from: moments_invite_clicked */
    public class C10543 implements FutureCallback<GraphQLResult<RideSignupMessageMutationModel>> {
        final /* synthetic */ RideMutationHelper f9182a;

        public C10543(RideMutationHelper rideMutationHelper) {
            this.f9182a = rideMutationHelper;
        }

        public void onSuccess(@Nullable Object obj) {
            this.f9182a.f9204k = null;
        }

        public void onFailure(Throwable th) {
            this.f9182a.f9204k = null;
            this.f9182a.f9196c.a(RideMutationHelper.f9194a, "Fail to send signup welcome message", th);
        }
    }

    /* compiled from: moments_invite_clicked */
    class C10555 implements OnClickListener {
        final /* synthetic */ RideMutationHelper f9183a;

        C10555(RideMutationHelper rideMutationHelper) {
            this.f9183a = rideMutationHelper;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    /* compiled from: moments_invite_clicked */
    public class C10577 implements OnClickListener {
        final /* synthetic */ RideMutationHelper f9187a;

        public C10577(RideMutationHelper rideMutationHelper) {
            this.f9187a = rideMutationHelper;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f9187a.f9201h.m9369b("click_cancel_in_surge_dialog");
            dialogInterface.dismiss();
        }
    }

    /* compiled from: moments_invite_clicked */
    public class C10588 implements OnClickListener {
        final /* synthetic */ String f9188a;
        final /* synthetic */ BetterEditTextView f9189b;
        final /* synthetic */ RideRequestParam f9190c;
        final /* synthetic */ SurgeEstimateModel f9191d;
        final /* synthetic */ RideMutationHelper f9192e;

        public C10588(RideMutationHelper rideMutationHelper, String str, BetterEditTextView betterEditTextView, RideRequestParam rideRequestParam, SurgeEstimateModel surgeEstimateModel) {
            this.f9192e = rideMutationHelper;
            this.f9188a = str;
            this.f9189b = betterEditTextView;
            this.f9190c = rideRequestParam;
            this.f9191d = surgeEstimateModel;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f9192e.f9201h.m9369b("click_confirm_in_surge_dialog");
            if (this.f9188a.equals(this.f9189b.getText().toString())) {
                this.f9190c.f9273l = this.f9191d.m9394j();
                this.f9192e.m9716a(this.f9190c);
                return;
            }
            this.f9192e.f9199f.hideSoftInputFromWindow(this.f9189b.getWindowToken(), 0);
            this.f9192e.f9200g.m9020a(this.f9192e.f9195b.getString(2131240740));
        }
    }

    /* compiled from: moments_invite_clicked */
    public class C10599 implements OnClickListener {
        final /* synthetic */ RideMutationHelper f9193a;

        public C10599(RideMutationHelper rideMutationHelper) {
            this.f9193a = rideMutationHelper;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public static RideMutationHelper m9712b(InjectorLike injectorLike) {
        return new RideMutationHelper((Context) injectorLike.getInstance(Context.class), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), InputMethodManagerMethodAutoProvider.b(injectorLike), BusinessMessageDialogHelper.m9018b(injectorLike), RideAnalyticsLogger.m9362b(injectorLike), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public RideMutationHelper(Context context, AbstractFbErrorReporter abstractFbErrorReporter, GraphQLQueryExecutor graphQLQueryExecutor, InputMethodManager inputMethodManager, BusinessMessageDialogHelper businessMessageDialogHelper, RideAnalyticsLogger rideAnalyticsLogger, ExecutorService executorService) {
        this.f9195b = context;
        this.f9196c = abstractFbErrorReporter;
        this.f9197d = graphQLQueryExecutor;
        this.f9199f = inputMethodManager;
        this.f9200g = businessMessageDialogHelper;
        this.f9201h = rideAnalyticsLogger;
        this.f9198e = executorService;
    }

    public final void m9716a(final RideRequestParam rideRequestParam) {
        if (this.f9202i == null) {
            m9714d(this.f9195b.getString(2131240730));
            RideRequestCreateInputData rideRequestCreateInputData = new RideRequestCreateInputData();
            rideRequestCreateInputData.a("thread_id", rideRequestParam.f9262a);
            rideRequestCreateInputData.a("ride_provider_name", rideRequestParam.f9263b);
            rideRequestCreateInputData.a("ride_display_name", rideRequestParam.f9264c);
            rideRequestCreateInputData.a("ride_id", rideRequestParam.f9265d);
            Origin origin = new Origin();
            origin.a("latitude", Double.valueOf(rideRequestParam.f9266e.getLatitude()));
            GraphQlCallInput graphQlCallInput = origin;
            graphQlCallInput.a("longitude", Double.valueOf(rideRequestParam.f9266e.getLongitude()));
            rideRequestCreateInputData.a("origin", graphQlCallInput);
            if (rideRequestParam.f9267f != null) {
                Destination destination = new Destination();
                destination.a("latitude", Double.valueOf(rideRequestParam.f9267f.getLatitude()));
                graphQlCallInput = destination;
                graphQlCallInput.a("longitude", Double.valueOf(rideRequestParam.f9267f.getLongitude()));
                rideRequestCreateInputData.a("destination", graphQlCallInput);
            }
            rideRequestCreateInputData.a("origin_address", rideRequestParam.f9268g);
            rideRequestCreateInputData.a("destination_address", rideRequestParam.f9270i);
            if (!Strings.isNullOrEmpty(rideRequestParam.f9269h)) {
                rideRequestCreateInputData.a("origin_place_id", rideRequestParam.f9269h);
            }
            if (!Strings.isNullOrEmpty(rideRequestParam.f9271j)) {
                rideRequestCreateInputData.a("destination_place_id", rideRequestParam.f9271j);
            }
            if (!Strings.isNullOrEmpty(rideRequestParam.f9272k)) {
                rideRequestCreateInputData.a("payment_credential_id", rideRequestParam.f9272k);
            }
            rideRequestCreateInputData.a("surge_confirmation_id", rideRequestParam.f9273l);
            GraphQlCallInput graphQlCallInput2 = rideRequestCreateInputData;
            GraphQlQueryString rideRequestMutationString = new RideRequestMutationString();
            rideRequestMutationString.a("input", graphQlCallInput2);
            this.f9202i = this.f9197d.a(GraphQLRequest.a(rideRequestMutationString));
            Futures.a(this.f9202i, new FutureCallback<GraphQLResult<RideRequestMutationModel>>(this) {
                final /* synthetic */ RideMutationHelper f9180b;

                public void onSuccess(@Nullable Object obj) {
                    GraphQLResult graphQLResult = (GraphQLResult) obj;
                    RideMutationHelper.m9713b(this.f9180b);
                    this.f9180b.f9202i = null;
                    if (graphQLResult == null || graphQLResult.e == null || ((RideRequestMutationModel) graphQLResult.e).m9400j() == null) {
                        this.f9180b.f9196c.a(RideMutationHelper.f9194a, "Get wrong ride request mutation result");
                        this.f9180b.f9200g.m9019a();
                        return;
                    }
                    GraphQLRideRequestOutcome j = ((RideRequestMutationModel) graphQLResult.e).m9400j();
                    C10976 c10976;
                    if (j == GraphQLRideRequestOutcome.SUCCESS) {
                        c10976 = this.f9180b.f9206m;
                        ((RideRequestMutationModel) graphQLResult.e).m9401k();
                        RideAnalyticsLogger rideAnalyticsLogger = c10976.f9399a.f9408f;
                        rideAnalyticsLogger.m9369b("success_request_ride");
                        rideAnalyticsLogger.f9056b.b(FunnelRegistry.q);
                        c10976.f9399a.as = true;
                        RideRequestFragment.aH(c10976.f9399a);
                        c10976.f9399a.ao().onBackPressed();
                    } else if (j == GraphQLRideRequestOutcome.SURGE_ACCEPTANCE_FLOW_NEEDED) {
                        this.f9180b.m9715a(((RideRequestMutationModel) graphQLResult.e).m9402l(), rideRequestParam);
                    } else if (j == GraphQLRideRequestOutcome.ADDING_PAYMENT_NEEDED || j == GraphQLRideRequestOutcome.ERROR_INVALID_PAYMENT_INFORMATION || j == GraphQLRideRequestOutcome.ERROR_UPDATE_PAYMENT) {
                        CharSequence string;
                        c10976 = this.f9180b.f9206m;
                        if (Strings.isNullOrEmpty(((RideRequestMutationModel) graphQLResult.e).m9399a())) {
                            string = this.f9180b.f9195b.getString(2131240774);
                        } else {
                            string = ((RideRequestMutationModel) graphQLResult.e).m9399a();
                        }
                        RideRequestFragment rideRequestFragment = c10976.f9399a;
                        if (rideRequestFragment.ay) {
                            rideRequestFragment.f9408f.m9369b("show_payment_error_dialog");
                            new FbAlertDialogBuilder(rideRequestFragment.getContext()).b(string).a(rideRequestFragment.jW_().getString(2131230730), new OnClickListener(rideRequestFragment) {
                                final /* synthetic */ RideRequestFragment f9393a;

                                {
                                    this.f9393a = r1;
                                }

                                public void onClick(DialogInterface dialogInterface, int i) {
                                    this.f9393a.f9408f.m9369b("click_update_in_payment_error_dialog");
                                    dialogInterface.dismiss();
                                    RideRequestFragment.aJ(this.f9393a);
                                }
                            }).b(rideRequestFragment.jW_().getString(2131230727), new OnClickListener(rideRequestFragment) {
                                final /* synthetic */ RideRequestFragment f9392a;

                                {
                                    this.f9392a = r1;
                                }

                                public void onClick(DialogInterface dialogInterface, int i) {
                                    this.f9392a.f9408f.m9369b("click_cancel_in_payment_error_dialog");
                                    dialogInterface.dismiss();
                                }
                            }).b();
                        } else {
                            rideRequestFragment.ao.m9020a(string);
                        }
                    } else if (!Strings.isNullOrEmpty(((RideRequestMutationModel) graphQLResult.e).m9399a())) {
                        this.f9180b.f9200g.m9020a(((RideRequestMutationModel) graphQLResult.e).m9399a());
                    }
                }

                public void onFailure(Throwable th) {
                    RideMutationHelper.m9713b(this.f9180b);
                    this.f9180b.f9202i = null;
                    this.f9180b.f9200g.m9019a();
                    this.f9180b.f9196c.a(RideMutationHelper.f9194a, "Can't get request mutation result", th);
                }
            }, this.f9198e);
        }
    }

    public final void m9717a(String str) {
        if (this.f9203j == null) {
            m9714d(this.f9195b.getString(2131240731));
            RideCancelInputData rideCancelInputData = new RideCancelInputData();
            rideCancelInputData.a("ride_request_fbid", str);
            GraphQlQueryString rideCancelMutationString = new RideCancelMutationString();
            rideCancelMutationString.a("input", rideCancelInputData);
            this.f9203j = this.f9197d.a(GraphQLRequest.a(rideCancelMutationString));
            Futures.a(this.f9203j, new C10532(this), this.f9198e);
        }
    }

    public final void m9715a(@Nullable final SurgeEstimateModel surgeEstimateModel, final RideRequestParam rideRequestParam) {
        if (surgeEstimateModel == null) {
            this.f9200g.m9019a();
            return;
        }
        View inflate = LayoutInflater.from(this.f9195b).inflate(2130906897, null);
        BetterTextView betterTextView = (BetterTextView) inflate.findViewById(2131567089);
        ((BetterTextView) inflate.findViewById(2131567087)).setText(this.f9195b.getString(2131240738, new Object[]{String.valueOf(surgeEstimateModel.m9395k())}));
        if (Strings.isNullOrEmpty(surgeEstimateModel.m9392a())) {
            betterTextView.setVisibility(8);
        } else {
            betterTextView.setText(this.f9195b.getString(2131240739, new Object[]{surgeEstimateModel.m9392a()}));
        }
        new FbAlertDialogBuilder(this.f9195b).b(inflate).a(this.f9195b.getResources().getString(2131240735), new OnClickListener(this) {
            final /* synthetic */ RideMutationHelper f9186c;

            public void onClick(DialogInterface dialogInterface, int i) {
                if (surgeEstimateModel.m9395k() >= surgeEstimateModel.m9396l()) {
                    RideMutationHelper rideMutationHelper = this.f9186c;
                    SurgeEstimateModel surgeEstimateModel = surgeEstimateModel;
                    RideRequestParam rideRequestParam = rideRequestParam;
                    rideMutationHelper.f9201h.m9369b("show_surge_dialog");
                    View inflate = LayoutInflater.from(rideMutationHelper.f9195b).inflate(2130906896, null);
                    Object valueOf = String.valueOf(surgeEstimateModel.m9395k());
                    ((BetterTextView) inflate.findViewById(2131567085)).setText(rideMutationHelper.f9195b.getResources().getString(2131240741, new Object[]{valueOf}));
                    BetterEditTextView betterEditTextView = (BetterEditTextView) inflate.findViewById(2131567086);
                    betterEditTextView.setHint(valueOf);
                    AlertDialog a = new FbAlertDialogBuilder(rideMutationHelper.f9195b).b(inflate).a(rideMutationHelper.f9195b.getResources().getString(2131230729), new C10588(rideMutationHelper, valueOf, betterEditTextView, rideRequestParam, surgeEstimateModel)).b(rideMutationHelper.f9195b.getString(2131230727), new C10577(rideMutationHelper)).a(false).a();
                    a.getWindow().setSoftInputMode(4);
                    a.show();
                    return;
                }
                rideRequestParam.f9273l = surgeEstimateModel.m9394j();
                this.f9186c.m9716a(rideRequestParam);
            }
        }).b(this.f9195b.getString(2131230727), new C10555(this)).a(false).b();
    }

    private void m9714d(String str) {
        this.f9205l = new DialogBasedProgressIndicator(this.f9195b, str);
        this.f9205l.a();
    }

    public static void m9713b(RideMutationHelper rideMutationHelper) {
        if (rideMutationHelper.f9205l != null) {
            rideMutationHelper.f9205l.b();
        }
    }
}
