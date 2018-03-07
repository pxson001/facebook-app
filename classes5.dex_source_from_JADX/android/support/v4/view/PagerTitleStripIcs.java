package android.support.v4.view;

import android.content.Context;
import android.text.method.SingleLineTransformationMethod;
import android.view.View;
import java.util.Locale;

/* compiled from: video_autoplay_style */
class PagerTitleStripIcs {

    /* compiled from: video_autoplay_style */
    public class SingleLineAllCapsTransform extends SingleLineTransformationMethod {
        private Locale f349a;

        public SingleLineAllCapsTransform(Context context) {
            this.f349a = context.getResources().getConfiguration().locale;
        }

        public CharSequence getTransformation(CharSequence charSequence, View view) {
            CharSequence transformation = super.getTransformation(charSequence, view);
            return transformation != null ? transformation.toString().toUpperCase(this.f349a) : null;
        }
    }

    PagerTitleStripIcs() {
    }
}
