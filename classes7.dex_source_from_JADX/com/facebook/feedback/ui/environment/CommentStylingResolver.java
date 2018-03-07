package com.facebook.feedback.ui.environment;

import android.content.Context;
import android.util.TypedValue;
import com.facebook.feedback.ui.rows.views.CommentRowPadding;

/* compiled from: ridge_tooltip_nux_impression */
public class CommentStylingResolver {
    public int f4820a;
    public int f4821b;
    public int f4822c;
    public int f4823d;
    public int f4824e;
    public int f4825f;
    public int f4826g;

    public CommentStylingResolver(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(2130773271, typedValue, true);
        this.f4820a = context.getResources().getDimensionPixelSize(typedValue.resourceId);
        context.getTheme().resolveAttribute(2130773272, typedValue, true);
        this.f4821b = context.getResources().getDimensionPixelSize(typedValue.resourceId);
        context.getTheme().resolveAttribute(2130773273, typedValue, true);
        this.f4822c = context.getResources().getDimensionPixelSize(typedValue.resourceId);
        context.getTheme().resolveAttribute(2130773274, typedValue, true);
        this.f4823d = context.getResources().getDimensionPixelSize(typedValue.resourceId);
        context.getTheme().resolveAttribute(2130773284, typedValue, true);
        this.f4824e = context.getResources().getDimensionPixelSize(typedValue.resourceId);
        this.f4825f = context.getResources().getDimensionPixelSize(2131428740);
        this.f4826g = context.getResources().getDimensionPixelSize(2131428721);
    }

    public final int m5365a(CommentRowPadding commentRowPadding) {
        switch (commentRowPadding) {
            case NO_OFFSET:
                return this.f4822c;
            case PROFILE_PICTURE_OFFSET:
                return (this.f4822c + this.f4824e) + this.f4826g;
            case THREADED_PROFILE_PICTURE_OFFSET:
                return (((this.f4822c + this.f4824e) + this.f4826g) + this.f4825f) + this.f4826g;
            default:
                return 0;
        }
    }
}
