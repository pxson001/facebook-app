package com.facebook.feed.rows.sections;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.fbui.widget.contentview.ContentView.ThumbnailSize;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.feed.util.story.FeedStoryUtil;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.model.GraphQLAYMTChannel;
import com.facebook.graphql.model.GraphQLAYMTTip;
import com.facebook.graphql.model.GraphQLBoostedComponent;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLStory;
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
import com.facebook.multirow.parts.ContentViewSubtitlePartDefinition;
import com.facebook.multirow.parts.ContentViewThumbnailUriPartDefinition;
import com.facebook.multirow.parts.ContentViewTitlePartDefinition;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: \t */
public class StoryAYMTHotPostFooterPartDefinition<E extends HasPositionInformation> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, ContentView> {
    public static final ViewType<ContentView> f20395a = ViewType.a(2130907002);
    public static final String f20396b = StoryAYMTHotPostFooterPartDefinition.class.getSimpleName();
    private static final PaddingStyle f20397c;
    private static StoryAYMTHotPostFooterPartDefinition f20398k;
    private static final Object f20399l = new Object();
    private final FeedStoryUtil f20400d;
    private final AbstractFbErrorReporter f20401e;
    private final GraphQLQueryExecutor f20402f;
    private final ContentViewThumbnailUriPartDefinition f20403g;
    private final ContentViewTitlePartDefinition f20404h;
    private final ContentViewSubtitlePartDefinition f20405i;
    private final BackgroundPartDefinition f20406j;

