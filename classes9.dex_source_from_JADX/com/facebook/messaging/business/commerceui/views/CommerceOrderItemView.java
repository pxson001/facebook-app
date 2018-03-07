package com.facebook.messaging.business.commerceui.views;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.inject.FbInjector;
import com.facebook.messaging.business.commerce.model.retail.Receipt;
import com.facebook.messaging.business.commerceui.utils.ModelUtils;
import com.facebook.widget.CustomViewGroup;
import com.facebook.widget.text.BetterTextView;
import javax.inject.Inject;

/* compiled from: numAttachments */
public class CommerceOrderItemView extends CustomViewGroup {
    @Inject
    public ModelUtils f8439a;
    public FbDraweeView f8440b;
    public BetterTextView f8441c;
    public BetterTextView f8442d;
    public Receipt f8443e;

    public static void m8706a(Object obj, Context context) {
        ((CommerceOrderItemView) obj).f8439a = new ModelUtils((Context) FbInjector.get(context).getInstance(Context.class));
    }

    public CommerceOrderItemView(Context context) {
        this(context, null, 0);
    }

    private CommerceOrderItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = CommerceOrderItemView.class;
        m8706a(this, getContext());
        setContentView(2130905631);
        this.f8440b = (FbDraweeView) getView(2131564670);
        this.f8441c = (BetterTextView) getView(2131564671);
        this.f8442d = (BetterTextView) getView(2131564672);
    }
}
