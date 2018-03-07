package com.facebook.quickpromotion.action;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.common.util.FacebookUriUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import javax.inject.Inject;

@ContextScoped
/* compiled from: related_articles_style */
public class DefaultQuickPromotionActionHandler {
    private static DefaultQuickPromotionActionHandler f4601e;
    private static final Object f4602f = new Object();
    private final Context f4603a;
    private final SecureContextHelper f4604b;
    private final AbstractFbErrorReporter f4605c;
    private final UriIntentMapper f4606d;

    private static DefaultQuickPromotionActionHandler m4469b(InjectorLike injectorLike) {
        return new DefaultQuickPromotionActionHandler((Context) injectorLike.getInstance(Context.class), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (UriIntentMapper) Fb4aUriIntentMapper.a(injectorLike));
    }

    @Inject
    DefaultQuickPromotionActionHandler(Context context, SecureContextHelper secureContextHelper, AbstractFbErrorReporter abstractFbErrorReporter, UriIntentMapper uriIntentMapper) {
        this.f4603a = context;
        this.f4604b = secureContextHelper;
        this.f4605c = abstractFbErrorReporter;
        this.f4606d = uriIntentMapper;
    }

    public final void m4470a(Uri uri) {
        Throwable e;
        Intent a = this.f4606d.a(this.f4603a, uri.toString());
        if (a == null) {
            a = new Intent("android.intent.action.VIEW", uri);
            a.addFlags(268435456);
        }
        try {
            if (!FacebookUriUtil.g(uri) || a.getBooleanExtra("force_external_browser", false)) {
                this.f4604b.b(a, this.f4603a);
            } else if (FacebookUriUtil.l(uri)) {
                this.f4604b.c(a, this.f4603a);
            } else {
                this.f4604b.a(a, this.f4603a);
            }
        } catch (ActivityNotFoundException e2) {
            e = e2;
            this.f4605c.a("QuickPromotion_action", e);
        } catch (SecurityException e3) {
            e = e3;
            this.f4605c.a("QuickPromotion_action", e);
        }
    }

    public static DefaultQuickPromotionActionHandler m4468a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            DefaultQuickPromotionActionHandler b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f4602f) {
                DefaultQuickPromotionActionHandler defaultQuickPromotionActionHandler;
                if (a2 != null) {
                    defaultQuickPromotionActionHandler = (DefaultQuickPromotionActionHandler) a2.a(f4602f);
                } else {
                    defaultQuickPromotionActionHandler = f4601e;
                }
                if (defaultQuickPromotionActionHandler == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m4469b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f4602f, b3);
                        } else {
                            f4601e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = defaultQuickPromotionActionHandler;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
