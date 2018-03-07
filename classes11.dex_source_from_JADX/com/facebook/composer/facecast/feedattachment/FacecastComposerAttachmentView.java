package com.facebook.composer.facecast.feedattachment;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.facebook.composer.facecast.feedattachment.FacecastComposerAttachmentController.C08021;
import com.facebook.composer.facecast.feedattachment.FacecastComposerStateController.FacecastComposerState;
import com.facebook.facecast.FacecastStateManager;
import com.facebook.facecast.plugin.FacecastComposerPreviewPlugin;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbButton;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomRelativeLayout;

/* compiled from: groupsDiscoverySearch */
public class FacecastComposerAttachmentView extends CustomRelativeLayout {
    private ViewGroup f6407a;
    public FacecastComposerAttachmentController f6408b;
    private FacecastComposerState f6409c;
    public ImageView f6410d;
    private FacecastComposerPreviewPlugin f6411e;
    private View f6412f;
    public FbTextView f6413g;
    private FbTextView f6414h;
    private FbTextView f6415i;
    private View f6416j;
    private FbButton f6417k;
    private LinearLayout f6418l;

    /* compiled from: groupsDiscoverySearch */
    class C08041 implements OnClickListener {
        final /* synthetic */ FacecastComposerAttachmentView f6402a;

