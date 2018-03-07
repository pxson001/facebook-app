package com.facebook.privacy.checkup.photofeed;

import android.content.Context;
import com.facebook.api.feed.data.EndOfFeedSentinel.EndOfFeedSentinelFeedUnit;
import com.facebook.api.feed.data.LoadingMoreSentinel.LoadingMoreSentinelFeedUnit;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.RootPartSelector;
import com.facebook.feed.rows.sections.common.EmptyPartDefinition;
import com.facebook.feed.rows.sections.common.loadingmore.LoadingMorePartDefinition;
import com.facebook.feed.rows.sections.common.unknown.UnknownFeedUnitMultiRowGroupPartDefinition;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.privacy.checkup.protocol.FetchPhotoCheckupInterfaces.MediaMetadataWithCreatorPrivacyOptions;
import javax.inject.Inject;

@ContextScoped
/* compiled from: SmallInverse */
public class PhotoPrivacyFeedRootPartDefinition extends BaseMultiRowGroupPartDefinition<Object, Void, PhotoPrivacyFeedEnvironment> {
    private static PhotoPrivacyFeedRootPartDefinition f11050b;
    private static final Object f11051c = new Object();
    private final RootPartSelector<PhotoPrivacyFeedEnvironment> f11052a;

    private static PhotoPrivacyFeedRootPartDefinition m11450b(InjectorLike injectorLike) {
        return new PhotoPrivacyFeedRootPartDefinition(IdBasedLazy.a(injectorLike, 9695), IdBasedLazy.a(injectorLike, 6021), IdBasedLazy.a(injectorLike, 6023), IdBasedLazy.a(injectorLike, 6019));
    }

    @Inject
    public PhotoPrivacyFeedRootPartDefinition(Lazy<PhotoPrivacyFeedContentRowPartDefinition> lazy, Lazy<LoadingMorePartDefinition> lazy2, Lazy<UnknownFeedUnitMultiRowGroupPartDefinition> lazy3, Lazy<EmptyPartDefinition> lazy4) {
        this.f11052a = RootPartSelector.a().a(MediaMetadataWithCreatorPrivacyOptions.class, lazy).b(LoadingMoreSentinelFeedUnit.class, lazy2).a(EndOfFeedSentinelFeedUnit.class, lazy4).a(Object.class, lazy3);
    }

    public final boolean m11452a(Object obj) {
        return true;
    }

    public final Object m11451a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        this.f11052a.a(baseMultiRowSubParts, obj);
        return null;
    }

    public static PhotoPrivacyFeedRootPartDefinition m11449a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PhotoPrivacyFeedRootPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f11051c) {
                PhotoPrivacyFeedRootPartDefinition photoPrivacyFeedRootPartDefinition;
                if (a2 != null) {
                    photoPrivacyFeedRootPartDefinition = (PhotoPrivacyFeedRootPartDefinition) a2.a(f11051c);
                } else {
                    photoPrivacyFeedRootPartDefinition = f11050b;
                }
                if (photoPrivacyFeedRootPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m11450b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f11051c, b3);
                        } else {
                            f11050b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = photoPrivacyFeedRootPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
