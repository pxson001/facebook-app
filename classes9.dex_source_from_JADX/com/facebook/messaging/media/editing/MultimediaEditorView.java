package com.facebook.messaging.media.editing;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.facebook.fbui.widget.text.ImageWithTextView;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.media.editing.MultimediaEditorController.C13012;
import com.facebook.messaging.photos.editing.LayerGroupLayout;
import com.facebook.messaging.photos.editing.PhotoEditingControlsLayout;
import com.facebook.messaging.photos.editing.TextStylesLayout;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringSystem;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.player.InlineVideoView;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.ViewStubHolder;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: mCursor */
public abstract class MultimediaEditorView extends CustomFrameLayout {
    private static final SpringConfig f11582b = new SpringConfig(400.0d, 15.0d);
    @Inject
    public SpringSystem f11583a;
    public C13012 f11584c;
    private Spring f11585d;

    /* compiled from: mCursor */
    public class C13041 implements OnClickListener {
        final /* synthetic */ MultimediaEditorView f11577a;

        public C13041(MultimediaEditorView multimediaEditorView) {
            this.f11577a = multimediaEditorView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 590667343);
            MultimediaEditorView multimediaEditorView = this.f11577a;
            if (multimediaEditorView.f11584c != null) {
                multimediaEditorView.f11584c.f11561a.m12217a();
            }
            Logger.a(2, EntryType.UI_INPUT_END, 2139488359, a);
        }
    }

    /* compiled from: mCursor */
    public class C13052 implements OnClickListener {
        final /* synthetic */ MultimediaEditorView f11578a;

        public C13052(MultimediaEditorView multimediaEditorView) {
            this.f11578a = multimediaEditorView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1521287678);
            MultimediaEditorView.m12229k(this.f11578a);
            Logger.a(2, EntryType.UI_INPUT_END, -94313484, a);
        }
    }

    /* compiled from: mCursor */
    class C13063 implements DialogInterface.OnClickListener {
        final /* synthetic */ MultimediaEditorView f11579a;

        C13063(MultimediaEditorView multimediaEditorView) {
            this.f11579a = multimediaEditorView;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            MultimediaEditorView.m12229k(this.f11579a);
            dialogInterface.dismiss();
        }
    }

    /* compiled from: mCursor */
    class C13074 implements DialogInterface.OnClickListener {
        final /* synthetic */ MultimediaEditorView f11580a;

        C13074(MultimediaEditorView multimediaEditorView) {
            this.f11580a = multimediaEditorView;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    /* compiled from: mCursor */
    class HideShowSpringListener extends SimpleSpringListener {
        final /* synthetic */ MultimediaEditorView f11581a;

        public final void m12226b(Spring spring) {
            if (spring.i == 0.0d) {
                this.f11581a.getDoneButton().setVisibility(8);
            }
        }

        public final void m12227d(Spring spring) {
            if (spring.i == 1.0d && this.f11581a.mo490h()) {
                this.f11581a.getDoneButton().setVisibility(0);
            }
        }

        public HideShowSpringListener(MultimediaEditorView multimediaEditorView) {
            this.f11581a = multimediaEditorView;
        }

        public final void m12225a(Spring spring) {
            float d = (float) spring.d();
            View doneButton = this.f11581a.getDoneButton();
            ViewCompat.e(doneButton, d);
            ViewCompat.f(doneButton, d);
        }
    }

    public static void m12228a(Object obj, Context context) {
        ((MultimediaEditorView) obj).f11583a = SpringSystem.b(FbInjector.get(context));
    }

    @Nullable
    public abstract View getCancelButton();

    public abstract ImageWithTextView getDeleteLayerButton();

    public abstract View getDoneButton();

    public abstract ViewStubHolder<ImageView> getImagePreviewStubHolder();

    public abstract LayerGroupLayout getLayers();

    public abstract PhotoEditingControlsLayout getPhotoEditingControls();

    public abstract TextStylesLayout getTextStyles();

    public abstract ViewStubHolder<InlineVideoView> getVideoPreviewStubHolder();

    public MultimediaEditorView(Context context) {
        this(context, null);
    }

    public MultimediaEditorView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MultimediaEditorView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = MultimediaEditorView.class;
        m12228a(this, getContext());
        Spring l = this.f11583a.a().a(f11582b).a(1.0d).l();
        l.c = true;
        this.f11585d = l.a(new HideShowSpringListener(this));
    }

    public final void m12230b() {
        this.f11585d.b(1.0d);
        setCancelButtonVisibility(0);
    }

    public final void m12231e() {
        this.f11585d.b(0.0d);
        setCancelButtonVisibility(8);
    }

    private void setCancelButtonVisibility(int i) {
        View cancelButton = getCancelButton();
        if (cancelButton != null) {
            cancelButton.setVisibility(i);
        }
    }

    public final void m12232f() {
        ViewStubHolder videoPreviewStubHolder = getVideoPreviewStubHolder();
        if (videoPreviewStubHolder.c()) {
            ((InlineVideoView) videoPreviewStubHolder.a()).c(EventTriggerType.BY_USER);
        }
    }

    public static void m12229k(MultimediaEditorView multimediaEditorView) {
        if (multimediaEditorView.f11584c != null) {
            C13012 c13012 = multimediaEditorView.f11584c;
            if (c13012.f11561a.f11576m) {
                MultimediaEditorController.m12215l(c13012.f11561a);
            }
        }
    }

    public final void m12233g() {
        new FbAlertDialogBuilder(getContext()).a(2131232207).b(2131232208).b(2131232209, new C13074(this)).a(2131232210, new C13063(this)).b();
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!isEnabled()) {
            return false;
        }
        if (keyEvent.getKeyCode() == 4) {
            DispatcherState keyDispatcherState = getKeyDispatcherState();
            switch (keyEvent.getAction()) {
                case 0:
                    keyDispatcherState.startTracking(keyEvent, this);
                    return true;
                case 1:
                    if (!keyEvent.isCanceled() && keyDispatcherState.isTracking(keyEvent)) {
                        boolean h;
                        if (this.f11584c != null) {
                            h = this.f11584c.f11561a.m12224h();
                        } else {
                            h = false;
                        }
                        return h;
                    }
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        getDoneButton().setEnabled(z);
    }

    protected boolean mo490h() {
        return true;
    }
}
