package com.facebook.richdocument.view.autoplay;

import android.content.Context;
import com.facebook.common.network.FbDataConnectionManager;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.http.observer.ConnectionQuality;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.video.analytics.VideoDisplayedInfo.AutoPlayFailureReason;
import com.facebook.video.settings.VideoAutoPlaySettingsChecker;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;

@ContextScoped
/* compiled from: passIfNotSupported */
public class VideoAutoPlayPolicy {
    private static VideoAutoPlayPolicy f6574c;
    private static final Object f6575d = new Object();
    private final VideoAutoPlaySettingsChecker f6576a;
    private final FbDataConnectionManager f6577b;

    private static VideoAutoPlayPolicy m6890b(InjectorLike injectorLike) {
        return new VideoAutoPlayPolicy(VideoAutoPlaySettingsChecker.a(injectorLike), FbDataConnectionManager.a(injectorLike));
    }

    @Inject
    public VideoAutoPlayPolicy(VideoAutoPlaySettingsChecker videoAutoPlaySettingsChecker, FbDataConnectionManager fbDataConnectionManager) {
        this.f6576a = videoAutoPlaySettingsChecker;
        this.f6577b = fbDataConnectionManager;
    }

    public final boolean m6891a() {
        Set hashSet = new HashSet();
        if (!this.f6576a.a(hashSet)) {
            hashSet.remove(AutoPlayFailureReason.DISABLED_BY_ALREADY_SEEN);
            hashSet.remove(AutoPlayFailureReason.DISABLED_BY_UNKNOWN_AUTOPLAY_SETTINGS);
            hashSet.remove(AutoPlayFailureReason.DISABLED_BY_AUTOPLAY_SETTING);
            if (!hashSet.isEmpty()) {
                return false;
            }
        }
        if (this.f6577b.c() == ConnectionQuality.EXCELLENT) {
            return true;
        }
        return false;
    }

    public static VideoAutoPlayPolicy m6889a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            VideoAutoPlayPolicy b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f6575d) {
                VideoAutoPlayPolicy videoAutoPlayPolicy;
                if (a2 != null) {
                    videoAutoPlayPolicy = (VideoAutoPlayPolicy) a2.a(f6575d);
                } else {
                    videoAutoPlayPolicy = f6574c;
                }
                if (videoAutoPlayPolicy == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m6890b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f6575d, b3);
                        } else {
                            f6574c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = videoAutoPlayPolicy;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
