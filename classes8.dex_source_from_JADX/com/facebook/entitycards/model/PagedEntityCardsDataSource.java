package com.facebook.entitycards.model;

import android.os.Bundle;
import android.view.LayoutInflater;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.entitycards.EntityCardsAdapter;
import com.facebook.entitycards.EntityCardsAdapterProvider;
import com.facebook.entitycards.analytics.EntityCardConfigurationEventListener.CardConfigDataType;
import com.facebook.entitycards.analytics.EntityCardsAnalyticsLogger;
import com.facebook.entitycards.analytics.EntityCardsPerfLogger;
import com.facebook.entitycards.analytics.EntityCardsScrollTTITracker;
import com.facebook.entitycards.collect.ImmutableOffsetArray;
import com.facebook.entitycards.collect.OffsetArray;
import com.facebook.entitycards.collect.OffsetArrayHelper;
import com.facebook.entitycards.collect.ParcelableOffsetArray;
import com.facebook.entitycards.controller.EntityCardsController;
import com.facebook.entitycards.intent.EntityCardsFragment.C11761;
import com.facebook.entitycards.loader.DefaultEntityCardsPageLoader;
import com.facebook.entitycards.loader.DefaultEntityCardsPageLoader.C11861;
import com.facebook.entitycards.model.EntityCardsDataSource.State;
import com.facebook.entitycards.model.event.EntityModelLoadErrorEvent;
import com.facebook.entitycards.service.EntityCardsEntityLoader;
import com.facebook.entitycards.service.EntityCardsPageLoader;
import com.facebook.inject.Assisted;
import com.facebook.ui.recyclableviewpool.RecyclableViewPoolManager;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Absent;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.HashMap;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: horizontal_scroll */
public final class PagedEntityCardsDataSource extends AbstractEntityCardsDataSource {
    final ScrollLoadTrigger f11048a = new ScrollLoadTrigger(EntityCardsScrollDirection.LEFT);
    final ScrollLoadTrigger f11049b = new ScrollLoadTrigger(EntityCardsScrollDirection.RIGHT);
    final ScrollLoadError f11050c = new ScrollLoadError("left_edge");
    final ScrollLoadError f11051d = new ScrollLoadError("right_edge");
    public final OffsetArray<String> f11052e;
    public final HashMap<String, EntityCardsDataKey> f11053f = Maps.c();
    public final HashMap<String, Object> f11054g = Maps.c();
    public ListenableFuture<ImmutableMap<String, ?>> f11055h = null;
    public boolean f11056i = false;
    public ListenableFuture<EntityCardsPage> f11057j = null;
    public ListenableFuture<EntityCardsPage> f11058k = null;
    public Optional<EntityCardsDataKey> f11059l = Absent.withType();
    public Optional<EntityCardsDataKey> f11060m = Absent.withType();
    public boolean f11061n = false;
    public boolean f11062o = false;
    private final DefaultEntityCardsPageLoader f11063p;
    public final EntityCardsPerfLogger f11064q;
    public final EntityCardsAnalyticsLogger f11065r;
    private final Optional<EntityCardsPage> f11066s;
    private final Optional<ImmutableOffsetArray<String>> f11067t;
    private final String f11068u;
    private final int f11069v;
    private final int f11070w;
    private final Executor f11071x;
    public final AbstractFbErrorReporter f11072y;
    private final EntityCardsAdapterProvider f11073z;

    /* compiled from: horizontal_scroll */
    class C11902 implements Function<ImmutableMap<String, ?>, Void> {
        final /* synthetic */ PagedEntityCardsDataSource f11044a;

        C11902(PagedEntityCardsDataSource pagedEntityCardsDataSource) {
            this.f11044a = pagedEntityCardsDataSource;
        }

        public Object apply(Object obj) {
            return null;
        }
    }

    /* compiled from: horizontal_scroll */
    class C11924 implements Function<ImmutableMap<String, ?>, Void> {
        final /* synthetic */ PagedEntityCardsDataSource f11047a;

