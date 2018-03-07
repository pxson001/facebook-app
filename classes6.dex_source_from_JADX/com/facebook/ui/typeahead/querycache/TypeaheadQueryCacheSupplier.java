package com.facebook.ui.typeahead.querycache;

import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.ui.typeahead.FetchSource;
import javax.inject.Inject;

/* compiled from: copyMessageId */
public class TypeaheadQueryCacheSupplier<T> implements IHaveUserData {
    public final TypeaheadQueryCache<T> f18451a;
    public final TypeaheadQueryCache<T> f18452b;
    public final TypeaheadQueryCache<T> f18453c;
    public final TypeaheadQueryCache<T> f18454d;

    /* compiled from: copyMessageId */
    public /* synthetic */ class C13781 {
        public static final /* synthetic */ int[] f18450a = new int[FetchSource.values().length];

        static {
            try {
                f18450a[FetchSource.LOCAL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f18450a[FetchSource.REMOTE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f18450a[FetchSource.REMOTE_ENTITY.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f18450a[FetchSource.REMOTE_KEYWORD.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    @Inject
    public TypeaheadQueryCacheSupplier(TypeaheadQueryCache typeaheadQueryCache, TypeaheadQueryCache typeaheadQueryCache2, TypeaheadQueryCache typeaheadQueryCache3, TypeaheadQueryCache typeaheadQueryCache4) {
        this.f18451a = typeaheadQueryCache;
        this.f18452b = typeaheadQueryCache2;
        this.f18453c = typeaheadQueryCache3;
        this.f18454d = typeaheadQueryCache4;
    }

    public void clearUserData() {
        this.f18451a.m27063a();
        this.f18452b.m27063a();
        this.f18453c.m27063a();
        this.f18454d.m27063a();
    }
}
