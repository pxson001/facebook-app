package com.facebook.messaging.photos.view;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.internal.widget.ViewStubCompat;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.PopupMenu.OnMenuItemClickListener;
import android.text.Spannable.Factory;
import android.text.SpannableStringBuilder;
import android.view.ContextThemeWrapper;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.FrameLayout;
import android.widget.Gallery;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.LocalBroadcast;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.build.BuildConstants;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.callercontexttagger.AnalyticsTagger;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.ui.util.ViewPositionUtil;
import com.facebook.common.util.ContextUtils;
import com.facebook.common.util.DeviceUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbui.glyph.GlyphButton;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.annotations.IsGlobalMessageDeleteEnabled;
import com.facebook.messaging.annotations.IsTapPhotoToViewAllImagesEnabled;
import com.facebook.messaging.attachments.AttachmentDataFactory;
import com.facebook.messaging.attachments.ImageAttachmentData;
import com.facebook.messaging.attachments.VideoAttachmentData;
import com.facebook.messaging.attachments.VideoAttachmentData.AttachmentType;
import com.facebook.messaging.attachments.VideoAttachmentDataBuilder;
import com.facebook.messaging.chatheads.detect.ChatHeadsContextDetector;
import com.facebook.messaging.forward.MessageForwardHandler;
import com.facebook.messaging.forward.MessageForwardHandler.C04042;
import com.facebook.messaging.fullscreendialog.FullScreenDialogFragment;
import com.facebook.messaging.intents.MessagesBroadcastIntents;
import com.facebook.messaging.media.download.DownloadPhotosParams;
import com.facebook.messaging.media.download.DownloadedMedia;
import com.facebook.messaging.media.download.DownloadedMedia.ResultCode;
import com.facebook.messaging.media.download.MediaDownloadManager;
import com.facebook.messaging.media.download.MediaDownloadManager.5;
import com.facebook.messaging.media.download.PhotoDownloadDestination;
import com.facebook.messaging.media.download.SaveMmsPhotoParams;
import com.facebook.messaging.media.photoquality.PhotoQualityHelper;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.MessageUtil;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.mutators.DeleteMessagesDialogFragment;
import com.facebook.messaging.photos.service.MediaMessageItem;
import com.facebook.messaging.photos.service.PhotoMessageDataCache;
import com.facebook.messaging.photos.tiles.UserTileViewParamsFactory;
import com.facebook.messaging.send.trigger.NavigationTrigger;
import com.facebook.messaging.util.date.MessagingDateUtil;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.runtimepermissions.AbstractRuntimePermissionsListener;
import com.facebook.runtimepermissions.ActivitylessRuntimePermissionsManagerProvider;
import com.facebook.runtimepermissions.RequestPermissionsConfig;
import com.facebook.runtimepermissions.RequestPermissionsConfig.RationaleBehavior;
import com.facebook.runtimepermissions.RequestPermissionsConfigBuilder;
import com.facebook.runtimepermissions.RuntimePermissionsManager;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.ui.emoji.EmojiUtil;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ui.media.attachments.MediaResource.Type;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.user.model.UserKey;
import com.facebook.user.tiles.UserTileView;
import com.facebook.video.engine.VideoDataSource;
import com.facebook.video.engine.VideoDataSourceBuilder;
import com.facebook.widget.ViewStubHolder;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: registration_prefill */
public class PhotoViewFragment extends FullScreenDialogFragment implements AnalyticsFragment {
    private static final String[] aF = new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"};
    private static final RequestPermissionsConfig aG;
    @Inject
    public SharedImageMessageAdapter aA;
    @Inject
    @IsGlobalMessageDeleteEnabled
    public Provider<Boolean> aB;
    @Inject
    public PhotoQualityHelper aC;
    @Inject
    ActivitylessRuntimePermissionsManagerProvider aD;
    @Inject
    public QeAccessor aE;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<MessageForwardHandler> aH = UltralightRuntime.b;
    public Gallery aI;
    public ViewGroup aJ;
    private FrameLayout aK;
    public GestureDetector aL;
    private TextView aM;
    private UserTileView aN;
    private TextView aO;
    private TextView aP;
    private TextView aQ;
    public ImageButton aR;
    private GlyphButton aS;
    private SelfRegistrableReceiverImpl aT;
    public MediaGalleryAdapter aU;
    private PhotoViewMode aV;
    public com.facebook.orca.threadview.ThreadViewMessagesFragment.AnonymousClass10 aW;
    private boolean aX;
    @Nullable
    public ThreadKey aY;
    public Context aZ;
    @Inject
    MessagingDateUtil am;
    @Inject
    EmojiUtil an;
    @Inject
    public MediaDownloadManager ao;
    @Inject
    AnalyticsTagger ap;
    @Inject
    @IsTapPhotoToViewAllImagesEnabled
    public Provider<Boolean> aq;
    @Inject
    public MessageUtil ar;
    @Inject
    SecureContextHelper as;
    @Inject
    @LocalBroadcast
    BaseFbBroadcastManager at;
    @Inject
    AttachmentDataFactory au;
    @Inject
    public Product av;
    @Inject
    UserTileViewParamsFactory aw;
    @Inject
    AbstractFbErrorReporter ax;
    @Inject
    @ForUiThread
    public ExecutorService ay;
    @Inject
    PhotoMessageDataCache az;
    @Nullable
    private RuntimePermissionsManager ba;
    public ViewStubHolder<GlyphView> bb;
    public ViewStubHolder<TextView> bc;
    public GlyphView bd;
    public TextView be;
    private final OnItemSelectedListener bf = new OnItemSelectedListener(this) {
        final /* synthetic */ PhotoViewFragment f3622a;

        {
            this.f3622a = r1;
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            PhotoViewFragment.at(this.f3622a);
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    };
    private final SimpleOnGestureListener bg = new SimpleOnGestureListener(this) {
        final /* synthetic */ PhotoViewFragment f3623a;

        {
            this.f3623a = r1;
        }

        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            boolean z;
            boolean z2 = false;
            if (this.f3623a.aJ.getVisibility() == 0) {
                z = true;
            } else {
                z = false;
            }
            PhotoViewFragment photoViewFragment = this.f3623a;
            if (!z) {
                z2 = true;
            }
            PhotoViewFragment.m3451i(photoViewFragment, z2);
            return true;
        }
    };

