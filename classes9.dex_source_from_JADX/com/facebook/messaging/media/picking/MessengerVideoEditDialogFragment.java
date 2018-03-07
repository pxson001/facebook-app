package com.facebook.messaging.media.picking;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import com.facebook.analytics.NavigationLogger;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.inject.FbInjector;
import com.facebook.iorg.common.upsell.ui.FbZeroDialogController;
import com.facebook.iorg.common.zero.ui.ZeroDialogController;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.fullscreendialog.FullScreenDialogFragment;
import com.facebook.messaging.fullscreendialog.FullScreenDialogParams;
import com.facebook.messaging.media.upload.MaxVideoSizeHelper;
import com.facebook.messaging.media.upload.MessagesVideoSizeEstimator;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.orca.compose.VideoLengthChecker;
import com.facebook.orca.compose.VideoLengthChecker.C21263;
import com.facebook.orca.compose.VideoLengthChecker.C21274;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ui.media.attachments.MediaResourceBuilder;
import com.facebook.videocodec.base.VideoMetadataExtractor;
import com.facebook.videocodec.extract.DefaultVideoMetadataExtractor;
import com.facebook.videocodec.trimming.VideoPreviewFragment;
import com.facebook.videocodec.trimming.VideoPreviewFragment.VideoPreviewFragmentCallback;
import com.facebook.zero.sdk.common.ZeroFeatureKey;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Futures;
import java.util.concurrent.ExecutorService;

/* compiled from: mCardBinId */
public class MessengerVideoEditDialogFragment extends FullScreenDialogFragment implements VideoPreviewFragmentCallback {
    public VideoPreviewFragment am;
    private ImageButton an;
    private ImageButton ao;
    public MessagesVideoSizeEstimator ap;
    public ZeroDialogController aq;
    public VideoLengthChecker ar;
    public MaxVideoSizeHelper as;
    public ThreadKey at;
    public MediaResource au;
    public Listener av;

    /* compiled from: mCardBinId */
    public interface Listener {
        void mo452a();

        void mo453a(MediaResource mediaResource);

        void mo454b(MediaResource mediaResource);
    }

    /* compiled from: mCardBinId */
    class C13261 implements com.facebook.iorg.common.zero.ui.ZeroDialogController.Listener {
        final /* synthetic */ MessengerVideoEditDialogFragment f11800a;

        C13261(MessengerVideoEditDialogFragment messengerVideoEditDialogFragment) {
            this.f11800a = messengerVideoEditDialogFragment;
        }

        public final void m12425a(Object obj) {
            MessengerVideoEditDialogFragment messengerVideoEditDialogFragment = this.f11800a;
            messengerVideoEditDialogFragment.b();
            if (messengerVideoEditDialogFragment.av != null) {
                MediaResourceBuilder a = MediaResource.a().a(messengerVideoEditDialogFragment.au);
                a.q = messengerVideoEditDialogFragment.am.b();
                a = a;
                a.r = messengerVideoEditDialogFragment.am.e();
                messengerVideoEditDialogFragment.av.mo453a(a.C());
            }
        }

        public final void m12424a() {
        }
    }

    /* compiled from: mCardBinId */
    class C13272 implements OnClickListener {
        final /* synthetic */ MessengerVideoEditDialogFragment f11801a;

