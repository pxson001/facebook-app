package com.facebook.feed.util.composer.launch;

import android.app.Activity;
import android.content.res.Resources;
import android.support.v4.app.FragmentManager;
import com.facebook.audiofingerprinting.MusicMetadata;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.util.StringUtil;
import com.facebook.composer.capability.ComposerFacecastCapability;
import com.facebook.composer.minutiae.music.MusicMetadataHelper;
import com.facebook.debug.log.BLog;
import com.facebook.facecast.abtest.ExperimentsForFacecastAbtestModule;
import com.facebook.feed.util.composer.abtest.ExperimentsForFeedUtilComposerAbtestModule;
import com.facebook.feed.util.composer.sprout.InlineComposerSproutFragment;
import com.facebook.feed.util.composer.sprout.SproutAnalyticsLogger;
import com.facebook.feed.util.composer.sprout.SproutAnalyticsLogger.SproutSource;
import com.facebook.feed.util.composer.sprout.SproutAnalyticsLoggerProvider;
import com.facebook.feed.util.composer.sprout.SproutSpec;
import com.facebook.feed.util.composer.sprout.SproutSpec.Builder;
import com.facebook.feed.util.composer.sprout.SproutSpec.Style;
import com.facebook.feed.util.composer.sprout.header.InlineComposerHeaderControllerProvider;
import com.facebook.friendsharing.listeningto.nux.ListeningToNuxController;
import com.facebook.graphql.model.GraphQLExploreFeed;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.ipc.composer.model.TargetType;
import com.facebook.platformattribution.PlatformAttributionLaunchHelper;
import com.facebook.platformattribution.nux.LayoutNuxDialogFragment;
import com.facebook.qe.api.QeAccessor;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: TWO_SQUARE_ITEMS */
public class SproutLauncher {
    private static final ImmutableList<Fab> f22382a = ImmutableList.of(Fab.STATUS, Fab.GALLERY, Fab.MINUTIAE, Fab.LOCATION);
    private static final String f22383b = SproutLauncher.class.getSimpleName();
    public final QeAccessor f22384c;
    public final FeedComposerLauncher f22385d;
    public final Resources f22386e;
    public final PlatformAttributionLaunchHelper f22387f;
    public final FragmentManager f22388g;
    public final Activity f22389h;
    private final SproutSource f22390i;
    public final MusicMetadataHelper f22391j;
    public final ListeningToNuxController f22392k;
    private final InlineComposerHeaderControllerProvider f22393l;
    public final Lazy<ComposerFacecastCapability> f22394m;
    private SproutAnalyticsLoggerProvider f22395n;
    public SproutAnalyticsLogger f22396o;

    /* compiled from: TWO_SQUARE_ITEMS */
    public class AnonymousClass10 implements Runnable {
        final /* synthetic */ String f22350a;
        final /* synthetic */ SproutLauncher f22351b;

        public AnonymousClass10(SproutLauncher sproutLauncher, String str) {
            this.f22351b = sproutLauncher;
            this.f22350a = str;
        }

        public void run() {
            this.f22351b.f22385d.m24968e(Optional.of(this.f22350a), this.f22351b.f22389h);
        }
    }

    /* compiled from: TWO_SQUARE_ITEMS */
    public class AnonymousClass11 implements Runnable {
        final /* synthetic */ String f22352a;
        final /* synthetic */ SproutLauncher f22353b;

        public AnonymousClass11(SproutLauncher sproutLauncher, String str) {
            this.f22353b = sproutLauncher;
            this.f22352a = str;
        }

        public void run() {
            this.f22353b.f22385d.m24969f(Optional.of(this.f22352a), this.f22353b.f22389h);
        }
    }

    /* compiled from: TWO_SQUARE_ITEMS */
    public class AnonymousClass12 implements Runnable {
        final /* synthetic */ String f22354a;
        final /* synthetic */ SproutLauncher f22355b;

        public AnonymousClass12(SproutLauncher sproutLauncher, String str) {
            this.f22355b = sproutLauncher;
            this.f22354a = str;
        }

        public void run() {
            if (this.f22355b.f22384c.a(ExperimentsForFacecastAbtestModule.f2796q, false)) {
                this.f22355b.f22385d.m24962b(Optional.of(this.f22354a), this.f22355b.f22389h);
            } else {
                this.f22355b.f22385d.m24953a(this.f22355b.f22389h);
            }
        }
    }

