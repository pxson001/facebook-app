package com.facebook.feedplugins.richmedia;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import com.facebook.common.android.WindowManagerMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLStoryAttachment;
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
import javax.inject.Inject;

@ContextScoped
/* compiled from: bundle_source */
public class RichMediaVideoDimensionsPartDefinition extends BaseSinglePartDefinition<GraphQLStoryAttachment, State, AnyEnvironment, RichMediaVideoAttachmentView> {
    private static RichMediaVideoDimensionsPartDefinition f9249b;
    private static final Object f9250c = new Object();
    public final WindowManager f9251a;

    /* compiled from: bundle_source */
    public final class State {
        public final int f9245a;
        public final int f9246b;
        public final int f9247c;
        public final int f9248d;

        public State(int i, int i2, int i3, int i4) {
            this.f9245a = i;
            this.f9246b = i2;
            this.f9247c = i3;
            this.f9248d = i4;
        }
    }

    private static RichMediaVideoDimensionsPartDefinition m9890b(InjectorLike injectorLike) {
        return new RichMediaVideoDimensionsPartDefinition(WindowManagerMethodAutoProvider.b(injectorLike));
    }

    public final Object m9891a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) obj;
        Display defaultDisplay = this.f9251a.getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        int i = point.x;
        GraphQLMedia r = graphQLStoryAttachment.r();
        int R = (int) ((((float) r.R()) / ((float) r.bo())) * ((float) i));
        return new State(i, Math.min(i, R), i, R);
    }

    public final /* bridge */ /* synthetic */ void m9892a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -118171776);
        State state = (State) obj2;
        RichMediaVideoAttachmentView richMediaVideoAttachmentView = (RichMediaVideoAttachmentView) view;
        int i = state.f9245a;
        int i2 = state.f9246b;
        LayoutParams layoutParams = richMediaVideoAttachmentView.f9231b.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LayoutParams(i, i2);
        }
        layoutParams.height = i2;
        layoutParams.width = i;
        richMediaVideoAttachmentView.f9231b.setLayoutParams(layoutParams);
        richMediaVideoAttachmentView.f9236g = ((double) state.f9247c) / ((double) state.f9248d);
        Logger.a(8, EntryType.MARK_POP, 1919786689, a);
    }

    @Inject
    public RichMediaVideoDimensionsPartDefinition(WindowManager windowManager) {
        this.f9251a = windowManager;
    }

    public static RichMediaVideoDimensionsPartDefinition m9889a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            RichMediaVideoDimensionsPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9250c) {
                RichMediaVideoDimensionsPartDefinition richMediaVideoDimensionsPartDefinition;
                if (a2 != null) {
                    richMediaVideoDimensionsPartDefinition = (RichMediaVideoDimensionsPartDefinition) a2.a(f9250c);
                } else {
                    richMediaVideoDimensionsPartDefinition = f9249b;
                }
                if (richMediaVideoDimensionsPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9890b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9250c, b3);
                        } else {
                            f9249b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = richMediaVideoDimensionsPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
