package com.facebook.messaging.business.commerceui.views.retail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.business.commerce.model.retail.CommerceBubbleModel;
import com.facebook.messaging.business.commerce.model.retail.Subscription;
import com.facebook.messaging.business.commerceui.analytics.MessengerCommerceAnalyticsLogger;
import com.facebook.messaging.business.commerceui.views.CommerceView;
import com.facebook.messaging.linkhandling.LinkHandlingHelper;
import com.facebook.resources.ui.FbButton;
import com.facebook.widget.CustomRelativeLayout;
import com.facebook.widget.text.BetterTextView;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import javax.inject.Inject;

/* compiled from: null ViewerContextUser found when creating params for payment request */
public class ProductSubscriptionView extends CustomRelativeLayout implements CommerceView {
    private static final CallerContext f8542d = CallerContext.a(ProductSubscriptionView.class);
    @Inject
    CommerceViewHelpers f8543a;
    @Inject
    MessengerCommerceAnalyticsLogger f8544b;
    @Inject
    Lazy<LinkHandlingHelper> f8545c;
    private final FbDraweeView f8546e;
    private final FbDraweeView f8547f;
    private final BetterTextView f8548g;
    private final BetterTextView f8549h;
    private final BetterTextView f8550i;
    private final BetterTextView f8551j;
    private final FbButton f8552k;
    public Subscription f8553l;

    /* compiled from: null ViewerContextUser found when creating params for payment request */
    class C09721 implements OnClickListener {
        final /* synthetic */ ProductSubscriptionView f8540a;

        C09721(ProductSubscriptionView productSubscriptionView) {
            this.f8540a = productSubscriptionView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -2105279556);
            this.f8540a.f8544b.m8654a(this.f8540a.f8553l.b(), this.f8540a.f8553l.a());
            ((LinkHandlingHelper) this.f8540a.f8545c.get()).a(this.f8540a.getContext(), this.f8540a.f8553l.c);
            Logger.a(2, EntryType.UI_INPUT_END, 1143026501, a);
        }
    }

    /* compiled from: null ViewerContextUser found when creating params for payment request */
    class C09732 implements OnClickListener {
        final /* synthetic */ ProductSubscriptionView f8541a;

        C09732(ProductSubscriptionView productSubscriptionView) {
            this.f8541a = productSubscriptionView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1534105470);
            ((LinkHandlingHelper) this.f8541a.f8545c.get()).a(this.f8541a.getContext(), this.f8541a.f8553l.c);
            Logger.a(2, EntryType.UI_INPUT_END, -1587077233, a);
        }
    }

    private static <T extends View> void m8775a(Class<T> cls, T t) {
        m8776a((Object) t, t.getContext());
    }

    private static void m8776a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((ProductSubscriptionView) obj).m8774a(CommerceViewHelpers.m8755b(fbInjector), MessengerCommerceAnalyticsLogger.m8651b(fbInjector), IdBasedSingletonScopeProvider.b(fbInjector, 7898));
    }

    private void m8774a(CommerceViewHelpers commerceViewHelpers, MessengerCommerceAnalyticsLogger messengerCommerceAnalyticsLogger, Lazy<LinkHandlingHelper> lazy) {
        this.f8543a = commerceViewHelpers;
        this.f8544b = messengerCommerceAnalyticsLogger;
        this.f8545c = lazy;
    }

    public ProductSubscriptionView(Context context) {
        this(context, null);
    }

    public ProductSubscriptionView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ProductSubscriptionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m8775a(ProductSubscriptionView.class, (View) this);
        setContentView(2130905616);
        this.f8546e = (FbDraweeView) a(2131564642);
        this.f8547f = (FbDraweeView) a(2131564643);
        this.f8548g = (BetterTextView) a(2131564570);
        this.f8549h = (BetterTextView) a(2131564571);
        this.f8550i = (BetterTextView) a(2131564572);
        this.f8551j = (BetterTextView) a(2131564573);
        this.f8552k = (FbButton) a(2131564645);
        setOnClickListener(new C09721(this));
    }

    public void setModel(CommerceBubbleModel commerceBubbleModel) {
        Preconditions.checkArgument(commerceBubbleModel instanceof Subscription);
        this.f8553l = (Subscription) commerceBubbleModel;
        m8777b();
    }

    public final boolean mo231a() {
        return true;
    }

    private void m8777b() {
        Preconditions.checkNotNull(this.f8553l.d);
        if (this.f8553l.d.d != null) {
            this.f8546e.setVisibility(0);
            this.f8546e.setBackgroundResource(2131363762);
            this.f8546e.a(this.f8553l.d.d, f8542d);
        } else {
            this.f8546e.setVisibility(8);
        }
        if (this.f8553l.b == null || this.f8553l.b.a == null) {
            this.f8547f.setVisibility(8);
        } else {
            this.f8543a.m8756a(this.f8547f, this.f8553l.b, f8542d);
        }
        if (this.f8553l.c != null) {
            this.f8552k.setOnClickListener(new C09732(this));
            this.f8552k.setVisibility(0);
        } else {
            this.f8552k.setVisibility(8);
        }
        m8778c();
    }

    private void m8778c() {
        int i;
        int i2 = 0;
        this.f8548g.setText(this.f8553l.d.b);
        this.f8549h.setVisibility(!Strings.isNullOrEmpty(this.f8553l.d.g) ? 0 : 8);
        this.f8549h.setText(!Strings.isNullOrEmpty(this.f8553l.d.g) ? this.f8553l.d.g : "");
        BetterTextView betterTextView = this.f8550i;
        if (Strings.isNullOrEmpty(this.f8553l.d.h)) {
            i = 8;
        } else {
            i = 0;
        }
        betterTextView.setVisibility(i);
        this.f8550i.setText(!Strings.isNullOrEmpty(this.f8553l.d.h) ? this.f8553l.d.h : "");
        BetterTextView betterTextView2 = this.f8551j;
        if (Strings.isNullOrEmpty(this.f8553l.d.i)) {
            i2 = 8;
        }
        betterTextView2.setVisibility(i2);
        this.f8551j.setText(!Strings.isNullOrEmpty(this.f8553l.d.i) ? this.f8553l.d.i : "");
    }
}
