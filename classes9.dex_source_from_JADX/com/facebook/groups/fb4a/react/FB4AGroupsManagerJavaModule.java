package com.facebook.groups.fb4a.react;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.api.story.FetchSingleStoryParams.FetchType;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.queryinterface.ProvidesInterface;
import com.facebook.common.util.StringLocaleUtil;
import com.facebook.composer.activity.ComposerLauncherImpl;
import com.facebook.composer.publish.ComposerPublishServiceHelper;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.debug.log.BLog;
import com.facebook.fbreact.instance.FbReactInstanceHolder;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feedback.ui.CommentPhotoPickerUtil;
import com.facebook.groups.constants.GroupMsiteUrls;
import com.facebook.groups.fb4a.react.intent.GeneralGroupsReactFragmentIntentBuilder;
import com.facebook.groups.feed.data.GroupsFeedEvents.PendingPostCountEvent;
import com.facebook.groups.feed.data.GroupsFeedEvents.ReportedPostCountEvent;
import com.facebook.groups.memberlist.intent.GroupMemberActions;
import com.facebook.groups.react.AbstractGroupsManagerJavaModule;
import com.facebook.groups.react.CameraLauncher;
import com.facebook.groups.react.CameraLauncher.C07281;
import com.facebook.groups.react.CameraLauncherProvider;
import com.facebook.groups.react.EditPostLauncher;
import com.facebook.groups.react.EditPostLauncherProvider;
import com.facebook.groups.react.GroupComposerLauncher;
import com.facebook.groups.react.GroupComposerLauncherProvider;
import com.facebook.groups.react.GroupsReactDataFetcherProvider;
import com.facebook.groups.react.PhotoGalleryLauncher;
import com.facebook.groups.react.PhotoGalleryLauncher.C07391;
import com.facebook.groups.react.PhotoGalleryLauncher.C07402;
import com.facebook.groups.react.PhotoGalleryLauncherProvider;
import com.facebook.groups.react.PhotoPickerLauncher;
import com.facebook.groups.react.PhotoPickerLauncherProvider;
import com.facebook.groups.treehouse.perf.TreehousePerfLogger;
import com.facebook.inject.Assisted;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.ipc.composer.intent.DefaultPluginConfigSerializer;
import com.facebook.ipc.composer.intent.EmptyPluginConfig;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.ipc.media.MediaItem;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.mediastorage.MediaStorage;
import com.facebook.photos.base.analytics.constants.PhotoLoggingConstants.FullscreenGallerySource;
import com.facebook.photos.mediafetcher.interfaces.MediaFetcherConstructionRule;
import com.facebook.photos.mediafetcher.query.NodesMediaQueryProvider;
import com.facebook.photos.mediafetcher.query.param.MultiIdQueryParam;
import com.facebook.photos.mediagallery.launcher.MediaGalleryLauncherParams;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.modules.core.RCTNativeAppEventEmitter;
import com.facebook.runtimepermissions.ActivityRuntimePermissionsManagerProvider;
import com.facebook.search.titlebar.GraphSearchTitleSearchBox;
import com.facebook.search.titlebar.GraphSearchTitleSearchBox$OnInitStateLeftListener;
import com.facebook.ufiservices.data.FeedbackLoader;
import com.facebook.ufiservices.util.UfiIntentBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.titlebar.HasTitleBar;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: payments_dialog_fragment */
public class FB4AGroupsManagerJavaModule extends AbstractGroupsManagerJavaModule implements ActivityEventListener {
    public final FbReactInstanceHolder f6890a;
    private final DefaultAndroidThreadUtil f6891b;
    public final GroupPostSearchLauncher f6892c;
    private final Fb4aGroupNavigationLauncherProvider f6893d;
    private final GroupComposerLauncherProvider f6894e;
    private final PhotoGalleryLauncherProvider f6895f;
    private final PhotoPickerLauncherProvider f6896g;
    private final EditPostLauncherProvider f6897h;
    private final CameraLauncherProvider f6898i;
    private final FeedEventBus f6899j;
    private final GeneralGroupsReactFragmentIntentBuilder f6900k;
    private PhotoPickerLauncher f6901l;
    private EditPostLauncher f6902m;
    private CameraLauncher f6903n;

