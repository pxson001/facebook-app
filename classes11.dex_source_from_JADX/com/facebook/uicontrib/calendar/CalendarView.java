package com.facebook.uicontrib.calendar;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.facebook.R;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

@TargetApi(11)
/* compiled from: nearbyMapAreaFragment */
public class CalendarView extends FrameLayout {
    private static final String f5206a = CalendarView.class.getSimpleName();
    public WeeksAdapter f5207A;
    public ListView f5208B;
    private TextView f5209C;
    private ViewGroup f5210D;
    private ImageView f5211E;
    private String[] f5212F;
    private String[] f5213G;
    public int f5214H;
    private int f5215I;
    private long f5216J;
    public boolean f5217K;
    public int f5218L;
    public int f5219M;
    public OnDateChangeListener f5220N;
    private ScrollStateRunnable f5221O;
    public TimeSensitivity f5222P;
    public Calendar f5223Q;
    private Calendar f5224R;
    public Calendar f5225S;
    public Calendar f5226T;
    private final DateFormat f5227U;
    private Locale f5228V;
    public boolean f5229W;
    public long aa;
    public Calendar ab;
    public int ac;
    private DateFormatSymbols f5230b;
    public final int f5231c;
    public final int f5232d;
    public int f5233e;
    public Drawable f5234f;
    public Drawable f5235g;
    public int f5236h;
    public int f5237i;
    public int f5238j;
    public int f5239k;
    public boolean f5240l;
    public int f5241m;
    public int f5242n;
    private int f5243o;
    private int f5244p;
    private int f5245q;
    public int f5246r;
    public int f5247s;
    private int f5248t;
    private int f5249u;
    public int f5250v;
    public boolean f5251w;
    public int f5252x;
    private float f5253y;
    private float f5254z;

    /* compiled from: nearbyMapAreaFragment */
    class C06831 extends DataSetObserver {
        final /* synthetic */ CalendarView f5165a;

        C06831(CalendarView calendarView) {
            this.f5165a = calendarView;
        }

        public void onChanged() {
            if (this.f5165a.f5220N != null) {
                this.f5165a.f5220N.a(this.f5165a.f5207A.f5199b, this.f5165a.f5207A.f5200c);
            }
        }
    }

    /* compiled from: nearbyMapAreaFragment */
    class C06842 implements OnScrollListener {
        final /* synthetic */ CalendarView f5166a;

        C06842(CalendarView calendarView) {
            this.f5166a = calendarView;
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
            this.f5166a.m6465a(absListView, i);
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            this.f5166a.m6464a(absListView);
        }
    }

    /* compiled from: nearbyMapAreaFragment */
    class ScrollStateRunnable implements Runnable {
        final /* synthetic */ CalendarView f5168a;
        private AbsListView f5169b;
        private int f5170c;

        public ScrollStateRunnable(CalendarView calendarView) {
            this.f5168a = calendarView;
        }

        public final void m6419a(AbsListView absListView, int i) {
            this.f5169b = absListView;
            this.f5170c = i;
            this.f5168a.removeCallbacks(this);
            this.f5168a.postDelayed(this, 40);
        }

        public void run() {
            this.f5168a.f5219M = this.f5170c;
            if (this.f5170c == 0 && this.f5168a.f5218L != 0) {
                View childAt = this.f5169b.getChildAt(0);
                if (childAt != null) {
                    int bottom = childAt.getBottom() - this.f5168a.f5247s;
                    if (bottom > this.f5168a.f5247s) {
                        if (this.f5168a.f5217K) {
                            this.f5169b.smoothScrollBy(bottom - childAt.getHeight(), 500);
                        } else {
                            this.f5169b.smoothScrollBy(bottom, 500);
                        }
                    }
                } else {
                    return;
                }
            }
            this.f5168a.f5218L = this.f5170c;
        }
    }

    /* compiled from: nearbyMapAreaFragment */
    public enum TimeSensitivity {
        MILLISECONDS,
        SECONDS,
        MINUTES,
        HOUR
    }

    /* compiled from: nearbyMapAreaFragment */
    public class WeekView extends View {
        final /* synthetic */ CalendarView f5171a;
        private final Rect f5172b = new Rect();
        private final Paint f5173c = new Paint();
        private final Paint f5174d = new Paint();
        private String[] f5175e;
        private boolean[] f5176f;
        public boolean f5177g;
        public boolean f5178h;
        public Calendar f5179i;
        public int f5180j = -1;
        public int f5181k = -1;
        private int f5182l = -1;
        private int f5183m;
        private int f5184n;
        public boolean f5185o;
        public boolean f5186p;
        private boolean f5187q;
        private int f5188r = -1;
        private int f5189s = -1;
        private int f5190t = -1;
        private int f5191u = -1;
        private int f5192v;
        private int f5193w = -1;
        private int f5194x = -1;
        private int f5195y = -1;
        private int f5196z = -1;

        public WeekView(CalendarView calendarView, Context context) {
            this.f5171a = calendarView;
            super(context);
            m6427d();
        }

