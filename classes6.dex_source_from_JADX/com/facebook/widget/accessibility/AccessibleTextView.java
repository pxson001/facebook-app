package com.facebook.widget.accessibility;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityManagerCompat;
import android.text.Layout;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.accessibility.AccessibilityManager;
import com.facebook.fbui.menu.PopoverMenu;
import com.facebook.fig.menu.FigPopoverMenuWindow;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: custom_properties[moments_video_uuid] */
public class AccessibleTextView extends FbTextView implements ClickableSpanAccessibilityDelegator {
    private final TextViewAccessibilityDelegate<AccessibleTextView> f18151a;
    private AccessibilityManager f18152b;

    public AccessibleTextView(Context context) {
        this(context, null);
    }

    public AccessibleTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AccessibleTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f18151a = new TextViewAccessibilityDelegate(this);
        ViewCompat.a(this, this.f18151a);
        this.f18152b = (AccessibilityManager) getContext().getSystemService("accessibility");
    }

    @VisibleForTesting
    private void m26702a() {
        final FigPopoverMenuWindow figPopoverMenuWindow = new FigPopoverMenuWindow(getContext());
        PopoverMenu c = figPopoverMenuWindow.c();
        final ClickableSpan[] f = this.f18151a.m28512f();
        for (int i = 0; i < f.length; i++) {
            TextViewAccessibilityDelegate textViewAccessibilityDelegate = this.f18151a;
            String str = null;
            if (i + 1 < textViewAccessibilityDelegate.c().size()) {
                ClickableSpanAccessibilityDelegate$AccessibleText b = textViewAccessibilityDelegate.b(i + 1);
                if (b != null) {
                    str = b.f19785a;
                }
            }
            c.a(str).setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                final /* synthetic */ AccessibleTextView f19782c;

                public boolean onMenuItemClick(MenuItem menuItem) {
                    f[i].onClick(this.f19782c);
                    return true;
                }
            });
        }
        c.a(2131230727).setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
            final /* synthetic */ AccessibleTextView f19784b;

            public boolean onMenuItemClick(MenuItem menuItem) {
                figPopoverMenuWindow.l();
                return true;
            }
        });
        figPopoverMenuWindow.f(this);
    }

    private void m26703b() {
        Object obj;
        if (this.f18151a.m28512f().length == 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            obj = 1;
            if (this.f18151a.m28512f().length != 1) {
                obj = null;
            }
            if (obj == null || this.f18151a.m28511c(0) == null) {
                m26702a();
            } else {
                this.f18151a.m28511c(0).onClick(this);
            }
        }
    }

    public float getTextSize() {
        Layout layout = getLayout();
        if (layout == null) {
            return 0.0f;
        }
        float textSize = layout.getPaint().getTextSize();
        Preconditions.checkArgument(textSize > 0.0f);
        return textSize;
    }

    public boolean performAccessibilityAction(int i, Bundle bundle) {
        if (i != 16) {
            return super.performAccessibilityAction(i, bundle);
        }
        m26703b();
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -959409302);
        if (getLayout() == null) {
            Logger.a(2, EntryType.UI_INPUT_END, 414144076, a);
            return false;
        } else if (AccessibilityManagerCompat.b(this.f18152b)) {
            if (motionEvent.getAction() != 1) {
                m26703b();
            }
            LogUtils.a(-1080719715, a);
            return true;
        } else {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            LogUtils.a(930936789, a);
            return onTouchEvent;
        }
    }
}
