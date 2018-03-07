package com.facebook.messaging.business.common.calltoaction;

import android.content.Context;
import android.content.UriMatcher;
import android.net.Uri;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.inject.MultiBinderSet;
import com.facebook.messaging.linkhandling.LinkHandlingHelper;
import com.facebook.messaging.model.threadkey.ThreadKey;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: newReceiverStatus */
public class BusinessUriMapper {
    private final Context f8704a;
    private final Lazy<LinkHandlingHelper> f8705b;
    public final Set<BusinessUriHandler> f8706c;
    private final FbUriIntentHandler f8707d;
    public final UriMatcher f8708e = new UriMatcher(-1);
    public final Map<Integer, BusinessUriHandler> f8709f = new HashMap();

    public static BusinessUriMapper m8917b(InjectorLike injectorLike) {
        return new BusinessUriMapper((Context) injectorLike.getInstance(Context.class), new MultiBinderSet(injectorLike.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$BusinessUriHandler(injectorLike)), IdBasedSingletonScopeProvider.b(injectorLike, 7898), FbUriIntentHandler.a(injectorLike));
    }

    @Inject
    public BusinessUriMapper(Context context, Set<BusinessUriHandler> set, Lazy<LinkHandlingHelper> lazy, FbUriIntentHandler fbUriIntentHandler) {
        this.f8704a = context;
        this.f8706c = set;
        this.f8705b = lazy;
        this.f8707d = fbUriIntentHandler;
        int i = 1;
        for (BusinessUriHandler businessUriHandler : this.f8706c) {
            this.f8708e.addURI(businessUriHandler.m8913a(), businessUriHandler.mo330b(), i);
            this.f8709f.put(Integer.valueOf(i), businessUriHandler);
            i++;
        }
    }

    public final void m8918a(@Nullable Uri uri, @Nullable Uri uri2, @Nullable ThreadKey threadKey) {
        if ((uri != null || uri2 != null) && !m8916a(uri, threadKey) && !m8916a(uri2, threadKey)) {
            ((LinkHandlingHelper) this.f8705b.get()).a(this.f8704a, uri2);
        }
    }

    private boolean m8916a(@Nullable Uri uri, @Nullable ThreadKey threadKey) {
        if (uri == null) {
            return false;
        }
        int match = this.f8708e.match(uri);
        if (match == -1 || !((BusinessUriHandler) this.f8709f.get(Integer.valueOf(match))).mo329a(this.f8704a, uri, threadKey)) {
            return this.f8707d.a(this.f8704a, uri.toString());
        }
        return true;
    }
}
