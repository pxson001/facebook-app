package com.facebook.rtc.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v4.view.GestureDetectorCompat;
import android.util.AttributeSet;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.rtc.fbwebrtc.WebrtcUiHandler;
import com.facebook.rtc.snake.fbs.Coordinate;
import com.facebook.rtc.snake.fbs.Snake;
import com.facebook.rtc.snake.fbs.SnakeBoard;
import com.facebook.rtc.snake.fbs.SnakeCommand;
import com.facebook.rtc.snake.fbs.SnakeUpdate;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.google.common.base.Strings;
import com.google.flatbuffers.FlatBufferBuilder;
import java.nio.ByteBuffer;
import java.util.HashMap;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: app_icon_params */
public class RtcSnakeView extends View {
    private static final int[] f20173k = new int[]{-65536, -16776961, -16711936, -65281};
    private GameState f20174a = GameState.NOT_START;
    private ByteBuffer f20175b = null;
    private GestureDetectorCompat f20176c = null;
    private Paint f20177d = new Paint();
    private Paint f20178e = new Paint();
    private Paint f20179f = new Paint();
    private Paint f20180g = new Paint();
    private Paint f20181h = new Paint();
    private Paint f20182i = new Paint();
    private HashMap<Long, Integer> f20183j = new HashMap();
    private Handler f20184l = new Handler();
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<WebrtcUiHandler> f20185m = UltralightRuntime.b;

    /* compiled from: app_icon_params */
    class C23721 extends SimpleOnGestureListener {
        final /* synthetic */ RtcSnakeView f20171a;

