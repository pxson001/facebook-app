package com.facebook.facecast.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.composer.privacy.common.ComposerEventPrivacyDelegateProvider;
import com.facebook.composer.privacy.common.ComposerFixedPrivacyData;
import com.facebook.composer.privacy.common.ComposerGroupPrivacyDelegateProvider;
import com.facebook.composer.privacy.common.ComposerPageAdminPrivacyDelegateProvider;
import com.facebook.composer.privacy.common.ComposerPrivacyData;
import com.facebook.composer.privacy.common.ComposerPrivacyDelegate.PrivacyUpdatedHandler;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.facebook.inject.FbInjector;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.ipc.composer.model.TargetType;
import com.facebook.privacy.PrivacyOperationsClient;
import com.facebook.privacy.model.PrivacyOptionHelper;
import com.facebook.privacy.model.PrivacyOptionsResult;
import com.facebook.privacy.model.SelectablePrivacyData;
import com.facebook.privacy.model.SelectablePrivacyData.Builder;
import com.facebook.privacy.ui.PrivacyIcons;
import com.facebook.privacy.ui.PrivacyIcons.Size;
import com.facebook.resources.ui.FbTextView;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: avc1 */
public class FacecastEndScreenPrivacyPill extends FbTextView {
    private static final String f18814i = FacecastEndScreenPrivacyPill.class.getName();
    @Inject
    DefaultAndroidThreadUtil f18815a;
    @Inject
    AbstractFbErrorReporter f18816b;
    @Inject
    ComposerGroupPrivacyDelegateProvider f18817c;
    @Inject
    ComposerPageAdminPrivacyDelegateProvider f18818d;
    @Inject
    ComposerEventPrivacyDelegateProvider f18819e;
    @Inject
    PrivacyOperationsClient f18820f;
    @Inject
    PrivacyIcons f18821g;
    @Inject
    GlyphColorizer f18822h;
    public SelectablePrivacyData f18823j;
    public ComposerFixedPrivacyData f18824k;
    private int f18825l;
    private final PrivacyUpdatedHandler f18826m;

    /* compiled from: avc1 */
    class C16301 extends AbstractDisposableFutureCallback<PrivacyOptionsResult> {
        final /* synthetic */ FacecastEndScreenPrivacyPill f18811a;

        C16301(FacecastEndScreenPrivacyPill facecastEndScreenPrivacyPill) {
            this.f18811a = facecastEndScreenPrivacyPill;
        }

        protected final void m22410a(Object obj) {
            PrivacyOptionsResult privacyOptionsResult = (PrivacyOptionsResult) obj;
            GraphQLPrivacyOption graphQLPrivacyOption = privacyOptionsResult.selectedPrivacyOption;
            FacecastEndScreenPrivacyPill facecastEndScreenPrivacyPill = this.f18811a;
            Builder builder = new Builder();
            builder.a = privacyOptionsResult;
            facecastEndScreenPrivacyPill.f18823j = builder.a(graphQLPrivacyOption).b();
            this.f18811a.m22420a(graphQLPrivacyOption.d(), this.f18811a.m22414a(graphQLPrivacyOption), true);
            this.f18811a.setClickable(true);
        }

        protected final void m22411a(Throwable th) {
        }
    }

    /* compiled from: avc1 */
    class C16312 implements PrivacyUpdatedHandler {
        final /* synthetic */ FacecastEndScreenPrivacyPill f18812a;

        C16312(FacecastEndScreenPrivacyPill facecastEndScreenPrivacyPill) {
            this.f18812a = facecastEndScreenPrivacyPill;
        }

        public final void mo487a(ComposerPrivacyData composerPrivacyData, boolean z) {
            this.f18812a.f18824k = composerPrivacyData.f2000a;
            this.f18812a.m22420a(this.f18812a.f18824k.f1977b, this.f18812a.getResources().getDrawable(this.f18812a.f18821g.a(this.f18812a.f18824k.f1976a, Size.PILL)), false);
        }
    }

