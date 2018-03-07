package com.facebook.adinterfaces.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.adinterfaces.AdInterfacesCreativeHelper.Dimension;
import com.facebook.adinterfaces.abtest.ExperimentsForAdInterfacesModule;
import com.facebook.adinterfaces.error.AdInterfacesErrorReporter;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: UserPhoneNumberAddCoreMutation */
public class AdInterfacesReactUtil {
    private final Product f22886a;
    private final AdInterfacesErrorReporter f22887b;
    public final UriIntentMapper f22888c;
    private final QeAccessor f22889d;

    public static AdInterfacesReactUtil m24849b(InjectorLike injectorLike) {
        return new AdInterfacesReactUtil(AdInterfacesErrorReporter.m22724a(injectorLike), (UriIntentMapper) Fb4aUriIntentMapper.a(injectorLike), ProductMethodAutoProvider.b(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public AdInterfacesReactUtil(AdInterfacesErrorReporter adInterfacesErrorReporter, UriIntentMapper uriIntentMapper, Product product, QeAccessor qeAccessor) {
        this.f22887b = adInterfacesErrorReporter;
        this.f22888c = uriIntentMapper;
        this.f22886a = product;
        this.f22889d = qeAccessor;
    }

    @Nullable
    public final Intent m24850a(Context context, String str, Dimension dimension, Dimension dimension2) {
        String a = StringFormatUtil.a(FBLinks.r, new Object[]{str});
        Intent a2 = this.f22888c.a(context, a);
        if (a2 == null) {
            this.f22887b.m22726a(AdInterfacesReactUtil.class, "Got null intent for uri: " + a);
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("page", str);
        bundle.putInt("cropWidth", dimension.f21488b);
        bundle.putInt("cropHeight", dimension.f21487a);
        bundle.putInt("minCropWidth", dimension2.f21488b);
        bundle.putInt("minCropHeight", dimension2.f21487a);
        bundle.putString("callbackModule", "AdInterfacesModule");
        bundle.putString("callbackMethod", "onImageSelected");
        a2.putExtra("init_props", bundle);
        return a2;
    }

    public final boolean m24851a() {
        return this.f22886a == Product.FB4A;
    }

    public final boolean m24852b() {
        return this.f22886a == Product.FB4A && this.f22889d.a(ExperimentsForAdInterfacesModule.f21605b, false);
    }
}
