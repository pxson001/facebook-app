package com.facebook.chatheads.view;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.facebook.inject.Assisted;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: reaction_to */
public class ChatHeadTextBubbleWindow extends FloatingChatWindow<ChatHeadTextBubbleView> {
    private final OnGlobalLayoutListener f5829a;
    public int f5830b;

    /* compiled from: reaction_to */
    class C06121 implements OnGlobalLayoutListener {
        final /* synthetic */ ChatHeadTextBubbleWindow f5828a;

        C06121(ChatHeadTextBubbleWindow chatHeadTextBubbleWindow) {
            this.f5828a = chatHeadTextBubbleWindow;
        }

        public void onGlobalLayout() {
            FloatingChatWindow floatingChatWindow = this.f5828a;
            floatingChatWindow.setY(floatingChatWindow.f5830b - (((ChatHeadTextBubbleView) floatingChatWindow.f5795c).getMeasuredHeight() / 2));
        }
    }

    @Inject
    public ChatHeadTextBubbleWindow(WindowManager windowManager, Provider<Boolean> provider, @Assisted boolean z) {
        boolean booleanValue = ((Boolean) provider.get()).booleanValue();
        LayoutParams layoutParams = new LayoutParams(-2, -2, z ? 2010 : 2007, 525064, -3);
        if (!booleanValue) {
            layoutParams.flags |= 16777216;
        }
        if (z) {
            layoutParams.flags |= 524288;
        }
        layoutParams.gravity = 51;
        super(windowManager, layoutParams);
        this.f5830b = -1000;
        this.f5829a = new C06121(this);
    }

    public final void mo229a() {
        if (!this.f5796d) {
            ((ChatHeadTextBubbleView) this.f5795c).getViewTreeObserver().addOnGlobalLayoutListener(this.f5829a);
        }
        super.mo229a();
    }

    public final void mo230b() {
        if (this.f5796d) {
            ((ChatHeadTextBubbleView) this.f5795c).getViewTreeObserver().removeGlobalOnLayoutListener(this.f5829a);
        }
        super.mo230b();
    }
}
