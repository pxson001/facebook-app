package com.facebook.timeline.pymk.rows;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
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
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.timeline.protiles.rows.ProtilesHeaderPartDefinition;
import com.facebook.timeline.protiles.views.ProtilesHeaderView;
import com.facebook.timeline.pymk.PeopleYouMayKnowModel;
import javax.inject.Inject;

@ContextScoped
/* compiled from: faceweb_help_center */
public class PeopleYouMayKnowHeaderPartDefinition extends MultiRowSinglePartDefinition<PeopleYouMayKnowModel, Drawable, AnyEnvironment, ProtilesHeaderView> {
    private static PeopleYouMayKnowHeaderPartDefinition f12544c;
    private static final Object f12545d = new Object();
    private final TextPartDefinition f12546a;
    private final Resources f12547b;

    private static PeopleYouMayKnowHeaderPartDefinition m12533b(InjectorLike injectorLike) {
        return new PeopleYouMayKnowHeaderPartDefinition(TextPartDefinition.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike));
    }

    public final /* bridge */ /* synthetic */ void m12536a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1040889535);
        ProtilesHeaderView protilesHeaderView = (ProtilesHeaderView) view;
        protilesHeaderView.setDrawable((Drawable) obj2);
        protilesHeaderView.setFocusable(true);
        Logger.a(8, EntryType.MARK_POP, 1278204699, a);
    }

    @Inject
    public PeopleYouMayKnowHeaderPartDefinition(TextPartDefinition textPartDefinition, Resources resources) {
        this.f12546a = textPartDefinition;
        this.f12547b = resources;
    }

    public final boolean m12537a(Object obj) {
        return true;
    }

    public final ViewType<ProtilesHeaderView> m12534a() {
        return ProtilesHeaderPartDefinition.f12251a;
    }

    public final Object m12535a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(2131566443, this.f12546a, this.f12547b.getString(2131233210));
        return this.f12547b.getDrawable(2130842576);
    }

    public static PeopleYouMayKnowHeaderPartDefinition m12532a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PeopleYouMayKnowHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12545d) {
                PeopleYouMayKnowHeaderPartDefinition peopleYouMayKnowHeaderPartDefinition;
                if (a2 != null) {
                    peopleYouMayKnowHeaderPartDefinition = (PeopleYouMayKnowHeaderPartDefinition) a2.a(f12545d);
                } else {
                    peopleYouMayKnowHeaderPartDefinition = f12544c;
                }
                if (peopleYouMayKnowHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m12533b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12545d, b3);
                        } else {
                            f12544c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = peopleYouMayKnowHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
