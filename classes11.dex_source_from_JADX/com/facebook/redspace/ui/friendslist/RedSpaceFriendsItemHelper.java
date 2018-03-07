package com.facebook.redspace.ui.friendslist;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.graphql.enums.GraphQLRedSpaceUserAttributeType;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.redspace.abtest.RedSpaceStrings;
import com.facebook.redspace.data.RedSpaceFeedProfileUnreadStoriesHelper;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFeedProfileFragmentModel;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFeedProfileFragmentModel.RedspaceModel.AttributesModel;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.google.common.collect.ImmutableList;

@ContextScoped
/* compiled from: PRIVACY_CHECKUP_WRITE_REQUEST_FLUSH */
public class RedSpaceFriendsItemHelper {
    private static RedSpaceFriendsItemHelper f12439d;
    private static final Object f12440e = new Object();
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<RedSpaceStrings> f12441a = UltralightRuntime.b;
    @Inject
    public RedSpaceFeedProfileUnreadStoriesHelper f12442b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<Resources> f12443c = UltralightRuntime.b;

    private static RedSpaceFriendsItemHelper m12846b(InjectorLike injectorLike) {
        RedSpaceFriendsItemHelper redSpaceFriendsItemHelper = new RedSpaceFriendsItemHelper();
        com.facebook.inject.Lazy a = IdBasedLazy.a(injectorLike, 3264);
        RedSpaceFeedProfileUnreadStoriesHelper a2 = RedSpaceFeedProfileUnreadStoriesHelper.m12202a(injectorLike);
        com.facebook.inject.Lazy b = IdBasedSingletonScopeProvider.b(injectorLike, 30);
        redSpaceFriendsItemHelper.f12441a = a;
        redSpaceFriendsItemHelper.f12442b = a2;
        redSpaceFriendsItemHelper.f12443c = b;
        return redSpaceFriendsItemHelper;
    }

    public static CharSequence m12845a(String str, int i) {
        if (i == 0) {
            return str;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new StyleSpan(1), 0, str.length(), 33);
        return spannableStringBuilder;
    }

    public final String m12847a(RedSpaceFeedProfileFragmentModel redSpaceFeedProfileFragmentModel) {
        if (redSpaceFeedProfileFragmentModel.m() == null || redSpaceFeedProfileFragmentModel.m().j() == null) {
            return null;
        }
        ImmutableList j = redSpaceFeedProfileFragmentModel.m().j();
        int size = j.size();
        for (int i = 0; i < size; i++) {
            if (((AttributesModel) j.get(i)).a() == GraphQLRedSpaceUserAttributeType.SUGGESTED) {
                return ((RedSpaceStrings) this.f12441a.get()).b();
            }
        }
        return null;
    }

    public final int m12848b(RedSpaceFeedProfileFragmentModel redSpaceFeedProfileFragmentModel) {
        return this.f12442b.m12204a(redSpaceFeedProfileFragmentModel);
    }

    public static RedSpaceFriendsItemHelper m12844a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            RedSpaceFriendsItemHelper b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12440e) {
                RedSpaceFriendsItemHelper redSpaceFriendsItemHelper;
                if (a2 != null) {
                    redSpaceFriendsItemHelper = (RedSpaceFriendsItemHelper) a2.a(f12440e);
                } else {
                    redSpaceFriendsItemHelper = f12439d;
                }
                if (redSpaceFriendsItemHelper == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m12846b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12440e, b3);
                        } else {
                            f12439d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = redSpaceFriendsItemHelper;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final CharSequence m12849c(RedSpaceFeedProfileFragmentModel redSpaceFeedProfileFragmentModel) {
        int b = m12848b(redSpaceFeedProfileFragmentModel);
        if (b == 0) {
            return null;
        }
        boolean z;
        if (redSpaceFeedProfileFragmentModel.m() == null || redSpaceFeedProfileFragmentModel.m().m() == null || redSpaceFeedProfileFragmentModel.m().m().a() == null) {
            z = false;
        } else {
            z = redSpaceFeedProfileFragmentModel.m().m().a().j();
        }
        if (!z) {
            return String.valueOf(b);
        }
        return ((Resources) this.f12443c.get()).getString(2131235780, new Object[]{Integer.valueOf(b)});
    }
}
