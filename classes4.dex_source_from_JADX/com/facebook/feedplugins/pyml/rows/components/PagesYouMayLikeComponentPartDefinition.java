package com.facebook.feedplugins.pyml.rows.components;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.feed.ComponentPartDefinition;
import com.facebook.components.feed.ComponentPartHelper;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feed.rows.core.analytics.HasIsAsync;
import com.facebook.feed.rows.qe.AndroidComponentsExperimentHelper;
import com.facebook.feed.rows.qe.ExperimentsForMultiRowQEModule;
import com.facebook.feed.rows.sections.components.FeedBackgroundStylerComponentWrapper;
import com.facebook.feed.rows.sections.hscrollrecyclerview.FeedUnitAndChangePageListener;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.feed.rows.styling.DefaultPaddingStyleResolver;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.graphql.model.GraphQLPYMLWithLargeImageFeedUnit;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.inject.Inject;

@ContextScoped
/* compiled from: old_language */
public class PagesYouMayLikeComponentPartDefinition<E extends HasContext & HasFeedListType & HasIsAsync & HasMenuButtonProvider & HasPersistentState & HasPositionInformation & HasPrefetcher & HasRowKey> extends ComponentPartDefinition<FeedUnitAndChangePageListener<GraphQLPYMLWithLargeImageFeedUnit>, E> {
    private static PagesYouMayLikeComponentPartDefinition f6268g;
    private static final Object f6269h = new Object();
    private final PagesYouMayLikeComponent f6270c;
    private final FeedBackgroundStylerComponentWrapper f6271d;
    private final AndroidComponentsExperimentHelper f6272e;
    private PaddingStyle f6273f;

    private static PagesYouMayLikeComponentPartDefinition m6721b(InjectorLike injectorLike) {
        return new PagesYouMayLikeComponentPartDefinition((Context) injectorLike.getInstance(Context.class), PagesYouMayLikeComponent.m6728a(injectorLike), FeedBackgroundStylerComponentWrapper.b(injectorLike), DefaultPaddingStyleResolver.a(injectorLike), AndroidComponentsExperimentHelper.a(injectorLike));
    }

    public final CacheableEntity m6727b(Object obj) {
        return ComponentPartHelper.a(((FeedUnitAndChangePageListener) obj).f6289a);
    }

    @Inject
    public PagesYouMayLikeComponentPartDefinition(Context context, PagesYouMayLikeComponent pagesYouMayLikeComponent, FeedBackgroundStylerComponentWrapper feedBackgroundStylerComponentWrapper, DefaultPaddingStyleResolver defaultPaddingStyleResolver, AndroidComponentsExperimentHelper androidComponentsExperimentHelper) {
        super(context);
        this.f6270c = pagesYouMayLikeComponent;
        this.f6271d = feedBackgroundStylerComponentWrapper;
        this.f6272e = androidComponentsExperimentHelper;
        Builder c = Builder.c();
        c.b = (-defaultPaddingStyleResolver.c()) - defaultPaddingStyleResolver.d();
        this.f6273f = c.i();
    }

    public static PagesYouMayLikeComponentPartDefinition m6720a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PagesYouMayLikeComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f6269h) {
                PagesYouMayLikeComponentPartDefinition pagesYouMayLikeComponentPartDefinition;
                if (a2 != null) {
                    pagesYouMayLikeComponentPartDefinition = (PagesYouMayLikeComponentPartDefinition) a2.a(f6269h);
                } else {
                    pagesYouMayLikeComponentPartDefinition = f6268g;
                }
                if (pagesYouMayLikeComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m6721b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f6269h, b3);
                        } else {
                            f6268g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pagesYouMayLikeComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private Component<?> m6719a(ComponentContext componentContext, FeedUnitAndChangePageListener<GraphQLPYMLWithLargeImageFeedUnit> feedUnitAndChangePageListener, E e) {
        return this.f6271d.a(componentContext, (HasPositionInformation) e, new StylingData(feedUnitAndChangePageListener.f6289a, this.f6273f, Position.TOP), this.f6270c.m6730a(componentContext).a(feedUnitAndChangePageListener).a((HasFeedListType) e).a(true).d());
    }

    public final boolean m6726a(Object obj) {
        AndroidComponentsExperimentHelper androidComponentsExperimentHelper = this.f6272e;
        boolean z = false;
        if (androidComponentsExperimentHelper.j == null) {
            androidComponentsExperimentHelper.j = Boolean.valueOf(AndroidComponentsExperimentHelper.a(androidComponentsExperimentHelper.a.a(ExperimentsForMultiRowQEModule.g, 0)));
        }
        if (androidComponentsExperimentHelper.j.booleanValue() || androidComponentsExperimentHelper.s()) {
            z = true;
        }
        return z;
    }

    public final boolean m6724a(E e) {
        return false;
    }
}
