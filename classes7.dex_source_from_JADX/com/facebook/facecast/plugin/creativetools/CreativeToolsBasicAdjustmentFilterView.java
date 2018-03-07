package com.facebook.facecast.plugin.creativetools;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import com.facebook.facecast.PreviewRenderer;
import com.facebook.facecast.PreviewRenderer.SecondaryPreviewSurface;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.RoundedCornerOverlayDrawable;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: bio_add_prompt_impression */
public class CreativeToolsBasicAdjustmentFilterView extends CustomFrameLayout {
    public final CreativeToolsBasicAdjustmentFilterViewHolder f18660a;
    private final float f18661b;
    private final Paint f18662c;
    public final RoundedCornerOverlayDrawable f18663d;
    @Nullable
    public PreviewRenderer f18664e;
    @Nullable
    public CreativeToolsBasicAdjustmentFilterViewListener f18665f;
    @Nullable
    private SecondaryPreviewSurface f18666g;

    /* compiled from: bio_add_prompt_impression */
    public interface CreativeToolsBasicAdjustmentFilterViewListener {
        void mo1431a(CreativeToolsBasicAdjustmentFilterView creativeToolsBasicAdjustmentFilterView);
    }

    /* compiled from: bio_add_prompt_impression */
    class C16121 implements OnLayoutChangeListener {
        final /* synthetic */ CreativeToolsBasicAdjustmentFilterView f18658a;

        C16121(CreativeToolsBasicAdjustmentFilterView creativeToolsBasicAdjustmentFilterView) {
            this.f18658a = creativeToolsBasicAdjustmentFilterView;
        }

        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            this.f18658a.f18663d.setBounds(i - 1, i2 - 1, i3 + 1, i4 + 1);
        }
    }

    /* compiled from: bio_add_prompt_impression */
    class C16132 implements OnClickListener {
        final /* synthetic */ CreativeToolsBasicAdjustmentFilterView f18659a;

        C16132(CreativeToolsBasicAdjustmentFilterView creativeToolsBasicAdjustmentFilterView) {
            this.f18659a = creativeToolsBasicAdjustmentFilterView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 828918556);
            if (this.f18659a.f18665f != null) {
                this.f18659a.f18665f.mo1431a(this.f18659a);
            }
            Logger.a(2, EntryType.UI_INPUT_END, 1122143030, a);
        }
    }

    public CreativeToolsBasicAdjustmentFilterView(Context context) {
        this(context, null);
    }

    public CreativeToolsBasicAdjustmentFilterView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CreativeToolsBasicAdjustmentFilterView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130904193);
        this.f18660a = new CreativeToolsBasicAdjustmentFilterViewHolder(this);
        this.f18661b = ((float) getResources().getDimensionPixelSize(2131432380)) / 2.0f;
        this.f18662c = new Paint();
        this.f18662c.setAntiAlias(true);
        this.f18662c.setColor(getResources().getColor(2131363616));
        this.f18663d = new RoundedCornerOverlayDrawable();
        this.f18663d.a(getResources().getColor(2131363615));
        RoundedCornerOverlayDrawable roundedCornerOverlayDrawable = this.f18663d;
        float dimension = getResources().getDimension(2131432381);
        roundedCornerOverlayDrawable.a(dimension, dimension, dimension, dimension);
        this.f18663d.setCallback(this);
        this.f18660a.f18668m.addOnLayoutChangeListener(new C16121(this));
        this.f18660a.f18668m.setZOrderMediaOverlay(true);
        this.f18660a.f18669n.setOnClickListener(new C16132(this));
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (isSelected()) {
            canvas.drawCircle(((float) canvas.getWidth()) / 2.0f, ((float) (this.f18660a.f18668m.getBottom() + canvas.getHeight())) / 2.0f, this.f18661b, this.f18662c);
        }
        this.f18663d.draw(canvas);
    }

    public void setListener(CreativeToolsBasicAdjustmentFilterViewListener creativeToolsBasicAdjustmentFilterViewListener) {
        this.f18665f = creativeToolsBasicAdjustmentFilterViewListener;
    }

    public void setPreviewRenderer(PreviewRenderer previewRenderer) {
        this.f18664e = previewRenderer;
    }

    public void setVisibility(boolean z) {
        if (this.f18666g != null) {
            this.f18666g.f18072g = z;
        }
    }

    public final void m22250a(CreativeToolsBasicAdjustmentFilter creativeToolsBasicAdjustmentFilter) {
        boolean z;
        boolean z2 = true;
        Preconditions.checkArgument(creativeToolsBasicAdjustmentFilter != null, "Binding null filter");
        if (this.f18666g == null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "Already bound");
        if (this.f18664e == null) {
            z2 = false;
        }
        Preconditions.checkState(z2, "Must have a preview renderer");
        this.f18660a.f18669n.setText(creativeToolsBasicAdjustmentFilter.f18642b);
        this.f18666g = this.f18664e.m21919a(this.f18660a.f18668m, creativeToolsBasicAdjustmentFilter.f18644d);
    }

    public final void m22249a() {
        if (this.f18666g != null) {
            PreviewRenderer previewRenderer = this.f18664e;
            SecondaryPreviewSurface secondaryPreviewSurface = this.f18666g;
            if (previewRenderer.f18101v != null) {
                previewRenderer.f18081b.sendMessageAtFrontOfQueue(previewRenderer.f18081b.obtainMessage(14, secondaryPreviewSurface));
            }
            this.f18666g = null;
        }
    }
}
