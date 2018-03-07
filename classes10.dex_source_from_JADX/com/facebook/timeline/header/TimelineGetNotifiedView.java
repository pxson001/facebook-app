package com.facebook.timeline.header;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import com.facebook.ultralight.Inject;
import com.facebook.widget.CustomLinearLayout;
import javax.annotation.Nullable;

/* compiled from: friends_center_total_searches */
public class TimelineGetNotifiedView extends CustomLinearLayout {
    @Inject
    AllCapsTransformationMethod f11323a;
    @Inject
    GlyphColorizer f11324b;
    private FbTextView f11325c;
    private FbTextView f11326d;

    private static <T extends View> void m11407a(Class<T> cls, T t) {
        m11408a((Object) t, t.getContext());
    }

    private static void m11408a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((TimelineGetNotifiedView) obj).m11406a(AllCapsTransformationMethod.b(fbInjector), GlyphColorizer.a(fbInjector));
    }

    private void m11406a(AllCapsTransformationMethod allCapsTransformationMethod, GlyphColorizer glyphColorizer) {
        this.f11323a = allCapsTransformationMethod;
        this.f11324b = glyphColorizer;
    }

    public TimelineGetNotifiedView(Context context) {
        super(context);
        m11409b();
    }

    public TimelineGetNotifiedView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m11409b();
    }

    public TimelineGetNotifiedView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m11409b();
    }

    private void m11409b() {
        m11407a(TimelineGetNotifiedView.class, (View) this);
    }

    protected void onFinishInflate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -975866966);
        super.onFinishInflate();
        this.f11325c = (FbTextView) a(2131567933);
        this.f11326d = (FbTextView) a(2131567934);
        this.f11326d.setTransformationMethod(this.f11323a);
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1783569511, a);
    }

    public void setButtonStateToAsk(OnClickListener onClickListener) {
        this.f11325c.setText(2131235074);
        this.f11326d.setText(2131235072);
        this.f11326d.setOnClickListener(onClickListener);
        this.f11326d.setBackgroundResource(2131362081);
        this.f11326d.setCompoundDrawables(null, null, null, null);
    }

    public final void m11410a() {
        this.f11325c.setText(2131235075);
        this.f11326d.setOnClickListener(null);
        this.f11326d.setText(2131235073);
        this.f11326d.setBackgroundResource(2131362177);
        this.f11326d.setCompoundDrawablesWithIntrinsicBounds(this.f11324b.a(2130839776, -1), null, null, null);
        this.f11326d.setCompoundDrawablePadding(getResources().getDimensionPixelSize(2131429982));
    }
}
