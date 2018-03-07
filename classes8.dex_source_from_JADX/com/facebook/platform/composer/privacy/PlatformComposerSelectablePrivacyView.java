package com.facebook.platform.composer.privacy;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.composer.privacy.common.ComposerPrivacyData;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.privacy.model.PrivacyLoadingToken;
import com.facebook.privacy.selector.AudienceTypeaheadUtil;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.tokenizedtypeahead.model.BaseToken;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: results_vertical */
public class PlatformComposerSelectablePrivacyView extends CustomLinearLayout {
    @Inject
    AudienceTypeaheadUtil f4261a;
    @Inject
    PlatformComposerTagExpandPrivacyHelper f4262b;
    private ImmutableList<BaseToken> f4263c;
    private View f4264d;
    private View f4265e;
    private View f4266f;
    private TextView f4267g;
    public boolean f4268h;
    private boolean f4269i;
    private ComposerPrivacyData f4270j;
    private ImmutableList<BaseToken> f4271k;
    private boolean f4272l = false;

    private static <T extends View> void m4195a(Class<T> cls, T t) {
        m4196a((Object) t, t.getContext());
    }

    private static void m4196a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((PlatformComposerSelectablePrivacyView) obj).m4194a(AudienceTypeaheadUtil.b(fbInjector), PlatformComposerTagExpandPrivacyHelper.m4201a(fbInjector));
    }

    public PlatformComposerSelectablePrivacyView(Context context) {
        super(context);
        m4193a();
    }

    public PlatformComposerSelectablePrivacyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m4193a();
    }

    private void m4193a() {
        m4195a(PlatformComposerSelectablePrivacyView.class, (View) this);
        setContentView(2130906316);
        this.f4263c = ImmutableList.of(new PrivacyLoadingToken(getContext()));
        this.f4264d = a(2131560618);
        this.f4266f = a(2131560616);
        this.f4267g = (TextView) a(2131560617);
        this.f4265e = a(2131560619);
        setAsLoading(true);
    }

    private void m4194a(AudienceTypeaheadUtil audienceTypeaheadUtil, PlatformComposerTagExpandPrivacyHelper platformComposerTagExpandPrivacyHelper) {
        this.f4261a = audienceTypeaheadUtil;
        this.f4262b = platformComposerTagExpandPrivacyHelper;
    }

    public void setOnClickListener(final OnClickListener onClickListener) {
        OnClickListener c05471 = new OnClickListener(this) {
            final /* synthetic */ PlatformComposerSelectablePrivacyView f4260b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1729254570);
                if (this.f4260b.f4268h) {
                    Logger.a(2, EntryType.UI_INPUT_END, -296391451, a);
                    return;
                }
                onClickListener.onClick(view);
                LogUtils.a(1841965268, a);
            }
        };
        super.setOnClickListener(c05471);
        this.f4267g.setOnClickListener(c05471);
    }

    public final void m4199a(boolean z, ComposerPrivacyData composerPrivacyData) {
        boolean z2 = composerPrivacyData.d || !(composerPrivacyData.b == null || composerPrivacyData.b.a == null);
        Preconditions.checkArgument(z2, "Trying to display an invalid ComposerPrivacyData in SelectablePrivacyView");
        if (z == this.f4269i && this.f4270j != null) {
            if (!this.f4270j.d || !composerPrivacyData.d) {
                if (this.f4270j.b != null && this.f4270j.b.equals(composerPrivacyData.b)) {
                    return;
                }
            }
            return;
        }
        this.f4269i = z;
        this.f4270j = composerPrivacyData;
        setAsLoading(this.f4270j.d);
    }

    private void setAsLoading(boolean z) {
        if (z) {
            this.f4271k = this.f4263c;
            this.f4264d.setVisibility(0);
            this.f4265e.setVisibility(8);
            this.f4267g.setAlpha(0.5f);
        } else {
            this.f4265e.setVisibility(0);
            this.f4264d.setVisibility(8);
            this.f4267g.setAlpha(1.0f);
            this.f4271k = this.f4261a.a(this.f4270j.b, getResources(), this.f4269i, true);
        }
        this.f4268h = z;
        this.f4272l = true;
        invalidate();
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -367996853);
        super.onSizeChanged(i, i2, i3, i4);
        this.f4272l = true;
        invalidate();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1027170626, a);
    }

    private void m4198b() {
        this.f4267g.setText(this.f4262b.m4204a(getContext(), this.f4271k, this.f4267g.getTextSize(), this.f4266f.getMeasuredWidth(), false));
    }

    protected void onDraw(Canvas canvas) {
        if (this.f4272l) {
            this.f4272l = false;
            m4198b();
        }
    }
}
