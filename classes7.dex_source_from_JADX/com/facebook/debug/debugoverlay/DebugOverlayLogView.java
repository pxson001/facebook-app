package com.facebook.debug.debugoverlay;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.widget.TextView;
import com.facebook.inject.FbInjector;
import com.google.common.collect.Lists;
import java.util.List;

/* compiled from: sync_delta_passed_over */
public class DebugOverlayLogView extends TextView {
    private final List<LogMessageAndTag> f2580a;

    /* compiled from: sync_delta_passed_over */
    final class LogMessageAndTag {
        public final String f2578a;
        public final DebugOverlayTag f2579b;

        LogMessageAndTag(String str, DebugOverlayTag debugOverlayTag) {
            this.f2578a = str;
            this.f2579b = debugOverlayTag;
        }
    }

    public DebugOverlayLogView(Context context) {
        this(context, null);
    }

    private DebugOverlayLogView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2580a = Lists.a();
        Class cls = DebugOverlayLogView.class;
        FbInjector.get(getContext());
        setShadowLayer(2.0f, 0.0f, 1.0f, 2131361847);
    }

    final void m2969a(DebugOverlayTag debugOverlayTag, String str) {
        this.f2580a.add(new LogMessageAndTag(str, debugOverlayTag));
        if (this.f2580a.size() > 20) {
            this.f2580a.remove(0);
        }
        m2967b();
    }

    final void m2968a() {
        this.f2580a.clear();
        m2967b();
    }

    private void m2967b() {
        CharSequence spannableStringBuilder = new SpannableStringBuilder();
        for (LogMessageAndTag logMessageAndTag : this.f2580a) {
            spannableStringBuilder.append(logMessageAndTag.f2578a);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(logMessageAndTag.f2579b.f2584c), spannableStringBuilder.length() - logMessageAndTag.f2578a.length(), spannableStringBuilder.length(), 33);
            spannableStringBuilder.append("\n");
        }
        if (spannableStringBuilder.length() == 0) {
            spannableStringBuilder.append(' ');
        }
        setText(spannableStringBuilder);
    }
}
