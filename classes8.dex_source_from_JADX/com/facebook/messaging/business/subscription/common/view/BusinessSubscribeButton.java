package com.facebook.messaging.business.subscription.common.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.business.subscription.common.utils.BusinessSubscriptionMutationHelper;
import com.facebook.messaging.business.subscription.common.utils.BusinessSubscriptionMutationHelper.SubscribeCallback;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.text.BetterTextView;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: track_name */
public class BusinessSubscribeButton extends CustomFrameLayout {
    @Inject
    GlyphColorizer f1455a;
    @Inject
    BusinessSubscriptionMutationHelper f1456b;
    public final SubscribeCallback f1457c;
    public String f1458d;
    public String f1459e;
    @Nullable
    public SubscribeButtonListener f1460f;
    private final BetterTextView f1461g;
    private final ImageView f1462h;

    /* compiled from: track_name */
    class C01491 implements SubscribeCallback {
        final /* synthetic */ BusinessSubscribeButton f1453a;

        C01491(BusinessSubscribeButton businessSubscribeButton) {
            this.f1453a = businessSubscribeButton;
        }

        public final void mo65a() {
            this.f1453a.m1644a(ButtonState.SUBSCRIBED);
            if (this.f1453a.f1460f != null) {
                this.f1453a.f1460f.mo67a();
            }
        }

        public final void mo66b() {
            this.f1453a.m1644a(ButtonState.SUBSCRIBE);
        }
    }

    /* compiled from: track_name */
    class C01502 implements OnClickListener {
        final /* synthetic */ BusinessSubscribeButton f1454a;

        C01502(BusinessSubscribeButton businessSubscribeButton) {
            this.f1454a = businessSubscribeButton;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1893848775);
            this.f1454a.m1644a(ButtonState.REQUEST_SENT);
            this.f1454a.f1456b.m1638a(this.f1454a.f1459e, this.f1454a.f1458d, this.f1454a.f1457c);
            Logger.a(2, EntryType.UI_INPUT_END, -361236914, a);
        }
    }

    /* compiled from: track_name */
    enum ButtonState {
        SUBSCRIBE,
        SUBSCRIBED,
        REQUEST_SENT
    }

    /* compiled from: track_name */
    public interface SubscribeButtonListener {
        void mo67a();
    }

    private static <T extends View> void m1646a(Class<T> cls, T t) {
        m1647a((Object) t, t.getContext());
    }

    private static void m1647a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((BusinessSubscribeButton) obj).m1643a(GlyphColorizer.a(fbInjector), BusinessSubscriptionMutationHelper.m1637b(fbInjector));
    }

    public BusinessSubscribeButton(Context context) {
        this(context, null, 0);
    }

    public BusinessSubscribeButton(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BusinessSubscribeButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1457c = new C01491(this);
        m1646a(BusinessSubscribeButton.class, (View) this);
        setContentView(2130903474);
        this.f1461g = (BetterTextView) c(2131560121);
        this.f1462h = (ImageView) c(2131560122);
        this.f1461g.setOnClickListener(new C01502(this));
        m1644a(ButtonState.SUBSCRIBE);
    }

    private void m1643a(GlyphColorizer glyphColorizer, BusinessSubscriptionMutationHelper businessSubscriptionMutationHelper) {
        this.f1455a = glyphColorizer;
        this.f1456b = businessSubscriptionMutationHelper;
    }

    public void setSubscribePageId(String str) {
        this.f1458d = str;
    }

    public void setSubscribeListener(SubscribeButtonListener subscribeButtonListener) {
        this.f1460f = subscribeButtonListener;
    }

    public void setButtonSource(String str) {
        this.f1459e = str;
    }

    private void m1644a(ButtonState buttonState) {
        m1649b(buttonState);
        m1651c(buttonState);
        m1653d(buttonState);
    }

    private void m1649b(ButtonState buttonState) {
        boolean z = buttonState == ButtonState.SUBSCRIBE;
        setEnabled(z);
        this.f1461g.setEnabled(z);
    }

    private void m1651c(ButtonState buttonState) {
        this.f1461g.setTextColor(buttonState == ButtonState.SUBSCRIBE ? getResources().getColor(2131363302) : getResources().getColor(2131363303));
    }

    private void m1653d(ButtonState buttonState) {
        this.f1462h.setImageDrawable(this.f1455a.a(buttonState == ButtonState.SUBSCRIBED ? 2130839776 : 2130839686, getResources().getColor(buttonState == ButtonState.SUBSCRIBE ? 2131363302 : 2131363303)));
    }
}
