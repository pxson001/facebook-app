package com.facebook.video.player.plugins;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.content.event.FbEvent;
import com.facebook.resources.ui.FbTextView;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.events.RVPVideoSpecUpdateEvent;
import com.facebook.video.player.events.RichVideoPlayerEventSubscriber;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: composer_attach_photo_cancel */
public class DebugConsolePlugin extends RichVideoPlayerPlugin {
    private final FbTextView f19321a;
    public final Map<String, String> f19322b;
    public final Map<String, String> f19323c;

    /* compiled from: composer_attach_photo_cancel */
    class RichVideoPlayerSpecUpdateSubscriber extends RichVideoPlayerEventSubscriber<RVPVideoSpecUpdateEvent> {
        final /* synthetic */ DebugConsolePlugin f19320a;

        public RichVideoPlayerSpecUpdateSubscriber(DebugConsolePlugin debugConsolePlugin) {
            this.f19320a = debugConsolePlugin;
        }

        public final void m28090b(FbEvent fbEvent) {
            RVPVideoSpecUpdateEvent rVPVideoSpecUpdateEvent = (RVPVideoSpecUpdateEvent) fbEvent;
            if (rVPVideoSpecUpdateEvent.a) {
                this.f19320a.f19322b.clear();
            }
            this.f19320a.f19322b.putAll(rVPVideoSpecUpdateEvent.b);
            DebugConsolePlugin.m28092e(this.f19320a);
        }

        public final Class<RVPVideoSpecUpdateEvent> m28089a() {
            return RVPVideoSpecUpdateEvent.class;
        }
    }

    public DebugConsolePlugin(Context context) {
        this(context, null);
    }

    private DebugConsolePlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private DebugConsolePlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f19322b = new HashMap();
        this.f19323c = new HashMap();
        setContentView(2130903864);
        this.f19321a = (FbTextView) a(2131560929);
        this.f.add(new RichVideoPlayerSpecUpdateSubscriber(this));
    }

    protected final void m28093a(RichVideoPlayerParams richVideoPlayerParams, boolean z) {
        if (z) {
            this.f19323c.put("RichVideoPlayer Hash", Integer.toHexString(System.identityHashCode(this.i)));
            m28092e(this);
        }
    }

    protected final void m28094c() {
        this.f19322b.clear();
        this.f19323c.clear();
    }

    public static void m28092e(DebugConsolePlugin debugConsolePlugin) {
        int i;
        List arrayList = new ArrayList();
        m28091a(debugConsolePlugin.f19322b, arrayList);
        m28091a(debugConsolePlugin.f19323c, arrayList);
        FbTextView fbTextView = debugConsolePlugin.f19321a;
        if (arrayList.isEmpty()) {
            i = 8;
        } else {
            i = 0;
        }
        fbTextView.setVisibility(i);
        debugConsolePlugin.f19321a.setText(StringUtil.b("\n", new Object[]{arrayList}));
    }

    private static void m28091a(Map<String, String> map, List<String> list) {
        for (String str : map.keySet()) {
            list.add(StringFormatUtil.a("%s=%s", new Object[]{str, map.get(str)}));
        }
    }
}
