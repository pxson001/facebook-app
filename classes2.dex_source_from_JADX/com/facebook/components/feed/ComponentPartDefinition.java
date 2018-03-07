package com.facebook.components.feed;

import android.content.Context;
import android.view.View;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentTree;
import com.facebook.components.ComponentView;
import com.facebook.components.feed.api.ComponentPart;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.analytics.HasIsAsync;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectableComponentWithoutContext;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;

/* compiled from: image_seen_state */
public abstract class ComponentPartDefinition<P, E extends HasContext & HasIsAsync & HasPersistentState> extends MultiRowSinglePartDefinition<P, ComponentTree, E, ComponentView> implements ComponentPart<P, E>, InjectableComponentWithoutContext {
    public static final ViewType f20386a = new C08251();
    public ComponentPartHelper<P, E> f20387b;
    private final String f20388c = getClass().getSimpleName();

    /* compiled from: image_seen_state */
    final class C08251 extends ViewType {
        C08251() {
        }

        public final View mo1995a(Context context) {
            return new FeedComponentView(context);
        }
    }

    public static void m28091a(Object obj, Context context) {
        ((ComponentPartDefinition) obj).f20387b = ComponentPartHelper.m28376a(FbInjector.get(context));
    }

    public abstract Component<?> mo3129a(ComponentContext componentContext, P p, E e);

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        return this.f20387b.m28382a(subParts, obj, (HasContext) anyEnvironment, this.f20388c, (ComponentPart) this);
    }

    public final void mo2542a(Object obj, Object obj2, AnyEnvironment anyEnvironment) {
        this.f20387b.m28383a((HasContext) anyEnvironment, (ComponentTree) obj2, obj, this.f20388c, (ComponentPart) this);
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -305063952);
        ((ComponentView) view).setComponent((ComponentTree) obj2);
        Logger.a(8, EntryType.MARK_POP, -1835549310, a);
    }

    public final void mo2544b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((ComponentView) view).m30430f();
    }

    public ComponentPartDefinition(Context context) {
        Class cls = ComponentPartDefinition.class;
        m28091a((Object) this, context);
    }

    public ViewType mo2547a() {
        return f20386a;
    }

    public boolean m28099a(E e) {
        return false;
    }

    public void mo3132a(SubParts<E> subParts, P p) {
    }
}
