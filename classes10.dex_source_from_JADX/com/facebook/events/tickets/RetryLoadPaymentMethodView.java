package com.facebook.events.tickets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import com.facebook.inject.FbInjector;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomLinearLayout;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: args_thread_key */
public class RetryLoadPaymentMethodView extends CustomLinearLayout {
    @Inject
    public AllCapsTransformationMethod f19203a;
    private FbTextView f19204b;

    private static <T extends View> void m19384a(Class<T> cls, T t) {
        m19385a((Object) t, t.getContext());
    }

    private static void m19385a(Object obj, Context context) {
        ((RetryLoadPaymentMethodView) obj).f19203a = AllCapsTransformationMethod.b(FbInjector.get(context));
    }

    public RetryLoadPaymentMethodView(Context context) {
        super(context);
        m19382a();
    }

    public RetryLoadPaymentMethodView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m19382a();
    }

    public RetryLoadPaymentMethodView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m19382a();
    }

    private void m19382a() {
        m19384a(RetryLoadPaymentMethodView.class, (View) this);
        setContentView(2130904006);
        this.f19204b = (FbTextView) a(2131561221);
        this.f19204b.setTransformationMethod(this.f19203a);
        setBackgroundResource(2131361920);
    }

    public void setActionClickListener(OnClickListener onClickListener) {
        this.f19204b.setOnClickListener(onClickListener);
    }

    private void m19383a(AllCapsTransformationMethod allCapsTransformationMethod) {
        this.f19203a = allCapsTransformationMethod;
    }
}
