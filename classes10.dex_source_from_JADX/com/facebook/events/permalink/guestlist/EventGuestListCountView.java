package com.facebook.events.permalink.guestlist;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import com.facebook.common.numbers.NumberTruncationUtil;
import com.facebook.events.permalink.guestlist.common.EventGuestListType;
import com.facebook.inject.FbInjector;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomLinearLayout;
import javax.inject.Inject;

/* compiled from: broadcastScript */
public class EventGuestListCountView extends CustomLinearLayout {
    @Inject
    public NumberTruncationUtil f18349a;
    private FbTextView f18350b;
    private FbTextView f18351c;
    private ProgressBar f18352d;
    private int f18353e;

    /* compiled from: broadcastScript */
    public class EventGuestCountModel {
        public int f18346a;
        public String f18347b;
        public EventGuestListType f18348c;

        public EventGuestCountModel(int i, String str, EventGuestListType eventGuestListType) {
            this.f18346a = i;
            this.f18347b = str;
            this.f18348c = eventGuestListType;
        }

        public final int m18684a() {
            return this.f18346a;
        }

        public final String m18685b() {
            return this.f18347b;
        }

        public final EventGuestListType m18686c() {
            return this.f18348c;
        }
    }

    private static <T extends View> void m18688a(Class<T> cls, T t) {
        m18689a((Object) t, t.getContext());
    }

    private static void m18689a(Object obj, Context context) {
        ((EventGuestListCountView) obj).f18349a = NumberTruncationUtil.a(FbInjector.get(context));
    }

    public EventGuestListCountView(Context context) {
        super(context);
        m18690c();
    }

    public EventGuestListCountView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m18690c();
    }

    public EventGuestListCountView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m18690c();
    }

    private void m18690c() {
        m18688a(EventGuestListCountView.class, (View) this);
        setOrientation(1);
        setContentView(2130904036);
        this.f18350b = (FbTextView) a(2131561296);
        this.f18351c = (FbTextView) a(2131561298);
        this.f18352d = (ProgressBar) a(2131561297);
    }

    public void setInProgress(boolean z) {
        if (z) {
            this.f18350b.setVisibility(4);
            this.f18352d.setVisibility(0);
            return;
        }
        this.f18350b.setVisibility(0);
        this.f18352d.setVisibility(8);
    }

    private void m18687a(NumberTruncationUtil numberTruncationUtil) {
        this.f18349a = numberTruncationUtil;
    }

    public final void m18692a() {
        this.f18353e++;
        m18691d();
    }

    public final void m18694b() {
        this.f18353e--;
        m18691d();
    }

    private void m18691d() {
        this.f18350b.setText(this.f18349a.a(this.f18353e));
    }

    public final void m18693a(EventGuestCountModel eventGuestCountModel) {
        this.f18353e = eventGuestCountModel.f18346a;
        m18691d();
        this.f18351c.setText(eventGuestCountModel.f18347b);
        setInProgress(false);
    }
}
