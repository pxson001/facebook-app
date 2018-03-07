package com.facebook.search.results.rows.sections.newscontext;

import android.content.Context;
import android.text.Layout.Alignment;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.feed.ComponentPartDefinition;
import com.facebook.components.widget.Text;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.analytics.HasIsAsync;
import com.facebook.feed.rows.sections.components.FeedBackgroundStylerComponentWrapper;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.search.abtest.ExperimentsForSearchAbTestModule;
import javax.inject.Inject;

@ContextScoped
/* compiled from: PageCallToActionContactUsFormSubmitMutation */
public class SearchResultsNewsContextSummaryComponentPartDefinition<E extends HasContext & HasIsAsync & HasPersistentState & HasPositionInformation> extends ComponentPartDefinition<String, E> {
    private static final PaddingStyle f24657c;
    private static SearchResultsNewsContextSummaryComponentPartDefinition f24658f;
    private static final Object f24659g = new Object();
    private final QeAccessor f24660d;
    private final FeedBackgroundStylerComponentWrapper f24661e;

    private static SearchResultsNewsContextSummaryComponentPartDefinition m28072b(InjectorLike injectorLike) {
        return new SearchResultsNewsContextSummaryComponentPartDefinition((Context) injectorLike.getInstance(Context.class), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), FeedBackgroundStylerComponentWrapper.b(injectorLike));
    }

    static {
        Builder a = Builder.a();
        a.b = -4.0f;
        a = a;
        a.c = 0.0f;
        f24657c = a.i();
    }

    @Inject
    public SearchResultsNewsContextSummaryComponentPartDefinition(Context context, QeAccessor qeAccessor, FeedBackgroundStylerComponentWrapper feedBackgroundStylerComponentWrapper) {
        super(context);
        this.f24660d = qeAccessor;
        this.f24661e = feedBackgroundStylerComponentWrapper;
    }

    public final boolean m28077a(Object obj) {
        return true;
    }

    public static SearchResultsNewsContextSummaryComponentPartDefinition m28071a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsNewsContextSummaryComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24659g) {
                SearchResultsNewsContextSummaryComponentPartDefinition searchResultsNewsContextSummaryComponentPartDefinition;
                if (a2 != null) {
                    searchResultsNewsContextSummaryComponentPartDefinition = (SearchResultsNewsContextSummaryComponentPartDefinition) a2.a(f24659g);
                } else {
                    searchResultsNewsContextSummaryComponentPartDefinition = f24658f;
                }
                if (searchResultsNewsContextSummaryComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28072b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24659g, b3);
                        } else {
                            f24658f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsNewsContextSummaryComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private Component<?> m28070a(ComponentContext componentContext, String str, E e) {
        return this.f24661e.a(componentContext, (HasPositionInformation) e, new StylingData(null, f24657c, ((HasPositionInformation) e).h() instanceof SearchResultsNewsContextAttributionPartDefinition ? Position.MIDDLE : Position.BOTTOM), Text.a(componentContext).a(str).o(2131427402).l(2131361973).a(Alignment.ALIGN_CENTER).d(1.1f).d());
    }

    public final CacheableEntity m28078b(Object obj) {
        return null;
    }

    public final boolean m28075a(E e) {
        return this.f24660d.a(ExperimentsForSearchAbTestModule.an, false);
    }
}
