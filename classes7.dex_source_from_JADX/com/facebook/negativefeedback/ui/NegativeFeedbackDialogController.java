package com.facebook.negativefeedback.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.api.negative_feedback.NegativeFeedbackActionMethod.Params;
import com.facebook.api.negative_feedback.NegativeFeedbackActionMethod.ParamsBuilder;
import com.facebook.api.negative_feedback.NegativeFeedbackMessageActionMethod;
import com.facebook.api.negative_feedback.NegativeFeedbackPostService;
import com.facebook.auth.module.ViewerContextManagerProvider;
import com.facebook.auth.viewercontext.ViewerContextManager;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.UriUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.fbui.widget.contentview.CheckedContentView;
import com.facebook.graphql.enums.GraphQLNegativeFeedbackActionType;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.negativefeedback.logging.NegativeFeedbackAnalyticsLogger;
import com.facebook.negativefeedback.logging.NegativeFeedbackPerformanceLogger;
import com.facebook.negativefeedback.protocol.NegativeFeedbackQuery.NegativeFeedbackFlowForMessageThreadQueryString;
import com.facebook.negativefeedback.protocol.NegativeFeedbackQuery.NegativeFeedbackFlowStepQueryString;
import com.facebook.negativefeedback.protocol.NegativeFeedbackQueryModels.NegativeFeedbackFlowForMessageThreadQueryModel;
import com.facebook.negativefeedback.protocol.NegativeFeedbackQueryModels.NegativeFeedbackFlowStepQueryModel;
import com.facebook.negativefeedback.protocol.NegativeFeedbackQueryModels.NegativeFeedbackPromptQueryFragmentModel;
import com.facebook.negativefeedback.protocol.NegativeFeedbackQueryModels.NegativeFeedbackPromptQueryFragmentModel.ResponsesModel;
import com.facebook.negativefeedback.protocol.NegativeFeedbackResponseData;
import com.facebook.negativefeedback.ui.NegativeFeedbackErrorView.ErrorType;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import com.facebook.rapidfeedback.RapidFeedbackController;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.keyboard.KeyboardUtils;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: notif_options */
public class NegativeFeedbackDialogController {
    public static final String f8028b = NegativeFeedbackDialogController.class.getSimpleName();
    public Boolean f8029A = Boolean.valueOf(false);
    public Boolean f8030B = Boolean.valueOf(false);
    public Boolean f8031C = Boolean.valueOf(false);
    public Boolean f8032D = Boolean.valueOf(false);
    public final OnClickListener f8033E = new C06361(this);
    public final OnClickListener f8034F = new C06372(this);
    private final OnItemClickListener f8035G = new C06383(this);
    private final OnItemClickListener f8036H = new C06394(this);
    public GraphQLQueryExecutor f8037a;
    public TasksManager<NegativeFeedbackTaskKey> f8038c;
    public AbstractFbErrorReporter f8039d;
    private DefaultAndroidThreadUtil f8040e;
    private Provider<NegativeFeedbackPostService> f8041f;
    public AlertDialog f8042g;
    public Stack<NegativeFeedbackResponseData> f8043h;
    public ArrayList<NegativeFeedbackResponseData> f8044i;
    public NegativeFeedbackDialogViewHolder f8045j;
    public NegativeFeedbackResponseData f8046k;
    public boolean f8047l = false;
    public NegativeFeedbackPromptQueryFragmentModel f8048m;
    public NegativeFeedbackDialogViewFactory f8049n;
    public FrameLayout f8050o;
    public LinearLayout f8051p;
    public Set<GraphQLNegativeFeedbackActionType> f8052q;
    public NegativeFeedbackAnalyticsLogger f8053r;
    public NegativeFeedbackPerformanceLogger f8054s;
    private SecureContextHelper f8055t;
    public NegativeFeedbackDialogContent f8056u;
    public RapidFeedbackController f8057v;
    public String f8058w;
    public List<String> f8059x;
    public Bundle f8060y;
    public ViewerContextManager f8061z;

    /* compiled from: notif_options */
    class C06361 implements OnClickListener {
        final /* synthetic */ NegativeFeedbackDialogController f8016a;

