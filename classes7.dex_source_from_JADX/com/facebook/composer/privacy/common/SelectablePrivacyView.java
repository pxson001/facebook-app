package com.facebook.composer.privacy.common;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.TextView;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.privacy.model.PrivacyLoadingToken;
import com.facebook.privacy.selector.AudienceTypeaheadUtil;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.LazyView;
import com.facebook.widget.tokenizedtypeahead.model.BaseToken;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: tapped_place_claim */
public class SelectablePrivacyView extends CustomLinearLayout {
    @Inject
    AudienceTypeaheadUtil f2039a;
    @Inject
    TagExpandPrivacyHelper f2040b;
    private ImmutableList<BaseToken> f2041c;
    private View f2042d;
    private LazyView<View> f2043e;
    private View f2044f;
    private TextView f2045g;
    public boolean f2046h;
    private boolean f2047i;
    private ComposerPrivacyData f2048j;
    private ImmutableList<BaseToken> f2049k;
    private boolean f2050l = false;

    private static <T extends View> void m1986a(Class<T> cls, T t) {
        m1987a((Object) t, t.getContext());
    }

    private static void m1987a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((SelectablePrivacyView) obj).m1985a(AudienceTypeaheadUtil.b(injectorLike), TagExpandPrivacyHelper.m1991a(injectorLike));
    }

    private void m1985a(AudienceTypeaheadUtil audienceTypeaheadUtil, TagExpandPrivacyHelper tagExpandPrivacyHelper) {
        this.f2039a = audienceTypeaheadUtil;
        this.f2040b = tagExpandPrivacyHelper;
    }

    public SelectablePrivacyView(Context context) {
        super(context);
        m1984a();
    }

    public SelectablePrivacyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m1984a();
    }

    private void m1984a() {
        m1986a(SelectablePrivacyView.class, (View) this);
        setContentView(2130903723);
        this.f2041c = ImmutableList.of(new PrivacyLoadingToken(getContext()));
        this.f2042d = a(2131560618);
        this.f2043e = new LazyView((ViewStub) a(2131560619));
        this.f2044f = a(2131560616);
        this.f2045g = (TextView) a(2131560617);
        setAsLoading(true);
    }

    public void setOnClickListener(final OnClickListener onClickListener) {
        OnClickListener c02121 = new OnClickListener(this) {
            final /* synthetic */ SelectablePrivacyView f2038b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1042480681);
                if (this.f2038b.f2046h) {
                    Logger.a(2, EntryType.UI_INPUT_END, -199432558, a);
                    return;
                }
                onClickListener.onClick(view);
                LogUtils.a(-1529588184, a);
            }
        };
        super.setOnClickListener(c02121);
        this.f2045g.setOnClickListener(c02121);
    }

    public final void m1990a(boolean z, ComposerPrivacyData composerPrivacyData) {
        boolean z2 = composerPrivacyData.f2003d || !(composerPrivacyData.f2001b == null || composerPrivacyData.f2001b.a == null);
        Preconditions.checkArgument(z2, "Trying to display an invalid ComposerPrivacyData in SelectablePrivacyView");
        if (z == this.f2047i && this.f2048j != null) {
            if (!this.f2048j.f2003d || !composerPrivacyData.f2003d) {
                if (this.f2048j.f2001b != null && this.f2048j.f2001b.equals(composerPrivacyData.f2001b)) {
                    return;
                }
            }
            return;
        }
        this.f2047i = z;
        this.f2048j = composerPrivacyData;
        setAsLoading(this.f2048j.f2003d);
    }

    private void setAsLoading(boolean z) {
        if (z) {
            this.f2049k = this.f2041c;
            this.f2042d.setVisibility(0);
            this.f2043e.c();
            this.f2045g.setAlpha(0.5f);
        } else {
            this.f2042d.setVisibility(8);
            this.f2043e.a().setVisibility(0);
            this.f2045g.setAlpha(1.0f);
            this.f2049k = this.f2039a.a(this.f2048j.f2001b, getResources(), this.f2047i, true);
        }
        this.f2046h = z;
        this.f2050l = true;
        invalidate();
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -354547716);
        super.onSizeChanged(i, i2, i3, i4);
        this.f2050l = true;
        invalidate();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 664355229, a);
    }

    private void m1989b() {
        this.f2045g.setText(this.f2040b.m1994a(getContext(), this.f2049k, this.f2045g.getTextSize(), this.f2044f.getMeasuredWidth(), false, false));
    }

    protected void onDraw(Canvas canvas) {
        if (this.f2050l) {
            this.f2050l = false;
            m1989b();
        }
    }
}
