package com.facebook.widget.text;

import android.view.ViewTreeObserver.OnPreDrawListener;

/* compiled from: d6fdfb377f736f73aeb2a608ca2501c7 */
class VariableTextLayoutView$1 implements OnPreDrawListener {
    final /* synthetic */ VariableTextLayoutView f16172a;

    VariableTextLayoutView$1(VariableTextLayoutView variableTextLayoutView) {
        this.f16172a = variableTextLayoutView;
    }

    public boolean onPreDraw() {
        return VariableTextLayoutView.f(this.f16172a);
    }
}
