package com.facebook.privacy.checkup.photofeed;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
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
import com.facebook.privacy.checkup.photofeed.data.PhotoCheckupManager;
import com.facebook.privacy.checkup.protocol.FetchPhotoCheckupInterfaces.MediaMetadataWithCreatorPrivacyOptions;
import com.facebook.privacy.protocol.options.PrivacyOptionsGraphQLInterfaces.PrivacyOptionFieldsWithExplanation;
import com.facebook.privacy.spinner.AudienceSpinner;
import com.facebook.privacy.spinner.AudienceSpinner.AudienceExplanationDisplayMode;
import com.facebook.privacy.spinner.AudienceSpinner.PrivacyChangeListener;
import com.facebook.privacy.spinner.AudienceSpinner.SelectorOpenedListener;
import com.facebook.privacy.spinner.AudienceSpinnerAdapter;
import com.facebook.privacy.spinner.AudienceSpinnerAdapterProvider;
import com.facebook.privacy.spinner.AudienceSpinnerData;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: Stale state (%d s) */
public class PhotoAudienceSpinnerPartDefinition<E extends HasPositionInformation & CanEditObjectPrivacy> extends MultiRowSinglePartDefinition<MediaMetadataWithCreatorPrivacyOptions, State, E, AudienceSpinner> {
    public static final ViewType f11018a = new C13131();
    private static PhotoAudienceSpinnerPartDefinition f11019d;
    private static final Object f11020e = new Object();
    private final PhotoCheckupManager f11021b;
    private final AudienceSpinnerAdapterProvider f11022c;

    /* compiled from: Stale state (%d s) */
    final class C13131 extends ViewType {
        C13131() {
        }

        public final View m11417a(Context context) {
            return new AudienceSpinner(context);
        }
    }

    /* compiled from: Stale state (%d s) */
    public class State {
        public final AudienceSpinnerAdapter f11015a;
        public final PrivacyChangeListener f11016b;
        public final SelectorOpenedListener f11017c;

        public State(AudienceSpinnerAdapter audienceSpinnerAdapter, PrivacyChangeListener privacyChangeListener, SelectorOpenedListener selectorOpenedListener) {
            this.f11015a = audienceSpinnerAdapter;
            this.f11016b = privacyChangeListener;
            this.f11017c = selectorOpenedListener;
        }
    }

    private static PhotoAudienceSpinnerPartDefinition m11421b(InjectorLike injectorLike) {
        return new PhotoAudienceSpinnerPartDefinition(PhotoCheckupManager.m11454a(injectorLike), (AudienceSpinnerAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(AudienceSpinnerAdapterProvider.class));
    }

    public final Object m11423a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        MediaMetadataWithCreatorPrivacyOptions mediaMetadataWithCreatorPrivacyOptions = (MediaMetadataWithCreatorPrivacyOptions) obj;
        final HasPositionInformation hasPositionInformation = (HasPositionInformation) anyEnvironment;
        String d = mediaMetadataWithCreatorPrivacyOptions.d();
        PrivacyOptionFieldsWithExplanation a = ((CanEditObjectPrivacy) hasPositionInformation).mo289a();
        if (a == null) {
            AudienceSpinnerData a2 = AudienceSpinnerData.a(this.f11021b.f11078e.a(mediaMetadataWithCreatorPrivacyOptions.k().m5450a().m5444a(), false));
            a = ((CanEditObjectPrivacy) hasPositionInformation).mo290a(mediaMetadataWithCreatorPrivacyOptions.d());
            if (a != null) {
                a2.b(a);
            }
            return new State(this.f11022c.a(a2, AudienceExplanationDisplayMode.AUDIENCE_SHOW_PUBLIC_FRIENDS_AND_CUSTOM, d), new PrivacyChangeListener(this) {
                final /* synthetic */ PhotoAudienceSpinnerPartDefinition f11012b;

                public final void m11418a(PrivacyOptionFieldsWithExplanation privacyOptionFieldsWithExplanation, @Nullable String str) {
                    ((CanEditObjectPrivacy) hasPositionInformation).mo291a(str, privacyOptionFieldsWithExplanation);
                }
            }, new SelectorOpenedListener(this) {
                final /* synthetic */ PhotoAudienceSpinnerPartDefinition f11014b;

                public final void m11419a(boolean z) {
                    ((CanEditObjectPrivacy) hasPositionInformation).mo292a(z);
                }
            });
        }
        return new State(this.f11022c.a(new AudienceSpinnerData(ImmutableList.of(a), a), AudienceExplanationDisplayMode.AUDIENCE_SHOW_PUBLIC_FRIENDS_AND_CUSTOM, d), null, null);
    }

    public final /* bridge */ /* synthetic */ void m11424a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1964918856);
        State state = (State) obj2;
        AudienceSpinner audienceSpinner = (AudienceSpinner) view;
        boolean z = true;
        AudienceSpinnerAdapter audienceSpinnerAdapter = state.f11015a;
        if (state.f11015a.getCount() <= 1) {
            z = false;
        }
        audienceSpinner.a(audienceSpinnerAdapter, z);
        audienceSpinner.setPrivacyChangeListener(state.f11016b);
        audienceSpinner.setSelectorOpenedListener(state.f11017c);
        Logger.a(8, EntryType.MARK_POP, 535769574, a);
    }

    public final boolean m11425a(Object obj) {
        MediaMetadataWithCreatorPrivacyOptions mediaMetadataWithCreatorPrivacyOptions = (MediaMetadataWithCreatorPrivacyOptions) obj;
        return (mediaMetadataWithCreatorPrivacyOptions == null || mediaMetadataWithCreatorPrivacyOptions.k() == null || mediaMetadataWithCreatorPrivacyOptions.k().m5450a() == null || mediaMetadataWithCreatorPrivacyOptions.k().m5450a().m5444a() == null || mediaMetadataWithCreatorPrivacyOptions.k().m5450a().m5444a().isEmpty()) ? false : true;
    }

    public final void m11426b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        AudienceSpinner audienceSpinner = (AudienceSpinner) view;
        audienceSpinner.setPrivacyChangeListener(null);
        audienceSpinner.setSelectorOpenedListener(null);
        audienceSpinner.a();
    }

    public static PhotoAudienceSpinnerPartDefinition m11420a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PhotoAudienceSpinnerPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f11020e) {
                PhotoAudienceSpinnerPartDefinition photoAudienceSpinnerPartDefinition;
                if (a2 != null) {
                    photoAudienceSpinnerPartDefinition = (PhotoAudienceSpinnerPartDefinition) a2.a(f11020e);
                } else {
                    photoAudienceSpinnerPartDefinition = f11019d;
                }
                if (photoAudienceSpinnerPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m11421b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f11020e, b3);
                        } else {
                            f11019d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = photoAudienceSpinnerPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PhotoAudienceSpinnerPartDefinition(PhotoCheckupManager photoCheckupManager, AudienceSpinnerAdapterProvider audienceSpinnerAdapterProvider) {
        this.f11021b = photoCheckupManager;
        this.f11022c = audienceSpinnerAdapterProvider;
    }

    public final ViewType m11422a() {
        return f11018a;
    }
}
