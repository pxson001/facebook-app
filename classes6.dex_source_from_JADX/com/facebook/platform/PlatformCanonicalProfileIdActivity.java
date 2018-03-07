package com.facebook.platform;

import android.content.Context;
import android.os.Bundle;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.common.util.StringUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.crudolib.urimap.UriMatchPatterns;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.FbInjector;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.platform.server.handler.ParcelableString;
import com.facebook.platform.server.protocol.GetCanonicalProfileIdsMethod$Params;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.collect.Iterables;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.ArrayList;
import java.util.HashMap;
import javax.annotation.Nullable;

@UriMatchPatterns
/* compiled from: finalizeWfsTree */
public class PlatformCanonicalProfileIdActivity extends FbFragmentActivity {
    public UriIntentMapper f14845p;
    public DefaultBlueServiceOperationFactory f14846q;
    public SecureContextHelper f14847r;

    /* compiled from: finalizeWfsTree */
    class C09632 implements FutureCallback<OperationResult> {
        final /* synthetic */ PlatformCanonicalProfileIdActivity f14844a;

        C09632(PlatformCanonicalProfileIdActivity platformCanonicalProfileIdActivity) {
            this.f14844a = platformCanonicalProfileIdActivity;
        }

        public void onSuccess(@Nullable Object obj) {
            OperationResult operationResult = (OperationResult) obj;
            if (operationResult != null) {
                HashMap j = operationResult.j();
                if (!j.values().isEmpty()) {
                    this.f14844a.f14847r.a(this.f14844a.f14845p.a(this.f14844a, PlatformCanonicalProfileIdActivity.m22469c(((ParcelableString) Iterables.a(j.values(), 0)).f14934a)), this.f14844a);
                }
            }
            this.f14844a.finish();
        }

        public void onFailure(Throwable th) {
            this.f14844a.finish();
        }
    }

    private static <T extends Context> void m22465a(Class<T> cls, T t) {
        m22466a((Object) t, (Context) t);
    }

    public static void m22466a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        PlatformCanonicalProfileIdActivity platformCanonicalProfileIdActivity = (PlatformCanonicalProfileIdActivity) obj;
        UriIntentMapper uriIntentMapper = (UriIntentMapper) Fb4aUriIntentMapper.a(fbInjector);
        DefaultBlueServiceOperationFactory b = DefaultBlueServiceOperationFactory.b(fbInjector);
        SecureContextHelper secureContextHelper = (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector);
        platformCanonicalProfileIdActivity.f14845p = uriIntentMapper;
        platformCanonicalProfileIdActivity.f14846q = b;
        platformCanonicalProfileIdActivity.f14847r = secureContextHelper;
    }

    protected final void m22470b(Bundle bundle) {
        super.b(bundle);
        Class cls = PlatformCanonicalProfileIdActivity.class;
        m22466a((Object) this, (Context) this);
        Bundle extras = getIntent().getExtras();
        String string = extras.getString("com.facebook.katana.profile.id");
        CharSequence string2 = extras.getString("com.facebook.katana.profile.type");
        if (StringUtil.a(string) || StringUtil.a(string2) || !"app_scoped_user".equals(string2)) {
            this.f14847r.a(this.f14845p.a(this, m22469c(string)), this);
            finish();
            return;
        }
        m22468b(string);
    }

    private void m22468b(final String str) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("app_scoped_ids", new GetCanonicalProfileIdsMethod$Params(new ArrayList<String>() {
        }));
        Futures.a(BlueServiceOperationFactoryDetour.a(this.f14846q, "platform_get_canonical_profile_ids", bundle, ErrorPropagation.BY_EXCEPTION, null, 1551238857).a(), new C09632(this));
    }

    private static String m22469c(String str) {
        return StringFormatUtil.formatStrLocaleSafe(FBLinks.aX, str);
    }
}
