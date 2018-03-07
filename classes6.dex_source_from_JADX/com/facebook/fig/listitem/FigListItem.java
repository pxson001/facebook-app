package com.facebook.fig.listitem;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import com.facebook.R;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.fig.button.FigButton;
import com.facebook.fig.button.FigToggleButton;
import com.facebook.fig.common.FigTextHelper;
import com.facebook.resources.ui.FbCheckBox;
import com.facebook.resources.ui.FbRadioButton;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.SwitchCompat;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;

/* compiled from: media-upload-video-chunk-post */
public class FigListItem extends ImageBlockLayout {
    private static final int[] f10490h = new int[]{2131430818, 2131430819, 2131430820, 2131430821, 2131430822, 2131430817};
    private static final int[] f10491i = new int[]{2131624526, 2131624527, 2131624524, 2131624525, 2131624528, 2131624529};
    private static final int[] f10492j = new int[]{2131624528, 2131624529, 2131624530, 2131624531, 2131624532, 2131624534, 2131624533, 2131624535, 2131624536, 2131624526, 2131624527, 2131624537, 2131624538, 2131624541, 2131624542};
    private static final int[] f10493k = new int[]{2131624539, 2131624540};
    @ThumbnailSize
    private int f10494l;
    private int f10495m;
    private FigTextHelper f10496n;
    private FigTextHelper f10497o;
    private FigTextHelper f10498p;
    @TitleTextAppearenceType
    private int f10499q;
    @BodyTextAppearenceType
    private int f10500r;
    @MetaTextAppearenceType
    private int f10501s;
    private boolean f10502t = false;
    private boolean f10503u;
    private int f10504v;
    private int f10505w;
    private int f10506x;
    @ActionType
    private int f10507y = 0;

    /* compiled from: media-upload-video-chunk-post */
    public @interface ActionType {
    }

    /* compiled from: media-upload-video-chunk-post */
    public @interface BodyTextAppearenceType {
    }

    /* compiled from: media-upload-video-chunk-post */
    public @interface MetaTextAppearenceType {
    }

    /* compiled from: media-upload-video-chunk-post */
    public @interface ThumbnailSize {
    }

    /* compiled from: media-upload-video-chunk-post */
    public @interface TitleTextAppearenceType {
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return m16673d();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return a(attributeSet);
    }

