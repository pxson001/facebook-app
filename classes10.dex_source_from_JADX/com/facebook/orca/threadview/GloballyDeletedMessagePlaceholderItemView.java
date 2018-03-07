package com.facebook.orca.threadview;

import android.content.Context;
import com.facebook.inject.FbInjector;
import com.facebook.messaging.photos.tiles.UserTileViewParamsFactory;
import com.facebook.messaging.threadview.rows.RowGloballyDeletedMessagePlaceholderItem;
import com.facebook.user.tiles.UserTileView;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.RoundedCornerOverlayDrawable;
import com.facebook.widget.text.BetterTextView;
import javax.inject.Inject;

/* compiled from: min_viewability_percentage */
public class GloballyDeletedMessagePlaceholderItemView extends CustomFrameLayout {
    @Inject
    public UserTileViewParamsFactory f6934a;
    public BetterTextView f6935b = ((BetterTextView) c(2131564861));
    public RoundedCornerOverlayDrawable f6936c = new RoundedCornerOverlayDrawable();
    public RowGloballyDeletedMessagePlaceholderItem f6937d;
    public UserTileView f6938e = ((UserTileView) c(2131564859));

    public static void m6561a(Object obj, Context context) {
        ((GloballyDeletedMessagePlaceholderItemView) obj).f6934a = UserTileViewParamsFactory.a(FbInjector.get(context));
    }

    public GloballyDeletedMessagePlaceholderItemView(Context context) {
        super(context, null, 0);
        Class cls = GloballyDeletedMessagePlaceholderItemView.class;
        m6561a(this, getContext());
        setContentView(2130905697);
        this.f6936c.c(getResources().getDimensionPixelSize(2131428585));
        this.f6936c.b(getResources().getColor(2131362331));
        c(2131564860).setBackgroundDrawable(this.f6936c);
    }
}
