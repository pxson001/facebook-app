package com.facebook.commerce.productdetails.ui.productandpurchasedetails;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.commerce.core.animations.SlideDownAnimation;
import com.facebook.commerce.core.animations.SlideUpAnimation;
import com.facebook.commerce.productdetails.graphql.FetchProductGroupQueryModels.FetchProductGroupQueryModel;
import com.facebook.common.util.StringUtil;
import com.facebook.groups.staticadapter.StaticAdapter.Bindable;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.CustomFrameLayout;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: debug_messenger_notificaiton_service_last_intent_timestamp */
public class ProductGroupProductAndPurchaseDetailsView extends CustomFrameLayout implements Bindable<FetchProductGroupQueryModel> {
    @Inject
    public ProductGroupProductAndPurchaseDetailsViewControllerImpl f15294a;
    public TextView f15295b = ((TextView) c(2131566292));
    public TextView f15296c = ((TextView) c(2131566293));
    public TextView f15297d = ((TextView) c(2131566294));
    public TextView f15298e = ((TextView) c(2131566295));
    public ToggleInfoListener f15299f;
    public ToggleInfoListener f15300g;

    /* compiled from: debug_messenger_notificaiton_service_last_intent_timestamp */
    public class ToggleInfoListener implements OnClickListener {
        final /* synthetic */ ProductGroupProductAndPurchaseDetailsView f15285a;
        private TextView f15286b;
        private View f15287c;
        private Drawable f15288d;
        private Drawable f15289e;
        private Drawable f15290f;
        private float f15291g;
        private SlideUpAnimation f15292h = new SlideUpAnimation(200, this.f15287c);
        private SlideDownAnimation f15293i = new SlideDownAnimation(200, this.f15287c);

        public ToggleInfoListener(ProductGroupProductAndPurchaseDetailsView productGroupProductAndPurchaseDetailsView, TextView textView, View view, int i, Context context) {
            this.f15285a = productGroupProductAndPurchaseDetailsView;
            this.f15286b = textView;
            this.f15287c = view;
            this.f15288d = context.getResources().getDrawable(i);
            this.f15291g = textView.getTextSize();
            this.f15288d.setBounds(0, 0, (int) this.f15291g, (int) this.f15291g);
            this.f15289e = context.getResources().getDrawable(2130838068);
            this.f15290f = context.getResources().getDrawable(2130838060);
            this.f15289e.setBounds(0, 0, (int) this.f15291g, (int) this.f15291g);
            this.f15290f.setBounds(0, 0, (int) this.f15291g, (int) this.f15291g);
        }

        private void m15920b() {
            SlideUpAnimation slideUpAnimation = this.f15292h;
            View view = this.f15287c;
            slideUpAnimation.a = (float) view.getMeasuredHeight();
            view.startAnimation(slideUpAnimation);
            m15919a(false);
        }

        private void m15921c() {
            SlideDownAnimation slideDownAnimation = this.f15293i;
            View view = this.f15287c;
            view.measure(-1, -2);
            slideDownAnimation.a = (float) view.getMeasuredHeight();
            view.getLayoutParams().height = 0;
            view.setVisibility(0);
            view.startAnimation(slideDownAnimation);
            m15919a(true);
        }

        private void m15919a(boolean z) {
            if (z) {
                this.f15286b.setCompoundDrawables(this.f15288d, null, this.f15290f, null);
            } else {
                this.f15286b.setCompoundDrawables(this.f15288d, null, this.f15289e, null);
            }
        }

        public final void m15922a() {
            if (this.f15287c.getVisibility() == 8) {
                m15919a(false);
            } else {
                m15919a(true);
            }
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1864006934);
            if ((!this.f15292h.hasStarted() || this.f15292h.hasEnded()) && (!this.f15293i.hasStarted() || this.f15293i.hasEnded())) {
                if (this.f15287c.getVisibility() == 0) {
                    m15920b();
                } else {
                    m15921c();
                }
                LogUtils.a(416641114, a);
                return;
            }
            Logger.a(2, EntryType.UI_INPUT_END, 1370106835, a);
        }
    }

    public static void m15923a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((ProductGroupProductAndPurchaseDetailsView) obj).f15294a = new ProductGroupProductAndPurchaseDetailsViewControllerImpl();
    }

    public ProductGroupProductAndPurchaseDetailsView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = ProductGroupProductAndPurchaseDetailsView.class;
        m15923a(this, getContext());
        setContentView(2130906412);
        this.f15299f = new ToggleInfoListener(this, this.f15295b, this.f15296c, 2130843546, context);
        this.f15300g = new ToggleInfoListener(this, this.f15297d, this.f15298e, 2130843365, context);
    }

    public final void m15924a(FetchProductGroupQueryModel fetchProductGroupQueryModel) {
        Optional optional;
        Optional optional2;
        ProductGroupProductAndPurchaseDetailsViewControllerImpl productGroupProductAndPurchaseDetailsViewControllerImpl = this.f15294a;
        if (StringUtil.a(fetchProductGroupQueryModel.m15817o())) {
            optional = Absent.INSTANCE;
        } else {
            optional = Optional.of(fetchProductGroupQueryModel.m15817o());
        }
        if (fetchProductGroupQueryModel.m15814l() == null || fetchProductGroupQueryModel.m15814l().m15701j() == null || fetchProductGroupQueryModel.m15814l().m15701j().isEmpty()) {
            optional2 = Absent.INSTANCE;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            ImmutableList j = fetchProductGroupQueryModel.m15814l().m15701j();
            int size = j.size();
            for (int i = 0; i < size; i++) {
                String str = (String) j.get(i);
                if (stringBuilder.length() != 0) {
                    stringBuilder.append(ProductGroupProductAndPurchaseDetailsViewControllerImpl.f15301a);
                }
                stringBuilder.append("•  ").append(str);
            }
            optional2 = Optional.of(stringBuilder.toString());
        }
        ProductGroupProductAndPurchaseDetailsViewModel productGroupProductAndPurchaseDetailsViewModel = new ProductGroupProductAndPurchaseDetailsViewModel(optional, optional2);
        if (productGroupProductAndPurchaseDetailsViewModel.m15926a().isPresent()) {
            this.f15295b.setVisibility(0);
            this.f15295b.setOnClickListener(this.f15299f);
            this.f15296c.setVisibility(0);
            this.f15296c.setText((CharSequence) productGroupProductAndPurchaseDetailsViewModel.m15926a().get());
        } else {
            this.f15295b.setVisibility(8);
            this.f15295b.setOnClickListener(null);
            this.f15296c.setVisibility(8);
        }
        if (productGroupProductAndPurchaseDetailsViewModel.m15927b().isPresent()) {
            this.f15297d.setVisibility(0);
            this.f15297d.setOnClickListener(this.f15300g);
            this.f15298e.setText((CharSequence) productGroupProductAndPurchaseDetailsViewModel.m15927b().get());
        } else {
            this.f15297d.setVisibility(8);
            this.f15297d.setOnClickListener(null);
            this.f15298e.setText("");
        }
        this.f15298e.setVisibility(8);
        this.f15300g.m15922a();
        this.f15299f.m15922a();
    }
}
