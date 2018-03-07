package com.facebook.feed.rows.core.parts;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.feed.rows.core.analytics.MultiRowPerfLogger;
import com.facebook.feed.rows.core.binding.Binder;
import com.facebook.feed.rows.core.traversal.GroupPartRenderer;
import com.facebook.feed.rows.core.traversal.SinglePartHolder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.MultiRowGroupPartDefinition;
import com.facebook.multirow.api.SinglePartDefinitionWithViewType;
import com.facebook.multirow.api.SinglePartDefinitionWithViewTypeAndIsNeeded;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;

/* compiled from: WWW_TIMELINE */
public class ViewGroupRenderer {

    /* compiled from: WWW_TIMELINE */
    final class C11281 implements SinglePartDefinitionWithViewType<P, Binder<ViewGroup>, E, V> {
        final /* synthetic */ ViewType f12259a;
        final /* synthetic */ MultiRowGroupPartDefinition f12260b;
        final /* synthetic */ Context f12261c;
        final /* synthetic */ MultiRowPerfLogger f12262d;

        C11281(ViewType viewType, MultiRowGroupPartDefinition multiRowGroupPartDefinition, Context context, MultiRowPerfLogger multiRowPerfLogger) {
            this.f12259a = viewType;
            this.f12260b = multiRowGroupPartDefinition;
            this.f12261c = context;
            this.f12262d = multiRowPerfLogger;
        }

        public final void m20287a(Object obj, Object obj2, AnyEnvironment anyEnvironment) {
            ((Binder) obj2).b(anyEnvironment);
        }

        public final /* bridge */ /* synthetic */ void m20288a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
            int a = Logger.a(8, EntryType.MARK_PUSH, 169836389);
            ((Binder) obj2).a((ViewGroup) view);
            Logger.a(8, EntryType.MARK_POP, -1174658832, a);
        }

        public final void m20289b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
            ((Binder) obj2).b((ViewGroup) view);
        }

        public final ViewType m20285a() {
            return this.f12259a;
        }

        public final Object m20286a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
            Binder c11292 = new C11292(this.f12260b, obj, this.f12262d, this.f12261c);
            c11292.a(anyEnvironment);
            return c11292;
        }
    }

    /* compiled from: WWW_TIMELINE */
    public final class C11292 extends Binder<V> {
        final List<View> f12263a = new ArrayList();
        ImmutableList<SinglePartHolder<?, ?, ?, ?>> f12264b;
        final /* synthetic */ MultiRowGroupPartDefinition f12265c;
        final /* synthetic */ Object f12266d;
        final /* synthetic */ MultiRowPerfLogger f12267e;
        final /* synthetic */ Context f12268f;

        public C11292(MultiRowGroupPartDefinition multiRowGroupPartDefinition, Object obj, MultiRowPerfLogger multiRowPerfLogger, Context context) {
            this.f12265c = multiRowGroupPartDefinition;
            this.f12266d = obj;
            this.f12267e = multiRowPerfLogger;
            this.f12268f = context;
        }

        public final void m20290a(View view) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < this.f12264b.size(); i++) {
                ((SinglePartHolder) this.f12264b.get(i)).a((View) this.f12263a.get(i));
                viewGroup.addView((View) this.f12263a.get(i));
            }
        }

        public final void m20292b(View view) {
            ((ViewGroup) view).removeAllViews();
            for (int i = 0; i < this.f12264b.size(); i++) {
                ((SinglePartHolder) this.f12264b.get(i)).b((View) this.f12263a.get(i));
            }
        }

        public final void m20291a(AnyEnvironment anyEnvironment) {
            int i;
            int i2 = 0;
            this.f12264b = GroupPartRenderer.a(this.f12265c, this.f12266d, anyEnvironment, this.f12267e);
            int size = this.f12264b.size();
            for (i = 0; i < size; i++) {
                this.f12263a.add(((SinglePartHolder) this.f12264b.get(i)).b().a(this.f12268f));
            }
            i = this.f12264b.size();
            while (i2 < i) {
                ((SinglePartHolder) this.f12264b.get(i2)).a(anyEnvironment);
                i2++;
            }
        }

        public final void m20293b(AnyEnvironment anyEnvironment) {
            int size = this.f12264b.size();
            for (int i = 0; i < size; i++) {
                ((SinglePartHolder) this.f12264b.get(i)).b(anyEnvironment);
            }
        }
    }

    public static <P, E extends AnyEnvironment, V extends ViewGroup> SinglePartDefinitionWithViewType<P, ?, ? super E, V> m20294a(SinglePartDefinitionWithViewTypeAndIsNeeded<P, ?, E, ?> singlePartDefinitionWithViewTypeAndIsNeeded, ViewType viewType, Context context, MultiRowPerfLogger multiRowPerfLogger) {
        return m20295a(new SingleChildMultiRowGroupPartDefinition(singlePartDefinitionWithViewTypeAndIsNeeded), viewType, context, multiRowPerfLogger);
    }

    public static <P, E extends AnyEnvironment, V extends ViewGroup> SinglePartDefinitionWithViewType<P, ?, ? super E, V> m20295a(MultiRowGroupPartDefinition<P, ?, E> multiRowGroupPartDefinition, ViewType viewType, Context context, MultiRowPerfLogger multiRowPerfLogger) {
        return new C11281(viewType, multiRowGroupPartDefinition, context, multiRowPerfLogger);
    }
}
