package com.facebook.feed.inlinecomposer.multirow.work;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.inlinecomposer.model.WorkComposerModel;
import com.facebook.feed.inlinecomposer.work.WorkHeaderGroupsActionHandler;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.widget.hscrollrecyclerview.HScrollRecyclerView;
import javax.inject.Inject;

@ContextScoped
/* compiled from: muted_until2 */
public class InlineComposerHscrollRecyclerViewPartDefinition extends MultiRowSinglePartDefinition<WorkComposerModel, State, HasPositionInformation, HScrollRecyclerView> {
    public static final ViewType<HScrollRecyclerView> f13091a = new C05301();
    private static InlineComposerHscrollRecyclerViewPartDefinition f13092h;
    private static final Object f13093i = new Object();
    private final BackgroundPartDefinition f13094b;
    private final PaddingStyle f13095c = Builder.m19303c().m19313i();
    private final WorkGroupsPogRecyclerViewAdapterProvider f13096d;
    private final WorkPogHScrollDividerDecorator f13097e;
    public final WorkHeaderGroupsActionHandler f13098f;
    public final int f13099g;

    /* compiled from: muted_until2 */
    final class C05301 extends ViewType<HScrollRecyclerView> {
        C05301() {
        }

        public final View mo1995a(Context context) {
            return new HScrollRecyclerView(context);
        }
    }

    private static InlineComposerHscrollRecyclerViewPartDefinition m19317b(InjectorLike injectorLike) {
        return new InlineComposerHscrollRecyclerViewPartDefinition(BackgroundPartDefinition.m19135a(injectorLike), (WorkGroupsPogRecyclerViewAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(WorkGroupsPogRecyclerViewAdapterProvider.class), new WorkPogHScrollDividerDecorator(ResourcesMethodAutoProvider.m6510a(injectorLike)), WorkHeaderGroupsActionHandler.m19209b(injectorLike), ResourcesMethodAutoProvider.m6510a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        WorkComposerModel workComposerModel = (WorkComposerModel) obj;
        subParts.mo2756a(this.f13094b, new StylingData(this.f13095c));
        return new State(new WorkGroupsPogRecyclerViewAdapter(workComposerModel.f12922b, new 2(this), (Context) this.f13096d.getInstance(Context.class)), this.f13097e);
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1769870701);
        WorkComposerModel workComposerModel = (WorkComposerModel) obj;
        State state = (State) obj2;
        HScrollRecyclerView hScrollRecyclerView = (HScrollRecyclerView) view;
        hScrollRecyclerView.setAdapter(state.a);
        hScrollRecyclerView.m17145a(state.b);
        hScrollRecyclerView.g(this.f13099g, workComposerModel.f12923c);
        Logger.a(8, EntryType.MARK_POP, -1348859214, a);
    }

    public final void mo2544b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        State state = (State) obj2;
        HScrollRecyclerView hScrollRecyclerView = (HScrollRecyclerView) view;
        hScrollRecyclerView.setAdapter(null);
        hScrollRecyclerView.m17153b(state.b);
    }

    public static InlineComposerHscrollRecyclerViewPartDefinition m19316a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            InlineComposerHscrollRecyclerViewPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f13093i) {
                InlineComposerHscrollRecyclerViewPartDefinition inlineComposerHscrollRecyclerViewPartDefinition;
                if (a2 != null) {
                    inlineComposerHscrollRecyclerViewPartDefinition = (InlineComposerHscrollRecyclerViewPartDefinition) a2.mo818a(f13093i);
                } else {
                    inlineComposerHscrollRecyclerViewPartDefinition = f13092h;
                }
                if (inlineComposerHscrollRecyclerViewPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m19317b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f13093i, b3);
                        } else {
                            f13092h = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = inlineComposerHscrollRecyclerViewPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public InlineComposerHscrollRecyclerViewPartDefinition(BackgroundPartDefinition backgroundPartDefinition, WorkGroupsPogRecyclerViewAdapterProvider workGroupsPogRecyclerViewAdapterProvider, WorkPogHScrollDividerDecorator workPogHScrollDividerDecorator, WorkHeaderGroupsActionHandler workHeaderGroupsActionHandler, Resources resources) {
        this.f13094b = backgroundPartDefinition;
        this.f13096d = workGroupsPogRecyclerViewAdapterProvider;
        this.f13097e = workPogHScrollDividerDecorator;
        this.f13098f = workHeaderGroupsActionHandler;
        this.f13099g = resources.getDimensionPixelSize(2131430510);
    }

    public final boolean m19321a(Object obj) {
        return true;
    }

    public final ViewType<HScrollRecyclerView> mo2547a() {
        return f13091a;
    }
}
