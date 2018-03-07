package com.facebook.feedplugins.worktrending.rows;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.feedplugins.worktrending.rows.WorkTrendingExpandableListPartDefinition.C11571;
import com.facebook.feedplugins.worktrending.rows.WorkTrendingExpandableListPartDefinition.WorkTrendingExpandableListPersistentKey;
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
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: android.bluetooth.adapter.extra.STATE */
public class WorkTrendingFooterPartDefinition extends MultiRowSinglePartDefinition<Props, Void, HasPositionInformation, TextView> {
    public static final ViewType f10006a = new C11581();
    private static final PaddingStyle f10007c;
    private static WorkTrendingFooterPartDefinition f10008f;
    private static final Object f10009g = new Object();
    public final Resources f10010b;
    private BackgroundPartDefinition f10011d;
    private ClickListenerPartDefinition f10012e;

    /* compiled from: android.bluetooth.adapter.extra.STATE */
    final class C11581 extends ViewType {
        C11581() {
        }

        public final View m10358a(Context context) {
            View textView = new TextView(context);
            textView.setGravity(1);
            return textView;
        }
    }

    /* compiled from: android.bluetooth.adapter.extra.STATE */
    public class Props {
        public final C11571 f10004a;
        public final boolean f10005b;

        public Props(boolean z, C11571 c11571) {
            this.f10005b = z;
            this.f10004a = c11571;
        }
    }

    private static WorkTrendingFooterPartDefinition m10360b(InjectorLike injectorLike) {
        return new WorkTrendingFooterPartDefinition(BackgroundPartDefinition.a(injectorLike), ClickListenerPartDefinition.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike));
    }

    public final Object m10362a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final Props props = (Props) obj;
        subParts.a(this.f10011d, new StylingData(f10007c));
        subParts.a(this.f10012e, new OnClickListener(this) {
            final /* synthetic */ WorkTrendingFooterPartDefinition f10003b;

            public void onClick(View view) {
                boolean z;
                int a = Logger.a(2, EntryType.UI_INPUT_START, 736325670);
                C11571 c11571 = props.f10004a;
                WorkTrendingExpandableListPartDefinition workTrendingExpandableListPartDefinition = c11571.f9995d;
                if (c11571.f9995d.f10001c) {
                    z = false;
                } else {
                    z = true;
                }
                workTrendingExpandableListPartDefinition.f10001c = z;
                c11571.f9992a.a(new WorkTrendingExpandableListPersistentKey(c11571.f9993b), Boolean.valueOf(c11571.f9995d.f10001c));
                c11571.f9992a.a(new FeedProps[]{c11571.f9994c});
                Logger.a(2, EntryType.UI_INPUT_END, 1018890774, a);
            }
        });
        return null;
    }

    public final /* bridge */ /* synthetic */ void m10363a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -428294431);
        TextView textView = (TextView) view;
        if (((Props) obj).f10005b) {
            textView.setText(this.f10010b.getString(2131242498));
        } else {
            textView.setText(this.f10010b.getString(2131242497));
        }
        Logger.a(8, EntryType.MARK_POP, -251969186, a);
    }

    static {
        Builder a = Builder.a();
        a.b = 4.0f;
        a = a;
        a.c = 4.0f;
        f10007c = a.i();
    }

    public static WorkTrendingFooterPartDefinition m10359a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            WorkTrendingFooterPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f10009g) {
                WorkTrendingFooterPartDefinition workTrendingFooterPartDefinition;
                if (a2 != null) {
                    workTrendingFooterPartDefinition = (WorkTrendingFooterPartDefinition) a2.a(f10009g);
                } else {
                    workTrendingFooterPartDefinition = f10008f;
                }
                if (workTrendingFooterPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10360b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f10009g, b3);
                        } else {
                            f10008f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = workTrendingFooterPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public WorkTrendingFooterPartDefinition(BackgroundPartDefinition backgroundPartDefinition, ClickListenerPartDefinition clickListenerPartDefinition, Resources resources) {
        this.f10011d = backgroundPartDefinition;
        this.f10012e = clickListenerPartDefinition;
        this.f10010b = resources;
    }

    public final boolean m10364a(Object obj) {
        return true;
    }

    public final ViewType<TextView> m10361a() {
        return f10006a;
    }
}
