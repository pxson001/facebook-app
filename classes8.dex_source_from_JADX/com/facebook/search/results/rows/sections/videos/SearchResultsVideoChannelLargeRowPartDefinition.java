package com.facebook.search.results.rows.sections.videos;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feedplugins.attachments.video.VideoZeroDialogPartDefinition;
import com.facebook.graphql.calls.EntryPointInputVideoChannelEntryPoint;
import com.facebook.graphql.model.GraphQLGraphSearchResultsEdge;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ContentViewContentDescriptionPartDefinition;
import com.facebook.multirow.parts.ContentViewMetaTextPartDefinition;
import com.facebook.multirow.parts.ContentViewSubtitlePartDefinition;
import com.facebook.multirow.parts.ContentViewThumbnailUriPartDefinition;
import com.facebook.search.results.environment.HasSearchResultsContext;
import com.facebook.search.results.environment.entity.OldCanLogEntityNavigation;
import com.facebook.search.results.rows.SearchBackgroundPartDefinition;
import com.facebook.search.results.rows.sections.entities.OldSearchResultsEntityTitlePartDefinition;
import com.facebook.search.results.rows.sections.entities.SearchResultsEntityConstants;
import com.facebook.search.results.rows.sections.entities.SearchResultsEntityUtils;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.ExternalLogType;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.channelfeed.ChannelFeedGenericLauncherPartDefinition;
import com.facebook.video.channelfeed.ChannelFeedGenericLauncherPartDefinition.Props;
import com.facebook.video.channelfeed.ChannelFeedHeaderParams;
import com.facebook.video.channelfeed.ChannelFeedParams;
import com.facebook.video.channelfeed.ChannelFeedParams.Builder;
import com.facebook.video.channelfeed.LaunchChannelFeedClickListener;
import com.facebook.video.channelfeed.LaunchChannelFeedClickListenerProvider;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: PLACE_TIP */
public class SearchResultsVideoChannelLargeRowPartDefinition<E extends HasContext & HasSearchResultsContext & HasPositionInformation & OldCanLogEntityNavigation> extends MultiRowSinglePartDefinition<GraphQLGraphSearchResultsEdge, Void, E, ContentView> {
    public static final ViewType<ContentView> f25168a = ViewType.a(2130907660);
    private static SearchResultsVideoChannelLargeRowPartDefinition f25169k;
    private static final Object f25170l = new Object();
    private final SearchBackgroundPartDefinition f25171b;
    private final OldSearchResultsEntityTitlePartDefinition f25172c;
    private final ChannelFeedGenericLauncherPartDefinition f25173d;
    private final ContentViewSubtitlePartDefinition f25174e;
    private final ContentViewContentDescriptionPartDefinition f25175f;
    private final ContentViewMetaTextPartDefinition f25176g;
    private final ContentViewThumbnailUriPartDefinition f25177h;
    private final Lazy<VideoZeroDialogPartDefinition> f25178i;
    private final LaunchChannelFeedClickListenerProvider f25179j;

