package com.facebook.messaging.peopleyoumaycall;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.facebook.inject.FbInjector;
import com.facebook.messaging.photos.tiles.MessengerThreadTileViewDataFactory;
import com.facebook.user.model.User;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.tiles.DelegatingThreadTileViewData;
import com.facebook.widget.tiles.ThreadTileView;
import com.facebook.widget.tiles.ThreadTileViewData;
import com.facebook.widget.tiles.TileBadge;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: requestable_fields */
public class PeopleYouMayCallItemView extends CustomLinearLayout {
    @Inject
    public MessengerThreadTileViewDataFactory f3451a;
    private ThreadTileView f3452b;
    private TextView f3453c;

    /* compiled from: requestable_fields */
    class ThreadTileViewDataWithNoBadge extends DelegatingThreadTileViewData {
        public ThreadTileViewDataWithNoBadge(ThreadTileViewData threadTileViewData) {
            super(threadTileViewData);
        }

        public final TileBadge m3333b() {
            return TileBadge.NONE;
        }
    }

    private static <T extends View> void m3335a(Class<T> cls, T t) {
        m3336a((Object) t, t.getContext());
    }

    private static void m3336a(Object obj, Context context) {
        ((PeopleYouMayCallItemView) obj).f3451a = MessengerThreadTileViewDataFactory.a(FbInjector.get(context));
    }

    public PeopleYouMayCallItemView(Context context) {
        super(context);
        m3334a();
    }

    public PeopleYouMayCallItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m3334a();
    }

    public PeopleYouMayCallItemView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m3334a();
    }

    private void m3334a() {
        m3335a(PeopleYouMayCallItemView.class, (View) this);
        setOrientation(1);
        setContentView(2130906164);
        this.f3452b = (ThreadTileView) a(2131560123);
        this.f3453c = (TextView) a(2131560124);
    }

    final void m3337a(PersonYouMayCall personYouMayCall) {
        User user = personYouMayCall.f3464a;
        this.f3452b.setThreadTileViewData(new ThreadTileViewDataWithNoBadge(this.f3451a.a(user)));
        this.f3453c.setText(user.h());
    }

    final void m3338a(boolean z) {
        this.f3453c.setVisibility(z ? 0 : 8);
    }
}
