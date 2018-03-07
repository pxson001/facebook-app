package com.facebook.richdocument.view.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.Layout;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.text.style.UnderlineSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.widget.TextView;
import com.facebook.R;
import com.facebook.common.util.StringUtil;
import com.facebook.composer.activity.ComposerLauncherImpl;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import com.facebook.richdocument.RichDocumentInfo;
import com.facebook.richdocument.fonts.RichDocumentFontManager;
import com.facebook.richdocument.ham.ExtraPaddingAware;
import com.facebook.richdocument.ham.HamDimensions;
import com.facebook.richdocument.logging.RichDocumentAnalyticsLogger;
import com.facebook.richdocument.model.block.RichText;
import com.facebook.richdocument.utils.UIUtils;
import com.facebook.richdocument.view.block.BlockViewUtil;
import com.facebook.richdocument.view.block.BlockViewUtil.C07471;
import com.facebook.richdocument.view.block.impl.TextBlockViewImpl.C07651;
import com.facebook.richdocument.view.touch.RichDocumentTouch;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.CustomFrameLayout;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: offer_title */
public class RichTextView extends CustomFrameLayout implements ExtraPaddingAware {
    @Inject
    RichTextUtils f7390a;
    @Inject
    HamDimensions f7391b;
    @Inject
    CopyPasteTouchHandlerProvider f7392c;
    public InnerRichTextView f7393d;
    private final Rect f7394e;
    public int f7395f;
    public int f7396g;
    private int f7397h;
    public C07651 f7398i;
    private CopyPasteTouchHandler f7399j;
    public boolean f7400k;

    /* compiled from: offer_title */
    public class InnerRichTextView extends FbTextView {
        final /* synthetic */ RichTextView f7386a;
        public int f7387b;
        private final TextAppearance f7388c;
        public boolean f7389d;

        /* compiled from: offer_title */
        class TextAppearance {
            final /* synthetic */ InnerRichTextView f7369a;
            private final int f7370b;
            private final ColorStateList f7371c;
            private final float f7372d;
            private final ColorStateList f7373e;
            private final ColorStateList f7374f;
            private final Typeface f7375g;
            private final int f7376h;
            private final float f7377i;
            private final float f7378j;
            private final float f7379k;
            private final TransformationMethod f7380l;
            private final boolean f7381m;
            private final float f7382n;
            private final String f7383o;
            private final int f7384p;
            private final Drawable f7385q;

            TextAppearance(InnerRichTextView innerRichTextView, InnerRichTextView innerRichTextView2) {
                this.f7369a = innerRichTextView;
                this.f7384p = innerRichTextView2.f7387b;
                this.f7371c = innerRichTextView2.getTextColors();
                this.f7372d = innerRichTextView2.getTextSize();
                this.f7373e = innerRichTextView2.getHintTextColors();
                this.f7374f = innerRichTextView2.getLinkTextColors();
                this.f7375g = innerRichTextView2.getTypeface();
                this.f7385q = innerRichTextView2.getBackground();
                if (VERSION.SDK_INT >= 16) {
                    this.f7370b = innerRichTextView2.getHighlightColor();
                    this.f7376h = innerRichTextView2.getShadowColor();
                    this.f7377i = innerRichTextView2.getShadowDx();
                    this.f7378j = innerRichTextView2.getShadowDy();
                    this.f7379k = innerRichTextView2.getShadowRadius();
                } else {
                    this.f7370b = 0;
                    this.f7376h = 0;
                    this.f7377i = 0.0f;
                    this.f7378j = 0.0f;
                    this.f7379k = 0.0f;
                }
                this.f7380l = innerRichTextView2.getTransformationMethod();
                if (VERSION.SDK_INT > 21) {
                    this.f7381m = innerRichTextView2.getPaint().isElegantTextHeight();
                    this.f7382n = innerRichTextView2.getLetterSpacing();
                    this.f7383o = innerRichTextView2.getFontFeatureSettings();
                    return;
                }
                this.f7381m = false;
                this.f7382n = 0.0f;
                this.f7383o = null;
            }