    private static SearchResultsVideoChannelLargeRowPartDefinition m28452b(InjectorLike injectorLike) {
        return new SearchResultsVideoChannelLargeRowPartDefinition(SearchBackgroundPartDefinition.m27225a(injectorLike), OldSearchResultsEntityTitlePartDefinition.m27686a(injectorLike), ChannelFeedGenericLauncherPartDefinition.a(injectorLike), ContentViewSubtitlePartDefinition.a(injectorLike), ContentViewContentDescriptionPartDefinition.a(injectorLike), ContentViewMetaTextPartDefinition.a(injectorLike), ContentViewThumbnailUriPartDefinition.a(injectorLike), IdBasedLazy.a(injectorLike, 1817), (LaunchChannelFeedClickListenerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(LaunchChannelFeedClickListenerProvider.class));
    }

    public final Object m28455a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final GraphQLGraphSearchResultsEdge graphQLGraphSearchResultsEdge = (GraphQLGraphSearchResultsEdge) obj;
        final HasContext hasContext = (HasContext) anyEnvironment;
        String k = ((HasSearchResultsContext) hasContext).mo1248s().m27102v() != null ? ((HasSearchResultsContext) hasContext).mo1248s().m27102v().mo595k() : null;
        Builder builder = new Builder();
        builder.k = m28453b(graphQLGraphSearchResultsEdge);
        builder = builder.a(graphQLGraphSearchResultsEdge.j().dp());
        builder.d = EntryPointInputVideoChannelEntryPoint.SEARCH;
        builder = builder;
        builder.h = EventTriggerType.BY_USER;
        builder = builder;
        builder.g = PlayerOrigin.SEARCH_RESULTS;
        builder = builder;
        builder.m = k;
        Builder builder2 = builder;
        builder2.l = ExternalLogType.SEARCH_RESULTS;
        ChannelFeedParams a = builder2.a();
        subParts.a(this.f25172c, graphQLGraphSearchResultsEdge.j());
        subParts.a(this.f25174e, SearchResultsEntityUtils.m27757a(graphQLGraphSearchResultsEdge));
        subParts.a(this.f25175f, SearchResultsEntityUtils.m27767c(graphQLGraphSearchResultsEdge));
        subParts.a(this.f25176g, SearchResultsEntityUtils.m27764b(graphQLGraphSearchResultsEdge));
        subParts.a(this.f25177h, SearchResultsEntityUtils.m27766c(graphQLGraphSearchResultsEdge.j()));
        subParts.a(this.f25171b, SearchResultsEntityConstants.f24177b);
        subParts.a(this.f25173d, new Props(a, new AtomicReference(), null));
        SinglePartDefinition singlePartDefinition = (SinglePartDefinition) this.f25178i.get();
        final LaunchChannelFeedClickListener a2 = this.f25179j.a(a, null, new AtomicReference(), null, null);
        subParts.a(singlePartDefinition, new VideoZeroDialogPartDefinition.Props(new OnClickListener(this) {
            final /* synthetic */ SearchResultsVideoChannelLargeRowPartDefinition f25167d;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 14698201);
                ((OldCanLogEntityNavigation) hasContext).mo1251b(graphQLGraphSearchResultsEdge.j());
                a2.onClick(view);
                Logger.a(2, EntryType.UI_INPUT_END, 1496837830, a);
            }
        }));
        return null;
    }

    public final boolean m28456a(Object obj) {
        return ((GraphQLGraphSearchResultsEdge) obj).j() != null;
    }

    public static SearchResultsVideoChannelLargeRowPartDefinition m28451a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsVideoChannelLargeRowPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f25170l) {
                SearchResultsVideoChannelLargeRowPartDefinition searchResultsVideoChannelLargeRowPartDefinition;
                if (a2 != null) {
                    searchResultsVideoChannelLargeRowPartDefinition = (SearchResultsVideoChannelLargeRowPartDefinition) a2.a(f25170l);
                } else {
                    searchResultsVideoChannelLargeRowPartDefinition = f25169k;
                }
                if (searchResultsVideoChannelLargeRowPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28452b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f25170l, b3);
                        } else {
                            f25169k = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsVideoChannelLargeRowPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public SearchResultsVideoChannelLargeRowPartDefinition(SearchBackgroundPartDefinition searchBackgroundPartDefinition, OldSearchResultsEntityTitlePartDefinition oldSearchResultsEntityTitlePartDefinition, ChannelFeedGenericLauncherPartDefinition channelFeedGenericLauncherPartDefinition, ContentViewSubtitlePartDefinition contentViewSubtitlePartDefinition, ContentViewContentDescriptionPartDefinition contentViewContentDescriptionPartDefinition, ContentViewMetaTextPartDefinition contentViewMetaTextPartDefinition, ContentViewThumbnailUriPartDefinition contentViewThumbnailUriPartDefinition, Lazy<VideoZeroDialogPartDefinition> lazy, LaunchChannelFeedClickListenerProvider launchChannelFeedClickListenerProvider) {
        this.f25171b = searchBackgroundPartDefinition;
        this.f25172c = oldSearchResultsEntityTitlePartDefinition;
        this.f25174e = contentViewSubtitlePartDefinition;
        this.f25173d = channelFeedGenericLauncherPartDefinition;
        this.f25175f = contentViewContentDescriptionPartDefinition;
        this.f25176g = contentViewMetaTextPartDefinition;
        this.f25177h = contentViewThumbnailUriPartDefinition;
        this.f25178i = lazy;
        this.f25179j = launchChannelFeedClickListenerProvider;
    }

    public final ViewType<ContentView> m28454a() {
        return f25168a;
    }

    @Nullable
    private static ChannelFeedHeaderParams m28453b(GraphQLGraphSearchResultsEdge graphQLGraphSearchResultsEdge) {
        String str = null;
        GraphQLNode j = graphQLGraphSearchResultsEdge.j();
        Uri c = SearchResultsEntityUtils.m27766c(j);
        if (j == null || c == null) {
            return null;
        }
        CharSequence b = SearchResultsEntityUtils.m27764b(graphQLGraphSearchResultsEdge);
        ChannelFeedHeaderParams.Builder builder = new ChannelFeedHeaderParams.Builder();
        builder.b = j.eP();
        ChannelFeedHeaderParams.Builder builder2 = builder;
        if (b != null) {
            str = b.toString();
        }
        builder2.c = str;
        ChannelFeedHeaderParams.Builder builder3 = builder2;
        builder3.e = c.toString();
        return builder3.a();
    }
}
