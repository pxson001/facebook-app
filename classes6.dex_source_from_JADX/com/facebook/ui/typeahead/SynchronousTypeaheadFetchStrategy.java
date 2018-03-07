package com.facebook.ui.typeahead;

import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.typeahead.TypeaheadFetcher.OnSuggestionsFetchedListener;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableMap;
import java.util.HashMap;
import javax.inject.Inject;

/* compiled from: createNewFile failed */
public class SynchronousTypeaheadFetchStrategy<T> {
    private static final Class<?> f18426c = TypeaheadFetchHandler.class;
    @VisibleForTesting
    TypeaheadFetchHandler f18427a;
    @VisibleForTesting
    public TypeaheadFetchHandler<T> f18428b;
    public final DefaultAndroidThreadUtil f18429d;
    public boolean f18430e;
    private TypeaheadFetcher<T> f18431f;
    private TypeaheadFetcher<T> f18432g;
    public OnSuggestionsFetchedListener<T> f18433h;
    public OnFetchStateChangedListener f18434i;
    public TypeaheadRequest f18435j = TypeaheadRequest.f15457a;
    private FetchState f18436k = FetchState.IDLE;
    private SearchTypeaheadConfig f18437l;

    /* compiled from: createNewFile failed */
    public class TypeaheadFetchHandler<T> implements OnFetchStateChangedListener, OnSuggestionsFetchedListener<T> {
        public TypeaheadRequest f18418a = TypeaheadRequest.f15457a;
        public final /* synthetic */ SynchronousTypeaheadFetchStrategy f18419b;
        private final TypeaheadFetcher<T> f18420c;
        private final OnSuggestionsFetchedListener<T> f18421d;
        public FetchState f18422e = FetchState.IDLE;
        private final HashMap<TypeaheadRequest, Integer> f18423f = new HashMap();
        private final TypeaheadFetchHandlerType f18424g;
        private final int f18425h;

        public TypeaheadFetchHandler(SynchronousTypeaheadFetchStrategy synchronousTypeaheadFetchStrategy, TypeaheadFetcher<T> typeaheadFetcher, OnSuggestionsFetchedListener<T> onSuggestionsFetchedListener, TypeaheadFetchHandlerType typeaheadFetchHandlerType, int i) {
            this.f18419b = synchronousTypeaheadFetchStrategy;
            this.f18420c = typeaheadFetcher;
            this.f18421d = onSuggestionsFetchedListener;
            this.f18424g = typeaheadFetchHandlerType;
            this.f18425h = i;
        }

        public final void m27041a(TypeaheadResponse<T> typeaheadResponse) {
            TypeaheadRequest typeaheadRequest = typeaheadResponse.f18439a;
            this.f18418a = typeaheadRequest;
            int intValue = (this.f18423f.containsKey(typeaheadRequest) ? ((Integer) this.f18423f.get(typeaheadRequest)).intValue() : 0) - 1;
            if (intValue > 0) {
                this.f18423f.put(typeaheadRequest, Integer.valueOf(intValue));
            } else {
                this.f18423f.remove(typeaheadRequest);
            }
            String str = this.f18419b.f18435j.f15458b;
            str = typeaheadRequest.f15458b;
            Integer.valueOf(intValue);
            if (!this.f18419b.f18435j.equals(typeaheadRequest)) {
                m27038b(this, 0);
            }
            if (this.f18421d != null) {
                this.f18421d.a(typeaheadResponse);
            }
        }

        public final void m27040a(FetchState fetchState) {
            if (fetchState == FetchState.ERROR) {
                m27039d();
            }
            m27036b(fetchState);
        }

        private void m27036b(FetchState fetchState) {
            if (this.f18422e == fetchState) {
                return;
            }
            if (!this.f18422e.equals(FetchState.ERROR) || !fetchState.equals(FetchState.IDLE)) {
                this.f18422e = fetchState;
                SynchronousTypeaheadFetchStrategy.m27044b(this.f18419b);
            }
        }

        public static void m27037b(TypeaheadFetchHandler typeaheadFetchHandler) {
            if (typeaheadFetchHandler.f18420c.mo1395d()) {
                m27034a(typeaheadFetchHandler, 150);
            } else {
                m27038b(typeaheadFetchHandler, 0);
            }
        }

        public static void m27034a(TypeaheadFetchHandler typeaheadFetchHandler, final int i) {
            final TypeaheadRequest typeaheadRequest = typeaheadFetchHandler.f18419b.f18435j;
            typeaheadFetchHandler.f18419b.f18429d.b(new Runnable(typeaheadFetchHandler) {
                final /* synthetic */ TypeaheadFetchHandler f18417c;

                public void run() {
                    Object obj;
                    TypeaheadFetchHandler typeaheadFetchHandler = this.f18417c;
                    TypeaheadRequest typeaheadRequest = typeaheadRequest;
                    if (!typeaheadRequest.equals(typeaheadFetchHandler.f18419b.f18435j) || (typeaheadFetchHandler.f18419b.f18430e && typeaheadRequest.equals(typeaheadFetchHandler.f18419b.f18428b.f18418a))) {
                        obj = null;
                    } else {
                        obj = 1;
                    }
                    if (obj != null) {
                        TypeaheadFetchHandler.m27038b(this.f18417c, i);
                    }
                }
            }, (long) i);
        }

