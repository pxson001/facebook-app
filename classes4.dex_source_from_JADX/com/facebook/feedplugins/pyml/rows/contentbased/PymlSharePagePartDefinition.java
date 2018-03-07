package com.facebook.feedplugins.pyml.rows.contentbased;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.LinearLayout;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.feed.renderer.DefaultFeedUnitRenderer;
import com.facebook.feedplugins.pyml.rows.ShareData;
import com.facebook.feedplugins.pyml.rows.contentbased.ui.ContentBasedPageYouMayLikeShareContentView;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLPagesYouMayLikeFeedUnitItemContentConnection;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.ImageUtil;
import com.facebook.graphql.model.SuggestedPageUnitItem;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ipc.feed.PermalinkStoryIdParams;
import com.facebook.ipc.feed.ViewPermalinkIntentFactory;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinitionWithViewType;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.resources.ui.FbTextView;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;

@ContextScoped
/* compiled from: notificationsFetchSeenStatesParams */
public class PymlSharePagePartDefinition extends BaseSinglePartDefinitionWithViewType<PagesYouMayLikeItemViewModelProps, ImmutableList<ShareData>, AnyEnvironment, ContentBasedPageYouMayLikeShareContentView> {
    public static final ViewType<ContentBasedPageYouMayLikeShareContentView> f6745a = new C03141();
    public static final CallerContext f6746b = CallerContext.a(ContentBasedPageYouMayLikeShareContentView.class, "native_newsfeed", "share_photo");
    private static PymlSharePagePartDefinition f6747h;
    private static final Object f6748i = new Object();
    private final ContentBasedPageYouMayLikePartDefinition f6749c;
    private final PymlActorPhotoPartDefinition f6750d;
    public final DefaultFeedUnitRenderer f6751e;
    public final SecureContextHelper f6752f;
    public final ViewPermalinkIntentFactory f6753g;

    /* compiled from: notificationsFetchSeenStatesParams */
    final class C03141 extends ViewType<ContentBasedPageYouMayLikeShareContentView> {
        C03141() {
        }

        public final View m7130a(Context context) {
            return new ContentBasedPageYouMayLikeShareContentView(context);
        }
    }

    private static PymlSharePagePartDefinition m7124b(InjectorLike injectorLike) {
        return new PymlSharePagePartDefinition(ContentBasedPageYouMayLikePartDefinition.a(injectorLike), PymlActorPhotoPartDefinition.a(injectorLike), DefaultFeedUnitRenderer.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), ViewPermalinkIntentFactory.a(injectorLike));
    }

    public final Object m7127a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        PagesYouMayLikeItemViewModelProps pagesYouMayLikeItemViewModelProps = (PagesYouMayLikeItemViewModelProps) obj;
        subParts.a(this.f6750d, pagesYouMayLikeItemViewModelProps.b);
        subParts.a(this.f6749c, pagesYouMayLikeItemViewModelProps);
        SuggestedPageUnitItem suggestedPageUnitItem = pagesYouMayLikeItemViewModelProps.b;
        Builder builder = ImmutableList.builder();
        GraphQLPagesYouMayLikeFeedUnitItemContentConnection q = suggestedPageUnitItem.mo552q();
        if (!(q == null || q.a() == null)) {
            ImmutableList a = q.a();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                Uri uri;
                String str;
                2 2;
                GraphQLNode graphQLNode = (GraphQLNode) a.get(i);
                GraphQLStoryAttachment c = m7125c(graphQLNode);
                if (c == null || c.r() == null || c.r().S() == null || c.r().S().b() == null) {
                    uri = null;
                } else {
                    uri = ImageUtil.a(c.r().S());
                }
                Uri uri2 = uri;
                c = m7125c(graphQLNode);
                if (c == null || c.A() == null) {
                    str = null;
                } else {
                    str = c.A();
                }
                String str2 = str;
                if (graphQLNode.dp() == null) {
                    2 = new 2(this, suggestedPageUnitItem);
                } else {
                    PermalinkStoryIdParams.Builder builder2 = new PermalinkStoryIdParams.Builder();
                    builder2.a = graphQLNode.dp();
                    builder2 = builder2;
                    builder2.b = graphQLNode.at();
                    2 = new 3(this, this.f6753g.a(builder2.a()));
                }
                builder.c(new ShareData(uri2, str2, 2));
            }
        }
        return builder.b();
    }

    public final /* bridge */ /* synthetic */ void m7128a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1177362073);
        ImmutableList immutableList = (ImmutableList) obj2;
        ContentBasedPageYouMayLikeShareContentView contentBasedPageYouMayLikeShareContentView = (ContentBasedPageYouMayLikeShareContentView) view;
        CallerContext callerContext = f6746b;
        for (int i = 0; i < Math.min(contentBasedPageYouMayLikeShareContentView.f6756f.size(), immutableList.size()); i++) {
            ShareData shareData = (ShareData) immutableList.get(i);
            if (shareData.a != null) {
                ((FbDraweeView) contentBasedPageYouMayLikeShareContentView.f6754d.get(i)).a(shareData.a, callerContext);
            }
            if (shareData.b != null) {
                ((FbTextView) contentBasedPageYouMayLikeShareContentView.f6755e.get(i)).setText(shareData.b);
            }
            if (shareData.c != null) {
                ((LinearLayout) contentBasedPageYouMayLikeShareContentView.f6756f.get(i)).setOnClickListener(shareData.c);
            }
        }
        Logger.a(8, EntryType.MARK_POP, -133465729, a);
    }

    public final void m7129b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ContentBasedPageYouMayLikeShareContentView contentBasedPageYouMayLikeShareContentView = (ContentBasedPageYouMayLikeShareContentView) view;
        int size = contentBasedPageYouMayLikeShareContentView.f6756f.size();
        for (int i = 0; i < size; i++) {
            ((View) contentBasedPageYouMayLikeShareContentView.f6756f.get(i)).setOnClickListener(null);
        }
    }

    public static PymlSharePagePartDefinition m7123a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PymlSharePagePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f6748i) {
                PymlSharePagePartDefinition pymlSharePagePartDefinition;
                if (a2 != null) {
                    pymlSharePagePartDefinition = (PymlSharePagePartDefinition) a2.a(f6748i);
                } else {
                    pymlSharePagePartDefinition = f6747h;
                }
                if (pymlSharePagePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m7124b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f6748i, b3);
                        } else {
                            f6747h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pymlSharePagePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PymlSharePagePartDefinition(ContentBasedPageYouMayLikePartDefinition contentBasedPageYouMayLikePartDefinition, PymlActorPhotoPartDefinition pymlActorPhotoPartDefinition, DefaultFeedUnitRenderer defaultFeedUnitRenderer, SecureContextHelper secureContextHelper, ViewPermalinkIntentFactory viewPermalinkIntentFactory) {
        this.f6749c = contentBasedPageYouMayLikePartDefinition;
        this.f6750d = pymlActorPhotoPartDefinition;
        this.f6751e = defaultFeedUnitRenderer;
        this.f6752f = secureContextHelper;
        this.f6753g = viewPermalinkIntentFactory;
    }

    public final ViewType<ContentBasedPageYouMayLikeShareContentView> m7126a() {
        return f6745a;
    }

    @Nullable
    public static GraphQLStoryAttachment m7125c(GraphQLNode graphQLNode) {
        return (graphQLNode.ab() == null || graphQLNode.ab().isEmpty()) ? null : (GraphQLStoryAttachment) graphQLNode.ab().get(0);
    }
}
