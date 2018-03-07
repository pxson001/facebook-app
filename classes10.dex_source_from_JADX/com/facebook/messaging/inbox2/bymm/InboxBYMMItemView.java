package com.facebook.messaging.inbox2.bymm;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.facebook.inject.FbInjector;
import com.facebook.messaging.photos.tiles.MessengerThreadTileViewDataFactory;
import com.facebook.user.model.User;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.tiles.ThreadTileView;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: set_items_cursor */
public class InboxBYMMItemView extends CustomLinearLayout {
    @Inject
    public MessengerThreadTileViewDataFactory f2682a;
    public InboxBusinessYouMayMessage f2683b;
    private ThreadTileView f2684c;
    private TextView f2685d;

    private static <T extends View> void m2650a(Class<T> cls, T t) {
        m2651a((Object) t, t.getContext());
    }

    private static void m2651a(Object obj, Context context) {
        ((InboxBYMMItemView) obj).f2682a = MessengerThreadTileViewDataFactory.a(FbInjector.get(context));
    }

    public InboxBYMMItemView(Context context) {
        super(context);
        m2652b();
    }

    public InboxBYMMItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m2652b();
    }

    public InboxBYMMItemView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2652b();
    }

    private void m2652b() {
        m2650a(InboxBYMMItemView.class, (View) this);
        setOrientation(1);
        setContentView(2130903477);
        this.f2684c = (ThreadTileView) a(2131560123);
        this.f2685d = (TextView) a(2131560124);
    }

    final void m2654a(InboxBusinessYouMayMessage inboxBusinessYouMayMessage) {
        this.f2683b = inboxBusinessYouMayMessage;
        User user = inboxBusinessYouMayMessage.f2691a;
        this.f2684c.setThreadTileViewData(this.f2682a.a(user));
        this.f2685d.setText(user.j());
    }

    final InboxBusinessYouMayMessage m2653a() {
        return this.f2683b;
    }
}
