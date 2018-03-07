package com.facebook.platform.composer.model;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.platform.composer.abtest.ExperimentsForPlatformComposerModule;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;

@ContextScoped
/* compiled from: rich_document_block_bind */
public class PlatformComposerConfiguration {
    private static PlatformComposerConfiguration f4162h;
    private static final Object f4163i = new Object();
    public ContainerType f4164a;
    public PostButtonPosition f4165b;
    public final HeaderType f4166c;
    public final boolean f4167d;
    public final boolean f4168e;
    public final boolean f4169f;
    public final boolean f4170g;

    /* compiled from: rich_document_block_bind */
    public enum ContainerType {
        FULL,
        MINI
    }

    /* compiled from: rich_document_block_bind */
    public enum HeaderType {
        STACKED,
        TARGET_PRIVACY
    }

    /* compiled from: rich_document_block_bind */
    public enum PostButtonPosition {
        TOP,
        BOTTOM,
        BIG_BOTTOM
    }

    private static PlatformComposerConfiguration m4124b(InjectorLike injectorLike) {
        return new PlatformComposerConfiguration((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public PlatformComposerConfiguration(QeAccessor qeAccessor) {
        switch (qeAccessor.a(Liveness.Live, ExperimentsForPlatformComposerModule.f3935e, 0)) {
            case 1:
                this.f4164a = ContainerType.MINI;
                break;
            default:
                this.f4164a = ContainerType.FULL;
                break;
        }
        String a = qeAccessor.a(Liveness.Live, ExperimentsForPlatformComposerModule.f3940j, "default");
        if (a.equals("bottom")) {
            this.f4165b = PostButtonPosition.BOTTOM;
        } else if (a.equals("big_bottom")) {
            this.f4165b = PostButtonPosition.BIG_BOTTOM;
        } else {
            this.f4165b = PostButtonPosition.TOP;
        }
        this.f4167d = qeAccessor.a(Liveness.Live, ExperimentsForPlatformComposerModule.f3931a, true);
        if (qeAccessor.a(Liveness.Live, ExperimentsForPlatformComposerModule.f3933c, "default").equals("target_privacy")) {
            this.f4166c = HeaderType.TARGET_PRIVACY;
            this.f4168e = false;
        } else {
            this.f4166c = HeaderType.STACKED;
            this.f4168e = true;
        }
        this.f4169f = qeAccessor.a(Liveness.Live, ExperimentsForPlatformComposerModule.f3938h, false);
        this.f4170g = qeAccessor.a(Liveness.Live, ExperimentsForPlatformComposerModule.f3934d, false);
    }

    public static PlatformComposerConfiguration m4123a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PlatformComposerConfiguration b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f4163i) {
                PlatformComposerConfiguration platformComposerConfiguration;
                if (a2 != null) {
                    platformComposerConfiguration = (PlatformComposerConfiguration) a2.a(f4163i);
                } else {
                    platformComposerConfiguration = f4162h;
                }
                if (platformComposerConfiguration == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m4124b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f4163i, b3);
                        } else {
                            f4162h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = platformComposerConfiguration;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
