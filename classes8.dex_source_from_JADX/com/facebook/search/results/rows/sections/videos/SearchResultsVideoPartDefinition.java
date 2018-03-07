package com.facebook.search.results.rows.sections.videos;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feedplugins.attachments.video.ChannelFeedEligibilityUtil;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesLongFields;
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
import com.facebook.multirow.parts.FbDraweePartDefinition;
import com.facebook.multirow.parts.FbDraweePartDefinition.Props;
import com.facebook.multirow.parts.FbDraweePartDefinition.Props.Builder;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.search.results.environment.HasSearchResultPosition;
import com.facebook.search.results.environment.HasSearchResultsContext;
import com.facebook.search.results.environment.videos.HasSearchResultsVideoStoryPersistentState;
import com.facebook.search.results.model.SearchResultsProps;
import com.facebook.search.results.protocol.video.SearchResultsVideoInterfaces.SearchResultsVideo;
import com.facebook.search.results.protocol.video.SearchResultsVideoModels.SearchResultsVideoModel.OwnerModel;
import com.facebook.search.results.rows.SearchBackgroundPartDefinition;
import com.facebook.search.results.util.SearchResultsFormatUtil;
import com.facebook.search.util.TypeaheadRowTitleFormatter;
import com.facebook.video.analytics.ChannelEligibility;
import com.facebook.widget.CustomFrameLayout;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

@ContextScoped
/* compiled from: PLACE_MAP_INTERACTION */
public class SearchResultsVideoPartDefinition<E extends HasContext & HasFeedListType & HasPositionInformation & HasPrefetcher & HasRowKey & HasSearchResultsContext & HasSearchResultPosition & HasSearchResultsVideoStoryPersistentState> extends MultiRowSinglePartDefinition<SearchResultsProps<SearchResultsVideo>, Void, E, ImageBlockLayout> {
    public static final ViewType<ImageBlockLayout> f25207a = ViewType.a(2130907126);
    static final PaddingStyle f25208b;
    public static final CallerContext f25209c = CallerContext.a(SearchResultsVideoPartDefinition.class, "graph_search_results_page");
    private static SearchResultsVideoPartDefinition f25210l;
    private static final Object f25211m = new Object();
    private final SearchBackgroundPartDefinition<E> f25212d;
    private final FbDraweePartDefinition<E> f25213e;
    private final TextPartDefinition f25214f;
    public final TypeaheadRowTitleFormatter f25215g;
    private final SearchResultsVideoMetaTextPartDefinition f25216h;
    private final ChannelFeedEligibilityUtil f25217i;
    private final SearchResultsVideoChannelLauncherPartDefinition<E> f25218j;
    private final SearchResultsVideoFullscreenLauncherPartDefinition<E, ImageBlockLayout> f25219k;

    private static SearchResultsVideoPartDefinition m28475b(InjectorLike injectorLike) {
        return new SearchResultsVideoPartDefinition(SearchBackgroundPartDefinition.m27225a(injectorLike), FbDraweePartDefinition.a(injectorLike), TextPartDefinition.a(injectorLike), TypeaheadRowTitleFormatter.m10667a(injectorLike), SearchResultsVideoMetaTextPartDefinition.m28470a(injectorLike), ChannelFeedEligibilityUtil.a(injectorLike), SearchResultsVideoChannelLauncherPartDefinition.m28459a(injectorLike), SearchResultsVideoFullscreenLauncherPartDefinition.m28465a(injectorLike));
    }

