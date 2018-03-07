package com.facebook.timeline.aboutpage.util;

import android.content.Context;
import android.text.Layout;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import javax.inject.Singleton;

@Singleton
/* compiled from: Ljava/util/concurrent/ScheduledFuture */
public class ItemLinkMovementMethod extends LinkMovementMethod {
    private static volatile ItemLinkMovementMethod f13668b;
    private BackgroundColorSpan f13669a;

    public static com.facebook.timeline.aboutpage.util.ItemLinkMovementMethod m14862a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003a in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f13668b;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.timeline.aboutpage.util.ItemLinkMovementMethod.class;
        monitor-enter(r1);
        r0 = f13668b;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x0039 }
        r3 = r2.b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m14861a();	 Catch:{ all -> 0x0034 }
        f13668b = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f13668b;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.aboutpage.util.ItemLinkMovementMethod.a(com.facebook.inject.InjectorLike):com.facebook.timeline.aboutpage.util.ItemLinkMovementMethod");
    }

    private static ItemLinkMovementMethod m14861a() {
        return new ItemLinkMovementMethod();
    }

    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        Spannable spannable2 = (Spannable) textView.getText();
        ClickableSpan b = m14865b(textView, motionEvent);
        boolean z = b != null;
        int action = motionEvent.getAction();
        if (m14864a(z, action)) {
            switch (action) {
                case 0:
                    m14863a(spannable2, textView.getContext());
                    spannable2.setSpan(m14860a(textView.getContext()), spannable2.getSpanStart(b), spannable2.getSpanEnd(b), 33);
                    break;
                case 1:
                    b.onClick(textView);
                    break;
                case 2:
                case 3:
                    break;
            }
            m14863a(spannable2, textView.getContext());
        } else if (textView.getTag() != null) {
            ((View) textView.getTag()).onTouchEvent(motionEvent);
        }
        return true;
    }

    private ClickableSpan m14865b(TextView textView, MotionEvent motionEvent) {
        int x = (((int) motionEvent.getX()) - textView.getTotalPaddingLeft()) + textView.getScrollX();
        int y = (((int) motionEvent.getY()) - textView.getTotalPaddingTop()) + textView.getScrollY();
        Layout layout = textView.getLayout();
        y = layout.getLineForVertical(y);
        if (layout.getLineRight(y) < ((float) x)) {
            x = -1;
        } else {
            x = layout.getOffsetForHorizontal(y, (float) x);
        }
        int i = x;
        ClickableSpan[] clickableSpanArr = (ClickableSpan[]) ((Spannable) textView.getText()).getSpans(i, i, ClickableSpan.class);
        return clickableSpanArr.length > 0 ? clickableSpanArr[0] : null;
    }

    private void m14863a(Spannable spannable, Context context) {
        spannable.removeSpan(m14860a(context));
    }

    private static boolean m14864a(boolean z, int i) {
        if (i == 3) {
            return true;
        }
        if (i == 2) {
            return !z;
        } else {
            return z;
        }
    }

    private BackgroundColorSpan m14860a(Context context) {
        if (this.f13669a == null) {
            this.f13669a = new BackgroundColorSpan(context.getResources().getColor(2131363014));
        }
        return this.f13669a;
    }
}
