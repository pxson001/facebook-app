package com.facebook.timeline.profilevideo;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.references.CloseableReference;
import com.facebook.device.ScreenUtil;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.timeline.profilevideo.model.ProfileVideoModel;
import com.facebook.timeline.profilevideo.model.ProfileVideoModelStore;
import com.facebook.timeline.profilevideo.service.ProfileVideoThumbnailTaskManager;
import com.facebook.timeline.profilevideo.view.ScrubberThumb;
import com.facebook.timeline.profilevideo.view.SimpleNewsFeedAdapter;
import com.facebook.timeline.profilevideo.view.SimpleNewsFeedAnimator;
import com.facebook.timeline.profilevideo.view.SimpleNewsFeedView;
import com.facebook.video.scrubber.GLFrameRetrieverProvider;
import com.facebook.videocodec.effects.renderers.EffectsFactory;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: mPulsarRssi */
public class ProfileVideoEditFragment extends FbFragment {
    @Inject
    public ScreenUtil f9290a;
    public boolean al = false;
    public boolean am = false;
    public ScrubberThumb an;
    public SeekBar ao;
    public float ap;
    @Nullable
    public CloseableReference<Bitmap> aq;
    public final List<CloseableReference<Bitmap>> ar = new ArrayList();
    private String as;
    public final C09651 at = new C09651(this);
    public final C09662 au = new C09662(this);
    private final OnSeekBarChangeListener av = new C09673(this);
    @Inject
    public ProfileVideoThumbnailGenerator f9291b;
    public SimpleNewsFeedView f9292c;
    public SimpleNewsFeedAdapter f9293d;
    public SimpleNewsFeedAnimator f9294e;
    public View f9295f;
    public ImageView f9296g;
    public LinearLayout f9297h;
    private View f9298i;

    /* compiled from: mPulsarRssi */
    public class C09651 {
        public final /* synthetic */ ProfileVideoEditFragment f9286a;

        C09651(ProfileVideoEditFragment profileVideoEditFragment) {
            this.f9286a = profileVideoEditFragment;
        }

