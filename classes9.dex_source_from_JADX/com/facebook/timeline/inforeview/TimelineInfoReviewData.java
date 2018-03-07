package com.facebook.timeline.inforeview;

import com.facebook.timeline.data.TimelineDataSource;
import com.facebook.timeline.protocol.TimelineInfoReviewGraphQLInterfaces.InfoReviewItemsFragment;
import com.facebook.timeline.protocol.TimelineInfoReviewGraphQLModels.InfoReviewItemsFragmentModel;
import javax.annotation.Nullable;

/* compiled from: upload ad image failed */
public class TimelineInfoReviewData extends TimelineDataSource<InfoReviewItemsFragment> {
    public InfoReviewProfileQuestionStatusData f914f = new InfoReviewProfileQuestionStatusData();

    public final boolean m923d() {
        return this.b != null;
    }

    public final void m921a(@Nullable InfoReviewItemsFragmentModel infoReviewItemsFragmentModel, int i) {
        super.a(infoReviewItemsFragmentModel, i);
        if (d()) {
            this.d = 2;
        }
    }
}
