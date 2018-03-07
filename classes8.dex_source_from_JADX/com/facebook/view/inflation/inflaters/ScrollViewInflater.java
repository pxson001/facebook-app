package com.facebook.view.inflation.inflaters;

import android.content.Context;
import android.view.View;
import android.widget.ScrollView;
import com.facebook.view.inflation.utils.ParseUtils;
import com.facebook.view.inflation.utils.ViewIdentifier;

/* compiled from: location_opt_in_location_history_turned_on */
public class ScrollViewInflater extends FrameLayoutInflater {

    /* compiled from: location_opt_in_location_history_turned_on */
    enum Attribute {
        FILL_VIEWPORT("fillViewport");
        
        private final String mValue;

        private Attribute(String str) {
            this.mValue = str;
        }

        public static Attribute from(String str) {
            Attribute[] values = values();
            for (Attribute attribute : values) {
                if (attribute.mValue.equals(str)) {
                    return attribute;
                }
            }
            return null;
        }
    }

    public ScrollViewInflater(ParseUtils parseUtils, ViewIdentifier viewIdentifier) {
        super(parseUtils, viewIdentifier);
    }

    protected final View mo623a(Context context) {
        return new ScrollView(context);
    }

    public final void mo624a(View view, String str, String str2, Context context) {
        ScrollView scrollView = (ScrollView) view;
        switch (Attribute.from(str)) {
            case FILL_VIEWPORT:
                scrollView.setFillViewport(Boolean.valueOf(str2).booleanValue());
                return;
            default:
                super.mo624a(view, str, str2, context);
                return;
        }
    }
}
