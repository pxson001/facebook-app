package com.facebook.particles;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.facebook.feedback.reactions.ui.FloatingReactionsLauncher$1;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.choreographer.ChoreographerWrapper;
import com.facebook.ui.choreographer.DefaultChoreographerWrapper;
import javax.inject.Inject;

/* compiled from: max_contacts_allowed */
public class ParticleSystemView extends View {
    @Inject
    public ParticleSystemDrawable f9230a;
    private FloatingReactionsLauncher$1 f9231b;

    public static void m11275a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((ParticleSystemView) obj).f9230a = new ParticleSystemDrawable((Context) fbInjector.getInstance(Context.class), (ChoreographerWrapper) DefaultChoreographerWrapper.a(fbInjector));
    }

    public ParticleSystemView(Context context) {
        super(context);
        Class cls = ParticleSystemView.class;
        m11275a(this, getContext());
        setBackgroundDrawable(this.f9230a);
    }

    protected void onWindowVisibilityChanged(int i) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1667276125);
        super.onWindowVisibilityChanged(i);
        if (i == 8 && this.f9231b != null) {
            this.f9231b.m4505a();
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 548040423, a);
    }

    public final void m11277a(SimpleParticleStyle simpleParticleStyle) {
        this.f9230a.m11274a(simpleParticleStyle);
    }

    public void setParticleSystemCallback(FloatingReactionsLauncher$1 floatingReactionsLauncher$1) {
        this.f9231b = floatingReactionsLauncher$1;
        this.f9230a.f9227i = floatingReactionsLauncher$1;
    }

    public final void m11276a() {
        ParticleSystemDrawable particleSystemDrawable = this.f9230a;
        particleSystemDrawable.f9220b.clear();
        particleSystemDrawable.f9221c.clear();
        particleSystemDrawable.f9222d.clear();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 623705698);
        ParticleSystemDrawable particleSystemDrawable = this.f9230a;
        boolean onTouchEvent = particleSystemDrawable.f9226h.onTouchEvent(motionEvent);
        switch (motionEvent.getActionMasked()) {
            case 1:
            case 3:
                particleSystemDrawable.f9228j = null;
                onTouchEvent = true;
                break;
        }
        boolean z = onTouchEvent || super.onTouchEvent(motionEvent);
        LogUtils.a(446278369, a);
        return z;
    }
}
