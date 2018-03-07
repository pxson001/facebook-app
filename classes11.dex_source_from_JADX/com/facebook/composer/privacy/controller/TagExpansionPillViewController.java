package com.facebook.composer.privacy.controller;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.composer.activity.ComposerFragment;
import com.facebook.composer.activity.ComposerFragment.AnonymousClass25;
import com.facebook.composer.analytics.ComposerAnalyticsEventBuilder;
import com.facebook.composer.analytics.ComposerAnalyticsLogger;
import com.facebook.composer.attachments.ComposerAttachment.ProvidesAttachments;
import com.facebook.composer.attachments.ComposerTagUtil;
import com.facebook.composer.event.ComposerEvent;
import com.facebook.composer.event.ComposerEventHandler;
import com.facebook.composer.event.ComposerEventOriginator;
import com.facebook.composer.privacy.common.ComposerPrivacyData.ProvidesPrivacyData;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.graphql.enums.GraphQLPrivacyOptionTagExpansionType;
import com.facebook.graphql.enums.GraphQLPrivacyTagExpansionState;
import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.facebook.graphql.model.GraphQLPrivacyRowInput.Builder;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesSessionId;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesTextWithEntities;
import com.facebook.ipc.composer.model.ComposerTaggedUser.ProvidesTaggedUsers;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.privacy.model.GraphQLPrivacyOptionBuilder;
import com.facebook.privacy.model.PrivacyOptionHelper;
import com.facebook.privacy.model.SelectablePrivacyData;
import com.facebook.resources.ui.FbTextView;
import com.facebook.resources.utils.TextViewUtils;
import com.facebook.user.model.User;
import com.facebook.widget.LazyView;
import com.google.common.base.Preconditions;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: first edge is null */
public class TagExpansionPillViewController<DataProvider extends ProvidesAttachments & ProvidesSessionId & ProvidesTextWithEntities & ProvidesPrivacyData & ProvidesTaggedUsers> implements ComposerEventHandler {
    private final Resources f6900a;
    private final GlyphColorizer f6901b;
    public final WeakReference<DataProvider> f6902c;
    private final LazyView<FbTextView> f6903d;
    private final User f6904e;
    public final AnonymousClass25 f6905f;
    public final ComposerAnalyticsLogger f6906g;
    private final OnClickListener f6907h = new C08701(this);

    /* compiled from: first edge is null */
    class C08701 implements OnClickListener {
        final /* synthetic */ TagExpansionPillViewController f6898a;

