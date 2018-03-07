package com.facebook.feed.rows.core.parts;

import android.view.View;
import com.facebook.feed.rows.core.binding.Binder;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.renderers.RendererUtils;
import javax.annotation.Nullable;

/* compiled from: mk */
public class SinglePartDefinitionBinder<P, S, E extends AnyEnvironment, V extends View> extends Binder<V> {
    private final P f13437a;
    private E f13438b;
    private PartHolder<P, S, E, V> f13439c;
    private SinglePartDefinition<P, S, E, V> f13440d;

    /* compiled from: mk */
    class PartHolder<P, S, E extends AnyEnvironment, V extends View> implements SubParts<E> {
        public final SinglePartDefinition<P, S, E, V> f14286a;
        private final P f14287b;
        public final int f14288c;
        @Nullable
        public PartHolder f14289d;
        @Nullable
        public PartHolder f14290e;
        @Nullable
        public PartHolder f14291f;
        @Nullable
        public PartHolder f14292g;
        private S f14293h;

        PartHolder(SinglePartDefinition<P, S, E, V> singlePartDefinition, int i, P p) {
            this.f14286a = singlePartDefinition;
            this.f14288c = i;
            this.f14287b = p;
        }

        public static void m20679a(PartHolder partHolder, AnyEnvironment anyEnvironment) {
            partHolder.f14293h = partHolder.f14286a.mo2541a((SubParts) partHolder, partHolder.f14287b, anyEnvironment);
        }

        public static void m20680a(PartHolder partHolder, AnyEnvironment anyEnvironment, View view) {
            partHolder.f14286a.mo2543a(partHolder.f14287b, partHolder.f14293h, anyEnvironment, view);
        }

        public static void m20682b(PartHolder partHolder, AnyEnvironment anyEnvironment, View view) {
            partHolder.f14286a.mo2544b(partHolder.f14287b, partHolder.f14293h, anyEnvironment, view);
        }

        public static void m20681b(PartHolder partHolder, AnyEnvironment anyEnvironment) {
            partHolder.f14286a.mo2542a(partHolder.f14287b, partHolder.f14293h, anyEnvironment);
            partHolder.f14293h = null;
        }

        public final <P2> void mo2756a(SinglePartDefinition<P2, ?, ? super E, ? extends View> singlePartDefinition, P2 p2) {
            mo2755a(-1, (SinglePartDefinition) singlePartDefinition, (Object) p2);
        }

        public final <P2> void mo2755a(int i, SinglePartDefinition<P2, ?, ? super E, ? extends View> singlePartDefinition, P2 p2) {
            PartHolder partHolder = new PartHolder(singlePartDefinition, i, p2);
            if (this.f14290e == null) {
                this.f14289d = partHolder;
            } else {
                this.f14290e.f14292g = partHolder;
                partHolder.f14291f = this.f14290e;
            }
            this.f14290e = partHolder;
        }
    }

    public SinglePartDefinitionBinder(P p, SinglePartDefinition<P, S, E, V> singlePartDefinition) {
        this.f13437a = p;
        this.f13440d = singlePartDefinition;
    }

    public final void mo2634a(AnyEnvironment anyEnvironment) {
        try {
            this.f13438b = anyEnvironment;
            this.f13439c = new PartHolder(this.f13440d, -1, this.f13437a);
            m19788a(this.f13439c);
        } catch (Exception e) {
            m19790a(this.f13439c, e, "preparing");
        }
    }

    public final void mo2633a(V v) {
        m19789a(this.f13439c, v);
    }

    public final void mo2635b(V v) {
        m19792b(this.f13439c, v);
    }

    public final void mo2636b(AnyEnvironment anyEnvironment) {
        try {
            m19791b(this.f13439c);
        } catch (Exception e) {
            m19790a(this.f13439c, e, "releasing");
        }
    }

    private <P2, V2 extends View> void m19788a(PartHolder<P2, ?, E, V2> partHolder) {
        try {
            PartHolder.m20679a((PartHolder) partHolder, this.f13438b);
            for (PartHolder partHolder2 = partHolder.f14289d; partHolder2 != null; partHolder2 = partHolder2.f14292g) {
                m19788a(partHolder2);
            }
        } catch (Exception e) {
            m19790a(partHolder, e, "preparing");
        }
    }

    private <P2, V1 extends View, V2 extends View> void m19789a(PartHolder<P2, ?, E, V1> partHolder, V1 v1) {
        try {
            PartHolder.m20680a((PartHolder) partHolder, this.f13438b, (View) v1);
            for (PartHolder partHolder2 = partHolder.f14289d; partHolder2 != null; partHolder2 = partHolder2.f14292g) {
                m19789a(partHolder2, RendererUtils.m20703a((View) v1, partHolder2.f14288c));
            }
        } catch (Exception e) {
            m19790a(partHolder, e, "binding");
        }
    }

    private <P2, V1 extends View, V2 extends View> void m19792b(PartHolder<P2, ?, E, V1> partHolder, V1 v1) {
        try {
            for (PartHolder partHolder2 = partHolder.f14290e; partHolder2 != null; partHolder2 = partHolder2.f14291f) {
                m19792b(partHolder2, RendererUtils.m20703a((View) v1, partHolder2.f14288c));
            }
            PartHolder.m20682b(partHolder, this.f13438b, v1);
        } catch (Exception e) {
            m19790a(partHolder, e, "unbinding");
        }
    }

    private <P2, V2 extends View> void m19791b(PartHolder<P2, ?, E, V2> partHolder) {
        try {
            PartHolder.m20681b(partHolder, this.f13438b);
            for (PartHolder partHolder2 = partHolder.f14289d; partHolder2 != null; partHolder2 = partHolder2.f14292g) {
                m19791b(partHolder2);
            }
        } catch (Exception e) {
            m19790a(partHolder, e, "releasing");
        }
    }

    private static void m19790a(PartHolder partHolder, Exception exception, String str) {
        String str2;
        if (partHolder == null) {
            str2 = "Null partholder";
        } else if (partHolder.f14286a == null) {
            str2 = partHolder.getClass().getCanonicalName();
        } else {
            str2 = partHolder.f14286a.getClass().getCanonicalName();
        }
        WrappedCorePartException.a(str2, str, exception);
    }
}
