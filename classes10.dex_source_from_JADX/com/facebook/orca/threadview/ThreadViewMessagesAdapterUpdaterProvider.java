package com.facebook.orca.threadview;

import android.widget.BaseAdapter;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.orca.threadview.abtest.ThreadViewReducedAnimationExperimentController;

/* compiled from: message has event message */
public class ThreadViewMessagesAdapterUpdaterProvider extends AbstractAssistedProvider<ThreadViewMessagesAdapterUpdater> {
    public final ThreadViewMessagesAdapterUpdater m7400a(BaseAdapter baseAdapter, ThreadViewReducedAnimationExperimentController threadViewReducedAnimationExperimentController, InterRowItemAnimationFactory interRowItemAnimationFactory) {
        return new ThreadViewMessagesAdapterUpdater(baseAdapter, threadViewReducedAnimationExperimentController, interRowItemAnimationFactory, RowItemUiUtil.m7015a(this), (AbstractFbErrorReporter) FbErrorReporterImpl.a(this), new RowItemDifferentiator());
    }
}
