package com.facebook.feedplugins.musicstory.albums;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.SizeUtil;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.binding.StoryKeyUtil;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.persistence.ContextStateKey;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.hscrollrecyclerview.HScrollRecyclerViewRowType;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageStyle;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageStyleFactory;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageSubParts;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageSwitcherPartDefinition;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageSwitcherPartDefinition.Controller;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition.Callbacks;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition.Props;
import com.facebook.feed.rows.sections.hscrollrecyclerview.SimpleCallbacks;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BasePaddingStyleResolver;
import com.facebook.feed.rows.styling.DefaultPaddingStyleResolver;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.util.render.FeedRenderUtils;
import com.facebook.feedplugins.musicstory.SingleSongData;
import com.facebook.feedplugins.musicstory.SingleSongData.Builder;
import com.facebook.feedplugins.musicstory.model.AlbumData;
import com.facebook.feedplugins.musicstory.utils.AlbumStoryDataExtractor;
import com.facebook.feedplugins.musicstory.utils.MusicStoryDataExtractor;
import com.facebook.feedplugins.musicstory.utils.MusicStoryLoggerProvider;
import com.facebook.feedplugins.musicstory.utils.MusicStoryLoggingParams;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import javax.annotation.concurrent.Immutable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: composer_group_sale_post_intercept */
public class AlbumSharePartDefinition<V extends View, E extends HasPositionInformation & HasPersistentState & HasInvalidate & HasContext> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Void, E, V> {
    private static AlbumSharePartDefinition f8263k;
    private static final Object f8264l = new Object();
    private final BackgroundPartDefinition f8265a;
    private final PageSwitcherPartDefinition f8266b;
    private final Context f8267c;
    private final BasePaddingStyleResolver f8268d;
    private final FeedRenderUtils f8269e;
    private final PersistentRecyclerPartDefinition<Object, E> f8270f;
    private final PageStyleFactory f8271g;
    public final MusicStoryLoggerProvider f8272h;
    public final SimpleMusicStoryInHScrollPartDefinition f8273i;
    public final ExecutorService f8274j;

    /* compiled from: composer_group_sale_post_intercept */
    public class C10252 implements Runnable {
        final /* synthetic */ HasInvalidate f8258a;
        final /* synthetic */ AlbumSharePartDefinition f8259b;

        public C10252(AlbumSharePartDefinition albumSharePartDefinition, HasInvalidate hasInvalidate) {
            this.f8259b = albumSharePartDefinition;
            this.f8258a = hasInvalidate;
        }

        public void run() {
            this.f8258a.hL_();
        }
    }

    /* compiled from: composer_group_sale_post_intercept */
    public class MusicAlbumStateKey implements ContextStateKey<String, PersistentAlbumState> {
        private static final String f8260a = AlbumSharePartDefinition.class.getName();
        private final String f8261b;

        public MusicAlbumStateKey(String str) {
            Preconditions.checkNotNull(str);
            this.f8261b = f8260a + str;
        }

        public final Object m9206a() {
            return new PersistentAlbumState();
        }

        public final Object m9207b() {
            return this.f8261b;
        }
    }

    @Immutable
    /* compiled from: composer_group_sale_post_intercept */
    public class PersistentAlbumState {
        public int f8262a;
    }

    private static AlbumSharePartDefinition m9212b(InjectorLike injectorLike) {
        return new AlbumSharePartDefinition((Context) injectorLike.getInstance(Context.class), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), (BasePaddingStyleResolver) DefaultPaddingStyleResolver.a(injectorLike), FeedRenderUtils.a(injectorLike), PersistentRecyclerPartDefinition.a(injectorLike), PageStyleFactory.b(injectorLike), (MusicStoryLoggerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(MusicStoryLoggerProvider.class), SimpleMusicStoryInHScrollPartDefinition.m9218a(injectorLike), PageSwitcherPartDefinition.a(injectorLike), BackgroundPartDefinition.a(injectorLike));
    }

