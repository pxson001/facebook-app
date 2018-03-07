package com.facebook.timeline.feed.parts;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.widget.text.BadgeTextView;
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
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.timeline.units.model.TimelineSectionData.SectionType;
import com.facebook.timeline.units.model.TimelineSectionData.TimelinePostsLabel;
import javax.inject.Inject;

@ContextScoped
/* compiled from: friends_nearby_dashboard_search_type_during_session */
public class TimelinePostsLabelPartDefinition extends MultiRowSinglePartDefinition<TimelinePostsLabel, Void, AnyEnvironment, BadgeTextView> {
    public static final ViewType f11198a = new C16231();
    private static TimelinePostsLabelPartDefinition f11199d;
    private static final Object f11200e = new Object();
    private final Resources f11201b;
    private final TextPartDefinition f11202c;

    /* compiled from: friends_nearby_dashboard_search_type_during_session */
    final class C16231 extends ViewType {
        C16231() {
        }

        public final View m11338a(Context context) {
            return LayoutInflater.from(context).inflate(2130907475, null);
        }
    }

    private static TimelinePostsLabelPartDefinition m11340b(InjectorLike injectorLike) {
        return new TimelinePostsLabelPartDefinition(ResourcesMethodAutoProvider.a(injectorLike), TextPartDefinition.a(injectorLike));
    }

    public final Object m11342a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f11202c, ((TimelinePostsLabel) obj).f12784a == SectionType.RECENT_SECTION ? this.f11201b.getString(2131234892) : this.f11201b.getString(2131234893));
        return null;
    }

    public final boolean m11343a(Object obj) {
        TimelinePostsLabel timelinePostsLabel = (TimelinePostsLabel) obj;
        return timelinePostsLabel.f12784a == SectionType.UNSEEN_SECTION || timelinePostsLabel.f12784a == SectionType.RECENT_SECTION;
    }

    @Inject
    public TimelinePostsLabelPartDefinition(Resources resources, TextPartDefinition textPartDefinition) {
        this.f11201b = resources;
        this.f11202c = textPartDefinition;
    }

    public final ViewType m11341a() {
        return f11198a;
    }

    public static TimelinePostsLabelPartDefinition m11339a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            TimelinePostsLabelPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f11200e) {
                TimelinePostsLabelPartDefinition timelinePostsLabelPartDefinition;
                if (a2 != null) {
                    timelinePostsLabelPartDefinition = (TimelinePostsLabelPartDefinition) a2.a(f11200e);
                } else {
                    timelinePostsLabelPartDefinition = f11199d;
                }
                if (timelinePostsLabelPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m11340b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f11200e, b3);
                        } else {
                            f11199d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = timelinePostsLabelPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
