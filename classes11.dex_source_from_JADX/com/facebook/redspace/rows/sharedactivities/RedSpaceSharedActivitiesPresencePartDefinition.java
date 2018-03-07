package com.facebook.redspace.rows.sharedactivities;

import android.content.Context;
import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.timeformat.DefaultTimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil.TimeFormatStyle;
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
import com.facebook.redspace.model.PresenceActivitySharing;
import com.facebook.redspace.model.RedSpaceSharedActivities.SharedActivity;
import com.facebook.redspace.rows.RedSpaceEnvironment;
import com.facebook.redspace.rows.sharedactivities.RedSpaceSharedActivitiesContentViewPartDefinition.Props;
import com.facebook.ultralight.Inject;

@ContextScoped
/* compiled from: PROFILE_FIELD_TEXT */
public class RedSpaceSharedActivitiesPresencePartDefinition extends MultiRowSinglePartDefinition<SharedActivity, Void, RedSpaceEnvironment, ContentView> {
    public static final ViewType<ContentView> f12270a = ViewType.a(2130906761);
    private static RedSpaceSharedActivitiesPresencePartDefinition f12271f;
    private static final Object f12272g = new Object();
    private final RedSpaceSharedActivitiesBackgroundPartDefinition f12273b;
    private final Resources f12274c;
    private final DefaultTimeFormatUtil f12275d;
    private final RedSpaceSharedActivitiesContentViewPartDefinition f12276e;

    private static RedSpaceSharedActivitiesPresencePartDefinition m12716b(InjectorLike injectorLike) {
        return new RedSpaceSharedActivitiesPresencePartDefinition(RedSpaceSharedActivitiesBackgroundPartDefinition.m12692a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), DefaultTimeFormatUtil.a(injectorLike), RedSpaceSharedActivitiesContentViewPartDefinition.m12696a(injectorLike));
    }

    public final Object m12718a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        CharSequence string;
        if (((PresenceActivitySharing) ((SharedActivity) obj)).b) {
            string = this.f12274c.getString(2131235774);
        } else {
            string = this.f12274c.getString(2131235776, new Object[]{this.f12275d.a(TimeFormatStyle.SHORTEST_RELATIVE_PAST_STYLE, r13.d)});
        }
        subParts.a(this.f12273b, null);
        RedSpaceSharedActivitiesContentViewPartDefinition redSpaceSharedActivitiesContentViewPartDefinition = this.f12276e;
        Props props = new Props();
        props.f12234a = this.f12274c.getString(2131235773);
        props = props;
        props.f12235b = string;
        Props props2 = props;
        props2.f12241h = this.f12274c.getColor(2131363129);
        props2 = props2;
        props2.f12237d = this.f12274c.getDrawable(2130839888);
        subParts.a(redSpaceSharedActivitiesContentViewPartDefinition, props2);
        return null;
    }

    public final boolean m12719a(Object obj) {
        SharedActivity sharedActivity = (SharedActivity) obj;
        return (sharedActivity instanceof PresenceActivitySharing) && sharedActivity.e();
    }

    @Inject
    private RedSpaceSharedActivitiesPresencePartDefinition(RedSpaceSharedActivitiesBackgroundPartDefinition redSpaceSharedActivitiesBackgroundPartDefinition, Resources resources, DefaultTimeFormatUtil defaultTimeFormatUtil, RedSpaceSharedActivitiesContentViewPartDefinition redSpaceSharedActivitiesContentViewPartDefinition) {
        this.f12276e = redSpaceSharedActivitiesContentViewPartDefinition;
        this.f12273b = redSpaceSharedActivitiesBackgroundPartDefinition;
        this.f12274c = resources;
        this.f12275d = defaultTimeFormatUtil;
    }

    public final ViewType<ContentView> m12717a() {
        return f12270a;
    }

    public static RedSpaceSharedActivitiesPresencePartDefinition m12715a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            RedSpaceSharedActivitiesPresencePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12272g) {
                RedSpaceSharedActivitiesPresencePartDefinition redSpaceSharedActivitiesPresencePartDefinition;
                if (a2 != null) {
                    redSpaceSharedActivitiesPresencePartDefinition = (RedSpaceSharedActivitiesPresencePartDefinition) a2.a(f12272g);
                } else {
                    redSpaceSharedActivitiesPresencePartDefinition = f12271f;
                }
                if (redSpaceSharedActivitiesPresencePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m12716b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12272g, b3);
                        } else {
                            f12271f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = redSpaceSharedActivitiesPresencePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
