package com.facebook.richdocument.view.widget;

import android.content.Context;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.widget.TextView;
import com.facebook.common.util.ClipboardUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.fbui.popover.PopoverWindow;
import com.facebook.fbui.popover.PopoverWindow.OnDismissListener;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.richdocument.RichDocumentInfo;
import com.facebook.richdocument.logging.RichDocumentAnalyticsLogger;
import com.facebook.richdocument.model.block.entity.BaseEntity;
import com.facebook.richdocument.view.block.BlockViewUtil;
import com.facebook.richdocument.view.widget.RichTextView.InnerRichTextView;
import com.facebook.tools.dextr.runtime.LogUtils;
import javax.inject.Inject;

/* compiled from: open_page_add_product_tap */
public class CopyPasteTouchHandler implements OnTouchListener {
    public final TextView f7142a;
    public final ComposerLauncher f7143b;
    public final RichDocumentInfo f7144c;
    public final RichDocumentAnalyticsLogger f7145d;
    public final BlockViewUtil f7146e;
    public final Context f7147f = this.f7142a.getContext();
    public final BackgroundColorSpan f7148g;
    private final CheckForExtendedLongPress f7149h;
    private final float f7150i;
    private final int f7151j;
    public InstantArticlesTextLongPressWindow f7152k;
    private float f7153l;
    private float f7154m;
    public boolean f7155n;
    public String f7156o;
    public boolean f7157p;
    public boolean f7158q;
    public boolean f7159r;
    private boolean f7160s;

    /* compiled from: open_page_add_product_tap */
    public class C08111 implements OnClickListener {
        final /* synthetic */ CopyPasteTouchHandler f7137a;

