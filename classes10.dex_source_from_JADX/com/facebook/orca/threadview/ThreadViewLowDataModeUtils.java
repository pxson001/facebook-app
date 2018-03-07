package com.facebook.orca.threadview;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.android.ConnectivityManagerMethodAutoProvider;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequest.RequestLevel;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.attachments.ImageAttachmentData;
import com.facebook.messaging.lowdatamode.LowDataModeManager;
import com.facebook.messaging.media.prefetch.ThreadViewImageUriGetter;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

@UserScoped
/* compiled from: message has platform metadata */
public class ThreadViewLowDataModeUtils {
    private static final Object f7649d = new Object();
    public ConnectivityManager f7650a;
    public FbSharedPreferences f7651b;
    private final LowDataModeManager f7652c;

    private static ThreadViewLowDataModeUtils m7359b(InjectorLike injectorLike) {
        return new ThreadViewLowDataModeUtils((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), IdBasedProvider.a(injectorLike, 4165), ConnectivityManagerMethodAutoProvider.b(injectorLike), LowDataModeManager.a(injectorLike));
    }

    @Inject
    public ThreadViewLowDataModeUtils(FbSharedPreferences fbSharedPreferences, Provider<Boolean> provider, ConnectivityManager connectivityManager, LowDataModeManager lowDataModeManager) {
        this.f7651b = fbSharedPreferences;
        this.f7650a = connectivityManager;
        this.f7652c = lowDataModeManager;
    }

    public final boolean m7360a() {
        if (this.f7652c.a()) {
            int i = 1;
            NetworkInfo networkInfo = this.f7650a.getNetworkInfo(1);
            if (!(networkInfo != null && networkInfo.isConnected() && networkInfo.isAvailable())) {
                i = 0;
            }
            if (i == 0) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.orca.threadview.ThreadViewLowDataModeUtils m7358a(com.facebook.inject.InjectorLike r7) {
        /*
        r2 = com.facebook.inject.ScopeSet.a();
        r0 = com.facebook.auth.userscope.UserScope.class;
        r0 = r7.getInstance(r0);
        r0 = (com.facebook.auth.userscope.UserScope) r0;
        r1 = r7.getScopeAwareInjector();
        r1 = r1.b();
        if (r1 != 0) goto L_0x001e;
    L_0x0016:
        r0 = new com.facebook.inject.ProvisioningException;
        r1 = "Called user scoped provider outside of context scope";
        r0.<init>(r1);
        throw r0;
    L_0x001e:
        r3 = r0.a(r1);
        r4 = r3.b();	 Catch:{ all -> 0x006c }
        r1 = f7649d;	 Catch:{ all -> 0x006c }
        r1 = r4.get(r1);	 Catch:{ all -> 0x006c }
        r5 = com.facebook.auth.userscope.UserScope.a;	 Catch:{ all -> 0x006c }
        if (r1 != r5) goto L_0x0035;
    L_0x0030:
        r3.c();
        r0 = 0;
    L_0x0034:
        return r0;
    L_0x0035:
        if (r1 != 0) goto L_0x007c;
    L_0x0037:
        r1 = 4;
        r5 = r2.b(r1);	 Catch:{  }
        r6 = r0.a(r3);	 Catch:{ all -> 0x0067 }
        r0 = r6.e();	 Catch:{ all -> 0x0062 }
        r1 = m7359b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f7649d;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.orca.threadview.ThreadViewLowDataModeUtils) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.orca.threadview.ThreadViewLowDataModeUtils) r0;	 Catch:{  }
        r3.c();
        goto L_0x0034;
    L_0x0062:
        r0 = move-exception;
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0067:
        r0 = move-exception;
        r2.c(r5);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x006c:
        r0 = move-exception;
        r3.c();
        throw r0;
    L_0x0071:
        r0 = f7649d;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.orca.threadview.ThreadViewLowDataModeUtils) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.orca.threadview.ThreadViewLowDataModeUtils.a(com.facebook.inject.InjectorLike):com.facebook.orca.threadview.ThreadViewLowDataModeUtils");
    }

    @Nullable
    public static ImageRequest m7357a(ImageAttachmentData imageAttachmentData, int i) {
        Uri a = ThreadViewImageUriGetter.m3136a(i, imageAttachmentData.b);
        if (a == null) {
            a = ThreadViewImageUriGetter.m3136a(i, imageAttachmentData.a);
        }
        if (a == null) {
            return null;
        }
        ImageRequestBuilder a2 = ImageRequestBuilder.a(a);
        a2.b = RequestLevel.DISK_CACHE;
        return a2.m();
    }
}
