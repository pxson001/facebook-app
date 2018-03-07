package com.facebook.feed.ui.fullscreenvideoplayer;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import com.facebook.common.util.LocaleUtil;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.inject.FbInjector;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.ui.dialogs.FbDialogFragment;
import com.facebook.video.settings.VideoPrefs;
import com.google.common.collect.ImmutableList;
import java.util.Locale;

/* compiled from: Timestamp */
public class SubtitleDialog extends FbDialogFragment {
    public OnDismissListener am;
    public SubtitlesRequestCallback an;
    public String ao;
    public SubtitlesRequestAPI ap;
    public ImmutableList<String> aq;
    public FbSharedPreferences ar;

    /* compiled from: Timestamp */
    class C18621 implements OnClickListener {
        final /* synthetic */ SubtitleDialog f21957a;

        C18621(SubtitleDialog subtitleDialog) {
            this.f21957a = subtitleDialog;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f21957a.onCancel(dialogInterface);
        }
    }

    /* compiled from: Timestamp */
    public final class SubtitleLocales {
        final /* synthetic */ SubtitleDialog f21960a;
        private Locale[] f21961b;
        public String[] f21962c;
        public int f21963d;

        public SubtitleLocales(SubtitleDialog subtitleDialog, ImmutableList<String> immutableList, String str) {
            int i;
            int i2 = 1;
            this.f21960a = subtitleDialog;
            int size = immutableList.size();
            this.f21961b = new Locale[size];
            this.f21962c = new String[(size + 1)];
            Locale locale = Locale.getDefault();
            Locale a = LocaleUtil.a(subtitleDialog.ar.a(VideoPrefs.k, ""));
            int i3 = 0;
            int i4 = -1;
            int i5 = -1;
            while (i3 < size) {
                this.f21961b[i3] = LocaleUtil.a((String) immutableList.get(i3));
                this.f21962c[i3] = LocaleUtil.a(this.f21961b[i3]);
                if (this.f21961b[i3].equals(locale)) {
                    i = i3;
                } else {
                    i = i5;
                }
                if (this.f21961b[i3].equals(a)) {
                    i5 = i3;
                } else {
                    i5 = i4;
                }
                i3++;
                i4 = i5;
                i5 = i;
            }
            i = i4 == i5 ? 1 : 0;
            this.f21962c[size] = str;
            if (i4 != -1) {
                m24552a(0, i4);
                if (i5 != 0) {
                    i4 = i5;
                }
                this.f21963d = 0;
                if (i4 != -1 && i == 0) {
                    m24552a(1, i4);
                    i2 = 2;
                }
            } else {
                if (i5 != -1) {
                    m24552a(0, i5);
                } else {
                    i2 = 0;
                }
                this.f21963d = size;
            }
            for (i3 = i2 + 1; i3 < size; i3++) {
                i = i3;
                while (i > i2 && this.f21962c[i - 1].compareTo(this.f21962c[i]) > 0) {
                    m24552a(i, i - 1);
                    i--;
                }
            }
        }

        private void m24552a(int i, int i2) {
            Locale locale = this.f21961b[i];
            String str = this.f21962c[i];
            this.f21961b[i] = this.f21961b[i2];
            this.f21962c[i] = this.f21962c[i2];
            this.f21961b[i2] = locale;
            this.f21962c[i2] = str;
        }

        public static String m24551a(SubtitleLocales subtitleLocales, int i) {
            if (i >= subtitleLocales.f21961b.length || i < 0) {
                return "";
            }
            return subtitleLocales.f21961b[i].toString();
        }
    }

    public static void m24554a(Object obj, Context context) {
        ((SubtitleDialog) obj).ap = SubtitlesRequestAPI.a(FbInjector.get(context));
    }

    public static SubtitleDialog m24553a(String str, OnDismissListener onDismissListener, SubtitlesRequestCallback subtitlesRequestCallback, ImmutableList<String> immutableList, FbSharedPreferences fbSharedPreferences) {
        SubtitleDialog subtitleDialog = new SubtitleDialog();
        subtitleDialog.ao = str;
        subtitleDialog = subtitleDialog;
        subtitleDialog.ar = fbSharedPreferences;
        subtitleDialog = subtitleDialog;
        subtitleDialog.an = subtitlesRequestCallback;
        subtitleDialog = subtitleDialog;
        subtitleDialog.am = onDismissListener;
        subtitleDialog = subtitleDialog;
        subtitleDialog.aq = immutableList;
        return subtitleDialog;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        this.am.onDismiss(dialogInterface);
    }

    public void onCancel(DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
        this.am.onDismiss(dialogInterface);
    }

    public final Dialog m24555c(Bundle bundle) {
        super.c(bundle);
        Class cls = SubtitleDialog.class;
        m24554a(this, getContext());
        final SubtitleLocales subtitleLocales = new SubtitleLocales(this, this.aq, b(2131232796));
        return new Builder(getContext()).a(2131232794).a(subtitleLocales.f21962c, subtitleLocales.f21963d, new OnClickListener(this) {
            final /* synthetic */ SubtitleDialog f21959b;

            public void onClick(DialogInterface dialogInterface, int i) {
                this.f21959b.ar.edit().a(VideoPrefs.k, SubtitleLocales.m24551a(subtitleLocales, i)).commit();
                subtitleLocales.f21963d = i;
                this.f21959b.ap.a(this.f21959b.ao, SubtitleLocales.m24551a(subtitleLocales, i), this.f21959b.an);
                dialogInterface.dismiss();
            }
        }).b(2131232795, new C18621(this)).a();
    }
}