        C06361(NegativeFeedbackDialogController negativeFeedbackDialogController) {
            this.f8016a = negativeFeedbackDialogController;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            if (this.f8016a.f8043h.size() > 1) {
                if (this.f8016a.f8056u instanceof NegativeFeedbackMessageComposerView) {
                    KeyboardUtils.a(this.f8016a.f8042g.getContext(), (NegativeFeedbackMessageComposerView) this.f8016a.f8056u);
                    this.f8016a.f8053r.m9599c(this.f8016a.f8046k.f8006a);
                } else {
                    this.f8016a.f8053r.m9601e(this.f8016a.f8046k.f8006a);
                }
                this.f8016a.f8047l = true;
                this.f8016a.f8038c.c(NegativeFeedbackTaskKey.FLOW_STEP);
                NegativeFeedbackDialogController.m9732a(this.f8016a, (NegativeFeedbackResponseData) this.f8016a.f8043h.elementAt(this.f8016a.f8043h.size() - 2));
            }
        }
    }

    /* compiled from: notif_options */
    class C06372 implements OnClickListener {
        final /* synthetic */ NegativeFeedbackDialogController f8017a;

        C06372(NegativeFeedbackDialogController negativeFeedbackDialogController) {
            this.f8017a = negativeFeedbackDialogController;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            NegativeFeedbackMessageComposerView negativeFeedbackMessageComposerView = (NegativeFeedbackMessageComposerView) this.f8017a.f8056u;
            if (negativeFeedbackMessageComposerView != null) {
                Object obj;
                if (this.f8017a.f8046k.f8012g) {
                    obj = this.f8017a.f8046k.f8010e;
                } else {
                    String selectedProfileId;
                    if (negativeFeedbackMessageComposerView.f8096c != null) {
                        selectedProfileId = negativeFeedbackMessageComposerView.f8096c.getSelectedProfileId();
                    } else {
                        selectedProfileId = "";
                    }
                    String str = selectedProfileId;
                }
                if (!StringUtil.a(obj) && !StringUtil.c(negativeFeedbackMessageComposerView.getMessageBody())) {
                    KeyboardUtils.a(negativeFeedbackMessageComposerView.getContext(), negativeFeedbackMessageComposerView);
                    NegativeFeedbackDialogController.m9734a(this.f8017a, this.f8017a.f8046k.f8006a, negativeFeedbackMessageComposerView.getMessageBody(), obj);
                }
            }
        }
    }

    /* compiled from: notif_options */
    class C06383 implements OnItemClickListener {
        final /* synthetic */ NegativeFeedbackDialogController f8018a;

        C06383(NegativeFeedbackDialogController negativeFeedbackDialogController) {
            this.f8018a = negativeFeedbackDialogController;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (view instanceof CheckedContentView) {
                ((CheckedContentView) view).setChecked(true);
                this.f8018a.f8047l = false;
                int headerViewsCount = i - ((ListView) adapterView).getHeaderViewsCount();
                this.f8018a.f8046k = (NegativeFeedbackResponseData) this.f8018a.f8044i.get(headerViewsCount);
                this.f8018a.f8053r.m9595a(this.f8018a.f8046k.f8006a);
                NegativeFeedbackDialogController.m9732a(this.f8018a, new NegativeFeedbackResponseData(this.f8018a.f8046k));
            }
        }
    }

    /* compiled from: notif_options */
    class C06394 implements OnItemClickListener {
        final /* synthetic */ NegativeFeedbackDialogController f8019a;

        C06394(NegativeFeedbackDialogController negativeFeedbackDialogController) {
            this.f8019a = negativeFeedbackDialogController;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            this.f8019a.f8047l = false;
            NegativeFeedbackDialogController.m9730a(this.f8019a, (ListView) adapterView, i);
        }
    }

    /* compiled from: notif_options */
    public class C06405 implements FutureCallback<GraphQLResult<NegativeFeedbackFlowStepQueryModel>> {
        final /* synthetic */ NegativeFeedbackDialogController f8020a;

        public C06405(NegativeFeedbackDialogController negativeFeedbackDialogController) {
            this.f8020a = negativeFeedbackDialogController;
        }

        public void onSuccess(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            this.f8020a.f8054s.m9607b();
            if (graphQLResult.e == null || ((NegativeFeedbackFlowStepQueryModel) graphQLResult.e).m9622a() == null) {
                NegativeFeedbackDialogController.m9733a(this.f8020a, ErrorType.DATA_ERROR);
                return;
            }
            this.f8020a.f8048m = ((NegativeFeedbackFlowStepQueryModel) graphQLResult.e).m9622a();
            NegativeFeedbackDialogController.m9731a(this.f8020a, this.f8020a.f8048m);
        }

