package com.facebook.pages.common.surface.calltoaction.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.base.fragment.CanHandleBackPressed;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.fbui.popover.PopoverWindow;
import com.facebook.fbui.popover.PopoverWindow.Position;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.PageCallToActionViewerSubmissionInputData;
import com.facebook.graphql.calls.PageCallToActionViewerSubmissionInputData.FieldsData;
import com.facebook.graphql.calls.PageCallToActionViewerSubmissionInputData.Source;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.common.surface.calltoaction.PageCallToActionFetcher;
import com.facebook.pages.common.surface.calltoaction.PageCallToActionFetcherProvider;
import com.facebook.pages.common.surface.calltoaction.analytics.PageCallToActionAnalytics;
import com.facebook.pages.common.surface.calltoaction.analytics.PageCallToActionEvent;
import com.facebook.pages.common.surface.calltoaction.graphql.PageAdminCallToActionGraphQLModels.CallToActionConfigFieldsModel;
import com.facebook.pages.common.surface.calltoaction.graphql.PageCallToActionMutations.PageCallToActionContactUsFormSubmitMutationString;
import com.facebook.pages.common.surface.calltoaction.graphql.PageCallToActionMutationsModels.PageCallToActionContactUsFormSubmitMutationModel;
import com.facebook.pages.common.surface.calltoaction.ui.PageCallToActionConfirmationPopoverView;
import com.facebook.pages.common.surface.calltoaction.ui.PageCallToActionInputFieldsContainer;
import com.facebook.pages.common.surface.calltoaction.util.PageCallToActionUtil.PageCallToActionErrorState;
import com.facebook.ui.futures.TasksManager;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.HasTitleBar;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.facebook.widget.titlebar.TitleBarButtonSpec.Builder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: create_header */
public class PageUserCallToActionFragment extends FbFragment implements CanHandleBackPressed {
    @Inject
    public Lazy<TasksManager> f16704a;
    @Inject
    public Lazy<PageCallToActionAnalytics> f16705b;
    @Inject
    public PageCallToActionFetcherProvider f16706c;
    private ArrayList<CallToActionConfigFieldsModel> f16707d;
    public String f16708e;
    public String f16709f;
    public PageCallToActionInputFieldsContainer f16710g;

    /* compiled from: create_header */
    class C18131 implements OnClickListener {
        final /* synthetic */ PageUserCallToActionFragment f16699a;

        C18131(PageUserCallToActionFragment pageUserCallToActionFragment) {
            this.f16699a = pageUserCallToActionFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            ((PageCallToActionAnalytics) this.f16699a.f16705b.get()).f16655a.a(PageCallToActionAnalytics.m19689a(PageCallToActionEvent.EVENT_VIEWER_CALL_TO_ACTION_BACK_CLICK_NO, this.f16699a.f16708e));
        }
    }

    /* compiled from: create_header */
    class C18142 implements OnClickListener {
        final /* synthetic */ PageUserCallToActionFragment f16700a;

        C18142(PageUserCallToActionFragment pageUserCallToActionFragment) {
            this.f16700a = pageUserCallToActionFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            ((PageCallToActionAnalytics) this.f16700a.f16705b.get()).f16655a.a(PageCallToActionAnalytics.m19689a(PageCallToActionEvent.EVENT_VIEWER_CALL_TO_ACTION_BACK_CLICK_YES, this.f16700a.f16708e));
            PageUserCallToActionFragment.m19737b(this.f16700a);
        }
    }

    /* compiled from: create_header */
    public class ToolbarButtonListener extends OnToolbarButtonListener {
        public final /* synthetic */ PageUserCallToActionFragment f16703a;

        /* compiled from: create_header */
        public class C18161 extends AbstractDisposableFutureCallback<PageCallToActionContactUsFormSubmitMutationModel> {
            public final /* synthetic */ ToolbarButtonListener f16702a;

            /* compiled from: create_header */
            public class C18151 {
                public final /* synthetic */ C18161 f16701a;

                C18151(C18161 c18161) {
                    this.f16701a = c18161;
                }
            }

            C18161(ToolbarButtonListener toolbarButtonListener) {
                this.f16702a = toolbarButtonListener;
            }

            protected final void m19733a(Object obj) {
                this.f16702a.f16703a.f16710g.m20083a(false);
                PopoverWindow popoverWindow = new PopoverWindow(this.f16702a.f16703a.getContext());
                PageCallToActionConfirmationPopoverView pageCallToActionConfirmationPopoverView = new PageCallToActionConfirmationPopoverView(this.f16702a.f16703a.getContext());
                popoverWindow.b(0.85f);
                pageCallToActionConfirmationPopoverView.f16801c = popoverWindow;
                pageCallToActionConfirmationPopoverView.f16802d = new C18151(this);
                popoverWindow.d(pageCallToActionConfirmationPopoverView);
                popoverWindow.c(this.f16702a.f16703a.T);
                popoverWindow.a(Position.CENTER);
                popoverWindow.d();
            }

