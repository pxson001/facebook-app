package com.facebook.platform.composer.titlebar;

import android.content.res.Resources;
import android.view.ViewStub;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.util.StringUtil;
import com.facebook.composer.event.ComposerEvent;
import com.facebook.composer.event.ComposerEventHandler;
import com.facebook.composer.event.ComposerEventOriginator;
import com.facebook.composer.privacy.common.ComposerPrivacyData;
import com.facebook.inject.Assisted;
import com.facebook.inject.IdBasedProvider;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.ipc.composer.model.ComposerType;
import com.facebook.ipc.composer.model.TargetType;
import com.facebook.platform.composer.composer.PlatformComposerFragment;
import com.facebook.platform.composer.composer.PlatformComposerFragment.C05306;
import com.facebook.platform.composer.composer.PlatformComposerFragment.C05306.C05271;
import com.facebook.platform.composer.composer.PlatformComposerFragment.C05306.C05282;
import com.facebook.platform.composer.composer.PlatformComposerFragment.C05306.C05293;
import com.facebook.platform.composer.model.PlatformComposerConfiguration;
import com.facebook.platform.composer.model.PlatformComposerConfiguration.PostButtonPosition;
import com.facebook.platform.composer.model.PlatformComposerModel;
import com.facebook.platform.composer.privacy.PlatformComposerTagExpandPrivacyHelper.C05481;
import com.facebook.privacy.selector.AudienceTypeaheadUtil;
import com.facebook.privacy.ui.PrivacyIcons;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: result.getResult is null */
public class PlatformComposerTitleBarController implements ComposerEventHandler {
    private static final ImmutableList<ComposerEvent> f4440a = ImmutableList.of(ComposerEvent.ON_DATASET_CHANGE, ComposerEvent.ON_STATUS_TEXT_CHANGED);
    private final WeakReference<DataProvider> f4441b;
    private final AbstractFbErrorReporter f4442c;
    public final Resources f4443d;
    private final PlatformComposerTitleBarView f4444e;
    private final AudienceTypeaheadUtil f4445f;
    private final PlatformComposerTargetImageController f4446g;
    public final Boolean f4447h;

