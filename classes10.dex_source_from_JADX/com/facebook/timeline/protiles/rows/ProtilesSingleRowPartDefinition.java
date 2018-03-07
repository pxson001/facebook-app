package com.facebook.timeline.protiles.rows;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.CanFriendPerson;
import com.facebook.feed.environment.HasImageLoadListener;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
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
import com.facebook.multirow.parts.ViewPaddingPartDefinition;
import com.facebook.multirow.parts.ViewPaddingPartDefinition.PaddingData;
import com.facebook.timeline.protiles.model.ProtilesGridRowData;
import com.facebook.timeline.protiles.model.ProtilesGridRowData.ViewPosition;
import com.facebook.timeline.protiles.protocol.FetchProtilesGraphQLModels.ProtileItemFieldsModel;
import com.facebook.timeline.protiles.rows.ProtilesGridPhotoHeaderPartDefinition.Props;
import com.facebook.timeline.protiles.util.ProtilesImageUtil;
import com.facebook.timeline.protiles.views.ProtilesFriendView;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.CustomViewUtils;
import javax.inject.Inject;

@ContextScoped
/* compiled from: fbPlatformDialogMustClose */
public class ProtilesSingleRowPartDefinition<E extends HasImageLoadListener & CanFriendPerson & HasPrefetcher> extends MultiRowSinglePartDefinition<ProtilesGridRowData, State, E, CustomLinearLayout> {
    public static final ViewType f12334a = new C17481();
    private static final CallerContext f12335b = CallerContext.a(ProtilesSingleRowPartDefinition.class, "timeline");
    private static ProtilesSingleRowPartDefinition f12336h;
    private static final Object f12337i = new Object();
    private final ProtilesImageUtil f12338c;
    private final ProtilesGridPhotoHeaderPartDefinition f12339d;
    private final ProtilesGridPhotoFooterPartDefinition f12340e;
    private final Resources f12341f;
    private final ViewPaddingPartDefinition f12342g;

    /* compiled from: fbPlatformDialogMustClose */
    final class C17481 extends ViewType {
        C17481() {
        }

        public final View m12378a(Context context) {
            CustomLinearLayout customLinearLayout = new CustomLinearLayout(context);
            CustomViewUtils.b(customLinearLayout, new ColorDrawable(-1));
            return customLinearLayout;
        }
    }

    /* compiled from: fbPlatformDialogMustClose */
    public class State {
        public final int f12332a;
        public final int f12333b;

        public State(int i, int i2) {
            this.f12332a = i;
            this.f12333b = i2;
        }
    }

    private static ProtilesSingleRowPartDefinition m12381b(InjectorLike injectorLike) {
        return new ProtilesSingleRowPartDefinition(ProtilesImageUtil.m12423a(injectorLike), ProtilesGridPhotoHeaderPartDefinition.m12312a(injectorLike), ProtilesGridPhotoFooterPartDefinition.m12304a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), ViewPaddingPartDefinition.a(injectorLike));
    }

    public final Object m12383a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ProtilesGridRowData protilesGridRowData = (ProtilesGridRowData) obj;
        subParts.a(this.f12342g, m12379a(protilesGridRowData));
        int dimensionPixelSize = this.f12341f.getDimensionPixelSize(2131433967);
        int min = Math.min(protilesGridRowData.f12118c.size(), 3);
        int b = this.f12338c.m12429b();
        for (int i = 0; i < min; i++) {
            subParts.a(this.f12339d, new Props(protilesGridRowData.f12116a, (ProtileItemFieldsModel) protilesGridRowData.f12118c.get(i), i, b, f12335b));
            subParts.a(this.f12340e, new ProtilesGridPhotoFooterPartDefinition.Props((ProtileItemFieldsModel) protilesGridRowData.f12118c.get(i), i));
        }
        return new State(min, dimensionPixelSize);
    }

    public final /* bridge */ /* synthetic */ void m12384a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1044059263);
        State state = (State) obj2;
        CustomLinearLayout customLinearLayout = (CustomLinearLayout) view;
        for (int childCount = customLinearLayout.getChildCount(); childCount < state.f12332a; childCount++) {
            Context context = customLinearLayout.getContext();
            int i = state.f12333b;
            LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(i, 0, i, 0);
            ProtilesFriendView protilesFriendView = new ProtilesFriendView(context);
            protilesFriendView.setLayoutParams(layoutParams);
            customLinearLayout.addView(protilesFriendView);
        }
        Logger.a(8, EntryType.MARK_POP, 87095760, a);
    }

    public final boolean m12385a(Object obj) {
        return !((ProtilesGridRowData) obj).f12118c.isEmpty();
    }

    public static ProtilesSingleRowPartDefinition m12380a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ProtilesSingleRowPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12337i) {
                ProtilesSingleRowPartDefinition protilesSingleRowPartDefinition;
                if (a2 != null) {
                    protilesSingleRowPartDefinition = (ProtilesSingleRowPartDefinition) a2.a(f12337i);
                } else {
                    protilesSingleRowPartDefinition = f12336h;
                }
                if (protilesSingleRowPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m12381b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12337i, b3);
                        } else {
                            f12336h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = protilesSingleRowPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public ProtilesSingleRowPartDefinition(ProtilesImageUtil protilesImageUtil, ProtilesGridPhotoHeaderPartDefinition protilesGridPhotoHeaderPartDefinition, ProtilesGridPhotoFooterPartDefinition protilesGridPhotoFooterPartDefinition, Resources resources, ViewPaddingPartDefinition viewPaddingPartDefinition) {
        this.f12338c = protilesImageUtil;
        this.f12339d = protilesGridPhotoHeaderPartDefinition;
        this.f12340e = protilesGridPhotoFooterPartDefinition;
        this.f12341f = resources;
        this.f12342g = viewPaddingPartDefinition;
    }

    public final ViewType m12382a() {
        return f12334a;
    }

    private PaddingData m12379a(ProtilesGridRowData protilesGridRowData) {
        int i;
        int i2 = 0;
        int dimensionPixelSize = this.f12341f.getDimensionPixelSize(2131433967);
        int dimensionPixelSize2 = this.f12341f.getDimensionPixelSize(2131433966);
        if (protilesGridRowData.f12117b == ViewPosition.TOP_ROW) {
            i = 0;
        } else {
            i = dimensionPixelSize;
        }
        if (protilesGridRowData.f12117b != ViewPosition.BOTTOM_ROW) {
            i2 = dimensionPixelSize;
        }
        return new PaddingData(dimensionPixelSize2, i, dimensionPixelSize2, i2);
    }
}
