package com.facebook.search.typeahead.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.analytics.HasIsAsync;
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
import com.facebook.search.model.EmptyScopedNullStateTypeaheadUnit;
import javax.inject.Inject;

@ContextScoped
/* compiled from: video/h263 */
public class SearchTypeaheadEmptyScopedNullStateSelectorPartDefinition<E extends HasContext & HasIsAsync & HasPersistentState> extends BaseMultiRowGroupPartDefinition<EmptyScopedNullStateTypeaheadUnit, Void, E> {
    private static SearchTypeaheadEmptyScopedNullStateSelectorPartDefinition f476c;
    private static final Object f477d = new Object();
    private final SearchTypeaheadEmptyScopedNullStateVideoPartDefinition<E> f478a;
    private final SearchTypeaheadEmptyScopedNullStateDefaultPartDefinition f479b;

    private static SearchTypeaheadEmptyScopedNullStateSelectorPartDefinition m584b(InjectorLike injectorLike) {
        return new SearchTypeaheadEmptyScopedNullStateSelectorPartDefinition(SearchTypeaheadEmptyScopedNullStateVideoPartDefinition.m588a(injectorLike), SearchTypeaheadEmptyScopedNullStateDefaultPartDefinition.m577a(injectorLike));
    }

    public final Object m585a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        EmptyScopedNullStateTypeaheadUnit emptyScopedNullStateTypeaheadUnit = (EmptyScopedNullStateTypeaheadUnit) obj;
        SubPartsSelector.a(baseMultiRowSubParts, this.f478a, emptyScopedNullStateTypeaheadUnit).a(this.f479b, emptyScopedNullStateTypeaheadUnit);
        return null;
    }

    @Inject
    public SearchTypeaheadEmptyScopedNullStateSelectorPartDefinition(SearchTypeaheadEmptyScopedNullStateVideoPartDefinition searchTypeaheadEmptyScopedNullStateVideoPartDefinition, SearchTypeaheadEmptyScopedNullStateDefaultPartDefinition searchTypeaheadEmptyScopedNullStateDefaultPartDefinition) {
        this.f478a = searchTypeaheadEmptyScopedNullStateVideoPartDefinition;
        this.f479b = searchTypeaheadEmptyScopedNullStateDefaultPartDefinition;
    }

    public final boolean m586a(Object obj) {
        return true;
    }

    public static SearchTypeaheadEmptyScopedNullStateSelectorPartDefinition m583a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchTypeaheadEmptyScopedNullStateSelectorPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f477d) {
                SearchTypeaheadEmptyScopedNullStateSelectorPartDefinition searchTypeaheadEmptyScopedNullStateSelectorPartDefinition;
                if (a2 != null) {
                    searchTypeaheadEmptyScopedNullStateSelectorPartDefinition = (SearchTypeaheadEmptyScopedNullStateSelectorPartDefinition) a2.a(f477d);
                } else {
                    searchTypeaheadEmptyScopedNullStateSelectorPartDefinition = f476c;
                }
                if (searchTypeaheadEmptyScopedNullStateSelectorPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m584b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f477d, b3);
                        } else {
                            f476c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchTypeaheadEmptyScopedNullStateSelectorPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
