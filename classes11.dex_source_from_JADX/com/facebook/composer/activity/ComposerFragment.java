package com.facebook.composer.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.hardware.Camera;
import android.location.Location;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannedString;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.facebook.abtest.qe.bootstrap.framework.QuickExperimentController;
import com.facebook.abtest.qe.framework.QuickExperimentControllerImpl;
import com.facebook.analytics.ComposerSelfCensorshipTextWatcherEventBuilder;
import com.facebook.analytics.NavigationLogger;
import com.facebook.analytics.SelfCensorshipTextWatcher;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.audiofingerprinting.AudioFingerprintingSession;
import com.facebook.audiofingerprinting.AudioFingerprintingSuggestionsCache;
import com.facebook.auth.annotations.LoggedInUser;
import com.facebook.auth.module.User_LoggedInUserMethodAutoProvider;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.CrossFbProcessBroadcast;
import com.facebook.base.broadcast.CrossProcessFbBroadcastManager;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.callercontexttagger.AnalyticsTagger;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.BackgroundExecutorService;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.i18n.StringLengthHelper;
import com.facebook.common.json.FbObjectMapper;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.time.Clock;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.title.IndicatorBarController;
import com.facebook.common.util.FindViewUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.composer.abtest.ExperimentsForComposerAbTestModule;
import com.facebook.composer.actionitem.ActionItemController$Delegate;
import com.facebook.composer.actionitem.ActionItemListController;
import com.facebook.composer.actionitem.ActionItemListControllerProvider;
import com.facebook.composer.actionitem.PublishModeActionItemControllerProvider;
import com.facebook.composer.activity.ComposerIntentParser.ParseResult;
import com.facebook.composer.activity.PostCompositionView.OnHideListener;
import com.facebook.composer.album.AlbumPillController;
import com.facebook.composer.album.AlbumPillControllerProvider;
import com.facebook.composer.analytics.ComposerAnalyticsEventBuilder;
import com.facebook.composer.analytics.ComposerAnalyticsLogger;
import com.facebook.composer.analytics.ComposerAnalyticsLogger.Events;
import com.facebook.composer.analytics.ComposerPerformanceLogger;
import com.facebook.composer.analytics.PhotoSequences;
import com.facebook.composer.analytics.WithTagPerformanceLogger;
import com.facebook.composer.attachments.AttachmentUtils;
import com.facebook.composer.attachments.ComposerAttachment;
import com.facebook.composer.attachments.ComposerAttachment.ProvidesAttachments;
import com.facebook.composer.attachments.ComposerTagUtil;
import com.facebook.composer.attachments.MediaItemMetaDataExtractor;
import com.facebook.composer.attachments.PhotoTagExtractor;
import com.facebook.composer.audienceeducator.ComposerAudienceEducatorData;
import com.facebook.composer.audienceeducator.ComposerAudienceEducatorData.TagExpansionExplanationType;
import com.facebook.composer.capability.ComposerHeaderCapability;
import com.facebook.composer.capability.ComposerPhotoCapability.Capability;
import com.facebook.composer.capability.ComposerRedSpaceCapability;
import com.facebook.composer.controller.AttachmentCountByContentTypeController;
import com.facebook.composer.controller.AttachmentCountByContentTypeControllerProvider;
import com.facebook.composer.controller.ComposerFb4aTitleBarControllerProvider;
import com.facebook.composer.controller.ComposerFeedOnlyPostController;
import com.facebook.composer.controller.ComposerFeedOnlyPostControllerProvider;
import com.facebook.composer.controller.ComposerHintControllerProvider;
import com.facebook.composer.controller.ComposerPrivacyController;
import com.facebook.composer.controller.ComposerPrivacyControllerProvider;
import com.facebook.composer.controller.ComposerRedSpaceControllerProvider;
import com.facebook.composer.controller.ComposerRedSpaceSubtitleControllerProvider;
import com.facebook.composer.controller.ComposerSellController;
import com.facebook.composer.controller.ComposerSellControllerProvider;
import com.facebook.composer.controller.ComposerSubmitEnabledController;
import com.facebook.composer.controller.ComposerSubmitEnabledControllerProvider;
import com.facebook.composer.controller.LinearComposerPhotoButtonControllerProvider;
import com.facebook.composer.controller.LinkifyController;
import com.facebook.composer.controller.RidgeComposerController;
import com.facebook.composer.controller.RidgeComposerControllerProvider;
import com.facebook.composer.controller.compost.ComposerCompostDraftController;
import com.facebook.composer.datepicker.DatePickerActivity;
import com.facebook.composer.event.ComposerEvent;
import com.facebook.composer.event.ComposerEventHandler;
import com.facebook.composer.event.ComposerEventOriginator;
import com.facebook.composer.facecast.feedattachment.FacecastComposerAttachmentControllerProvider;
import com.facebook.composer.feedattachment.ComposerFeedAttachmentController;
import com.facebook.composer.feedattachment.ComposerFeedAttachmentManager;
import com.facebook.composer.feedattachment.ComposerFeedAttachmentManagerProvider;
import com.facebook.composer.feedattachment.GifComposerAttachmentControllerProvider;
import com.facebook.composer.feedattachment.GifComposerAttachmentProvider;
import com.facebook.composer.feedattachment.LegacyComposerFeedAttachmentManager;
import com.facebook.composer.feedattachment.LegacyComposerFeedAttachmentManagerProvider;
import com.facebook.composer.feedattachment.LegacyFeedAttachmentAdapterProvider;
import com.facebook.composer.feedattachment.ShareComposerAttachmentControllerProvider;
import com.facebook.composer.feedattachment.minutiae.MinutiaeAttachmentControllerProvider;
import com.facebook.composer.inlinesprouts.InlineSproutsController;
import com.facebook.composer.inlinesprouts.InlineSproutsControllerProvider;
import com.facebook.composer.inlinesprouts.InlineSproutsQeWrapper;
import com.facebook.composer.inlinesprouts.InlineSproutsView;
import com.facebook.composer.inlinesprouts.InlineSproutsView.ExpandAnimation;
import com.facebook.composer.inlinesprouts.InlineSproutsView.OnMeasuredListener;
import com.facebook.composer.lifeevent.model.ComposerLifeEventModel;
import com.facebook.composer.location.ComposerLocationProductsPresenter;
import com.facebook.composer.location.ComposerLocationProductsPresenterProvider;
import com.facebook.composer.location.controller.ImplicitLocationPillController;
import com.facebook.composer.location.controller.ImplicitLocationPillControllerProvider;
import com.facebook.composer.location.feedattachment.CheckinPreviewAttachmentControllerProvider;
import com.facebook.composer.metatext.MetaTextBuilderDelegate;
import com.facebook.composer.minutiae.analytics.RidgeAnalyticsLogger;
import com.facebook.composer.minutiae.iconpicker.MinutiaeIconPickerIntentHelper;
import com.facebook.composer.minutiae.model.MinutiaeObject;
import com.facebook.composer.minutiae.music.MusicMetadataHelper;
import com.facebook.composer.minutiae.perf.MinutiaeVerbPickerPerformanceLogger;
import com.facebook.composer.minutiae.protocol.MinutiaeVerbsFetcher;
import com.facebook.composer.minutiae.util.MinutiaeIntentHelper;
import com.facebook.composer.minutiae.util.RidgeOptInController;
import com.facebook.composer.model.ComposerModel;
import com.facebook.composer.pages.PagePublishOptionPillController;
import com.facebook.composer.pages.PagePublishOptionPillControllerProvider;
import com.facebook.composer.privacy.common.ComposerAudienceFragment;
import com.facebook.composer.privacy.common.ComposerAudienceFragment.AudienceDialogData;
import com.facebook.composer.privacy.common.ComposerAudienceFragment.OnAudienceSelectedListener;
import com.facebook.composer.privacy.common.ComposerPrivacyData;
import com.facebook.composer.privacy.common.ComposerPrivacyData.ProvidesPrivacyData;
import com.facebook.composer.privacy.common.ComposerPrivacyDelegate.PrivacyUpdatedHandler;
import com.facebook.composer.privacy.common.ComposerSelectablePrivacyDelegateBase.DataProvider;
import com.facebook.composer.privacy.common.FixedPrivacyView;
import com.facebook.composer.privacy.common.SelectablePrivacyView;
import com.facebook.composer.privacy.controller.FixedPrivacyPillViewControllerProvider;
import com.facebook.composer.privacy.controller.LoadingPrivacyPillViewController;
import com.facebook.composer.privacy.controller.LoadingPrivacyPillViewControllerProvider;
import com.facebook.composer.privacy.controller.SelectablePrivacyPillViewControllerProvider;
import com.facebook.composer.privacy.controller.SelectablePrivacyPillViewUsingBaseTokenControllerProvider;
import com.facebook.composer.privacy.controller.TagExpansionPillViewController;
import com.facebook.composer.privacy.controller.TagExpansionPillViewControllerProvider;
import com.facebook.composer.protocol.ComposerService;
import com.facebook.composer.protocol.ComposerService.2;
import com.facebook.composer.protocol.ComposerService.3;
import com.facebook.composer.protocol.FetchPlaceLocationGraphQL;
import com.facebook.composer.protocol.FetchPlaceLocationGraphQL.FetchPlaceLocationQueryString;
import com.facebook.composer.protocol.FetchPlaceLocationGraphQLModels.FetchPlaceLocationQueryModel;
import com.facebook.composer.publish.ComposerPublishService;
import com.facebook.composer.publish.common.model.ComposerSessionLoggingData;
import com.facebook.composer.publish.helpers.OptimisticPostHelper;
import com.facebook.composer.publish.helpers.OptimisticPostHelperProvider;
import com.facebook.composer.publish.helpers.PublishAttachmentsHelperProvider;
import com.facebook.composer.publish.helpers.PublishEditHelperProvider;
import com.facebook.composer.publish.helpers.PublishStatusHelperProvider;
import com.facebook.composer.publish.helpers.TopicFeedsHelper;
import com.facebook.composer.savedsession.ComposerInstanceTracker;
import com.facebook.composer.savedsession.ComposerSavedSessionController;
import com.facebook.composer.sell.GroupCommerceSellComposerIntercept;
import com.facebook.composer.stickerpost.ComposerStickerController;
import com.facebook.composer.stickerpost.ComposerStickerControllerProvider;
import com.facebook.composer.survey.ComposerSurveyConstraintGenerator;
import com.facebook.composer.survey.ComposerSurveyConstraintGeneratorProvider;
import com.facebook.composer.targetselection.ComposerTargetSelectorControllerProvider;
import com.facebook.composer.tasks.ComposerTaskId;
import com.facebook.composer.tasks.ComposerTaskId.DependantAction;
import com.facebook.composer.tip.ComposerInterstitialControllers;
import com.facebook.composer.tip.ComposerInterstitialTip;
import com.facebook.composer.tip.ComposerTip;
import com.facebook.composer.tip.ComposerTipSessionControl;
import com.facebook.composer.tip.LinearComposerNextButtonTipControllerProvider;
import com.facebook.composer.tip.Tip;
import com.facebook.composer.tip.TipControllerInterface;
import com.facebook.composer.tip.TipManager;
import com.facebook.composer.tip.TipManagerProvider;
import com.facebook.composer.topics.ComposerTopicControllerProvider;
import com.facebook.composer.transliteration.ComposerTransliterationController;
import com.facebook.composer.transliteration.ComposerTransliterationControllerProvider;
import com.facebook.composer.ui.footerbar.FooterElementsListFactoryProvider;
import com.facebook.composer.ui.publishmode.PublishModeSelectorActivity;
import com.facebook.composer.ui.publishmode.PublishModeTitleGenerator;
import com.facebook.composer.ui.publishmode.SchedulePostController;
import com.facebook.composer.ui.statusview.ComposerHeaderViewController;
import com.facebook.composer.ui.statusview.ComposerHeaderViewControllerProvider;
import com.facebook.composer.ui.statusview.ComposerSellView;
import com.facebook.composer.ui.statusview.ComposerStatusView;
import com.facebook.composer.ui.statusview.ComposerStatusView.AfterFirstDrawListener;
import com.facebook.composer.ui.tagging.ComposerAttachmentsAutoTaggingController;
import com.facebook.composer.ui.text.ComposerEditText.TextWithEntitiesChangedListener;
import com.facebook.composer.ui.underwood.ActionUpTouchInterceptorFrameLayout;
import com.facebook.composer.ui.underwood.AttachmentsViewEventListener;
import com.facebook.composer.ui.underwood.UnderwoodLogger;
import com.facebook.composer.util.ComposerScreenSizeUtil;
import com.facebook.contacts.annotations.IsAddressBookSyncEnabled;
import com.facebook.content.SecureContextHelper;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.facecast.FacecastActivity;
import com.facebook.facecast.abtest.ExperimentsForFacecastAbtestModule;
import com.facebook.facecast.model.FacecastCompositionData;
import com.facebook.facerec.manager.FaceBoxPrioritizer;
import com.facebook.facerec.manager.FaceBoxPrioritizer.FaceBoxPrioritizerListener;
import com.facebook.facerec.model.LocalFaceRecImageData;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.feed.util.composer.abtest.ExperimentsForFeedUtilComposerAbtestModule;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.friendsharing.gif.util.GifUtil;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.graphql.enums.GraphQLLifeEventAPIIdentifier;
import com.facebook.graphql.enums.GraphQLPrivacyOptionTagExpansionType;
import com.facebook.graphql.enums.GraphQLPrivacyOptionType;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.GraphQLAlbum;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLPrivacyAudienceMember;
import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.groupcommerce.ui.GroupsSalePostInterceptDialogFragment;
import com.facebook.groupcommerce.ui.GroupsSalePostMarketplaceInfoDialogFragment;
import com.facebook.groupcommerce.ui.SelectCategoryActivity;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.iorg.common.upsell.ui.FbZeroDialogController;
import com.facebook.iorg.common.zero.ui.ZeroDialogController;
import com.facebook.iorg.common.zero.ui.ZeroDialogController.Listener;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsImplicitLocationSupported;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesSessionId;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesTextWithEntities;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.ipc.composer.intent.ComposerPageData;
import com.facebook.ipc.composer.intent.ComposerShareParams;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.ipc.composer.model.ComposerCommerceInfo;
import com.facebook.ipc.composer.model.ComposerContentType;
import com.facebook.ipc.composer.model.ComposerDateInfo;
import com.facebook.ipc.composer.model.ComposerEntryPicker;
import com.facebook.ipc.composer.model.ComposerFacecastInfo;
import com.facebook.ipc.composer.model.ComposerLocation;
import com.facebook.ipc.composer.model.ComposerLocationInfo;
import com.facebook.ipc.composer.model.ComposerSlideshowData;
import com.facebook.ipc.composer.model.ComposerSourceType;
import com.facebook.ipc.composer.model.ComposerTaggedUser;
import com.facebook.ipc.composer.model.ComposerTaggedUser.ProvidesTaggedUsers;
import com.facebook.ipc.composer.model.ComposerType;
import com.facebook.ipc.composer.model.MarketplaceCrossPostSettingModel;
import com.facebook.ipc.composer.model.MinutiaeTag;
import com.facebook.ipc.composer.model.ProductItemAttachment;
import com.facebook.ipc.composer.model.ProductItemLocationPickerSettings;
import com.facebook.ipc.composer.model.ProductItemPlace;
import com.facebook.ipc.composer.model.PublishMode;
import com.facebook.ipc.composer.model.RedSpaceValue;
import com.facebook.ipc.composer.model.TargetType;
import com.facebook.ipc.composer.plugin.ComposerPlugin.InstanceState;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters.BooleanGetter;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters.Getter;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters.PrivacyDelegateGetter;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters.ProvidesPluginSurveyConstraintGetter;
import com.facebook.ipc.composer.plugin.ComposerPluginSession;
import com.facebook.ipc.composer.plugin.impl.ComposerPluginDefault;
import com.facebook.ipc.creativecam.CreativeCamResult;
import com.facebook.ipc.katana.model.GeoRegion.ImplicitLocation;
import com.facebook.ipc.media.MediaIdKey;
import com.facebook.ipc.media.MediaItem;
import com.facebook.ipc.media.MediaItem.MediaType;
import com.facebook.ipc.media.data.LocalMediaData.Builder;
import com.facebook.ipc.media.data.MediaData;
import com.facebook.ipc.model.FacebookProfile;
import com.facebook.ipc.slideshow.SlideshowEditConfiguration;
import com.facebook.ipc.slideshow.SlideshowEditConfigurationSpec.Source;
import com.facebook.ipc.slideshow.SlideshowEditIntentCreator;
import com.facebook.katana.util.logging.FB4A_AnalyticEntities.UIElements;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.base.analytics.DefaultPhotoFlowLogger;
import com.facebook.photos.base.analytics.PhotoFlowLogger;
import com.facebook.photos.base.analytics.PreFilledTagLogger;
import com.facebook.photos.base.media.MediaItemFactory;
import com.facebook.photos.base.media.MediaItemFactory.FallbackMediaId;
import com.facebook.photos.base.media.MediaItemFactory.PhotoItemBuilder;
import com.facebook.photos.base.media.PhotoItem;
import com.facebook.photos.base.photos.LocalPhoto;
import com.facebook.photos.base.tagging.FaceBox;
import com.facebook.photos.base.tagging.Tag;
import com.facebook.photos.creativeediting.analytics.CreativeEditingAnalyticsLogger;
import com.facebook.photos.creativeediting.model.CreativeEditingData;
import com.facebook.photos.taggablegallery.ProductionVideoGalleryActivity;
import com.facebook.photos.taggablegallery.TaggableGalleryActivity;
import com.facebook.photos.taggablegallery.TaggableGalleryConstants;
import com.facebook.photos.tagging.AutoTaggingHelper;
import com.facebook.photos.tagging.store.FaceBoxStore;
import com.facebook.photos.tagging.store.TagStore;
import com.facebook.photos.upload.manager.UploadManager;
import com.facebook.places.checkin.analytics.PlacesPerformanceLogger;
import com.facebook.places.checkin.composerflows.PeopleToPlaceController;
import com.facebook.places.checkin.ipc.CheckinIntentCreator;
import com.facebook.places.checkin.ipc.PlacePickerConfiguration;
import com.facebook.places.checkin.ipc.SearchType;
import com.facebook.places.checkin.protocol.CheckinSearchResultsLoader;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel.LocationModel;
import com.facebook.platform.opengraph.model.OpenGraphActionRobotext;
import com.facebook.platform.server.protocol.GetAppNameMethod.Params;
import com.facebook.platformattribution.PlatformAttributionLaunchHelper;
import com.facebook.privacy.PrivacyOperationsClient;
import com.facebook.privacy.audience.AudienceEducatorManager;
import com.facebook.privacy.audience.AudienceEducatorManager.AudienceEducatorType;
import com.facebook.privacy.model.GraphQLPrivacyOptionBuilder;
import com.facebook.privacy.model.PrivacyOptionHelper;
import com.facebook.privacy.model.SelectablePrivacyData;
import com.facebook.privacy.selector.AudienceSelectorPerformanceLogger;
import com.facebook.privacy.selector.AudienceSelectorPerformanceLogger.Caller;
import com.facebook.privacy.selector.AudienceTypeaheadFragment;
import com.facebook.privacy.selector.AudienceTypeaheadFragment.SelectorListener;
import com.facebook.profilelist.ProfilesListActivity;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.reaction.ReactionComposerManagerProviderMethodAutoProvider;
import com.facebook.reaction.ReactionModule.1;
import com.facebook.reaction.composer.DefaultReactionComposerManager;
import com.facebook.reaction.composer.ReactionComposerManager;
import com.facebook.reaction.composer.ReactionComposerManagerProvider;
import com.facebook.runtimepermissions.ActivityRuntimePermissionsManagerProvider;
import com.facebook.sequencelogger.Sequence;
import com.facebook.share.model.ComposerAppAttribution;
import com.facebook.slideshow.analytics.SlideshowLogger;
import com.facebook.tagging.conversion.FriendSuggestionsAndSelectorActivity;
import com.facebook.tagging.data.TagTypeaheadDataSource;
import com.facebook.tagging.data.TaggingProfiles;
import com.facebook.tagging.graphql.utils.MentionsSpannableStringBuilder;
import com.facebook.tagging.graphql.utils.MentionsUtils;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.SequenceLoggerDetour;
import com.facebook.transliteration.TransliterationActivity;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.Toaster;
import com.facebook.uicontrib.datepicker.Date;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.user.model.User;
import com.facebook.vault.datafetcher.VaultDataFetcher;
import com.facebook.widget.LazyView;
import com.facebook.widget.LazyView.OnInflateRunner;
import com.facebook.widget.ScrollingAwareScrollView;
import com.facebook.widget.ScrollingAwareScrollView.OnScrollListener;
import com.facebook.widget.text.watcher.BaseTextWatcher;
import com.facebook.zero.sdk.common.ZeroFeatureKey;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Multiset;
import com.google.common.collect.RegularImmutableList;
import com.google.common.collect.RegularImmutableSet;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Provider;

