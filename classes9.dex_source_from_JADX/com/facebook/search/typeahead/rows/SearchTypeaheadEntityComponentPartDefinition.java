package com.facebook.search.typeahead.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.feed.ComponentPartDefinition;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.analytics.HasIsAsync;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.search.model.EntityTypeaheadUnit;
import com.facebook.search.typeahead.rows.SearchTypeaheadEntityComponent.Builder;
import com.facebook.search.typeahead.rows.SearchTypeaheadEntityComponent.State;
import com.facebook.ultralight.Inject;

@ContextScoped
/* compiled from: via_list */
public class SearchTypeaheadEntityComponentPartDefinition<E extends HasContext & HasIsAsync & HasPersistentState> extends ComponentPartDefinition<EntityTypeaheadUnit, E> {
    private static SearchTypeaheadEntityComponentPartDefinition f496d;
    private static final Object f497e = new Object();
    private final SearchTypeaheadEntityComponent f498c;

    private static SearchTypeaheadEntityComponentPartDefinition m603b(InjectorLike injectorLike) {
        return new SearchTypeaheadEntityComponentPartDefinition((Context) injectorLike.getInstance(Context.class), SearchTypeaheadEntityComponent.m597a(injectorLike));
    }

    @Inject
    private SearchTypeaheadEntityComponentPartDefinition(Context context, SearchTypeaheadEntityComponent searchTypeaheadEntityComponent) {
        super(context);
        this.f498c = searchTypeaheadEntityComponent;
    }

    public final boolean m606a(Object obj) {
        return true;
    }

    private Component<?> m601a(ComponentContext componentContext, EntityTypeaheadUnit entityTypeaheadUnit) {
        State state = new State(this.f498c);
        Builder builder = (Builder) SearchTypeaheadEntityComponent.f492b.a();
        if (builder == null) {
            builder = new Builder();
        }
        Builder.m594a(builder, componentContext, 0, state);
        Builder builder2 = builder;
        builder2.f486a.f490a = entityTypeaheadUnit;
        builder2.f489d.set(0);
        return builder2.d();
    }

    public final CacheableEntity m607b(Object obj) {
        return null;
    }

    public static SearchTypeaheadEntityComponentPartDefinition m602a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchTypeaheadEntityComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f497e) {
                SearchTypeaheadEntityComponentPartDefinition searchTypeaheadEntityComponentPartDefinition;
                if (a2 != null) {
                    searchTypeaheadEntityComponentPartDefinition = (SearchTypeaheadEntityComponentPartDefinition) a2.a(f497e);
                } else {
                    searchTypeaheadEntityComponentPartDefinition = f496d;
                }
                if (searchTypeaheadEntityComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m603b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f497e, b3);
                        } else {
                            f496d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchTypeaheadEntityComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
