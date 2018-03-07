package com.facebook.common.eventbus;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.List;
import java.util.Map;

/* compiled from: prepare_async_time */
public class TypedEventBus {
    public Map<Class<? extends TypedEvent<?>>, List<TypedHandler>> f9190a = Maps.m838c();
    public List<TypedEventBus> f9191b = Lists.m1297a(1);
    private final Object f9192c = new Object();
    private int f9193d = 0;
    private final List<Runnable> f9194e = Lists.m1297a(2);

    public final <HandlerType extends TypedHandler> void m14080a(final Class<? extends TypedEvent<HandlerType>> cls, final HandlerType handlerType) {
        m14077a(new Runnable(this) {
            final /* synthetic */ TypedEventBus f9198c;

            public void run() {
                TypedEventBus typedEventBus = this.f9198c;
                Class cls = cls;
                List list = (List) typedEventBus.f9190a.get(cls);
                if (list == null) {
                    list = Lists.m1296a();
                    typedEventBus.f9190a.put(cls, list);
                }
                list.add(handlerType);
            }
        });
    }

    public final <HandlerType extends TypedHandler> void m14082b(Class<? extends TypedEvent<HandlerType>> cls, HandlerType handlerType) {
        m14077a(new 2(this, cls, handlerType));
    }

    public final void m14079a(TypedEventBus typedEventBus) {
        m14077a(new 3(this, typedEventBus));
    }

    public final void m14081b(TypedEventBus typedEventBus) {
        m14077a(new 4(this, typedEventBus));
    }

    public <HandlerType extends TypedHandler> void m14078a(TypedEvent<HandlerType> typedEvent) {
        synchronized (this.f9192c) {
            this.f9193d++;
        }
        try {
            List<TypedHandler> list = (List) this.f9190a.get(typedEvent.getClass());
            if (list != null) {
                for (TypedHandler a : list) {
                    typedEvent.m14083a(a);
                }
            }
            if (!this.f9191b.isEmpty()) {
                for (TypedEventBus a2 : this.f9191b) {
                    a2.m14078a((TypedEvent) typedEvent);
                }
            }
            synchronized (this.f9192c) {
                this.f9193d--;
                if (this.f9193d == 0) {
                    for (Runnable run : this.f9194e) {
                        run.run();
                    }
                    this.f9194e.clear();
                }
            }
        } catch (Throwable th) {
            Throwable th2 = th;
            synchronized (this.f9192c) {
                this.f9193d--;
                if (this.f9193d == 0) {
                    for (Runnable run2 : this.f9194e) {
                        run2.run();
                    }
                    this.f9194e.clear();
                }
            }
        }
    }

    private void m14077a(Runnable runnable) {
        synchronized (this.f9192c) {
            if (this.f9193d > 0) {
                this.f9194e.add(runnable);
            } else {
                runnable.run();
            }
        }
    }
}
