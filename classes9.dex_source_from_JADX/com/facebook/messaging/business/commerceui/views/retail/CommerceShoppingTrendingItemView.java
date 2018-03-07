package com.facebook.messaging.business.commerceui.views.retail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.business.attachments.model.PlatformGenericAttachmentItem;
import com.facebook.messaging.business.commerceui.analytics.MessengerCommerceAnalyticsLogger;
import com.facebook.messaging.linkhandling.LinkHandlingHelper;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterTextView;
import javax.inject.Inject;

/* compiled from: null content-id */
public class CommerceShoppingTrendingItemView extends CustomLinearLayout {
    @Inject
    public Lazy<LinkHandlingHelper> f8502a;
    @Inject
    public MessengerCommerceAnalyticsLogger f8503b;
    public final FbDraweeView f8504c;
    public final BetterTextView f8505d;
    public final BetterTextView f8506e;

    /* compiled from: null content-id */
    public class C09691 implements OnClickListener {
        final /* synthetic */ String f8499a;
        final /* synthetic */ PlatformGenericAttachmentItem f8500b;
        final /* synthetic */ CommerceShoppingTrendingItemView f8501c;

        public C09691(CommerceShoppingTrendingItemView commerceShoppingTrendingItemView, String str, PlatformGenericAttachmentItem platformGenericAttachmentItem) {
            this.f8501c = commerceShoppingTrendingItemView;
            this.f8499a = str;
            this.f8500b = platformGenericAttachmentItem;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1720263618);
            this.f8501c.f8503b.m8659e(this.f8499a);
            ((LinkHandlingHelper) this.f8501c.f8502a.get()).a(this.f8501c.getContext(), this.f8500b.l);
            Logger.a(2, EntryType.UI_INPUT_END, 1728770721, a);
        }
    }

    public static void m8751a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        CommerceShoppingTrendingItemView commerceShoppingTrendingItemView = (CommerceShoppingTrendingItemView) obj;
        Lazy b = IdBasedSingletonScopeProvider.b(fbInjector, 7898);
        MessengerCommerceAnalyticsLogger b2 = MessengerCommerceAnalyticsLogger.m8651b(fbInjector);
        commerceShoppingTrendingItemView.f8502a = b;
        commerceShoppingTrendingItemView.f8503b = b2;
    }

    public CommerceShoppingTrendingItemView(Context context) {
        this(context, null, 0);
    }

    private CommerceShoppingTrendingItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = CommerceShoppingTrendingItemView.class;
        m8751a(this, getContext());
        setContentView(2130905634);
        this.f8504c = (FbDraweeView) a(2131562510);
        this.f8505d = (BetterTextView) a(2131562512);
        this.f8506e = (BetterTextView) a(2131564681);
        int dimensionPixelSize = getResources().getDimensionPixelSize(2131433552);
        setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        setOrientation(1);
    }
}
