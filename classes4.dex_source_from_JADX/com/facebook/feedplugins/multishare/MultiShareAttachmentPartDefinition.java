package com.facebook.feedplugins.multishare;

import android.content.Context;
import android.text.TextUtils;
import android.util.TypedValue;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.SizeUtil;
import com.facebook.device.ScreenUtil;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.persistence.ContextStateKey;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.feed.rows.sections.hscrollrecyclerview.HScrollRecyclerViewRowType;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageStyle;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageStyleFactory;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageSubParts;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition$Callbacks;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition$Props;
import com.facebook.feed.rows.sections.hscrollrecyclerview.SimpleCallbacks;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.feedplugins.multishare.abtest.ExperimentsForMultiShareAbTestModule;
import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;
import com.facebook.graphql.model.GraphQLVideo;
import com.facebook.graphql.model.conversion.GraphQLMediaConversionHelper;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.video.channelfeed.MultiShareNoLinkUtil;
import com.facebook.widget.hscrollrecyclerview.HScrollRecyclerView;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: never */
public class MultiShareAttachmentPartDefinition<E extends HasFeedListType & HasInvalidate & HasPersistentState & HasPositionInformation & HasPrefetcher & HasContext> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Void, E, HScrollRecyclerView> {
    public static final CallerContext f7171a = CallerContext.a(MultiShareAttachmentPartDefinition.class, "native_newsfeed");
    private static MultiShareAttachmentPartDefinition f7172p;
    private static final Object f7173q = new Object();
    private final Context f7174b;
    public final MultiShareBusinessLocationItemPartDefinition f7175c;
    private final BackgroundPartDefinition f7176d;
    public final MultiShareProductItemPartDefinition<E> f7177e;
    public final MultiShareEndItemPartDefinition<E> f7178f;
    private final PageStyleFactory f7179g;
    public final NewsFeedAnalyticsEventBuilder f7180h;
    public final AnalyticsLogger f7181i;
    private final PersistentRecyclerPartDefinition<Object, E> f7182j;
    private final ScreenUtil f7183k;
    private final QeAccessor f7184l;
    private final float f7185m;
    private final float f7186n = ((float) Math.min(this.f7183k.c(), this.f7183k.d()));
    private final float f7187o;

    /* compiled from: never */
    public class MultiSharePersistentKey implements ContextStateKey<String, MultiSharePersistentState> {
        private final String f13884a;

        public MultiSharePersistentKey(FeedProps<GraphQLStoryAttachment> feedProps) {
            this.f13884a = getClass() + AttachmentProps.c(feedProps).g();
        }

        public final Object m14673b() {
            return this.f13884a;
        }

        public final Object m14672a() {
            return new MultiSharePersistentState();
        }
    }

    /* compiled from: never */
    public class MultiSharePersistentState {
        public int f13885a = 0;

        public final int m14674a() {
            return this.f13885a;
        }
    }

