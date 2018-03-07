package com.facebook.facecast.plugin;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import com.facebook.common.async.AsyncTaskVersionHelper;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.composer.privacy.common.ComposerAudienceFragment;
import com.facebook.composer.privacy.common.ComposerAudienceFragment.AudienceDialogData;
import com.facebook.composer.privacy.common.ComposerAudienceFragment.OnAudienceSelectedListener;
import com.facebook.debug.log.BLog;
import com.facebook.facecast.FacecastActivity.C15176;
import com.facebook.facecast.FacecastFacepileView;
import com.facebook.facecast.FacecastLocalVideoSaveController;
import com.facebook.facecast.FacecastLocalVideoSaveController.FacecastLocalVideoSaveWorker;
import com.facebook.facecast.FacecastLocalVideoSaveControllerProvider;
import com.facebook.facecast.FacecastStateManager;
import com.facebook.facecast.LiveStreamDvrUploader;
import com.facebook.facecast.abtest.ExperimentsForFacecastAbtestModule;
import com.facebook.facecast.abtest.FacecastEndScreenQEHelper;
import com.facebook.facecast.plugin.FacecastAnalyticsLogger.EXIT_SOURCE;
import com.facebook.facecast.plugin.FacecastViewerFacepileController.ViewersDownloadedListener;
import com.facebook.facecast.protocol.FacecastNetworker;
import com.facebook.facecast.view.FacecastEndScreenPrivacyPill;
import com.facebook.facecast.view.FacecastHdUploadButton;
import com.facebook.facecast.view.FacecastHdUploadButton.OnInterceptClickListener;
import com.facebook.facecast.view.FacecastPreviewSaveButton;
import com.facebook.facecast.view.FacecastPreviewSaveButton.SaveButtonState;
import com.facebook.facecast.view.FacecastVideoPlaybackContainer;
import com.facebook.facecast.view.FacecastVideoPlaybackView;
import com.facebook.facecastdisplay.LiveEventAuthor;
import com.facebook.facecastdisplay.LiveStatusPoller;
import com.facebook.facecastdisplay.LiveStatusPoller.LiveStatusListener;
import com.facebook.facecastdisplay.protocol.FetchVideoBroadcastQueryModels.VideoBroadcastFragmentModel;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.fig.button.FigButton;
import com.facebook.graphql.enums.GraphQLVideoBroadcastStatus;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.mediastorage.MediaStorage;
import com.facebook.mediastorage.String_MediaStorageDirStringMethodAutoProvider;
import com.facebook.privacy.PrivacyOperationsClient;
import com.facebook.privacy.model.SelectablePrivacyData;
import com.facebook.privacy.selector.AudienceSelectorPerformanceLogger;
import com.facebook.privacy.selector.AudienceSelectorPerformanceLogger.Caller;
import com.facebook.privacy.selector.AudienceTypeaheadFragment.DataProvider;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.video.videostreaming.LiveStreamer;
import com.facebook.widget.text.BetterTextView;
import com.google.common.base.Preconditions;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: borderTopWidth */
public class FacecastEndScreenV2Plugin extends FacecastBasePlugin {
    public static final String f18361q = FacecastEndScreenV2Plugin.class.getName();
    @Nullable
    public C15176 f18362A;
    @Nullable
    public String f18363B;
    @Nullable
    public String f18364C;
    @Nullable
    public File f18365D;
    public long f18366E;
    public ComposerTargetData f18367F;
    public SelectablePrivacyData f18368G;
    public long f18369H;
    public FacecastViewerFacepileController f18370I;
    public FacecastEndScreenV2FullscreenTransitionController f18371J;
    private final AnonymousClass11 f18372K;
    @Inject
    public FacecastNetworker f18373c;
    @Inject
    public AbstractFbErrorReporter f18374d;
    @Inject
    FacecastViewerFacepileControllerProvider f18375e;
    @Inject
    public FacecastEndScreenQEHelper f18376f;
    @Inject
    public LiveStreamer f18377g;
    @Inject
    public LiveStreamDvrUploader f18378h;
    @Inject
    FacecastLocalVideoSaveControllerProvider f18379i;
    @Inject
    Toaster f18380j;
    @Inject
    FacecastAnalyticsLogger f18381k;
    @Inject
    FacecastHdUploadHelper f18382l;
    @Inject
    public AudienceSelectorPerformanceLogger f18383m;
    @Inject
    public PrivacyOperationsClient f18384n;
    @Inject
    public TasksManager f18385o;
    @Inject
    LiveStatusPoller f18386p;
    public FacecastVideoPlaybackView f18387r;
    private FigButton f18388s;
    private FigButton f18389t;
    public final ViewStub f18390u;
    @Nullable
    public FacecastFacepileView f18391v;
    @Nullable
    public FacecastPreviewSaveButton f18392w;
    @Nullable
    public FacecastHdUploadButton f18393x;
    public final BetterTextView f18394y;
    private final ProgressBar f18395z;