        public final void m6433a(int i, boolean z, int i2, int i3, int i4) {
            int i5;
            int i6;
            this.f5188r = i2;
            this.f5189s = i3;
            this.f5185o = this.f5188r != -1;
            this.f5186p = this.f5189s != -1;
            this.f5187q = z;
            if (this.f5171a.f5251w) {
                i5 = this.f5171a.f5252x + 1;
            } else {
                i5 = this.f5171a.f5252x;
            }
            this.f5192v = i5;
            this.f5182l = i;
            this.f5171a.f5223Q.setTimeInMillis(this.f5171a.f5225S.getTimeInMillis());
            this.f5171a.f5223Q.add(3, this.f5182l);
            this.f5171a.f5223Q.setFirstDayOfWeek(this.f5171a.f5214H);
            this.f5175e = new String[this.f5192v];
            this.f5176f = new boolean[this.f5192v];
            if (this.f5171a.f5251w) {
                this.f5175e[0] = String.format(Locale.getDefault(), "%d", new Object[]{Integer.valueOf(this.f5171a.f5223Q.get(3))});
                i6 = 1;
            } else {
                i6 = 0;
            }
            this.f5171a.f5223Q.add(5, this.f5171a.f5214H - this.f5171a.f5223Q.get(7));
            this.f5179i = (Calendar) this.f5171a.f5223Q.clone();
            this.f5180j = this.f5171a.f5223Q.get(2);
            this.f5178h = true;
            for (i6 = 
/*
Method generation error in method: com.facebook.uicontrib.calendar.CalendarView.WeekView.a(int, boolean, int, int, int):void
jadx.core.utils.exceptions.CodegenException: Error generate insn: PHI: (r1_11 'i6' int) = (r1_10 'i6' int), (r1_18 'i6' int) binds: {(r1_10 'i6' int)=B:11:0x005d, (r1_18 'i6' int)=B:38:0x0156} in method: com.facebook.uicontrib.calendar.CalendarView.WeekView.a(int, boolean, int, int, int):void
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:226)
	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:184)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:61)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:183)
	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:328)
	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:265)
	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:228)
	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:118)
	at jadx.core.codegen.ClassGen.addInnerClasses(ClassGen.java:241)
	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:118)
	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:83)
	at jadx.core.codegen.CodeGen.visit(CodeGen.java:19)
	at jadx.core.ProcessClass.process(ProcessClass.java:43)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: jadx.core.utils.exceptions.CodegenException: PHI can be used only in fallback mode
	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:530)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:514)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
	... 18 more

*/

            private void m6427d() {
                this.f5173c.setFakeBoldText(false);
                this.f5173c.setAntiAlias(true);
                this.f5173c.setStyle(Style.FILL);
                this.f5174d.setFakeBoldText(true);
                this.f5174d.setAntiAlias(true);
                this.f5174d.setStyle(Style.FILL);
                this.f5174d.setTextAlign(Align.CENTER);
                this.f5174d.setTextSize((float) this.f5171a.f5233e);
            }

            public final int m6432a() {
                return this.f5180j;
            }

            public final int m6435b() {
                return this.f5181k;
            }

            public final Calendar m6436c() {
                return this.f5179i;
            }

            public final boolean m6434a(float f, Calendar calendar) {
                int i;
                int i2;
                boolean h = this.f5171a.f5214H;
                if (h) {
                    i = this.f5171a.f5251w ? this.f5183m - (this.f5183m / this.f5192v) : this.f5183m;
                    i2 = 0;
                } else {
                    if (this.f5171a.f5251w) {
                        i = this.f5183m / this.f5192v;
                    } else {
                        i = 0;
                    }
                    i2 = i;
                    i = this.f5183m;
                }
                if (f < ((float) i2) || f > ((float) i)) {
                    calendar.clear();
                    return false;
                }
                i = (int) (((f - ((float) i2)) * ((float) this.f5171a.f5252x)) / ((float) (i - i2)));
                if (h) {
                    i = (this.f5171a.f5252x - 1) - i;
                }
                calendar.setTimeInMillis(this.f5179i.getTimeInMillis());
                calendar.add(5, i);
                return true;
            }

            protected void onDraw(Canvas canvas) {
                m6420a(canvas);
                m6428d(canvas);
                m6423b(canvas);
                if (this.f5171a.f5240l) {
                    m6425c(canvas);
                }
            }

            private void m6420a(Canvas canvas) {
                int i = 0;
                if (this.f5187q) {
                    this.f5173c.setColor(this.f5171a.f5236h);
                    this.f5172b.top = ((this.f5184n - this.f5171a.ac) + (this.f5171a.f5231c / 2)) / 2;
                    this.f5172b.bottom = ((this.f5184n + this.f5171a.ac) + (this.f5171a.f5231c / 2)) / 2;
                    boolean h = this.f5171a.f5214H;
                    int i2 = (this.f5183m / this.f5192v) / 2;
                    if (this.f5185o && this.f5186p) {
                        this.f5172b.left = this.f5193w + i2;
                        this.f5172b.right = this.f5196z - i2;
                    } else if (this.f5185o) {
                        if (h) {
                            this.f5172b.left = this.f5193w + i2;
                            this.f5172b.right = this.f5171a.f5251w ? this.f5183m - (this.f5183m / this.f5192v) : this.f5183m;
                        } else {
                            this.f5172b.left = this.f5193w + i2;
                            this.f5172b.right = this.f5183m;
                        }
                        canvas.drawRect(this.f5172b, this.f5173c);
                        return;
                    } else if (this.f5186p) {
                        Rect rect;
                        int i3;
                        if (h) {
                            r0 = this.f5172b;
                        } else {
                            r0 = this.f5172b;
                            if (this.f5171a.f5251w) {
                                rect = r0;
                                i3 = this.f5183m / this.f5192v;
                                rect.left = i3;
                                this.f5172b.right = this.f5195y + i2;
                                canvas.drawRect(this.f5172b, this.f5173c);
                                return;
                            }
                        }
                        rect = r0;
                        i3 = 0;
                        rect.left = i3;
                        this.f5172b.right = this.f5195y + i2;
                        canvas.drawRect(this.f5172b, this.f5173c);
                        return;
                    } else if (h) {
                        this.f5172b.left = 0;
                        this.f5172b.right = this.f5171a.f5251w ? this.f5183m - (this.f5183m / this.f5192v) : this.f5183m;
                    } else {
                        r0 = this.f5172b;
                        if (this.f5171a.f5251w) {
                            i = this.f5183m / this.f5192v;
                        }
                        r0.left = i;
                        this.f5172b.right = this.f5183m;
                    }
                    canvas.drawRect(this.f5172b, this.f5173c);
                }
            }

            private void m6423b(Canvas canvas) {
                int i = 0;
                int textSize = (((int) ((this.f5173c.getTextSize() + ((float) this.f5184n)) / 2.0f)) - this.f5171a.f5231c) - this.f5171a.f5246r;
                int i2 = this.f5192v;
                int i3 = i2 * 2;
                this.f5173c.setTextAlign(Align.CENTER);
                this.f5173c.setTextSize((float) this.f5171a.f5233e);
                if (this.f5171a.f5214H) {
                    for (int i4 = 0; i4 < i2 - 1; i4++) {
                        this.f5174d.setColor(this.f5176f[i4] ? this.f5171a.f5238j : this.f5171a.f5239k);
                        int i5 = (((i4 * 2) + 1) * this.f5183m) / i3;
                        if (m6421a(i4)) {
                            this.f5174d.setColor(this.f5171a.f5237i);
                        }
                        canvas.drawText(this.f5175e[(i2 - 1) - i4], (float) i5, (float) textSize, this.f5174d);
                    }
                    if (this.f5171a.f5251w) {
                        this.f5173c.setColor(this.f5171a.f5242n);
                        canvas.drawText(this.f5175e[0], (float) (this.f5183m - (this.f5183m / i3)), (float) textSize, this.f5173c);
                        return;
                    }
                    return;
                }
                if (this.f5171a.f5251w) {
                    this.f5173c.setColor(this.f5171a.f5242n);
                    canvas.drawText(this.f5175e[0], (float) (this.f5183m / i3), (float) textSize, this.f5173c);
                    i = 1;
                }
                while (i < i2) {
                    this.f5174d.setColor(this.f5176f[i] ? this.f5171a.f5238j : this.f5171a.f5239k);
                    i5 = (((i * 2) + 1) * this.f5183m) / i3;
                    if (m6421a(i)) {
                        this.f5174d.setColor(this.f5171a.f5237i);
                    }
                    canvas.drawText(this.f5175e[i], (float) i5, (float) textSize, this.f5174d);
                    i++;
                }
            }

            private boolean m6421a(int i) {
                if (this.f5171a.f5229W) {
                    if (this.f5186p && i == this.f5191u) {
                        return true;
                    }
                    return false;
                } else if (this.f5185o && i == this.f5190t) {
                    return true;
                } else {
                    return false;
                }
            }

            private void m6425c(Canvas canvas) {
                int firstVisiblePosition = this.f5171a.f5208B.getFirstVisiblePosition();
                if (this.f5171a.f5208B.getChildAt(0).getTop() < 0) {
                    firstVisiblePosition++;
                }
                if (firstVisiblePosition != this.f5182l) {
                    float f;
                    float f2;
                    this.f5173c.setColor(this.f5171a.f5241m);
                    this.f5173c.setStrokeWidth((float) this.f5171a.f5231c);
                    if (this.f5171a.f5214H) {
                        f = this.f5171a.f5251w ? (float) (this.f5183m - (this.f5183m / this.f5192v)) : (float) this.f5183m;
                        f2 = 0.0f;
                    } else {
                        float f3;
                        if (this.f5171a.f5251w) {
                            f3 = (float) (this.f5183m / this.f5192v);
                        } else {
                            f3 = 0.0f;
                        }
                        f = (float) this.f5183m;
                        f2 = f3;
                    }
                    canvas.drawLine(f2, 0.0f, f, 0.0f, this.f5173c);
                }
            }

            private void m6428d(Canvas canvas) {
                if (this.f5186p || this.f5185o) {
                    int i;
                    if (this.f5186p) {
                        i = this.f5196z - this.f5195y;
                        if (this.f5171a.f5229W) {
                            this.f5171a.f5234f.setBounds(this.f5195y + ((i - this.f5171a.ac) / 2), ((this.f5184n - this.f5171a.ac) + (this.f5171a.f5231c / 2)) / 2, this.f5196z - ((i - this.f5171a.ac) / 2), ((this.f5184n + this.f5171a.ac) + (this.f5171a.f5231c / 2)) / 2);
                            this.f5171a.f5234f.draw(canvas);
                        } else {
                            this.f5171a.f5235g.setBounds(this.f5195y + ((i - this.f5171a.ac) / 2), ((this.f5184n - this.f5171a.ac) + (this.f5171a.f5231c / 2)) / 2, this.f5196z - ((i - this.f5171a.ac) / 2), ((this.f5184n + this.f5171a.ac) + (this.f5171a.f5231c / 2)) / 2);
                            this.f5171a.f5235g.draw(canvas);
                        }
                    }
                    if (this.f5185o) {
                        i = this.f5194x - this.f5193w;
                        if (!this.f5171a.f5229W || m6430e()) {
                            this.f5171a.f5234f.setBounds(this.f5193w + ((i - this.f5171a.ac) / 2), ((this.f5184n - this.f5171a.ac) + (this.f5171a.f5231c / 2)) / 2, this.f5194x - ((i - this.f5171a.ac) / 2), ((this.f5184n + this.f5171a.ac) + (this.f5171a.f5231c / 2)) / 2);
                            this.f5171a.f5234f.draw(canvas);
                            return;
                        }
                        this.f5171a.f5235g.setBounds(this.f5193w + ((i - this.f5171a.ac) / 2), ((this.f5184n - this.f5171a.ac) + (this.f5171a.f5231c / 2)) / 2, this.f5194x - ((i - this.f5171a.ac) / 2), ((this.f5184n + this.f5171a.ac) + (this.f5171a.f5231c / 2)) / 2);
                        this.f5171a.f5235g.draw(canvas);
                    }
                }
            }

            private boolean m6430e() {
                return this.f5188r > 0 && this.f5188r == this.f5189s;
            }

            protected void onSizeChanged(int i, int i2, int i3, int i4) {
                int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 827324876);
                this.f5183m = i;
                m6431f();
                Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -59973982, a);
            }