    /* compiled from: TWO_SQUARE_ITEMS */
    public class C19132 implements Runnable {
        final /* synthetic */ String f22360a;
        final /* synthetic */ ImmutableList f22361b;
        final /* synthetic */ GraphQLExploreFeed f22362c;
        final /* synthetic */ SproutLauncher f22363d;

        public C19132(SproutLauncher sproutLauncher, String str, ImmutableList immutableList, GraphQLExploreFeed graphQLExploreFeed) {
            this.f22363d = sproutLauncher;
            this.f22360a = str;
            this.f22361b = immutableList;
            this.f22362c = graphQLExploreFeed;
        }

        public void run() {
            this.f22363d.f22385d.m24963b(Optional.of(this.f22360a), this.f22363d.f22389h, this.f22361b, this.f22362c);
        }
    }

    /* compiled from: TWO_SQUARE_ITEMS */
    public class C19143 implements Runnable {
        final /* synthetic */ String f22364a;
        final /* synthetic */ ImmutableList f22365b;
        final /* synthetic */ GraphQLExploreFeed f22366c;
        final /* synthetic */ SproutLauncher f22367d;

        public C19143(SproutLauncher sproutLauncher, String str, ImmutableList immutableList, GraphQLExploreFeed graphQLExploreFeed) {
            this.f22367d = sproutLauncher;
            this.f22364a = str;
            this.f22365b = immutableList;
            this.f22366c = graphQLExploreFeed;
        }

        public void run() {
            this.f22367d.f22385d.m24967d(Optional.of(this.f22364a), this.f22367d.f22389h, this.f22365b, this.f22366c);
        }
    }

    /* compiled from: TWO_SQUARE_ITEMS */
    public class C19154 implements Runnable {
        final /* synthetic */ String f22368a;
        final /* synthetic */ SproutLauncher f22369b;

        public C19154(SproutLauncher sproutLauncher, String str) {
            this.f22369b = sproutLauncher;
            this.f22368a = str;
        }

        public void run() {
            this.f22369b.f22385d.m24966d(Optional.of(this.f22368a), this.f22369b.f22389h);
        }
    }

    /* compiled from: TWO_SQUARE_ITEMS */
    public class C19165 implements Runnable {
        final /* synthetic */ MusicMetadata f22370a;
        final /* synthetic */ String f22371b;
        final /* synthetic */ SproutLauncher f22372c;

        public C19165(SproutLauncher sproutLauncher, MusicMetadata musicMetadata, String str) {
            this.f22372c = sproutLauncher;
            this.f22370a = musicMetadata;
            this.f22371b = str;
        }

        public void run() {
            SproutLauncher sproutLauncher = this.f22372c;
            if (SproutLauncher.m24972a(this.f22370a)) {
                if (this.f22372c.f22396o != null) {
                    this.f22372c.f22396o.m25027b();
                }
                this.f22372c.f22385d.m24955a(Optional.of(this.f22371b), this.f22372c.f22389h, this.f22370a);
                return;
            }
            this.f22372c.f22385d.m24964c(Optional.of(this.f22371b), this.f22372c.f22389h);
        }
    }

    /* compiled from: TWO_SQUARE_ITEMS */
    public class C19176 implements Runnable {
        final /* synthetic */ SproutLauncher f22373a;

        public C19176(SproutLauncher sproutLauncher) {
            this.f22373a = sproutLauncher;
        }

        public void run() {
            this.f22373a.f22387f.b("sprout", "881555691867714", "com.instagram.layout");
            if (this.f22373a.f22387f.a("com.instagram.layout")) {
                this.f22373a.f22387f.a("881555691867714", "com.instagram.layout", this.f22373a.f22389h);
            } else {
                new LayoutNuxDialogFragment().a(this.f22373a.f22388g, LayoutNuxDialogFragment.class.getSimpleName());
            }
        }
    }

    /* compiled from: TWO_SQUARE_ITEMS */
    public class C19187 implements Runnable {
        final /* synthetic */ String f22374a;
        final /* synthetic */ SproutLauncher f22375b;

        public C19187(SproutLauncher sproutLauncher, String str) {
            this.f22375b = sproutLauncher;
            this.f22374a = str;
        }

        public void run() {
            this.f22375b.f22385d.m24957a(Optional.of(this.f22374a), this.f22375b.f22388g);
        }
    }