        public static void m27038b(TypeaheadFetchHandler typeaheadFetchHandler, int i) {
            TypeaheadRequest typeaheadRequest = typeaheadFetchHandler.f18419b.f18435j;
            if (!Strings.isNullOrEmpty(typeaheadRequest.f15458b) && !typeaheadFetchHandler.f18423f.containsKey(typeaheadRequest)) {
                typeaheadFetchHandler.f18423f.put(typeaheadRequest, Integer.valueOf(typeaheadFetchHandler.f18425h));
                TypeaheadRequest a = typeaheadRequest.mo1226c().m23081a(ImmutableBiMap.b("DURATION_MS", Integer.valueOf(i))).mo1223a();
                String str = typeaheadRequest.f15458b;
                typeaheadFetchHandler.f18420c.mo1394b(a);
                typeaheadFetchHandler.m27036b(FetchState.ACTIVE);
            }
        }

        public static void m27035a(TypeaheadFetchHandler typeaheadFetchHandler, ImmutableMap immutableMap) {
            typeaheadFetchHandler.f18420c.mo1393a(immutableMap);
            typeaheadFetchHandler.m27039d();
            typeaheadFetchHandler.m27036b(FetchState.IDLE);
        }

        private void m27039d() {
            this.f18423f.clear();
            this.f18418a = TypeaheadRequest.f15457a;
        }
    }

    /* compiled from: createNewFile failed */
    public enum TypeaheadFetchHandlerType {
        LOCAL,
        REMOTE
    }

    public static SynchronousTypeaheadFetchStrategy m27043b(InjectorLike injectorLike) {
        return new SynchronousTypeaheadFetchStrategy(DefaultAndroidThreadUtil.b(injectorLike), SearchTypeaheadConfig.b(injectorLike));
    }

    @Inject
    public SynchronousTypeaheadFetchStrategy(DefaultAndroidThreadUtil defaultAndroidThreadUtil, SearchTypeaheadConfig searchTypeaheadConfig) {
        this.f18429d = defaultAndroidThreadUtil;
        this.f18437l = searchTypeaheadConfig;
    }

    public final void m27050a(TypeaheadRequest typeaheadRequest) {
        this.f18435j = typeaheadRequest;
        m27045c();
    }

    public final void m27048a(TypeaheadFetcher<T> typeaheadFetcher) {
        m27049a(typeaheadFetcher, 1);
    }

    protected final void m27049a(TypeaheadFetcher<T> typeaheadFetcher, int i) {
        this.f18432g = typeaheadFetcher;
        this.f18428b = new TypeaheadFetchHandler(this, this.f18432g, this.f18433h, TypeaheadFetchHandlerType.REMOTE, i);
        this.f18432g.mo1392a(this.f18428b);
        this.f18432g.mo1391a(this.f18428b);
    }

    public final void m27052b(TypeaheadFetcher<T> typeaheadFetcher) {
        this.f18431f = typeaheadFetcher;
        this.f18427a = new TypeaheadFetchHandler(this, this.f18431f, this.f18433h, TypeaheadFetchHandlerType.LOCAL, 1);
        this.f18431f.mo1392a(this.f18427a);
        this.f18431f.mo1391a(this.f18427a);
    }

    public final void m27051a(ImmutableMap<String, String> immutableMap) {
        if (m27046d()) {
            TypeaheadFetchHandler.m27035a(this.f18427a, (ImmutableMap) immutableMap);
        }
        TypeaheadFetchHandler.m27035a(this.f18428b, (ImmutableMap) immutableMap);
    }

    public final void m27047a() {
        this.f18430e = true;
    }

    public static void m27044b(SynchronousTypeaheadFetchStrategy synchronousTypeaheadFetchStrategy) {
        FetchState fetchState;
        if (synchronousTypeaheadFetchStrategy.m27042a(FetchState.ACTIVE)) {
            fetchState = FetchState.ACTIVE;
        } else if (synchronousTypeaheadFetchStrategy.m27042a(FetchState.ERROR)) {
            fetchState = FetchState.ERROR;
        } else {
            fetchState = FetchState.IDLE;
        }
        if (fetchState != synchronousTypeaheadFetchStrategy.f18436k) {
            synchronousTypeaheadFetchStrategy.f18436k = fetchState;
            if (synchronousTypeaheadFetchStrategy.f18434i != null) {
                synchronousTypeaheadFetchStrategy.f18434i.a(synchronousTypeaheadFetchStrategy.f18436k);
            }
        }
    }

    private void m27045c() {
        if (m27046d() && this.f18435j.mo1225b()) {
            TypeaheadFetchHandler.m27037b(this.f18427a);
        }
        Preconditions.checkNotNull(this.f18432g, "Remote Typeahead fetcher hasn't been set yet!");
        if (this.f18435j.f15458b.codePointCount(0, this.f18435j.f15458b.length()) >= 3) {
            TypeaheadFetchHandler.m27037b(this.f18428b);
            return;
        }
        int a;
        TypeaheadFetchHandler typeaheadFetchHandler = this.f18428b;
        SearchTypeaheadConfig searchTypeaheadConfig = this.f18437l;
        if (searchTypeaheadConfig.f.a(SearchTypeaheadConfig.d, false)) {
            a = (int) searchTypeaheadConfig.e.a(SearchTypeaheadConfig.c, 300);
        } else {
            a = 300;
        }
        TypeaheadFetchHandler.m27034a(typeaheadFetchHandler, a);
    }

    private boolean m27042a(FetchState fetchState) {
        return this.f18428b.f18422e == fetchState || (m27046d() && this.f18427a.f18422e == fetchState);
    }

    private boolean m27046d() {
        return (this.f18431f == null || this.f18427a == null) ? false : true;
    }
}
