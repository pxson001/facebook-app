package com.facebook.feedplugins.pyml.rows;

import android.content.Context;
import android.graphics.PointF;
import android.net.Uri;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feed.hscroll.ExperimentsForFeedHScrollModule;
import com.facebook.feed.rows.core.events.NavigatedToTargetPageEvent;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageSwitcherPartDefinition.Controller;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.feed.rows.styling.DefaultPaddingStyleResolver;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.ui.itemlistfeedunits.gating.ExperimentsForNewsFeedModule;
import com.facebook.feedplugins.pyml.EgoUnitUtil;
import com.facebook.feedplugins.pyml.rows.ui.PageYouMayLikeView;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLPage;
import com.facebook.graphql.model.GraphQLVect2;
import com.facebook.graphql.model.ImageUtil;
import com.facebook.graphql.model.ScrollableItemListFeedUnit;
import com.facebook.graphql.model.SuggestedPageUnitItem;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinitionWithViewType;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.FbDraweePartDefinition;
import com.facebook.multirow.parts.FbDraweePartDefinition.Props.Builder;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.ui.futures.TasksManager;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: onError MEDIA_ERROR_IO */
public class PymlPagePartDefinition<E extends HasMenuButtonProvider & HasPositionInformation & HasPrefetcher & HasRowKey> extends BaseSinglePartDefinitionWithViewType<Props, Void, E, PageYouMayLikeView> {
    public static final ViewType<PageYouMayLikeView> f6230a = new C02741();
    private static final CallerContext f6231b = CallerContext.a(PymlPagePartDefinition.class, "native_newsfeed", "actor_photo");
    private static final CallerContext f6232c = CallerContext.a(PymlPagePartDefinition.class, "native_newsfeed", "cover_photo");
    private static PymlPagePartDefinition f6233k;
    private static final Object f6234l = new Object();
    private final BackgroundPartDefinition f6235d;
    private final FbDraweePartDefinition<E> f6236e;
    private final PageYouMayLikePartDefinition f6237f;
    private final PymlHeaderPartDefinition f6238g;
    private final QeAccessor f6239h;
    private final boolean f6240i = this.f6239h.a(ExperimentsForNewsFeedModule.f6258a, false);
    private final DefaultPaddingStyleResolver f6241j;

    /* compiled from: onError MEDIA_ERROR_IO */
    final class C02741 extends ViewType<PageYouMayLikeView> {
        C02741() {
        }

        public final View m6690a(Context context) {
            return new PageYouMayLikeView(context);
        }
    }

    /* compiled from: onError MEDIA_ERROR_IO */
    public class Props {
        public final SuggestedPageUnitItem f6416a;
        public final FeedProps<? extends ScrollableItemListFeedUnit> f6417b;
        public final TasksManager<GraphQLPage> f6418c;
        public final int f6419d;
        public final int f6420e;
        public final Controller f6421f;
        public final boolean f6422g;
        public final boolean f6423h;

        public Props(SuggestedPageUnitItem suggestedPageUnitItem, FeedProps<? extends ScrollableItemListFeedUnit> feedProps, TasksManager<GraphQLPage> tasksManager, int i, int i2, Controller controller, boolean z, boolean z2) {
            this.f6416a = suggestedPageUnitItem;
            this.f6417b = feedProps;
            this.f6418c = tasksManager;
            this.f6419d = i;
            this.f6420e = i2;
            this.f6421f = controller;
            this.f6422g = z;
            this.f6423h = z2;
        }
    }

