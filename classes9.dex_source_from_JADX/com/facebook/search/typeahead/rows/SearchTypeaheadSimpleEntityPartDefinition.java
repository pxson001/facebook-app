package com.facebook.search.typeahead.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
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
import com.facebook.multirow.parts.ContentViewThumbnailUriPartDefinition;
import com.facebook.multirow.parts.ContentViewTitlePartDefinition;
import com.facebook.search.model.EntityTypeaheadUnit;
import com.facebook.ultralight.Inject;
import com.facebook.widget.CustomFrameLayout;

@ContextScoped
/* compiled from: vaultImageGet */
public class SearchTypeaheadSimpleEntityPartDefinition extends MultiRowSinglePartDefinition<EntityTypeaheadUnit, Void, AnyEnvironment, CustomFrameLayout> {
    public static final ViewType<CustomFrameLayout> f617a = ViewType.a(2130907102);
    private static SearchTypeaheadSimpleEntityPartDefinition f618d;
    private static final Object f619e = new Object();
    private final ContentViewThumbnailUriPartDefinition f620b;
    private final ContentViewTitlePartDefinition f621c;

    private static SearchTypeaheadSimpleEntityPartDefinition m712b(InjectorLike injectorLike) {
        return new SearchTypeaheadSimpleEntityPartDefinition(ContentViewThumbnailUriPartDefinition.a(injectorLike), ContentViewTitlePartDefinition.a(injectorLike));
    }

    public final Object m714a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        EntityTypeaheadUnit entityTypeaheadUnit = (EntityTypeaheadUnit) obj;
        subParts.a(2131567451, this.f621c, entityTypeaheadUnit.b);
        subParts.a(2131567451, this.f620b, entityTypeaheadUnit.d);
        return null;
    }

    @Inject
    private SearchTypeaheadSimpleEntityPartDefinition(ContentViewThumbnailUriPartDefinition contentViewThumbnailUriPartDefinition, ContentViewTitlePartDefinition contentViewTitlePartDefinition) {
        this.f620b = contentViewThumbnailUriPartDefinition;
        this.f621c = contentViewTitlePartDefinition;
    }

    public final ViewType<CustomFrameLayout> m713a() {
        return f617a;
    }

    public final boolean m715a(Object obj) {
        return true;
    }

    public static SearchTypeaheadSimpleEntityPartDefinition m711a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchTypeaheadSimpleEntityPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f619e) {
                SearchTypeaheadSimpleEntityPartDefinition searchTypeaheadSimpleEntityPartDefinition;
                if (a2 != null) {
                    searchTypeaheadSimpleEntityPartDefinition = (SearchTypeaheadSimpleEntityPartDefinition) a2.a(f619e);
                } else {
                    searchTypeaheadSimpleEntityPartDefinition = f618d;
                }
                if (searchTypeaheadSimpleEntityPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m712b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f619e, b3);
                        } else {
                            f618d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchTypeaheadSimpleEntityPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