/* compiled from: inviters_for_viewer_to_like */
public class ComposerFragment extends FbFragment {
    public static final Class<?> aW = ComposerFragment.class;
    public static final ComposerEventOriginator cn = ComposerEventOriginator.a(ComposerFragment.class);
    @Inject
    @LoggedInUser
    public volatile Provider<User> f6142a = UltralightRuntime.a;
    @Inject
    private AudienceEducatorControllerProvider aA;
    private AudienceEducatorController aB;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<InlinePrivacySurveyController> aC = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<AutoTaggingHelper> aD = UltralightRuntime.b;
    public LinkifyController aE;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<MinutiaeVerbPickerPerformanceLogger> aF = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<ComposerScreenSizeUtil> aG = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<PhotoSequences> aH = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<MinutiaeIconPickerIntentHelper> aI = UltralightRuntime.b;
    @Inject
    private ComposerInstanceTracker aJ;
    @Inject
    private ComposerPrivacyControllerProvider aK;
    public ComposerPluginDefault aL;
    private ComposerPluginSession aM;
    private boolean aN = false;
    @Inject
    private LinearComposerNextButtonTipControllerProvider aO;
    @Inject
    private PlatformAttributionLaunchHelper aP;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<PublishModeTitleGenerator> aQ = UltralightRuntime.b;
    @Inject
    private ComposerDataProviderImplProvider aR;
    public ComposerDataProviderImpl aS;
    @Inject
    private ComposerMutatorImplProvider aT;
    public ComposerMutatorImpl aU;
    @Inject
    private FbObjectMapper aV;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<Clock> aX = UltralightRuntime.b;
    public ComposerSellController aY;
    @Inject
    private ComposerSellControllerProvider aZ;
    @Inject
    private TipManagerProvider al;
    public TipManager am;
    @Inject
    public ComposerIntentParser an;
    @Inject
    private AnalyticsTagger ao;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<NavigationLogger> ap = UltralightRuntime.b;
    @Inject
    private DefaultBlueServiceOperationFactory aq;
    @Inject
    private MetaTextBuilderDelegate ar;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<MonotonicClock> as = UltralightRuntime.b;
    @Inject
    private GatekeeperStoreImpl at;
    @Inject
    private TagStore au;
    @Inject
    public FaceBoxStore av;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<ComposerCompostDraftController> aw = UltralightRuntime.b;
    private ComposerPrivacyController ax;
    @Inject
    private ComposerTargetSelectorControllerProvider ay;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<AndroidThreadUtil> az = UltralightRuntime.b;
    @Inject
    public volatile Provider<MinutiaeVerbsFetcher> f6143b = UltralightRuntime.a;
    @Inject
    public QeAccessor bA;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<PhotoTagExtractor> bB = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<FaceBoxPrioritizer> bC = UltralightRuntime.b;
    @Inject
    private ComposerAttachmentsAutoTaggingController bD;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<PrivacyOperationsClient> bE = UltralightRuntime.b;
    @Inject
    private RidgeComposerControllerProvider bF;
    public RidgeComposerController bG;
    public ComposerLocationProductsPresenter bH;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<ComposerSavedSessionController> bI = UltralightRuntime.b;
    @Inject
    public ComposerAnalyticsLogger bJ;
    @Inject
    private DefaultPhotoFlowLogger bK;
    @Inject
    private SlideshowLogger bL;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<UploadManager> bM = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<FbNetworkManager> bN = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<FbErrorReporter> bO = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<SecureContextHelper> bP = UltralightRuntime.b;
    private long bQ;
    private ScrollingAwareScrollView bR;
    public ComposerStatusView bS;
    private LazyView<TextView> bT;
    private LazyView<PostCompositionView> bU;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<PeopleToPlaceController> bV = UltralightRuntime.b;
    @Inject
    private ComposerFeedAttachmentManagerProvider bW;
    @Inject
    private LegacyComposerFeedAttachmentManagerProvider bX;
    public boolean bY = false;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<VaultDataFetcher> bZ = UltralightRuntime.b;
    @Inject
    private ComposerFb4aTitleBarControllerProvider ba;
    @Inject
    private LinearComposerPhotoButtonControllerProvider bb;
    @Inject
    private ComposerRedSpaceControllerProvider bc;
    @Inject
    private ComposerRedSpaceSubtitleControllerProvider bd;
    @Inject
    private ComposerFeedOnlyPostControllerProvider be;
    @Inject
    private ComposerTransliterationControllerProvider bf;
    @Inject
    private ComposerSurveyConstraintGeneratorProvider bg;
    private boolean bh = true;
    @Nullable
    public ComposerMetaTextController bi;
    private ImmutableSet<Long> bj = RegularImmutableSet.a;
    @Inject
    public ComposerPerformanceLogger bk;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<WithTagPerformanceLogger> bl = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<AudienceSelectorPerformanceLogger> bm = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<MediaItemMetaDataExtractor> bn = UltralightRuntime.b;
    private boolean bo = false;
    @CrossFbProcessBroadcast
    @Inject
    private BaseFbBroadcastManager bp;
    @Inject
    private TaggingProfiles bq;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<PreFilledTagLogger> br = UltralightRuntime.b;
    private boolean bs;
    private long bt;
    private long bu;
    public View bv;
    public LazyView<SelectablePrivacyView> bw;
    public LazyView<FixedPrivacyView> bx;
    private boolean by;
    @Inject
    public TasksManager bz;
    @Inject
    @IsAddressBookSyncEnabled
    volatile Provider<Boolean> f6144c = UltralightRuntime.a;
    @Inject
    private AlbumPillControllerProvider cA;
    @Inject
    private MediaItemFactory cB;
    @Inject
    private ComposerTopicControllerProvider cC;
    @Inject
    private ActivityRuntimePermissionsManagerProvider cD;
    private AttachmentCountByContentTypeController cE;
    @Inject
    private AttachmentCountByContentTypeControllerProvider cF;
    @Inject
    private LegacyFeedAttachmentAdapterProvider cG;
    private final C07551 cH = new C07551(this);
    private final C07562 cI = new C07562(this);
    private C07573 cJ = new C07573(this);
    private C07584 cK = new C07584(this);
    private final C07625 cL = new C07625(this);
    private final C07636 cM = new C07636(this);
    private C07647 cN = new C07647(this);
    @Inject
    private 1 cO;
    private ReactionComposerManager cP;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<Toaster> cQ = UltralightRuntime.b;
    private final TextWatcher cR = new C07658(this);
    public ActionUpTouchInterceptorFrameLayout cS;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<UnderwoodLogger> cT = UltralightRuntime.b;
    @Inject
    private ComposerSubmitEnabledControllerProvider cU;
    public ComposerSubmitEnabledController cV;
    @Inject
    private FooterElementsListFactoryProvider cW;
    @Inject
    private MinutiaeAttachmentControllerProvider cX;
    @Inject
    private GifComposerAttachmentControllerProvider cY;
    @Inject
    private GifComposerAttachmentProvider cZ;
    @BackgroundExecutorService
    @Inject
    private ExecutorService ca;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<PlacesPerformanceLogger> cb = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<GroupCommerceSellComposerIntercept> cc = UltralightRuntime.b;
    @Inject
    private PublishStatusHelperProvider cd;
    @Inject
    private PublishEditHelperProvider ce;
    @Inject
    private PublishAttachmentsHelperProvider cf;
    @Inject
    private OptimisticPostHelperProvider cg;
    @Inject
    private ActionItemListControllerProvider ch;
    private ActionItemListController ci;
    @Inject
    private ComposerStickerControllerProvider cj;
    public boolean ck;
    @Inject
    private ComposerLocationProductsPresenterProvider cl;
    @Inject
    private ComposerHintControllerProvider cm;
    private InlineSproutsController co;
    @Inject
    private InlineSproutsQeWrapper cp;
    @Inject
    private InlineSproutsControllerProvider cq;
    @Inject
    private LoadingPrivacyPillViewControllerProvider cr;
    @Inject
    private ImplicitLocationPillControllerProvider cs;
    @Inject
    private PagePublishOptionPillControllerProvider ct;
    @Inject
    private TagExpansionPillViewControllerProvider cu;
    @Inject
    private FixedPrivacyPillViewControllerProvider cv;
    @Inject
    private SelectablePrivacyPillViewControllerProvider cw;
    @Inject
    private SelectablePrivacyPillViewUsingBaseTokenControllerProvider cx;
    @Inject
    private ComposerHeaderViewControllerProvider cy;
    private ComposerHeaderViewController cz;
    @Inject
    volatile Provider<AnalyticsLogger> f6145d = UltralightRuntime.a;
    private final AnonymousClass32 dA = new Object(this) {
        public final /* synthetic */ ComposerFragment f6063a;

        {
            this.f6063a = r1;
        }
    };
    private final AnonymousClass33 dB = new Object(this) {
        final /* synthetic */ ComposerFragment f6064a;

        {
            this.f6064a = r1;
        }

        public final void m7464a() {
            this.f6064a.bS.setIsAddMorePhotosAllowed(this.f6064a.aS.ax() == Capability.ALLOW);
        }
    };
    private final AnonymousClass34 dC = new Object(this) {
        public final /* synthetic */ ComposerFragment f6065a;

        {
            this.f6065a = r1;
        }
    };
    private final AnonymousClass35 dD = new Object(this) {
        final /* synthetic */ ComposerFragment f6066a;

        {
            this.f6066a = r1;
        }

        public final void m7466a(ComposerPrivacyData composerPrivacyData, boolean z) {
            this.f6066a.dZ.a(composerPrivacyData, z);
        }

        public final void m7465a() {
            this.f6066a.bk.c.c(917513, "ComposerSelectedPrivacyAvailable");
        }
    };
    private final AnonymousClass36 dE = new Object(this) {
        public final /* synthetic */ ComposerFragment f6067a;

        {
            this.f6067a = r1;
        }

        public final void m7468a(GraphQLTextWithEntities graphQLTextWithEntities) {
            this.f6067a.aU.m7630b(ComposerFragment.cn).m7670a(graphQLTextWithEntities).m7689a();
        }

        public final void m7467a(ComposerLifeEventModel composerLifeEventModel, @Nullable ComposerEventOriginator composerEventOriginator) {
            ComposerMutatorImpl composerMutatorImpl = this.f6067a.aU;
            if (composerEventOriginator == null) {
                composerEventOriginator = ComposerFragment.cn;
            }
            composerMutatorImpl.m7630b(composerEventOriginator).m7664a(composerLifeEventModel).m7689a();
        }
    };
    private final AnonymousClass37 dF = new DataProvider(this) {
        public final /* synthetic */ ComposerFragment f6068a;

        {
            this.f6068a = r1;
        }

        public final boolean m7469a() {
            return this.f6068a.aS.m7445w();
        }

        public final boolean m7470b() {
            return this.f6068a.cV.m7747b();
        }

        public final boolean m7471c() {
            return this.f6068a.aS.ag() == null || this.f6068a.aS.ag().d;
        }

        @Nullable
        public final GraphQLAlbum m7472d() {
            return this.f6068a.aS.ad();
        }

        @Nullable
        public final GraphQLPrivacyOption m7473f() {
            return this.f6068a.aS.m7421X();
        }

        public final PrivacyDelegateGetter m7474h() {
            return this.f6068a.aL.y;
        }
    };
    private final AnonymousClass38 dG = new Object(this) {
        public final /* synthetic */ ComposerFragment f6069a;

        {
            this.f6069a = r1;
        }

        public final String m7475a() {
            return this.f6069a.aS.ab();
        }

        public final ComposerAudienceEducatorData m7476d() {
            return this.f6069a.aS.az();
        }

        public final ComposerPrivacyData m7477e() {
            return this.f6069a.aS.ag();
        }
    };
    private final AnonymousClass39 dH = new Object(this) {
        public final /* synthetic */ ComposerFragment f6070a;

        {
            this.f6070a = r1;
        }

        public final ComposerPrivacyData m7478b() {
            return this.f6070a.aS.ag();
        }
    };
    private final AnonymousClass40 dI = new Object(this) {
        public final /* synthetic */ ComposerFragment f6072a;

        {
            this.f6072a = r1;
        }

        public final void m7479a(ProductItemPlace productItemPlace) {
            if (productItemPlace != null) {
                this.f6072a.bS.setStructuredLocationText(productItemPlace.name);
            }
            ComposerFragment.bf(this.f6072a);
        }

        public final void m7480a(String str) {
            if (!StringUtil.a(str) && StringUtil.a(this.f6072a.bS.getPickupDeliveryText())) {
                this.f6072a.bS.setPickupDeliveryText(str.substring(0, Math.min(5, str.length())));
            }
            ComposerFragment.bf(this.f6072a);
        }
    };
    private final AnonymousClass41 dJ = new Object(this) {
        final /* synthetic */ ComposerFragment f6073a;

        {
            this.f6073a = r1;
        }

        public final ComposerModel m7481a() {
            return this.f6073a.aU.f6187f;
        }

        public final ComposerPluginDefault m7482b() {
            return this.f6073a.aL;
        }
    };
    public final AnonymousClass42 dK = new Object(this) {
        public final /* synthetic */ ComposerFragment f6074a;

        {
            this.f6074a = r1;
        }
    };
    @Inject
    private ComposerShortcutUtil dL;
    private final AnonymousClass63 dM = new Object(this) {
        public final /* synthetic */ ComposerFragment f6103a;

        {
            this.f6103a = r1;
        }
    };
    private final TextWithEntitiesChangedListener dN = new TextWithEntitiesChangedListener(this) {
        final /* synthetic */ ComposerFragment f6104a;

        {
            this.f6104a = r1;
        }

        public final void m7508a(GraphQLTextWithEntities graphQLTextWithEntities, boolean z) {
            m7506b(graphQLTextWithEntities);
            ComposerFragment.aB(this.f6104a).a(graphQLTextWithEntities.a());
            ComposerFragment composerFragment = this.f6104a;
            boolean z2 = false;
            if (composerFragment.aS.m7442r() == null && ((composerFragment.aS.m7436l() == null || composerFragment.aS.m7436l().hideAttachment) && composerFragment.aS.m7427c() == ComposerContentType.NO_ATTACHMENTS && !(composerFragment.aS.m7439o().isEdit() && (composerFragment.aS.m7443s().targetType == TargetType.USER || composerFragment.aS.m7443s().targetType == TargetType.GROUP || composerFragment.aS.m7443s().targetType == TargetType.EVENT)))) {
                z2 = composerFragment.aL.f() != null ? composerFragment.aL.f().a() : true;
            }
            if (z2) {
                composerFragment = this.f6104a;
                if (composerFragment.aE == null) {
                    composerFragment.aE = new LinkifyController();
                }
                ComposerShareParams a = composerFragment.aE.m7757a(graphQLTextWithEntities.a(), z, this.f6104a.aU.f6187f.f6745c.getRemovedURLs());
                if (a != null) {
                    this.f6104a.aU.m7630b(ComposerFragment.cn).m7690b(a).m7689a();
                    this.f6104a.bJ.a.a(new ComposerAnalyticsEventBuilder("add_link_attachment").h(this.f6104a.aS.ab()).m(this.f6104a.aS.m7439o().isEdit()).a);
                }
            }
            if (!(StringUtil.c(graphQLTextWithEntities.a()) || this.f6104a.ck)) {
                this.f6104a.bJ.a(this.f6104a.aS.ab(), ((Clock) this.f6104a.aX.get()).a());
                this.f6104a.ck = true;
            }
            ComposerSessionLoggingData b = this.f6104a.aS.m7426b();
            if (z) {
                this.f6104a.bJ.a(Events.COMPOSER_TEXT_PASTED, this.f6104a.aS.ab());
                this.f6104a.aU.m7630b(ComposerFragment.cn).m7667a(ComposerSessionLoggingData.a(b).setNumberOfCopyPastes(b.getNumberOfPastes() + 1).setNumberOfKeystrokes(b.getNumberOfKeystrokes() + 1).a()).m7689a();
            } else {
                this.f6104a.aU.m7630b(ComposerFragment.cn).m7667a(ComposerSessionLoggingData.a(b).setNumberOfKeystrokes(b.getNumberOfKeystrokes() + 1).a()).m7689a();
            }
            this.f6104a.aU.m7627a(ComposerEvent.ON_STATUS_TEXT_CHANGED, ComposerFragment.cn);
        }

        public final void m7507a(GraphQLTextWithEntities graphQLTextWithEntities) {
            m7506b(graphQLTextWithEntities);
            ComposerFragment.aB(this.f6104a).a(MentionsUtils.a(this.f6104a.aS.ae()));
            ComposerFragment.be(this.f6104a);
        }

        private void m7506b(GraphQLTextWithEntities graphQLTextWithEntities) {
            this.f6104a.aU.m7630b(ComposerFragment.cn).m7670a(graphQLTextWithEntities).m7689a();
        }
    };
    private final AnonymousClass65 dO = new Object(this) {
        public final /* synthetic */ ComposerFragment f6105a;

        {
            this.f6105a = r1;
        }
    };
    private final ActionItemController$Delegate dP = new ActionItemController$Delegate(this) {
        final /* synthetic */ ComposerFragment f6106a;

        {
            this.f6106a = r1;
        }

        public final void mo184a() {
            ComposerFragment.bL(this.f6106a);
            ComposerFragment.bg(this.f6106a);
        }
    };
    private final ActionItemController$Delegate dQ = new ActionItemController$Delegate(this) {
        final /* synthetic */ ComposerFragment f6107a;

        {
            this.f6107a = r1;
        }

        public final void mo184a() {
            this.f6107a.bS.m8417b();
            this.f6107a.bS.m8421c();
        }
    };
    private final ActionItemController$Delegate dR = new ActionItemController$Delegate(this) {
        final /* synthetic */ ComposerFragment f6108a;

        {
            this.f6108a = r1;
        }

        public final void mo184a() {
            ComposerFragment.bZ(this.f6108a);
        }
    };
    private final ActionItemController$Delegate dS = new ActionItemController$Delegate(this) {
        final /* synthetic */ ComposerFragment f6109a;

        {
            this.f6109a = r1;
        }

        public final void mo184a() {
            ComposerFragment.bT(this.f6109a);
        }
    };
    private final ActionItemController$Delegate dT = new ActionItemController$Delegate(this) {
        final /* synthetic */ ComposerFragment f6111a;

        {
            this.f6111a = r1;
        }

        public final void mo184a() {
            ComposerFragment.bK(this.f6111a);
        }
    };
    private final ActionItemController$Delegate dU = new ActionItemController$Delegate(this) {
        final /* synthetic */ ComposerFragment f6112a;

        {
            this.f6112a = r1;
        }

        public final void mo184a() {
            if (this.f6112a.aS.aA().isVideoTaggingPromptShowing() && this.f6112a.bA.a(ExperimentsForComposerAbTestModule.B, false)) {
                ComposerFragment composerFragment = this.f6112a;
                List<MediaData> arrayList = new ArrayList();
                ImmutableList m = composerFragment.aS.m7437m();
                int size = m.size();
                for (int i = 0; i < size; i++) {
                    ComposerAttachment composerAttachment = (ComposerAttachment) m.get(i);
                    if (!(composerAttachment.g() == null || composerAttachment.g().getFrames().isEmpty())) {
                        arrayList.addAll(composerAttachment.g().getFrames());
                    }
                }
                ArrayList arrayList2 = new ArrayList();
                for (MediaData mediaData : arrayList) {
                    PhotoItemBuilder photoItemBuilder = new PhotoItemBuilder();
                    photoItemBuilder.f = new Builder().a(mediaData).a();
                    arrayList2.add(photoItemBuilder.a());
                }
                Intent putExtra = new Intent(composerFragment.getContext(), TaggableGalleryActivity.class).putParcelableArrayListExtra("extra_taggable_gallery_photo_list", arrayList2).putExtra("extra_session_id", composerFragment.aS.ab()).putExtra("extra_taggable_gallery_photo_item_id", ((PhotoItem) arrayList2.get(0)).d());
                composerFragment.bJ.a(Events.COMPOSER_VIDEO_TAG_CLICK, composerFragment.aS.ab());
                composerFragment.a(putExtra, 131);
                return;
            }
            ComposerFragment.bJ(this.f6112a);
        }
    };
    private final ActionItemController$Delegate dV = new ActionItemController$Delegate(this) {
        final /* synthetic */ ComposerFragment f6113a;

        {
            this.f6113a = r1;
        }

        public final void mo184a() {
            ComposerFragment.bM(this.f6113a);
        }
    };
    private final AnonymousClass73 dW = new Object(this) {
        public final /* synthetic */ ComposerFragment f6114a;

        {
            this.f6114a = r1;
        }
    };
    private final ActionItemController$Delegate dX = new ActionItemController$Delegate(this) {
        final /* synthetic */ ComposerFragment f6115a;

        {
            this.f6115a = r1;
        }

        public final void mo184a() {
            ComposerFragment.bd(this.f6115a);
        }
    };
    private final ActionItemController$Delegate dY = new ActionItemController$Delegate(this) {
        final /* synthetic */ ComposerFragment f6116a;

        {
            this.f6116a = r1;
        }

        public final void mo184a() {
            ComposerFragment.bV(this.f6116a);
        }
    };
    public final PrivacyUpdatedHandler dZ = new PrivacyUpdatedHandler(this) {
        final /* synthetic */ ComposerFragment f6138a;

        {
            this.f6138a = r1;
        }

        public final void m7531a(ComposerPrivacyData composerPrivacyData, boolean z) {
            boolean z2 = true;
            ((DefaultAndroidThreadUtil) this.f6138a.az.get()).a();
            TransactionImpl a = this.f6138a.aU.m7630b(ComposerFragment.cn).m7666a(composerPrivacyData);
            SelectablePrivacyData selectablePrivacyData = this.f6138a.aS.ag().b;
            SelectablePrivacyData selectablePrivacyData2 = composerPrivacyData.b;
            Object obj = null;
            if (!(selectablePrivacyData == null || selectablePrivacyData2 == null || ((selectablePrivacyData.a != null && selectablePrivacyData.a.selectedPrivacyOption != null && selectablePrivacyData2.a != null && selectablePrivacyData2.a.selectedPrivacyOption != null && !selectablePrivacyData2.a.selectedPrivacyOption.equals(selectablePrivacyData.a.selectedPrivacyOption)) || selectablePrivacyData.d == null || selectablePrivacyData2.d == null || (PrivacyOptionHelper.a(selectablePrivacyData.d, selectablePrivacyData2.d) && selectablePrivacyData.b == selectablePrivacyData2.b)))) {
                obj = 1;
            }
            if (obj != null) {
                a.m7700d(true);
            }
            a.m7689a();
            if (composerPrivacyData.b != null && this.f6138a.aS.ag().d) {
                this.f6138a.bJ.a(Events.COMPOSER_PRIVACY_READY, this.f6138a.aS.ab());
            }
            if (this.f6138a.aS.ag().b == null || this.f6138a.aS.ag().b.a == null) {
                z2 = false;
            }
            if (!(this.f6138a.aS.m7413O() || this.f6138a.bv == null)) {
                if (this.f6138a.aS.ag().c) {
                    this.f6138a.bv.setVisibility(0);
                    if (z2) {
                        ((SelectablePrivacyView) this.f6138a.bw.a()).setVisibility(0);
                        if (this.f6138a.bx.b()) {
                            ((FixedPrivacyView) this.f6138a.bx.a()).setVisibility(8);
                        }
                        ((SelectablePrivacyView) this.f6138a.bw.a()).a(ComposerFragment.cc(this.f6138a), this.f6138a.aS.ag());
                    } else if (this.f6138a.aS.ag().d) {
                        ((SelectablePrivacyView) this.f6138a.bw.a()).setVisibility(0);
                        if (this.f6138a.bx.b()) {
                            ((FixedPrivacyView) this.f6138a.bx.a()).setVisibility(8);
                        }
                        ((SelectablePrivacyView) this.f6138a.bw.a()).a(ComposerFragment.cc(this.f6138a), this.f6138a.aS.ag());
                    } else if (this.f6138a.aS.ag().a != null) {
                        if (this.f6138a.bw.b()) {
                            ((SelectablePrivacyView) this.f6138a.bw.a()).setVisibility(8);
                        }
                        ((FixedPrivacyView) this.f6138a.bx.a()).setVisibility(0);
                        FixedPrivacyView fixedPrivacyView = (FixedPrivacyView) this.f6138a.bx.a();
                        ComposerFragment.cc(this.f6138a);
                        fixedPrivacyView.a(this.f6138a.aS.ag().a, this.f6138a.aS.ad());
                    }
                } else {
                    this.f6138a.bv.setVisibility(8);
                    return;
                }
            }
            if (z2) {
                if (this.f6138a.bY) {
                    this.f6138a.bY = false;
                    ComposerFragment.bd(this.f6138a);
                }
                if (z) {
                    this.f6138a.aU.m7630b(ComposerFragment.cn).m7669a(this.f6138a.aS.ag().b.b()).m7689a();
                }
            }
            ComposerFragment.ce(this.f6138a);
            this.f6138a.aU.m7627a(ComposerEvent.ON_PRIVACY_FETCHED, ComposerFragment.cn);
        }
    };
    @Inject
    private FacecastComposerAttachmentControllerProvider da;
    @Inject
    private ShareComposerAttachmentControllerProvider db;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<CreativeEditingAnalyticsLogger> dc = UltralightRuntime.b;
    @Inject
    private CheckinPreviewAttachmentControllerProvider dd;
    private final C07669 de = new C07669(this);
    @Inject
    private IndicatorBarController df;
    @Inject
    private ZeroDialogController dg;
    private final AnonymousClass10 dh = new Object(this) {
        public final /* synthetic */ ComposerFragment f6038a;

        {
            this.f6038a = r1;
        }
    };
    private final AnonymousClass11 di = new Object(this) {
        public final /* synthetic */ ComposerFragment f6039a;

        {
            this.f6039a = r1;
        }
    };
    private final AnonymousClass12 dj = new Object(this) {
        final /* synthetic */ ComposerFragment f6040a;

        {
            this.f6040a = r1;
        }

        public final void m7450a() {
            ComposerFragment.bL(this.f6040a);
        }
    };
    private final AnonymousClass13 dk = new Object(this) {
        public final /* synthetic */ ComposerFragment f6041a;

        {
            this.f6041a = r1;
        }
    };
    private final AnonymousClass14 dl = new Object(this) {
        public final /* synthetic */ ComposerFragment f6042a;

        {
            this.f6042a = r1;
        }
    };
    private final AnonymousClass15 dm = new Object(this) {
        final /* synthetic */ ComposerFragment f6043a;

        {
            this.f6043a = r1;
        }

        public final void m7451a() {
            ((NavigationLogger) this.f6043a.ap.get()).a("tap_composer_footer_buttons");
            ComposerFragment.bJ(this.f6043a);
        }
    };
    private final AnonymousClass16 dn = new Object(this) {
        public final /* synthetic */ ComposerFragment f6044a;

        {
            this.f6044a = r1;
        }
    };
    private final AnonymousClass17 f6146do = new Object(this) {
        final /* synthetic */ ComposerFragment f6045a;

        {
            this.f6045a = r1;
        }

        public final void m7452a() {
            ((NavigationLogger) this.f6045a.ap.get()).a("tap_composer_footer_buttons");
            ComposerFragment.bM(this.f6045a);
        }
    };
    public final AnonymousClass18 dp = new Object(this) {
        final /* synthetic */ ComposerFragment f6046a;

        {
            this.f6046a = r1;
        }

        public final void m7453a() {
            Integer num;
            ((NavigationLogger) this.f6046a.ap.get()).a("tap_composer_footer_buttons");
            ComposerFragment composerFragment = this.f6046a;
            Integer num2 = null;
            ComposerLifeEventModel n = composerFragment.aS.m7438n();
            ComposerDateInfo composerDateInfo = (ComposerDateInfo) Preconditions.checkNotNull(composerFragment.aS.m7428d());
            User user = (User) composerFragment.f6142a.get();
            Context context = composerFragment.getContext();
            GraphQLLifeEventAPIIdentifier graphQLLifeEventAPIIdentifier = n.b;
            Date.Builder builder = new Date.Builder();
            builder.a = user.B;
            Date.Builder builder2 = builder;
            if (user.C == 0) {
                num = null;
            } else {
                num = Integer.valueOf(user.C);
            }
            builder2.b = num;
            builder = builder2;
            if (user.D != 0) {
                num2 = Integer.valueOf(user.D);
            }
            builder.c = num2;
            ((SecureContextHelper) composerFragment.bP.get()).a(DatePickerActivity.m7782a(context, graphQLLifeEventAPIIdentifier, builder.a(), composerDateInfo.a(), composerDateInfo.b(), composerDateInfo.c(), n.h), 8, composerFragment);
        }
    };
    private final AnonymousClass21 dq = new Object(this) {
        public final /* synthetic */ ComposerFragment f6050a;

        {
            this.f6050a = r1;
        }
    };
    private final SelectorListener dr = new SelectorListener(this) {
        final /* synthetic */ ComposerFragment f6052a;
        private boolean f6053b = false;

        {
            this.f6052a = r2;
        }

        public final void m7455a() {
            this.f6052a.bJ.a(Events.COMPOSER_OPEN_PRIVACY, this.f6052a.aS.ab(), this.f6052a.aS.m7443s().targetId, this.f6052a.aS.m7439o().getComposerType());
            this.f6052a.am.a(Tip.INTERSTITIAL_NUX, true);
        }

        public final void m7456b() {
            this.f6052a.aU.m7627a(ComposerEvent.ON_TAG_EXPANSION_DISABLED, ComposerFragment.cn);
        }

        public final void m7457c() {
            if (!this.f6053b) {
                this.f6053b = true;
                this.f6052a.bJ.a(Events.COMPOSER_PICKS_PRIVACY_FROM_TYPEAHEAD_FILTER, this.f6052a.aS.ab());
            }
        }
    };
    private final OnAudienceSelectedListener ds = new OnAudienceSelectedListener(this) {
        final /* synthetic */ ComposerFragment f6054a;

        {
            this.f6054a = r1;
        }

        public final void m7458a(SelectablePrivacyData selectablePrivacyData) {
            ComposerFragment.m7542a(this.f6054a, selectablePrivacyData);
        }
    };
    private final AnonymousClass25 dt = new Object(this) {
        public final /* synthetic */ ComposerFragment f6055a;

        {
            this.f6055a = r1;
        }
    };
    private final AudienceDialogData du = new AudienceDialogData(new AudienceTypeaheadFragment.DataProvider(this) {
        final /* synthetic */ ComposerFragment f6056a;

        {
            this.f6056a = r1;
        }

        public final SelectablePrivacyData m7459a() {
            return this.f6056a.aS.ag().b;
        }

        public final boolean m7460b() {
            return !ComposerFragment.cd(this.f6056a).isEmpty();
        }
    }, this.ds, this.dr);
    public final AnonymousClass27 dv = new Object(this) {
        final /* synthetic */ ComposerFragment f6057a;

        {
            this.f6057a = r1;
        }

        public final SelectablePrivacyData m7461a() {
            return this.f6057a.aS.ag().b;
        }

        public final boolean m7462b() {
            return !ComposerFragment.cd(this.f6057a).isEmpty();
        }
    };
    public final AnonymousClass28 dw = new Object(this) {
        public final /* synthetic */ ComposerFragment f6058a;

        {
            this.f6058a = r1;
        }

        public final void m7463a() {
            ComposerFragment.bA(this.f6058a);
        }
    };
    private final AnonymousClass29 dx = new Object(this) {
        public final /* synthetic */ ComposerFragment f6059a;

        {
            this.f6059a = r1;
        }
    };
    private final AnonymousClass30 dy = new Object(this) {
        public final /* synthetic */ ComposerFragment f6061a;

        {
            this.f6061a = r1;
        }
    };
    private final AnonymousClass31 dz = new Object(this) {
        public final /* synthetic */ ComposerFragment f6062a;

        {
            this.f6062a = r1;
        }
    };
    public final AnonymousClass19 f6147e = new Object(this) {
        public final /* synthetic */ ComposerFragment f6047a;

        {
            this.f6047a = r1;
        }
    };
    public final AnonymousClass20 f6148f = new Object(this) {
        public final /* synthetic */ ComposerFragment f6049a;

        {
            this.f6049a = r1;
        }
    };
    public final AnonymousClass22 f6149g = new Object(this) {
        public final /* synthetic */ ComposerFragment f6051a;

        {
            this.f6051a = r1;
        }
    };
    AnonymousClass62 f6150h = new Object(this) {
        final /* synthetic */ ComposerFragment f6102a;

        {
            this.f6102a = r1;
        }

        public final void m7505a() {
            ComposerFragment.m7558b(this.f6102a, AttachmentUtils.e(this.f6102a.aS.m7437m()));
        }
    };
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<ComposerService> f6151i = UltralightRuntime.b;

    /* compiled from: inviters_for_viewer_to_like */
    public class C07551 {
        final /* synthetic */ ComposerFragment f6048a;

        C07551(ComposerFragment composerFragment) {
            this.f6048a = composerFragment;
        }

        public final void m7454a() {
            ComposerFragment.bd(this.f6048a);
        }
    }

    /* compiled from: inviters_for_viewer_to_like */
    public class C07562 {
        public final /* synthetic */ ComposerFragment f6060a;

        C07562(ComposerFragment composerFragment) {
            this.f6060a = composerFragment;
        }
    }

    /* compiled from: inviters_for_viewer_to_like */
    public class C07573 {
        public final /* synthetic */ ComposerFragment f6071a;

        C07573(ComposerFragment composerFragment) {
            this.f6071a = composerFragment;
        }
    }

    /* compiled from: inviters_for_viewer_to_like */
    public class C07584 {
        public final /* synthetic */ ComposerFragment f6083a;

        C07584(ComposerFragment composerFragment) {
            this.f6083a = composerFragment;
        }

