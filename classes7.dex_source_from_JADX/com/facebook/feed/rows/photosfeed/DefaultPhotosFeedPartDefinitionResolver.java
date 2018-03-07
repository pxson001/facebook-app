package com.facebook.feed.rows.photosfeed;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.MultiRowGroupPartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: action_og_object */
public class DefaultPhotosFeedPartDefinitionResolver {
    private static DefaultPhotosFeedPartDefinitionResolver f20019d;
    private static final Object f20020e = new Object();
    private final Lazy<PhotosFeedStoryGroupPartDefinition> f20021a;
    public final Lazy<PhotosFeedMediaMetadataRootPartDefinition> f20022b;
    public final PhotosFeedBasicRootPartDefinitionProvider f20023c;

    /* compiled from: action_og_object */
    class C17301 implements Lazy<PhotosFeedBasicRootPartDefinition> {
        final /* synthetic */ DefaultPhotosFeedPartDefinitionResolver f20018a;

        C17301(DefaultPhotosFeedPartDefinitionResolver defaultPhotosFeedPartDefinitionResolver) {
            this.f20018a = defaultPhotosFeedPartDefinitionResolver;
        }

        public Object get() {
            PhotosFeedBasicRootPartDefinitionProvider photosFeedBasicRootPartDefinitionProvider = this.f20018a.f20023c;
            return new PhotosFeedBasicRootPartDefinition(this.f20018a.f20022b, IdBasedLazy.a(photosFeedBasicRootPartDefinitionProvider, 6021), IdBasedLazy.a(photosFeedBasicRootPartDefinitionProvider, 6023), IdBasedLazy.a(photosFeedBasicRootPartDefinitionProvider, 6019));
        }
    }

    private static DefaultPhotosFeedPartDefinitionResolver m23209b(InjectorLike injectorLike) {
        return new DefaultPhotosFeedPartDefinitionResolver(IdBasedLazy.a(injectorLike, 5949), IdBasedLazy.a(injectorLike, 5941), (PhotosFeedBasicRootPartDefinitionProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(PhotosFeedBasicRootPartDefinitionProvider.class));
    }

    @Inject
    public DefaultPhotosFeedPartDefinitionResolver(Lazy<PhotosFeedStoryGroupPartDefinition> lazy, Lazy<PhotosFeedMediaMetadataRootPartDefinition> lazy2, PhotosFeedBasicRootPartDefinitionProvider photosFeedBasicRootPartDefinitionProvider) {
        this.f20021a = lazy;
        this.f20022b = lazy2;
        this.f20023c = photosFeedBasicRootPartDefinitionProvider;
    }

    public final Lazy<? extends MultiRowGroupPartDefinition> m23210a() {
        return this.f20021a;
    }

    public final Lazy<? extends MultiRowGroupPartDefinition> m23211b() {
        return new C17301(this);
    }

    public static DefaultPhotosFeedPartDefinitionResolver m23208a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            DefaultPhotosFeedPartDefinitionResolver b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20020e) {
                DefaultPhotosFeedPartDefinitionResolver defaultPhotosFeedPartDefinitionResolver;
                if (a2 != null) {
                    defaultPhotosFeedPartDefinitionResolver = (DefaultPhotosFeedPartDefinitionResolver) a2.a(f20020e);
                } else {
                    defaultPhotosFeedPartDefinitionResolver = f20019d;
                }
                if (defaultPhotosFeedPartDefinitionResolver == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23209b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20020e, b3);
                        } else {
                            f20019d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = defaultPhotosFeedPartDefinitionResolver;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
