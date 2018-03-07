package com.facebook.crowdsourcing.placequestion;

import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Checkable;
import com.facebook.analytics.CurationSurface;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.util.SeparatedSpannableStringBuilder;
import com.facebook.crowdsourcing.protocol.graphql.PlaceQuestionFragmentsModels.PlaceQuestionAnswerFieldsModel;
import com.facebook.crowdsourcing.protocol.graphql.PlaceQuestionFragmentsModels.PlaceQuestionFieldsModel;
import com.facebook.crowdsourcing.protocol.graphql.PlaceQuestionFragmentsModels.PlaceQuestionFieldsModel.PlaceQuestionPlaceModel;
import com.facebook.crowdsourcing.protocol.graphql.PlaceQuestionMutations.PlaceQuestionAnswerSubmitString;
import com.facebook.crowdsourcing.protocol.graphql.PlaceQuestionMutations.PlaceQuestionSkipString;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.PlaceQuestionSkipInputData;
import com.facebook.graphql.calls.PlaceQuestionSubmitAnswerInputData;
import com.facebook.graphql.calls.PlaceQuestionSubmitAnswerInputData.Surface;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.request.MutationRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.maps.ExternalMapLauncher;
import com.facebook.offlinemode.common.OfflineQueryBehavior;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.futures.TasksManager;
import com.google.common.collect.ImmutableList;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: com.facebook.zero.ZERO_RATING_STATE_CHANGED */
public class PlaceQuestionViewController {
    public Set<String> f17556a = new HashSet();
    public final Lazy<ExternalMapLauncher> f17557b;
    private final GraphQLQueryExecutor f17558c;
    private PlaceQuestionInteractionListener f17559d;
    private final TasksManager<String> f17560e;

    /* compiled from: com.facebook.zero.ZERO_RATING_STATE_CHANGED */
    public interface PlaceQuestionInteractionListener {
        void mo1356e();

        void mo1357f();
    }

    /* compiled from: com.facebook.zero.ZERO_RATING_STATE_CHANGED */
    class C14574 extends AbstractDisposableFutureCallback<GraphQLResult<?>> {
        final /* synthetic */ PlaceQuestionViewController f17555a;

        C14574(PlaceQuestionViewController placeQuestionViewController) {
            this.f17555a = placeQuestionViewController;
        }

        protected final void m21425a(Throwable th) {
        }
    }

    public static PlaceQuestionViewController m21435b(InjectorLike injectorLike) {
        return new PlaceQuestionViewController(IdBasedSingletonScopeProvider.b(injectorLike, 7475), GraphQLQueryExecutor.a(injectorLike), TasksManager.b(injectorLike));
    }

    public static PlaceQuestionViewController m21426a(InjectorLike injectorLike) {
        return m21435b(injectorLike);
    }

    @Inject
    public PlaceQuestionViewController(Lazy<ExternalMapLauncher> lazy, GraphQLQueryExecutor graphQLQueryExecutor, TasksManager tasksManager) {
        this.f17557b = lazy;
        this.f17558c = graphQLQueryExecutor;
        this.f17560e = tasksManager;
    }

