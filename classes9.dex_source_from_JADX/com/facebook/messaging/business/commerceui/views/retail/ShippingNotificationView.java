package com.facebook.messaging.business.commerceui.views.retail;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.LinearLayout;
import com.facebook.android.maps.StaticMapView.StaticMapOptions;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.FindViewUtil;
import com.facebook.common.util.StringLocaleUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.maps.FbMapViewDelegate;
import com.facebook.maps.FbStaticMapView;
import com.facebook.maps.delegate.MapDelegate;
import com.facebook.maps.delegate.MapDelegate.OnMapClickListener;
import com.facebook.maps.delegate.MapDelegate.OnMarkerClickListener;
import com.facebook.maps.delegate.MarkerDelegate;
import com.facebook.maps.delegate.OnMapReadyDelegateCallback;
import com.facebook.messaging.business.attachments.model.PlatformGenericAttachmentItem;
import com.facebook.messaging.business.commerce.model.retail.CommerceBubbleModel;
import com.facebook.messaging.business.commerce.model.retail.CommerceBubbleModelType;
import com.facebook.messaging.business.commerce.model.retail.CommerceData;
import com.facebook.messaging.business.commerce.model.retail.RetailAddress;
import com.facebook.messaging.business.commerce.model.retail.Shipment;
import com.facebook.messaging.business.commerceui.gating.AreDynamicMapsEnabledForCommerce;
import com.facebook.messaging.business.commerceui.views.CommerceView;
import com.facebook.widget.CustomRelativeLayout;
import com.facebook.widget.text.BetterTextView;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: nub_x */
public class ShippingNotificationView extends CustomRelativeLayout implements CommerceView {
    private static final CallerContext f8608e = CallerContext.a(ShippingNotificationView.class);
    @Inject
    CommerceViewHelpers f8609a;
    @Inject
    SecureContextHelper f8610b;
    @Inject
    MapViewHelper f8611c;
    @Inject
    @AreDynamicMapsEnabledForCommerce
    Provider<Boolean> f8612d;
    private final ViewStub f8613f;
    private final FbDraweeView f8614g;
    private final BetterTextView f8615h;
    private final BetterTextView f8616i;
    private final BetterTextView f8617j;
    private final BetterTextView f8618k;
    private final BetterTextView f8619l;
    private final BetterTextView f8620m;
    private final ImmutableList<View> f8621n;
    private final BetterTextView f8622o;
    private FbMapViewDelegate f8623p;
    private FbStaticMapView f8624q;
    private OnMapReadyDelegateCallback f8625r;
    public OnMapClickListener f8626s;
    public OnMarkerClickListener f8627t;
    private boolean f8628u;
    private final double f8629v;
    private final ShippingNotificationViewModelHelper f8630w;

    /* compiled from: nub_x */
    class C09883 implements OnMapReadyDelegateCallback {
        final /* synthetic */ ShippingNotificationView f8607a;

        C09883(ShippingNotificationView shippingNotificationView) {
            this.f8607a = shippingNotificationView;
        }

        public final void m8833a(MapDelegate mapDelegate) {
            mapDelegate.a(this.f8607a.f8626s);
            mapDelegate.a(this.f8607a.f8627t);
        }
    }

    private static <T extends View> void m8836a(Class<T> cls, T t) {
        m8837a((Object) t, t.getContext());
    }