        public C08111(CopyPasteTouchHandler copyPasteTouchHandler) {
            this.f7137a = copyPasteTouchHandler;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 456534711);
            this.f7137a.f7159r = true;
            if (!this.f7137a.f7155n) {
                ClipboardUtil.a(this.f7137a.f7147f, this.f7137a.f7142a.getText().toString());
                this.f7137a.f7145d.m5367b("copied_text");
            } else if (this.f7137a.f7156o != null) {
                ClipboardUtil.a(this.f7137a.f7147f, this.f7137a.f7156o);
                this.f7137a.f7145d.m5367b("copied_link");
            }
            this.f7137a.f7152k.l();
            LogUtils.a(-808671628, a);
        }
    }

    /* compiled from: open_page_add_product_tap */
    public class C08122 implements OnClickListener {
        final /* synthetic */ CopyPasteTouchHandler f7138a;

        public C08122(CopyPasteTouchHandler copyPasteTouchHandler) {
            this.f7138a = copyPasteTouchHandler;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 265007367);
            this.f7138a.f7158q = true;
            if (this.f7138a.f7155n) {
                this.f7138a.f7146e.m6923a(this.f7138a.f7147f, this.f7138a.f7143b, null, this.f7138a.f7156o, this.f7138a.f7144c.m5104b(), 1002);
                this.f7138a.f7145d.m5367b("shared_link");
            } else {
                this.f7138a.f7146e.m6926b(this.f7138a.f7147f, this.f7138a.f7143b, this.f7138a.f7142a.getText().toString(), this.f7138a.f7144c.f5115c);
                this.f7138a.f7145d.m5367b("shared_text");
            }
            this.f7138a.f7152k.l();
            LogUtils.a(1894664136, a);
        }
    }

    /* compiled from: open_page_add_product_tap */
    public class C08133 implements OnDismissListener {
        final /* synthetic */ CopyPasteTouchHandler f7139a;

        public C08133(CopyPasteTouchHandler copyPasteTouchHandler) {
            this.f7139a = copyPasteTouchHandler;
        }

        public final boolean m7434a(PopoverWindow popoverWindow) {
            if (this.f7139a.f7155n) {
                ((LinkHighlightMovementMethod) this.f7139a.f7142a.getMovementMethod()).m7490a((Spannable) this.f7139a.f7142a.getText());
            } else {
                CopyPasteTouchHandler copyPasteTouchHandler = this.f7139a;
                SpannableString spannableString = (SpannableString) copyPasteTouchHandler.f7142a.getText();
                spannableString.removeSpan(copyPasteTouchHandler.f7148g);
                copyPasteTouchHandler.f7142a.setText(spannableString);
            }
            if (!(this.f7139a.f7158q || this.f7139a.f7159r)) {
                this.f7139a.f7145d.m5367b("text_selection_dismissed");
            }
            return true;
        }
    }

    /* compiled from: open_page_add_product_tap */
    public class CheckForExtendedLongPress implements Runnable {
        public final /* synthetic */ CopyPasteTouchHandler f7140a;
        public int f7141b;

        public CheckForExtendedLongPress(CopyPasteTouchHandler copyPasteTouchHandler) {
            this.f7140a = copyPasteTouchHandler;
        }

        public void run() {
            this.f7140a.f7157p = false;
            if (!this.f7140a.f7142a.isPressed()) {
                return;
            }
            if (!(this.f7140a.f7142a instanceof InnerRichTextView)) {
                CopyPasteTouchHandler.m7436c(this.f7140a);
            } else if (((InnerRichTextView) this.f7140a.f7142a).getWindowAttachmentCount() == this.f7141b) {
                CopyPasteTouchHandler.m7436c(this.f7140a);
            }
        }
    }

    @Inject
    public CopyPasteTouchHandler(@Assisted TextView textView, ComposerLauncher composerLauncher, RichDocumentInfo richDocumentInfo, RichDocumentAnalyticsLogger richDocumentAnalyticsLogger, BlockViewUtil blockViewUtil) {
        this.f7142a = textView;
        this.f7143b = composerLauncher;
        this.f7144c = richDocumentInfo;
        this.f7145d = richDocumentAnalyticsLogger;
        this.f7146e = blockViewUtil;
        this.f7150i = ((float) ViewConfiguration.get(this.f7147f).getScaledTouchSlop()) / 1.2f;
        this.f7151j = (int) TypedValue.applyDimension(1, 5.0f, this.f7147f.getResources().getDisplayMetrics());
        this.f7148g = new BackgroundColorSpan(this.f7147f.getResources().getColor(2131363475));
        this.f7149h = new CheckForExtendedLongPress(this);
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.f7155n = false;
                this.f7160s = false;
                this.f7156o = null;
                if (this.f7142a.getMovementMethod() instanceof LinkHighlightMovementMethod) {
                    BaseEntity a = LinkHighlightMovementMethod.m7489a(this.f7142a, (Spannable) this.f7142a.getText(), motionEvent);
                    if (a != null) {
                        String B;
                        this.f7155n = true;
                        if (a.f5658a.m6390A() == null || StringUtil.c(a.f5658a.m6390A())) {
                            B = a.f5658a.m6391B();
                        } else {
                            B = a.f5658a.m6390A();
                        }
                        this.f7156o = B;
                    }
                }
                CheckForExtendedLongPress checkForExtendedLongPress = this.f7149h;
                if (checkForExtendedLongPress.f7140a.f7142a instanceof InnerRichTextView) {
                    checkForExtendedLongPress.f7141b = ((InnerRichTextView) checkForExtendedLongPress.f7140a.f7142a).getWindowAttachmentCount();
                }
                this.f7142a.removeCallbacks(this.f7149h);
                this.f7142a.postDelayed(this.f7149h, 700);
                this.f7157p = true;
                this.f7153l = motionEvent.getX();
                this.f7154m = motionEvent.getY();
                break;
            case 1:
                this.f7160s = true;
                if (this.f7157p) {
                    m7435b();
                    break;
                } else if (this.f7155n) {
                    return true;
                }
                break;
            case 2:
                float abs = Math.abs(motionEvent.getX() - this.f7153l);
                float abs2 = Math.abs(motionEvent.getY() - this.f7154m);
                if (abs > this.f7150i || abs2 > this.f7150i) {
                    m7435b();
                    break;
                }
            case 3:
                break;
        }
        if (!this.f7160s) {
            m7435b();
        }
        this.f7142a.removeCallbacks(this.f7149h);
        return false;
    }

    private void m7435b() {
        this.f7142a.removeCallbacks(this.f7149h);
        this.f7157p = false;
        if (this.f7152k != null && this.f7152k.r) {
            this.f7152k.l();
        }
    }

    public static void m7436c(CopyPasteTouchHandler copyPasteTouchHandler) {
        copyPasteTouchHandler.f7152k = new InstantArticlesTextLongPressWindow(copyPasteTouchHandler.f7147f);
        InstantArticlesTextLongPressWindow instantArticlesTextLongPressWindow = copyPasteTouchHandler.f7152k;
        instantArticlesTextLongPressWindow.f7219l.setOnClickListener(new C08111(copyPasteTouchHandler));
        instantArticlesTextLongPressWindow = copyPasteTouchHandler.f7152k;
        instantArticlesTextLongPressWindow.f7220m.setOnClickListener(new C08122(copyPasteTouchHandler));
        copyPasteTouchHandler.f7152k.H = new C08133(copyPasteTouchHandler);
        if (copyPasteTouchHandler.f7155n) {
            copyPasteTouchHandler.f7152k.m7488a(copyPasteTouchHandler.f7147f.getResources().getString(2131237727));
            int totalPaddingTop = (((int) copyPasteTouchHandler.f7154m) - copyPasteTouchHandler.f7142a.getTotalPaddingTop()) + copyPasteTouchHandler.f7142a.getScrollY();
            Layout layout = copyPasteTouchHandler.f7142a.getLayout();
            copyPasteTouchHandler.f7152k.m7486a((int) copyPasteTouchHandler.f7153l, layout.getLineTop(layout.getLineForVertical(totalPaddingTop)) + copyPasteTouchHandler.f7151j, copyPasteTouchHandler.f7155n);
        } else {
            copyPasteTouchHandler.f7152k.m7488a(copyPasteTouchHandler.f7147f.getResources().getString(2131237726));
            copyPasteTouchHandler.f7152k.m7486a((int) copyPasteTouchHandler.f7153l, 0, copyPasteTouchHandler.f7155n);
            SpannableString spannableString = (SpannableString) copyPasteTouchHandler.f7142a.getText();
            spannableString.setSpan(copyPasteTouchHandler.f7148g, 0, spannableString.length(), 33);
            copyPasteTouchHandler.f7142a.setText(spannableString);
        }
        copyPasteTouchHandler.f7152k.c(copyPasteTouchHandler.f7142a);
        copyPasteTouchHandler.f7152k.d();
        copyPasteTouchHandler.f7145d.m5367b("long_pressed_text");
        copyPasteTouchHandler.f7159r = false;
        copyPasteTouchHandler.f7158q = false;
    }
}