        public void onFailure(Throwable th) {
            this.f8020a.f8054s.m9608c();
            this.f8020a.f8039d.a(NegativeFeedbackDialogController.f8028b, "NFX flow step fetch failed", th);
            NegativeFeedbackDialogController.m9733a(this.f8020a, ErrorType.NETWORK_ERROR);
        }
    }

    /* compiled from: notif_options */
    public class C06416 implements FutureCallback<GraphQLResult<NegativeFeedbackFlowForMessageThreadQueryModel>> {
        final /* synthetic */ NegativeFeedbackDialogController f8021a;

        public C06416(NegativeFeedbackDialogController negativeFeedbackDialogController) {
            this.f8021a = negativeFeedbackDialogController;
        }

        public void onSuccess(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            this.f8021a.f8054s.m9607b();
            if (graphQLResult.e == null || ((NegativeFeedbackFlowForMessageThreadQueryModel) graphQLResult.e).m9616a() == null) {
                NegativeFeedbackDialogController.m9733a(this.f8021a, ErrorType.DATA_ERROR);
            } else {
                NegativeFeedbackDialogController.m9731a(this.f8021a, ((NegativeFeedbackFlowForMessageThreadQueryModel) graphQLResult.e).m9616a());
            }
        }

        public void onFailure(Throwable th) {
            this.f8021a.f8054s.m9608c();
            this.f8021a.f8039d.a(NegativeFeedbackDialogController.f8028b, "NFX flow step fetch failed", th);
            NegativeFeedbackDialogController.m9733a(this.f8021a, ErrorType.NETWORK_ERROR);
        }
    }

    /* compiled from: notif_options */
    class C06427 implements View.OnClickListener {
        final /* synthetic */ NegativeFeedbackDialogController f8022a;

