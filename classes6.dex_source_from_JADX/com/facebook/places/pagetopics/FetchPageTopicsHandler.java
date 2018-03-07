package com.facebook.places.pagetopics;

import android.content.Context;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.json.JsonFactoryMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunnerImpl;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.katana.app.module.LocaleMethodAutoProvider;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.io.File;
import java.util.Locale;
import javax.inject.Inject;

@ContextScoped
/* compiled from: formatted_address */
public class FetchPageTopicsHandler implements BlueServiceHandler {
    @VisibleForTesting
    static long f14726a = 0;
    private static final Class<?> f14727b = FetchPageTopicsHandler.class;
    private static FetchPageTopicsHandler f14728i;
    private static final Object f14729j = new Object();
    private final AbstractSingleMethodRunner f14730c;
    private final FetchPageTopicsMethod f14731d;
    private final Clock f14732e;
    private final ObjectMapper f14733f;
    private final Context f14734g;
    private final Locale f14735h;

    private static FetchPageTopicsHandler m22290b(InjectorLike injectorLike) {
        return new FetchPageTopicsHandler((AbstractSingleMethodRunner) SingleMethodRunnerImpl.a(injectorLike), new FetchPageTopicsMethod(LocaleMethodAutoProvider.b(injectorLike), JsonFactoryMethodAutoProvider.a(injectorLike)), (Clock) SystemClockMethodAutoProvider.a(injectorLike), (ObjectMapper) FbObjectMapperMethodAutoProvider.a(injectorLike), LocaleMethodAutoProvider.b(injectorLike), (Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public FetchPageTopicsHandler(AbstractSingleMethodRunner abstractSingleMethodRunner, FetchPageTopicsMethod fetchPageTopicsMethod, Clock clock, ObjectMapper objectMapper, Locale locale, Context context) {
        this.f14730c = abstractSingleMethodRunner;
        this.f14731d = fetchPageTopicsMethod;
        this.f14732e = clock;
        this.f14733f = objectMapper;
        this.f14735h = locale;
        this.f14734g = context;
    }

    public final OperationResult m22292a(OperationParams operationParams) {
        if (operationParams.a().equals("FetchPageTopics")) {
            OperationResult a;
            synchronized (FetchPageTopicsHandler.class) {
                FetchPageTopicsResult a2 = m22287a();
                long a3 = this.f14732e.a();
                if (a2 == null || !this.f14735h.toString().equals(a2.m22299c()) || a3 - f14726a >= 3600000) {
                    f14726a = a3;
                    try {
                        FetchPageTopicsResult a4 = m22288a(Long.valueOf(a2 != null ? a2.m22298b().m22295a() : -1));
                        Preconditions.checkNotNull(a4);
                        if (a4.m22296a() == null || a4.m22296a().size() == 0) {
                            Preconditions.checkNotNull(a2);
                            a = OperationResult.a(a2);
                        } else {
                            m22289a(a4);
                            a = OperationResult.a(a4);
                        }
                    } catch (Throwable e) {
                        if (a2 != null) {
                            BLog.b(f14727b, "Exception happened while gettings page topics, using cached result", e);
                            a = OperationResult.a(a2);
                        } else {
                            throw e;
                        }
                    }
                }
                a = OperationResult.a(a2);
            }
            return a;
        }
        throw new RuntimeException("unknown type");
    }

    public static FetchPageTopicsHandler m22286a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FetchPageTopicsHandler b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f14729j) {
                FetchPageTopicsHandler fetchPageTopicsHandler;
                if (a2 != null) {
                    fetchPageTopicsHandler = (FetchPageTopicsHandler) a2.a(f14729j);
                } else {
                    fetchPageTopicsHandler = f14728i;
                }
                if (fetchPageTopicsHandler == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m22290b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f14729j, b3);
                        } else {
                            f14728i = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = fetchPageTopicsHandler;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private FetchPageTopicsResult m22287a() {
        File b = m22291b();
        if (!b.exists()) {
            return null;
        }
        try {
            return (FetchPageTopicsResult) this.f14733f.a(b, FetchPageTopicsResult.class);
        } catch (Throwable e) {
            BLog.b(f14727b, "Error reading cache", e);
            return null;
        }
    }

    private void m22289a(FetchPageTopicsResult fetchPageTopicsResult) {
        try {
            this.f14733f.a(m22291b(), fetchPageTopicsResult);
        } catch (Throwable e) {
            BLog.b(f14727b, "Error writing cache", e);
        }
    }

    @VisibleForTesting
    private File m22291b() {
        return new File(this.f14734g.getExternalFilesDir(null), "page_topics.json");
    }

    private FetchPageTopicsResult m22288a(Long l) {
        return (FetchPageTopicsResult) this.f14730c.a(this.f14731d, l);
    }
}
