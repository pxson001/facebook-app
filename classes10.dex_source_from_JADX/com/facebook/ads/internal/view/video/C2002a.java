package com.facebook.ads.internal.view.video;

import android.net.Uri;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import com.facebook.ads.internal.adapters.C1900e;
import com.facebook.ads.internal.util.C1991o;
import com.facebook.ads.internal.view.video.support.C2004a;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import java.util.HashMap;
import java.util.Map;

public class C2002a extends FrameLayout {
    private C2004a f14385a;
    private C1900e f14386b;
    private String f14387c;
    private String f14388d;
    public String f14389e;
    public boolean f14390f;
    private boolean f14391g;
    private int f14392h;
    private float f14393i;

    private void m14492c() {
        if (!this.f14391g && this.f14389e != null) {
            Map hashMap = new HashMap();
            hashMap.put("time", Integer.toString(this.f14392h / 1000));
            hashMap.put("inline", "1");
            new C1991o(hashMap).execute(new String[]{this.f14389e});
            this.f14391g = true;
            this.f14392h = 0;
        }
    }

    private void setOnClickListenerInternal(OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
    }

    private void setOnTouchListenerInternal(OnTouchListener onTouchListener) {
        super.setOnTouchListener(onTouchListener);
    }

    public final void m14493a() {
        if (this.f14392h > 0) {
            m14492c();
            this.f14392h = 0;
        }
    }

    public final void m14494b() {
        this.f14387c = null;
    }

    public boolean getAutoplay() {
        return this.f14390f;
    }

    public String getVideoPlayReportURI() {
        return this.f14388d;
    }

    public String getVideoURI() {
        return this.f14387c;
    }

    float getVolume() {
        return this.f14393i;
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 153326052);
        super.onAttachedToWindow();
        this.f14386b.m14236a();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -2024614743, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1958264893);
        super.onDetachedFromWindow();
        m14492c();
        this.f14386b.m14237b();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1779422968, a);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
    }

    public void setVideoPlayReportURI(String str) {
        this.f14388d = str;
    }

    public void setVideoTimeReportURI(String str) {
        m14493a();
        this.f14389e = str;
    }

    public void setVideoURI(String str) {
        this.f14387c = str;
        if (str != null) {
            C2004a c2004a = this.f14385a;
            Uri parse = Uri.parse(str);
            c2004a.f14398d = parse;
            c2004a.f14395a.mo743a(c2004a.f14397c, parse);
            if (this.f14390f) {
                this.f14385a.m14495a();
            }
        }
    }

    void setVolume(float f) {
        this.f14393i = f;
    }
}
