package com.facebook.redspace.rows.sharedactivities;

import android.content.Context;
import android.net.Uri;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.redspace.model.GenericActivitySharing;
import com.facebook.redspace.model.RedSpaceSharedActivities.SharedActivity;
import com.facebook.redspace.rows.RedSpaceEnvironment;
import com.facebook.redspace.rows.sharedactivities.RedSpaceSharedActivitiesContentViewPartDefinition.Props;
import com.facebook.ultralight.Inject;

@ContextScoped
/* compiled from: PROFILE_STEP */
public class RedSpaceSharedActivitiesGenericPartDefinition extends MultiRowSinglePartDefinition<SharedActivity, Void, RedSpaceEnvironment, ContentView> {
    public static final ViewType<ContentView> f12251a = ViewType.a(2130906758);
    private static RedSpaceSharedActivitiesGenericPartDefinition f12252d;
    private static final Object f12253e = new Object();
    private final RedSpaceSharedActivitiesBackgroundPartDefinition f12254b;
    private final RedSpaceSharedActivitiesContentViewPartDefinition f12255c;

    private static RedSpaceSharedActivitiesGenericPartDefinition m12701b(InjectorLike injectorLike) {
        return new RedSpaceSharedActivitiesGenericPartDefinition(RedSpaceSharedActivitiesBackgroundPartDefinition.m12692a(injectorLike), RedSpaceSharedActivitiesContentViewPartDefinition.m12696a(injectorLike));
    }

    public final Object m12703a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        GenericActivitySharing genericActivitySharing = (GenericActivitySharing) ((SharedActivity) obj);
        subParts.a(this.f12254b, null);
        RedSpaceSharedActivitiesContentViewPartDefinition redSpaceSharedActivitiesContentViewPartDefinition = this.f12255c;
        Props props = new Props();
        props.f12234a = genericActivitySharing.d;
        props = props;
        props.f12241h = genericActivitySharing.c;
        props = props;
        props.f12236c = genericActivitySharing.a;
        props = props;
        props.f12238e = Uri.parse(genericActivitySharing.d());
        subParts.a(redSpaceSharedActivitiesContentViewPartDefinition, props);
        return null;
    }

    public final boolean m12704a(Object obj) {
        SharedActivity sharedActivity = (SharedActivity) obj;
        return (sharedActivity instanceof GenericActivitySharing) && sharedActivity.e();
    }

    @Inject
    private RedSpaceSharedActivitiesGenericPartDefinition(RedSpaceSharedActivitiesBackgroundPartDefinition redSpaceSharedActivitiesBackgroundPartDefinition, RedSpaceSharedActivitiesContentViewPartDefinition redSpaceSharedActivitiesContentViewPartDefinition) {
        this.f12255c = redSpaceSharedActivitiesContentViewPartDefinition;
        this.f12254b = redSpaceSharedActivitiesBackgroundPartDefinition;
    }

    public final ViewType<ContentView> m12702a() {
        return f12251a;
    }

    public static RedSpaceSharedActivitiesGenericPartDefinition m12700a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            RedSpaceSharedActivitiesGenericPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12253e) {
                RedSpaceSharedActivitiesGenericPartDefinition redSpaceSharedActivitiesGenericPartDefinition;
                if (a2 != null) {
                    redSpaceSharedActivitiesGenericPartDefinition = (RedSpaceSharedActivitiesGenericPartDefinition) a2.a(f12253e);
                } else {
                    redSpaceSharedActivitiesGenericPartDefinition = f12252d;
                }
                if (redSpaceSharedActivitiesGenericPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m12701b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12253e, b3);
                        } else {
                            f12252d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = redSpaceSharedActivitiesGenericPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
