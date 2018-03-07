package com.facebook.ufiservices.data;

import android.content.Context;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.Tuple;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLPageInfo;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ipc.feed.ProfileListParamType;
import com.facebook.ufiservices.flyout.ProfileListParams;
import com.google.common.collect.ImmutableList;
import java.util.List;

@ContextScoped
/* compiled from: data10 */
public class ActorProfilesLoader implements ProfilesListLoader {
    private static ActorProfilesLoader f17980a;
    private static final Object f17981b = new Object();

    private static ActorProfilesLoader m26503c() {
        return new ActorProfilesLoader();
    }

    public final ProfileListParamType mo1345a() {
        return ProfileListParamType.PROFILES;
    }

    public final void mo1346a(ProfileListParams profileListParams, AbstractDisposableFutureCallback<Tuple<List<GraphQLActor>, GraphQLPageInfo>> abstractDisposableFutureCallback, boolean z, String str, CallerContext callerContext) {
        ImmutableList a = profileListParams.m26565a();
        if (a == null || a.isEmpty()) {
            abstractDisposableFutureCallback.onFailure(new NullPointerException("No actors for profiles type"));
        } else {
            abstractDisposableFutureCallback.onSuccess(new Tuple(a, GraphQLHelper.a(null, null, false, false)));
        }
    }

    public final boolean mo1347b() {
        return false;
    }

    public static ActorProfilesLoader m26502a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ActorProfilesLoader c;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f17981b) {
                ActorProfilesLoader actorProfilesLoader;
                if (a2 != null) {
                    actorProfilesLoader = (ActorProfilesLoader) a2.a(f17981b);
                } else {
                    actorProfilesLoader = f17980a;
                }
                if (actorProfilesLoader == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        c = m26503c();
                        if (a2 != null) {
                            a2.a(f17981b, c);
                        } else {
                            f17980a = c;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    c = actorProfilesLoader;
                }
            }
            return c;
        } finally {
            a.c(b);
        }
    }
}
