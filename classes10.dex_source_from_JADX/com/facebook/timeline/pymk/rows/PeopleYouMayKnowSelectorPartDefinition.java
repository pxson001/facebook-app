package com.facebook.timeline.pymk.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.CanFriendPerson;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feed.rows.core.parts.RootPartSelector;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.timeline.pymk.PeopleYouMayKnowModel;
import javax.inject.Inject;

@ContextScoped
/* compiled from: facebookAd.sendImpression(); */
public class PeopleYouMayKnowSelectorPartDefinition<E extends CanFriendPerson & HasContext & HasPersistentState & HasPrefetcher & HasRowKey & HasInvalidate> extends BaseMultiRowGroupPartDefinition<Object, Void, E> {
    private static PeopleYouMayKnowSelectorPartDefinition f12573b;
    private static final Object f12574c = new Object();
    private final RootPartSelector<E> f12575a;

    private static PeopleYouMayKnowSelectorPartDefinition m12557b(InjectorLike injectorLike) {
        return new PeopleYouMayKnowSelectorPartDefinition(IdBasedLazy.a(injectorLike, 11357));
    }

    @Inject
    public PeopleYouMayKnowSelectorPartDefinition(Lazy<PeopleYouMayKnowGroupPartDefinition> lazy) {
        this.f12575a = RootPartSelector.a().a(PeopleYouMayKnowModel.class, lazy);
    }

    public final boolean m12559a(Object obj) {
        return true;
    }

    public final Object m12558a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        this.f12575a.a(baseMultiRowSubParts, obj);
        return null;
    }

    public static PeopleYouMayKnowSelectorPartDefinition m12556a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PeopleYouMayKnowSelectorPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12574c) {
                PeopleYouMayKnowSelectorPartDefinition peopleYouMayKnowSelectorPartDefinition;
                if (a2 != null) {
                    peopleYouMayKnowSelectorPartDefinition = (PeopleYouMayKnowSelectorPartDefinition) a2.a(f12574c);
                } else {
                    peopleYouMayKnowSelectorPartDefinition = f12573b;
                }
                if (peopleYouMayKnowSelectorPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m12557b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12574c, b3);
                        } else {
                            f12573b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = peopleYouMayKnowSelectorPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
