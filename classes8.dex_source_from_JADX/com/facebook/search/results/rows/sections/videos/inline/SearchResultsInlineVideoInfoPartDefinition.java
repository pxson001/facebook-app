package com.facebook.search.results.rows.sections.videos.inline;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.graphql.model.StoryHierarchyHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.TextIconPartDefinition;
import com.facebook.multirow.parts.TextIconPartDefinition.IconData;
import com.facebook.multirow.parts.TextIconPartDefinition.IconData.Position;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.multirow.parts.TextWithImageEntitiesOrHiddenPartDefinition;
import com.facebook.multirow.parts.TextWithImageEntitiesOrHiddenPartDefinition.Props;
import com.facebook.search.results.environment.HasSearchResultPosition;
import com.facebook.search.results.environment.HasSearchResultsContext;
import com.facebook.search.results.environment.videos.HasSearchResultsVideoStoryPersistentState;
import com.facebook.search.results.model.SearchResultsProps;
import com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel;
import com.facebook.search.results.protocol.SearchResultsEdgeUtil;
import com.facebook.search.results.rows.sections.videos.SearchResultsVideoFullscreenLauncherPartDefinition;
import com.facebook.search.results.rows.sections.videos.SearchResultsVideoMetaTextPartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: PLACEHOLDER */
public class SearchResultsInlineVideoInfoPartDefinition<E extends HasContext & HasFeedListType & HasSearchResultPosition & HasSearchResultsContext & HasSearchResultsVideoStoryPersistentState> extends MultiRowSinglePartDefinition<SearchResultsProps<FeedProps<GraphQLStoryAttachment>>, Void, E, View> {
    public static final ViewType<View> f25278a = ViewType.a(2130904925);
    private static SearchResultsInlineVideoInfoPartDefinition f25279g;
    private static final Object f25280h = new Object();
    private final SearchResultsVideoFullscreenLauncherPartDefinition<E, View> f25281b;
    private final SearchResultsVideoMetaTextPartDefinition f25282c;
    private final TextIconPartDefinition f25283d;
    private final TextPartDefinition f25284e;
    private final TextWithImageEntitiesOrHiddenPartDefinition<E> f25285f;

    private static SearchResultsInlineVideoInfoPartDefinition m28522b(InjectorLike injectorLike) {
        return new SearchResultsInlineVideoInfoPartDefinition(SearchResultsVideoFullscreenLauncherPartDefinition.m28465a(injectorLike), SearchResultsVideoMetaTextPartDefinition.m28470a(injectorLike), TextIconPartDefinition.a(injectorLike), TextPartDefinition.a(injectorLike), TextWithImageEntitiesOrHiddenPartDefinition.a(injectorLike));
    }

    public final Object m28524a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        SearchResultsProps searchResultsProps = (SearchResultsProps) obj;
        FeedProps feedProps = (FeedProps) searchResultsProps.f23388a;
        subParts.a(2131558927, this.f25285f, new Props(StoryHierarchyHelper.b((GraphQLStory) feedProps.b.a)));
        subParts.a(2131560532, this.f25282c, searchResultsProps.m27104a(((EdgesModel) SearchResultsEdgeUtil.m9803e(searchResultsProps.f23390c).get(searchResultsProps.f23389b)).m9699a()));
        GraphQLActor a = StoryAttachmentHelper.a((GraphQLStoryAttachment) feedProps.a);
        if (a != null) {
            subParts.a(2131558926, this.f25284e, a.aa());
            subParts.a(2131558926, this.f25283d, new IconData(a.R() ? 2130843879 : 0, 2131431544, Position.END));
            subParts.a(this.f25281b, searchResultsProps);
        }
        return null;
    }

    public static SearchResultsInlineVideoInfoPartDefinition m28521a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsInlineVideoInfoPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f25280h) {
                SearchResultsInlineVideoInfoPartDefinition searchResultsInlineVideoInfoPartDefinition;
                if (a2 != null) {
                    searchResultsInlineVideoInfoPartDefinition = (SearchResultsInlineVideoInfoPartDefinition) a2.a(f25280h);
                } else {
                    searchResultsInlineVideoInfoPartDefinition = f25279g;
                }
                if (searchResultsInlineVideoInfoPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28522b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f25280h, b3);
                        } else {
                            f25279g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsInlineVideoInfoPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public SearchResultsInlineVideoInfoPartDefinition(SearchResultsVideoFullscreenLauncherPartDefinition searchResultsVideoFullscreenLauncherPartDefinition, SearchResultsVideoMetaTextPartDefinition searchResultsVideoMetaTextPartDefinition, TextIconPartDefinition textIconPartDefinition, TextPartDefinition textPartDefinition, TextWithImageEntitiesOrHiddenPartDefinition textWithImageEntitiesOrHiddenPartDefinition) {
        this.f25281b = searchResultsVideoFullscreenLauncherPartDefinition;
        this.f25282c = searchResultsVideoMetaTextPartDefinition;
        this.f25283d = textIconPartDefinition;
        this.f25284e = textPartDefinition;
        this.f25285f = textWithImageEntitiesOrHiddenPartDefinition;
    }

    public final ViewType<View> m28523a() {
        return f25278a;
    }

    public final boolean m28525a(Object obj) {
        return true;
    }
}
