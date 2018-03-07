package com.facebook.gametime.ui.components.partdefinition.table;

import android.content.Context;
import android.graphics.Paint;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.gametime.ui.components.partdefinition.table.GametimeTableRowComponentPartDefinition.Props;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.multirow.api.MultiRowPartWithIsNeeded;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.common.ReactionDividerUnitComponentPartDefinition;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLInterfaces.ReactionUnitGametimeTableComponentFragment.TypedData;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLModels.ReactionUnitGametimeTableComponentFragmentModel.TypedDataModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: StringValue */
public class GametimeTableUnitComponentPartDefinition<E extends HasContext> extends BaseMultiRowGroupPartDefinition<ReactionUnitComponentNode, State, E> {
    @ColorRes
    private static final int f25281a = 2131361974;
    @ColorRes
    private static final int f25282b = 2131361921;
    @DimenRes
    public static final int f25283c = 2131427400;
    @DimenRes
    public static final int f25284d = 2131427402;
    private static GametimeTableUnitComponentPartDefinition f25285g;
    private static final Object f25286h = new Object();
    private final Provider<GametimeTableRowComponentPartDefinition> f25287e;
    private final Provider<ReactionDividerUnitComponentPartDefinition> f25288f;

    /* compiled from: StringValue */
    public class State {
        final /* synthetic */ GametimeTableUnitComponentPartDefinition f25279a;
        public final int[] f25280b;

        public State(GametimeTableUnitComponentPartDefinition gametimeTableUnitComponentPartDefinition, ImmutableList<String> immutableList, ImmutableList<? extends TypedData> immutableList2, Context context) {
            this.f25279a = gametimeTableUnitComponentPartDefinition;
            Paint paint = new Paint();
            paint.setTextSize(context.getResources().getDimension(2131427402));
            int size = !immutableList.isEmpty() ? immutableList.size() : ((TypedDataModel) immutableList2.get(0)).a().size();
            this.f25280b = new int[size];
            for (int i = 0; i < size; i++) {
                if (!immutableList.isEmpty()) {
                    paint.setTextSize(context.getResources().getDimension(GametimeTableUnitComponentPartDefinition.f25283c));
                    this.f25280b[i] = (int) paint.measureText((String) immutableList.get(i));
                }
                int size2 = immutableList2.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    TypedDataModel typedDataModel = (TypedDataModel) immutableList2.get(i2);
                    paint.setTextSize(context.getResources().getDimension(GametimeTableUnitComponentPartDefinition.f25284d));
                    this.f25280b[i] = Math.max(this.f25280b[i], (int) paint.measureText((String) typedDataModel.a().get(i)));
                }
            }
        }
    }

    private static GametimeTableUnitComponentPartDefinition m27211b(InjectorLike injectorLike) {
        return new GametimeTableUnitComponentPartDefinition(IdBasedProvider.a(injectorLike, 6788), IdBasedProvider.a(injectorLike, 9861));
    }

    public final Object m27212a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        HasContext hasContext = (HasContext) anyEnvironment;
        ImmutableList cY = reactionUnitComponentNode.b.cY();
        ImmutableList cX = reactionUnitComponentNode.f().cX();
        State state = new State(this, cY, cX, hasContext.getContext());
        baseMultiRowSubParts.a((MultiRowPartWithIsNeeded) this.f25287e.get(), new Props(cY, state.f25280b, f25281a, f25283c));
        baseMultiRowSubParts.a((MultiRowPartWithIsNeeded) this.f25288f.get(), null);
        int size = cX.size();
        for (int i = 0; i < size; i++) {
            baseMultiRowSubParts.a((MultiRowPartWithIsNeeded) this.f25287e.get(), new Props(((TypedDataModel) cX.get(i)).a(), state.f25280b, f25282b, f25284d));
            baseMultiRowSubParts.a((MultiRowPartWithIsNeeded) this.f25288f.get(), null);
        }
        return state;
    }

    public final boolean m27213a(Object obj) {
        ReactionUnitComponentFields reactionUnitComponentFields = ((ReactionUnitComponentNode) obj).b;
        if (reactionUnitComponentFields.cY().isEmpty() && reactionUnitComponentFields.cX().isEmpty()) {
            return false;
        }
        boolean z;
        ImmutableList cY = reactionUnitComponentFields.cY();
        ImmutableList cX = reactionUnitComponentFields.cX();
        int size = !cY.isEmpty() ? cY.size() : ((TypedDataModel) cX.get(0)).a().size();
        int size2 = cX.size();
        for (int i = 0; i < size2; i++) {
            if (((TypedDataModel) cX.get(i)).a().size() != size) {
                z = false;
                break;
            }
        }
        z = true;
        return z;
    }

    @Inject
    public GametimeTableUnitComponentPartDefinition(Provider<GametimeTableRowComponentPartDefinition> provider, Provider<ReactionDividerUnitComponentPartDefinition> provider2) {
        this.f25287e = provider;
        this.f25288f = provider2;
    }

    public static GametimeTableUnitComponentPartDefinition m27210a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GametimeTableUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f25286h) {
                GametimeTableUnitComponentPartDefinition gametimeTableUnitComponentPartDefinition;
                if (a2 != null) {
                    gametimeTableUnitComponentPartDefinition = (GametimeTableUnitComponentPartDefinition) a2.a(f25286h);
                } else {
                    gametimeTableUnitComponentPartDefinition = f25285g;
                }
                if (gametimeTableUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27211b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f25286h, b3);
                        } else {
                            f25285g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = gametimeTableUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
