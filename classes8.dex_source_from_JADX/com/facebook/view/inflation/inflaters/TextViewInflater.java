package com.facebook.view.inflation.inflaters;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;
import com.facebook.view.inflation.utils.ParseUtils;
import com.facebook.view.inflation.utils.ViewIdentifier;

/* compiled from: location_opt_in_place_save_intro_learn_more_tapped */
class TextViewInflater extends ViewInflater {

    /* compiled from: location_opt_in_place_save_intro_learn_more_tapped */
    enum Attribute {
        TEXT("text"),
        GRAVITY("gravity"),
        SINGLE_LINE("singleLine"),
        MAX_LINES("maxLines"),
        SCROLL_HORIZONTALLY("scrollHorizontally"),
        ELLIPSIZE("ellipsize"),
        TEXT_COLOR("textColor"),
        TEXT_SIZE("textSize"),
        INCLUDE_FONT_PADDING("includeFontPadding"),
        TYPEFACE("typeface"),
        TEXT_STYLE("textStyle");
        
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
            throw new IllegalArgumentException("unknown text view attribute = " + str);
        }
    }

    public TextViewInflater(ParseUtils parseUtils, ViewIdentifier viewIdentifier) {
        super(parseUtils, viewIdentifier);
    }

    protected View mo623a(Context context) {
        return new TextView(context);
    }

    protected final void mo624a(View view, String str, String str2, Context context) {
        TextView textView = (TextView) view;
        switch (Attribute.from(str)) {
            case TEXT:
                textView.setText(str2);
                return;
            case GRAVITY:
                textView.setGravity(this.f9790a.m11548p(str2));
                return;
            case SINGLE_LINE:
                textView.setSingleLine(Boolean.valueOf(str2).booleanValue());
                return;
            case ELLIPSIZE:
                textView.setEllipsize(this.f9790a.m11543k(str2));
                return;
            case TEXT_COLOR:
                if (ParseUtils.m11537r(str2)) {
                    textView.setTextColor(Color.parseColor(str2));
                    return;
                } else if (ParseUtils.m11539t(str2)) {
                    textView.setTextColor(context.getResources().getIdentifier(this.f9790a.m11541g(str2), "color", context.getPackageName()));
                    return;
                } else if (ParseUtils.m11538s(str2)) {
                    textView.setTextColor(context.getResources().getIdentifier(ParseUtils.m11536i(str2), null, null));
                    return;
                } else {
                    throw new IllegalArgumentException("unknown color for text view " + str2);
                }
            case TEXT_SIZE:
                textView.setTextSize(2, ParseUtils.m11531c(str2));
                return;
            case INCLUDE_FONT_PADDING:
                textView.setIncludeFontPadding(Boolean.valueOf(str2).booleanValue());
                return;
            case TYPEFACE:
                Typeface m = this.f9790a.m11545m(str2);
                if (textView.getTypeface() == null) {
                    textView.setTypeface(m);
                    return;
                } else {
                    textView.setTypeface(m, textView.getTypeface().getStyle());
                    return;
                }
            case TEXT_STYLE:
                textView.setTypeface(textView.getTypeface(), this.f9790a.m11546n(str2));
                return;
            case MAX_LINES:
                textView.setMaxLines(Integer.parseInt(str2));
                return;
            case SCROLL_HORIZONTALLY:
                textView.setHorizontallyScrolling(Boolean.valueOf(str2).booleanValue());
                return;
            default:
                throw new IllegalStateException("unhandled text view attribute = " + str);
        }
    }
}