    /* compiled from: TWO_SQUARE_ITEMS */
    public class C19198 implements Runnable {
        final /* synthetic */ String f22376a;
        final /* synthetic */ ImmutableList f22377b;
        final /* synthetic */ GraphQLExploreFeed f22378c;
        final /* synthetic */ SproutLauncher f22379d;

        public C19198(SproutLauncher sproutLauncher, String str, ImmutableList immutableList, GraphQLExploreFeed graphQLExploreFeed) {
            this.f22379d = sproutLauncher;
            this.f22376a = str;
            this.f22377b = immutableList;
            this.f22378c = graphQLExploreFeed;
        }

        public void run() {
            this.f22379d.f22385d.m24965c(Optional.of(this.f22376a), this.f22379d.f22389h, this.f22377b, this.f22378c);
        }
    }

    /* compiled from: TWO_SQUARE_ITEMS */
    public class C19209 implements Runnable {
        final /* synthetic */ String f22380a;
        final /* synthetic */ SproutLauncher f22381b;

        public C19209(SproutLauncher sproutLauncher, String str) {
            this.f22381b = sproutLauncher;
            this.f22380a = str;
        }

        public void run() {
            this.f22381b.f22385d.m24961a(Optional.of(this.f22380a), this.f22381b.f22384c.a(ExperimentsForFeedUtilComposerAbtestModule.d, 2131234554, this.f22381b.f22386e), this.f22381b.f22389h);
        }
    }

