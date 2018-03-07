package com.facebook.messaging.business.agent.helper;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.util.ContextUtils;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.messaging.business.common.BusinessPrefKeys;
import com.facebook.messaging.graphql.threads.business.AgentThreadFragmentsModels.BusinessIsPageLinkedQueryModel;
import com.facebook.messaging.linkhandling.LinkHandlingHelper;
import com.facebook.orca.threadview.ThreadViewMessagesFragment.AnonymousClass31;
import com.facebook.orca.threadview.ThreadViewMessagesFragment.AnonymousClass32;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;

/* compiled from: thread_type */
public class AgentTermsStatusHelper {
    public final GraphQLQueryExecutor f1476a;
    public final ExecutorService f1477b;
    public final FbSharedPreferences f1478c;
    public final Context f1479d;
    public final Lazy<LinkHandlingHelper> f1480e;
    public ListenableFuture<GraphQLResult<BusinessIsPageLinkedQueryModel>> f1481f;
    public AlertDialog f1482g;
    public final AtomicBoolean f1483h = new AtomicBoolean(false);
    @GuardedBy("ui-thread")
    public AnonymousClass31 f1484i;

    /* compiled from: thread_type */
    public class C02491 implements FutureCallback<GraphQLResult<BusinessIsPageLinkedQueryModel>> {
        final /* synthetic */ AnonymousClass32 f1470a;
        final /* synthetic */ AgentTermsStatusHelper f1471b;

        public C02491(AgentTermsStatusHelper agentTermsStatusHelper, AnonymousClass32 anonymousClass32) {
            this.f1471b = agentTermsStatusHelper;
            this.f1470a = anonymousClass32;
        }

        public void onSuccess(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            this.f1471b.f1481f = null;
            if (graphQLResult == null || graphQLResult.e == null || ((BusinessIsPageLinkedQueryModel) graphQLResult.e).a() == null) {
                this.f1471b.f1484i.m7463a(this.f1471b.f1479d.getResources().getString(2131241138));
                return;
            }
            boolean a = ((BusinessIsPageLinkedQueryModel) graphQLResult.e).a().a();
            this.f1471b.f1478c.edit().putBoolean(BusinessPrefKeys.b, a).commit();
            Boolean.toString(a);
            if (a) {
                this.f1471b.f1484i.m7462a();
                return;
            }
            AgentTermsStatusHelper agentTermsStatusHelper = this.f1471b;
            AnonymousClass32 anonymousClass32 = this.f1470a;
            if (agentTermsStatusHelper.f1483h.compareAndSet(false, true)) {
                agentTermsStatusHelper.f1482g = new FbAlertDialogBuilder(agentTermsStatusHelper.f1479d).a(2131241133).b(2131241134).c(2131241135, new C02524(agentTermsStatusHelper)).a(2131241136, new C02513(agentTermsStatusHelper)).b(2131241137, new C02502(agentTermsStatusHelper, anonymousClass32)).a(false).c(false).b();
            }
        }

        public void onFailure(Throwable th) {
            this.f1471b.f1481f = null;
            this.f1471b.f1484i.m7463a(this.f1471b.f1479d.getResources().getString(2131241138));
        }
    }

    /* compiled from: thread_type */
    public class C02502 implements OnClickListener {
        final /* synthetic */ AnonymousClass32 f1472a;
        final /* synthetic */ AgentTermsStatusHelper f1473b;

        public C02502(AgentTermsStatusHelper agentTermsStatusHelper, AnonymousClass32 anonymousClass32) {
            this.f1473b = agentTermsStatusHelper;
            this.f1472a = anonymousClass32;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            this.f1473b.f1483h.set(false);
            this.f1472a.m7464a();
        }
    }

    /* compiled from: thread_type */
    public class C02513 implements OnClickListener {
        final /* synthetic */ AgentTermsStatusHelper f1474a;

        public C02513(AgentTermsStatusHelper agentTermsStatusHelper) {
            this.f1474a = agentTermsStatusHelper;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f1474a.f1478c.edit().putBoolean(BusinessPrefKeys.b, true).commit();
            dialogInterface.dismiss();
            this.f1474a.f1483h.set(false);
            this.f1474a.f1484i.m7462a();
        }
    }

    /* compiled from: thread_type */
    public class C02524 implements OnClickListener {
        final /* synthetic */ AgentTermsStatusHelper f1475a;

        public C02524(AgentTermsStatusHelper agentTermsStatusHelper) {
            this.f1475a = agentTermsStatusHelper;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            Uri parse = Uri.parse(this.f1475a.f1479d.getResources().getString(2131241139));
            if (ContextUtils.a(this.f1475a.f1479d, Activity.class) == null) {
                dialogInterface.dismiss();
                this.f1475a.f1483h.set(false);
            }
            ((LinkHandlingHelper) this.f1475a.f1480e.get()).a(this.f1475a.f1479d, parse);
        }
    }

    public static AgentTermsStatusHelper m1466b(InjectorLike injectorLike) {
        return new AgentTermsStatusHelper(GraphQLQueryExecutor.a(injectorLike), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), (Context) injectorLike.getInstance(Context.class), IdBasedSingletonScopeProvider.b(injectorLike, 7898));
    }

    @Inject
    public AgentTermsStatusHelper(GraphQLQueryExecutor graphQLQueryExecutor, ExecutorService executorService, FbSharedPreferences fbSharedPreferences, Context context, Lazy<LinkHandlingHelper> lazy) {
        this.f1476a = graphQLQueryExecutor;
        this.f1477b = executorService;
        this.f1478c = fbSharedPreferences;
        this.f1479d = context;
        this.f1480e = lazy;
    }

    public final boolean m1467c() {
        return this.f1478c.a(BusinessPrefKeys.b, false);
    }
}
