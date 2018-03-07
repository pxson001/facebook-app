package com.facebook.react.uimanager.events;

import android.util.LongSparseArray;
import android.view.Choreographer.FrameCallback;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.ReactChoreographer;
import com.facebook.react.uimanager.ReactChoreographer.CallbackType;
import com.facebook.systrace.Systrace;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: for_sale_item_message_seller_button_clicked */
public class EventDispatcher implements LifecycleEventListener {
    public static final Comparator<Event> f11892a = new C10461();
    private final Object f11893b = new Object();
    public final Object f11894c = new Object();
    public final ReactApplicationContext f11895d;
    public final LongSparseArray<Integer> f11896e = new LongSparseArray();
    private final Map<String, Short> f11897f = MapBuilder.m13603a();
    public final DispatchEventsRunnable f11898g = new DispatchEventsRunnable(this);
    private final ArrayList<Event> f11899h = new ArrayList();
    public Event[] f11900i = new Event[16];
    public int f11901j = 0;
    @Nullable
    public RCTEventEmitter f11902k;
    public final ScheduleDispatchFrameCallback f11903l;
    private short f11904m = (short) 0;
    public volatile boolean f11905n = false;
    public volatile int f11906o = 0;

    /* compiled from: for_sale_item_message_seller_button_clicked */
    final class C10461 implements Comparator<Event> {
        C10461() {
        }

        public final int compare(Object obj, Object obj2) {
            Event event = (Event) obj;
            Event event2 = (Event) obj2;
            if (event == null && event2 == null) {
                return 0;
            }
            if (event == null) {
                return -1;
            }
            if (event2 == null) {
                return 1;
            }
            long d = event.f11752d - event2.m13912d();
            if (d == 0) {
                return 0;
            }
            if (d < 0) {
                return -1;
            }
            return 1;
        }
    }

    /* compiled from: for_sale_item_message_seller_button_clicked */
    class DispatchEventsRunnable implements Runnable {
        final /* synthetic */ EventDispatcher f11887a;

        public DispatchEventsRunnable(EventDispatcher eventDispatcher) {
            this.f11887a = eventDispatcher;
        }

        public void run() {
            int i = 0;
            Systrace.a(8192, "DispatchEventsRunnable");
            try {
                Systrace.e(8192, "ScheduleDispatchFrameCallback", this.f11887a.f11906o);
                this.f11887a.f11905n = false;
                this.f11887a.f11906o = this.f11887a.f11906o + 1;
                Assertions.b(this.f11887a.f11902k);
                synchronized (this.f11887a.f11894c) {
                    if (this.f11887a.f11901j > 1) {
                        Arrays.sort(this.f11887a.f11900i, 0, this.f11887a.f11901j, EventDispatcher.f11892a);
                    }
                    while (i < this.f11887a.f11901j) {
                        Event event = this.f11887a.f11900i[i];
                        if (event != null) {
                            Systrace.e(8192, event.mo738b(), event.m13915g());
                            event.mo737a(this.f11887a.f11902k);
                            event.m13917i();
                        }
                        i++;
                    }
                    this.f11887a.f11906o = this.f11887a.f11906o + 1;
                    this.f11887a.f11896e.clear();
                }
            } finally {
                Systrace.a(8192);
            }
        }
    }

    /* compiled from: for_sale_item_message_seller_button_clicked */
    class ScheduleDispatchFrameCallback implements FrameCallback {
        final /* synthetic */ EventDispatcher f11889a;
        private volatile boolean f11890b;
        private boolean f11891c;

        /* compiled from: for_sale_item_message_seller_button_clicked */
        class C10471 implements Runnable {
            final /* synthetic */ ScheduleDispatchFrameCallback f11888a;

            C10471(ScheduleDispatchFrameCallback scheduleDispatchFrameCallback) {
                this.f11888a = scheduleDispatchFrameCallback;
            }

            public void run() {
                this.f11888a.m14135b();
            }
        }

        public ScheduleDispatchFrameCallback(EventDispatcher eventDispatcher) {
            this.f11889a = eventDispatcher;
            this.f11890b = false;
            this.f11891c = false;
        }

        public void doFrame(long j) {
            UiThreadUtil.m13554b();
            if (this.f11891c) {
                this.f11890b = false;
            } else {
                m14133d();
            }
            Systrace.a(8192, "ScheduleDispatchFrameCallback");
            try {
                this.f11889a.f11895d;
                if (this.f11889a.f11901j > 0 && !this.f11889a.f11905n) {
                    this.f11889a.f11905n = true;
                    Systrace.d(8192, "ScheduleDispatchFrameCallback", this.f11889a.f11906o);
                    this.f11889a.f11895d.m13530c(this.f11889a.f11898g);
                }
                Systrace.a(8192);
            } catch (Throwable th) {
                Systrace.a(8192);
            }
        }

