package com.facebook.multirow.parts;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.DimenRes;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.feed.environment.HasContext;
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
import com.google.common.base.Preconditions;

@ContextScoped
/* compiled from: numOfAttachments */
public class ImageBlockLayoutThumbnailPartDefinition extends BaseSinglePartDefinition<Props, Drawable, HasContext, ImageBlockLayout> {
    private static ImageBlockLayoutThumbnailPartDefinition f7940a;
    private static final Object f7941b = new Object();

    /* compiled from: numOfAttachments */
    public final class Props {
        public final String f7935a;
        public final Uri f7936b;
        public final int f7937c;
        @DimenRes
        public int f7938d;
        @DimenRes
        public int f7939e;

        /* compiled from: numOfAttachments */
        public final class Builder {
            public String f7930a;
            public Uri f7931b;
            public int f7932c;
            @DimenRes
            public int f7933d;
            @DimenRes
            public int f7934e;

            public final Builder m9563a(String str) {
                Preconditions.checkState(this.f7931b == null, "Thumbnail Uri is already defined.");
                this.f7930a = str;
                return this;
            }

            public final Props m9564a() {
                return new Props(this.f7930a, this.f7931b, this.f7932c, this.f7933d, this.f7934e);
            }
        }

        public Props(String str, Uri uri, int i, @DimenRes int i2, @DimenRes int i3) {
            this.f7935a = str;
            this.f7936b = uri;
            this.f7937c = i;
            this.f7938d = i2;
            this.f7939e = i3;
        }
    }

    private static ImageBlockLayoutThumbnailPartDefinition m9565a() {
        return new ImageBlockLayoutThumbnailPartDefinition();
    }

    public final Object m9567a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        return props.f7937c > 0 ? ((HasContext) anyEnvironment).getContext().getResources().getDrawable(props.f7937c) : null;
    }

    public final /* bridge */ /* synthetic */ void m9568a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 254861792);
        Props props = (Props) obj;
        HasContext hasContext = (HasContext) anyEnvironment;
        ImageBlockLayout imageBlockLayout = (ImageBlockLayout) view;
        imageBlockLayout.setThumbnailPlaceholderDrawable((Drawable) obj2);
        if (props.f7936b != null) {
            imageBlockLayout.setThumbnailUri(props.f7936b);
        }
        if (props.f7935a != null) {
            imageBlockLayout.setThumbnailUri(props.f7935a);
        }
        if (props.f7938d > 0) {
            imageBlockLayout.setThumbnailSize(hasContext.getContext().getResources().getDimensionPixelSize(props.f7938d));
        }
        if (props.f7939e > 0) {
            imageBlockLayout.setThumbnailPadding(hasContext.getContext().getResources().getDimensionPixelSize(props.f7939e));
        }
        Logger.a(8, EntryType.MARK_POP, 1792601727, a);
    }

    public static ImageBlockLayoutThumbnailPartDefinition m9566a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ImageBlockLayoutThumbnailPartDefinition a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f7941b) {
                ImageBlockLayoutThumbnailPartDefinition imageBlockLayoutThumbnailPartDefinition;
                if (a3 != null) {
                    imageBlockLayoutThumbnailPartDefinition = (ImageBlockLayoutThumbnailPartDefinition) a3.a(f7941b);
                } else {
                    imageBlockLayoutThumbnailPartDefinition = f7940a;
                }
                if (imageBlockLayoutThumbnailPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m9565a();
                        if (a3 != null) {
                            a3.a(f7941b, a2);
                        } else {
                            f7940a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = imageBlockLayoutThumbnailPartDefinition;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
