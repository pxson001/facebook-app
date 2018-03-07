package com.facebook.timeline.header.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomLinearLayout;
import javax.inject.Inject;

/* compiled from: fetchSinglePage */
public class TimelineIntroCardEmptySectionView extends CustomLinearLayout implements TimelineIntroCardEmptySection {
    @Inject
    public AllCapsTransformationMethod f12018a;
    private FbTextView f12019b;
    private GlyphView f12020c;

    private static <T extends View> void m12049a(Class<T> cls, T t) {
        m12050a((Object) t, t.getContext());
    }

    private static void m12050a(Object obj, Context context) {
        ((TimelineIntroCardEmptySectionView) obj).f12018a = AllCapsTransformationMethod.b(FbInjector.get(context));
    }

    private void m12048a(AllCapsTransformationMethod allCapsTransformationMethod) {
        this.f12018a = allCapsTransformationMethod;
    }

    public TimelineIntroCardEmptySectionView(Context context) {
        super(context);
    }

    public TimelineIntroCardEmptySectionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void m12047a() {
        m12049a(TimelineIntroCardEmptySectionView.class, (View) this);
        this.f12019b = (FbTextView) a(2131567941);
        this.f12019b.setTransformationMethod(this.f12018a);
        this.f12020c = (GlyphView) a(2131567940);
    }

    protected void onFinishInflate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1006847537);
        super.onFinishInflate();
        m12047a();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -118264146, a);
    }

    public void setLabelText(CharSequence charSequence) {
        this.f12019b.setText(charSequence);
    }

    public void setIcon(int i) {
        this.f12020c.setImageResource(i);
    }
}
