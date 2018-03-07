package com.facebook.composer.plugininternal;

import android.content.Context;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.ipc.composer.intent.SerializedComposerPluginConfig;
import com.facebook.ipc.composer.model.ComposerCommerceInfo;
import com.facebook.ipc.composer.model.ComposerType;
import com.facebook.ipc.composer.model.ProductItemLocationPickerSettings;
import com.facebook.ipc.composer.plugin.ComposerPlugin.InstanceState;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters.BooleanGetter;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters.Getter;
import com.facebook.ipc.composer.plugin.ComposerPluginSession;
import com.facebook.ipc.composer.plugin.impl.ComposerPluginDefault;
import com.facebook.places.checkin.ipc.SearchType;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: for note id( */
public class ComposerPluginMock extends ComposerPluginDefault {

    /* compiled from: for note id( */
    class C08601 implements BooleanGetter {
        final /* synthetic */ ComposerPluginMock f6850c;

        C08601(ComposerPluginMock composerPluginMock) {
            this.f6850c = composerPluginMock;
        }

        public final boolean m8183a() {
            return this.f6850c.E().a.i() != null && this.f6850c.E().a.i().b();
        }
    }

    /* compiled from: for note id( */
    /* synthetic */ class C08623 {
        static final /* synthetic */ int[] f6853a = new int[ComposerType.values().length];

        static {
            try {
                f6853a[ComposerType.SELL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f6853a[ComposerType.SHARE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f6853a[ComposerType.STATUS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f6853a[ComposerType.RECOMMENDATION.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f6853a[ComposerType.GREETING_CARD.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f6853a[ComposerType.GOODWILL_CAMPAIGN.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    /* compiled from: for note id( */
    public class Factory implements com.facebook.ipc.composer.plugin.ComposerPlugin.Factory {
        private final ComposerPluginMockProvider f6854a;

        public final ComposerPluginDefault m8186a(SerializedComposerPluginConfig serializedComposerPluginConfig, ComposerPluginSession composerPluginSession, @Nullable InstanceState instanceState) {
            ComposerType composerType = composerPluginSession.a.o().getComposerType();
            boolean z = composerType == ComposerType.STATUS || composerType == ComposerType.SHARE || composerType == ComposerType.SELL;
            Preconditions.checkState(z);
            if (instanceState != null) {
                m8185a(instanceState.b);
            }
            return new ComposerPluginMock((Context) this.f6854a.getInstance(Context.class), composerPluginSession);
        }

        @Inject
        public Factory(ComposerPluginMockProvider composerPluginMockProvider) {
            this.f6854a = composerPluginMockProvider;
        }

        public final String m8187b() {
            return "MOCK";
        }

        private static void m8185a(@Nullable String str) {
            try {
                int parseInt = Integer.parseInt(str);
                if (parseInt != 1) {
                    throw new IllegalStateException("ComposerPluginMock.Factory: version change from " + parseInt + " to 1");
                }
            } catch (NumberFormatException e) {
                throw new IllegalStateException("ComposerPluginMock.Factory: no support for instanceState");
            }
        }
    }

    @Inject
    public ComposerPluginMock(Context context, @Assisted ComposerPluginSession composerPluginSession) {
        super(context, composerPluginSession);
    }

    @Nullable
    public final InstanceState m8199a() {
        return InstanceState.a(Integer.toString(1));
    }

    @Nullable
    protected final BooleanGetter aM() {
        switch (C08623.f6853a[E().a.o().getComposerType().ordinal()]) {
            case 1:
                return BooleanGetter.b;
            case 2:
                return BooleanGetter.a;
            default:
                return null;
        }
    }

    @Nullable
    protected final BooleanGetter aK() {
        switch (C08623.f6853a[E().a.o().getComposerType().ordinal()]) {
            case 1:
            case 2:
                return BooleanGetter.b;
            default:
                return null;
        }
    }

    @Nullable
    protected final BooleanGetter m8188H() {
        switch (C08623.f6853a[E().a.o().getComposerType().ordinal()]) {
            case 2:
                return BooleanGetter.b;
            default:
                return null;
        }
    }

    protected final BooleanGetter m8189J() {
        switch (C08623.f6853a[E().a.o().getComposerType().ordinal()]) {
            case 1:
            case 2:
                return BooleanGetter.b;
            default:
                return null;
        }
    }

    @Nullable
    protected final BooleanGetter m8190L() {
        switch (C08623.f6853a[E().a.o().getComposerType().ordinal()]) {
            case 1:
                return BooleanGetter.b;
            default:
                return null;
        }
    }

    @Nullable
    protected final BooleanGetter m8191M() {
        switch (C08623.f6853a[E().a.o().getComposerType().ordinal()]) {
            case 3:
                return BooleanGetter.a;
            default:
                return BooleanGetter.b;
        }
    }

    protected final BooleanGetter m8192O() {
        switch (C08623.f6853a[E().a.o().getComposerType().ordinal()]) {
            case 1:
                return new C08601(this);
            case 2:
                return BooleanGetter.a;
            default:
                return null;
        }
    }

    protected final BooleanGetter m8193P() {
        switch (C08623.f6853a[E().a.o().getComposerType().ordinal()]) {
            case 1:
                return BooleanGetter.b;
            default:
                return null;
        }
    }

    @Nullable
    protected final BooleanGetter m8194Q() {
        switch (C08623.f6853a[E().a.o().getComposerType().ordinal()]) {
            case 1:
            case 2:
                return BooleanGetter.b;
            default:
                return null;
        }
    }

    protected final BooleanGetter m8195R() {
        switch (C08623.f6853a[E().a.o().getComposerType().ordinal()]) {
            case 1:
                return BooleanGetter.b;
            default:
                return null;
        }
    }

    @Nullable
    protected final BooleanGetter m8196S() {
        switch (C08623.f6853a[E().a.o().getComposerType().ordinal()]) {
            case 2:
                return BooleanGetter.b;
            default:
                return null;
        }
    }

    @Nullable
    public final BooleanGetter m8197T() {
        switch (C08623.f6853a[E().a.o().getComposerType().ordinal()]) {
            case 1:
            case 4:
            case 5:
            case 6:
                return BooleanGetter.b;
            default:
                return null;
        }
    }

    @Nullable
    protected final BooleanGetter m8198X() {
        switch (C08623.f6853a[E().a.o().getComposerType().ordinal()]) {
            case 2:
                return BooleanGetter.a;
            default:
                return null;
        }
    }

    @Nullable
    protected final BooleanGetter ac() {
        switch (C08623.f6853a[E().a.o().getComposerType().ordinal()]) {
            case 1:
                return BooleanGetter.b;
            default:
                return null;
        }
    }

    @Nullable
    protected final BooleanGetter ad() {
        switch (C08623.f6853a[E().a.o().getComposerType().ordinal()]) {
            case 1:
                return BooleanGetter.a;
            default:
                return null;
        }
    }

    @Nullable
    protected final BooleanGetter ae() {
        switch (C08623.f6853a[E().a.o().getComposerType().ordinal()]) {
            case 2:
                return BooleanGetter.a;
            default:
                return null;
        }
    }

    @Nullable
    protected final BooleanGetter af() {
        switch (C08623.f6853a[E().a.o().getComposerType().ordinal()]) {
            case 1:
                return BooleanGetter.b;
            default:
                return null;
        }
    }

    @Nullable
    protected final Getter<SearchType> aC() {
        final ComposerConfiguration o = E().a.o();
        switch (C08623.f6853a[o.getComposerType().ordinal()]) {
            case 1:
                return new Getter<SearchType>(this) {
                    final /* synthetic */ ComposerPluginMock f6852b;

                    public final Object m8184a() {
                        Object obj = SearchType.HIDE_GEOHUBS;
                        ComposerCommerceInfo commerceInfo = o.getCommerceInfo();
                        if (commerceInfo == null) {
                            return obj;
                        }
                        ProductItemLocationPickerSettings productItemLocationPickerSettings = commerceInfo.getProductItemLocationPickerSettings();
                        return (productItemLocationPickerSettings == null || !productItemLocationPickerSettings.getUseNeighborhoodDataSource()) ? obj : SearchType.FORSALE_POST;
                    }
                };
            default:
                return null;
        }
    }

    @Nullable
    protected final BooleanGetter aD() {
        switch (C08623.f6853a[E().a.o().getComposerType().ordinal()]) {
            case 1:
            case 5:
            case 6:
                return BooleanGetter.b;
            default:
                return null;
        }
    }

    @Nullable
    protected final BooleanGetter aF() {
        switch (C08623.f6853a[E().a.o().getComposerType().ordinal()]) {
            case 1:
            case 5:
            case 6:
                return BooleanGetter.b;
            default:
                return null;
        }
    }

    @Nullable
    protected final BooleanGetter aL() {
        switch (C08623.f6853a[E().a.o().getComposerType().ordinal()]) {
            case 1:
                return BooleanGetter.b;
            default:
                return null;
        }
    }
}
