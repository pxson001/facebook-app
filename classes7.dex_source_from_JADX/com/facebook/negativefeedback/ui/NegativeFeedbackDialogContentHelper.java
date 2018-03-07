package com.facebook.negativefeedback.ui;

import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ListView;
import com.facebook.widget.CustomLinearLayout;

/* compiled from: notification id */
public class NegativeFeedbackDialogContentHelper {

    /* compiled from: notification id */
    final class C06351 implements OnGlobalLayoutListener {
        final /* synthetic */ ListView f8013a;
        final /* synthetic */ CustomLinearLayout f8014b;

        C06351(ListView listView, CustomLinearLayout customLinearLayout) {
            this.f8013a = listView;
            this.f8014b = customLinearLayout;
        }

        public final void onGlobalLayout() {
            ListView listView = this.f8013a;
            if (VERSION.SDK_INT >= 16) {
                listView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            } else {
                listView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
            Resources resources = this.f8014b.getContext().getResources();
            int lastVisiblePosition = this.f8013a.getLastVisiblePosition();
            if (this.f8013a.getChildAt(lastVisiblePosition) != null) {
                if (this.f8013a.getChildAt(lastVisiblePosition).getBottom() > this.f8013a.getHeight()) {
                    this.f8014b.setBackgroundDrawable(resources.getDrawable(2130843265));
                } else {
                    this.f8014b.setBackgroundDrawable(new ColorDrawable(resources.getColor(17170445)));
                }
                NegativeFeedbackDialogContentHelper.m9722a(this.f8014b);
            }
        }
    }

    public static OnGlobalLayoutListener m9721a(ListView listView, CustomLinearLayout customLinearLayout) {
        return new C06351(listView, customLinearLayout);
    }

    public static void m9722a(CustomLinearLayout customLinearLayout) {
        int dimension = (int) customLinearLayout.getContext().getResources().getDimension(2131431891);
        customLinearLayout.setPadding(dimension, dimension, dimension, 0);
    }
}
