package com.facebook.bookmark.service;

import android.content.Context;
import com.facebook.bookmark.db.BookmarkDatabaseHelper;
import com.facebook.bookmark.protocol.BookmarkSetFavoritesMethod;
import com.facebook.bookmark.protocol.BookmarkSyncMethod;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunnerImpl;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.ContextScope;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.performancelogger.DelegatingPerformanceLogger;
import com.facebook.performancelogger.PerformanceLogger;
import com.fasterxml.jackson.databind.ObjectMapper;

/* compiled from: recent_outgoing_transactions */
public class BlueServiceHandler_BookmarkSyncQueueMethodAutoProvider extends AbstractProvider<BlueServiceHandler> {
    private static BlueServiceHandler f5678a;
    private static final Object f5679b = new Object();

    private static BlueServiceHandler m5903b(InjectorLike injectorLike) {
        return BookmarkServiceModule.m5905a((PerformanceLogger) DelegatingPerformanceLogger.a(injectorLike), BookmarkDatabaseHelper.m5834a(injectorLike), BroadcastSender.m5907a(injectorLike), (ObjectMapper) FbObjectMapperMethodAutoProvider.a(injectorLike), (AbstractSingleMethodRunner) SingleMethodRunnerImpl.a(injectorLike), BookmarkSyncMethod.m5898a(injectorLike), Integer_BookmarkExpireTimeoutMethodAutoProvider.m5910a(injectorLike), BookmarkSetFavoritesMethod.m5894a(injectorLike));
    }

    public Object get() {
        return BookmarkServiceModule.m5905a((PerformanceLogger) DelegatingPerformanceLogger.a(this), BookmarkDatabaseHelper.m5834a((InjectorLike) this), BroadcastSender.m5907a((InjectorLike) this), (ObjectMapper) FbObjectMapperMethodAutoProvider.a(this), (AbstractSingleMethodRunner) SingleMethodRunnerImpl.a(this), BookmarkSyncMethod.m5898a((InjectorLike) this), Integer_BookmarkExpireTimeoutMethodAutoProvider.m5910a(this), BookmarkSetFavoritesMethod.m5894a((InjectorLike) this));
    }

    public static BlueServiceHandler m5902a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            BlueServiceHandler b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f5679b) {
                BlueServiceHandler blueServiceHandler;
                if (a2 != null) {
                    blueServiceHandler = (BlueServiceHandler) a2.a(f5679b);
                } else {
                    blueServiceHandler = f5678a;
                }
                if (blueServiceHandler == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m5903b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f5679b, b3);
                        } else {
                            f5678a = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = blueServiceHandler;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
