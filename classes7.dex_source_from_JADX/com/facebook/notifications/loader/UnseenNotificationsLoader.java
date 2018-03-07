package com.facebook.notifications.loader;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Process;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.notifications.protocol.FetchGraphQLNotificationsParamsBuilder;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLInterfaces.NotificationsEdgeFields;
import com.facebook.notifications.provider.GraphQLNotificationsContentProviderHelper;
import com.facebook.notifications.util.NotificationsLastUpdatedUtil;
import com.google.common.base.Preconditions;
import java.util.List;

/* compiled from: newsfeed_story_like_fail */
public class UnseenNotificationsLoader extends NotificationsLoader {
    private final GraphQLNotificationsContentProviderHelper f8169g;
    private final ViewerContext f8170h;
    public boolean f8171i;

    public final /* synthetic */ Object m9794d() {
        return f();
    }

    public UnseenNotificationsLoader(Context context, GraphQLNotificationsContentProviderHelper graphQLNotificationsContentProviderHelper, ContentResolver contentResolver, NotificationsLastUpdatedUtil notificationsLastUpdatedUtil, Uri uri, ViewerContext viewerContext) {
        super(context, graphQLNotificationsContentProviderHelper, contentResolver, uri, viewerContext, 0, false, notificationsLastUpdatedUtil);
        this.f8169g = (GraphQLNotificationsContentProviderHelper) Preconditions.checkNotNull(graphQLNotificationsContentProviderHelper);
        this.f8170h = viewerContext;
    }

    public final List<NotificationsEdgeFields> m9795f() {
        int threadPriority = Process.getThreadPriority(Process.myTid());
        try {
            Process.setThreadPriority(0);
            FetchGraphQLNotificationsParamsBuilder a = new FetchGraphQLNotificationsParamsBuilder().a(this.f8170h).b(this.f8171i).a(DataFreshnessParam.STALE_DATA_OKAY);
            if (this.f.isPresent()) {
                a.c(true);
                a.e((String) this.f.get());
            }
            List<NotificationsEdgeFields> a2 = this.f8169g.b(a.p()).a.a();
            return a2;
        } finally {
            Process.setThreadPriority(threadPriority);
        }
    }
}
