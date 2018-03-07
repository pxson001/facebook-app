package com.facebook.feed.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.facebook.analytics.CurationSurface;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.api.feed.service.GraphPostService;
import com.facebook.api.feedcache.memory.optimisticstory.OptimisticStoryStateCache;
import com.facebook.attachments.angora.actionbutton.SaveButtonUtils;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.negativefeedback.NegativeFeedbackExperienceLocation;
import com.facebook.common.time.Clock;
import com.facebook.common.util.TriState;
import com.facebook.content.SecureContextHelper;
import com.facebook.controller.mutation.gk.ControllerMutationGatekeepers;
import com.facebook.facecastdisplay.streamingreactions.StreamingReactionsController;
import com.facebook.fbui.menu.MenuItemImpl;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper.BaseFeedStoryMenuOptions;
import com.facebook.feed.menu.base.SetNotifyMeLegacyMutationProvider;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.ui.fullscreenvideoplayer.SubtitleDialog;
import com.facebook.feed.ui.fullscreenvideoplayer.SubtitlesRequestCallback;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.graphql.calls.VideoChannelFollowInputData;
import com.facebook.graphql.calls.VideoChannelSubscribeInputData;
import com.facebook.graphql.calls.VideoChannelUnfollowInputData.Surface;
import com.facebook.graphql.calls.VideoChannelUnsubscribeInputData;
import com.facebook.graphql.enums.GraphQLNegativeFeedbackActionType;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLNegativeFeedbackAction;
import com.facebook.graphql.model.GraphQLNegativeFeedbackActionsEdge;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.NegativeFeedbackActionsUnit;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.graphql.model.conversion.GraphQLMediaConversionHelper;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.groupcommerce.protocol.ProductItemUpdateAvailabilityHelper;
import com.facebook.inject.Assisted;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.negativefeedback.video.RapidReportingController;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.privacy.edit.EditPrivacyIntentBuilder;
import com.facebook.qe.api.QeAccessor;
import com.facebook.reviews.util.intent.StoryReviewComposerLauncherAndHandler;
import com.facebook.saved.analytics.SaveAnalyticsLogger;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.Toaster;
import com.facebook.video.channelfeed.protocol.VideoChannelMutationsHelper;
import com.facebook.video.player.events.RVPDialogEvent;
import com.facebook.video.player.events.RVPRequestSubtitlesLanguageChangeEvent;
import com.facebook.video.player.events.RVPRequestSubtitlesVisibilityChangeEvent;
import com.facebook.video.player.events.RichVideoPlayerEventBus;
import com.facebook.video.subtitles.controller.Subtitles;
import com.facebook.widget.bottomsheet.BottomSheetDialog;
import com.facebook.xconfig.core.XConfigReader;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: Trun count in traf != 1 (unsupported). */
public class VideoFeedStoryMenuHelper extends BaseFeedStoryMenuHelper {
    private static final Provider<Boolean> f21800o = new C18291();
    private static final ImmutableSet<GraphQLNegativeFeedbackActionType> f21801p = ImmutableSet.of(GraphQLNegativeFeedbackActionType.HIDE, GraphQLNegativeFeedbackActionType.RESOLVE_PROBLEM);
    private static final ImmutableSet<GraphQLNegativeFeedbackActionType> f21802q = ImmutableSet.of(GraphQLNegativeFeedbackActionType.RESOLVE_PROBLEM);
    @Nullable
    public RichVideoPlayerEventBus f21803A;
    private final RapidReportingController f21804r;
    public final VideoChannelMutationsHelper f21805s;
    private final NegativeFeedbackExperienceLocation f21806t;
    private final String f21807u;
    public final StreamingReactionsController f21808v;
    public final FbSharedPreferences f21809w;
    public final FragmentActivity f21810x;
    private final Provider<Boolean> f21811y;
    @Nullable
    public ImmutableList<String> f21812z;