    /* compiled from: TWO_SQUARE_ITEMS */
    public enum Fab {
        STATUS {
            final SproutSpec getSpec(SproutLauncher sproutLauncher, String str, ImmutableList<GraphQLExploreFeed> immutableList, GraphQLExploreFeed graphQLExploreFeed) {
                return SproutLauncher.m24973b(sproutLauncher, str, immutableList, graphQLExploreFeed);
            }
        },
        GALLERY {
            final SproutSpec getSpec(SproutLauncher sproutLauncher, String str, ImmutableList<GraphQLExploreFeed> immutableList, GraphQLExploreFeed graphQLExploreFeed) {
                return SproutSpec.m25061a(2131362972, 2130839750, sproutLauncher.f22384c.a(ExperimentsForFeedUtilComposerAbtestModule.e, 2131234821, sproutLauncher.f22386e), "gallery", new C19132(sproutLauncher, str, immutableList, graphQLExploreFeed)).m25060a();
            }
        },
        INSTAGRAM_LAYOUT {
            final SproutSpec getSpec(SproutLauncher sproutLauncher, String str, ImmutableList<GraphQLExploreFeed> immutableList, GraphQLExploreFeed graphQLExploreFeed) {
                sproutLauncher.f22387f.a("sprout", "881555691867714", "com.instagram.layout");
                Builder a = SproutSpec.m25061a(2131362978, 2130840968, sproutLauncher.f22386e.getString(2131234830), "instagram_layout", new C19176(sproutLauncher));
                a.f22458g = Style.OUTLINE;
                a = a;
                a.f22460i = true;
                a = a;
                a.f22459h = null;
                return a.m25060a();
            }
        },
        LOCATION {
            final SproutSpec getSpec(SproutLauncher sproutLauncher, String str, ImmutableList<GraphQLExploreFeed> immutableList, GraphQLExploreFeed graphQLExploreFeed) {
                return SproutSpec.m25061a(2131362974, 2130839970, sproutLauncher.f22384c.a(ExperimentsForFeedUtilComposerAbtestModule.P, 2131234823, sproutLauncher.f22386e), "location", new C19143(sproutLauncher, str, immutableList, graphQLExploreFeed)).m25060a();
            }
        },
        APP {
            final SproutSpec getSpec(SproutLauncher sproutLauncher, String str, ImmutableList<GraphQLExploreFeed> immutableList, GraphQLExploreFeed graphQLExploreFeed) {
                return SproutSpec.m25061a(2131362982, 2130839693, sproutLauncher.f22384c.a(ExperimentsForFeedUtilComposerAbtestModule.P, 2131234838, sproutLauncher.f22386e), "app", new C19154(sproutLauncher, str)).m25060a();
            }
        },
        ADD_STICKER {
            final SproutSpec getSpec(SproutLauncher sproutLauncher, String str, ImmutableList<GraphQLExploreFeed> immutableList, GraphQLExploreFeed graphQLExploreFeed) {
                Builder a = SproutSpec.m25061a(2131362976, 2130840115, sproutLauncher.f22386e.getString(2131234831), "add_sticker", new C19187(sproutLauncher, str));
                a.f22460i = true;
                return a.m25060a();
            }
        },
        MINUTIAE {
            final SproutSpec getSpec(SproutLauncher sproutLauncher, String str, ImmutableList<GraphQLExploreFeed> immutableList, GraphQLExploreFeed graphQLExploreFeed) {
                return SproutSpec.m25061a(2131362980, 2130843443, sproutLauncher.f22384c.a(ExperimentsForFeedUtilComposerAbtestModule.R, 2131234832, sproutLauncher.f22386e), "minutiae", new C19198(sproutLauncher, str, immutableList, graphQLExploreFeed)).m25060a();
            }
        },
        FEELING {
            final SproutSpec getSpec(SproutLauncher sproutLauncher, String str, ImmutableList<GraphQLExploreFeed> immutableList, GraphQLExploreFeed graphQLExploreFeed) {
                return SproutSpec.m25061a(2131362980, 2130843443, sproutLauncher.f22384c.a(ExperimentsForFeedUtilComposerAbtestModule.c, 2131234833, sproutLauncher.f22386e), "feeling", new C19209(sproutLauncher, str)).m25060a();
            }
        },
        LISTENING_TO {
            final SproutSpec getSpec(SproutLauncher sproutLauncher, String str, ImmutableList<GraphQLExploreFeed> immutableList, GraphQLExploreFeed graphQLExploreFeed) {
                MusicMetadata musicMetadata = (MusicMetadata) sproutLauncher.f22391j.m1651b().orNull();
                String str2 = null;
                if (SproutLauncher.m24972a(musicMetadata)) {
                    if (sproutLauncher.f22396o != null) {
                        sproutLauncher.f22396o.m25025a();
                    }
                    str2 = sproutLauncher.f22386e.getString(2131234827, new Object[]{musicMetadata.f1072a, musicMetadata.f1074c});
                }
                Builder a = SproutSpec.m25061a(2131362983, 2130841063, sproutLauncher.f22386e.getString(2131234826), "listening_to", new C19165(sproutLauncher, musicMetadata, str));
                a.f22455d = str2;
                a = a;
                a.f22461j = sproutLauncher.f22392k;
                return a.m25060a();
            }
        },
        GIF {
            final SproutSpec getSpec(SproutLauncher sproutLauncher, String str, ImmutableList<GraphQLExploreFeed> immutableList, GraphQLExploreFeed graphQLExploreFeed) {
                return SproutSpec.m25061a(2131362984, 2130843442, sproutLauncher.f22386e.getString(2131234834), "gif", new AnonymousClass10(sproutLauncher, str)).m25060a();
            }
        },
        RECOMMENDATIONS {
            final SproutSpec getSpec(SproutLauncher sproutLauncher, String str, ImmutableList<GraphQLExploreFeed> immutableList, GraphQLExploreFeed graphQLExploreFeed) {
                return SproutSpec.m25061a(2131362985, 2130839976, sproutLauncher.f22386e.getString(2131234835), "recommendations", new AnonymousClass11(sproutLauncher, str)).m25060a();
            }
        },
        LIVE {
            final SproutSpec getSpec(SproutLauncher sproutLauncher, String str, ImmutableList<GraphQLExploreFeed> immutableList, GraphQLExploreFeed graphQLExploreFeed) {
                return SproutSpec.m25061a(2131362977, 2130839966, sproutLauncher.f22386e.getString(2131234836), "live_video", new AnonymousClass12(sproutLauncher, str)).m25060a();
            }

            final boolean isSupported(SproutLauncher sproutLauncher) {
                return ((ComposerFacecastCapability) sproutLauncher.f22394m.get()).m20718a(TargetType.UNDIRECTED);
            }
        };

        abstract SproutSpec getSpec(SproutLauncher sproutLauncher, String str, ImmutableList<GraphQLExploreFeed> immutableList, GraphQLExploreFeed graphQLExploreFeed);

        boolean isSupported(SproutLauncher sproutLauncher) {
            return true;
        }

        public static Fab fromString(String str) {
            for (Fab fab : values()) {
                if (fab.name().equalsIgnoreCase(str)) {
                    return fab;
                }
            }
            return null;
        }
    }