        C08701(TagExpansionPillViewController tagExpansionPillViewController) {
            this.f6898a = tagExpansionPillViewController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 2029391574);
            TagExpansionPillViewController tagExpansionPillViewController = this.f6898a;
            ProvidesAttachments providesAttachments = (ProvidesAttachments) Preconditions.checkNotNull(tagExpansionPillViewController.f6902c.get());
            GraphQLPrivacyOption graphQLPrivacyOption = (GraphQLPrivacyOption) Preconditions.checkNotNull(((ProvidesPrivacyData) providesAttachments).ag().b.d);
            Builder a2 = Builder.a(PrivacyOptionHelper.e(graphQLPrivacyOption));
            a2.g = GraphQLPrivacyTagExpansionState.TAGGEES;
            GraphQLPrivacyOption b = GraphQLPrivacyOptionBuilder.a(graphQLPrivacyOption).a(a2.a()).b();
            SelectablePrivacyData.Builder builder = new SelectablePrivacyData.Builder(((ProvidesPrivacyData) providesAttachments).ag().b);
            builder.c = true;
            SelectablePrivacyData b2 = builder.a(b).b();
            AnonymousClass25 anonymousClass25 = tagExpansionPillViewController.f6905f;
            anonymousClass25.f6055a.aU.m7627a(ComposerEvent.ON_TAG_EXPANSION_DISABLED, ComposerFragment.cn);
            ComposerFragment.m7542a(anonymousClass25.f6055a, b2);
            ComposerAnalyticsLogger composerAnalyticsLogger = tagExpansionPillViewController.f6906g;
            composerAnalyticsLogger.a.a(new ComposerAnalyticsEventBuilder("composer_tag_expansion_pill_clicked").h(((ProvidesSessionId) providesAttachments).ab()).a);
            Logger.a(2, EntryType.UI_INPUT_END, -1595576411, a);
        }
    }

    /* compiled from: first edge is null */
    /* synthetic */ class C08712 {
        static final /* synthetic */ int[] f6899a = new int[ComposerEvent.values().length];

        static {
            try {
                f6899a[ComposerEvent.ON_FIRST_DRAW.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f6899a[ComposerEvent.ON_DATASET_CHANGE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f6899a[ComposerEvent.ON_STATUS_TEXT_CHANGED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f6899a[ComposerEvent.ON_PRIVACY_FETCHED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f6899a[ComposerEvent.ON_PRIVACY_CHANGE_FROM_INLINE_PRIVACY_SURVEY.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f6899a[ComposerEvent.ON_TAG_EXPANSION_DISABLED.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    @Inject
    public TagExpansionPillViewController(GlyphColorizer glyphColorizer, Resources resources, ComposerAnalyticsLogger composerAnalyticsLogger, User user, @Assisted DataProvider dataProvider, @Assisted TagExpansionPillClickedListener tagExpansionPillClickedListener, @Assisted LazyView<FbTextView> lazyView) {
        this.f6901b = glyphColorizer;
        this.f6900a = resources;
        this.f6906g = composerAnalyticsLogger;
        this.f6904e = user;
        this.f6902c = new WeakReference(Preconditions.checkNotNull(dataProvider));
        this.f6905f = tagExpansionPillClickedListener;
        this.f6903d = lazyView;
        m8223b();
    }

    public final void m8224a(ComposerEvent composerEvent, @Nullable ComposerEventOriginator composerEventOriginator) {
        switch (C08712.f6899a[composerEvent.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                m8223b();
                return;
            default:
                return;
        }
    }

    private void m8223b() {
        ProvidesAttachments providesAttachments = (ProvidesAttachments) Preconditions.checkNotNull(this.f6902c.get());
        if (!((ProvidesPrivacyData) providesAttachments).ag().d) {
            SelectablePrivacyData selectablePrivacyData = ((ProvidesPrivacyData) providesAttachments).ag().b;
            if (selectablePrivacyData == null) {
                this.f6903d.c();
                return;
            }
            GraphQLPrivacyOption graphQLPrivacyOption = selectablePrivacyData.d;
            boolean z;
            if (ComposerTagUtil.a(Long.parseLong(this.f6904e.a), ((ProvidesTaggedUsers) providesAttachments).h(), ((ProvidesTextWithEntities) providesAttachments).ae(), providesAttachments.m()).isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            if (graphQLPrivacyOption == null || !selectablePrivacyData.f() || selectablePrivacyData.b || !r0 || selectablePrivacyData.g() == null) {
                this.f6903d.c();
                return;
            }
            GraphQLPrivacyOptionTagExpansionType g = selectablePrivacyData.g();
            if (g == GraphQLPrivacyOptionTagExpansionType.NONE || g == GraphQLPrivacyOptionTagExpansionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE) {
                this.f6903d.c();
                return;
            }
            CharSequence string;
            Drawable a;
            int i;
            Drawable drawable;
            if (g == GraphQLPrivacyOptionTagExpansionType.FRIENDS_OF_TAGGEES) {
                string = this.f6900a.getString(2131234219);
                a = this.f6901b.a(this.f6900a.getDrawable(2130838225), -7235677);
                ((FbTextView) this.f6903d.a()).setOnClickListener(this.f6907h);
                ((FbTextView) this.f6903d.a()).setEnabled(true);
                i = 2130837703;
                drawable = a;
            } else if (g == GraphQLPrivacyOptionTagExpansionType.TAGGEES) {
                string = this.f6900a.getString(2131234220);
                ((FbTextView) this.f6903d.a()).setOnClickListener(null);
                ((FbTextView) this.f6903d.a()).setEnabled(false);
                i = 2130837713;
                drawable = null;
            } else {
                throw new IllegalStateException("GraphQLPrivacyOptionTagExpansionType cannot be " + g);
            }
            a = this.f6901b.a(this.f6900a.getDrawable(i), -7235677);
            ((FbTextView) this.f6903d.a()).setVisibility(0);
            TextViewUtils.a((TextView) this.f6903d.a(), a, null, drawable, null);
            ((FbTextView) this.f6903d.a()).setText(string);
        }
    }
}
