package com.facebook.pages.common.reaction.components;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView.ScaleType;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.drawee.fbpipeline.FbDraweeView;
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

@ContextScoped
/* compiled from: setIsTagPeopleAttached */
public class PageAlbumCoverPhotoPartDefinition<E extends AnyEnvironment> extends BaseSinglePartDefinition<Props, Void, E, FbDraweeView> {
    private static PageAlbumCoverPhotoPartDefinition f1876a;
    private static final Object f1877b = new Object();

    /* compiled from: setIsTagPeopleAttached */
    public abstract class CoverPhoto {
        public final float f1870a;
        public final ScaleType f1871b;

        public abstract void mo43a(FbDraweeView fbDraweeView);

        public CoverPhoto(float f, ScaleType scaleType) {
            this.f1870a = f;
            this.f1871b = scaleType;
        }

        protected final void m2919b(FbDraweeView fbDraweeView) {
            LayoutParams layoutParams = fbDraweeView.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = -2;
                fbDraweeView.setLayoutParams(layoutParams);
            }
            fbDraweeView.setAspectRatio(this.f1870a);
        }

        protected final void m2920c(FbDraweeView fbDraweeView) {
            fbDraweeView.setScaleType(this.f1871b);
        }
    }

    /* compiled from: setIsTagPeopleAttached */
    public class Props {
        public final CoverPhoto f1872a;

        public Props(CoverPhoto coverPhoto) {
            this.f1872a = coverPhoto;
        }
    }

    /* compiled from: setIsTagPeopleAttached */
    public class ResourceIdCoverPhoto extends CoverPhoto {
        public final int f1873c;

        public ResourceIdCoverPhoto(int i, float f, ScaleType scaleType) {
            super(f, scaleType);
            this.f1873c = i;
        }

        public final void mo43a(FbDraweeView fbDraweeView) {
            m2919b(fbDraweeView);
            m2920c(fbDraweeView);
            fbDraweeView.setImageResource(this.f1873c);
        }
    }

    /* compiled from: setIsTagPeopleAttached */
    public class UriCoverPhoto extends CoverPhoto {
        public final String f1874c;
        public final CallerContext f1875d;

        public UriCoverPhoto(String str, CallerContext callerContext, float f, ScaleType scaleType) {
            super(f, scaleType);
            this.f1874c = str;
            this.f1875d = callerContext;
        }

        public final void mo43a(FbDraweeView fbDraweeView) {
            m2919b(fbDraweeView);
            m2920c(fbDraweeView);
            fbDraweeView.a(Uri.parse(this.f1874c), this.f1875d);
        }
    }

    private static PageAlbumCoverPhotoPartDefinition m2923a() {
        return new PageAlbumCoverPhotoPartDefinition();
    }

    public final /* bridge */ /* synthetic */ void m2925a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1628379850);
        ((Props) obj).f1872a.mo43a((FbDraweeView) view);
        Logger.a(8, EntryType.MARK_POP, -964952262, a);
    }

    public static PageAlbumCoverPhotoPartDefinition m2924a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PageAlbumCoverPhotoPartDefinition a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f1877b) {
                PageAlbumCoverPhotoPartDefinition pageAlbumCoverPhotoPartDefinition;
                if (a3 != null) {
                    pageAlbumCoverPhotoPartDefinition = (PageAlbumCoverPhotoPartDefinition) a3.a(f1877b);
                } else {
                    pageAlbumCoverPhotoPartDefinition = f1876a;
                }
                if (pageAlbumCoverPhotoPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m2923a();
                        if (a3 != null) {
                            a3.a(f1877b, a2);
                        } else {
                            f1876a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = pageAlbumCoverPhotoPartDefinition;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
