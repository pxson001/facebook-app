package com.facebook.backstage.camera;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.facebook.backstage.data.LocalShot;
import com.facebook.backstage.data.LocalShot.MediaType;
import com.facebook.backstage.media.MediaProcessor;
import com.facebook.backstage.ui.ScalingToggleableEditText;
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
import com.facebook.messaging.doodle.ColourIndicator;
import com.facebook.messaging.doodle.ColourPicker;
import com.facebook.messaging.doodle.ColourPicker.OnColourPickerInteractionListener;
import com.facebook.resources.ui.FbTextView;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.text.DateFormat;
import java.util.Date;
import javax.inject.Inject;

/* compiled from: secondCodePoint */
public class TextOnlyPreviewView extends FrameLayout {
    public static final String f4454d = TextOnlyPreviewView.class.getSimpleName();
    @Inject
    @ForUiThread
    public ListeningExecutorService f4455a;
    @Inject
    public MediaProcessor f4456b;
    @Inject
    public AbstractFbErrorReporter f4457c;
    private final OnClickListener f4458e;
    private final OnClickListener f4459f;
    private final OnColourPickerInteractionListener f4460g;
    public final View f4461h;
    private final View f4462i;
    private final FbTextView f4463j;
    public final ColourIndicator f4464k;
    private final ColourPicker f4465l;
    public final ToggleableEditText f4466m;
    public LocalShot f4467n;
    public TextOnlyListener f4468o;
    public ListenableFuture f4469p;

    /* compiled from: secondCodePoint */
    interface TextOnlyListener {
        void mo135a();

        void mo136a(LocalShot localShot);
    }

    /* compiled from: secondCodePoint */
    class C04231 implements OnClickListener {
        final /* synthetic */ TextOnlyPreviewView f4450a;

