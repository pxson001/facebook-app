package com.facebook.timeline.protiles.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.CanFriendPerson;
import com.facebook.feed.environment.HasImageLoadListener;
import com.facebook.graphql.enums.GraphQLProfileTileSectionType;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.timeline.protiles.model.ProtileModel;
import javax.inject.Inject;

@ContextScoped
/* compiled from: fb_location */
public class ProtilesRootPartDefinition<E extends HasImageLoadListener & CanFriendPerson> extends BaseMultiRowGroupPartDefinition<ProtileModel, Void, E> {
    private static ProtilesRootPartDefinition f12327d;
    private static final Object f12328e = new Object();
    private final ProtilesHeaderPartDefinition f12329a;
    private final ProtilesItemsRootPartDefinition f12330b;
    private final ProtilesFooterPartDefinition f12331c;

    private static ProtilesRootPartDefinition m12375b(InjectorLike injectorLike) {
        return new ProtilesRootPartDefinition(ProtilesHeaderPartDefinition.m12320a(injectorLike), ProtilesItemsRootPartDefinition.m12329a(injectorLike), ProtilesFooterPartDefinition.m12286a(injectorLike));
    }

    public final Object m12376a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        ProtileModel protileModel = (ProtileModel) obj;
        baseMultiRowSubParts.a(this.f12329a, protileModel);
        baseMultiRowSubParts.a(this.f12330b, protileModel);
        baseMultiRowSubParts.a(this.f12331c, protileModel);
        return null;
    }

    public final boolean m12377a(Object obj) {
        ProtileModel protileModel = (ProtileModel) obj;
        return protileModel.m12109b() == GraphQLProfileTileSectionType.PHOTOS || protileModel.m12109b() == GraphQLProfileTileSectionType.FRIENDS;
    }

    @Inject
    public ProtilesRootPartDefinition(ProtilesHeaderPartDefinition protilesHeaderPartDefinition, ProtilesItemsRootPartDefinition protilesItemsRootPartDefinition, ProtilesFooterPartDefinition protilesFooterPartDefinition) {
        this.f12329a = protilesHeaderPartDefinition;
        this.f12330b = protilesItemsRootPartDefinition;
        this.f12331c = protilesFooterPartDefinition;
    }

    public static ProtilesRootPartDefinition m12374a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ProtilesRootPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12328e) {
                ProtilesRootPartDefinition protilesRootPartDefinition;
                if (a2 != null) {
                    protilesRootPartDefinition = (ProtilesRootPartDefinition) a2.a(f12328e);
                } else {
                    protilesRootPartDefinition = f12327d;
                }
                if (protilesRootPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m12375b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12328e, b3);
                        } else {
                            f12327d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = protilesRootPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
