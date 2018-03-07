package com.facebook.composer.privacy.controller;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.composer.activity.ComposerFragment.C07551;
import com.facebook.composer.analytics.ComposerAnalyticsLogger;
import com.facebook.composer.attachments.ComposerAttachment.ProvidesAttachments;
import com.facebook.composer.attachments.ComposerTagUtil;
import com.facebook.composer.event.ComposerEvent;
import com.facebook.composer.event.ComposerEventHandler;
import com.facebook.composer.event.ComposerEventOriginator;
import com.facebook.composer.privacy.common.ComposerPrivacyData;
import com.facebook.composer.privacy.common.ComposerPrivacyData.ProvidesPrivacyData;
import com.facebook.composer.privacy.common.TagExpandPrivacyHelper;
import com.facebook.composer.privacy.controller.SelectablePrivacyPillViewController.PillClickedListener;
import com.facebook.device.ScreenUtil;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesSessionId;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesTextWithEntities;
import com.facebook.ipc.composer.model.ComposerTaggedUser.ProvidesTaggedUsers;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.privacy.selector.AudienceTypeaheadUtil;
import com.facebook.resources.ui.FbTextView;
import com.facebook.resources.utils.TextViewUtils;
import com.facebook.user.model.User;
import com.facebook.widget.LazyView;
import com.facebook.widget.tokenizedtypeahead.model.BaseToken;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: first_story_tracking_data */
public class SelectablePrivacyPillViewUsingBaseTokenController<DataProvider extends ProvidesAttachments & ProvidesSessionId & ProvidesTextWithEntities & ProvidesPrivacyData & ProvidesTaggedUsers> implements ComposerEventHandler {
    private final AudienceTypeaheadUtil f6884a;
    private final TagExpandPrivacyHelper f6885b;
    private final ScreenUtil f6886c;
    private final User f6887d;
    public final WeakReference<DataProvider> f6888e;
    private final LazyView<FbTextView> f6889f;
    private final Context f6890g;
    public final C07551 f6891h;
    public final ComposerAnalyticsLogger f6892i;
    private final GlyphColorizer f6893j;
    private final OnClickListener f6894k = new C08681(this);
    private ComposerPrivacyData f6895l;
    private ImmutableList<BaseToken> f6896m;
    private boolean f6897n;

    /* compiled from: first_story_tracking_data */
    class C08681 implements OnClickListener {
        final /* synthetic */ SelectablePrivacyPillViewUsingBaseTokenController f6882a;

        C08681(SelectablePrivacyPillViewUsingBaseTokenController selectablePrivacyPillViewUsingBaseTokenController) {
            this.f6882a = selectablePrivacyPillViewUsingBaseTokenController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1891193152);
            this.f6882a.f6892i.c(((ProvidesSessionId) ((ProvidesAttachments) Preconditions.checkNotNull(this.f6882a.f6888e.get()))).ab());
            this.f6882a.f6891h.m7454a();
            Logger.a(2, EntryType.UI_INPUT_END, -640829317, a);
        }
    }

    /* compiled from: first_story_tracking_data */
    /* synthetic */ class C08692 {
        static final /* synthetic */ int[] f6883a = new int[ComposerEvent.values().length];

        static {
            try {
                f6883a[ComposerEvent.ON_FIRST_DRAW.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f6883a[ComposerEvent.ON_DATASET_CHANGE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f6883a[ComposerEvent.ON_STATUS_TEXT_CHANGED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f6883a[ComposerEvent.ON_PRIVACY_FETCHED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f6883a[ComposerEvent.ON_PRIVACY_CHANGE_FROM_INLINE_PRIVACY_SURVEY.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    @Inject
    public SelectablePrivacyPillViewUsingBaseTokenController(AudienceTypeaheadUtil audienceTypeaheadUtil, TagExpandPrivacyHelper tagExpandPrivacyHelper, ScreenUtil screenUtil, ComposerAnalyticsLogger composerAnalyticsLogger, GlyphColorizer glyphColorizer, User user, @Assisted Context context, @Assisted DataProvider dataProvider, @Assisted LazyView<FbTextView> lazyView, @Assisted PillClickedListener pillClickedListener) {
        this.f6884a = audienceTypeaheadUtil;
        this.f6885b = tagExpandPrivacyHelper;
        this.f6886c = screenUtil;
        this.f6892i = composerAnalyticsLogger;
        this.f6893j = glyphColorizer;
        this.f6890g = context;
        this.f6887d = user;
        this.f6888e = new WeakReference(dataProvider);
        this.f6889f = lazyView;
        this.f6891h = pillClickedListener;
        m8218a();
    }

    public final void m8221a(ComposerEvent composerEvent, @Nullable ComposerEventOriginator composerEventOriginator) {
        switch (C08692.f6883a[composerEvent.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                m8218a();
                return;
            default:
                return;
        }
    }

    private void m8218a() {
        boolean z = false;
        ProvidesAttachments providesAttachments = (ProvidesAttachments) Preconditions.checkNotNull(this.f6888e.get());
        if (((ProvidesPrivacyData) providesAttachments).ag().d || ((ProvidesPrivacyData) providesAttachments).ag().b == null || ((ProvidesPrivacyData) providesAttachments).ag().b.d == null) {
            this.f6889f.c();
            this.f6895l = null;
            this.f6897n = false;
            return;
        }
        if (!ComposerTagUtil.a(Long.parseLong(this.f6887d.a), ((ProvidesTaggedUsers) providesAttachments).h(), ((ProvidesTextWithEntities) providesAttachments).ae(), providesAttachments.m()).isEmpty()) {
            z = true;
        }
        if (z != this.f6897n || this.f6895l != ((ProvidesPrivacyData) providesAttachments).ag()) {
            this.f6897n = z;
            this.f6895l = ((ProvidesPrivacyData) providesAttachments).ag();
            ((FbTextView) this.f6889f.a()).setOnClickListener(this.f6894k);
            this.f6896m = this.f6884a.a(this.f6895l.b, this.f6890g.getResources(), this.f6897n, true);
            if (this.f6896m != null) {
                m8219b();
            }
        }
    }

    private void m8219b() {
        ((FbTextView) this.f6889f.a()).setVisibility(0);
        FbTextView fbTextView = (FbTextView) this.f6889f.a();
        Resources resources = this.f6890g.getResources();
        fbTextView.setPadding(resources.getDimensionPixelSize(2131429686), resources.getDimensionPixelSize(2131429681), resources.getDimensionPixelSize(2131429686), resources.getDimensionPixelSize(2131429681));
        fbTextView.setText(this.f6885b.a(this.f6890g, this.f6896m, fbTextView.getTextSize(), m8220c(), true, true));
        TextViewUtils.a(fbTextView, null, null, this.f6893j.a(resources.getDrawable(2130838259), -7235677), null);
    }

    @VisibleForTesting
    private int m8220c() {
        Resources resources = this.f6890g.getResources();
        return (((((this.f6886c.c() - resources.getDimensionPixelSize(2131429632)) - resources.getDimensionPixelSize(2131428032)) - resources.getDimensionPixelSize(2131429662)) - resources.getDimensionPixelSize(2131429686)) - resources.getDimensionPixelSize(2131429686)) - resources.getDimensionPixelSize(2131429685);
    }
}
