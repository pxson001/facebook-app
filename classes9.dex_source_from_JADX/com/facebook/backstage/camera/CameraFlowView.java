package com.facebook.backstage.camera;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.Toast;
import com.facebook.backstage.analytics.BackstageAnalyticsLogger;
import com.facebook.backstage.analytics.BackstageAnalyticsLogger.Event;
import com.facebook.backstage.camera.CameraView.CameraViewListener;
import com.facebook.backstage.camera.PreviewView.PreviewViewListener;
import com.facebook.backstage.consumption.BackstageUploadService;
import com.facebook.backstage.consumption.HolderListener;
import com.facebook.backstage.consumption.camera.CameraOptions;
import com.facebook.backstage.data.LocalShot;
import com.facebook.backstage.data.LocalShot.MediaType;
import com.facebook.backstage.data.UploadShot;
import com.facebook.backstage.ui.LazyView;
import com.facebook.backstage.ui.LazyView.OnInflateRunner;
import com.facebook.backstage.ui.ViewAnimator;
import com.facebook.backstage.ui.ViewAnimator.OnFinishListener;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.optic.CameraPreviewView;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

@TargetApi(16)
/* compiled from: search_typeahead_pre_connect */
public class CameraFlowView extends FrameLayout {
    protected final CameraView f4318a;
    protected final LazyView<PreviewView> f4319b;
    protected final LazyView<TextOnlyPreviewView> f4320c;
    public CameraFlowState f4321d;
    protected float f4322e;
    public String f4323f;
    protected String f4324g;
    @Inject
    Lazy<SecureContextHelper> f4325h;
    @Inject
    BackstageAnalyticsLogger f4326i;
    public boolean f4327j;
    public List<CameraInteractionListener> f4328k;
    public HolderListener f4329l;
    public boolean f4330m;
    private boolean f4331n;

    /* compiled from: search_typeahead_pre_connect */
    class C03921 implements OnInflateRunner<TextOnlyPreviewView> {
        final /* synthetic */ CameraFlowView f4311a;

        C03921(CameraFlowView cameraFlowView) {
            this.f4311a = cameraFlowView;
        }

        public final void mo137a(View view) {
            final TextOnlyPreviewView textOnlyPreviewView = (TextOnlyPreviewView) view;
            textOnlyPreviewView.f4468o = new TextOnlyListener(this) {
                final /* synthetic */ C03921 f4310b;

                public final void mo136a(LocalShot localShot) {
                    String str;
                    String str2;
                    String str3 = localShot.f5129e;
                    String str4 = localShot.f5132h;
                    MediaType mediaType = localShot.f5126b;
                    long time = localShot.f5125a.getTime();
                    if (this.f4310b.f4311a.f4323f == null) {
                        str = "";
                    } else {
                        str = this.f4310b.f4311a.f4323f;
                    }
                    if (this.f4310b.f4311a.f4324g == null) {
                        str2 = "";
                    } else {
                        str2 = this.f4310b.f4311a.f4324g;
                    }
                    UploadShot uploadShot = new UploadShot(str3, str4, mediaType, time, str, str2);
                    BackstageUploadService.m4523a((SecureContextHelper) this.f4310b.f4311a.f4325h.get(), this.f4310b.f4311a.getContext(), uploadShot);
                    for (CameraInteractionListener a : this.f4310b.f4311a.f4328k) {
                        a.mo157a();
                    }
                }

                public final void mo135a() {
                    textOnlyPreviewView.m4447a();
                    this.f4310b.f4311a.mo160b(false);
                }
            };
        }
    }

    /* compiled from: search_typeahead_pre_connect */
    class C03942 implements OnInflateRunner<PreviewView> {
        final /* synthetic */ CameraFlowView f4314a;

        C03942(CameraFlowView cameraFlowView) {
            this.f4314a = cameraFlowView;
        }

