package com.facebook.view.inflation.inflaters;

import android.content.Context;
import android.view.View;
import com.facebook.view.inflation.utils.ParseUtils;
import com.facebook.view.inflation.utils.ViewIdentifier;
import com.facebook.widget.ratingbar.FractionalRatingBar;

/* compiled from: location_opt_in_place_save_intro */
public class FractionalRatingBarInflater extends ViewInflater {

    /* compiled from: location_opt_in_place_save_intro */
    enum Attribute {
        RATING("rating");
        
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
            throw new IllegalArgumentException("unknown rating bar attribute = " + str);
        }
    }

    public FractionalRatingBarInflater(ParseUtils parseUtils, ViewIdentifier viewIdentifier) {
        super(parseUtils, viewIdentifier);
    }

    protected final View mo623a(Context context) {
        return new FractionalRatingBar(context);
    }

    protected final void mo624a(View view, String str, String str2, Context context) {
        FractionalRatingBar fractionalRatingBar = (FractionalRatingBar) view;
        switch (Attribute.from(str)) {
            case RATING:
                fractionalRatingBar.setRating(Float.parseFloat(str2));
                return;
            default:
                throw new IllegalStateException("unhandled rating bar attribute = " + str);
        }
    }
}
