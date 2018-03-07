package com.facebook.backstage.camera;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.facebook.backstage.data.LocalShot;
import com.facebook.backstage.media.MediaProcessor;
import com.facebook.backstage.ui.MediaView;
import com.facebook.backstage.ui.ToggleableEditText;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbButton;
import com.facebook.resources.ui.FbTextView;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.text.DateFormat;
import java.util.Date;
import javax.inject.Inject;

/* compiled from: search_session_started_by_user */
public class PreviewView extends FrameLayout {
    public static final String f4433d = PreviewView.class.getSimpleName();
    @Inject
    @ForUiThread
    public ListeningExecutorService f4434a;
    @Inject
    public MediaProcessor f4435b;
    @Inject
    public AbstractFbErrorReporter f4436c;
    private final ViewGroup f4437e;
    private final MediaView f4438f;
    public final FbButton f4439g;
    public final ToggleableEditText f4440h;
    private final FbTextView f4441i;
    private final FbButton f4442j;
    private OnClickListener f4443k;
    public LocalShot f4444l;
    public PreviewViewListener f4445m;
    public ListenableFuture f4446n;
    private final OnClickListener f4447o;

    /* compiled from: search_session_started_by_user */
    public interface PreviewViewListener {
        void mo138a();

        void mo139a(LocalShot localShot);
    }

    /* compiled from: search_session_started_by_user */
    class C04191 implements OnClickListener {
        final /* synthetic */ PreviewView f4430a;

        /* compiled from: search_session_started_by_user */
        class C04181 implements FutureCallback<Void> {
            final /* synthetic */ C04191 f4429a;

            C04181(C04191 c04191) {
                this.f4429a = c04191;
            }

            public void onSuccess(Object obj) {
                if (this.f4429a.f4430a.f4445m != null) {
                    this.f4429a.f4430a.f4445m.mo139a(this.f4429a.f4430a.f4444l);
                }
                this.f4429a.f4430a.f4439g.setEnabled(true);
            }

            public void onFailure(Throwable th) {
                this.f4429a.f4430a.f4439g.setEnabled(true);
                this.f4429a.f4430a.f4436c.a(SoftError.a(PreviewView.f4433d, "Failed to decode media to bitmap or video file").g());
            }
        }

        C04191(PreviewView previewView) {
            this.f4430a = previewView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 900886179);
            this.f4430a.f4444l.f5132h = this.f4430a.f4440h.getText().toString();
            this.f4430a.f4439g.setEnabled(false);
            this.f4430a.m4427d();
            Futures.a(this.f4430a.f4446n, new C04181(this), this.f4430a.f4434a);
            Logger.a(2, EntryType.UI_INPUT_END, 1093985136, a);
        }
    }

    /* compiled from: search_session_started_by_user */
    class C04202 implements OnClickListener {
        final /* synthetic */ PreviewView f4431a;

        C04202(PreviewView previewView) {
            this.f4431a = previewView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -161550073);
            this.f4431a.f4440h.m5735b();
            Logger.a(2, EntryType.UI_INPUT_END, -715217312, a);
        }
    }

    /* compiled from: search_session_started_by_user */
    class C04213 implements OnClickListener {
        final /* synthetic */ PreviewView f4432a;

        C04213(PreviewView previewView) {
            this.f4432a = previewView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1164330084);
            if (this.f4432a.f4445m != null) {
                this.f4432a.f4445m.mo138a();
            }
            Logger.a(2, EntryType.UI_INPUT_END, -361411983, a);
        }
    }

    private static <T extends View> void m4421a(Class<T> cls, T t) {
        m4422a((Object) t, t.getContext());
    }

    private static void m4422a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        PreviewView previewView = (PreviewView) obj;
        ListeningExecutorService listeningExecutorService = (ListeningExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike);
        MediaProcessor a = MediaProcessor.m5621a(injectorLike);
        AbstractFbErrorReporter abstractFbErrorReporter = (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike);
        previewView.f4434a = listeningExecutorService;
        previewView.f4435b = a;
        previewView.f4436c = abstractFbErrorReporter;
    }

    public void setIsHiding(boolean z) {
        if (z) {
            this.f4438f.setOnClickListener(null);
            this.f4440h.m5737c();
            return;
        }
        this.f4438f.setOnClickListener(this.f4447o);
    }

    public PreviewView(Context context) {
        this(context, null);
    }

    public PreviewView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PreviewView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4443k = new C04191(this);
        this.f4447o = new C04202(this);
        m4421a(PreviewView.class, (View) this);
        View.inflate(context, 2130906371, this);
        this.f4438f = (MediaView) findViewById(2131563004);
        this.f4439g = (FbButton) findViewById(2131562068);
        this.f4442j = (FbButton) findViewById(2131566217);
        this.f4437e = (ViewGroup) findViewById(2131566216);
        this.f4440h = (ToggleableEditText) findViewById(2131559899);
        this.f4441i = (FbTextView) findViewById(2131559889);
        ColorStateList valueOf = ColorStateList.valueOf(context.getResources().getColor(2131361916));
        this.f4439g.getBackground().setColorFilter(new PorterDuffColorFilter(valueOf.getDefaultColor(), Mode.SRC_IN));
        this.f4442j.getBackground().setColorFilter(new PorterDuffColorFilter(valueOf.getDefaultColor(), Mode.SRC_IN));
        this.f4438f.setOnClickListener(this.f4447o);
        this.f4442j.setOnClickListener(new C04213(this));
        this.f4440h.m5733a();
    }

    public void setListener(PreviewViewListener previewViewListener) {
        this.f4445m = previewViewListener;
    }

    public final boolean m4432a(MotionEvent motionEvent) {
        return motionEvent.getY() > this.f4437e.getY();
    }

    public void setShot(LocalShot localShot) {
        this.f4444l = localShot;
        if (localShot.m4911i()) {
            this.f4438f.m5719a(this.f4444l.f5127c, this.f4444l.f5130f, this.f4444l.f5131g);
        } else {
            this.f4438f.setVideo$44bdce70(this.f4444l.f5128d);
        }
        this.f4439g.setOnClickListener(this.f4443k);
        m4426c();
    }

    public final void m4431a() {
        this.f4439g.setOnClickListener(null);
        this.f4440h.m5737c();
        this.f4438f.m5718a();
        this.f4440h.setText("");
        this.f4444l = null;
        this.f4446n = null;
    }

    private void m4426c() {
        this.f4441i.setText(DateFormat.getTimeInstance(3).format(new Date()));
    }

    private void m4427d() {
        this.f4446n = this.f4435b.m5623a(this.f4444l);
    }
}
