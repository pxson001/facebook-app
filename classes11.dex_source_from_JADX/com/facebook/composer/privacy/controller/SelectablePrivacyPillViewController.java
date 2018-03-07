package com.facebook.composer.privacy.controller;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.composer.activity.ComposerDataProviderImpl;
import com.facebook.composer.activity.ComposerFragment.C07551;
import com.facebook.composer.analytics.ComposerAnalyticsLogger;
import com.facebook.composer.attachments.ComposerAttachment.ProvidesAttachments;
import com.facebook.composer.attachments.ComposerTagUtil;
import com.facebook.composer.event.ComposerEvent;
import com.facebook.composer.event.ComposerEventHandler;
import com.facebook.composer.event.ComposerEventOriginator;
import com.facebook.composer.privacy.common.ComposerPrivacyData;
import com.facebook.composer.privacy.common.ComposerPrivacyData.ProvidesPrivacyData;
import com.facebook.composer.ui.drawables.GlyphpileDrawable;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.graphql.enums.GraphQLPrivacyOptionTagExpansionType;
import com.facebook.graphql.enums.GraphQLPrivacyOptionType;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsTagExpansionPillSupported;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesSessionId;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesTextWithEntities;
import com.facebook.ipc.composer.model.ComposerTaggedUser.ProvidesTaggedUsers;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.privacy.model.PrivacyOptionHelper;
import com.facebook.privacy.model.SelectablePrivacyData;
import com.facebook.privacy.protocol.options.PrivacyOptionsGraphQLInterfaces.PrivacyAudienceMember;
import com.facebook.privacy.protocol.options.PrivacyOptionsGraphQLInterfaces.PrivacyOptionFieldsForComposer;
import com.facebook.privacy.ui.PrivacyIcons;
import com.facebook.privacy.ui.PrivacyIcons.Size;
import com.facebook.resources.ui.FbTextView;
import com.facebook.resources.utils.TextViewUtils;
import com.facebook.user.model.User;
import com.facebook.widget.LazyView;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.lang.ref.WeakReference;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: flatbuffer_parser */
public class SelectablePrivacyPillViewController<DataProvider extends ProvidesAttachments & ProvidesIsTagExpansionPillSupported & ProvidesSessionId & ProvidesTextWithEntities & ProvidesPrivacyData & ProvidesTaggedUsers> implements ComposerEventHandler {
    public final Resources f6871a;
    private final GlyphColorizer f6872b;
    private final LazyView<FbTextView> f6873c;
    public final WeakReference<DataProvider> f6874d;
    private final User f6875e;
    public final C07551 f6876f;
    public final ComposerAnalyticsLogger f6877g;
    private final PrivacyIcons f6878h;
    private final OnClickListener f6879i = new C08661(this);
    public ComposerPrivacyData f6880j;
    private boolean f6881k;

    /* compiled from: flatbuffer_parser */
    class C08661 implements OnClickListener {
        final /* synthetic */ SelectablePrivacyPillViewController f6869a;

