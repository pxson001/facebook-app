package com.facebook.richdocument.view.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.richdocument.view.RichDocumentUIConfig;
import com.facebook.widget.CustomViewGroup;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;

@ContextScoped
/* compiled from: operation params are null */
public class CompositeRecyclableViewFactory {
    private static CompositeRecyclableViewFactory f7046c;
    private static final Object f7047d = new Object();
    public final Context f7048a;
    public final Map<Integer, RecyclableViewFactory> f7049b = new HashMap();

    /* compiled from: operation params are null */
    public interface RecyclableView {
        void mo437a();
    }

    /* compiled from: operation params are null */
    public class RecyclableViewFactory<V extends RecyclableView> {
        private final int f7040a;
        private final ViewGroup f7041b;
        private final LayoutInflater f7042c;
        public final List<V> f7043d;
        public final Set<V> f7044e;
        private final int f7045f;

        public RecyclableViewFactory(int i, LayoutInflater layoutInflater, ViewGroup viewGroup, int i2) {
            if (i == 0) {
                throw new IllegalArgumentException("Provide valid layout resource id");
            } else if (layoutInflater == null) {
                throw new IllegalArgumentException("Layout inflater cannot be null");
            } else if (viewGroup == null) {
                throw new IllegalArgumentException("A valid parent ViewGroup is required");
            } else {
                this.f7040a = i;
                this.f7042c = layoutInflater;
                this.f7041b = viewGroup;
                this.f7045f = i2;
                this.f7043d = new ArrayList(this.f7045f);
                this.f7044e = new HashSet(this.f7045f);
            }
        }

        public final int m7354a(int i) {
            if (this.f7043d.size() + i > this.f7045f) {
                i = this.f7045f - this.f7043d.size();
            }
            for (int i2 = 0; i2 < i; i2++) {
                this.f7043d.add(m7353b());
            }
            return i;
        }

        private V m7353b() {
            RecyclableView recyclableView = (RecyclableView) this.f7042c.inflate(this.f7040a, this.f7041b, false);
            this.f7044e.add(recyclableView);
            return recyclableView;
        }

        public final V m7355a() {
            if (this.f7043d.isEmpty()) {
                return m7353b();
            }
            return (RecyclableView) this.f7043d.remove(this.f7043d.size() - 1);
        }
    }

    private static CompositeRecyclableViewFactory m7357b(InjectorLike injectorLike) {
        return new CompositeRecyclableViewFactory((Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public CompositeRecyclableViewFactory(Context context) {
        this.f7048a = context;
        LayoutInflater from = LayoutInflater.from(this.f7048a);
        this.f7049b.put(Integer.valueOf(2130906884), new RecyclableViewFactory(2130906884, from, new CustomViewGroup(this.f7048a), RichDocumentUIConfig.f6532C));
        this.f7049b.put(Integer.valueOf(2130906862), new RecyclableViewFactory(2130906862, from, new CustomViewGroup(this.f7048a), RichDocumentUIConfig.f6533D));
        this.f7049b.put(Integer.valueOf(2130906878), new RecyclableViewFactory(2130906878, from, new CustomViewGroup(this.f7048a), RichDocumentUIConfig.f6534E));
    }

    public static CompositeRecyclableViewFactory m7356a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            CompositeRecyclableViewFactory b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f7047d) {
                CompositeRecyclableViewFactory compositeRecyclableViewFactory;
                if (a2 != null) {
                    compositeRecyclableViewFactory = (CompositeRecyclableViewFactory) a2.a(f7047d);
                } else {
                    compositeRecyclableViewFactory = f7046c;
                }
                if (compositeRecyclableViewFactory == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m7357b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f7047d, b3);
                        } else {
                            f7046c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = compositeRecyclableViewFactory;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final View m7358a(int i) {
        if (this.f7049b.containsKey(Integer.valueOf(i))) {
            return (View) ((RecyclableViewFactory) this.f7049b.get(Integer.valueOf(i))).m7355a();
        }
        return null;
    }
}
