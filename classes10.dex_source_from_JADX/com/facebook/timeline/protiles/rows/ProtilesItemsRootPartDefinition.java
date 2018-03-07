package com.facebook.timeline.protiles.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.CanFriendPerson;
import com.facebook.feed.environment.HasImageLoadListener;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
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
/* compiled from: fbtrace_node */
public class ProtilesItemsRootPartDefinition<E extends HasImageLoadListener & CanFriendPerson & HasPrefetcher> extends BaseMultiRowGroupPartDefinition<ProtileModel, Void, E> {
    private static ProtilesItemsRootPartDefinition f12260d;
    private static final Object f12261e = new Object();
    private final ProtilesPhotosMosaicPartDefinition f12262a;
    private final ProtilesGridPartDefinition f12263b;
    private final ProtilesListPartDefinition f12264c;

    private static ProtilesItemsRootPartDefinition m12330b(InjectorLike injectorLike) {
        return new ProtilesItemsRootPartDefinition(ProtilesGridPartDefinition.m12300a(injectorLike), ProtilesPhotosMosaicPartDefinition.m12364a(injectorLike), ProtilesListPartDefinition.m12333a(injectorLike));
    }

    public final Object m12331a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        ProtileModel protileModel = (ProtileModel) obj;
        SubPartsSelector.a(baseMultiRowSubParts, this.f12263b, protileModel).a(this.f12262a, protileModel).a(this.f12264c, protileModel);
        return null;
    }

    public final boolean m12332a(Object obj) {
        ProtileModel protileModel = (ProtileModel) obj;
        return (protileModel == null || protileModel.f12107c.isEmpty()) ? false : true;
    }

    @Inject
    public ProtilesItemsRootPartDefinition(ProtilesGridPartDefinition protilesGridPartDefinition, ProtilesPhotosMosaicPartDefinition protilesPhotosMosaicPartDefinition, ProtilesListPartDefinition protilesListPartDefinition) {
        this.f12262a = protilesPhotosMosaicPartDefinition;
        this.f12263b = protilesGridPartDefinition;
        this.f12264c = protilesListPartDefinition;
    }

    public static ProtilesItemsRootPartDefinition m12329a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ProtilesItemsRootPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12261e) {
                ProtilesItemsRootPartDefinition protilesItemsRootPartDefinition;
                if (a2 != null) {
                    protilesItemsRootPartDefinition = (ProtilesItemsRootPartDefinition) a2.a(f12261e);
                } else {
                    protilesItemsRootPartDefinition = f12260d;
                }
                if (protilesItemsRootPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m12330b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12261e, b3);
                        } else {
                            f12260d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = protilesItemsRootPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
