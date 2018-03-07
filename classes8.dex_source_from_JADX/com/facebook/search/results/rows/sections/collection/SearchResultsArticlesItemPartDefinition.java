package com.facebook.search.results.rows.sections.collection;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.multirow.parts.ContentViewThumbnailUriStringPartDefinition;
import com.facebook.multirow.parts.ContentViewTitlePartDefinition;
import com.facebook.search.results.environment.entity.OldCanLogEntityNavigation;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: RESEND_CODE_SUCCESS */
public class SearchResultsArticlesItemPartDefinition<E extends HasPositionInformation & OldCanLogEntityNavigation & HasContext> extends MultiRowSinglePartDefinition<GraphQLNode, Void, E, ContentView> {
    public static final ViewType f23720a = new C25371();
    private static final PaddingStyle f23721b;
    private static SearchResultsArticlesItemPartDefinition f23722i;
    private static final Object f23723j = new Object();
    public final FbUriIntentHandler f23724c;
    private final BackgroundPartDefinition f23725d;
    private final ContentViewTitlePartDefinition f23726e;
    private final SearchResultsExternalUrlContentViewSubtitlePartDefinition<E> f23727f;
    private final ContentViewThumbnailUriStringPartDefinition f23728g;
    private final ClickListenerPartDefinition f23729h;

    /* compiled from: RESEND_CODE_SUCCESS */
    final class C25371 extends ViewType {
        C25371() {
        }

        public final View m27367a(Context context) {
            return LayoutInflater.from(context).inflate(2130906998, null);
        }
    }

    private static SearchResultsArticlesItemPartDefinition m27370b(InjectorLike injectorLike) {
        return new SearchResultsArticlesItemPartDefinition(FbUriIntentHandler.a(injectorLike), BackgroundPartDefinition.a(injectorLike), ContentViewTitlePartDefinition.a(injectorLike), SearchResultsExternalUrlContentViewSubtitlePartDefinition.m27391a(injectorLike), ContentViewThumbnailUriStringPartDefinition.a(injectorLike), ClickListenerPartDefinition.a(injectorLike));
    }

    public final Object m27372a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final GraphQLNode graphQLNode = (GraphQLNode) obj;
        final HasPositionInformation hasPositionInformation = (HasPositionInformation) anyEnvironment;
        subParts.a(this.f23725d, new StylingData(f23721b));
        subParts.a(this.f23726e, graphQLNode.it().a());
        subParts.a(this.f23727f, graphQLNode);
        subParts.a(this.f23728g, ((GraphQLImage) Preconditions.checkNotNull(((GraphQLMedia) Preconditions.checkNotNull(graphQLNode.em())).S())).b());
        subParts.a(this.f23729h, new OnClickListener(this) {
            final /* synthetic */ SearchResultsArticlesItemPartDefinition f23719c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1405207214);
                this.f23719c.f23724c.a(view.getContext(), graphQLNode.iR());
                ((OldCanLogEntityNavigation) hasPositionInformation).mo1251b(graphQLNode);
                Logger.a(2, EntryType.UI_INPUT_END, -1663525690, a);
            }
        });
        return null;
    }

    static {
        Builder a = Builder.a();
        a.b = 6.0f;
        a = a;
        a.c = 6.0f;
        f23721b = a.i();
    }

    public static SearchResultsArticlesItemPartDefinition m27368a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsArticlesItemPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23723j) {
                SearchResultsArticlesItemPartDefinition searchResultsArticlesItemPartDefinition;
                if (a2 != null) {
                    searchResultsArticlesItemPartDefinition = (SearchResultsArticlesItemPartDefinition) a2.a(f23723j);
                } else {
                    searchResultsArticlesItemPartDefinition = f23722i;
                }
                if (searchResultsArticlesItemPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27370b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23723j, b3);
                        } else {
                            f23722i = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsArticlesItemPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public SearchResultsArticlesItemPartDefinition(FbUriIntentHandler fbUriIntentHandler, BackgroundPartDefinition backgroundPartDefinition, ContentViewTitlePartDefinition contentViewTitlePartDefinition, SearchResultsExternalUrlContentViewSubtitlePartDefinition searchResultsExternalUrlContentViewSubtitlePartDefinition, ContentViewThumbnailUriStringPartDefinition contentViewThumbnailUriStringPartDefinition, ClickListenerPartDefinition clickListenerPartDefinition) {
        this.f23724c = fbUriIntentHandler;
        this.f23725d = backgroundPartDefinition;
        this.f23726e = contentViewTitlePartDefinition;
        this.f23727f = searchResultsExternalUrlContentViewSubtitlePartDefinition;
        this.f23728g = contentViewThumbnailUriStringPartDefinition;
        this.f23729h = clickListenerPartDefinition;
    }

    public final ViewType m27371a() {
        return f23720a;
    }

    public static boolean m27369a(GraphQLNode graphQLNode) {
        if (graphQLNode.j() == null || graphQLNode.j().g() != 514783620 || graphQLNode.it() == null || Strings.isNullOrEmpty(graphQLNode.it().a()) || Strings.isNullOrEmpty(graphQLNode.iR()) || graphQLNode.em() == null || graphQLNode.em().S() == null) {
            return false;
        }
        return true;
    }
}
