package com.facebook.timeline.contextual;

import android.view.View.OnClickListener;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.ipc.profile.TimelineContext;

/* compiled from: group_request_member_header_visible */
public class TimelineContextualInfoAdapterProvider extends AbstractAssistedProvider<TimelineContextualInfoAdapter> {
    public final TimelineContextualInfoAdapter m10456a(TimelineContext timelineContext, TimelineContextualInfoData timelineContextualInfoData, ContextItemsRenderingStyle contextItemsRenderingStyle, OnClickListener onClickListener, String str) {
        return new TimelineContextualInfoAdapter(timelineContext, timelineContextualInfoData, contextItemsRenderingStyle, onClickListener, str, (AbstractFbErrorReporter) FbErrorReporterImpl.a(this), IdBasedProvider.a(this, 11162), IdBasedProvider.a(this, 11161), (TimelineIntroCardContextListItemPresenterProvider) getOnDemandAssistedProviderForStaticDi(TimelineIntroCardContextListItemPresenterProvider.class), IdBasedProvider.a(this, 11164));
    }
}