        public final void m7491a(AudienceEducatorType audienceEducatorType) {
            switch (AnonymousClass92.f6139a[audienceEducatorType.ordinal()]) {
                case 1:
                    this.f6083a.aU.m7627a(ComposerEvent.ON_AAA_TUX_COMPLETED, ComposerFragment.cn);
                    return;
                case 2:
                    this.f6083a.aU.m7627a(ComposerEvent.ON_AAA_ONLY_ME_COMPLETED, ComposerFragment.cn);
                    return;
                case 3:
                    this.f6083a.aU.m7627a(ComposerEvent.ON_NEWCOMER_AUDIENCE_SELECTOR_COMPLETED, ComposerFragment.cn);
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: inviters_for_viewer_to_like */
    public class C07625 {
        public final /* synthetic */ ComposerFragment f6099a;

        C07625(ComposerFragment composerFragment) {
            this.f6099a = composerFragment;
        }
    }

    /* compiled from: inviters_for_viewer_to_like */
    public class C07636 {
        final /* synthetic */ ComposerFragment f6110a;

        C07636(ComposerFragment composerFragment) {
            this.f6110a = composerFragment;
        }

        public final void m7513a(String str) {
            this.f6110a.bS.setHint(str);
        }
    }

    /* compiled from: inviters_for_viewer_to_like */
    public class C07647 {
        public final /* synthetic */ ComposerFragment f6125a;

        C07647(ComposerFragment composerFragment) {
            this.f6125a = composerFragment;
        }
    }

    /* compiled from: inviters_for_viewer_to_like */
    class C07658 extends BaseTextWatcher {
        final /* synthetic */ ComposerFragment f6136a;

        C07658(ComposerFragment composerFragment) {
            this.f6136a = composerFragment;
        }

        public void afterTextChanged(Editable editable) {
            ComposerFragment.bf(this.f6136a);
        }
    }

    /* compiled from: inviters_for_viewer_to_like */
    public /* synthetic */ class AnonymousClass92 {
        static final /* synthetic */ int[] f6139a = new int[AudienceEducatorType.values().length];
        public static final /* synthetic */ int[] f6140b = new int[MediaType.values().length];

        static {
            try {
                f6140b[MediaType.PHOTO.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f6140b[MediaType.VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f6139a[AudienceEducatorType.AUDIENCE_ALIGNMENT_EDUCATOR.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f6139a[AudienceEducatorType.AUDIENCE_ALIGNMENT_ONLY_ME_EDUCATOR.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f6139a[AudienceEducatorType.NEWCOMER_AUDIENCE_EDUCATOR.ordinal()] = 3;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    /* compiled from: inviters_for_viewer_to_like */
    public class C07669 {
        public final /* synthetic */ ComposerFragment f6141a;

        C07669(ComposerFragment composerFragment) {
            this.f6141a = composerFragment;
        }
    }

    public static void m7550a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((ComposerFragment) obj).m7553a(IdBasedProvider.a(injectorLike, 3595), IdBasedProvider.a(injectorLike, 5255), IdBasedProvider.a(injectorLike, 3940), IdBasedSingletonScopeProvider.a(injectorLike, 175), IdBasedLazy.a(injectorLike, 5268), (TipManagerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(TipManagerProvider.class), ComposerIntentParser.m7603a(injectorLike), AnalyticsTagger.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 137), DefaultBlueServiceOperationFactory.a(injectorLike), MetaTextBuilderDelegate.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 601), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), TagStore.a(injectorLike), FaceBoxStore.a(injectorLike), IdBasedLazy.a(injectorLike, 5216), (ComposerTargetSelectorControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ComposerTargetSelectorControllerProvider.class), IdBasedLazy.a(injectorLike, 517), (AudienceEducatorControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(AudienceEducatorControllerProvider.class), IdBasedLazy.a(injectorLike, 5188), IdBasedLazy.a(injectorLike, 9432), IdBasedSingletonScopeProvider.b(injectorLike, 5246), IdBasedLazy.a(injectorLike, 5305), IdBasedLazy.a(injectorLike, 5191), IdBasedSingletonScopeProvider.b(injectorLike, 5239), ComposerInstanceTracker.m8225a(injectorLike), (ComposerPrivacyControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ComposerPrivacyControllerProvider.class), (LinearComposerNextButtonTipControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(LinearComposerNextButtonTipControllerProvider.class), PlatformAttributionLaunchHelper.a(injectorLike), IdBasedLazy.a(injectorLike, 5299), (ComposerDataProviderImplProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ComposerDataProviderImplProvider.class), (ComposerMutatorImplProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ComposerMutatorImplProvider.class), FbObjectMapperMethodAutoProvider.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 609), (ComposerSellControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ComposerSellControllerProvider.class), (ComposerFb4aTitleBarControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ComposerFb4aTitleBarControllerProvider.class), (LinearComposerPhotoButtonControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(LinearComposerPhotoButtonControllerProvider.class), (ComposerRedSpaceControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ComposerRedSpaceControllerProvider.class), (ComposerRedSpaceSubtitleControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ComposerRedSpaceSubtitleControllerProvider.class), (ComposerFeedOnlyPostControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ComposerFeedOnlyPostControllerProvider.class), (ComposerTransliterationControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ComposerTransliterationControllerProvider.class), (ComposerSurveyConstraintGeneratorProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ComposerSurveyConstraintGeneratorProvider.class), ComposerPerformanceLogger.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 5192), IdBasedSingletonScopeProvider.b(injectorLike, 9716), IdBasedLazy.a(injectorLike, 5194), (BaseFbBroadcastManager) CrossProcessFbBroadcastManager.a(injectorLike), TaggingProfiles.a(injectorLike), IdBasedLazy.a(injectorLike, 9256), TasksManager.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), IdBasedLazy.a(injectorLike, 5195), IdBasedLazy.a(injectorLike, 5764), ComposerAttachmentsAutoTaggingController.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 9683), (RidgeComposerControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(RidgeComposerControllerProvider.class), IdBasedLazy.a(injectorLike, 5283), ComposerAnalyticsLogger.a(injectorLike), DefaultPhotoFlowLogger.a(injectorLike), SlideshowLogger.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 2984), IdBasedSingletonScopeProvider.b(injectorLike, 585), IdBasedSingletonScopeProvider.b(injectorLike, 494), IdBasedSingletonScopeProvider.b(injectorLike, 968), IdBasedLazy.a(injectorLike, 9517), (ComposerFeedAttachmentManagerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ComposerFeedAttachmentManagerProvider.class), (LegacyComposerFeedAttachmentManagerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(LegacyComposerFeedAttachmentManagerProvider.class), IdBasedLazy.a(injectorLike, 11557), (ExecutorService) ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 2997), IdBasedLazy.a(injectorLike, 5285), (PublishStatusHelperProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(PublishStatusHelperProvider.class), (PublishEditHelperProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(PublishEditHelperProvider.class), (PublishAttachmentsHelperProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(PublishAttachmentsHelperProvider.class), (OptimisticPostHelperProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(OptimisticPostHelperProvider.class), (ActionItemListControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ActionItemListControllerProvider.class), (ComposerStickerControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ComposerStickerControllerProvider.class), (ComposerLocationProductsPresenterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ComposerLocationProductsPresenterProvider.class), (ComposerHintControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ComposerHintControllerProvider.class), InlineSproutsQeWrapper.m8044a(injectorLike), (InlineSproutsControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(InlineSproutsControllerProvider.class), (LoadingPrivacyPillViewControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(LoadingPrivacyPillViewControllerProvider.class), (ImplicitLocationPillControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ImplicitLocationPillControllerProvider.class), (PagePublishOptionPillControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(PagePublishOptionPillControllerProvider.class), (TagExpansionPillViewControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(TagExpansionPillViewControllerProvider.class), (FixedPrivacyPillViewControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FixedPrivacyPillViewControllerProvider.class), (SelectablePrivacyPillViewControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(SelectablePrivacyPillViewControllerProvider.class), (SelectablePrivacyPillViewUsingBaseTokenControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(SelectablePrivacyPillViewUsingBaseTokenControllerProvider.class), (ComposerHeaderViewControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ComposerHeaderViewControllerProvider.class), (AlbumPillControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(AlbumPillControllerProvider.class), MediaItemFactory.a(injectorLike), (ComposerTopicControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ComposerTopicControllerProvider.class), (ActivityRuntimePermissionsManagerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ActivityRuntimePermissionsManagerProvider.class), (AttachmentCountByContentTypeControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(AttachmentCountByContentTypeControllerProvider.class), (LegacyFeedAttachmentAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(LegacyFeedAttachmentAdapterProvider.class), ReactionComposerManagerProviderMethodAutoProvider.a(injectorLike), IdBasedLazy.a(injectorLike, 3588), IdBasedLazy.a(injectorLike, 5303), (ComposerSubmitEnabledControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ComposerSubmitEnabledControllerProvider.class), (FooterElementsListFactoryProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FooterElementsListFactoryProvider.class), (MinutiaeAttachmentControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(MinutiaeAttachmentControllerProvider.class), (GifComposerAttachmentControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(GifComposerAttachmentControllerProvider.class), (GifComposerAttachmentProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(GifComposerAttachmentProvider.class), (FacecastComposerAttachmentControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FacecastComposerAttachmentControllerProvider.class), (ShareComposerAttachmentControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ShareComposerAttachmentControllerProvider.class), IdBasedSingletonScopeProvider.b(injectorLike, 9276), (CheckinPreviewAttachmentControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(CheckinPreviewAttachmentControllerProvider.class), IndicatorBarController.a(injectorLike), (ZeroDialogController) FbZeroDialogController.a(injectorLike), ComposerShortcutUtil.m7631a(injectorLike));
    }

    private ComposerAudienceFragment bn() {
        return (ComposerAudienceFragment) this.D.a("AUDIENCE_FRAGMENT_TAG");
    }

    public static void ce(ComposerFragment composerFragment) {
        if (composerFragment.y) {
            composerFragment.au().m7393a(composerFragment.getContext(), composerFragment.cJ);
        }
    }

    public static void m7542a(ComposerFragment composerFragment, SelectablePrivacyData selectablePrivacyData) {
        boolean z = true;
        composerFragment.dZ.a(new ComposerPrivacyData.Builder(composerFragment.aS.ag()).a(selectablePrivacyData).a(), true);
        GraphQLPrivacyOption graphQLPrivacyOption = selectablePrivacyData.d;
        composerFragment.bJ.a(Events.COMPOSER_CHANGE_PRIVACY, composerFragment.aS.ab(), composerFragment.aS.m7443s().targetId, composerFragment.aS.m7439o().getComposerType());
        if (cd(composerFragment).isEmpty()) {
            z = false;
        }
        TagExpansionExplanationType a = InlinePrivacySurveyController.m7636a(z, selectablePrivacyData.b, graphQLPrivacyOption.E_());
        if (!(composerFragment.aS.m7439o().getComposerType() == ComposerType.SHARE && composerFragment.aS.m7424a() == null)) {
            ComposerAudienceEducatorData.Builder a2 = composerFragment.aS.az().a();
            a2.c = graphQLPrivacyOption.d();
            a2 = a2;
            a2.d = a;
            composerFragment.aU.m7630b(cn).m7663a(a2.a()).m7689a();
            AudienceEducatorController au = composerFragment.au();
            au.f5999b = false;
            au.m7395b(graphQLPrivacyOption);
        }
        ((InlinePrivacySurveyController) composerFragment.aC.get()).m7642a(graphQLPrivacyOption);
        if (!composerFragment.aU.f6187f.f6756n) {
            composerFragment.bb();
        }
    }

    public static void m7546a(ComposerFragment composerFragment, boolean z, boolean z2) {
        if (((ViewGroup) composerFragment.T) != null) {
            composerFragment.aU.m7630b(cn).m7701e(true).m7689a();
            composerFragment.aU();
            composerFragment.aV();
            composerFragment.bk.c("ComposerSetupTransliterationController");
            if (composerFragment.aS.m7408I() && composerFragment.bS.f7199m != null) {
                composerFragment.aU.m7628a((ComposerEventHandler) new ComposerTransliterationController(composerFragment.dK, composerFragment.aS, composerFragment.bS.f7199m));
            }
            composerFragment.bk.d("ComposerSetupTransliterationController");
            composerFragment.aU.m7628a(composerFragment.am);
            composerFragment.am.c();
            composerFragment.aU.m7627a(ComposerEvent.ON_FIRST_DRAW, cn);
            composerFragment.au().m7395b(null);
            if (!(z || z2)) {
                composerFragment.bb();
            }
            composerFragment.aD();
            composerFragment.bk.c("ComposerMinutiaePrefetch");
            CheckinPlaceModel a = composerFragment.aS.m7431g().a();
            MinutiaeVerbsFetcher minutiaeVerbsFetcher = (MinutiaeVerbsFetcher) composerFragment.f6143b.get();
            minutiaeVerbsFetcher.a(a != null ? a.cf_() : null);
            minutiaeVerbsFetcher.q = true;
            minutiaeVerbsFetcher.a();
            composerFragment.bk.d("ComposerMinutiaePrefetch");
            if (composerFragment.aS.m7443s() != null) {
                aB(composerFragment).a(Long.valueOf(composerFragment.aS.m7443s().targetId));
            }
            if (composerFragment.aS.m7439o().getComposerType() == ComposerType.SHARE) {
                aB(composerFragment).a(composerFragment.aS.m7441q());
            }
            if (((Boolean) composerFragment.f6144c.get()).booleanValue()) {
                ((ComposerService) composerFragment.f6151i.get()).c();
            }
            composerFragment.bk.d.b(ComposerPerformanceLogger.b);
        }
    }

    public static boolean m7554a(ComposerFragment composerFragment, DependantAction dependantAction) {
        Multiset b = composerFragment.bz.b();
        for (ComposerTaskId composerTaskId : ComposerTaskId.values()) {
            if (composerTaskId.isDependencyFor(dependantAction) && b.contains(composerTaskId)) {
                return true;
            }
        }
        return false;
    }

    private AudienceEducatorController au() {
        if (this.aB == null) {
            AudienceEducatorControllerProvider audienceEducatorControllerProvider = this.aA;
            this.aB = new AudienceEducatorController(AudienceEducatorManager.a(audienceEducatorControllerProvider), FbNetworkManager.a(audienceEducatorControllerProvider), IdBasedSingletonScopeProvider.b(audienceEducatorControllerProvider, 494), IdBasedSingletonScopeProvider.b(audienceEducatorControllerProvider, 9683), IdBasedSingletonScopeProvider.b(audienceEducatorControllerProvider, 9703), IdBasedSingletonScopeProvider.b(audienceEducatorControllerProvider, 30), IdBasedProvider.a(audienceEducatorControllerProvider, 741), IdBasedProvider.a(audienceEducatorControllerProvider, 739), IdBasedProvider.a(audienceEducatorControllerProvider, 737), IdBasedProvider.a(audienceEducatorControllerProvider, 738), (QuickExperimentController) QuickExperimentControllerImpl.a(audienceEducatorControllerProvider), this.dG);
        }
        return this.aB;
    }

    private void m7548a(Tip tip) {
        if (!this.aU.f6187f.f6755m) {
            this.aU.m7630b(cn).m7699c(true).m7689a();
            this.am.a(new Tip[]{tip});
        }
    }

    public static void m7544a(ComposerFragment composerFragment, Throwable th, String str) {
        Getter getter = composerFragment.aL.P;
        Bundle bundle = getter == null ? new Bundle() : (Bundle) getter.a();
        bundle.putString("com.facebook.platform.extra.COMPOSER_ERROR", str);
        if (th != null) {
            bundle.putSerializable("com.facebook.platform.extra.COMPOSER_EXCEPTION", th);
        }
        composerFragment.ao().setResult(0, new Intent().putExtras(bundle));
        ComposerAnalyticsLogger composerAnalyticsLogger = composerFragment.bJ;
        composerAnalyticsLogger.a.a(new ComposerAnalyticsEventBuilder("composer_exit_failure").h(composerFragment.aS.ab()).i(composerAnalyticsLogger.b.p()).a);
        ((UploadManager) composerFragment.bM.get()).a(composerFragment.aS.ab());
        bX(composerFragment);
        composerFragment.ao().finish();
    }

    private void ax() {
        this.bk.a("ComposerSetupRobotextFetch");
        if (this.aS.m7439o().getPlatformConfiguration().b() && this.bi != null) {
            this.by = true;
            this.bz.a(ComposerTaskId.FETCH_ROBOTEXT, new Callable<ListenableFuture<OperationResult>>(this) {
                final /* synthetic */ ComposerFragment f6077a;

                {
                    this.f6077a = r1;
                }

                public Object call() {
                    return ((ComposerMetaTextController) Preconditions.checkNotNull(this.f6077a.bi)).m7622a(this.f6077a.aS.m7439o().getPlatformConfiguration().ogActionJsonForRobotext, this.f6077a.aS.m7439o().getPlatformConfiguration().ogActionType, this.f6077a.aS.m7424a());
                }
            }, new OperationResultFutureCallback(this) {
                final /* synthetic */ ComposerFragment f6078a;

                {
                    this.f6078a = r1;
                }

                protected final void m7486a(Object obj) {
                    OpenGraphActionRobotext openGraphActionRobotext = (OpenGraphActionRobotext) ((OperationResult) obj).h();
                    if (!(this.f6078a.aS.m7436l() == null || this.f6078a.aS.m7405F())) {
                        this.f6078a.bS.setMinutiaeUri(this.f6078a.aS.m7436l().a());
                    }
                    ((ComposerMetaTextController) Preconditions.checkNotNull(this.f6078a.bi)).m7624a(openGraphActionRobotext);
                }

                protected final void m7485a(ServiceException serviceException) {
                    ComposerFragment.m7544a(this.f6078a, (Throwable) serviceException, "Failed to generate preview for user.");
                }
            });
        }
        this.bk.b("ComposerSetupRobotextFetch");
    }

    public static void az(ComposerFragment composerFragment) {
        ((FaceBoxPrioritizer) composerFragment.bC.get()).e();
        composerFragment.bS.m8420b(AttachmentUtils.b(composerFragment.aS.m7437m()));
        composerFragment.bz.a(ComposerTaskId.ENABLE_POST_AFTER_AUTOTAGGING, new Callable<ListenableFuture<String>>(composerFragment) {
            final /* synthetic */ ComposerFragment f6084a;

            {
                this.f6084a = r1;
            }

            public Object call() {
                ComposerService composerService = (ComposerService) this.f6084a.f6151i.get();
                return composerService.a.a(new 3(composerService));
            }
        }, new AbstractDisposableFutureCallback<String>(composerFragment) {
            final /* synthetic */ ComposerFragment f6085a;

            {
                this.f6085a = r1;
            }

            protected final void m7492a(Object obj) {
                this.f6085a.aU.m7627a(ComposerEvent.ON_DATASET_CHANGE, ComposerFragment.cn);
            }

            protected final void m7493a(Throwable th) {
                this.f6085a.aU.m7627a(ComposerEvent.ON_DATASET_CHANGE, ComposerFragment.cn);
            }
        });
    }

    public final void m7598c(@Nullable Bundle bundle) {
        boolean z = true;
        super.c(bundle);
        Class cls = ComposerFragment.class;
        m7550a((Object) this, getContext());
        ComposerPerformanceLogger composerPerformanceLogger = this.bk;
        Sequence e = composerPerformanceLogger.d.e(ComposerPerformanceLogger.a);
        if (e != null) {
            SequenceLoggerDetour.a(SequenceLoggerDetour.a(SequenceLoggerDetour.b(e, "ComposerDIPhase", -1821670484), "ComposerFragmentSetup", 1365898088), "ComposerFragmentOnCreate", 2030124809);
        }
        composerPerformanceLogger.g = true;
        this.ck = false;
        if (bundle != null && bm()) {
            this.bY = false;
            ComposerAudienceFragment bn = bn();
            if (bn != null) {
                bn.a();
            }
        }
        ParseResult a = this.an.m7610a(this.s, bundle);
        this.aS = this.aR.m7449a(this.dJ);
        ComposerMutatorImplProvider composerMutatorImplProvider = this.aT;
        this.aU = new ComposerMutatorImpl((TransactionImplProvider) composerMutatorImplProvider.getOnDemandAssistedProviderForStaticDi(TransactionImplProvider.class), DefaultAndroidThreadUtil.b(composerMutatorImplProvider), a.f6154b);
        this.aM = new ComposerPluginSession(this.aS, this.dE, this.cL);
        this.aL = a.m7602a(this.aM);
        this.aU.m7628a(this.aL);
        this.cE = AttachmentCountByContentTypeControllerProvider.m7709a(this.aS);
        this.cV = this.cU.m7749a(this.aS, this.dz);
        this.aS.f6037u = this.cV;
        if (this.aL.ar() == null || !this.aL.ar().a()) {
            if (this.aS.m7439o().getInitialDateInfo() != null) {
                z = false;
            }
            Preconditions.checkArgument(z);
        } else {
            if (this.aS.m7439o().getInitialDateInfo() == null) {
                z = false;
            }
            Preconditions.checkArgument(z);
        }
        this.bH = this.cl.m8104a(this.aS, this.dy);
        this.aJ.m8230a(this.aS.ab(), this.aS.m7439o());
        aC();
        this.bK.a(this.aS.ab());
        if ((this.aS.m7439o().getSourceType() == ComposerSourceType.EXTERNAL || this.aS.m7439o().getSourceType() == ComposerSourceType.PLATFORM) && AttachmentUtils.k(this.aS.m7437m())) {
            this.bK.c(this.aS.m7437m().size());
        }
        if (bundle == null) {
            if (this.aS.m7431g().a() != null) {
                this.bJ.a(Events.COMPOSER_ADD_LOCATION, this.aS.ab());
            }
            if (!this.aS.m7432h().isEmpty()) {
                this.bJ.a(Events.COMPOSER_FRIEND_TAG, this.aS.ab());
            }
        } else {
            this.bh = false;
        }
        ComposerPerformanceLogger composerPerformanceLogger2 = this.bk;
        composerPerformanceLogger2.c.d(917512, "ComposerActionButtonPressed");
        composerPerformanceLogger2.c.d(917513, "ComposerSelectedPrivacyAvailable");
        this.bQ = System.nanoTime();
        if (this.aS.m7436l() != null) {
            this.bJ.a(Events.COMPOSER_MINUTIAE, this.aS.ab());
            m7538a(this, this.aS.m7436l());
        }
        if (this.aS.m7431g().a() != null) {
            m7557b(this, this.aS.m7431g().a());
        }
        this.ax = this.aK.m7725a(this.dF, this.dD);
        this.aU.m7628a(this.ax);
        this.bs = false;
        this.dg.a(ZeroFeatureKey.VIDEO_UPLOAD_INTERSTITIAL, b(2131232931), new Listener(this) {
            final /* synthetic */ ComposerFragment f6086a;

            {
                this.f6086a = r1;
            }

            public final void m7495a(Object obj) {
                ComposerFragment.bv(this.f6086a);
            }

            public final void m7494a() {
            }
        });
        if (bundle == null) {
            this.au.a(this.aS.ab());
            this.av.a(this.aS.ab());
        }
        this.dL.m7633a();
        this.bk.a(this.aS.ab(), this.aS.m7439o());
    }

    public static ReactionComposerManager aB(ComposerFragment composerFragment) {
        if (composerFragment.cP == null) {
            if (composerFragment.aU.f6187f.f6753k == 0) {
                Surface reactionSurface = composerFragment.aS.m7439o().getReactionSurface();
                1 1 = composerFragment.cO;
                String ab = composerFragment.aS.ab();
                boolean isEdit = composerFragment.aS.m7439o().isEdit();
                if (reactionSurface == null) {
                    reactionSurface = Surface.ANDROID_COMPOSER;
                }
                composerFragment.cP = 1.a(ab, isEdit, reactionSurface);
            } else {
                composerFragment.cP = new DefaultReactionComposerManager();
            }
        }
        return composerFragment.cP;
    }

    private void aC() {
        String str = "";
        try {
            str = this.aV.a(this.aS.m7439o());
        } catch (Throwable e) {
            ((AbstractFbErrorReporter) this.bO.get()).a("composer_entry_configuration_json_failed", e);
        }
        this.bJ.a(this.aS.ab(), this.aS.m7439o(), this.aS.m7443s().targetType, this.aS.m7443s().targetId, this.aS.m7439o().isEdit(), this.aS.m7439o().getLegacyApiStoryId(), this.cE.m7708a(), this.aS.m7427c().toString(), this.aS.m7408I(), str);
        ((CreativeEditingAnalyticsLogger) this.dc.get()).a(this.aS.ab(), this.aS.m7437m().size());
        if (!this.aS.m7437m().isEmpty()) {
            ImmutableList.Builder builder = ImmutableList.builder();
            ImmutableList m = this.aS.m7437m();
            int size = m.size();
            for (int i = 0; i < size; i++) {
                builder.c(((ComposerAttachment) m.get(i)).b().d().toString());
            }
            this.bJ.a(this.aS.ab(), builder.b(), ImmutableList.of(), AttachmentUtils.i(this.aS.m7437m()), false);
        }
        if (this.aS.m7439o().getLaunchLoggingParams().getEntryPicker() == ComposerEntryPicker.MEDIA_PICKER) {
            this.bK.g(this.aS.ab());
        }
        if (this.aS.m7439o().getSourceType() == ComposerSourceType.EXTERNAL && AttachmentUtils.i(this.aS.m7437m())) {
            this.bK.c(AttachmentUtils.g(this.aS.m7437m()));
        }
        cf();
    }

    private void aD() {
        if (this.aS.m7401B()) {
            this.bH.m8101a();
        }
    }

    private void aE() {
        if (!AttachmentUtils.e(this.aS.m7437m()).isEmpty()) {
            this.bu = 500;
            this.bu += 2500;
            ((PreFilledTagLogger) this.br.get()).b = this.aS.ab();
            this.bt = ((MonotonicClock) this.as.get()).now();
            this.bz.a(ComposerTaskId.TIMEOUT_AUTOTAGGING, new Callable<ListenableFuture<String>>(this) {
                final /* synthetic */ ComposerFragment f6081a;

                {
                    this.f6081a = r1;
                }

                public Object call() {
                    ComposerService composerService = (ComposerService) this.f6081a.f6151i.get();
                    return composerService.a.a(new 2(composerService));
                }
            }, new AbstractDisposableFutureCallback<String>(this) {
                final /* synthetic */ ComposerFragment f6082a;

                {
                    this.f6082a = r1;
                }

                protected final void m7489a(Object obj) {
                    ComposerFragment.az(this.f6082a);
                }

                protected final void m7490a(Throwable th) {
                    ComposerFragment.az(this.f6082a);
                }
            });
            this.aU.m7627a(ComposerEvent.ON_DATASET_CHANGE, cn);
        }
    }

    public final View m7595a(LayoutInflater layoutInflater, ViewGroup viewGroup, @Nullable Bundle bundle) {
        boolean z;
        boolean z2;
        boolean z3 = true;
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1552028903);
        this.bk.a("ComposerCreateViewPhase");
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(2130903739, viewGroup, false);
        this.ao.a(viewGroup2, "composer", this);
        boolean I = this.aS.m7408I();
        if (I && this.cp.f6600d.a(ExperimentsForFeedUtilComposerAbtestModule.y, false) && !ba()) {
            z = true;
        } else {
            z = false;
        }
        this.bT = new LazyView((ViewStub) FindViewUtil.b(viewGroup2, 2131560658));
        m7534a(viewGroup2);
        if (bundle != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        m7536a(viewGroup2, z2, z);
        m7555b(viewGroup2);
        aF();
        aG();
        aH();
        m7582j(viewGroup2);
        if (bundle == null) {
            z3 = false;
        }
        m7535a(viewGroup2, z3);
        m7562c(viewGroup2);
        aI();
        m7564d(viewGroup2);
        m7568e(viewGroup2);
        aJ();
        m7570f(viewGroup2);
        m7573g(viewGroup2);
        m7575h(viewGroup2);
        bk();
        aK();
        aL();
        ax();
        aN();
        aO();
        aP();
        aQ();
        m7579i(viewGroup2);
        m7556b(viewGroup2, I, z);
        aR();
        aS();
        aT();
        this.bk.b("ComposerCreateViewPhase");
        LogUtils.f(-1046060239, a);
        return viewGroup2;
    }

    private void m7534a(ViewGroup viewGroup) {
        this.bk.a("ComposerSetupScrollView");
        this.bR = (ScrollingAwareScrollView) viewGroup.findViewById(2131560652);
        this.bR.a(new OnScrollListener(this) {
            final /* synthetic */ ComposerFragment f6087a;

            {
                this.f6087a = r1;
            }

            public final void m7496a(int i, int i2) {
                this.f6087a.aU.m7627a(ComposerEvent.ON_SCROLL_CHANGED, ComposerFragment.cn);
            }
        });
        this.bk.b("ComposerSetupScrollView");
    }

    private void m7536a(ViewGroup viewGroup, final boolean z, final boolean z2) {
        boolean z3 = true;
        this.bk.a("ComposerSetupStatusView");
        this.bS = (ComposerStatusView) viewGroup.findViewById(2131560657);
        if (!this.aL.a(this.bS.f7189c)) {
            this.bS.m8416a(this.aS.m7405F());
        }
        if (this.aL.A() != null && this.aL.A().a()) {
            this.bS.setPadding(0, 0, 0, 0);
        }
        this.bS.f7206t = new AfterFirstDrawListener(this) {
            final /* synthetic */ ComposerFragment f6091c;

            /* compiled from: inviters_for_viewer_to_like */
            class C07591 implements Runnable {
                final /* synthetic */ AnonymousClass54 f6088a;

                C07591(AnonymousClass54 anonymousClass54) {
                    this.f6088a = anonymousClass54;
                }

                public void run() {
                    ComposerFragment.m7546a(this.f6088a.f6091c, z, z2);
                }
            }

            public final void mo182a() {
                ComposerPerformanceLogger composerPerformanceLogger = this.f6091c.bk;
                Sequence e = composerPerformanceLogger.d.e(ComposerPerformanceLogger.a);
                if (e != null) {
                    SequenceLoggerDetour.b(SequenceLoggerDetour.b(SequenceLoggerDetour.b(e, "ComposerRenderPhase", -746745273), "ComposerDrawPhase", -1616178058), "ComposerLaunchPhase", -2098354335);
                    composerPerformanceLogger.d.b(ComposerPerformanceLogger.a);
                    composerPerformanceLogger.g = false;
                }
                composerPerformanceLogger.e.b("OpenComposer");
                composerPerformanceLogger.d.a(ComposerPerformanceLogger.b);
                this.f6091c.bS.post(new C07591(this));
            }
        };
        this.aU.m7629a(this.bS.getEventHandlers());
        if (this.aS.m7439o().shouldDisableMentions()) {
            this.bS.m8425e();
        }
        if (!StringUtil.a(this.aS.ae().a())) {
            this.bS.setStatusText(MentionsSpannableStringBuilder.a(this.aS.ae(), jW_(), this.bq));
        }
        this.bS.setFriendTaggingEnabled(!this.aS.m7443s().a());
        if (this.aS.m7443s().targetType == TargetType.GROUP) {
            this.bS.setTaggingGroupId(this.aS.m7443s().targetId);
        }
        Getter w = this.aL.w();
        if (w != null) {
            this.bS.setMentionsTypeaheadDataSource((TagTypeaheadDataSource) w.a());
        }
        this.bS.m8409a(new SelfCensorshipTextWatcher((AnalyticsLogger) this.f6145d.get(), new ComposerSelfCensorshipTextWatcherEventBuilder("composer", this.aS.ab(), String.valueOf(this.aS.m7443s().targetId), this.bQ)));
        ComposerStatusView composerStatusView = this.bS;
        if (this.aS.ax() != Capability.ALLOW) {
            z3 = false;
        }
        composerStatusView.setIsAddMorePhotosAllowed(z3);
        this.bS.setAttachmentsViewEventListener(cb());
        this.bS.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener(this) {
            final /* synthetic */ ComposerFragment f6092a;

            {
                this.f6092a = r1;
            }

            public void onGlobalLayout() {
                this.f6092a.bJ.a(Events.COMPOSER_TEXT_READY, this.f6092a.aS.ab());
                Sequence e = this.f6092a.bk.d.e(ComposerPerformanceLogger.a);
                if (e != null) {
                    SequenceLoggerDetour.a(e, "ComposerDrawPhase", 205017871);
                }
                this.f6092a.bS.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        });
        this.bk.b("ComposerSetupStatusView");
    }

    private void m7555b(ViewGroup viewGroup) {
        this.bk.a("ComposerSetupHeaderViewController");
        if (this.aS.m7405F()) {
            this.cz = this.cy.m8367a(this.aS, (ViewStub) viewGroup.findViewById(2131560633));
            this.aU.m7628a(this.cz);
        }
        this.bk.b("ComposerSetupHeaderViewController");
    }

    private void aF() {
        this.bk.a("ComposerSetupImplicitLocationPill");
        if (this.aS.aF()) {
            ComposerMutatorImpl composerMutatorImpl = this.aU;
            ImplicitLocationPillControllerProvider implicitLocationPillControllerProvider = this.cs;
            LazyView lazyView = this.cz.f7145b.f7137n;
            ComposerDataProviderImpl composerDataProviderImpl = this.aS;
            LazyView lazyView2 = lazyView;
            composerMutatorImpl.m7628a((ComposerEventHandler) new ImplicitLocationPillController((QeAccessor) QeInternalImplMethodAutoProvider.a(implicitLocationPillControllerProvider), ComposerAnalyticsLogger.a(implicitLocationPillControllerProvider), GlyphColorizer.a(implicitLocationPillControllerProvider), ResourcesMethodAutoProvider.a(implicitLocationPillControllerProvider), lazyView2, (ProvidesIsImplicitLocationSupported) composerDataProviderImpl, this.aU));
        }
        this.bk.b("ComposerSetupImplicitLocationPill");
    }

    private void aG() {
        this.bk.a("ComposerSetupTagExpansionPill");
        if (this.aS.m7414P()) {
            ComposerMutatorImpl composerMutatorImpl = this.aU;
            TagExpansionPillViewControllerProvider tagExpansionPillViewControllerProvider = this.cu;
            ComposerDataProviderImpl composerDataProviderImpl = this.aS;
            composerMutatorImpl.m7628a((ComposerEventHandler) new TagExpansionPillViewController(GlyphColorizer.a(tagExpansionPillViewControllerProvider), ResourcesMethodAutoProvider.a(tagExpansionPillViewControllerProvider), ComposerAnalyticsLogger.a(tagExpansionPillViewControllerProvider), User_LoggedInUserMethodAutoProvider.b(tagExpansionPillViewControllerProvider), (ProvidesAttachments) composerDataProviderImpl, this.dt, this.cz.f7145b.f7135l));
        }
        this.bk.b("ComposerSetupTagExpansionPill");
    }

    private void aH() {
        this.bk.a("ComposerSetupAlbumPill");
        if (this.aS.m7446x()) {
            ComposerMutatorImpl composerMutatorImpl = this.aU;
            AlbumPillControllerProvider albumPillControllerProvider = this.cA;
            ComposerDataProviderImpl composerDataProviderImpl = this.aS;
            composerMutatorImpl.m7628a((ComposerEventHandler) new AlbumPillController(ResourcesMethodAutoProvider.a(albumPillControllerProvider), GlyphColorizer.a(albumPillControllerProvider), composerDataProviderImpl, this.cI, this.cz.f7145b.f7139p));
        }
        this.bk.b("ComposerSetupAlbumPill");
    }

    private void m7535a(ViewGroup viewGroup, boolean z) {
        this.bk.a("ComposerSetupTipManager");
        this.am = this.al.a(viewGroup, null, this.aS, this.dh, this.dH, this.cN);
        if (this.aS.m7431g().a() != null && this.aS.m7432h().isEmpty() && !z) {
            this.am.a(new Tip[]{Tip.TAG_PEOPLE_FOR_CHECKIN});
        } else if (this.aS.m7431g().a() == null && !this.aS.m7437m().isEmpty()) {
            m7548a(Tip.TAG_PLACE_AFTER_PHOTO);
        } else if (this.aS.m7403D()) {
            this.am.a(new Tip[]{Tip.FACECAST_ICON_NUX});
            this.am.a(new Tip[]{Tip.LIVE_TOPIC_COMPOSER_NUX});
        }
        this.bk.b("ComposerSetupTipManager");
    }

    private void m7562c(ViewGroup viewGroup) {
        this.bk.a("ComposerSetupRedSpaceViews");
        this.aU.m7628a(this.bd.m7734a((ViewStub) viewGroup.findViewById(2131560650), this.aS));
        if (this.aS.ay()) {
            this.aU.m7628a(ComposerRedSpaceControllerProvider.m7731a((ViewStub) viewGroup.findViewById(2131560663), this.aU, this.aS));
        }
        this.bk.b("ComposerSetupRedSpaceViews");
    }

    private void aI() {
        this.bk.a("ComposerSetupPostComposition");
        this.bU = new LazyView((ViewStub) FindViewUtil.b(this.cS, 2131560488), new OnInflateRunner<PostCompositionView>(this) {
            final /* synthetic */ ComposerFragment f6094a;

            /* compiled from: inviters_for_viewer_to_like */
            class C07601 implements OnHideListener {
                final /* synthetic */ AnonymousClass56 f6093a;

                C07601(AnonymousClass56 anonymousClass56) {
                    this.f6093a = anonymousClass56;
                }

                public final void mo183a() {
                    this.f6093a.f6094a.bJ.a(Events.COMPOSER_POST_COMPOSITION_CANCEL, this.f6093a.f6094a.aS.ab());
                    this.f6093a.f6094a.aU.m7630b(ComposerFragment.cn).m7696b(false).m7689a();
                    this.f6093a.f6094a.bS.m8417b();
                    ComposerFragment.bo(this.f6093a.f6094a);
                }
            }

            {
                this.f6094a = r1;
            }

            public final void m7501a(View view) {
                ((PostCompositionView) view).f6216c = new C07601(this);
            }
        });
        this.bk.b("ComposerSetupPostComposition");
    }

    private void m7564d(ViewGroup viewGroup) {
        this.bk.a("ComposerSetupPrivacyViews");
        if (this.aS.m7413O()) {
            ComposerMutatorImpl composerMutatorImpl = this.aU;
            LoadingPrivacyPillViewControllerProvider loadingPrivacyPillViewControllerProvider = this.cr;
            composerMutatorImpl.m7628a((ComposerEventHandler) new LoadingPrivacyPillViewController(ResourcesMethodAutoProvider.a(loadingPrivacyPillViewControllerProvider), this.aS, this.cz.f7145b.f7133j));
            if (!this.aS.m7414P()) {
                boolean z;
                ComposerDataProviderImpl composerDataProviderImpl = this.aS;
                ComposerHeaderCapability composerHeaderCapability = (ComposerHeaderCapability) composerDataProviderImpl.f6031o.get();
                if (composerHeaderCapability.b(composerDataProviderImpl.f6035s.m7482b().S) && ((QeAccessor) composerHeaderCapability.a.get()).a(ExperimentsForFeedUtilComposerAbtestModule.F, false)) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    this.aU.m7628a(this.cx.m8222a(getContext(), this.aS, this.cz.f7145b.f7134k, this.cH));
                    this.aU.m7628a(this.cv.m8206a(this.aS, this.cz.f7145b.f7136m));
                }
            }
            this.aU.m7628a(this.cw.m8217a(this.aS, this.cz.f7145b.f7134k, this.cH));
            this.aU.m7628a(this.cv.m8206a(this.aS, this.cz.f7145b.f7136m));
        } else {
            this.bv = ((ViewStub) viewGroup.findViewById(2131560654)).inflate();
            this.bw = new LazyView((ViewStub) viewGroup.findViewById(2131560605), new OnInflateRunner(this) {
                final /* synthetic */ ComposerFragment f6096a;

                /* compiled from: inviters_for_viewer_to_like */
                class C07611 implements OnClickListener {
                    final /* synthetic */ AnonymousClass57 f6095a;

                    C07611(AnonymousClass57 anonymousClass57) {
                        this.f6095a = anonymousClass57;
                    }

                    public void onClick(View view) {
                        int a = Logger.a(2, EntryType.UI_INPUT_START, 2047820481);
                        ((NavigationLogger) this.f6095a.f6096a.ap.get()).a("tap_composer_privacy");
                        ComposerFragment.bd(this.f6095a.f6096a);
                        Logger.a(2, EntryType.UI_INPUT_END, 1949069862, a);
                    }
                }

                {
                    this.f6096a = r1;
                }

                public final void m7502a(View view) {
                    view.setOnClickListener(new C07611(this));
                }
            });
            this.bx = new LazyView((ViewStub) viewGroup.findViewById(2131560606));
            be(this);
        }
        this.bk.b("ComposerSetupPrivacyViews");
    }

    private void m7568e(ViewGroup viewGroup) {
        this.bk.a("ComposerSetupStickersView");
        new ComposerStickerController(this.aS.ab(), s(), this.f6148f, FbDraweeControllerBuilder.b(this.cj)).a(this.aS.m7442r(), (ViewStub) viewGroup.findViewById(2131560655));
        this.bk.b("ComposerSetupStickersView");
    }

    private void m7570f(ViewGroup viewGroup) {
        this.bk.a("ComposerSetupFeedOnlyPostController");
        ComposerMutatorImpl composerMutatorImpl = this.aU;
        ComposerFeedOnlyPostControllerProvider composerFeedOnlyPostControllerProvider = this.be;
        ViewStub viewStub = (ViewStub) viewGroup.findViewById(2131560653);
        ComposerMutatorImpl composerMutatorImpl2 = this.aU;
        ViewStub viewStub2 = viewStub;
        ComposerMutatorImpl composerMutatorImpl3 = composerMutatorImpl2;
        composerMutatorImpl.m7628a((ComposerEventHandler) new ComposerFeedOnlyPostController((Context) composerFeedOnlyPostControllerProvider.getInstance(Context.class), (QeAccessor) QeInternalImplMethodAutoProvider.a(composerFeedOnlyPostControllerProvider), viewStub2, composerMutatorImpl3, this.aS));
        this.bk.b("ComposerSetupFeedOnlyPostController");
    }

    private void aJ() {
        this.bk.a("ComposerSetupDynamicTextStyleController");
        this.aU.m7628a(this.bS.m8406a(this.aS));
        this.bk.b("ComposerSetupDynamicTextStyleController");
    }

    private void m7573g(ViewGroup viewGroup) {
        this.bk.a("ComposerSetupTitle");
        this.aU.m7628a(this.ba.m7717a((ViewStub) viewGroup.findViewById(2131560528), this.aS, this.ay.m8281a(this.dM, this.aS), this.dO));
        this.bk.b("ComposerSetupTitle");
    }

    private void m7575h(ViewGroup viewGroup) {
        this.bk.a("ComposerSetupTitleIndicatorBars");
        ViewStub viewStub = (ViewStub) viewGroup.findViewById(2131561006);
        this.df.f = (ViewStub) viewGroup.findViewById(2131568572);
        this.df.b(viewStub);
        this.bk.b("ComposerSetupTitleIndicatorBars");
    }

    private void aK() {
        this.bk.a("ComposerSetupMetaTextController");
        this.bi = new ComposerMetaTextController(getContext(), this.aq, this.ar, new Object(this) {
            public final /* synthetic */ ComposerFragment f6097a;

            {
                this.f6097a = r1;
            }

            public final void m7503a() {
                ComposerFragment.bJ(this.f6097a);
            }

            public final void m7504a(SpannedString spannedString, boolean z) {
                this.f6097a.aU.m7630b(ComposerFragment.cn).m7662a(spannedString).m7689a();
                if (!this.f6097a.aS.m7405F()) {
                    this.f6097a.bS.m8408a(spannedString, z);
                }
            }
        });
        this.bk.b("ComposerSetupMetaTextController");
    }

    private void aL() {
        this.bk.a("ComposerSetupSellStatusView");
        aM();
        this.bk.b("ComposerSetupSellStatusView");
    }

    private void aM() {
        if (this.aS.m7439o().getComposerType() == ComposerType.SELL) {
            boolean z;
            boolean z2;
            if (this.aS.m7433i() != null) {
                ProductItemAttachment i = this.aS.m7433i();
                this.bS.setTitleText(i.title);
                this.bS.setPickupDeliveryText(i.pickupDeliveryInfo);
                this.bS.setStructuredLocationText(i.pickupDeliveryInfo);
                if (i.price != null) {
                    this.bS.m8415a(i.price.toString(), i.currencyCode);
                }
                if (!(i.description == null || i.description.isEmpty())) {
                    this.bS.setDescriptionText(MentionsSpannableStringBuilder.a(i.description, jW_(), this.bq, null));
                }
            }
            ProductItemLocationPickerSettings productItemLocationPickerSettings = this.aS.m7439o().getCommerceInfo().getProductItemLocationPickerSettings();
            boolean z3 = productItemLocationPickerSettings != null && productItemLocationPickerSettings.getUseZipCode();
            if (z3 || this.aS.m7433i() != null) {
                z = false;
            } else {
                z = true;
            }
            MarketplaceCrossPostSettingModel marketplaceCrossPostSettingModel = this.aS.m7439o().getCommerceInfo().getMarketplaceCrossPostSettingModel();
            if (marketplaceCrossPostSettingModel != null && marketplaceCrossPostSettingModel.a().booleanValue() && this.aS.m7433i() == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.aY = this.aZ.m7739a(this.dI, this.aS, Boolean.valueOf(z), Boolean.valueOf(z3), Boolean.valueOf(z2), this.aS.m7443s().targetId);
            this.bH.f6682m = true;
            aY();
        }
    }

    private void aN() {
        this.bk.a("ComposerSetupPlace");
        if (this.aS.m7431g().a() != null) {
            final CheckinPlaceModel a = this.aS.m7431g().a();
            if (a.j() != null) {
                bW(this);
            } else {
                ComposerService composerService = (ComposerService) this.f6151i.get();
                this.bz.a(ComposerTaskId.FETCH_PAGE_INFO, ((GraphQLQueryExecutor) composerService.c.get()).a(GraphQLRequest.a((FetchPlaceLocationQueryString) FetchPlaceLocationGraphQL.a().a("page_id", Long.valueOf(Long.parseLong(a.cf_()))))), new AbstractDisposableFutureCallback<GraphQLResult<FetchPlaceLocationQueryModel>>(this) {
                    final /* synthetic */ ComposerFragment f6080b;

                    protected final void m7487a(Object obj) {
                        GraphQLResult graphQLResult = (GraphQLResult) obj;
                        if (graphQLResult.e == null || ((FetchPlaceLocationQueryModel) graphQLResult.e).k() == null) {
                            ComposerFragment.m7544a(this.f6080b, null, "Failed to get place name.");
                            return;
                        }
                        TransactionImpl b = this.f6080b.aU.m7630b(ComposerFragment.cn);
                        ComposerLocationInfo.Builder a = ComposerLocationInfo.a(this.f6080b.aS.m7431g());
                        CheckinPlaceModel.Builder builder = new CheckinPlaceModel.Builder();
                        builder.f = a.cf_();
                        CheckinPlaceModel.Builder builder2 = builder;
                        builder2.h = ((FetchPlaceLocationQueryModel) graphQLResult.e).l();
                        builder2 = builder2;
                        LocationModel.Builder builder3 = new LocationModel.Builder();
                        builder3.a = ((FetchPlaceLocationQueryModel) graphQLResult.e).k().a();
                        builder3 = builder3;
                        builder3.b = ((FetchPlaceLocationQueryModel) graphQLResult.e).k().b();
                        builder2.g = builder3.a();
                        b.m7692b(a.a(builder2.a()).b()).m7689a();
                        ComposerFragment.m7557b(this.f6080b, this.f6080b.aS.m7431g().a());
                        ComposerFragment.bW(this.f6080b);
                    }

                    protected final void m7488a(Throwable th) {
                        if (this.f6080b.aS.m7439o().getPlatformConfiguration().dataFailuresFatal) {
                            ComposerFragment.m7544a(this.f6080b, th, "Failed to get place name.");
                        }
                    }
                });
            }
        }
        if (this.aS.m7431g().c() != null) {
            bW(this);
        }
        this.bk.b("ComposerSetupPlace");
    }

    private void aO() {
        this.bk.a("ComposerSetupTagging");
        Object obj = !this.aS.m7432h().isEmpty() ? 1 : null;
        if (!(this.aS.m7436l() == null && obj == null)) {
            bi(this);
            if (obj != null) {
                bj(this);
            }
        }
        this.bk.b("ComposerSetupTagging");
    }

    private void aP() {
        this.bk.a("ComposerSetupHintController");
        this.aU.m7628a(this.cm.m7721a(this.aS, this.cM));
        this.bk.b("ComposerSetupHintController");
    }

    private void aQ() {
        this.bk.a("ComposerSetupAttachments");
        if (this.aS.m7437m() != null && this.aS.m7437m().size() > 0) {
            PhotoSequences photoSequences = (PhotoSequences) this.aH.get();
            String ab = this.aS.ab();
            photoSequences.b.a(PhotoSequences.a, ab, null, photoSequences.c.now());
            ((PhotoSequences) this.aH.get()).b(this.aS.ab(), ((ComposerAttachment) this.aS.m7437m().get(0)).b().c());
        }
        m7576h(false);
        m7580i(false);
        this.bk.b("ComposerSetupAttachments");
    }

    private void m7579i(ViewGroup viewGroup) {
        this.bk.a("ComposerSetupPluginViews");
        ViewStub viewStub = this.bS.f7188b;
        this.aL.b((ViewStub) FindViewUtil.b(viewGroup, 2131560659));
        this.bk.b("ComposerSetupPluginViews");
    }

    private void aR() {
        this.bk.a("ComposerSetupProfilePicture");
        ch();
        this.bk.b("ComposerSetupProfilePicture");
    }

    private void aS() {
        ViewStub viewStub;
        this.bk.a("ComposerSetupTopics");
        if (this.cz == null || this.cz.f7145b == null) {
            viewStub = this.bS.f7198l;
        } else {
            viewStub = this.cz.f7145b.f7141r;
        }
        this.aU.m7628a(this.cC.a(viewStub, this.aS, this, 15, this.am, this.aU));
        this.bk.b("ComposerSetupTopics");
    }

    private void aT() {
        this.bk.a("ComposerSetupPublishModePill");
        if (this.aS.m7411L()) {
            PagePublishOptionPillControllerProvider pagePublishOptionPillControllerProvider = this.ct;
            ComposerDataProviderImpl composerDataProviderImpl = this.aS;
            LazyView lazyView = this.cz.f7145b.f7138o;
            this.aU.m7628a(new PagePublishOptionPillController(composerDataProviderImpl, lazyView, this.dY, ResourcesMethodAutoProvider.a(pagePublishOptionPillControllerProvider), (QeAccessor) QeInternalImplMethodAutoProvider.a(pagePublishOptionPillControllerProvider), PublishModeTitleGenerator.b(pagePublishOptionPillControllerProvider), GlyphColorizer.a(pagePublishOptionPillControllerProvider)));
        }
        this.bk.b("ComposerSetupPublishModePill");
    }

    private void aU() {
        this.bk.c("ComposerSetupRidgeController");
        RidgeComposerControllerProvider ridgeComposerControllerProvider = this.bF;
        this.bG = new RidgeComposerController((ProvidesSessionId) this.aS, IdBasedProvider.a(ridgeComposerControllerProvider, 637), RidgeOptInController.b(ridgeComposerControllerProvider), AudioFingerprintingSession.b(ridgeComposerControllerProvider), AudioFingerprintingSuggestionsCache.a(ridgeComposerControllerProvider), RidgeAnalyticsLogger.a(ridgeComposerControllerProvider), MusicMetadataHelper.b(ridgeComposerControllerProvider));
        a(this.bG);
        this.bG.f6342h = this.dx;
        this.bG.d(this);
        this.bk.d("ComposerSetupRidgeController");
    }

    private void aV() {
        this.bk.c("ComposerSetupFooterBar");
        if (!this.aS.m7408I()) {
            this.aU.m7629a(this.cW.m8350a(this.am, this.dl, this.dk, this.dm, this.dn, this.f6146do, this.dp, this.f6147e, this.f6149g, this.dj, (ViewGroup) F(), this.dq, this.aS).m8349a());
        }
        this.bk.d("ComposerSetupFooterBar");
    }

    public final void m7599d(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1592286114);
        super.d(bundle);
        Throwable th = this.an.f6168m;
        if (th != null) {
            m7544a(this, th, "Failed to parse composer saved session");
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -700176850, a);
    }

    private void aY() {
        boolean z = false;
        this.bS.setOnCategoryClickedListener(new OnClickListener(this) {
            final /* synthetic */ ComposerFragment f6098a;

            {
                this.f6098a = r1;
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1408132015);
                ComposerFragment composerFragment = this.f6098a;
                Intent intent = new Intent(composerFragment.ao(), SelectCategoryActivity.class);
                intent.putParcelableArrayListExtra("categories", Lists.a(composerFragment.aS.m7439o().getGroupCommerceCategories()));
                composerFragment.a(intent, 9);
                Logger.a(2, EntryType.UI_INPUT_END, -671853135, a);
            }
        });
        this.bS.setOnLocationClickedListener(new OnClickListener(this) {
            final /* synthetic */ ComposerFragment f6100a;

            {
                this.f6100a = r1;
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1232076668);
                ComposerFragment.bP(this.f6100a);
                Logger.a(2, EntryType.UI_INPUT_END, -449065167, a);
            }
        });
        MarketplaceCrossPostSettingModel marketplaceCrossPostSettingModel = this.aS.m7439o().getCommerceInfo().getMarketplaceCrossPostSettingModel();
        ComposerStatusView composerStatusView = this.bS;
        ComposerCommerceInfo commerceInfo = this.aS.m7439o().getCommerceInfo();
        ImmutableList groupCommerceCategories = this.aS.m7439o().getGroupCommerceCategories();
        boolean isEdit = this.aS.m7439o().isEdit();
        String valueOf = String.valueOf(this.aS.m7443s().targetId);
        boolean z2 = false;
        ComposerSellView composerSellView = (ComposerSellView) composerStatusView.f7191e.a();
        composerSellView.setVisibility(0);
        if (composerStatusView.f7193g != null) {
            composerStatusView.f7193g.setVisibility(8);
        }
        composerSellView.setCurrencyCode(commerceInfo.getCurrencyCode());
        composerSellView.setCategories(groupCommerceCategories);
        composerSellView.m8386a(commerceInfo.getIsCategoryOptional(), commerceInfo.getPrefillCategoryId());
        ProductItemLocationPickerSettings productItemLocationPickerSettings = commerceInfo.getProductItemLocationPickerSettings();
        boolean useZipCode = productItemLocationPickerSettings != null ? productItemLocationPickerSettings.getUseZipCode() : false;
        if (productItemLocationPickerSettings != null) {
            z2 = productItemLocationPickerSettings.getIsCompulsory();
        }
        composerSellView.m8387a(useZipCode, z2);
        if (!isEdit) {
            MarketplaceCrossPostSettingModel marketplaceCrossPostSettingModel2 = commerceInfo.getMarketplaceCrossPostSettingModel();
            if (marketplaceCrossPostSettingModel2 != null) {
                composerSellView.m8384a(marketplaceCrossPostSettingModel2, valueOf);
            }
        }
        composerSellView.m8390c();
        this.bS.m8418b(this.cR);
        boolean z3 = this.aS.m7443s().targetType == TargetType.MARKETPLACE;
        if (!z3) {
            z = this.aS.m7439o().shouldPostToMarketplaceByDefault();
        }
        this.bS.setIsPostToMarketplaceChecked(z);
        if (z3) {
            this.bS.m8429i();
        }
        if (marketplaceCrossPostSettingModel != null && marketplaceCrossPostSettingModel.c().booleanValue()) {
            m7537a(this, this.aY.f6314j);
        }
        this.bS.setOnPostToMarketplaceCheckedChangeListener(new OnCheckedChangeListener(this) {
            final /* synthetic */ ComposerFragment f6101a;

            {
                this.f6101a = r1;
            }

            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                long j;
                if (z) {
                    j = this.f6101a.aY.f6314j;
                } else {
                    j = 0;
                }
                ComposerFragment.m7537a(this.f6101a, j);
            }
        });
    }

    public final void m7597a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        if (!this.aS.m7437m().isEmpty()) {
            Object obj;
            if (((FaceBoxPrioritizer) this.bC.get()).l) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                aE();
            }
        }
        if (this.aL.O != null && !this.aL.O.a()) {
            this.bS.setShowCaption(false);
        }
    }

    private void m7582j(ViewGroup viewGroup) {
        this.bk.a("ComposerSetupUnderwood");
        if (this.aL.N == null || this.aL.N.a()) {
            this.bS.m8412a(this.bR, viewGroup, this.bh, this.aS.m7408I(), this.f6150h, this.aS);
            if (!this.aU.f6187f.f6745c.m8150b().isEmpty()) {
                this.bS.setRemovedEditingLoggingParameters(this.aU.f6187f.f6745c.m8150b());
            }
            UnderwoodLogger underwoodLogger = (UnderwoodLogger) this.cT.get();
            String str = this.bK.j;
            Preconditions.checkArgument(!StringUtil.a(str));
            underwoodLogger.a.a(str);
        }
        this.bk.b("ComposerSetupUnderwood");
    }

    private void aZ() {
        ao().getWindow().setSoftInputMode(18);
        this.bS.m8424d();
        this.bS.clearFocus();
    }

    private boolean ba() {
        if (this.aL.x != null && this.aL.x.a()) {
            return true;
        }
        if (!this.aS.m7437m().isEmpty()) {
            return true;
        }
        if (GifUtil.a(this.aS.m7441q())) {
            return true;
        }
        if (this.aS.m7439o().getInitialStickerData() != null) {
            return true;
        }
        ComposerScreenSizeUtil composerScreenSizeUtil = (ComposerScreenSizeUtil) this.aG.get();
        return (composerScreenSizeUtil.a.getDisplayMetrics().heightPixels < composerScreenSizeUtil.a.getDimensionPixelSize(2131429622) ? 1 : null) != null && this.aS.m7439o().shouldHideKeyboardIfReachedMinimumHeight();
    }

    private void bb() {
        if (this.aS.m7427c() != ComposerContentType.SHARE_ATTACHMENT || !this.bA.a(ExperimentsForComposerAbTestModule.q, false)) {
            if (!this.aU.f6187f.f6756n) {
                this.bS.m8417b();
            }
            if (ba() || this.am.d()) {
                aZ();
            } else if (this.aS.m7401B()) {
                bo(this);
            }
        }
    }

    public static void bd(ComposerFragment composerFragment) {
        if (composerFragment.aS.ag() == null || composerFragment.aS.ag().d) {
            composerFragment.bY = true;
        } else if (!composerFragment.bm()) {
            ((AudienceSelectorPerformanceLogger) composerFragment.bm.get()).a(Caller.COMPOSER_FRAGMENT);
            ComposerAudienceFragment composerAudienceFragment = new ComposerAudienceFragment();
            composerAudienceFragment.a(composerFragment.du);
            composerAudienceFragment.a(composerFragment.D, "AUDIENCE_FRAGMENT_TAG");
        }
    }

    public static void be(ComposerFragment composerFragment) {
        if (!composerFragment.aS.m7413O()) {
            if (composerFragment.bw != null && composerFragment.bw.b() && composerFragment.aS.ag() != null && composerFragment.aS.ag().b != null && composerFragment.aS.ag().b.a != null) {
                ((SelectablePrivacyView) composerFragment.bw.a()).a(cc(composerFragment), composerFragment.aS.ag());
            } else if (composerFragment.bx != null && composerFragment.bx.b() && composerFragment.aS.ag() != null && composerFragment.aS.ag().a != null) {
                FixedPrivacyView fixedPrivacyView = (FixedPrivacyView) composerFragment.bx.a();
                cc(composerFragment);
                fixedPrivacyView.a(composerFragment.aS.ag().a, composerFragment.aS.ad());
            }
        }
    }

    public static void bf(ComposerFragment composerFragment) {
        boolean z;
        boolean z2 = true;
        ProductItemLocationPickerSettings productItemLocationPickerSettings = composerFragment.aS.m7439o().getCommerceInfo().getProductItemLocationPickerSettings();
        boolean z3 = productItemLocationPickerSettings != null && productItemLocationPickerSettings.getUseZipCode();
        if (productItemLocationPickerSettings == null || !productItemLocationPickerSettings.getIsCompulsory()) {
            z = false;
        } else {
            z = true;
        }
        ProductItemAttachment.Builder builder = new ProductItemAttachment.Builder();
        builder.a = composerFragment.bS.getTitleText().toString();
        builder = builder;
        builder.d = composerFragment.bS.getDescriptionText().toString();
        ProductItemAttachment.Builder builder2 = builder;
        builder2.e = (Long) composerFragment.bS.getPrice().orNull();
        builder = builder2;
        builder.f = composerFragment.aS.m7439o().getCommerceInfo().getCurrencyCode();
        builder = builder;
        builder.g = composerFragment.bS.getCategoryID();
        builder = builder;
        if (!composerFragment.bS.m8428h() || composerFragment.aS.m7439o().getCommerceInfo().getIsCategoryOptional()) {
            z2 = false;
        }
        builder.h = z2;
        builder = builder;
        builder.i = z3;
        builder = builder;
        builder.j = z;
        ProductItemAttachment.Builder builder3 = builder;
        if (z3) {
            builder3.b = composerFragment.bS.getPickupDeliveryText().toString();
        } else {
            ProductItemPlace productItemPlace = composerFragment.aY.f6313i;
            String charSequence = composerFragment.bS.getStructuredLocationText() == null ? null : composerFragment.bS.getStructuredLocationText().toString();
            if (productItemPlace != null) {
                charSequence = productItemPlace.name;
            }
            builder3.c = productItemPlace;
            builder3.b = charSequence;
        }
        composerFragment.aU.m7630b(cn).m7677a(builder3.a()).m7689a();
    }

    public static void m7537a(ComposerFragment composerFragment, long j) {
        composerFragment.aU.m7630b(cn).m7661a(j).m7689a();
    }

    public static void m7545a(ComposerFragment composerFragment, boolean z) {
        composerFragment.am.a(true);
        composerFragment.aU.m7630b(cn).m7696b(true).m7689a();
        composerFragment.aZ();
        composerFragment.bS.clearFocus();
        if (composerFragment.ci == null) {
            ActionItemListControllerProvider actionItemListControllerProvider = composerFragment.ch;
            ComposerDataProviderImpl composerDataProviderImpl = composerFragment.aS;
            composerFragment.ci = new ActionItemListController(composerDataProviderImpl, composerFragment.dY, (PublishModeActionItemControllerProvider) actionItemListControllerProvider.getOnDemandAssistedProviderForStaticDi(PublishModeActionItemControllerProvider.class), (Context) actionItemListControllerProvider.getInstance(Context.class), ComposerAnalyticsLogger.a(actionItemListControllerProvider));
            composerFragment.aU.m7628a(composerFragment.ci);
        }
        ((PostCompositionView) composerFragment.bU.a()).bringToFront();
        ((PostCompositionView) composerFragment.bU.a()).m7657a(composerFragment.ci, z);
        ce(composerFragment);
    }

    private void m7556b(final ViewGroup viewGroup, boolean z, boolean z2) {
        this.bk.a("ComposerSetupInlineSprouts");
        if (z) {
            final LazyView lazyView = new LazyView((ViewStub) FindViewUtil.b(this.cS, 2131560489));
            this.co = this.cq.m8043a(new OnClickListener(this) {
                final /* synthetic */ ComposerFragment f6117a;

                {
                    this.f6117a = r1;
                }

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 293585702);
                    ComposerFragment.m7559b(this.f6117a, true);
                    Logger.a(2, EntryType.UI_INPUT_END, -1927026677, a);
                }
            }, (InlineSproutsView) lazyView.a(), new OnMeasuredListener(this) {
                final /* synthetic */ ComposerFragment f6120c;

                public final void mo185a() {
                    viewGroup.setPadding(viewGroup.getPaddingLeft(), viewGroup.getPaddingTop(), viewGroup.getPaddingRight(), ((InlineSproutsView) lazyView.a()).getCollapsedMeasuredHeight());
                }
            }, this.aS, this.aU, this.dR, this.dU, this.dS, this.dV, this.dW, this.dP, this.dQ);
            this.aU.m7628a(this.co);
            if (z2) {
                m7559b(this, false);
            }
        }
        this.bk.b("ComposerSetupInlineSprouts");
    }

    public static void m7559b(ComposerFragment composerFragment, boolean z) {
        composerFragment.am.a(true);
        composerFragment.bS.clearFocus();
        composerFragment.aZ();
        InlineSproutsController inlineSproutsController = composerFragment.co;
        inlineSproutsController.f6563A = true;
        if (z) {
            ExpandAnimation expandAnimation;
            if (inlineSproutsController.f6580l.f) {
                expandAnimation = ExpandAnimation.FROM_TOP;
            } else {
                expandAnimation = ExpandAnimation.FROM_BOTTOM;
            }
            inlineSproutsController.f6565C = expandAnimation;
        } else {
            inlineSproutsController.f6565C = ExpandAnimation.NO_ANIMATION;
        }
        if (inlineSproutsController.f6565C != ExpandAnimation.FROM_TOP) {
            InlineSproutsController.m8028a(inlineSproutsController, inlineSproutsController.f6565C);
        }
    }

    public static void bg(ComposerFragment composerFragment) {
        composerFragment.co.m8041a();
    }

    public static void m7543a(ComposerFragment composerFragment, ImmutableList immutableList, boolean z, boolean z2) {
        composerFragment.aU.m7630b(cn).m7694b(immutableList).m7668a(composerFragment.aS.m7425a(immutableList) ? composerFragment.aS.ad() : null).m7689a();
        if (z) {
            composerFragment.aD();
            composerFragment.m7576h(z2);
        }
        be(composerFragment);
    }

    private ImmutableList<ComposerAttachment> m7532a(ImmutableList<ComposerAttachment> immutableList) {
        Preconditions.checkNotNull(immutableList);
        ImmutableList.Builder builder = ImmutableList.builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            ComposerAttachment composerAttachment;
            ComposerAttachment composerAttachment2 = (ComposerAttachment) immutableList.get(i);
            ImmutableList m = this.aS.m7437m();
            int size2 = m.size();
            for (int i2 = 0; i2 < size2; i2++) {
                composerAttachment = (ComposerAttachment) m.get(i2);
                if (composerAttachment2.b().equals(composerAttachment.b())) {
                    break;
                }
            }
            composerAttachment = composerAttachment2;
            builder.c(composerAttachment);
        }
        return builder.b();
    }

    private void m7576h(boolean z) {
        this.bS.m8414a(this.aS.m7437m(), z);
        if (this.aS.m7415Q()) {
            m7558b(this, AttachmentUtils.e(this.aS.m7437m()));
        }
        if (!this.aS.m7415Q()) {
            ((UploadManager) this.bM.get()).a(AttachmentUtils.e(this.aS.m7437m()), this.aS.ab(), this.aS.m7443s().a() ? ((ComposerPageData) Preconditions.checkNotNull(this.aS.m7440p())).getPostAsPageViewerContext() : null, this.aS.m7443s().targetId);
        }
        m7552a(AttachmentUtils.e(this.aS.m7437m()));
    }

    private void bh() {
        ((FaceBoxPrioritizer) this.bC.get()).d();
        m7552a(AttachmentUtils.e(this.aS.m7437m()));
        this.bS.m8423c(AttachmentUtils.b(this.aS.m7437m()));
    }

    private void m7552a(final List<MediaItem> list) {
        if (!list.isEmpty()) {
            List<LocalFaceRecImageData> arrayList = new ArrayList();
            for (MediaItem mediaItem : list) {
                if (mediaItem instanceof PhotoItem) {
                    PhotoItem photoItem = (PhotoItem) mediaItem;
                    LocalPhoto localPhoto = photoItem.f;
                    if (!localPhoto.f || !this.av.c(localPhoto) || !this.av.d(localPhoto)) {
                        arrayList.add(new LocalFaceRecImageData(photoItem, this.au, this.av));
                    }
                }
            }
            ((FaceBoxPrioritizer) this.bC.get()).j = new FaceBoxPrioritizerListener(this) {
                final /* synthetic */ ComposerFragment f6122b;

                public final void m7521a(LocalFaceRecImageData localFaceRecImageData) {
                    Object obj;
                    this.f6122b.aU.m7627a(ComposerEvent.ON_FACE_DETECTION_COMPLETE, ComposerFragment.cn);
                    this.f6122b.bS.m8413a(AttachmentUtils.b(this.f6122b.aS.m7437m()));
                    ComposerFragment composerFragment = this.f6122b;
                    for (MediaItem mediaItem : list) {
                        if (mediaItem instanceof PhotoItem) {
                            if (!composerFragment.av.c(((PhotoItem) mediaItem).f)) {
                                obj = null;
                                break;
                            }
                        }
                    }
                    obj = 1;
                    if (obj != null) {
                        Class cls = ComposerFragment.aW;
                        ((UploadManager) this.f6122b.bM.get()).a(AttachmentUtils.e(this.f6122b.aS.m7437m()), this.f6122b.aS.ab(), this.f6122b.aS.m7443s().a() ? ((ComposerPageData) Preconditions.checkNotNull(this.f6122b.aS.m7440p())).getPostAsPageViewerContext() : null, this.f6122b.aS.m7443s().targetId);
                    }
                }

                public final void m7522b(LocalFaceRecImageData localFaceRecImageData) {
                    if (this.f6122b.aS.m7415Q() && !localFaceRecImageData.e().isEmpty()) {
                        ((AutoTaggingHelper) this.f6122b.aD.get()).a(this.f6122b.ao().getApplicationContext(), localFaceRecImageData, AttachmentUtils.b(this.f6122b.aS.m7437m()));
                        ComposerFragment.m7558b(this.f6122b, AttachmentUtils.e(this.f6122b.aS.m7437m()));
                        this.f6122b.bS.m8420b(AttachmentUtils.b(this.f6122b.aS.m7437m()));
                        ComposerFragment.bi(this.f6122b);
                        ComposerFragment.bj(this.f6122b);
                    }
                }
            };
            if (arrayList.isEmpty()) {
                ((UploadManager) this.bM.get()).a(AttachmentUtils.e(this.aS.m7437m()), this.aS.ab(), this.aS.m7443s().a() ? ((ComposerPageData) Preconditions.checkNotNull(this.aS.m7440p())).getPostAsPageViewerContext() : null, this.aS.m7443s().targetId);
                return;
            }
            ((FaceBoxPrioritizer) this.bC.get()).a(arrayList);
            ComposerAttachmentsAutoTaggingController composerAttachmentsAutoTaggingController = this.bD;
            Preconditions.checkNotNull(arrayList);
            composerAttachmentsAutoTaggingController.b = Lists.a();
            for (LocalFaceRecImageData localFaceRecImageData : arrayList) {
                composerAttachmentsAutoTaggingController.b.add(localFaceRecImageData.a);
            }
        }
    }

    public static void m7558b(ComposerFragment composerFragment, ImmutableList immutableList) {
        ImmutableList a = ((PhotoTagExtractor) composerFragment.bB.get()).a(immutableList);
        ImmutableList a2 = ((PhotoTagExtractor) composerFragment.bB.get()).a(immutableList);
        ImmutableSet.Builder builder = ImmutableSet.builder();
        int size = a2.size();
        for (int i = 0; i < size; i++) {
            builder.c(Long.valueOf(((Tag) a2.get(i)).c));
        }
        ImmutableSet b = builder.b();
        if (!composerFragment.bj.equals(b)) {
            composerFragment.aU.m7630b(cn).m7698c(ComposerTagUtil.a(a, ComposerTagUtil.a(composerFragment.bj, composerFragment.aS.m7432h()))).m7689a();
            composerFragment.bj = b;
            bi(composerFragment);
            bj(composerFragment);
        }
    }

    public static void bi(ComposerFragment composerFragment) {
        bW(composerFragment);
        be(composerFragment);
    }

    public static void bj(ComposerFragment composerFragment) {
        aB(composerFragment).a(ImmutableSet.copyOf(ComposerTagUtil.a(composerFragment.aS.m7432h())));
    }

    public final void m7600e(Bundle bundle) {
        super.e(bundle);
        ComposerModel composerModel = this.aU.f6187f;
        ComposerPluginDefault composerPluginDefault = this.aL;
        bundle.putString("session_id", composerModel.f6743a);
        bundle.putParcelable("composition", composerModel.f6745c);
        bundle.putParcelable("composer_session_logging_data", composerModel.f6749g);
        bundle.putLong("session_start_time_ms", composerModel.f6759q);
        bundle.putParcelable("viewer_coordinates", composerModel.f6748f);
        bundle.putParcelable("target_data", composerModel.f6747e);
        FlatBufferModelHelper.a(bundle, "privacy_override", composerModel.f6750h);
        bundle.putParcelable("audience_educator_data", composerModel.f6751i);
        bundle.putBoolean("has_shown_tag_place_tip_or_suggestion", composerModel.f6755m);
        bundle.putBoolean("privacy_has_changed", composerModel.f6754l);
        bundle.putString("plugin_state", ((InstanceState) Preconditions.checkNotNull(composerPluginDefault.a())).b);
        bundle.putBoolean("post_composition_shown", composerModel.f6756n);
        bundle.putParcelable("inline_sprouts_state", composerModel.f6752j);
        bundle.putCharSequence("meta_text", composerModel.f6760r);
        this.aN = true;
    }

    private void bk() {
        this.bk.a("ComposerSetupFeedAttachment");
        Object a = this.da.m7847a(this.aS, this.aU, this.cD.a(o()), this.di);
        ComposerFeedAttachmentController a2 = this.db.m7945a(this.aS, this.aU);
        ComposerFeedAttachmentController a3 = this.cX.m7989a(this.aS, this.dA);
        ComposerFeedAttachmentController a4 = this.dd.m8136a(this.aS, this.aU, this.dC);
        ViewStub viewStub = (ViewStub) this.bS.findViewById(2131560636);
        if (this.bA.a(ExperimentsForComposerAbTestModule.l, false)) {
            viewStub.setLayoutResource(2130903669);
            this.aU.m7628a((ComposerEventHandler) new ComposerFeedAttachmentManager(ImmutableSet.of(this.cG.m7922a(a), this.cZ.m7893a(this.aS, this.aU, this.dB), this.cG.m7922a(a2), this.cG.m7922a(a3), this.cG.m7922a(a4)), viewStub));
        } else {
            viewStub.setLayoutResource(2130905032);
            ComposerMutatorImpl composerMutatorImpl = this.aU;
            LegacyComposerFeedAttachmentManagerProvider legacyComposerFeedAttachmentManagerProvider = this.bX;
            composerMutatorImpl.m7628a((ComposerEventHandler) new LegacyComposerFeedAttachmentManager(TasksManager.b(legacyComposerFeedAttachmentManagerProvider), (Context) legacyComposerFeedAttachmentManagerProvider.getInstance(Context.class), ImmutableSet.of(a, this.cY.m7892a(this.aS, this.aU, this.dB), a2, a3, a4), viewStub));
        }
        this.bk.b("ComposerSetupFeedAttachment");
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.aU.m7627a(ComposerEvent.ON_ORIENTATION_CHANGED, cn);
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -984366081);
        super.mi_();
        this.ax.f6267a.a();
        ComposerSavedSessionController composerSavedSessionController = (ComposerSavedSessionController) this.bI.get();
        C07669 c07669 = this.de;
        String ab = this.aS.ab();
        composerSavedSessionController.f6933f = new WeakReference(Preconditions.checkNotNull(c07669));
        composerSavedSessionController.f6934g = (String) Preconditions.checkNotNull(ab);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -743513267, a);
    }

    public final void mj_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1197955344);
        this.ax.f6267a.e();
        super.mj_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 224052403, a);
    }

    public final void m7592G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1795420712);
        super.G();
        if (this.aS.m7424a() != null && this.aS.m7424a().b() == null) {
            this.bz.a(ComposerTaskId.FETCH_APP_NAME, new Callable<ListenableFuture<String>>(this) {
                final /* synthetic */ ComposerFragment f6075a;

                {
                    this.f6075a = r1;
                }

                public Object call() {
                    ComposerService composerService = (ComposerService) this.f6075a.f6151i.get();
                    String a = this.f6075a.aS.m7424a().a();
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("app_name", new Params(a));
                    return Futures.a(BlueServiceOperationFactoryDetour.a((DefaultBlueServiceOperationFactory) composerService.b.get(), "platform_get_app_name", bundle, 772600632).a(), new ComposerService.1(composerService));
                }
            }, new AbstractDisposableFutureCallback<String>(this) {
                final /* synthetic */ ComposerFragment f6076a;

                {
                    this.f6076a = r1;
                }

                protected final void m7483a(Object obj) {
                    String str = (String) obj;
                    if (Strings.isNullOrEmpty(str)) {
                        ComposerFragment.m7544a(this.f6076a, null, "Failed to get app name.");
                    } else {
                        this.f6076a.aU.m7630b(ComposerFragment.cn).m7679a(new ComposerAppAttribution(this.f6076a.aS.m7424a().a(), str, this.f6076a.aS.m7424a().c(), this.f6076a.aS.m7424a().d())).m7689a();
                    }
                }

                protected final void m7484a(Throwable th) {
                    ComposerFragment.m7544a(this.f6076a, th, "Failed to get app name.");
                }
            });
        }
        this.bS.m8410a(this.dN);
        this.bS.m8418b(this.cR);
        if (this.aS.m7401B()) {
            this.am.c();
            au().m7395b(null);
            if (this.am.d()) {
                aZ();
            }
        }
        ((ComposerSavedSessionController) this.bI.get()).m8249a();
        this.df.d();
        Sequence e = this.bk.d.e(ComposerPerformanceLogger.a);
        if (e != null) {
            SequenceLoggerDetour.a(SequenceLoggerDetour.b(e, "ComposerFragmentSetup", -817403694), "ComposerRenderPhase", 1940245516);
        }
        this.bk.c.c(917509, "ComposerLaunchTTIExternalShare");
        this.bk.c.c(917510, "ComposerLaunchTTIPlatformShare");
        this.aU.m7627a(ComposerEvent.ON_RESUME, cn);
        final ImmutableList b = AttachmentUtils.b(this.aS.m7437m());
        if (!b.isEmpty() && ((VaultDataFetcher) this.bZ.get()).a()) {
            ExecutorDetour.a(this.ca, new Runnable(this) {
                final /* synthetic */ ComposerFragment f6124b;

                public void run() {
                    ((VaultDataFetcher) this.f6124b.bZ.get()).a(b);
                }
            }, 247634417);
        }
        if (this.aU.f6187f.f6756n && !(this.bU.b() && ((PostCompositionView) this.bU.a()).getVisibility() == 0)) {
            m7545a(this, false);
        }
        this.aN = false;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1930811736, a);
    }

    public final void m7593H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1546483985);
        if (!this.aS.m7437m().isEmpty()) {
            this.bJ.a(this.aS.ab(), this.aS.m7439o().getComposerType(), this.bS.getMaxScrolledPercent(), this.bS.getMinAspectRatio());
        }
        ImmutableMap creativeEditingUsageParameters = this.bS.getCreativeEditingUsageParameters();
        if (!(creativeEditingUsageParameters == null || creativeEditingUsageParameters.isEmpty())) {
            this.aU.m7630b(cn).m7680a(creativeEditingUsageParameters).m7689a();
        }
        this.bz.c();
        this.am.a(true);
        aZ();
        this.bS.m8419b(this.dN);
        this.bS.m8422c(this.cR);
        ((ComposerSavedSessionController) this.bI.get()).m8250b();
        this.df.f();
        ComposerTipSessionControl composerTipSessionControl = this.am.e;
        for (ComposerInterstitialControllers composerInterstitialControllers : ComposerInterstitialControllers.values()) {
            ((ComposerInterstitialTip) composerTipSessionControl.b.a(composerInterstitialControllers.interstitialId)).a();
        }
        this.aU.m7627a(ComposerEvent.ON_PAUSE, cn);
        super.H();
        ((WithTagPerformanceLogger) this.bl.get()).b();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1982955303, a);
    }

    public final void m7596a(int i, int i2, @Nullable Intent intent) {
        boolean z;
        boolean z2 = false;
        super.a(i, i2, intent);
        if (intent == null) {
            intent = new Intent();
        }
        if (!this.aS.m7407H() || this.cp.f6600d.a(ExperimentsForFeedUtilComposerAbtestModule.r, false)) {
            z = false;
        } else {
            z = true;
        }
        switch (i) {
            case 1:
            case 5:
                m7561c(i2, intent);
                break;
            case 2:
                m7563d(i2, intent);
                break;
            case 3:
                if (i2 == -1) {
                    m7540a(this, (ComposerTargetData) intent.getParcelableExtra("extra_composer_target_data"), (ViewerContext) intent.getParcelableExtra("extra_actor_viewer_context"));
                }
                break;
            case 4:
                m7572g(i2, intent);
                break;
            case 6:
                if (i2 == 0) {
                    this.bJ.a(Events.COMPOSER_MINUTIAE_ICON_PICKER_CANCEL, this.aS.ab());
                } else if (i2 == -1) {
                    this.bJ.a(Events.COMPOSER_MINUTIAE_ICON_PICKER_UPDATE, this.aS.ab());
                    MinutiaeObject minutiaeObject = null;
                    if (intent.hasExtra("minutiae_object")) {
                        minutiaeObject = (MinutiaeObject) intent.getParcelableExtra("minutiae_object");
                    }
                    m7538a(this, minutiaeObject);
                    bi(this);
                }
                break;
            case 7:
                m7588m(i2, intent);
                break;
            case 8:
                m7566e(i2, intent);
                break;
            case 9:
                if (intent.hasExtra("category_id")) {
                    this.bS.setCategoryID(intent.getStringExtra("category_id"));
                    bf(this);
                }
                break;
            case 10:
                m7584k(i2, intent);
                break;
            case 11:
                m7586l(i2, intent);
                break;
            case 12:
                if (i2 == -1 && intent.hasExtra("extra_composer_life_event_icon_model")) {
                    this.aU.m7630b(cn).m7664a((ComposerLifeEventModel) intent.getParcelableExtra("extra_composer_life_event_icon_model")).m7689a();
                }
                break;
            case 13:
                if (i2 == -1) {
                    GraphQLAlbum graphQLAlbum = (GraphQLAlbum) FlatBufferModelHelper.a(intent, "extra_selected_album");
                    this.aU.m7630b(cn).m7668a(graphQLAlbum).m7689a();
                    if (graphQLAlbum != null) {
                        this.bJ.a(Events.COMPOSER_SELECT_ALBUM, this.aS.ab());
                    }
                }
                break;
            case 14:
                m7590o(i2, intent);
                break;
            case 15:
                m7591p(i2, intent);
                break;
            case 124:
                m7571g(i2);
                z = true;
                break;
            case 126:
                m7567e(intent);
                z = true;
                break;
            case 127:
                m7581j(i2, intent);
                z = true;
                break;
            case 128:
                z2 = m7577h(i2);
                break;
            case 130:
                m7578i(i2, intent);
                break;
            case 131:
                m7569f(intent);
                z = true;
                break;
        }
        if (this.aS.m7408I()) {
            if (z) {
                bg(this);
            } else if (this.aS.m7407H()) {
                z2 = true;
            }
        }
        if (!bm()) {
            Object obj;
            TipManager tipManager = this.am;
            if (tipManager.i) {
                obj = null;
            } else if (((ComposerInterstitialTip) tipManager.c.a(TipManager.a, ComposerInterstitialTip.class)) != null) {
                r4 = 1;
            } else {
                Iterator it = tipManager.j.iterator();
                while (it.hasNext()) {
                    TipControllerInterface tipControllerInterface = (TipControllerInterface) tipManager.b.get((Tip) it.next());
                    if (tipControllerInterface != null && tipControllerInterface.b()) {
                        r4 = 1;
                    }
                }
                obj = null;
            }
            if (obj == null && !this.aU.f6187f.f6756n && !r2) {
                bo(this);
            }
        }
    }

    private boolean bm() {
        return this.bY || bn() != null;
    }

    public static void bo(ComposerFragment composerFragment) {
        if (composerFragment.am == null) {
            ((AbstractFbErrorReporter) composerFragment.bO.get()).a("composer_keyboard", "Tip Manager not available");
            return;
        }
        boolean a;
        if (composerFragment.aL.C != null) {
            a = composerFragment.aL.C.a();
        } else if (!composerFragment.aS.m7437m().isEmpty() || composerFragment.am.d() || GifUtil.a(composerFragment.aS.m7441q())) {
            a = false;
        } else {
            a = true;
        }
        if (a) {
            composerFragment.aL.b();
            composerFragment.bS.m8421c();
            composerFragment.bS.m8417b();
        }
    }

    public static void m7540a(ComposerFragment composerFragment, @Nullable ComposerTargetData composerTargetData, ViewerContext viewerContext) {
        ComposerPageData.Builder a = composerFragment.aS.m7440p() != null ? ComposerPageData.a(composerFragment.aS.m7440p()) : ComposerPageData.newBuilder();
        TransactionImpl a2 = composerFragment.aU.m7630b(cn).m7673a(composerTargetData);
        if (composerTargetData.targetType != TargetType.PAGE) {
            viewerContext = null;
        }
        a2.m7671a(a.setPostAsPageViewerContext(viewerContext).a()).m7689a();
        aB(composerFragment).a(Long.valueOf(composerFragment.aS.m7443s().targetId));
        composerFragment.bb();
        composerFragment.bS.setIsAddMorePhotosAllowed(composerFragment.aS.ax() == Capability.ALLOW);
        composerFragment.ch();
        if (composerFragment.aS.m7435k() != RedSpaceValue.POST_TO_NEWSFEED) {
            boolean z;
            ComposerDataProviderImpl composerDataProviderImpl = composerFragment.aS;
            ComposerRedSpaceCapability composerRedSpaceCapability = (ComposerRedSpaceCapability) composerDataProviderImpl.f6024h.get();
            BooleanGetter booleanGetter = composerDataProviderImpl.f6035s.m7482b().K;
            ComposerConfiguration composerConfiguration = composerDataProviderImpl.f6035s.m7481a().f6744b;
            TargetType targetType = composerDataProviderImpl.f6035s.m7481a().f6747e.targetType;
            if (composerDataProviderImpl.ad() != null) {
                z = true;
            } else {
                z = false;
            }
            if (!composerRedSpaceCapability.b(booleanGetter, composerConfiguration, targetType, z)) {
                composerFragment.aU.m7630b(cn).m7693b(RedSpaceValue.POST_TO_NEWSFEED).m7689a();
            }
        }
    }

    private void m7561c(int i, Intent intent) {
        if (i == 0) {
            this.bJ.a(Events.COMPOSER_FRIEND_TAG_CANCEL, this.aS.ab());
        } else if (i != -1) {
            this.bJ.a(Events.COMPOSER_FRIEND_TAG_FAILURE, this.aS.ab());
        } else {
            MediaItem mediaItem;
            int i2;
            this.bJ.a(Events.COMPOSER_FRIEND_TAG, this.aS.ab());
            if (intent.getBooleanExtra("tag_people_after_tag_place", false)) {
                this.bJ.a(Events.COMPOSER_FRIEND_TAG_SUGGESTIONS_SHOWN, this.aS.ab());
            }
            ImmutableSet copyOf = ImmutableSet.copyOf(ComposerTagUtil.a(this.aS.m7432h()));
            Context applicationContext = ao().getApplicationContext();
            Set a = Sets.a();
            if (intent.hasExtra("full_profiles")) {
                List<FacebookProfile> parcelableArrayListExtra = intent.getParcelableArrayListExtra("full_profiles");
                ImmutableList.Builder builder = ImmutableList.builder();
                for (FacebookProfile facebookProfile : parcelableArrayListExtra) {
                    a.add(Long.valueOf(facebookProfile.mId));
                    builder.c(ComposerTaggedUser.a(facebookProfile.mId).a(facebookProfile.mDisplayName).b(facebookProfile.mImageUrl).a());
                }
                this.aU.m7630b(cn).m7698c(builder.b()).m7689a();
            }
            boolean booleanExtra = intent.getBooleanExtra("photo_tagged_set_modified", false);
            if (intent.hasExtra("extra_media_items") && booleanExtra) {
                ArrayList parcelableArrayListExtra2 = intent.getParcelableArrayListExtra("extra_media_items");
                if (parcelableArrayListExtra2 != null) {
                    ImmutableList.Builder builder2 = ImmutableList.builder();
                    int size = parcelableArrayListExtra2.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        mediaItem = (MediaItem) parcelableArrayListExtra2.get(i3);
                        if (mediaItem instanceof PhotoItem) {
                            for (Tag h : this.au.b((PhotoItem) mediaItem)) {
                                a.add(Long.valueOf(h.h()));
                            }
                        }
                        ComposerAttachment a2 = AttachmentUtils.a(this.aS.m7437m(), mediaItem.c());
                        ComposerAttachment.Builder a3 = ComposerAttachment.Builder.a(mediaItem);
                        if (a2 != null) {
                            a3.a(a2.d()).a(a2.e());
                        }
                        builder2.c(a3.a());
                    }
                    m7543a(this, builder2.b(), true, true);
                }
            }
            if (booleanExtra) {
                ImmutableList e = AttachmentUtils.e(this.aS.m7437m());
                int size2 = e.size();
                for (i2 = 0; i2 < size2; i2++) {
                    mediaItem = (MediaItem) e.get(i2);
                    if (mediaItem instanceof PhotoItem) {
                        this.au.a(applicationContext, (PhotoItem) mediaItem);
                    }
                }
            }
            if (booleanExtra) {
                Collection b = Sets.b(Sets.c(copyOf, a));
                b.remove(Long.valueOf(cj()));
                ImmutableList.Builder builder3 = ImmutableList.builder();
                ImmutableList e2 = AttachmentUtils.e(this.aS.m7437m());
                int size3 = e2.size();
                for (i2 = 0; i2 < size3; i2++) {
                    mediaItem = (MediaItem) e2.get(i2);
                    if (mediaItem instanceof PhotoItem) {
                        builder3.c((PhotoItem) mediaItem);
                    }
                }
                this.au.a(builder3.b(), b);
                this.aU.m7630b(cn).m7698c(ComposerTagUtil.a(ImmutableSet.copyOf(b), this.aS.m7432h())).m7689a();
            }
            bi(this);
            bj(this);
            Object obj = !this.aS.m7432h().isEmpty() ? 1 : null;
            if (!copyOf.isEmpty() && obj == null) {
                this.bJ.a(Events.COMPOSER_FRIEND_TAG_REMOVE, this.aS.ab());
            }
            this.bS.m8420b(AttachmentUtils.b(this.aS.m7437m()));
            if (intent.getBooleanExtra("tag_place_after_tag_people", false)) {
                m7563d(i, intent);
            }
        }
    }

    private void m7563d(int i, Intent intent) {
        if (i == 0) {
            this.bJ.a(Events.COMPOSER_ADD_LOCATION_CANCEL, this.aS.ab());
        } else if (i != -1) {
            this.bJ.a(Events.COMPOSER_ADD_LOCATION_FAILURE, this.aS.ab());
        } else {
            if (intent.getBooleanExtra("tag_place_after_tag_people", false)) {
                this.bJ.a(Events.COMPOSER_ADD_LOCATION_AFTER_TAG_PEOPLE, this.aS.ab());
            }
            bp(this);
            if (intent.getBooleanExtra("extra_xed_location", false)) {
                this.aU.m7630b(cn).m7692b(ComposerLocationInfo.a(this.aS.m7431g()).a().b()).m7689a();
                bW(this);
                m7557b(this, null);
            } else if (intent.hasExtra("text_only_place")) {
                this.aU.m7630b(cn).m7692b(ComposerLocationInfo.a(this.aS.m7431g()).a(intent.getStringExtra("text_only_place")).b()).m7689a();
                bW(this);
            } else {
                m7541a(this, (CheckinPlaceModel) FlatBufferModelHelper.a(intent, "extra_place"), (ImplicitLocation) intent.getParcelableExtra("extra_implicit_location"), (MinutiaeObject) intent.getParcelableExtra("minutiae_object"));
            }
            if (intent.getBooleanExtra("tag_people_after_tag_place", false)) {
                m7561c(i, intent);
            } else if (!intent.getBooleanExtra("tag_place_after_tag_people", false)) {
                this.am.a(new Tip[]{Tip.TAG_PEOPLE_FOR_CHECKIN});
            }
        }
    }

    public static void bp(ComposerFragment composerFragment) {
        composerFragment.bJ.a(Events.COMPOSER_ADD_LOCATION, composerFragment.aS.ab());
        TransactionImpl b = composerFragment.aU.m7630b(cn);
        ComposerLocationInfo.Builder a = ComposerLocationInfo.a(composerFragment.aS.m7431g());
        a.d = false;
        b.m7692b(a.b()).m7689a();
    }

    public static void m7541a(ComposerFragment composerFragment, CheckinPlaceModel checkinPlaceModel, ImplicitLocation implicitLocation, MinutiaeObject minutiaeObject) {
        boolean z = true;
        boolean z2 = composerFragment.aS.m7431g().a() != null;
        TransactionImpl b = composerFragment.aU.m7630b(cn);
        ComposerLocationInfo.Builder a = ComposerLocationInfo.a(composerFragment.aS.m7431g());
        a.b = false;
        b.m7692b(a.a(checkinPlaceModel, implicitLocation).b()).m7689a();
        if (minutiaeObject != null) {
            m7538a(composerFragment, minutiaeObject);
        }
        bW(composerFragment);
        if (composerFragment.aS.m7431g().a() == null) {
            z = false;
        }
        if (z2 && !r1) {
            composerFragment.bJ.a(Events.COMPOSER_ADD_LOCATION_REMOVE, composerFragment.aS.ab());
        }
        m7557b(composerFragment, composerFragment.aS.m7431g().a());
    }

    private void m7566e(int i, Intent intent) {
        if (i == -1) {
            Date date = (Date) intent.getParcelableExtra("startDate");
            Date date2 = (Date) intent.getParcelableExtra("endDate");
            boolean booleanExtra = intent.getBooleanExtra("isCurrent", false);
            boolean booleanExtra2 = intent.getBooleanExtra("hasGraduated", false);
            TransactionImpl b = this.aU.m7630b(cn);
            ComposerDateInfo.Builder builder = new ComposerDateInfo.Builder();
            builder.a = date;
            ComposerDateInfo.Builder builder2 = builder;
            builder2.b = date2;
            builder2 = builder2;
            builder2.c = booleanExtra;
            TransactionImpl a = b.m7674a(builder2.a());
            ComposerLifeEventModel.Builder l = ((ComposerLifeEventModel) Preconditions.checkNotNull(this.aS.m7438n())).l();
            l.h = booleanExtra2;
            a.m7664a(l.a()).m7689a();
        }
    }

    private void m7571g(int i) {
        if (i == 0) {
            this.bJ.a(Events.COMPOSER_ATTACH_MOVIE_CANCEL, this.aS.ab());
            return;
        }
        boolean i2 = AttachmentUtils.i(this.aS.m7437m());
        if (i == 4) {
            m7543a(this, RegularImmutableList.a, true, false);
            if (i2) {
                this.bJ.a(Events.COMPOSER_ATTACH_MOVIE_REMOVE, this.aS.ab());
            } else {
                this.bJ.a(Events.COMPOSER_ATTACH_MOVIE_CANCEL, this.aS.ab());
            }
        } else if (this.aS.m7415Q()) {
            m7558b(this, AttachmentUtils.e(this.aS.m7437m()));
        }
    }

    private void m7572g(int i, Intent intent) {
        if (i == 0) {
            this.bJ.a(Events.COMPOSER_MINUTIAE_CANCEL, this.aS.ab());
            if (this.bG != null) {
                this.bG.m7771f();
            }
        } else if (i == -1) {
            this.bJ.a(Events.COMPOSER_MINUTIAE, this.aS.ab());
            Object obj = this.aS.m7436l() != null ? 1 : null;
            MinutiaeObject minutiaeObject = null;
            if (intent.hasExtra("minutiae_object")) {
                minutiaeObject = (MinutiaeObject) intent.getParcelableExtra("minutiae_object");
            }
            m7538a(this, minutiaeObject);
            bi(this);
            if (intent.hasExtra("extra_place")) {
                m7563d(i, intent);
            }
            if (obj != null && this.aS.m7436l() == null) {
                this.bJ.a(Events.COMPOSER_MINUTIAE_REMOVE, this.aS.ab());
            }
        }
    }

    private void m7578i(int i, Intent intent) {
        if (i != 0) {
            this.aU.m7630b(cn).m7676a((ComposerSlideshowData) intent.getParcelableExtra("extra_slideshow_data")).m7689a();
            m7533a(intent, true);
        }
    }

    private void m7581j(int i, Intent intent) {
        if (i == 0) {
            this.bJ.a(Events.COMPOSER_ATTACH_PHOTO_CANCEL, this.aS.ab());
        } else {
            ComposerContentType c = this.aS.m7427c();
            this.aU.m7630b(cn).m7676a((ComposerSlideshowData) intent.getParcelableExtra("extra_slideshow_data")).m7689a();
            boolean z = this.aS.m7427c() != c || this.aS.m7427c() == ComposerContentType.SLIDESHOW;
            m7533a(intent, z);
        }
        m7580i(true);
    }

    private void m7533a(Intent intent, boolean z) {
        ImmutableList copyOf;
        ImmutableList immutableList;
        ImmutableList of;
        ImmutableList immutableList2;
        ImmutableList b;
        ImmutableList b2;
        boolean z2;
        boolean z3 = true;
        boolean k = AttachmentUtils.k(this.aS.m7437m());
        boolean i = AttachmentUtils.i(this.aS.m7437m());
        if (intent.hasExtra("extra_media_items")) {
            Collection parcelableArrayListExtra = intent.getParcelableArrayListExtra("extra_media_items");
            if (parcelableArrayListExtra != null) {
                copyOf = ImmutableList.copyOf(parcelableArrayListExtra);
                immutableList = copyOf;
                of = ImmutableList.of();
                if (immutableList == null && !immutableList.isEmpty()) {
                    of = ComposerAttachment.a(immutableList);
                } else if (intent.getParcelableExtra("creative_cam_result_extra") != null) {
                    of = m7560c(intent);
                }
                immutableList2 = this.an.m7611a(this.aS.ab(), of, this.aS.m7439o().isEdit()).a;
                if (immutableList2.isEmpty()) {
                    ImmutableList.Builder builder = ImmutableList.builder();
                    ImmutableList.Builder builder2 = ImmutableList.builder();
                    m7549a(br(), immutableList, builder, builder2);
                    b = builder.b();
                    b2 = builder2.b();
                    z2 = immutableList.isEmpty() && ((MediaItem) immutableList.get(0)).m() == MediaType.VIDEO;
                    if (!(b.isEmpty() && b2.isEmpty())) {
                        this.bJ.a(this.aS.ab(), b, b2, z2, i);
                    }
                    if (z2) {
                        this.bJ.a(Events.COMPOSER_ATTACH_MOVIE, this.aS.ab());
                        if (this.aS.m7434j() == PublishMode.SAVE_DRAFT) {
                            this.aU.m7630b(cn).m7678a(PublishMode.NORMAL).m7689a();
                        }
                    } else if (!immutableList.isEmpty()) {
                        this.bJ.a(Events.COMPOSER_ATTACH_PHOTO, this.aS.ab());
                        ((CreativeEditingAnalyticsLogger) this.dc.get()).a(this.aS.ab(), CreativeEditingAnalyticsLogger.Events.ATTACHMENT_ADDED);
                    }
                    m7543a(this, m7532a(immutableList2), true, z);
                    ComposerStatusView composerStatusView = this.bS;
                    if (this.aS.m7427c() == ComposerContentType.SLIDESHOW || this.aS.ax() != Capability.ALLOW) {
                        z3 = false;
                    }
                    composerStatusView.setIsAddMorePhotosAllowed(z3);
                    if (k && !AttachmentUtils.k(this.aS.m7437m())) {
                        this.bJ.a(Events.COMPOSER_ATTACH_PHOTO_REMOVE, this.aS.ab());
                    }
                    if (i && !AttachmentUtils.i(this.aS.m7437m())) {
                        this.bJ.a(Events.COMPOSER_ATTACH_MOVIE_REMOVE, this.aS.ab());
                    }
                    m7548a(Tip.TAG_PLACE_AFTER_PHOTO);
                }
            }
        }
        copyOf = RegularImmutableList.a;
        immutableList = copyOf;
        of = ImmutableList.of();
        if (immutableList == null) {
        }
        if (intent.getParcelableExtra("creative_cam_result_extra") != null) {
            of = m7560c(intent);
        }
        immutableList2 = this.an.m7611a(this.aS.ab(), of, this.aS.m7439o().isEdit()).a;
        if (immutableList2.isEmpty()) {
            ImmutableList.Builder builder3 = ImmutableList.builder();
            ImmutableList.Builder builder22 = ImmutableList.builder();
            m7549a(br(), immutableList, builder3, builder22);
            b = builder3.b();
            b2 = builder22.b();
            if (immutableList.isEmpty()) {
            }
            this.bJ.a(this.aS.ab(), b, b2, z2, i);
            if (z2) {
                this.bJ.a(Events.COMPOSER_ATTACH_MOVIE, this.aS.ab());
                if (this.aS.m7434j() == PublishMode.SAVE_DRAFT) {
                    this.aU.m7630b(cn).m7678a(PublishMode.NORMAL).m7689a();
                }
            } else if (immutableList.isEmpty()) {
                this.bJ.a(Events.COMPOSER_ATTACH_PHOTO, this.aS.ab());
                ((CreativeEditingAnalyticsLogger) this.dc.get()).a(this.aS.ab(), CreativeEditingAnalyticsLogger.Events.ATTACHMENT_ADDED);
            }
            m7543a(this, m7532a(immutableList2), true, z);
            ComposerStatusView composerStatusView2 = this.bS;
            z3 = false;
            composerStatusView2.setIsAddMorePhotosAllowed(z3);
            this.bJ.a(Events.COMPOSER_ATTACH_PHOTO_REMOVE, this.aS.ab());
            this.bJ.a(Events.COMPOSER_ATTACH_MOVIE_REMOVE, this.aS.ab());
            m7548a(Tip.TAG_PLACE_AFTER_PHOTO);
        }
    }

    private ImmutableList<ComposerAttachment> m7560c(Intent intent) {
        CreativeCamResult creativeCamResult = (CreativeCamResult) intent.getParcelableExtra("creative_cam_result_extra");
        ImmutableList a = ComposerAttachment.a(ImmutableList.of(this.cB.a(creativeCamResult.b, FallbackMediaId.CREATIVECAM_MEDIA)));
        ImmutableList.Builder builder = new ImmutableList.Builder();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            ComposerAttachment composerAttachment = (ComposerAttachment) a.get(i);
            if (composerAttachment.c().equals(creativeCamResult.b)) {
                ComposerAttachment.Builder a2 = ComposerAttachment.Builder.a(composerAttachment);
                a2.e = creativeCamResult.c;
                builder.c(a2.a());
            }
        }
        return builder.b();
    }

