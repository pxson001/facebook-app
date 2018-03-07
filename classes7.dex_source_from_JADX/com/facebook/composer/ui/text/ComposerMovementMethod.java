package com.facebook.composer.ui.text;

import android.text.Layout;
import android.text.Spannable;
import android.text.method.ArrowKeyMovementMethod;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.widget.TextView;

/* compiled from: composerConfiguration */
public class ComposerMovementMethod extends ArrowKeyMovementMethod {
    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            int x = (((int) motionEvent.getX()) - textView.getTotalPaddingLeft()) + textView.getScrollX();
            int y = (((int) motionEvent.getY()) - textView.getTotalPaddingTop()) + textView.getScrollY();
            Layout layout = textView.getLayout();
            x = layout.getOffsetForHorizontal(layout.getLineForVertical(y), (float) x);
            ClickableSpan[] clickableSpanArr = (ClickableSpan[]) spannable.getSpans(x, x, ClickableSpan.class);
            if (clickableSpanArr.length != 0) {
                clickableSpanArr[0].onClick(textView);
                return true;
            }
        }
        return super.onTouchEvent(textView, spannable, motionEvent);
    }
}
