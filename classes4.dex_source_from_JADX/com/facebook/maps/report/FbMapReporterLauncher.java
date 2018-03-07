package com.facebook.maps.report;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import com.facebook.android.maps.MapReporterLauncher;
import com.facebook.android.maps.MapReporterLauncher.ActivityLauncher;
import com.facebook.android.maps.MapReporterLauncher.DialogBuilder;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.iorg.common.upsell.ui.FbZeroDialogController;
import com.facebook.iorg.common.zero.ui.ZeroDialogController;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.facebook.zero.sdk.common.ZeroFeatureKey;
import javax.inject.Inject;

@ContextScoped
/* compiled from: edit_privacy_cancel */
public class FbMapReporterLauncher extends MapReporterLauncher {
    private static FbMapReporterLauncher f13406e;
    private static final Object f13407f = new Object();
    private final ZeroDialogController f13408a;
    private final String f13409b;
    public boolean f13410c;
    public FragmentManager f13411d;

    /* compiled from: edit_privacy_cancel */
    class C06361 implements DialogBuilder {
        final /* synthetic */ Context f13419a;
        private final Builder f13420b = new FbAlertDialogBuilder(this.f13419a);

        C06361(Context context) {
            this.f13419a = context;
        }

        public final DialogBuilder mo959a(CharSequence charSequence) {
            this.f13420b.m14346b(charSequence);
            return this;
        }

        public final DialogBuilder mo960a(CharSequence charSequence, OnClickListener onClickListener) {
            this.f13420b.mo963a(charSequence, onClickListener);
            return this;
        }

        public final DialogBuilder mo961b(CharSequence charSequence, OnClickListener onClickListener) {
            this.f13420b.mo966b(charSequence, onClickListener);
            return this;
        }

        public final Dialog mo958a() {
            return this.f13420b.mo964a();
        }
    }

    /* compiled from: edit_privacy_cancel */
    class C06372 implements ActivityLauncher {
        final /* synthetic */ SecureContextHelper f13469a;
        final /* synthetic */ Context f13470b;

        C06372(SecureContextHelper secureContextHelper, Context context) {
            this.f13469a = secureContextHelper;
            this.f13470b = context;
        }

        public final void mo969a(Intent intent) {
            this.f13469a.b(intent, this.f13470b);
        }
    }

    private static FbMapReporterLauncher m14308b(InjectorLike injectorLike) {
        return new FbMapReporterLauncher((ZeroDialogController) FbZeroDialogController.b(injectorLike), (Context) injectorLike.getInstance(Context.class), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike));
    }

    @Inject
    public FbMapReporterLauncher(ZeroDialogController zeroDialogController, Context context, SecureContextHelper secureContextHelper) {
        super(context, context.getResources().getText(2131230963), context.getResources().getText(2131230964), new C06361(context), new C06372(secureContextHelper, context));
        this.f13409b = context.getResources().getString(2131232929);
        this.f13408a = zeroDialogController;
    }

    public static FbMapReporterLauncher m14306a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FbMapReporterLauncher b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f13407f) {
                FbMapReporterLauncher fbMapReporterLauncher;
                if (a2 != null) {
                    fbMapReporterLauncher = (FbMapReporterLauncher) a2.a(f13407f);
                } else {
                    fbMapReporterLauncher = f13406e;
                }
                if (fbMapReporterLauncher == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14308b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f13407f, b3);
                        } else {
                            f13406e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = fbMapReporterLauncher;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    protected final void mo957a(Uri uri) {
        if (this.f13410c) {
            this.f13408a.a(ZeroFeatureKey.EXTERNAL_URLS_INTERSTITIAL, this.f13409b, new 3(this, uri));
            this.f13408a.a(ZeroFeatureKey.EXTERNAL_URLS_INTERSTITIAL, this.f13411d);
            return;
        }
        super.mo957a(uri);
    }
}