    /* compiled from: payments_dialog_fragment */
    class C07172 implements Runnable {
        final /* synthetic */ FB4AGroupsManagerJavaModule f6882a;

        C07172(FB4AGroupsManagerJavaModule fB4AGroupsManagerJavaModule) {
            this.f6882a = fB4AGroupsManagerJavaModule;
        }

        public void run() {
            this.f6882a.f6890a.c().d();
        }
    }

    @Inject
    public FB4AGroupsManagerJavaModule(@Assisted ReactApplicationContext reactApplicationContext, FbReactInstanceHolder fbReactInstanceHolder, DefaultAndroidThreadUtil defaultAndroidThreadUtil, GroupPostSearchLauncher groupPostSearchLauncher, Fb4aGroupNavigationLauncherProvider fb4aGroupNavigationLauncherProvider, GroupComposerLauncherProvider groupComposerLauncherProvider, PhotoGalleryLauncherProvider photoGalleryLauncherProvider, PhotoPickerLauncherProvider photoPickerLauncherProvider, EditPostLauncherProvider editPostLauncherProvider, CameraLauncherProvider cameraLauncherProvider, FeedEventBus feedEventBus, GeneralGroupsReactFragmentIntentBuilder generalGroupsReactFragmentIntentBuilder) {
        super(reactApplicationContext);
        reactApplicationContext.a(this);
        this.f6890a = fbReactInstanceHolder;
        this.f6891b = defaultAndroidThreadUtil;
        this.f6892c = groupPostSearchLauncher;
        this.f6893d = fb4aGroupNavigationLauncherProvider;
        this.f6894e = groupComposerLauncherProvider;
        this.f6895f = photoGalleryLauncherProvider;
        this.f6896g = photoPickerLauncherProvider;
        this.f6897h = editPostLauncherProvider;
        this.f6899j = feedEventBus;
        this.f6900k = generalGroupsReactFragmentIntentBuilder;
        this.f6898i = cameraLauncherProvider;
    }

    public final Map<String, Object> m7184a() {
        Map hashMap = new HashMap();
        hashMap.put("appContext", "fb4a");
        return hashMap;
    }

    @ReactMethod
    public void groupCommerceGetDisplayPrice(ReadableMap readableMap, Callback callback) {
        BLog.b("RKTreehouseManager", "groupCommerceGetDisplayPrice() not supported yet");
    }

    @ReactMethod
    public void groupHeaderInfoDidUpdate(String str, int i) {
        BLog.b("RKTreehouseManager", "groupHeaderInfoDidUpdate() not supported yet");
    }

    @ReactMethod
    public void willNavigate(String str) {
        BLog.b("RKTreehouseManager", "groupHeaderInfoDidUpdate() not supported yet");
    }

    @ReactMethod
    public void didNavigate(String str) {
        BLog.b("RKTreehouseManager", "groupHeaderInfoDidUpdate() not supported yet");
    }

    @ReactMethod
    public void openURL(String str) {
        Fb4aGroupNavigationLauncher a = this.f6893d.m7195a(q());
        a.f6911g.a(a.f6905a, str);
    }

    @ReactMethod
    public void openVideo(String str) {
        BLog.b("RKTreehouseManager", "groupHeaderInfoDidUpdate() not supported yet");
    }

    @ReactMethod
    public void openPhotoGallery(String str) {
        PhotoGalleryLauncher a = this.f6895f.m7325a(this.a, q());
        a.f7036e.f7049f.a(TreehousePerfLogger.f7046d, false);
        a.f7034c.m7317a(str, FetchType.GRAPHQL_PHOTO_CREATION_STORY, new C07391(a));
    }

    @ReactMethod
    public void openPhotoGalleryWithMultiplePhoto(ReadableArray readableArray, int i) {
        PhotoGalleryLauncher a = this.f6895f.m7325a(this.a, q());
        Preconditions.checkNotNull(readableArray);
        Builder builder = ImmutableList.builder();
        for (int i2 = 0; i2 < readableArray.size(); i2++) {
            builder.c(readableArray.getString(i2));
        }
        MediaGalleryLauncherParams.Builder builder2 = new MediaGalleryLauncherParams.Builder(MediaFetcherConstructionRule.a(NodesMediaQueryProvider.class, new MultiIdQueryParam(builder.b())));
        if (i >= 0 && i < readableArray.size()) {
            builder2.a(readableArray.getString(i));
        }
        builder2.a(FullscreenGallerySource.REACTION_FEED_STORY_PHOTO_ALBUM);
        a.f7032a.runOnUiThread(new C07402(a, builder2));
    }

