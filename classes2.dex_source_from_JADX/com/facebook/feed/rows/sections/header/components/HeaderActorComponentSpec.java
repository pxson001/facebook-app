package com.facebook.feed.rows.sections.header.components;

import android.content.Context;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.TriState;
import com.facebook.components.annotations.LayoutSpec;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feedplugins.graphqlstory.header.DefaultHeaderPartDataProviderForTextLayout;
import com.facebook.feedplugins.images.FbFeedFrescoComponent;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.video.settings.VideoAutoPlaySettingsChecker;
import javax.inject.Inject;

@LayoutSpec
@ContextScoped
/* compiled from: image_low_height */
public class HeaderActorComponentSpec<E extends HasFeedListType & HasPersistentState & HasPrefetcher & HasRowKey> {
    public static final CallerContext f20408a = CallerContext.m9061a(HeaderActorComponentSpec.class, "native_newsfeed");
    private static HeaderActorComponentSpec f20409g;
    private static final Object f20410h = new Object();
    public final DefaultHeaderPartDataProviderForTextLayout f20411b;
    public final FbFeedFrescoComponent<E> f20412c;
    public final QeAccessor f20413d;
    public final VideoAutoPlaySettingsChecker f20414e;
    public TriState f20415f = TriState.UNSET;

    private static HeaderActorComponentSpec m28158b(InjectorLike injectorLike) {
        return new HeaderActorComponentSpec(FbFeedFrescoComponent.m28159a(injectorLike), DefaultHeaderPartDataProviderForTextLayout.m28171a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike), VideoAutoPlaySettingsChecker.m26868a(injectorLike));
    }

    public static HeaderActorComponentSpec m28157a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            HeaderActorComponentSpec b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20410h) {
                HeaderActorComponentSpec headerActorComponentSpec;
                if (a2 != null) {
                    headerActorComponentSpec = (HeaderActorComponentSpec) a2.mo818a(f20410h);
                } else {
                    headerActorComponentSpec = f20409g;
                }
                if (headerActorComponentSpec == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28158b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20410h, b3);
                        } else {
                            f20409g = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = headerActorComponentSpec;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public HeaderActorComponentSpec(FbFeedFrescoComponent fbFeedFrescoComponent, DefaultHeaderPartDataProviderForTextLayout defaultHeaderPartDataProviderForTextLayout, QeAccessor qeAccessor, VideoAutoPlaySettingsChecker videoAutoPlaySettingsChecker) {
        this.f20412c = fbFeedFrescoComponent;
        this.f20411b = defaultHeaderPartDataProviderForTextLayout;
        this.f20413d = qeAccessor;
        this.f20414e = videoAutoPlaySettingsChecker;
    }
}
