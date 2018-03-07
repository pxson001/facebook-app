package com.facebook.components.feed;

import android.content.Context;
import android.view.View;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentTree;
import com.facebook.components.feed.api.ComponentPart;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.analytics.HasIsAsync;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectableComponentWithoutContext;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;

/* compiled from: transliterator_more_cancelled */
public abstract class EmbeddedComponentPartDefinition<P, E extends HasContext & HasIsAsync & HasPersistentState> extends BaseSinglePartDefinition<P, ComponentTree, E, FeedComponentView> implements ComponentPart<P, E>, InjectableComponentWithoutContext {
    public ComponentPartHelper<P, E> f1207a;
    private final String f1208b = getClass().getSimpleName();

    public static void m1265a(Object obj, Context context) {
        ((EmbeddedComponentPartDefinition) obj).f1207a = ComponentPartHelper.a(FbInjector.get(context));
    }

    public abstract Component<?> m1266a(ComponentContext componentContext, P p, E e);

    public final Object m1268a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        return this.f1207a.a(subParts, obj, (HasContext) anyEnvironment, this.f1208b, this);
    }

    public final /* bridge */ /* synthetic */ void m1270a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 182213460);
        ((FeedComponentView) view).setComponent((ComponentTree) obj2);
        Logger.a(8, EntryType.MARK_POP, 619414172, a);
    }

    public final void m1273b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((FeedComponentView) view).f();
    }

    public EmbeddedComponentPartDefinition(Context context) {
        Class cls = EmbeddedComponentPartDefinition.class;
        m1265a((Object) this, context);
    }

    public final boolean m1271a(AnyEnvironment anyEnvironment) {
        return false;
    }

    public final CacheableEntity m1272b(P p) {
        return null;
    }

    public final void m1269a(SubParts<E> subParts, P p) {
    }
}
