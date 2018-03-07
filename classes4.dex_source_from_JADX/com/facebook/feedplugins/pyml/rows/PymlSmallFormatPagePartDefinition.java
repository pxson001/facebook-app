package com.facebook.feedplugins.pyml.rows;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageSwitcherPartDefinition.Controller;
import com.facebook.feed.rows.util.DraweeControllerPartDefinition;
import com.facebook.feed.rows.util.DraweeControllerPartDefinition.Callbacks;
import com.facebook.feedplugins.pyml.EgoUnitUtil;
import com.facebook.feedplugins.pyml.rows.ui.PageYouMayLikeSmallFormatView;
import com.facebook.graphql.model.GraphQLCreativePagesYouMayLikeFeedUnit;
import com.facebook.graphql.model.GraphQLPage;
import com.facebook.graphql.model.ImageUtil;
import com.facebook.graphql.model.SuggestedPageUnitItem;
import com.facebook.imagepipeline.request.ImageRequest;
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
import com.facebook.ui.futures.TasksManager;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: onNonCancellationFailure */
public class PymlSmallFormatPagePartDefinition extends BaseSinglePartDefinitionWithViewType<Props, Void, AnyEnvironment, PageYouMayLikeSmallFormatView> {
    public static final ViewType<PageYouMayLikeSmallFormatView> f6147a = new C02721();
    public static final CallerContext f6148b = CallerContext.a(PymlSmallFormatPagePartDefinition.class, "native_newsfeed", "actor_photo");
    private static final CallerContext f6149c = CallerContext.a(PymlSmallFormatPagePartDefinition.class, "native_newsfeed", "cover_photo");
    private static PymlSmallFormatPagePartDefinition f6150g;
    private static final Object f6151h = new Object();
    private final DraweeControllerPartDefinition<PageYouMayLikeSmallFormatView> f6152d;
    private final PageYouMayLikeSmallFormatPartDefinition f6153e;
    public final Resources f6154f;

    /* compiled from: onNonCancellationFailure */
    final class C02721 extends ViewType<PageYouMayLikeSmallFormatView> {
        C02721() {
        }

        public final View m6625a(Context context) {
            return new PageYouMayLikeSmallFormatView(context);
        }
    }

    /* compiled from: onNonCancellationFailure */
    public class Props {
        public final GraphQLCreativePagesYouMayLikeFeedUnit f6365a;
        public final SuggestedPageUnitItem f6366b;
        public final TasksManager<GraphQLPage> f6367c;
        public final Controller f6368d;

        public Props(GraphQLCreativePagesYouMayLikeFeedUnit graphQLCreativePagesYouMayLikeFeedUnit, SuggestedPageUnitItem suggestedPageUnitItem, TasksManager<GraphQLPage> tasksManager, Controller controller) {
            this.f6365a = graphQLCreativePagesYouMayLikeFeedUnit;
            this.f6366b = suggestedPageUnitItem;
            this.f6367c = tasksManager;
            this.f6368d = controller;
        }
    }

    private static PymlSmallFormatPagePartDefinition m6622b(InjectorLike injectorLike) {
        return new PymlSmallFormatPagePartDefinition(DraweeControllerPartDefinition.m6627a(injectorLike), PageYouMayLikeSmallFormatPartDefinition.m6636a(injectorLike), (Context) injectorLike.getInstance(Context.class));
    }

    public final Object m6624a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        DraweeControllerPartDefinition draweeControllerPartDefinition = this.f6152d;
        final SuggestedPageUnitItem suggestedPageUnitItem = props.f6366b;
        subParts.a(draweeControllerPartDefinition, new com.facebook.feed.rows.util.DraweeControllerPartDefinition.Props(f6148b, new Callbacks<PageYouMayLikeSmallFormatView>(this) {
            final /* synthetic */ PymlSmallFormatPagePartDefinition f6370b;

            public final void mo568a(View view, @Nullable DraweeController draweeController) {
                ((PageYouMayLikeSmallFormatView) view).f6406k.setController(draweeController);
            }

            public final ImageRequest mo567a() {
                return ImageRequest.a(ImageUtil.a(EgoUnitUtil.m6653b(suggestedPageUnitItem)));
            }
        }, true, false));
        subParts.a(this.f6152d, m6620a(props.f6366b));
        subParts.a(this.f6153e, new com.facebook.feedplugins.pyml.rows.PageYouMayLikeSmallFormatPartDefinition.Props(props.f6365a, props.f6366b, props.f6367c, props.f6368d));
        return null;
    }

    public static PymlSmallFormatPagePartDefinition m6621a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PymlSmallFormatPagePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f6151h) {
                PymlSmallFormatPagePartDefinition pymlSmallFormatPagePartDefinition;
                if (a2 != null) {
                    pymlSmallFormatPagePartDefinition = (PymlSmallFormatPagePartDefinition) a2.a(f6151h);
                } else {
                    pymlSmallFormatPagePartDefinition = f6150g;
                }
                if (pymlSmallFormatPagePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m6622b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f6151h, b3);
                        } else {
                            f6150g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pymlSmallFormatPagePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PymlSmallFormatPagePartDefinition(DraweeControllerPartDefinition draweeControllerPartDefinition, PageYouMayLikeSmallFormatPartDefinition pageYouMayLikeSmallFormatPartDefinition, Context context) {
        this.f6152d = draweeControllerPartDefinition;
        this.f6153e = pageYouMayLikeSmallFormatPartDefinition;
        this.f6154f = context.getResources();
    }

    public final ViewType<PageYouMayLikeSmallFormatView> m6623a() {
        return f6147a;
    }

    private com.facebook.feed.rows.util.DraweeControllerPartDefinition.Props<PageYouMayLikeSmallFormatView> m6620a(final SuggestedPageUnitItem suggestedPageUnitItem) {
        return new com.facebook.feed.rows.util.DraweeControllerPartDefinition.Props(f6149c, new Callbacks<PageYouMayLikeSmallFormatView>(this) {
            final /* synthetic */ PymlSmallFormatPagePartDefinition f6376b;

            public final void mo568a(View view, @Nullable DraweeController draweeController) {
                PageYouMayLikeSmallFormatView pageYouMayLikeSmallFormatView = (PageYouMayLikeSmallFormatView) view;
                if (!(draweeController == null || draweeController.d() == null)) {
                    GenericDraweeHierarchy genericDraweeHierarchy = (GenericDraweeHierarchy) draweeController.d();
                    genericDraweeHierarchy.b(this.f6376b.f6154f.getDrawable(2131361848));
                    pageYouMayLikeSmallFormatView.f6405j.setHierarchy(genericDraweeHierarchy);
                }
                pageYouMayLikeSmallFormatView.f6405j.setController(draweeController);
            }

            public final ImageRequest mo567a() {
                return ImageRequest.a(ImageUtil.a(suggestedPageUnitItem.mo550o()));
            }
        }, true, false);
    }
}