    private void m7580i(boolean z) {
        ImmutableList e = AttachmentUtils.e(this.aS.m7437m());
        if (this.aS.m7427c() != ComposerContentType.SLIDESHOW) {
            Object obj;
            ComposerAttachmentsAutoTaggingController composerAttachmentsAutoTaggingController = this.bD;
            Preconditions.checkNotNull(e);
            int size = e.size();
            loop0:
            for (int i = 0; i < size; i++) {
                MediaItem mediaItem = (MediaItem) e.get(i);
                if ((mediaItem instanceof PhotoItem) && (((PhotoItem) mediaItem).f instanceof LocalPhoto)) {
                    LocalPhoto localPhoto = ((PhotoItem) mediaItem).f;
                    List<FaceBox> a = composerAttachmentsAutoTaggingController.a.a(localPhoto);
                    if (a == null) {
                        obj = 1;
                        break;
                    } else if (!(a.isEmpty() || localPhoto.f)) {
                        for (FaceBox faceBox : a) {
                            if (!faceBox.f) {
                                int i2 = 1;
                                break loop0;
                            }
                        }
                        continue;
                    }
                }
            }
            obj = null;
            if (obj != null) {
                bh();
                if (z) {
                    aE();
                    return;
                }
                return;
            }
        }
        ((FaceBoxPrioritizer) this.bC.get()).e();
    }

