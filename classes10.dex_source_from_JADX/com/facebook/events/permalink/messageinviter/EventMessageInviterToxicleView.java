package com.facebook.events.permalink.messageinviter;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.events.common.ActionMechanism;
import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.events.common.EventDrawDividerUtil;
import com.facebook.events.logging.EventEventLogger;
import com.facebook.events.model.Event;
import com.facebook.events.model.EventUser;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.forcemessenger.ForceMessengerHandler;
import com.facebook.messaging.util.MessengerAppUtils;
import com.facebook.resources.utils.TextViewUtils;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.text.BetterTextView;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: becomeAdminsDialog */
public class EventMessageInviterToxicleView extends CustomFrameLayout {
    @Inject
    MessengerAppUtils f18678a;
    @Inject
    EventEventLogger f18679b;
    @Inject
    ForceMessengerHandler f18680c;
    @Inject
    GlyphColorizer f18681d;
    public Event f18682e;
    public EventAnalyticsParams f18683f;
    private BetterTextView f18684g;
    private EventDrawDividerUtil f18685h;
    private int f18686i;
    private boolean f18687j;

    /* compiled from: becomeAdminsDialog */
    class C26621 implements OnClickListener {
        final /* synthetic */ EventMessageInviterToxicleView f18677a;

        C26621(EventMessageInviterToxicleView eventMessageInviterToxicleView) {
            this.f18677a = eventMessageInviterToxicleView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1890376321);
            if (this.f18677a.f18682e != null) {
                String str;
                EventUser eventUser = this.f18677a.f18682e.ai;
                if (eventUser == null) {
                    str = null;
                } else {
                    str = eventUser.b;
                }
                if (str != null) {
                    this.f18677a.f18679b.m18129a(this.f18677a.f18683f.d, ActionMechanism.PERMALINK, this.f18677a.f18683f.c, this.f18677a.f18682e.a, this.f18677a.f18678a.c());
                    this.f18677a.f18680c.a(str, "events");
                }
            }
            LogUtils.a(-1912990545, a);
        }
    }

    private static <T extends View> void m18985a(Class<T> cls, T t) {
        m18986a((Object) t, t.getContext());
    }

    private static void m18986a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((EventMessageInviterToxicleView) obj).m18984a(MessengerAppUtils.a(fbInjector), EventEventLogger.m18119b(fbInjector), ForceMessengerHandler.b(fbInjector), GlyphColorizer.a(fbInjector));
    }

    public EventMessageInviterToxicleView(Context context) {
        super(context);
        m18983a();
    }

    public EventMessageInviterToxicleView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m18983a();
    }

    private void m18984a(MessengerAppUtils messengerAppUtils, EventEventLogger eventEventLogger, ForceMessengerHandler forceMessengerHandler, GlyphColorizer glyphColorizer) {
        this.f18678a = messengerAppUtils;
        this.f18679b = eventEventLogger;
        this.f18680c = forceMessengerHandler;
        this.f18681d = glyphColorizer;
    }

    protected EventMessageInviterToxicleView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m18983a();
    }

    private void m18983a() {
        m18985a(EventMessageInviterToxicleView.class, (View) this);
        setContentView(2130904081);
        this.f18685h = new EventDrawDividerUtil(getResources());
        this.f18686i = getResources().getDimensionPixelSize(2131427416);
        this.f18684g = (BetterTextView) c(2131561363);
        TextViewUtils.a(this.f18684g, this.f18681d.a(2130839685, -12887656), null, null, null);
        setOnClickListener(new C26621(this));
    }

    public final void m18988a(Event event, EventAnalyticsParams eventAnalyticsParams, boolean z) {
        this.f18687j = !z;
        this.f18682e = event;
        this.f18683f = eventAnalyticsParams;
        setMessageInviterButtonText(event.ai.c);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f18687j) {
            this.f18685h.a(canvas, 0.0f, this.f18686i);
        }
    }

    private void setMessageInviterButtonText(String str) {
        this.f18684g.setText(getResources().getString(2131237065, new Object[]{str}));
    }
}
