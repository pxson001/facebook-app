package com.facebook.search.widget.endofresultsmarker;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.text.BetterTextView;
import javax.annotation.Nullable;

/* compiled from: user_id =  */
public class EndOfResultsMarkerView extends CustomFrameLayout {
    public final BetterTextView f715a;

    public EndOfResultsMarkerView(Context context) {
        this(context, null);
    }

    private EndOfResultsMarkerView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private EndOfResultsMarkerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130903973);
        this.f715a = (BetterTextView) c(2131561175);
    }

    public final void m797b() {
        this.f715a.setVisibility(8);
    }
}
