package com.facebook.securitycheckup.utils;

import android.content.Context;
import android.net.Uri;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import javax.inject.Inject;

/* compiled from: homfiftchyfcfrejktumbtkmzoodddvicughugutrujamyrjssyrewniccceohnhjvcbvvbhuuunutneyfdfhfcpowtomkindavmikminniktortopockarktinhkaappustjvf */
public class HelpPageUtil {
    private Lazy<FbUriIntentHandler> f9936a;
    private Context f9937b;

    public static HelpPageUtil m10066b(InjectorLike injectorLike) {
        return new HelpPageUtil((Context) injectorLike.getInstance(Context.class), IdBasedSingletonScopeProvider.b(injectorLike, 616));
    }

    @Inject
    public HelpPageUtil(Context context, Lazy<FbUriIntentHandler> lazy) {
        this.f9936a = lazy;
        this.f9937b = context;
    }

    public final void m10067a(String str) {
        ((FbUriIntentHandler) this.f9936a.get()).a(this.f9937b, StringFormatUtil.formatStrLocaleSafe(FBLinks.cs, Uri.encode(str)));
    }
}