        C08041(FacecastComposerAttachmentView facecastComposerAttachmentView) {
            this.f6402a = facecastComposerAttachmentView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -502032451);
            if (this.f6402a.f6408b != null) {
                this.f6402a.f6408b.m7845n();
            }
            Logger.a(2, EntryType.UI_INPUT_END, -284270004, a);
        }
    }

    /* compiled from: groupsDiscoverySearch */
    class C08052 implements OnClickListener {
        final /* synthetic */ FacecastComposerAttachmentView f6403a;

        C08052(FacecastComposerAttachmentView facecastComposerAttachmentView) {
            this.f6403a = facecastComposerAttachmentView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 2128002367);
            FacecastComposerAttachmentController facecastComposerAttachmentController = this.f6403a.f6408b;
            facecastComposerAttachmentController.f6398p.a(FacecastComposerAttachmentController.f6385c, new C08021(facecastComposerAttachmentController, facecastComposerAttachmentController));
            Logger.a(2, EntryType.UI_INPUT_END, 1411129802, a);
        }
    }

    /* compiled from: groupsDiscoverySearch */
    class C08063 implements OnClickListener {
        final /* synthetic */ FacecastComposerAttachmentView f6404a;

        C08063(FacecastComposerAttachmentView facecastComposerAttachmentView) {
            this.f6404a = facecastComposerAttachmentView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -2126215619);
            this.f6404a.f6408b.m7844m();
            Logger.a(2, EntryType.UI_INPUT_END, -70207194, a);
        }
    }

    /* compiled from: groupsDiscoverySearch */
    class C08074 implements OnClickListener {
        final /* synthetic */ FacecastComposerAttachmentView f6405a;

        C08074(FacecastComposerAttachmentView facecastComposerAttachmentView) {
            this.f6405a = facecastComposerAttachmentView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 456631675);
            this.f6405a.f6408b.m7844m();
            Logger.a(2, EntryType.UI_INPUT_END, 625357840, a);
        }
    }

    public FacecastComposerAttachmentView(Context context) {
        this(context, null);
    }

    private FacecastComposerAttachmentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private FacecastComposerAttachmentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130904188);
        this.f6407a = (ViewGroup) a(2131561594);
        this.f6410d = (ImageView) a(2131561604);
        this.f6412f = a(2131561597);
        this.f6412f.setOnClickListener(new C08041(this));
        this.f6413g = (FbTextView) a(2131561603);
        this.f6418l = (LinearLayout) a(2131561599);
        this.f6416j = a(2131561598);
        this.f6414h = (FbTextView) a(2131561600);
        this.f6415i = (FbTextView) a(2131561601);
        this.f6417k = (FbButton) a(2131561602);
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i);
    }

    protected void onWindowVisibilityChanged(int i) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 2026325179);
        super.onWindowVisibilityChanged(i);
        this.f6408b.m7834b(i);
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1872897936, a);
    }

    public final void m7849a(FacecastComposerPreviewPlugin facecastComposerPreviewPlugin, FacecastStateManager facecastStateManager) {
        this.f6411e = facecastComposerPreviewPlugin;
        this.f6411e.a(this.f6407a, facecastStateManager, 0);
        this.f6411e.l();
    }

    public final void m7848a() {
        this.f6417k.setOnClickListener(null);
        this.f6417k.setText("");
        this.f6417k.setContentDescription("");
        this.f6414h.setText("");
        this.f6415i.setText("");
        this.f6409c = null;
    }

    public void setState(FacecastComposerState facecastComposerState) {
        this.f6409c = facecastComposerState;
        switch (this.f6409c) {
            case CAMERA_PERMISSION_DENIED:
                setViewContainerBackgroundColor(getResources().getColor(2131361843));
                this.f6416j.setVisibility(0);
                this.f6418l.setVisibility(0);
                this.f6412f.setVisibility(8);
                this.f6413g.setVisibility(8);
                this.f6413g.clearAnimation();
                this.f6417k.setText(getResources().getString(2131242377));
                this.f6417k.setContentDescription(getResources().getString(2131242378));
                this.f6417k.setOnClickListener(new C08052(this));
                return;
            case LOADING:
                setViewContainerBackgroundColor(getResources().getColor(2131361843));
                if (this.f6411e != null) {
                    this.f6411e.l();
                }
                this.f6412f.setVisibility(0);
                this.f6413g.setVisibility(0);
                this.f6416j.setVisibility(8);
                this.f6418l.setVisibility(8);
                this.f6413g.startAnimation(AnimationUtils.loadAnimation(getContext(), 2130968593));
                return;
            case NO_CONNECTION:
                setViewContainerBackgroundColor(getResources().getColor(2131361843));
                if (this.f6411e != null) {
                    this.f6411e.l();
                }
                this.f6416j.setVisibility(0);
                this.f6418l.setVisibility(0);
                this.f6412f.setVisibility(8);
                this.f6413g.setVisibility(8);
                this.f6413g.clearAnimation();
                m7850a(getResources().getString(2131242381), getResources().getString(2131242382));
                this.f6417k.setText(getResources().getString(2131242383));
                this.f6417k.setContentDescription(getResources().getString(2131242383));
                this.f6417k.setOnClickListener(new C08063(this));
                return;
            case WEAK_CONNECTION:
                setViewContainerBackgroundColor(getResources().getColor(2131361843));
                if (this.f6411e != null) {
                    this.f6411e.l();
                }
                this.f6416j.setVisibility(0);
                this.f6418l.setVisibility(0);
                this.f6412f.setVisibility(8);
                this.f6413g.setVisibility(8);
                this.f6413g.clearAnimation();
                m7850a(getResources().getString(2131242379), getResources().getString(2131242380));
                this.f6417k.setText(getResources().getString(2131242383));
                this.f6417k.setContentDescription(getResources().getString(2131242383));
                this.f6417k.setOnClickListener(new C08074(this));
                return;
            case READY:
                setViewContainerBackgroundColor(getResources().getColor(2131361921));
                if (this.f6411e != null) {
                    FacecastComposerPreviewPlugin facecastComposerPreviewPlugin = this.f6411e;
                    facecastComposerPreviewPlugin.i.setVisibility(0);
                    facecastComposerPreviewPlugin.j.setVisibility(0);
                }
                this.f6412f.setVisibility(8);
                this.f6413g.setVisibility(8);
                this.f6413g.clearAnimation();
                this.f6416j.setVisibility(8);
                this.f6418l.setVisibility(8);
                return;
            default:
                return;
        }
    }

    public final void m7850a(String str, String str2) {
        this.f6414h.setText(str);
        this.f6415i.setText(str2);
    }

    private void setViewContainerBackgroundColor(int i) {
        if (VERSION.SDK_INT >= 16) {
            this.f6407a.setBackground(new ColorDrawable(i));
        } else {
            this.f6407a.setBackgroundColor(i);
        }
    }
}
