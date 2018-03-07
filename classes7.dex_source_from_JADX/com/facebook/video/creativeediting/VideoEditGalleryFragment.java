package com.facebook.video.creativeediting;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import com.facebook.common.util.FindViewUtil;
import com.facebook.inject.FbInjector;
import com.facebook.ipc.videoeditgallery.VideoEditGalleryLaunchConfiguration;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.editgallery.animations.AnimationParam;
import com.facebook.photos.editgallery.common.FeatureSelectorController;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.ui.dialogs.FbDialogFragment;
import com.facebook.ui.titlebar.Fb4aTitleBar;
import com.facebook.video.creativeediting.VideoEditGalleryFragmentController.C11725;
import com.facebook.video.creativeediting.VideoEditGalleryFragmentController.State;
import com.facebook.video.creativeediting.VideoEditGalleryFragmentManager.VideoEditGalleryCallback;
import com.facebook.video.creativeediting.analytics.VideoEditingGalleryEntryPoint;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: ec-3 */
public class VideoEditGalleryFragment extends FbDialogFragment {
    @Inject
    public VideoEditGalleryFragmentControllerProvider am;
    private Uri an;
    public VideoEditGalleryLaunchConfiguration ao;
    private VideoEditGalleryFragmentController ap;
    public LinearLayout aq;
    private ViewStub ar;
    public VideoEditGalleryCallback as;
    public VideoEditingGalleryEntryPoint at;
    private View au;
    public Fb4aTitleBar av;
    private VideoEditGalleryPreviewLayout aw;
    @Nullable
    private AnimationParam ax;

    public static void m19447a(Object obj, Context context) {
        ((VideoEditGalleryFragment) obj).am = (VideoEditGalleryFragmentControllerProvider) FbInjector.get(context).getOnDemandAssistedProviderForStaticDi(VideoEditGalleryFragmentControllerProvider.class);
    }

    public final void m19451a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1202480278);
        super.a(bundle);
        Class cls = VideoEditGalleryFragment.class;
        m19447a(this, getContext());
        a(2, 2131625385);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1694182082, a);
    }

    public void onCancel(DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
        if (this.as != null) {
            this.as.mo1168a(this.aw.f15447b.getCurrentPositionMs());
        }
    }

    public final View m19450a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 563842618);
        View inflate = layoutInflater.inflate(2130907664, viewGroup, false);
        this.au = FindViewUtil.b(inflate, 2131561112);
        this.av = (Fb4aTitleBar) this.au.findViewById(2131558563);
        this.aw = (VideoEditGalleryPreviewLayout) FindViewUtil.b(inflate, 2131568308);
        this.ar = (ViewStub) FindViewUtil.b(inflate, 2131568309);
        this.aq = (LinearLayout) FindViewUtil.b(inflate, 2131568312);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 451766597, a);
        return inflate;
    }

    public final void m19448G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1013269502);
        super.G();
        for (FeatureSelectorController featureSelectorController : this.ap.f15427n) {
            featureSelectorController.f10488b.mo568f();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1090049548, a);
    }

    public final void m19449H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 873542969);
        super.H();
        for (FeatureSelectorController featureSelectorController : this.ap.f15427n) {
            featureSelectorController.f10488b.mo569g();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -332238401, a);
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 33179667);
        if (an() != null) {
            an().setRequestedOrientation(1);
        }
        super.mi_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1986812821, a);
    }

    public final void mj_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 605394024);
        if (an() != null) {
            an().setRequestedOrientation(1);
        }
        super.mj_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1576015797, a);
    }

    public final void m19453e(Bundle bundle) {
        super.e(bundle);
        bundle.putParcelable("config", this.ao);
        bundle.putParcelable("video_uri", this.an);
        VideoEditGalleryFragmentController videoEditGalleryFragmentController = this.ap;
        videoEditGalleryFragmentController.f15436w.f15412b = VideoEditGalleryFragmentController.m19470n(videoEditGalleryFragmentController);
        bundle.putParcelable("state", videoEditGalleryFragmentController.f15436w);
        bundle.putString("entry_point", this.at.getParamKey());
    }

    public final void m19454h(@Nullable Bundle bundle) {
        State state;
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 736012828);
        super.h(bundle);
        if (bundle != null) {
            this.ao = (VideoEditGalleryLaunchConfiguration) bundle.getParcelable("config");
            this.an = (Uri) bundle.getParcelable("video_uri");
            state = (State) bundle.getParcelable("state");
            if (bundle.getString("entry_point", null) == null) {
                this.at = VideoEditingGalleryEntryPoint.UNKNOWN;
            } else {
                this.at = VideoEditingGalleryEntryPoint.valueOf(bundle.getString("entry_point"));
            }
        } else {
            state = null;
        }
        if (state == null) {
            state = new State(this.ao.f6203c, this.ao.f6201a);
        }
        m19446a(state);
        LogUtils.f(492207735, a);
    }

    private void m19446a(State state) {
        this.ap = this.am.m19477a(this, this.an, state, this.as, this.ax, this.ao);
        VideoEditGalleryFragmentController videoEditGalleryFragmentController = this.ap;
        ExecutorDetour.a(videoEditGalleryFragmentController.f15417d, new C11725(videoEditGalleryFragmentController), -1597400370);
    }

    public final void m19452a(VideoEditGalleryLaunchConfiguration videoEditGalleryLaunchConfiguration, Uri uri, VideoEditGalleryCallback videoEditGalleryCallback, @Nullable AnimationParam animationParam, VideoEditingGalleryEntryPoint videoEditingGalleryEntryPoint) {
        this.ao = videoEditGalleryLaunchConfiguration;
        this.an = uri;
        this.as = videoEditGalleryCallback;
        this.ax = animationParam;
        this.at = videoEditingGalleryEntryPoint;
    }

    public final VideoEditGalleryVideoPreviewView as() {
        return this.aw.f15447b;
    }

    public final VideoEditGalleryTrimmerFilmstripView at() {
        return this.aw.f15446a;
    }

    public final ViewStub au() {
        return this.ar;
    }

    public final VideoEditGalleryLaunchConfiguration av() {
        return this.ao;
    }

    public final String aw() {
        return this.ao.f6202b;
    }

    public final VideoEditingGalleryEntryPoint ax() {
        return this.at;
    }
}