            private void m6431f() {
                int i;
                boolean h = this.f5171a.f5214H;
                if (this.f5185o) {
                    i = this.f5188r - this.f5171a.f5214H;
                    if (i < 0) {
                        i += 7;
                    }
                    if (this.f5171a.f5251w && !h) {
                        i++;
                    }
                    if (h) {
                        this.f5190t = (this.f5171a.f5252x - 1) - i;
                        this.f5193w = (this.f5190t * this.f5183m) / this.f5192v;
                    } else {
                        this.f5190t = i;
                        this.f5193w = (this.f5190t * this.f5183m) / this.f5192v;
                    }
                    this.f5194x = this.f5193w + (this.f5183m / this.f5192v);
                    i = this.f5194x - this.f5193w;
                    int min = Math.min(this.f5184n - this.f5171a.f5231c, this.f5171a.f5232d);
                    this.f5171a.ac = Math.min(i, min);
                }
                if (this.f5186p) {
                    i = this.f5189s - this.f5171a.f5214H;
                    if (i < 0) {
                        i += 7;
                    }
                    if (this.f5171a.f5251w && !h) {
                        i++;
                    }
                    this.f5191u = i;
                    if (h) {
                        this.f5191u = (this.f5171a.f5252x - 1) - i;
                        this.f5195y = (this.f5191u * this.f5183m) / this.f5192v;
                    } else {
                        this.f5191u = i;
                        this.f5195y = (this.f5191u * this.f5183m) / this.f5192v;
                    }
                    this.f5196z = this.f5195y + (this.f5183m / this.f5192v);
                    i = this.f5196z - this.f5195y;
                    int min2 = Math.min(this.f5184n - this.f5171a.f5231c, this.f5171a.f5232d);
                    this.f5171a.ac = Math.min(i, min2);
                }
            }

