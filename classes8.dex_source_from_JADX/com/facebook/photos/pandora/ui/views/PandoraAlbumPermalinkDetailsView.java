package com.facebook.photos.pandora.ui.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.text.SpannableStringBuilder;
import android.view.View;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.timeformat.DefaultTimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil.TimeFormatStyle;
import com.facebook.common.util.StringUtil;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.widget.text.ImageWithTextView;
import com.facebook.graphql.enums.GraphQLPhotosAlbumAPIType;
import com.facebook.graphql.enums.GraphQLPrivacyOptionType;
import com.facebook.graphql.model.GraphQLAlbum;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.photos.albums.util.PandoraAlbumItemCountUtil;
import com.facebook.photos.photoset.controllers.AlbumHeaderSetupController;
import com.facebook.photos.photoset.ui.permalink.AlbumPermalinkContributorsSectionView;
import com.facebook.privacy.ui.PrivacyIcons;
import com.facebook.privacy.ui.PrivacyIcons.Size;
import com.facebook.resources.ui.FbTextView;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.FbImageSpan;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.List;

/* compiled from: colors */
public class PandoraAlbumPermalinkDetailsView extends CustomLinearLayout {
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<ViewerContext> f17749a = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<AlbumHeaderSetupController> f17750b = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<DefaultTimeFormatUtil> f17751c = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<PrivacyIcons> f17752d = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<GlyphColorizer> f17753e = UltralightRuntime.b;

    public static void m21732a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((PandoraAlbumPermalinkDetailsView) obj).m21731a(IdBasedLazy.a(fbInjector, 372), IdBasedLazy.a(fbInjector, 9405), IdBasedSingletonScopeProvider.b(fbInjector, 610), IdBasedSingletonScopeProvider.b(fbInjector, 9722), IdBasedSingletonScopeProvider.b(fbInjector, 1275));
    }

    public PandoraAlbumPermalinkDetailsView(Context context) {
        super(context);
        Class cls = PandoraAlbumPermalinkDetailsView.class;
        m21732a((Object) this, getContext());
        setContentView(2130906135);
    }

    public final void m21733a(GraphQLAlbum graphQLAlbum, boolean z, long j, boolean z2, @Nullable ComposerTargetData composerTargetData) {
        Preconditions.checkNotNull(graphQLAlbum);
        FbTextView fbTextView = (FbTextView) findViewById(2131559541);
        if (graphQLAlbum.E() == null || graphQLAlbum.E().a() == null) {
            fbTextView.setText("");
        } else {
            fbTextView.setText(graphQLAlbum.E().a());
        }
        setAlbumDetailsText(graphQLAlbum);
        ((AlbumPermalinkContributorsSectionView) findViewById(2131565761)).m21787a(graphQLAlbum);
        fbTextView = (FbTextView) findViewById(2131559542);
        if (graphQLAlbum.y() == null || graphQLAlbum.y().a() == null) {
            fbTextView.setVisibility(8);
        } else {
            fbTextView.setText(graphQLAlbum.y().a());
            fbTextView.setVisibility(0);
        }
        FbTextView fbTextView2 = (ImageWithTextView) findViewById(2131565769);
        View findViewById = findViewById(2131565770);
        findViewById.setVisibility(8);
        if (z) {
            fbTextView2.setVisibility(0);
            ((AlbumHeaderSetupController) this.f17750b.get()).m21751a(graphQLAlbum, fbTextView2, composerTargetData, ((ViewerContext) this.f17749a.get()).a(), j, z2);
            return;
        }
        findViewById.setVisibility(0);
    }

    private void setAlbumDetailsText(GraphQLAlbum graphQLAlbum) {
        FbTextView fbTextView = (FbTextView) findViewById(2131565759);
        FbTextView fbTextView2 = (FbTextView) findViewById(2131565760);
        List arrayList = new ArrayList();
        int i = (graphQLAlbum.k() == GraphQLPhotosAlbumAPIType.SHARED && graphQLAlbum.q() != null && graphQLAlbum.l()) ? 1 : 0;
        if (i != 0) {
            arrayList.add(getContext().getResources().getQuantityString(2131689585, graphQLAlbum.q().size(), new Object[]{Integer.valueOf(graphQLAlbum.q().size())}));
        }
        if (graphQLAlbum.w() != null) {
            arrayList.add(PandoraAlbumItemCountUtil.a(graphQLAlbum, getContext()));
        }
        if (graphQLAlbum.r() != 0) {
            arrayList.add(((DefaultTimeFormatUtil) this.f17751c.get()).a(TimeFormatStyle.STREAM_RELATIVE_STYLE, graphQLAlbum.r() * 1000));
        }
        if (!(graphQLAlbum.s() == null || graphQLAlbum.s().B() == null)) {
            arrayList.add(graphQLAlbum.s().B());
        }
        arrayList.add(m21730a(graphQLAlbum, fbTextView2.getCurrentTextColor()));
        if (arrayList.size() < 5) {
            fbTextView.setVisibility(8);
            fbTextView2.setText(StringUtil.a(" · ", arrayList));
            return;
        }
        fbTextView.setVisibility(0);
        fbTextView.setText(StringUtil.a(" · ", arrayList.subList(0, arrayList.size() - 2)));
        fbTextView2.setText(StringUtil.a(" · ", arrayList.subList(arrayList.size() - 2, arrayList.size())));
    }

    private CharSequence m21730a(GraphQLAlbum graphQLAlbum, int i) {
        GraphQLPrivacyOptionType graphQLPrivacyOptionType;
        CharSequence n;
        GraphQLPrivacyOptionType graphQLPrivacyOptionType2 = GraphQLPrivacyOptionType.CUSTOM;
        String string = getResources().getString(2131234199);
        if (graphQLAlbum.D() == null || graphQLAlbum.D().m() == null || graphQLAlbum.D().m().d() == null || graphQLAlbum.D().n() == null) {
            Object obj = string;
            graphQLPrivacyOptionType = graphQLPrivacyOptionType2;
        } else {
            graphQLPrivacyOptionType2 = GraphQLPrivacyOptionType.fromIconName(graphQLAlbum.D().m().d());
            n = graphQLAlbum.D().n();
            graphQLPrivacyOptionType = graphQLPrivacyOptionType2;
        }
        Drawable drawable = (Drawable) Preconditions.checkNotNull(((GlyphColorizer) this.f17753e.get()).a(((PrivacyIcons) this.f17752d.get()).a(graphQLPrivacyOptionType, Size.PILL), i));
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        CharSequence spannableStringBuilder = new SpannableStringBuilder(n);
        spannableStringBuilder.setSpan(new FbImageSpan(drawable, 2), 0, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    private void m21731a(com.facebook.inject.Lazy<ViewerContext> lazy, com.facebook.inject.Lazy<AlbumHeaderSetupController> lazy2, com.facebook.inject.Lazy<DefaultTimeFormatUtil> lazy3, com.facebook.inject.Lazy<PrivacyIcons> lazy4, com.facebook.inject.Lazy<GlyphColorizer> lazy5) {
        this.f17749a = lazy;
        this.f17750b = lazy2;
        this.f17751c = lazy3;
        this.f17752d = lazy4;
        this.f17753e = lazy5;
    }
}
