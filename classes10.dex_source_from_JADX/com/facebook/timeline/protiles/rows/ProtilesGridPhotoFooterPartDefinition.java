package com.facebook.timeline.protiles.rows;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
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
import com.facebook.resources.utils.TextViewUtils;
import com.facebook.timeline.protiles.protocol.FetchProtilesGraphQLModels.ProtileItemFieldsModel;
import com.facebook.timeline.protiles.util.ProtilesFriendSubtitleUtil;
import com.facebook.timeline.protiles.views.ProtilesFriendView;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.base.Strings;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: fd */
public class ProtilesGridPhotoFooterPartDefinition extends BaseSinglePartDefinition<Props, State, AnyEnvironment, CustomLinearLayout> {
    private static ProtilesGridPhotoFooterPartDefinition f12214b;
    private static final Object f12215c = new Object();
    private final ProtilesFriendSubtitleUtil f12216a;

    /* compiled from: fd */
    public class Props {
        public final ProtileItemFieldsModel f12209a;
        public final int f12210b;

        public Props(ProtileItemFieldsModel protileItemFieldsModel, int i) {
            this.f12209a = protileItemFieldsModel;
            this.f12210b = i;
        }
    }

    /* compiled from: fd */
    public class State {
        @Nullable
        public final String f12211a;
        @Nullable
        public final String f12212b;
        @Nullable
        public final Drawable f12213c;

        public State(String str, String str2, Drawable drawable) {
            this.f12211a = str;
            this.f12212b = str2;
            this.f12213c = drawable;
        }
    }

    private static ProtilesGridPhotoFooterPartDefinition m12305b(InjectorLike injectorLike) {
        return new ProtilesGridPhotoFooterPartDefinition(ProtilesFriendSubtitleUtil.m12404a(injectorLike));
    }

    public final Object m12306a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Drawable drawable;
        Props props = (Props) obj;
        String a = props.f12209a.m12182d() != null ? props.f12209a.m12182d().m12176a() : null;
        String a2 = this.f12216a.m12408a(props.f12209a);
        ProtilesFriendSubtitleUtil protilesFriendSubtitleUtil = this.f12216a;
        int c = ProtilesFriendSubtitleUtil.m12406c(props.f12209a);
        if (c > 0) {
            drawable = protilesFriendSubtitleUtil.f12368a.getDrawable(c);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        } else {
            drawable = null;
        }
        return new State(a, a2, drawable);
    }

    public final /* bridge */ /* synthetic */ void m12307a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -2029688354);
        State state = (State) obj2;
        ProtilesFriendView protilesFriendView = (ProtilesFriendView) ((CustomLinearLayout) view).getChildAt(((Props) obj).f12210b);
        protilesFriendView.f12405a.setText(state.f12211a);
        CharSequence charSequence = state.f12212b;
        protilesFriendView.f12406b.setVisibility(Strings.isNullOrEmpty(charSequence) ? 4 : 0);
        protilesFriendView.f12406b.setText(charSequence);
        TextViewUtils.b(protilesFriendView.f12406b, state.f12213c, null, null, null);
        Logger.a(8, EntryType.MARK_POP, -1374134993, a);
    }

    @Inject
    public ProtilesGridPhotoFooterPartDefinition(ProtilesFriendSubtitleUtil protilesFriendSubtitleUtil) {
        this.f12216a = protilesFriendSubtitleUtil;
    }

    public static ProtilesGridPhotoFooterPartDefinition m12304a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ProtilesGridPhotoFooterPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12215c) {
                ProtilesGridPhotoFooterPartDefinition protilesGridPhotoFooterPartDefinition;
                if (a2 != null) {
                    protilesGridPhotoFooterPartDefinition = (ProtilesGridPhotoFooterPartDefinition) a2.a(f12215c);
                } else {
                    protilesGridPhotoFooterPartDefinition = f12214b;
                }
                if (protilesGridPhotoFooterPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m12305b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12215c, b3);
                        } else {
                            f12214b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = protilesGridPhotoFooterPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
