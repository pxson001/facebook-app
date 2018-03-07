package com.facebook.timeline.actionbar.seefirst;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.facebook.common.util.FindViewUtil;
import com.facebook.fbui.popover.PopoverWindow;
import com.facebook.fbui.popover.PopoverWindow.OnDismissListener;
import com.facebook.fbui.popover.PopoverWindow.Position;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import javax.inject.Inject;

/* compiled from: use_out_dev */
public class FollowSwitcherPopupWindow {
    private boolean f786a;
    private View f787b;
    public FbTextView f788c;
    private PopoverWindow f789d;
    public Resources f790e;
    public SwitcherButton f791f;
    public SwitcherButton f792g;
    private SwitcherButton f793h;
    public SwitcherButton f794i;
    public OnChangeListener f795j;

    /* compiled from: use_out_dev */
    public class SwitcherButton {
        View f777a;
        public int f778b;
        public int f779c;
        int f780d;
        int f781e;
        boolean f782f;
        public View f783g;
        public FbTextView f784h;
        public final /* synthetic */ FollowSwitcherPopupWindow f785i;

        public SwitcherButton(final FollowSwitcherPopupWindow followSwitcherPopupWindow, View view, View view2, FbTextView fbTextView, boolean z, int i, int i2, int i3, int i4) {
            this.f785i = followSwitcherPopupWindow;
            this.f777a = view;
            this.f783g = view2;
            this.f784h = fbTextView;
            this.f782f = z;
            this.f778b = i3;
            this.f779c = i4;
            this.f781e = i;
            this.f780d = i2;
            view.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ SwitcherButton f776b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 583517917);
                    this.f776b.m835a();
                    Logger.a(2, EntryType.UI_INPUT_END, 1052606022, a);
                }
            });
        }

        public final void m835a() {
            Object obj;
            if (this.f785i.f791f == this) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj == null) {
                this.f783g.setBackgroundResource(this.f778b);
                this.f784h.setBackgroundResource(2130843304);
                this.f784h.setTextColor(this.f785i.f790e.getColor(2131363016));
                if (this.f785i.f791f != null) {
                    SwitcherButton switcherButton = this.f785i.f791f;
                    switcherButton.f783g.setBackgroundResource(switcherButton.f779c);
                    switcherButton.f784h.setBackgroundResource(17170445);
                    switcherButton.f784h.setTextColor(switcherButton.f785i.f790e.getColor(2131361937));
                }
                this.f785i.f791f = this;
                this.f785i.f788c.setText(this.f780d);
                this.f785i.f788c.sendAccessibilityEvent(2);
                if (this.f785i.f795j != null) {
                    boolean z;
                    OnChangeListener onChangeListener = this.f785i.f795j;
                    FollowSwitcherPopupWindow followSwitcherPopupWindow = this.f785i;
                    if (followSwitcherPopupWindow.f791f != followSwitcherPopupWindow.f794i) {
                        z = true;
                    } else {
                        z = false;
                    }
                    boolean z2 = z;
                    FollowSwitcherPopupWindow followSwitcherPopupWindow2 = this.f785i;
                    onChangeListener.a(z2, followSwitcherPopupWindow2.f791f == followSwitcherPopupWindow2.f792g);
                }
            }
        }
    }

    @Inject
    public FollowSwitcherPopupWindow(@Assisted View view, @Assisted Boolean bool, @Assisted Boolean bool2, @Assisted Boolean bool3, Context context, BottomPopoverWindow bottomPopoverWindow, Boolean bool4) {
        this.f786a = bool4.booleanValue();
        this.f787b = view;
        this.f790e = context.getResources();
        this.f789d = bottomPopoverWindow;
        View frameLayout = new FrameLayout(context);
        View inflate = LayoutInflater.from(context).inflate(2130907044, frameLayout);
        this.f789d.d(frameLayout);
        if (this.f786a) {
            ((LinearLayout) FindViewUtil.b(inflate, 2131567380)).getLayoutParams().width = -2;
        }
        this.f788c = (FbTextView) FindViewUtil.b(inflate, 2131567379);
        this.f794i = new SwitcherButton(this, FindViewUtil.b(inflate, 2131567384), FindViewUtil.b(inflate, 2131567385), (FbTextView) FindViewUtil.b(inflate, 2131567386), false, 2131234903, bool3.booleanValue() ? 2131234911 : 2131234910, 2130837640, 2130837639);
        this.f793h = new SwitcherButton(this, FindViewUtil.b(inflate, 2131567381), FindViewUtil.b(inflate, 2131567382), (FbTextView) FindViewUtil.b(inflate, 2131567383), true, 2131234907, 2131234912, 2130837636, 2130837635);
        this.f792g = new SwitcherButton(this, FindViewUtil.b(inflate, 2131567376), FindViewUtil.b(inflate, 2131567377), (FbTextView) FindViewUtil.b(inflate, 2131567378), true, 2131234906, 2131234914, 2130837638, 2130837637);
        if (bool2.booleanValue()) {
            this.f792g.m835a();
            this.f791f = this.f792g;
        } else if (bool.booleanValue()) {
            this.f793h.m835a();
            this.f791f = this.f793h;
        } else {
            this.f794i.m835a();
            this.f791f = this.f794i;
        }
    }

    public final void m837a(OnDismissListener onDismissListener) {
        this.f789d.H = onDismissListener;
    }

    public final void m836a() {
        if (this.f791f == this.f794i) {
            this.f793h.m835a();
        }
    }

    public final void m838e() {
        if (this.f786a) {
            this.f789d.a(Position.BELOW);
            this.f789d.c(true);
            this.f789d.f(this.f787b);
            return;
        }
        this.f789d.a(this.f787b);
    }
}
