package com.facebook.orca.threadview;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.messaging.messagerequests.experiment.MessageRequestsExperimentController;
import com.facebook.ui.errordialog.ErrorDialogs;
import java.util.concurrent.Executor;

/* compiled from: megaphone_string */
public class ThreadViewMessagesFragmentMessageRequestsControllerProvider extends AbstractAssistedProvider<ThreadViewMessagesFragmentMessageRequestsController> {
    public final ThreadViewMessagesFragmentMessageRequestsController m7810a(FragmentManager fragmentManager) {
        return new ThreadViewMessagesFragmentMessageRequestsController(AnalyticsLoggerMethodAutoProvider.a(this), DefaultBlueServiceOperationFactory.b(this), IdBasedProvider.a(this, 11752), (Context) getInstance(Context.class), ErrorDialogs.a(this), fragmentManager, MessageRequestsExperimentController.m3149b(this), ResourcesMethodAutoProvider.a(this), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(this));
    }
}
