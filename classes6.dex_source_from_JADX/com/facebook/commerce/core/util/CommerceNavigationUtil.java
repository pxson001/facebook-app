package com.facebook.commerce.core.util;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.commerce.core.analytics.CommerceAnalytics.CommerceRefType;
import com.facebook.commerce.publishing.graphql.CommercePublishingQueryFragmentsInterfaces.AdminCommerceProductItem;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.common.util.StringUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import java.util.Currency;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: posts_content_module_row */
public class CommerceNavigationUtil {
    private static CommerceNavigationUtil f7556d;
    private static final Object f7557e = new Object();
    public final Context f7558a;
    public final SecureContextHelper f7559b;
    public final UriIntentMapper f7560c;

    private static CommerceNavigationUtil m10684b(InjectorLike injectorLike) {
        return new CommerceNavigationUtil((Context) injectorLike.getInstance(Context.class), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), (UriIntentMapper) Fb4aUriIntentMapper.a(injectorLike));
    }

    @Inject
    public CommerceNavigationUtil(Context context, SecureContextHelper secureContextHelper, UriIntentMapper uriIntentMapper) {
        this.f7558a = context;
        this.f7559b = secureContextHelper;
        this.f7560c = uriIntentMapper;
    }

    public final void m10690a(String str) {
        m10691a(str, CommerceRefType.UNKNOWN);
    }

    public static CommerceNavigationUtil m10681a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            CommerceNavigationUtil b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f7557e) {
                CommerceNavigationUtil commerceNavigationUtil;
                if (a2 != null) {
                    commerceNavigationUtil = (CommerceNavigationUtil) a2.a(f7557e);
                } else {
                    commerceNavigationUtil = f7556d;
                }
                if (commerceNavigationUtil == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10684b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f7557e, b3);
                        } else {
                            f7556d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = commerceNavigationUtil;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final void m10691a(String str, CommerceRefType commerceRefType) {
        Intent a = this.f7560c.a(this.f7558a, StringFormatUtil.formatStrLocaleSafe(FBLinks.eA, str));
        if (a != null) {
            a.putExtra("product_ref_type", commerceRefType);
            this.f7559b.a(a, this.f7558a);
        }
    }

    public final void m10693a(String str, String str2, @Nullable String str3) {
        Intent a = this.f7560c.a(this.f7558a, StringFormatUtil.formatStrLocaleSafe(FBLinks.eE, str));
        if (a != null) {
            if (str2 != null) {
                a.putExtra("merchant_page_id", str2);
            }
            if (str3 != null) {
                a.putExtra("arg_init_product_id", str3);
            }
            this.f7559b.a(a, this.f7558a);
        }
    }

    public final void m10692a(String str, @Nullable String str2) {
        m10694a(str, str2, false);
    }

    public final void m10694a(String str, @Nullable String str2, boolean z) {
        Intent a = this.f7560c.a(this.f7558a, StringFormatUtil.formatStrLocaleSafe(FBLinks.eD, str));
        if (a != null) {
            a.putExtra("extra_finish_on_launch_edit_shop", z);
            if (str2 != null) {
                a.putExtra("arg_init_product_id", str2);
            }
            this.f7559b.a(a, this.f7558a);
        }
    }

    public final void m10686a(long j) {
        this.f7559b.a(this.f7560c.a(this.f7558a, StringFormatUtil.formatStrLocaleSafe(FBLinks.eC, Long.valueOf(j))), this.f7558a);
    }

    public final void m10688a(long j, Currency currency, int i, ViewerContext viewerContext, int i2) {
        m10682a(j, currency, null, i, viewerContext, i2 == 0);
    }

    public final void m10689a(long j, Currency currency, @Nullable AdminCommerceProductItem adminCommerceProductItem, int i, ViewerContext viewerContext) {
        m10682a(j, currency, adminCommerceProductItem, i, viewerContext, false);
    }

    private void m10682a(long j, Currency currency, @Nullable AdminCommerceProductItem adminCommerceProductItem, int i, ViewerContext viewerContext, boolean z) {
        Intent b = adminCommerceProductItem != null ? m10683b(j, adminCommerceProductItem.cu_()) : m10685c(j);
        if (b != null) {
            b.putExtra("extra_currency", currency);
            FlatBufferModelHelper.a(b, "extra_admin_product_item", adminCommerceProductItem);
            b.putExtra("extra_featured_products_count", i);
            b.putExtra("extra_has_empty_catalog", z);
            b.putExtra("com.facebook.orca.auth.OVERRIDDEN_VIEWER_CONTEXT", viewerContext);
            this.f7559b.a(b, this.f7558a);
        }
    }

    public final void m10687a(long j, Optional<String> optional, boolean z, int i, Fragment fragment, ViewerContext viewerContext) {
        Intent a = optional.isPresent() ? m10679a(j, (String) optional.get()) : m10695b(j);
        if (a != null) {
            a.putExtra("extra_wait_for_mutation_finish", z);
            a.putExtra("com.facebook.orca.auth.OVERRIDDEN_VIEWER_CONTEXT", viewerContext);
            if (i <= 0 || fragment == null) {
                this.f7559b.a(a, this.f7558a);
            } else {
                this.f7559b.a(a, i, fragment);
            }
        }
    }

    @Nullable
    public final Intent m10695b(long j) {
        Intent c = m10685c(j);
        if (c != null) {
            c.putExtra("extra_requires_initial_fetch", true);
        }
        return c;
    }

    @Nullable
    private Intent m10679a(long j, String str) {
        Intent b = m10683b(j, str);
        if (b != null) {
            b.putExtra("extra_requires_initial_fetch", true);
            b.putExtra("extra_product_item_id_to_fetch", str);
        }
        return b;
    }

    @Nullable
    private Intent m10685c(long j) {
        return m10680a(this.f7560c.a(this.f7558a, FBLinks.ez), j);
    }

    @Nullable
    private Intent m10683b(long j, String str) {
        Preconditions.checkState(!StringUtil.a(str));
        return m10680a(this.f7560c.a(this.f7558a, StringFormatUtil.formatStrLocaleSafe(FBLinks.ey, str)), j);
    }

    @Nullable
    private static Intent m10680a(@Nullable Intent intent, long j) {
        if (intent != null) {
            intent.putExtra("com.facebook.katana.profile.id", j);
        }
        return intent;
    }
}
