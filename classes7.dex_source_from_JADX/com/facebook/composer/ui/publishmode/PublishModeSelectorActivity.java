package com.facebook.composer.ui.publishmode;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.composer.attachments.AttachmentUtils;
import com.facebook.composer.attachments.ComposerAttachment;
import com.facebook.composer.ui.publishmode.SchedulePostController.SchedulePostControllerHost;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.fbui.widget.contentview.ContentView.ThumbnailSize;
import com.facebook.fbui.widget.layout.SegmentedLinearLayout;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.composer.model.PublishMode;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ultralight.Inject;
import com.facebook.widget.titlebar.FbTitleBar;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Calendar;

/* compiled from: composer_entrypoint */
public class PublishModeSelectorActivity extends FbFragmentActivity implements SchedulePostControllerHost {
    @Inject
    PublishModeTitleGenerator f17077p;
    @Inject
    SchedulePostControllerProvider f17078q;
    public SchedulePostController f17079r;

    /* compiled from: composer_entrypoint */
    class C13811 implements OnClickListener {
        final /* synthetic */ PublishModeSelectorActivity f17074a;

        C13811(PublishModeSelectorActivity publishModeSelectorActivity) {
            this.f17074a = publishModeSelectorActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 338702659);
            this.f17074a.onBackPressed();
            Logger.a(2, EntryType.UI_INPUT_END, 334385084, a);
        }
    }

    private static <T extends Context> void m21027a(Class<T> cls, T t) {
        m21028a((Object) t, (Context) t);
    }

    public static void m21028a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((PublishModeSelectorActivity) obj).m21025a(PublishModeTitleGenerator.m21032b(injectorLike), (SchedulePostControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(SchedulePostControllerProvider.class));
    }

    public static Intent m21022a(Context context, PublishMode publishMode, ImmutableList<ComposerAttachment> immutableList, Long l) {
        Intent intent = new Intent(context, PublishModeSelectorActivity.class);
        intent.putExtra("publishMode", publishMode);
        if (l != null) {
            intent.putExtra("scheduleTime", l);
        }
        intent.putExtra("composerAttachments", immutableList);
        return intent;
    }

    public final void m21030b(Bundle bundle) {
        Class cls = PublishModeSelectorActivity.class;
        m21028a((Object) this, (Context) this);
        PublishMode publishMode = (PublishMode) getIntent().getSerializableExtra("publishMode");
        long longExtra = getIntent().getLongExtra("scheduleTime", -1);
        ImmutableList copyOf = ImmutableList.copyOf((ArrayList) getIntent().getSerializableExtra("composerAttachments"));
        this.f17079r = this.f17078q.m21040a(this, Long.valueOf(longExtra));
        setContentView(2130906507);
        FbTitleBar fbTitleBar = (FbTitleBar) findViewById(2131558563);
        fbTitleBar.setTitle(2131234633);
        fbTitleBar.a(new C13811(this));
        SegmentedLinearLayout segmentedLinearLayout = (SegmentedLinearLayout) a(2131566444);
        for (final PublishMode publishMode2 : PublishMode.values()) {
            if (m21029a(publishMode2, copyOf)) {
                ContentView contentView = (ContentView) LayoutInflater.from(this).inflate(2130906506, segmentedLinearLayout, false);
                contentView.setTitleText(this.f17077p.m21034a(publishMode2));
                if (publishMode2 == publishMode) {
                    contentView.setTitleTextAppearance(2131625397);
                }
                contentView.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ PublishModeSelectorActivity f17076b;

                    public void onClick(View view) {
                        int a = Logger.a(2, EntryType.UI_INPUT_START, 895631121);
                        if (publishMode2 == PublishMode.SCHEDULE_POST) {
                            SchedulePostController schedulePostController = this.f17076b.f17079r;
                            if (schedulePostController.f17097d.getTimeInMillis() - Calendar.getInstance().getTimeInMillis() < 660000) {
                                schedulePostController.f17097d = Calendar.getInstance();
                                schedulePostController.f17097d.add(12, 11);
                                schedulePostController.f17096c.m21037b();
                                schedulePostController.f17096c.m21038c();
                            }
                            schedulePostController.f17096c.show();
                        } else {
                            this.f17076b.m21026a(publishMode2, 0);
                        }
                        LogUtils.a(-1160233754, a);
                    }
                });
                if (publishMode2 == PublishMode.SCHEDULE_POST && longExtra > 0) {
                    contentView.setThumbnailSize(ThumbnailSize.MEDIUM);
                    contentView.setSubtitleText(this.f17077p.m21033a(longExtra));
                }
                segmentedLinearLayout.addView(contentView);
            }
        }
    }

    private void m21025a(PublishModeTitleGenerator publishModeTitleGenerator, SchedulePostControllerProvider schedulePostControllerProvider) {
        this.f17077p = publishModeTitleGenerator;
        this.f17078q = schedulePostControllerProvider;
    }

    private static boolean m21029a(PublishMode publishMode, ImmutableList<ComposerAttachment> immutableList) {
        if (publishMode == PublishMode.SAVE_DRAFT && AttachmentUtils.i(immutableList)) {
            return false;
        }
        return true;
    }

    public final void mo1337i() {
        m21026a(PublishMode.SCHEDULE_POST, this.f17079r.f17097d.getTimeInMillis() / 1000);
    }

    private void m21026a(PublishMode publishMode, long j) {
        Intent intent = new Intent();
        intent.putExtra("selectedPublishMode", publishMode);
        intent.putExtra("scheduleTime", j);
        setResult(-1, intent);
        finish();
    }
}