            final void m7619a(InnerRichTextView innerRichTextView) {
                innerRichTextView.setHighlightColor(this.f7370b);
                innerRichTextView.setTextColor(this.f7371c);
                innerRichTextView.setTextSize(0, this.f7372d);
                innerRichTextView.setHintTextColor(this.f7373e);
                innerRichTextView.setLinkTextColor(this.f7374f);
                innerRichTextView.setTypeface(this.f7375g);
                if (VERSION.SDK_INT >= 16 && this.f7376h != 0) {
                    innerRichTextView.setShadowLayer(this.f7379k, this.f7377i, this.f7378j, this.f7376h);
                }
                innerRichTextView.setTransformationMethod(this.f7380l);
                if (VERSION.SDK_INT > 21) {
                    innerRichTextView.setElegantTextHeight(this.f7381m);
                    innerRichTextView.setLetterSpacing(this.f7382n);
                    innerRichTextView.setFontFeatureSettings(this.f7383o);
                }
                innerRichTextView.m7625a(this.f7384p);
                innerRichTextView.setBackground(this.f7385q);
            }
        }

        public InnerRichTextView(RichTextView richTextView, Context context, AttributeSet attributeSet) {
            this(richTextView, context, attributeSet, 0);
        }

        private InnerRichTextView(RichTextView richTextView, Context context, @Nullable AttributeSet attributeSet, int i) {
            int resourceId;
            int resourceId2;
            this.f7386a = richTextView;
            super(context, attributeSet, i);
            this.f7389d = true;
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RichText, i, i);
                resourceId = obtainStyledAttributes.getResourceId(0, 0);
                resourceId2 = obtainStyledAttributes.getResourceId(2, 0);
                setFallbackFont(obtainStyledAttributes);
                obtainStyledAttributes.recycle();
            } else {
                resourceId2 = 0;
                resourceId = 0;
            }
            if (richTextView.f7391b.m5277c(resourceId2)) {
                float a = richTextView.f7391b.m5275a(resourceId2);
                if (a > 0.0f) {
                    setTextSize(0, a);
                }
            }
            if (richTextView.f7391b.m5277c(resourceId)) {
                m7625a(richTextView.f7391b.m5276b(resourceId));
            }
            this.f7388c = new TextAppearance(this, this);
            resourceId2 = richTextView.f7391b.m5276b(2131558724);
            RichDocumentTouch.m7189a(this, Integer.valueOf(resourceId2), Integer.valueOf(resourceId2), Integer.valueOf(2));
        }

        protected void onMeasure(int i, int i2) {
            int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -785695395);
            super.onMeasure(i, i2);
            if (this.f7389d) {
                Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1005634575, a);
                return;
            }
            Layout layout = getLayout();
            if (layout == null || layout.getLineCount() == 1) {
                LogUtils.g(471729598, a);
                return;
            }
            setMeasuredDimension((((int) Math.ceil((double) m7620a(layout))) + getCompoundPaddingLeft()) + getCompoundPaddingRight(), getMeasuredHeight());
            LogUtils.g(975070961, a);
        }

        private static float m7620a(Layout layout) {
            int lineCount = layout.getLineCount();
            float f = 0.0f;
            for (int i = 0; i < lineCount; i++) {
                if (layout.getLineMax(i) > f) {
                    f = layout.getLineWidth(i);
                }
            }
            return f;
        }

        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            if (getLineSpacingExtra() < 0.0f) {
                setBottom(getBottom() - ((int) getLineSpacingExtra()));
            }
        }

        public void setTextAppearance(Context context, int i) {
            int resourceId;
            int resourceId2;
            int resourceId3;
            super.setTextAppearance(context, i);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, R.styleable.RichText);
            if (obtainStyledAttributes != null) {
                resourceId = obtainStyledAttributes.getResourceId(0, 0);
                resourceId2 = obtainStyledAttributes.getResourceId(1, 0);
                resourceId3 = obtainStyledAttributes.getResourceId(2, 0);
                setFallbackFont(obtainStyledAttributes);
                obtainStyledAttributes.recycle();
            } else {
                resourceId3 = 0;
                resourceId2 = 0;
                resourceId = 0;
            }
            if (this.f7386a.f7391b.m5277c(resourceId3)) {
                float a = this.f7386a.f7391b.m5275a(resourceId3);
                if (a > 0.0f) {
                    setTextSize(0, a);
                }
            }
            if (this.f7386a.f7391b.m5277c(resourceId2)) {
                m7622a(this.f7386a.f7391b.m5275a(resourceId2));
            } else {
                m7622a(0.0f);
            }
            if (this.f7386a.f7391b.m5277c(resourceId)) {
                m7625a(this.f7386a.f7391b.m5276b(resourceId));
            }
        }

        public void setMatchParentWidth(boolean z) {
            this.f7389d = z;
        }

        private void setFallbackFont(@Nullable TypedArray typedArray) {
            if (typedArray != null) {
                String string = typedArray.getString(3);
                if (!StringUtil.a(string)) {
                    Typeface a = RichDocumentFontManager.m5202a(string);
                    if (a == null) {
                        a = Typeface.DEFAULT;
                    }
                    setTypeface(a);
                }
            }
        }

        private void m7622a(float f) {
            int b = (int) (((float) this.f7386a.f7391b.m5276b(2131558650)) * f);
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) getLayoutParams();
            marginLayoutParams.setMargins(0, 0, b, 0);
            if (VERSION.SDK_INT >= 17) {
                marginLayoutParams.setMarginStart(0);
                marginLayoutParams.setMarginEnd(b);
            }
        }

        public void setTypeface(Typeface typeface) {
            super.setTypeface(typeface);
            m7625a(this.f7387b);
        }

        public void setTextSize(float f) {
            super.setTextSize(f);
            m7625a(this.f7387b);
        }

        public void setTextSize(int i, float f) {
            super.setTextSize(i, f);
            m7625a(this.f7387b);
        }

        public void setTypeface(Typeface typeface, int i) {
            super.setTypeface(typeface, i);
            m7625a(this.f7387b);
        }

        public final void m7625a(int i) {
            this.f7387b = i;
            if (i <= 0) {
                setLineSpacing(0.0f, 1.0f);
            } else {
                setLineSpacing((float) m7623b(), 1.0f);
            }
        }

        private int m7623b() {
            return this.f7387b - (getLineHeight() - ((int) getLineSpacingExtra()));
        }

        public void setText(RichText richText) {
            this.f7386a.f7390a.m1359a((TextView) this, richText);
        }

        public int getWindowAttachmentCount() {
            return getWindowAttachCount();
        }

        public final void m7624a() {
            this.f7386a.f7395f = 0;
            this.f7386a.f7396g = 0;
            setText("");
            this.f7388c.m7619a(this);
        }
    }

    private static <T extends View> void m7628a(Class<T> cls, T t) {
        m7629a((Object) t, t.getContext());
    }

    private static void m7629a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((RichTextView) obj).m7627a(RichTextUtils.m1355a(injectorLike), HamDimensions.m5268a(injectorLike), (CopyPasteTouchHandlerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(CopyPasteTouchHandlerProvider.class));
    }

    public RichTextView(Context context) {
        this(context, null);
    }

    public RichTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RichTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f7394e = new Rect();
        this.f7400k = true;
        m7628a(RichTextView.class, (View) this);
        this.f7393d = new InnerRichTextView(this, context, attributeSet);
        UIUtils.m6864a(this.f7393d, 0);
        super.addView(this.f7393d);
        this.f7393d.setPadding(0, 0, 0, 0);
        this.f7393d.setGravity(0);
        LayoutParams layoutParams = (MarginLayoutParams) this.f7393d.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new MarginLayoutParams(-2, -2);
        }
        layoutParams.setMargins(0, 0, 0, 0);
        this.f7393d.setLayoutParams(layoutParams);
        this.f7393d.setIncludeFontPadding(false);
        this.f7393d.setVisibility(0);
        setClipChildren(false);
        setClipToPadding(false);
        this.f7393d.getPaint().setLinearText(true);
        this.f7393d.getPaint().setSubpixelText(true);
    }

    private void m7627a(RichTextUtils richTextUtils, HamDimensions hamDimensions, CopyPasteTouchHandlerProvider copyPasteTouchHandlerProvider) {
        this.f7390a = richTextUtils;
        this.f7391b = hamDimensions;
        this.f7392c = copyPasteTouchHandlerProvider;
    }

    public void addView(View view) {
        if (getChildCount() == 0) {
            super.addView(view);
        }
    }

    public void addView(View view, int i) {
        if (getChildCount() == 0) {
            super.addView(view, i);
        }
    }

    public void addView(View view, int i, int i2) {
        if (getChildCount() == 0) {
            super.addView(view, i, i2);
        }
    }

    public int getExtraPaddingBottom() {
        return this.f7397h;
    }

    private static boolean m7630a(CharSequence charSequence, int i, int i2) {
        if (!(charSequence instanceof SpannableString) || ((SpannableString) charSequence).getSpans(i, i2, UnderlineSpan.class).length <= 0) {
            return false;
        }
        return true;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f7400k) {
            CharSequence text = this.f7393d.getText();
            String charSequence = text.toString();
            TextPaint paint = this.f7393d.getPaint();
            int measuredHeight = getMeasuredHeight();
            int paddingBottom;
            if (this.f7393d.getLineCount() == 1) {
                paint.getTextBounds(charSequence, 0, charSequence.length(), this.f7394e);
                this.f7395f = (this.f7394e.top - paint.getFontMetricsInt().ascent) - getPaddingTop();
                paddingBottom = (((m7630a(text, 0, text.length()) ? paint.getFontMetricsInt().descent : this.f7394e.bottom) - this.f7394e.top) + getPaddingBottom()) + getPaddingTop();
                setMeasuredDimension(getMeasuredWidth(), paddingBottom);
                this.f7396g = (measuredHeight - paddingBottom) - this.f7395f;
                setExtraPaddingBottom(this.f7394e.bottom);
            } else if (this.f7393d.getLineCount() > 1) {
                int min;
                Layout layout = this.f7393d.getLayout();
                int lineEnd = layout.getLineEnd(0);
                int lineStart = layout.getLineStart(this.f7393d.getLineCount() - 1);
                paint.getTextBounds(charSequence, 0, lineEnd, this.f7394e);
                this.f7395f = (this.f7394e.top - paint.getFontMetricsInt().ascent) + getPaddingTop();
                lineEnd = this.f7394e.top - paint.getFontMetricsInt().ascent;
                paint.getTextBounds(charSequence, lineStart, charSequence.length(), this.f7394e);
                paddingBottom = m7630a(text, lineStart, text.length()) ? 0 : paint.getFontMetricsInt().descent - this.f7394e.bottom;
                if (VERSION.SDK_INT >= 21) {
                    min = Math.min(0, (int) this.f7393d.getLineSpacingExtra());
                } else {
                    min = Math.round(this.f7393d.getLineSpacingExtra());
                }
                paddingBottom = ((((getMeasuredHeight() - lineEnd) - paddingBottom) + getPaddingBottom()) + getPaddingTop()) - min;
                setMeasuredDimension(getMeasuredWidth(), paddingBottom);
                this.f7396g = (measuredHeight - paddingBottom) - this.f7395f;
                setExtraPaddingBottom(this.f7394e.bottom);
            }
        }
    }

    private void setExtraPaddingBottom(int i) {
        int i2 = this.f7397h;
        this.f7397h = i;
        if (this.f7398i != null && i2 != this.f7397h) {
            ViewHolder viewHolder = this.f7398i.f6808a.f6602a;
            if (viewHolder != null) {
                for (ViewParent parent = viewHolder.a.getParent(); parent != null; parent = parent.getParent()) {
                    if (parent instanceof RecyclerView) {
                        RecyclerView recyclerView = (RecyclerView) parent;
                        recyclerView.post(new C07471(recyclerView));
                    }
                }
            }
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f7393d.setY((float) (-this.f7395f));
    }

    public InnerRichTextView getInnerRichTextView() {
        return this.f7393d;
    }

    public int getTopPixelsRemovedFromPadding() {
        return this.f7395f;
    }

    public int getBottomPixelsRemovedFromPadding() {
        return this.f7396g;
    }

    public void setEnableCopy(boolean z) {
        if (!z) {
            this.f7393d.setOnTouchListener(null);
            this.f7399j = null;
        } else if (this.f7399j == null) {
            InjectorLike injectorLike = this.f7392c;
            this.f7399j = new CopyPasteTouchHandler(this.f7393d, (ComposerLauncher) ComposerLauncherImpl.a(injectorLike), RichDocumentInfo.m5102a(injectorLike), RichDocumentAnalyticsLogger.m5360a(injectorLike), BlockViewUtil.m6915a(injectorLike));
            this.f7393d.setOnTouchListener(this.f7399j);
        }
    }

    public void setShouldCustomMeasure(boolean z) {
        this.f7400k = z;
    }
}
