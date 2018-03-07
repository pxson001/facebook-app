package com.facebook.timeline.favmediapicker.rows.parts;

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
import com.facebook.timeline.favmediapicker.ui.views.SectionTitleView;
import javax.inject.Inject;

@ContextScoped
/* compiled from: friends_nearby_settings */
public class SectionTitlePartDefinition extends MultiRowSinglePartDefinition<Props, Void, AnyEnvironment, SectionTitleView> {
    public static final ViewType<SectionTitleView> f11082a = new C16031();
    private static SectionTitlePartDefinition f11083f;
    private static final Object f11084g = new Object();
    private final Lazy<ClickListenerPartDefinition> f11085b;
    private final ViewPaddingPartDefinition f11086c;
    private final TextPartDefinition f11087d;
    public final Resources f11088e;

    /* compiled from: friends_nearby_settings */
    final class C16031 extends ViewType<SectionTitleView> {
        C16031() {
        }

        public final View m11247a(Context context) {
            return new SectionTitleView(context);
        }
    }

    /* compiled from: friends_nearby_settings */
    public class Props {
        public final String f11080a;
        public final OnClickListener f11081b;

        public Props(String str, OnClickListener onClickListener) {
            this.f11080a = str;
            this.f11081b = onClickListener;
        }
    }

    private static SectionTitlePartDefinition m11249b(InjectorLike injectorLike) {
        return new SectionTitlePartDefinition(IdBasedLazy.a(injectorLike, 2770), ViewPaddingPartDefinition.a(injectorLike), TextPartDefinition.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike));
    }

    public final Object m11251a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        ViewPaddingPartDefinition viewPaddingPartDefinition = this.f11086c;
        int dimensionPixelSize = this.f11088e.getDimensionPixelSize(2131433941);
        subParts.a(viewPaddingPartDefinition, new PaddingData(dimensionPixelSize, this.f11088e.getDimensionPixelSize(2131433942), dimensionPixelSize, this.f11088e.getDimensionPixelSize(2131433944)));
        subParts.a(2131561741, this.f11087d, props.f11080a);
        if (props.f11081b != null) {
            subParts.a(2131561743, (SinglePartDefinition) this.f11085b.get(), props.f11081b);
        }
        return null;
    }

    public final /* bridge */ /* synthetic */ void m11252a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        Object obj3;
        int a = Logger.a(8, EntryType.MARK_PUSH, -461202461);
        SectionTitleView sectionTitleView = (SectionTitleView) view;
        if (((Props) obj).f11081b != null) {
            obj3 = 1;
        } else {
            obj3 = null;
        }
        if (obj3 != null) {
            ((FbTextView) sectionTitleView.f11131b.a()).setVisibility(0);
            ((FbTextView) sectionTitleView.f11131b.a()).setTransformationMethod(sectionTitleView.f11130a);
        } else {
            sectionTitleView.f11131b.c();
        }
        Logger.a(8, EntryType.MARK_POP, -193787205, a);
    }

    @Inject
    public SectionTitlePartDefinition(Lazy<ClickListenerPartDefinition> lazy, ViewPaddingPartDefinition viewPaddingPartDefinition, TextPartDefinition textPartDefinition, Resources resources) {
        this.f11085b = lazy;
        this.f11086c = viewPaddingPartDefinition;
        this.f11087d = textPartDefinition;
        this.f11088e = resources;
    }

    public static SectionTitlePartDefinition m11248a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SectionTitlePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f11084g) {
                SectionTitlePartDefinition sectionTitlePartDefinition;
                if (a2 != null) {
                    sectionTitlePartDefinition = (SectionTitlePartDefinition) a2.a(f11084g);
                } else {
                    sectionTitlePartDefinition = f11083f;
                }
                if (sectionTitlePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m11249b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f11084g, b3);
                        } else {
                            f11083f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = sectionTitlePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType<SectionTitleView> m11250a() {
        return f11082a;
    }

    public final boolean m11253a(Object obj) {
        return true;
    }
}
