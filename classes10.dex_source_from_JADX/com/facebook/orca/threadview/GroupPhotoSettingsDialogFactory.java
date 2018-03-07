package com.facebook.orca.threadview;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.media.mediapicker.dialog.PickMediaSource;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.threadview.iconpicker.ThreadIconPickerActivity;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Inject;

/* compiled from: min_time_between_updates_ms */
public class GroupPhotoSettingsDialogFactory {
    private final Context f6959a;
    public final ThreadViewOperationsHelper f6960b;

    /* compiled from: min_time_between_updates_ms */
    abstract class PhotoOption {
        public final String f6949c;
        final /* synthetic */ GroupPhotoSettingsDialogFactory f6950d;

        public abstract void mo252a();

        public PhotoOption(GroupPhotoSettingsDialogFactory groupPhotoSettingsDialogFactory, String str) {
            this.f6950d = groupPhotoSettingsDialogFactory;
            this.f6949c = str;
        }
    }

    public static GroupPhotoSettingsDialogFactory m6569b(InjectorLike injectorLike) {
        return new GroupPhotoSettingsDialogFactory((Context) injectorLike.getInstance(Context.class), ThreadViewOperationsHelper.m7876b(injectorLike));
    }

    @Inject
    public GroupPhotoSettingsDialogFactory(Context context, ThreadViewOperationsHelper threadViewOperationsHelper) {
        this.f6959a = context;
        this.f6960b = threadViewOperationsHelper;
    }

    public final AlertDialog m6570a(final ThreadSummary threadSummary) {
        Resources resources = this.f6959a.getResources();
        final List<PhotoOption> a = Lists.a(4);
        if (threadSummary.c() || threadSummary.b()) {
            a.add(new PhotoOption(this, resources.getString(2131231162)) {
                final /* synthetic */ GroupPhotoSettingsDialogFactory f6952b;

                public final void mo252a() {
                    ThreadViewOperationsHelper threadViewOperationsHelper = this.f6952b.f6960b;
                    ThreadSummary threadSummary = threadSummary;
                    Intent intent = new Intent(threadViewOperationsHelper.f7920a, ThreadIconPickerActivity.class);
                    intent.putExtra("threadKey", threadSummary.a);
                    intent.putExtra("remove", true);
                    threadViewOperationsHelper.f7922c.a(intent, threadViewOperationsHelper.f7920a);
                }
            });
        }
        a.add(new PhotoOption(this, resources.getString(2131230967)) {
            final /* synthetic */ GroupPhotoSettingsDialogFactory f6954b;

            public final void mo252a() {
                this.f6954b.f6960b.m7878a(threadSummary, PickMediaSource.CAMERA);
            }
        });
        a.add(new PhotoOption(this, resources.getString(2131230973)) {
            final /* synthetic */ GroupPhotoSettingsDialogFactory f6956b;

            public final void mo252a() {
                this.f6956b.f6960b.m7878a(threadSummary, PickMediaSource.GALLERY);
            }
        });
        CharSequence[] charSequenceArr = new CharSequence[a.size()];
        int i = 0;
        for (PhotoOption photoOption : a) {
            int i2 = i + 1;
            charSequenceArr[i] = photoOption.f6949c;
            i = i2;
        }
        FbAlertDialogBuilder fbAlertDialogBuilder = new FbAlertDialogBuilder(this.f6959a);
        fbAlertDialogBuilder.a(2131231365);
        fbAlertDialogBuilder.a(charSequenceArr, new OnClickListener(this) {
            final /* synthetic */ GroupPhotoSettingsDialogFactory f6958b;

            public void onClick(DialogInterface dialogInterface, int i) {
                ((PhotoOption) a.get(i)).mo252a();
                dialogInterface.dismiss();
            }
        });
        return fbAlertDialogBuilder.a();
    }
}
