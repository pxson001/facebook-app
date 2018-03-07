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
import com.facebook.search.api.GraphSearchQuery.ScopedEntityType;
import com.facebook.search.model.EmptyScopedNullStateTypeaheadUnit;
import com.facebook.search.typeahead.rows.SearchTypeaheadNUXComponent.Builder;
import com.facebook.search.typeahead.rows.SearchTypeaheadNUXComponent.State;
import javax.inject.Inject;

@ContextScoped
/* compiled from: video/3gpp2 */
public class SearchTypeaheadEmptyScopedNullStateVideoPartDefinition<E extends HasContext & HasIsAsync & HasPersistentState> extends ComponentPartDefinition<EmptyScopedNullStateTypeaheadUnit, E> {
    private static SearchTypeaheadEmptyScopedNullStateVideoPartDefinition f480d;
    private static final Object f481e = new Object();
    private final SearchTypeaheadNUXComponent f482c;

    private static SearchTypeaheadEmptyScopedNullStateVideoPartDefinition m589b(InjectorLike injectorLike) {
        return new SearchTypeaheadEmptyScopedNullStateVideoPartDefinition((Context) injectorLike.getInstance(Context.class), SearchTypeaheadNUXComponent.m657a(injectorLike));
    }

    public final boolean m592a(Object obj) {
        return ((EmptyScopedNullStateTypeaheadUnit) obj).a == ScopedEntityType.VIDEO;
    }

    @Inject
    public SearchTypeaheadEmptyScopedNullStateVideoPartDefinition(Context context, SearchTypeaheadNUXComponent searchTypeaheadNUXComponent) {
        super(context);
        this.f482c = searchTypeaheadNUXComponent;
    }

    private Component<?> m587a(ComponentContext componentContext) {
        State state = new State(this.f482c);
        Builder builder = (Builder) SearchTypeaheadNUXComponent.f570b.a();
        if (builder == null) {
            builder = new Builder();
        }
        Builder.m654a(builder, componentContext, 0, state);
        Builder builder2 = builder;
        builder2.f563a.f567a = builder2.b(2131237407);
        builder2.f566d.set(0);
        builder2 = builder2;
        builder2.f563a.f568b = builder2.b(2131237413);
        builder2.f566d.set(1);
        return builder2.d();
    }

    public final CacheableEntity m593b(Object obj) {
        return null;
    }

    public static SearchTypeaheadEmptyScopedNullStateVideoPartDefinition m588a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchTypeaheadEmptyScopedNullStateVideoPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f481e) {
                SearchTypeaheadEmptyScopedNullStateVideoPartDefinition searchTypeaheadEmptyScopedNullStateVideoPartDefinition;
                if (a2 != null) {
                    searchTypeaheadEmptyScopedNullStateVideoPartDefinition = (SearchTypeaheadEmptyScopedNullStateVideoPartDefinition) a2.a(f481e);
                } else {
                    searchTypeaheadEmptyScopedNullStateVideoPartDefinition = f480d;
                }
                if (searchTypeaheadEmptyScopedNullStateVideoPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m589b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f481e, b3);
                        } else {
                            f480d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchTypeaheadEmptyScopedNullStateVideoPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