        C23721(RtcSnakeView rtcSnakeView) {
            this.f20171a = rtcSnakeView;
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (motionEvent == null || motionEvent2 == null) {
                return false;
            }
            float y = motionEvent2.getY() - motionEvent.getY();
            float x = motionEvent2.getX() - motionEvent.getX();
            if (Math.abs(x) > Math.abs(y)) {
                if (Math.abs(x) > 50.0f && Math.abs(f) > 50.0f) {
                    if (x > 0.0f) {
                        this.f20171a.m19816a((byte) 1);
                        return true;
                    }
                    this.f20171a.m19816a((byte) 0);
                    return true;
                }
            } else if (Math.abs(y) > 50.0f && Math.abs(f2) > 50.0f) {
                if (y > 0.0f) {
                    this.f20171a.m19816a((byte) 3);
                    return true;
                }
                this.f20171a.m19816a((byte) 2);
                return true;
            }
            return false;
        }

        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }
    }

    /* compiled from: app_icon_params */
    class C23732 implements Runnable {
        final /* synthetic */ RtcSnakeView f20172a;

        C23732(RtcSnakeView rtcSnakeView) {
            this.f20172a = rtcSnakeView;
        }

        public void run() {
            RtcSnakeView.m19827c(this.f20172a);
        }
    }

    /* compiled from: app_icon_params */
    enum GameState {
        NOT_START,
        COUNT_DOWN,
        IN_GAME,
        GAME_OVER
    }

    private static <T extends View> void m19824a(Class<T> cls, T t) {
        m19825a((Object) t, t.getContext());
    }

    private static void m19825a(Object obj, Context context) {
        ((RtcSnakeView) obj).f20185m = IdBasedLazy.a(FbInjector.get(context), 10375);
    }

    private void m19821a(com.facebook.inject.Lazy<WebrtcUiHandler> lazy) {
        this.f20185m = lazy;
    }

    public RtcSnakeView(Context context) {
        super(context);
        m19826b();
    }

    public RtcSnakeView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m19826b();
    }

    private void m19826b() {
        m19824a(RtcSnakeView.class, (View) this);
        this.f20176c = new GestureDetectorCompat(getContext(), new C23721(this));
        this.f20176c.a.a(false);
        this.f20177d.setColor(-1);
        this.f20177d.setStyle(Style.STROKE);
        this.f20177d.setStrokeWidth(2.0f);
        this.f20178e.setColor(-7829368);
        this.f20178e.setStrokeWidth(1.0f);
        this.f20179f.setColor(-256);
        this.f20179f.setStyle(Style.FILL);
        this.f20179f.setStrokeWidth(0.0f);
        this.f20180g.setColor(-65536);
        this.f20180g.setStyle(Style.FILL);
        this.f20180g.setStrokeWidth(0.0f);
        this.f20181h.setTypeface(Typeface.DEFAULT_BOLD);
        this.f20181h.setTextAlign(Align.CENTER);
        this.f20181h.setTextSize(96.0f);
        this.f20182i.setTypeface(Typeface.DEFAULT_BOLD);
        this.f20182i.setTextAlign(Align.CENTER);
        this.f20182i.setColor(-1);
        this.f20182i.setTextSize(192.0f);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 1612062010);
        boolean a2 = this.f20176c.a(motionEvent);
        Logger.a(2, EntryType.UI_INPUT_END, -888984704, a);
        return a2;
    }

    public final void m19829a(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            int i;
            this.f20175b = ByteBuffer.wrap(bArr);
            SnakeUpdate a = SnakeUpdate.m19715a(this.f20175b);
            int a2 = a.a(4);
            switch (a2 != 0 ? a.b.get(a2 + a.a) : (byte) 0) {
                case (byte) 0:
                    this.f20174a = GameState.COUNT_DOWN;
                    invalidate();
                    break;
                case (byte) 1:
                    this.f20174a = GameState.IN_GAME;
                    invalidate();
                    break;
                case (byte) 2:
                    this.f20174a = GameState.GAME_OVER;
                    invalidate();
                    HandlerDetour.b(this.f20184l, new C23732(this), 5000, 676255796);
                    break;
            }
            if (this.f20174a == GameState.NOT_START) {
                i = 8;
            } else {
                i = 0;
            }
            setVisibility(i);
        }
    }

    private void m19816a(byte b) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder();
        SnakeCommand.m19712a(flatBufferBuilder);
        SnakeCommand.m19713a(flatBufferBuilder, (byte) 1);
        flatBufferBuilder.a(1, b, 0);
        flatBufferBuilder.c(SnakeCommand.m19714b(flatBufferBuilder));
        ((WebrtcUiHandler) this.f20185m.get()).m19462a(flatBufferBuilder.e());
    }

    protected void onDraw(Canvas canvas) {
        if (this.f20175b != null) {
            SnakeUpdate a = SnakeUpdate.m19715a(this.f20175b);
            if (a != null) {
                SnakeBoard snakeBoard;
                float min = (float) Math.min(canvas.getWidth() - 10, canvas.getHeight() - 10);
                float width = (((float) canvas.getWidth()) - min) / 2.0f;
                float height = (((float) canvas.getHeight()) - min) / 2.0f;
                float f = min / 30.0f;
                m19818a(canvas, width, height, min);
                SnakeBoard snakeBoard2 = new SnakeBoard();
                int a2 = a.a(6);
                if (a2 != 0) {
                    a2 = a.b(a2 + a.a);
                    ByteBuffer byteBuffer = a.b;
                    snakeBoard2.a = a2;
                    snakeBoard2.b = byteBuffer;
                    snakeBoard = snakeBoard2;
                } else {
                    snakeBoard = null;
                }
                SnakeBoard snakeBoard3 = snakeBoard;
                if (snakeBoard3 != null) {
                    m19819a(canvas, width, height, f, f, snakeBoard3);
                }
                int a3;
                if (this.f20174a == GameState.COUNT_DOWN) {
                    short s;
                    a3 = a.a(8);
                    if (a3 != 0) {
                        s = a.b.getShort(a3 + a.a);
                    } else {
                        s = (short) 0;
                    }
                    m19820a(canvas, (int) s);
                } else if (this.f20174a == GameState.GAME_OVER) {
                    a3 = a.a(10);
                    m19817a(canvas, a3 != 0 ? a.b.get(a3 + a.a) : (byte) 0);
                }
            }
        }
    }

    private void m19820a(Canvas canvas, int i) {
        String num;
        if (i > 0) {
            num = Integer.toString(i);
        } else {
            num = getContext().getString(2131232183);
        }
        if (!Strings.isNullOrEmpty(num)) {
            float width = (float) (canvas.getWidth() / 2);
            Rect rect = new Rect();
            this.f20182i.getTextBounds(num, 0, num.length(), rect);
            canvas.drawText(num, width, (float) ((rect.height() + canvas.getHeight()) / 2), this.f20182i);
        }
    }

    private void m19817a(Canvas canvas, byte b) {
        String str = null;
        if (b == (byte) 0) {
            str = getContext().getString(2131232184);
            this.f20181h.setColor(-16711936);
        } else if (b == (byte) 1) {
            str = getContext().getString(2131232185);
            this.f20181h.setColor(-65536);
        } else if (b == (byte) 2) {
            str = getContext().getString(2131232186);
            this.f20181h.setColor(-256);
        }
        if (!Strings.isNullOrEmpty(str)) {
            float width = (float) (canvas.getWidth() / 2);
            Rect rect = new Rect();
            this.f20181h.getTextBounds(str, 0, str.length(), rect);
            canvas.drawText(str, width, (float) ((rect.height() + canvas.getHeight()) / 2), this.f20181h);
        }
    }

    private void m19819a(Canvas canvas, float f, float f2, float f3, float f4, SnakeBoard snakeBoard) {
        Coordinate b = snakeBoard.m19710b();
        if (b != null && b.m19704a() >= (short) 0 && b.m19705b() >= (short) 0) {
            float a = f + (((float) snakeBoard.m19710b().m19704a()) * f3);
            float b2 = f2 + (((float) snakeBoard.m19710b().m19705b()) * f4);
            canvas.drawRect(a, b2, a + f3, b2 + f4, this.f20179f);
        }
        for (int i = 0; i < snakeBoard.m19709a(); i++) {
            Snake f5 = snakeBoard.m19711f(i);
            this.f20180g.setColor(m19815a(f5.m19706a()));
            for (int i2 = 0; i2 < f5.m19707b(); i2++) {
                b = f5.m19708f(i2);
                if (b != null) {
                    a = (((float) b.m19704a()) * f3) + f;
                    b2 = f2 + (((float) b.m19705b()) * f4);
                    canvas.drawRect(a, b2, a + f3, b2 + f4, this.f20180g);
                }
            }
        }
    }

    private void m19818a(Canvas canvas, float f, float f2, float f3) {
        int i = 1;
        float f4 = f3 / 30.0f;
        canvas.drawRect(f, f2, f + f3, f2 + f3, this.f20177d);
        for (int i2 = 1; i2 < 30; i2++) {
            float f5 = f + (((float) i2) * f4);
            canvas.drawLine(f5, f2, f5, f2 + f3, this.f20178e);
        }
        while (i < 30) {
            float f6 = f2 + (((float) i) * f4);
            canvas.drawLine(f, f6, f + f3, f6, this.f20178e);
            i++;
        }
    }

    private int m19815a(long j) {
        if (this.f20183j.containsKey(Long.valueOf(j))) {
            return ((Integer) this.f20183j.get(Long.valueOf(j))).intValue();
        }
        int i = f20173k[this.f20183j.size()];
        this.f20183j.put(Long.valueOf(j), Integer.valueOf(i));
        return i;
    }

    public final void m19828a() {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder();
        SnakeCommand.m19712a(flatBufferBuilder);
        SnakeCommand.m19713a(flatBufferBuilder, (byte) 0);
        flatBufferBuilder.c(SnakeCommand.m19714b(flatBufferBuilder));
        ((WebrtcUiHandler) this.f20185m.get()).m19462a(flatBufferBuilder.e());
    }

    public static void m19827c(RtcSnakeView rtcSnakeView) {
        rtcSnakeView.f20175b = null;
        rtcSnakeView.f20174a = GameState.NOT_START;
        rtcSnakeView.setVisibility(rtcSnakeView.f20174a == GameState.NOT_START ? 8 : 0);
    }
}