    public final Object m9215a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        HasPositionInformation hasPositionInformation = (HasPositionInformation) anyEnvironment;
        float c = 8.0f + ((float) SizeUtil.c(this.f8267c, (float) m9211b()));
        FeedProps e = AttachmentProps.e(feedProps);
        GraphQLStory graphQLStory = (GraphQLStory) e.a;
        StylingData stylingData = new StylingData(e, PageStyle.a);
        AlbumData b = m9213b(feedProps);
        PersistentAlbumState persistentAlbumState = (PersistentAlbumState) ((HasPersistentState) hasPositionInformation).a(new MusicAlbumStateKey(graphQLStory.c()), graphQLStory);
        subParts.a(this.f8265a, stylingData);
        subParts.a(this.f8266b, new Controller());
        subParts.a(this.f8270f, new Props(this.f8271g.a(c, PageStyle.a, true), 0, m9208a((HasInvalidate) hasPositionInformation, b, feedProps, persistentAlbumState), StoryKeyUtil.a(graphQLStory), graphQLStory));
        return null;
    }

    public static AlbumSharePartDefinition m9209a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            AlbumSharePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8264l) {
                AlbumSharePartDefinition albumSharePartDefinition;
                if (a2 != null) {
                    albumSharePartDefinition = (AlbumSharePartDefinition) a2.a(f8264l);
                } else {
                    albumSharePartDefinition = f8263k;
                }
                if (albumSharePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9212b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8264l, b3);
                        } else {
                            f8263k = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = albumSharePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public static boolean m9210a(FeedProps<GraphQLStoryAttachment> feedProps) {
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
        GraphQLNode z = graphQLStoryAttachment.z();
        return (z == null || z.j() == null || z.j().g() != -2027902571 || graphQLStoryAttachment.x() == null || graphQLStoryAttachment.x().size() <= 0) ? false : true;
    }

    @Inject
    public AlbumSharePartDefinition(Context context, ExecutorService executorService, BasePaddingStyleResolver basePaddingStyleResolver, FeedRenderUtils feedRenderUtils, PersistentRecyclerPartDefinition persistentRecyclerPartDefinition, PageStyleFactory pageStyleFactory, MusicStoryLoggerProvider musicStoryLoggerProvider, SimpleMusicStoryInHScrollPartDefinition simpleMusicStoryInHScrollPartDefinition, PageSwitcherPartDefinition pageSwitcherPartDefinition, BackgroundPartDefinition backgroundPartDefinition) {
        this.f8267c = context;
        this.f8274j = executorService;
        this.f8268d = basePaddingStyleResolver;
        this.f8269e = feedRenderUtils;
        this.f8270f = persistentRecyclerPartDefinition;
        this.f8271g = pageStyleFactory;
        this.f8265a = backgroundPartDefinition;
        this.f8266b = pageSwitcherPartDefinition;
        this.f8272h = musicStoryLoggerProvider;
        this.f8273i = simpleMusicStoryInHScrollPartDefinition;
    }

    public final ViewType<V> m9214a() {
        return HScrollRecyclerViewRowType.a;
    }

    private Callbacks<Object, E> m9208a(HasInvalidate hasInvalidate, AlbumData albumData, FeedProps<GraphQLStoryAttachment> feedProps, PersistentAlbumState persistentAlbumState) {
        final FeedProps<GraphQLStoryAttachment> feedProps2 = feedProps;
        final AlbumData albumData2 = albumData;
        final PersistentAlbumState persistentAlbumState2 = persistentAlbumState;
        final HasInvalidate hasInvalidate2 = hasInvalidate;
        return new SimpleCallbacks<E>(this) {
            final /* synthetic */ AlbumSharePartDefinition f8257e;

            public final void m9204a(PageSubParts<E> pageSubParts) {
                boolean z;
                GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps2.a;
                ImmutableList immutableList = albumData2.f8330i;
                Preconditions.checkNotNull(persistentAlbumState2);
                if (immutableList.size() == graphQLStoryAttachment.x().size()) {
                    z = true;
                } else {
                    z = false;
                }
                Preconditions.checkState(z);
                for (int i = 0; i < immutableList.size(); i++) {
                    pageSubParts.a(this.f8257e.f8273i, new SimpleMusicStoryInHScrollPartDefinition.Props((SingleSongData) immutableList.get(i), this.f8257e.f8272h.m9318a(new MusicStoryLoggingParams(feedProps2.a((GraphQLStoryAttachment) graphQLStoryAttachment.x().get(i)))), persistentAlbumState2, i));
                }
            }

            public final void m9205c(int i) {
                persistentAlbumState2.f8262a = i;
                AlbumSharePartDefinition albumSharePartDefinition = this.f8257e;
                ExecutorDetour.a(albumSharePartDefinition.f8274j, new C10252(albumSharePartDefinition, hasInvalidate2), -5184867);
            }
        };
    }

    private AlbumData m9213b(FeedProps<GraphQLStoryAttachment> feedProps) {
        String aa;
        Uri uri;
        AlbumStoryDataExtractor albumStoryDataExtractor = new AlbumStoryDataExtractor((GraphQLStoryAttachment) feedProps.a);
        List arrayList = new ArrayList();
        ImmutableList x = ((GraphQLStoryAttachment) feedProps.a).x();
        int size = x.size();
        for (int i = 0; i < size; i++) {
            MusicStoryDataExtractor musicStoryDataExtractor = new MusicStoryDataExtractor(feedProps.a((GraphQLStoryAttachment) x.get(i)));
            Builder builder = new Builder(musicStoryDataExtractor.m9301a());
            builder.f8215b = musicStoryDataExtractor.m9303c();
            builder = builder;
            builder.f8218e = musicStoryDataExtractor.m9302b();
            builder = builder;
            builder.f8219f = musicStoryDataExtractor.m9304d();
            builder = builder;
            builder.f8223j = musicStoryDataExtractor.m9305e();
            builder = builder;
            builder.f8217d = musicStoryDataExtractor.m9306f();
            builder = builder;
            builder.f8216c = musicStoryDataExtractor.m9307g();
            builder = builder;
            builder.f8220g = musicStoryDataExtractor.m9308h();
            builder = builder;
            builder.f8221h = musicStoryDataExtractor.m9309i();
            builder = builder;
            builder.f8222i = musicStoryDataExtractor.m9310j();
            arrayList.add(builder.m9195a());
        }
        AlbumData.Builder builder2 = new AlbumData.Builder(arrayList);
        if (albumStoryDataExtractor.f8400b.fa() != null) {
            aa = albumStoryDataExtractor.f8400b.fa().aa();
        } else {
            aa = albumStoryDataExtractor.f8400b.U();
        }
        builder2.f8315c = aa;
        builder2 = builder2;
        if (Strings.isNullOrEmpty(albumStoryDataExtractor.f8400b.bs())) {
            uri = null;
        } else {
            uri = Uri.parse(albumStoryDataExtractor.f8400b.bs());
        }
        builder2.f8316d = uri;
        builder2 = builder2;
        if (albumStoryDataExtractor.f8399a.r() == null || albumStoryDataExtractor.f8399a.r().Y() == null) {
            uri = null;
        } else {
            uri = Uri.parse(albumStoryDataExtractor.f8399a.r().Y().b());
        }
        builder2.f8320h = uri;
        builder2 = builder2;
        if (albumStoryDataExtractor.f8400b.W() == null || albumStoryDataExtractor.f8400b.W().isEmpty()) {
            aa = null;
        } else {
            aa = (String) albumStoryDataExtractor.f8400b.W().get(0);
        }
        builder2.f8314b = aa;
        builder2 = builder2;
        builder2.f8313a = albumStoryDataExtractor.f8400b.eL();
        builder2 = builder2;
        if (albumStoryDataExtractor.f8400b.cX() == null || Strings.isNullOrEmpty(albumStoryDataExtractor.f8400b.cX().p())) {
            uri = null;
        } else {
            uri = Uri.parse(albumStoryDataExtractor.f8400b.cX().p());
        }
        builder2.f8317e = uri;
        builder2 = builder2;
        if (albumStoryDataExtractor.f8400b.cX() == null || Strings.isNullOrEmpty(albumStoryDataExtractor.f8400b.cX().H())) {
            uri = null;
        } else {
            uri = Uri.parse(albumStoryDataExtractor.f8400b.cX().H());
        }
        builder2.f8318f = uri;
        builder2 = builder2;
        if (albumStoryDataExtractor.f8400b.fa() == null || albumStoryDataExtractor.f8400b.fa().H() == null) {
            aa = null;
        } else {
            aa = albumStoryDataExtractor.f8400b.fa().H();
        }
        builder2.f8319g = aa;
        return new AlbumData(builder2);
    }

    private int m9211b() {
        return this.f8269e.a(this.f8267c, this.f8268d.a(PaddingStyle.a).d.a(0));
    }
}