    /* compiled from: borderTopWidth */
    class C15621 implements OnClickListener {
        final /* synthetic */ FacecastEndScreenV2Plugin f18350a;

        C15621(FacecastEndScreenV2Plugin facecastEndScreenV2Plugin) {
            this.f18350a = facecastEndScreenV2Plugin;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 936530070);
            if (this.f18350a.f18371J.f18338g) {
                Logger.a(2, EntryType.UI_INPUT_END, -1131711442, a);
                return;
            }
            if (!this.f18350a.f18371J.f18337f) {
                this.f18350a.f18371J.m22039a();
            }
            LogUtils.a(1372637096, a);
        }
    }

    /* compiled from: borderTopWidth */
    class C15632 implements OnClickListener {
        final /* synthetic */ FacecastEndScreenV2Plugin f18351a;

        C15632(FacecastEndScreenV2Plugin facecastEndScreenV2Plugin) {
            this.f18351a = facecastEndScreenV2Plugin;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 893805688);
            FacecastEndScreenV2Plugin facecastEndScreenV2Plugin = this.f18351a;
            if (facecastEndScreenV2Plugin.f18377g.u) {
                Object obj;
                if (facecastEndScreenV2Plugin.f18393x == null || !facecastEndScreenV2Plugin.f18393x.isChecked()) {
                    obj = null;
                } else {
                    obj = 1;
                }
                if (obj != null && facecastEndScreenV2Plugin.f18376f.m3063c()) {
                    File file = facecastEndScreenV2Plugin.f18365D;
                    if (file != null) {
                        facecastEndScreenV2Plugin.f18378h.m21893a(file, facecastEndScreenV2Plugin.f18363B);
                    } else {
                        BLog.a(FacecastEndScreenV2Plugin.f18361q, "DVR File is null");
                    }
                }
            }
            if (this.f18351a.f18368G != null) {
                facecastEndScreenV2Plugin = this.f18351a;
                facecastEndScreenV2Plugin.f18385o.a("end_screen_set_privacy", facecastEndScreenV2Plugin.f18384n.a(facecastEndScreenV2Plugin.f18364C, null, facecastEndScreenV2Plugin.f18364C, this.f18351a.f18368G.d), null);
            }
            FacecastEndScreenV2Plugin.m22050a(this.f18351a, EXIT_SOURCE.POST_BUTTON);
            FacecastEndScreenV2Plugin.m22058m(this.f18351a);
            Logger.a(2, EntryType.UI_INPUT_END, -20610146, a);
        }
    }

    /* compiled from: borderTopWidth */
    class C15643 implements OnClickListener {
        final /* synthetic */ FacecastEndScreenV2Plugin f18352a;

        C15643(FacecastEndScreenV2Plugin facecastEndScreenV2Plugin) {
            this.f18352a = facecastEndScreenV2Plugin;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1478828107);
            FacecastEndScreenV2Plugin.m22063r(this.f18352a);
            Logger.a(2, EntryType.UI_INPUT_END, 1877679128, a);
        }
    }

    /* compiled from: borderTopWidth */
    public class C15654 {
        public final /* synthetic */ FacecastEndScreenV2Plugin f18353a;

        public C15654(FacecastEndScreenV2Plugin facecastEndScreenV2Plugin) {
            this.f18353a = facecastEndScreenV2Plugin;
        }
    }

    /* compiled from: borderTopWidth */
    class C15665 implements LiveStatusListener {
        final /* synthetic */ FacecastEndScreenV2Plugin f18354a;

        C15665(FacecastEndScreenV2Plugin facecastEndScreenV2Plugin) {
            this.f18354a = facecastEndScreenV2Plugin;
        }

        public final void m22043a(VideoBroadcastFragmentModel videoBroadcastFragmentModel) {
        }

        public final void m22045b(VideoBroadcastFragmentModel videoBroadcastFragmentModel) {
            if (videoBroadcastFragmentModel.m4015d() == GraphQLVideoBroadcastStatus.VOD_READY) {
                this.f18354a.f18386p.a();
                String k = videoBroadcastFragmentModel.m4018k();
                if (k == null) {
                    this.f18354a.f18374d.a(FacecastEndScreenV2Plugin.f18361q + "_onBroadcastCompleted", "Broadcast status is VOD_READY but playableUrl is null");
                } else {
                    FacecastEndScreenV2Plugin.m22049a(this.f18354a, Uri.parse(k));
                }
            }
        }

        public final void m22044a(String str) {
        }

        public final void r_(int i) {
        }
    }

    /* compiled from: borderTopWidth */
    class C15687 implements OnInterceptClickListener {
        final /* synthetic */ FacecastEndScreenV2Plugin f18357a;

        C15687(FacecastEndScreenV2Plugin facecastEndScreenV2Plugin) {
            this.f18357a = facecastEndScreenV2Plugin;
        }

        public final boolean mo1418a() {
            if (!this.f18357a.f18393x.isChecked()) {
                Object obj;
                FacecastHdUploadHelper facecastHdUploadHelper = this.f18357a.f18382l;
                long j = this.f18357a.f18366E;
                if (facecastHdUploadHelper.f18426a.v() || j <= 20971520) {
                    obj = null;
                } else {
                    obj = 1;
                }
                if (obj != null) {
                    FacecastEndScreenV2Plugin.m22064s(this.f18357a);
                    return true;
                }
            }
            return false;
        }
    }

    /* compiled from: borderTopWidth */
    class C15698 implements OnClickListener {
        final /* synthetic */ FacecastEndScreenV2Plugin f18358a;

        C15698(FacecastEndScreenV2Plugin facecastEndScreenV2Plugin) {
            this.f18358a = facecastEndScreenV2Plugin;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1890755185);
            FacecastEndScreenV2Plugin facecastEndScreenV2Plugin = this.f18358a;
            FacecastEndScreenPrivacyPill facecastEndScreenPrivacyPill = (FacecastEndScreenPrivacyPill) view;
            if (facecastEndScreenV2Plugin.f18368G != null) {
                ComposerAudienceFragment composerAudienceFragment = new ComposerAudienceFragment();
                composerAudienceFragment.m1913a(new AudienceDialogData(new DataProvider(facecastEndScreenV2Plugin) {
                    final /* synthetic */ FacecastEndScreenV2Plugin f18341a;

                    {
                        this.f18341a = r1;
                    }

                    public final SelectablePrivacyData m22040a() {
                        return this.f18341a.f18368G;
                    }

                    public final boolean m22041b() {
                        return false;
                    }
                }, new C15709(facecastEndScreenV2Plugin, facecastEndScreenPrivacyPill), null));
                facecastEndScreenV2Plugin.f18383m.a(Caller.FACECAST_ACTIVITY);
                composerAudienceFragment.a(((FragmentActivity) facecastEndScreenV2Plugin.getContext()).kO_(), "ENDSCREEN_FACECAST_AUDIENCE_FRAGMENT_TAG");
                facecastEndScreenV2Plugin.f18387r.m22436b();
            }
            Logger.a(2, EntryType.UI_INPUT_END, 1652453619, a);
        }
    }

    /* compiled from: borderTopWidth */
    public class C15709 implements OnAudienceSelectedListener {
        final /* synthetic */ FacecastEndScreenPrivacyPill f18359a;
        final /* synthetic */ FacecastEndScreenV2Plugin f18360b;

        public C15709(FacecastEndScreenV2Plugin facecastEndScreenV2Plugin, FacecastEndScreenPrivacyPill facecastEndScreenPrivacyPill) {
            this.f18360b = facecastEndScreenV2Plugin;
            this.f18359a = facecastEndScreenPrivacyPill;
        }

        public final void mo488a(SelectablePrivacyData selectablePrivacyData) {
            this.f18360b.f18368G = selectablePrivacyData;
            this.f18359a.m22423a(selectablePrivacyData, this.f18360b.f18367F);
            this.f18360b.f18387r.m22434a();
        }
    }

    public static void m22052a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((FacecastEndScreenV2Plugin) obj).m22051a(FacecastNetworker.m22307b(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (FacecastViewerFacepileControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FacecastViewerFacepileControllerProvider.class), FacecastEndScreenQEHelper.m3061b(injectorLike), LiveStreamer.a(injectorLike), LiveStreamDvrUploader.m21892b(injectorLike), (FacecastLocalVideoSaveControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FacecastLocalVideoSaveControllerProvider.class), Toaster.b(injectorLike), FacecastAnalyticsLogger.m21959a(injectorLike), FacecastHdUploadHelper.m22083b(injectorLike), AudienceSelectorPerformanceLogger.a(injectorLike), PrivacyOperationsClient.a(injectorLike), TasksManager.b(injectorLike), LiveStatusPoller.b(injectorLike));
    }

    public FacecastEndScreenV2Plugin(Context context) {
        this(context, null);
    }

    private FacecastEndScreenV2Plugin(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private FacecastEndScreenV2Plugin(Context context, @Nullable AttributeSet attributeSet, int i) {
        File d;
        super(context, attributeSet, i);
        this.f18366E = 0;
        this.f18372K = new Object(this) {
            public final /* synthetic */ FacecastEndScreenV2Plugin f18342a;

            {
                this.f18342a = r1;
            }
        };
        Class cls = FacecastEndScreenV2Plugin.class;
        m22052a((Object) this, getContext());
        setContentView(2130904213);
        this.f18387r = (FacecastVideoPlaybackView) a(2131561635);
        this.f18390u = (ViewStub) a(2131561650);
        this.f18394y = (BetterTextView) a(2131561651);
        this.f18395z = (ProgressBar) a(2131561669);
        if (this.f18377g.u) {
            d = this.f18377g.d();
        } else {
            d = null;
        }
        this.f18365D = d;
        if (this.f18365D == null) {
            this.f18374d.a(f18361q + "_<cstr>", "Recorded local file from live does not exist");
            this.f18395z.setVisibility(0);
        } else {
            this.f18366E = this.f18365D.length();
            m22049a(this, Uri.fromFile(this.f18365D));
        }
        m22055h();
        m22056i();
        if (this.f18365D != null && this.f18365D.length() > 0) {
            if (this.f18376f.m3062b()) {
                m22059n();
            }
            if (this.f18376f.m3063c()) {
                m22060o();
            }
        }
        this.f18371J = new FacecastEndScreenV2FullscreenTransitionController((ViewGroup) a(2131561645), (ScrollView) a(2131561666), (FacecastVideoPlaybackContainer) a(2131561668), (ViewGroup) a(2131561670));
        this.f18371J.f18340i = new C15654(this);
    }

    public static void m22049a(FacecastEndScreenV2Plugin facecastEndScreenV2Plugin, Uri uri) {
        facecastEndScreenV2Plugin.f18395z.setVisibility(8);
        facecastEndScreenV2Plugin.f18387r.m22435a(uri);
        if (facecastEndScreenV2Plugin.f18376f.f2806a.a(ExperimentsForFacecastAbtestModule.f2791l, false)) {
            facecastEndScreenV2Plugin.f18387r.setOnClickListener(new C15621(facecastEndScreenV2Plugin));
        }
    }

    private void m22055h() {
        this.f18388s = (FigButton) a(2131561665);
        this.f18388s.setOnClickListener(new C15632(this));
        this.f18388s.setText(this.f18376f.f2806a.a(ExperimentsForFacecastAbtestModule.f2793n, getContext().getString(2131238267)));
    }

    private void m22056i() {
        this.f18389t = (FigButton) a(2131561664);
        this.f18389t.setOnClickListener(new C15643(this));
        this.f18389t.setText(this.f18376f.f2806a.a(ExperimentsForFacecastAbtestModule.f2790k, getContext().getString(2131238268)));
    }

    private void m22057k() {
        this.f18386p.g = new C15665(this);
        this.f18386p.a(this.f18364C);
    }

    public static void m22058m(FacecastEndScreenV2Plugin facecastEndScreenV2Plugin) {
        if (facecastEndScreenV2Plugin.f18362A != null) {
            facecastEndScreenV2Plugin.f18362A.m21763a();
        }
    }

    private void m22059n() {
        FacecastLocalVideoSaveControllerProvider facecastLocalVideoSaveControllerProvider = this.f18379i;
        final FacecastLocalVideoSaveController facecastLocalVideoSaveController = new FacecastLocalVideoSaveController(this.f18365D, this.f18372K, String_MediaStorageDirStringMethodAutoProvider.a(facecastLocalVideoSaveControllerProvider), MediaStorage.a(facecastLocalVideoSaveControllerProvider));
        if (facecastLocalVideoSaveController.m21871a()) {
            this.f18392w = (FacecastPreviewSaveButton) ((ViewStub) a(2131561672)).inflate();
            this.f18392w.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ FacecastEndScreenV2Plugin f18356b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 1987794178);
                    switch (this.f18356b.f18392w.f18834d) {
                        case IDLE:
                            FacecastLocalVideoSaveController facecastLocalVideoSaveController = facecastLocalVideoSaveController;
                            if (facecastLocalVideoSaveController.m21871a()) {
                                AsyncTaskVersionHelper.a(new FacecastLocalVideoSaveWorker(facecastLocalVideoSaveController.f18031e, facecastLocalVideoSaveController.f18029c, facecastLocalVideoSaveController.f18030d), new Void[0]);
                            }
                            break;
                        case SAVING_COMPLETED:
                        case SAVED:
                            FacecastEndScreenV2Plugin.m22054c(this.f18356b, 2131238264);
                            break;
                    }
                    LogUtils.a(941056992, a);
                }
            });
        }
    }

    private void m22060o() {
        this.f18393x = (FacecastHdUploadButton) ((ViewStub) a(2131561671)).inflate();
        this.f18393x.f18828b = new C15687(this);
        FacecastHdUploadButton facecastHdUploadButton = this.f18393x;
        FacecastHdUploadHelper facecastHdUploadHelper = this.f18382l;
        long j = this.f18366E;
        boolean z = false;
        if (facecastHdUploadHelper.f18427b.f2806a.a(ExperimentsForFacecastAbtestModule.f2789j, false)) {
            if (facecastHdUploadHelper.f18426a.v()) {
                if (j <= 104857600) {
                    z = true;
                }
            } else if (j <= 20971520) {
                z = true;
            }
        }
        facecastHdUploadButton.setChecked(z);
    }

    private void m22061p() {
        FacecastEndScreenPrivacyPill facecastEndScreenPrivacyPill = (FacecastEndScreenPrivacyPill) a(2131561674);
        facecastEndScreenPrivacyPill.m22423a(this.f18368G, this.f18367F);
        if (this.f18368G != null) {
            facecastEndScreenPrivacyPill.setOnClickListener(new C15698(this));
        }
    }

    public static void m22054c(FacecastEndScreenV2Plugin facecastEndScreenV2Plugin, int i) {
        facecastEndScreenV2Plugin.f18380j.a(new ToastBuilder(i));
    }

    public final void m22065a(long j, long j2, String str, String str2, ComposerTargetData composerTargetData, SelectablePrivacyData selectablePrivacyData) {
        this.f18367F = composerTargetData;
        this.f18368G = selectablePrivacyData;
        this.f18369H = j2;
        this.f18363B = str;
        this.f18364C = str2;
        this.f18370I = this.f18375e.m22181a(str2, j, new ViewersDownloadedListener(this) {
            final /* synthetic */ FacecastEndScreenV2Plugin f18343a;

            {
                this.f18343a = r1;
            }

            public final void mo1416a(@Nullable List<LiveEventAuthor> list, int i) {
                FacecastEndScreenV2Plugin facecastEndScreenV2Plugin = this.f18343a;
                if (list == null || list.isEmpty()) {
                    CharSequence a = FacecastEndScreenUiUtil.m22037a(facecastEndScreenV2Plugin.getResources(), facecastEndScreenV2Plugin.f18369H, facecastEndScreenV2Plugin.f18367F);
                    if (a == null) {
                        facecastEndScreenV2Plugin.f18374d.a(FacecastEndScreenV2Plugin.f18361q + "_getEmptyFacepileString", "Unsupported type " + facecastEndScreenV2Plugin.f18367F.targetType + " for " + facecastEndScreenV2Plugin.f18367F.targetId + " is called.");
                    }
                    facecastEndScreenV2Plugin.f18394y.setText(a);
                    return;
                }
                if (facecastEndScreenV2Plugin.f18391v == null) {
                    facecastEndScreenV2Plugin.f18391v = (FacecastFacepileView) facecastEndScreenV2Plugin.f18390u.inflate();
                }
                List arrayList = new ArrayList();
                for (LiveEventAuthor liveEventAuthor : list) {
                    arrayList.add(liveEventAuthor.f2903b);
                }
                facecastEndScreenV2Plugin.f18391v.setFBIDs(arrayList);
                if (facecastEndScreenV2Plugin.f18370I != null) {
                    facecastEndScreenV2Plugin.f18394y.setText(facecastEndScreenV2Plugin.f18370I.m22178a(list, i));
                }
            }
        }, getContext());
        m22061p();
        if (this.f18365D == null) {
            m22057k();
        }
    }

    public final void mo1419e() {
        super.mo1419e();
        this.f18387r.m22434a();
    }

    public final void mo1413d() {
        super.mo1413d();
        this.f18387r.m22436b();
    }

    public final boolean mo1409a() {
        if (!this.f18371J.f18338g) {
            if (this.f18371J.f18337f) {
                FacecastEndScreenV2FullscreenTransitionController facecastEndScreenV2FullscreenTransitionController = this.f18371J;
                Preconditions.checkNotNull(facecastEndScreenV2FullscreenTransitionController.f18339h);
                facecastEndScreenV2FullscreenTransitionController.f18337f = false;
                facecastEndScreenV2FullscreenTransitionController.f18339h.f18293b.start();
                facecastEndScreenV2FullscreenTransitionController.f18339h = null;
            } else {
                m22062q();
            }
        }
        return true;
    }

    private void m22062q() {
        String string;
        String string2 = getContext().getString(2131238271);
        if (this.f18392w == null || this.f18392w.f18834d != SaveButtonState.SAVED) {
            string = getContext().getString(2131238272);
        } else {
            string = getContext().getString(2131238273);
        }
        m22053a(string2, string, EXIT_SOURCE.BACK_BUTTON);
    }

    public static void m22063r(FacecastEndScreenV2Plugin facecastEndScreenV2Plugin) {
        facecastEndScreenV2Plugin.m22053a(facecastEndScreenV2Plugin.getContext().getString(2131238238), facecastEndScreenV2Plugin.getContext().getString(2131238240), EXIT_SOURCE.DELETE_BUTTON);
    }

    private void m22053a(String str, String str2, final EXIT_SOURCE exit_source) {
        Builder builder = new Builder(getContext());
        builder.a(str);
        builder.b(str2);
        builder.a(getContext().getString(2131238268), new DialogInterface.OnClickListener(this) {
            final /* synthetic */ FacecastEndScreenV2Plugin f18345b;

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                FacecastEndScreenV2Plugin facecastEndScreenV2Plugin = this.f18345b;
                facecastEndScreenV2Plugin.f18373c.m22309b(facecastEndScreenV2Plugin.f18363B);
                FacecastEndScreenV2Plugin.m22050a(this.f18345b, exit_source);
                FacecastEndScreenV2Plugin.m22058m(this.f18345b);
            }
        });
        builder.b(getContext().getString(2131238269), new DialogInterface.OnClickListener(this) {
            final /* synthetic */ FacecastEndScreenV2Plugin f18346a;

            {
                this.f18346a = r1;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.a().show();
    }

    public static void m22064s(FacecastEndScreenV2Plugin facecastEndScreenV2Plugin) {
        Builder builder = new Builder(facecastEndScreenV2Plugin.getContext());
        builder.a(facecastEndScreenV2Plugin.getContext().getString(2131238274));
        builder.b(facecastEndScreenV2Plugin.getContext().getString(2131238275, new Object[]{Long.toString(Math.max(1, Math.round(((double) facecastEndScreenV2Plugin.f18366E) / 1048576.0d)))}));
        builder.a(facecastEndScreenV2Plugin.getContext().getString(2131238270), new DialogInterface.OnClickListener(facecastEndScreenV2Plugin) {
            final /* synthetic */ FacecastEndScreenV2Plugin f18347a;

            {
                this.f18347a = r1;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                this.f18347a.f18393x.setChecked(true);
                dialogInterface.dismiss();
            }
        });
        builder.b(facecastEndScreenV2Plugin.getContext().getString(2131238269), new DialogInterface.OnClickListener(facecastEndScreenV2Plugin) {
            final /* synthetic */ FacecastEndScreenV2Plugin f18348a;

            {
                this.f18348a = r1;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.a().show();
    }

    public static void m22050a(FacecastEndScreenV2Plugin facecastEndScreenV2Plugin, EXIT_SOURCE exit_source) {
        boolean z;
        boolean z2;
        boolean z3 = (!facecastEndScreenV2Plugin.f18376f.m3062b() || facecastEndScreenV2Plugin.f18392w == null) ? false : facecastEndScreenV2Plugin.f18392w.f18834d == SaveButtonState.SAVED;
        if (facecastEndScreenV2Plugin.f18376f.m3063c() && exit_source == EXIT_SOURCE.POST_BUTTON && facecastEndScreenV2Plugin.f18393x != null && facecastEndScreenV2Plugin.f18393x.isChecked()) {
            z = true;
        } else {
            z = false;
        }
        if (facecastEndScreenV2Plugin.f18365D != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        facecastEndScreenV2Plugin.f18381k.m21962a(exit_source, facecastEndScreenV2Plugin.f18369H, z3, z, z2);
    }

    protected final void hE_() {
        super.hE_();
        if (this.f18370I != null) {
            this.f18370I.m22179a();
        }
    }

    protected final void mo1408a(ViewGroup viewGroup, FacecastStateManager facecastStateManager) {
        super.mo1408a(viewGroup, facecastStateManager);
        if (this.f18370I != null) {
            this.f18370I.m22180b();
        }
    }

    private void m22051a(FacecastNetworker facecastNetworker, AbstractFbErrorReporter abstractFbErrorReporter, FacecastViewerFacepileControllerProvider facecastViewerFacepileControllerProvider, FacecastEndScreenQEHelper facecastEndScreenQEHelper, LiveStreamer liveStreamer, LiveStreamDvrUploader liveStreamDvrUploader, FacecastLocalVideoSaveControllerProvider facecastLocalVideoSaveControllerProvider, Toaster toaster, FacecastAnalyticsLogger facecastAnalyticsLogger, FacecastHdUploadHelper facecastHdUploadHelper, AudienceSelectorPerformanceLogger audienceSelectorPerformanceLogger, PrivacyOperationsClient privacyOperationsClient, TasksManager tasksManager, LiveStatusPoller liveStatusPoller) {
        this.f18373c = facecastNetworker;
        this.f18374d = abstractFbErrorReporter;
        this.f18375e = facecastViewerFacepileControllerProvider;
        this.f18376f = facecastEndScreenQEHelper;
        this.f18377g = liveStreamer;
        this.f18378h = liveStreamDvrUploader;
        this.f18379i = facecastLocalVideoSaveControllerProvider;
        this.f18380j = toaster;
        this.f18381k = facecastAnalyticsLogger;
        this.f18382l = facecastHdUploadHelper;
        this.f18383m = audienceSelectorPerformanceLogger;
        this.f18384n = privacyOperationsClient;
        this.f18385o = tasksManager;
        this.f18386p = liveStatusPoller;
    }
}
