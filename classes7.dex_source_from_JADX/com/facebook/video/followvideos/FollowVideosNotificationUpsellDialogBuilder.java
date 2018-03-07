package com.facebook.video.followvideos;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager.LayoutParams;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.ui.dialogs.FbDialog;
import com.facebook.video.followvideos.VideoHomeFollowVideosButton.C12034;
import javax.annotation.Nullable;

/* compiled from: does not take an ExecutorToken as its first parameter. */
public class FollowVideosNotificationUpsellDialogBuilder {
    public Context f15667a;
    public String f15668b;
    public long f15669c = -1;
    @Nullable
    public C12034 f15670d;

    /* compiled from: does not take an ExecutorToken as its first parameter. */
    public class NotificationDialog extends FbDialog {
        public final /* synthetic */ FollowVideosNotificationUpsellDialogBuilder f15663a;
        public Handler f15664b = new Handler(getContext().getMainLooper());
        public Runnable f15665c;
        public boolean f15666d;

        /* compiled from: does not take an ExecutorToken as its first parameter. */
        public class C11972 implements Runnable {
            final /* synthetic */ NotificationDialog f15660a;

            public C11972(NotificationDialog notificationDialog) {
                this.f15660a = notificationDialog;
            }

            public void run() {
                this.f15660a.dismiss();
            }
        }

        /* compiled from: does not take an ExecutorToken as its first parameter. */
        public class C11983 implements OnShowListener {
            final /* synthetic */ NotificationDialog f15661a;

            public C11983(NotificationDialog notificationDialog) {
                this.f15661a = notificationDialog;
            }

            public void onShow(DialogInterface dialogInterface) {
                HandlerDetour.b(this.f15661a.f15664b, this.f15661a.f15665c, this.f15661a.f15663a.f15669c, -1833020768);
            }
        }

        /* compiled from: does not take an ExecutorToken as its first parameter. */
        public class C11994 implements OnDismissListener {
            final /* synthetic */ NotificationDialog f15662a;

            public C11994(NotificationDialog notificationDialog) {
                this.f15662a = notificationDialog;
            }

            public void onDismiss(DialogInterface dialogInterface) {
                HandlerDetour.a(this.f15662a.f15664b, this.f15662a.f15665c);
            }
        }

        public NotificationDialog(FollowVideosNotificationUpsellDialogBuilder followVideosNotificationUpsellDialogBuilder, Context context) {
            this.f15663a = followVideosNotificationUpsellDialogBuilder;
            super(context);
            requestWindowFeature(1);
            setContentView(2130907678);
            getWindow().setBackgroundDrawable(null);
            LayoutParams attributes = getWindow().getAttributes();
            attributes.width = -1;
            attributes.height = -2;
            attributes.gravity = 80;
            attributes.flags &= -3;
            getWindow().setAttributes(attributes);
            ((FbTextView) findViewById(2131568338)).setText(this.f15663a.f15667a.getResources().getString(2131235670, new Object[]{this.f15663a.f15668b}));
            final FbTextView fbTextView = (FbTextView) findViewById(2131568339);
            fbTextView.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ NotificationDialog f15659b;

                public void onClick(View view) {
                    boolean z;
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 1774401982);
                    NotificationDialog notificationDialog = this.f15659b;
                    if (this.f15659b.f15666d) {
                        z = false;
                    } else {
                        z = true;
                    }
                    notificationDialog.f15666d = z;
                    if (this.f15659b.f15666d) {
                        fbTextView.setText(this.f15659b.f15663a.f15667a.getResources().getString(2131235672));
                    } else {
                        fbTextView.setText(this.f15659b.f15663a.f15667a.getResources().getString(2131235671));
                    }
                    if (this.f15659b.f15663a.f15670d != null) {
                        this.f15659b.f15663a.f15670d.m19621a(this.f15659b.f15666d);
                    }
                    LogUtils.a(2007427432, a);
                }
            });
            if (this.f15663a.f15669c != -1) {
                this.f15665c = new C11972(this);
                setOnShowListener(new C11983(this));
                setOnDismissListener(new C11994(this));
            }
        }

        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            if (this.f15663a.f15669c != -1) {
                HandlerDetour.a(this.f15664b, this.f15665c);
                HandlerDetour.b(this.f15664b, this.f15665c, this.f15663a.f15669c, -262645804);
            }
            return super.dispatchTouchEvent(motionEvent);
        }
    }
}