    @ReactMethod
    public void logEventEnded(String str) {
        BLog.b("RKTreehouseManager", "groupHeaderInfoDidUpdate() not supported yet");
    }

    @ReactMethod
    public void logEventWithDuration(String str, int i) {
        BLog.b("RKTreehouseManager", "logEventWithDuration() not supported yet");
    }

    @ReactMethod
    public void editPost(String str) {
        EditPostLauncherProvider editPostLauncherProvider = this.f6897h;
        ReactApplicationContext reactApplicationContext = this.a;
        this.f6902m = new EditPostLauncher(reactApplicationContext, q(), (GroupsReactDataFetcherProvider) editPostLauncherProvider.getOnDemandAssistedProviderForStaticDi(GroupsReactDataFetcherProvider.class), (ComposerLauncher) ComposerLauncherImpl.a(editPostLauncherProvider), IdBasedSingletonScopeProvider.a(editPostLauncherProvider, 2347), Toaster.b(editPostLauncherProvider), ComposerPublishServiceHelper.b(editPostLauncherProvider), FeedbackLoader.a(editPostLauncherProvider), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(editPostLauncherProvider));
        this.f6902m.m7307a(str);
    }

    @ReactMethod
    public void tappedActorProfile(String str, String str2) {
        BLog.b("RKTreehouseManager", "groupHeaderInfoDidUpdate() not supported yet");
    }

    @ReactMethod
    public void tappedActorProfileInGroup(String str, String str2, String str3) {
        BLog.b("RKTreehouseManager", "groupHeaderInfoDidUpdate() not supported yet");
    }

    @ReactMethod
    public void tappedPageProfile(String str) {
        BLog.b("RKTreehouseManager", "groupHeaderInfoDidUpdate() not supported yet");
    }

    @ReactMethod
    public void openPage(String str) {
        BLog.b("RKTreehouseManager", "groupHeaderInfoDidUpdate() not supported yet");
    }

    @ReactMethod
    public void openGroupSearch(final String str) {
        this.f6891b.a(new Runnable(this) {
            final /* synthetic */ FB4AGroupsManagerJavaModule f6881b;

            public void run() {
                this.f6881b.f6892c.m7198a(str, this.f6881b.q());
            }
        });
    }

    @ReactMethod
    public void openGroupProfile(String str) {
        BLog.b("RKTreehouseManager", "groupHeaderInfoDidUpdate() not supported yet");
    }

    @ReactMethod
    public void openAddMember(String str, String str2, String str3) {
        this.f6893d.m7195a(q()).m7193a(str, str2, str3);
    }

    @ReactMethod
    public void openAllMembers(String str, String str2, boolean z, String str3, String str4) {
        this.f6893d.m7195a(q()).m7194a(str, str2, z, str3, str4);
    }

    @ReactMethod
    public void createGroupChat(String str, String str2, ReadableArray readableArray, int i) {
        this.f6893d.m7195a(q()).m7192a(str);
    }

    @ReactMethod
    public void openComposer(String str, String str2, String str3) {
        GroupComposerLauncher a = this.f6894e.m7313a(this.a, q());
        a.f7006c.a(null, GroupComposerLauncher.m7308a(str, str2, false), 1756, a.f7005b);
    }

    @ReactMethod
    public void openPollComposer(String str, String str2) {
        GroupComposerLauncher a = this.f6894e.m7313a(this.a, q());
        ComposerConfiguration.Builder a2 = ComposerConfiguration.a(GroupComposerLauncher.m7308a(str, str2, false));
        a2.setDisableMentions(true);
        a2.setPluginConfig(new DefaultPluginConfigSerializer().a(EmptyPluginConfig.a("GroupsPollComposerPluginConfig")));
        a.f7006c.a(null, a2.a(), 1756, a.f7005b);
    }

    @ReactMethod
    public void openPhotoComposer(String str, String str2) {
        this.f6894e.m7313a(this.a, q()).m7312c(str, str2);
    }

