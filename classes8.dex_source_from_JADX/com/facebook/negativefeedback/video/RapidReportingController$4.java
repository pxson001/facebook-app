package com.facebook.negativefeedback.video;

import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.negativefeedback.video.protocol.RapidReportingTagsQueryModels.RapidReportingTagsQueryModel;
import com.facebook.negativefeedback.video.ui.ReportLiveVideoFeedbackView;
import com.google.common.util.concurrent.FutureCallback;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: text_size */
public class RapidReportingController$4 implements FutureCallback<GraphQLResult<RapidReportingTagsQueryModel>> {
    final /* synthetic */ ReportLiveVideoFeedbackView f1630a;
    final /* synthetic */ RapidReportingController f1631b;

    public RapidReportingController$4(RapidReportingController rapidReportingController, ReportLiveVideoFeedbackView reportLiveVideoFeedbackView) {
        this.f1631b = rapidReportingController;
        this.f1630a = reportLiveVideoFeedbackView;
    }

    public void onSuccess(@Nullable Object obj) {
        List list;
        GraphQLResult graphQLResult = (GraphQLResult) obj;
        if (graphQLResult == null || graphQLResult.e == null || ((RapidReportingTagsQueryModel) graphQLResult.e).m1861j() == null) {
            this.f1631b.c.a(RapidReportingController.a, "NFX graphql call to fetch story tags successful but returned no tags");
            list = null;
        } else {
            list = ((RapidReportingTagsQueryModel) graphQLResult.e).m1861j().m1852a();
        }
        this.f1630a.setTags(list);
    }

    public void onFailure(Throwable th) {
        this.f1630a.setTags(null);
    }
}
