package com.facebook.photos.mediagallery.ui.tagging;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.TriState;
import com.facebook.funnellogger.FunnelLoggerImpl;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.MediaMetadata;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.Sets;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: sms_auto_confirm_network_failure */
public class TaggingStateController {
    private static TaggingStateController f2561g;
    private static final Object f2562h = new Object();
    @VisibleForTesting
    public TriState f2563a = TriState.UNSET;
    public final FunnelLoggerImpl f2564b;
    public boolean f2565c = false;
    @Nullable
    public View f2566d;
    private Set<TaggingStateListener> f2567e = Sets.a();
    public boolean f2568f = false;

    /* compiled from: sms_auto_confirm_network_failure */
    public interface TaggingStateListener {
        void mo119a(boolean z);
    }

    /* compiled from: sms_auto_confirm_network_failure */
    public class C03181 implements OnClickListener {
        final /* synthetic */ TaggingStateController f2560a;

        public C03181(TaggingStateController taggingStateController) {
            this.f2560a = taggingStateController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -962618946);
            this.f2560a.f2564b.b(FunnelRegistry.z, "click_tag_button");
            TaggingStateController.m2665d(this.f2560a);
            Logger.a(2, EntryType.UI_INPUT_END, 170372614, a);
        }
    }

    private static TaggingStateController m2664b(InjectorLike injectorLike) {
        return new TaggingStateController(FunnelLoggerImpl.a(injectorLike));
    }

    @Inject
    public TaggingStateController(FunnelLoggerImpl funnelLoggerImpl) {
        this.f2564b = funnelLoggerImpl;
    }

    public static TaggingStateController m2663a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            TaggingStateController b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f2562h) {
                TaggingStateController taggingStateController;
                if (a2 != null) {
                    taggingStateController = (TaggingStateController) a2.a(f2562h);
                } else {
                    taggingStateController = f2561g;
                }
                if (taggingStateController == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m2664b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f2562h, b3);
                        } else {
                            f2561g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = taggingStateController;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final void m2666a(@Nullable MediaMetadata mediaMetadata, MediaMetadata mediaMetadata2) {
        Object obj;
        Preconditions.checkNotNull(this.f2566d);
        Preconditions.checkNotNull(mediaMetadata2);
        if (mediaMetadata == null || !((mediaMetadata2.d() == null || mediaMetadata2.d().equals(mediaMetadata.d())) && mediaMetadata.w() == mediaMetadata2.w() && mediaMetadata.n() == mediaMetadata2.n())) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            obj = (this.f2563a == TriState.YES && mediaMetadata2 != null && (mediaMetadata2.n() || mediaMetadata2.w())) ? 1 : null;
            Object obj2 = obj;
            this.f2566d.setVisibility(obj2 != null ? 0 : 8);
            if (obj2 == null && this.f2565c) {
                m2665d(this);
            }
            if (this.f2568f && !this.f2565c && obj2 != null) {
                this.f2568f = false;
                m2665d(this);
            }
        }
    }

    public final boolean m2669b() {
        return this.f2563a.asBoolean(false);
    }

    public final void m2667a(TaggingStateListener taggingStateListener) {
        this.f2567e.add(taggingStateListener);
    }

    public final void m2668b(TaggingStateListener taggingStateListener) {
        this.f2567e.remove(taggingStateListener);
    }

    public static void m2665d(TaggingStateController taggingStateController) {
        taggingStateController.f2565c = !taggingStateController.f2565c;
        for (TaggingStateListener a : taggingStateController.f2567e) {
            a.mo119a(taggingStateController.f2565c);
        }
    }
}
