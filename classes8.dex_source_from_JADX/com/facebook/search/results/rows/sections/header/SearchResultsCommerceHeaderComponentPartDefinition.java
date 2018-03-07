package com.facebook.search.results.rows.sections.header;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.feed.ComponentPartDefinition;
import com.facebook.components.glyph.GlyphColorizerDrawableReference;
import com.facebook.components.reference.Reference;
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
import com.facebook.search.results.rows.sections.header.SearchResultsCommerceHeaderComponent.State;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: ProfilePhoto */
public class SearchResultsCommerceHeaderComponentPartDefinition<E extends HasContext & HasIsAsync & HasPersistentState & HasPositionInformation> extends ComponentPartDefinition<HeaderProps, E> {
    private static final StylingData f24363f;
    private static SearchResultsCommerceHeaderComponentPartDefinition f24364g;
    private static final Object f24365h = new Object();
    private final SearchResultsCommerceHeaderComponent f24366c;
    private final GlyphColorizerDrawableReference f24367d;
    private final FeedBackgroundStylerComponentWrapper f24368e;

    /* compiled from: ProfilePhoto */
    public class HeaderProps {
        public final String f24360a;
        public final String f24361b;
        public final Boolean f24362c;

        public HeaderProps(String str, @Nullable String str2, @Nullable Boolean bool) {
            this.f24360a = str;
            this.f24361b = str2;
            this.f24362c = bool;
        }
    }

    private static SearchResultsCommerceHeaderComponentPartDefinition m27856b(InjectorLike injectorLike) {
        return new SearchResultsCommerceHeaderComponentPartDefinition((Context) injectorLike.getInstance(Context.class), SearchResultsCommerceHeaderComponent.m27850a(injectorLike), GlyphColorizerDrawableReference.a(injectorLike), FeedBackgroundStylerComponentWrapper.b(injectorLike));
    }

    static {
        Builder a = Builder.a();
        a.b = 0.0f;
        f24363f = new StylingData(null, a.i(), Position.TOP);
    }

    public static SearchResultsCommerceHeaderComponentPartDefinition m27855a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsCommerceHeaderComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24365h) {
                SearchResultsCommerceHeaderComponentPartDefinition searchResultsCommerceHeaderComponentPartDefinition;
                if (a2 != null) {
                    searchResultsCommerceHeaderComponentPartDefinition = (SearchResultsCommerceHeaderComponentPartDefinition) a2.a(f24365h);
                } else {
                    searchResultsCommerceHeaderComponentPartDefinition = f24364g;
                }
                if (searchResultsCommerceHeaderComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27856b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24365h, b3);
                        } else {
                            f24364g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsCommerceHeaderComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public SearchResultsCommerceHeaderComponentPartDefinition(Context context, SearchResultsCommerceHeaderComponent searchResultsCommerceHeaderComponent, GlyphColorizerDrawableReference glyphColorizerDrawableReference, FeedBackgroundStylerComponentWrapper feedBackgroundStylerComponentWrapper) {
        super(context);
        this.f24366c = searchResultsCommerceHeaderComponent;
        this.f24367d = glyphColorizerDrawableReference;
        this.f24368e = feedBackgroundStylerComponentWrapper;
    }

    public final boolean m27859a(Object obj) {
        return true;
    }

    private Component<?> m27854a(ComponentContext componentContext, HeaderProps headerProps, E e) {
        Reference b = headerProps.f24362c.booleanValue() ? this.f24367d.a(componentContext).h(2130838154).i(-12146688).b() : null;
        State state = new State(this.f24366c);
        SearchResultsCommerceHeaderComponent.Builder builder = (SearchResultsCommerceHeaderComponent.Builder) SearchResultsCommerceHeaderComponent.f24356b.a();
        if (builder == null) {
            builder = new SearchResultsCommerceHeaderComponent.Builder();
        }
        SearchResultsCommerceHeaderComponent.Builder.m27847a(builder, componentContext, 0, state);
        SearchResultsCommerceHeaderComponent.Builder builder2 = builder;
        builder2.f24348a.f24352a = headerProps.f24360a;
        builder2.f24351d.set(0);
        builder2 = builder2;
        builder2.f24348a.f24353b = headerProps.f24361b;
        builder2 = builder2;
        builder2.f24348a.f24354c = b;
        return this.f24368e.a(componentContext, (HasPositionInformation) e, f24363f, builder2.d());
    }

    public final CacheableEntity m27860b(Object obj) {
        return null;
    }
}
