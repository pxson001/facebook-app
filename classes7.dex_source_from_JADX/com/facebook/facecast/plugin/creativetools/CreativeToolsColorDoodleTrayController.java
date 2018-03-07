package com.facebook.facecast.plugin.creativetools;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnTouchListener;
import com.facebook.facecast.FacecastPreviewView;
import com.facebook.facecast.PreviewRenderer;
import com.facebook.videocodec.effects.renderers.DoodleEvent;
import com.facebook.videocodec.effects.renderers.DoodleEvent.Type;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: bcf221e9060d72b9d738d7ee03399f1c */
public class CreativeToolsColorDoodleTrayController implements CreativeToolsTrayController {
    private final View f18691a;
    public final CreativeToolsColorDoodleHoneycombView f18692b;
    private final View f18693c;
    private final View f18694d;
    private final View f18695e;
    private final OnTouchListener f18696f;
    @Nullable
    public PreviewRenderer f18697g;
    private final int f18698h = -16711936;

    /* compiled from: bcf221e9060d72b9d738d7ee03399f1c */
    public class OnTouchListenerHelper implements OnTouchListener {
        final /* synthetic */ CreativeToolsColorDoodleTrayController f18688a;
        public int f18689b = -1;
        public DoodleEvent f18690c = null;

        public OnTouchListenerHelper(CreativeToolsColorDoodleTrayController creativeToolsColorDoodleTrayController) {
            this.f18688a = creativeToolsColorDoodleTrayController;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTouch(android.view.View r11, android.view.MotionEvent r12) {
            /*
            r10 = this;
            r9 = -1;
            r0 = 1;
            r1 = 0;
            r2 = r10.f18688a;
            r2 = r2.f18697g;
            if (r2 != 0) goto L_0x000a;
        L_0x0009:
            return r1;
        L_0x000a:
            r2 = android.support.v4.view.MotionEventCompat.a(r12);
            r4 = new java.util.ArrayList;
            r4.<init>();
            switch(r2) {
                case 0: goto L_0x0057;
                case 1: goto L_0x005e;
                case 2: goto L_0x0072;
                case 3: goto L_0x005e;
                case 4: goto L_0x0016;
                case 5: goto L_0x0016;
                case 6: goto L_0x0062;
                default: goto L_0x0016;
            };
        L_0x0016:
            r2 = r1;
            r0 = r1;
            r3 = r1;
        L_0x0019:
            if (r0 == 0) goto L_0x003a;
        L_0x001b:
            r0 = android.support.v4.view.MotionEventCompat.b(r12, r1);
            r10.f18689b = r0;
            r0 = new com.facebook.videocodec.effects.renderers.DoodleEvent;
            r5 = com.facebook.videocodec.effects.renderers.DoodleEvent.Type.START;
            r6 = r12.getX();
            r7 = r12.getY();
            r8 = -16711936; // 0xffffffffff00ff00 float:-1.7146522E38 double:NaN;
            r0.<init>(r5, r6, r7, r8);
            r10.f18690c = r0;
            r0 = r10.f18690c;
            r4.add(r0);
        L_0x003a:
            if (r3 == 0) goto L_0x0085;
        L_0x003c:
            r0 = r10.f18689b;
            r3 = android.support.v4.view.MotionEventCompat.a(r12, r0);
            r5 = r12.getHistorySize();
            r0 = r1;
        L_0x0047:
            if (r0 >= r5) goto L_0x007a;
        L_0x0049:
            r6 = r12.getHistoricalX(r3, r0);
            r7 = r12.getHistoricalY(r3, r0);
            r10.m22270a(r4, r6, r7);
            r0 = r0 + 1;
            goto L_0x0047;
        L_0x0057:
            r2 = r10.f18689b;
            if (r2 != r9) goto L_0x0016;
        L_0x005b:
            r2 = r1;
            r3 = r1;
            goto L_0x0019;
        L_0x005e:
            r2 = r0;
            r3 = r1;
            r0 = r1;
            goto L_0x0019;
        L_0x0062:
            r2 = android.support.v4.view.MotionEventCompat.b(r12);
            r2 = android.support.v4.view.MotionEventCompat.b(r12, r2);
            r3 = r10.f18689b;
            if (r2 != r3) goto L_0x0016;
        L_0x006e:
            r2 = r0;
            r3 = r1;
            r0 = r1;
            goto L_0x0019;
        L_0x0072:
            r2 = r10.f18689b;
            if (r2 == r9) goto L_0x0016;
        L_0x0076:
            r2 = r1;
            r3 = r0;
            r0 = r1;
            goto L_0x0019;
        L_0x007a:
            r0 = android.support.v4.view.MotionEventCompat.c(r12, r3);
            r3 = android.support.v4.view.MotionEventCompat.d(r12, r3);
            r10.m22270a(r4, r0, r3);
        L_0x0085:
            if (r2 == 0) goto L_0x0096;
        L_0x0087:
            r10.f18689b = r9;
            r0 = 0;
            r10.f18690c = r0;
            r0 = new com.facebook.videocodec.effects.renderers.DoodleEvent;
            r2 = com.facebook.videocodec.effects.renderers.DoodleEvent.Type.END;
            r0.<init>(r2);
            r4.add(r0);
        L_0x0096:
            r0 = r4.isEmpty();
            if (r0 != 0) goto L_0x0009;
        L_0x009c:
            r0 = r10.f18688a;
            r0 = r0.f18697g;
            r0.m21925a(r4);
            goto L_0x0009;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.facecast.plugin.creativetools.CreativeToolsColorDoodleTrayController.OnTouchListenerHelper.onTouch(android.view.View, android.view.MotionEvent):boolean");
        }

        private void m22270a(List<DoodleEvent> list, float f, float f2) {
            Object obj = 1;
            if (this.f18690c != null) {
                if (Math.abs(this.f18690c.f15805b - f) + Math.abs(this.f18690c.f15806c - f2) < 10.0f) {
                    obj = null;
                }
            }
            if (obj != null) {
                this.f18690c = new DoodleEvent(Type.MOVE, f, f2, -16711936);
                list.add(this.f18690c);
            }
        }
    }

    public CreativeToolsColorDoodleTrayController(Context context) {
        LayoutInflater from = LayoutInflater.from(context);
        this.f18691a = from.inflate(2130904197, null);
        this.f18692b = (CreativeToolsColorDoodleHoneycombView) this.f18691a.findViewById(2131561624);
        this.f18693c = from.inflate(2130904196, null);
        this.f18694d = this.f18693c.findViewById(2131561622);
        this.f18695e = this.f18693c.findViewById(2131561623);
        this.f18696f = new OnTouchListenerHelper(this);
    }

    public final void mo1430a(FacecastPreviewView facecastPreviewView) {
        facecastPreviewView.m21876a(this.f18696f);
        List arrayList = new ArrayList();
        arrayList.add(new DoodleEvent(Type.VIEW_INIT, (float) facecastPreviewView.getWidth(), (float) facecastPreviewView.getHeight()));
        if (this.f18697g != null) {
            this.f18697g.m21925a(arrayList);
        }
    }

    public final void mo1433b(FacecastPreviewView facecastPreviewView) {
        facecastPreviewView.m21877b(this.f18696f);
        OnTouchListenerHelper onTouchListenerHelper = (OnTouchListenerHelper) this.f18696f;
        onTouchListenerHelper.f18689b = -1;
        onTouchListenerHelper.f18690c = null;
    }

    public final View mo1432b() {
        return this.f18691a;
    }

    public final View mo1434c() {
        return this.f18693c;
    }
}
