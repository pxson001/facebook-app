package com.facebook.feed.rows.sections.header.ui;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

@ContextScoped
/* compiled from: href=["\']([^"\']+\.css(\?[^"\']*)?)["\'] */
public class ClientSideBumpIconIndicatorDefinition<V extends View & ClientSideIconIndicator> extends BaseSinglePartDefinition<FeedUnit, State, AnyEnvironment, V> {
    private static ClientSideBumpIconIndicatorDefinition f20803c;
    private static final Object f20804d = new Object();
    public boolean f20805a = false;
    private final SimpleDateFormat f20806b = new SimpleDateFormat("dd HH:mm", Locale.US);

    private static ClientSideBumpIconIndicatorDefinition m28528b() {
        return new ClientSideBumpIconIndicatorDefinition();
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedUnit feedUnit = (FeedUnit) obj;
        String str = null;
        if (feedUnit != null) {
            String str2 = "";
            MutableFlatBuffer w_ = feedUnit.w_();
            if (w_ != null) {
                CharSequence charSequence = (String) w_.m21541b(3);
                if (!StringUtil.m3589a(charSequence)) {
                    Calendar instance = Calendar.getInstance();
                    instance.setTimeInMillis(Long.parseLong(charSequence));
                    str = this.f20806b.format(instance.getTime());
                }
            }
            str = str2;
        }
        return new State(str);
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -508444825);
        view.post(new 1(this, (FeedUnit) obj, view, (State) obj2));
        Logger.a(8, EntryType.MARK_POP, -144166744, a);
    }

    public final void m28530a() {
        this.f20805a = true;
    }

    public static ClientSideBumpIconIndicatorDefinition m28527a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ClientSideBumpIconIndicatorDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20804d) {
                ClientSideBumpIconIndicatorDefinition clientSideBumpIconIndicatorDefinition;
                if (a2 != null) {
                    clientSideBumpIconIndicatorDefinition = (ClientSideBumpIconIndicatorDefinition) a2.mo818a(f20804d);
                } else {
                    clientSideBumpIconIndicatorDefinition = f20803c;
                }
                if (clientSideBumpIconIndicatorDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.m1474e();
                        b3 = m28528b();
                        if (a2 != null) {
                            a2.mo822a(f20804d, b3);
                        } else {
                            f20803c = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = clientSideBumpIconIndicatorDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
