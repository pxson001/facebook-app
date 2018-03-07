package com.facebook.notifications.protocol;

import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.List;

/* compiled from: min_push_intervals_s */
public class FetchGraphQLNotificationsParamsBuilder {
    public DataFreshnessParam f7654a;
    public int f7655b = 10;
    public int f7656c = 10;
    public String f7657d;
    public String f7658e;
    public ViewerContext f7659f;
    public String f7660g;
    public List<String> f7661h = Lists.a();
    public boolean f7662i;
    public boolean f7663j = false;
    public boolean f7664k = false;
    public int f7665l;
    public String f7666m;
    public boolean f7667n = false;
    public String f7668o;

    public final FetchGraphQLNotificationsParamsBuilder m8033a(DataFreshnessParam dataFreshnessParam) {
        this.f7654a = dataFreshnessParam;
        return this;
    }

    public final FetchGraphQLNotificationsParamsBuilder m8031a(int i) {
        this.f7655b = i;
        return this;
    }

    public final FetchGraphQLNotificationsParamsBuilder m8032a(ViewerContext viewerContext) {
        this.f7659f = viewerContext;
        return this;
    }

    public final FetchGraphQLNotificationsParamsBuilder m8034a(List<String> list) {
        Preconditions.checkNotNull(list);
        this.f7661h = list;
        return this;
    }

    public final FetchGraphQLNotificationsParamsBuilder m8035b(boolean z) {
        this.f7664k = z;
        return this;
    }

    public final FetchGraphQLNotificationsParamsBuilder m8036c(boolean z) {
        this.f7667n = z;
        return this;
    }

    public final FetchGraphQLNotificationsParamsBuilder m8037e(String str) {
        this.f7668o = str;
        return this;
    }

    public final FetchGraphQLNotificationsParams m8038p() {
        Preconditions.checkNotNull(this.f7654a);
        return new FetchGraphQLNotificationsParams(this);
    }
}
