package com.facebook.facecast.plugin.creativetools;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.util.CollectionUtil;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomLinearLayout;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: batch_upload_finish */
public class CreativeToolsPackSelectorTray extends CustomLinearLayout {
    private final float f18712a;
    private final Paint f18713b;
    private final Path f18714c;
    private final List<CreativeToolsPack> f18715d;
    private final List<View> f18716e;
    @Nullable
    private View f18717f;
    @Nullable
    public CreativeToolsPackSelectorTrayListener f18718g;

    /* compiled from: batch_upload_finish */
    public interface CreativeToolsPackSelectorTrayListener {
        void mo1439a(CreativeToolsPack creativeToolsPack);
    }

    public CreativeToolsPackSelectorTray(Context context) {
        this(context, null);
    }

    public CreativeToolsPackSelectorTray(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CreativeToolsPackSelectorTray(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setOrientation(0);
        setWillNotDraw(false);
        this.f18712a = getResources().getDimension(2131432375);
        this.f18713b = new Paint();
        this.f18713b.setAntiAlias(true);
        this.f18713b.setColor(getResources().getColor(2131363614));
        this.f18713b.setStyle(Style.FILL);
        this.f18714c = new Path();
        this.f18715d = new ArrayList();
        this.f18716e = new ArrayList();
    }

    public void setListener(CreativeToolsPackSelectorTrayListener creativeToolsPackSelectorTrayListener) {
        this.f18718g = creativeToolsPackSelectorTrayListener;
    }

    public void setCreativeToolsPacks(List<CreativeToolsPack> list) {
        this.f18715d.clear();
        this.f18715d.addAll(list);
        removeAllViews();
        this.f18716e.clear();
        for (final CreativeToolsPack creativeToolsPack : list) {
            View.inflate(getContext(), 2130904198, this);
            GlyphView glyphView = (GlyphView) getChildAt(getChildCount() - 1);
            glyphView.setImageResource(creativeToolsPack.mo1436b());
            glyphView.setContentDescription(getResources().getString(creativeToolsPack.mo1435a()));
            glyphView.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ CreativeToolsPackSelectorTray f18711b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -1983805101);
                    this.f18711b.m22277a(view, creativeToolsPack);
                    Logger.a(2, EntryType.UI_INPUT_END, 796509787, a);
                }
            });
            this.f18716e.add(glyphView);
        }
    }

    public final void m22279a() {
        if (this.f18717f == null && CollectionUtil.b(this.f18716e) && CollectionUtil.b(this.f18715d)) {
            m22277a((View) this.f18716e.get(0), (CreativeToolsPack) this.f18715d.get(0));
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f18717f != null) {
            float left = (float) ((this.f18717f.getLeft() + this.f18717f.getRight()) / 2);
            float height = (float) canvas.getHeight();
            this.f18714c.reset();
            this.f18714c.moveTo(left - this.f18712a, height);
            this.f18714c.lineTo(this.f18712a + left, height);
            this.f18714c.lineTo(left, height - this.f18712a);
            this.f18714c.close();
            canvas.drawPath(this.f18714c, this.f18713b);
        }
    }

    private void m22277a(View view, CreativeToolsPack creativeToolsPack) {
        if (view != this.f18717f) {
            if (this.f18717f != null) {
                this.f18717f.setEnabled(true);
                this.f18717f.setSelected(false);
            }
            this.f18717f = view;
            this.f18717f.setEnabled(false);
            this.f18717f.setSelected(true);
            if (this.f18718g != null) {
                this.f18718g.mo1439a(creativeToolsPack);
            }
            invalidate();
        }
    }
}