    private ImmutableSet<MediaItem> br() {
        ImmutableSet.Builder builder = ImmutableSet.builder();
        ImmutableList m = this.aS.m7437m();
        int size = m.size();
        for (int i = 0; i < size; i++) {
            builder.c(((ComposerAttachment) m.get(i)).b());
        }
        return builder.b();
    }

    private static void m7549a(ImmutableSet<MediaItem> immutableSet, ImmutableList<MediaItem> immutableList, ImmutableList.Builder<String> builder, ImmutableList.Builder<String> builder2) {
        ImmutableSet copyOf = ImmutableSet.copyOf(immutableList);
        Iterator it = Sets.c(copyOf, immutableSet).iterator();
        while (it.hasNext()) {
            builder.c(((MediaItem) it.next()).d().toString());
        }
        Iterator it2 = Sets.c(immutableSet, copyOf).iterator();
        while (it2.hasNext()) {
            builder2.c(((MediaItem) it2.next()).d().toString());
        }
    }

    private int bs() {
        ImmutableList m = this.aS.m7437m();
        int size = m.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            int i3;
            CreativeEditingData e = ((ComposerAttachment) m.get(i)).e();
            if (e == null || e.d() == null) {
                i3 = i2;
            } else {
                i3 = e.d().size() + i2;
            }
            i++;
            i2 = i3;
        }
        return i2;
    }