    public final void m21437a(final PlaceQuestionView placeQuestionView, PlaceQuestionFieldsModel placeQuestionFieldsModel, int i, PlaceQuestionInteractionListener placeQuestionInteractionListener) {
        Uri uri = null;
        this.f17559d = placeQuestionInteractionListener;
        placeQuestionView.m21423c(i);
        placeQuestionView.setTitle(placeQuestionFieldsModel.m2466j());
        placeQuestionView.setDetails(placeQuestionFieldsModel.m2464d());
        placeQuestionView.setSubtitle(placeQuestionFieldsModel.eq_());
        if (!(placeQuestionFieldsModel.m2465g() == null || placeQuestionFieldsModel.m2465g().m2413a() == null)) {
            String a = placeQuestionFieldsModel.m2465g().m2413a().m2408a();
            placeQuestionView.setPhoto(a != null ? Uri.parse(a) : null);
        }
        final PlaceQuestionPlaceModel er_ = placeQuestionFieldsModel.er_();
        if (er_ != null) {
            if (er_.es_() != null) {
                placeQuestionView.m21420a(er_.es_().a(), er_.es_().b(), 13);
                placeQuestionView.setMapOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ PlaceQuestionViewController f17547b;

                    public void onClick(View view) {
                        int a = Logger.a(2, EntryType.UI_INPUT_START, 663297012);
                        ((ExternalMapLauncher) this.f17547b.f17557b.get()).a(view.getContext(), CurationSurface.AFTER_PARTY.toString(), er_.es_().a(), er_.es_().b(), er_.m2450d(), er_.m2444a() != null ? er_.m2444a().m2420a() : null);
                        LogUtils.a(-1943897065, a);
                    }
                });
            }
            placeQuestionView.setMapVisible(er_.es_() != null);
            placeQuestionView.setPlaceName(er_.m2450d());
            a = er_.m2451g().m2436a();
            if (a != null) {
                uri = Uri.parse(a);
            }
            placeQuestionView.setProfilePicture(uri);
            ImmutableList b = er_.m2448b();
            placeQuestionView.getContext();
            placeQuestionView.setPlaceCategories(m21428a(b));
            placeQuestionView.setPlaceAddress(er_.m2444a().m2421b());
            placeQuestionView.setPlaceDetailsVisible(true);
        } else {
            placeQuestionView.setMapVisible(false);
            placeQuestionView.setPlaceDetailsVisible(false);
        }
        final String b2 = placeQuestionFieldsModel.m2462b();
        for (int i2 = 0; i2 < placeQuestionFieldsModel.m2463c().size(); i2++) {
            boolean z;
            final PlaceQuestionAnswerFieldsModel placeQuestionAnswerFieldsModel = (PlaceQuestionAnswerFieldsModel) placeQuestionFieldsModel.m2463c().get(i2);
            if (i2 == placeQuestionFieldsModel.m2463c().size() - 1 && i == 0) {
                z = true;
            } else {
                z = false;
            }
            placeQuestionView.m21422a(placeQuestionAnswerFieldsModel.m2397a().m2392a(), new OnClickListener(this) {
                final /* synthetic */ PlaceQuestionViewController f17551d;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 689961254);
                    if (this.f17551d.f17556a.contains(b2)) {
                        Logger.a(2, EntryType.UI_INPUT_END, 1100131855, a);
                        return;
                    }
                    if (view instanceof Checkable) {
                        ((Checkable) view).toggle();
                    }
                    this.f17551d.m21434a(b2, placeQuestionAnswerFieldsModel.m2399b(), placeQuestionView);
                    this.f17551d.f17556a.add(b2);
                    LogUtils.a(2060762326, a);
                }
            }, z);
        }
        m21429a(placeQuestionView, placeQuestionFieldsModel, i);
    }

    private static String m21428a(ImmutableList<String> immutableList) {
        SeparatedSpannableStringBuilder separatedSpannableStringBuilder = new SeparatedSpannableStringBuilder(" · ");
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            separatedSpannableStringBuilder.a((String) immutableList.get(i));
        }
        return separatedSpannableStringBuilder.toString();
    }

    private void m21429a(final PlaceQuestionView placeQuestionView, final PlaceQuestionFieldsModel placeQuestionFieldsModel, int i) {
        placeQuestionView.m21421a(placeQuestionView.getContext().getResources().getString(2131230751), new OnClickListener(this) {
            final /* synthetic */ PlaceQuestionViewController f17554c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1033655529);
                if (this.f17554c.f17556a.contains(placeQuestionFieldsModel.m2462b())) {
                    Logger.a(2, EntryType.UI_INPUT_END, 1044701726, a);
                    return;
                }
                this.f17554c.m21433a(placeQuestionFieldsModel.m2462b(), placeQuestionView);
                this.f17554c.f17556a.add(placeQuestionFieldsModel.m2462b());
                LogUtils.a(425213763, a);
            }
        }, i == 0 ? placeQuestionFieldsModel.m2463c().size() / 2 : -1);
    }

    private void m21434a(String str, String str2, PlaceQuestionView placeQuestionView) {
        PlaceQuestionSubmitAnswerInputData placeQuestionSubmitAnswerInputData = new PlaceQuestionSubmitAnswerInputData();
        placeQuestionSubmitAnswerInputData.a("place_question_id", str);
        GraphQlCallInput graphQlCallInput = placeQuestionSubmitAnswerInputData;
        graphQlCallInput.a("place_question_answer_value", str2);
        graphQlCallInput = graphQlCallInput;
        graphQlCallInput.a("surface", Surface.REACTION);
        graphQlCallInput = graphQlCallInput;
        GraphQlQueryString placeQuestionAnswerSubmitString = new PlaceQuestionAnswerSubmitString();
        placeQuestionAnswerSubmitString.a("input", graphQlCallInput);
        m21432a(GraphQLRequest.a(placeQuestionAnswerSubmitString), str);
        this.f17559d.mo1356e();
    }

    private void m21433a(String str, PlaceQuestionView placeQuestionView) {
        PlaceQuestionSkipInputData placeQuestionSkipInputData = new PlaceQuestionSkipInputData();
        placeQuestionSkipInputData.a("place_question_id", str);
        GraphQlCallInput graphQlCallInput = placeQuestionSkipInputData;
        graphQlCallInput.a("surface", PlaceQuestionSkipInputData.Surface.REACTION);
        graphQlCallInput = graphQlCallInput;
        GraphQlQueryString placeQuestionSkipString = new PlaceQuestionSkipString();
        placeQuestionSkipString.a("input", graphQlCallInput);
        m21432a(GraphQLRequest.a(placeQuestionSkipString), str);
        this.f17559d.mo1357f();
    }

    private void m21432a(MutationRequest mutationRequest, String str) {
        this.f17560e.a("task_key_submit_answer" + str, this.f17558c.a(mutationRequest, OfflineQueryBehavior.b), new C14574(this));
    }
}