        C06427(NegativeFeedbackDialogController negativeFeedbackDialogController) {
            this.f8022a = negativeFeedbackDialogController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 784071854);
            NegativeFeedbackDialogController.m9741i(this.f8022a);
            Logger.a(2, EntryType.UI_INPUT_END, -2097272786, a);
        }
    }

    /* compiled from: notif_options */
    class C06449 extends OperationResultFutureCallback {
        final /* synthetic */ NegativeFeedbackDialogController f8027a;

        C06449(NegativeFeedbackDialogController negativeFeedbackDialogController) {
            this.f8027a = negativeFeedbackDialogController;
        }

        protected final void m9726a(Object obj) {
            this.f8027a.f8047l = true;
            this.f8027a.f8030B = Boolean.valueOf(true);
            this.f8027a.f8042g.a(-2).setEnabled(true);
            NegativeFeedbackDialogController.m9742j(this.f8027a);
            NegativeFeedbackDialogController.m9732a(this.f8027a, (NegativeFeedbackResponseData) this.f8027a.f8043h.elementAt(this.f8027a.f8043h.size() - 2));
        }

        protected final void m9725a(ServiceException serviceException) {
            this.f8027a.f8042g.a(-2).setEnabled(true);
            this.f8027a.f8039d.a(NegativeFeedbackDialogController.f8028b, "NFX message send action failed", serviceException);
        }
    }

    /* compiled from: notif_options */
    public enum NegativeFeedbackTaskKey {
        FLOW_STEP,
        ACTION
    }

    public static NegativeFeedbackDialogController m9737b(InjectorLike injectorLike) {
        return new NegativeFeedbackDialogController((AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), DefaultAndroidThreadUtil.b(injectorLike), IdBasedProvider.a(injectorLike, 4820), GraphQLQueryExecutor.a(injectorLike), new NegativeFeedbackAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike)), new NegativeFeedbackPerformanceLogger(QuickPerformanceLoggerMethodAutoProvider.a(injectorLike)), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), RapidFeedbackController.b(injectorLike), TasksManager.b(injectorLike), ViewerContextManagerProvider.b(injectorLike));
    }

    private void m9736a(NegativeFeedbackGuidedActionItem negativeFeedbackGuidedActionItem, ListView listView) {
        ResponsesModel responsesModel = negativeFeedbackGuidedActionItem.f8072a;
        if (this.f8042g != null) {
            String str = "";
            String str2 = "";
            if (responsesModel.m9684j() != null) {
                str = responsesModel.m9684j().m9661b();
                str2 = responsesModel.m9684j().m9662c();
            }
            this.f8046k = new NegativeFeedbackResponseData(responsesModel.gL_(), -1, responsesModel.m9683g(), responsesModel.gM_(), str, str2, responsesModel.m9685k());
            if (responsesModel.m9683g() == GraphQLNegativeFeedbackActionType.MESSAGE) {
                this.f8043h.push(this.f8046k);
            } else if (NegativeFeedbackGuidedActionsView.f8085a.contains(responsesModel.m9683g())) {
                m9738b(responsesModel);
                negativeFeedbackGuidedActionItem.f8074c = NegativeFeedbackGuidedActionItemViewType.INITIAL;
            } else {
                m9740b(negativeFeedbackGuidedActionItem, listView);
            }
        }
    }

    @Inject
    public NegativeFeedbackDialogController(FbErrorReporter fbErrorReporter, AndroidThreadUtil androidThreadUtil, Provider<NegativeFeedbackPostService> provider, GraphQLQueryExecutor graphQLQueryExecutor, NegativeFeedbackAnalyticsLogger negativeFeedbackAnalyticsLogger, NegativeFeedbackPerformanceLogger negativeFeedbackPerformanceLogger, SecureContextHelper secureContextHelper, RapidFeedbackController rapidFeedbackController, TasksManager tasksManager, ViewerContextManager viewerContextManager) {
        this.f8039d = fbErrorReporter;
        this.f8040e = androidThreadUtil;
        this.f8041f = provider;
        this.f8037a = graphQLQueryExecutor;
        this.f8053r = negativeFeedbackAnalyticsLogger;
        this.f8054s = negativeFeedbackPerformanceLogger;
        this.f8055t = secureContextHelper;
        this.f8057v = rapidFeedbackController;
        this.f8038c = tasksManager;
        this.f8061z = viewerContextManager;
    }

    public static void m9730a(NegativeFeedbackDialogController negativeFeedbackDialogController, ListView listView, int i) {
        if (i < listView.getHeaderViewsCount()) {
            m9741i(negativeFeedbackDialogController);
            return;
        }
        NegativeFeedbackGuidedActionItem negativeFeedbackGuidedActionItem = (NegativeFeedbackGuidedActionItem) listView.getItemAtPosition(i);
        int headerViewsCount = i - listView.getHeaderViewsCount();
        if (NegativeFeedbackGuidedActionsView.f8087c.containsKey(negativeFeedbackGuidedActionItem.m9757c())) {
            switch (negativeFeedbackGuidedActionItem.f8074c) {
                case INITIAL:
                    m9741i(negativeFeedbackDialogController);
                    negativeFeedbackGuidedActionItem.f8074c = NegativeFeedbackGuidedActionItemViewType.ASK_TO_CONFIRM;
                    negativeFeedbackDialogController.f8053r.m9604h(negativeFeedbackGuidedActionItem.f8072a.gL_());
                    break;
                case ASK_TO_CONFIRM:
                    negativeFeedbackDialogController.m9735a(negativeFeedbackGuidedActionItem, headerViewsCount, listView);
                    break;
                default:
                    m9741i(negativeFeedbackDialogController);
                    break;
            }
        }
        m9741i(negativeFeedbackDialogController);
        if (negativeFeedbackGuidedActionItem.f8074c != NegativeFeedbackGuidedActionItemViewType.COMPLETED) {
            negativeFeedbackDialogController.m9735a(negativeFeedbackGuidedActionItem, headerViewsCount, listView);
        }
        AdapterDetour.a((BaseAdapter) ((HeaderViewListAdapter) listView.getAdapter()).getWrappedAdapter(), 1088631781);
    }

    public static void m9732a(NegativeFeedbackDialogController negativeFeedbackDialogController, NegativeFeedbackResponseData negativeFeedbackResponseData) {
        if (negativeFeedbackDialogController.f8056u != null) {
            negativeFeedbackDialogController.f8056u.setProgressBarVisibility(true);
        }
        if (negativeFeedbackResponseData.f8007b != -1) {
            String str = negativeFeedbackResponseData.f8006a;
            long j = negativeFeedbackResponseData.f8007b;
            NegativeFeedbackFlowForMessageThreadQueryString negativeFeedbackFlowForMessageThreadQueryString = new NegativeFeedbackFlowForMessageThreadQueryString();
            negativeFeedbackFlowForMessageThreadQueryString.a("thread_id", str);
            negativeFeedbackFlowForMessageThreadQueryString.a("responsible_id", Long.valueOf(j));
            negativeFeedbackDialogController.f8054s.m9606a();
            GraphQLRequest a = GraphQLRequest.a(negativeFeedbackFlowForMessageThreadQueryString).a(GraphQLCachePolicy.a).a(120);
            a.s = negativeFeedbackDialogController.f8061z.a();
            negativeFeedbackDialogController.f8038c.a(NegativeFeedbackTaskKey.FLOW_STEP, negativeFeedbackDialogController.f8037a.a(a), AbstractDisposableFutureCallback.a(new C06416(negativeFeedbackDialogController)));
            return;
        }
        str = negativeFeedbackResponseData.f8006a;
        NegativeFeedbackFlowStepQueryString negativeFeedbackFlowStepQueryString = new NegativeFeedbackFlowStepQueryString();
        negativeFeedbackFlowStepQueryString.a("node_token", str);
        negativeFeedbackFlowStepQueryString.a("negative_feedback_location", negativeFeedbackDialogController.f8058w);
        negativeFeedbackDialogController.f8054s.m9606a();
        a = GraphQLRequest.a(negativeFeedbackFlowStepQueryString).a(GraphQLCachePolicy.a).a(120);
        a.s = negativeFeedbackDialogController.f8061z.a();
        negativeFeedbackDialogController.f8038c.a(NegativeFeedbackTaskKey.FLOW_STEP, negativeFeedbackDialogController.f8037a.a(a), AbstractDisposableFutureCallback.a(new C06405(negativeFeedbackDialogController)));
    }

    public final void m9744a(String str, String str2) {
        this.f8046k = new NegativeFeedbackResponseData(str, -1, null, "", "", "", false);
        this.f8053r.m9596a(str, str2);
        this.f8058w = str2;
        m9732a(this, this.f8046k);
    }

    public final void m9743a(String str, long j, String str2) {
        this.f8046k = new NegativeFeedbackResponseData(str, j, null, "", "", "", false);
        this.f8053r.m9596a(str, str2);
        this.f8058w = str2;
        m9732a(this, this.f8046k);
    }

    public static void m9741i(NegativeFeedbackDialogController negativeFeedbackDialogController) {
        if (negativeFeedbackDialogController.f8056u instanceof NegativeFeedbackGuidedActionsView) {
            BaseAdapter baseAdapter = ((NegativeFeedbackGuidedActionsView) negativeFeedbackDialogController.f8056u).f8092g;
            for (int i = 0; i < baseAdapter.getCount(); i++) {
                NegativeFeedbackGuidedActionItem negativeFeedbackGuidedActionItem = (NegativeFeedbackGuidedActionItem) baseAdapter.getItem(i);
                if (negativeFeedbackGuidedActionItem.f8074c == NegativeFeedbackGuidedActionItemViewType.ASK_TO_CONFIRM) {
                    negativeFeedbackGuidedActionItem.f8074c = NegativeFeedbackGuidedActionItemViewType.INITIAL;
                    negativeFeedbackDialogController.f8053r.m9605i(negativeFeedbackGuidedActionItem.f8072a.gL_());
                    negativeFeedbackDialogController.f8029A = Boolean.valueOf(true);
                }
            }
            AdapterDetour.a(baseAdapter, -271221997);
        }
    }

    public static void m9731a(NegativeFeedbackDialogController negativeFeedbackDialogController, NegativeFeedbackPromptQueryFragmentModel negativeFeedbackPromptQueryFragmentModel) {
        if (negativeFeedbackPromptQueryFragmentModel != null && negativeFeedbackDialogController.f8042g != null) {
            NegativeFeedbackDialogViewHolder negativeFeedbackDialogViewHolder;
            if (negativeFeedbackDialogController.f8047l) {
                negativeFeedbackDialogController.f8043h.pop();
                negativeFeedbackDialogController.f8046k = (NegativeFeedbackResponseData) negativeFeedbackDialogController.f8043h.peek();
            } else {
                negativeFeedbackDialogController.f8043h.push(negativeFeedbackDialogController.f8046k);
            }
            negativeFeedbackDialogController.f8044i.clear();
            if (negativeFeedbackPromptQueryFragmentModel.m9697a().isEmpty()) {
                ((NegativeFeedbackGuidedActionsView) negativeFeedbackDialogController.m9727a(NegativeFeedbackDialogViewType.GUIDED_ACTIONS)).m9760a(negativeFeedbackPromptQueryFragmentModel);
            } else if (negativeFeedbackPromptQueryFragmentModel.m9697a().get(0) == null) {
                return;
            } else {
                if (((ResponsesModel) negativeFeedbackPromptQueryFragmentModel.m9697a().get(0)).m9683g() == null || ((ResponsesModel) negativeFeedbackPromptQueryFragmentModel.m9697a().get(0)).m9683g() == GraphQLNegativeFeedbackActionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE) {
                    NegativeFeedbackResponsesView negativeFeedbackResponsesView = (NegativeFeedbackResponsesView) negativeFeedbackDialogController.m9727a(NegativeFeedbackDialogViewType.FLOW_RESPONSES);
                    if (negativeFeedbackResponsesView.f8103b != null) {
                        negativeFeedbackResponsesView.f8103b.setText(negativeFeedbackPromptQueryFragmentModel.m9698b().m9693a());
                    }
                    ImmutableList a = negativeFeedbackPromptQueryFragmentModel.m9697a();
                    int size = a.size();
                    for (int i = 0; i < size; i++) {
                        String a2;
                        ResponsesModel responsesModel = (ResponsesModel) a.get(i);
                        String str = "";
                        String str2 = "";
                        if (responsesModel.m9686l() != null) {
                            str = responsesModel.m9686l().m9667a();
                        }
                        if (responsesModel.gN_() != null) {
                            a2 = responsesModel.gN_().m9652a();
                        } else {
                            a2 = str2;
                        }
                        negativeFeedbackResponsesView.f8105d.add(new NegativeFeedbackResponseItem(str, a2));
                    }
                    negativeFeedbackResponsesView.setProgressBarVisibility(false);
                    negativeFeedbackResponsesView.f8102a.setOnItemClickListener(negativeFeedbackDialogController.f8035G);
                } else {
                    NegativeFeedbackGuidedActionsView negativeFeedbackGuidedActionsView = (NegativeFeedbackGuidedActionsView) negativeFeedbackDialogController.m9727a(NegativeFeedbackDialogViewType.GUIDED_ACTIONS);
                    negativeFeedbackGuidedActionsView.f8093h = negativeFeedbackDialogController.f8052q;
                    negativeFeedbackGuidedActionsView.m9760a(negativeFeedbackPromptQueryFragmentModel);
                    negativeFeedbackGuidedActionsView.f8089d.setOnItemClickListener(negativeFeedbackDialogController.f8036H);
                    negativeFeedbackDialogController.f8051p.setOnClickListener(new C06427(negativeFeedbackDialogController));
                    negativeFeedbackDialogController.f8045j.m9753g();
                    negativeFeedbackDialogViewHolder = negativeFeedbackDialogController.f8045j;
                    if (negativeFeedbackDialogViewHolder.f8067b != null) {
                        negativeFeedbackDialogViewHolder.f8067b.setVisibility(0);
                    }
                }
            }
            if (negativeFeedbackDialogController.f8043h.size() > 1) {
                negativeFeedbackDialogViewHolder = negativeFeedbackDialogController.f8045j;
                if (negativeFeedbackDialogViewHolder.f8066a != null) {
                    negativeFeedbackDialogViewHolder.f8066a.setVisibility(0);
                }
            } else {
                negativeFeedbackDialogController.f8045j.m9752c();
            }
            negativeFeedbackDialogController.m9739b(negativeFeedbackPromptQueryFragmentModel);
        }
    }

    private void m9729a(NegativeFeedbackDialogContent negativeFeedbackDialogContent) {
        this.f8050o.removeAllViews();
        if (negativeFeedbackDialogContent != null) {
            this.f8050o.addView((View) negativeFeedbackDialogContent);
        }
    }

    private void m9739b(NegativeFeedbackPromptQueryFragmentModel negativeFeedbackPromptQueryFragmentModel) {
        ImmutableList a = negativeFeedbackPromptQueryFragmentModel.m9697a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            ResponsesModel responsesModel = (ResponsesModel) a.get(i);
            GraphQLNegativeFeedbackActionType g = responsesModel.m9683g();
            String str = "";
            String str2 = "";
            if (responsesModel.m9684j() != null) {
                str = responsesModel.m9684j().m9661b();
                str2 = responsesModel.m9684j().m9662c();
            }
            this.f8044i.add(new NegativeFeedbackResponseData(responsesModel.gL_(), -1, g, responsesModel.gM_(), str, str2, responsesModel.m9685k()));
        }
    }

    public static void m9733a(NegativeFeedbackDialogController negativeFeedbackDialogController, ErrorType errorType) {
        NegativeFeedbackErrorView negativeFeedbackErrorView = (NegativeFeedbackErrorView) negativeFeedbackDialogController.m9727a(NegativeFeedbackDialogViewType.ERROR);
        if (errorType == ErrorType.NETWORK_ERROR) {
            negativeFeedbackErrorView.f8069a.setText(2131237749);
            negativeFeedbackErrorView.f8070b.setText(2131237750);
        } else {
            negativeFeedbackErrorView.f8069a.setText(2131237747);
            negativeFeedbackErrorView.f8070b.setText(2131237748);
        }
        NegativeFeedbackDialogViewHolder negativeFeedbackDialogViewHolder = negativeFeedbackDialogController.f8045j;
        if (negativeFeedbackDialogViewHolder.f8067b != null) {
            negativeFeedbackDialogViewHolder.f8067b.setText(2131237743);
        }
    }

    private void m9728a(ResponsesModel responsesModel) {
        NegativeFeedbackMessageComposerView negativeFeedbackMessageComposerView = (NegativeFeedbackMessageComposerView) m9727a(NegativeFeedbackDialogViewType.MESSAGE_COMPOSER);
        if (responsesModel.m9685k()) {
            negativeFeedbackMessageComposerView.f8096c.setVisibility(8);
            if (responsesModel.m9684j() != null) {
                negativeFeedbackMessageComposerView.f8095b.setText(responsesModel.m9684j().m9662c());
            }
        } else {
            negativeFeedbackMessageComposerView.f8097d.setVisibility(8);
        }
        negativeFeedbackMessageComposerView.f8094a.setText(responsesModel.gM_());
        this.f8042g.getWindow().clearFlags(131072);
        NegativeFeedbackDialogViewHolder negativeFeedbackDialogViewHolder = this.f8045j;
        if (negativeFeedbackDialogViewHolder.f8068c != null) {
            negativeFeedbackDialogViewHolder.f8068c.setVisibility(0);
        }
        negativeFeedbackDialogViewHolder = this.f8045j;
        if (negativeFeedbackDialogViewHolder.f8067b != null) {
            negativeFeedbackDialogViewHolder.f8067b.setVisibility(8);
        }
    }

    private void m9735a(NegativeFeedbackGuidedActionItem negativeFeedbackGuidedActionItem, int i, ListView listView) {
        negativeFeedbackGuidedActionItem.f8074c = NegativeFeedbackGuidedActionItemViewType.INITIATED;
        this.f8046k = (NegativeFeedbackResponseData) this.f8044i.get(i);
        ResponsesModel responsesModel = negativeFeedbackGuidedActionItem.f8072a;
        m9736a(negativeFeedbackGuidedActionItem, listView);
        if (responsesModel.m9683g() == GraphQLNegativeFeedbackActionType.MESSAGE) {
            this.f8053r.m9598b(responsesModel.gL_());
            m9728a(responsesModel);
        }
    }

    private void m9738b(ResponsesModel responsesModel) {
        Uri a = UriUtil.a(responsesModel.m9687m());
        if (a != null) {
            this.f8053r.m9602f(responsesModel.gL_());
            Intent intent = new Intent("android.intent.action.VIEW", a);
            intent.putExtra("force_in_app_browser", true);
            this.f8055t.b(intent, this.f8042g.getContext());
            this.f8032D = Boolean.valueOf(true);
        }
    }

    private void m9740b(final NegativeFeedbackGuidedActionItem negativeFeedbackGuidedActionItem, final ListView listView) {
        listView.setEnabled(false);
        final ResponsesModel responsesModel = negativeFeedbackGuidedActionItem.f8072a;
        NegativeFeedbackPostService negativeFeedbackPostService = (NegativeFeedbackPostService) this.f8041f.get();
        String gL_ = responsesModel.gL_();
        Bundle bundle = new Bundle();
        ParamsBuilder paramsBuilder = new ParamsBuilder();
        paramsBuilder.f600a = gL_;
        bundle.putParcelable("negativeFeedbackActionParams", new Params(paramsBuilder));
        ListenableFuture a = BlueServiceOperationFactoryDetour.a(negativeFeedbackPostService.f609a, "negative_feedback_actions", bundle, ErrorPropagation.BY_EXCEPTION, null, 1967871059).a();
        this.f8053r.m9603g(responsesModel.gL_());
        this.f8038c.a(NegativeFeedbackTaskKey.ACTION, a, AbstractDisposableFutureCallback.a(new OperationResultFutureCallback(this) {
            final /* synthetic */ NegativeFeedbackDialogController f8026d;

            protected final void m9724a(Object obj) {
                this.f8026d.f8030B = Boolean.valueOf(true);
                if (NegativeFeedbackGuidedActionsView.f8086b.contains(responsesModel.m9683g())) {
                    this.f8026d.f8031C = Boolean.valueOf(true);
                } else {
                    NegativeFeedbackDialogController.m9742j(this.f8026d);
                }
                listView.setEnabled(true);
                this.f8026d.f8052q.add(responsesModel.m9683g());
                negativeFeedbackGuidedActionItem.f8073b = this.f8026d.f8052q;
                negativeFeedbackGuidedActionItem.f8074c = NegativeFeedbackGuidedActionItemViewType.COMPLETED;
                if (this.f8026d.f8056u instanceof NegativeFeedbackGuidedActionsView) {
                    AdapterDetour.a(((NegativeFeedbackGuidedActionsView) this.f8026d.f8056u).f8092g, -236444158);
                }
            }

            protected final void m9723a(ServiceException serviceException) {
                this.f8026d.f8039d.a(NegativeFeedbackDialogController.f8028b, "NFX action failed", serviceException);
            }
        }));
    }

    public static void m9734a(NegativeFeedbackDialogController negativeFeedbackDialogController, String str, String str2, String str3) {
        negativeFeedbackDialogController.f8042g.a(-2).setEnabled(false);
        NegativeFeedbackPostService negativeFeedbackPostService = (NegativeFeedbackPostService) negativeFeedbackDialogController.f8041f.get();
        Bundle bundle = new Bundle();
        NegativeFeedbackMessageActionMethod.ParamsBuilder paramsBuilder = new NegativeFeedbackMessageActionMethod.ParamsBuilder();
        paramsBuilder.f606a = str;
        paramsBuilder = paramsBuilder;
        paramsBuilder.f607b = str2;
        paramsBuilder = paramsBuilder;
        paramsBuilder.f608c = str3;
        bundle.putParcelable("negativeFeedbackMessageActionParams", new NegativeFeedbackMessageActionMethod.Params(paramsBuilder));
        ListenableFuture a = BlueServiceOperationFactoryDetour.a(negativeFeedbackPostService.f609a, "negative_feedback_message_actions", bundle, ErrorPropagation.BY_EXCEPTION, null, -1385047927).a();
        negativeFeedbackDialogController.f8053r.m9597a(str, str2, str3);
        negativeFeedbackDialogController.f8040e.a(a, new C06449(negativeFeedbackDialogController));
    }

    public static void m9742j(NegativeFeedbackDialogController negativeFeedbackDialogController) {
        negativeFeedbackDialogController.f8059x.add(((NegativeFeedbackResponseData) negativeFeedbackDialogController.f8043h.peek()).f8006a);
    }

    private NegativeFeedbackDialogContent m9727a(NegativeFeedbackDialogViewType negativeFeedbackDialogViewType) {
        NegativeFeedbackDialogContent a = NegativeFeedbackDialogViewFactory.m9751a(negativeFeedbackDialogViewType, this.f8042g.getContext());
        this.f8056u = a;
        m9729a(a);
        return a;
    }
}
