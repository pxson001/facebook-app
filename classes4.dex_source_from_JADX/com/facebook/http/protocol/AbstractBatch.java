package com.facebook.http.protocol;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.http.protocol.ApiMethodRunner$Batch.Type;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: features */
public abstract class AbstractBatch implements ApiMethodRunner$Batch {
    private List<BatchOperation<?, ?>> f11910a = Lists.a();
    private List f11911b = Lists.a();
    private Map<String, Object> f11912c = Maps.c();
    private Map<String, Exception> f11913d = Maps.c();
    private Type f11914e = Type.NORMAL;
    public DeviceApiContext f11915f;
    private DeviceApiResult f11916g;

    public final <PARAMS, RESULT> void mo888a(BatchOperation<PARAMS, RESULT> batchOperation) {
        this.f11910a.add(batchOperation);
    }

    public final <RESULT> RESULT mo887a(String str) {
        return this.f11912c.get(str);
    }

    public final void mo889a(String str, CallerContext callerContext) {
        mo884a(str, callerContext, null);
    }

    @Nullable
    public final Exception mo890b(String str) {
        return (Exception) this.f11913d.get(str);
    }

    protected final List<BatchOperation<?, ?>> m12523a() {
        return this.f11910a;
    }

    public final Type m12529b() {
        return this.f11914e;
    }

    public final ApiMethodRunner$Batch mo885a(Type type) {
        this.f11914e = type;
        return this;
    }

    public final ApiMethodRunner$Batch mo886a(DeviceApiContext deviceApiContext) {
        this.f11915f = deviceApiContext;
        return this;
    }

    public final boolean m12531d() {
        return this.f11915f != null;
    }

    public final DeviceApiResult mo891e() {
        return this.f11916g;
    }

    protected final void m12525a(DeviceApiResult deviceApiResult) {
        this.f11916g = deviceApiResult;
    }

    protected final void m12528a(String str, Object obj) {
        this.f11911b.add(obj);
        if (str != null) {
            this.f11912c.put(str, obj);
        }
    }

    protected final void m12527a(String str, Exception exception) {
        if (str != null) {
            this.f11913d.put(str, exception);
        }
    }
}
