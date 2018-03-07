package com.facebook.view.inflation.inflaters;

import android.content.Context;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.facebook.view.inflation.utils.ParseUtils;
import com.facebook.view.inflation.utils.ViewIdentifier;

/* compiled from: location_opt_in_on_login_gms_ls_dialog_start */
public class ImageViewInflater extends ViewInflater {

    /* compiled from: location_opt_in_on_login_gms_ls_dialog_start */
    enum Attribute {
        ADJUST_VIEW_BOUNDS("adjustViewBounds"),
        BASELINE("baseline"),
        BASELINE_ALIGN_BOTTOM("baselineAlignBottom"),
        CROP_TO_PADDING("cropToPadding"),
        MAX_HEIGHT("maxHeight"),
        MAX_WIDTH("maxWidth"),
        SCALE_TYPE("scaleType"),
        SRC("src"),
        TINT("tint");
        
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
            throw new IllegalArgumentException("unknown image view attribute = " + str);
        }
    }

    public ImageViewInflater(ParseUtils parseUtils, ViewIdentifier viewIdentifier) {
        super(parseUtils, viewIdentifier);
    }

    protected View mo623a(Context context) {
        return new ImageView(context);
    }

    protected final void mo624a(View view, String str, String str2, Context context) {
        ImageView imageView = (ImageView) view;
        switch (Attribute.from(str)) {
            case ADJUST_VIEW_BOUNDS:
                imageView.setAdjustViewBounds(Boolean.valueOf(str2).booleanValue());
                return;
            case BASELINE:
                if (VERSION.SDK_INT >= 11) {
                    imageView.setBaseline(Integer.parseInt(str2));
                    return;
                }
                throw new IllegalArgumentException("baseline image view attribute requires honeycomb or later");
            case BASELINE_ALIGN_BOTTOM:
                if (VERSION.SDK_INT >= 11) {
                    imageView.setBaselineAlignBottom(Boolean.valueOf(str2).booleanValue());
                    return;
                }
                throw new IllegalArgumentException("baselineAlignBottom image view attribute requires honeycomb or later");
            case CROP_TO_PADDING:
                if (VERSION.SDK_INT >= 16) {
                    imageView.setCropToPadding(Boolean.valueOf(str2).booleanValue());
                    return;
                }
                throw new IllegalArgumentException("cropToPadding image view attribute requires jelly bean or later");
            case MAX_HEIGHT:
                imageView.setMaxHeight(Integer.parseInt(str2));
                return;
            case MAX_WIDTH:
                imageView.setMaxWidth(Integer.parseInt(str2));
                return;
            case SCALE_TYPE:
                imageView.setScaleType(ScaleType.valueOf(str2));
                return;
            case SRC:
                imageView.setImageResource(context.getResources().getIdentifier(ParseUtils.m11534f(str2), "drawable", context.getPackageName()));
                return;
            case TINT:
                imageView.setColorFilter(Color.parseColor(str2));
                return;
            default:
                throw new IllegalStateException("unhandled image view attribute = " + str);
        }
    }
}