    @Inject
    public SproutLauncher(QeAccessor qeAccessor, Resources resources, PlatformAttributionLaunchHelper platformAttributionLaunchHelper, MusicMetadataHelper musicMetadataHelper, SproutAnalyticsLoggerProvider sproutAnalyticsLoggerProvider, ListeningToNuxController listeningToNuxController, InlineComposerHeaderControllerProvider inlineComposerHeaderControllerProvider, Lazy<ComposerFacecastCapability> lazy, @Assisted SproutSource sproutSource, @Assisted FeedComposerLauncher feedComposerLauncher, @Assisted FragmentManager fragmentManager, @Assisted Activity activity) {
        this.f22384c = qeAccessor;
        this.f22386e = resources;
        this.f22387f = platformAttributionLaunchHelper;
        this.f22391j = musicMetadataHelper;
        this.f22395n = sproutAnalyticsLoggerProvider;
        this.f22394m = lazy;
        this.f22392k = listeningToNuxController;
        this.f22390i = sproutSource;
        this.f22385d = feedComposerLauncher;
        this.f22388g = fragmentManager;
        this.f22389h = activity;
        this.f22393l = inlineComposerHeaderControllerProvider;
    }

    public final void m24975a(String str, String str2, int i, GraphQLExploreFeed graphQLExploreFeed) {
        String a;
        String uuid = SafeUUIDGenerator.a().toString();
        this.f22396o = this.f22395n.m25030a(this.f22390i, uuid);
        ImmutableList of = graphQLExploreFeed != null ? ImmutableList.of(graphQLExploreFeed) : ImmutableList.of();
        Runnable c = m24974c(uuid, of, graphQLExploreFeed);
        if (graphQLExploreFeed == null || of.isEmpty() || StringUtil.c(graphQLExploreFeed.G())) {
            a = this.f22384c.a(ExperimentsForFeedUtilComposerAbtestModule.k, str2);
        } else {
            a = ((GraphQLExploreFeed) of.get(0)).G();
        }
        try {
            InlineComposerSproutFragment.m24979a(this.f22390i, uuid, c, i, m24971a(uuid, of, graphQLExploreFeed), this.f22393l.m25093a(str, str2, a)).a(this.f22388g, null);
        } catch (Throwable e) {
            BLog.b(f22383b, e, "Show called after saveInstanceState", new Object[0]);
        }
    }

    private ImmutableList<SproutSpec> m24971a(String str, ImmutableList<GraphQLExploreFeed> immutableList, GraphQLExploreFeed graphQLExploreFeed) {
        ImmutableList.Builder builder = ImmutableList.builder();
        ImmutableList a = m24970a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            Fab fab = (Fab) a.get(i);
            if (fab.isSupported(this)) {
                builder.c(fab.getSpec(this, str, immutableList, graphQLExploreFeed));
            }
        }
        return builder.b();
    }

    private ImmutableList<Fab> m24970a() {
        String a = this.f22384c.a(ExperimentsForFeedUtilComposerAbtestModule.j, null);
        if (a != null) {
            ImmutableList.Builder builder = ImmutableList.builder();
            for (String trim : a.split(",")) {
                Fab fromString = Fab.fromString(trim.trim());
                if (fromString != null) {
                    builder.c(fromString);
                }
            }
            ImmutableList<Fab> b = builder.b();
            if (!b.isEmpty()) {
                return b;
            }
        }
        return f22382a;
    }

    public static SproutSpec m24973b(SproutLauncher sproutLauncher, String str, ImmutableList immutableList, GraphQLExploreFeed graphQLExploreFeed) {
        return SproutSpec.m25061a(2131362971, 2130839837, sproutLauncher.f22384c.a(ExperimentsForFeedUtilComposerAbtestModule.ab, 2131234820, sproutLauncher.f22386e), "status", sproutLauncher.m24974c(str, immutableList, graphQLExploreFeed)).m25060a();
    }

    private Runnable m24974c(final String str, final ImmutableList<GraphQLExploreFeed> immutableList, final GraphQLExploreFeed graphQLExploreFeed) {
        return new Runnable(this) {
            final /* synthetic */ SproutLauncher f22359d;

            public void run() {
                this.f22359d.f22385d.m24956a(Optional.of(str), this.f22359d.f22389h, immutableList, graphQLExploreFeed);
            }
        };
    }

    public static boolean m24972a(MusicMetadata musicMetadata) {
        return (musicMetadata == null || StringUtil.a(musicMetadata.f1072a) || StringUtil.a(musicMetadata.f1074c)) ? false : true;
    }
}