    private static PymlPagePartDefinition m6687b(InjectorLike injectorLike) {
        return new PymlPagePartDefinition(FbDraweePartDefinition.a(injectorLike), PageYouMayLikePartDefinition.m6692a(injectorLike), PymlHeaderPartDefinition.m6700a(injectorLike), BackgroundPartDefinition.a(injectorLike), DefaultPaddingStyleResolver.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    public final Object m6689a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        if (props.f6422g) {
            subParts.a(2131565664, this.f6238g, new com.facebook.feedplugins.pyml.rows.PymlHeaderPartDefinition.Props(props.f6416a, props.f6417b));
        }
        subParts.a(2131561267, this.f6236e, m6685a(props, true));
        FbDraweePartDefinition fbDraweePartDefinition = this.f6236e;
        Builder builder = new Builder();
        builder.c = f6231b;
        subParts.a(2131565666, fbDraweePartDefinition, builder.a(ImageUtil.a(EgoUnitUtil.m6653b(props.f6416a))).a());
        subParts.a(this.f6237f, new com.facebook.feedplugins.pyml.rows.PageYouMayLikePartDefinition.Props((ScrollableItemListFeedUnit) props.f6417b.a, props.f6416a, props.f6418c, Integer.valueOf(props.f6419d), props.f6421f, Boolean.valueOf(this.f6240i), m6683a(this.f6239h, (ScrollableItemListFeedUnit) props.f6417b.a()), Boolean.valueOf(props.f6422g)));
        subParts.a(this.f6235d, new StylingData(props.f6417b, m6686b(), props.f6423h ? Position.DIVIDER_BOTTOM : null));
        return null;
    }

    public static PymlPagePartDefinition m6684a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PymlPagePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f6234l) {
                PymlPagePartDefinition pymlPagePartDefinition;
                if (a2 != null) {
                    pymlPagePartDefinition = (PymlPagePartDefinition) a2.a(f6234l);
                } else {
                    pymlPagePartDefinition = f6233k;
                }
                if (pymlPagePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m6687b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f6234l, b3);
                        } else {
                            f6233k = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pymlPagePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PymlPagePartDefinition(FbDraweePartDefinition fbDraweePartDefinition, PageYouMayLikePartDefinition pageYouMayLikePartDefinition, PymlHeaderPartDefinition pymlHeaderPartDefinition, BackgroundPartDefinition backgroundPartDefinition, DefaultPaddingStyleResolver defaultPaddingStyleResolver, QeAccessor qeAccessor) {
        this.f6236e = fbDraweePartDefinition;
        this.f6237f = pageYouMayLikePartDefinition;
        this.f6235d = backgroundPartDefinition;
        this.f6238g = pymlHeaderPartDefinition;
        this.f6241j = defaultPaddingStyleResolver;
        this.f6239h = qeAccessor;
    }

    public final ViewType<PageYouMayLikeView> m6688a() {
        return f6230a;
    }

    @Nullable
    public static NavigatedToTargetPageEvent m6683a(QeAccessor qeAccessor, ScrollableItemListFeedUnit scrollableItemListFeedUnit) {
        return qeAccessor.a(ExperimentsForFeedHScrollModule.a, false) ? new NavigatedToTargetPageEvent(scrollableItemListFeedUnit) : null;
    }

    public static com.facebook.multirow.parts.FbDraweePartDefinition.Props m6685a(Props props, boolean z) {
        float f = 0.5f;
        SuggestedPageUnitItem suggestedPageUnitItem = props.f6416a;
        GraphQLImage a = suggestedPageUnitItem.mo547a(props.f6419d);
        if (a == null) {
            a = suggestedPageUnitItem.mo550o();
        }
        GraphQLImage graphQLImage = a;
        GraphQLVect2 p = props.f6416a.mo551p();
        float a2 = p == null ? 0.5f : (float) p.a();
        if (p != null) {
            f = (float) p.b();
        }
        PointF pointF = new PointF(a2, f);
        Builder builder = new Builder();
        builder.c = f6232c;
        builder = builder.a(Uri.parse(graphQLImage.b()));
        builder.g = pointF;
        builder = builder;
        builder.b = 2.71f;
        builder = builder;
        builder.f = z;
        return builder.a();
    }

    private PaddingStyle m6686b() {
        float f;
        PaddingStyle.Builder e = PaddingStyle.Builder.e();
        if (this.f6240i) {
            f = 0.0f;
        } else {
            f = 12.0f;
        }
        e.d = f;
        PaddingStyle.Builder builder = e;
        builder.c = 1.0f - this.f6241j.e();
        return builder.i();
    }
}
