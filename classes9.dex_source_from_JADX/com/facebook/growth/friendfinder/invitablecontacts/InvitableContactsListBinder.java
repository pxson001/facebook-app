package com.facebook.growth.friendfinder.invitablecontacts;

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import com.facebook.inject.Assisted;
import com.facebook.ipc.katana.findfriends.CIFlow;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import javax.inject.Inject;

/* compiled from: page/ */
public class InvitableContactsListBinder {
    public final Resources f7395a;
    private final AllCapsTransformationMethod f7396b;
    public final InvitableContactsController f7397c;

    @Inject
    public InvitableContactsListBinder(AllCapsTransformationMethod allCapsTransformationMethod, InvitableContactsControllerProvider invitableContactsControllerProvider, @Assisted CIFlow cIFlow, @Assisted Adapter adapter, @Assisted Resources resources) {
        this.f7396b = allCapsTransformationMethod;
        this.f7397c = invitableContactsControllerProvider.m7697a(cIFlow, adapter);
        this.f7395a = resources;
    }

    public final void m7717a(InvitableContactsItemRow invitableContactsItemRow, final InvitableContactsCandidate invitableContactsCandidate) {
        boolean z = true;
        boolean z2 = false;
        OnClickListener onClickListener = null;
        CharSequence a = m7716a(2131236381, (View) invitableContactsItemRow);
        CharSequence charSequence = invitableContactsCandidate.f7350c;
        switch (invitableContactsCandidate.f7352e) {
            case UNINVITED:
                onClickListener = new OnClickListener(this) {
                    final /* synthetic */ InvitableContactsListBinder f7391b;

                    public void onClick(View view) {
                        int a = Logger.a(2, EntryType.UI_INPUT_START, 1293026185);
                        this.f7391b.f7397c.m7696a(invitableContactsCandidate);
                        Logger.a(2, EntryType.UI_INPUT_END, 1509082424, a);
                    }
                };
                break;
            case PENDING_CAN_UNDO:
                charSequence = m7715a(invitableContactsCandidate);
                z = false;
                z2 = true;
                break;
            case PENDING_CANNOT_UNDO:
                charSequence = this.f7395a.getString(2131236438);
                z = false;
                break;
            case INVITED:
                a = m7716a(2131236437, (View) invitableContactsItemRow);
                z = false;
                break;
            default:
                z = false;
                break;
        }
        invitableContactsItemRow.f7387a.setText(invitableContactsCandidate.f7349b);
        invitableContactsItemRow.f7389c.setText(a);
        if (z) {
            invitableContactsItemRow.f7389c.setTextAppearance(invitableContactsItemRow.getContext(), 2131624423);
            invitableContactsItemRow.f7389c.setBackgroundDrawable(invitableContactsItemRow.getResources().getDrawable(2130839742));
        } else {
            invitableContactsItemRow.f7389c.setTextAppearance(invitableContactsItemRow.getContext(), 2131624427);
            invitableContactsItemRow.f7389c.setBackgroundDrawable(invitableContactsItemRow.getResources().getDrawable(2130839736));
            invitableContactsItemRow.f7389c.setTextColor(invitableContactsItemRow.getResources().getColor(2131361967));
        }
        invitableContactsItemRow.f7389c.setEnabled(z);
        invitableContactsItemRow.m7714b(z2, charSequence);
        invitableContactsItemRow.f7389c.setOnClickListener(onClickListener);
    }

    private Spanned m7715a(final InvitableContactsCandidate invitableContactsCandidate) {
        SpannableString spannableString = new SpannableString(this.f7395a.getString(2131236438));
        Spannable spannableString2 = new SpannableString(this.f7395a.getString(2131236440));
        spannableString2.setSpan(new ClickableSpan(this) {
            final /* synthetic */ InvitableContactsListBinder f7393b;

            public void onClick(View view) {
                this.f7393b.f7397c.m7696a(invitableContactsCandidate);
            }

            public void updateDrawState(TextPaint textPaint) {
                textPaint.setUnderlineText(false);
                textPaint.setColor(this.f7393b.f7395a.getColor(2131361917));
            }
        }, 0, spannableString2.length(), 33);
        return (Spanned) TextUtils.concat(new CharSequence[]{spannableString, " ", spannableString2});
    }

    private CharSequence m7716a(int i, View view) {
        return this.f7396b.getTransformation(this.f7395a.getString(i), view);
    }
}
