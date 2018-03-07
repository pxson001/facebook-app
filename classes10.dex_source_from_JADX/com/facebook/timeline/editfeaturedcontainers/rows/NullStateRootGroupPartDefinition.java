package com.facebook.timeline.editfeaturedcontainers.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
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
import com.facebook.timeline.editfeaturedcontainers.models.CameraRollData;
import com.facebook.timeline.editfeaturedcontainers.models.RecentSectionData;
import com.facebook.timeline.editfeaturedcontainers.models.SuggestedPhotosData;
import com.facebook.timeline.editfeaturedcontainers.protocol.FetchNullStateGraphQLModels.FeaturedPageSectionModel;
import com.facebook.timeline.editfeaturedcontainers.rows.environments.NullStateEnvironment;
import javax.inject.Inject;

@ContextScoped
/* compiled from: getSimpleText  */
public class NullStateRootGroupPartDefinition extends BaseMultiRowGroupPartDefinition<Object, Void, NullStateEnvironment> {
    private static NullStateRootGroupPartDefinition f10832b;
    private static final Object f10833c = new Object();
    private final RootPartSelector<NullStateEnvironment> f10834a;

    private static NullStateRootGroupPartDefinition m10957b(InjectorLike injectorLike) {
        return new NullStateRootGroupPartDefinition(IdBasedLazy.a(injectorLike, 11198), IdBasedLazy.a(injectorLike, 11195), IdBasedLazy.a(injectorLike, 11204), IdBasedLazy.a(injectorLike, 11203));
    }

    @Inject
    public NullStateRootGroupPartDefinition(Lazy<NullStateRecentSectionPartDefinition> lazy, Lazy<NullStateCameraSectionPartDefinition> lazy2, Lazy<NullStateSuggestedPhotosSectionPartDefinition> lazy3, Lazy<NullStateSuggestedPagesSectionPartDefinition> lazy4) {
        this.f10834a = RootPartSelector.a().a(RecentSectionData.class, lazy).a(CameraRollData.class, lazy2).a(SuggestedPhotosData.class, lazy3).a(FeaturedPageSectionModel.class, lazy4);
    }

    public final boolean m10959a(Object obj) {
        return true;
    }

    public final Object m10958a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        this.f10834a.a(baseMultiRowSubParts, obj);
        return null;
    }

    public static NullStateRootGroupPartDefinition m10956a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            NullStateRootGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f10833c) {
                NullStateRootGroupPartDefinition nullStateRootGroupPartDefinition;
                if (a2 != null) {
                    nullStateRootGroupPartDefinition = (NullStateRootGroupPartDefinition) a2.a(f10833c);
                } else {
                    nullStateRootGroupPartDefinition = f10832b;
                }
                if (nullStateRootGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10957b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f10833c, b3);
                        } else {
                            f10832b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = nullStateRootGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
