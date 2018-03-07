package com.facebook.redspace.rows.sharedactivities;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
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
import com.facebook.redspace.model.RedSpaceSharedActivities;
import com.facebook.redspace.model.RedSpaceSharedActivities.SharedActivity;
import com.facebook.redspace.rows.RedSpaceEnvironment;
import com.facebook.ultralight.Inject;
import com.google.common.collect.ImmutableList;

@ContextScoped
/* compiled from: PROFILE_PHOTO_CHECKUP */
public class RedSpaceSharedActivitiesGroupPartDefinition extends BaseMultiRowGroupPartDefinition<Object, Void, RedSpaceEnvironment> {
    private static RedSpaceSharedActivitiesGroupPartDefinition f12256d;
    private static final Object f12257e = new Object();
    private final RedSpaceSharedActivitiesPresencePartDefinition f12258a;
    private final RedSpaceSharedActivitiesGenericPartDefinition f12259b;
    private final RedSpaceSharedActivitiesLocationPartDefinition f12260c;

    private static RedSpaceSharedActivitiesGroupPartDefinition m12706b(InjectorLike injectorLike) {
        return new RedSpaceSharedActivitiesGroupPartDefinition(RedSpaceSharedActivitiesPresencePartDefinition.m12715a(injectorLike), RedSpaceSharedActivitiesGenericPartDefinition.m12700a(injectorLike), RedSpaceSharedActivitiesLocationPartDefinition.m12709a(injectorLike));
    }

    @Inject
    private RedSpaceSharedActivitiesGroupPartDefinition(RedSpaceSharedActivitiesPresencePartDefinition redSpaceSharedActivitiesPresencePartDefinition, RedSpaceSharedActivitiesGenericPartDefinition redSpaceSharedActivitiesGenericPartDefinition, RedSpaceSharedActivitiesLocationPartDefinition redSpaceSharedActivitiesLocationPartDefinition) {
        this.f12258a = redSpaceSharedActivitiesPresencePartDefinition;
        this.f12259b = redSpaceSharedActivitiesGenericPartDefinition;
        this.f12260c = redSpaceSharedActivitiesLocationPartDefinition;
    }

    public final boolean m12708a(Object obj) {
        return obj instanceof RedSpaceSharedActivities;
    }

    public final Object m12707a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        ImmutableList immutableList = ((RedSpaceSharedActivities) obj).a;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            SharedActivity sharedActivity = (SharedActivity) immutableList.get(i);
            SubPartsSelector.a(baseMultiRowSubParts, this.f12258a, sharedActivity).a(this.f12260c, sharedActivity).a(this.f12259b, sharedActivity);
        }
        return null;
    }

    public static RedSpaceSharedActivitiesGroupPartDefinition m12705a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            RedSpaceSharedActivitiesGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12257e) {
                RedSpaceSharedActivitiesGroupPartDefinition redSpaceSharedActivitiesGroupPartDefinition;
                if (a2 != null) {
                    redSpaceSharedActivitiesGroupPartDefinition = (RedSpaceSharedActivitiesGroupPartDefinition) a2.a(f12257e);
                } else {
                    redSpaceSharedActivitiesGroupPartDefinition = f12256d;
                }
                if (redSpaceSharedActivitiesGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m12706b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12257e, b3);
                        } else {
                            f12256d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = redSpaceSharedActivitiesGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
