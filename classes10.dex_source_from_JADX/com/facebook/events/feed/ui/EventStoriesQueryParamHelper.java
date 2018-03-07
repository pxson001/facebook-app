package com.facebook.events.feed.ui;

import com.facebook.api.ufiservices.qe.ExperimentsForUfiServiceQeModule;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.graphql.querybuilder.common.GraphQlQueryDefaults;
import com.facebook.graphql.util.GraphQLImageHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.data.protocol.SizeAwareImageUtil;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.story.GraphQLStoryHelper;
import com.facebook.topics.protocol.FetchTopicsParamBuilderUtil;
import javax.inject.Inject;

/* compiled from: com.facebook.TokenCachingStrategy.AccessTokenSource */
public class EventStoriesQueryParamHelper {
    private final FetchTopicsParamBuilderUtil f17449a;
    private final GraphQLImageHelper f17450b;
    private final GraphQLStoryHelper f17451c;
    private final QeAccessor f17452d;
    private final SizeAwareImageUtil f17453e;

    public static EventStoriesQueryParamHelper m17800b(InjectorLike injectorLike) {
        return new EventStoriesQueryParamHelper(FetchTopicsParamBuilderUtil.a(injectorLike), GraphQLImageHelper.a(injectorLike), GraphQLStoryHelper.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), SizeAwareImageUtil.a(injectorLike));
    }

    @Inject
    public EventStoriesQueryParamHelper(FetchTopicsParamBuilderUtil fetchTopicsParamBuilderUtil, GraphQLImageHelper graphQLImageHelper, GraphQLStoryHelper graphQLStoryHelper, QeAccessor qeAccessor, SizeAwareImageUtil sizeAwareImageUtil) {
        this.f17449a = fetchTopicsParamBuilderUtil;
        this.f17450b = graphQLImageHelper;
        this.f17451c = graphQLStoryHelper;
        this.f17452d = qeAccessor;
        this.f17453e = sizeAwareImageUtil;
    }

    public final void m17801a(TypedGraphQlQueryString typedGraphQlQueryString) {
        this.f17449a.a(typedGraphQlQueryString);
        this.f17453e.a(typedGraphQlQueryString, this.f17450b.c());
        typedGraphQlQueryString.a("image_large_aspect_width", this.f17451c.y());
        typedGraphQlQueryString.a("image_large_aspect_height", this.f17451c.z());
        typedGraphQlQueryString.a("include_replies_in_total_count", Boolean.toString(this.f17452d.a(ExperimentsForUfiServiceQeModule.l, false)));
        typedGraphQlQueryString.a("no_recent_story", Boolean.toString(true));
        Enum a = GraphQlQueryDefaults.a();
        String str = "default_image_scale";
        if (a == null) {
            a = GraphQlQueryDefaults.a;
        }
        typedGraphQlQueryString.a(str, a);
    }

    public static EventStoriesQueryParamHelper m17799a(InjectorLike injectorLike) {
        return m17800b(injectorLike);
    }
}
