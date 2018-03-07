package com.facebook.timeline.editfeaturedcontainers.rows;

import android.content.Context;
import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.timeline.editfeaturedcontainers.models.SuggestedPhotosData;
import com.facebook.timeline.editfeaturedcontainers.rows.NullStateSectionTitlePartDefinition.Props;
import com.facebook.timeline.editfeaturedcontainers.rows.environments.NullStateEnvironment;
import javax.inject.Inject;

@ContextScoped
/* compiled from: getGroupThreads */
public class NullStateSuggestedPhotosSectionPartDefinition extends BaseMultiRowGroupPartDefinition<SuggestedPhotosData, Void, NullStateEnvironment> {
    private static NullStateSuggestedPhotosSectionPartDefinition f10870d;
    private static final Object f10871e = new Object();
    private final NullStateSectionTitlePartDefinition f10872a;
    private final NullStateSuggestedRollPartDefinition f10873b;
    public final Resources f10874c;

    private static NullStateSuggestedPhotosSectionPartDefinition m10984b(InjectorLike injectorLike) {
        return new NullStateSuggestedPhotosSectionPartDefinition(NullStateSectionTitlePartDefinition.m10961a(injectorLike), NullStateSuggestedRollPartDefinition.m10990a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike));
    }

    public final Object m10985a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        SuggestedPhotosData suggestedPhotosData = (SuggestedPhotosData) obj;
        baseMultiRowSubParts.a(this.f10872a, new Props(this.f10874c.getString(2131241389), null));
        baseMultiRowSubParts.a(this.f10873b, suggestedPhotosData);
        return null;
    }

    @Inject
    public NullStateSuggestedPhotosSectionPartDefinition(NullStateSectionTitlePartDefinition nullStateSectionTitlePartDefinition, NullStateSuggestedRollPartDefinition nullStateSuggestedRollPartDefinition, Resources resources) {
        this.f10872a = nullStateSectionTitlePartDefinition;
        this.f10873b = nullStateSuggestedRollPartDefinition;
        this.f10874c = resources;
    }

    public final boolean m10986a(Object obj) {
        return true;
    }

    public static NullStateSuggestedPhotosSectionPartDefinition m10983a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            NullStateSuggestedPhotosSectionPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f10871e) {
                NullStateSuggestedPhotosSectionPartDefinition nullStateSuggestedPhotosSectionPartDefinition;
                if (a2 != null) {
                    nullStateSuggestedPhotosSectionPartDefinition = (NullStateSuggestedPhotosSectionPartDefinition) a2.a(f10871e);
                } else {
                    nullStateSuggestedPhotosSectionPartDefinition = f10870d;
                }
                if (nullStateSuggestedPhotosSectionPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10984b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f10871e, b3);
                        } else {
                            f10870d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = nullStateSuggestedPhotosSectionPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
