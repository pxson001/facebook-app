package com.facebook.leadgen.deeplink;

import android.content.Context;
import android.os.Bundle;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.crudolib.urimap.UriMatchPatterns;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.FbInjector;
import com.facebook.leadgen.model.graphql.FetchLeadGenDeepLinkQuery.FetchLeadGenDeepLinkString;
import com.facebook.leadgen.model.graphql.FetchLeadGenDeepLinkQueryModels.FetchLeadGenDeepLinkModel;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Strings;
import javax.inject.Inject;

@UriMatchPatterns
/* compiled from: pivot_on_click */
public class LeadGenActivity extends FbFragmentActivity {
    @Inject
    GraphQLQueryExecutor f6373p;
    @Inject
    TasksManager f6374q;
    private String f6375r;

    /* compiled from: pivot_on_click */
    class C05781 extends AbstractDisposableFutureCallback<GraphQLResult<FetchLeadGenDeepLinkModel>> {
        final /* synthetic */ LeadGenActivity f6372a;

        C05781(LeadGenActivity leadGenActivity) {
            this.f6372a = leadGenActivity;
        }

        protected final void m8207a(Throwable th) {
        }
    }

    private static <T extends Context> void m8209a(Class<T> cls, T t) {
        m8210a((Object) t, (Context) t);
    }

    public static void m8210a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((LeadGenActivity) obj).m8208a(GraphQLQueryExecutor.a(fbInjector), TasksManager.b(fbInjector));
    }

    protected void onStart() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 907687108);
        super.onStart();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 573324482, a);
    }

    protected final void m8212b(Bundle bundle) {
        Class cls = LeadGenActivity.class;
        m8210a((Object) this, (Context) this);
        super.b(bundle);
        this.f6375r = getIntent().getStringExtra("lead_gen_data_id");
        if (!Strings.isNullOrEmpty(this.f6375r)) {
            m8211i();
        }
    }

    private void m8211i() {
        GraphQlQueryString fetchLeadGenDeepLinkString = new FetchLeadGenDeepLinkString();
        fetchLeadGenDeepLinkString.a("lead_gen_data_id", this.f6375r);
        fetchLeadGenDeepLinkString.b(true);
        this.f6374q.a("fetch_lead_gen_deep_link_story" + this.f6375r, this.f6373p.a(GraphQLRequest.a(fetchLeadGenDeepLinkString).a(GraphQLCachePolicy.a)), new C05781(this));
    }

    private void m8208a(GraphQLQueryExecutor graphQLQueryExecutor, TasksManager tasksManager) {
        this.f6373p = graphQLQueryExecutor;
        this.f6374q = tasksManager;
    }
}
