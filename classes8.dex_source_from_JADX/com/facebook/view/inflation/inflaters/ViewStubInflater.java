package com.facebook.view.inflation.inflaters;

import android.content.Context;
import android.view.View;
import android.view.ViewStub;
import com.facebook.view.inflation.utils.ParseUtils;
import com.facebook.view.inflation.utils.ViewIdentifier;

/* compiled from: location_opt_in_lh_notification_page_impression */
public class ViewStubInflater extends ViewInflater {

    /* compiled from: location_opt_in_lh_notification_page_impression */
    enum Attribute {
        INFLATED_ID("inflatedId"),
        LAYOUT("layout");
        
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
            throw new IllegalArgumentException("unknown view stub attribute = " + str);
        }
    }

    public ViewStubInflater(ParseUtils parseUtils, ViewIdentifier viewIdentifier) {
        super(parseUtils, viewIdentifier);
    }

    protected final View mo623a(Context context) {
        return new ViewStub(context);
    }

    protected final void mo624a(View view, String str, String str2, Context context) {
        ViewStub viewStub = (ViewStub) view;
        switch (Attribute.from(str)) {
            case INFLATED_ID:
                viewStub.setInflatedId(context.getResources().getIdentifier(ParseUtils.m11532d(str2), "layout", context.getPackageName()));
                return;
            case LAYOUT:
                viewStub.setLayoutResource(context.getResources().getIdentifier(ParseUtils.m11535h(str2), "layout", context.getPackageName()));
                return;
            default:
                throw new IllegalStateException("unhandled view stub attribute = " + str);
        }
    }
}
