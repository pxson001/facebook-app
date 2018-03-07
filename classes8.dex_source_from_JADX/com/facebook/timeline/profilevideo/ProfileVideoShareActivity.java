package com.facebook.timeline.profilevideo;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.auth.annotations.LoggedInUserId;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.content.SecureContextHelper;
import com.facebook.debug.log.BLog;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.photos.editgallery.utils.FetchImageUtils;
import com.facebook.platform.common.util.PlatformPackageUtilities;
import com.facebook.share.model.ComposerAppAttribution;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: mPresenceSourceType */
public class ProfileVideoShareActivity extends FbFragmentActivity {
    @Inject
    private FetchImageUtils f9329p;
    @Inject
    public ProfileVideoPreviewLauncherImpl f9330q;
    @Inject
    @Lazy
    @LoggedInUserId
    private com.facebook.inject.Lazy<String> f9331r = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<UriIntentMapper> f9332s = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<SecureContextHelper> f9333t = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<PlatformPackageUtilities> f9334u = UltralightRuntime.b;
    private Uri f9335v;
    public boolean f9336w;

    private static <T extends Context> void m11093a(Class<T> cls, T t) {
        m11094a((Object) t, (Context) t);
    }

    public static void m11094a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((ProfileVideoShareActivity) obj).m11091a(FetchImageUtils.b(fbInjector), ProfileVideoPreviewLauncherImpl.m11085b(fbInjector), IdBasedLazy.a(fbInjector, 4442), IdBasedSingletonScopeProvider.b(fbInjector, 2436), IdBasedSingletonScopeProvider.b(fbInjector, 968), IdBasedLazy.a(fbInjector, 9638));
    }

    protected final void m11097a(Bundle bundle) {
        Class cls = ProfileVideoShareActivity.class;
        m11094a((Object) this, (Context) this);
    }

    protected final void m11098b(@Nullable Bundle bundle) {
        super.b(bundle);
        if (bundle != null && bundle.containsKey("uri_key") && bundle.containsKey("has_launched_preview_key")) {
            this.f9335v = (Uri) bundle.getParcelable("uri_key");
            this.f9336w = bundle.getBoolean("has_launched_preview_key");
        } else {
            this.f9335v = (Uri) getIntent().getParcelableExtra("android.intent.extra.STREAM");
            this.f9336w = false;
        }
        if (this.f9335v == null) {
            m11095a("Video Uri is NULL", new Object[0]);
            return;
        }
        String stringExtra;
        String stringExtra2;
        String a;
        final boolean z = !getIntent().getAction().equals("android.intent.action.SEND");
        if (z) {
            stringExtra = getIntent().getStringExtra("proxied_app_id");
        } else {
            stringExtra = null;
        }
        if (z) {
            stringExtra2 = getIntent().getStringExtra("proxied_app_package_name");
        } else {
            stringExtra2 = null;
        }
        if (z) {
            a = ((PlatformPackageUtilities) this.f9334u.get()).a(stringExtra2, 0);
        } else {
            a = null;
        }
        if (!this.f9336w) {
            try {
                this.f9329p.b(this, this.f9335v, new AbstractDisposableFutureCallback<Uri>(this) {
                    final /* synthetic */ ProfileVideoShareActivity f9328d;

                    protected final void m11088a(Object obj) {
                        Uri uri = (Uri) obj;
                        Preconditions.checkNotNull(uri);
                        ComposerAppAttribution composerAppAttribution = z ? new ComposerAppAttribution(stringExtra, "", a, "") : null;
                        this.f9328d.f9336w = true;
                        this.f9328d.f9330q.mo53a(this.f9328d, SafeUUIDGenerator.a().toString(), uri, 5, 1002, null, composerAppAttribution, 0);
                    }

                    protected final void m11089a(Throwable th) {
                        this.f9328d.m11095a("Failed to covert content Uri to file Uri: %s", th.toString());
                    }
                });
            } catch (IllegalArgumentException e) {
                m11095a(e.getMessage(), new Object[0]);
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putParcelable("uri_key", this.f9335v);
        bundle.putBoolean("has_launched_preview_key", this.f9336w);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 != -1) {
            finish();
            return;
        }
        Intent a = ((UriIntentMapper) this.f9332s.get()).a(this, StringFormatUtil.a(FBLinks.aX, new Object[]{this.f9331r.get()}));
        if (a == null) {
            m11095a("Failed to obtain logged in user", new Object[0]);
            return;
        }
        ((SecureContextHelper) this.f9333t.get()).a(a, this);
        finish();
    }

    private void m11095a(String str, Object... objArr) {
        BLog.b(ProfileVideoShareActivity.class.getCanonicalName(), str, objArr);
        finish();
    }

    private void m11091a(FetchImageUtils fetchImageUtils, ProfileVideoPreviewLauncherImpl profileVideoPreviewLauncherImpl, com.facebook.inject.Lazy<String> lazy, com.facebook.inject.Lazy<UriIntentMapper> lazy2, com.facebook.inject.Lazy<SecureContextHelper> lazy3, com.facebook.inject.Lazy<PlatformPackageUtilities> lazy4) {
        this.f9329p = fetchImageUtils;
        this.f9330q = profileVideoPreviewLauncherImpl;
        this.f9331r = lazy;
        this.f9332s = lazy2;
        this.f9333t = lazy3;
        this.f9334u = lazy4;
    }
}
