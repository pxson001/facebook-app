package com.facebook.messaging.payment.prefs.transactions;

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
import com.facebook.widget.tiles.TileBadge;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: friendable */
public class UserMessengerPayHistoryItemView extends CustomLinearLayout implements MessengerPayHistoryItemView {
    @Inject
    @IsPartialAccount
    public Provider<Boolean> f14416a;
    private UserMessengerPayHistoryItemViewParams f14417b;

    private static <T extends View> void m14807a(Class<T> cls, T t) {
        m14808a((Object) t, t.getContext());
    }

    private static void m14808a(Object obj, Context context) {
        ((UserMessengerPayHistoryItemView) obj).f14416a = IdBasedProvider.a(FbInjector.get(context), 3902);
    }

    public UserMessengerPayHistoryItemView(Context context) {
        this(context, null);
    }

    public UserMessengerPayHistoryItemView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    protected UserMessengerPayHistoryItemView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m14807a(UserMessengerPayHistoryItemView.class, (View) this);
        setContentView(2130907624);
    }

    public void setMessengerPayHistoryItemViewParams(MessengerPayHistoryItemViewParams messengerPayHistoryItemViewParams) {
        this.f14417b = (UserMessengerPayHistoryItemViewParams) messengerPayHistoryItemViewParams;
        m14810b();
        m14806a();
    }

    private void m14806a() {
        ((SimpleMessengerPayHistoryItemView) findViewById(2131566330)).setMessengerPayHistoryItemViewCommonParams(this.f14417b.f14419b);
    }

    private void m14809a(Provider<Boolean> provider) {
        this.f14416a = provider;
    }

    private void m14810b() {
        boolean booleanValue = ((Boolean) this.f14416a.get()).booleanValue();
        boolean equals = "499725321".equals(this.f14417b.f14418a.mo526b());
        UserTileView userTileView = (UserTileView) findViewById(2131568226);
        UserKey userKey = new UserKey(Type.FACEBOOK, this.f14417b.f14418a.mo526b());
        TileBadge tileBadge = this.f14417b.f14418a.mo528d() ? TileBadge.MESSENGER : (booleanValue || equals) ? TileBadge.NONE : TileBadge.FACEBOOK;
        userTileView.setParams(UserTileViewParams.a(userKey, tileBadge));
    }
}