    public final Object m28477a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        String string;
        Props props;
        SearchResultsProps searchResultsProps = (SearchResultsProps) obj;
        HasContext hasContext = (HasContext) anyEnvironment;
        SearchResultsVideo searchResultsVideo = (SearchResultsVideo) searchResultsProps.f23388a;
        TextPartDefinition textPartDefinition = this.f25214f;
        Resources resources = hasContext.getContext().getResources();
        if (searchResultsVideo.mo571A()) {
            string = resources.getString(2131239058);
        } else {
            string = SearchResultsFormatUtil.m28568a((long) searchResultsVideo.ae());
        }
        subParts.a(2131567482, textPartDefinition, string);
        resources = hasContext.getContext().getResources();
        DefaultImageFields F = searchResultsVideo.mo575F();
        if (F == null) {
            props = null;
        } else {
            Builder a = new Builder().a(F.b());
            a.c = f25209c;
            Builder a2 = a.a(resources.getDimensionPixelSize(2131432641), resources.getDimensionPixelSize(2131432642));
            a2.h = ScaleType.h;
            props = a2.a();
        }
        Props props2 = props;
        if (props2 != null) {
            subParts.a(2131567481, this.f25213e, props2);
        }
        textPartDefinition = this.f25214f;
        DefaultTextWithEntitiesLongFields R = searchResultsVideo.mo578R();
        if (R != null) {
            string = R.a();
        } else {
            string = null;
        }
        subParts.a(2131558927, textPartDefinition, string);
        textPartDefinition = this.f25214f;
        OwnerModel Y = searchResultsVideo.mo580Y();
        SpannableStringBuilder a3 = Y == null ? null : Y.m10544b() ? this.f25215g.m10671a(new SpannableStringBuilder(Y.m10545c())) : Y.m10545c();
        subParts.a(2131558926, textPartDefinition, a3);
        subParts.a(2131567483, this.f25216h, searchResultsProps);
        GraphQLStory graphQLStory = (GraphQLStory) Preconditions.checkNotNull(((SearchResultsVideo) searchResultsProps.f23388a).mo591p());
        SearchResultsProps a4 = searchResultsProps.m27104a(FeedProps.c(graphQLStory).a(StoryAttachmentHelper.o(graphQLStory)));
        subParts.a(this.f25217i.a((FeedProps) a4.f23388a, ((HasFeedListType) hasContext).c().a()) == ChannelEligibility.ELIGIBLE ? this.f25218j : this.f25219k, a4);
        subParts.a(this.f25212d, new StylingData(null, f25208b, SearchBackgroundPartDefinition.m27224a(searchResultsProps, (HasPositionInformation) hasContext)));
        return null;
    }

    public final /* bridge */ /* synthetic */ void m28478a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -795585651);
        ImageBlockLayout imageBlockLayout = (ImageBlockLayout) view;
        if (((SearchResultsVideo) ((SearchResultsProps) obj).f23388a).mo576J()) {
            CustomFrameLayout customFrameLayout = (CustomFrameLayout) imageBlockLayout.findViewById(2131567480);
            if (customFrameLayout.findViewById(2131567296) == null) {
                LayoutInflater.from(customFrameLayout.getContext()).inflate(2130907009, customFrameLayout, true);
            }
        }
        Logger.a(8, EntryType.MARK_POP, 1167384132, a);
    }

    public final boolean m28479a(Object obj) {
        GraphQLStory p = ((SearchResultsVideo) ((SearchResultsProps) obj).f23388a).mo591p();
        GraphQLStoryAttachment o = p != null ? StoryAttachmentHelper.o(p) : null;
        return (p == null || o == null || o.r() == null) ? false : true;
    }

    public final void m28480b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        CustomFrameLayout customFrameLayout = (CustomFrameLayout) ((ImageBlockLayout) view).findViewById(2131567480);
        View findViewById = customFrameLayout.findViewById(2131567296);
        if (findViewById != null) {
            customFrameLayout.removeView(findViewById);
        }
    }

    public static SearchResultsVideoPartDefinition m28474a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsVideoPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f25211m) {
                SearchResultsVideoPartDefinition searchResultsVideoPartDefinition;
                if (a2 != null) {
                    searchResultsVideoPartDefinition = (SearchResultsVideoPartDefinition) a2.a(f25211m);
                } else {
                    searchResultsVideoPartDefinition = f25210l;
                }
                if (searchResultsVideoPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28475b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f25211m, b3);
                        } else {
                            f25210l = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsVideoPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    static {
        PaddingStyle.Builder a = PaddingStyle.Builder.a();
        a.b = 3.0f;
        a = a;
        a.c = 3.0f;
        f25208b = a.i();
    }

    @Inject
    public SearchResultsVideoPartDefinition(SearchBackgroundPartDefinition searchBackgroundPartDefinition, FbDraweePartDefinition fbDraweePartDefinition, TextPartDefinition textPartDefinition, TypeaheadRowTitleFormatter typeaheadRowTitleFormatter, SearchResultsVideoMetaTextPartDefinition searchResultsVideoMetaTextPartDefinition, ChannelFeedEligibilityUtil channelFeedEligibilityUtil, SearchResultsVideoChannelLauncherPartDefinition searchResultsVideoChannelLauncherPartDefinition, SearchResultsVideoFullscreenLauncherPartDefinition searchResultsVideoFullscreenLauncherPartDefinition) {
        this.f25212d = searchBackgroundPartDefinition;
        this.f25213e = fbDraweePartDefinition;
        this.f25214f = textPartDefinition;
        this.f25215g = typeaheadRowTitleFormatter;
        this.f25216h = searchResultsVideoMetaTextPartDefinition;
        this.f25217i = channelFeedEligibilityUtil;
        this.f25218j = searchResultsVideoChannelLauncherPartDefinition;
        this.f25219k = searchResultsVideoFullscreenLauncherPartDefinition;
    }

    public final ViewType<ImageBlockLayout> m28476a() {
        return f25207a;
    }
}
