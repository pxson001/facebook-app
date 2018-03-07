package com.facebook.messaging.montage.viewer;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import com.facebook.common.ui.util.LayoutParamsUtil;
import com.facebook.common.util.FindViewUtil;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.attachments.AttachmentDataFactory;
import com.facebook.messaging.attachments.VideoAttachmentData;
import com.facebook.messaging.messageclassifier.MessageClassification;
import com.facebook.messaging.messageclassifier.MessageClassifier;
import com.facebook.messaging.model.messages.Message;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.engine.AbstractVideoPlayerListener;
import com.facebook.video.engine.Constants.VideoError;
import com.facebook.video.engine.VideoPlayerParams;
import com.facebook.video.engine.VideoPlayerParamsBuilder;
import com.facebook.video.player.InlineVideoView;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: is_correctness_testing */
public class MontageVideoFragment extends AbstractMontageItemFragment {
    private InlineVideoView al;
    private VideoAttachmentData am;
    public boolean an;
    private boolean ao;
    private long ap;
    @Inject
    public AttachmentDataFactory f12616h;
    @Inject
    public MessageClassifier f12617i;

    /* compiled from: is_correctness_testing */
    class C14161 extends AbstractVideoPlayerListener {
        final /* synthetic */ MontageVideoFragment f12614a;

        C14161(MontageVideoFragment montageVideoFragment) {
            this.f12614a = montageVideoFragment;
        }

        public final void m13066a() {
            this.f12614a.aA();
        }

        public final void m13067a(int i) {
            this.f12614a.an = true;
            this.f12614a.aB();
        }

        public final void m13068a(String str, VideoError videoError) {
            this.f12614a.m13026a(new RuntimeException("Error loading montage video: " + videoError + " stage: " + str));
        }
    }

    /* compiled from: is_correctness_testing */
    class C14172 implements OnLayoutChangeListener {
        final /* synthetic */ MontageVideoFragment f12615a;

        C14172(MontageVideoFragment montageVideoFragment) {
            this.f12615a = montageVideoFragment;
        }

        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            MontageVideoFragment.aC(this.f12615a);
        }
    }

    public static void m13069a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        MontageVideoFragment montageVideoFragment = (MontageVideoFragment) obj;
        AttachmentDataFactory a = AttachmentDataFactory.a(fbInjector);
        MessageClassifier a2 = MessageClassifier.a(fbInjector);
        montageVideoFragment.f12616h = a;
        montageVideoFragment.f12617i = a2;
    }

    public final void mo496c(@Nullable Bundle bundle) {
        super.mo496c(bundle);
        Class cls = MontageVideoFragment.class;
        m13069a((Object) this, getContext());
        Message message = this.f12577g.f12555b;
        if (this.f12617i.a(message) != MessageClassification.VIDEO_CLIP) {
            throw new IllegalStateException("Loaded a StatusVideoFragment with a non-video message.");
        }
        this.am = this.f12616h.j(message);
    }

    protected final void mo492a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        this.al = (InlineVideoView) FindViewUtil.b(layoutInflater.inflate(2130905343, viewGroup, true), 2131563188);
        this.al.s = new C14161(this);
        this.T.addOnLayoutChangeListener(new C14172(this));
    }

    public final void mo497d(@Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1799690234);
        super.mo497d(bundle);
        HandlerDetour.a(this.f12572b, this.aB);
        HandlerDetour.a(this.f12572b, this.aC, 2134122628);
        aC(this);
        InlineVideoView inlineVideoView = this.al;
        VideoPlayerParamsBuilder a2 = VideoPlayerParams.newBuilder().a(ImmutableList.copyOf(this.am.f7769f));
        a2.b = this.am.f7772i;
        a2 = a2;
        a2.c = this.am.f7767d;
        inlineVideoView.setVideoData(a2.m());
        this.al.f();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -43412242, a);
    }

    protected final void aq() {
        if (!this.al.c()) {
            this.al.b(EventTriggerType.BY_AUTOPLAY);
        }
    }

    protected final void ar() {
        if (this.al != null && this.al.c()) {
            this.al.d(EventTriggerType.BY_ANDROID);
        }
    }

    public final long as() {
        if (ay()) {
            return this.ap;
        }
        if (this.am == null) {
            return 0;
        }
        if (this.an) {
            return 0;
        }
        long j = (long) this.am.f7767d;
        if (this.ar) {
            j -= (long) this.al.getCurrentPosition();
        }
        return Math.max(0, j);
    }

    public final void av() {
        this.ap = as();
        this.ao = true;
        this.al.d(EventTriggerType.BY_USER);
    }

    public final void aw() {
        if (this.ao) {
            this.ao = false;
            this.al.b(EventTriggerType.BY_USER);
        }
    }

    public final void ax() {
        this.ao = false;
        this.ap = this.am == null ? 0 : (long) this.am.f7767d;
        this.al.a(EventTriggerType.BY_PLAYER);
    }

    public final boolean ay() {
        return this.ao;
    }

    public static void aC(MontageVideoFragment montageVideoFragment) {
        int width = montageVideoFragment.T.getWidth();
        int height = montageVideoFragment.T.getHeight();
        float f = ((float) width) / ((float) height);
        float f2 = ((float) montageVideoFragment.am.f7764a) / ((float) montageVideoFragment.am.f7765b);
        if (montageVideoFragment.am.f7764a > montageVideoFragment.am.f7765b) {
            montageVideoFragment.al.setRotation(90.0f);
        } else {
            montageVideoFragment.al.setRotation(0.0f);
            int i = height;
            height = width;
            width = i;
        }
        if (f2 <= f) {
            height = (int) (((float) width) * f2);
        } else {
            width = (int) (((float) height) / f2);
        }
        LayoutParamsUtil.a(montageVideoFragment.al, height, width);
    }
}
