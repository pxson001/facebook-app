package com.facebook.maps.rows;

import android.content.Context;
import android.content.res.Resources;
import com.facebook.android.maps.StaticMapView;
import com.facebook.android.maps.StaticMapView.StaticMapOptions;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.locale.FBLocaleMapper;
import com.facebook.common.locale.Locales;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.maps.FbStaticMapView;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import javax.inject.Inject;

@ContextScoped
/* compiled from: new_app_id */
public class PrefetchMapPartDefinition<E extends HasPrefetcher> extends BaseSinglePartDefinition<Props, Void, E, FbStaticMapView> {
    public static final CallerContext f7156a = CallerContext.a(MapPartDefinition.class, "newsfeed_map_view", "map", "native_newsfeed");
    private static PrefetchMapPartDefinition f7157d;
    private static final Object f7158e = new Object();
    public final Lazy<Locales> f7159b;
    public final Lazy<Resources> f7160c;

    /* compiled from: new_app_id */
    public class Props {
        public final FeedProps<GraphQLStory> f13683a;
        public final Integer f13684b;
        public final Integer f13685c;
        public final StaticMapOptions f13686d;

        public Props(FeedProps<GraphQLStory> feedProps, StaticMapOptions staticMapOptions, int i, int i2) {
            this.f13683a = feedProps;
            this.f13686d = staticMapOptions;
            this.f13684b = Integer.valueOf(i);
            this.f13685c = Integer.valueOf(i2);
        }
    }

    private static PrefetchMapPartDefinition m7481b(InjectorLike injectorLike) {
        return new PrefetchMapPartDefinition(IdBasedSingletonScopeProvider.b(injectorLike, 576), IdBasedSingletonScopeProvider.b(injectorLike, 30));
    }

    public final Object m7482a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        HasPrefetcher hasPrefetcher = (HasPrefetcher) anyEnvironment;
        if (props.f13683a != null) {
            StaticMapOptions staticMapOptions = props.f13686d;
            hasPrefetcher.a(ImageRequest.a(StaticMapView.m14284a(props.f13684b.intValue(), props.f13685c.intValue(), 2, (Resources) this.f7160c.get(), FBLocaleMapper.a(((Locales) this.f7159b.get()).a()), staticMapOptions)), f7156a);
        }
        return null;
    }

    public static PrefetchMapPartDefinition m7480a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PrefetchMapPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f7158e) {
                PrefetchMapPartDefinition prefetchMapPartDefinition;
                if (a2 != null) {
                    prefetchMapPartDefinition = (PrefetchMapPartDefinition) a2.a(f7158e);
                } else {
                    prefetchMapPartDefinition = f7157d;
                }
                if (prefetchMapPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m7481b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f7158e, b3);
                        } else {
                            f7157d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = prefetchMapPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PrefetchMapPartDefinition(Lazy<Locales> lazy, Lazy<Resources> lazy2) {
        this.f7159b = lazy;
        this.f7160c = lazy2;
    }
}
