package com.facebook.view.inflation.inflaters;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView.ScaleType;
import com.facebook.view.inflation.utils.ParseUtils;
import com.facebook.view.inflation.utils.ViewIdentifier;
import com.facebook.widget.images.UrlImage;

/* compiled from: location_opt_in_location_history_failed */
class UrlImageInflater extends ViewInflater {

    /* compiled from: location_opt_in_location_history_failed */
    enum Attribute {
        SCALE_TYPE("scaleType"),
        URL("url"),
        PLACEHOLDER_SRC("placeholderSrc");
        
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
            throw new IllegalArgumentException("unknown url image attribute = " + str);
        }
    }

    public UrlImageInflater(ParseUtils parseUtils, ViewIdentifier viewIdentifier) {
        super(parseUtils, viewIdentifier);
    }

    protected final View mo623a(Context context) {
        UrlImage urlImage = new UrlImage(context);
        urlImage.setPlaceHolderResourceId(2130837805);
        urlImage.setPlaceHolderScaleType(ScaleType.FIT_XY);
        return urlImage;
    }

    protected final void mo624a(View view, String str, String str2, Context context) {
        UrlImage urlImage = (UrlImage) view;
        switch (Attribute.from(str)) {
            case SCALE_TYPE:
                urlImage.setScaleType(this.f9790a.m11544l(str2));
                return;
            case URL:
                urlImage.setImageParams(Uri.parse(str2));
                return;
            case PLACEHOLDER_SRC:
                urlImage.setPlaceHolderResourceId(context.getResources().getIdentifier(ParseUtils.m11534f(str2), "drawable", context.getPackageName()));
                return;
            default:
                throw new IllegalStateException("unhandled url image attribute = " + str);
        }
    }
}