    /* compiled from: registration_prefill */
    class C05611 implements OnTouchListener {
        final /* synthetic */ PhotoViewFragment f3624a;

        C05611(PhotoViewFragment photoViewFragment) {
            this.f3624a = photoViewFragment;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (this.f3624a.aR.getVisibility() == 0 && ViewPositionUtil.a(motionEvent, this.f3624a.aR)) {
                return false;
            }
            return this.f3624a.aL.onTouchEvent(motionEvent);
        }
    }

    /* compiled from: registration_prefill */
    class C05622 implements OnClickListener {
        final /* synthetic */ PhotoViewFragment f3625a;

        C05622(PhotoViewFragment photoViewFragment) {
            this.f3625a = photoViewFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1594335826);
            this.f3625a.b();
            Logger.a(2, EntryType.UI_INPUT_END, 715166651, a);
        }
    }

    /* compiled from: registration_prefill */
    class C05633 implements ActionReceiver {
        final /* synthetic */ PhotoViewFragment f3626a;

        C05633(PhotoViewFragment photoViewFragment) {
            this.f3626a = photoViewFragment;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 68483386);
            if (this.f3626a.aI == null) {
                Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 1433495166, a);
                return;
            }
            Message i = ((MediaMessageItem) this.f3626a.aI.getSelectedItem()).i();
            if (i != null) {
                List stringArrayListExtra = intent.getStringArrayListExtra("message_ids");
                List stringArrayListExtra2 = intent.getStringArrayListExtra("offline_threading_ids");
                if (stringArrayListExtra.contains(i.a) || stringArrayListExtra2.contains(i.n)) {
                    this.f3626a.b();
                }
            }
            LogUtils.e(-551857372, a);
        }
    }

    /* compiled from: registration_prefill */
    class C05644 implements OnClickListener {
        final /* synthetic */ PhotoViewFragment f3627a;

        C05644(PhotoViewFragment photoViewFragment) {
            this.f3627a = photoViewFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1659250326);
            PhotoViewFragment photoViewFragment = this.f3627a;
            PopupMenu popupMenu = new PopupMenu(photoViewFragment.aZ, this.f3627a.aR);
            MenuInflater b = popupMenu.b();
            popupMenu.e = new C05688(photoViewFragment);
            b.inflate(2131820572, popupMenu.b);
            MediaMessageItem mediaMessageItem = (MediaMessageItem) photoViewFragment.aI.getSelectedItem();
            Message i = mediaMessageItem.i();
            if (PhotoViewFragment.m3445b(i)) {
                popupMenu.b.removeItem(2131568660);
                popupMenu.b.removeItem(2131568624);
                popupMenu.b.removeItem(2131568661);
                popupMenu.b.removeItem(2131568659);
                if (mediaMessageItem.e().d != Type.PHOTO) {
                    popupMenu.b.removeItem(2131568658);
                }
                popupMenu.c();
            } else {
                if (photoViewFragment.aC.b() && !mediaMessageItem.a() && (mediaMessageItem.b() > 2048 || mediaMessageItem.c() > 2048)) {
                    popupMenu.b.getItem(0).setVisible(true);
                }
                if (mediaMessageItem.e().d != Type.VIDEO) {
                    popupMenu.b.removeItem(2131568659);
                }
                if (mediaMessageItem.e().d != Type.PHOTO) {
                    popupMenu.b.removeItem(2131568660);
                    popupMenu.b.removeItem(2131568658);
                }
                if (i == null || ((Boolean) photoViewFragment.aq.get()).booleanValue()) {
                    popupMenu.b.removeItem(2131568661);
                } else if (!photoViewFragment.ar.P(i) && ((Boolean) photoViewFragment.aB.get()).booleanValue()) {
                    popupMenu.b.findItem(2131568661).setTitle(photoViewFragment.jW_().getText(2131231051));
                }
                if (photoViewFragment.aE.a(ExperimentsForPhotoViewModule.f3588a, false) || !DeviceUtil.a(photoViewFragment.getContext().getPackageManager(), BuildConstants.n())) {
                    popupMenu.b.removeItem(2131568660);
                }
                if (!(i == null || ((MessageForwardHandler) photoViewFragment.aH.get()).m2245a(i))) {
                    popupMenu.b.removeItem(2131568624);
                }
                popupMenu.c();
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1380135824, a);
        }
    }

    /* compiled from: registration_prefill */
    public class C05655 implements OnClickListener {
        final /* synthetic */ PhotoViewFragment f3628a;

        public C05655(PhotoViewFragment photoViewFragment) {
            this.f3628a = photoViewFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 97219163);
            PhotoViewFragment.as(this.f3628a);
            Logger.a(2, EntryType.UI_INPUT_END, -2091625689, a);
        }
    }

    /* compiled from: registration_prefill */
    public class C05666 implements OnClickListener {
        final /* synthetic */ PhotoViewFragment f3629a;

        public C05666(PhotoViewFragment photoViewFragment) {
            this.f3629a = photoViewFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -996015399);
            PhotoViewFragment.as(this.f3629a);
            Logger.a(2, EntryType.UI_INPUT_END, 108029771, a);
        }
    }

    /* compiled from: registration_prefill */
    class C05677 extends AbstractRuntimePermissionsListener {
        final /* synthetic */ PhotoViewFragment f3630a;

        C05677(PhotoViewFragment photoViewFragment) {
            this.f3630a = photoViewFragment;
        }

        public final void m3432a() {
            MediaMessageItem mediaMessageItem = (MediaMessageItem) this.f3630a.aI.getSelectedItem();
            if (mediaMessageItem.e().d == Type.PHOTO) {
                PhotoViewFragment.m3446e(this.f3630a, mediaMessageItem);
            } else if (mediaMessageItem.e().d == Type.VIDEO) {
                PhotoViewFragment.m3448f(this.f3630a, mediaMessageItem);
            }
        }
    }

    /* compiled from: registration_prefill */
    public class C05688 implements OnMenuItemClickListener {
        final /* synthetic */ PhotoViewFragment f3631a;

        public C05688(PhotoViewFragment photoViewFragment) {
            this.f3631a = photoViewFragment;
        }

        public final boolean m3433a(MenuItem menuItem) {
            return PhotoViewFragment.m3447e(this.f3631a, menuItem);
        }
    }

    /* compiled from: registration_prefill */
    public class PhotoViewFragmentBuilder {
        public final Bundle f3635a = new Bundle();

        public final PhotoViewFragmentBuilder m3436a(Message message) {
            this.f3635a.putParcelable("message", message);
            return this;
        }

        public final PhotoViewFragmentBuilder m3435a(ImageAttachmentData imageAttachmentData) {
            this.f3635a.putParcelable("selected_image", imageAttachmentData);
            return this;
        }

        public final PhotoViewFragment m3437a() {
            PhotoViewFragment photoViewFragment = new PhotoViewFragment();
            photoViewFragment.g(this.f3635a);
            return photoViewFragment;
        }
    }

    /* compiled from: registration_prefill */
    public enum PhotoViewMode {
        BACKED_BY_MESSAGE_DATA,
        BACKED_BY_SHARED_IMAGE_LIST
    }

    public static void m3444a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((PhotoViewFragment) obj).m3442a(MessagingDateUtil.a(injectorLike), EmojiUtil.a(injectorLike), MediaDownloadManager.a(injectorLike), AnalyticsTagger.a(injectorLike), IdBasedProvider.a(injectorLike, 4093), MessageUtil.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), AttachmentDataFactory.a(injectorLike), ProductMethodAutoProvider.a(injectorLike), UserTileViewParamsFactory.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), PhotoMessageDataCache.a(injectorLike), SharedImageMessageAdapter.m3474a(injectorLike), IdBasedProvider.a(injectorLike, 4063), PhotoQualityHelper.a(injectorLike), (ActivitylessRuntimePermissionsManagerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ActivitylessRuntimePermissionsManagerProvider.class), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), IdBasedLazy.a(injectorLike, 7858));
    }

    private void m3442a(MessagingDateUtil messagingDateUtil, EmojiUtil emojiUtil, MediaDownloadManager mediaDownloadManager, AnalyticsTagger analyticsTagger, Provider<Boolean> provider, MessageUtil messageUtil, SecureContextHelper secureContextHelper, FbBroadcastManager fbBroadcastManager, AttachmentDataFactory attachmentDataFactory, Product product, UserTileViewParamsFactory userTileViewParamsFactory, FbErrorReporter fbErrorReporter, ExecutorService executorService, PhotoMessageDataCache photoMessageDataCache, SharedImageMessageAdapter sharedImageMessageAdapter, Provider<Boolean> provider2, PhotoQualityHelper photoQualityHelper, ActivitylessRuntimePermissionsManagerProvider activitylessRuntimePermissionsManagerProvider, QeAccessor qeAccessor, com.facebook.inject.Lazy<MessageForwardHandler> lazy) {
        this.am = messagingDateUtil;
        this.an = emojiUtil;
        this.ao = mediaDownloadManager;
        this.ap = analyticsTagger;
        this.aq = provider;
        this.ar = messageUtil;
        this.as = secureContextHelper;
        this.at = fbBroadcastManager;
        this.au = attachmentDataFactory;
        this.av = product;
        this.aw = userTileViewParamsFactory;
        this.ax = fbErrorReporter;
        this.ay = executorService;
        this.az = photoMessageDataCache;
        this.aA = sharedImageMessageAdapter;
        this.aB = provider2;
        this.aC = photoQualityHelper;
        this.aD = activitylessRuntimePermissionsManagerProvider;
        this.aE = qeAccessor;
        this.aH = lazy;
    }

    static {
        RequestPermissionsConfigBuilder requestPermissionsConfigBuilder = new RequestPermissionsConfigBuilder();
        requestPermissionsConfigBuilder.c = RationaleBehavior.ONLY_SHOW_FOR_SETTINGS;
        requestPermissionsConfigBuilder = requestPermissionsConfigBuilder;
        requestPermissionsConfigBuilder.d = true;
        aG = requestPermissionsConfigBuilder.e();
    }

    public static PhotoViewFragmentBuilder aq() {
        return new PhotoViewFragmentBuilder();
    }

    public final void m3454a(@Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 2075815072);
        super.a(bundle);
        int b = ContextUtils.b(getContext(), 2130772869, 2131624670);
        a(2, b);
        this.aZ = new ContextThemeWrapper(getContext(), b);
        Class cls = PhotoViewFragment.class;
        m3444a((Object) this, this.aZ);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -734985038, a);
    }

    public final View m3453a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1253747152);
        View inflate = layoutInflater.cloneInContext(this.aZ).inflate(2130905823, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 452589401, a);
        return inflate;
    }

    public final void m3455a(View view, @Nullable Bundle bundle) {
        Object obj;
        boolean z = false;
        super.a(view, bundle);
        this.bb = ViewStubHolder.a((ViewStubCompat) e(2131565063));
        this.bc = ViewStubHolder.a((ViewStubCompat) e(2131565064));
        Bundle bundle2 = this.s;
        Message message = (Message) bundle2.getParcelable("message");
        this.aY = message != null ? message.b : null;
        this.aI = (Gallery) e(2131565057);
        PhotoViewMode photoViewMode = (PhotoViewMode) bundle2.getSerializable("photo_view_fragment_mode");
        if (photoViewMode == null) {
            photoViewMode = PhotoViewMode.BACKED_BY_MESSAGE_DATA;
        }
        this.aV = photoViewMode;
        if (this.aV == PhotoViewMode.BACKED_BY_SHARED_IMAGE_LIST) {
            this.aX = false;
            m3439a(bundle2, bundle);
        } else {
            ImageAttachmentData imageAttachmentData = (ImageAttachmentData) bundle2.getParcelable("selected_image");
            if (imageAttachmentData == null) {
                b();
                return;
            }
            boolean z2;
            if (!(!((Boolean) this.aq.get()).booleanValue() || this.aY == null || this.au.c(message))) {
                PhotoMessageDataCache photoMessageDataCache = this.az;
                ThreadKey threadKey = this.aY;
                if (!photoMessageDataCache.a.containsKey(threadKey) || ((ImmutableList) photoMessageDataCache.a.get(threadKey)).isEmpty()) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj == null) {
                    z2 = true;
                    this.aX = z2;
                    m3440a(bundle2, message, imageAttachmentData, bundle);
                }
            }
            z2 = false;
            this.aX = z2;
            m3440a(bundle2, message, imageAttachmentData, bundle);
        }
        this.aL = new GestureDetector(this.aZ, this.bg);
        this.aI.setOnTouchListener(new C05611(this));
        this.aI.setOnItemSelectedListener(this.bf);
        this.aJ = (ViewGroup) e(2131564429);
        this.aM = (TextView) e(2131564912);
        this.aN = (UserTileView) e(2131564859);
        this.aO = (TextView) e(2131565061);
        this.aP = (TextView) e(2131565062);
        this.aQ = (TextView) e(2131565059);
        this.aK = (FrameLayout) e(2131565058);
        this.aR = (ImageButton) e(2131565065);
        this.aS = (GlyphButton) e(2131565066);
        if (Build.MANUFACTURER.equals("Amazon") && (Build.MODEL.equals("Kindle Fire") || Build.MODEL.startsWith("KF"))) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null && ChatHeadsContextDetector.a(getContext())) {
            this.aS.setVisibility(0);
            this.aS.setOnClickListener(new C05622(this));
        }
        at(this);
        if (bundle == null || bundle.getBoolean("was_overlay_shown")) {
            z = true;
        }
        m3451i(this, z);
        this.aT = this.at.a().a(MessagesBroadcastIntents.h, new C05633(this)).a();
        this.aT.b();
        this.aR.setOnClickListener(new C05644(this));
        if (((Boolean) this.aq.get()).booleanValue() && this.aV == PhotoViewMode.BACKED_BY_MESSAGE_DATA) {
            this.aK.setVisibility(8);
        }
        this.ap.a(this.aI, "messenger_photo_view", this);
        this.aI.getSelectedItem();
        if (this.aE.a(ExperimentsForPhotoViewModule.f3588a, false) && DeviceUtil.a(getContext().getPackageManager(), BuildConstants.n()) && this.aR.getVisibility() == 0) {
            this.bc.f();
            this.bb.f();
            this.bd = (GlyphView) e(2131567422);
            this.be = (TextView) e(2131567423);
            this.bd.setOnClickListener(new C05655(this));
            this.be.setOnClickListener(new C05666(this));
        }
    }

    public static void as(PhotoViewFragment photoViewFragment) {
        if (photoViewFragment.ba == null) {
            photoViewFragment.ba = photoViewFragment.aD.a(photoViewFragment);
        }
        photoViewFragment.ba.a(aF, aG, new C05677(photoViewFragment));
    }

    public final void m3452I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1816158567);
        if (this.aT != null) {
            this.aT.c();
        }
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1693450944, a);
    }

    public void onDismiss(DialogInterface dialogInterface) {
        if (this.aW != null) {
            this.aW.m7401a();
        }
        super.onDismiss(dialogInterface);
    }

    public final void m3456e(Bundle bundle) {
        bundle.putInt("saved_photo_index", this.aI.getSelectedItemPosition());
        bundle.putBoolean("was_overlay_shown", this.aJ.getVisibility() == 0);
        if (this.aX) {
            bundle.putString("photo_fetch_start_cursor", this.aA.f3651h);
            this.az.a(this.aY, ImmutableList.copyOf(this.aA.f3645b));
        }
    }

    public final String am_() {
        return "messenger_photo_view";
    }

    public static boolean m3445b(Message message) {
        return message != null && ThreadKey.d(message.b);
    }

    public static boolean m3447e(PhotoViewFragment photoViewFragment, MenuItem menuItem) {
        final MediaMessageItem mediaMessageItem = (MediaMessageItem) photoViewFragment.aI.getSelectedItem();
        final Message i = mediaMessageItem.i();
        if (menuItem.getItemId() == 2131568624) {
            MessageForwardHandler messageForwardHandler = (MessageForwardHandler) photoViewFragment.aH.get();
            messageForwardHandler.f2393g.a(new C04042(messageForwardHandler, mediaMessageItem.e(), NavigationTrigger.b("messenger_photo_view")));
            return true;
        } else if (menuItem.getItemId() == 2131568658) {
            if (photoViewFragment.ba == null) {
                photoViewFragment.ba = photoViewFragment.aD.a(photoViewFragment);
            }
            photoViewFragment.ba.a(aF, aG, new AbstractRuntimePermissionsListener(photoViewFragment) {
                final /* synthetic */ PhotoViewFragment f3634c;

                public final void m3434a() {
                    if (PhotoViewFragment.m3445b(i)) {
                        PhotoViewFragment photoViewFragment = this.f3634c;
                        photoViewFragment.ao.a(photoViewFragment.ao.a(new SaveMmsPhotoParams(mediaMessageItem.e().c), CallerContext.a(photoViewFragment.getClass(), "photo_save_photo_view")));
                        return;
                    }
                    photoViewFragment = this.f3634c;
                    photoViewFragment.ao.a(photoViewFragment.ao.a(new DownloadPhotosParams(ImmutableList.of(MediaDownloadManager.a(mediaMessageItem)), PhotoDownloadDestination.GALLERY, false), CallerContext.a(photoViewFragment.getClass(), "photo_save_photo_view")));
                    if (!ThreadKey.g(photoViewFragment.aY)) {
                        photoViewFragment.ao.a(photoViewFragment.getContext());
                    }
                }
            });
            return true;
        } else if (menuItem.getItemId() == 2131568659) {
            if (photoViewFragment.ba == null) {
                photoViewFragment.ba = photoViewFragment.aD.a(photoViewFragment);
            }
            photoViewFragment.ba.a(aF, aG, new AbstractRuntimePermissionsListener(photoViewFragment) {
                final /* synthetic */ PhotoViewFragment f3615b;

                public final void m3431a() {
                    PhotoViewFragment photoViewFragment = this.f3615b;
                    MediaMessageItem mediaMessageItem = mediaMessageItem;
                    VideoDataSourceBuilder newBuilder = VideoDataSource.newBuilder();
                    newBuilder.a = mediaMessageItem.e().c;
                    VideoDataSource i = newBuilder.i();
                    VideoAttachmentDataBuilder newBuilder2 = VideoAttachmentData.newBuilder();
                    newBuilder2.a = AttachmentType.MESSAGE_ATTACHMENT;
                    newBuilder2 = newBuilder2;
                    newBuilder2.g = Arrays.asList(new VideoDataSource[]{i});
                    VideoAttachmentDataBuilder videoAttachmentDataBuilder = newBuilder2;
                    videoAttachmentDataBuilder.j = mediaMessageItem.e().u;
                    photoViewFragment.ao.c(photoViewFragment.ao.a(videoAttachmentDataBuilder.n(), CallerContext.a(photoViewFragment.getClass(), "video_save_video_view")));
                }
            });
            return true;
        } else if (menuItem.getItemId() == 2131568661) {
            DeleteMessagesDialogFragment deleteMessagesDialogFragment = new DeleteMessagesDialogFragment();
            deleteMessagesDialogFragment.m3232a(i);
            deleteMessagesDialogFragment.a(photoViewFragment.s(), "delete_message_dialog_tag");
            return true;
        } else {
            if (menuItem.getItemId() == 2131568660) {
                m3446e(photoViewFragment, mediaMessageItem);
            } else if (menuItem.getItemId() == 2131568657) {
                photoViewFragment.m3441a(mediaMessageItem, menuItem);
            }
            return false;
        }
    }

    private void m3441a(final MediaMessageItem mediaMessageItem, final MenuItem menuItem) {
        ListenableFuture a = this.ao.a(new DownloadPhotosParams(ImmutableList.of(MediaDownloadManager.a(mediaMessageItem)), PhotoDownloadDestination.TEMP, false), CallerContext.a(getClass(), "photo_load_full_image_view"));
        Futures.a(a, new FutureCallback<DownloadedMedia>(this) {
            final /* synthetic */ PhotoViewFragment f3618c;

            public void onSuccess(Object obj) {
                mediaMessageItem.a(((DownloadedMedia) obj).b);
                if (this.f3618c.aU == null) {
                    AdapterDetour.a(this.f3618c.aA, 1498055306);
                } else {
                    AdapterDetour.a(this.f3618c.aU, 1284528011);
                }
                menuItem.setVisible(false);
                mediaMessageItem.a(true);
            }

            public void onFailure(Throwable th) {
            }
        }, this.ay);
        MediaDownloadManager mediaDownloadManager = this.ao;
        Futures.a(a, new 5(mediaDownloadManager), mediaDownloadManager.f);
    }

    public static void m3446e(PhotoViewFragment photoViewFragment, MediaMessageItem mediaMessageItem) {
        photoViewFragment.m3443a(photoViewFragment.ao.a(new DownloadPhotosParams(ImmutableList.of(MediaDownloadManager.a(mediaMessageItem)), PhotoDownloadDestination.TEMP, false), CallerContext.a(photoViewFragment.getClass(), "photo_save_temp_photo_view")), Type.PHOTO);
    }

    public static void m3448f(PhotoViewFragment photoViewFragment, MediaMessageItem mediaMessageItem) {
        VideoDataSourceBuilder newBuilder = VideoDataSource.newBuilder();
        newBuilder.a = mediaMessageItem.e().c;
        VideoDataSource i = newBuilder.i();
        VideoAttachmentDataBuilder newBuilder2 = VideoAttachmentData.newBuilder();
        newBuilder2.a = AttachmentType.MESSAGE_ATTACHMENT;
        newBuilder2 = newBuilder2;
        newBuilder2.g = Arrays.asList(new VideoDataSource[]{i});
        VideoAttachmentDataBuilder videoAttachmentDataBuilder = newBuilder2;
        videoAttachmentDataBuilder.j = mediaMessageItem.e().u;
        photoViewFragment.m3443a(photoViewFragment.ao.a(videoAttachmentDataBuilder.n(), CallerContext.a(photoViewFragment.getClass(), "video_save_video_view")), Type.VIDEO);
    }

    private void m3443a(ListenableFuture<DownloadedMedia> listenableFuture, final Type type) {
        if (type == Type.VIDEO || type == Type.PHOTO) {
            Futures.a(listenableFuture, new FutureCallback<DownloadedMedia>(this) {
                final /* synthetic */ PhotoViewFragment f3620b;

                public void onSuccess(Object obj) {
                    DownloadedMedia downloadedMedia = (DownloadedMedia) obj;
                    if (!this.f3620b.mx_()) {
                        return;
                    }
                    if (downloadedMedia.a.equals(ResultCode.FAILURE)) {
                        this.f3620b.ax.a("PhotoViewFragment", "Could not save media to temp storage for sharing");
                        Toast.makeText(this.f3620b.getContext(), 2131231000, 0).show();
                        return;
                    }
                    Intent intent = new Intent("android.intent.action.SEND");
                    intent.setType(type == Type.VIDEO ? "video/*" : "image/jpeg");
                    intent.setPackage(BuildConstants.n());
                    intent.putExtra("android.intent.extra.STREAM", downloadedMedia.b);
                    this.f3620b.as.b(Intent.createChooser(intent, this.f3620b.b(2131231343)), this.f3620b.getContext());
                }

                public void onFailure(Throwable th) {
                    if (this.f3620b.mx_()) {
                        this.f3620b.ax.a("PhotoViewFragment", "Could not save media to temp storage for sharing", th);
                        Toast.makeText(this.f3620b.getContext(), 2131231000, 0).show();
                    }
                }
            }, this.ay);
        }
    }

    private void m3440a(Bundle bundle, @Nullable Message message, ImageAttachmentData imageAttachmentData, Bundle bundle2) {
        int i = 0;
        int i2;
        if (this.aX) {
            String string;
            PhotoMessageDataCache photoMessageDataCache = this.az;
            ThreadKey threadKey = this.aY;
            Preconditions.checkNotNull(threadKey);
            List<MediaMessageItem> list = (ImmutableList) photoMessageDataCache.a.get(threadKey);
            String str = "";
            if (bundle2 != null) {
                i2 = bundle2.getInt("saved_photo_index");
                string = bundle2.getString("photo_fetch_start_cursor");
            } else {
                int a = m3438a(new DefaultPhotoMessageItem(imageAttachmentData, message), (List) list);
                for (MediaMessageItem e : list) {
                    string = e.e().u;
                    if (string != null) {
                        i2 = a;
                        break;
                    }
                }
                string = str;
                i2 = a;
            }
            this.aA.f3646c = this.aY;
            this.aA.f3651h = string;
            SharedImageMessageAdapter sharedImageMessageAdapter = this.aA;
            sharedImageMessageAdapter.f3645b.addAll(list);
            sharedImageMessageAdapter.f3652i = sharedImageMessageAdapter.f3645b.size();
            this.aI.setAdapter(this.aA);
            this.aI.setSelection(i2, false);
            this.aA.f3648e = new Object(this) {
                public final /* synthetic */ PhotoViewFragment f3621a;

                {
                    this.f3621a = r1;
                }
            };
            return;
        }
        List arrayList = new ArrayList();
        List f;
        if (message != null) {
            f = this.au.f(message);
        } else if (bundle.containsKey("message_image_attachments")) {
            f = bundle.getParcelableArrayList("message_image_attachments");
        } else {
            f = null;
        }
        if (r0 == null || r0.isEmpty()) {
            arrayList.add(new DefaultPhotoMessageItem(imageAttachmentData, message));
            i2 = 0;
        } else {
            i2 = 0;
            for (ImageAttachmentData imageAttachmentData2 : r0) {
                arrayList.add(new DefaultPhotoMessageItem(imageAttachmentData2, message));
                if (imageAttachmentData2.a.a.equals(imageAttachmentData.a.a)) {
                    i2 = i;
                }
                i++;
            }
        }
        this.aU = new MediaGalleryAdapter(getContext(), arrayList, this.D);
        this.aI.setAdapter(this.aU);
        this.aI.setSelection(i2);
    }

    private static int m3438a(MediaMessageItem mediaMessageItem, List<MediaMessageItem> list) {
        int i = 0;
        MediaResource e = mediaMessageItem.e();
        int i2 = e.u != null ? 1 : 0;
        while (i < list.size()) {
            MediaResource e2 = ((MediaMessageItem) list.get(i)).e();
            if (i2 != 0 && e.u.equals(e2.u)) {
                return i;
            }
            if (i2 == 0 && e.c.equals(e2.c)) {
                return i;
            }
            i++;
        }
        return list.size() - 1;
    }

    private void m3439a(Bundle bundle, Bundle bundle2) {
        int i;
        if (bundle2 != null) {
            i = bundle2.getInt("saved_photo_index", bundle.getInt("selection_index", 0));
        } else {
            i = bundle.getInt("selection_index", 0);
        }
        this.aI.setAdapter(new MediaGalleryAdapter(getContext(), bundle.getParcelableArrayList("media_list"), this.D));
        this.aI.setSelection(i);
    }

    public static void m3451i(PhotoViewFragment photoViewFragment, boolean z) {
        MediaMessageItem mediaMessageItem = (MediaMessageItem) photoViewFragment.aI.getSelectedItem();
        if (!z || m3450h(mediaMessageItem)) {
            photoViewFragment.aJ.setVisibility(8);
            photoViewFragment.aK.setVisibility(8);
            return;
        }
        photoViewFragment.aJ.setVisibility(0);
        if (!((Boolean) photoViewFragment.aq.get()).booleanValue() || photoViewFragment.aV != PhotoViewMode.BACKED_BY_MESSAGE_DATA) {
            photoViewFragment.aK.setVisibility(0);
        }
    }

    public static void at(PhotoViewFragment photoViewFragment) {
        if (photoViewFragment.mx_()) {
            int i;
            MediaMessageItem mediaMessageItem = (MediaMessageItem) photoViewFragment.aI.getSelectedItem();
            Message i2 = mediaMessageItem.i();
            int i3 = (i2 == null || !MessageUtil.B(i2)) ? 0 : 1;
            MediaResource e = mediaMessageItem.e();
            if (i3 != 0 || ((e.u == null && !m3445b(i2)) || photoViewFragment.av == Product.PAA)) {
                photoViewFragment.aR.setVisibility(4);
            } else {
                photoViewFragment.aR.setVisibility(0);
            }
            if (mediaMessageItem.e().d == Type.PHOTO) {
                i = 1;
            } else {
                i = 0;
            }
            int i4 = 0;
            if (photoViewFragment.be != null) {
                photoViewFragment.be.setVisibility(i != 0 ? 0 : 8);
            }
            if (photoViewFragment.bd != null) {
                GlyphView glyphView = photoViewFragment.bd;
                if (i == 0) {
                    i4 = 8;
                }
                glyphView.setVisibility(i4);
            }
            CharSequence spannableStringBuilder = new SpannableStringBuilder(Factory.getInstance().newSpannable(Strings.nullToEmpty(StringUtil.a(mediaMessageItem.h(), 120))));
            photoViewFragment.an.a(spannableStringBuilder, (int) photoViewFragment.aM.getTextSize());
            photoViewFragment.aM.setText(spannableStringBuilder);
            photoViewFragment.m3449g(mediaMessageItem);
            if (!(((Boolean) photoViewFragment.aq.get()).booleanValue() && photoViewFragment.aV == PhotoViewMode.BACKED_BY_MESSAGE_DATA)) {
                i = photoViewFragment.aI.getSelectedItemPosition() + 1;
                photoViewFragment.aQ.setText(photoViewFragment.a(2131232190, new Object[]{Integer.valueOf(i), Integer.valueOf(photoViewFragment.aI.getCount())}));
            }
            if (!m3450h(mediaMessageItem)) {
                photoViewFragment.aP.setText(photoViewFragment.am.b(mediaMessageItem.e().A));
            }
        }
    }

    private void m3449g(MediaMessageItem mediaMessageItem) {
        int i = 0;
        CharSequence f = mediaMessageItem.f();
        UserKey g = mediaMessageItem.g();
        int i2 = (StringUtil.a(f) || g == null) ? 1 : 0;
        if (i2 == 0) {
            this.aN.setParams(this.aw.a(g, f));
            this.aO.setText(f);
        }
        UserTileView userTileView = this.aN;
        if (i2 != 0) {
            i = 8;
        }
        userTileView.setVisibility(i);
    }

    private static boolean m3450h(MediaMessageItem mediaMessageItem) {
        return mediaMessageItem.e().A <= 0;
    }
}