    private static MultiShareAttachmentPartDefinition m7504b(InjectorLike injectorLike) {
        return new MultiShareAttachmentPartDefinition((Context) injectorLike.getInstance(Context.class), MultiShareBusinessLocationItemPartDefinition.m7510a(injectorLike), BackgroundPartDefinition.a(injectorLike), MultiShareProductItemPartDefinition.m7538a(injectorLike), MultiShareEndItemPartDefinition.m7563a(injectorLike), PageStyleFactory.b(injectorLike), NewsFeedAnalyticsEventBuilder.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), ScreenUtil.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), PersistentRecyclerPartDefinition.a(injectorLike));
    }

    public static MultiShareAttachmentPartDefinition m7500a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            MultiShareAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f7173q) {
                MultiShareAttachmentPartDefinition multiShareAttachmentPartDefinition;
                if (a2 != null) {
                    multiShareAttachmentPartDefinition = (MultiShareAttachmentPartDefinition) a2.a(f7173q);
                } else {
                    multiShareAttachmentPartDefinition = f7172p;
                }
                if (multiShareAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m7504b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f7173q, b3);
                        } else {
                            f7172p = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = multiShareAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final Object m7507a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        CacheableEntity cacheableEntity;
        PaddingStyle i;
        FeedProps feedProps = (FeedProps) obj;
        HasFeedListType hasFeedListType = (HasFeedListType) anyEnvironment;
        float f = this.f7186n * this.f7187o;
        float b = f / m7503b((GraphQLStoryAttachment) feedProps.a);
        FeedProps e = AttachmentProps.e(feedProps);
        if (e == null) {
            cacheableEntity = null;
        } else {
            GraphQLStory graphQLStory = (GraphQLStory) e.a();
        }
        MultiSharePersistentState multiSharePersistentState = (MultiSharePersistentState) ((HasPersistentState) hasFeedListType).a(new MultiSharePersistentKey(feedProps), cacheableEntity);
        if (MultiShareNoLinkUtil.m14670b((GraphQLStoryAttachment) feedProps.a())) {
            Builder g = Builder.g();
            g.c = 0.0f;
            i = g.i();
        } else {
            i = PageStyle.f13886a;
        }
        subParts.a(this.f7176d, new StylingData(e, i));
        PersistentRecyclerPartDefinition persistentRecyclerPartDefinition = this.f7182j;
        PageStyle a = this.f7179g.a(this.f7185m + 8.0f, PageStyle.f13886a, true);
        PageStyle pageStyle = a;
        int a2 = multiSharePersistentState.m14674a();
        subParts.a(persistentRecyclerPartDefinition, new PersistentRecyclerPartDefinition$Props(pageStyle, a2, m7499a(feedProps, multiSharePersistentState, this.f7185m, b, f), "MultiShareAttachmentPartDefinition" + AttachmentProps.c(feedProps).g(), AttachmentProps.c(feedProps)));
        return null;
    }

    @Inject
    public MultiShareAttachmentPartDefinition(Context context, MultiShareBusinessLocationItemPartDefinition multiShareBusinessLocationItemPartDefinition, BackgroundPartDefinition backgroundPartDefinition, MultiShareProductItemPartDefinition multiShareProductItemPartDefinition, MultiShareEndItemPartDefinition multiShareEndItemPartDefinition, PageStyleFactory pageStyleFactory, NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder, AnalyticsLogger analyticsLogger, ScreenUtil screenUtil, QeAccessor qeAccessor, PersistentRecyclerPartDefinition persistentRecyclerPartDefinition) {
        this.f7175c = multiShareBusinessLocationItemPartDefinition;
        this.f7176d = backgroundPartDefinition;
        this.f7174b = context;
        this.f7177e = multiShareProductItemPartDefinition;
        this.f7178f = multiShareEndItemPartDefinition;
        this.f7179g = pageStyleFactory;
        this.f7182j = persistentRecyclerPartDefinition;
        this.f7180h = newsFeedAnalyticsEventBuilder;
        this.f7181i = analyticsLogger;
        this.f7183k = screenUtil;
        this.f7184l = qeAccessor;
        TypedValue typedValue = new TypedValue();
        this.f7174b.getResources().getValue(2131429038, typedValue, true);
        float c = (float) SizeUtil.c(this.f7174b, (float) ((int) this.f7174b.getResources().getDimension(2131429029)));
        this.f7187o = typedValue.getFloat();
        this.f7185m = (typedValue.getFloat() * ((float) SizeUtil.c(this.f7174b, this.f7186n))) + (c * 2.0f);
    }

    public final ViewType m7506a() {
        return HScrollRecyclerViewRowType.f11901a;
    }

    public final boolean m7508a(Object obj) {
        return true;
    }

    private PersistentRecyclerPartDefinition$Callbacks<Object, E> m7499a(final FeedProps<GraphQLStoryAttachment> feedProps, final MultiSharePersistentState multiSharePersistentState, float f, float f2, float f3) {
        final ImmutableList a = m7501a(feedProps, f, f2, f3);
        return new SimpleCallbacks<E>(this) {
            final /* synthetic */ MultiShareAttachmentPartDefinition f13910d;

            public final void mo566a(PageSubParts<E> pageSubParts) {
                int size = a.size();
                for (int i = 0; i < size; i++) {
                    MultiShareAttachmentItemViewModel multiShareAttachmentItemViewModel = (MultiShareAttachmentItemViewModel) a.get(i);
                    if (multiShareAttachmentItemViewModel.f13901e) {
                        pageSubParts.m14702a(this.f13910d.f7178f, multiShareAttachmentItemViewModel);
                    } else if (GraphQLStoryAttachmentUtil.a((GraphQLStoryAttachment) multiShareAttachmentItemViewModel.f13897a.a, GraphQLStoryAttachmentStyle.BUSINESS_LOCATION)) {
                        pageSubParts.m14702a(this.f13910d.f7175c, multiShareAttachmentItemViewModel);
                    } else {
                        pageSubParts.m14702a(this.f13910d.f7177e, multiShareAttachmentItemViewModel);
                    }
                }
            }

            public final void m14698c(int i) {
                HoneyAnalyticsEvent honeyAnalyticsEvent;
                FeedProps e = AttachmentProps.e(feedProps);
                Preconditions.a(e);
                multiSharePersistentState.f13885a = i;
                NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder = this.f13910d.f7180h;
                boolean p = StoryProps.p(e);
                int a = MultiShareAttachmentPartDefinition.m7498a((GraphQLStoryAttachment) feedProps.a, i);
                ArrayNode a2 = TrackableFeedProps.a(e);
                if (NewsFeedAnalyticsEventBuilder.B(a2)) {
                    honeyAnalyticsEvent = null;
                } else {
                    HoneyClientEvent b = new HoneyClientEvent("multishare_item_imp").a("tracking", a2).a("scroll_index", a).b(p);
                    b.c = "native_newsfeed";
                    honeyAnalyticsEvent = b;
                }
                this.f13910d.f7181i.c(honeyAnalyticsEvent);
            }
        };
    }

    private ImmutableList<MultiShareAttachmentItemViewModel> m7501a(FeedProps<GraphQLStoryAttachment> feedProps, float f, float f2, float f3) {
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a();
        ImmutableList.Builder builder = ImmutableList.builder();
        int i = 0;
        boolean z = !m7505c(graphQLStoryAttachment);
        boolean z2 = m7502a(graphQLStoryAttachment) || MultiShareNoLinkUtil.m14670b(graphQLStoryAttachment);
        ImmutableList x = graphQLStoryAttachment.x();
        int size = x.size();
        for (int i2 = 0; i2 < size; i2++) {
            builder.c(new MultiShareAttachmentItemViewModel(feedProps.a((GraphQLStoryAttachment) x.get(i2)), i, m7498a(graphQLStoryAttachment, i), false, z, z2, f, f2, f3));
            i++;
        }
        if (!GraphQLStoryAttachmentUtil.a(graphQLStoryAttachment, GraphQLStoryAttachmentStyle.MULTI_SHARE_NO_END_CARD)) {
            builder.c(new MultiShareAttachmentItemViewModel(feedProps, i, m7498a(graphQLStoryAttachment, i), true, false, false, f, f2, f3));
        }
        return builder.b();
    }

    private boolean m7502a(GraphQLStoryAttachment graphQLStoryAttachment) {
        if (MultiShareNoLinkUtil.m14667a(graphQLStoryAttachment)) {
            return this.f7184l.a(ExperimentsForMultiShareAbTestModule.f4217b, false);
        }
        return false;
    }

    private float m7503b(GraphQLStoryAttachment graphQLStoryAttachment) {
        if (!m7502a(graphQLStoryAttachment)) {
            return 1.0f;
        }
        float f = Float.MAX_VALUE;
        for (GraphQLStoryAttachment graphQLStoryAttachment2 : graphQLStoryAttachment.x()) {
            if (GraphQLStoryAttachmentUtil.p(graphQLStoryAttachment2)) {
                GraphQLVideo b = GraphQLMediaConversionHelper.b(graphQLStoryAttachment2.r());
                if (b.I() > 0 && b.bw() > 0) {
                    float bw = ((float) b.bw()) / ((float) b.I());
                    if (bw >= f) {
                        bw = f;
                    }
                    f = bw;
                }
            }
        }
        return f < 0.1f ? 1.0f : f;
    }

    private static boolean m7505c(GraphQLStoryAttachment graphQLStoryAttachment) {
        ImmutableList x = graphQLStoryAttachment.x();
        int size = x.size();
        for (int i = 0; i < size; i++) {
            Object obj;
            GraphQLStoryAttachment graphQLStoryAttachment2 = (GraphQLStoryAttachment) x.get(i);
            if (graphQLStoryAttachment2.n() == null || TextUtils.isEmpty(graphQLStoryAttachment2.n().a())) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                return true;
            }
        }
        return false;
    }

    public static int m7498a(GraphQLStoryAttachment graphQLStoryAttachment, int i) {
        boolean z;
        if (i < 0 || i > graphQLStoryAttachment.x().size()) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.a(z);
        if (i == graphQLStoryAttachment.x().size()) {
            return 0;
        }
        return i + 1;
    }
}
