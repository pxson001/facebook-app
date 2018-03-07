package com.facebook.orca.threadview.sms;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.provider.ContactsContract.Contacts;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import com.facebook.common.util.ContextUtils;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.cache.ThreadParticipantUtils;
import com.facebook.messaging.model.threads.ThreadParticipant;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.sms.util.SmsContactUtil;
import com.facebook.orca.threadview.ThreadViewLoader.Result;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.facebook.user.cache.UserCache;
import com.facebook.user.model.User;
import com.facebook.user.model.User.Type;
import com.facebook.user.model.UserKey;
import com.facebook.user.tiles.UserTileViewParams;
import com.facebook.widget.tiles.TileBadge;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: mStopQPLMarker */
public class SmsThreadViewButtonsHelper {
    public final Context f8346a;
    private final SecureContextHelper f8347b;
    private final ThreadParticipantUtils f8348c;
    public final SmsContactUtil f8349d;
    public final UserCache f8350e;

    /* compiled from: mStopQPLMarker */
    public class C12492 implements OnClickListener {
        final /* synthetic */ SmsThreadViewButtonsHelper f8344a;

        public C12492(SmsThreadViewButtonsHelper smsThreadViewButtonsHelper) {
            this.f8344a = smsThreadViewButtonsHelper;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* compiled from: mStopQPLMarker */
    public class GroupContactsAdapter extends ArrayAdapter<ThreadParticipant> {
        final /* synthetic */ SmsThreadViewButtonsHelper f8345a;

        public GroupContactsAdapter(SmsThreadViewButtonsHelper smsThreadViewButtonsHelper, Context context, int i, List<ThreadParticipant> list) {
            this.f8345a = smsThreadViewButtonsHelper;
            super(context, i, list);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            UserTileViewParams b;
            ThreadParticipant threadParticipant = (ThreadParticipant) getItem(i);
            String g = threadParticipant.b().g();
            User a = this.f8345a.f8350e.a(threadParticipant.b());
            if (a == null) {
                a = this.f8345a.f8349d.a(g);
            }
            if (view != null) {
                view = (SmsGroupContactsListItem) view;
            } else {
                view = new SmsGroupContactsListItem(this.f8345a.f8346a);
            }
            if (a.ao()) {
                b = UserTileViewParams.b(a, TileBadge.SMS);
                if (a.an() != null) {
                    view.f8341c.setText(a.w().a);
                    view.f8341c.setVisibility(0);
                } else {
                    view.f8341c.setVisibility(8);
                }
            } else {
                b = UserTileViewParams.a(a, TileBadge.SMS);
                view.f8341c.setVisibility(8);
            }
            view.f8339a.setParams(b);
            view.f8340b.setText(a.j());
            return view;
        }
    }

    public static SmsThreadViewButtonsHelper m8304b(InjectorLike injectorLike) {
        return new SmsThreadViewButtonsHelper((Context) injectorLike.getInstance(Context.class), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), ThreadParticipantUtils.a(injectorLike), SmsContactUtil.a(injectorLike), UserCache.a(injectorLike));
    }

    @Inject
    public SmsThreadViewButtonsHelper(Context context, SecureContextHelper secureContextHelper, ThreadParticipantUtils threadParticipantUtils, SmsContactUtil smsContactUtil, UserCache userCache) {
        this.f8346a = ContextUtils.a(context, 2130772966, 2131625115);
        this.f8347b = secureContextHelper;
        this.f8348c = threadParticipantUtils;
        this.f8349d = smsContactUtil;
        this.f8350e = userCache;
    }

    public final void m8305a(@Nullable Result result) {
        if (result != null && result.f7611a != null) {
            if (result.f7611a.h.size() == 2) {
                ThreadParticipant a = this.f8348c.a(result.f7611a);
                String f = a.b().f();
                if (f != null) {
                    m8303a(this, f);
                    return;
                } else {
                    m8302a(this, a.b());
                    return;
                }
            }
            ThreadSummary threadSummary = result.f7611a;
            Builder builder = ImmutableList.builder();
            ImmutableList immutableList = threadSummary.h;
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                ThreadParticipant threadParticipant = (ThreadParticipant) immutableList.get(i);
                if (threadParticipant.b().g() != null) {
                    builder.c(threadParticipant);
                }
            }
            final ListAdapter groupContactsAdapter = new GroupContactsAdapter(this, this.f8346a, 2130907142, builder.b());
            new FbAlertDialogBuilder(this.f8346a).a(2131231077).b(2131231078, new C12492(this)).a(groupContactsAdapter, new OnClickListener(this) {
                final /* synthetic */ SmsThreadViewButtonsHelper f8343b;

                public void onClick(DialogInterface dialogInterface, int i) {
                    ThreadParticipant threadParticipant = (ThreadParticipant) groupContactsAdapter.getItem(i);
                    String f = threadParticipant.b().f();
                    if (f != null) {
                        SmsThreadViewButtonsHelper.m8303a(this.f8343b, f);
                    } else {
                        SmsThreadViewButtonsHelper.m8302a(this.f8343b, threadParticipant.b());
                    }
                }
            }).a().show();
        }
    }

    public static void m8303a(SmsThreadViewButtonsHelper smsThreadViewButtonsHelper, String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(Contacts.CONTENT_URI.buildUpon().appendPath(str).build(), "vnd.android.cursor.item/contact");
        smsThreadViewButtonsHelper.f8347b.b(intent, smsThreadViewButtonsHelper.f8346a);
    }

    public static void m8302a(SmsThreadViewButtonsHelper smsThreadViewButtonsHelper, UserKey userKey) {
        String b;
        String str;
        if (userKey.a() == Type.EMAIL) {
            b = userKey.b();
            str = "email";
        } else {
            String g;
            User a = smsThreadViewButtonsHelper.f8350e.a(userKey);
            if (a == null || a.w() == null) {
                g = userKey.g();
            } else {
                g = a.w().b;
            }
            b = g;
            str = "phone";
        }
        if (b != null) {
            Intent intent = new Intent("android.intent.action.INSERT_OR_EDIT");
            intent.putExtra(str, b);
            intent.setType("vnd.android.cursor.item/contact");
            smsThreadViewButtonsHelper.f8347b.b(intent, smsThreadViewButtonsHelper.f8346a);
        }
    }
}