    protected /* synthetic */ LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return m16669a(layoutParams);
    }

    public FigListItem(Context context) {
        super(context);
        m16665a(null, 0);
    }

    public FigListItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m16665a(attributeSet, 2130772407);
    }

    public FigListItem(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m16665a(attributeSet, i);
    }

    private void m16665a(AttributeSet attributeSet, int i) {
        this.f10496n = new FigTextHelper();
        this.f10497o = new FigTextHelper();
        this.f10498p = new FigTextHelper();
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(2131430816);
        super.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        super.setThumbnailPadding(dimensionPixelSize);
        setTitleTextAppearance(2131624543);
        setBodyTextAppearance(2131624544);
        setMetaTextAppearance(2131624545);
        setAuxViewPadding(dimensionPixelSize);
        setAuxViewPadding(dimensionPixelSize);
        setBackgroundColor(ContextCompat.b(getContext(), 2131362094));
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.FigListItem, i, 0);
            int resourceId = obtainStyledAttributes.getResourceId(0, 0);
            if (resourceId > 0) {
                setTitleText(resourceId);
            } else {
                setTitleText(obtainStyledAttributes.getText(0));
            }
            resourceId = obtainStyledAttributes.getResourceId(1, 0);
            if (resourceId > 0) {
                setBodyText(resourceId);
            } else {
                setBodyText(obtainStyledAttributes.getText(1));
            }
            resourceId = obtainStyledAttributes.getResourceId(2, 0);
            if (resourceId > 0) {
                setMetaText(resourceId);
            } else {
                setMetaText(obtainStyledAttributes.getText(2));
            }
            setThumbnailSizeType(obtainStyledAttributes.getInteger(7, 0));
            setTitleTextAppearenceType(obtainStyledAttributes.getInteger(8, 0));
            setBodyTextAppearenceType(obtainStyledAttributes.getInteger(9, 0));
            setMetaTextAppearenceType(obtainStyledAttributes.getInteger(10, 0));
            this.f10502t = obtainStyledAttributes.getBoolean(3, false);
            this.f10504v = obtainStyledAttributes.getInteger(4, 3);
            this.f10505w = obtainStyledAttributes.getInteger(11, 3);
            this.f10506x = obtainStyledAttributes.getInteger(11, 3);
            setActionType(obtainStyledAttributes.getInteger(13, 0));
            setActionText(obtainStyledAttributes.getText(5));
            Drawable drawable = obtainStyledAttributes.getDrawable(6);
            if (drawable != null) {
                setActionDrawable(drawable);
            }
            setActionState(obtainStyledAttributes.getBoolean(14, false));
            m16666f();
            obtainStyledAttributes.recycle();
        }
    }

    public void setPadding(int i, int i2, int i3, int i4) {
    }

    public void setThumbnailPadding(int i) {
    }

    protected void onMeasure(int i, int i2) {
        int i3 = 2;
        int i4 = 0;
        if (this.f10502t || this.f10503u) {
            boolean z;
            int i5;
            int i6;
            boolean d = this.f10496n.m16662d();
            boolean d2 = this.f10497o.m16662d();
            boolean d3 = this.f10498p.m16662d();
            if (!this.f10502t) {
                setTitleMaxLines(this.f10504v);
                setBodyMaxLines(this.f10505w);
                z = d2;
                d2 = d3;
            } else if (this.f10494l == 3) {
                if (d3) {
                    setTitleMaxLines(1);
                    setBodyMaxLines(1);
                } else {
                    setTitleMaxLines(2);
                    d2 = false;
                }
                z = d2;
                i5 = 0;
            } else if (this.f10494l == 4) {
                setTitleMaxLines(2);
                if (d3) {
                    i3 = 1;
                }
                setBodyMaxLines(i3);
                z = d2;
                d2 = d3;
            } else {
                setTitleMaxLines(1);
                setBodyMaxLines(1);
                z = this.f10494l == 2;
                i5 = 0;
            }
            this.f10498p.m16659b(1);
            FigTextHelper figTextHelper = this.f10496n;
            if (d) {
                i6 = 0;
            } else {
                i6 = 8;
            }
            figTextHelper.f10486c = i6;
            FigTextHelper figTextHelper2 = this.f10497o;
            if (z) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            figTextHelper2.f10486c = i3;
            FigTextHelper figTextHelper3 = this.f10498p;
            if (i5 == 0) {
                i4 = 8;
            }
            figTextHelper3.f10486c = i4;
        }
        super.onMeasure(i, i2);
    }

    protected final void m16671a(int i, int i2) {
        this.f10496n.m16661c(i);
        int max = Math.max(0, this.f10496n.m16658b());
        int c = this.f10496n.m16660c() + 0;
        this.f10497o.m16661c(i);
        max = Math.max(max, this.f10497o.m16658b());
        c += this.f10497o.m16660c();
        this.f10498p.m16661c(i);
        b(Math.max(max, this.f10498p.m16658b()), c + this.f10498p.m16660c());
    }

    protected final void m16672a(int i, int i2, int i3) {
        if (m16667g()) {
            i2 += getTopPaddingCenterTextContent();
        }
        this.f10496n.m16657a(c(), i, i2, i3);
        int c = this.f10496n.m16660c() + i2;
        this.f10497o.m16657a(c(), i, c, i3);
        this.f10498p.m16657a(c(), i, c + this.f10497o.m16660c(), i3);
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        this.f10496n.m16654a(canvas);
        this.f10497o.m16654a(canvas);
        this.f10498p.m16654a(canvas);
    }

    protected final ImageBlockLayout.LayoutParams m16673d() {
        return new ImageBlockLayout.LayoutParams(-2, -2);
    }

    public final ImageBlockLayout.LayoutParams m16668a(AttributeSet attributeSet) {
        return new ImageBlockLayout.LayoutParams(getContext(), attributeSet);
    }

    protected final ImageBlockLayout.LayoutParams m16669a(LayoutParams layoutParams) {
        if (layoutParams instanceof ImageBlockLayout.LayoutParams) {
            return (ImageBlockLayout.LayoutParams) layoutParams;
        }
        return m16673d();
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams != null && (layoutParams instanceof ImageBlockLayout.LayoutParams);
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
    }

    public void removeView(View view) {
    }

    public void removeViewInLayout(View view) {
    }

    public void setTitleMaxLines(int i) {
        this.f10504v = i;
        this.f10496n.m16659b(i);
    }

    @VisibleForTesting
    public int getTitleMaxLines() {
        return this.f10504v;
    }

    public void setBodyMaxLines(int i) {
        this.f10505w = i;
        this.f10497o.m16659b(i);
    }

    @VisibleForTesting
    public int getBodyMaxLines() {
        return this.f10505w;
    }

    public void setMetaMaxLines(int i) {
        this.f10506x = i;
        this.f10498p.m16659b(i);
    }

    @VisibleForTesting
    public int getMetaMaxLines() {
        return this.f10506x;
    }

    protected int getThumbnailDimensionSize() {
        return getResources().getDimensionPixelSize(f10490h[this.f10494l]);
    }

    @ThumbnailSize
    public int getThumbnailSize() {
        return this.f10494l;
    }

    public void setThumbnailSizeType(@ThumbnailSize int i) {
        this.f10494l = i;
        this.f10495m = getThumbnailDimensionSize();
        setThumbnailSize(this.f10495m);
        requestLayout();
        invalidate();
    }

    public void setTitleTextAppearenceType(@TitleTextAppearenceType int i) {
        if (i != this.f10499q) {
            this.f10499q = i;
            this.f10496n.m16653a(getContext(), f10491i[this.f10499q]);
            requestLayout();
            invalidate();
        }
    }

    public void setBodyTextAppearenceType(@BodyTextAppearenceType int i) {
        if (i != this.f10500r) {
            this.f10500r = i;
            this.f10497o.m16653a(getContext(), f10492j[this.f10500r]);
            requestLayout();
            invalidate();
        }
    }

    public void setMetaTextAppearenceType(@MetaTextAppearenceType int i) {
        if (i != this.f10501s) {
            this.f10501s = i;
            this.f10498p.m16653a(getContext(), f10493k[this.f10501s]);
            requestLayout();
            invalidate();
        }
    }

    public void setThumbnailDrawable(Drawable drawable) {
        super.setThumbnailSize(this.f10495m);
        super.setThumbnailDrawable(drawable);
    }

    public void setMaxLinesFromThumbnailSize(boolean z) {
        if (this.f10502t != z) {
            this.f10502t = z;
            m16666f();
            requestLayout();
            invalidate();
        }
    }

    public final void m16670a() {
        this.f10505w = 1;
        this.f10504v = 1;
        this.f10503u = false;
        requestLayout();
        invalidate();
    }

    private void m16666f() {
        boolean z = false;
        boolean z2 = this.f10504v >= 0 && this.f10505w >= 0;
        Preconditions.checkState(z2, "titleMaxLines and bodyMaxLines must be non-negative");
        if (!(this.f10502t && this.f10503u)) {
            z = true;
        }
        Preconditions.checkState(z, "maxLinesFromThumbnailSize must be false if titleMaxLines and bodyMaxLines are specified");
    }

    public void setTitleText(CharSequence charSequence) {
        this.f10496n.m16656a(charSequence);
        requestLayout();
        invalidate();
    }

    public void setTitleText(int i) {
        this.f10496n.m16656a(getContext().getText(i));
        requestLayout();
        invalidate();
    }

    public CharSequence getTitleText() {
        return this.f10496n.m16652a();
    }

    public void setBodyText(CharSequence charSequence) {
        this.f10497o.m16656a(charSequence);
        requestLayout();
        invalidate();
    }

    public void setBodyText(int i) {
        this.f10497o.m16656a(getContext().getText(i));
        requestLayout();
        invalidate();
    }

    public CharSequence getBodyText() {
        return this.f10497o.m16652a();
    }

    public void setMetaText(CharSequence charSequence) {
        this.f10498p.m16656a(charSequence);
        requestLayout();
        invalidate();
    }

    public void setMetaText(int i) {
        this.f10498p.m16656a(getContext().getText(i));
        requestLayout();
        invalidate();
    }

    public CharSequence getMetaText() {
        return this.f10498p.m16652a();
    }

    private void setTitleTextAppearance(int i) {
        this.f10496n.m16653a(getContext(), i);
        requestLayout();
        invalidate();
    }

    private void setBodyTextAppearance(int i) {
        this.f10497o.m16653a(getContext(), i);
        requestLayout();
        invalidate();
    }

    private void setMetaTextAppearance(int i) {
        this.f10498p.m16653a(getContext(), i);
        requestLayout();
        invalidate();
    }

    public void setActionType(@ActionType int i) {
        if (i != this.f10507y) {
            this.f10507y = i;
            ImageBlockLayout.LayoutParams layoutParams = new ImageBlockLayout.LayoutParams(-2, -2);
            layoutParams.b = true;
            layoutParams.d = 17;
            layoutParams.leftMargin = 0;
            if (this.a != null) {
                super.removeView(this.a);
            }
            FbTextView fbTextView;
            switch (i) {
                case 1:
                    FigButton figButton = new FigButton(getContext());
                    figButton.setType(36);
                    figButton.setTextColor(-16777216);
                    super.addView(figButton, 0, layoutParams);
                    break;
                case 2:
                    super.addView(new FbCheckBox(getContext()), 0, layoutParams);
                    break;
                case 3:
                    super.addView(new SwitchCompat(getContext()), 0, layoutParams);
                    break;
                case 4:
                    super.addView(new FbRadioButton(getContext()), 0, layoutParams);
                    break;
                case 5:
                    fbTextView = new FbTextView(getContext());
                    fbTextView.setTextAppearance(getContext(), 2131624531);
                    super.addView(fbTextView, 0, layoutParams);
                    break;
                case 6:
                    GlyphView glyphView = new GlyphView(getContext());
                    glyphView.setGlyphColor(ContextCompat.b(getContext(), 2131362108));
                    glyphView.setImageDrawable(ContextCompat.a(getContext(), 2130839667));
                    super.addView(glyphView, 0, layoutParams);
                    break;
                case 7:
                    FigToggleButton figToggleButton = new FigToggleButton(getContext());
                    figToggleButton.setType(20);
                    super.addView(figToggleButton, 0, layoutParams);
                    break;
                case 8:
                    fbTextView = new FbTextView(getContext());
                    fbTextView.setTextAppearance(getContext(), 2131624532);
                    super.addView(fbTextView, 0, layoutParams);
                    break;
            }
            requestLayout();
            invalidate();
        }
    }

    public void setActionDrawable(Drawable drawable) {
        switch (this.f10507y) {
            case 7:
                ((FigToggleButton) this.a).setGlyph(drawable);
                break;
        }
        requestLayout();
        invalidate();
    }

    public void setActionText(CharSequence charSequence) {
        switch (this.f10507y) {
            case 1:
                ((FigButton) this.a).setText(charSequence);
                break;
            case 5:
                ((FbTextView) this.a).setText(charSequence);
                break;
            case 8:
                ((FbTextView) this.a).setText(charSequence);
                break;
        }
        requestLayout();
        invalidate();
    }

    public void setActionState(boolean z) {
        switch (this.f10507y) {
            case 2:
                ((FbCheckBox) this.a).setChecked(z);
                break;
            case 3:
                ((SwitchCompat) this.a).setChecked(z);
                break;
            case 4:
                ((FbRadioButton) this.a).setChecked(z);
                break;
            case 7:
                ((FigToggleButton) this.a).setChecked(z);
                break;
        }
        requestLayout();
        invalidate();
    }

    public boolean getActionState() {
        switch (this.f10507y) {
            case 2:
                return ((FbCheckBox) this.a).isChecked();
            case 3:
                return ((SwitchCompat) this.a).isChecked();
            case 4:
                return ((FbRadioButton) this.a).isChecked();
            case 7:
                return ((FigToggleButton) this.a).isChecked();
            default:
                return false;
        }
    }

    public void setActionOnClickListener(OnClickListener onClickListener) {
        if (this.a != null) {
            this.a.setOnClickListener(onClickListener);
        }
    }

    public void setActionContentDescription(CharSequence charSequence) {
        if (this.a != null) {
            this.a.setContentDescription(charSequence);
        }
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        this.f10496n.m16655a(accessibilityEvent);
        this.f10497o.m16655a(accessibilityEvent);
        this.f10498p.m16655a(accessibilityEvent);
        return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    @VisibleForTesting
    public void setAuxView(View view) {
        this.a = view;
    }

    private boolean m16667g() {
        return (this.f10496n.m16660c() + this.f10497o.m16660c()) + this.f10498p.m16660c() < getThumbnailDimensionSize();
    }

    private int getTopPaddingCenterTextContent() {
        return (getThumbnailDimensionSize() - ((this.f10496n.m16660c() + this.f10497o.m16660c()) + this.f10498p.m16660c())) / 2;
    }
}