    @ReactMethod
    public void reportStoryURL(ReadableMap readableMap, Callback callback, Callback callback2) {
        if (StringLocaleUtil.a(FBLinks.cA, new Object[]{readableMap.getString("hideableToken"), readableMap.getString("storyGraphQLID"), readableMap.getString("actionType"), readableMap.getString("storyRenderLocation"), readableMap.getString("trackingCodes")}) != null) {
            callback.a(new Object[]{StringLocaleUtil.a(FBLinks.cA, new Object[]{readableMap.getString("hideableToken"), readableMap.getString("storyGraphQLID"), readableMap.getString("actionType"), readableMap.getString("storyRenderLocation"), readableMap.getString("trackingCodes")})});
            return;
        }
        callback2.a(new Object[0]);
    }

    @ReactMethod
    public void openStoryPermalink(String str, String str2, boolean z, boolean z2) {
        BLog.b("RKTreehouseManager", "groupHeaderInfoDidUpdate() not supported yet");
    }

    @ReactMethod
    public void updateGroupInfoProperty(String str, String str2, int i) {
        if ("pending".equals(str2)) {
            this.f6899j.a(new PendingPostCountEvent(i));
        } else if ("reported".equals(str2)) {
            this.f6899j.a(new ReportedPostCountEvent(i));
        } else {
            throw new JSApplicationIllegalArgumentException("Attempted to update unsupported group info property");
        }
    }

    @ReactMethod
    public void openPhotoPicker(Callback callback) {
        this.f6901l = new PhotoPickerLauncher(q(), CommentPhotoPickerUtil.a(this.f6896g));
        PhotoPickerLauncher photoPickerLauncher = this.f6901l;
        CommentPhotoPickerUtil commentPhotoPickerUtil = photoPickerLauncher.f7039c;
        Context context = photoPickerLauncher.f7038b;
        commentPhotoPickerUtil.c.a(UfiIntentBuilder.a(context, false), 954, context);
        photoPickerLauncher.f7040d = callback;
    }

    @ReactMethod
    public void openCamera(Callback callback) {
        CameraLauncherProvider cameraLauncherProvider = this.f6898i;
        this.f6903n = new CameraLauncher(q(), MediaStorage.a(cameraLauncherProvider), (SecureContextHelper) DefaultSecureContextHelper.a(cameraLauncherProvider), (ActivityRuntimePermissionsManagerProvider) cameraLauncherProvider.getOnDemandAssistedProviderForStaticDi(ActivityRuntimePermissionsManagerProvider.class), Toaster.b(cameraLauncherProvider));
        CameraLauncher cameraLauncher = this.f6903n;
        cameraLauncher.f6986h = cameraLauncher.f6981c.c();
        cameraLauncher.f6985g = callback;
        cameraLauncher.f6982d.a(CameraLauncher.f6979a, new C07281(cameraLauncher));
    }

    @ReactMethod
    public void openAddCoverPhoto(String str, String str2) {
        BLog.b("RKTreehouseManager", "groupHeaderInfoDidUpdate() not supported yet");
    }

    @ReactMethod
    public void logQEExposureLogging(String str) {
        BLog.b("RKTreehouseManager", "groupHeaderInfoDidUpdate() not supported yet");
    }

    @ReactMethod
    public void closeModalWindow() {
        this.f6891b.a(new C07172(this));
    }

    @ReactMethod
    public void didRemoveMember(String str) {
        BLog.b("RKTreehouseManager", "didRemoveMember() not supported yet");
    }

    @ReactMethod
    public void openMessengerComposer(String str) {
        Fb4aGroupNavigationLauncher a = this.f6893d.m7195a(q());
        GroupMemberActions.a(str, a.f6907c, a.f6905a, a.f6906b, a.f6905a);
    }

    @ReactMethod
    public void viewerDidComment(String str) {
        BLog.b("RKTreehouseManager", "viewerDidComment() not supported yet");
    }

    @ReactMethod
    public void viewerDidLike(String str) {
        BLog.b("RKTreehouseManager", "viewerDidLike() not supported yet");
    }

    @ReactMethod
    public void openEvent(String str) {
        Fb4aGroupNavigationLauncher a = this.f6893d.m7195a(q());
        a.f6907c.a(a.f6909e.a(a.f6905a, GroupMsiteUrls.b(str)), a.f6905a);
    }

