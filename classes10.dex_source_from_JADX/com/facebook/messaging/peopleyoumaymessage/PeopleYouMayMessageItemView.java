package com.facebook.messaging.peopleyoumaymessage;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.facebook.graphql.enums.GraphQLMessengerPYMMIconType;
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

/* compiled from: remove_people */
public class PeopleYouMayMessageItemView extends CustomLinearLayout {
    @Inject
    public MessengerThreadTileViewDataFactory f3481a;
    private ThreadTileView f3482b;
    private TextView f3483c;

    /* compiled from: remove_people */
    class ThreadTileViewDataWithBirthdayBadge extends DelegatingThreadTileViewData {
        private final PersonYouMayMessage f3480a;

        public ThreadTileViewDataWithBirthdayBadge(PersonYouMayMessage personYouMayMessage, ThreadTileViewData threadTileViewData) {
            super(threadTileViewData);
            this.f3480a = personYouMayMessage;
        }

        public final TileBadge m3361b() {
            if (this.f3480a.f3502b == GraphQLMessengerPYMMIconType.BIRTHDAY) {
                return TileBadge.BIRTHDAY;
            }
            return TileBadge.NONE;
        }
    }

    private static <T extends View> void m3363a(Class<T> cls, T t) {
        m3364a((Object) t, t.getContext());
    }

    private static void m3364a(Object obj, Context context) {
        ((PeopleYouMayMessageItemView) obj).f3481a = MessengerThreadTileViewDataFactory.a(FbInjector.get(context));
    }

    public PeopleYouMayMessageItemView(Context context) {
        super(context);
        m3362a();
    }

    public PeopleYouMayMessageItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m3362a();
    }

    public PeopleYouMayMessageItemView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m3362a();
    }

    private void m3362a() {
        m3363a(PeopleYouMayMessageItemView.class, (View) this);
        setOrientation(1);
        setContentView(2130906169);
        this.f3482b = (ThreadTileView) a(2131560123);
        this.f3483c = (TextView) a(2131560124);
        this.f3482b.setUseInbox2AlternateBadges(true);
    }

    final void m3365a(PersonYouMayMessage personYouMayMessage) {
        User user = personYouMayMessage.f3501a;
        this.f3482b.setThreadTileViewData(new ThreadTileViewDataWithBirthdayBadge(personYouMayMessage, this.f3481a.a(user)));
        this.f3483c.setText(user.h());
    }

    final void m3366a(boolean z) {
        this.f3483c.setVisibility(z ? 0 : 8);
    }
}