        C04231(TextOnlyPreviewView textOnlyPreviewView) {
            this.f4450a = textOnlyPreviewView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1501437130);
            this.f4450a.f4466m.m5737c();
            this.f4450a.f4466m.clearFocus();
            this.f4450a.f4466m.setDrawingCacheEnabled(true);
            this.f4450a.f4466m.buildDrawingCache();
            final Bitmap drawingCache = this.f4450a.f4466m.getDrawingCache();
            this.f4450a.f4467n = new LocalShot(MediaType.PHOTO, drawingCache, "", 0, 0, false, ((float) this.f4450a.getHeight()) / ((float) this.f4450a.getWidth()));
            this.f4450a.f4461h.setEnabled(false);
            this.f4450a.f4469p;
            Futures.a(this.f4450a.f4469p, new FutureCallback<Void>(this) {
                final /* synthetic */ C04231 f4449b;

                public void onSuccess(Object obj) {
                    drawingCache.recycle();
                    this.f4449b.f4450a.f4466m.destroyDrawingCache();
                    this.f4449b.f4450a.f4466m.setDrawingCacheEnabled(false);
                    if (this.f4449b.f4450a.f4468o != null) {
                        this.f4449b.f4450a.f4468o.mo136a(this.f4449b.f4450a.f4467n);
                    }
                    this.f4449b.f4450a.f4461h.setEnabled(true);
                }

                public void onFailure(Throwable th) {
                    this.f4449b.f4450a.f4461h.setEnabled(true);
                    SoftError g = SoftError.a(TextOnlyPreviewView.f4454d, "Failed to decode media to bitmap or video file").g();
                    drawingCache.recycle();
                    this.f4449b.f4450a.f4466m.destroyDrawingCache();
                    this.f4449b.f4450a.f4466m.setDrawingCacheEnabled(false);
                    this.f4449b.f4450a.f4457c.a(g);
                }
            }, this.f4450a.f4455a);
            Logger.a(2, EntryType.UI_INPUT_END, 678295657, a);
        }
    }

    /* compiled from: secondCodePoint */
    class C04242 implements OnClickListener {
        final /* synthetic */ TextOnlyPreviewView f4451a;

        C04242(TextOnlyPreviewView textOnlyPreviewView) {
            this.f4451a = textOnlyPreviewView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -271091617);
            this.f4451a.f4466m.m5735b();
            Logger.a(2, EntryType.UI_INPUT_END, 487951167, a);
        }
    }

    /* compiled from: secondCodePoint */
    class C04253 implements OnColourPickerInteractionListener {
        final /* synthetic */ TextOnlyPreviewView f4452a;

        C04253(TextOnlyPreviewView textOnlyPreviewView) {
            this.f4452a = textOnlyPreviewView;
        }

        public final void m4434a(int i, float f, float f2, float f3) {
            this.f4452a.f4464k.a(i, f, f2, f3);
            this.f4452a.f4466m.m5736b(i);
        }

        public final void m4433a(int i) {
            this.f4452a.f4464k.setColour(i);
            this.f4452a.f4464k.a();
            this.f4452a.f4466m.m5736b(i);
        }
    }

    /* compiled from: secondCodePoint */
    class C04264 implements OnClickListener {
        final /* synthetic */ TextOnlyPreviewView f4453a;

        C04264(TextOnlyPreviewView textOnlyPreviewView) {
            this.f4453a = textOnlyPreviewView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1103042946);
            if (this.f4453a.f4468o != null) {
                this.f4453a.f4468o.mo135a();
            }
            Logger.a(2, EntryType.UI_INPUT_END, 1841828919, a);
        }
    }

    private static <T extends View> void m4437a(Class<T> cls, T t) {
        m4438a((Object) t, t.getContext());
    }

    private static void m4438a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        TextOnlyPreviewView textOnlyPreviewView = (TextOnlyPreviewView) obj;
        ListeningExecutorService listeningExecutorService = (ListeningExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike);
        MediaProcessor a = MediaProcessor.m5621a(injectorLike);
        AbstractFbErrorReporter abstractFbErrorReporter = (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike);
        textOnlyPreviewView.f4455a = listeningExecutorService;
        textOnlyPreviewView.f4456b = a;
        textOnlyPreviewView.f4457c = abstractFbErrorReporter;
    }

    public TextOnlyPreviewView(Context context) {
        this(context, null);
    }

    public TextOnlyPreviewView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TextOnlyPreviewView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4458e = new C04231(this);
        this.f4459f = new C04242(this);
        this.f4460g = new C04253(this);
        m4437a(TextOnlyPreviewView.class, (View) this);
        View.inflate(context, 2130907378, this);
        this.f4461h = findViewById(2131562068);
        this.f4462i = findViewById(2131566217);
        this.f4463j = (FbTextView) findViewById(2131559889);
        this.f4464k = (ColourIndicator) findViewById(2131565938);
        this.f4465l = (ColourPicker) findViewById(2131565939);
        this.f4465l.c = this.f4460g;
        this.f4466m = (ScalingToggleableEditText) findViewById(2131559899);
        this.f4463j.setText(DateFormat.getTimeInstance(3).format(new Date()));
        this.f4461h.getBackground().setColorFilter(getResources().getColor(2131361916), Mode.SRC_IN);
        this.f4462i.getBackground().setColorFilter(getResources().getColor(2131361916), Mode.SRC_IN);
        this.f4466m.setOnClickListener(this.f4459f);
        this.f4461h.setOnClickListener(this.f4458e);
        this.f4462i.setOnClickListener(new C04264(this));
    }

    public final void m4447a() {
        this.f4466m.m5737c();
        this.f4466m.clearFocus();
        this.f4466m.setText("");
        this.f4467n = null;
        this.f4469p = null;
    }

    public final void m4448b() {
        this.f4466m.m5735b();
    }

    public void setListener(TextOnlyListener textOnlyListener) {
        this.f4468o = textOnlyListener;
    }

    public static void m4443d(TextOnlyPreviewView textOnlyPreviewView) {
        textOnlyPreviewView.f4469p = textOnlyPreviewView.f4456b.m5623a(textOnlyPreviewView.f4467n);
    }
}
