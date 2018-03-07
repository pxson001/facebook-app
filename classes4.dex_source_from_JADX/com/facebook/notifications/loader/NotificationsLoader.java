package com.facebook.notifications.loader;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Process;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.Loader$ForceLoadContentObserver;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.notifications.protocol.FetchGraphQLNotificationsParamsBuilder;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields;
import com.facebook.notifications.provider.GraphQLNotificationsContentProviderHelper;
import com.facebook.notifications.util.NotificationsLastUpdatedUtil;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import java.util.List;

/* compiled from: excluded_members */
public class NotificationsLoader extends AsyncTaskLoader<List<FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields>> {
    public Optional<String> f12690f = Absent.INSTANCE;
    private final GraphQLNotificationsContentProviderHelper f12691g;
    private final ViewerContext f12692h;
    private final ContentResolver f12693i;
    private final Uri f12694j;
    private final int f12695k;
    private final boolean f12696l;
    private final NotificationsLastUpdatedUtil f12697u;
    private List<FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields> f12698v;
    private Loader$ForceLoadContentObserver f12699w;
    private boolean f12700x = true;
    public int f12701y;

    public final /* synthetic */ void m13503b(Object obj) {
        m13502a((List) obj);
    }

    public /* synthetic */ Object mo915d() {
        return m13505f();
    }

    public NotificationsLoader(Context context, GraphQLNotificationsContentProviderHelper graphQLNotificationsContentProviderHelper, ContentResolver contentResolver, Uri uri, ViewerContext viewerContext, int i, boolean z, NotificationsLastUpdatedUtil notificationsLastUpdatedUtil) {
        super(context);
        this.f12691g = (GraphQLNotificationsContentProviderHelper) Preconditions.checkNotNull(graphQLNotificationsContentProviderHelper);
        this.f12693i = (ContentResolver) Preconditions.checkNotNull(contentResolver);
        this.f12694j = (Uri) Preconditions.checkNotNull(uri);
        this.f12692h = viewerContext;
        this.f12699w = new Loader$ForceLoadContentObserver(this);
        this.f12695k = i;
        this.f12696l = z;
        this.f12697u = notificationsLastUpdatedUtil;
    }

    public List<FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields> m13505f() {
        int i = 0;
        int threadPriority = Process.getThreadPriority(Process.myTid());
        try {
            Process.setThreadPriority(0);
            FetchGraphQLNotificationsParamsBuilder a = new FetchGraphQLNotificationsParamsBuilder().m8032a(this.f12692h).m8033a(DataFreshnessParam.STALE_DATA_OKAY);
            int i2 = this.f12701y;
            if (this.f12698v != null) {
                i = this.f12698v.size();
            }
            i = Math.max(i2, i) + this.f12697u.m7926b();
            if (this.f12696l) {
                a.m8031a(Math.max(i, 30));
            } else if (this.f12700x) {
                a.m8031a(this.f12695k);
                this.f12700x = false;
            } else {
                a.m8031a(Math.max(i, 10));
            }
            if (this.f12690f.isPresent()) {
                a.m8036c(true);
                a.m8037e((String) this.f12690f.get());
            }
            List<FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields> a2 = this.f12691g.m7895a(a.m8038p()).f10826a.m11244a();
            return a2;
        } finally {
            Process.setThreadPriority(threadPriority);
        }
    }

    private void m13502a(List<FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields> list) {
        this.f12698v = list;
        if (this.p) {
            super.b(list);
        }
    }

    protected final void m13506g() {
        this.f12693i.registerContentObserver(this.f12694j, true, this.f12699w);
        if (this.f12698v != null) {
            m13502a(this.f12698v);
        }
        if (t() || this.f12698v == null) {
            a();
        }
    }

    protected final void m13507h() {
        m13514b();
    }

    protected final void m13508i() {
        m13507h();
        this.f12698v = null;
        this.f12693i.unregisterContentObserver(this.f12699w);
    }
}