    /* compiled from: Trun count in traf != 1 (unsupported). */
    final class C18291 implements Provider<Boolean> {
        C18291() {
        }

        public final Object get() {
            return Boolean.FALSE;
        }
    }

    /* compiled from: Trun count in traf != 1 (unsupported). */
    public class C18302 implements OnMenuItemClickListener {
        final /* synthetic */ boolean f21783a;
        final /* synthetic */ GraphQLActor f21784b;
        final /* synthetic */ VideoFeedStoryMenuHelper f21785c;

        public C18302(VideoFeedStoryMenuHelper videoFeedStoryMenuHelper, boolean z, GraphQLActor graphQLActor) {
            this.f21785c = videoFeedStoryMenuHelper;
            this.f21783a = z;
            this.f21784b = graphQLActor;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            if (this.f21783a) {
                this.f21785c.f21805s.a(this.f21784b.H(), Surface.CHEVRON);
            } else {
                this.f21785c.f21805s.a(this.f21784b.H(), VideoChannelFollowInputData.Surface.CHEVRON);
            }
            return true;
        }
    }

    /* compiled from: Trun count in traf != 1 (unsupported). */
    /* synthetic */ class C18377 {
        static final /* synthetic */ int[] f21798a = new int[GraphQLNegativeFeedbackActionType.values().length];

        static {
            try {
                f21798a[GraphQLNegativeFeedbackActionType.HIDE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
        }
    }

    /* compiled from: Trun count in traf != 1 (unsupported). */
    class VideoFeedStoryMenuOptions extends BaseFeedStoryMenuOptions<GraphQLStory> {
        final /* synthetic */ VideoFeedStoryMenuHelper f21799b;

        public final void m24385a(Menu menu, FeedProps<GraphQLStory> feedProps, View view) {
            GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
            if (c(feedProps)) {
                this.f21799b.m24396a(menu, (FeedProps) feedProps, view);
            }
            GraphQLActor r = StoryAttachmentHelper.r(graphQLStory);
            Context context = view.getContext();
            if (r != null) {
                if (r.ay()) {
                    CharSequence string;
                    CharSequence string2;
                    int i;
                    VideoFeedStoryMenuHelper videoFeedStoryMenuHelper = this.f21799b;
                    boolean aB = r.aB();
                    if (aB) {
                        string = context.getString(2131233651, new Object[]{r.aa()});
                    } else {
                        Object string3 = context.getString(2131233649, new Object[]{r.aa()});
                    }
                    if (aB) {
                        string2 = context.getString(2131233652);
                    } else {
                        Object string4 = context.getString(2131233650, new Object[]{r.aa()});
                    }
                    if (aB) {
                        i = 2130840145;
                    } else {
                        i = 2130839874;
                    }
                    MenuItem add = menu.add(string);
                    if (add instanceof MenuItemImpl) {
                        ((MenuItemImpl) add).a(string2);
                    }
                    add.setOnMenuItemClickListener(new C18302(videoFeedStoryMenuHelper, aB, r));
                    videoFeedStoryMenuHelper.a(add, i, graphQLStory);
                }
                if (r.aB() && r.aJ()) {
                    VideoFeedStoryMenuHelper.m24390b(this.f21799b, menu, graphQLStory, r, context);
                }
            }
            if (VideoFeedStoryMenuHelper.m24393m(this.f21799b)) {
                VideoFeedStoryMenuHelper.m24387a(this.f21799b, menu, graphQLStory);
            }
            if (a(graphQLStory)) {
                b(menu, feedProps, view);
            }
            if (VideoFeedStoryMenuHelper.m24391c(this.f21799b, graphQLStory)) {
                VideoFeedStoryMenuHelper.m24389b(this.f21799b, menu, graphQLStory);
            }
        }

        public final boolean m24386a(FeedProps<GraphQLStory> feedProps) {
            return c(feedProps) || a((GraphQLStory) feedProps.a);
        }

        public VideoFeedStoryMenuOptions(VideoFeedStoryMenuHelper videoFeedStoryMenuHelper) {
            this.f21799b = videoFeedStoryMenuHelper;
            super(videoFeedStoryMenuHelper);
        }
    }

    @Inject
    public VideoFeedStoryMenuHelper(@Assisted FeedEnvironment feedEnvironment, @Assisted NegativeFeedbackExperienceLocation negativeFeedbackExperienceLocation, @Assisted String str, Provider<SecureContextHelper> provider, Provider<IFeedIntentBuilder> provider2, ComposerLauncher composerLauncher, TasksManager tasksManager, ProductItemUpdateAvailabilityHelper productItemUpdateAvailabilityHelper, ObjectMapper objectMapper, SaveButtonUtils saveButtonUtils, SaveAnalyticsLogger saveAnalyticsLogger, Provider<GraphPostService> provider3, AndroidThreadUtil androidThreadUtil, FeedEventBus feedEventBus, Provider<Boolean> provider4, AnalyticsLogger analyticsLogger, NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder, Provider<TriState> provider5, Provider<Toaster> provider6, Clock clock, Provider<EditPrivacyIntentBuilder> provider7, Provider<Boolean> provider8, Provider<StoryReviewComposerLauncherAndHandler> provider9, GraphQLStoryUtil graphQLStoryUtil, QeAccessor qeAccessor, Provider<BottomSheetDialog> provider10, OptimisticStoryStateCache optimisticStoryStateCache, XConfigReader xConfigReader, RapidReportingController rapidReportingController, VideoChannelMutationsHelper videoChannelMutationsHelper, StreamingReactionsController streamingReactionsController, FbSharedPreferences fbSharedPreferences, FragmentActivity fragmentActivity, Provider<Boolean> provider11, ControllerMutationGatekeepers controllerMutationGatekeepers, GraphQLQueryExecutor graphQLQueryExecutor, SetNotifyMeLegacyMutationProvider setNotifyMeLegacyMutationProvider) {
        super(provider, provider2, composerLauncher, tasksManager, productItemUpdateAvailabilityHelper, objectMapper, saveButtonUtils, saveAnalyticsLogger, provider3, androidThreadUtil, feedEventBus, provider4, f21800o, f21800o, analyticsLogger, newsFeedAnalyticsEventBuilder, provider5, provider6, clock, provider7, provider8, provider9, graphQLStoryUtil, qeAccessor, provider10, feedEnvironment, optimisticStoryStateCache, xConfigReader, rapidReportingController, controllerMutationGatekeepers, graphQLQueryExecutor, setNotifyMeLegacyMutationProvider);
        this.f21804r = rapidReportingController;
        this.f21805s = videoChannelMutationsHelper;
        this.f21806t = negativeFeedbackExperienceLocation;
        this.f21807u = str;
        this.f21808v = streamingReactionsController;
        this.f21809w = fbSharedPreferences;
        this.f21810x = fragmentActivity;
        this.f21811y = provider11;
    }

    public final NegativeFeedbackExperienceLocation m24394a() {
        return this.f21806t;
    }

    protected final CurationSurface m24398b() {
        return CurationSurface.NATIVE_STORY;
    }

    protected final String m24399c() {
        return this.f21807u;
    }

    protected final boolean m24397a(NegativeFeedbackActionsUnit negativeFeedbackActionsUnit, GraphQLNegativeFeedbackAction graphQLNegativeFeedbackAction) {
        return (m24392l() ? f21802q : f21801p).contains(graphQLNegativeFeedbackAction.b());
    }

    protected final BaseFeedStoryMenuOptions m24400d(FeedUnit feedUnit) {
        if (feedUnit instanceof GraphQLStory) {
            return new VideoFeedStoryMenuOptions(this);
        }
        return super.d(feedUnit);
    }

    protected final void m24396a(Menu menu, final FeedProps<? extends NegativeFeedbackActionsUnit> feedProps, final View view) {
        Object obj;
        NegativeFeedbackActionsUnit negativeFeedbackActionsUnit = (NegativeFeedbackActionsUnit) feedProps.a;
        ImmutableList a = negativeFeedbackActionsUnit.t().a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            GraphQLNegativeFeedbackActionsEdge graphQLNegativeFeedbackActionsEdge = (GraphQLNegativeFeedbackActionsEdge) a.get(i);
            if (graphQLNegativeFeedbackActionsEdge.a() != null && graphQLNegativeFeedbackActionsEdge.a().b() == GraphQLNegativeFeedbackActionType.RESOLVE_PROBLEM) {
                obj = 1;
                break;
            }
        }
        obj = null;
        if (obj == null && RapidReportingController.a(negativeFeedbackActionsUnit)) {
            int i2;
            if (RapidReportingController.a((NegativeFeedbackActionsUnit) feedProps.a)) {
                i2 = 2131232834;
            } else {
                i2 = 2131232835;
            }
            MenuItem add = menu.add(view.getContext().getString(i2));
            add.setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                final /* synthetic */ VideoFeedStoryMenuHelper f21795c;

                public boolean onMenuItemClick(MenuItem menuItem) {
                    this.f21795c.b(feedProps, view);
                    return true;
                }
            });
            a(add, 2130843018, (FeedUnit) feedProps.a);
        }
        super.a(menu, feedProps, view);
    }

    @Nullable
    protected final String m24395a(Context context, GraphQLNegativeFeedbackAction graphQLNegativeFeedbackAction) {
        switch (C18377.f21798a[graphQLNegativeFeedbackAction.b().ordinal()]) {
            case 1:
                return null;
            default:
                return super.a(context, graphQLNegativeFeedbackAction);
        }
    }

    protected final boolean m24401i() {
        return true;
    }

    private boolean m24392l() {
        return f() == null;
    }

    @Nullable
    private static String m24388b(GraphQLStory graphQLStory) {
        GraphQLStoryAttachment o = StoryAttachmentHelper.o(graphQLStory);
        if (o == null || o.r() == null || GraphQLMediaConversionHelper.b(o.r()) == null) {
            return null;
        }
        return o.r().b();
    }

    public static void m24390b(VideoFeedStoryMenuHelper videoFeedStoryMenuHelper, Menu menu, GraphQLStory graphQLStory, final GraphQLActor graphQLActor, Context context) {
        CharSequence string;
        final boolean aI = graphQLActor.aI();
        if (aI) {
            string = context.getString(2131233655);
        } else {
            Object string2 = context.getString(2131233653);
        }
        if (aI) {
            CharSequence string3 = context.getString(2131233656);
        } else {
            Object string4 = context.getString(2131233654);
        }
        MenuItem add = menu.add(string);
        if (add instanceof MenuItemImpl) {
            ((MenuItemImpl) add).a(string3);
        }
        add.setOnMenuItemClickListener(new OnMenuItemClickListener(videoFeedStoryMenuHelper) {
            final /* synthetic */ VideoFeedStoryMenuHelper f21788c;

            public boolean onMenuItemClick(MenuItem menuItem) {
                if (aI) {
                    this.f21788c.f21805s.a(graphQLActor.H(), VideoChannelUnsubscribeInputData.Surface.CHEVRON);
                } else {
                    this.f21788c.f21805s.a(graphQLActor.H(), VideoChannelSubscribeInputData.Surface.CHEVRON);
                }
                return true;
            }
        });
        videoFeedStoryMenuHelper.a(add, 2130839905, graphQLStory);
    }

    public static void m24387a(VideoFeedStoryMenuHelper videoFeedStoryMenuHelper, Menu menu, GraphQLStory graphQLStory) {
        final String b = m24388b(graphQLStory);
        if (b != null) {
            MenuItem add = menu.add(2131233433);
            add.setOnMenuItemClickListener(new OnMenuItemClickListener(videoFeedStoryMenuHelper) {
                final /* synthetic */ VideoFeedStoryMenuHelper f21792b;

                /* compiled from: Trun count in traf != 1 (unsupported). */
                class C18321 implements OnDismissListener {
                    final /* synthetic */ C18344 f21789a;

                    C18321(C18344 c18344) {
                        this.f21789a = c18344;
                    }

                    public void onDismiss(DialogInterface dialogInterface) {
                        if (this.f21789a.f21792b.f21803A != null) {
                            this.f21789a.f21792b.f21803A.a(new RVPDialogEvent(false));
                        }
                    }
                }

                /* compiled from: Trun count in traf != 1 (unsupported). */
                class C18332 implements SubtitlesRequestCallback {
                    final /* synthetic */ C18344 f21790a;

                    C18332(C18344 c18344) {
                        this.f21790a = c18344;
                    }

                    public final void mo1511a(Subtitles subtitles) {
                        if (this.f21790a.f21792b.f21803A != null) {
                            this.f21790a.f21792b.f21803A.a(new RVPRequestSubtitlesLanguageChangeEvent(subtitles));
                        }
                    }

                    public final void mo1510a() {
                        if (this.f21790a.f21792b.f21803A != null) {
                            this.f21790a.f21792b.f21803A.a(new RVPRequestSubtitlesVisibilityChangeEvent(false));
                        }
                    }
                }

                public boolean onMenuItemClick(MenuItem menuItem) {
                    SubtitleDialog.m24553a(b, new C18321(this), new C18332(this), this.f21792b.f21812z, this.f21792b.f21809w).a(this.f21792b.f21810x.kO_(), null);
                    if (this.f21792b.f21803A != null) {
                        this.f21792b.f21803A.a(new RVPDialogEvent(true));
                    }
                    return true;
                }
            });
            videoFeedStoryMenuHelper.a(add, 2130839802, graphQLStory);
        }
    }

    public static boolean m24393m(VideoFeedStoryMenuHelper videoFeedStoryMenuHelper) {
        return (!((Boolean) videoFeedStoryMenuHelper.f21811y.get()).equals(Boolean.TRUE) || videoFeedStoryMenuHelper.f21812z == null || videoFeedStoryMenuHelper.f21812z.isEmpty()) ? false : true;
    }

    public static void m24389b(VideoFeedStoryMenuHelper videoFeedStoryMenuHelper, Menu menu, GraphQLStory graphQLStory) {
        int i;
        int i2;
        int i3;
        final String b = m24388b(graphQLStory);
        if (videoFeedStoryMenuHelper.f21808v.m4079a(b)) {
            i = 2131232839;
            i2 = 2131232838;
            i3 = 2130839953;
        } else {
            i = 2131232837;
            i2 = 2131232836;
            i3 = 2130839920;
        }
        MenuItem add = menu.add(i2);
        if (add instanceof MenuItemImpl) {
            ((MenuItemImpl) add).a(i);
        }
        add.setOnMenuItemClickListener(new OnMenuItemClickListener(videoFeedStoryMenuHelper) {
            final /* synthetic */ VideoFeedStoryMenuHelper f21797b;

            public boolean onMenuItemClick(MenuItem menuItem) {
                if (this.f21797b.f21808v.m4079a(b)) {
                    this.f21797b.f21808v.m4082c(b);
                } else {
                    this.f21797b.f21808v.m4081b(b);
                }
                return true;
            }
        });
        videoFeedStoryMenuHelper.a(add, i3, graphQLStory);
    }

    public static boolean m24391c(VideoFeedStoryMenuHelper videoFeedStoryMenuHelper, GraphQLStory graphQLStory) {
        return videoFeedStoryMenuHelper.m24392l() && RapidReportingController.a(graphQLStory) && videoFeedStoryMenuHelper.f21808v.f3328a.a(598, false);
    }
}