            protected void onMeasure(int i, int i2) {
                this.f5184n = ((this.f5171a.f5208B.getHeight() - this.f5171a.f5208B.getPaddingTop()) - this.f5171a.f5208B.getPaddingBottom()) / this.f5171a.f5250v;
                setMeasuredDimension(MeasureSpec.getSize(i), this.f5184n);
            }
        }

        /* compiled from: nearbyMapAreaFragment */
        public class WeeksAdapter extends BaseAdapter implements OnTouchListener {
            final /* synthetic */ CalendarView f5198a;
            public final Calendar f5199b = Calendar.getInstance();
            public Calendar f5200c;
            private final GestureDetector f5201d;
            private int f5202e;
            private int f5203f;
            private int f5204g;
            private int f5205h;

            /* compiled from: nearbyMapAreaFragment */
            class CalendarGestureListener extends SimpleOnGestureListener {
                final /* synthetic */ WeeksAdapter f5197a;

                CalendarGestureListener(WeeksAdapter weeksAdapter) {
                    this.f5197a = weeksAdapter;
                }

                public boolean onSingleTapUp(MotionEvent motionEvent) {
                    return true;
                }
            }

            public WeeksAdapter(CalendarView calendarView) {
                this.f5198a = calendarView;
                this.f5201d = new GestureDetector(calendarView.getContext(), new CalendarGestureListener(this));
                m6444f(this);
            }

            public static void m6444f(WeeksAdapter weeksAdapter) {
                weeksAdapter.f5202e = CalendarView.m6476b(weeksAdapter.f5198a, weeksAdapter.f5199b);
                if (weeksAdapter.f5200c != null) {
                    weeksAdapter.f5203f = CalendarView.m6476b(weeksAdapter.f5198a, weeksAdapter.f5200c);
                }
                weeksAdapter.f5205h = CalendarView.m6476b(weeksAdapter.f5198a, weeksAdapter.f5198a.f5226T);
                if (!(weeksAdapter.f5198a.f5225S.get(7) == weeksAdapter.f5198a.f5214H && weeksAdapter.f5198a.f5226T.get(7) == weeksAdapter.f5198a.f5214H)) {
                    weeksAdapter.f5205h++;
                }
                AdapterDetour.a(weeksAdapter, 1946656915);
            }

            public final void m6447a(Calendar calendar, boolean z) {
                if (z) {
                    m6439a(calendar, this.f5199b);
                }
                if (!calendar.equals(this.f5199b)) {
                    if (this.f5198a.ab == null || !calendar.before(this.f5198a.ab)) {
                        if (this.f5200c != null) {
                            if (!calendar.before(this.f5200c)) {
                                m6440b((int) TimeUnit.DAYS.convert(calendar.getTimeInMillis() - this.f5199b.getTimeInMillis(), TimeUnit.MILLISECONDS));
                            } else if (!m6442b(calendar, this.f5200c)) {
                                return;
                            }
                        }
                        this.f5199b.setTimeInMillis(calendar.getTimeInMillis());
                        this.f5202e = CalendarView.m6476b(this.f5198a, this.f5199b);
                        this.f5204g = this.f5199b.get(2);
                        AdapterDetour.a(this, 282232136);
                    }
                }
            }

            public final void m6449b(Calendar calendar, boolean z) {
                if (this.f5200c == null) {
                    if (calendar.after(this.f5199b)) {
                        this.f5200c = Calendar.getInstance();
                    } else {
                        return;
                    }
                }
                if (z) {
                    m6439a(calendar, this.f5200c);
                }
                if (!calendar.equals(this.f5200c)) {
                    if (!calendar.after(this.f5199b)) {
                        m6440b((int) TimeUnit.DAYS.convert(calendar.getTimeInMillis() - this.f5200c.getTimeInMillis(), TimeUnit.MILLISECONDS));
                    } else if (m6442b(this.f5199b, calendar)) {
                        this.f5200c.setTimeInMillis(calendar.getTimeInMillis());
                        this.f5203f = CalendarView.m6476b(this.f5198a, this.f5200c);
                        this.f5204g = this.f5200c.get(2);
                        AdapterDetour.a(this, 731901948);
                    }
                }
            }

