package com.facebook.crudolib.net;

import com.facebook.crudolib.net.RequestRunner.InternalRequestRunnable;
import com.facebook.crudolib.netengine.fbhttp.FbHttpEngine;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.annotation.Nullable;

/* compiled from: Today rendered with no views or no data */
public class CrudoNet {
    public final FbHttpEngine f24029a;
    public final ExecutorService f24030b;
    public final boolean f24031c;
    private final RequestRunner f24032d;

    /* compiled from: Today rendered with no views or no data */
    public class Builder {
        @Nullable
        public FbHttpEngine f24026a;
        @Nullable
        public ExecutorService f24027b;
        public boolean f24028c;
    }

    public CrudoNet(Builder builder) {
        if (builder.f24026a == null) {
            throw new NullPointerException("Missing engine");
        }
        this.f24029a = builder.f24026a;
        if (builder.f24027b == null) {
            builder.f24027b = Executors.newFixedThreadPool(4);
        }
        this.f24030b = builder.f24027b;
        this.f24031c = builder.f24028c;
        this.f24032d = new RequestRunner(this);
    }

    public final FbHttpEngine m25970a() {
        return this.f24029a;
    }

    public final CancelTrigger m25969a(AppRequest appRequest) {
        if (appRequest == null) {
            throw new IllegalArgumentException("appRequest required");
        }
        RequestRunner requestRunner = this.f24032d;
        ExecutorDetour.a(requestRunner.f24049a.f24030b, new InternalRequestRunnable(requestRunner, appRequest), -1969377193);
        return appRequest.f24016e;
    }
}
