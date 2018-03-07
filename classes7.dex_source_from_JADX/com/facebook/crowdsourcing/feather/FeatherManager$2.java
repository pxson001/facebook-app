package com.facebook.crowdsourcing.feather;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.crowdsourcing.feather.activity.FeatherActivity;
import com.facebook.crowdsourcing.logging.CrowdEntryPoint;
import com.facebook.crowdsourcing.protocol.graphql.FeatherQueriesModels.FeatherQuestionsQueryModel;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.graphql.executor.GraphQLResult;
import com.google.common.base.Strings;

/* compiled from: com.facebook.zero.notification.ZeroPersistentNotificationService.SHOW */
public class FeatherManager$2 extends AbstractDisposableFutureCallback<GraphQLResult<FeatherQuestionsQueryModel>> {
    final /* synthetic */ Context f17395a;
    final /* synthetic */ String f17396b;
    final /* synthetic */ CrowdEntryPoint f17397c;
    final /* synthetic */ FeatherManager f17398d;

    public FeatherManager$2(FeatherManager featherManager, Context context, String str, CrowdEntryPoint crowdEntryPoint) {
        this.f17398d = featherManager;
        this.f17395a = context;
        this.f17396b = str;
        this.f17397c = crowdEntryPoint;
    }

    protected final void m21283a(Object obj) {
        GraphQLResult graphQLResult = (GraphQLResult) obj;
        if (System.nanoTime() - this.f17398d.g > 4000000000L) {
            this.f17398d.f.b(FunnelRegistry.S, "fetch_successful_too_late");
            this.f17398d.f.b(FunnelRegistry.S);
        } else if (graphQLResult == null || graphQLResult.e == null || ((FeatherQuestionsQueryModel) graphQLResult.e).m2381a() == null || ((FeatherQuestionsQueryModel) graphQLResult.e).m2381a().isEmpty() || Strings.isNullOrEmpty(((FeatherQuestionsQueryModel) graphQLResult.e).m2384j())) {
            this.f17398d.f.b(FunnelRegistry.S, "fetch_successful_no_data");
        } else {
            this.f17398d.f.b(FunnelRegistry.S, "fetch_successful");
            Intent intent = new Intent(this.f17395a, FeatherActivity.class);
            intent.putExtra("extra_place", this.f17396b);
            intent.putExtra("extra_place_name", ((FeatherQuestionsQueryModel) graphQLResult.e).m2384j());
            intent.putExtra("extra_entry_point", this.f17397c.getFullName());
            FlatBufferModelHelper.a(intent, "extra_questions", ((FeatherQuestionsQueryModel) graphQLResult.e).m2381a());
            this.f17398d.f.b(FunnelRegistry.S, "fetch_end");
            this.f17398d.c.a(intent, this.f17395a);
        }
    }

    protected final void m21284a(Throwable th) {
        this.f17398d.f.b(FunnelRegistry.S, "fetch_failed");
        this.f17398d.a.a("Feather", "Failed to load Feather questions");
    }
}
