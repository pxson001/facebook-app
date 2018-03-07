package com.facebook.messaging.payment.prefs.transactions;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.inject.FbInjector;
import com.facebook.widget.CustomLinearLayout;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: friends_section */
public class ProductMessengerPayHistoryItemView extends CustomLinearLayout implements MessengerPayHistoryItemView {
    private static final CallerContext f14405b = CallerContext.a(ProductMessengerPayHistoryItemView.class);
    @Inject
    public Resources f14406a;
    private ProductMessengerPayHistoryItemViewParams f14407c;

    private static <T extends View> void m14789a(Class<T> cls, T t) {
        m14790a((Object) t, t.getContext());
    }

    private static void m14790a(Object obj, Context context) {
        ((ProductMessengerPayHistoryItemView) obj).f14406a = ResourcesMethodAutoProvider.a(FbInjector.get(context));
    }

    public ProductMessengerPayHistoryItemView(Context context) {
        this(context, null);
    }

    public ProductMessengerPayHistoryItemView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    protected ProductMessengerPayHistoryItemView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m14789a(ProductMessengerPayHistoryItemView.class, (View) this);
        setContentView(2130906421);
    }

    public void setMessengerPayHistoryItemViewParams(MessengerPayHistoryItemViewParams messengerPayHistoryItemViewParams) {
        this.f14407c = (ProductMessengerPayHistoryItemViewParams) messengerPayHistoryItemViewParams;
        m14787a();
        m14791b();
    }

    private void m14787a() {
        ((SimpleMessengerPayHistoryItemView) findViewById(2131566330)).setMessengerPayHistoryItemViewCommonParams(this.f14407c.f14410c);
    }

    private void m14791b() {
        GenericDraweeHierarchyBuilder a = GenericDraweeHierarchyBuilder.a(this.f14406a);
        a.u = RoundingParams.e();
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = a;
        if (this.f14407c.f14409b != 0) {
            genericDraweeHierarchyBuilder.f = this.f14406a.getDrawable(this.f14407c.f14409b);
        }
        FbDraweeView fbDraweeView = (FbDraweeView) findViewById(2131566324);
        fbDraweeView.setHierarchy(genericDraweeHierarchyBuilder.u());
        if (this.f14407c.f14408a != null) {
            fbDraweeView.a(Uri.parse(this.f14407c.f14408a), f14405b);
        }
    }

    private void m14788a(Resources resources) {
        this.f14406a = resources;
    }
}
