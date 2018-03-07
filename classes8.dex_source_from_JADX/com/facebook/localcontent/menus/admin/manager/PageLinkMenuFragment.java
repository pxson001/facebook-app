package com.facebook.localcontent.menus.admin.manager;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.android.InputMethodManagerMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.fbui.dialog.ProgressDialog;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.PageLinkMenuCreateInputData;
import com.facebook.graphql.error.GraphQLException;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.FbInjector;
import com.facebook.localcontent.analytics.LocalContentMenuLogger;
import com.facebook.localcontent.protocol.graphql.LinkMenuMutations.PageLinkMenuCreateMutationString;
import com.facebook.localcontent.protocol.graphql.LinkMenuMutationsModels.PageLinkMenuCreateMutationModel;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.offlinemode.common.OfflineQueryBehavior;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.titlebar.HasTitleBar;
import com.google.common.base.Strings;
import javax.inject.Inject;

/* compiled from: ec_card_recycled */
public class PageLinkMenuFragment extends FbFragment {
    @Inject
    public GraphQLQueryExecutor f15078a;
    @Inject
    public InputMethodManager f15079b;
    @Inject
    public LocalContentMenuLogger f15080c;
    @Inject
    public TasksManager f15081d;
    @Inject
    Toaster f15082e;
    public EditText f15083f;

    /* compiled from: ec_card_recycled */
    class C16451 implements OnClickListener {
        final /* synthetic */ PageLinkMenuFragment f15074a;

        C16451(PageLinkMenuFragment pageLinkMenuFragment) {
            this.f15074a = pageLinkMenuFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1408545357);
            PageLinkMenuFragment pageLinkMenuFragment = this.f15074a;
            String string = pageLinkMenuFragment.s.getString("com.facebook.katana.profile.id");
            pageLinkMenuFragment.f15080c.f14941a.a(LocalContentMenuLogger.m17408b("page_menu_management", "menu_management_save_link_menu_button_tap", string));
            PageLinkMenuCreateInputData pageLinkMenuCreateInputData = new PageLinkMenuCreateInputData();
            pageLinkMenuCreateInputData.a("link_menu_uri", pageLinkMenuFragment.f15083f.getText().toString());
            GraphQlCallInput graphQlCallInput = pageLinkMenuCreateInputData;
            graphQlCallInput.a("page_id", string);
            graphQlCallInput = graphQlCallInput;
            GraphQlQueryString pageLinkMenuCreateMutationString = new PageLinkMenuCreateMutationString();
            pageLinkMenuCreateMutationString.a("input", graphQlCallInput);
            pageLinkMenuFragment.f15081d.a("task_key_create_link_menu" + string, pageLinkMenuFragment.f15078a.a(GraphQLRequest.a(pageLinkMenuCreateMutationString), OfflineQueryBehavior.c), new C16462(pageLinkMenuFragment, ProgressDialog.a(pageLinkMenuFragment.getContext(), null, pageLinkMenuFragment.jW_().getString(2131239131), true, false), string));
            Logger.a(2, EntryType.UI_INPUT_END, -1733441021, a);
        }
    }

    /* compiled from: ec_card_recycled */
    public class C16462 extends AbstractDisposableFutureCallback<GraphQLResult<PageLinkMenuCreateMutationModel>> {
        final /* synthetic */ ProgressDialog f15075a;
        final /* synthetic */ String f15076b;
        final /* synthetic */ PageLinkMenuFragment f15077c;

        public C16462(PageLinkMenuFragment pageLinkMenuFragment, ProgressDialog progressDialog, String str) {
            this.f15077c = pageLinkMenuFragment;
            this.f15075a = progressDialog;
            this.f15076b = str;
        }

        protected final void m17499a(Object obj) {
            this.f15075a.dismiss();
            PageLinkMenuFragment pageLinkMenuFragment = this.f15077c;
            pageLinkMenuFragment.f15080c.f14941a.a(LocalContentMenuLogger.m17408b("page_menu_management", "menu_management_save_link_menu_successful", this.f15076b));
            Activity ao = pageLinkMenuFragment.ao();
            if (ao != null) {
                View currentFocus = ao.getCurrentFocus();
                if (currentFocus != null) {
                    pageLinkMenuFragment.f15079b.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
                }
                ao.setResult(-1);
                ao.finish();
            }
        }

        protected final void m17500a(Throwable th) {
            this.f15075a.dismiss();
            PageLinkMenuFragment.m17502a(this.f15077c, th, this.f15076b);
        }
    }

    public static void m17503a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((PageLinkMenuFragment) obj).m17501a(GraphQLQueryExecutor.a(fbInjector), InputMethodManagerMethodAutoProvider.b(fbInjector), LocalContentMenuLogger.m17409b(fbInjector), TasksManager.b(fbInjector), Toaster.b(fbInjector));
    }

    public final void m17507c(@Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = PageLinkMenuFragment.class;
        m17503a((Object) this, getContext());
    }

    public final View m17505a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -949632419);
        View inflate = layoutInflater.inflate(2130906064, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1418766443, a);
        return inflate;
    }

    public final void m17506a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        this.f15083f = (EditText) e(2131565615);
        this.f15083f.setText(this.s.getString("extra_link_menu_url"));
        ((Button) e(2131565616)).setOnClickListener(new C16451(this));
    }

    public final void m17504G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 695327776);
        super.G();
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.y_(2131239124);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -49793428, a);
    }

    public static void m17502a(PageLinkMenuFragment pageLinkMenuFragment, Throwable th, String str) {
        CharSequence charSequence = null;
        if (th instanceof GraphQLException) {
            GraphQLException graphQLException = (GraphQLException) th;
            if (graphQLException.error != null) {
                charSequence = graphQLException.error.c();
            }
        }
        if (Strings.isNullOrEmpty(charSequence)) {
            charSequence = pageLinkMenuFragment.b(2131239132);
        }
        pageLinkMenuFragment.f15082e.a(new ToastBuilder(charSequence));
        pageLinkMenuFragment.f15080c.f14941a.a(LocalContentMenuLogger.m17408b("page_menu_management", "menu_management_save_link_menu_failure", str));
    }

    private void m17501a(GraphQLQueryExecutor graphQLQueryExecutor, InputMethodManager inputMethodManager, LocalContentMenuLogger localContentMenuLogger, TasksManager tasksManager, Toaster toaster) {
        this.f15078a = graphQLQueryExecutor;
        this.f15079b = inputMethodManager;
        this.f15080c = localContentMenuLogger;
        this.f15081d = tasksManager;
        this.f15082e = toaster;
    }
}
