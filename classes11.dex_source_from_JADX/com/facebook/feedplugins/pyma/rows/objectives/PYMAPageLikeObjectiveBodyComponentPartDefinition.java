package com.facebook.feedplugins.pyma.rows.objectives;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.feed.ComponentPartDefinition;
import com.facebook.components.feed.ComponentPartHelper;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.analytics.HasIsAsync;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.qe.ExperimentsForMultiRowQEModule;
import com.facebook.feed.rows.sections.components.FeedBackgroundStylerComponentWrapper;
import com.facebook.feed.rows.sections.hscrollrecyclerview.FeedUnitAndChangePageListener;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.DefaultPaddingStyleResolver;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.feedplugins.pyma.PYMADataModelHelper;
import com.facebook.feedplugins.pyml.rows.components.PagesYouMayLikeComponent;
import com.facebook.graphql.model.GraphQLPagesYouMayAdvertiseFeedUnit;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;

@ContextScoped
/* compiled from: collection_table_item_image_size */
public class PYMAPageLikeObjectiveBodyComponentPartDefinition<E extends HasContext & HasFeedListType & HasIsAsync & HasPersistentState & HasPositionInformation> extends ComponentPartDefinition<FeedProps<GraphQLPagesYouMayAdvertiseFeedUnit>, E> {
    private static PYMAPageLikeObjectiveBodyComponentPartDefinition f8649i;
    private static final Object f8650j = new Object();
    private final PagesYouMayLikeComponent f8651c;
    private final QeAccessor f8652d;
    private final FeedBackgroundStylerComponentWrapper f8653e;
    private final PYMADataModelHelper f8654f;
    private PaddingStyle f8655g;
    private Boolean f8656h;

    private static PYMAPageLikeObjectiveBodyComponentPartDefinition m9489b(InjectorLike injectorLike) {
        return new PYMAPageLikeObjectiveBodyComponentPartDefinition((Context) injectorLike.getInstance(Context.class), PagesYouMayLikeComponent.a(injectorLike), FeedBackgroundStylerComponentWrapper.b(injectorLike), DefaultPaddingStyleResolver.a(injectorLike), PYMADataModelHelper.m9459a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    public final /* synthetic */ boolean m9494a(Object obj) {
        return m9496b();
    }

    public final CacheableEntity m9495b(Object obj) {
        return ComponentPartHelper.a((FeedProps) obj);
    }

    public static PYMAPageLikeObjectiveBodyComponentPartDefinition m9488a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PYMAPageLikeObjectiveBodyComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8650j) {
                PYMAPageLikeObjectiveBodyComponentPartDefinition pYMAPageLikeObjectiveBodyComponentPartDefinition;
                if (a2 != null) {
                    pYMAPageLikeObjectiveBodyComponentPartDefinition = (PYMAPageLikeObjectiveBodyComponentPartDefinition) a2.a(f8650j);
                } else {
                    pYMAPageLikeObjectiveBodyComponentPartDefinition = f8649i;
                }
                if (pYMAPageLikeObjectiveBodyComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9489b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8650j, b3);
                        } else {
                            f8649i = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pYMAPageLikeObjectiveBodyComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PYMAPageLikeObjectiveBodyComponentPartDefinition(Context context, PagesYouMayLikeComponent pagesYouMayLikeComponent, FeedBackgroundStylerComponentWrapper feedBackgroundStylerComponentWrapper, DefaultPaddingStyleResolver defaultPaddingStyleResolver, PYMADataModelHelper pYMADataModelHelper, QeAccessor qeAccessor) {
        super(context);
        this.f8652d = qeAccessor;
        this.f8651c = pagesYouMayLikeComponent;
        this.f8653e = feedBackgroundStylerComponentWrapper;
        Builder c = Builder.c();
        c.c = defaultPaddingStyleResolver.e();
        c = c;
        c.b = defaultPaddingStyleResolver.d();
        this.f8655g = c.i();
        this.f8654f = pYMADataModelHelper;
    }

    private Component<?> m9487a(ComponentContext componentContext, FeedProps<GraphQLPagesYouMayAdvertiseFeedUnit> feedProps, E e) {
        return this.f8653e.a(componentContext, (HasPositionInformation) e, new StylingData(feedProps, this.f8655g), this.f8651c.a(componentContext).a(new FeedUnitAndChangePageListener(FeedProps.c(this.f8654f.m9462a(feedProps, true)), null)).a((HasFeedListType) e).a(false).d());
    }

    public final boolean m9496b() {
        boolean z = false;
        if (this.f8656h == null) {
            int a = this.f8652d.a(ExperimentsForMultiRowQEModule.g, 0);
            if (a == 1 || a == 2) {
                z = true;
            }
            this.f8656h = Boolean.valueOf(z);
        }
        return this.f8656h.booleanValue();
    }

    public final boolean m9492a(E e) {
        return false;
    }
}