    private void m7567e(Intent intent) {
        Collection parcelableArrayListExtra = intent.getParcelableArrayListExtra("extra_photo_items_list");
        List parcelableArrayListExtra2 = intent.getParcelableArrayListExtra("extras_taggable_gallery_creative_editing_data_list");
        if (parcelableArrayListExtra2 != null) {
            Preconditions.checkState(parcelableArrayListExtra.size() == parcelableArrayListExtra2.size());
        }
        if (intent.getBooleanExtra("extra_are_media_items_modified", false)) {
            ImmutableList.Builder builder = ImmutableList.builder();
            ImmutableList m = this.aS.m7437m();
            int size = m.size();
            for (int i = 0; i < size; i++) {
                ComposerAttachment composerAttachment = (ComposerAttachment) m.get(i);
                if (composerAttachment.b() != null) {
                    MediaItem mediaItem;
                    CreativeEditingData creativeEditingData;
                    ComposerAttachment.Builder a;
                    MediaIdKey d = composerAttachment.b().d();
                    int i2 = 0;
                    while (i2 < parcelableArrayListExtra.size()) {
                        if (((PhotoItem) parcelableArrayListExtra.get(i2)).d().equals(d)) {
                            mediaItem = (PhotoItem) parcelableArrayListExtra.get(i2);
                            creativeEditingData = parcelableArrayListExtra2 != null ? (CreativeEditingData) parcelableArrayListExtra2.get(i2) : null;
                            if (mediaItem == null) {
                                a = ComposerAttachment.Builder.a(mediaItem);
                                if (creativeEditingData != null) {
                                    a.e = creativeEditingData;
                                }
                            } else {
                                a = ComposerAttachment.Builder.a(composerAttachment);
                            }
                            a.d = composerAttachment.d();
                            builder.c(a.a());
                        } else {
                            i2++;
                        }
                    }
                    creativeEditingData = null;
                    mediaItem = null;
                    if (mediaItem == null) {
                        a = ComposerAttachment.Builder.a(composerAttachment);
                    } else {
                        a = ComposerAttachment.Builder.a(mediaItem);
                        if (creativeEditingData != null) {
                            a.e = creativeEditingData;
                        }
                    }
                    a.d = composerAttachment.d();
                    builder.c(a.a());
                }
            }
            m7543a(this, builder.b(), true, true);
            this.bS.m8420b(ImmutableList.copyOf(parcelableArrayListExtra));
        }
    }

    private void m7569f(Intent intent) {
        int i = 0;
        if (intent.getBooleanExtra("extra_are_media_items_modified", false)) {
            ImmutableList a = ((PhotoTagExtractor) this.bB.get()).a(intent.getParcelableArrayListExtra("extra_photo_items_list"));
            ImmutableList.Builder builder = ImmutableList.builder();
            int size = a.size();
            while (i < size) {
                Tag tag = (Tag) a.get(i);
                ComposerTaggedUser.Builder a2 = ComposerTaggedUser.a(tag.c);
                a2.b = tag.b.g();
                a2 = a2;
                a2.c = tag.i;
                builder.c(a2.a());
                i++;
            }
            this.aU.m7630b(cn).m7698c(builder.b()).m7689a();
            bi(this);
            bj(this);
        }
    }

    private void m7584k(int i, Intent intent) {
        if (i == 0) {
            this.bJ.a(Events.COMPOSER_ADD_LOCATION_CANCEL, this.aS.ab());
        } else if (i != -1) {
            this.bJ.a(Events.COMPOSER_ADD_LOCATION_FAILURE, this.aS.ab());
        } else {
            this.bJ.a(Events.COMPOSER_ADD_LOCATION, this.aS.ab());
            if (intent.getBooleanExtra("extra_xed_location", false)) {
                this.bS.setStructuredLocationText("");
                this.aY.f6313i = null;
            } else if (intent.hasExtra("text_only_place")) {
                this.bS.setStructuredLocationText(intent.getStringExtra("text_only_place"));
                this.aY.f6313i = null;
            } else {
                CheckinPlaceModel checkinPlaceModel = (CheckinPlaceModel) FlatBufferModelHelper.a(intent, "extra_place");
                if (checkinPlaceModel != null) {
                    ProductItemPlace.Builder builder = new ProductItemPlace.Builder();
                    builder.a = checkinPlaceModel.j();
                    builder = builder;
                    builder.b = checkinPlaceModel.cf_();
                    builder = builder;
                    if (checkinPlaceModel.cg_() != null) {
                        builder.c = checkinPlaceModel.cg_().a();
                        builder.d = checkinPlaceModel.cg_().b();
                    }
                    ProductItemPlace a = builder.a();
                    this.bS.setStructuredLocationText(a.name);
                    this.aY.f6313i = a;
                }
            }
            bf(this);
        }
    }

    private void m7586l(int i, Intent intent) {
        if (i == -1 && intent.hasExtra("transliterated_text")) {
            String stringExtra = intent.getStringExtra("transliterated_text");
            this.aU.m7630b(cn).m7670a(GraphQLHelper.a(stringExtra)).m7689a();
            this.bS.setStatusText(MentionsSpannableStringBuilder.a(GraphQLHelper.a(stringExtra), jW_(), this.bq));
            bW(this);
        }
    }

    private void m7588m(int i, Intent intent) {
        au().m7392a(i, intent, this.cK);
    }

    public static void m7557b(@Nullable ComposerFragment composerFragment, CheckinPlaceModel checkinPlaceModel) {
        aB(composerFragment).a(checkinPlaceModel);
    }

    public static void m7538a(ComposerFragment composerFragment, MinutiaeObject minutiaeObject) {
        composerFragment.aU.m7630b(cn).m7665a(minutiaeObject).m7689a();
        aB(composerFragment).a(minutiaeObject);
    }

    private void bt() {
        this.bJ.a(this.aS.ab(), this.aS.m7439o().getSourceType(), this.aS.m7439o().getComposerType(), this.aS.m7443s().targetType, this.aS.m7443s().targetId, this.bQ, bE(), this.bz.b(), this.aS.ag().e, this.cV.m7747b());
    }

    public static void bu(ComposerFragment composerFragment) {
        if (m7554a(composerFragment, DependantAction.SUBMISSION) || composerFragment.aS.ag().e) {
            composerFragment.bt();
        } else if (!composerFragment.bo) {
            if (AttachmentUtils.i(composerFragment.aS.m7437m())) {
                composerFragment.dg.a(ZeroFeatureKey.VIDEO_UPLOAD_INTERSTITIAL, composerFragment.D);
            } else {
                bv(composerFragment);
            }
        }
    }