        public final void m14134a() {
            this.f11891c = true;
        }

        public final void m14135b() {
            if (!this.f11890b) {
                this.f11890b = true;
                m14133d();
            }
        }

        private void m14133d() {
            ReactChoreographer.m13927a().m13933a(CallbackType.TIMERS_EVENTS, this.f11889a.f11903l);
        }

        public final void m14136c() {
            if (!this.f11890b) {
                if (this.f11889a.f11895d.m13533f()) {
                    m14135b();
                } else {
                    this.f11889a.f11895d.m13522a(new C10471(this));
                }
            }
        }
    }

    public EventDispatcher(ReactApplicationContext reactApplicationContext) {
        this.f11895d = reactApplicationContext;
        this.f11895d.mo745a((LifecycleEventListener) this);
        this.f11903l = new ScheduleDispatchFrameCallback(this);
    }

    public final void m14159a(Event event) {
        Assertions.a(event.m13916h(), "Dispatched event hasn't been initialized");
        synchronized (this.f11893b) {
            this.f11899h.add(event);
            Systrace.d(8192, event.mo738b(), event.m13915g());
        }
        if (this.f11902k != null) {
            this.f11903l.m14136c();
        }
    }

    public final void hf_() {
        UiThreadUtil.m13554b();
        if (this.f11902k == null) {
            this.f11902k = (RCTEventEmitter) this.f11895d.m13515a(RCTEventEmitter.class);
        }
        this.f11903l.m14135b();
    }

    public final void hg_() {
        m14147e();
    }

    public final void hh_() {
        m14147e();
    }

    public final void m14158a() {
        m14147e();
    }

    private void m14147e() {
        UiThreadUtil.m13554b();
        this.f11903l.m14134a();
    }

    public static void m14149f(EventDispatcher eventDispatcher) {
        synchronized (eventDispatcher.f11893b) {
            synchronized (eventDispatcher.f11894c) {
                for (int i = 0; i < eventDispatcher.f11899h.size(); i++) {
                    Event event = (Event) eventDispatcher.f11899h.get(i);
                    if (event.mo752e()) {
                        Event event2;
                        long a = eventDispatcher.m14137a(event.m13911c(), event.mo738b(), event.mo753f());
                        Integer num = (Integer) eventDispatcher.f11896e.get(a);
                        if (num == null) {
                            eventDispatcher.f11896e.put(a, Integer.valueOf(eventDispatcher.f11901j));
                            event2 = event;
                            event = null;
                        } else {
                            Event event3 = eventDispatcher.f11900i[num.intValue()];
                            Event a2 = event.m13906a(event3);
                            if (a2 != event3) {
                                eventDispatcher.f11896e.put(a, Integer.valueOf(eventDispatcher.f11901j));
                                eventDispatcher.f11900i[num.intValue()] = null;
                                event = event3;
                                event2 = a2;
                            } else {
                                event2 = null;
                            }
                        }
                        if (event2 != null) {
                            eventDispatcher.m14142b(event2);
                        }
                        if (event != null) {
                            event.m13917i();
                        }
                    } else {
                        eventDispatcher.m14142b(event);
                    }
                }
            }
            eventDispatcher.f11899h.clear();
        }
    }

    private long m14137a(int i, String str, short s) {
        short shortValue;
        Short sh = (Short) this.f11897f.get(str);
        if (sh != null) {
            shortValue = sh.shortValue();
        } else {
            shortValue = this.f11904m;
            this.f11904m = (short) (shortValue + 1);
            this.f11897f.put(str, Short.valueOf(shortValue));
        }
        return m14138a(i, shortValue, s);
    }

    private static long m14138a(int i, short s, short s2) {
        return (((long) i) | ((((long) s) & 65535) << 32)) | ((((long) s2) & 65535) << 48);
    }

    private void m14142b(Event event) {
        if (this.f11901j == this.f11900i.length) {
            this.f11900i = (Event[]) Arrays.copyOf(this.f11900i, this.f11900i.length * 2);
        }
        Event[] eventArr = this.f11900i;
        int i = this.f11901j;
        this.f11901j = i + 1;
        eventArr[i] = event;
    }

    public static void m14152h(EventDispatcher eventDispatcher) {
        Arrays.fill(eventDispatcher.f11900i, 0, eventDispatcher.f11901j, null);
        eventDispatcher.f11901j = 0;
    }
}