    @ReactMethod
    public void emitNavigationEvent(String str) {
        BLog.b("RKTreehouseManager", "emitNavigationEvent() not supported yet");
    }

    public final void m7185a(int i, int i2, Intent intent) {
        if (i == 954 && this.f6901l != null) {
            PhotoPickerLauncher photoPickerLauncher = this.f6901l;
            if (photoPickerLauncher.f7040d == null) {
                BLog.a(PhotoPickerLauncher.f7037a, "onPhotoPicked() invoked without pending callback");
                return;
            }
            Callback callback = photoPickerLauncher.f7040d;
            Object[] objArr = new Object[1];
            String str = null;
            MediaItem a = CommentPhotoPickerUtil.a(954, i2, intent);
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            if (i2 == -1) {
                String str2 = "uri";
                if (a.f() != null) {
                    str = a.f().toString();
                }
                writableNativeMap.putString(str2, str);
            } else {
                writableNativeMap.putString("uri", null);
            }
            objArr[0] = writableNativeMap;
            callback.a(objArr);
            photoPickerLauncher.f7040d = null;
        } else if (i2 == -1 && i == 1756) {
            this.f6894e.m7313a(p(), q()).m7311a(i2, intent);
        } else if (i == 1758 && this.f6902m != null) {
            this.f6902m.m7306a(i2, intent);
        } else if (i == 1010 && this.f6903n != null) {
            this.f6903n.m7303a(i2);
        }
    }

    @ReactMethod
    public void setTitleBarConfig(final ReadableMap readableMap) {
        if (q() == null) {
            BLog.b("RKTreehouseManager", "Cannot set titlebar. Current activity is null");
        } else {
            q().runOnUiThread(new Runnable(this) {
                final /* synthetic */ FB4AGroupsManagerJavaModule f6886b;

                /* compiled from: payments_dialog_fragment */
                class C07181 implements GraphSearchTitleSearchBox$OnInitStateLeftListener {
                    final /* synthetic */ C07203 f6883a;

                    C07181(C07203 c07203) {
                        this.f6883a = c07203;
                    }

                    public final void mo30a(String str, String str2) {
                        Object writableNativeMap = new WritableNativeMap();
                        writableNativeMap.putString("text", str2);
                        if (readableMap.hasKey("fromRootTag")) {
                            this.f6883a.f6886b.m7176a("searchBarTextName" + readableMap.getInt("fromRootTag"), writableNativeMap);
                        }
                    }
                }

                /* compiled from: payments_dialog_fragment */
                class C07192 implements OnClickListener {
                    final /* synthetic */ C07203 f6884a;

                    C07192(C07203 c07203) {
                        this.f6884a = c07203;
                    }

                    public void onClick(View view) {
                        int a = Logger.a(2, EntryType.UI_INPUT_START, -912893335);
                        this.f6884a.f6886b.navigateToGeneralReactFragment("FBGroupsHubSearchRoute", null);
                        Logger.a(2, EntryType.UI_INPUT_END, -1633074426, a);
                    }
                }

                public void run() {
                    HasTitleBar r = FB4AGroupsManagerJavaModule.m7183r(this.f6886b);
                    if (r == null) {
                        BLog.b("RKTreehouseManager", "Cannot get title bar in activity:" + this.f6886b.q().getClass().getName());
                    } else if (readableMap == null) {
                        r.setCustomTitle(null);
                        r.a_(null);
                        r.c(true);
                    } else {
                        String string = readableMap.getString("type");
                        boolean z = true;
                        switch (string.hashCode()) {
                            case -1964681502:
                                if (string.equals("clickable")) {
                                    z = true;
                                    break;
                                }
                                break;
                            case 3556653:
                                if (string.equals("text")) {
                                    z = true;
                                    break;
                                }
                                break;
                            case 1602416228:
                                if (string.equals("editable")) {
                                    z = false;
                                    break;
                                }
                                break;
                        }
                        GraphSearchTitleSearchBox graphSearchTitleSearchBox;
                        switch (z) {
                            case false:
                                graphSearchTitleSearchBox = new GraphSearchTitleSearchBox(this.f6886b.q());
                                graphSearchTitleSearchBox.k = new C07181(this);
                                r.setCustomTitle(graphSearchTitleSearchBox);
                                r.c(true);
                                if (!Strings.isNullOrEmpty(readableMap.getString("searchHint"))) {
                                    graphSearchTitleSearchBox.e.setHint(readableMap.getString("searchHint"));
                                }
                                graphSearchTitleSearchBox.e.b();
                                return;
                            case true:
                                graphSearchTitleSearchBox = new GraphSearchTitleSearchBox(this.f6886b.q());
                                if (!Strings.isNullOrEmpty(readableMap.getString("searchHint"))) {
                                    graphSearchTitleSearchBox.e.setHint(readableMap.getString("searchHint"));
                                }
                                graphSearchTitleSearchBox.e.setFocusable(false);
                                graphSearchTitleSearchBox.a(new C07192(this));
                                r.setCustomTitle(graphSearchTitleSearchBox);
                                r.c(true);
                                return;
                            case true:
                                String string2 = readableMap.getString("text");
                                if (!Strings.isNullOrEmpty(string2)) {
                                    r.a_(string2);
                                    r.c(true);
                                    return;
                                }
                                return;
                            default:
                                BLog.b("RKTreehouseManager", "Unknown search bar type: " + readableMap.getString("type"));
                                return;
                        }
                    }
                }
            });
        }
    }

