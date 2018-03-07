package com.facebook.feed.curationflow;

import com.facebook.feed.protocol.FetchCurationFlowGraphQLModels.FetchCurationFlowModel.FeedCurationFlowStepModel;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.enums.GraphQLNegativeFeedbackActionType;
import com.google.common.util.concurrent.FutureCallback;
import javax.annotation.Nullable;

/* compiled from: application/x-subrip */
class CurationFlowManager$2 implements FutureCallback<FeedCurationFlowStepModel> {
    final /* synthetic */ FutureCallback f19136a;
    final /* synthetic */ FeedProps f19137b;
    final /* synthetic */ GraphQLNegativeFeedbackActionType f19138c;
    final /* synthetic */ String f19139d;
    final /* synthetic */ CurationFlowManager f19140e;

    CurationFlowManager$2(CurationFlowManager curationFlowManager, FutureCallback futureCallback, FeedProps feedProps, GraphQLNegativeFeedbackActionType graphQLNegativeFeedbackActionType, String str) {
        this.f19140e = curationFlowManager;
        this.f19136a = futureCallback;
        this.f19137b = feedProps;
        this.f19138c = graphQLNegativeFeedbackActionType;
        this.f19139d = str;
    }

    public void onSuccess(@Nullable Object obj) {
        FeedCurationFlowStepModel feedCurationFlowStepModel = (FeedCurationFlowStepModel) obj;
        if (this.f19136a != null) {
            this.f19136a.onSuccess(feedCurationFlowStepModel);
        }
    }

    public void onFailure(Throwable th) {
        if (this.f19136a != null) {
            this.f19136a.onFailure(th);
        }
        CurationFlowManager.a(this.f19140e, this.f19137b, this.f19138c, this.f19139d);
    }
}
