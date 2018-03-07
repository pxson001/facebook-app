package com.facebook.photos.mediagallery.ui;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.draggable.Direction;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.photos.dialog.PhotoAnimationDialogFragment;
import com.facebook.photos.dialog.PhotoAnimationDialogLaunchParams.Builder;
import com.facebook.photos.dialog.util.PhotosDialogPerfUtil;
import com.facebook.photos.mediafetcher.MediaFetcherFactory;
import com.facebook.photos.mediagallery.launcher.MediaGalleryLauncher;
import com.facebook.photos.mediagallery.launcher.MediaGalleryLauncherParams;
import com.facebook.photos.mediagallery.launcher.animation.AnimationParamProvider;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: sort_applied */
public class DefaultMediaGalleryLauncher implements MediaGalleryLauncher {
    private static final CallerContext f2347a = CallerContext.a(MediaGalleryFragment.class, "photo_viewer");
    private static DefaultMediaGalleryLauncher f2348e;
    private static final Object f2349f = new Object();
    private final MediaFetcherFactory f2350b;
    private final PhotosDialogPerfUtil f2351c;
    private final QeAccessor f2352d;

    private static DefaultMediaGalleryLauncher m2460b(InjectorLike injectorLike) {
        return new DefaultMediaGalleryLauncher(MediaFetcherFactory.b(injectorLike), PhotosDialogPerfUtil.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public DefaultMediaGalleryLauncher(MediaFetcherFactory mediaFetcherFactory, PhotosDialogPerfUtil photosDialogPerfUtil, QeAccessor qeAccessor) {
        this.f2350b = mediaFetcherFactory;
        this.f2351c = photosDialogPerfUtil;
        this.f2352d = qeAccessor;
    }

    public final void m2461a(Context context, MediaGalleryLauncherParams mediaGalleryLauncherParams, @Nullable AnimationParamProvider animationParamProvider) {
        m2462a(context, mediaGalleryLauncherParams, animationParamProvider, null);
    }

    public static DefaultMediaGalleryLauncher m2459a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            DefaultMediaGalleryLauncher b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f2349f) {
                DefaultMediaGalleryLauncher defaultMediaGalleryLauncher;
                if (a2 != null) {
                    defaultMediaGalleryLauncher = (DefaultMediaGalleryLauncher) a2.a(f2349f);
                } else {
                    defaultMediaGalleryLauncher = f2348e;
                }
                if (defaultMediaGalleryLauncher == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m2460b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f2349f, b3);
                        } else {
                            f2348e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = defaultMediaGalleryLauncher;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final void m2462a(Context context, MediaGalleryLauncherParams mediaGalleryLauncherParams, @Nullable AnimationParamProvider animationParamProvider, @Nullable OnDismissListener onDismissListener) {
        MediaGalleryFragment a = MediaGalleryFragment.m2505a(mediaGalleryLauncherParams, this.f2350b, this.f2351c, f2347a, this.f2352d);
        Builder a2 = new Builder(mediaGalleryLauncherParams).a(Direction.UP);
        a2.f = Direction.UP.flag() | Direction.DOWN.flag();
        a2 = a2;
        a2.g = -16777216;
        if (!PhotoAnimationDialogFragment.a(context, a, a2.a(), animationParamProvider, onDismissListener)) {
            a.aq();
        }
    }
}