    @ReactMethod
    public void navigateToGeneralReactFragment(String str, String str2) {
        this.f6900k.a(str2, str, q());
    }

    @ReactMethod
    public void openGroupsEdit() {
        BLog.b("RKTreehouseManager", "openGroupEditPage() not supported yet");
    }

    @ReactMethod
    public void createHomescreenShortcut(String str, String str2, String str3) {
        BLog.b("RKTreehouseManager", "createHomescreenShortcut() not supported yet");
    }

    @ReactMethod
    public void openNotificationSettingsPage(String str) {
        BLog.b("RKTreehouseManager", "openNotificationSettingsPage() not supported yet");
    }

    @ReactMethod
    public void leaveGroup(String str, String str2, int i, String str3, String str4, String str5) {
        BLog.b("RKTreehouseManager", "leaveGroup() not supported yet");
    }

    @ReactMethod
    public void openGroupCreateFlow() {
        BLog.b("RKTreehouseManager", "openGroupCreateFlow() not supported yet");
    }

    @ReactMethod
    public void openDiscoverTab() {
        BLog.b("RKTreehouseManager", "openDiscoverTab() not supported yet");
    }

    @ReactMethod
    public void openURI(String str) {
        BLog.b("RKTreehouseManager", "openURI() not supported yet");
    }

    @ReactMethod
    public void switchFeed(boolean z) {
        BLog.b("RKTreehouseManager", "switchFeed() not supported yet");
    }

    @ReactMethod
    public void updateInboxTabs(int i, int i2, int i3, int i4) {
        BLog.b("RKTreehouseManager", "updateInboxTabs() not supported yet");
    }

    @ReactMethod
    public void reloadGroups() {
        BLog.b("RKTreehouseManager", "reloadGroups() not supported yet");
    }

    @ReactMethod
    public void setPagerSwipingEnabled(boolean z) {
        BLog.b("RKTreehouseManager", "setPagerSwipingEnabled() not supported yet");
    }

    public static HasTitleBar m7183r(FB4AGroupsManagerJavaModule fB4AGroupsManagerJavaModule) {
        if (fB4AGroupsManagerJavaModule.q() instanceof ProvidesInterface) {
            return (HasTitleBar) ((ProvidesInterface) fB4AGroupsManagerJavaModule.q()).a(HasTitleBar.class);
        }
        return null;
    }

    private void m7176a(final String str, @Nullable final Object obj) {
        if (q() == null) {
            BLog.b("RKTreehouseManager", "Cannot emit event. Current activity is null");
        } else {
            q().runOnUiThread(new Runnable(this) {
                final /* synthetic */ FB4AGroupsManagerJavaModule f6889c;

                public void run() {
                    ReactContext j = this.f6889c.f6890a.c().j();
                    if (j == null) {
                        BLog.a("FB4AGroupsManagerJavaModule", "Context not available at this moment for event: " + str);
                    }
                    if (j.b()) {
                        ((RCTNativeAppEventEmitter) j.a(RCTNativeAppEventEmitter.class)).emit(str, obj);
                    }
                }
            });
        }
    }
}
