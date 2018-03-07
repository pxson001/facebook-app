package com.facebook.entitycards.model;

import com.facebook.entitycardsplugins.person.PersonCardSupportDeclaration;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: unknown relative layout param =  */
public final class C1196xd3c85960 implements MultiBindIndexedProvider<EntityCardsCardSupportDeclaration>, Provider<Set<EntityCardsCardSupportDeclaration>> {
    private final InjectorLike f11077a;

    public C1196xd3c85960(InjectorLike injectorLike) {
        this.f11077a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f11077a.getScopeAwareInjector(), this);
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
