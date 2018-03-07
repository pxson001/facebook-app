package com.facebook.timeline.pymk.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.CanFriendPerson;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.timeline.pymk.PeopleYouMayKnowModel;
import javax.inject.Inject;

@ContextScoped
/* compiled from: faceweb_nfx */
public class PeopleYouMayKnowGroupPartDefinition<E extends CanFriendPerson & HasContext & HasPersistentState & HasRowKey & HasPrefetcher & HasInvalidate> extends BaseMultiRowGroupPartDefinition<PeopleYouMayKnowModel, Void, E> {
    private static PeopleYouMayKnowGroupPartDefinition f12512d;
    private static final Object f12513e = new Object();
    private final PeopleYouMayKnowFooterPartDefinition f12514a;
    private final PeopleYouMayKnowHeaderPartDefinition f12515b;
    private final PeopleYouMayKnowHScrollPartDefinition<E> f12516c;

    private static PeopleYouMayKnowGroupPartDefinition m12517b(InjectorLike injectorLike) {
        return new PeopleYouMayKnowGroupPartDefinition(PeopleYouMayKnowFooterPartDefinition.m12504a(injectorLike), PeopleYouMayKnowHeaderPartDefinition.m12532a(injectorLike), PeopleYouMayKnowHScrollPartDefinition.m12526a(injectorLike));
    }

    public final Object m12518a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        PeopleYouMayKnowModel peopleYouMayKnowModel = (PeopleYouMayKnowModel) obj;
        baseMultiRowSubParts.a(this.f12515b, peopleYouMayKnowModel);
        baseMultiRowSubParts.a(this.f12516c, peopleYouMayKnowModel);
        baseMultiRowSubParts.a(this.f12514a, peopleYouMayKnowModel);
        return null;
    }

    @Inject
    public PeopleYouMayKnowGroupPartDefinition(PeopleYouMayKnowFooterPartDefinition peopleYouMayKnowFooterPartDefinition, PeopleYouMayKnowHeaderPartDefinition peopleYouMayKnowHeaderPartDefinition, PeopleYouMayKnowHScrollPartDefinition peopleYouMayKnowHScrollPartDefinition) {
        this.f12514a = peopleYouMayKnowFooterPartDefinition;
        this.f12515b = peopleYouMayKnowHeaderPartDefinition;
        this.f12516c = peopleYouMayKnowHScrollPartDefinition;
    }

    public final boolean m12519a(Object obj) {
        return true;
    }

    public static PeopleYouMayKnowGroupPartDefinition m12516a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PeopleYouMayKnowGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12513e) {
                PeopleYouMayKnowGroupPartDefinition peopleYouMayKnowGroupPartDefinition;
                if (a2 != null) {
                    peopleYouMayKnowGroupPartDefinition = (PeopleYouMayKnowGroupPartDefinition) a2.a(f12513e);
                } else {
                    peopleYouMayKnowGroupPartDefinition = f12512d;
                }
                if (peopleYouMayKnowGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m12517b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12513e, b3);
                        } else {
                            f12512d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = peopleYouMayKnowGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
