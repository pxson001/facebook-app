package com.facebook.search.results.rows.sections.livefeed;

import android.content.Context;
import android.content.res.Resources;
import android.util.AndroidRuntimeException;
import android.view.View;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
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
import com.facebook.multirow.parts.ViewPaddingPartDefinition;
import com.facebook.multirow.parts.ViewPaddingPartDefinition.PaddingData;
import javax.inject.Inject;

@ContextScoped
/* compiled from: Pin */
public class LiveFeedResharedAttachmentBackgroundPartDefinition extends BaseSinglePartDefinition<Position, Integer, AnyEnvironment, View> {
    private static LiveFeedResharedAttachmentBackgroundPartDefinition f24526c;
    private static final Object f24527d = new Object();
    private final Resources f24528a;
    private final ViewPaddingPartDefinition f24529b;

    /* compiled from: Pin */
    /* synthetic */ class C25921 {
        static final /* synthetic */ int[] f24525a = new int[Position.values().length];

        static {
            try {
                f24525a[Position.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f24525a[Position.MIDDLE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f24525a[Position.BOTTOM.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    private static LiveFeedResharedAttachmentBackgroundPartDefinition m27980b(InjectorLike injectorLike) {
        return new LiveFeedResharedAttachmentBackgroundPartDefinition(ResourcesMethodAutoProvider.a(injectorLike), ViewPaddingPartDefinition.a(injectorLike));
    }

    public final Object m27981a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        int dimensionPixelSize;
        int dimensionPixelSize2;
        int dimensionPixelSize3;
        int dimensionPixelSize4;
        int i;
        Position position = (Position) obj;
        switch (C25921.f24525a[position.ordinal()]) {
            case 1:
                dimensionPixelSize = this.f24528a.getDimensionPixelSize(2131432590);
                dimensionPixelSize2 = this.f24528a.getDimensionPixelSize(2131432591);
                dimensionPixelSize3 = this.f24528a.getDimensionPixelSize(2131432589);
                dimensionPixelSize4 = this.f24528a.getDimensionPixelSize(2131432593);
                i = 2130840201;
                break;
            case 2:
                dimensionPixelSize2 = this.f24528a.getDimensionPixelSize(2131432588);
                dimensionPixelSize4 = this.f24528a.getDimensionPixelSize(2131432592);
                dimensionPixelSize3 = this.f24528a.getDimensionPixelSize(2131432589);
                i = 2130840200;
                dimensionPixelSize = dimensionPixelSize2;
                dimensionPixelSize2 = dimensionPixelSize4;
                break;
            case 3:
                dimensionPixelSize = this.f24528a.getDimensionPixelSize(2131432588);
                dimensionPixelSize2 = 0;
                dimensionPixelSize3 = this.f24528a.getDimensionPixelSize(2131432589);
                dimensionPixelSize4 = this.f24528a.getDimensionPixelSize(2131432592);
                i = 2130840198;
                break;
            default:
                throw new AndroidRuntimeException("Invalid parameter forLiveFeedResharedAttachmentBackgroundPartDefinition:  " + position.toString());
        }
        subParts.a(this.f24529b, new PaddingData(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize3, dimensionPixelSize4));
        return Integer.valueOf(i);
    }

    public final /* bridge */ /* synthetic */ void m27982a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 860663196);
        view.setBackgroundResource(((Integer) obj2).intValue());
        Logger.a(8, EntryType.MARK_POP, -12739801, a);
    }

    @Inject
    public LiveFeedResharedAttachmentBackgroundPartDefinition(Resources resources, ViewPaddingPartDefinition viewPaddingPartDefinition) {
        this.f24528a = resources;
        this.f24529b = viewPaddingPartDefinition;
    }

    public static LiveFeedResharedAttachmentBackgroundPartDefinition m27979a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            LiveFeedResharedAttachmentBackgroundPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24527d) {
                LiveFeedResharedAttachmentBackgroundPartDefinition liveFeedResharedAttachmentBackgroundPartDefinition;
                if (a2 != null) {
                    liveFeedResharedAttachmentBackgroundPartDefinition = (LiveFeedResharedAttachmentBackgroundPartDefinition) a2.a(f24527d);
                } else {
                    liveFeedResharedAttachmentBackgroundPartDefinition = f24526c;
                }
                if (liveFeedResharedAttachmentBackgroundPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27980b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24527d, b3);
                        } else {
                            f24526c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = liveFeedResharedAttachmentBackgroundPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
