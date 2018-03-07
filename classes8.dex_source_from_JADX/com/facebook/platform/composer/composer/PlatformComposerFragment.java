package com.facebook.platform.composer.composer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.CompoundButton;
import com.facebook.auth.annotations.LoggedInUser;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.i18n.StringLengthHelper;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.TriState;
import com.facebook.composer.attachments.AttachmentUtils;
import com.facebook.composer.attachments.ComposerAttachment;
import com.facebook.composer.attachments.ComposerAttachment.ProvidesAttachments;
import com.facebook.composer.audienceeducator.ComposerAudienceEducatorData;
import com.facebook.composer.capability.ComposerMultimediaCapability;
import com.facebook.composer.event.ComposerEvent;
import com.facebook.composer.event.ComposerEventHandler;
import com.facebook.composer.metatext.MetaTextBuilder.ParamsBuilder;
import com.facebook.composer.metatext.MetaTextBuilder.TagClickListener;
import com.facebook.composer.metatext.MetaTextBuilderDelegate;
import com.facebook.composer.minutiae.model.MinutiaeObject;
import com.facebook.composer.minutiae.util.MinutiaeIntentHelper;
import com.facebook.composer.privacy.common.ComposerAudienceFragment;
import com.facebook.composer.privacy.common.ComposerAudienceFragment.AudienceDialogData;
import com.facebook.composer.privacy.common.ComposerAudienceFragment.OnAudienceSelectedListener;
import com.facebook.composer.privacy.common.ComposerPrivacyData;
import com.facebook.composer.privacy.common.ComposerPrivacyData.Builder;
import com.facebook.composer.privacy.common.ComposerPrivacyDelegate.PrivacyUpdatedHandler;
import com.facebook.composer.privacy.common.ComposerSelectablePrivacyDelegateBase;
import com.facebook.composer.privacy.common.ComposerSelectablePrivacyDelegateBase.AnalyticsCallback;
import com.facebook.composer.protocol.FetchPlaceLocationGraphQL;
import com.facebook.composer.protocol.FetchPlaceLocationGraphQL.FetchPlaceLocationQueryString;
import com.facebook.composer.protocol.FetchPlaceLocationGraphQLModels.FetchPlaceLocationQueryModel;
import com.facebook.composer.publish.ComposerPublishServiceHelper;
import com.facebook.composer.publish.helpers.OptimisticPostHelper;
import com.facebook.composer.publish.helpers.OptimisticPostHelperProvider;
import com.facebook.composer.ui.underwood.AttachmentsViewEventListener;
import com.facebook.composer.ui.underwood.UnderwoodController;
import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.content.SecureContextHelper;
import com.facebook.facerec.manager.FaceBoxPrioritizer;
import com.facebook.facerec.manager.FaceBoxPrioritizer.FaceBoxPrioritizerListener;
import com.facebook.facerec.model.LocalFaceRecImageData;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbui.menu.PopoverMenu;
import com.facebook.fig.menu.FigPopoverMenuWindow;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.friendsharing.gif.util.GifUtil;
import com.facebook.funnellogger.FunnelLogger;
import com.facebook.funnellogger.FunnelLoggerImpl;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.GraphQLAlbum;
import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.hashtag.parser.HashtagParser;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsComposerDrawn;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsMultimediaSupported;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesSessionId;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.ipc.composer.intent.ComposerConfigurationSpec.ProvidesConfiguration;
import com.facebook.ipc.composer.intent.ComposerShareParams;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.ipc.composer.intent.ComposerTargetData.ProvidesTargetData;
import com.facebook.ipc.composer.intent.PlatformConfiguration;
import com.facebook.ipc.composer.model.ComposerContentType;
import com.facebook.ipc.composer.model.ComposerContentType.ProvidesContentType;
import com.facebook.ipc.composer.model.ComposerLocation;
import com.facebook.ipc.composer.model.ComposerLocationInfo;
import com.facebook.ipc.composer.model.ComposerSourceType;
import com.facebook.ipc.composer.model.ComposerTaggedUser;
import com.facebook.ipc.composer.model.PublishMode;
import com.facebook.ipc.composer.model.RedSpaceValue;
import com.facebook.ipc.composer.model.TargetType;
import com.facebook.ipc.katana.model.GeoRegion.ImplicitLocation;
import com.facebook.ipc.media.MediaItem;
import com.facebook.ipc.media.data.MediaData;
import com.facebook.ipc.media.data.MediaData.Type;
import com.facebook.ipc.media.data.MimeType;
import com.facebook.ipc.model.FacebookProfile;
import com.facebook.ipc.simplepicker.SimplePickerIntent;
import com.facebook.ipc.simplepicker.SimplePickerLauncherConfiguration;
import com.facebook.ipc.simplepicker.SimplePickerLauncherConfiguration.Action;
import com.facebook.ipc.simplepicker.SimplePickerSource;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.base.media.PhotoItem;
import com.facebook.photos.base.photos.LocalPhoto;
import com.facebook.photos.base.tagging.FaceBox;
import com.facebook.photos.creativeediting.model.CreativeEditingData;
import com.facebook.photos.taggablegallery.ProductionVideoGalleryActivity;
import com.facebook.photos.taggablegallery.TaggableGalleryActivity;
import com.facebook.photos.taggablegallery.TaggableGalleryConstants.Source;
import com.facebook.photos.tagging.store.FaceBoxStore;
import com.facebook.photos.tagging.store.TagStore;
import com.facebook.places.checkin.ipc.CheckinIntentCreator;
import com.facebook.places.checkin.ipc.PlacePickerConfiguration;
import com.facebook.places.checkin.ipc.SearchType;
import com.facebook.places.graphql.PlacesGraphQLInterfaces.CheckinPlace;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel.LocationModel;
import com.facebook.platform.composer.composer.PlatformComposerAppHashtagView.Listener;
import com.facebook.platform.composer.composer.PlatformComposerControllerFragment.C05094;
import com.facebook.platform.composer.composer.PlatformComposerEditText.TextWithEntitiesChangedListener;
import com.facebook.platform.composer.footer.PlatformComposerFooterView;
import com.facebook.platform.composer.footer.PlatformComposerFooterView.ButtonType;
import com.facebook.platform.composer.logging.PlatformComposerPerformanceLogger;
import com.facebook.platform.composer.model.PlatformComposerConfiguration;
import com.facebook.platform.composer.model.PlatformComposerConfiguration.ContainerType;
import com.facebook.platform.composer.model.PlatformComposerConfiguration.HeaderType;
import com.facebook.platform.composer.model.PlatformComposerConfiguration.PostButtonPosition;
import com.facebook.platform.composer.model.PlatformComposerDataProviderImpl;
import com.facebook.platform.composer.model.PlatformComposerDataProviderImplProvider;
import com.facebook.platform.composer.model.PlatformComposerModel;
import com.facebook.platform.composer.model.PlatformComposition;
import com.facebook.platform.composer.privacy.PlatformComposerFixedPrivacyView;
import com.facebook.platform.composer.privacy.PlatformComposerPrivacyController;
import com.facebook.platform.composer.privacy.PlatformComposerPrivacyControllerProvider;
import com.facebook.platform.composer.privacy.PlatformComposerSelectablePrivacyView;
import com.facebook.platform.composer.publish.PublishShareHelperProvider;
import com.facebook.platform.composer.titlebar.PlatformComposerTargetImageControllerProvider;
import com.facebook.platform.composer.titlebar.PlatformComposerTargetSelectorController;
import com.facebook.platform.composer.titlebar.PlatformComposerTargetSelectorControllerProvider;
import com.facebook.platform.composer.titlebar.PlatformComposerTitleBarController;
import com.facebook.platform.composer.titlebar.PlatformComposerTitleBarControllerProvider;
import com.facebook.platform.server.protocol.GetAppNameMethod.Params;
import com.facebook.privacy.model.SelectablePrivacyData;
import com.facebook.privacy.selector.AudienceSelectorPerformanceLogger;
import com.facebook.privacy.selector.AudienceSelectorPerformanceLogger.Caller;
import com.facebook.privacy.selector.AudienceTypeaheadFragment.DataProvider;
import com.facebook.privacy.selector.AudienceTypeaheadUtil;
import com.facebook.privacy.ui.PrivacyIcons;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.sequencelogger.Sequence;
import com.facebook.share.model.ComposerAppAttribution;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringSystem;
import com.facebook.springs.SpringUtil;
import com.facebook.tagging.conversion.FriendSuggestionsAndSelectorActivity;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.tools.dextr.runtime.detour.SequenceLoggerDetour;
import com.facebook.ui.futures.TasksManager;
import com.facebook.user.model.User;
import com.facebook.widget.ScrollingAwareScrollView;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.Futures;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: rich_document_map_block */
public class PlatformComposerFragment extends FbFragment {
    private static final String aL = PlatformComposerFragment.class.getSimpleName();
    @Inject
    PlatformComposerAttachmentControllerProvider f4108a;
    @Inject
    PrivacyIcons aA;
    @Inject
    public ComposerMultimediaCapability aB;
    @Inject
    GatekeeperStoreImpl aC;
    @Inject
    public DefaultBlueServiceOperationFactory aD;
    @Inject
    @ForUiThread
    public Executor aE;
    @Inject
    public GraphQLQueryExecutor aF;
    @Inject
    PlatformComposerPerformanceLogger aG;
    @Inject
    public TasksManager aH;
    @Inject
    public PlatformComposerMetaTextController aI;
    @Inject
    OptimisticPostHelperProvider aJ;
    @Inject
    PlatformComposerDataProviderImplProvider aK;
    public PlatformComposerAttachmentFragment aM;
    private PlatformComposerDataProviderImpl aN;
    public PlatformComposerModel aO;
    private long aP;
    private TextWithEntitiesChangedListener aQ;
    private PlatformComposerEditText aR;
    public boolean aS;
    public Spring aT;
    public Spring aU;
    public Spring aV;
    public View aW;
    public View aX;
    public int aY;
    public PlatformComposerTargetSelectorController aZ;
    @Inject
    DefaultAndroidThreadUtil al;
    @Inject
    SpringSystem am;
    @Inject
    Resources an;
    @Inject
    public Lazy<AudienceSelectorPerformanceLogger> ao;
    @Inject
    PlatformComposerTitleBarControllerProvider ap;
    @Inject
    PlatformComposerTargetSelectorControllerProvider aq;
    @Inject
    PlatformComposerPhotoReelControllerProvider ar;
    @Inject
    PlatformComposerAlbumSelectorControllerProvider as;
    @Inject
    PlatformComposerRedSpaceControllerProvider at;
    @Inject
    AbstractFbErrorReporter au;
    @Inject
    PlatformComposerConfiguration av;
    @Inject
    FaceBoxStore aw;
    @Inject
    Lazy<FaceBoxPrioritizer> ax;
    @Inject
    TagStore ay;
    @Inject
    public FunnelLoggerImpl az;
    @Inject
    PlatformComposerDraftPostController f4109b;
    public final AnonymousClass10 bA = new Object(this) {
        public final /* synthetic */ PlatformComposerFragment f4063a;

        {
            this.f4063a = r1;
        }
    };
    public C05094 bB;
    public final OnAudienceSelectedListener bC = new OnAudienceSelectedListener(this) {
        final /* synthetic */ PlatformComposerFragment f4064a;

        {
            this.f4064a = r1;
        }

        public final void m3999a(SelectablePrivacyData selectablePrivacyData) {
            ComposerPrivacyData a = new Builder(this.f4064a.aO.f4189d).a(selectablePrivacyData).a();
            this.f4064a.bk.f4245a.e();
            PlatformComposerFragment.m4063a(this.f4064a, a, true);
            PlatformComposerFragment.aT(this.f4064a);
        }
    };
    public final AnonymousClass12 bD = new Object(this) {
        public final /* synthetic */ PlatformComposerFragment f4065a;

        {
            this.f4065a = r1;
        }
    };
    private final AnonymousClass13 bE = new Object(this) {
        public final /* synthetic */ PlatformComposerFragment f4066a;

        {
            this.f4066a = r1;
        }

        public final Context m4000a() {
            return this.f4066a.getContext();
        }

        public final void m4001b() {
            this.f4066a.az.b(FunnelRegistry.l, "alert dialog cancelled");
        }

        public final void m4002c() {
            PlatformComposerFragment.m4062a(this.f4066a, 0, null, false);
            this.f4066a.bp.m4093b();
        }
    };
    private final AnonymousClass14 bF = new Object(this) {
        final /* synthetic */ PlatformComposerFragment f4067a;

        {
            this.f4067a = r1;
        }

        public final PlatformComposerModel m4003a() {
            return this.f4067a.aO;
        }
    };
    private ComposerEventHandler ba;
    public FigPopoverMenuWindow bb;
    private ScrollingAwareScrollView bc;
    public PlatformComposerStatusView bd;
    public PlatformComposerAlbumSelectorController be;
    private PlatformComposerRedSpaceController bf;
    private PlatformComposerAttachmentController bg;
    private View bh;
    private PlatformComposerSelectablePrivacyView bi;
    private PlatformComposerFixedPrivacyView bj;
    public PlatformComposerPrivacyController bk;
    public boolean bl = false;
    private CharSequence bm;
    public PlatformComposerFooterView bn;
    public SelectablePrivacyData bo;
    public PlatformComposerPhotoReelController bp;
    public boolean bq;
    private final C05221 br = new C05221(this);
    private final C05232 bs = new C05232(this);
    private final C05243 bt = new C05243(this);
    private final C05254 bu = new C05254(this);
    private final C05265 bv = new C05265(this);
    private final C05306 bw = new C05306(this);
    private final C05317 bx = new C05317(this);
    private final C05328 by = new C05328(this);
    public final DataProvider bz = new C05339(this);
    @Inject
    @LoggedInUser
    Provider<User> f4110c;
    @Inject
    Clock f4111d;
    @Inject
    PublishShareHelperProvider f4112e;
    @Inject
    Lazy<ComposerPublishServiceHelper> f4113f;
    @Inject
    public Lazy<SecureContextHelper> f4114g;
    @Inject
    MetaTextBuilderDelegate f4115h;
    @Inject
    PlatformComposerPrivacyControllerProvider f4116i;