        public final void m11047a(int i) {
            Object obj;
            this.f9286a.al = false;
            ProfileVideoEditFragment.as(this.f9286a);
            ProfileVideoThumbnailGenerator profileVideoThumbnailGenerator = this.f9286a.f9291b;
            C09651 c09651 = this.f9286a.at;
            ProfileVideoThumbnailTaskManager profileVideoThumbnailTaskManager = profileVideoThumbnailGenerator.f9351b;
            if (profileVideoThumbnailTaskManager.f9402f || profileVideoThumbnailTaskManager.f9399c != null) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj == null) {
                profileVideoThumbnailGenerator.m11106a(i, c09651, 1.0f);
            }
        }
    }

    /* compiled from: mPulsarRssi */
    public class C09662 {
        public final /* synthetic */ ProfileVideoEditFragment f9287a;

        C09662(ProfileVideoEditFragment profileVideoEditFragment) {
            this.f9287a = profileVideoEditFragment;
        }
    }

    /* compiled from: mPulsarRssi */
    class C09673 implements OnSeekBarChangeListener {
        final /* synthetic */ ProfileVideoEditFragment f9288a;

        C09673(ProfileVideoEditFragment profileVideoEditFragment) {
            this.f9288a = profileVideoEditFragment;
        }

        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            ProfileVideoModel ar = ProfileVideoEditFragment.ar(this.f9288a);
            if (ar != null) {
                int h = ar.m11131h();
                this.f9288a.f9291b.m11106a((((ar.m11132i() - h) * i) / 100) + h, this.f9288a.at, 1.0f);
            }
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
            if (this.f9288a.f9294e != null) {
                SimpleNewsFeedAnimator simpleNewsFeedAnimator = this.f9288a.f9294e;
                simpleNewsFeedAnimator.f9512n = true;
                simpleNewsFeedAnimator.f9500b.postDelayed(simpleNewsFeedAnimator.f9513o, 150);
                this.f9288a.am = true;
                ProfileVideoEditFragment.as(this.f9288a);
            }
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            if (this.f9288a.f9294e != null) {
                SimpleNewsFeedAnimator simpleNewsFeedAnimator = this.f9288a.f9294e;
                if (simpleNewsFeedAnimator.f9512n) {
                    simpleNewsFeedAnimator.f9500b.removeCallbacks(simpleNewsFeedAnimator.f9513o);
                } else {
                    if (simpleNewsFeedAnimator.f9504f != null) {
                        simpleNewsFeedAnimator.f9504f.cancel();
                    }
                    ImageView imageView = simpleNewsFeedAnimator.f9503e.f9494a;
                    if (imageView != null) {
                        imageView.setVisibility(0);
                        Animator animatorSet = new AnimatorSet();
                        animatorSet.play(ObjectAnimator.ofFloat(simpleNewsFeedAnimator.f9502d, View.X, new float[]{(float) simpleNewsFeedAnimator.f9506h.left, (float) simpleNewsFeedAnimator.f9505g.left})).with(ObjectAnimator.ofFloat(simpleNewsFeedAnimator.f9502d, View.Y, new float[]{(float) simpleNewsFeedAnimator.f9506h.top, (float) simpleNewsFeedAnimator.f9505g.top})).with(ObjectAnimator.ofFloat(simpleNewsFeedAnimator.f9502d, View.SCALE_X, new float[]{simpleNewsFeedAnimator.f9509k})).with(ObjectAnimator.ofFloat(simpleNewsFeedAnimator.f9502d, View.SCALE_Y, new float[]{simpleNewsFeedAnimator.f9509k}));
                        animatorSet.setDuration(300);
                        animatorSet.setInterpolator(new DecelerateInterpolator());
                        animatorSet.addListener(simpleNewsFeedAnimator.f9511m);
                        animatorSet.start();
                        simpleNewsFeedAnimator.f9504f = animatorSet;
                    }
                }
                this.f9288a.am = false;
                ProfileVideoEditFragment.as(this.f9288a);
            }
        }
    }

    /* compiled from: mPulsarRssi */
    class C09684 implements Runnable {
        final /* synthetic */ ProfileVideoEditFragment f9289a;

        C09684(ProfileVideoEditFragment profileVideoEditFragment) {
            this.f9289a = profileVideoEditFragment;
        }

        public void run() {
            this.f9289a.f9292c.m11208l();
            this.f9289a.f9294e = new SimpleNewsFeedAnimator(this.f9289a.f9295f, this.f9289a.f9293d);
        }
    }

    public static void m11048a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ProfileVideoEditFragment profileVideoEditFragment = (ProfileVideoEditFragment) obj;
        ScreenUtil a = ScreenUtil.a(fbInjector);
        ProfileVideoThumbnailGenerator profileVideoThumbnailGenerator = new ProfileVideoThumbnailGenerator(new ProfileVideoThumbnailTaskManager(ListeningExecutorService_ForProfileVideoWorkerMethodAutoProvider.m11046a(fbInjector), (ListeningExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(fbInjector)), (GLFrameRetrieverProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(GLFrameRetrieverProvider.class), EffectsFactory.b(fbInjector));
        profileVideoEditFragment.f9290a = a;
        profileVideoEditFragment.f9291b = profileVideoThumbnailGenerator;
    }

    public final void m11054c(Bundle bundle) {
        super.c(bundle);
        Class cls = ProfileVideoEditFragment.class;
        m11048a((Object) this, getContext());
        if (bundle != null) {
            this.as = bundle.getString("session_id");
        } else {
            this.as = this.s.getString("session_id");
        }
    }

    public final void m11055e(Bundle bundle) {
        bundle.putString("session_id", this.as);
        super.e(bundle);
    }

    public final View m11051a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1507023255);
        View inflate = layoutInflater.inflate(2130906485, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -694212466, a);
        return inflate;
    }

    public final void m11052a(View view, Bundle bundle) {
        this.f9291b.m11108a(this);
        this.f9292c = (SimpleNewsFeedView) e(2131566412);
        this.f9293d = new SimpleNewsFeedAdapter();
        this.f9292c.setAdapter(this.f9293d);
        this.f9292c.post(new C09684(this));
        this.f9295f = e(2131566410);
        this.f9296g = (ImageView) e(2131566413);
        this.f9297h = (LinearLayout) e(2131566415);
        this.f9298i = e(2131566414);
        this.ao = (SeekBar) e(2131566416);
        this.ao.setOnSeekBarChangeListener(this.av);
        this.an = new ScrubberThumb(jW_());
        int i = this.ao.getLayoutParams().height;
        ScrubberThumb scrubberThumb = this.an;
        scrubberThumb.f9492j = i;
        scrubberThumb.f9491i = i;
        this.ao.setThumb(this.an);
        this.ap = (float) jW_().getDimensionPixelSize(2131432829);
    }

    private void aq() {
        for (CloseableReference close : this.ar) {
            close.close();
        }
        this.ar.clear();
        this.f9297h.removeAllViews();
        int dimension = (int) jW_().getDimension(2131432825);
        int c = (this.f9290a.c() / dimension) + 1;
        for (int i = 0; i < c; i++) {
            FbDraweeView fbDraweeView = new FbDraweeView(getContext());
            fbDraweeView.setLayoutParams(new LayoutParams(dimension, dimension));
            this.f9297h.addView(fbDraweeView);
        }
        ProfileVideoThumbnailGenerator profileVideoThumbnailGenerator = this.f9291b;
        C09662 c09662 = this.au;
        Preconditions.checkNotNull(profileVideoThumbnailGenerator.f9355f);
        for (int i2 = 0; i2 < c; i2++) {
            int h = profileVideoThumbnailGenerator.f9355f.m11131h();
            profileVideoThumbnailGenerator.m11107a(i2, c09662, 1.0f, h + (((profileVideoThumbnailGenerator.f9355f.m11132i() - h) * i2) / c));
        }
    }

    public final void m11050H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1115433601);
        super.H();
        this.f9291b.m11105a();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1187524417, a);
    }

    public final void m11049G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -433726787);
        super.G();
        m11053b();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1839587333, a);
    }

    public final void m11053b() {
        ProfileVideoModel ar = ar(this);
        if (ar != null) {
            this.f9291b.m11109a(ar);
            ar = ar(this);
            if (ar.f9370c == 0) {
                this.f9291b.m11106a(0, this.at, 1.0f);
            } else {
                int h = ar.m11131h();
                int i = ar.m11132i();
                int i2 = ar.f9370c;
                h = ((i2 - h) * 100) / (i - h);
                this.f9291b.m11106a(i2, this.at, 1.0f);
                this.ao.setProgress(h);
            }
            aq();
        }
    }

    @Nullable
    public static ProfileVideoModel ar(ProfileVideoEditFragment profileVideoEditFragment) {
        FragmentActivity o = profileVideoEditFragment.o();
        if (o instanceof ProfileVideoModelStore) {
            return ((ProfileVideoModelStore) o).mo598i();
        }
        return null;
    }

    public static void as(ProfileVideoEditFragment profileVideoEditFragment) {
        if (profileVideoEditFragment.f9298i == null) {
            return;
        }
        if (profileVideoEditFragment.al && profileVideoEditFragment.am) {
            profileVideoEditFragment.f9298i.setVisibility(0);
        } else {
            profileVideoEditFragment.f9298i.setVisibility(4);
        }
    }
}
