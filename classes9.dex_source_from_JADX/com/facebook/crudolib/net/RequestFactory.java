package com.facebook.crudolib.net;

import com.facebook.crudolib.netengine.HttpEngineRequest$Builder;
import com.facebook.crudolib.netmodule.CrudoNetModule.C29121;
import javax.annotation.Nullable;

/* compiled from: TincanSignalingPacketDelete */
public class RequestFactory {
    public final CrudoNet f24042a;
    final ChainableRequestMutator f24043b;
    public final ChainableRequestMutator f24044c;
    @Nullable
    final C29121 f24045d;
    @Nullable
    public final ResponseInterceptor f24046e;

    /* compiled from: TincanSignalingPacketDelete */
    public class Builder {
        final CrudoNet f24037a;
        public final ChainableRequestMutatorBuilder f24038b;
        @Nullable
        public C29121 f24039c;
        @Nullable
        public ResponseInterceptor f24040d;

        public Builder(CrudoNet crudoNet) {
            if (crudoNet == null) {
                throw new IllegalArgumentException("crudoNet cannot be null");
            }
            this.f24037a = crudoNet;
            this.f24038b = new ChainableRequestMutatorBuilder();
        }

        public Builder(RequestFactory requestFactory) {
            this.f24037a = requestFactory.f24042a;
            this.f24038b = new ChainableRequestMutatorBuilder(requestFactory.f24043b);
            this.f24039c = requestFactory.f24045d;
            this.f24040d = requestFactory.f24046e;
        }

        public final RequestFactory m25973b() {
            return new RequestFactory(this);
        }
    }

    /* compiled from: TincanSignalingPacketDelete */
    class UserAgentRequestMutator implements RequestMutator {
        private final C29121 f24041a;

        public UserAgentRequestMutator(C29121 c29121) {
            this.f24041a = c29121;
        }

        public final void mo1108a(HttpEngineRequest$Builder httpEngineRequest$Builder) {
            String str = (String) this.f24041a.f24117a.get();
            if (str != null) {
                httpEngineRequest$Builder.mo1114b("User-Agent", str);
            }
        }
    }

    public RequestFactory(Builder builder) {
        this.f24042a = builder.f24037a;
        this.f24043b = builder.f24038b.m25964a();
        if (builder.f24039c != null) {
            builder.f24038b.m25965a(new UserAgentRequestMutator(builder.f24039c));
        }
        this.f24044c = builder.f24038b.m25964a();
        this.f24045d = builder.f24039c;
        this.f24046e = builder.f24040d;
    }
}
