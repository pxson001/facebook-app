package com.facebook.events.ui.privacy;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.events.model.PrivacyType;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.OnDrawListenerSet;
import com.facebook.widget.OnDrawListenerSet.OnDrawListener;
import com.facebook.widget.text.BetterTextView;
import javax.annotation.Nullable;

/* compiled from: append */
public class EventCreationPrivacyEducationWidgetRedesign extends CustomLinearLayout {
    private BetterTextView f19485a;
    private GlyphView f19486b;
    private final OnDrawListenerSet f19487c = new OnDrawListenerSet();

    /* compiled from: append */
    class C27731 implements OnClickListener {
        final /* synthetic */ EventCreationPrivacyEducationWidgetRedesign f19484a;

        C27731(EventCreationPrivacyEducationWidgetRedesign eventCreationPrivacyEducationWidgetRedesign) {
            this.f19484a = eventCreationPrivacyEducationWidgetRedesign;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 855702296);
            this.f19484a.setVisibility(8);
            Logger.a(2, EntryType.UI_INPUT_END, -1428897348, a);
        }
    }

    public EventCreationPrivacyEducationWidgetRedesign(Context context) {
        super(context);
        m19669a();
    }

    public EventCreationPrivacyEducationWidgetRedesign(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m19669a();
    }

    public EventCreationPrivacyEducationWidgetRedesign(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m19669a();
    }

    private void m19669a() {
        setContentView(2130904026);
        setOrientation(0);
        this.f19485a = (BetterTextView) findViewById(2131561274);
        this.f19486b = (GlyphView) findViewById(2131561275);
        this.f19486b.setOnClickListener(new C27731(this));
    }

    public final CharSequence m19670a(PrivacyType privacyType) {
        if (privacyType == null) {
            return null;
        }
        return (privacyType == PrivacyType.USER_PUBLIC || privacyType == PrivacyType.PAGE) ? getResources().getString(2131241663) : getResources().getString(2131241664);
    }

    public final void m19671a(CharSequence charSequence) {
        this.f19485a.setText(charSequence);
        setVisibility(charSequence == null ? 8 : 0);
    }

    public void setOnDrawListenerTo(OnDrawListener onDrawListener) {
        this.f19487c.b(onDrawListener);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f19487c.a();
    }
}
