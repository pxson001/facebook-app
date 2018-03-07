package com.facebook.instantarticles.fetcher;

import android.content.Context;
import android.util.DisplayMetrics;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.graphql.calls.MediaTypeInputMimeType;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.querybuilder.common.ScaleInputPixelRatio;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectableComponentWithoutContext;
import com.facebook.inject.Lazy;
import com.facebook.qe.api.QeAccessor;
import com.facebook.richdocument.fetcher.FetchDefaults;
import com.facebook.richdocument.fetcher.RichDocumentFetchParams;
import javax.inject.Inject;

/* compiled from: used */
public abstract class BaseInstantArticlesFetchParams<T> implements InjectableComponentWithoutContext, RichDocumentFetchParams<GraphQLRequest<T>> {
    @Inject
    public Lazy<QeAccessor> f798a;
    public String f799b;
    public int f800c = 100;
    public int f801d = 1000;
    public int f802e = 100;
    public int f803f = 100;
    public MediaTypeInputMimeType f804g = FetchDefaults.f5220a;
    public ScaleInputPixelRatio f805h = FetchDefaults.f5221b;
    public long f806i = 604800000;
    public GraphQLCachePolicy f807j = FetchDefaults.f5222c;
    public int f808k = 3;
    public int f809l;
    public int f810m;
    public int f811n;
    public boolean f812o = false;
    public RequestPriority f813p = FetchDefaults.f5223d;
    private String f814q;

    public static void m825a(Object obj, Context context) {
        ((BaseInstantArticlesFetchParams) obj).f798a = IdBasedSingletonScopeProvider.b(FbInjector.get(context), 3219);
    }

    public BaseInstantArticlesFetchParams(Context context, String str) {
        Class cls = BaseInstantArticlesFetchParams.class;
        m825a(this, context);
        this.f799b = str;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.f809l = displayMetrics.widthPixels / 2;
        this.f810m = (int) (((float) this.f809l) / 1.91f);
        this.f811n = displayMetrics.heightPixels;
        this.f814q = SafeUUIDGenerator.a().toString();
    }
}