        C11924(PagedEntityCardsDataSource pagedEntityCardsDataSource) {
            this.f11047a = pagedEntityCardsDataSource;
        }

        public Object apply(Object obj) {
            PagedEntityCardsDataSource.m12999b(this.f11047a, (ImmutableMap) obj);
            return null;
        }
    }

    private boolean m13006n() {
        return this.f11033e != State.UNINITIALIZED;
    }

    public final ListenableFuture<Void> mo782e() {
        boolean z;
        if (this.f11033e == State.UNINITIALIZED) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "Only initialize once.");
        if (this.f11066s.isPresent()) {
            this.f11065r.mo769a(CardConfigDataType.PREVIEW);
            m12993a(((EntityCardsPage) this.f11066s.get()).f11035a, ((EntityCardsPage) this.f11066s.get()).f11036b);
            this.f11033e = State.PRELIMINARY_INITIALIZED;
            m12972a(m13005m(), State.UNINITIALIZED, State.PRELIMINARY_INITIALIZED);
            m12973a(m12990a(((EntityCardsPage) this.f11066s.get()).f11035a));
        }
        return m13004l();
    }

    @Inject
    public PagedEntityCardsDataSource(@Assisted EntityCardsPageLoader entityCardsPageLoader, @Assisted EntityCardsEntityLoader entityCardsEntityLoader, @Assisted EntityCardsAnalyticsLogger entityCardsAnalyticsLogger, @Assisted EntityCardsPerfLogger entityCardsPerfLogger, @Assisted String str, @Assisted ImmutableOffsetArray<String> immutableOffsetArray, @Nullable @Assisted ImmutableMap<String, ?> immutableMap, @Assisted String str2, @Assisted Integer num, @Assisted Integer num2, Executor executor, FbErrorReporter fbErrorReporter, EntityCardsAdapterProvider entityCardsAdapterProvider) {
        super(str, entityCardsEntityLoader);
        this.f11073z = entityCardsAdapterProvider;
        this.f11064q = entityCardsPerfLogger;
        this.f11065r = entityCardsAnalyticsLogger;
        this.f11068u = str2;
        this.f11069v = num.intValue();
        this.f11070w = num2.intValue();
        this.f11063p = entityCardsPageLoader;
        this.f11071x = executor;
        this.f11072y = fbErrorReporter;
        Preconditions.checkArgument(immutableOffsetArray.m12837a((Object) str2), "currentEntityId must be in initialEntityIds");
        if (immutableMap == null || immutableMap.isEmpty()) {
            OffsetArrayHelper.m12846a(immutableOffsetArray);
            this.f11066s = Absent.withType();
            this.f11067t = Optional.of(immutableOffsetArray);
            this.f11052e = new OffsetArray(immutableOffsetArray.m12835a(0));
            return;
        }
        EntityCardsPage entityCardsPage = new EntityCardsPage(immutableOffsetArray, immutableMap);
        this.f11066s = Optional.of(entityCardsPage);
        this.f11067t = Absent.withType();
        this.f11052e = new OffsetArray(entityCardsPage.m12981b().m12835a(0));
    }

    public static void m12994a(PagedEntityCardsDataSource pagedEntityCardsDataSource, ImmutableOffsetArray immutableOffsetArray, ImmutableMap immutableMap, EntityCardsScrollDirection entityCardsScrollDirection) {
        if (entityCardsScrollDirection == EntityCardsScrollDirection.LEFT) {
            pagedEntityCardsDataSource.m12998b(immutableOffsetArray, immutableMap);
        } else {
            pagedEntityCardsDataSource.m13001c(immutableOffsetArray, immutableMap);
        }
        pagedEntityCardsDataSource.m12972a(pagedEntityCardsDataSource.m13005m(), pagedEntityCardsDataSource.f11033e, pagedEntityCardsDataSource.f11033e);
        pagedEntityCardsDataSource.m12973a(pagedEntityCardsDataSource.m12990a((OffsetArray) immutableOffsetArray));
        m13003d(pagedEntityCardsDataSource, entityCardsScrollDirection);
        pagedEntityCardsDataSource.f11064q.m12828d(entityCardsScrollDirection);
        pagedEntityCardsDataSource.f11065r.m12798a(true, immutableOffsetArray.m12838b());
    }

    private boolean m13000b(EntityCardsScrollDirection entityCardsScrollDirection) {
        DefaultEntityCardsPageLoader defaultEntityCardsPageLoader = this.f11063p;
        boolean z = true;
        if (!(defaultEntityCardsPageLoader.f11026f.contains(entityCardsScrollDirection) || defaultEntityCardsPageLoader.f11027g.containsKey(entityCardsScrollDirection))) {
            z = defaultEntityCardsPageLoader.f11021a.mo774a(entityCardsScrollDirection);
        }
        return z;
    }

    public final void mo779a(final EntityCardsScrollDirection entityCardsScrollDirection) {
        Preconditions.checkState(m13006n());
        Object obj = 1;
        if (entityCardsScrollDirection == EntityCardsScrollDirection.LEFT) {
            if (this.f11057j == null) {
                obj = null;
            }
        } else if (this.f11058k == null) {
            obj = null;
        }
        if (obj == null) {
            ListenableFuture a;
            m13008p();
            if (entityCardsScrollDirection == EntityCardsScrollDirection.LEFT) {
                if (this.f11059l.isPresent()) {
                    this.f11061n = false;
                    m12995a(this, (EntityCardsDataKey) this.f11059l.get());
                } else {
                    return;
                }
            } else if (this.f11060m.isPresent()) {
                this.f11062o = false;
                m12995a(this, (EntityCardsDataKey) this.f11060m.get());
            } else {
                return;
            }
            this.f11064q.m12827c(entityCardsScrollDirection);
            DefaultEntityCardsPageLoader defaultEntityCardsPageLoader = this.f11063p;
            int i = this.f11069v;
            Preconditions.checkArgument(i > 0);
            defaultEntityCardsPageLoader.f11026f.add(entityCardsScrollDirection);
            if (defaultEntityCardsPageLoader.f11027g.containsKey(entityCardsScrollDirection)) {
                a = Futures.a(defaultEntityCardsPageLoader.f11027g.get(entityCardsScrollDirection));
            } else {
                a = defaultEntityCardsPageLoader.f11021a.mo773a(entityCardsScrollDirection, i);
            }
            SettableFuture f = SettableFuture.f();
            Futures.a(a, new C11861(defaultEntityCardsPageLoader, f, entityCardsScrollDirection), defaultEntityCardsPageLoader.f11025e);
            ListenableFuture listenableFuture = f;
            if (entityCardsScrollDirection == EntityCardsScrollDirection.LEFT) {
                this.f11057j = listenableFuture;
            } else {
                Preconditions.checkArgument(entityCardsScrollDirection == EntityCardsScrollDirection.RIGHT);
                this.f11058k = listenableFuture;
            }
            Futures.a(listenableFuture, new FutureCallback<EntityCardsPage>(this) {
                final /* synthetic */ PagedEntityCardsDataSource f11043b;

                public void onSuccess(Object obj) {
                    EntityCardsPage entityCardsPage = (EntityCardsPage) obj;
                    PagedEntityCardsDataSource.m12994a(this.f11043b, entityCardsPage.f11035a, entityCardsPage.f11036b, entityCardsScrollDirection);
                }

                public void onFailure(Throwable th) {
                    if (!(th instanceof CancellationException)) {
                        this.f11043b.f11072y.a("load_entity_page_failure", th);
                    }
                    PagedEntityCardsDataSource.m13003d(this.f11043b, entityCardsScrollDirection);
                    this.f11043b.f11064q.m12829e(entityCardsScrollDirection);
                    this.f11043b.f11065r.m12798a(false, 0);
                    if (entityCardsScrollDirection == EntityCardsScrollDirection.LEFT) {
                        this.f11043b.f11061n = true;
                        PagedEntityCardsDataSource.m12995a(this.f11043b, (EntityCardsDataKey) this.f11043b.f11059l.get());
                        return;
                    }
                    this.f11043b.f11062o = true;
                    PagedEntityCardsDataSource.m12995a(this.f11043b, (EntityCardsDataKey) this.f11043b.f11060m.get());
                }
            }, this.f11071x);
        }
    }

    private ListenableFuture<Void> m13004l() {
        if (this.f11055h != null && !this.f11055h.isDone()) {
            return Futures.a(this.f11055h, new C11902(this), this.f11071x);
        }
        final ImmutableList o = m13007o();
        this.f11056i = false;
        this.f11055h = this.f11031c.m13091a(o);
        Futures.a(this.f11055h, new FutureCallback<ImmutableMap<String, ?>>(this) {
            final /* synthetic */ PagedEntityCardsDataSource f11046b;

            public void onSuccess(Object obj) {
                this.f11046b.f11055h = null;
            }

            public void onFailure(Throwable th) {
                this.f11046b.f11055h = null;
                this.f11046b.f11056i = true;
                AbstractEntityCardsDataSource abstractEntityCardsDataSource = this.f11046b;
                ImmutableList immutableList = o;
                int size = immutableList.size();
                for (int i = 0; i < size; i++) {
                    abstractEntityCardsDataSource.mo775a().a(new EntityModelLoadErrorEvent((String) immutableList.get(i)));
                }
            }
        }, this.f11071x);
        return Futures.a(this.f11055h, new C11924(this), this.f11071x);
    }

    public final void mo783f() {
        if (!(this.f11055h == null || this.f11055h.isDone())) {
            this.f11055h.cancel(true);
        }
        this.f11055h = null;
        if (!(this.f11057j == null || this.f11057j.isDone())) {
            this.f11057j.cancel(true);
        }
        this.f11057j = null;
        if (!(this.f11058k == null || this.f11058k.isDone())) {
            this.f11058k.cancel(true);
        }
        this.f11058k = null;
    }

    public static void m12999b(PagedEntityCardsDataSource pagedEntityCardsDataSource, ImmutableMap immutableMap) {
        pagedEntityCardsDataSource.f11065r.mo769a(CardConfigDataType.FINAL);
        if (pagedEntityCardsDataSource.f11066s.isPresent()) {
            ImmutableList o = pagedEntityCardsDataSource.m13007o();
            int size = o.size();
            for (int i = 0; i < size; i++) {
                String str = (String) o.get(i);
                Object obj = immutableMap.get(str);
                Preconditions.checkArgument(pagedEntityCardsDataSource.f11054g.containsKey(str));
                pagedEntityCardsDataSource.f11054g.put(str, obj);
            }
        } else {
            pagedEntityCardsDataSource.m12993a((ImmutableOffsetArray) pagedEntityCardsDataSource.f11067t.get(), immutableMap);
        }
        State state = pagedEntityCardsDataSource.f11033e;
        pagedEntityCardsDataSource.f11033e = State.INITIAL_ENTITIES_LOADED;
        pagedEntityCardsDataSource.m12972a(pagedEntityCardsDataSource.m13005m(), state, pagedEntityCardsDataSource.f11033e);
        ImmutableSet<String> keySet = immutableMap.keySet();
        Builder builder = new Builder();
        for (String str2 : keySet) {
            obj = pagedEntityCardsDataSource.f11054g.get(str2);
            if (obj != null) {
                builder.b(pagedEntityCardsDataSource.f11053f.get(str2), obj);
            }
        }
        pagedEntityCardsDataSource.m12973a(builder.b());
    }

    protected final void mo781b(String str) {
        if ("left_edge".equals(str) && this.f11059l.isPresent()) {
            mo779a(EntityCardsScrollDirection.LEFT);
            m12995a(this, (EntityCardsDataKey) this.f11059l.get());
        } else if ("right_edge".equals(str) && this.f11060m.isPresent()) {
            mo779a(EntityCardsScrollDirection.RIGHT);
            m12995a(this, (EntityCardsDataKey) this.f11060m.get());
        } else {
            Preconditions.checkArgument(m13007o().contains(str), "Asked to refetch an entity that is not in the initial list.");
            m13004l();
            m12973a(m12990a(this.f11052e));
        }
    }

    public static void m12995a(PagedEntityCardsDataSource pagedEntityCardsDataSource, EntityCardsDataKey entityCardsDataKey) {
        pagedEntityCardsDataSource.m12973a(ImmutableBiMap.b(entityCardsDataKey, pagedEntityCardsDataSource.m12996b(entityCardsDataKey)));
    }

    protected final boolean mo780a(String str) {
        if (this.f11056i) {
            return this.f11066s.isPresent() ? ((EntityCardsPage) this.f11066s.get()).f11036b.containsKey(str) : ((ImmutableOffsetArray) this.f11067t.get()).m12837a((Object) str);
        } else {
            return false;
        }
    }

    private Object m12996b(EntityCardsDataKey entityCardsDataKey) {
        if ("left_edge".equals(entityCardsDataKey.f11034a)) {
            if (this.f11061n) {
                return this.f11050c;
            }
            return this.f11048a;
        } else if (!"right_edge".equals(entityCardsDataKey.f11034a)) {
            return this.f11054g.get(entityCardsDataKey.f11034a);
        } else {
            if (this.f11062o) {
                return this.f11051d;
            }
            return this.f11049b;
        }
    }

    @VisibleForTesting
    private OrderedImmutableMap<EntityCardsDataKey, Object> m13005m() {
        m13008p();
        OrderedImmutableMap.Builder builder = new OrderedImmutableMap.Builder();
        if (this.f11059l.isPresent()) {
            builder.m12983a(this.f11059l.get(), m12996b((EntityCardsDataKey) this.f11059l.get()));
        }
        for (int i = 0; i < this.f11052e.m12838b(); i++) {
            String str = (String) this.f11052e.m12839b(i);
            builder.m12983a(this.f11053f.get(str), this.f11054g.get(str));
        }
        if (this.f11060m.isPresent()) {
            builder.m12983a(this.f11060m.get(), m12996b((EntityCardsDataKey) this.f11060m.get()));
        }
        return builder.m12982a();
    }

    public final Optional<Bundle> mo785h() {
        Optional<Bundle> optional;
        DefaultEntityCardsPageLoader defaultEntityCardsPageLoader = this.f11063p;
        Optional<Bundle> a = defaultEntityCardsPageLoader.f11021a.mo772a();
        if (defaultEntityCardsPageLoader.f11027g.containsKey(EntityCardsScrollDirection.LEFT)) {
            if (a.isPresent()) {
                optional = a;
            } else {
                optional = Optional.of(new Bundle());
            }
            ((Bundle) optional.get()).putParcelable("page_loader_currently_loading_ids_left", new ParcelableOffsetArray((ImmutableOffsetArray) defaultEntityCardsPageLoader.f11027g.get(EntityCardsScrollDirection.LEFT)));
        } else {
            optional = a;
        }
        if (defaultEntityCardsPageLoader.f11027g.containsKey(EntityCardsScrollDirection.RIGHT)) {
            if (!optional.isPresent()) {
                optional = Optional.of(new Bundle());
            }
            ((Bundle) optional.get()).putParcelable("page_loader_currently_loading_ids_right", new ParcelableOffsetArray((ImmutableOffsetArray) defaultEntityCardsPageLoader.f11027g.get(EntityCardsScrollDirection.RIGHT)));
        }
        return optional;
    }

    public final int mo786i() {
        Preconditions.checkState(m13006n(), "An uninitialized datasource has no (meaningful) current index");
        OrderedImmutableMap m = m13005m();
        for (int i = 0; i < m.m12989c(); i++) {
            if (this.f11068u.equals(((EntityCardsDataKey) m.m12987b(i)).f11034a)) {
                return i;
            }
        }
        throw new IllegalStateException("Unable to find initial entity ID in current list!");
    }

    public final String mo778a(Object obj) {
        Preconditions.checkNotNull(obj);
        if (!mo787j()) {
            return null;
        }
        EntityCardsDataKey entityCardsDataKey = (EntityCardsDataKey) obj;
        if ("right_edge".equals(entityCardsDataKey.f11034a)) {
            return (String) this.f11052e.m12839b(this.f11052e.m12838b() - 1);
        }
        if ("left_edge".equals(entityCardsDataKey.f11034a)) {
            return (String) this.f11052e.m12839b(0);
        }
        return entityCardsDataKey.f11034a;
    }

    public final boolean mo787j() {
        return !this.f11054g.isEmpty();
    }

    public final int mo788k() {
        return this.f11070w;
    }

    private void m12992a(int i, String str, EntityCardsDataKey entityCardsDataKey, Object obj) {
        if (this.f11054g.containsKey(str)) {
            m13002c(str);
        } else if (this.f11052e.m12841c(i)) {
            this.f11052e.mo771a(i, str);
            this.f11053f.put(str, entityCardsDataKey);
            this.f11054g.put(str, obj);
        } else {
            m12991a(i, str, entityCardsDataKey);
        }
    }

    private void m12997b(int i, String str, EntityCardsDataKey entityCardsDataKey, Object obj) {
        if (this.f11054g.containsKey(str)) {
            m13002c(str);
        } else if (this.f11052e.m12841c(i)) {
            this.f11052e.mo771a(i, str);
            this.f11053f.put(str, entityCardsDataKey);
            this.f11054g.put(str, obj);
        } else {
            m12991a(i, str, entityCardsDataKey);
        }
    }

    private void m13002c(String str) {
        this.f11072y.a("paged_data_source_received_duplicate", StringFormatUtil.formatStrLocaleSafe("Received entity from {%s} loader with id {%s} already in list", this.f11029a, str));
    }

    private void m12991a(int i, String str, EntityCardsDataKey entityCardsDataKey) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i2 = 0; i2 < this.f11052e.m12838b(); i2++) {
            int a = this.f11052e.m12835a(i2);
            String str2 = (String) this.f11052e.m12839b(i2);
            stringBuilder.append("(");
            stringBuilder.append(a);
            stringBuilder.append(",");
            stringBuilder.append(str2);
            stringBuilder.append(")");
        }
        this.f11072y.a("paged_data_source_discontinuity", StringFormatUtil.formatStrLocaleSafe("Received entity at position {%d} with key {%s} and id {%s} that can't be put into the ID list {%s}", Integer.valueOf(i), entityCardsDataKey, str, stringBuilder.toString()));
    }

    private void m12993a(ImmutableOffsetArray<String> immutableOffsetArray, ImmutableMap<String, ?> immutableMap) {
        boolean z;
        int i = 0;
        if (this.f11052e.m12838b() == 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
        while (i < immutableOffsetArray.m12838b()) {
            String str = (String) immutableOffsetArray.m12839b(i);
            this.f11052e.mo771a(immutableOffsetArray.m12835a(i), str);
            this.f11053f.put(str, new EntityCardsDataKey(str));
            this.f11054g.put(str, immutableMap.get(str));
            i++;
        }
        OffsetArrayHelper.m12846a(this.f11052e);
    }

    private void m12998b(ImmutableOffsetArray<String> immutableOffsetArray, ImmutableMap<String, ?> immutableMap) {
        for (int b = immutableOffsetArray.m12838b() - 1; b >= 0; b--) {
            EntityCardsDataKey entityCardsDataKey;
            int a = immutableOffsetArray.m12835a(b);
            String str = (String) immutableOffsetArray.m12839b(b);
            if (this.f11059l.isPresent()) {
                entityCardsDataKey = (EntityCardsDataKey) this.f11059l.get();
                this.f11059l = Absent.INSTANCE;
                this.f11061n = false;
            } else {
                entityCardsDataKey = new EntityCardsDataKey(str);
            }
            entityCardsDataKey.f11034a = str;
            m12992a(a, str, entityCardsDataKey, immutableMap.get(str));
        }
    }

    private ImmutableList<String> m13007o() {
        OffsetArray offsetArray;
        if (this.f11066s.isPresent()) {
            offsetArray = ((EntityCardsPage) this.f11066s.get()).f11035a;
        } else {
            ImmutableOffsetArray immutableOffsetArray = (ImmutableOffsetArray) this.f11067t.get();
        }
        return offsetArray.m12842d();
    }

    private void m13001c(ImmutableOffsetArray<String> immutableOffsetArray, ImmutableMap<String, ?> immutableMap) {
        for (int i = 0; i < immutableOffsetArray.m12838b(); i++) {
            EntityCardsDataKey entityCardsDataKey;
            int a = immutableOffsetArray.m12835a(i);
            String str = (String) immutableOffsetArray.m12839b(i);
            if (this.f11060m.isPresent()) {
                entityCardsDataKey = (EntityCardsDataKey) this.f11060m.get();
                this.f11060m = Absent.INSTANCE;
                this.f11062o = false;
            } else {
                entityCardsDataKey = new EntityCardsDataKey(str);
            }
            entityCardsDataKey.f11034a = str;
            m12997b(a, str, entityCardsDataKey, immutableMap.get(str));
        }
    }

    private void m13008p() {
        if (m13000b(EntityCardsScrollDirection.LEFT) && !this.f11059l.isPresent()) {
            this.f11059l = Optional.of(new EntityCardsDataKey("left_edge"));
        }
        if (m13000b(EntityCardsScrollDirection.RIGHT) && !this.f11060m.isPresent()) {
            this.f11060m = Optional.of(new EntityCardsDataKey("right_edge"));
        }
    }

    public static void m13003d(PagedEntityCardsDataSource pagedEntityCardsDataSource, EntityCardsScrollDirection entityCardsScrollDirection) {
        if (entityCardsScrollDirection == EntityCardsScrollDirection.LEFT) {
            pagedEntityCardsDataSource.f11057j = null;
            return;
        }
        Preconditions.checkArgument(entityCardsScrollDirection == EntityCardsScrollDirection.RIGHT);
        pagedEntityCardsDataSource.f11058k = null;
    }

    public final ImmutableList<String> mo784g() {
        ImmutableList.Builder builder = ImmutableList.builder();
        for (int i = 0; i < this.f11052e.m12838b(); i++) {
            builder.c(this.f11052e.m12839b(i));
        }
        return builder.b();
    }

    private ImmutableMap<EntityCardsDataKey, Object> m12990a(OffsetArray<String> offsetArray) {
        Builder builder = new Builder();
        for (int i = 0; i < offsetArray.m12838b(); i++) {
            String str = (String) offsetArray.m12839b(i);
            Object obj = this.f11054g.get(str);
            if (obj != null) {
                builder.b(this.f11053f.get(str), obj);
            }
        }
        return builder.b();
    }

    public final EntityCardsAdapter mo777a(EntityCardsAnalyticsLogger entityCardsAnalyticsLogger, EntityCardsController entityCardsController, EntityCardsDataSource entityCardsDataSource, C11761 c11761, EntityCardsScrollTTITracker entityCardsScrollTTITracker, LayoutInflater layoutInflater, RecyclableViewPoolManager recyclableViewPoolManager, Integer num, Bundle bundle) {
        return this.f11073z.m12776a(entityCardsAnalyticsLogger, entityCardsController, entityCardsDataSource, c11761, entityCardsScrollTTITracker, layoutInflater, recyclableViewPoolManager, num, bundle);
    }
}