    /* compiled from: result.getResult is null */
    public /* synthetic */ class C05801 {
        public static final /* synthetic */ int[] f4439a = new int[TargetType.values().length];

        static {
            try {
                f4439a[TargetType.UNDIRECTED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f4439a[TargetType.USER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f4439a[TargetType.PAGE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f4439a[TargetType.GROUP.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    @Inject
    public PlatformComposerTitleBarController(@Assisted ViewStub viewStub, @Assisted C05306 c05306, AbstractFbErrorReporter abstractFbErrorReporter, Resources resources, PlatformComposerConfiguration platformComposerConfiguration, AudienceTypeaheadUtil audienceTypeaheadUtil, PlatformComposerTargetImageControllerProvider platformComposerTargetImageControllerProvider, Boolean bool) {
        this.f4442c = abstractFbErrorReporter;
        this.f4441b = new WeakReference(Preconditions.checkNotNull(c05306));
        this.f4443d = resources;
        this.f4445f = audienceTypeaheadUtil;
        this.f4447h = bool;
        if (c05306.m4042c()) {
            viewStub.setLayoutResource(2130906324);
            this.f4444e = (PlatformComposerTitleBarView) viewStub.inflate();
            this.f4446g = new PlatformComposerTargetImageController(this.f4444e.findViewById(2131566142), this.f4444e.findViewById(2131566143), IdBasedProvider.a(platformComposerTargetImageControllerProvider, 3595), PrivacyIcons.a(platformComposerTargetImageControllerProvider));
        } else {
            viewStub.setLayoutResource(2130906323);
            this.f4444e = (PlatformComposerTitleBarView) viewStub.inflate();
            this.f4446g = null;
        }
        this.f4444e.f4451a = new C05271(c05306);
        this.f4444e.f4452b = new C05282(c05306);
        this.f4444e.f4453c = new C05293(c05306);
        this.f4444e.setShowPostButton(platformComposerConfiguration.f4165b == PostButtonPosition.TOP);
        m4300d();
    }

    public final void m4301a(ComposerEvent composerEvent, @Nullable ComposerEventOriginator composerEventOriginator) {
        if (f4440a.contains(composerEvent)) {
            m4300d();
        }
    }

    private String m4299a(ComposerPrivacyData composerPrivacyData, boolean z) {
        if (composerPrivacyData.b != null && composerPrivacyData.b.a != null) {
            ImmutableList a = this.f4445f.a(composerPrivacyData.b, this.f4443d, z, false);
            StringBuilder stringBuilder = new StringBuilder();
            StringUtil.a(stringBuilder, ", ", new C05481(), new Object[]{a});
            return stringBuilder.toString();
        } else if (composerPrivacyData.a != null) {
            return composerPrivacyData.a.b;
        } else {
            if (composerPrivacyData.d) {
                return "...";
            }
            this.f4442c.a("platform_composer_update_titlebar", "No privacy data");
            return "";
        }
    }

    private void m4300d() {
        C05306 c05306 = (C05306) Preconditions.checkNotNull(this.f4441b.get());
        if (this.f4444e == null) {
            this.f4442c.b("composer_update_titlebar", "TitleBar is not set in Composer Fragment!");
            return;
        }
        this.f4444e.setPostButtonEnabled(PlatformComposerFragment.aA(c05306.f4103a));
        String string;
        if (c05306.m4042c()) {
            this.f4444e.setTitlePrefix(this.f4443d.getString(2131238384));
            PlatformComposerTitleBarView platformComposerTitleBarView = this.f4444e;
            ComposerTargetData composerTargetData = c05306.m4041a().f4190e;
            switch (C05801.f4439a[composerTargetData.targetType.ordinal()]) {
                case 1:
                    string = this.f4443d.getString(2131238385);
                    break;
                case 2:
                    string = this.f4443d.getString(2131238386, new Object[]{composerTargetData.targetName});
                    break;
                default:
                    string = composerTargetData.targetName;
                    break;
            }
            platformComposerTitleBarView.setTitle(string);
            this.f4444e.setSubtitlePrefix(this.f4443d.getString(2131238387));
            this.f4444e.setSubtitle(m4299a(c05306.m4041a().f4189d, PlatformComposerFragment.aV(c05306.f4103a)));
            this.f4446g.m4288a(c05306.m4041a().f4190e, c05306.m4041a().f4189d);
            return;
        }
        platformComposerTitleBarView = this.f4444e;
        PlatformComposerModel a = c05306.m4041a();
        Preconditions.checkNotNull(a);
        ComposerConfiguration composerConfiguration = a.f4187b;
        ComposerTargetData composerTargetData2 = a.f4190e;
        Preconditions.checkNotNull(composerConfiguration);
        Preconditions.checkNotNull(composerTargetData2);
        switch (C05801.f4439a[composerTargetData2.targetType.ordinal()]) {
            case 1:
                if (composerConfiguration.getComposerType() != ComposerType.SHARE) {
                    string = this.f4443d.getString(this.f4447h.booleanValue() ? 2131234524 : 2131234523);
                    break;
                } else {
                    string = this.f4443d.getString(this.f4447h.booleanValue() ? 2131238365 : 2131238364);
                    break;
                }
            case 2:
                string = this.f4443d.getString(2131238366, new Object[]{composerTargetData2.targetName});
                break;
            case 3:
                if (!composerTargetData2.actsAsTarget) {
                    string = this.f4443d.getString(2131238367, new Object[]{composerTargetData2.targetName});
                    break;
                } else {
                    string = this.f4443d.getString(2131234611, new Object[]{composerTargetData2.targetName});
                    break;
                }
            case 4:
                string = this.f4443d.getString(2131238368, new Object[]{composerTargetData2.targetName});
                break;
            default:
                string = composerTargetData2.targetName;
                break;
        }
        platformComposerTitleBarView.setTitle(string);
        this.f4444e.setSubtitle(this.f4443d.getString(2131234585));
    }
}
