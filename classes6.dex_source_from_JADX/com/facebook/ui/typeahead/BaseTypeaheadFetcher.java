package com.facebook.ui.typeahead;

import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.typeahead.TypeaheadFetcher.OnSuggestionsFetchedListener;
import com.facebook.ui.typeahead.querycache.TypeaheadQueryCache;
import com.facebook.ui.typeahead.querycache.TypeaheadQueryCacheSupplier;
import com.facebook.ui.typeahead.querycache.TypeaheadQueryCacheSupplier.C13781;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.CancellationException;
import javax.annotation.Nullable;

/* compiled from: creative_editing_data */
public abstract class BaseTypeaheadFetcher<T> implements TypeaheadFetcher<T> {
    private static final Class f18403a = BaseTypeaheadFetcher.class;
    private final TasksManager<String> f18404b;
    public final TypeaheadQueryCache f18405c;
    public OnSuggestionsFetchedListener<T> f18406d;
    private OnFetchStateChangedListener f18407e;
    public FetchState f18408f = FetchState.IDLE;

    public abstract ListenableFuture<SearchResponse<T>> m27011a(TypeaheadRequest typeaheadRequest);

    public abstract String m27012a();

    public abstract void m27016a(@Nullable TypeaheadRequest typeaheadRequest, Throwable th);

    public abstract FetchSource m27020b();

    public BaseTypeaheadFetcher(TasksManager tasksManager, TypeaheadQueryCacheSupplier typeaheadQueryCacheSupplier) {
        TypeaheadQueryCache typeaheadQueryCache;
        this.f18404b = tasksManager;
        switch (C13781.f18450a[m27020b().ordinal()]) {
            case 1:
                typeaheadQueryCache = typeaheadQueryCacheSupplier.f18451a;
                break;
            case 2:
                typeaheadQueryCache = typeaheadQueryCacheSupplier.f18452b;
                break;
            case 3:
                typeaheadQueryCache = typeaheadQueryCacheSupplier.f18453c;
                break;
            case 4:
                typeaheadQueryCache = typeaheadQueryCacheSupplier.f18454d;
                break;
            default:
                typeaheadQueryCache = null;
                break;
        }
        this.f18405c = typeaheadQueryCache;
    }

    protected void m27018a(TypeaheadResponse<T> typeaheadResponse) {
        String str = typeaheadResponse.f18439a.f15458b;
        if (!(this.f18405c == null || this.f18405c.m27065b(typeaheadResponse.f18439a.f15459c, str))) {
            m27020b();
            ImmutableList immutableList = typeaheadResponse.f18440b.f18413b;
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                immutableList.get(i).toString();
            }
            this.f18405c.m27064a(typeaheadResponse.f18439a.f15459c, str, typeaheadResponse);
        }
        if (this.f18406d != null) {
            this.f18406d.a(typeaheadResponse);
        }
        m27010f();
    }

    public void m27017a(@Nullable TypeaheadRequest typeaheadRequest, CancellationException cancellationException) {
    }

    public final void mo1394b(final TypeaheadRequest typeaheadRequest) {
        this.f18404b.b(m27012a(), m27011a(typeaheadRequest), new AbstractDisposableFutureCallback<SearchResponse<T>>(this) {
            final /* synthetic */ BaseTypeaheadFetcher f18402b;

            protected final void m27001a(Object obj) {
                SearchResponse searchResponse = (SearchResponse) obj;
                FetchSource b = this.f18402b.m27020b();
                if (b.isRemote()) {
                    b = FetchSource.REMOTE;
                }
                this.f18402b.m27018a(new TypeaheadResponse(typeaheadRequest, searchResponse, b, MatchType.EXACT));
            }

            protected final void m27003a(CancellationException cancellationException) {
                this.f18402b.m27017a(typeaheadRequest, cancellationException);
                this.f18402b.m27010f();
            }

            protected final void m27002a(Throwable th) {
                this.f18402b.m27016a(typeaheadRequest, th);
                this.f18402b.m27013a(FetchState.ERROR);
            }
        });
        m27013a(FetchState.ACTIVE);
    }

    public final void mo1392a(OnSuggestionsFetchedListener<T> onSuggestionsFetchedListener) {
        this.f18406d = onSuggestionsFetchedListener;
    }

    @Nullable
    public final TypeaheadQueryCache<T> m27022c() {
        return this.f18405c;
    }

    public void mo1393a(ImmutableMap<String, String> immutableMap) {
        this.f18404b.c();
        m27013a(FetchState.IDLE);
    }

    public final boolean mo1395d() {
        return this.f18404b.a(m27012a());
    }

    public final void mo1391a(OnFetchStateChangedListener onFetchStateChangedListener) {
        this.f18407e = onFetchStateChangedListener;
    }

    private void m27010f() {
        if (!mo1395d()) {
            m27013a(FetchState.IDLE);
        }
    }

    protected final void m27013a(FetchState fetchState) {
        if (this.f18408f != fetchState) {
            this.f18408f = fetchState;
            if (this.f18407e != null) {
                this.f18407e.a(fetchState);
            }
        }
    }
}