    private static void m8837a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((ShippingNotificationView) obj).m8835a(CommerceViewHelpers.m8755b(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), MapViewHelper.m8760b(injectorLike), IdBasedProvider.a(injectorLike, 4114));
    }

    private void m8835a(CommerceViewHelpers commerceViewHelpers, SecureContextHelper secureContextHelper, MapViewHelper mapViewHelper, Provider<Boolean> provider) {
        this.f8609a = commerceViewHelpers;
        this.f8610b = secureContextHelper;
        this.f8611c = mapViewHelper;
        this.f8612d = provider;
    }

    public ShippingNotificationView(Context context) {
        this(context, null);
    }

    public ShippingNotificationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShippingNotificationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8629v = 1.9d;
        m8836a(ShippingNotificationView.class, (View) this);
        this.f8630w = new ShippingNotificationViewModelHelper(context);
        setContentView(2130905615);
        this.f8613f = (ViewStub) a(2131564629);
        this.f8614g = (FbDraweeView) a(2131564630);
        this.f8615h = (BetterTextView) a(2131564632);
        this.f8616i = (BetterTextView) a(2131564631);
        this.f8617j = (BetterTextView) a(2131564633);
        this.f8618k = (BetterTextView) a(2131564634);
        this.f8619l = (BetterTextView) a(2131564635);
        this.f8620m = (BetterTextView) a(2131564636);
        this.f8621n = ImmutableList.of(a(2131564637), a(2131564638), a(2131564639));
        this.f8622o = (BetterTextView) a(2131564640);
        this.f8628u = ((Boolean) this.f8612d.get()).booleanValue();
    }

    public final boolean mo231a() {
        if (this.f8630w.f8632b != null && this.f8630w.f8632b.b() == CommerceBubbleModelType.SHIPMENT_FOR_UNSUPPORTED_CARRIER) {
            Preconditions.checkState(this.f8630w.f8632b instanceof Shipment);
            if (((Shipment) this.f8630w.f8632b).e != null) {
                this.f8610b.b(new Intent("android.intent.action.VIEW").setData(((Shipment) this.f8630w.f8632b).e), getContext());
                return true;
            }
        }
        return false;
    }

    public void setModel(CommerceBubbleModel commerceBubbleModel) {
        this.f8630w.m8847a(commerceBubbleModel);
        m8839b();
    }

    protected void onMeasure(int i, int i2) {
        int size = MeasureSpec.getSize(i);
        LayoutParams layoutParams = this.f8613f.getLayoutParams();
        layoutParams.width = size;
        layoutParams.height = (int) (((double) ((float) size)) / 1.9d);
        this.f8613f.setLayoutParams(layoutParams);
        super.onMeasure(i, i2);
    }

    private void m8839b() {
        m8840c();
        this.f8609a.m8756a(this.f8614g, this.f8630w.m8848b(), f8608e);
        m8841d();
        m8842e();
        m8843f();
        m8844g();
    }

    private void m8840c() {
        if (this.f8628u) {
            if (this.f8623p == null) {
                this.f8613f.setLayoutResource(2130905593);
                this.f8623p = (FbMapViewDelegate) this.f8613f.inflate();
                this.f8623p.a(null);
                final Intent a = ShippingDetailsFragment.m8817a(getContext(), new CommerceData(this.f8630w.f8632b));
                this.f8626s = new OnMapClickListener(this) {
                    final /* synthetic */ ShippingNotificationView f8604b;

                    public final void m8831a() {
                        this.f8604b.f8610b.a(a, this.f8604b.getContext());
                    }
                };
                this.f8627t = new OnMarkerClickListener(this) {
                    final /* synthetic */ ShippingNotificationView f8606b;

                    public final boolean m8832a(MarkerDelegate markerDelegate) {
                        this.f8606b.f8610b.a(a, this.f8606b.getContext());
                        return true;
                    }
                };
                this.f8625r = new C09883(this);
            }
            this.f8611c.m8761a(this.f8630w.f8632b, this.f8623p);
            this.f8623p.a(this.f8625r);
            return;
        }
        if (this.f8624q == null) {
            this.f8613f.setLayoutResource(2130905619);
            this.f8624q = (FbStaticMapView) this.f8613f.inflate();
        }
        RetailAddress h = this.f8630w.m8854h();
        if (h != null) {
            this.f8624q.setMapOptions(new StaticMapOptions("shipping_notification").a().a(13).a(h.h, h.i));
            this.f8624q.setVisibility(0);
            return;
        }
        this.f8624q.setVisibility(8);
    }

    private void m8841d() {
        CharSequence d = this.f8630w.m8850d();
        CharSequence c = this.f8630w.m8849c();
        CharSequence e = this.f8630w.m8851e();
        if (Strings.isNullOrEmpty(d) || Strings.isNullOrEmpty(e)) {
            this.f8616i.setVisibility(8);
            this.f8617j.setVisibility(8);
        } else {
            this.f8616i.setVisibility(0);
            this.f8617j.setVisibility(0);
            this.f8616i.setText(d);
            this.f8617j.setText(e);
        }
        if (Strings.isNullOrEmpty(c)) {
            this.f8615h.setVisibility(8);
        } else {
            this.f8615h.setVisibility(0);
            this.f8615h.setText(c);
        }
        d = this.f8630w.m8852f();
        c = this.f8630w.m8853g();
        if (Strings.isNullOrEmpty(d) || Strings.isNullOrEmpty(c)) {
            this.f8618k.setVisibility(8);
            this.f8619l.setVisibility(8);
            return;
        }
        this.f8618k.setVisibility(0);
        this.f8619l.setVisibility(0);
        this.f8618k.setText(d);
        this.f8619l.setText(c);
    }

    private void m8842e() {
        ImmutableList c;
        if (this.f8630w.f8632b != null) {
            c = this.f8630w.f8632b.c();
        } else {
            c = RegularImmutableList.a;
        }
        if (c.size() == 1) {
            this.f8620m.setText(2131240669);
        } else {
            this.f8620m.setText(2131240670);
        }
        for (int i = 0; i < this.f8621n.size(); i++) {
            PlatformGenericAttachmentItem platformGenericAttachmentItem;
            if (i < c.size()) {
                platformGenericAttachmentItem = (PlatformGenericAttachmentItem) c.get(i);
            } else {
                platformGenericAttachmentItem = null;
            }
            View view = (View) this.f8621n.get(i);
            if (platformGenericAttachmentItem != null) {
                view.setVisibility(0);
                FbDraweeView fbDraweeView = (FbDraweeView) FindViewUtil.b(view, 2131564624);
                if (platformGenericAttachmentItem.d != null) {
                    fbDraweeView.a(platformGenericAttachmentItem.d, f8608e);
                }
                ((BetterTextView) FindViewUtil.b(view, 2131564625)).setText(platformGenericAttachmentItem.b);
                BetterTextView betterTextView = (BetterTextView) FindViewUtil.b(view, 2131564626);
                if (Strings.isNullOrEmpty(platformGenericAttachmentItem.g)) {
                    betterTextView.setVisibility(8);
                } else {
                    betterTextView.setVisibility(0);
                    betterTextView.setText(platformGenericAttachmentItem.g);
                }
            } else {
                view.setVisibility(8);
            }
        }
    }

    private void m8843f() {
        ImmutableList c;
        if (this.f8630w.f8632b != null) {
            c = this.f8630w.f8632b.c();
        } else {
            c = RegularImmutableList.a;
        }
        if (c.size() > this.f8621n.size()) {
            this.f8622o.setVisibility(0);
            this.f8622o.setText(StringLocaleUtil.a(getResources().getString(2131240662), new Object[]{Integer.valueOf(c.size() - this.f8621n.size())}));
            return;
        }
        this.f8622o.setVisibility(8);
    }

    private void m8844g() {
        ImmutableList c;
        if (this.f8630w.f8632b != null) {
            c = this.f8630w.f8632b.c();
        } else {
            c = RegularImmutableList.a;
        }
        int dimension = (int) getResources().getDimension(2131433481);
        int dimension2 = (int) getResources().getDimension(2131433486);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        if (c.size() > this.f8621n.size()) {
            layoutParams.setMargins(dimension, dimension2, dimension, 0);
            ((View) this.f8621n.get(this.f8621n.size() - 1)).setLayoutParams(layoutParams);
        } else if (!c.isEmpty()) {
            layoutParams.setMargins(dimension, dimension2, dimension, dimension);
            ((View) this.f8621n.get(c.size() - 1)).setLayoutParams(layoutParams);
        }
    }
}
