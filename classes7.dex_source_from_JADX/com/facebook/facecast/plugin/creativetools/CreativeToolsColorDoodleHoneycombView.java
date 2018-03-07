package com.facebook.facecast.plugin.creativetools;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomFrameLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: before */
public class CreativeToolsColorDoodleHoneycombView extends CustomFrameLayout {
    private final List<View> f18674a;
    private final int f18675b;
    private final int f18676c;
    private final int f18677d;
    private final int f18678e;
    private final int f18679f;
    @Nullable
    private CreativeToolsColorDoodlePack f18680g;
    @Nullable
    public CreativeToolsColorDoodleItemView f18681h;

    public CreativeToolsColorDoodleHoneycombView(Context context) {
        this(context, null);
    }

    public CreativeToolsColorDoodleHoneycombView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CreativeToolsColorDoodleHoneycombView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f18674a = new ArrayList();
        this.f18675b = getResources().getDimensionPixelSize(2131432382);
        this.f18676c = getResources().getDimensionPixelOffset(2131432383);
        this.f18677d = getResources().getDimensionPixelOffset(2131432384);
        this.f18678e = this.f18675b + (this.f18676c * 2);
        this.f18679f = this.f18675b + (this.f18677d * 2);
    }

    public void setColorDoodlePack(CreativeToolsColorDoodlePack creativeToolsColorDoodlePack) {
        if (this.f18680g != creativeToolsColorDoodlePack) {
            this.f18680g = creativeToolsColorDoodlePack;
            removeAllViews();
            this.f18674a.clear();
            this.f18681h = null;
            Iterator it = creativeToolsColorDoodlePack.iterator();
            while (it.hasNext()) {
                CreativeToolsColorDoodle creativeToolsColorDoodle = (CreativeToolsColorDoodle) it.next();
                final View creativeToolsColorDoodleItemView = new CreativeToolsColorDoodleItemView(getContext());
                creativeToolsColorDoodleItemView.f18686e = creativeToolsColorDoodle.f18671a;
                creativeToolsColorDoodleItemView.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ CreativeToolsColorDoodleHoneycombView f18673b;

                    public void onClick(View view) {
                        int a = Logger.a(2, EntryType.UI_INPUT_START, -109062652);
                        if (this.f18673b.f18681h != null) {
                            this.f18673b.f18681h.setSelected(false);
                        }
                        this.f18673b.f18681h = creativeToolsColorDoodleItemView;
                        this.f18673b.f18681h.setSelected(true);
                        Logger.a(2, EntryType.UI_INPUT_END, -1746682103, a);
                    }
                });
                this.f18674a.add(creativeToolsColorDoodleItemView);
                addView(creativeToolsColorDoodleItemView, this.f18675b, this.f18675b);
            }
        }
    }

    public int getCurrentlySelectedColor() {
        if (this.f18681h != null) {
            return this.f18681h.f18686e;
        }
        return -1;
    }

    protected void onMeasure(int i, int i2) {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.f18675b, 1073741824);
        for (View measure : this.f18674a) {
            measure.measure(makeMeasureSpec, makeMeasureSpec);
        }
        makeMeasureSpec = View.getDefaultSize(0, i);
        if (makeMeasureSpec == 0 || this.f18674a.isEmpty()) {
            setMeasuredDimension(makeMeasureSpec, View.getDefaultSize(0, i2));
            return;
        }
        int a = m22262a(makeMeasureSpec);
        int size = this.f18674a.size() / a;
        int i3 = size * 2;
        a = this.f18674a.size() - (a * size);
        if (a > 0) {
            i3++;
            if (a - (m22265b(makeMeasureSpec) - 1) > 0) {
                i3++;
            }
        }
        setMeasuredDimension(makeMeasureSpec, View.resolveSize(i3 * this.f18679f, i2));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (!this.f18674a.isEmpty()) {
            int i5 = i3 - i;
            int b = m22265b(i5);
            int i6 = b - 1;
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            Object obj = 1;
            int i10 = 0;
            int i11 = 0;
            while (i11 < this.f18674a.size()) {
                int i12;
                Object obj2;
                int i13;
                if (i11 == 0 || i9 == i10) {
                    i8 = 0;
                    i12 = i11 == 0 ? 0 : i7 + this.f18679f;
                    obj2 = obj == null ? 1 : null;
                    if (obj2 != null) {
                        i10 = b;
                    } else {
                        i10 = i6;
                    }
                    i7 = (i5 - (Math.min(i10, this.f18674a.size() - i11) * this.f18678e)) / 2;
                    i13 = i10;
                } else {
                    i12 = i7;
                    i7 = i8;
                    i8 = i9;
                    obj2 = obj;
                    i13 = i10;
                }
                ((View) this.f18674a.get(i11)).layout(this.f18676c + i7, this.f18677d + i12, (this.f18676c + i7) + this.f18675b, (this.f18677d + i12) + this.f18675b);
                i11++;
                i10 = i13;
                obj = obj2;
                i9 = i8 + 1;
                i8 = i7 + this.f18678e;
                i7 = i12;
            }
        }
    }

    private int m22262a(int i) {
        return (m22265b(i) * 2) - 1;
    }

    private int m22265b(int i) {
        return Math.max(i / this.f18678e, 1);
    }
}