        C13272(MessengerVideoEditDialogFragment messengerVideoEditDialogFragment) {
            this.f11801a = messengerVideoEditDialogFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 421446337);
            this.f11801a.b();
            MediaResourceBuilder a2 = MediaResource.a().a(this.f11801a.au);
            a2.q = this.f11801a.am.b();
            a2 = a2;
            a2.r = this.f11801a.am.e();
            this.f11801a.av.mo454b(a2.C());
            Logger.a(2, EntryType.UI_INPUT_END, -1068701393, a);
        }
    }

    /* compiled from: mCardBinId */
    class C13283 implements OnClickListener {
        final /* synthetic */ MessengerVideoEditDialogFragment f11802a;

        C13283(MessengerVideoEditDialogFragment messengerVideoEditDialogFragment) {
            this.f11802a = messengerVideoEditDialogFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1178127076);
            this.f11802a.aq.a(ZeroFeatureKey.VIDEO_UPLOAD_INTERSTITIAL, this.f11802a.s());
            Logger.a(2, EntryType.UI_INPUT_END, -868953001, a);
        }
    }

    /* compiled from: mCardBinId */
    class C13294 implements OnClickListener {
        final /* synthetic */ MessengerVideoEditDialogFragment f11803a;

        C13294(MessengerVideoEditDialogFragment messengerVideoEditDialogFragment) {
            this.f11803a = messengerVideoEditDialogFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1743190732);
            this.f11803a.b();
            Logger.a(2, EntryType.UI_INPUT_END, 1082653579, a);
        }
    }

    /* compiled from: mCardBinId */
    class C13305 implements Function<Void, Void> {
        final /* synthetic */ MessengerVideoEditDialogFragment f11804a;

        C13305(MessengerVideoEditDialogFragment messengerVideoEditDialogFragment) {
            this.f11804a = messengerVideoEditDialogFragment;
        }

        public Object apply(Object obj) {
            this.f11804a.b();
            return null;
        }
    }

    public static void m12427a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        MessengerVideoEditDialogFragment messengerVideoEditDialogFragment = (MessengerVideoEditDialogFragment) obj;
        MessagesVideoSizeEstimator a = MessagesVideoSizeEstimator.a(fbInjector);
        ZeroDialogController zeroDialogController = (ZeroDialogController) FbZeroDialogController.b(fbInjector);
        VideoLengthChecker videoLengthChecker = new VideoLengthChecker((Context) fbInjector.getInstance(Context.class), NavigationLogger.a(fbInjector), (VideoMetadataExtractor) DefaultVideoMetadataExtractor.b(fbInjector), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(fbInjector), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(fbInjector), (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector));
        MaxVideoSizeHelper b = MaxVideoSizeHelper.m12454b(fbInjector);
        messengerVideoEditDialogFragment.ap = a;
        messengerVideoEditDialogFragment.aq = zeroDialogController;
        messengerVideoEditDialogFragment.ar = videoLengthChecker;
        messengerVideoEditDialogFragment.as = b;
    }

    public static MessengerVideoEditDialogFragment m12426a(MediaResource mediaResource, FullScreenDialogParams fullScreenDialogParams, boolean z) {
        MessengerVideoEditDialogFragment messengerVideoEditDialogFragment = new MessengerVideoEditDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("m", mediaResource);
        bundle.putBoolean("extra_replace_send_with_confirm", z);
        fullScreenDialogParams.a(bundle);
        messengerVideoEditDialogFragment.g(bundle);
        return messengerVideoEditDialogFragment;
    }

    public final void m12430a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -983433441);
        super.a(bundle);
        Class cls = MessengerVideoEditDialogFragment.class;
        m12427a(this, getContext());
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -984501653, a);
    }

    public final void m12431a(Fragment fragment) {
        super.a(fragment);
        if (fragment instanceof VideoPreviewFragment) {
            this.am = (VideoPreviewFragment) fragment;
            this.am.a(true);
            this.am.aA = this;
        }
    }

    public final View m12429a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 826744145);
        int dimensionPixelSize = jW_().getDimensionPixelSize(2131427383);
        View inflate = layoutInflater.inflate(2130905920, viewGroup, false);
        inflate.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, 0);
        inflate.setMinimumWidth(10000);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -2127950188, a);
        return inflate;
    }

    public final void m12433d(Bundle bundle) {
        boolean z;
        OnClickListener c13272;
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1202674206);
        super.d(bundle);
        this.an = (ImageButton) e(2131562049);
        this.ao = (ImageButton) e(2131560414);
        Bundle bundle2 = this.s;
        if (bundle2 != null) {
            this.au = (MediaResource) bundle2.getParcelable("m");
            z = bundle2.getBoolean("extra_replace_send_with_confirm", false);
        } else {
            z = false;
        }
        Preconditions.checkNotNull(this.au);
        this.am.a(this.au.c);
        this.am.a(this.ap);
        this.am.as = this.as.m12455a();
        this.aq.a(ZeroFeatureKey.VIDEO_UPLOAD_INTERSTITIAL, b(2131232931), new C13261(this));
        if (z) {
            this.an.setImageDrawable(ContextCompat.a(getContext(), 2130838035));
            c13272 = new C13272(this);
        } else {
            c13272 = new C13283(this);
        }
        this.an.setOnClickListener(c13272);
        this.an.setEnabled(false);
        this.ao.setOnClickListener(new C13294(this));
        VideoLengthChecker videoLengthChecker = this.ar;
        Futures.a(videoLengthChecker.f18370e.a(new C21263(videoLengthChecker, this.au.c)), new C21274(videoLengthChecker, "messenger_video_edit", new C13305(this)), videoLengthChecker.f18369d);
        LogUtils.f(-1193935070, a);
    }

    public final void m12428I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 845518851);
        super.I();
        if (this.av != null) {
            this.av.mo452a();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 2115296494, a);
    }

    public final void m12432a(boolean z) {
        if (z) {
            this.an.setEnabled(true);
        }
    }
}
