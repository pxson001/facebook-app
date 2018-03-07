package com.facebook.composer.pages;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.composer.actionitem.ActionItemController$Delegate;
import com.facebook.composer.activity.ComposerDataProviderImpl;
import com.facebook.composer.event.ComposerEvent;
import com.facebook.composer.event.ComposerEventHandler;
import com.facebook.composer.event.ComposerEventOriginator;
import com.facebook.composer.ui.publishmode.PublishModeTitleGenerator;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.feed.util.composer.abtest.ExperimentsForFeedUtilComposerAbtestModule;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsCustomPublishModeSupported;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesPublishScheduleTime;
import com.facebook.ipc.composer.model.PublishMode;
import com.facebook.ipc.composer.model.PublishMode.ProvidesPublishMode;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.resources.ui.FbTextView;
import com.facebook.resources.utils.TextViewUtils;
import com.facebook.widget.LazyView;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: friend_requests_count */
public class PagePublishOptionPillController<DataProvider extends ProvidesIsCustomPublishModeSupported & ProvidesPublishScheduleTime & ProvidesPublishMode> implements ComposerEventHandler {
    public final Resources f6824a;
    public final QeAccessor f6825b;
    public final WeakReference<DataProvider> f6826c;
    public final LazyView<FbTextView> f6827d;
    public final ActionItemController$Delegate f6828e;
    public final PublishModeTitleGenerator f6829f;
    public final GlyphColorizer f6830g;
    public final OnClickListener f6831h = new C08541(this);

    /* compiled from: friend_requests_count */
    class C08541 implements OnClickListener {
        final /* synthetic */ PagePublishOptionPillController f6822a;

        C08541(PagePublishOptionPillController pagePublishOptionPillController) {
            this.f6822a = pagePublishOptionPillController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 866988767);
            this.f6822a.f6828e.mo184a();
            Logger.a(2, EntryType.UI_INPUT_END, 445596215, a);
        }
    }

    /* compiled from: friend_requests_count */
    public /* synthetic */ class C08552 {
        public static final /* synthetic */ int[] f6823a = new int[PublishMode.values().length];

        static {
            try {
                f6823a[PublishMode.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f6823a[PublishMode.SAVE_DRAFT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f6823a[PublishMode.SCHEDULE_POST.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    @Inject
    public PagePublishOptionPillController(@Assisted DataProvider dataProvider, @Assisted LazyView<FbTextView> lazyView, @Assisted ActionItemController$Delegate actionItemController$Delegate, Resources resources, QeAccessor qeAccessor, PublishModeTitleGenerator publishModeTitleGenerator, GlyphColorizer glyphColorizer) {
        this.f6825b = qeAccessor;
        this.f6826c = new WeakReference(Preconditions.checkNotNull(dataProvider));
        this.f6828e = actionItemController$Delegate;
        this.f6827d = lazyView;
        this.f6824a = resources;
        this.f6829f = publishModeTitleGenerator;
        this.f6830g = glyphColorizer;
    }

    public final void m8155a(ComposerEvent composerEvent, @Nullable ComposerEventOriginator composerEventOriginator) {
        if (composerEvent == ComposerEvent.ON_DATASET_CHANGE) {
            ComposerDataProviderImpl composerDataProviderImpl = (ComposerDataProviderImpl) Preconditions.checkNotNull(this.f6826c.get());
            if (composerDataProviderImpl.m7402C()) {
                TextViewUtils.a((TextView) this.f6827d.a(), null, null, this.f6830g.a(this.f6824a.getDrawable(2130838259), -7235677), null);
                ((FbTextView) this.f6827d.a()).setOnClickListener(this.f6831h);
                FbTextView fbTextView = (FbTextView) this.f6827d.a();
                PublishMode j = ((ProvidesPublishMode) composerDataProviderImpl).j();
                String str = null;
                switch (C08552.f6823a[j.ordinal()]) {
                    case 1:
                        str = this.f6825b.a(ExperimentsForFeedUtilComposerAbtestModule.X, null);
                        break;
                    case 2:
                        str = this.f6825b.a(ExperimentsForFeedUtilComposerAbtestModule.W, null);
                        break;
                    case 3:
                        str = this.f6825b.a(ExperimentsForFeedUtilComposerAbtestModule.Y, null);
                        break;
                }
                if (Strings.isNullOrEmpty(str)) {
                    str = this.f6829f.a(j);
                }
                fbTextView.setText(str);
                return;
            }
            this.f6827d.c();
        }
    }
}
