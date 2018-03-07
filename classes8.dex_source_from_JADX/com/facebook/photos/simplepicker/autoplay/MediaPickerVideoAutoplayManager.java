package com.facebook.photos.simplepicker.autoplay;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.autoplay.VideoAutoplayVisibilityDecider;
import com.facebook.feed.autoplay.VideoDisplayedCoordinator;
import com.facebook.feed.autoplay.VideoDisplayedCoordinatorProvider;
import com.facebook.feed.autoplay.VideoViewController;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.photos.simplepicker.view.PickerPlayableView;
import com.facebook.photos.simplepicker.view.SelectableView;
import javax.inject.Inject;

@ContextScoped
/* compiled from: show_password_unchecked */
public class MediaPickerVideoAutoplayManager<V extends View & PickerPlayableView & SelectableView> {
    private static MediaPickerVideoAutoplayManager f2921b;
    private static final Object f2922c = new Object();
    private final VideoDisplayedCoordinator<V> f2923a;

    private static MediaPickerVideoAutoplayManager m2992b(InjectorLike injectorLike) {
        return new MediaPickerVideoAutoplayManager(new MediaPickerVideoDisplayedSelector(VideoAutoplayVisibilityDecider.a(injectorLike)), (VideoDisplayedCoordinatorProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(VideoDisplayedCoordinatorProvider.class));
    }

    @Inject
    public MediaPickerVideoAutoplayManager(MediaPickerVideoDisplayedSelector mediaPickerVideoDisplayedSelector, VideoDisplayedCoordinatorProvider videoDisplayedCoordinatorProvider) {
        this.f2923a = videoDisplayedCoordinatorProvider.a(mediaPickerVideoDisplayedSelector, true);
    }

    public final void m2993a(V v, VideoViewController videoViewController) {
        this.f2923a.a(v, videoViewController);
    }

    public static MediaPickerVideoAutoplayManager m2991a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            MediaPickerVideoAutoplayManager b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f2922c) {
                MediaPickerVideoAutoplayManager mediaPickerVideoAutoplayManager;
                if (a2 != null) {
                    mediaPickerVideoAutoplayManager = (MediaPickerVideoAutoplayManager) a2.a(f2922c);
                } else {
                    mediaPickerVideoAutoplayManager = f2921b;
                }
                if (mediaPickerVideoAutoplayManager == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m2992b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f2922c, b3);
                        } else {
                            f2921b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = mediaPickerVideoAutoplayManager;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