    /* compiled from: rich_document_map_block */
    public class C05221 {
        final /* synthetic */ PlatformComposerFragment f4073a;

        C05221(PlatformComposerFragment platformComposerFragment) {
            this.f4073a = platformComposerFragment;
        }

        public final void m4004a(RedSpaceValue redSpaceValue) {
            PlatformComposerFragment platformComposerFragment = this.f4073a;
            PlatformComposerModel.Builder a = this.f4073a.aO.m4142a();
            PlatformComposition.Builder C = this.f4073a.aO.f4188c.m4148C();
            C.f4224w = redSpaceValue;
            a.f4174c = C.m4145b();
            platformComposerFragment.aO = a.m4141a();
        }
    }

    /* compiled from: rich_document_map_block */
    public class C05232 {
        final /* synthetic */ PlatformComposerFragment f4084a;

        C05232(PlatformComposerFragment platformComposerFragment) {
            this.f4084a = platformComposerFragment;
        }

        public final String m4013a() {
            return this.f4084a.aO.f4186a;
        }

        public final ComposerShareParams m4014b() {
            return this.f4084a.aO.f4188c.m4165q();
        }

        public final ComposerAppAttribution m4015c() {
            return this.f4084a.aO.f4188c.m4172x();
        }
    }

    /* compiled from: rich_document_map_block */
    public /* synthetic */ class AnonymousClass38 {
        public static final /* synthetic */ int[] f4096c = new int[Type.values().length];

        static {
            try {
                f4096c[Type.Photo.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f4096c[Type.Video.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            f4095b = new int[PostButtonPosition.values().length];
            try {
                f4095b[PostButtonPosition.BOTTOM.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f4095b[PostButtonPosition.BIG_BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f4095b[PostButtonPosition.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError e5) {
            }
            f4094a = new int[ContainerType.values().length];
            try {
                f4094a[ContainerType.FULL.ordinal()] = 1;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f4094a[ContainerType.MINI.ordinal()] = 2;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    /* compiled from: rich_document_map_block */
    public class C05243 {
        public final /* synthetic */ PlatformComposerFragment f4097a;

        C05243(PlatformComposerFragment platformComposerFragment) {
            this.f4097a = platformComposerFragment;
        }
    }

    /* compiled from: rich_document_map_block */
    public class C05254 implements ComposerSelectablePrivacyDelegateBase.DataProvider {
        public final /* synthetic */ PlatformComposerFragment f4098a;

        C05254(PlatformComposerFragment platformComposerFragment) {
            this.f4098a = platformComposerFragment;
        }

        public final boolean m4034a() {
            return this.f4098a.aO.f4188c.m4149a();
        }

        public final boolean m4035b() {
            return false;
        }

        public final boolean m4036c() {
            return this.f4098a.aO.f4189d == null || this.f4098a.aO.f4189d.d;
        }

        @Nullable
        public final GraphQLAlbum m4037d() {
            return this.f4098a.aO == null ? null : this.f4098a.aO.f4188c.m4151c();
        }

        @Nullable
        public final GraphQLPrivacyOption m4038f() {
            return this.f4098a.aO == null ? null : this.f4098a.aO.f4192g;
        }
    }

    /* compiled from: rich_document_map_block */
    public class C05265 implements PrivacyUpdatedHandler, AnalyticsCallback {
        final /* synthetic */ PlatformComposerFragment f4099a;

        C05265(PlatformComposerFragment platformComposerFragment) {
            this.f4099a = platformComposerFragment;
        }

        public final void m4040a(ComposerPrivacyData composerPrivacyData, boolean z) {
            this.f4099a.al.a();
            PlatformComposerFragment.m4063a(this.f4099a, composerPrivacyData, z);
            PlatformComposerFragment.aT(this.f4099a);
        }

        public final void m4039a() {
        }
    }

    /* compiled from: rich_document_map_block */
    public class C05306 {
        public final /* synthetic */ PlatformComposerFragment f4103a;

        /* compiled from: rich_document_map_block */
        public class C05271 implements OnClickListener {
            final /* synthetic */ C05306 f4100a;

            public C05271(C05306 c05306) {
                this.f4100a = c05306;
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1805929914);
                PlatformComposerFragment.m4062a(this.f4100a.f4103a, 0, null, true);
                Logger.a(2, EntryType.UI_INPUT_END, -1807824943, a);
            }
        }

        /* compiled from: rich_document_map_block */
        public class C05282 implements OnClickListener {
            final /* synthetic */ C05306 f4101a;

            public C05282(C05306 c05306) {
                this.f4101a = c05306;
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1627753807);
                if (this.f4101a.f4103a.av.f4166c != HeaderType.TARGET_PRIVACY) {
                    if (this.f4101a.f4103a.aZ != null && this.f4101a.f4103a.aZ.m4296a()) {
                        if (this.f4101a.f4103a.bb == null) {
                            this.f4101a.f4103a.bb = new FigPopoverMenuWindow(view.getContext());
                            this.f4101a.f4103a.bb.a(true);
                            this.f4101a.f4103a.bb.c(view);
                        }
                        this.f4101a.f4103a.aZ.m4295a(this.f4101a.f4103a.bb.c());
                        PopoverMenu c = this.f4101a.f4103a.bb.c();
                        if (c.size() == 1) {
                            c.performIdentifierAction(c.getItem(0).getItemId(), 0);
                        } else {
                            this.f4101a.f4103a.bb.d();
                        }
                    }
                } else if (!(this.f4101a.f4103a.bB == null || this.f4101a.f4103a.aO.f4188c.m4152d())) {
                    C05094 c05094 = this.f4101a.f4103a.bB;
                    PlatformComposerModel platformComposerModel = this.f4101a.f4103a.aO;
                    c05094.m3969a(70);
                }
                LogUtils.a(307843712, a);
            }
        }

        /* compiled from: rich_document_map_block */
        public class C05293 implements OnClickListener {
            final /* synthetic */ C05306 f4102a;

            public C05293(C05306 c05306) {
                this.f4102a = c05306;
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1622201187);
                PlatformComposerFragment.m4062a(this.f4102a.f4103a, -1, PlatformComposerFragment.as(this.f4102a.f4103a), false);
                Logger.a(2, EntryType.UI_INPUT_END, -122501534, a);
            }
        }

        C05306(PlatformComposerFragment platformComposerFragment) {
            this.f4103a = platformComposerFragment;
        }

        public final PlatformComposerModel m4041a() {
            return this.f4103a.aO;
        }

        public final boolean m4042c() {
            return this.f4103a.av.f4166c == HeaderType.TARGET_PRIVACY;
        }
    }

    /* compiled from: rich_document_map_block */
    public class C05317 {
        public final /* synthetic */ PlatformComposerFragment f4104a;

        C05317(PlatformComposerFragment platformComposerFragment) {
            this.f4104a = platformComposerFragment;
        }
    }

    /* compiled from: rich_document_map_block */
    public class C05328 implements ProvidesAttachments, ProvidesIsComposerDrawn, ProvidesIsMultimediaSupported, ProvidesSessionId, ProvidesConfiguration, ProvidesTargetData, ProvidesContentType {
        final /* synthetic */ PlatformComposerFragment f4105a;

        C05328(PlatformComposerFragment platformComposerFragment) {
            this.f4105a = platformComposerFragment;
        }

        public final ComposerContentType m4045c() {
            ComposerShareParams q = this.f4105a.aO.f4188c.m4165q();
            ImmutableList m = m4046m();
            if (this.f4105a.aO.f4188c.m4164p() != null) {
                return ComposerContentType.STICKER;
            }
            if (GifUtil.a(q)) {
                return ComposerContentType.GIF_VIDEO;
            }
            if (q != null) {
                return ComposerContentType.SHARE_ATTACHMENT;
            }
            if (m.isEmpty()) {
                return ComposerContentType.NO_ATTACHMENTS;
            }
            if (AttachmentUtils.j(m)) {
                return ComposerContentType.GIF_VIDEO;
            }
            if (AttachmentUtils.l(m)) {
                return ComposerContentType.MULTIMEDIA;
            }
            if (AttachmentUtils.i(m)) {
                return ComposerContentType.VIDEO;
            }
            return m.size() == 1 ? ComposerContentType.SINGLE_PHOTO : ComposerContentType.MULTIPLE_PHOTOS;
        }

        public final ComposerTargetData m4048s() {
            return this.f4105a.aO.f4190e;
        }

        public final ImmutableList<ComposerAttachment> m4046m() {
            return this.f4105a.aO.f4188c.m4153e();
        }

        public final boolean m4043B() {
            return true;
        }

        public final ComposerConfiguration m4047o() {
            return this.f4105a.aO.f4187b;
        }

        public final String ab() {
            return this.f4105a.aO.f4186a;
        }

        public final boolean m4044K() {
            return false;
        }
    }

    /* compiled from: rich_document_map_block */
    class C05339 implements DataProvider {
        final /* synthetic */ PlatformComposerFragment f4106a;

        C05339(PlatformComposerFragment platformComposerFragment) {
            this.f4106a = platformComposerFragment;
        }

        public final SelectablePrivacyData m4049a() {
            return this.f4106a.aO.f4189d.b;
        }

        public final boolean m4050b() {
            return !this.f4106a.aO.f4188c.m4168t().isEmpty();
        }
    }

    /* compiled from: rich_document_map_block */
    public enum PlatformComposerTaskId {
        FETCH_ROBOTEXT,
        FETCH_APP_NAME,
        FETCH_PLACE_INFO
    }

    /* compiled from: rich_document_map_block */
    class SpringListener extends SimpleSpringListener {
        final /* synthetic */ PlatformComposerFragment f4107a;

        public SpringListener(PlatformComposerFragment platformComposerFragment) {
            this.f4107a = platformComposerFragment;
        }

        public final void m4051a(Spring spring) {
            float d;
            if (spring == this.f4107a.aT) {
                d = (float) spring.d();
                this.f4107a.aW.setAlpha(d);
                this.f4107a.aX.setTranslationY(((float) this.f4107a.aY) - ((float) SpringUtil.a((double) d, 0.0d, 1.0d, 0.0d, (double) this.f4107a.aY)));
            } else if (spring == this.f4107a.aU) {
                d = (float) spring.d();
                this.f4107a.aX.setScaleY(d);
                this.f4107a.aX.setScaleX(d);
            } else if (spring == this.f4107a.aV) {
                float d2 = (float) spring.d();
                d = (float) SpringUtil.a((double) d2, 0.0d, 1.0d, 1.0d, 1.1d);
                this.f4107a.aX.setScaleX(d);
                this.f4107a.aX.setScaleY(d);
                this.f4107a.aX.setTranslationY(-((float) SpringUtil.a((double) d2, 0.0d, 1.0d, 0.0d, (double) this.f4107a.aY)));
                this.f4107a.aW.setAlpha(1.0f - (d2 / 1.5f));
            }
        }

        public final void m4052b(Spring spring) {
            if (spring == this.f4107a.aT) {
                if (!spring.g(0.0d)) {
                    this.f4107a.aW.setAlpha(1.0f);
                    this.f4107a.aX.setTranslationY(0.0f);
                    return;
                }
            } else if (spring == this.f4107a.aU) {
                this.f4107a.aV.b(1.5d);
                return;
            } else if (spring != this.f4107a.aV) {
                return;
            } else {
                if (!(spring.g(1.5d) || spring.g(0.0d))) {
                    return;
                }
            }
            PlatformComposerFragment.aY(this.f4107a);
        }
    }

    public static void m4067a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((PlatformComposerFragment) obj).m4061a((PlatformComposerAttachmentControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(PlatformComposerAttachmentControllerProvider.class), PlatformComposerDraftPostController.m3974a(injectorLike), IdBasedProvider.a(injectorLike, 3595), (Clock) SystemClockMethodAutoProvider.a(injectorLike), (PublishShareHelperProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(PublishShareHelperProvider.class), IdBasedLazy.a(injectorLike, 5272), IdBasedSingletonScopeProvider.b(injectorLike, 968), MetaTextBuilderDelegate.a(injectorLike), (PlatformComposerPrivacyControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(PlatformComposerPrivacyControllerProvider.class), DefaultAndroidThreadUtil.a(injectorLike), SpringSystem.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 9716), (PlatformComposerTitleBarControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(PlatformComposerTitleBarControllerProvider.class), (PlatformComposerTargetSelectorControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(PlatformComposerTargetSelectorControllerProvider.class), (PlatformComposerPhotoReelControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(PlatformComposerPhotoReelControllerProvider.class), (PlatformComposerAlbumSelectorControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(PlatformComposerAlbumSelectorControllerProvider.class), (PlatformComposerRedSpaceControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(PlatformComposerRedSpaceControllerProvider.class), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), PlatformComposerConfiguration.m4123a(injectorLike), FaceBoxStore.a(injectorLike), IdBasedLazy.a(injectorLike, 5764), TagStore.a(injectorLike), FunnelLoggerImpl.a(injectorLike), PrivacyIcons.a(injectorLike), ComposerMultimediaCapability.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), DefaultBlueServiceOperationFactory.a(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), PlatformComposerPerformanceLogger.m4117a(injectorLike), TasksManager.a(injectorLike), PlatformComposerMetaTextController.m4088a(injectorLike), (OptimisticPostHelperProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(OptimisticPostHelperProvider.class), (PlatformComposerDataProviderImplProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(PlatformComposerDataProviderImplProvider.class));
    }

    public final void m4081c(Bundle bundle) {
        super.c(bundle);
        Class cls = PlatformComposerFragment.class;
        m4067a((Object) this, getContext());
        this.az.a(FunnelRegistry.l);
        m4073o(bundle);
        this.aQ = new TextWithEntitiesChangedListener(this) {
            final /* synthetic */ PlatformComposerFragment f4082a;

            {
                this.f4082a = r1;
            }

            public final void mo197a(GraphQLTextWithEntities graphQLTextWithEntities) {
                m4008c(graphQLTextWithEntities);
                PlatformComposerFragment.aT(this.f4082a);
                PlatformComposerFragment.aB(this.f4082a);
            }

            public final void mo198b(GraphQLTextWithEntities graphQLTextWithEntities) {
                m4008c(graphQLTextWithEntities);
            }

            private void m4008c(GraphQLTextWithEntities graphQLTextWithEntities) {
                PlatformComposerFragment platformComposerFragment = this.f4082a;
                PlatformComposerModel.Builder a = this.f4082a.aO.m4142a();
                PlatformComposition.Builder C = this.f4082a.aO.f4188c.m4148C();
                C.f4207f = graphQLTextWithEntities;
                a.f4174c = C.m4145b();
                platformComposerFragment.aO = a.m4141a();
            }
        };
        this.aN = new PlatformComposerDataProviderImpl(this.bF);
        if (aI() && !aJ(this) && this.av.f4170g) {
            this.av.f4164a = ContainerType.MINI;
            this.av.f4165b = PostButtonPosition.BOTTOM;
        }
    }

    public final View m4077a(LayoutInflater layoutInflater, ViewGroup viewGroup, @android.support.annotation.Nullable Bundle bundle) {
        ViewGroup viewGroup2;
        ViewerContext viewerContext;
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1196150451);
        switch (this.av.f4164a) {
            case FULL:
                ViewGroup viewGroup3 = (ViewGroup) layoutInflater.inflate(2130906305, viewGroup, false);
                this.bl = true;
                viewGroup2 = viewGroup3;
                break;
            case MINI:
                viewGroup2 = (ViewGroup) layoutInflater.inflate(2130906306, viewGroup, false);
                break;
            default:
                viewGroup2 = null;
                break;
        }
        ViewStub viewStub = (ViewStub) viewGroup2.findViewById(2131566097);
        this.bh = viewGroup2.findViewById(2131560604);
        if (!this.av.f4168e) {
            this.bh.setVisibility(8);
        }
        this.bi = (PlatformComposerSelectablePrivacyView) viewGroup2.findViewById(2131559538);
        this.bi.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ PlatformComposerFragment f4068a;

            {
                this.f4068a = r1;
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 2002610069);
                PlatformComposerFragment platformComposerFragment = this.f4068a;
                ((AudienceSelectorPerformanceLogger) platformComposerFragment.ao.get()).a(Caller.COMPOSER_FRAGMENT);
                ComposerAudienceFragment composerAudienceFragment = new ComposerAudienceFragment();
                composerAudienceFragment.a(new AudienceDialogData(platformComposerFragment.bz, platformComposerFragment.bC, null));
                composerAudienceFragment.a(platformComposerFragment.D, "AUDIENCE_FRAGMENT_TAG");
                this.f4068a.az.b(FunnelRegistry.l, "privacy_view");
                Logger.a(2, EntryType.UI_INPUT_END, -1180333256, a);
            }
        });
        this.bj = (PlatformComposerFixedPrivacyView) viewGroup2.findViewById(2131559540);
        this.aW = viewGroup2.findViewById(2131560614);
        this.aX = viewGroup2.findViewById(2131566107);
        this.aW.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ PlatformComposerFragment f4069a;

            {
                this.f4069a = r1;
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -182290414);
                PlatformComposerFragment.m4062a(this.f4069a, 0, null, true);
                this.f4069a.az.b(FunnelRegistry.l, "white_place");
                Logger.a(2, EntryType.UI_INPUT_END, 1282684381, a);
            }
        });
        this.aX.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ PlatformComposerFragment f4070a;

            {
                this.f4070a = r1;
            }

            public void onClick(View view) {
                Logger.a(2, EntryType.UI_INPUT_END, -984371422, Logger.a(2, EntryType.UI_INPUT_START, -813786593));
            }
        });
        if (this.av.f4164a == ContainerType.MINI) {
            View findViewById = viewGroup2.findViewById(2131566098);
            if (findViewById != null) {
                findViewById.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ PlatformComposerFragment f4071a;

                    {
                        this.f4071a = r1;
                    }

                    public void onClick(View view) {
                        int a = Logger.a(2, EntryType.UI_INPUT_START, 2138747920);
                        PlatformComposerFragment.m4062a(this.f4071a, 0, null, true);
                        this.f4071a.az.b(FunnelRegistry.l, "close_button");
                        Logger.a(2, EntryType.UI_INPUT_END, 2011540526, a);
                    }
                });
            }
        }
        this.aR = (PlatformComposerEditText) viewGroup2.findViewById(2131563416);
        this.aR.m3998a(this.aQ);
        if (!StringUtil.a(new CharSequence[]{this.bm})) {
            this.aR.setText(this.bm);
        }
        this.bn = (PlatformComposerFooterView) viewGroup2.findViewById(2131560585);
        this.bn.m4111a(ButtonType.MINUTIAE, new OnClickListener(this) {
            final /* synthetic */ PlatformComposerFragment f4072a;

            {
                this.f4072a = r1;
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 2088728365);
                ((SecureContextHelper) this.f4072a.f4114g.get()).a(MinutiaeIntentHelper.a(this.f4072a.getContext(), this.f4072a.aO.f4188c.m4158j(), this.f4072a.aO.f4186a, this.f4072a.aO.f4187b, null, null, this.f4072a.aO.f4187b.getMinutiaeObjectTag() != null), 10, this.f4072a);
                this.f4072a.az.b(FunnelRegistry.l, "minutiae_button");
                LogUtils.a(-500046480, a);
            }
        });
        this.bn.m4111a(ButtonType.ALBUM, new OnClickListener(this) {
            final /* synthetic */ PlatformComposerFragment f4074a;

            {
                this.f4074a = r1;
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1572841305);
                this.f4074a.be.m3943a(this.f4074a.bn.m4109a(ButtonType.ALBUM));
                Logger.a(2, EntryType.UI_INPUT_END, -612178810, a);
            }
        });
        this.bn.m4111a(ButtonType.PEOPLE_TAGGING, new OnClickListener(this) {
            final /* synthetic */ PlatformComposerFragment f4075a;

            {
                this.f4075a = r1;
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 796168964);
                ((SecureContextHelper) this.f4075a.f4114g.get()).a(FriendSuggestionsAndSelectorActivity.m10811a(this.f4075a.getContext(), Sets.b(this.f4075a.aO.f4188c.m4169u())), 20, this.f4075a);
                this.f4075a.az.b(FunnelRegistry.l, "people_tagging_button");
                Logger.a(2, EntryType.UI_INPUT_END, -1291844443, a);
            }
        });
        this.bn.m4111a(ButtonType.PLACE_TAGGING, new OnClickListener(this) {
            final /* synthetic */ PlatformComposerFragment f4076a;

            {
                this.f4076a = r1;
            }

            public void onClick(View view) {
                SearchType searchType;
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1902910952);
                PlatformComposerFragment platformComposerFragment = this.f4076a;
                PlacePickerConfiguration.Builder newBuilder = PlacePickerConfiguration.newBuilder();
                if (AttachmentUtils.k(platformComposerFragment.aO.f4188c.m4153e())) {
                    searchType = SearchType.PHOTO;
                } else if (AttachmentUtils.i(platformComposerFragment.aO.f4188c.m4153e())) {
                    searchType = SearchType.VIDEO;
                } else if (platformComposerFragment.aO.f4187b.getInitialLocationInfo().k()) {
                    searchType = SearchType.CHECKIN;
                } else {
                    searchType = SearchType.STATUS;
                }
                newBuilder.p = searchType;
                newBuilder = newBuilder;
                newBuilder.e = platformComposerFragment.aO.f4186a;
                newBuilder = newBuilder;
                newBuilder.d = platformComposerFragment.aO.f4191f;
                newBuilder = newBuilder;
                newBuilder.a = platformComposerFragment.aO.f4188c.m4157i().a();
                newBuilder = newBuilder;
                newBuilder.y = platformComposerFragment.aO.f4188c.m4157i().c();
                ((SecureContextHelper) platformComposerFragment.f4114g.get()).a(CheckinIntentCreator.a(platformComposerFragment.getContext(), newBuilder.a()), 40, platformComposerFragment);
                this.f4076a.az.b(FunnelRegistry.l, "place_tagging_button");
                Logger.a(2, EntryType.UI_INPUT_END, 1709236076, a);
            }
        });
        this.bn.m4111a(ButtonType.PHOTO, new OnClickListener(this) {
            final /* synthetic */ PlatformComposerFragment f4077a;

            {
                this.f4077a = r1;
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -651103712);
                PlatformComposerFragment.aG(this.f4077a);
                this.f4077a.az.b(FunnelRegistry.l, "add_photo_button");
                Logger.a(2, EntryType.UI_INPUT_END, -426414709, a);
            }
        });
        if (this.av.f4164a == ContainerType.MINI) {
            this.bn.setMaxVisibleButtonAllowed(4);
        } else if (this.av.f4164a == ContainerType.FULL) {
            this.bn.setMaxVisibleButtonAllowed(6);
        }
        OnClickListener anonymousClass24 = new OnClickListener(this) {
            final /* synthetic */ PlatformComposerFragment f4078a;

            {
                this.f4078a = r1;
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1592130646);
                PlatformComposerFragment.m4062a(this.f4078a, -1, PlatformComposerFragment.as(this.f4078a), false);
                Logger.a(2, EntryType.UI_INPUT_END, 132300326, a);
            }
        };
        switch (this.av.f4165b) {
            case BOTTOM:
                this.bn.m4114c(ButtonType.POST, true);
                this.bn.m4114c(ButtonType.BIG_POST, false);
                this.bn.m4111a(ButtonType.POST, anonymousClass24);
                break;
            case BIG_BOTTOM:
                this.bn.m4114c(ButtonType.POST, false);
                this.bn.m4114c(ButtonType.BIG_POST, true);
                this.bn.m4111a(ButtonType.BIG_POST, anonymousClass24);
                break;
            case TOP:
                this.bn.m4114c(ButtonType.POST, false);
                this.bn.m4114c(ButtonType.BIG_POST, false);
                break;
        }
        this.bg = this.f4108a.m3958a(this.bs, this.bt);
        if (!(this.aO == null || this.aO.f4188c.m4165q() == null)) {
            this.aM = (PlatformComposerAttachmentFragment) s().a("ATTACHMENT_TAG");
            if (this.aM != null) {
                this.aM.f3994a = this.bg;
            }
            aD();
        }
        this.bc = (ScrollingAwareScrollView) viewGroup2.findViewById(2131560652);
        this.bd = (PlatformComposerStatusView) viewGroup2.findViewById(2131560657);
        if (this.av.f4166c == HeaderType.TARGET_PRIVACY) {
            this.bd.m4099a();
        } else {
            this.bd.setProfileImage(((User) this.f4110c.get()).x());
        }
        if (!(this.aO == null || this.aO.f4188c == null || this.aO.f4188c.m4146A())) {
            this.bd.setAppProvidedHashtag(this.aO.f4188c.m4174z());
            this.bd.setListener(new Listener(this) {
                final /* synthetic */ PlatformComposerFragment f4079a;

                {
                    this.f4079a = r1;
                }

                public final void mo196a() {
                    this.f4079a.az.a(FunnelRegistry.l, "hashtag.user_did_remove", this.f4079a.aO.f4188c.m4174z());
                    PlatformComposerFragment platformComposerFragment = this.f4079a;
                    PlatformComposerModel.Builder a = this.f4079a.aO.m4142a();
                    PlatformComposition.Builder C = this.f4079a.aO.f4188c.m4148C();
                    C.f4200A = true;
                    a.f4174c = C.m4145b();
                    platformComposerFragment.aO = a.m4141a();
                    this.f4079a.bd.setAppProvidedHashtag(null);
                }
            });
        }
        this.bp = new PlatformComposerPhotoReelController((ViewStub) viewGroup2.findViewById(2131566099), IdBasedLazy.a(this.ar, 5302));
        if (aI() || aJ(this)) {
            this.bp.f4125b.setVisibility(8);
        }
        m4058a(viewGroup2);
        PlatformComposerPhotoReelController platformComposerPhotoReelController = this.bp;
        ((UnderwoodController) platformComposerPhotoReelController.f4124a.get()).D = true;
        ((UnderwoodController) platformComposerPhotoReelController.f4124a.get()).h();
        ((UnderwoodController) this.bp.f4124a.get()).B = new AttachmentsViewEventListener(this) {
            final /* synthetic */ PlatformComposerFragment f4085a;

            {
                this.f4085a = r1;
            }

            public final void m4019a(ComposerAttachment composerAttachment, @android.support.annotation.Nullable FaceBox faceBox) {
                this.f4085a.az.b(FunnelRegistry.l, "photo_view_clicked");
                PlatformComposerFragment platformComposerFragment = this.f4085a;
                MediaItem b = composerAttachment.b();
                if (b != null) {
                    MediaData b2 = b.b();
                    Intent putExtra;
                    switch (AnonymousClass38.f4096c[b2.mType.ordinal()]) {
                        case 1:
                            putExtra = new Intent(platformComposerFragment.getContext(), TaggableGalleryActivity.class).putParcelableArrayListExtra("extra_taggable_gallery_photo_list", new ArrayList(AttachmentUtils.b(platformComposerFragment.aO.f4188c.m4153e()))).putParcelableArrayListExtra("extras_taggable_gallery_creative_editing_data_list", AttachmentUtils.c(platformComposerFragment.aO.f4188c.m4153e())).putExtra("extra_taggable_gallery_photo_item_id", b.d()).putExtra("extra_session_id", platformComposerFragment.aO.f4186a);
                            if (faceBox != null) {
                                putExtra.putExtra("extra_taggable_gallery_goto_facebox", faceBox);
                            }
                            platformComposerFragment.az.b(FunnelRegistry.l, "photo_tagging");
                            platformComposerFragment.a(putExtra, 60);
                            return;
                        case 2:
                            if (!MimeType.d.equals(b2.mMimeType)) {
                                putExtra = new Intent(platformComposerFragment.ao(), ProductionVideoGalleryActivity.class).putExtra("extra_session_id", platformComposerFragment.aO.f4186a).putExtra("extra_source", Source.COMPOSER.ordinal()).putExtra("extra_video_uri", AttachmentUtils.g(platformComposerFragment.aO.f4188c.m4153e()));
                                platformComposerFragment.az.b(FunnelRegistry.l, "video_play");
                                platformComposerFragment.a(putExtra);
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                }
            }

            public final void m4018a(ComposerAttachment composerAttachment) {
                Collection<Object> arrayList = new ArrayList(AttachmentUtils.a(this.f4085a.aO.f4188c.m4153e()));
                MediaItem b = composerAttachment.b();
                if (b != null) {
                    for (Object obj : arrayList) {
                        MediaItem b2 = obj.b();
                        if (b2 != null && b2.d().equals(b.d())) {
                            break;
                        }
                    }
                    ComposerAttachment composerAttachment2 = composerAttachment;
                    arrayList.remove(obj);
                    this.f4085a.az.b(FunnelRegistry.l, "photo_removed");
                    PlatformComposerFragment.m4065a(this.f4085a, ImmutableList.copyOf(arrayList), true, false, false);
                    PlatformComposerFragment.aB(this.f4085a);
                }
            }

            public final void m4017a(int i, ComposerAttachment composerAttachment, boolean z, boolean z2) {
                boolean z3;
                Object arrayList = new ArrayList(AttachmentUtils.a(this.f4085a.aO.f4188c.m4153e()));
                if (i >= arrayList.size() || i < 0) {
                    this.f4085a.az.a(FunnelRegistry.l, "platform_composer_onAttachmentChanged_IndexOutOfBounds");
                    this.f4085a.au.b("platform_composer_onAttachmentChanged_IndexOutOfBounds", "index: " + i + " size: " + arrayList.size());
                } else {
                    arrayList.set(i, composerAttachment);
                }
                PlatformComposerFragment platformComposerFragment = this.f4085a;
                ImmutableList copyOf = ImmutableList.copyOf(arrayList);
                if (z || z2) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                PlatformComposerFragment.m4065a(platformComposerFragment, copyOf, z3, false, z2);
                PlatformComposerFragment.aB(this.f4085a);
            }

            public final void m4016a() {
                this.f4085a.az.b(FunnelRegistry.l, "attachment_add_photo");
                PlatformComposerFragment.aG(this.f4085a);
            }

            public final void m4020b() {
            }

            public final void m4021c() {
            }
        };
        m4068a(false);
        this.aR.requestFocus();
        viewGroup2.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener(this) {
            final /* synthetic */ PlatformComposerFragment f4080a;

            {
                this.f4080a = r1;
            }

            public void onGlobalLayout() {
                PlatformComposerFragment platformComposerFragment = this.f4080a;
                if (!platformComposerFragment.aS && !platformComposerFragment.bl) {
                    Rect rect = new Rect();
                    platformComposerFragment.o().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                    Rect rect2 = rect;
                    platformComposerFragment.aY = (rect2.bottom - rect2.top) - (platformComposerFragment.aW.getHeight() / 2);
                    platformComposerFragment.aX.setTranslationY((float) platformComposerFragment.aY);
                    platformComposerFragment.aT.b(1.0d);
                    platformComposerFragment.aS = true;
                }
            }
        });
        this.aT = this.am.a().a(SpringConfig.b(15.0d, 7.0d)).a(new SpringListener(this)).a(0.0d).b(0.0d).l();
        this.aU = this.am.a().a(SpringConfig.b(50.0d, 1.0d)).a(new SpringListener(this)).a(1.0d).b(1.0d).l();
        this.aV = this.am.a().a(SpringConfig.b(15.0d, 7.0d)).a(new SpringListener(this)).a(0.0d).b(0.0d).l();
        this.bk = this.f4116i.m4192a(this.bu, this.bv);
        this.bk.f4245a.a();
        this.ba = m4053a(viewStub);
        this.ba.a(ComposerEvent.ON_DATASET_CHANGE, null);
        PlatformComposerAlbumSelectorControllerProvider platformComposerAlbumSelectorControllerProvider = this.as;
        AnonymousClass32 anonymousClass32 = new Object(this) {
            final /* synthetic */ PlatformComposerFragment f4087a;

            {
                this.f4087a = r1;
            }

            public final void m4027a(GraphQLAlbum graphQLAlbum) {
                PlatformComposerFragment.m4064a(this.f4087a, graphQLAlbum);
            }
        };
        AnonymousClass29 anonymousClass29 = new Object(this) {
            final /* synthetic */ PlatformComposerFragment f4083a;

            {
                this.f4083a = r1;
            }

            @Nullable
            public final GraphQLAlbum m4011a() {
                return this.f4083a.aO.f4188c.m4151c();
            }

            public final ComposerTargetData m4012b() {
                return this.f4083a.aO.f4190e;
            }
        };
        if (this.aO.f4190e.targetType == TargetType.PAGE) {
            viewerContext = this.aO.f4194i;
        } else {
            viewerContext = null;
        }
        this.be = platformComposerAlbumSelectorControllerProvider.m3944a(anonymousClass32, anonymousClass29, this, viewerContext, ((User) this.f4110c.get()).a);
        viewStub = (ViewStub) viewGroup2.findViewById(2131560663);
        PlatformComposerRedSpaceControllerProvider platformComposerRedSpaceControllerProvider = this.at;
        this.bf = new PlatformComposerRedSpaceController((QeAccessor) QeInternalImplMethodAutoProvider.a(platformComposerRedSpaceControllerProvider), viewStub, this.br);
        aH();
        at();
        av();
        aB(this);
        aN(this);
        aC();
        LogUtils.f(-1654706065, a);
        return viewGroup2;
    }

    public final void m4082d(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1334391161);
        super.d(bundle);
        if (aJ(this)) {
            PlatformConfiguration platformConfiguration = this.aO.f4187b.getPlatformConfiguration();
            if (platformConfiguration == null) {
                m4066a(this, new IllegalStateException("Must have platform configuration to share OG."), jW_().getString(2131238405));
            } else {
                this.aH.a(PlatformComposerTaskId.FETCH_ROBOTEXT, this.aI.m4089a(platformConfiguration.ogActionJsonForRobotext, platformConfiguration.ogActionType, this.aO.f4188c.m4172x()), new AbstractDisposableFutureCallback<SpannableStringBuilder>(this) {
                    final /* synthetic */ PlatformComposerFragment f4088a;

                    {
                        this.f4088a = r1;
                    }

                    protected final void m4028a(@android.support.annotation.Nullable Object obj) {
                        SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) obj;
                        if (spannableStringBuilder == null) {
                            PlatformComposerFragment.m4066a(this.f4088a, null, this.f4088a.jW_().getString(2131238405));
                            return;
                        }
                        this.f4088a.bd.m4100a(spannableStringBuilder);
                        this.f4088a.bq = true;
                        PlatformComposerFragment.aB(this.f4088a);
                    }

                    protected final void m4029a(Throwable th) {
                        PlatformComposerFragment.m4066a(this.f4088a, th, this.f4088a.jW_().getString(2131238405));
                    }
                });
            }
        }
        if (!(this.aO == null || this.aO.f4188c == null || this.aO.f4188c.m4172x() == null || !Strings.isNullOrEmpty(this.aO.f4188c.m4172x().b()) || Strings.isNullOrEmpty(this.aO.f4188c.m4172x().a()))) {
            bc();
        }
        if (!(this.aO == null || this.aO.f4188c.m4157i().j() == -1)) {
            bd();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 147964351, a);
    }

    public final void ar() {
        m4062a(this, 0, null, true);
    }

    public static Intent as(PlatformComposerFragment platformComposerFragment) {
        OptimisticPostHelper optimisticPostHelper = null;
        boolean z = platformComposerFragment.s.getBoolean("skip_publish");
        if (!z) {
            optimisticPostHelper = platformComposerFragment.aJ.a(platformComposerFragment.aN, null);
        }
        Intent a = platformComposerFragment.f4112e.m4212a(platformComposerFragment.aO, (User) platformComposerFragment.f4110c.get(), platformComposerFragment.aP, optimisticPostHelper).m4211a();
        if (!z) {
            ((ComposerPublishServiceHelper) platformComposerFragment.f4113f.get()).c(a);
        }
        platformComposerFragment.az.b(FunnelRegistry.l, "publish");
        ((UnderwoodController) platformComposerFragment.bp.f4124a.get()).b(true);
        ArrayList arrayList = new ArrayList();
        ImmutableList e = platformComposerFragment.aO.f4188c.m4153e();
        int size = e.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(((ComposerAttachment) e.get(i)).c());
        }
        if (!arrayList.isEmpty()) {
            a.putParcelableArrayListExtra("attachment_uris", arrayList);
        }
        return a;
    }

    private void m4058a(ViewGroup viewGroup) {
        if (this.aW != null) {
            this.bp.m4091a(this.bc, viewGroup, true, false, null, this.by);
            if (!this.aO.f4188c.m4163o().isEmpty()) {
                PlatformComposerPhotoReelController platformComposerPhotoReelController = this.bp;
                ((UnderwoodController) platformComposerPhotoReelController.f4124a.get()).a(this.aO.f4188c.m4163o());
            }
        }
    }

    private void at() {
        ImmutableList e = this.aO.f4188c.m4153e();
        if (AttachmentUtils.n(e)) {
            this.aR.setHint(this.an.getString(2131238380));
        } else if (AttachmentUtils.k(e) && this.aO.f4188c.m4153e().size() == 1) {
            this.aR.setHint(this.an.getString(2131238378));
        } else if (!AttachmentUtils.k(e) || this.aO.f4188c.m4153e().size() <= 1) {
            this.aR.setHint(this.an.getString(2131238363));
        } else {
            this.aR.setHint(this.an.getString(2131238379));
        }
    }

    public static void m4065a(PlatformComposerFragment platformComposerFragment, ImmutableList immutableList, boolean z, boolean z2, boolean z3) {
        PlatformComposition.Builder a = z2 ? platformComposerFragment.aO.f4188c.m4148C().m4143a(platformComposerFragment.m4055a(immutableList)) : platformComposerFragment.aO.f4188c.m4148C().m4143a(immutableList);
        PlatformComposerModel.Builder a2 = platformComposerFragment.aO.m4142a();
        a2.f4174c = a.m4145b();
        platformComposerFragment.aO = a2.m4141a();
        if (z) {
            platformComposerFragment.m4068a(z3);
        }
        platformComposerFragment.at();
        platformComposerFragment.aH();
    }

    private ImmutableList<ComposerAttachment> m4055a(ImmutableList<ComposerAttachment> immutableList) {
        Preconditions.checkNotNull(immutableList);
        ImmutableList.Builder builder = ImmutableList.builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            ComposerAttachment composerAttachment;
            ComposerAttachment composerAttachment2 = (ComposerAttachment) immutableList.get(i);
            if (composerAttachment2.b() == null) {
                composerAttachment = null;
            } else {
                ImmutableList e = this.aO.f4188c.m4153e();
                int size2 = e.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    composerAttachment = (ComposerAttachment) e.get(i2);
                    if (composerAttachment2.b().equals(composerAttachment.b())) {
                        break;
                    }
                }
                composerAttachment = composerAttachment2;
            }
            composerAttachment2 = composerAttachment;
            Preconditions.checkNotNull(composerAttachment2);
            builder.c(composerAttachment2);
        }
        return builder.b();
    }

    private void av() {
        ImmutableList e = AttachmentUtils.e(this.aO.f4188c.m4153e());
        if (!e.isEmpty()) {
            List arrayList = new ArrayList();
            int size = e.size();
            for (int i = 0; i < size; i++) {
                MediaItem mediaItem = (MediaItem) e.get(i);
                if (mediaItem instanceof PhotoItem) {
                    PhotoItem photoItem = (PhotoItem) mediaItem;
                    LocalPhoto localPhoto = photoItem.f;
                    if (!localPhoto.f || !this.aw.c(localPhoto) || !this.aw.d(localPhoto)) {
                        arrayList.add(new LocalFaceRecImageData(photoItem, this.ay, this.aw));
                    }
                }
            }
            ((FaceBoxPrioritizer) this.ax.get()).j = new FaceBoxPrioritizerListener(this) {
                final /* synthetic */ PlatformComposerFragment f4081a;

                {
                    this.f4081a = r1;
                }

                public final void m4006a(LocalFaceRecImageData localFaceRecImageData) {
                    this.f4081a.bp.m4092a(AttachmentUtils.b(this.f4081a.aO.f4188c.m4153e()));
                }

                public final void m4007b(LocalFaceRecImageData localFaceRecImageData) {
                }
            };
            if (!arrayList.isEmpty()) {
                ((FaceBoxPrioritizer) this.ax.get()).a(arrayList);
            }
        }
    }

    public static void m4062a(PlatformComposerFragment platformComposerFragment, int i, Intent intent, boolean z) {
        FragmentActivity o = platformComposerFragment.o();
        if (o != null) {
            if (z && i != -1 && platformComposerFragment.av.f4167d) {
                platformComposerFragment.f4109b.m3980a(platformComposerFragment.bE, platformComposerFragment.aO);
                return;
            }
            o.setResult(i, intent);
            if (platformComposerFragment.bl) {
                aY(platformComposerFragment);
            } else if (i != -1 || platformComposerFragment.av.f4164a == ContainerType.FULL) {
                platformComposerFragment.aV.b(1.5d);
            } else {
                platformComposerFragment.aU.b(0.85d);
            }
        }
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1426846796);
        super.mi_();
        this.aP = this.f4111d.a();
        this.aZ = this.aq.m4297a(this, this.bx);
        this.az.a(FunnelRegistry.l, "fragment_onstart", az());
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1373343481, a);
    }

    public final void m4074G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1922160525);
        super.G();
        PlatformComposerPerformanceLogger platformComposerPerformanceLogger = this.aG;
        Sequence e = platformComposerPerformanceLogger.f4159a.e(platformComposerPerformanceLogger.f4161c);
        if (e != null) {
            SequenceLoggerDetour.b(e, "PlatformComposerLaunch", 782790783);
        }
        platformComposerPerformanceLogger.f4159a.b(platformComposerPerformanceLogger.f4161c);
        this.be.m3942a();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1399961034, a);
    }

    public final void m4083e(Bundle bundle) {
        super.e(bundle);
        if (this.aO != null) {
            PlatformComposerModel platformComposerModel = this.aO;
            bundle.putString("session_id", platformComposerModel.f4186a);
            bundle.putParcelable("composition", platformComposerModel.f4188c);
            bundle.putParcelable("configuration", platformComposerModel.f4187b);
            bundle.putParcelable("viewer_coordinates", platformComposerModel.f4191f);
            bundle.putParcelable("target_data", platformComposerModel.f4190e);
            FlatBufferModelHelper.a(bundle, "privacy_override", platformComposerModel.f4192g);
            bundle.putParcelable("audience_educator_data", platformComposerModel.f4193h);
            bundle.putBoolean("has_shown_tag_place_tip_or_suggestion", platformComposerModel.f4198m);
            bundle.putBoolean("privacy_has_changed", platformComposerModel.f4196k);
            bundle.putBoolean("post_composition_shown", platformComposerModel.f4199n);
            bundle.putParcelable("page_viewer_context", platformComposerModel.f4194i);
            bundle.putInt("draft_load_attempts", platformComposerModel.f4195j);
            bundle.putInt("status_view_scroll_pos", platformComposerModel.f4197l);
        }
    }

    public final void m4075H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 37512477);
        super.H();
        if (!StringUtil.a(new CharSequence[]{this.aR.getUserText()})) {
            this.bm = this.aR.getUserText();
        }
        PlatformComposerAlbumSelectorController platformComposerAlbumSelectorController = this.be;
        if (platformComposerAlbumSelectorController.f3970l) {
            platformComposerAlbumSelectorController.f3960b.b(platformComposerAlbumSelectorController.f3966h);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1717115537, a);
    }

    public final void m4076I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1762710228);
        ((FaceBoxPrioritizer) this.ax.get()).j = null;
        ((FaceBoxPrioritizer) this.ax.get()).b();
        this.aH.c();
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 415472632, a);
    }

    private void m4073o(Bundle bundle) {
        if (this.aO == null) {
            if (bundle == null) {
                ViewerContext postAsPageViewerContext;
                Bundle bundle2 = this.s;
                ComposerConfiguration composerConfiguration = (ComposerConfiguration) bundle2.getParcelable("extra_composer_configuration");
                PlatformComposition a = m4054a(composerConfiguration, bundle2);
                ImmutableList initialAttachments = composerConfiguration.getInitialAttachments();
                if (initialAttachments.isEmpty()) {
                    initialAttachments = a.m4153e();
                }
                ImmutableList immutableList = initialAttachments;
                PlatformComposerModel.Builder builder = new PlatformComposerModel.Builder();
                builder.f4172a = SafeUUIDGenerator.a().toString();
                builder = builder;
                Builder builder2 = new Builder();
                builder2.a = false;
                builder2 = builder2;
                builder2.c = true;
                builder.f4175d = builder2.a();
                builder = builder;
                builder.f4173b = composerConfiguration;
                builder = builder;
                builder.f4179h = new ComposerAudienceEducatorData.Builder().a();
                builder = builder;
                builder.f4174c = a;
                PlatformComposerModel.Builder a2 = builder.m4140a(composerConfiguration.getInitialTargetData());
                if (composerConfiguration.getInitialPageData() != null) {
                    postAsPageViewerContext = composerConfiguration.getInitialPageData().getPostAsPageViewerContext();
                } else {
                    postAsPageViewerContext = null;
                }
                a2.f4180i = postAsPageViewerContext;
                builder = a2;
                PlatformComposition.Builder a3 = a.m4148C().m4143a(immutableList);
                a3.f4204c = composerConfiguration.getInitialTargetAlbum();
                builder.f4174c = a3.m4145b();
                this.aO = builder.m4141a();
                this.az.b(FunnelRegistry.l, az());
                return;
            }
            PlatformComposerModel.Builder builder3 = new PlatformComposerModel.Builder();
            builder3.f4172a = bundle.getString("session_id");
            PlatformComposerModel.Builder builder4 = builder3;
            builder4.f4174c = (PlatformComposition) bundle.getParcelable("composition");
            builder4 = builder4;
            builder4.f4173b = (ComposerConfiguration) bundle.getParcelable("configuration");
            builder4 = builder4;
            builder4.f4177f = (ComposerLocation) bundle.getParcelable("viewer_coordinates");
            builder4 = builder4.m4140a((ComposerTargetData) bundle.getParcelable("target_data"));
            builder4.f4178g = (GraphQLPrivacyOption) FlatBufferModelHelper.a(bundle, "privacy_override");
            builder4 = builder4;
            builder4.f4179h = (ComposerAudienceEducatorData) bundle.getParcelable("audience_educator_data");
            builder3 = builder4;
            builder3.f4184m = bundle.getBoolean("has_shown_tag_place_tip_or_suggestion");
            builder3 = builder3;
            builder3.f4183l = bundle.getBoolean("privacy_has_changed");
            builder3 = builder3;
            builder3.f4185n = bundle.getBoolean("post_composition_shown");
            builder4 = builder3;
            builder4.f4180i = (ViewerContext) bundle.getParcelable("page_viewer_context");
            builder3 = builder4;
            builder3.f4181j = bundle.getInt("draft_load_attempts");
            builder3 = builder3;
            builder3.f4182k = bundle.getInt("status_view_scroll_pos");
            builder3 = builder3;
            Builder builder5 = new Builder();
            builder5.a = false;
            builder5 = builder5;
            builder5.c = true;
            builder3.f4175d = builder5.a();
            this.aO = builder3.m4141a();
        }
    }

    private PlatformComposition m4054a(ComposerConfiguration composerConfiguration, Bundle bundle) {
        String str;
        PlatformComposition.Builder builder = new PlatformComposition.Builder(Long.parseLong(((User) this.f4110c.get()).d()));
        ImmutableList.Builder builder2 = ImmutableList.builder();
        ImmutableList initialTaggedUsers = composerConfiguration.getInitialTaggedUsers();
        int size = initialTaggedUsers.size();
        for (int i = 0; i < size; i++) {
            ComposerTaggedUser composerTaggedUser = (ComposerTaggedUser) initialTaggedUsers.get(i);
            builder2.c(new FacebookProfile(composerTaggedUser.a(), composerTaggedUser.b(), composerTaggedUser.c(), 0));
        }
        if (composerConfiguration.getPlatformConfiguration() != null) {
            str = composerConfiguration.getPlatformConfiguration().hashtag;
        } else {
            str = null;
        }
        if (str == null && bundle != null) {
            str = bundle.getString("android.intent.extra.TEXT", null);
        }
        PlatformComposition.Builder b = builder.m4144b(builder2.b());
        b.f4208g = composerConfiguration.getInitialLocationInfo();
        b = b;
        b.f4222u = composerConfiguration.getInitialShareParams();
        b.f4227z = m4056a(str);
        if (composerConfiguration.getInitialText() != null) {
            builder.f4207f = composerConfiguration.getInitialText();
        }
        builder.f4225x = composerConfiguration.getInitialAppAttribution();
        return builder.m4145b();
    }

    private String m4056a(String str) {
        if (this.aC.a(740) != TriState.YES || str == null) {
            return null;
        }
        List<String> b = new HashtagParser(str).b();
        if (b == null || b.isEmpty()) {
            return null;
        }
        String str2 = null;
        for (String str3 : b) {
            if (StringLengthHelper.a(str3) <= 33) {
                break;
            }
            str2 = str3;
        }
        String str32 = null;
        if (str32 == null) {
            this.az.a(FunnelRegistry.l, "hashtag.disallowed_too_long", str2);
        }
        StringBuilder stringBuilder = new StringBuilder("hashtag.");
        if (str32 != null) {
            str2 = str32;
        }
        this.az.a(FunnelRegistry.l, stringBuilder.append(str2).toString());
        return str32;
    }

    private String az() {
        if (this.aO == null || this.aO.f4188c == null) {
            return "unknown_attachment";
        }
        if (AttachmentUtils.i(this.aO.f4188c.m4153e())) {
            return "video_attachment";
        }
        if (AttachmentUtils.k(this.aO.f4188c.m4153e()) && this.aO.f4188c.m4153e().size() > 1) {
            return "multi_photo_attachment";
        }
        if (AttachmentUtils.k(this.aO.f4188c.m4153e())) {
            return "single_photo_attachment";
        }
        if (this.aO.f4188c.m4165q() == null || this.aO.f4188c.m4165q().linkForShare == null) {
            return "text_only_attachment";
        }
        return "link_attachment";
    }

    private void m4068a(boolean z) {
        PlatformComposerPhotoReelController platformComposerPhotoReelController = this.bp;
        ((UnderwoodController) platformComposerPhotoReelController.f4124a.get()).a(this.aO.f4188c.m4153e(), z);
        aD();
    }

    public static boolean aA(PlatformComposerFragment platformComposerFragment) {
        if (platformComposerFragment.aO == null || platformComposerFragment.aR == null) {
            return false;
        }
        if (platformComposerFragment.aO.f4187b != null && platformComposerFragment.aO.f4187b.getSourceType() == ComposerSourceType.PLATFORM && platformComposerFragment.aO.f4188c.m4172x() != null && platformComposerFragment.aO.f4188c.m4172x().b() == null) {
            return false;
        }
        boolean a = StringUtil.a(new CharSequence[]{platformComposerFragment.aR.getEncodedText()});
        boolean aI = platformComposerFragment.aI();
        boolean aJ = aJ(platformComposerFragment);
        boolean k = AttachmentUtils.k(platformComposerFragment.aO.f4188c.m4153e());
        boolean i = AttachmentUtils.i(platformComposerFragment.aO.f4188c.m4153e());
        if (!a || ((aI && !aJ) || k || i || (aJ && platformComposerFragment.bq))) {
            return true;
        }
        return false;
    }

    public static void aB(PlatformComposerFragment platformComposerFragment) {
        if (platformComposerFragment.ba != null) {
            platformComposerFragment.ba.a(ComposerEvent.ON_STATUS_TEXT_CHANGED, null);
        }
        if (platformComposerFragment.bn != null) {
            platformComposerFragment.bn.m4113b(ButtonType.BIG_POST, aA(platformComposerFragment));
            platformComposerFragment.bn.m4113b(ButtonType.POST, aA(platformComposerFragment));
        }
    }

    private void aC() {
        if (this.bf != null) {
            Object obj;
            if (!(this.aO.f4188c.m4154f() == RedSpaceValue.POST_TO_NEWSFEED || this.bf.m4096a(this.aO))) {
                this.br.m4004a(RedSpaceValue.POST_TO_NEWSFEED);
            }
            PlatformComposerRedSpaceController platformComposerRedSpaceController = this.bf;
            PlatformComposerModel platformComposerModel = this.aO;
            boolean z = false;
            if (platformComposerModel.f4187b.getAllowsRedSpaceToggle() && platformComposerRedSpaceController.m4096a(platformComposerModel)) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                ((CompoundButton) platformComposerRedSpaceController.f4130b.a()).setVisibility(0);
                CompoundButton compoundButton = (CompoundButton) platformComposerRedSpaceController.f4130b.a();
                if (platformComposerModel.f4188c.m4154f() == RedSpaceValue.POST_TO_NEWSFEED) {
                    z = true;
                }
                compoundButton.setChecked(z);
                return;
            }
            platformComposerRedSpaceController.f4130b.c();
        }
    }

    private void aD() {
        if (this.aM != null) {
            this.aM.m3964b();
        } else if (this.aO.f4188c.m4165q() != null) {
            this.aM = new PlatformComposerAttachmentFragment();
            this.aM.f3994a = this.bg;
            FragmentTransaction a = s().a();
            a.a(2131566131, this.aM, "ATTACHMENT_TAG");
            a.c();
            s().b();
            this.aM.m3964b();
        }
    }

    public static void aG(PlatformComposerFragment platformComposerFragment) {
        SimplePickerLauncherConfiguration.Builder e = new SimplePickerLauncherConfiguration.Builder(SimplePickerSource.COMPOSER_ADD_MORE_MEDIA).a(Action.NONE).a(ImmutableList.copyOf(AttachmentUtils.e(platformComposerFragment.aO.f4188c.m4153e()))).o().g().p().q().c().e();
        if (platformComposerFragment.aB.a(platformComposerFragment.aO.f4190e.targetType, false)) {
            e.b();
        }
        platformComposerFragment.a(SimplePickerIntent.a(platformComposerFragment.getContext(), e, platformComposerFragment.aO.f4186a), 50);
    }

    public final void m4078a(int i, int i2, @android.support.annotation.Nullable Intent intent) {
        switch (i) {
            case 10:
                m4071e(i2, intent);
                break;
            case 20:
                m4070c(i2, intent);
                break;
            case 30:
                if (i2 == -1) {
                    m4079a((ComposerTargetData) intent.getParcelableExtra("extra_composer_target_data"), (ViewerContext) intent.getParcelableExtra("extra_actor_viewer_context"));
                }
                break;
            case 40:
                m4072f(i2, intent);
                break;
            case 50:
                m4057a(i2, intent);
                break;
            case 60:
                m4069b(i2, intent);
                break;
            case 1000:
                PlatformComposerAlbumSelectorController platformComposerAlbumSelectorController = this.be;
                if (i2 == -1) {
                    platformComposerAlbumSelectorController.f3965g.m4027a((GraphQLAlbum) FlatBufferModelHelper.a(intent, "extra_album"));
                }
                break;
        }
        aH();
    }

    private void m4057a(int i, Intent intent) {
        if (i == -1) {
            ImmutableList copyOf;
            ImmutableList immutableList;
            boolean z;
            PlatformComposerModel.Builder a;
            PlatformComposition.Builder C;
            if (intent.hasExtra("extra_media_items")) {
                Collection parcelableArrayListExtra = intent.getParcelableArrayListExtra("extra_media_items");
                if (parcelableArrayListExtra != null) {
                    copyOf = ImmutableList.copyOf(parcelableArrayListExtra);
                    immutableList = copyOf;
                    if (immutableList.isEmpty() && ((MediaItem) immutableList.get(0)).b().mType == Type.Photo) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z && this.aO.f4188c.m4161m() == PublishMode.SAVE_DRAFT) {
                        a = this.aO.m4142a();
                        C = this.aO.f4188c.m4148C();
                        C.f4214m = PublishMode.NORMAL;
                        a.f4174c = C.m4145b();
                        this.aO = a.m4141a();
                    }
                    m4065a(this, ComposerAttachment.a(immutableList), true, true, true);
                    at();
                }
            }
            copyOf = RegularImmutableList.a;
            immutableList = copyOf;
            if (immutableList.isEmpty()) {
            }
            z = false;
            a = this.aO.m4142a();
            C = this.aO.f4188c.m4148C();
            C.f4214m = PublishMode.NORMAL;
            a.f4174c = C.m4145b();
            this.aO = a.m4141a();
            m4065a(this, ComposerAttachment.a(immutableList), true, true, true);
            at();
        }
    }

    private void m4069b(int i, Intent intent) {
        if (i == -1) {
            Collection parcelableArrayListExtra = intent.getParcelableArrayListExtra("extra_photo_items_list");
            List parcelableArrayListExtra2 = intent.getParcelableArrayListExtra("extras_taggable_gallery_creative_editing_data_list");
            if (parcelableArrayListExtra2 != null) {
                Preconditions.checkState(parcelableArrayListExtra.size() == parcelableArrayListExtra2.size());
            }
            if (intent.getBooleanExtra("extra_are_media_items_modified", false)) {
                ImmutableList.Builder builder = ImmutableList.builder();
                ImmutableList e = this.aO.f4188c.m4153e();
                int size = e.size();
                for (int i2 = 0; i2 < size; i2++) {
                    MediaItem mediaItem;
                    CreativeEditingData creativeEditingData;
                    ComposerAttachment.Builder a;
                    ComposerAttachment composerAttachment = (ComposerAttachment) e.get(i2);
                    long h = (long) composerAttachment.h();
                    int i3 = 0;
                    while (i3 < parcelableArrayListExtra.size()) {
                        if (((PhotoItem) parcelableArrayListExtra.get(i3)).c() == h) {
                            mediaItem = (PhotoItem) parcelableArrayListExtra.get(i3);
                            creativeEditingData = parcelableArrayListExtra2 != null ? (CreativeEditingData) parcelableArrayListExtra2.get(i3) : null;
                            if (mediaItem == null) {
                                a = ComposerAttachment.Builder.a(mediaItem);
                                if (creativeEditingData != null) {
                                    a.a(creativeEditingData);
                                }
                            } else {
                                a = ComposerAttachment.Builder.a(composerAttachment);
                            }
                            if (!Strings.isNullOrEmpty(composerAttachment.d().a())) {
                                a.a(composerAttachment.d());
                            }
                            builder.c(a.a());
                        } else {
                            i3++;
                        }
                    }
                    creativeEditingData = null;
                    mediaItem = null;
                    if (mediaItem == null) {
                        a = ComposerAttachment.Builder.a(composerAttachment);
                    } else {
                        a = ComposerAttachment.Builder.a(mediaItem);
                        if (creativeEditingData != null) {
                            a.a(creativeEditingData);
                        }
                    }
                    if (!Strings.isNullOrEmpty(composerAttachment.d().a())) {
                        a.a(composerAttachment.d());
                    }
                    builder.c(a.a());
                }
                m4065a(this, builder.b(), true, false, true);
                this.bp.m4094b(ImmutableList.copyOf(parcelableArrayListExtra));
            }
        }
    }

    private void m4070c(int i, Intent intent) {
        if (i == -1) {
            PlatformComposerModel.Builder a = this.aO.m4142a();
            PlatformComposition.Builder C = this.aO.f4188c.m4148C();
            C.f4212k = true;
            a.f4174c = C.m4145b();
            this.aO = a.m4141a();
            if (intent.hasExtra("full_profiles")) {
                Collection parcelableArrayListExtra = intent.getParcelableArrayListExtra("full_profiles");
                PlatformComposerModel.Builder a2 = this.aO.m4142a();
                a2.f4174c = this.aO.f4188c.m4148C().m4144b(ImmutableList.copyOf(parcelableArrayListExtra)).m4145b();
                this.aO = a2.m4141a();
            }
            aK();
            this.bk.m4191a(ComposerEvent.ON_DATASET_CHANGE);
        }
    }

    private void aH() {
        boolean z;
        boolean z2 = true;
        boolean aI = aI();
        boolean aJ = aJ(this);
        boolean k = AttachmentUtils.k(this.aO.f4188c.m4153e());
        boolean i = AttachmentUtils.i(this.aO.f4188c.m4153e());
        boolean z3 = this.aO.f4188c.m4158j() != null;
        if (this.aO.f4188c.m4151c() != null) {
            z = true;
        } else {
            z = false;
        }
        PlatformComposerFooterView platformComposerFooterView = this.bn;
        ButtonType buttonType = ButtonType.PHOTO;
        if (aI || aJ) {
            aI = false;
        } else {
            aI = true;
        }
        platformComposerFooterView.m4114c(buttonType, aI);
        PlatformComposerFooterView platformComposerFooterView2 = this.bn;
        ButtonType buttonType2 = ButtonType.ALBUM;
        if (!k || i || z3 || this.aO.f4190e.targetType != TargetType.UNDIRECTED) {
            z3 = false;
        } else {
            z3 = true;
        }
        platformComposerFooterView2.m4114c(buttonType2, z3);
        platformComposerFooterView2 = this.bn;
        buttonType2 = ButtonType.MINUTIAE;
        if (z) {
            z3 = false;
        } else {
            z3 = true;
        }
        platformComposerFooterView2.m4114c(buttonType2, z3);
        PlatformComposerFooterView platformComposerFooterView3 = this.bn;
        ButtonType buttonType3 = ButtonType.PHOTO;
        if (k || i) {
            z3 = true;
        } else {
            z3 = false;
        }
        platformComposerFooterView3.m4112a(buttonType3, z3);
        platformComposerFooterView3 = this.bn;
        buttonType3 = ButtonType.ALBUM;
        if (this.aO.f4188c.m4151c() != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        platformComposerFooterView3.m4112a(buttonType3, z3);
        platformComposerFooterView3 = this.bn;
        buttonType3 = ButtonType.PEOPLE_TAGGING;
        if (this.aO.f4188c.m4170v().isEmpty()) {
            z3 = false;
        } else {
            z3 = true;
        }
        platformComposerFooterView3.m4112a(buttonType3, z3);
        this.bn.m4112a(ButtonType.MINUTIAE, this.aO.f4188c.m4167s());
        PlatformComposerFooterView platformComposerFooterView4 = this.bn;
        ButtonType buttonType4 = ButtonType.PLACE_TAGGING;
        if (this.aO.f4188c.m4157i().a() == null) {
            z2 = false;
        }
        platformComposerFooterView4.m4112a(buttonType4, z2);
        if (this.av.f4169f) {
            this.bn.m4110a();
        }
    }

    private boolean aI() {
        return (this.aO.f4188c.m4165q() == null || this.aO.f4188c.m4165q().linkForShare == null) ? false : true;
    }

    public static boolean aJ(PlatformComposerFragment platformComposerFragment) {
        return platformComposerFragment.aO.f4187b.getPlatformConfiguration() != null && platformComposerFragment.aO.f4187b.getPlatformConfiguration().b();
    }

    public final void m4079a(ComposerTargetData composerTargetData, @android.support.annotation.Nullable ViewerContext viewerContext) {
        this.aO = this.aO.m4142a().m4140a(composerTargetData).m4141a();
        PlatformComposerModel.Builder a;
        if (composerTargetData.targetType == TargetType.PAGE) {
            a = this.aO.m4142a();
            a.f4180i = viewerContext;
            this.aO = a.m4141a();
        } else {
            a = this.aO.m4142a();
            a.f4180i = null;
            this.aO = a.m4141a();
        }
        this.bk.m4191a(ComposerEvent.ON_DATASET_CHANGE);
        aH();
        ba();
        aC();
    }

    private void m4071e(int i, Intent intent) {
        if (i == -1) {
            MinutiaeObject minutiaeObject = null;
            if (intent != null && intent.hasExtra("minutiae_object")) {
                minutiaeObject = (MinutiaeObject) intent.getParcelableExtra("minutiae_object");
            }
            m4059a(minutiaeObject);
            aK();
        }
    }

    private void m4059a(MinutiaeObject minutiaeObject) {
        PlatformComposerModel.Builder a = this.aO.m4142a();
        PlatformComposition.Builder C = this.aO.f4188c.m4148C();
        C.f4209h = minutiaeObject;
        a.f4174c = C.m4145b();
        this.aO = a.m4141a();
    }

    private void aK() {
        aN(this);
        aT(this);
        aD();
    }

    private void m4072f(int i, @android.support.annotation.Nullable Intent intent) {
        if (i == 0) {
            this.az.b(FunnelRegistry.l, "place_tag_cancelled");
            return;
        }
        if (i != -1) {
            this.az.b(FunnelRegistry.l, "place_tag_selected");
        }
        if (intent == null) {
            return;
        }
        if (intent.getBooleanExtra("extra_xed_location", false)) {
            aL();
        } else if (intent.hasExtra("text_only_place")) {
            String stringExtra = intent.getStringExtra("text_only_place");
            PlatformComposerModel.Builder a = this.aO.m4142a();
            PlatformComposition.Builder C = this.aO.f4188c.m4148C();
            C.f4208g = ComposerLocationInfo.a(this.aO.f4188c.m4157i()).a(stringExtra).b();
            a.f4174c = C.m4145b();
            this.aO = a.m4141a();
            aN(this);
        } else {
            m4060a((CheckinPlaceModel) FlatBufferModelHelper.a(intent, "extra_place"), (ImplicitLocation) intent.getParcelableExtra("extra_implicit_location"), (MinutiaeObject) intent.getParcelableExtra("minutiae_object"));
        }
    }

    private void aL() {
        PlatformComposerModel.Builder a = this.aO.m4142a();
        PlatformComposition.Builder C = this.aO.f4188c.m4148C();
        C.f4208g = ComposerLocationInfo.a(this.aO.f4188c.m4157i()).a().b();
        a.f4174c = C.m4145b();
        this.aO = a.m4141a();
        aN(this);
        aD();
        aH();
    }

    private void m4060a(CheckinPlaceModel checkinPlaceModel, ImplicitLocation implicitLocation, MinutiaeObject minutiaeObject) {
        PlatformComposerModel.Builder a = this.aO.m4142a();
        PlatformComposition.Builder C = this.aO.f4188c.m4148C();
        C.f4208g = ComposerLocationInfo.a(this.aO.f4188c.m4157i()).a(checkinPlaceModel, implicitLocation).b();
        a.f4174c = C.m4145b();
        this.aO = a.m4141a();
        if (minutiaeObject != null) {
            m4059a(minutiaeObject);
        }
        aN(this);
        aK();
    }

    public static void aN(PlatformComposerFragment platformComposerFragment) {
        if (platformComposerFragment.aO.f4188c.m4158j() != null) {
            platformComposerFragment.aR.setMinutiaeUri(platformComposerFragment.aO.f4188c.m4158j().a());
        }
        platformComposerFragment.aR.m3996a(platformComposerFragment.aO());
    }

    private SpannableStringBuilder aO() {
        String aP = aP();
        ParamsBuilder paramsBuilder = new ParamsBuilder();
        paramsBuilder.f = true;
        paramsBuilder = paramsBuilder;
        paramsBuilder.g = true;
        paramsBuilder = paramsBuilder;
        paramsBuilder.i = new TagClickListener(this) {
            final /* synthetic */ PlatformComposerFragment f4086a;

            {
                this.f4086a = r1;
            }

            public final void m4023a(int i) {
            }

            public final void m4022a() {
            }

            public final void m4024b() {
            }

            public final void m4025c() {
            }

            public final void m4026d() {
            }
        };
        paramsBuilder = paramsBuilder;
        paramsBuilder.a = this.aO.f4188c.m4158j();
        paramsBuilder.b(aP);
        paramsBuilder.e = aQ();
        paramsBuilder.b = this.aO.f4188c.m4157i().a();
        return this.f4115h.a(paramsBuilder.a());
    }

    private String aP() {
        ImmutableList v = this.aO.f4188c.m4170v();
        int size = v.size();
        for (int i = 0; i < size; i++) {
            FacebookProfile facebookProfile = (FacebookProfile) v.get(i);
            if (facebookProfile.mId != aR() && facebookProfile.mDisplayName != null) {
                return facebookProfile.mDisplayName;
            }
        }
        return null;
    }

    private int aQ() {
        ImmutableList v = this.aO.f4188c.m4170v();
        int size = v.size();
        for (int i = 0; i < size; i++) {
            if (((FacebookProfile) v.get(i)).mId == aR()) {
                return this.aO.f4188c.m4170v().size() - 1;
            }
        }
        return this.aO.f4188c.m4170v().size();
    }

    private long aR() {
        return Long.parseLong(((User) this.f4110c.get()).a);
    }

    public static void m4063a(PlatformComposerFragment platformComposerFragment, ComposerPrivacyData composerPrivacyData, boolean z) {
        PlatformComposerModel.Builder a = platformComposerFragment.aO.m4142a();
        a.f4175d = composerPrivacyData;
        SelectablePrivacyData selectablePrivacyData = platformComposerFragment.aO.f4189d.b;
        SelectablePrivacyData selectablePrivacyData2 = composerPrivacyData.b;
        Object obj = null;
        if (!(selectablePrivacyData == null || selectablePrivacyData2 == null || ((selectablePrivacyData.a != null && selectablePrivacyData.a.selectedPrivacyOption != null && selectablePrivacyData2.a != null && selectablePrivacyData2.a.selectedPrivacyOption != null && !selectablePrivacyData2.a.selectedPrivacyOption.equals(selectablePrivacyData.a.selectedPrivacyOption)) || selectablePrivacyData.d == null || selectablePrivacyData2.d == null || (selectablePrivacyData.d.equals(selectablePrivacyData2.d) && selectablePrivacyData.b == selectablePrivacyData2.b)))) {
            obj = 1;
        }
        if (obj != null) {
            a.f4183l = true;
        }
        platformComposerFragment.aO = a.m4141a();
        if (platformComposerFragment.aU()) {
            platformComposerFragment.bo = composerPrivacyData.b;
            if (z && platformComposerFragment.aO.f4189d.b != null) {
                a = platformComposerFragment.aO.m4142a();
                a.f4178g = platformComposerFragment.aO.f4189d.b.b();
                platformComposerFragment.aO = a.m4141a();
            }
        }
    }

    public static void m4064a(PlatformComposerFragment platformComposerFragment, GraphQLAlbum graphQLAlbum) {
        PlatformComposerModel.Builder a = platformComposerFragment.aO.m4142a();
        PlatformComposition.Builder C = platformComposerFragment.aO.f4188c.m4148C();
        C.f4204c = graphQLAlbum;
        a.f4174c = C.m4145b();
        platformComposerFragment.aO = a.m4141a();
        platformComposerFragment.bk.m4191a(ComposerEvent.ON_DATASET_CHANGE);
        platformComposerFragment.aH();
        platformComposerFragment.aC();
    }

    public static void aT(PlatformComposerFragment platformComposerFragment) {
        if (platformComposerFragment.bh != null) {
            if (!platformComposerFragment.aO.f4189d.c) {
                platformComposerFragment.bh.setVisibility(8);
            } else if (platformComposerFragment.av.f4168e) {
                platformComposerFragment.bh.setVisibility(0);
                if (platformComposerFragment.aU() || platformComposerFragment.aO.f4189d.d) {
                    platformComposerFragment.bi.setVisibility(0);
                    platformComposerFragment.bj.setVisibility(8);
                    platformComposerFragment.bi.m4199a(aV(platformComposerFragment), platformComposerFragment.aO.f4189d);
                } else if (platformComposerFragment.aO.f4189d.a != null) {
                    platformComposerFragment.bi.setVisibility(8);
                    platformComposerFragment.bj.setVisibility(0);
                    PlatformComposerFixedPrivacyView platformComposerFixedPrivacyView = platformComposerFragment.bj;
                    aV(platformComposerFragment);
                    platformComposerFixedPrivacyView.m4189a(platformComposerFragment.aO.f4189d.a, platformComposerFragment.aO.f4188c.m4151c());
                }
            } else {
                platformComposerFragment.bh.setVisibility(8);
                platformComposerFragment.ba();
            }
        }
    }

    private boolean aU() {
        return (this.aO.f4189d.b == null || this.aO.f4189d.b.a == null) ? false : true;
    }

    public static boolean aV(PlatformComposerFragment platformComposerFragment) {
        return !platformComposerFragment.aO.f4188c.m4168t().isEmpty();
    }

    public final void m4080a(TargetType targetType) {
        if (targetType != TargetType.UNDIRECTED) {
            try {
                a(new Intent(ao(), (Class) Preconditions.checkNotNull(this.aZ.m4294a(targetType))), 30);
            } catch (NullPointerException e) {
                this.az.a(FunnelRegistry.l, "no_activity_for_composer_target_selection");
                this.au.a("no_activity_for_composer_target_selection", "Couldn't find activity for target type: " + targetType);
            }
        } else if (this.aO.f4190e.targetType != TargetType.UNDIRECTED) {
            m4079a(new ComposerTargetData.Builder().a(), null);
        }
    }

    public static void aY(PlatformComposerFragment platformComposerFragment) {
        FragmentActivity o = platformComposerFragment.o();
        if (o != null) {
            platformComposerFragment.az.b(FunnelRegistry.l, "finish_activity");
            o.finish();
            o.overridePendingTransition(0, 0);
        }
    }

    private ComposerEventHandler m4053a(ViewStub viewStub) {
        PlatformComposerTitleBarControllerProvider platformComposerTitleBarControllerProvider = this.ap;
        return new PlatformComposerTitleBarController(viewStub, this.bw, (AbstractFbErrorReporter) FbErrorReporterImpl.a(platformComposerTitleBarControllerProvider), ResourcesMethodAutoProvider.a(platformComposerTitleBarControllerProvider), PlatformComposerConfiguration.m4123a(platformComposerTitleBarControllerProvider), AudienceTypeaheadUtil.b(platformComposerTitleBarControllerProvider), (PlatformComposerTargetImageControllerProvider) platformComposerTitleBarControllerProvider.getOnDemandAssistedProviderForStaticDi(PlatformComposerTargetImageControllerProvider.class), Boolean_IsWorkBuildMethodAutoProvider.a(platformComposerTitleBarControllerProvider));
    }

    private void ba() {
        if (this.ba != null) {
            this.ba.a(ComposerEvent.ON_DATASET_CHANGE, null);
        }
    }

    public static void m4066a(PlatformComposerFragment platformComposerFragment, Throwable th, String str) {
        Activity ao = platformComposerFragment.ao();
        if (ao != null) {
            Bundle bundle = new Bundle();
            bundle.putString("com.facebook.platform.extra.COMPOSER_ERROR", str);
            if (th != null) {
                bundle.putSerializable("com.facebook.platform.extra.COMPOSER_EXCEPTION", th);
            }
            ao.setResult(0, new Intent().putExtras(bundle));
            ao.finish();
        }
    }

    private void bc() {
        final ComposerAppAttribution x = this.aO.f4188c.m4172x();
        if (x == null) {
            m4066a(this, null, jW_().getString(2131238406));
            return;
        }
        TasksManager tasksManager = this.aH;
        PlatformComposerTaskId platformComposerTaskId = PlatformComposerTaskId.FETCH_APP_NAME;
        String a = x.a();
        Bundle bundle = new Bundle();
        bundle.putParcelable("app_name", new Params(a));
        tasksManager.a(platformComposerTaskId, Futures.a(BlueServiceOperationFactoryDetour.a(this.aD, "platform_get_app_name", bundle, 718729093).a(), new Function<OperationResult, String>(this) {
            final /* synthetic */ PlatformComposerFragment f4091a;

            {
                this.f4091a = r1;
            }

            public Object apply(Object obj) {
                return ((OperationResult) obj).c;
            }
        }, this.aE), new AbstractDisposableFutureCallback<String>(this) {
            final /* synthetic */ PlatformComposerFragment f4090b;

            protected final void m4030a(@android.support.annotation.Nullable Object obj) {
                String str = (String) obj;
                if (Strings.isNullOrEmpty(str)) {
                    PlatformComposerFragment.m4066a(this.f4090b, null, this.f4090b.jW_().getString(2131238406));
                    return;
                }
                if (this.f4090b.aO != null) {
                    PlatformComposerFragment platformComposerFragment = this.f4090b;
                    PlatformComposerModel.Builder a = this.f4090b.aO.m4142a();
                    PlatformComposition.Builder C = this.f4090b.aO.f4188c.m4148C();
                    C.f4225x = new ComposerAppAttribution(x.a(), str, x.c(), x.d());
                    a.f4174c = C.m4145b();
                    platformComposerFragment.aO = a.m4141a();
                }
                if (this.f4090b.aM != null) {
                    this.f4090b.aM.m3964b();
                }
                PlatformComposerFragment.aB(this.f4090b);
            }

            protected final void m4031a(Throwable th) {
                PlatformComposerFragment.m4066a(this.f4090b, th, this.f4090b.jW_().getString(2131238406));
            }
        });
    }

    private void bd() {
        long j = this.aO.f4188c.m4157i().j();
        this.aH.a(PlatformComposerTaskId.FETCH_PLACE_INFO, Futures.a(this.aF.a(GraphQLRequest.a((FetchPlaceLocationQueryString) FetchPlaceLocationGraphQL.a().a("page_id", Long.valueOf(j)))), new Function<GraphQLResult<FetchPlaceLocationQueryModel>, CheckinPlace>(this) {
            final /* synthetic */ PlatformComposerFragment f4093a;

            {
                this.f4093a = r1;
            }

            @android.support.annotation.Nullable
            public Object apply(@android.support.annotation.Nullable Object obj) {
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                if (graphQLResult == null || graphQLResult.e == null || ((FetchPlaceLocationQueryModel) graphQLResult.e).k() == null) {
                    return null;
                }
                CheckinPlaceModel.Builder builder = new CheckinPlaceModel.Builder();
                builder.f = ((FetchPlaceLocationQueryModel) graphQLResult.e).j();
                builder = builder;
                builder.h = ((FetchPlaceLocationQueryModel) graphQLResult.e).l();
                builder = builder;
                LocationModel.Builder builder2 = new LocationModel.Builder();
                builder2.a = ((FetchPlaceLocationQueryModel) graphQLResult.e).k().a();
                builder2 = builder2;
                builder2.b = ((FetchPlaceLocationQueryModel) graphQLResult.e).k().b();
                builder.g = builder2.a();
                return builder.a();
            }
        }, this.aE), new AbstractDisposableFutureCallback<CheckinPlace>(this) {
            final /* synthetic */ PlatformComposerFragment f4092a;

            {
                this.f4092a = r1;
            }

            protected final void m4032a(@android.support.annotation.Nullable Object obj) {
                CheckinPlaceModel checkinPlaceModel = (CheckinPlaceModel) obj;
                if (checkinPlaceModel != null) {
                    ComposerLocationInfo b = ComposerLocationInfo.a(this.f4092a.aO.f4188c.m4157i()).a(checkinPlaceModel).b();
                    PlatformComposerFragment platformComposerFragment = this.f4092a;
                    PlatformComposerModel.Builder a = this.f4092a.aO.m4142a();
                    PlatformComposition.Builder C = this.f4092a.aO.f4188c.m4148C();
                    C.f4208g = b;
                    a.f4174c = C.m4145b();
                    platformComposerFragment.aO = a.m4141a();
                    PlatformComposerFragment.aN(this.f4092a);
                } else if (this.f4092a.aO.f4187b.getPlatformConfiguration() != null && this.f4092a.aO.f4187b.getPlatformConfiguration().dataFailuresFatal) {
                    PlatformComposerFragment.m4066a(this.f4092a, null, this.f4092a.jW_().getString(2131238407));
                }
            }

            protected final void m4033a(Throwable th) {
                if (this.f4092a.aO != null) {
                    if (this.f4092a.aO.f4187b.getPlatformConfiguration() == null || !this.f4092a.aO.f4187b.getPlatformConfiguration().dataFailuresFatal) {
                        PlatformComposerFragment platformComposerFragment = this.f4092a;
                        PlatformComposerModel.Builder a = this.f4092a.aO.m4142a();
                        PlatformComposition.Builder C = this.f4092a.aO.f4188c.m4148C();
                        C.f4208g = null;
                        a.f4174c = C.m4145b();
                        platformComposerFragment.aO = a.m4141a();
                        return;
                    }
                    PlatformComposerFragment.m4066a(this.f4092a, th, this.f4092a.jW_().getString(2131238407));
                }
            }
        });
    }

    private void m4061a(PlatformComposerAttachmentControllerProvider platformComposerAttachmentControllerProvider, PlatformComposerDraftPostController platformComposerDraftPostController, Provider<User> provider, Clock clock, PublishShareHelperProvider publishShareHelperProvider, Lazy<ComposerPublishServiceHelper> lazy, Lazy<SecureContextHelper> lazy2, MetaTextBuilderDelegate metaTextBuilderDelegate, PlatformComposerPrivacyControllerProvider platformComposerPrivacyControllerProvider, AndroidThreadUtil androidThreadUtil, SpringSystem springSystem, Resources resources, Lazy<AudienceSelectorPerformanceLogger> lazy3, PlatformComposerTitleBarControllerProvider platformComposerTitleBarControllerProvider, PlatformComposerTargetSelectorControllerProvider platformComposerTargetSelectorControllerProvider, PlatformComposerPhotoReelControllerProvider platformComposerPhotoReelControllerProvider, PlatformComposerAlbumSelectorControllerProvider platformComposerAlbumSelectorControllerProvider, PlatformComposerRedSpaceControllerProvider platformComposerRedSpaceControllerProvider, FbErrorReporter fbErrorReporter, PlatformComposerConfiguration platformComposerConfiguration, FaceBoxStore faceBoxStore, Lazy<FaceBoxPrioritizer> lazy4, TagStore tagStore, FunnelLogger funnelLogger, PrivacyIcons privacyIcons, ComposerMultimediaCapability composerMultimediaCapability, GatekeeperStore gatekeeperStore, BlueServiceOperationFactory blueServiceOperationFactory, Executor executor, GraphQLQueryExecutor graphQLQueryExecutor, PlatformComposerPerformanceLogger platformComposerPerformanceLogger, TasksManager tasksManager, PlatformComposerMetaTextController platformComposerMetaTextController, OptimisticPostHelperProvider optimisticPostHelperProvider, PlatformComposerDataProviderImplProvider platformComposerDataProviderImplProvider) {
        this.f4108a = platformComposerAttachmentControllerProvider;
        this.f4109b = platformComposerDraftPostController;
        this.f4110c = provider;
        this.f4111d = clock;
        this.f4112e = publishShareHelperProvider;
        this.f4113f = lazy;
        this.f4114g = lazy2;
        this.f4115h = metaTextBuilderDelegate;
        this.f4116i = platformComposerPrivacyControllerProvider;
        this.al = androidThreadUtil;
        this.am = springSystem;
        this.an = resources;
        this.ao = lazy3;
        this.ap = platformComposerTitleBarControllerProvider;
        this.aq = platformComposerTargetSelectorControllerProvider;
        this.ar = platformComposerPhotoReelControllerProvider;
        this.as = platformComposerAlbumSelectorControllerProvider;
        this.at = platformComposerRedSpaceControllerProvider;
        this.au = fbErrorReporter;
        this.av = platformComposerConfiguration;
        this.aw = faceBoxStore;
        this.ax = lazy4;
        this.ay = tagStore;
        this.az = funnelLogger;
        this.aA = privacyIcons;
        this.aB = composerMultimediaCapability;
        this.aC = gatekeeperStore;
        this.aD = blueServiceOperationFactory;
        this.aE = executor;
        this.aF = graphQLQueryExecutor;
        this.aG = platformComposerPerformanceLogger;
        this.aH = tasksManager;
        this.aI = platformComposerMetaTextController;
        this.aJ = optimisticPostHelperProvider;
        this.aK = platformComposerDataProviderImplProvider;
    }
}
