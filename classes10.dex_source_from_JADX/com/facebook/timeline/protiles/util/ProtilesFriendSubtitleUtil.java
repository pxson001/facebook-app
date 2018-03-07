package com.facebook.timeline.protiles.util;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.DrawableRes;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.locale.Locales;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.timeline.protiles.protocol.FetchProtilesGraphQLModels.ProtileItemFieldsModel;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: fb4a_reg_name_title */
public class ProtilesFriendSubtitleUtil {
    private static ProtilesFriendSubtitleUtil f12366c;
    private static final Object f12367d = new Object();
    public final Resources f12368a;
    private final Locales f12369b;

    private static ProtilesFriendSubtitleUtil m12405b(InjectorLike injectorLike) {
        return new ProtilesFriendSubtitleUtil(ResourcesMethodAutoProvider.a(injectorLike), Locales.a(injectorLike));
    }

    @Inject
    public ProtilesFriendSubtitleUtil(Resources resources, Locales locales) {
        this.f12368a = resources;
        this.f12369b = locales;
    }

    @Nullable
    public final String m12408a(ProtileItemFieldsModel protileItemFieldsModel) {
        if (!m12407d(protileItemFieldsModel)) {
            return protileItemFieldsModel.m12181c() != null ? protileItemFieldsModel.m12181c().m12171a() : null;
        } else {
            return this.f12368a.getQuantityString(2131689628, protileItemFieldsModel.m12180b().m12158o(), new Object[]{Integer.valueOf(protileItemFieldsModel.m12180b().m12158o())}).toLowerCase(this.f12369b.a());
        }
    }

    @DrawableRes
    public static int m12406c(ProtileItemFieldsModel protileItemFieldsModel) {
        if (m12407d(protileItemFieldsModel)) {
            return 2130842808;
        }
        return 0;
    }

    public static ProtilesFriendSubtitleUtil m12404a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ProtilesFriendSubtitleUtil b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12367d) {
                ProtilesFriendSubtitleUtil protilesFriendSubtitleUtil;
                if (a2 != null) {
                    protilesFriendSubtitleUtil = (ProtilesFriendSubtitleUtil) a2.a(f12367d);
                } else {
                    protilesFriendSubtitleUtil = f12366c;
                }
                if (protilesFriendSubtitleUtil == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m12405b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12367d, b3);
                        } else {
                            f12366c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = protilesFriendSubtitleUtil;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private static boolean m12407d(ProtileItemFieldsModel protileItemFieldsModel) {
        return protileItemFieldsModel.m12180b() != null && protileItemFieldsModel.m12180b().m12158o() > 0;
    }
}
