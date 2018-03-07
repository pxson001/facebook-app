package com.facebook.feedplugins.pyml.rows.contentbased;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.feed.renderer.DefaultFeedUnitRenderer;
import com.facebook.feedplugins.pyml.rows.contentbased.ui.ContentBasedPageYouMayLikePhotoContentView;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLPagesYouMayLikeFeedUnitItemContentConnection;
import com.facebook.graphql.model.ImageUtil;
import com.facebook.graphql.model.SuggestedPageUnitItem;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinitionWithViewType;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;

@ContextScoped
/* compiled from: notifications_db */
public class PymlPhotoPagePartDefinition extends BaseSinglePartDefinitionWithViewType<PagesYouMayLikeItemViewModelProps, ImmutableList<Uri>, AnyEnvironment, ContentBasedPageYouMayLikePhotoContentView> {
    public static final ViewType<ContentBasedPageYouMayLikePhotoContentView> f6735a = new C03131();
    public static final CallerContext f6736b = CallerContext.a(ContentBasedPageYouMayLikePhotoContentView.class, "native_newsfeed", "photo_grid");
    private static PymlPhotoPagePartDefinition f6737g;
    private static final Object f6738h = new Object();
    private final ContentBasedPageYouMayLikePartDefinition f6739c;
    private final PymlActorPhotoPartDefinition f6740d;
    private final ClickListenerPartDefinition f6741e;
    public final DefaultFeedUnitRenderer f6742f;

    /* compiled from: notifications_db */
    final class C03131 extends ViewType<ContentBasedPageYouMayLikePhotoContentView> {
        C03131() {
        }

        public final View m7122a(Context context) {
            return new ContentBasedPageYouMayLikePhotoContentView(context);
        }
    }

    private static PymlPhotoPagePartDefinition m7118b(InjectorLike injectorLike) {
        return new PymlPhotoPagePartDefinition(ContentBasedPageYouMayLikePartDefinition.a(injectorLike), PymlActorPhotoPartDefinition.a(injectorLike), ClickListenerPartDefinition.a(injectorLike), DefaultFeedUnitRenderer.a(injectorLike));
    }

    public final Object m7120a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        PagesYouMayLikeItemViewModelProps pagesYouMayLikeItemViewModelProps = (PagesYouMayLikeItemViewModelProps) obj;
        subParts.a(this.f6740d, pagesYouMayLikeItemViewModelProps.b);
        subParts.a(this.f6739c, pagesYouMayLikeItemViewModelProps);
        subParts.a(2131560755, this.f6741e, new 2(this, pagesYouMayLikeItemViewModelProps));
        SuggestedPageUnitItem suggestedPageUnitItem = pagesYouMayLikeItemViewModelProps.b;
        Builder builder = ImmutableList.builder();
        GraphQLPagesYouMayLikeFeedUnitItemContentConnection q = suggestedPageUnitItem.mo552q();
        if (!(q == null || q.a() == null)) {
            ImmutableList a = q.a();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                GraphQLNode graphQLNode = (GraphQLNode) a.get(i);
                if (!(graphQLNode.dq() == null || graphQLNode.dq().b() == null)) {
                    builder.c(ImageUtil.a(graphQLNode.dq()));
                }
            }
        }
        return builder.b();
    }

    public final /* bridge */ /* synthetic */ void m7121a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 923893274);
        ImmutableList immutableList = (ImmutableList) obj2;
        ContentBasedPageYouMayLikePhotoContentView contentBasedPageYouMayLikePhotoContentView = (ContentBasedPageYouMayLikePhotoContentView) view;
        CallerContext callerContext = f6736b;
        for (int i = 0; i < Math.min(contentBasedPageYouMayLikePhotoContentView.f6744e.size(), immutableList.size()); i++) {
            ((FbDraweeView) contentBasedPageYouMayLikePhotoContentView.f6744e.get(i)).a((Uri) immutableList.get(i), callerContext);
        }
        Logger.a(8, EntryType.MARK_POP, 899543255, a);
    }

    @Inject
    public PymlPhotoPagePartDefinition(ContentBasedPageYouMayLikePartDefinition contentBasedPageYouMayLikePartDefinition, PymlActorPhotoPartDefinition pymlActorPhotoPartDefinition, ClickListenerPartDefinition clickListenerPartDefinition, DefaultFeedUnitRenderer defaultFeedUnitRenderer) {
        this.f6739c = contentBasedPageYouMayLikePartDefinition;
        this.f6740d = pymlActorPhotoPartDefinition;
        this.f6741e = clickListenerPartDefinition;
        this.f6742f = defaultFeedUnitRenderer;
    }

    public static PymlPhotoPagePartDefinition m7117a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PymlPhotoPagePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f6738h) {
                PymlPhotoPagePartDefinition pymlPhotoPagePartDefinition;
                if (a2 != null) {
                    pymlPhotoPagePartDefinition = (PymlPhotoPagePartDefinition) a2.a(f6738h);
                } else {
                    pymlPhotoPagePartDefinition = f6737g;
                }
                if (pymlPhotoPagePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m7118b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f6738h, b3);
                        } else {
                            f6737g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pymlPhotoPagePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType<ContentBasedPageYouMayLikePhotoContentView> m7119a() {
        return f6735a;
    }
}
