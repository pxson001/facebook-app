package android.support.v7.internal.text;

import android.content.Context;
import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;
import java.util.Locale;

/* compiled from: upsell_buy_failure_impression */
public class AllCapsTransformationMethod implements TransformationMethod {
    private Locale f706a;

    public AllCapsTransformationMethod(Context context) {
        this.f706a = context.getResources().getConfiguration().locale;
    }

    public CharSequence getTransformation(CharSequence charSequence, View view) {
        return charSequence != null ? charSequence.toString().toUpperCase(this.f706a) : null;
    }

    public void onFocusChanged(View view, CharSequence charSequence, boolean z, int i, Rect rect) {
    }
}