    private static StoryAYMTHotPostFooterPartDefinition m23520b(InjectorLike injectorLike) {
        return new StoryAYMTHotPostFooterPartDefinition(FeedStoryUtil.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), BackgroundPartDefinition.a(injectorLike), ContentViewThumbnailUriPartDefinition.m9515a(injectorLike), ContentViewTitlePartDefinition.m9521a(injectorLike), ContentViewSubtitlePartDefinition.m9512a(injectorLike));
    }

    public final Object m23530a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        GraphQLStory graphQLStory = (GraphQLStory) ((FeedProps) obj).a;
        String j = m23525j(graphQLStory);
        String k = m23526k(graphQLStory);
        GraphQLImage i = m23524i(graphQLStory);
        subParts.a(this.f20406j, new StylingData(null, f20397c, 2131361941, 2131361941));
        subParts.a(this.f20404h, j);
        subParts.a(this.f20405i, k);
        subParts.a(this.f20403g, Uri.parse(i.b()));
        m23521d(graphQLStory);
        return null;
    }

    public final /* bridge */ /* synthetic */ void m23531a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1012944854);
        ContentView contentView = (ContentView) view;
        contentView.setThumbnailSize(ThumbnailSize.XSMALL);
        contentView.setTitleTextAppearance(2131624223);
        contentView.setSubtitleTextAppearance(2131624222);
        contentView.setMaxLinesFromThumbnailSize(false);
        contentView.e(100, 100);
        Logger.a(8, EntryType.MARK_POP, 379304696, a);
    }

    public final boolean m23532a(Object obj) {
        GraphQLStory graphQLStory = (GraphQLStory) ((FeedProps) obj).a;
        if (this.f20400d.c(graphQLStory)) {
            Object obj2;
            if (StringUtil.a(m23525j(graphQLStory))) {
                m23519a(this, graphQLStory, "titleText is empty or null");
                obj2 = null;
            } else {
                obj2 = 1;
            }
            if (obj2 != null) {
                if (StringUtil.a(m23526k(graphQLStory))) {
                    m23519a(this, graphQLStory, "subtitleText is empty or null");
                    obj2 = null;
                } else {
                    obj2 = 1;
                }
                if (obj2 != null) {
                    obj2 = null;
                    GraphQLImage i = m23524i(graphQLStory);
                    if (i == null) {
                        m23519a(this, graphQLStory, "image is null");
                    } else if (StringUtil.a(i.b())) {
                        m23519a(this, graphQLStory, "image uri is empty or null");
                    } else {
                        obj2 = 1;
                    }
                    if (obj2 != null) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    static {
        Builder a = Builder.a();
        a.b = 6.0f;
        a = a;
        a.c = 6.0f;
        f20397c = a.i();
    }

    public static StoryAYMTHotPostFooterPartDefinition m23518a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            StoryAYMTHotPostFooterPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20399l) {
                StoryAYMTHotPostFooterPartDefinition storyAYMTHotPostFooterPartDefinition;
                if (a2 != null) {
                    storyAYMTHotPostFooterPartDefinition = (StoryAYMTHotPostFooterPartDefinition) a2.a(f20399l);
                } else {
                    storyAYMTHotPostFooterPartDefinition = f20398k;
                }
                if (storyAYMTHotPostFooterPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23520b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20399l, b3);
                        } else {
                            f20398k = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = storyAYMTHotPostFooterPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public StoryAYMTHotPostFooterPartDefinition(FeedStoryUtil feedStoryUtil, AbstractFbErrorReporter abstractFbErrorReporter, GraphQLQueryExecutor graphQLQueryExecutor, BackgroundPartDefinition backgroundPartDefinition, ContentViewThumbnailUriPartDefinition contentViewThumbnailUriPartDefinition, ContentViewTitlePartDefinition contentViewTitlePartDefinition, ContentViewSubtitlePartDefinition contentViewSubtitlePartDefinition) {
        this.f20400d = feedStoryUtil;
        this.f20403g = contentViewThumbnailUriPartDefinition;
        this.f20404h = contentViewTitlePartDefinition;
        this.f20405i = contentViewSubtitlePartDefinition;
        this.f20406j = backgroundPartDefinition;
        this.f20401e = abstractFbErrorReporter;
        this.f20402f = graphQLQueryExecutor;
    }

    public final ViewType<ContentView> m23529a() {
        return f20395a;
    }

    public static void m23519a(StoryAYMTHotPostFooterPartDefinition storyAYMTHotPostFooterPartDefinition, GraphQLStory graphQLStory, String str) {
        if (m23527l(graphQLStory) != null) {
            storyAYMTHotPostFooterPartDefinition.f20401e.a(f20396b, str);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m23521d(final com.facebook.graphql.model.GraphQLStory r5) {
        /*
        r4 = this;
        r3 = m23523h(r5);
        r3 = com.facebook.common.util.StringUtil.a(r3);
        if (r3 == 0) goto L_0x0083;
    L_0x000a:
        r3 = "AYMT Channel id is null or empty";
        m23519a(r4, r5, r3);
        r3 = 0;
    L_0x0010:
        r0 = r3;
        if (r0 == 0) goto L_0x0026;
    L_0x0013:
        r3 = m23522g(r5);
        r3 = com.facebook.common.util.StringUtil.a(r3);
        if (r3 == 0) goto L_0x0085;
    L_0x001d:
        r3 = "AYMT Tip id is null or empty";
        m23519a(r4, r5, r3);
        r3 = 0;
    L_0x0023:
        r0 = r3;
        if (r0 != 0) goto L_0x004a;
    L_0x0026:
        r0 = new java.lang.StringBuilder;
        r1 = "Cannot log impression: channel id = ";
        r0.<init>(r1);
        r1 = m23523h(r5);
        r0 = r0.append(r1);
        r1 = " tip id = ";
        r0 = r0.append(r1);
        r1 = m23522g(r5);
        r0 = r0.append(r1);
        r0 = r0.toString();
        m23519a(r4, r5, r0);
    L_0x004a:
        r3 = new com.facebook.api.graphql.storypromotion.NewsFeedStoryPromotionMutation$AYMTLogEventMutationString;
        r3.<init>();
        r0 = r3;
        r1 = new com.facebook.graphql.calls.AymtLogEventInputData;
        r1.<init>();
        r2 = m23523h(r5);
        r1 = r1.a(r2);
        r2 = com.facebook.graphql.calls.AymtLogEventInputData.EventType.IMPRESSION;
        r1 = r1.a(r2);
        r2 = m23522g(r5);
        r1 = r1.b(r2);
        r2 = "input";
        r0.a(r2, r1);
        r0 = com.facebook.graphql.executor.GraphQLRequest.a(r0);
        r1 = r4.f20402f;
        r0 = r1.a(r0);
        r1 = new com.facebook.feed.rows.sections.StoryAYMTHotPostFooterPartDefinition$1;
        r1.<init>(r4, r5);
        com.google.common.util.concurrent.Futures.a(r0, r1);
        return;
    L_0x0083:
        r3 = 1;
        goto L_0x0010;
    L_0x0085:
        r3 = 1;
        goto L_0x0023;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.rows.sections.StoryAYMTHotPostFooterPartDefinition.d(com.facebook.graphql.model.GraphQLStory):void");
    }

    @Nullable
    public static String m23522g(GraphQLStory graphQLStory) {
        GraphQLAYMTTip l = m23527l(graphQLStory);
        return l == null ? null : l.o();
    }

    @Nullable
    public static String m23523h(GraphQLStory graphQLStory) {
        GraphQLAYMTChannel m = m23528m(graphQLStory);
        return m == null ? null : m.j();
    }

    @Nullable
    public static GraphQLImage m23524i(GraphQLStory graphQLStory) {
        return m23527l(graphQLStory) == null ? null : m23527l(graphQLStory).m();
    }

    @Nullable
    public static String m23525j(GraphQLStory graphQLStory) {
        return m23527l(graphQLStory) == null ? null : m23527l(graphQLStory).p();
    }

    @Nullable
    public static String m23526k(GraphQLStory graphQLStory) {
        return m23527l(graphQLStory) == null ? null : m23527l(graphQLStory).l();
    }

    @Nullable
    private static GraphQLAYMTTip m23527l(GraphQLStory graphQLStory) {
        GraphQLAYMTChannel m = m23528m(graphQLStory);
        if (m == null) {
            return null;
        }
        ImmutableList k = m.k();
        if (k.isEmpty()) {
            return null;
        }
        return (GraphQLAYMTTip) k.get(0);
    }

    @Nullable
    private static GraphQLAYMTChannel m23528m(GraphQLStory graphQLStory) {
        GraphQLBoostedComponent an = graphQLStory.an();
        return an == null ? null : an.t();
    }
}
