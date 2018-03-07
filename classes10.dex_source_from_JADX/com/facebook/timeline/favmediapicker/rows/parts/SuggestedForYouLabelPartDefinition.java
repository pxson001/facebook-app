package com.facebook.timeline.favmediapicker.rows.parts;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.ViewType;
import com.facebook.resources.ui.FbTextView;
import com.facebook.timeline.favmediapicker.models.SuggestedForYouLabel;
import javax.inject.Inject;

@ContextScoped
/* compiled from: friends_nearby_self_view_section */
public class SuggestedForYouLabelPartDefinition extends MultiRowSinglePartDefinition<SuggestedForYouLabel, Void, AnyEnvironment, FbTextView> {
    public static final ViewType<FbTextView> f11089a = ViewType.a(2130907315);
    private static SuggestedForYouLabelPartDefinition f11090c;
    private static final Object f11091d = new Object();
    public final AllCapsTransformationMethod f11092b;

    private static SuggestedForYouLabelPartDefinition m11255b(InjectorLike injectorLike) {
        return new SuggestedForYouLabelPartDefinition(AllCapsTransformationMethod.b(injectorLike));
    }

    public final /* bridge */ /* synthetic */ void m11257a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -548410086);
        ((FbTextView) view).setTransformationMethod(this.f11092b);
        Logger.a(8, EntryType.MARK_POP, -2011583583, a);
    }

    @Inject
    public SuggestedForYouLabelPartDefinition(AllCapsTransformationMethod allCapsTransformationMethod) {
        this.f11092b = allCapsTransformationMethod;
    }

    public final ViewType<FbTextView> m11256a() {
        return f11089a;
    }

    public final boolean m11258a(Object obj) {
        return true;
    }

    public static SuggestedForYouLabelPartDefinition m11254a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SuggestedForYouLabelPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f11091d) {
                SuggestedForYouLabelPartDefinition suggestedForYouLabelPartDefinition;
                if (a2 != null) {
                    suggestedForYouLabelPartDefinition = (SuggestedForYouLabelPartDefinition) a2.a(f11091d);
                } else {
                    suggestedForYouLabelPartDefinition = f11090c;
                }
                if (suggestedForYouLabelPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m11255b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f11091d, b3);
                        } else {
                            f11090c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = suggestedForYouLabelPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