            private void m6440b(int i) {
                if (this.f5199b != null && this.f5200c != null) {
                    Calendar instance = Calendar.getInstance();
                    Calendar instance2 = Calendar.getInstance();
                    instance.setTime(this.f5199b.getTime());
                    instance2.setTime(this.f5200c.getTime());
                    instance.add(6, i);
                    instance2.add(6, i);
                    if (this.f5198a.ab != null) {
                        if (instance.before(this.f5198a.ab)) {
                            instance.setTime(this.f5198a.ab.getTime());
                            m6439a(instance, this.f5199b);
                        }
                        if (instance2.before(this.f5198a.ab)) {
                            instance2.setTime(this.f5198a.ab.getTime());
                            m6439a(instance2, this.f5200c);
                        }
                    }
                    if (!instance.before(instance2)) {
                        if (instance.get(11) < 23) {
                            m6439a(instance2, this.f5199b);
                            instance2.roll(11, 1);
                        } else {
                            m6439a(instance, this.f5200c);
                            instance.roll(11, -1);
                        }
                    }
                    this.f5199b.setTimeInMillis(instance.getTimeInMillis());
                    this.f5200c.setTimeInMillis(instance2.getTimeInMillis());
                    this.f5202e = CalendarView.m6476b(this.f5198a, this.f5199b);
                    this.f5203f = CalendarView.m6476b(this.f5198a, this.f5200c);
                    if (this.f5198a.f5229W) {
                        this.f5204g = this.f5200c.get(2);
                    } else {
                        this.f5204g = this.f5199b.get(2);
                    }
                    AdapterDetour.a(this, -1796760600);
                }
            }

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private void m6439a(java.util.Calendar r7, java.util.Calendar r8) {
                /*
                r6 = this;
                r5 = 14;
                r4 = 13;
                r3 = 12;
                r2 = 11;
                r0 = com.facebook.uicontrib.calendar.CalendarView.C06853.f5167a;
                r1 = r6.f5198a;
                r1 = r1.f5222P;
                r1 = r1.ordinal();
                r0 = r0[r1];
                switch(r0) {
                    case 1: goto L_0x002d;
                    case 2: goto L_0x0026;
                    case 3: goto L_0x001f;
                    case 4: goto L_0x0018;
                    default: goto L_0x0017;
                };
            L_0x0017:
                return;
            L_0x0018:
                r0 = r8.get(r5);
                r7.set(r5, r0);
            L_0x001f:
                r0 = r8.get(r4);
                r7.set(r4, r0);
            L_0x0026:
                r0 = r8.get(r3);
                r7.set(r3, r0);
            L_0x002d:
                r0 = r8.get(r2);
                r7.set(r2, r0);
                goto L_0x0017;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.uicontrib.calendar.CalendarView.WeeksAdapter.a(java.util.Calendar, java.util.Calendar):void");
            }

            public final void m6445a() {
                CalendarView.m6476b(this.f5198a, this.f5199b);
                CalendarView.m6476b(this.f5198a, this.f5200c);
            }

            public final void m6448b() {
                this.f5200c = null;
                this.f5203f = 0;
                this.f5204g = this.f5199b.get(2);
                this.f5198a.f5229W = false;
                this.f5198a.m6470a(this.f5199b, true, false, true);
                AdapterDetour.a(this, -2042223060);
            }

            public final void m6450c() {
                Calendar calendar = this.f5198a.f5229W ? this.f5200c : this.f5199b;
                if (calendar != null) {
                    this.f5198a.m6470a(calendar, false, false, false);
                }
            }

            private boolean m6442b(Calendar calendar, Calendar calendar2) {
                if (calendar == null || calendar2 == null || this.f5198a.aa < 0 || calendar2.getTimeInMillis() - calendar.getTimeInMillis() <= this.f5198a.aa) {
                    return true;
                }
                return false;
            }

            public final Calendar m6451d() {
                return this.f5199b;
            }

            public final Calendar m6452e() {
                return this.f5200c;
            }

            public int getCount() {
                return this.f5205h;
            }

            public Object getItem(int i) {
                return null;
            }

            public long getItemId(int i) {
                return (long) i;
            }

            public View getView(int i, View view, ViewGroup viewGroup) {
                View view2;
                int i2;
                int i3;
                boolean z = true;
                if (view != null) {
                    view2 = (WeekView) view;
                } else {
                    view2 = new WeekView(this.f5198a, this.f5198a.getContext());
                    view2.setLayoutParams(new LayoutParams(-2, -2));
                    view2.setClickable(true);
                    view2.setOnTouchListener(this);
                }
                if (this.f5202e == i) {
                    i2 = this.f5199b.get(7);
                } else {
                    i2 = -1;
                }
                if (this.f5203f == i) {
                    i3 = this.f5200c.get(7);
                } else {
                    i3 = -1;
                }
                if (i < this.f5202e || i > this.f5203f) {
                    z = false;
                }
                view2.m6433a(i, z, i2, i3, this.f5204g);
                return view2;
            }

            public final void m6446a(int i) {
                if (this.f5204g != i) {
                    this.f5204g = i;
                    AdapterDetour.a(this, 703124731);
                }
            }

            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (!this.f5198a.f5208B.isEnabled() || !this.f5201d.onTouchEvent(motionEvent)) {
                    return false;
                }
                if (!((WeekView) view).m6434a(motionEvent.getX(), this.f5198a.f5223Q) || this.f5198a.f5223Q.before(this.f5198a.f5225S) || this.f5198a.f5223Q.after(this.f5198a.f5226T)) {
                    return true;
                }
                m6438a(this.f5198a.f5223Q);
                return true;
            }

            private void m6438a(Calendar calendar) {
                if (this.f5198a.f5229W) {
                    m6449b(calendar, true);
                } else {
                    m6447a(calendar, true);
                }
                CalendarView.setMonthDisplayed(this.f5198a, calendar);
            }
        }

        public CalendarView(Context context) {
            this(context, null);
        }

        public CalendarView(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, 0);
        }

        public CalendarView(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, 0);
            this.f5246r = 2;
            this.f5247s = 2;
            this.f5248t = 12;
            this.f5249u = 20;
            this.f5252x = 7;
            this.f5253y = 0.05f;
            this.f5254z = 0.333f;
            this.f5215I = -1;
            this.f5217K = false;
            this.f5218L = 0;
            this.f5219M = 0;
            this.f5221O = new ScrollStateRunnable(this);
            this.f5222P = TimeSensitivity.MINUTES;
            this.f5227U = new SimpleDateFormat("MM/dd/yyyy");
            this.aa = -1;
            this.ac = -1;
            setCurrentLocale(Locale.getDefault());
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CalendarView, 2130772601, 2131626532);
            this.f5251w = obtainStyledAttributes.getBoolean(1, true);
            this.f5214H = obtainStyledAttributes.getInt(0, m6474b());
            String string = obtainStyledAttributes.getString(2);
            if (TextUtils.isEmpty(string) || !m6472a(string, this.f5225S)) {
                m6472a("01/01/1900", this.f5225S);
            }
            string = obtainStyledAttributes.getString(3);
            if (TextUtils.isEmpty(string) || !m6472a(string, this.f5226T)) {
                m6472a("01/01/2100", this.f5226T);
            }
            if (this.f5226T.before(this.f5225S)) {
                throw new IllegalArgumentException("Max date cannot be before min date.");
            }
            this.f5250v = obtainStyledAttributes.getInt(4, 6);
            this.f5236h = obtainStyledAttributes.getColor(5, 0);
            this.f5237i = obtainStyledAttributes.getColor(6, 0);
            this.f5238j = obtainStyledAttributes.getColor(7, 0);
            this.f5239k = obtainStyledAttributes.getColor(8, 0);
            this.f5240l = obtainStyledAttributes.getBoolean(10, false);
            this.f5241m = obtainStyledAttributes.getColor(11, 0);
            this.f5242n = obtainStyledAttributes.getColor(9, 0);
            this.f5232d = obtainStyledAttributes.getDimensionPixelSize(15, getResources().getDimensionPixelSize(2131434037));
            this.f5245q = obtainStyledAttributes.getResourceId(14, -1);
            m6481c();
            this.f5243o = obtainStyledAttributes.getResourceId(12, -1);
            this.f5244p = obtainStyledAttributes.getResourceId(13, -1);
            obtainStyledAttributes.recycle();
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            this.f5248t = (int) TypedValue.applyDimension(1, 12.0f, displayMetrics);
            this.f5246r = (int) TypedValue.applyDimension(1, 1.0f, displayMetrics);
            this.f5247s = (int) TypedValue.applyDimension(1, 2.0f, displayMetrics);
            this.f5249u = (int) TypedValue.applyDimension(1, 20.0f, displayMetrics);
            this.f5231c = this.f5240l ? (int) TypedValue.applyDimension(1, 1.0f, displayMetrics) : 0;
            this.f5234f = getContext().getResources().getDrawable(2130838377);
            this.f5235g = getContext().getResources().getDrawable(2130838378);
            View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(2130903478, null, false);
            addView(inflate);
            this.f5208B = (ListView) findViewById(2131560128);
            this.f5210D = (ViewGroup) inflate.findViewById(2131560126);
            this.f5211E = (ImageView) inflate.findViewById(2131560127);
            this.f5209C = (TextView) inflate.findViewById(2131560125);
            m6488f();
            m6490g();
            m6485e();
            this.f5223Q.setTimeInMillis(System.currentTimeMillis());
            m6476b(this, this.f5223Q);
            if (this.f5223Q.before(this.f5225S)) {
                m6470a(this.f5225S, false, true, true);
            } else if (this.f5226T.before(this.f5223Q)) {
                m6470a(this.f5226T, false, true, true);
            } else {
                m6470a(this.f5223Q, false, true, true);
            }
            invalidate();
        }

        public void setIsSelectingSecondDate(boolean z) {
            int i;
            int i2 = 0;
            if (this.f5229W != z) {
                i = 1;
            } else {
                i = 0;
            }
            this.f5229W = z;
            if (i != 0) {
                int childCount = this.f5208B.getChildCount();
                while (i2 < childCount) {
                    WeekView weekView = (WeekView) this.f5208B.getChildAt(i2);
                    if (weekView.f5185o || weekView.f5186p) {
                        weekView.invalidate();
                    }
                    i2++;
                }
                this.f5207A.m6450c();
            }
        }

        public final void m6511a() {
            if (this.f5207A != null) {
                this.f5207A.m6448b();
            }
        }

        public void setMaxDateRangeDistanceInMilliseconds(long j) {
            this.aa = j;
        }

        public final void m6512a(int i, int i2, int i3) {
            if (this.ab == null) {
                this.ab = Calendar.getInstance();
            }
            this.ab.clear();
            this.ab.set(i, i2, i3);
        }

        public Calendar getMinSelectableDate() {
            return this.ab;
        }

        public void setShownWeekCount(int i) {
            if (this.f5250v != i) {
                this.f5250v = i;
                invalidate();
            }
        }

        public int getShownWeekCount() {
            return this.f5250v;
        }

        public void setSelectedWeekBackgroundColor(int i) {
            if (this.f5236h != i) {
                this.f5236h = i;
                int childCount = this.f5208B.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    WeekView weekView = (WeekView) this.f5208B.getChildAt(i2);
                    if (weekView.f5185o) {
                        weekView.invalidate();
                    }
                }
            }
        }

        public int getSelectedWeekBackgroundColor() {
            return this.f5236h;
        }

        public void setFocusedMonthDateColor(int i) {
            if (this.f5238j != i) {
                this.f5238j = i;
                int childCount = this.f5208B.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    WeekView weekView = (WeekView) this.f5208B.getChildAt(i2);
                    if (weekView.f5177g) {
                        weekView.invalidate();
                    }
                }
            }
        }

        public int getFocusedMonthDateColor() {
            return this.f5238j;
        }

        public void setUnfocusedMonthDateColor(int i) {
            if (this.f5239k != i) {
                this.f5239k = i;
                int childCount = this.f5208B.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    WeekView weekView = (WeekView) this.f5208B.getChildAt(i2);
                    if (weekView.f5178h) {
                        weekView.invalidate();
                    }
                }
            }
        }

        public int getUnfocusedMonthDateColor() {
            return this.f5238j;
        }

        public void setWeekNumberColor(int i) {
            if (this.f5242n != i) {
                this.f5242n = i;
                if (this.f5251w) {
                    m6484d();
                }
            }
        }

        public int getWeekNumberColor() {
            return this.f5242n;
        }

        public void setWeekSeparatorLineColor(int i) {
            if (this.f5241m != i) {
                this.f5241m = i;
                m6484d();
            }
        }

        public int getWeekSeparatorLineColor() {
            return this.f5241m;
        }

        public void setMonthTextAppearance(int i) {
            if (this.f5243o != i) {
                this.f5243o = i;
                setMonthDisplayed(this, this.f5224R);
            }
        }

        public int getMonthTextAppearance() {
            return this.f5243o;
        }

        public void setWeekDayTextAppearance(int i) {
            if (this.f5244p != i) {
                this.f5244p = i;
                m6488f();
            }
        }

        public int getWeekDayTextAppearance() {
            return this.f5244p;
        }

        public void setDateTextAppearance(int i) {
            if (this.f5245q != i) {
                this.f5245q = i;
                m6481c();
                m6484d();
            }
        }

        public int getDateTextAppearance() {
            return this.f5245q;
        }

        public void setEnabled(boolean z) {
            this.f5208B.setEnabled(z);
        }

        public boolean isEnabled() {
            return this.f5208B.isEnabled();
        }

        protected void onConfigurationChanged(Configuration configuration) {
            super.onConfigurationChanged(configuration);
            setCurrentLocale(configuration.locale);
        }

        @TargetApi(14)
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(CalendarView.class.getName());
        }

        @TargetApi(14)
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(CalendarView.class.getName());
        }

        public void setTimeSensitivity(TimeSensitivity timeSensitivity) {
            Object obj = timeSensitivity != this.f5222P ? 1 : null;
            this.f5222P = timeSensitivity;
            if (obj != null && this.f5207A != null) {
                this.f5207A.m6445a();
            }
        }

        public static void m6468a(CalendarView calendarView, Calendar calendar) {
            if (calendar != null) {
                switch (calendarView.f5222P) {
                    case HOUR:
                        calendar.set(12, 0);
                        break;
                    case MINUTES:
                        break;
                    case SECONDS:
                        break;
                    default:
                        return;
                }
                calendar.set(13, 0);
                calendar.set(14, 0);
            }
        }

        public long getMinDate() {
            return this.f5225S.getTimeInMillis();
        }

        public void setMinDate(long j) {
            this.f5223Q.setTimeInMillis(j);
            m6476b(this, this.f5223Q);
            if (!m6473a(this.f5223Q, this.f5225S)) {
                this.f5225S.setTimeInMillis(j);
                Calendar calendar = this.f5207A.f5199b;
                if (calendar.before(this.f5225S)) {
                    this.f5207A.m6447a(this.f5225S, false);
                }
                WeeksAdapter.m6444f(this.f5207A);
                if (calendar.before(this.f5225S)) {
                    setDate(this.f5223Q.getTimeInMillis());
                } else {
                    m6470a(calendar, false, true, false);
                }
            }
        }

        public long getMaxDate() {
            return this.f5226T.getTimeInMillis();
        }

        public void setMaxDate(long j) {
            this.f5223Q.setTimeInMillis(j);
            m6476b(this, this.f5223Q);
            if (!m6473a(this.f5223Q, this.f5226T)) {
                this.f5226T.setTimeInMillis(j);
                WeeksAdapter.m6444f(this.f5207A);
                Calendar calendar = this.f5207A.f5199b;
                if (calendar.after(this.f5226T)) {
                    setDate(this.f5226T.getTimeInMillis());
                } else {
                    m6470a(calendar, false, true, false);
                }
            }
        }

        public void setShowWeekNumber(boolean z) {
            if (this.f5251w != z) {
                this.f5251w = z;
                AdapterDetour.a(this.f5207A, -695201880);
                m6488f();
            }
        }

        public boolean getShowWeekNumber() {
            return this.f5251w;
        }

        public int getFirstDayOfWeek() {
            return this.f5214H;
        }

        private int m6474b() {
            if (Locale.US.equals(this.f5228V)) {
                return 2;
            }
            return Calendar.getInstance().getFirstDayOfWeek();
        }

        public void setFirstDayOfWeek(int i) {
            if (this.f5214H != i) {
                this.f5214H = i;
                WeeksAdapter.m6444f(this.f5207A);
                m6488f();
            }
        }

        public void setOnDateChangeListener(OnDateChangeListener onDateChangeListener) {
            this.f5220N = onDateChangeListener;
        }

        public long getDate() {
            return this.f5207A.f5199b.getTimeInMillis();
        }

        public long getSecondDate() {
            return this.f5207A.f5200c.getTimeInMillis();
        }

        public void setShowDayNamesDivider(boolean z) {
            this.f5211E.setVisibility(z ? 0 : 8);
        }

        public void setDate(long j) {
            m6463a(j, false, false);
        }

        private void m6463a(long j, boolean z, boolean z2) {
            this.f5223Q.setTimeInMillis(j);
            m6476b(this, this.f5223Q);
            if (this.f5229W || !this.f5223Q.equals(this.f5207A.f5199b) || !this.f5229W || !this.f5223Q.equals(this.f5207A.f5200c)) {
                m6470a(this.f5223Q, z, true, z2);
            }
        }

        private void m6481c() {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(this.f5245q, R.styleable.TextAppearance);
            this.f5233e = obtainStyledAttributes.getDimensionPixelSize(0, 14);
            obtainStyledAttributes.recycle();
        }

        private void m6484d() {
            int childCount = this.f5208B.getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.f5208B.getChildAt(i).invalidate();
            }
        }

        private void setCurrentLocale(Locale locale) {
            if (!locale.equals(this.f5228V)) {
                this.f5228V = locale;
                this.f5230b = new DateFormatSymbols(locale);
                this.f5223Q = m6462a(this.f5223Q, locale);
                this.f5224R = m6462a(this.f5224R, locale);
                this.f5225S = m6462a(this.f5225S, locale);
                this.f5226T = m6462a(this.f5226T, locale);
            }
        }

        private static Calendar m6462a(Calendar calendar, Locale locale) {
            if (calendar == null) {
                return Calendar.getInstance(locale);
            }
            long timeInMillis = calendar.getTimeInMillis();
            Calendar instance = Calendar.getInstance(locale);
            instance.setTimeInMillis(timeInMillis);
            return instance;
        }

        private static boolean m6473a(Calendar calendar, Calendar calendar2) {
            return calendar.get(6) == calendar2.get(6) && calendar.get(1) == calendar2.get(1);
        }

        private void m6485e() {
            if (this.f5207A == null) {
                this.f5207A = new WeeksAdapter(this);
                this.f5207A.registerDataSetObserver(new C06831(this));
                this.f5208B.setAdapter(this.f5207A);
            }
            AdapterDetour.a(this.f5207A, 825127562);
        }

        private void m6488f() {
            int i;
            this.f5212F = new String[this.f5252x];
            this.f5213G = new String[this.f5252x];
            int i2 = this.f5252x + this.f5214H;
            for (i = this.f5214H; i < i2; i++) {
                int i3;
                if (i > 7) {
                    i3 = i - 7;
                } else {
                    i3 = i;
                }
                this.f5212F[i - this.f5214H] = DateUtils.getDayOfWeekString(i3, 50);
                this.f5213G[i - this.f5214H] = DateUtils.getDayOfWeekString(i3, 10);
            }
            TextView textView = (TextView) this.f5210D.getChildAt(0);
            if (this.f5251w) {
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
            i2 = this.f5210D.getChildCount();
            for (i = 0; i < i2 - 1; i++) {
                textView = (TextView) this.f5210D.getChildAt(i + 1);
                if (this.f5244p >= 0) {
                    textView.setTextAppearance(getContext(), this.f5244p);
                }
                if (i < this.f5252x) {
                    textView.setText(this.f5212F[i]);
                    textView.setContentDescription(this.f5213G[i]);
                    textView.setVisibility(0);
                } else {
                    textView.setVisibility(8);
                }
            }
            this.f5210D.invalidate();
        }

        private void m6490g() {
            this.f5208B.setDivider(null);
            this.f5208B.setItemsCanFocus(true);
            this.f5208B.setVerticalScrollBarEnabled(false);
            this.f5208B.setOnScrollListener(new C06842(this));
            this.f5208B.setFriction(this.f5253y);
            this.f5208B.setVelocityScale(this.f5254z);
        }

        private void m6470a(Calendar calendar, boolean z, boolean z2, boolean z3) {
            if (calendar.before(this.f5225S) || calendar.after(this.f5226T)) {
                throw new IllegalArgumentException("Time not between " + this.f5225S.getTime() + " and " + this.f5226T.getTime());
            }
            int firstVisiblePosition = this.f5208B.getFirstVisiblePosition();
            View childAt = this.f5208B.getChildAt(0);
            if (childAt != null && childAt.getTop() < 0) {
                firstVisiblePosition++;
            }
            int i = (this.f5250v + firstVisiblePosition) - 1;
            if (childAt != null && childAt.getTop() > this.f5249u) {
                i--;
            }
            if (z2) {
                if (this.f5229W) {
                    this.f5207A.m6449b(calendar, false);
                } else {
                    this.f5207A.m6447a(calendar, false);
                }
            }
            int b = m6476b(this, calendar);
            if (b < firstVisiblePosition || b > r2 || z3) {
                this.f5224R.setTimeInMillis(calendar.getTimeInMillis());
                this.f5224R.set(5, 1);
                setMonthDisplayed(this, this.f5224R);
                if (this.f5224R.before(this.f5225S)) {
                    firstVisiblePosition = 0;
                } else {
                    firstVisiblePosition = m6476b(this, this.f5224R);
                }
                this.f5218L = 2;
                if (z) {
                    this.f5208B.smoothScrollToPositionFromTop(firstVisiblePosition, this.f5247s, 1000);
                    return;
                }
                this.f5208B.setSelectionFromTop(firstVisiblePosition, this.f5247s);
                m6465a(this.f5208B, 0);
            } else if (z2) {
                setMonthDisplayed(this, calendar);
            }
        }

        private boolean m6472a(String str, Calendar calendar) {
            try {
                calendar.setTime(this.f5227U.parse(str));
                return true;
            } catch (ParseException e) {
                Log.w(f5206a, "Date: " + str + " not in format: MM/dd/yyyy");
                return false;
            }
        }

        private void m6465a(AbsListView absListView, int i) {
            this.f5221O.m6419a(absListView, i);
        }

        private void m6464a(AbsListView absListView) {
            int i = 0;
            boolean z = true;
            WeekView weekView = (WeekView) absListView.getChildAt(0);
            if (weekView != null) {
                long firstVisiblePosition = (long) ((absListView.getFirstVisiblePosition() * weekView.getHeight()) - weekView.getBottom());
                if (firstVisiblePosition < this.f5216J) {
                    this.f5217K = true;
                } else if (firstVisiblePosition > this.f5216J) {
                    this.f5217K = false;
                } else {
                    return;
                }
                if (weekView.getBottom() < this.f5248t) {
                    i = 1;
                }
                if (this.f5217K) {
                    weekView = (WeekView) absListView.getChildAt(i + 2);
                } else if (i != 0) {
                    weekView = (WeekView) absListView.getChildAt(1);
                }
                if (this.f5217K) {
                    i = weekView.f5180j;
                } else {
                    i = weekView.f5181k;
                }
                if (!(this.f5215I == 11 && i == 0)) {
                    if (this.f5215I == 0 && i == 11) {
                        z = true;
                    } else {
                        z = i - this.f5215I;
                    }
                }
                if ((!this.f5217K && r2 <= false) || (this.f5217K && r2 >= false)) {
                    Calendar calendar = weekView.f5179i;
                    if (this.f5217K) {
                        calendar.add(5, -7);
                    } else {
                        calendar.add(5, 7);
                    }
                    setMonthDisplayed(this, calendar);
                }
                this.f5216J = firstVisiblePosition;
                this.f5218L = this.f5219M;
            }
        }

        public static void setMonthDisplayed(CalendarView calendarView, Calendar calendar) {
            calendarView.f5215I = calendar.get(2);
            calendarView.f5207A.m6446a(calendarView.f5215I);
            long timeInMillis = calendar.getTimeInMillis();
            CharSequence formatDateRange = DateUtils.formatDateRange(calendarView.getContext(), timeInMillis, timeInMillis, 52);
            if (calendarView.f5243o >= 0) {
                calendarView.f5209C.setTextAppearance(calendarView.getContext(), calendarView.f5243o);
            }
            calendarView.f5209C.setText(formatDateRange);
            calendarView.f5209C.invalidate();
        }

        public static int m6476b(CalendarView calendarView, Calendar calendar) {
            if (calendar.before(calendarView.f5225S)) {
                throw new IllegalArgumentException("fromDate: " + calendarView.f5225S.getTime() + " does not precede toDate: " + calendar.getTime());
            }
            return (int) ((((calendar.getTimeInMillis() + ((long) calendar.getTimeZone().getOffset(calendar.getTimeInMillis()))) - (calendarView.f5225S.getTimeInMillis() + ((long) calendarView.f5225S.getTimeZone().getOffset(calendarView.f5225S.getTimeInMillis())))) + (((long) (calendarView.f5225S.get(7) - calendarView.f5214H)) * 86400000)) / 604800000);
        }

        public static boolean m6492h(CalendarView calendarView) {
            return ViewCompat.h(calendarView) == 1;
        }
    }
