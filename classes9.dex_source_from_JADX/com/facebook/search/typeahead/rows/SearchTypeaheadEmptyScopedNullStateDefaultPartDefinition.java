package com.facebook.search.typeahead.rows;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.widget.text.ImageWithTextView;
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
import com.facebook.search.api.GraphSearchQuery.ScopedEntityType;
import com.facebook.search.model.EmptyScopedNullStateTypeaheadUnit;
import javax.inject.Inject;

@ContextScoped
/* compiled from: videoChannelId */
public class SearchTypeaheadEmptyScopedNullStateDefaultPartDefinition extends MultiRowSinglePartDefinition<EmptyScopedNullStateTypeaheadUnit, String, AnyEnvironment, ImageWithTextView> {
    public static final ViewType f472a = ViewType.a(2130904625);
    private static SearchTypeaheadEmptyScopedNullStateDefaultPartDefinition f473c;
    private static final Object f474d = new Object();
    private final Context f475b;

    /* compiled from: videoChannelId */
    /* synthetic */ class C00461 {
        static final /* synthetic */ int[] f471a = new int[ScopedEntityType.values().length];

        static {
            try {
                f471a[ScopedEntityType.GROUP.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f471a[ScopedEntityType.USER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f471a[ScopedEntityType.PAGE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    private static SearchTypeaheadEmptyScopedNullStateDefaultPartDefinition m578b(InjectorLike injectorLike) {
        return new SearchTypeaheadEmptyScopedNullStateDefaultPartDefinition((Context) injectorLike.getInstance(Context.class));
    }

    public final Object m580a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        String str = "";
        switch (C00461.f471a[((EmptyScopedNullStateTypeaheadUnit) obj).a.ordinal()]) {
            case 1:
                return this.f475b.getResources().getString(2131237410);
            case 2:
                return this.f475b.getResources().getString(2131237411);
            case 3:
                return this.f475b.getResources().getString(2131237412);
            default:
                return str;
        }
    }

    public final /* bridge */ /* synthetic */ void m581a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1568305046);
        ((ImageWithTextView) view).setText((String) obj2);
        Logger.a(8, EntryType.MARK_POP, 1221656606, a);
    }

    @Inject
    public SearchTypeaheadEmptyScopedNullStateDefaultPartDefinition(Context context) {
        this.f475b = context;
    }

    public final ViewType m579a() {
        return f472a;
    }

    public final boolean m582a(Object obj) {
        return true;
    }

    public static SearchTypeaheadEmptyScopedNullStateDefaultPartDefinition m577a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchTypeaheadEmptyScopedNullStateDefaultPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f474d) {
                SearchTypeaheadEmptyScopedNullStateDefaultPartDefinition searchTypeaheadEmptyScopedNullStateDefaultPartDefinition;
                if (a2 != null) {
                    searchTypeaheadEmptyScopedNullStateDefaultPartDefinition = (SearchTypeaheadEmptyScopedNullStateDefaultPartDefinition) a2.a(f474d);
                } else {
                    searchTypeaheadEmptyScopedNullStateDefaultPartDefinition = f473c;
                }
                if (searchTypeaheadEmptyScopedNullStateDefaultPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m578b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f474d, b3);
                        } else {
                            f473c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchTypeaheadEmptyScopedNullStateDefaultPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
