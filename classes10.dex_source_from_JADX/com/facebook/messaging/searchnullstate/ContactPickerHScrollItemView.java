package com.facebook.messaging.searchnullstate;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.facebook.common.i18n.I18nJoiner;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.FbInjector;
import com.facebook.messaging.cache.ThreadDisplayCache;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.photos.tiles.MessengerThreadTileViewDataFactory;
import com.facebook.user.model.User;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.tiles.ThreadTileView;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: refresh_threshold */
public class ContactPickerHScrollItemView extends CustomLinearLayout {
    @Inject
    public I18nJoiner f3819a;
    @Inject
    public MessengerThreadTileViewDataFactory f3820b;
    @Inject
    public ThreadDisplayCache f3821c;
    private ThreadTileView f3822d;
    private TextView f3823e;
    public int f3824f;

    private static <T extends View> void m3604a(Class<T> cls, T t) {
        m3605a((Object) t, t.getContext());
    }

    private static void m3605a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ContactPickerHScrollItemView contactPickerHScrollItemView = (ContactPickerHScrollItemView) obj;
        I18nJoiner b = I18nJoiner.b(fbInjector);
        MessengerThreadTileViewDataFactory a = MessengerThreadTileViewDataFactory.a(fbInjector);
        ThreadDisplayCache a2 = ThreadDisplayCache.a(fbInjector);
        contactPickerHScrollItemView.f3819a = b;
        contactPickerHScrollItemView.f3820b = a;
        contactPickerHScrollItemView.f3821c = a2;
    }

    public ContactPickerHScrollItemView(Context context) {
        super(context);
        m3603a();
    }

    public ContactPickerHScrollItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m3603a();
    }

    public ContactPickerHScrollItemView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m3603a();
    }

    private void m3603a() {
        m3604a(ContactPickerHScrollItemView.class, (View) this);
        setOrientation(1);
        setContentView(2130905652);
        int dimension = (int) getContext().getResources().getDimension(2131433816);
        setPadding(dimension, 0, dimension, 0);
        this.f3822d = (ThreadTileView) a(2131564736);
        this.f3823e = (TextView) a(2131564737);
    }

    void setSingleLine(boolean z) {
        this.f3823e.setSingleLine(z);
        this.f3823e.setLines(z ? 1 : 2);
    }

    void setUser(User user) {
        this.f3822d.setThreadTileViewData(this.f3820b.a(user));
        this.f3823e.setText(!StringUtil.a(user.h()) ? user.h() : user.k());
    }

    void setThreadSummary(ThreadSummary threadSummary) {
        this.f3822d.setThreadTileViewData(this.f3820b.a(threadSummary));
        if (threadSummary.a()) {
            this.f3823e.setText(threadSummary.g);
            return;
        }
        List a = this.f3821c.a(threadSummary);
        if (a == null || a.isEmpty()) {
            this.f3823e.setText(getResources().getString(2131231061));
        } else {
            this.f3823e.setText(this.f3819a.a(a));
        }
    }

    public int getPosition() {
        return this.f3824f;
    }

    public void setPosition(int i) {
        this.f3824f = i;
    }
}