            protected final void m19734a(Throwable th) {
                this.f16702a.f16703a.f16710g.m20083a(false);
                this.f16702a.f16703a.f16710g.m20084c(2131239574);
            }
        }

        public ToolbarButtonListener(PageUserCallToActionFragment pageUserCallToActionFragment) {
            this.f16703a = pageUserCallToActionFragment;
        }

        public final void m19735a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            if (this.f16703a.f16710g.m20081a() == PageCallToActionErrorState.NONE) {
                this.f16703a.f16710g.m20083a(true);
                TasksManager tasksManager = (TasksManager) this.f16703a.f16704a.get();
                String str = "send_user_request_key";
                PageCallToActionFetcher a = this.f16703a.f16706c.m19688a(this.f16703a.f16708e);
                String str2 = this.f16703a.f16708e;
                Map fieldValues = this.f16703a.f16710g.getFieldValues();
                List arrayList = new ArrayList();
                for (Entry entry : fieldValues.entrySet()) {
                    FieldsData fieldsData = new FieldsData();
                    fieldsData.a("field_key", (String) entry.getKey());
                    GraphQlCallInput graphQlCallInput = fieldsData;
                    graphQlCallInput.a("field_value", (String) entry.getValue());
                    arrayList.add(graphQlCallInput);
                }
                PageCallToActionViewerSubmissionInputData pageCallToActionViewerSubmissionInputData = new PageCallToActionViewerSubmissionInputData();
                pageCallToActionViewerSubmissionInputData.a("page_id", str2);
                GraphQlCallInput graphQlCallInput2 = pageCallToActionViewerSubmissionInputData;
                graphQlCallInput2.a("source", Source.MOBILE_PAGE_PRESENCE_CALL_TO_ACTION);
                graphQlCallInput2 = graphQlCallInput2;
                graphQlCallInput2.a("fields_data", arrayList);
                tasksManager.a(str, GraphQLQueryExecutor.a(a.f16645a.a(GraphQLRequest.a((PageCallToActionContactUsFormSubmitMutationString) new PageCallToActionContactUsFormSubmitMutationString().a("input", graphQlCallInput2)))), new C18161(this));
            }
        }
    }

    public static void m19736a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        PageUserCallToActionFragment pageUserCallToActionFragment = (PageUserCallToActionFragment) obj;
        Lazy a = IdBasedLazy.a(fbInjector, 3561);
        Lazy a2 = IdBasedLazy.a(fbInjector, 8994);
        PageCallToActionFetcherProvider pageCallToActionFetcherProvider = (PageCallToActionFetcherProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(PageCallToActionFetcherProvider.class);
        pageUserCallToActionFragment.f16704a = a;
        pageUserCallToActionFragment.f16705b = a2;
        pageUserCallToActionFragment.f16706c = pageCallToActionFetcherProvider;
    }

    public final void m19740c(@Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = PageUserCallToActionFragment.class;
        m19736a((Object) this, getContext());
        Bundle bundle2 = this.s;
        this.f16707d = (ArrayList) FlatBufferModelHelper.b(bundle2, "arg_page_call_to_action_fields");
        this.f16708e = bundle2.getString("arg_page_id");
        this.f16709f = bundle2.getString("arg_page_call_to_action_label");
    }

    public final View m19738a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1778356330);
        View inflate = layoutInflater.inflate(2130906089, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1814603189, a);
        return inflate;
    }

    public final void m19739a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        this.f16710g = (PageCallToActionInputFieldsContainer) e(2131565659);
        this.f16710g.m20082a(null, null, this.f16707d, this.f16708e);
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1822525292);
        super.mi_();
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.a_(this.f16709f);
            hasTitleBar.c(true);
            Builder a2 = TitleBarButtonSpec.a();
            a2.g = jW_().getString(2131239548);
            hasTitleBar.a(a2.a());
            hasTitleBar.a(new ToolbarButtonListener(this));
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1991812493, a);
    }

    public final boolean O_() {
        ((PageCallToActionAnalytics) this.f16705b.get()).f16655a.a(PageCallToActionAnalytics.m19689a(PageCallToActionEvent.EVENT_VIEWER_CALL_TO_ACTION_BACK_BUTTON, this.f16708e));
        AlertDialog a = new AlertDialog.Builder(getContext()).a(jW_().getString(2131239583)).c(17301659).b(jW_().getString(2131239584)).a(2131230726, new C18142(this)).b(2131230727, new C18131(this)).a(null).a(true).a();
        a.getWindow().setDimAmount(0.85f);
        a.show();
        return true;
    }

    public static void m19737b(PageUserCallToActionFragment pageUserCallToActionFragment) {
        Activity ao = pageUserCallToActionFragment.ao();
        if (ao != null) {
            ao.finish();
        }
    }
}
