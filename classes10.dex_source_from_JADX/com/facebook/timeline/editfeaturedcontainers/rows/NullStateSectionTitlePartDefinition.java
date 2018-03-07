package com.facebook.timeline.editfeaturedcontainers.rows;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.multirow.parts.ViewPaddingPartDefinition;
import com.facebook.multirow.parts.ViewPaddingPartDefinition.PaddingData;
import com.facebook.resources.ui.FbTextView;
import com.facebook.timeline.editfeaturedcontainers.ui.views.NullStateSectionTitleView;
import javax.inject.Inject;

@ContextScoped
/* compiled from: getOutputStream */
public class NullStateSectionTitlePartDefinition extends MultiRowSinglePartDefinition<Props, Void, AnyEnvironment, NullStateSectionTitleView> {
    public static final ViewType<NullStateSectionTitleView> f10837a = new C15701();
    private static NullStateSectionTitlePartDefinition f10838f;
    private static final Object f10839g = new Object();
    private final Lazy<ClickListenerPartDefinition> f10840b;
    private final ViewPaddingPartDefinition f10841c;
    private final TextPartDefinition f10842d;
    public final Resources f10843e;

    /* compiled from: getOutputStream */
    final class C15701 extends ViewType<NullStateSectionTitleView> {
        C15701() {
        }

        public final View m10960a(Context context) {
            return new NullStateSectionTitleView(context);
        }
    }

    /* compiled from: getOutputStream */
    public class Props {
        public final String f10835a;
        public final OnClickListener f10836b;

        public Props(String str, OnClickListener onClickListener) {
            this.f10835a = str;
            this.f10836b = onClickListener;
        }
    }

    private static NullStateSectionTitlePartDefinition m10962b(InjectorLike injectorLike) {
        return new NullStateSectionTitlePartDefinition(IdBasedLazy.a(injectorLike, 2770), ViewPaddingPartDefinition.a(injectorLike), TextPartDefinition.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike));
    }

    public final Object m10964a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        ViewPaddingPartDefinition viewPaddingPartDefinition = this.f10841c;
        int dimensionPixelSize = this.f10843e.getDimensionPixelSize(2131433933);
        subParts.a(viewPaddingPartDefinition, new PaddingData(dimensionPixelSize, this.f10843e.getDimensionPixelSize(2131433934), dimensionPixelSize, this.f10843e.getDimensionPixelSize(2131433936)));
        subParts.a(2131561741, this.f10842d, props.f10835a);
        if (props.f10836b != null) {
            subParts.a(2131561743, (SinglePartDefinition) this.f10840b.get(), props.f10836b);
        }
        return null;
    }

    public final /* bridge */ /* synthetic */ void m10965a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        Object obj3;
        int a = Logger.a(8, EntryType.MARK_PUSH, 1012383066);
        NullStateSectionTitleView nullStateSectionTitleView = (NullStateSectionTitleView) view;
        if (((Props) obj).f10836b != null) {
            obj3 = 1;
        } else {
            obj3 = null;
        }
        if (obj3 != null) {
            ((FbTextView) nullStateSectionTitleView.f10946b.a()).setVisibility(0);
        } else {
            nullStateSectionTitleView.f10946b.c();
        }
        Logger.a(8, EntryType.MARK_POP, -1223124559, a);
    }

    @Inject
    public NullStateSectionTitlePartDefinition(Lazy<ClickListenerPartDefinition> lazy, ViewPaddingPartDefinition viewPaddingPartDefinition, TextPartDefinition textPartDefinition, Resources resources) {
        this.f10840b = lazy;
        this.f10841c = viewPaddingPartDefinition;
        this.f10842d = textPartDefinition;
        this.f10843e = resources;
    }

    public static NullStateSectionTitlePartDefinition m10961a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            NullStateSectionTitlePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f10839g) {
                NullStateSectionTitlePartDefinition nullStateSectionTitlePartDefinition;
                if (a2 != null) {
                    nullStateSectionTitlePartDefinition = (NullStateSectionTitlePartDefinition) a2.a(f10839g);
                } else {
                    nullStateSectionTitlePartDefinition = f10838f;
                }
                if (nullStateSectionTitlePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10962b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f10839g, b3);
                        } else {
                            f10838f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = nullStateSectionTitlePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType<NullStateSectionTitleView> m10963a() {
        return f10837a;
    }

    public final boolean m10966a(Object obj) {
        return true;
    }
}