        C08661(SelectablePrivacyPillViewController selectablePrivacyPillViewController) {
            this.f6869a = selectablePrivacyPillViewController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1321941399);
            this.f6869a.f6877g.c(((ProvidesSessionId) ((ProvidesAttachments) Preconditions.checkNotNull(this.f6869a.f6874d.get()))).ab());
            this.f6869a.f6876f.m7454a();
            Logger.a(2, EntryType.UI_INPUT_END, 1785177418, a);
        }
    }

    /* compiled from: flatbuffer_parser */
    /* synthetic */ class C08672 {
        static final /* synthetic */ int[] f6870a = new int[ComposerEvent.values().length];

        static {
            try {
                f6870a[ComposerEvent.ON_FIRST_DRAW.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f6870a[ComposerEvent.ON_DATASET_CHANGE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f6870a[ComposerEvent.ON_STATUS_TEXT_CHANGED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f6870a[ComposerEvent.ON_PRIVACY_FETCHED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f6870a[ComposerEvent.ON_PRIVACY_CHANGE_FROM_INLINE_PRIVACY_SURVEY.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    @Inject
    public SelectablePrivacyPillViewController(Resources resources, GlyphColorizer glyphColorizer, ComposerAnalyticsLogger composerAnalyticsLogger, User user, @Assisted DataProvider dataProvider, @Assisted LazyView<FbTextView> lazyView, @Assisted PillClickedListener pillClickedListener, PrivacyIcons privacyIcons) {
        this.f6871a = resources;
        this.f6872b = glyphColorizer;
        this.f6877g = composerAnalyticsLogger;
        this.f6875e = user;
        this.f6874d = new WeakReference(dataProvider);
        this.f6873c = lazyView;
        this.f6876f = pillClickedListener;
        this.f6878h = privacyIcons;
        m8210a();
    }

    public final void m8216a(ComposerEvent composerEvent, @Nullable ComposerEventOriginator composerEventOriginator) {
        switch (C08672.f6870a[composerEvent.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                m8210a();
                return;
            default:
                return;
        }
    }

    private void m8210a() {
        boolean z = false;
        ProvidesAttachments providesAttachments = (ProvidesAttachments) Preconditions.checkNotNull(this.f6874d.get());
        if (((ProvidesPrivacyData) providesAttachments).ag().d || ((ProvidesPrivacyData) providesAttachments).ag().b == null || ((ProvidesPrivacyData) providesAttachments).ag().b.d == null) {
            this.f6873c.c();
            this.f6880j = null;
            this.f6881k = false;
            return;
        }
        if (!ComposerTagUtil.a(Long.parseLong(this.f6875e.a), ((ProvidesTaggedUsers) providesAttachments).h(), ((ProvidesTextWithEntities) providesAttachments).ae(), providesAttachments.m()).isEmpty()) {
            z = true;
        }
        if (z != this.f6881k || this.f6880j != ((ProvidesPrivacyData) providesAttachments).ag()) {
            this.f6881k = z;
            this.f6880j = ((ProvidesPrivacyData) providesAttachments).ag();
            ((FbTextView) this.f6873c.a()).setOnClickListener(this.f6879i);
            m8211b();
        }
    }

    private void m8211b() {
        Drawable a;
        CharSequence concat;
        boolean z = false;
        SelectablePrivacyData selectablePrivacyData = this.f6880j.b;
        if (!(selectablePrivacyData == null || selectablePrivacyData.d == null)) {
            z = true;
        }
        Preconditions.checkState(z);
        ((FbTextView) this.f6873c.a()).setVisibility(0);
        int d = m8213d();
        if (d != 0) {
            a = this.f6872b.a(this.f6871a.getDrawable(d), -7235677);
        } else {
            a = null;
        }
        Drawable a2 = this.f6872b.a(this.f6871a.getDrawable(2130838259), -7235677);
        FbTextView fbTextView = (FbTextView) this.f6873c.a();
        fbTextView.setPadding(this.f6871a.getDimensionPixelSize(2131429686), this.f6871a.getDimensionPixelSize(2131429687), this.f6871a.getDimensionPixelSize(2131429686), this.f6871a.getDimensionPixelSize(2131429687));
        String e = m8214e();
        int f = m8215f();
        if (f == 0 || ((Boolean) Preconditions.checkNotNull(Boolean.valueOf(((ComposerDataProviderImpl) ((ProvidesAttachments) this.f6874d.get())).m7414P()))).booleanValue()) {
            TextViewUtils.a(fbTextView, a, null, a2, null);
            Object obj = e;
        } else {
            TextViewUtils.a(fbTextView, a, null, new GlyphpileDrawable(ImmutableList.of(this.f6872b.a(this.f6871a.getDrawable(f), -7235677), a2), this.f6871a.getDimensionPixelSize(2131429685)), null);
            concat = e.concat(",");
        }
        fbTextView.setText(concat);
    }

    private int m8213d() {
        PrivacyOptionFieldsForComposer privacyOptionFieldsForComposer = this.f6880j.b.d;
        if (PrivacyOptionHelper.b(privacyOptionFieldsForComposer)) {
            return this.f6878h.a(GraphQLPrivacyOptionType.FRIENDS_EXCEPT_ACQUAINTANCES, Size.PILL);
        }
        if (PrivacyOptionHelper.c(privacyOptionFieldsForComposer)) {
            return this.f6878h.a(GraphQLPrivacyOptionType.CUSTOM, Size.PILL);
        }
        return this.f6878h.a(PrivacyOptionHelper.a(privacyOptionFieldsForComposer), Size.PILL);
    }

    private String m8214e() {
        PrivacyOptionFieldsForComposer privacyOptionFieldsForComposer = this.f6880j.b.d;
        if (PrivacyOptionHelper.b(privacyOptionFieldsForComposer)) {
            String string;
            ImmutableList g = privacyOptionFieldsForComposer.g();
            if (g.isEmpty()) {
                string = this.f6871a.getString(2131234207);
            } else {
                String string2;
                if (g != null && !g.isEmpty()) {
                    switch (g.size()) {
                        case 1:
                            string2 = this.f6871a.getString(2131234209, new Object[]{((PrivacyAudienceMember) g.get(0)).d()});
                            break;
                        case 2:
                            string2 = this.f6871a.getString(2131234210, new Object[]{((PrivacyAudienceMember) g.get(0)).d(), ((PrivacyAudienceMember) g.get(1)).d()});
                            break;
                        case 3:
                            string2 = this.f6871a.getString(2131234211, new Object[]{((PrivacyAudienceMember) g.get(0)).d(), ((PrivacyAudienceMember) g.get(1)).d(), ((PrivacyAudienceMember) g.get(2)).d()});
                            break;
                        default:
                            string2 = this.f6871a.getString(2131234212, new Object[]{((PrivacyAudienceMember) g.get(0)).d(), ((PrivacyAudienceMember) g.get(1)).d(), ((PrivacyAudienceMember) g.get(2)).d()});
                            break;
                    }
                }
                string2 = this.f6871a.getString(2131234195);
                string = string2;
            }
            return string;
        } else if (PrivacyOptionHelper.c(privacyOptionFieldsForComposer)) {
            return m8212c(privacyOptionFieldsForComposer.F_());
        } else {
            return privacyOptionFieldsForComposer.d();
        }
    }

    private int m8215f() {
        SelectablePrivacyData selectablePrivacyData = this.f6880j.b;
        if (!selectablePrivacyData.f() || selectablePrivacyData.b || !this.f6881k) {
            return 0;
        }
        GraphQLPrivacyOptionTagExpansionType g = selectablePrivacyData.g();
        if (g == GraphQLPrivacyOptionTagExpansionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE || g == GraphQLPrivacyOptionTagExpansionType.NONE) {
            return 0;
        }
        if (g == GraphQLPrivacyOptionTagExpansionType.FRIENDS_OF_TAGGEES) {
            return 2130837706;
        }
        if (g == GraphQLPrivacyOptionTagExpansionType.TAGGEES) {
            return 2130837710;
        }
        throw new IllegalStateException("GraphQLPrivacyOptionTagExpansionType cannot be " + g);
    }

    private String m8212c(List<? extends PrivacyAudienceMember> list) {
        if (list.isEmpty()) {
            return this.f6871a.getString(2131234214);
        }
        String string;
        if (list != null && !list.isEmpty()) {
            switch (list.size()) {
                case 1:
                    string = this.f6871a.getString(2131234215, new Object[]{((PrivacyAudienceMember) list.get(0)).d()});
                    break;
                case 2:
                    string = this.f6871a.getString(2131234216, new Object[]{((PrivacyAudienceMember) list.get(0)).d(), ((PrivacyAudienceMember) list.get(1)).d()});
                    break;
                case 3:
                    string = this.f6871a.getString(2131234217, new Object[]{((PrivacyAudienceMember) list.get(0)).d(), ((PrivacyAudienceMember) list.get(1)).d(), ((PrivacyAudienceMember) list.get(2)).d()});
                    break;
                default:
                    string = this.f6871a.getString(2131234218, new Object[]{((PrivacyAudienceMember) list.get(0)).d(), ((PrivacyAudienceMember) list.get(1)).d(), ((PrivacyAudienceMember) list.get(2)).d()});
                    break;
            }
        }
        string = this.f6871a.getString(2131234195);
        return string;
    }
}