    /* compiled from: avc1 */
    /* synthetic */ class C16323 {
        static final /* synthetic */ int[] f18813a = new int[TargetType.values().length];

        static {
            try {
                f18813a[TargetType.GROUP.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f18813a[TargetType.PAGE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f18813a[TargetType.EVENT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f18813a[TargetType.UNDIRECTED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    private static <T extends View> void m22421a(Class<T> cls, T t) {
        m22422a((Object) t, t.getContext());
    }

    private static void m22422a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((FacecastEndScreenPrivacyPill) obj).m22418a(DefaultAndroidThreadUtil.b(fbInjector), (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector), (ComposerGroupPrivacyDelegateProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(ComposerGroupPrivacyDelegateProvider.class), (ComposerPageAdminPrivacyDelegateProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(ComposerPageAdminPrivacyDelegateProvider.class), (ComposerEventPrivacyDelegateProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(ComposerEventPrivacyDelegateProvider.class), PrivacyOperationsClient.a(fbInjector), PrivacyIcons.a(fbInjector), GlyphColorizer.a(fbInjector));
    }

    private void m22418a(DefaultAndroidThreadUtil defaultAndroidThreadUtil, AbstractFbErrorReporter abstractFbErrorReporter, ComposerGroupPrivacyDelegateProvider composerGroupPrivacyDelegateProvider, ComposerPageAdminPrivacyDelegateProvider composerPageAdminPrivacyDelegateProvider, ComposerEventPrivacyDelegateProvider composerEventPrivacyDelegateProvider, PrivacyOperationsClient privacyOperationsClient, PrivacyIcons privacyIcons, GlyphColorizer glyphColorizer) {
        this.f18815a = defaultAndroidThreadUtil;
        this.f18816b = abstractFbErrorReporter;
        this.f18817c = composerGroupPrivacyDelegateProvider;
        this.f18818d = composerPageAdminPrivacyDelegateProvider;
        this.f18819e = composerEventPrivacyDelegateProvider;
        this.f18820f = privacyOperationsClient;
        this.f18821g = privacyIcons;
        this.f18822h = glyphColorizer;
    }

    public FacecastEndScreenPrivacyPill(Context context) {
        this(context, null);
    }

    public FacecastEndScreenPrivacyPill(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FacecastEndScreenPrivacyPill(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f18826m = new C16312(this);
        m22421a(FacecastEndScreenPrivacyPill.class, (View) this);
        this.f18825l = getResources().getColor(2131362108);
    }

    public final void m22423a(@Nullable SelectablePrivacyData selectablePrivacyData, ComposerTargetData composerTargetData) {
        this.f18823j = selectablePrivacyData;
        if (this.f18823j != null) {
            GraphQLPrivacyOption graphQLPrivacyOption = this.f18823j.d;
            m22420a(graphQLPrivacyOption.d(), m22414a(graphQLPrivacyOption), true);
            setClickable(true);
            return;
        }
        setText(getResources().getString(2131230739));
        if (composerTargetData != null) {
            switch (C16323.f18813a[composerTargetData.targetType.ordinal()]) {
                case 1:
                    this.f18817c.m1934a(this.f18826m, Long.valueOf(composerTargetData.targetId), composerTargetData.targetName).mo91a();
                    return;
                case 2:
                    this.f18818d.m1939a(this.f18826m, getResources().getString(2131234252), composerTargetData.targetName).mo91a();
                    return;
                case 3:
                    this.f18819e.m1925a(this.f18826m, Long.valueOf(composerTargetData.targetId), composerTargetData.targetName, composerTargetData.targetPrivacy).mo91a();
                    return;
                case 4:
                    this.f18815a.a(this.f18820f.a(DataFreshnessParam.STALE_DATA_OKAY), new C16301(this));
                    return;
                default:
                    this.f18816b.a(f18814i + "updatePrivacyData", "Unsupported type " + composerTargetData.targetType);
                    return;
            }
        }
    }

    private void m22420a(CharSequence charSequence, Drawable drawable, boolean z) {
        Drawable a;
        setText(charSequence);
        Drawable a2 = this.f18822h.a(drawable, this.f18825l);
        if (z) {
            a = this.f18822h.a(2130840140, this.f18825l);
        } else {
            a = null;
        }
        setCompoundDrawablesWithIntrinsicBounds(a2, null, a, null);
    }

    private Drawable m22414a(GraphQLPrivacyOption graphQLPrivacyOption) {
        return getResources().getDrawable(this.f18821g.a(PrivacyOptionHelper.a(graphQLPrivacyOption), Size.TOKEN));
    }
}
