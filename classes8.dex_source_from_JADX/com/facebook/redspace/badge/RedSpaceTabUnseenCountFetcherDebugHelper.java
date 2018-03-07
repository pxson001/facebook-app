package com.facebook.redspace.badge;

import android.content.Context;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ultralight.Inject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@ContextScoped
/* compiled from: Unable to Attach Media Channel */
public class RedSpaceTabUnseenCountFetcherDebugHelper {
    private static RedSpaceTabUnseenCountFetcherDebugHelper f21291b;
    private static final Object f21292c = new Object();
    private final ObjectWriter f21293a;

    private static RedSpaceTabUnseenCountFetcherDebugHelper m24903b(InjectorLike injectorLike) {
        return new RedSpaceTabUnseenCountFetcherDebugHelper((ObjectMapper) FbObjectMapperMethodAutoProvider.a(injectorLike));
    }

    @Inject
    private RedSpaceTabUnseenCountFetcherDebugHelper(ObjectMapper objectMapper) {
        this.f21293a = objectMapper.g().a();
    }

    public final String m24904a(RedSpaceTabUnseenCountFetcher redSpaceTabUnseenCountFetcher) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unseen count:\n").append(redSpaceTabUnseenCountFetcher.m24897e());
        try {
            stringBuilder.append("\nApproximate count:\n").append(this.f21293a.a(redSpaceTabUnseenCountFetcher.m24898f()));
        } catch (JsonProcessingException e) {
            stringBuilder.append("\nApproximate count:\nCouldn't convert. Reason:").append(e);
        }
        stringBuilder.append("\nLast fetch time:\n").append(redSpaceTabUnseenCountFetcher.m24899g());
        stringBuilder.append("\nCache freshness TOP:\n").append(redSpaceTabUnseenCountFetcher.m24900h());
        stringBuilder.append("\nCache freshness OTHERS:\n").append(redSpaceTabUnseenCountFetcher.m24901i());
        return stringBuilder.toString();
    }

    public static RedSpaceTabUnseenCountFetcherDebugHelper m24902a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            RedSpaceTabUnseenCountFetcherDebugHelper b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f21292c) {
                RedSpaceTabUnseenCountFetcherDebugHelper redSpaceTabUnseenCountFetcherDebugHelper;
                if (a2 != null) {
                    redSpaceTabUnseenCountFetcherDebugHelper = (RedSpaceTabUnseenCountFetcherDebugHelper) a2.a(f21292c);
                } else {
                    redSpaceTabUnseenCountFetcherDebugHelper = f21291b;
                }
                if (redSpaceTabUnseenCountFetcherDebugHelper == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m24903b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f21292c, b3);
                        } else {
                            f21291b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = redSpaceTabUnseenCountFetcherDebugHelper;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
