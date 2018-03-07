package com.facebook.entitycards.loader;

import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.entitycards.collect.ImmutableOffsetArray;
import com.facebook.entitycards.collect.OffsetArray;
import com.facebook.entitycards.collect.ParcelableOffsetArray;
import com.facebook.entitycards.model.EntityCardsPage;
import com.facebook.entitycards.model.EntityCardsScrollDirection;
import com.facebook.entitycards.service.EntityCardsIdsForPageLoader;
import com.facebook.entitycardsplugins.person.loader.DefaultPersonCardsLoader;
import com.facebook.inject.Assisted;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.RegularImmutableBiMap;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.SettableFuture;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: id not found */
public class DefaultEntityCardsPageLoader {
    public final EntityCardsIdsForPageLoader f11021a;
    public final DefaultPersonCardsLoader f11022b;
    public final String f11023c;
    public final AbstractFbErrorReporter f11024d;
    public final ExecutorService f11025e;
    public final HashSet<EntityCardsScrollDirection> f11026f = new HashSet();
    public final HashMap<EntityCardsScrollDirection, ImmutableOffsetArray<String>> f11027g = new HashMap();

    /* compiled from: id not found */
    public class C11861 extends AbstractDisposableFutureCallback<ImmutableOffsetArray<String>> {
        final /* synthetic */ SettableFuture f11014a;
        final /* synthetic */ EntityCardsScrollDirection f11015b;
        final /* synthetic */ DefaultEntityCardsPageLoader f11016c;

        public C11861(DefaultEntityCardsPageLoader defaultEntityCardsPageLoader, SettableFuture settableFuture, EntityCardsScrollDirection entityCardsScrollDirection) {
            this.f11016c = defaultEntityCardsPageLoader;
            this.f11014a = settableFuture;
            this.f11015b = entityCardsScrollDirection;
        }

        protected final void m12953a(Object obj) {
            ImmutableOffsetArray immutableOffsetArray = (ImmutableOffsetArray) obj;
            if (immutableOffsetArray.m12840c()) {
                FutureDetour.a(this.f11014a, new EntityCardsPage(ImmutableOffsetArray.f10901a, RegularImmutableBiMap.a), -2051403228);
                return;
            }
            this.f11016c.f11027g.put(this.f11015b, immutableOffsetArray);
            Futures.a(this.f11016c.f11022b.m13091a(immutableOffsetArray.m12842d()), new C11872(this.f11016c, this.f11015b, this.f11014a, immutableOffsetArray), this.f11016c.f11025e);
        }

        protected final void m12954a(Throwable th) {
            this.f11016c.f11024d.a("people_entity_cards_page_ids", th);
            this.f11014a.a(th);
        }
    }

    /* compiled from: id not found */
    public class C11872 extends AbstractDisposableFutureCallback<ImmutableMap<String, ? extends Parcelable>> {
        final /* synthetic */ EntityCardsScrollDirection f11017a;
        final /* synthetic */ SettableFuture f11018b;
        final /* synthetic */ ImmutableOffsetArray f11019c;
        final /* synthetic */ DefaultEntityCardsPageLoader f11020d;

        public C11872(DefaultEntityCardsPageLoader defaultEntityCardsPageLoader, EntityCardsScrollDirection entityCardsScrollDirection, SettableFuture settableFuture, ImmutableOffsetArray immutableOffsetArray) {
            this.f11020d = defaultEntityCardsPageLoader;
            this.f11017a = entityCardsScrollDirection;
            this.f11018b = settableFuture;
            this.f11019c = immutableOffsetArray;
        }

        protected final void m12955a(Object obj) {
            ImmutableMap immutableMap = (ImmutableMap) obj;
            this.f11020d.f11026f.remove(this.f11017a);
            this.f11020d.f11027g.remove(this.f11017a);
            SettableFuture settableFuture = this.f11018b;
            DefaultEntityCardsPageLoader defaultEntityCardsPageLoader = this.f11020d;
            OffsetArray offsetArray = this.f11019c;
            if (!EntityCardsPage.m12980a(offsetArray, immutableMap)) {
                defaultEntityCardsPageLoader.f11024d.a("entity_cards_page_loader_bad_ids_page", StringFormatUtil.a("Surface '%s' did an entities fetch that returned a bad set of results. Expected IDs [%s] but got entities for [%s]", new Object[]{defaultEntityCardsPageLoader.f11023c, Joiner.on(",").join(offsetArray.m12842d()), Joiner.on(",").join(immutableMap.keySet())}));
            }
            FutureDetour.a(settableFuture, new EntityCardsPage(offsetArray, immutableMap), -228545137);
        }

        protected final void m12956a(Throwable th) {
            this.f11020d.f11024d.a("people_entity_cards_page", th);
            this.f11018b.a(th);
        }
    }

    @Inject
    public DefaultEntityCardsPageLoader(@Assisted EntityCardsIdsForPageLoader entityCardsIdsForPageLoader, @Assisted DefaultPersonCardsLoader defaultPersonCardsLoader, @Assisted String str, @Nullable @Assisted Bundle bundle, AbstractFbErrorReporter abstractFbErrorReporter, ExecutorService executorService) {
        this.f11021a = entityCardsIdsForPageLoader;
        this.f11022b = defaultPersonCardsLoader;
        this.f11023c = str;
        this.f11024d = abstractFbErrorReporter;
        this.f11025e = executorService;
        if (bundle != null) {
            if (bundle.containsKey("page_loader_currently_loading_ids_left")) {
                this.f11027g.put(EntityCardsScrollDirection.LEFT, ((ParcelableOffsetArray) bundle.getParcelable("page_loader_currently_loading_ids_left")).m12847a());
            }
            if (bundle.containsKey("page_loader_currently_loading_ids_right")) {
                this.f11027g.put(EntityCardsScrollDirection.RIGHT, ((ParcelableOffsetArray) bundle.getParcelable("page_loader_currently_loading_ids_right")).m12847a());
            }
        }
    }
}
