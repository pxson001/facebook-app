package com.facebook.events.permalink.about;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.LinearGradient;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.text.Layout.Alignment;
import android.text.Spannable;
import android.text.StaticLayout;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: cancelnag_ */
public class DetailsTextView extends FbTextView {
    private float f17896a = 1.0f;
    private float f17897b = 0.0f;
    private boolean f17898c;
    private boolean f17899d;
    public boolean f17900e;
    private int f17901f;
    private int f17902g;
    private int f17903h;
    private int f17904i;
    private int f17905j;
    private Rect f17906k;
    public DetailsTextViewListener f17907l;
    private SparseIntArray f17908m;
    private SparseIntArray f17909n;

    /* compiled from: cancelnag_ */
    public interface DetailsTextViewListener {
        void mo817a();

        void mo818b();
    }

    public DetailsTextView(Context context) {
        super(context);
    }

    public DetailsTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m18312b();
    }

    public DetailsTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m18312b();
    }

    private void m18312b() {
        Resources resources = getResources();
        this.f17904i = resources.getColor(2131363341);
        this.f17903h = resources.getDimensionPixelSize(2131431167);
        this.f17902g = 12;
        setMaxLines(this.f17902g);
        this.f17906k = new Rect();
        this.f17909n = new SparseIntArray();
        this.f17908m = new SparseIntArray();
        this.f17905j = getResources().getConfiguration().orientation;
        setFocusable(false);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 1699243285);
        if (motionEvent.getAction() != 1) {
            Logger.a(2, EntryType.UI_INPUT_END, 101834885, a);
        } else if (this.f17898c && (getText() instanceof Spannable) && getMovementMethod().onTouchEvent(this, (Spannable) getText(), motionEvent)) {
            LogUtils.a(-547447938, a);
        } else {
            m18313c();
            LogUtils.a(-353157975, a);
        }
        return true;
    }

    public void setOnExpandCollapseListener(DetailsTextViewListener detailsTextViewListener) {
        this.f17907l = detailsTextViewListener;
    }

    private void m18313c() {
        if (this.f17898c) {
            m18314d();
        } else {
            m18315e();
        }
    }

    private void m18315e() {
        if (this.f17901f < this.f17902g) {
            this.f17902g = this.f17901f;
        }
        this.f17898c = true;
        setMaxLines(Integer.MAX_VALUE);
        m18316f();
        if (this.f17907l != null) {
            this.f17907l.mo817a();
        }
    }

    private void setFadingGradient(int i) {
        getPaint().setShader(new LinearGradient(0.0f, (float) (i - this.f17903h), 0.0f, (float) i, getCurrentTextColor(), this.f17904i, TileMode.CLAMP));
    }

    private void m18316f() {
        getPaint().setShader(null);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.f17899d) {
            if (!this.f17898c && getLineCount() <= this.f17901f) {
                this.f17898c = true;
                this.f17900e = true;
                m18316f();
            } else if (getLineCount() > this.f17901f) {
                this.f17898c = false;
                this.f17900e = false;
                setFadingGradient(getHeight());
            }
            this.f17899d = false;
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f17899d = true;
        if (getLayoutParams() != null) {
            getLayoutParams().height = -2;
        }
        if (this.f17908m != null) {
            this.f17908m.clear();
        }
        if (this.f17909n != null) {
            this.f17909n.clear();
        }
        super.onTextChanged(charSequence, i, i2, i3);
    }

    public void setMaxLines(int i) {
        this.f17901f = i;
        super.setMaxLines(i);
    }

    public void setLineSpacing(float f, float f2) {
        super.setLineSpacing(f, f2);
        this.f17896a = f2;
        this.f17897b = f;
    }

    private void m18314d() {
        if (!this.f17900e) {
            getLocalVisibleRect(this.f17906k);
            this.f17898c = false;
            setMaxLines(this.f17902g);
            setFadingGradient(getCollapsedStateHeight());
            if (this.f17907l != null) {
                this.f17907l.mo818b();
            }
        }
    }

    private boolean m18317g() {
        return this.f17900e;
    }

    private void setIsRigid(boolean z) {
        this.f17900e = z;
    }

    public final void m18319a() {
        setMovementMethod(LinkMovementMethod.getInstance());
        setFocusable(false);
    }

    private void m18318h() {
        if (this.f17909n.indexOfKey(this.f17905j) <= 0 || this.f17908m.indexOfKey(this.f17905j) <= 0) {
            StaticLayout staticLayout = new StaticLayout(getText(), getPaint(), (getWidth() - getCompoundPaddingLeft()) - getCompoundPaddingRight(), Alignment.ALIGN_NORMAL, this.f17896a, this.f17897b, true);
            this.f17908m.put(this.f17905j, (staticLayout.getHeight() + getCompoundPaddingBottom()) + getCompoundPaddingTop());
            this.f17909n.put(this.f17905j, (staticLayout.getLineTop(this.f17902g) + getCompoundPaddingTop()) + getCompoundPaddingBottom());
        }
    }

    private int getExpandedStateHeight() {
        m18318h();
        return this.f17908m.get(this.f17905j);
    }

    private int getCollapsedStateHeight() {
        m18318h();
        return this.f17909n.get(this.f17905j);
    }

    protected void onConfigurationChanged(Configuration configuration) {
        if (this.f17905j != configuration.orientation) {
            this.f17905j = configuration.orientation;
            getLayoutParams().height = -2;
        }
    }
}
