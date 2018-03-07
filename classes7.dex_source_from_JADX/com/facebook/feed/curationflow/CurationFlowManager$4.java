package com.facebook.feed.curationflow;

import com.facebook.feed.protocol.FetchCurationFlowGraphQLModels.FetchCurationFlowModel;
import com.facebook.feed.protocol.FetchCurationFlowGraphQLModels.FetchCurationFlowModel.FeedCurationFlowStepModel;
import com.facebook.graphql.enums.GraphQLNegativeFeedbackActionType;
import com.facebook.graphql.executor.GraphQLResult;
import com.google.common.util.concurrent.FutureCallback;
import java.util.Stack;
import javax.annotation.Nullable;

/* compiled from: application/x-subrip */
class CurationFlowManager$4 implements FutureCallback<GraphQLResult<FetchCurationFlowModel>> {
    final /* synthetic */ String f19146a;
    final /* synthetic */ FutureCallback f19147b;
    final /* synthetic */ GraphQLNegativeFeedbackActionType f19148c;
    final /* synthetic */ CurationFlowManager f19149d;

    CurationFlowManager$4(CurationFlowManager curationFlowManager, String str, FutureCallback futureCallback, GraphQLNegativeFeedbackActionType graphQLNegativeFeedbackActionType) {
        this.f19149d = curationFlowManager;
        this.f19146a = str;
        this.f19147b = futureCallback;
        this.f19148c = graphQLNegativeFeedbackActionType;
    }

    public void onSuccess(@Nullable Object obj) {
        GraphQLResult graphQLResult = (GraphQLResult) obj;
        if (graphQLResult == null || graphQLResult.e == null) {
            onFailure(new NullPointerException("Curation result is null"));
            return;
        }
        CurationFlowManager.d(this.f19149d, this.f19146a);
        FeedCurationFlowStepModel a = ((FetchCurationFlowModel) graphQLResult.e).a();
        CurationFlowManager curationFlowManager = this.f19149d;
        String str = this.f19146a;
        if (!curationFlowManager.f.containsKey(str)) {
            curationFlowManager.f.put(str, new Stack());
        }
        ((Stack) curationFlowManager.f.get(str)).push(a);
        if (this.f19147b != null) {
            this.f19147b.onSuccess(a);
        }
    }

    public void onFailure(Throwable th) {
        CurationFlowManager.d(this.f19149d, this.f19146a);
        this.f19149d.b.a(CurationFlowManager.a, "Fetch curation flow failed: id=" + this.f19146a + " actionType=" + this.f19148c, th);
        if (this.f19147b != null) {
            this.f19147b.onFailure(th);
        }
    }
}
