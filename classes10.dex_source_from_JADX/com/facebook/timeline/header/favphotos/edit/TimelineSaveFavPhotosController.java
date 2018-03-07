package com.facebook.timeline.header.favphotos.edit;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.cache.GraphQLCacheManager;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.inject.Inject;

@ContextScoped
/* compiled from: fetch_nearby_friends_location_sharing */
public class TimelineSaveFavPhotosController {
    private static TimelineSaveFavPhotosController f11809c;
    private static final Object f11810d = new Object();
    public GraphQLQueryExecutor f11811a;
    public GraphQLCacheManager f11812b;

    private static TimelineSaveFavPhotosController m11878b(InjectorLike injectorLike) {
        return new TimelineSaveFavPhotosController(GraphQLQueryExecutor.a(injectorLike), GraphQLCacheManager.a(injectorLike));
    }

    @Inject
    public TimelineSaveFavPhotosController(GraphQLQueryExecutor graphQLQueryExecutor, GraphQLCacheManager graphQLCacheManager) {
        this.f11811a = graphQLQueryExecutor;
        this.f11812b = graphQLCacheManager;
    }

    public static TimelineSaveFavPhotosController m11877a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            TimelineSaveFavPhotosController b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f11810d) {
                TimelineSaveFavPhotosController timelineSaveFavPhotosController;
                if (a2 != null) {
                    timelineSaveFavPhotosController = (TimelineSaveFavPhotosController) a2.a(f11810d);
                } else {
                    timelineSaveFavPhotosController = f11809c;
                }
                if (timelineSaveFavPhotosController == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m11878b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f11810d, b3);
                        } else {
                            f11809c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = timelineSaveFavPhotosController;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
