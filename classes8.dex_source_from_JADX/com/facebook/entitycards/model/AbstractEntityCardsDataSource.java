package com.facebook.entitycards.model;

import com.facebook.entitycards.model.EntityCardsDataSource.State;
import com.facebook.entitycards.model.event.EntityCardsDatasourceEventBus;
import com.facebook.entitycards.model.event.EntityModelChangedEvent;
import com.facebook.entitycards.model.event.EntityModelCollectionChangedEvent;
import com.facebook.entitycardsplugins.person.loader.DefaultPersonCardsLoader;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.Iterator;
import java.util.Map.Entry;

/* compiled from: iconHeight */
public abstract class AbstractEntityCardsDataSource implements EntityCardsDataSource {
    public final String f11029a;
    private final EntityCardsDatasourceEventBus f11030b;
    public final DefaultPersonCardsLoader f11031c;
    private final C11881 f11032d = new C11881(this);
    public State f11033e = State.UNINITIALIZED;

    /* compiled from: iconHeight */
    public class C11881 {
        public final /* synthetic */ AbstractEntityCardsDataSource f11028a;

        C11881(AbstractEntityCardsDataSource abstractEntityCardsDataSource) {
            this.f11028a = abstractEntityCardsDataSource;
        }

        public final void m12958b(String str) {
            this.f11028a.mo781b(str);
        }
    }

    public abstract boolean mo780a(String str);

    protected abstract void mo781b(String str);

    public AbstractEntityCardsDataSource(String str, DefaultPersonCardsLoader defaultPersonCardsLoader) {
        this.f11029a = (String) Preconditions.checkNotNull(str);
        this.f11030b = new EntityCardsDatasourceEventBus();
        this.f11031c = defaultPersonCardsLoader;
    }

    public final EntityCardsDatasourceEventBus mo775a() {
        return this.f11030b;
    }

    protected final void m12973a(ImmutableMap<EntityCardsDataKey, ?> immutableMap) {
        if (immutableMap != null) {
            Iterator it = immutableMap.entrySet().iterator();
            while (it.hasNext()) {
                Entry entry = (Entry) it.next();
                mo775a().a(new EntityModelChangedEvent(entry.getKey(), ((EntityCardsDataKey) entry.getKey()).f11034a, entry.getValue()));
            }
        }
    }

    public final void m12972a(OrderedImmutableMap<EntityCardsDataKey, Object> orderedImmutableMap, State state, State state2) {
        mo775a().a(new EntityModelCollectionChangedEvent(orderedImmutableMap, state, state2));
    }

    public final C11881 mo776d() {
        return this.f11032d;
    }
}
