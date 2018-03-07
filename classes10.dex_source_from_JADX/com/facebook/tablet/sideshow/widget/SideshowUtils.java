package com.facebook.tablet.sideshow.widget;

import android.widget.TextView;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: gv */
public class SideshowUtils {
    private AllCapsTransformationMethod f10150a;

    public static SideshowUtils m10211b(InjectorLike injectorLike) {
        return new SideshowUtils(AllCapsTransformationMethod.b(injectorLike));
    }

    @Inject
    public SideshowUtils(AllCapsTransformationMethod allCapsTransformationMethod) {
        this.f10150a = allCapsTransformationMethod;
    }

    public final void m10212a(CharSequence charSequence, TextView textView) {
        if (textView != null && this.f10150a != null) {
            textView.setText(this.f10150a.getTransformation(charSequence, textView));
        }
    }
}
