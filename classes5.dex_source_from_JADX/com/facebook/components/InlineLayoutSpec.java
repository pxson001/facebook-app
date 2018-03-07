package com.facebook.components;

/* compiled from: setSoftMaximumLatencyMs(long) and setPeriod(long) cant both be called */
public abstract class InlineLayoutSpec extends Component implements Cloneable {
    private static final ComponentLifecycle f2801a = new Lifecycle();

    /* compiled from: setSoftMaximumLatencyMs(long) and setPeriod(long) cant both be called */
    class Lifecycle extends ComponentLifecycle {
        protected final ComponentLayout m3934b(ComponentContext componentContext, Component<?> component) {
            return ((InlineLayoutSpec) component).m3935a(componentContext);
        }

        public final void m3933a(EventHandler eventHandler, Object obj) {
        }
    }

    protected abstract InternalNode m3935a(ComponentContext componentContext);

    public InlineLayoutSpec() {
        super(f2801a);
    }
}
