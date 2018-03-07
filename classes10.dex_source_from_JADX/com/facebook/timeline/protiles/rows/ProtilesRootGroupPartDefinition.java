package com.facebook.timeline.protiles.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.CanFriendPerson;
import com.facebook.feed.environment.HasImageLoadListener;
import com.facebook.feed.rows.core.parts.RootPartSelector;
import com.facebook.feed.rows.sections.common.unknown.UnknownFeedUnitMultiRowGroupPartDefinition;
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
import com.facebook.timeline.protiles.model.ProtileModel;
import com.facebook.timeline.protiles.model.ProtilesLoadingData;
import com.facebook.timeline.protiles.model.TimelinePromptData;
import javax.inject.Inject;

@ContextScoped
/* compiled from: fb_mobile_activate_app */
public class ProtilesRootGroupPartDefinition<E extends HasImageLoadListener & CanFriendPerson> extends BaseMultiRowGroupPartDefinition<Object, Void, E> {
    private static ProtilesRootGroupPartDefinition f12324b;
    private static final Object f12325c = new Object();
    private final RootPartSelector<E> f12326a;

    private static ProtilesRootGroupPartDefinition m12371b(InjectorLike injectorLike) {
        return new ProtilesRootGroupPartDefinition(IdBasedLazy.a(injectorLike, 11331), IdBasedLazy.a(injectorLike, 11335), IdBasedLazy.a(injectorLike, 6023), IdBasedLazy.a(injectorLike, 11338));
    }

    @Inject
    public ProtilesRootGroupPartDefinition(Lazy<ProtilesLoadingIndicatorPartDefinition> lazy, Lazy<ProtilesRootPartDefinition> lazy2, Lazy<UnknownFeedUnitMultiRowGroupPartDefinition> lazy3, Lazy<TimelinePendingFriendRequestsPartDefinition> lazy4) {
        this.f12326a = RootPartSelector.a().a(ProtilesLoadingData.class, lazy).a(ProtileModel.class, lazy2).a(TimelinePromptData.class, lazy4).a(Object.class, lazy3);
    }

    public final boolean m12373a(Object obj) {
        return true;
    }

    public final Object m12372a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        this.f12326a.a(baseMultiRowSubParts, obj);
        return null;
    }

    public static ProtilesRootGroupPartDefinition m12370a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ProtilesRootGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12325c) {
                ProtilesRootGroupPartDefinition protilesRootGroupPartDefinition;
                if (a2 != null) {
                    protilesRootGroupPartDefinition = (ProtilesRootGroupPartDefinition) a2.a(f12325c);
                } else {
                    protilesRootGroupPartDefinition = f12324b;
                }
                if (protilesRootGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m12371b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12325c, b3);
                        } else {
                            f12324b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = protilesRootGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
