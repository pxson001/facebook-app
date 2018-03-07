package com.facebook.notifications.multirow;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLInterfaces.NotificationsEdgeFields;
import com.facebook.notifications.provider.GraphQLNotificationsContentProviderHelper;
import com.facebook.notifications.util.DefaultNotificationStoryLauncher;
import com.facebook.notifications.util.NotificationStoryHelper;
import com.facebook.notifications.util.NotificationStoryLauncher;
import com.facebook.notifications.util.NotificationsUtils;
import com.facebook.performancelogger.PerformanceLogger;
import com.facebook.today.abtest.TodayExperimentController;
import com.facebook.today.common.HasNotifications;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.touchlistener.HighlightViewUtil;
import com.google.common.util.concurrent.FutureCallback;
import javax.inject.Inject;

/* compiled from: custom_cta_mobile_click_back_button */
public class TodayNotificationClickListener<E extends HasInvalidate & HasNotifications> implements OnClickListener {
    private final E f16128a;
    private final FbUriIntentHandler f16129b;
    private final NotificationsEdgeFields f16130c;
    private final NotificationStoryHelper f16131d;
    private final GraphQLNotificationsContentProviderHelper f16132e;
    private final DefaultNotificationStoryLauncher f16133f;
    public final NotificationsUtils f16134g;
    public final PerformanceLogger f16135h;
    public final DefaultAndroidThreadUtil f16136i;
    private final TodayExperimentController f16137j;

    @Inject
    public TodayNotificationClickListener(@Assisted NotificationsEdgeFields notificationsEdgeFields, @Assisted E e, FbUriIntentHandler fbUriIntentHandler, NotificationStoryHelper notificationStoryHelper, GraphQLNotificationsContentProviderHelper graphQLNotificationsContentProviderHelper, NotificationStoryLauncher notificationStoryLauncher, NotificationsUtils notificationsUtils, PerformanceLogger performanceLogger, AndroidThreadUtil androidThreadUtil, TodayExperimentController todayExperimentController) {
        this.f16128a = e;
        this.f16129b = fbUriIntentHandler;
        this.f16130c = notificationsEdgeFields;
        this.f16131d = notificationStoryHelper;
        this.f16132e = graphQLNotificationsContentProviderHelper;
        this.f16133f = notificationStoryLauncher;
        this.f16134g = notificationsUtils;
        this.f16135h = performanceLogger;
        this.f16136i = androidThreadUtil;
        this.f16137j = todayExperimentController;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -1362456757);
        final Context context = view.getContext();
        GraphQLStory k = this.f16130c.k();
        this.f16135h.d(655408, "NNF_PermalinkNotificationLoad");
        ((HasNotifications) this.f16128a).mo974a(this.f16130c);
        GraphQLStory c = this.f16137j.v() ? k : this.f16132e.c(k.g());
        if (c == null) {
            this.f16136i.a(this.f16134g.a(k.c(), k.g()), new FutureCallback<GraphQLStory>(this) {
                final /* synthetic */ TodayNotificationClickListener f16127b;

                public void onSuccess(Object obj) {
                    TodayNotificationClickListener.m18960b(this.f16127b, context, (GraphQLStory) obj);
                }

                public void onFailure(Throwable th) {
                    this.f16127b.f16135h.f(655408, "NNF_PermalinkNotificationLoad");
                }
            });
        } else {
            m18960b(this, context, c);
        }
        View findViewById = view.findViewById(2131567802);
        if (findViewById != null) {
            if (findViewById instanceof ViewGroup) {
                HighlightViewUtil.a((ViewGroup) findViewById, 3);
            }
            if (findViewById instanceof ImageBlockLayout) {
                HighlightViewUtil.a((ImageBlockLayout) findViewById, 3);
            }
        }
        this.f16128a.hL_();
        LogUtils.a(-1555136985, a);
    }

    public static void m18960b(TodayNotificationClickListener todayNotificationClickListener, Context context, GraphQLStory graphQLStory) {
        if (graphQLStory == null) {
            todayNotificationClickListener.f16135h.f(655408, "NNF_PermalinkNotificationLoad");
            return;
        }
        ((HasNotifications) todayNotificationClickListener.f16128a).mo972a();
        ((HasNotifications) todayNotificationClickListener.f16128a).mo973a(graphQLStory, todayNotificationClickListener.f16130c.c());
        String a = NotificationStoryHelper.a(graphQLStory);
        if (!(a != null ? todayNotificationClickListener.f16129b.a(context, a) : todayNotificationClickListener.f16133f.a(context, FeedProps.c(graphQLStory)))) {
            todayNotificationClickListener.f16135h.f(655408, "NNF_PermalinkNotificationLoad");
        }
    }
}
