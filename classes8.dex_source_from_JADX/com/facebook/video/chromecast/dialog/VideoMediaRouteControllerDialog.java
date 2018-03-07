package com.facebook.video.chromecast.dialog;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.MediaRouteControllerDialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.video.chromecast.BaseCastManager;
import com.facebook.video.chromecast.VideoCastManager;
import com.facebook.video.chromecast.VideoCastParams;
import com.facebook.video.chromecast.callbacks.VideoCastConsumerAdapter;
import com.facebook.video.chromecast.logging.VideoCastLoggingUtils;
import javax.inject.Inject;

/* compiled from: mAccountCandidates */
public class VideoMediaRouteControllerDialog extends MediaRouteControllerDialog {
    public static final CallerContext f9688b = CallerContext.a(VideoMediaRouteControllerDialog.class, "video_cover");
    @Inject
    public VideoCastManager f9689a;
    public ImageView f9690c;
    public Button f9691d;
    public ProgressBar f9692e;
    public VideoCastParams f9693f;
    private VideoDialogCastConsumer f9694g;

    /* compiled from: mAccountCandidates */
    class C10211 implements OnClickListener {
        final /* synthetic */ VideoMediaRouteControllerDialog f9683a;

        C10211(VideoMediaRouteControllerDialog videoMediaRouteControllerDialog) {
            this.f9683a = videoMediaRouteControllerDialog;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -899221010);
            VideoMediaRouteControllerDialog videoMediaRouteControllerDialog = this.f9683a;
            videoMediaRouteControllerDialog.f9689a.m11352F();
            videoMediaRouteControllerDialog.dismiss();
            Logger.a(2, EntryType.UI_INPUT_END, 1512044837, a);
        }
    }

    /* compiled from: mAccountCandidates */
    public class C10222 implements OnClickListener {
        final /* synthetic */ VideoMediaRouteControllerDialog f9684a;

        public C10222(VideoMediaRouteControllerDialog videoMediaRouteControllerDialog) {
            this.f9684a = videoMediaRouteControllerDialog;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 2042774100);
            VideoMediaRouteControllerDialog videoMediaRouteControllerDialog = this.f9684a;
            videoMediaRouteControllerDialog.dismiss();
            videoMediaRouteControllerDialog.f9689a.m11349C();
            Logger.a(2, EntryType.UI_INPUT_END, -448589990, a);
        }
    }

    /* compiled from: mAccountCandidates */
    public class C10233 implements OnClickListener {
        final /* synthetic */ VideoMediaRouteControllerDialog f9685a;

        public C10233(VideoMediaRouteControllerDialog videoMediaRouteControllerDialog) {
            this.f9685a = videoMediaRouteControllerDialog;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1157531018);
            VideoMediaRouteControllerDialog videoMediaRouteControllerDialog = this.f9685a;
            videoMediaRouteControllerDialog.dismiss();
            BaseCastManager baseCastManager = videoMediaRouteControllerDialog.f9689a;
            baseCastManager.f9645J.m11436a(VideoCastLoggingUtils.f9698a, baseCastManager.f9647L, baseCastManager.f9646K, baseCastManager.mo620y());
            baseCastManager.m11286j();
            baseCastManager = videoMediaRouteControllerDialog.f9689a;
            if (baseCastManager.f9604w != null) {
                baseCastManager.f9604w.c();
            }
            Logger.a(2, EntryType.UI_INPUT_END, 1429657260, a);
        }
    }

    /* compiled from: mAccountCandidates */
    public class C10244 implements OnClickListener {
        final /* synthetic */ VideoMediaRouteControllerDialog f9686a;

        public C10244(VideoMediaRouteControllerDialog videoMediaRouteControllerDialog) {
            this.f9686a = videoMediaRouteControllerDialog;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 345634646);
            this.f9686a.f9689a.m11348B();
            Logger.a(2, EntryType.UI_INPUT_END, -615168058, a);
        }
    }

    /* compiled from: mAccountCandidates */
    class VideoDialogCastConsumer extends VideoCastConsumerAdapter {
        final /* synthetic */ VideoMediaRouteControllerDialog f9687a;

        public VideoDialogCastConsumer(VideoMediaRouteControllerDialog videoMediaRouteControllerDialog) {
            this.f9687a = videoMediaRouteControllerDialog;
        }

        public final void m11400a() {
            if (this.f9687a.f9693f != null) {
                if (this.f9687a.f9689a.m11366a(this.f9687a.f9693f.f9665a)) {
                    this.f9687a.m11414a(this.f9687a.f9689a.mo605A());
                    VideoMediaRouteControllerDialog.m11409b(this.f9687a, this.f9687a.f9689a.mo605A());
                    return;
                }
                if (this.f9687a.f9689a.m11356M() && this.f9687a.f9689a.m11369b(this.f9687a.f9693f.f9665a)) {
                    Object obj;
                    VideoMediaRouteControllerDialog videoMediaRouteControllerDialog = this.f9687a;
                    VideoCastParams videoCastParams = this.f9687a.f9693f;
                    if (videoMediaRouteControllerDialog.f9689a.f9648M == null || videoMediaRouteControllerDialog.f9689a.f9648M.f9665a.equals(videoCastParams.f9665a)) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        this.f9687a.dismiss();
                        return;
                    }
                }
                VideoMediaRouteControllerDialog.m11412i(this.f9687a);
            } else if (this.f9687a.f9689a.m11357O()) {
                VideoMediaRouteControllerDialog.m11412i(this.f9687a);
            }
        }

        public final void m11401b() {
            VideoMediaRouteControllerDialog.m11412i(this.f9687a);
        }

        public final void m11402d() {
        }

        public final void m11403e() {
        }
    }

    public static void m11407a(Object obj, Context context) {
        ((VideoMediaRouteControllerDialog) obj).f9689a = VideoCastManager.m11337a(FbInjector.get(context));
    }

    public VideoMediaRouteControllerDialog(Context context) {
        super(context);
        Class cls = VideoMediaRouteControllerDialog.class;
        m11407a((Object) this, getContext());
    }

    public void setContentView(int i) {
        super.setContentView(2130907692);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m11410e();
        this.f9691d = (Button) findViewById(2131563940);
        this.f9691d.setOnClickListener(new C10222(this));
        m11409b(this, this.f9689a.mo605A());
        this.f9691d.setVisibility(8);
        ((Button) findViewById(2131563939)).setOnClickListener(new C10233(this));
        this.f9694g = new VideoDialogCastConsumer(this);
        this.f9689a.m11361a(this.f9694g);
    }

    private void m11410e() {
        VideoCastParams videoCastParams = this.f9689a.f9648M;
        FrameLayout frameLayout = (FrameLayout) findViewById(2131568372);
        if (videoCastParams == null || this.f9689a.m11369b(videoCastParams.f9665a)) {
            frameLayout.setVisibility(8);
            return;
        }
        View a = m11404a(videoCastParams);
        frameLayout.setOnClickListener(new C10211(this));
        frameLayout.addView(a);
        frameLayout.setVisibility(0);
    }

    private View m11404a(VideoCastParams videoCastParams) {
        View h = m11411h();
        m11406a(h, videoCastParams);
        m11405a(h, 2131568371, getContext().getText(2131238999).toString());
        return h;
    }

    public final View m11413a() {
        this.f9693f = this.f9689a.f9647L;
        if (this.f9693f == null || !this.f9689a.m11357O()) {
            return null;
        }
        View h = m11411h();
        m11406a(h, this.f9693f);
        this.f9690c = (ImageView) h.findViewById(2131568367);
        h.setOnClickListener(new C10244(this));
        this.f9692e = (ProgressBar) h.findViewById(2131562398);
        m11414a(this.f9689a.mo605A());
        return h;
    }

    private static void m11406a(View view, VideoCastParams videoCastParams) {
        if (videoCastParams != null) {
            FbDraweeView fbDraweeView = (FbDraweeView) view.findViewById(2131560814);
            ImageRequest imageRequest = videoCastParams.f9675k;
            if (imageRequest != null) {
                fbDraweeView.a(imageRequest.c, f9688b);
                fbDraweeView.setVisibility(0);
            } else {
                fbDraweeView.setVisibility(8);
            }
            m11405a(view, 2131568369, videoCastParams.f9666b);
            m11405a(view, 2131568370, videoCastParams.f9667c);
        }
    }

    private View m11411h() {
        return getLayoutInflater().inflate(2130907691, (ViewGroup) findViewById(2131563931), false);
    }

    public static void m11405a(View view, int i, String str) {
        TextView textView = (TextView) view.findViewById(i);
        if (str == null || str.isEmpty()) {
            textView.setVisibility(8);
            return;
        }
        textView.setText(str);
        textView.setVisibility(0);
    }

    public final void m11414a(int i) {
        m11408a(false);
        switch (i) {
            case 1:
            case 3:
                this.f9690c.setImageResource(2130840836);
                return;
            case 2:
                this.f9690c.setImageResource(2130840835);
                return;
            case 4:
                m11408a(true);
                return;
            default:
                this.f9690c.setVisibility(8);
                return;
        }
    }

    private void m11408a(boolean z) {
        int i;
        int i2 = 8;
        ProgressBar progressBar = this.f9692e;
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        progressBar.setVisibility(i);
        ImageView imageView = this.f9690c;
        if (!z) {
            i2 = 0;
        }
        imageView.setVisibility(i2);
    }

    public static void m11409b(VideoMediaRouteControllerDialog videoMediaRouteControllerDialog, int i) {
        if (VideoCastManager.m11346d(i)) {
            videoMediaRouteControllerDialog.f9691d.setVisibility(0);
        } else {
            videoMediaRouteControllerDialog.f9691d.setVisibility(8);
        }
    }

    public void dismiss() {
        super.dismiss();
        this.f9689a.m11367b(this.f9694g);
    }

    public static void m11412i(VideoMediaRouteControllerDialog videoMediaRouteControllerDialog) {
        View a = videoMediaRouteControllerDialog.a();
        FrameLayout frameLayout = (FrameLayout) videoMediaRouteControllerDialog.findViewById(2131563931);
        if (a != null) {
            frameLayout.addView(a);
            frameLayout.setVisibility(0);
        } else {
            frameLayout.setVisibility(8);
        }
        videoMediaRouteControllerDialog.m11410e();
    }
}