    public static void bv(ComposerFragment composerFragment) {
        if (!composerFragment.cV.m7746a()) {
            composerFragment.bt();
        } else if (!composerFragment.bH()) {
            Object obj;
            if (composerFragment.aS.ag() == null || composerFragment.aS.ag().b == null || composerFragment.aS.ag().b.d == null) {
                obj = null;
            } else {
                ((InlinePrivacySurveyController) composerFragment.aC.get()).f6199a = composerFragment.aS.ab();
                ((InlinePrivacySurveyController) composerFragment.aC.get()).f6200b = new WeakReference(Preconditions.checkNotNull(composerFragment.dv));
                if (((InlinePrivacySurveyController) composerFragment.aC.get()).m7643a()) {
                    ((InlinePrivacySurveyController) composerFragment.aC.get()).f6201c = new WeakReference(Preconditions.checkNotNull(composerFragment.dw));
                    ((InlinePrivacySurveyController) composerFragment.aC.get()).m7644b();
                    obj = 1;
                } else {
                    obj = null;
                }
            }
            if (obj == null) {
                if (composerFragment.aU.f6187f.f6753k == 0 && ((GroupCommerceSellComposerIntercept) composerFragment.cc.get()).a(composerFragment.aS)) {
                    GroupsSalePostInterceptDialogFragment groupsSalePostInterceptDialogFragment = new GroupsSalePostInterceptDialogFragment();
                    groupsSalePostInterceptDialogFragment.am = new DialogInterface.OnClickListener(composerFragment) {
                        final /* synthetic */ ComposerFragment f6128a;

                        {
                            this.f6128a = r1;
                        }

                        public void onClick(DialogInterface dialogInterface, int i) {
                            this.f6128a.ao().setResult(-1, new Intent().putExtra("extra_is_composer_intercept_sell", true).putParcelableArrayListExtra("extra_is_composer_intercept_attachments", new ArrayList(AttachmentUtils.a(this.f6128a.aS.m7437m()))).putExtra("extra_is_composer_intercept_status", this.f6128a.aS.ae().a()));
                            ((CreativeEditingAnalyticsLogger) this.f6128a.dc.get()).c(this.f6128a.aS.ab(), this.f6128a.aS.m7437m().size());
                            this.f6128a.bS.m8427g();
                            ((UploadManager) this.f6128a.bM.get()).a(this.f6128a.aS.ab());
                            ComposerFragment.bX(this.f6128a);
                            this.f6128a.ao().finish();
                        }
                    };
                    groupsSalePostInterceptDialogFragment.an = new DialogInterface.OnClickListener(composerFragment) {
                        final /* synthetic */ ComposerFragment f6129a;

                        {
                            this.f6129a = r1;
                        }

                        public void onClick(DialogInterface dialogInterface, int i) {
                            ComposerFragment.bA(this.f6129a);
                        }
                    };
                    groupsSalePostInterceptDialogFragment.a(composerFragment.kO_(), "FOR_SALE_INTERCEPT_DIALOG");
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj == null) {
                    if (composerFragment.aS.m7434j() != PublishMode.SCHEDULE_POST || SchedulePostController.a(1000 * ((Long) Preconditions.checkNotNull(composerFragment.aS.m7422Y())).longValue(), ((Clock) composerFragment.aX.get()).a(), (Toaster) composerFragment.cQ.get())) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj == null) {
                        return;
                    }
                    if (composerFragment.aL.r() == null || !composerFragment.aL.r().a()) {
                        obj = null;
                        if (composerFragment.aU.f6187f.f6753k == 0 && composerFragment.aS.m7439o().getComposerType() == ComposerType.SELL) {
                            MarketplaceCrossPostSettingModel marketplaceCrossPostSettingModel = composerFragment.aS.m7439o().getCommerceInfo().getMarketplaceCrossPostSettingModel();
                            if (!(marketplaceCrossPostSettingModel == null || !marketplaceCrossPostSettingModel.a().booleanValue() || !marketplaceCrossPostSettingModel.b().booleanValue() || AttachmentUtils.e(composerFragment.aS.m7437m()).isEmpty() || composerFragment.bS.getShouldPostToMarketplace())) {
                                GroupsSalePostMarketplaceInfoDialogFragment groupsSalePostMarketplaceInfoDialogFragment = new GroupsSalePostMarketplaceInfoDialogFragment();
                                String valueOf = String.valueOf(composerFragment.aS.m7443s().targetId);
                                groupsSalePostMarketplaceInfoDialogFragment.ao = marketplaceCrossPostSettingModel;
                                groupsSalePostMarketplaceInfoDialogFragment.ap = groupsSalePostMarketplaceInfoDialogFragment.ao.interceptAcceptButtonLabel;
                                groupsSalePostMarketplaceInfoDialogFragment.aq = groupsSalePostMarketplaceInfoDialogFragment.ao.interceptDeclineButtonLabel;
                                groupsSalePostMarketplaceInfoDialogFragment.as = true;
                                groupsSalePostMarketplaceInfoDialogFragment.at = valueOf;
                                groupsSalePostMarketplaceInfoDialogFragment.am = new OnClickListener(composerFragment) {
                                    final /* synthetic */ ComposerFragment f6126a;

                                    {
                                        this.f6126a = r1;
                                    }

                                    public void onClick(View view) {
                                        int a = Logger.a(2, EntryType.UI_INPUT_START, 1138340144);
                                        this.f6126a.bS.setIsPostToMarketplaceChecked(true);
                                        ComposerFragment.m7537a(this.f6126a, this.f6126a.aY.f6314j);
                                        ComposerFragment.bA(this.f6126a);
                                        Logger.a(2, EntryType.UI_INPUT_END, 524141566, a);
                                    }
                                };
                                groupsSalePostMarketplaceInfoDialogFragment.an = new OnClickListener(composerFragment) {
                                    final /* synthetic */ ComposerFragment f6127a;

                                    {
                                        this.f6127a = r1;
                                    }

                                    public void onClick(View view) {
                                        int a = Logger.a(2, EntryType.UI_INPUT_START, -1635419767);
                                        this.f6127a.bS.setIsPostToMarketplaceChecked(false);
                                        ComposerFragment.m7537a(this.f6127a, 0);
                                        ComposerFragment.bA(this.f6127a);
                                        Logger.a(2, EntryType.UI_INPUT_END, 203974595, a);
                                    }
                                };
                                groupsSalePostMarketplaceInfoDialogFragment.a(composerFragment.kO_(), "FOR_SALE_POST_TO_MARKETPLACE_INFO");
                                obj = 1;
                            }
                        }
                        if (obj == null) {
                            bA(composerFragment);
                        }
                    }
                }
            }
        }
    }

    private void bz() {
        int i = 1;
        if (this.bA.a(ExperimentsForFacecastAbtestModule.q, false)) {
            if (Camera.getNumberOfCameras() <= 1) {
                i = 0;
            }
            if (this.aS.m7429e().facecastCameraIndex != -1) {
                i = -1;
            }
            TransactionImpl b = this.aU.m7630b(cn);
            ComposerFacecastInfo.Builder builder = new ComposerFacecastInfo.Builder(this.aS.m7429e());
            builder.a = i;
            b.m7691b(builder.a()).m7689a();
            return;
        }
        m7583j(true);
    }

    private void m7583j(boolean z) {
        String valueOf;
        MinutiaeTag a = MinutiaeObject.a(this.aS.m7436l());
        Intent intent = new Intent(getContext(), FacecastActivity.class);
        FacecastCompositionData.Builder builder = new FacecastCompositionData.Builder();
        builder.a = this.aS.ae().a();
        builder = builder;
        builder.b = this.aS.ag().b;
        builder = builder;
        builder.c = this.aS.m7443s();
        FacecastCompositionData.Builder builder2 = builder;
        if (this.aS.m7431g().a() != null) {
            valueOf = String.valueOf(this.aS.m7431g().j());
        } else {
            valueOf = null;
        }
        builder2.d = valueOf;
        builder = builder2;
        builder.e = a.ogActionTypeId;
        builder = builder;
        builder.f = a.ogObjectId;
        builder = builder;
        builder.g = a.ogIconId;
        builder = builder;
        builder.h = a.ogPhrase;
        builder = builder;
        builder.i = ComposerTagUtil.a(this.aS.m7432h());
        builder = builder;
        builder.j = TopicFeedsHelper.a(this.aS);
        builder = builder;
        builder.k = this.aS.m7439o().getLaunchLoggingParams().getSourceSurface();
        builder = builder;
        builder.m = this.aS.m7404E();
        intent.putExtras(FacecastActivity.a(builder.a(), this.aS.m7429e(), z));
        if (this.aS.m7440p() != null) {
            intent.putExtra("com.facebook.orca.auth.OVERRIDDEN_VIEWER_CONTEXT", this.aS.m7440p().getPostAsPageViewerContext());
        }
        ((SecureContextHelper) this.bP.get()).a(intent, 128, this);
    }

    public static void bA(ComposerFragment composerFragment) {
        boolean z;
        composerFragment.bk.c();
        User user = (User) composerFragment.f6142a.get();
        composerFragment.aU.m7630b(cn).m7667a(ComposerSessionLoggingData.a(composerFragment.aS.m7426b()).setCompositionDuration(composerFragment.bB()).a()).m7689a();
        String d = (composerFragment.aS.m7440p() == null || composerFragment.aS.m7440p().getPostAsPageViewerContext() == null) ? user.d() : composerFragment.aS.m7440p().getPostAsPageViewerContext().a();
        String d2 = (composerFragment.aS.m7441q() == null || composerFragment.aS.m7441q().shareable == null) ? null : composerFragment.aS.m7441q().shareable.d();
        ComposerAnalyticsLogger composerAnalyticsLogger = composerFragment.bJ;
        String ab = composerFragment.aS.ab();
        ComposerSourceType sourceType = composerFragment.aS.m7439o().getSourceType();
        ComposerType composerType = composerFragment.aS.m7439o().getComposerType();
        TargetType targetType = composerFragment.aS.m7443s().targetType;
        long j = composerFragment.aS.m7443s().targetId;
        Multiset b = composerFragment.bz.b();
        ImmutableMap a = composerFragment.cE.m7708a();
        String composerContentType = composerFragment.aS.m7427c().toString();
        int bs = composerFragment.bs();
        if (composerFragment.aS.m7439o().getInitialStickerData() != null) {
            z = true;
        } else {
            z = false;
        }
        composerAnalyticsLogger.a(ab, sourceType, composerType, targetType, j, b, a, composerContentType, bs, z, d, StringLengthHelper.a(composerFragment.aS.ae().a()), composerFragment.bS.getPayloadAttachmentFormats(), composerFragment.bS.getPayloadAttachmentSources(), d2);
        ((CreativeEditingAnalyticsLogger) composerFragment.dc.get()).b(composerFragment.aS.ab(), composerFragment.aS.m7437m().size());
        if (composerFragment.aS.m7427c() == ComposerContentType.SLIDESHOW) {
            composerFragment.bL.a(composerFragment.aS.ab(), composerFragment.aS.m7437m().size());
        }
        composerFragment.aU.m7627a(ComposerEvent.ON_USER_POST, cn);
        if (composerFragment.aS.m7429e().facecastCameraIndex != -1) {
            composerFragment.aU.m7627a(ComposerEvent.ON_LAUNCH_FACECAST, cn);
            composerFragment.m7583j(false);
            return;
        }
        Intent a2;
        if (AttachmentUtils.i(composerFragment.aS.m7437m())) {
            composerFragment.bK.c();
        }
        String c = composerFragment.aS.m7431g().c();
        if (c != null) {
            composerFragment.bJ.a(composerFragment.aS.ab(), c);
        }
        composerFragment.au().m7391a();
        composerFragment.bS.m8426f();
        aB(composerFragment).c();
        if (composerFragment.aS.m7431g().e() || composerFragment.aS.m7431g().l()) {
            composerFragment.bH.m8103c(false);
        } else if (composerFragment.aS.m7431g().a() != null) {
            composerFragment.bH.m8103c(true);
        }
        Getter z2 = composerFragment.aL.z();
        if (z2 == null) {
            OptimisticPostHelper a3 = composerFragment.cg.a(composerFragment.aS, composerFragment.aL.g());
            if (composerFragment.aS.m7439o().isEdit()) {
                a2 = composerFragment.ce.a(composerFragment.aS, a3).a();
            } else {
                a2 = composerFragment.cd.a(composerFragment.aS, composerFragment.cf.a(composerFragment.aS), a3).b();
            }
        } else {
            a2 = (Intent) z2.a();
        }
        if (composerFragment.aS.m7439o().getReactionUnitId() != null) {
            a2.putExtra("reaction_unit_id", composerFragment.aS.m7439o().getReactionUnitId());
        }
        if (composerFragment.aS.m7439o().isFireAndForget() && !a2.getBooleanExtra("is_uploading_media", false)) {
            a2.putExtra("extra_actor_viewer_context", composerFragment.aS.m7440p() != null ? composerFragment.aS.m7440p().getPostAsPageViewerContext() : null);
            ((SecureContextHelper) composerFragment.bP.get()).c(ComposerPublishService.a(composerFragment.getContext(), a2), composerFragment.getContext());
        }
        composerFragment.bD();
        if (composerFragment.aS.m7439o().getComposerType() == ComposerType.STATUS && composerFragment.aS.m7439o().getInitialShareParams() == null) {
            a2.putExtra("try_show_survey_on_result_extra_data", composerFragment.bC());
            a2.putExtra("try_show_survey_on_result_integration_point_id", "1573843042880095");
        }
        composerFragment.ao().setResult(-1, a2);
        ((ComposerSavedSessionController) composerFragment.bI.get()).m8251c();
        composerFragment.ao().finish();
        composerFragment.bo = true;
        composerFragment.cg();
    }

    private long bB() {
        return (((Clock) this.aX.get()).a() / 1000) - (this.aU.f6187f.f6759q / 1000);
    }

    private Bundle bC() {
        Bundle bundle = new Bundle();
        ComposerSurveyConstraintGenerator a = this.bg.m8268a(this.aS);
        ProvidesAttachments providesAttachments = (ProvidesAttachments) Preconditions.checkNotNull(a.f6945b.get());
        Map hashMap = new HashMap();
        if (!(((ProvidesPluginSurveyConstraintGetter) providesAttachments).av() == null || ((ProvidesPluginSurveyConstraintGetter) providesAttachments).av().a() == null)) {
            hashMap.putAll((Map) ((ProvidesPluginSurveyConstraintGetter) providesAttachments).av().a());
        }
        if (AttachmentUtils.k(providesAttachments.m())) {
            hashMap.put("photo_added", "1");
        }
        SelectablePrivacyData selectablePrivacyData = ((ProvidesPrivacyData) providesAttachments).ag().b;
        Object obj;
        if (ComposerTagUtil.a(Long.parseLong(((User) a.f6944a.get()).a), ((ProvidesTaggedUsers) providesAttachments).h(), ((ProvidesTextWithEntities) providesAttachments).ae(), providesAttachments.m()).isEmpty()) {
            obj = null;
        } else {
            obj = 1;
        }
        if (!(selectablePrivacyData == null || PrivacyOptionHelper.a(selectablePrivacyData.d) != GraphQLPrivacyOptionType.FRIENDS || r5 == null)) {
            hashMap.put("privacy_friends_and_tagged", "1");
        }
        hashMap.put("session_id", ((ProvidesSessionId) providesAttachments).ab());
        Iterator it = ImmutableMap.copyOf(hashMap).entrySet().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            bundle.putString((String) entry.getKey(), (String) entry.getValue());
        }
        return bundle;
    }

    private void bD() {
        if (this.aS.ag().b != null && this.aS.ag().b.c && !this.aS.m7439o().isEdit()) {
            BooleanGetter booleanGetter = this.aL.t;
            if (booleanGetter == null || booleanGetter.a()) {
                GraphQLPrivacyOptionBuilder a = GraphQLPrivacyOptionBuilder.a(this.aS.ag().b.d);
                GraphQLPrivacyOption graphQLPrivacyOption = this.aS.ag().b.d;
                if (!(graphQLPrivacyOption.G_() == null || graphQLPrivacyOption.G_().isEmpty() || graphQLPrivacyOption.E_() == graphQLPrivacyOption.G_().get(0))) {
                    a.a.d = (GraphQLPrivacyOptionTagExpansionType) graphQLPrivacyOption.G_().get(0);
                }
                ((PrivacyOperationsClient) this.bE.get()).a(a.b());
            }
        }
    }

    private int bE() {
        return this.aS.ae().a().replace(" ", "").length();
    }

    public final boolean m7601e() {
        return this.bs || ((MonotonicClock) this.as.get()).now() - this.bt > this.bu;
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 196072641);
        TipManager tipManager = this.am;
        tipManager.a(false);
        tipManager.i = true;
        Iterator it = this.am.f.iterator();
        while (it.hasNext()) {
            ((ComposerTip) it.next()).a();
        }
        this.bS.m8407a();
        this.aU.m7627a(ComposerEvent.ON_DESTROY_VIEW, cn);
        super.mY_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 811750021, a);
    }

    public final void m7594I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1281925078);
        ComposerPerformanceLogger composerPerformanceLogger = this.bk;
        composerPerformanceLogger.c.a(917512, "ComposerActionButtonPressed");
        composerPerformanceLogger.c.a(917513, "ComposerSelectedPrivacyAvailable");
        composerPerformanceLogger.d.d(ComposerPerformanceLogger.b);
        composerPerformanceLogger.e.a();
        ((CheckinSearchResultsLoader) this.bH.f6675f.get()).b();
        ((FaceBoxPrioritizer) this.bC.get()).j = null;
        ((FaceBoxPrioritizer) this.bC.get()).b();
        this.bz.c();
        this.aJ.m8229a(this.aS.ab());
        if (!this.aN) {
            this.au.b(this.aS.ab());
            this.av.b(this.aS.ab());
        }
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1609077544, a);
    }

    private void m7551a(String str, boolean z) {
        if (z && ((ComposerCompostDraftController) this.aw.get()).m7779a(this.aS)) {
            ((ComposerCompostDraftController) this.aw.get()).m7778a(new Object(this) {
                public final /* synthetic */ ComposerFragment f6130a;

                {
                    this.f6130a = r1;
                }

                public final void m7523a() {
                    ComposerFragment.m7585k(this.f6130a, true);
                }

                public final Context m7524c() {
                    return this.f6130a.getContext();
                }
            }, this.aS);
        } else {
            CharSequence charSequence;
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.a(true);
            if (this.aL.G != null) {
                charSequence = (String) this.aL.G.a();
            } else {
                charSequence = b(2131234587);
            }
            builder.a(charSequence);
            builder.b(str);
            builder.a(this.aL.E != null ? (String) this.aL.E.a() : b(2131234584), new DialogInterface.OnClickListener(this) {
                final /* synthetic */ ComposerFragment f6131a;

                {
                    this.f6131a = r1;
                }

                public void onClick(DialogInterface dialogInterface, int i) {
                    ComposerFragment.m7585k(this.f6131a, false);
                    dialogInterface.dismiss();
                }
            });
            if (this.aL.D != null) {
                charSequence = (String) this.aL.D.a();
            } else {
                charSequence = b(2131234594);
            }
            builder.b(charSequence, new DialogInterface.OnClickListener(this) {
                final /* synthetic */ ComposerFragment f6132a;

                {
                    this.f6132a = r1;
                }

                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            builder.a(new OnDismissListener(this) {
                final /* synthetic */ ComposerFragment f6133a;

                {
                    this.f6133a = r1;
                }

                public void onDismiss(DialogInterface dialogInterface) {
                    ComposerFragment composerFragment = this.f6133a;
                    composerFragment.bJ.b(Events.COMPOSER_DISCARD_DIALOG_DISMISSED, composerFragment.aS.ab(), composerFragment.aS.m7443s().targetId, composerFragment.aS.m7439o().getComposerType());
                    if (this.f6133a.o() != null) {
                        this.f6133a.o().setRequestedOrientation(-1);
                    }
                }
            });
            builder.a().show();
            if (jW_().getConfiguration().orientation == 2) {
                o().setRequestedOrientation(6);
            } else {
                o().setRequestedOrientation(7);
            }
        }
        this.bJ.b(Events.COMPOSER_DISCARD_DIALOG_DISPLAYED, this.aS.ab(), this.aS.m7443s().targetId, this.aS.m7439o().getComposerType());
    }

    public static void m7585k(ComposerFragment composerFragment, boolean z) {
        Intent b;
        if (composerFragment.aS.m7439o().isEdit()) {
            composerFragment.bJ.a(composerFragment.aS.ab(), composerFragment.cE.m7708a(), composerFragment.aS.m7427c().toString(), composerFragment.aS.m7439o().getSourceType(), composerFragment.aS.m7439o().getComposerType(), composerFragment.aS.m7443s().targetId, composerFragment.bs(), composerFragment.aS.m7439o().getInitialStickerData() != null, composerFragment.bS.getPayloadAttachmentFormats(), z);
        } else {
            boolean z2;
            ComposerAnalyticsLogger composerAnalyticsLogger = composerFragment.bJ;
            String ab = composerFragment.aS.ab();
            int bE = composerFragment.bE();
            long j = composerFragment.aS.m7443s().targetId;
            long j2 = composerFragment.bQ;
            Multiset b2 = composerFragment.bz.b();
            boolean z3 = composerFragment.aS.ag().e;
            ComposerType composerType = composerFragment.aS.m7439o().getComposerType();
            int Z = composerFragment.aS.m7423Z();
            if (composerFragment.aS.m7437m().isEmpty()) {
                z2 = false;
            } else {
                z2 = true;
            }
            composerAnalyticsLogger.a(ab, bE, j, j2, b2, z3, composerType, Z, z2, composerFragment.m7601e(), composerFragment.cV.m7748c(), composerFragment.cV.m7747b(), composerFragment.cV.m7746a(), composerFragment.cE.m7708a(), composerFragment.aS.m7427c().toString(), composerFragment.bs());
        }
        ((CreativeEditingAnalyticsLogger) composerFragment.dc.get()).c(composerFragment.aS.ab(), composerFragment.aS.m7437m().size());
        composerFragment.au().m7394b();
        composerFragment.bS.m8427g();
        composerFragment.aU.m7627a(ComposerEvent.ON_USER_CANCEL, cn);
        ((UploadManager) composerFragment.bM.get()).a(composerFragment.aS.ab());
        Intent intent = new Intent();
        if (z) {
            b = ((ComposerCompostDraftController) composerFragment.aw.get()).m7780b(composerFragment.aS);
        } else if (composerFragment.aS.m7439o().getComposerType() == ComposerType.STATUS && composerFragment.aS.m7439o().getInitialShareParams() == null) {
            intent.putExtra("try_show_survey_on_result_extra_data", composerFragment.bC());
            intent.putExtra("try_show_survey_on_result_integration_point_id", "1437658533199157");
            b = intent;
        } else {
            b = intent;
        }
        Getter l = composerFragment.aL.l();
        if (l != null) {
            b.putExtras((Bundle) l.a());
        }
        composerFragment.ao().setResult(0, b);
        bX(composerFragment);
        composerFragment.ao().finish();
    }

    private boolean bH() {
        ImmutableSet cd = cd(this);
        if (this.aS.ag() == null || this.aS.ag().b == null || this.aS.ag().b.d == null || this.aS.ag().b.d.g().isEmpty() || cd.isEmpty()) {
            return false;
        }
        ImmutableList g = this.aS.ag().b.d.g();
        ImmutableList.Builder builder = new ImmutableList.Builder();
        int size = g.size();
        for (int i = 0; i < size; i++) {
            GraphQLPrivacyAudienceMember graphQLPrivacyAudienceMember = (GraphQLPrivacyAudienceMember) g.get(i);
            if (cd.contains(Long.valueOf(Long.parseLong(graphQLPrivacyAudienceMember.c())))) {
                builder.c(graphQLPrivacyAudienceMember);
            }
        }
        ImmutableList b = builder.b();
        if (b.isEmpty()) {
            return false;
        }
        m7565d(b);
        return true;
    }

    private void m7565d(ImmutableList<GraphQLPrivacyAudienceMember> immutableList) {
        CharSequence a;
        if (immutableList.size() == 1) {
            a = a(2131234749, new Object[]{((GraphQLPrivacyAudienceMember) immutableList.get(0)).d()});
        } else if (immutableList.size() == 2) {
            a = a(2131234750, new Object[]{((GraphQLPrivacyAudienceMember) immutableList.get(0)).d(), ((GraphQLPrivacyAudienceMember) immutableList.get(1)).d()});
        } else {
            a = a(2131234751, new Object[]{((GraphQLPrivacyAudienceMember) immutableList.get(0)).d(), Integer.valueOf(immutableList.size() - 1)});
        }
        new FbAlertDialogBuilder(getContext()).b(a).a(true).a(b(2131230726), new DialogInterface.OnClickListener(this) {
            final /* synthetic */ ComposerFragment f6135a;

            {
                this.f6135a = r1;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                ComposerFragment.bA(this.f6135a);
            }
        }).b(b(2131230727), new DialogInterface.OnClickListener(this) {
            final /* synthetic */ ComposerFragment f6134a;

            {
                this.f6134a = r1;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).a().show();
    }

    public static void bJ(ComposerFragment composerFragment) {
        if (composerFragment.aS.m7415Q()) {
            ((WithTagPerformanceLogger) composerFragment.bl.get()).a();
            composerFragment.m7547a(Events.COMPOSER_FRIEND_TAG_CLICK, UIElements.b);
            Intent a;
            if (composerFragment.aS.m7443s().targetType == TargetType.GROUP) {
                ImmutableList.Builder builder = ImmutableList.builder();
                ImmutableList h = composerFragment.aS.m7432h();
                int size = h.size();
                for (int i = 0; i < size; i++) {
                    ComposerTaggedUser composerTaggedUser = (ComposerTaggedUser) h.get(i);
                    builder.c(new FacebookProfile(composerTaggedUser.a(), composerTaggedUser.b(), composerTaggedUser.c(), 0));
                }
                a = ProfilesListActivity.a(composerFragment.getContext(), composerFragment.aS.m7443s().targetId, builder.b(), composerFragment.aS.ab());
                ((WithTagPerformanceLogger) composerFragment.bl.get()).c();
                composerFragment.a(a, 1);
                return;
            }
            Set hashSet = new HashSet(ComposerTagUtil.a(composerFragment.aS.m7432h()));
            hashSet.remove(Long.valueOf(composerFragment.cj()));
            a = FriendSuggestionsAndSelectorActivity.a(composerFragment.getContext(), hashSet, AttachmentUtils.e(composerFragment.aS.m7437m()), composerFragment.bK);
            a.putExtra("extra_composer_internal_session_id", composerFragment.aS.ab());
            composerFragment.m7574h(a);
            ((FaceBoxPrioritizer) composerFragment.bC.get()).e();
            composerFragment.bs = true;
            if (composerFragment.aS.m7431g().a() == null && composerFragment.aS.m7437m().isEmpty() && composerFragment.aS.m7432h().isEmpty() && composerFragment.aS.m7400A() && composerFragment.aS.m7430f() != null) {
                PeopleToPlaceController peopleToPlaceController = (PeopleToPlaceController) composerFragment.bV.get();
                Object obj = 1;
                if (!(peopleToPlaceController.e.a() || peopleToPlaceController.c.c() || (peopleToPlaceController.f != null && peopleToPlaceController.f.h))) {
                    obj = null;
                }
                if (obj != null) {
                    a.putExtra("tag_place_after_tag_people", true);
                    a.putExtra("search_type", composerFragment.bR());
                }
            }
            ((WithTagPerformanceLogger) composerFragment.bl.get()).c();
            composerFragment.a(a, 5);
        }
    }

    private void m7574h(Intent intent) {
        Getter getter = this.aL.U;
        if (getter != null) {
            intent.putStringArrayListExtra("people_tagging_metadata", new ArrayList((Collection) getter.a()));
        }
    }

    public static void bK(ComposerFragment composerFragment) {
        Object obj;
        boolean z;
        ViewerContext postAsPageViewerContext = composerFragment.aS.m7443s().targetType == TargetType.PAGE ? ((ComposerPageData) Preconditions.checkNotNull(composerFragment.aS.m7440p())).getPostAsPageViewerContext() : null;
        Context context = composerFragment.getContext();
        String ab = composerFragment.aS.ab();
        ComposerTargetData s = composerFragment.aS.m7443s();
        GraphQLAlbum ad = composerFragment.aS.ad();
        if (AttachmentUtils.i(composerFragment.aS.f6035s.m7481a().f6745c.getAttachments())) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj == null) {
            z = true;
        } else {
            z = false;
        }
        composerFragment.a(AlbumSelectorActivity.m7352a(context, ab, postAsPageViewerContext, s, ad, z), 13);
    }

    public static void bL(ComposerFragment composerFragment) {
        ((NavigationLogger) composerFragment.ap.get()).a("tap_composer_footer_buttons");
        composerFragment.bJ.a(Events.COMPOSER_FACECAST_CLICK, composerFragment.aS.ab());
        composerFragment.bz();
    }

    public static void bM(ComposerFragment composerFragment) {
        composerFragment.m7547a(Events.COMPOSER_ADD_LOCATION_CLICK, UIElements.a);
        composerFragment.m7587l(false);
    }

    public static void bN(ComposerFragment composerFragment) {
        composerFragment.m7547a(Events.COMPOSER_ADD_LOCATION_CLICK, UIElements.a);
        composerFragment.m7587l(true);
    }

    private void m7587l(boolean z) {
        boolean z2;
        PlacePickerConfiguration.Builder newBuilder = PlacePickerConfiguration.newBuilder();
        newBuilder.p = bR();
        newBuilder = newBuilder;
        newBuilder.e = this.aS.ab();
        newBuilder = newBuilder;
        newBuilder.c = this.aS.m7439o();
        newBuilder = newBuilder;
        if (this.aS.m7436l() == null && this.aS.m7409J()) {
            z2 = true;
        } else {
            z2 = false;
        }
        newBuilder.s = z2;
        newBuilder = newBuilder;
        newBuilder.a = this.aS.m7431g().a();
        newBuilder = newBuilder;
        newBuilder.y = this.aS.m7431g().c();
        newBuilder = newBuilder;
        newBuilder.d = this.aS.m7430f();
        newBuilder = newBuilder;
        newBuilder.t = z;
        newBuilder = newBuilder;
        newBuilder.g = this.aS.aF();
        PlacePickerConfiguration.Builder builder = newBuilder;
        Location a = AttachmentUtils.a(this.aS.m7437m(), (MediaItemMetaDataExtractor) this.bn.get());
        if (AttachmentUtils.k(this.aS.m7437m()) && a != null) {
            a.toString();
            builder.o = ComposerLocation.a(a);
        }
        if (this.aS.m7415Q() && this.aS.m7432h().isEmpty() && this.aS.m7431g().a() == null && this.aS.m7437m().isEmpty()) {
            builder.v = true;
            Getter getter = this.aL.U;
            if (getter != null) {
                builder.n = (ImmutableList) getter.a();
            }
        }
        this.bH.m8102a(a != null);
        ((PlacesPerformanceLogger) this.cb.get()).b();
        ((SecureContextHelper) this.bP.get()).a(CheckinIntentCreator.a(getContext(), builder.a()), 2, this);
    }

    public static void bP(ComposerFragment composerFragment) {
        PlacePickerConfiguration.Builder newBuilder = PlacePickerConfiguration.newBuilder();
        newBuilder.p = composerFragment.bR();
        newBuilder = newBuilder;
        newBuilder.e = composerFragment.aS.ab();
        PlacePickerConfiguration.Builder builder = newBuilder;
        ProductItemPlace productItemPlace = composerFragment.aY.f6313i;
        if (productItemPlace != null) {
            Location location = new Location("");
            location.setLatitude(productItemPlace.latitude);
            location.setLongitude(productItemPlace.longitude);
            builder.o = ComposerLocation.a(location);
            builder.k = productItemPlace.name;
        } else {
            builder.d = composerFragment.aS.m7430f();
            String charSequence = composerFragment.bS.getStructuredLocationText().toString();
            if (!Strings.isNullOrEmpty(charSequence)) {
                builder.y = charSequence;
            }
        }
        ((SecureContextHelper) composerFragment.bP.get()).a(CheckinIntentCreator.a(composerFragment.getContext(), builder.a()), 10, composerFragment);
    }

    private SearchType bR() {
        Getter getter = this.aL.J;
        if (getter != null) {
            return (SearchType) getter.a();
        }
        if (AttachmentUtils.k(this.aS.m7437m())) {
            return SearchType.PHOTO;
        }
        if (AttachmentUtils.i(this.aS.m7437m())) {
            return SearchType.VIDEO;
        }
        if (this.aS.m7439o().getInitialLocationInfo().k()) {
            return SearchType.CHECKIN;
        }
        return SearchType.STATUS;
    }

    public static void bT(ComposerFragment composerFragment) {
        List list = null;
        MinutiaeVerbPickerPerformanceLogger minutiaeVerbPickerPerformanceLogger = (MinutiaeVerbPickerPerformanceLogger) composerFragment.aF.get();
        minutiaeVerbPickerPerformanceLogger.c(4390913, "minutiae_verb_picker_time_to_init");
        minutiaeVerbPickerPerformanceLogger.c(4390915, "minutiae_verb_picker_time_to_fetch_end");
        minutiaeVerbPickerPerformanceLogger.c(4390923, "minutiae_verb_picker_time_to_verbs_shown");
        composerFragment.bJ.a(Events.COMPOSER_MINUTIAE_CLICK, composerFragment.aS.ab());
        CheckinPlaceModel a = composerFragment.aS.m7431g().a();
        if (!(a == null || a.g() == null)) {
            CheckinPlaceModel.Builder builder = new CheckinPlaceModel.Builder();
            CheckinPlaceModel a2 = CheckinPlaceModel.a(a);
            CheckinPlaceModel.Builder builder2 = new CheckinPlaceModel.Builder();
            builder2.a = a2.b();
            builder2.b = a2.n();
            builder2.c = a2.o();
            builder2.d = a2.ce_();
            builder2.e = a2.p();
            builder2.f = a2.cf_();
            builder2.g = a2.q();
            builder2.h = a2.j();
            builder2.i = a2.r();
            builder2.j = a2.l();
            builder2.k = a2.m();
            builder = builder2;
            builder.e = null;
            a = builder.a();
            composerFragment.aU.m7630b(cn).m7692b(ComposerLocationInfo.a(composerFragment.aS.m7431g()).a(a).b()).m7689a();
        }
        Context context = composerFragment.getContext();
        MinutiaeObject l = composerFragment.aS.m7436l();
        String ab = composerFragment.aS.ab();
        ComposerConfiguration o = composerFragment.aS.m7439o();
        if (composerFragment.bG != null) {
            list = composerFragment.bG.m7772g();
        }
        Intent a3 = MinutiaeIntentHelper.a(context, l, ab, o, a, list, false);
        if (!(composerFragment.aS.m7440p() == null || composerFragment.aS.m7440p().getPostAsPageViewerContext() == null)) {
            a3.putExtra("com.facebook.orca.auth.OVERRIDDEN_VIEWER_CONTEXT", composerFragment.aS.m7440p().getPostAsPageViewerContext());
        }
        ((SecureContextHelper) composerFragment.bP.get()).a(a3, 4, composerFragment);
    }

    public static void bV(ComposerFragment composerFragment) {
        composerFragment.bJ.a(Events.COMPOSER_PUBLISH_MODE_SELECTOR_CLICK, composerFragment.aS.ab());
        composerFragment.a(PublishModeSelectorActivity.a(composerFragment.o(), composerFragment.aS.m7434j(), composerFragment.aS.m7437m(), composerFragment.aS.m7422Y()), 14);
    }

    public static void bW(ComposerFragment composerFragment) {
        if (!(composerFragment.aS.m7436l() == null || composerFragment.aS.m7405F())) {
            composerFragment.bS.setMinutiaeUri(composerFragment.aS.m7436l().a());
        }
        if (composerFragment.bi != null) {
            if (!composerFragment.aS.m7439o().isEdit() || composerFragment.aS.m7439o().isEditTagEnabled()) {
                composerFragment.bi.m7623a(composerFragment.cj(), composerFragment.aS.m7432h(), composerFragment.aS.m7431g().a(), composerFragment.aS.m7431g().c(), composerFragment.aS.m7436l(), composerFragment.by);
            } else {
                composerFragment.bi.m7625a(Long.valueOf(composerFragment.cj()), composerFragment.aS.m7431g().a(), composerFragment.aS.m7431g().c(), composerFragment.aS.m7432h(), composerFragment.aS.m7436l());
            }
        }
    }

    public final boolean ar() {
        if (this.aU.f6187f.f6756n) {
            ((PostCompositionView) this.bU.a()).m7656a();
            return false;
        }
        boolean z = !((FbNetworkManager) this.bN.get()).d();
        if (this.cV.m7748c()) {
            if (this.aS.m7407H()) {
                bg(this);
                return false;
            }
            String str;
            if (this.aL.F != null) {
                str = (String) this.aL.F.a();
            } else if (this.aS.m7439o().isEdit()) {
                str = b(2131234583);
            } else if (this.aS.m7444u()) {
                str = b(2131234582);
            } else if (z) {
                str = b(2131234580);
            } else {
                str = b(2131234579);
            }
            m7551a(str, true);
            return false;
        } else if (z) {
            m7551a(b(2131234580), false);
            return false;
        } else {
            boolean z2;
            this.bp.a(new Intent().setAction("backFromComposer").putExtra("backFromComposer", true));
            Intent putParcelableArrayListExtra = new Intent().putParcelableArrayListExtra("extra_media_items", Lists.a(AttachmentUtils.e(this.aS.m7437m())));
            Getter getter = this.aL.P;
            if (getter != null) {
                putParcelableArrayListExtra.putExtras((Bundle) getter.a());
            }
            ao().setResult(0, putParcelableArrayListExtra);
            bX(this);
            ComposerAnalyticsLogger composerAnalyticsLogger = this.bJ;
            String ab = this.aS.ab();
            ImmutableMap a = this.cE.m7708a();
            String composerContentType = this.aS.m7427c().toString();
            ComposerSourceType sourceType = this.aS.m7439o().getSourceType();
            ComposerType composerType = this.aS.m7439o().getComposerType();
            long j = this.aS.m7443s().targetId;
            int bs = bs();
            if (this.aS.m7439o().getInitialStickerData() != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            composerAnalyticsLogger.a(ab, a, composerContentType, sourceType, composerType, j, bs, z2, this.bS.getPayloadAttachmentFormats(), false);
            ((CreativeEditingAnalyticsLogger) this.dc.get()).c(this.aS.ab(), this.aS.m7437m().size());
            au().m7394b();
            this.bS.m8427g();
            this.aU.m7627a(ComposerEvent.ON_USER_CANCEL, cn);
            return true;
        }
    }

    public static void bX(ComposerFragment composerFragment) {
        ((ComposerSavedSessionController) composerFragment.bI.get()).m8252d();
        aB(composerFragment).b();
    }

    private void m7547a(Events events, String str) {
        if (events != null) {
            this.bJ.a(events, this.aS.ab());
        }
        this.bK.f(str);
    }

    private void m7589n(int i, Intent intent) {
        m7547a(Events.COMPOSER_ATTACH_MEDIA_CLICK, UIElements.d);
        this.bS.m8424d();
        this.bK.e(this.aS.m7439o().getComposerType().analyticsName);
        a(intent, i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void bZ(com.facebook.composer.activity.ComposerFragment r9) {
        /*
        r2 = r9.aS;
        r2 = r2.m7437m();
        r2 = com.facebook.composer.attachments.AttachmentUtils.e(r2);
        r3 = new com.facebook.ipc.simplepicker.SimplePickerLauncherConfiguration$Builder;
        r4 = com.facebook.ipc.simplepicker.SimplePickerSource.COMPOSER_ADD_MORE_MEDIA;
        r3.<init>(r4);
        r4 = com.facebook.ipc.simplepicker.SimplePickerLauncherConfiguration.Action.NONE;
        r3 = r3.a(r4);
        r2 = r3.a(r2);
        r2 = r2.o();
        r2 = r2.g();
        r2 = r2.p();
        r2 = r2.q();
        r3 = r9.aS;
        r3 = r3.ax();
        r4 = com.facebook.composer.capability.ComposerPhotoCapability.Capability.ALLOW_SINGLE_PHOTO_ONLY;
        if (r3 != r4) goto L_0x0038;
    L_0x0035:
        r2.h();
    L_0x0038:
        r3 = r9.aS;
        r3 = r3.ad();
        if (r3 == 0) goto L_0x0067;
    L_0x0040:
        r3 = r9.aS;
        r5 = r3.f6025i;
        r5 = r5.get();
        r5 = (com.facebook.composer.capability.ComposerAlbumCapability) r5;
        r6 = r3.f6035s;
        r6 = r6.m7481a();
        r6 = r6.f6747e;
        r6 = r6.targetType;
        r7 = r3.f6035s;
        r7 = r7.m7481a();
        r7 = r7.f6745c;
        r7 = r7.getTargetAlbum();
        r5 = r5.a(r6, r7);
        r3 = r5;
        if (r3 == 0) goto L_0x008f;
    L_0x0067:
        r3 = r9.aS;
        r3 = r3.m7434j();
        r4 = com.facebook.ipc.composer.model.PublishMode.SAVE_DRAFT;
        if (r3 == r4) goto L_0x008f;
    L_0x0071:
        r3 = r9.aL;
        r5 = r3.v;
        r3 = r5;
        if (r3 == 0) goto L_0x0083;
    L_0x0078:
        r3 = r9.aL;
        r5 = r3.v;
        r3 = r5;
        r3 = r3.a();
        if (r3 == 0) goto L_0x008f;
    L_0x0083:
        r3 = r9.aS;
        r3 = r3.m7439o();
        r3 = r3.isEdit();
        if (r3 == 0) goto L_0x0092;
    L_0x008f:
        r2.i();
    L_0x0092:
        r3 = r9.aS;
        r3 = r3.m7410K();
        if (r3 == 0) goto L_0x009d;
    L_0x009a:
        r2.b();
    L_0x009d:
        r3 = r9.aS;
        r3 = r3.m7443s();
        r3 = r3.a();
        if (r3 == 0) goto L_0x00ac;
    L_0x00a9:
        r2.k();
    L_0x00ac:
        r3 = r9.aS;
        r5 = r3.f6030n;
        r5.get();
        r6 = r3.m7443s();
        r5 = r3.m7437m();
        r5 = r5.isEmpty();
        if (r5 != 0) goto L_0x013a;
    L_0x00c1:
        r5 = 1;
    L_0x00c2:
        r7 = r3.f6035s;
        r7 = r7.m7482b();
        r8 = r7.M;
        r7 = r8;
        r8 = r6.b();
        if (r8 == 0) goto L_0x013c;
    L_0x00d1:
        if (r5 != 0) goto L_0x013c;
    L_0x00d3:
        if (r7 == 0) goto L_0x00db;
    L_0x00d5:
        r8 = r7.a();
        if (r8 == 0) goto L_0x013c;
    L_0x00db:
        r8 = 1;
    L_0x00dc:
        r5 = r8;
        r3 = r5;
        if (r3 == 0) goto L_0x00e3;
    L_0x00e0:
        r2.c();
    L_0x00e3:
        r3 = r9.aS;
        r3 = r3.m7439o();
        r3 = r3.getShouldPickerSupportLiveCamera();
        if (r3 == 0) goto L_0x00f2;
    L_0x00ef:
        r2.e();
    L_0x00f2:
        r3 = r9.aS;
        r5 = r3.f6029m;
        r5 = r5.get();
        r5 = (com.facebook.composer.capability.ComposerSlideshowCapability) r5;
        r6 = r3.m7443s();
        r6 = r6.a();
        r5 = r5.a(r6);
        r3 = r5;
        if (r3 == 0) goto L_0x0110;
    L_0x010b:
        r3 = 3;
        r4 = 7;
        r2.a(r3, r4);
    L_0x0110:
        r3 = r9.aS;
        r3 = r3.m7427c();
        r4 = com.facebook.ipc.composer.model.ComposerContentType.SLIDESHOW;
        if (r3 != r4) goto L_0x0124;
    L_0x011a:
        r3 = 1;
        r5 = r2.d;
        r6 = r5.s;
        com.google.common.base.Preconditions.checkState(r6);
        r5.v = r3;
    L_0x0124:
        r0 = r2;
        r2 = r9.getContext();
        r3 = r9.aS;
        r3 = r3.ab();
        r2 = com.facebook.ipc.simplepicker.SimplePickerIntent.a(r2, r0, r3);
        r0 = r2;
        r1 = 127; // 0x7f float:1.78E-43 double:6.27E-322;
        r9.m7589n(r1, r0);
        return;
    L_0x013a:
        r5 = 0;
        goto L_0x00c2;
    L_0x013c:
        r8 = 0;
        goto L_0x00dc;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.composer.activity.ComposerFragment.bZ(com.facebook.composer.activity.ComposerFragment):void");
    }

    private AttachmentsViewEventListener cb() {
        return new AttachmentsViewEventListener(this) {
            final /* synthetic */ ComposerFragment f6137a;

            {
                this.f6137a = r1;
            }

            public final void m7528a(ComposerAttachment composerAttachment, @Nullable FaceBox faceBox) {
                ComposerFragment composerFragment = this.f6137a;
                MediaItem b = composerAttachment.b();
                if (composerFragment.aS.m7407H()) {
                    ComposerFragment.bg(composerFragment);
                } else if (composerFragment.aS.m7427c() == ComposerContentType.SLIDESHOW) {
                    ((SecureContextHelper) composerFragment.bP.get()).a(SlideshowEditIntentCreator.a(composerFragment.ao(), SlideshowEditConfiguration.newBuilder().setMediaItems(AttachmentUtils.e(composerFragment.aS.m7437m())).setSource(Source.SLIDESHOW_ATTACHMENT_EDIT).setSessionId(composerFragment.aS.ab()).setSlideshowData(ComposerSlideshowData.a(composerFragment.aS.aB()).a()).a()), 130, composerFragment);
                } else {
                    switch (AnonymousClass92.f6140b[b.m().ordinal()]) {
                        case 1:
                            if (!composerFragment.aS.m7439o().isEdit()) {
                                if (composerFragment.aS.m7415Q()) {
                                    Intent putExtra = new Intent(composerFragment.getContext(), TaggableGalleryActivity.class).putParcelableArrayListExtra("extra_taggable_gallery_photo_list", new ArrayList(AttachmentUtils.b(composerFragment.aS.m7437m()))).putParcelableArrayListExtra("extras_taggable_gallery_creative_editing_data_list", AttachmentUtils.c(composerFragment.aS.m7437m())).putExtra("extra_taggable_gallery_photo_item_id", b.d()).putExtra("extra_session_id", composerFragment.aS.ab()).putExtra("extra_media_container_type", TargetType.convertToObjectType(composerFragment.aS.m7443s().targetType)).putExtra("extra_media_container_id", String.valueOf(composerFragment.aS.m7443s().targetId));
                                    if (faceBox != null) {
                                        putExtra.putExtra("extra_taggable_gallery_goto_facebox", faceBox);
                                    }
                                    composerFragment.bJ.a(Events.COMPOSER_PHOTO_THUMBNAIL_CLICKED, composerFragment.aS.ab());
                                    composerFragment.a(putExtra, 126);
                                    return;
                                }
                                ComposerFragment.bZ(composerFragment);
                                return;
                            }
                            return;
                        case 2:
                            if (!MediaItem.a.equals(b.i())) {
                                composerFragment.bJ.a(Events.COMPOSER_VIDEO_THUMBNAIL_CLICKED, composerFragment.aS.ab());
                                composerFragment.a(new Intent(composerFragment.ao(), ProductionVideoGalleryActivity.class).putExtra("extra_session_id", composerFragment.aS.ab()).putExtra("extra_source", TaggableGalleryConstants.Source.COMPOSER.ordinal()).putExtra("extra_video_uri", b.f()));
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                }
            }

            public final void m7527a(ComposerAttachment composerAttachment) {
                MediaItem b = composerAttachment.b();
                if (this.f6137a.aS.m7427c() == ComposerContentType.SLIDESHOW) {
                    this.f6137a.aU.m7630b(ComposerFragment.cn).m7676a(null).m7689a();
                    ComposerFragment.m7543a(this.f6137a, RegularImmutableList.a, true, true);
                    return;
                }
                if (b != null) {
                    switch (AnonymousClass92.f6140b[b.m().ordinal()]) {
                        case 1:
                            this.f6137a.bJ.a(this.f6137a.aS.ab(), composerAttachment.b().d().toString(), false);
                            break;
                        case 2:
                            this.f6137a.bJ.a(this.f6137a.aS.ab(), composerAttachment.b().d().toString(), true);
                            break;
                    }
                }
                Collection<Object> arrayList = new ArrayList(AttachmentUtils.a(this.f6137a.aS.m7437m()));
                for (Object obj : arrayList) {
                    if (obj.b() != null && obj.b().d().equals(composerAttachment.b().d())) {
                        arrayList.remove(obj);
                        ComposerFragment.m7543a(this.f6137a, ImmutableList.copyOf(arrayList), true, false);
                    }
                }
                ComposerAttachment composerAttachment2 = composerAttachment;
                arrayList.remove(obj);
                ComposerFragment.m7543a(this.f6137a, ImmutableList.copyOf(arrayList), true, false);
            }

            public final void m7526a(int i, ComposerAttachment composerAttachment, boolean z, boolean z2) {
                Collection arrayList = new ArrayList(AttachmentUtils.a(this.f6137a.aS.m7437m()));
                arrayList.set(i, composerAttachment);
                ComposerFragment composerFragment = this.f6137a;
                ImmutableList copyOf = ImmutableList.copyOf(arrayList);
                boolean z3 = z || z2;
                ComposerFragment.m7543a(composerFragment, copyOf, z3, z2);
                if (this.f6137a.aS.m7408I() && !this.f6137a.aS.m7407H() && composerAttachment.g() != null && composerAttachment.g().hasFaceboxes() && !this.f6137a.bS.hasFocus() && this.f6137a.bA.a(ExperimentsForComposerAbTestModule.z, false)) {
                    ComposerFragment.m7559b(this.f6137a, true);
                }
            }

            public final void m7525a() {
                ComposerFragment.bZ(this.f6137a);
            }

            public final void m7529b() {
                this.f6137a.aU.m7627a(ComposerEvent.ON_PHOTO_AUTO_ENHANCED, ComposerFragment.cn);
            }

            public final void m7530c() {
                this.f6137a.aU.m7627a(ComposerEvent.ON_FIRST_PHOTO_BITMAP_LOADED, ComposerFragment.cn);
            }
        };
    }

    private void m7553a(Provider<User> provider, Provider<MinutiaeVerbsFetcher> provider2, Provider<Boolean> provider3, Provider<AnalyticsLogger> provider4, com.facebook.inject.Lazy<ComposerService> lazy, TipManagerProvider tipManagerProvider, ComposerIntentParser composerIntentParser, AnalyticsTagger analyticsTagger, com.facebook.inject.Lazy<NavigationLogger> lazy2, BlueServiceOperationFactory blueServiceOperationFactory, MetaTextBuilderDelegate metaTextBuilderDelegate, com.facebook.inject.Lazy<MonotonicClock> lazy3, GatekeeperStore gatekeeperStore, TagStore tagStore, FaceBoxStore faceBoxStore, com.facebook.inject.Lazy<ComposerCompostDraftController> lazy4, ComposerTargetSelectorControllerProvider composerTargetSelectorControllerProvider, com.facebook.inject.Lazy<AndroidThreadUtil> lazy5, AudienceEducatorControllerProvider audienceEducatorControllerProvider, com.facebook.inject.Lazy<InlinePrivacySurveyController> lazy6, com.facebook.inject.Lazy<AutoTaggingHelper> lazy7, com.facebook.inject.Lazy<MinutiaeVerbPickerPerformanceLogger> lazy8, com.facebook.inject.Lazy<ComposerScreenSizeUtil> lazy9, com.facebook.inject.Lazy<PhotoSequences> lazy10, com.facebook.inject.Lazy<MinutiaeIconPickerIntentHelper> lazy11, ComposerInstanceTracker composerInstanceTracker, ComposerPrivacyControllerProvider composerPrivacyControllerProvider, LinearComposerNextButtonTipControllerProvider linearComposerNextButtonTipControllerProvider, PlatformAttributionLaunchHelper platformAttributionLaunchHelper, com.facebook.inject.Lazy<PublishModeTitleGenerator> lazy12, ComposerDataProviderImplProvider composerDataProviderImplProvider, ComposerMutatorImplProvider composerMutatorImplProvider, FbObjectMapper fbObjectMapper, com.facebook.inject.Lazy<Clock> lazy13, ComposerSellControllerProvider composerSellControllerProvider, ComposerFb4aTitleBarControllerProvider composerFb4aTitleBarControllerProvider, LinearComposerPhotoButtonControllerProvider linearComposerPhotoButtonControllerProvider, ComposerRedSpaceControllerProvider composerRedSpaceControllerProvider, ComposerRedSpaceSubtitleControllerProvider composerRedSpaceSubtitleControllerProvider, ComposerFeedOnlyPostControllerProvider composerFeedOnlyPostControllerProvider, ComposerTransliterationControllerProvider composerTransliterationControllerProvider, ComposerSurveyConstraintGeneratorProvider composerSurveyConstraintGeneratorProvider, ComposerPerformanceLogger composerPerformanceLogger, com.facebook.inject.Lazy<WithTagPerformanceLogger> lazy14, com.facebook.inject.Lazy<AudienceSelectorPerformanceLogger> lazy15, com.facebook.inject.Lazy<MediaItemMetaDataExtractor> lazy16, FbBroadcastManager fbBroadcastManager, TaggingProfiles taggingProfiles, com.facebook.inject.Lazy<PreFilledTagLogger> lazy17, TasksManager tasksManager, QeAccessor qeAccessor, com.facebook.inject.Lazy<PhotoTagExtractor> lazy18, com.facebook.inject.Lazy<FaceBoxPrioritizer> lazy19, ComposerAttachmentsAutoTaggingController composerAttachmentsAutoTaggingController, com.facebook.inject.Lazy<PrivacyOperationsClient> lazy20, RidgeComposerControllerProvider ridgeComposerControllerProvider, com.facebook.inject.Lazy<ComposerSavedSessionController> lazy21, ComposerAnalyticsLogger composerAnalyticsLogger, PhotoFlowLogger photoFlowLogger, SlideshowLogger slideshowLogger, com.facebook.inject.Lazy<UploadManager> lazy22, com.facebook.inject.Lazy<FbNetworkManager> lazy23, com.facebook.inject.Lazy<FbErrorReporter> lazy24, com.facebook.inject.Lazy<SecureContextHelper> lazy25, com.facebook.inject.Lazy<PeopleToPlaceController> lazy26, ComposerFeedAttachmentManagerProvider composerFeedAttachmentManagerProvider, LegacyComposerFeedAttachmentManagerProvider legacyComposerFeedAttachmentManagerProvider, com.facebook.inject.Lazy<VaultDataFetcher> lazy27, ExecutorService executorService, com.facebook.inject.Lazy<PlacesPerformanceLogger> lazy28, com.facebook.inject.Lazy<GroupCommerceSellComposerIntercept> lazy29, PublishStatusHelperProvider publishStatusHelperProvider, PublishEditHelperProvider publishEditHelperProvider, PublishAttachmentsHelperProvider publishAttachmentsHelperProvider, OptimisticPostHelperProvider optimisticPostHelperProvider, ActionItemListControllerProvider actionItemListControllerProvider, ComposerStickerControllerProvider composerStickerControllerProvider, ComposerLocationProductsPresenterProvider composerLocationProductsPresenterProvider, ComposerHintControllerProvider composerHintControllerProvider, InlineSproutsQeWrapper inlineSproutsQeWrapper, InlineSproutsControllerProvider inlineSproutsControllerProvider, LoadingPrivacyPillViewControllerProvider loadingPrivacyPillViewControllerProvider, ImplicitLocationPillControllerProvider implicitLocationPillControllerProvider, PagePublishOptionPillControllerProvider pagePublishOptionPillControllerProvider, TagExpansionPillViewControllerProvider tagExpansionPillViewControllerProvider, FixedPrivacyPillViewControllerProvider fixedPrivacyPillViewControllerProvider, SelectablePrivacyPillViewControllerProvider selectablePrivacyPillViewControllerProvider, SelectablePrivacyPillViewUsingBaseTokenControllerProvider selectablePrivacyPillViewUsingBaseTokenControllerProvider, ComposerHeaderViewControllerProvider composerHeaderViewControllerProvider, AlbumPillControllerProvider albumPillControllerProvider, MediaItemFactory mediaItemFactory, ComposerTopicControllerProvider composerTopicControllerProvider, ActivityRuntimePermissionsManagerProvider activityRuntimePermissionsManagerProvider, AttachmentCountByContentTypeControllerProvider attachmentCountByContentTypeControllerProvider, LegacyFeedAttachmentAdapterProvider legacyFeedAttachmentAdapterProvider, ReactionComposerManagerProvider reactionComposerManagerProvider, com.facebook.inject.Lazy<Toaster> lazy30, com.facebook.inject.Lazy<UnderwoodLogger> lazy31, ComposerSubmitEnabledControllerProvider composerSubmitEnabledControllerProvider, FooterElementsListFactoryProvider footerElementsListFactoryProvider, MinutiaeAttachmentControllerProvider minutiaeAttachmentControllerProvider, GifComposerAttachmentControllerProvider gifComposerAttachmentControllerProvider, GifComposerAttachmentProvider gifComposerAttachmentProvider, FacecastComposerAttachmentControllerProvider facecastComposerAttachmentControllerProvider, ShareComposerAttachmentControllerProvider shareComposerAttachmentControllerProvider, com.facebook.inject.Lazy<CreativeEditingAnalyticsLogger> lazy32, CheckinPreviewAttachmentControllerProvider checkinPreviewAttachmentControllerProvider, IndicatorBarController indicatorBarController, ZeroDialogController zeroDialogController, ComposerShortcutUtil composerShortcutUtil) {
        this.f6142a = provider;
        this.f6143b = provider2;
        this.f6144c = provider3;
        this.f6145d = provider4;
        this.f6151i = lazy;
        this.al = tipManagerProvider;
        this.an = composerIntentParser;
        this.ao = analyticsTagger;
        this.ap = lazy2;
        this.aq = blueServiceOperationFactory;
        this.ar = metaTextBuilderDelegate;
        this.as = lazy3;
        this.at = gatekeeperStore;
        this.au = tagStore;
        this.av = faceBoxStore;
        this.aw = lazy4;
        this.ay = composerTargetSelectorControllerProvider;
        this.az = lazy5;
        this.aA = audienceEducatorControllerProvider;
        this.aC = lazy6;
        this.aD = lazy7;
        this.aF = lazy8;
        this.aG = lazy9;
        this.aH = lazy10;
        this.aI = lazy11;
        this.aJ = composerInstanceTracker;
        this.aK = composerPrivacyControllerProvider;
        this.aO = linearComposerNextButtonTipControllerProvider;
        this.aP = platformAttributionLaunchHelper;
        this.aQ = lazy12;
        this.aR = composerDataProviderImplProvider;
        this.aT = composerMutatorImplProvider;
        this.aV = fbObjectMapper;
        this.aX = lazy13;
        this.aZ = composerSellControllerProvider;
        this.ba = composerFb4aTitleBarControllerProvider;
        this.bb = linearComposerPhotoButtonControllerProvider;
        this.bc = composerRedSpaceControllerProvider;
        this.bd = composerRedSpaceSubtitleControllerProvider;
        this.be = composerFeedOnlyPostControllerProvider;
        this.bf = composerTransliterationControllerProvider;
        this.bg = composerSurveyConstraintGeneratorProvider;
        this.bk = composerPerformanceLogger;
        this.bl = lazy14;
        this.bm = lazy15;
        this.bn = lazy16;
        this.bp = fbBroadcastManager;
        this.bq = taggingProfiles;
        this.br = lazy17;
        this.bz = tasksManager;
        this.bA = qeAccessor;
        this.bB = lazy18;
        this.bC = lazy19;
        this.bD = composerAttachmentsAutoTaggingController;
        this.bE = lazy20;
        this.bF = ridgeComposerControllerProvider;
        this.bI = lazy21;
        this.bJ = composerAnalyticsLogger;
        this.bK = photoFlowLogger;
        this.bL = slideshowLogger;
        this.bM = lazy22;
        this.bN = lazy23;
        this.bO = lazy24;
        this.bP = lazy25;
        this.bV = lazy26;
        this.bW = composerFeedAttachmentManagerProvider;
        this.bX = legacyComposerFeedAttachmentManagerProvider;
        this.bZ = lazy27;
        this.ca = executorService;
        this.cb = lazy28;
        this.cc = lazy29;
        this.cd = publishStatusHelperProvider;
        this.ce = publishEditHelperProvider;
        this.cf = publishAttachmentsHelperProvider;
        this.cg = optimisticPostHelperProvider;
        this.ch = actionItemListControllerProvider;
        this.cj = composerStickerControllerProvider;
        this.cl = composerLocationProductsPresenterProvider;
        this.cm = composerHintControllerProvider;
        this.cp = inlineSproutsQeWrapper;
        this.cq = inlineSproutsControllerProvider;
        this.cr = loadingPrivacyPillViewControllerProvider;
        this.cs = implicitLocationPillControllerProvider;
        this.ct = pagePublishOptionPillControllerProvider;
        this.cu = tagExpansionPillViewControllerProvider;
        this.cv = fixedPrivacyPillViewControllerProvider;
        this.cw = selectablePrivacyPillViewControllerProvider;
        this.cx = selectablePrivacyPillViewUsingBaseTokenControllerProvider;
        this.cy = composerHeaderViewControllerProvider;
        this.cA = albumPillControllerProvider;
        this.cB = mediaItemFactory;
        this.cC = composerTopicControllerProvider;
        this.cD = activityRuntimePermissionsManagerProvider;
        this.cF = attachmentCountByContentTypeControllerProvider;
        this.cG = legacyFeedAttachmentAdapterProvider;
        this.cO = reactionComposerManagerProvider;
        this.cQ = lazy30;
        this.cT = lazy31;
        this.cU = composerSubmitEnabledControllerProvider;
        this.cW = footerElementsListFactoryProvider;
        this.cX = minutiaeAttachmentControllerProvider;
        this.cY = gifComposerAttachmentControllerProvider;
        this.cZ = gifComposerAttachmentProvider;
        this.da = facecastComposerAttachmentControllerProvider;
        this.db = shareComposerAttachmentControllerProvider;
        this.dc = lazy32;
        this.dd = checkinPreviewAttachmentControllerProvider;
        this.df = indicatorBarController;
        this.dg = zeroDialogController;
        this.dL = composerShortcutUtil;
    }

    public static boolean cc(ComposerFragment composerFragment) {
        return !cd(composerFragment).isEmpty();
    }

    public static ImmutableSet cd(ComposerFragment composerFragment) {
        return ComposerTagUtil.a(composerFragment.cj(), composerFragment.aS.m7432h(), composerFragment.aS.ae(), composerFragment.aS.m7437m());
    }

    public static void m7539a(ComposerFragment composerFragment, GraphQLPrivacyOption graphQLPrivacyOption) {
        composerFragment.aU.m7630b(cn).m7669a(graphQLPrivacyOption).m7689a();
    }

    private void m7590o(int i, Intent intent) {
        if (i == -1) {
            PublishMode publishMode = (PublishMode) intent.getSerializableExtra("selectedPublishMode");
            long longExtra = intent.getLongExtra("scheduleTime", 0);
            if (this.aS.m7434j() != publishMode || (this.aS.m7422Y() != null && this.aS.m7422Y().longValue() != longExtra)) {
                this.aU.m7630b(cn).m7678a(publishMode).m7681a(publishMode == PublishMode.SCHEDULE_POST ? Long.valueOf(longExtra) : null).m7689a();
                ComposerAnalyticsLogger composerAnalyticsLogger = this.bJ;
                String ab = this.aS.ab();
                String contentType = publishMode.getContentType();
                ComposerAnalyticsEventBuilder composerAnalyticsEventBuilder = new ComposerAnalyticsEventBuilder("post_options_picker_selected_post_option");
                composerAnalyticsEventBuilder.a.b("post_option_type", contentType);
                composerAnalyticsEventBuilder = composerAnalyticsEventBuilder;
                if (ab != null) {
                    composerAnalyticsEventBuilder.h(ab);
                }
                composerAnalyticsLogger.a.a(composerAnalyticsEventBuilder.a);
                if (!this.aS.m7412N() && !this.aS.m7411L()) {
                    if (publishMode == PublishMode.SCHEDULE_POST) {
                        TextView textView = (TextView) this.bT.a();
                        textView.setVisibility(0);
                        textView.setText(((PublishModeTitleGenerator) this.aQ.get()).a(longExtra));
                        return;
                    }
                    this.bT.c();
                }
            }
        }
    }

    private void m7591p(int i, Intent intent) {
        if (i == -1) {
            ImmutableList copyOf;
            if (intent != null) {
                copyOf = ImmutableList.copyOf((ArrayList) intent.getSerializableExtra("topics"));
            } else {
                copyOf = RegularImmutableList.a;
            }
            this.aU.m7630b(cn).m7695b(this.aS.m7420W(), copyOf).m7689a();
        }
    }

    private boolean m7577h(int i) {
        if (i == -1) {
            bX(this);
            ao().finish();
            return true;
        }
        TransactionImpl b = this.aU.m7630b(cn);
        ComposerFacecastInfo.Builder builder = new ComposerFacecastInfo.Builder(this.aS.m7429e());
        builder.e = true;
        b.m7691b(builder.a()).m7689a();
        return false;
    }

    private void cf() {
        if (this.aS.m7424a() != null && !Strings.isNullOrEmpty(this.aS.m7424a().a())) {
            this.aP.c("on_composer_entered", this.aS.ab(), this.aS.m7424a().a());
        }
    }

    private void cg() {
        if (this.aS.m7424a() != null && !Strings.isNullOrEmpty(this.aS.m7424a().a())) {
            this.aP.c("on_composer_post_published", this.aS.ab(), this.aS.m7424a().a());
        }
    }

    private void ch() {
        boolean z = false;
        if (this.aS.m7439o().getInitialStickerData() == null) {
            if (this.aS.m7439o().getSourceType() == ComposerSourceType.FEED_INLINE) {
                z = true;
            } else if (this.aL.H != null) {
                z = this.aL.H.a();
            } else if (this.aS.m7405F()) {
                z = true;
            } else if (this.aS.m7439o().getComposerType() == ComposerType.STATUS || this.aS.m7439o().getComposerType() == ComposerType.SHARE) {
                z = true;
            }
        }
        if (z && !this.aS.m7405F()) {
            this.bS.setProfilePicture(this.aS.m7443s().actsAsTarget ? this.aS.m7443s().targetProfilePicUrl : ((User) this.f6142a.get()).x());
        }
    }

    private long cj() {
        return Long.parseLong(((User) this.f6142a.get()).a);
    }

    public static void ck(ComposerFragment composerFragment) {
        composerFragment.bJ.a(Events.COMPOSER_TRANSLITERATE_CLICK, composerFragment.aS.ab());
        Intent intent = new Intent(composerFragment.getContext(), TransliterationActivity.class);
        intent.putExtra("composer_text", composerFragment.aS.ae().a());
        intent.putExtra("entry_point", "composer");
        ((SecureContextHelper) composerFragment.bP.get()).a(intent, 11, composerFragment);
    }
}