        public final void mo137a(View view) {
            final PreviewView previewView = (PreviewView) view;
            previewView.f4445m = new PreviewViewListener(this) {
                final /* synthetic */ C03942 f4313b;

                public final void mo138a() {
                    previewView.m4431a();
                    this.f4313b.f4314a.setState(CameraFlowState.CAMERA);
                }

                public final void mo139a(LocalShot localShot) {
                    String str;
                    String str2;
                    String str3 = localShot.f5129e;
                    String str4 = localShot.f5132h;
                    MediaType mediaType = localShot.f5126b;
                    long time = localShot.f5125a.getTime();
                    if (this.f4313b.f4314a.f4323f == null) {
                        str = "";
                    } else {
                        str = this.f4313b.f4314a.f4323f;
                    }
                    if (this.f4313b.f4314a.f4324g == null) {
                        str2 = "";
                    } else {
                        str2 = this.f4313b.f4314a.f4324g;
                    }
                    UploadShot uploadShot = new UploadShot(str3, str4, mediaType, time, str, str2);
                    BackstageUploadService.m4523a((SecureContextHelper) this.f4313b.f4314a.f4325h.get(), this.f4313b.f4314a.getContext(), uploadShot);
                    for (CameraInteractionListener a : this.f4313b.f4314a.f4328k) {
                        a.mo157a();
                    }
                }
            };
        }
    }

    /* compiled from: search_typeahead_pre_connect */
    class C03953 implements CameraViewListener {
        final /* synthetic */ CameraFlowView f4315a;

        C03953(CameraFlowView cameraFlowView) {
            this.f4315a = cameraFlowView;
        }

        public final void mo140a(LocalShot localShot) {
            this.f4315a.f4326i.m4264a(localShot.m4911i() ? Event.CAMERA_PHOTO_CAPTURE : Event.CAMERA_VIDEO_CAPTURE);
            ((PreviewView) this.f4315a.f4319b.m5715a()).setShot(localShot);
            this.f4315a.f4326i.m4264a(Event.CAMERA_MEDIA_PREVIEW);
            this.f4315a.setState(CameraFlowState.PREVIEW);
        }

        public final void mo141a(String str) {
            Toast.makeText(this.f4315a.getContext(), str, 1).show();
        }
    }

    /* compiled from: search_typeahead_pre_connect */
    class C03964 implements OnFinishListener {
        final /* synthetic */ CameraFlowView f4316a;

        C03964(CameraFlowView cameraFlowView) {
            this.f4316a = cameraFlowView;
        }

        public final void mo142a() {
            this.f4316a.f4327j = false;
            if (this.f4316a.f4329l != null) {
                this.f4316a.f4329l.mo143a();
            }
        }
    }

    /* compiled from: search_typeahead_pre_connect */
    public enum CameraFlowState {
        CAMERA,
        PREVIEW,
        TEXT
    }

    /* compiled from: search_typeahead_pre_connect */
    public interface CameraInteractionListener {
        void mo157a();

        void mo158b();
    }

    private static <T extends View> void m4304a(Class<T> cls, T t) {
        m4305a((Object) t, t.getContext());
    }

