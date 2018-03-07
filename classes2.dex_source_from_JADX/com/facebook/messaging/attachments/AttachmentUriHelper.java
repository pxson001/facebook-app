package com.facebook.messaging.attachments;

import android.net.Uri.Builder;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.http.config.PlatformAppHttpConfig;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: mResumed= */
public class AttachmentUriHelper {
    private final Provider<PlatformAppHttpConfig> f15474a;
    private final Provider<ViewerContext> f15475b;

    public static AttachmentUriHelper m22032b(InjectorLike injectorLike) {
        return new AttachmentUriHelper(IdBasedProvider.m1811a(injectorLike, 2243), IdBasedProvider.m1811a(injectorLike, 372));
    }

    @Inject
    public AttachmentUriHelper(Provider<PlatformAppHttpConfig> provider, Provider<ViewerContext> provider2) {
        this.f15474a = provider;
        this.f15475b = provider2;
    }

    public final Builder m22033a() {
        Builder a = ((PlatformAppHttpConfig) this.f15474a.get()).mo1359a();
        a.appendEncodedPath("method/messaging.getAttachment");
        m22031a(a);
        return a;
    }

    public static String m22030a(String str) {
        return (str == null || str.startsWith("m_")) ? str : "m_" + str;
    }

    public final Builder m22034b() {
        Builder a = ((PlatformAppHttpConfig) this.f15474a.get()).mo1359a();
        a.appendEncodedPath("method/messaging.attachmentRedirect");
        m22031a(a);
        return a;
    }

    private void m22031a(Builder builder) {
        ViewerContext viewerContext = (ViewerContext) this.f15475b.get();
        if (viewerContext != null) {
            builder.appendQueryParameter("access_token", viewerContext.mAuthToken);
        }
    }
}
