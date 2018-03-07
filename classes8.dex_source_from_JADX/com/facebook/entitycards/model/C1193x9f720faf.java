package com.facebook.entitycards.model;

import com.facebook.entitycardsplugins.person.PersonCardSupportDeclaration;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: unknown relative layout param =  */
public final class C1193x9f720faf implements MultiBindIndexedProvider<EntityCardsCardSupportDeclaration>, Provider<Set<EntityCardsCardSupportDeclaration>> {
    private final InjectorLike f11074a;

    public C1193x9f720faf(InjectorLike injectorLike) {
        this.f11074a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f11074a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 1;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return PersonCardSupportDeclaration.m13080a(injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
