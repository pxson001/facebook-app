package com.facebook.groups.groupsgrid.mutations;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.graphql.enums.GraphQLLeavingGroupScenario;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.dialogs.ProgressDialogFragment;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: protile_header_click */
public class GroupLeaveDialogHelper {
    private final Resources f5754a;

    /* compiled from: protile_header_click */
    class C05291 implements OnClickListener {
        final /* synthetic */ GroupLeaveDialogHelper f5735a;

        C05291(GroupLeaveDialogHelper groupLeaveDialogHelper) {
            this.f5735a = groupLeaveDialogHelper;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
        }
    }

    /* compiled from: protile_header_click */
    class C05335 implements OnClickListener {
        final /* synthetic */ GroupLeaveDialogHelper f5752a;

        C05335(GroupLeaveDialogHelper groupLeaveDialogHelper) {
            this.f5752a = groupLeaveDialogHelper;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
        }
    }

    /* compiled from: protile_header_click */
    /* synthetic */ class C05346 {
        static final /* synthetic */ int[] f5753a = new int[GraphQLLeavingGroupScenario.values().length];

        static {
            try {
                f5753a[GraphQLLeavingGroupScenario.MEMBER_NOTIFICATIONS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f5753a[GraphQLLeavingGroupScenario.MEMBER_NO_NOTIFICATIONS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f5753a[GraphQLLeavingGroupScenario.ADMIN.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f5753a[GraphQLLeavingGroupScenario.ONLY_ADMIN.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f5753a[GraphQLLeavingGroupScenario.LAST_MEMBER.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public static GroupLeaveDialogHelper m7055b(InjectorLike injectorLike) {
        return new GroupLeaveDialogHelper(ResourcesMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public GroupLeaveDialogHelper(Resources resources) {
        this.f5754a = resources;
    }

    public static DialogFragment m7052a(FragmentManager fragmentManager, int i) {
        DialogFragment a = ProgressDialogFragment.a(i, true, false);
        a.a(fragmentManager, null);
        return a;
    }

    public static void m7053a(DialogFragment dialogFragment) {
        if (dialogFragment != null) {
            dialogFragment.b();
        }
    }

    public final Builder m7056a(Context context) {
        Builder builder = new Builder(context);
        builder.a(this.f5754a.getString(17039370), new C05291(this));
        builder.b(this.f5754a.getString(2131237880));
        return builder;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m7057a(final android.content.Context r10, android.content.DialogInterface.OnClickListener r11, final android.content.DialogInterface.OnClickListener r12, android.content.DialogInterface.OnClickListener r13, com.facebook.graphql.enums.GraphQLLeavingGroupScenario r14, java.lang.String r15) {
        /*
        r9 = this;
        r8 = new com.facebook.fbui.dialog.AlertDialog$Builder;
        r8.<init>(r10);
        r0 = r9.f5754a;
        r1 = 2131237883; // 0x7f081bfb float:1.809203E38 double:1.052971421E-314;
        r0 = r0.getString(r1);
        r8.a(r0);
        r0 = new com.facebook.groups.groupsgrid.mutations.GroupLeaveDialogHelper$2;
        r1 = r9;
        r2 = r10;
        r3 = r11;
        r4 = r12;
        r5 = r13;
        r6 = r14;
        r7 = r15;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7);
        r1 = com.facebook.groups.groupsgrid.mutations.GroupLeaveDialogHelper.C05346.f5753a;
        r2 = r14.ordinal();
        r1 = r1[r2];
        switch(r1) {
            case 1: goto L_0x0040;
            case 2: goto L_0x0075;
            case 3: goto L_0x0087;
            case 4: goto L_0x0099;
            case 5: goto L_0x00ca;
            default: goto L_0x0028;
        };
    L_0x0028:
        r0 = r9.f5754a;
        r1 = 17039360; // 0x1040000 float:2.424457E-38 double:8.4185624E-317;
        r0 = r0.getString(r1);
        r1 = new com.facebook.groups.groupsgrid.mutations.GroupLeaveDialogHelper$5;
        r1.<init>(r9);
        r8.b(r0, r1);
        r0 = r8.a();
        r0.show();
        return;
    L_0x0040:
        r1 = r9.f5754a;
        r2 = 2131237888; // 0x7f081c00 float:1.809204E38 double:1.0529714236E-314;
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r3[r4] = r15;
        r1 = r1.getString(r2, r3);
        r8.b(r1);
        r1 = r9.f5754a;
        r2 = 2131237895; // 0x7f081c07 float:1.8092053E38 double:1.052971427E-314;
        r1 = r1.getText(r2);
        r8.a(r1, r11);
        r1 = r9.f5754a;
        r2 = 2131237885; // 0x7f081bfd float:1.8092033E38 double:1.052971422E-314;
        r7 = r1.getText(r2);
        r1 = new com.facebook.groups.groupsgrid.mutations.GroupLeaveDialogHelper$3;
        r2 = r9;
        r3 = r10;
        r4 = r12;
        r5 = r13;
        r6 = r0;
        r1.<init>(r2, r3, r4, r5, r6);
        r8.c(r7, r1);
        goto L_0x0028;
    L_0x0075:
        r1 = r9.f5754a;
        r2 = 2131237888; // 0x7f081c00 float:1.809204E38 double:1.0529714236E-314;
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r3[r4] = r15;
        r1 = r1.getString(r2, r3);
        r8.b(r1);
    L_0x0087:
        r1 = r9.f5754a;
        r2 = 2131237890; // 0x7f081c02 float:1.8092043E38 double:1.0529714246E-314;
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r3[r4] = r15;
        r1 = r1.getString(r2, r3);
        r8.b(r1);
    L_0x0099:
        r1 = r9.f5754a;
        r2 = 2131237893; // 0x7f081c05 float:1.809205E38 double:1.052971426E-314;
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r3[r4] = r15;
        r1 = r1.getString(r2, r3);
        r8.b(r1);
        r1 = r9.f5754a;
        r2 = 2131237895; // 0x7f081c07 float:1.8092053E38 double:1.052971427E-314;
        r1 = r1.getText(r2);
        r8.a(r1, r11);
        r1 = r9.f5754a;
        r2 = 2131237885; // 0x7f081bfd float:1.8092033E38 double:1.052971422E-314;
        r1 = r1.getText(r2);
        r2 = new com.facebook.groups.groupsgrid.mutations.GroupLeaveDialogHelper$4;
        r2.<init>(r9, r10, r12, r0);
        r8.c(r1, r2);
        goto L_0x0028;
    L_0x00ca:
        r0 = r9.f5754a;
        r1 = 2131237884; // 0x7f081bfc float:1.8092031E38 double:1.0529714216E-314;
        r0 = r0.getString(r1);
        r8.a(r0);
        r0 = r9.f5754a;
        r1 = 2131237894; // 0x7f081c06 float:1.8092051E38 double:1.0529714265E-314;
        r2 = 1;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r2[r3] = r15;
        r0 = r0.getString(r1, r2);
        r8.b(r0);
        r0 = r9.f5754a;
        r1 = 2131237896; // 0x7f081c08 float:1.8092055E38 double:1.0529714275E-314;
        r0 = r0.getString(r1);
        r8.a(r0, r11);
        goto L_0x0028;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.groupsgrid.mutations.GroupLeaveDialogHelper.a(android.content.Context, android.content.DialogInterface$OnClickListener, android.content.DialogInterface$OnClickListener, android.content.DialogInterface$OnClickListener, com.facebook.graphql.enums.GraphQLLeavingGroupScenario, java.lang.String):void");
    }

    public static void m7054a(GroupLeaveDialogHelper groupLeaveDialogHelper, Context context, @Nullable OnClickListener onClickListener, OnClickListener onClickListener2, OnClickListener onClickListener3) {
        Builder builder = new Builder(context);
        builder.a(groupLeaveDialogHelper.f5754a.getText(2131237886));
        if (onClickListener2 != null) {
            builder.b(groupLeaveDialogHelper.f5754a.getString(2131237889));
            builder.c(groupLeaveDialogHelper.f5754a.getText(2131237898), onClickListener2);
        } else {
            builder.b(groupLeaveDialogHelper.f5754a.getString(2131237891));
        }
        builder.a(groupLeaveDialogHelper.f5754a.getString(2131237897), onClickListener);
        builder.b(groupLeaveDialogHelper.f5754a.getString(2131237881), onClickListener3);
        builder.a().show();
    }
}
