package com.facebook.messaging.business.subscription.instantarticle.view;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.messaging.business.subscription.common.view.BusinessSubscribeButton;
import com.facebook.messaging.business.subscription.common.view.BusinessSubscribeButton.SubscribeButtonListener;
import com.facebook.messaging.business.subscription.instantarticle.util.BusinessIASubscriptionBannerPresenter.C01522;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.tiles.ThreadTileView;
import com.facebook.widget.tiles.ThreadTileViewData;
import javax.annotation.Nullable;

/* compiled from: total_time_open */
public class BusinessIASubscribeBannerView extends CustomFrameLayout {
    private final ThreadTileView f1486a;
    private final FbTextView f1487b;
    private final FbTextView f1488c;
    private final BusinessSubscribeButton f1489d;

    public BusinessIASubscribeBannerView(Context context) {
        this(context, null, 0);
    }

    public BusinessIASubscribeBannerView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BusinessIASubscribeBannerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130903467);
        this.f1486a = (ThreadTileView) c(2131560095);
        this.f1487b = (FbTextView) c(2131560096);
        this.f1488c = (FbTextView) c(2131560097);
        this.f1489d = (BusinessSubscribeButton) c(2131560098);
        setClickable(true);
    }

    public final void m1676a(String str, String str2, ThreadTileViewData threadTileViewData, String str3, String str4, final C01522 c01522) {
        this.f1487b.setText(str);
        this.f1488c.setText(str2);
        this.f1486a.setThreadTileViewData(threadTileViewData);
        this.f1489d.f1458d = str3;
        this.f1489d.f1459e = str4;
        this.f1489d.f1460f = new SubscribeButtonListener(this) {
            final /* synthetic */ BusinessIASubscribeBannerView f1485b;

            public final void mo67a() {
                c01522.f1467a.c();
            }
        };
    }
}
