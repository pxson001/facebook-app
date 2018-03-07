package com.facebook.facecastdisplay;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomRelativeLayout;
import com.facebook.widget.springbutton.TouchSpring;
import javax.inject.Inject;

/* compiled from: sub_component */
public class LiveCommentEventView extends CustomRelativeLayout {
    public final LiveCommentEventViewHolder f2861a;
    @Inject
    public TouchSpring f2862b;
    private final Resources f2863c;
    private boolean f2864d;
    private boolean f2865e;

    /* compiled from: sub_component */
    public interface LiveCommentEventViewClickListener {
        void mo129a(View view, int i);
    }

    private static <T extends View> void m3152a(Class<T> cls, T t) {
        m3153a((Object) t, t.getContext());
    }

    private static void m3153a(Object obj, Context context) {
        ((LiveCommentEventView) obj).f2862b = TouchSpring.b(FbInjector.get(context));
    }

    public LiveCommentEventView(Context context) {
        this(context, null);
    }

    public LiveCommentEventView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LiveCommentEventView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m3152a(LiveCommentEventView.class, (View) this);
        setContentView(2130905066);
        setClipChildren(false);
        this.f2863c = context.getResources();
        this.f2861a = new LiveCommentEventViewHolder(this);
        this.f2861a.f2868m.a(this.f2862b);
    }

    public final void m3154a(boolean z) {
        if (z) {
            this.f2861a.f2868m.setImageResource(2130841066);
            this.f2861a.f2868m.setContentDescription(getResources().getString(2131232722));
            return;
        }
        this.f2861a.f2868m.setImageResource(2130841067);
        this.f2861a.f2868m.setContentDescription(getResources().getString(2131232723));
    }

    private void m3151a(TouchSpring touchSpring) {
        this.f2862b = touchSpring;
    }

    public void setListener(final LiveCommentEventViewClickListener liveCommentEventViewClickListener) {
        setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ LiveCommentEventView f2860b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1928990943);
                liveCommentEventViewClickListener.mo129a(view, this.f2860b.f2861a.e());
                Logger.a(2, EntryType.UI_INPUT_END, 1495184330, a);
            }
        });
    }

    public void setIsBlocked(boolean z) {
        this.f2864d = z;
        if (z) {
            this.f2861a.f2866o.setAlpha(0.5f);
            this.f2861a.f2867l.setAlpha(0.5f);
            this.f2861a.f2869n.setVisibility(0);
        } else {
            this.f2861a.f2866o.setAlpha(1.0f);
            this.f2861a.f2867l.setAlpha(1.0f);
            this.f2861a.f2869n.setVisibility(8);
        }
        m3150a();
    }

    public void setIsBroadcaster(boolean z) {
        this.f2865e = z;
        m3150a();
    }

    private void m3150a() {
        boolean z = (this.f2864d || this.f2865e) ? false : true;
        setClickable(z);
    }
}
