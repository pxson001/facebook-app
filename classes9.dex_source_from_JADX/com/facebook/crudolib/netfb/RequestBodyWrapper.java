package com.facebook.crudolib.netfb;

import com.facebook.crudolib.net.Releasable;
import com.facebook.crudolib.netengine.HttpEngineRequestBody;

/* compiled from: TimelineInfoReviewAdapter.unknown_viewtype */
public abstract class RequestBodyWrapper implements Releasable, HttpEngineRequestBody {
    private HttpEngineRequestBody f24091a;

    protected RequestBodyWrapper(HttpEngineRequestBody httpEngineRequestBody) {
        this.f24091a = httpEngineRequestBody;
    }

    public final HttpEngineRequestBody m26039d() {
        return this.f24091a;
    }

    public final String mo1124b() {
        return this.f24091a.mo1124b();
    }

    public long mo1123a() {
        return this.f24091a.mo1123a();
    }

    public final void mo1125c() {
        if (this.f24091a instanceof Releasable) {
            ((Releasable) this.f24091a).mo1125c();
        }
    }
}
