package com.facebook.search.results.rows.sections.header;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.feed.ComponentPartDefinition;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.analytics.HasIsAsync;
import com.facebook.feed.rows.sections.components.FeedBackgroundStylerComponentWrapper;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.search.results.rows.SearchBackgroundPartDefinition;
import com.facebook.search.results.rows.sections.header.SearchResultsHeaderComponent.State;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: PresenterUtils.setTextAnnotations */
public class SearchResultsHeaderComponentPartDefinition<E extends HasContext & HasIsAsync & HasPersistentState & HasPositionInformation> extends ComponentPartDefinition<HeaderProps, E> {
    private static final StylingData f24387c;
    private static SearchResultsHeaderComponentPartDefinition f24388f;
    private static final Object f24389g = new Object();
    private final FeedBackgroundStylerComponentWrapper f24390d;
    private final SearchResultsHeaderComponent f24391e;

    /* compiled from: PresenterUtils.setTextAnnotations */
    public class HeaderProps {
        public final String f24385a;
        public final String f24386b;

        public HeaderProps(String str, @Nullable String str2) {
            this.f24385a = str;
            this.f24386b = str2;
        }
    }

    private static SearchResultsHeaderComponentPartDefinition m27872b(InjectorLike injectorLike) {
        return new SearchResultsHeaderComponentPartDefinition((Context) injectorLike.getInstance(Context.class), FeedBackgroundStylerComponentWrapper.b(injectorLike), SearchResultsHeaderComponent.m27866a(injectorLike));
    }

    static {
        Builder a = Builder.a();
        a.b = 2.0f;
        f24387c = new StylingData(null, a.i(), Position.TOP);
    }

    @Inject
    public SearchResultsHeaderComponentPartDefinition(Context context, FeedBackgroundStylerComponentWrapper feedBackgroundStylerComponentWrapper, SearchResultsHeaderComponent searchResultsHeaderComponent) {
        super(context);
        this.f24390d = feedBackgroundStylerComponentWrapper;
        this.f24391e = searchResultsHeaderComponent;
    }

    public static SearchResultsHeaderComponentPartDefinition m27871a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsHeaderComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24389g) {
                SearchResultsHeaderComponentPartDefinition searchResultsHeaderComponentPartDefinition;
                if (a2 != null) {
                    searchResultsHeaderComponentPartDefinition = (SearchResultsHeaderComponentPartDefinition) a2.a(f24389g);
                } else {
                    searchResultsHeaderComponentPartDefinition = f24388f;
                }
                if (searchResultsHeaderComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27872b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24389g, b3);
                        } else {
                            f24388f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsHeaderComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final boolean m27875a(Object obj) {
        return true;
    }

    private Component<?> m27870a(ComponentContext componentContext, HeaderProps headerProps, E e) {
        State state = new State(this.f24391e);
        SearchResultsHeaderComponent.Builder builder = (SearchResultsHeaderComponent.Builder) SearchResultsHeaderComponent.f24381b.a();
        if (builder == null) {
            builder = new SearchResultsHeaderComponent.Builder();
        }
        SearchResultsHeaderComponent.Builder.m27863a(builder, componentContext, 0, state);
        SearchResultsHeaderComponent.Builder builder2 = builder;
        builder2.f24374a.f24378a = headerProps.f24385a;
        builder2.f24377d.set(0);
        builder2 = builder2;
        builder2.f24374a.f24379b = headerProps.f24386b;
        return this.f24390d.a(componentContext, (HasPositionInformation) e, SearchBackgroundPartDefinition.m27223a((HasContext) e, f24387c), builder2.d());
    }

    public final CacheableEntity m27876b(Object obj) {
        return null;
    }
}
