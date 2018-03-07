package com.facebook.timeline.header.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import com.facebook.fig.button.FigButton;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import javax.inject.Inject;

/* compiled from: fetchOwnedPages */
public class TimelineIntroCardEmptySectionWithBordersView extends FigButton implements TimelineIntroCardEmptySection {
    @Inject
    AllCapsTransformationMethod f12021j;

    private static <T extends View> void m12051a(Class<T> cls, T t) {
        m12052a((Object) t, t.getContext());
    }

    private static void m12052a(Object obj, Context context) {
        ((TimelineIntroCardEmptySectionWithBordersView) obj).m12054a(AllCapsTransformationMethod.b(FbInjector.get(context)));
    }

    final void m12054a(AllCapsTransformationMethod allCapsTransformationMethod) {
        this.f12021j = allCapsTransformationMethod;
    }

    public TimelineIntroCardEmptySectionWithBordersView(Context context) {
        super(context);
    }

    public TimelineIntroCardEmptySectionWithBordersView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void m12053b() {
        m12051a(TimelineIntroCardEmptySectionWithBordersView.class, (View) this);
        setTransformationMethod(this.f12021j);
    }

    protected void onFinishInflate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 432154649);
        super.onFinishInflate();
        m12053b();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1222391519, a);
    }

    public void setLabelText(CharSequence charSequence) {
        setText(charSequence);
    }

    public void setIcon(int i) {
        setGlyph(i);
    }
}