    private static void m4305a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((CameraFlowView) obj).m4303a(IdBasedSingletonScopeProvider.b(injectorLike, 968), BackstageAnalyticsLogger.m4259a(injectorLike));
    }

    private void m4303a(Lazy<SecureContextHelper> lazy, BackstageAnalyticsLogger backstageAnalyticsLogger) {
        this.f4325h = lazy;
        this.f4326i = backstageAnalyticsLogger;
    }

    public CameraFlowView(Context context) {
        this(context, null);
    }

    public CameraFlowView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CameraFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4327j = false;
        this.f4328k = new ArrayList();
        this.f4322e = 1.7777778f;
        m4304a(CameraFlowView.class, (View) this);
        View.inflate(context, 2130903485, this);
        this.f4318a = (CameraView) findViewById(2131560150);
        this.f4320c = new LazyView((ViewStub) findViewById(2131560151), new C03921(this));
        this.f4319b = new LazyView((ViewStub) findViewById(2131560152), new C03942(this));
        this.f4318a.f4379x = new C03953(this);
        setBackground(new ColorDrawable(-16777216));
    }

    public void setHolderListener(HolderListener holderListener) {
        this.f4329l = holderListener;
    }

    public void setIsHiding(boolean z) {
        ((PreviewView) this.f4319b.m5715a()).setIsHiding(z);
    }

    public final boolean m4310a() {
        return this.f4330m;
    }

    public void setXBy(float f) {
        setX(getX() + f);
    }

    public final boolean m4312a(boolean z) {
        if (this.f4321d == null) {
            mo160b(true);
            return false;
        }
        switch (this.f4321d) {
            case PREVIEW:
                ((PreviewView) this.f4319b.m5715a()).m4431a();
                setState(CameraFlowState.CAMERA);
                return true;
            case TEXT:
            case CAMERA:
                if (!z || getVisibility() != 0) {
                    return false;
                }
                if (!this.f4327j) {
                    mo160b(false);
                }
                return true;
            default:
                return false;
        }
    }

    public final void m4308a(CameraInteractionListener cameraInteractionListener) {
        List arrayList = new ArrayList(this.f4328k);
        arrayList.add(cameraInteractionListener);
        this.f4328k = arrayList;
    }

    public final void m4314b(CameraInteractionListener cameraInteractionListener) {
        List arrayList = new ArrayList(this.f4328k);
        arrayList.remove(cameraInteractionListener);
        this.f4328k = arrayList;
    }

    public final void m4309a(CameraOptions cameraOptions) {
        this.f4323f = cameraOptions.f4713c;
        this.f4324g = cameraOptions.f4714d;
        this.f4322e = cameraOptions.f4711a;
        this.f4330m = cameraOptions.f4716f;
        this.f4331n = cameraOptions.f4715e;
        if (cameraOptions.f4712b != null && cameraOptions.f4712b.booleanValue()) {
            this.f4318a.setSelfie(true);
        }
        if (this.f4331n) {
            setState(CameraFlowState.TEXT);
            setVisibility(0);
            ((TextOnlyPreviewView) this.f4320c.m5715a()).m4448b();
        } else {
            setState(CameraFlowState.CAMERA);
            ViewAnimator d = ViewAnimator.m5752a((View) this).m5760d(0.0f, 1.0f);
            d.f5549z = 0;
            d.m5759d();
        }
        this.f4326i.m4264a(Event.CAMERA_OPEN);
    }

    public void mo160b(boolean z) {
        if (z) {
            this.f4329l.mo143a();
        } else if (!this.f4327j) {
            for (CameraInteractionListener b : this.f4328k) {
                b.mo158b();
            }
            this.f4327j = true;
            ViewAnimator d = ViewAnimator.m5752a((View) this).m5760d(1.0f, 0.0f);
            d.f5524A = 8;
            d = d;
            d.f5528e = new C03964(this);
            d.m5759d();
        }
    }

    public final boolean m4311a(MotionEvent motionEvent) {
        Rect rect = new Rect();
        rect.left = (int) getX();
        rect.right = (int) (getX() + ((float) getWidth()));
        rect.top = (int) getY();
        rect.bottom = (int) (getY() + ((float) getHeight()));
        return rect.contains((int) motionEvent.getX(), (int) motionEvent.getY());
    }

    public final boolean m4316b(MotionEvent motionEvent) {
        if (this.f4321d == CameraFlowState.CAMERA) {
            return this.f4318a.m4388a(motionEvent);
        }
        if (this.f4321d == CameraFlowState.PREVIEW) {
            return ((PreviewView) this.f4319b.m5715a()).m4432a(motionEvent);
        }
        return false;
    }

    public final void m4313b() {
        CameraView cameraView = this.f4318a;
        CameraPreviewView.a();
    }

    public final void m4317c() {
        this.f4318a.m4389b();
    }

    protected void setState(CameraFlowState cameraFlowState) {
        this.f4321d = cameraFlowState;
        switch (this.f4321d) {
            case PREVIEW:
                this.f4318a.setVisibility(8);
                ((PreviewView) this.f4319b.m5715a()).setVisibility(0);
                this.f4320c.m5717c();
                return;
            case TEXT:
                this.f4318a.m4390c();
                this.f4318a.setVisibility(8);
                this.f4319b.m5717c();
                ((TextOnlyPreviewView) this.f4320c.m5715a()).setVisibility(0);
                return;
            case CAMERA:
                this.f4318a.setVisibility(0);
                this.f4319b.m5717c();
                this.f4320c.m5717c();
                return;
            default:
                return;
        }
    }

    protected void onMeasure(int i, int i2) {
        if (this.f4322e == -1.0f) {
            super.onMeasure(i, i2);
            return;
        }
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        float f = this.f4322e;
        int i3 = (int) ((((float) size) * f) / 1.0f);
        if (i3 > size2) {
            i3 = (int) ((((float) size2) * 1.0f) / f);
        } else {
            size2 = i3;
            i3 = size;
        }
        super.onMeasure(MeasureSpec.makeMeasureSpec(i3, 1073741824), MeasureSpec.makeMeasureSpec(size2, 1073741824));
    }
}
