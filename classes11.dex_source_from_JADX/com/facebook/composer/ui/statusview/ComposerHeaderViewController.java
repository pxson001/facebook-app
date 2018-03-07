package com.facebook.composer.ui.statusview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.view.ViewStub;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.UriUtil;
import com.facebook.composer.activity.ComposerDataProviderImpl;
import com.facebook.composer.event.ComposerEvent;
import com.facebook.composer.event.ComposerEventHandler;
import com.facebook.composer.event.ComposerEventOriginator;
import com.facebook.composer.metatext.MinutiaeIconMetaTextFormatter;
import com.facebook.composer.minutiae.model.MinutiaeObject.ProvidesMinutiae;
import com.facebook.composer.util.ComposerUserNameUtil;
import com.facebook.drawee.fbpipeline.BaseControllerListener;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesMetaText;
import com.facebook.ipc.composer.intent.ComposerTargetData.ProvidesTargetData;
import com.facebook.user.model.User;
import com.google.common.base.Preconditions;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: fb4a_upgrade_wifi_active */
public class ComposerHeaderViewController<DataProvider extends ProvidesMetaText & ProvidesTargetData & ProvidesMinutiae> implements ComposerEventHandler {
    private static final CallerContext f7144a = CallerContext.a(ComposerHeaderView.class, "composer");
    public final ComposerHeaderView f7145b;
    private final FbDraweeControllerBuilder f7146c;
    private final MinutiaeIconMetaTextFormatter f7147d;
    private final DraweeHolder<GenericDraweeHierarchy> f7148e;
    private final User f7149f;
    private final WeakReference<DataProvider> f7150g;
    private String f7151h;
    private String f7152i;
    private CloseableImage f7153j;
    private Uri f7154k;
    private SpannedString f7155l;

    /* compiled from: fb4a_upgrade_wifi_active */
    class C09051 extends BaseControllerListener {
        final /* synthetic */ ComposerHeaderViewController f7142a;

        C09051(ComposerHeaderViewController composerHeaderViewController) {
            this.f7142a = composerHeaderViewController;
        }

        public final void m8356a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            this.f7142a.m8361a((CloseableImage) obj);
        }

        public final void m8357b(String str, Throwable th) {
        }
    }

    /* compiled from: fb4a_upgrade_wifi_active */
    /* synthetic */ class C09062 {
        static final /* synthetic */ int[] f7143a = new int[ComposerEvent.values().length];

        static {
            try {
                f7143a[ComposerEvent.ON_DATASET_CHANGE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
        }
    }

    @Inject
    public ComposerHeaderViewController(FbDraweeControllerBuilder fbDraweeControllerBuilder, Resources resources, Context context, User user, @Assisted DataProvider dataProvider, @Assisted ViewStub viewStub) {
        this.f7146c = fbDraweeControllerBuilder;
        this.f7149f = user;
        this.f7150g = new WeakReference(dataProvider);
        this.f7145b = (ComposerHeaderView) viewStub.inflate();
        this.f7147d = new MinutiaeIconMetaTextFormatter(resources);
        this.f7148e = DraweeHolder.a(new GenericDraweeHierarchyBuilder(resources).u(), context);
        this.f7145b.setMinutiaeIconHolder(this.f7148e);
        m8363c();
    }

    public final void m8366a(ComposerEvent composerEvent, @Nullable ComposerEventOriginator composerEventOriginator) {
        switch (C09062.f7143a[composerEvent.ordinal()]) {
            case 1:
                m8363c();
                return;
            default:
                return;
        }
    }

    private void m8362b() {
        SpannableStringBuilder a = ComposerUserNameUtil.a(this.f7151h);
        if (this.f7155l != null) {
            a.append(this.f7155l);
        }
        this.f7145b.setText(a);
    }

    private void m8359a(SpannedString spannedString) {
        if (this.f7155l == null || !this.f7155l.equals(spannedString)) {
            this.f7155l = spannedString;
            m8362b();
            if (this.f7153j != null) {
                m8364d();
            }
        }
    }

    private void m8363c() {
        ComposerDataProviderImpl composerDataProviderImpl = (ComposerDataProviderImpl) Preconditions.checkNotNull(this.f7150g.get());
        String j = ((ProvidesTargetData) composerDataProviderImpl).s().actsAsTarget ? ((ProvidesTargetData) composerDataProviderImpl).s().targetName : this.f7149f.j();
        String x = ((ProvidesTargetData) composerDataProviderImpl).s().actsAsTarget ? ((ProvidesTargetData) composerDataProviderImpl).s().targetProfilePicUrl : this.f7149f.x();
        if (!StringUtil.a(j, this.f7151h)) {
            this.f7151h = j;
            m8362b();
        }
        if (!StringUtil.a(x, this.f7152i)) {
            this.f7152i = x;
            this.f7145b.m8355a(UriUtil.a(this.f7152i), f7144a);
        }
        if (!(((ProvidesMinutiae) composerDataProviderImpl).l() == null || ((ProvidesMinutiae) composerDataProviderImpl).l().a() == this.f7154k)) {
            m8358a(((ProvidesMinutiae) composerDataProviderImpl).l().a());
        }
        if (composerDataProviderImpl.m7419V() != null && !composerDataProviderImpl.m7419V().equals(this.f7155l)) {
            m8359a(composerDataProviderImpl.m7419V());
        }
    }

    private void m8358a(Uri uri) {
        this.f7154k = uri;
        this.f7148e.a(((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) this.f7146c.a(f7144a).b(this.f7148e.f)).b(uri).a(new C09051(this))).s());
    }

    private void m8361a(CloseableImage closeableImage) {
        this.f7153j = closeableImage;
        m8364d();
    }

    private void m8364d() {
        Preconditions.checkNotNull(this.f7153j);
        this.f7145b.setText(MinutiaeIconMetaTextFormatter.a(((GenericDraweeHierarchy) this.f7148e.f()).a(), new SpannableStringBuilder(this.f7145b.getText()), this.f7153j, this.f7154k, this.f7145b.getAscentForText()));
    }

    public final ComposerHeaderView m8365a() {
        return this.f7145b;
    }
}
