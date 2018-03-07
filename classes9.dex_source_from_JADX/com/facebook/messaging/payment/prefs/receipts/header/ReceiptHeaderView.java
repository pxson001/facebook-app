package com.facebook.messaging.payment.prefs.receipts.header;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.auth.annotations.IsPartialAccount;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.user.model.User.Type;
import com.facebook.user.model.UserKey;
import com.facebook.user.tiles.UserTileView;
import com.facebook.user.tiles.UserTileViewParams;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterTextView;
import com.facebook.widget.tiles.TileBadge;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: getSlotId */
public class ReceiptHeaderView extends CustomLinearLayout {
    @Inject
    @IsPartialAccount
    public Provider<Boolean> f14139a;
    private ReceiptHeaderViewParams f14140b;

    private static <T extends View> void m14607a(Class<T> cls, T t) {
        m14608a((Object) t, t.getContext());
    }

    private static void m14608a(Object obj, Context context) {
        ((ReceiptHeaderView) obj).f14139a = IdBasedProvider.a(FbInjector.get(context), 3902);
    }

    public ReceiptHeaderView(Context context) {
        this(context, null);
    }

    public ReceiptHeaderView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ReceiptHeaderView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m14607a(ReceiptHeaderView.class, (View) this);
        setContentView(2130906737);
    }

    public void setReceiptHeaderViewParams(ReceiptHeaderViewParams receiptHeaderViewParams) {
        this.f14140b = receiptHeaderViewParams;
        m14606a();
        m14610b();
        m14611c();
        m14612d();
    }

    private void m14606a() {
        ((BetterTextView) findViewById(2131566821)).setText(this.f14140b.f14150c);
    }

    private void m14610b() {
        ((BetterTextView) findViewById(2131566822)).setText(this.f14140b.f14149b);
    }

    private void m14611c() {
        boolean booleanValue = ((Boolean) this.f14139a.get()).booleanValue();
        UserTileView userTileView = (UserTileView) findViewById(2131566820);
        UserKey userKey = new UserKey(Type.FACEBOOK, this.f14140b.f14148a.mo526b());
        TileBadge tileBadge = this.f14140b.f14148a.mo528d() ? TileBadge.MESSENGER : booleanValue ? TileBadge.NONE : TileBadge.FACEBOOK;
        userTileView.setParams(UserTileViewParams.a(userKey, tileBadge));
    }

    private void m14609a(Provider<Boolean> provider) {
        this.f14139a = provider;
    }

    private void m14612d() {
        View findViewById = findViewById(2131566823);
        if (this.f14140b.f14151d) {
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(8);
        }
    }
}
