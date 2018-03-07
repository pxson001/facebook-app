package com.facebook.events.permalink.tabbar;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.IdRes;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.events.common.EventDrawDividerUtil;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.CustomLinearLayout;
import javax.annotation.Nullable;

/* compiled from: button_text_color */
public class EventPermalinkTabBar extends CustomLinearLayout {
    private View[] f18943a;
    public OnTabChangeListener f18944b;
    private EventDrawDividerUtil f18945c;

    /* compiled from: button_text_color */
    public interface OnTabChangeListener {
        void mo837a(@IdRes int i, boolean z);
    }

    /* compiled from: button_text_color */
    class C26871 implements OnClickListener {
        final /* synthetic */ EventPermalinkTabBar f18942a;

        C26871(EventPermalinkTabBar eventPermalinkTabBar) {
            this.f18942a = eventPermalinkTabBar;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 114827128);
            if (this.f18942a.f18944b != null) {
                this.f18942a.f18944b.mo837a(view.getId(), !view.isSelected());
            }
            LogUtils.a(-605259556, a);
        }
    }

    public EventPermalinkTabBar(Context context) {
        super(context);
        m19185a();
    }

    public EventPermalinkTabBar(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m19185a();
    }

    protected EventPermalinkTabBar(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m19185a();
    }

    private void m19185a() {
        int i = 0;
        setContentView(2130904086);
        this.f18945c = new EventDrawDividerUtil(getResources());
        View a = a(2131561368);
        View a2 = a(2131561369);
        this.f18943a = new View[]{a, a2};
        a.setSelected(true);
        OnClickListener c26871 = new C26871(this);
        View[] viewArr = this.f18943a;
        int length = viewArr.length;
        while (i < length) {
            viewArr[i].setOnClickListener(c26871);
            i++;
        }
    }

    public void setOnTabChangeListener(OnTabChangeListener onTabChangeListener) {
        this.f18944b = onTabChangeListener;
    }

    public void setSelected(@IdRes int i) {
        for (View view : this.f18943a) {
            boolean z;
            if (i == view.getId()) {
                z = true;
            } else {
                z = false;
            }
            view.setSelected(z);
        }
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        this.f18945c.a(canvas, 0.0f);
        this.f18945c.b(canvas);
    }
}
