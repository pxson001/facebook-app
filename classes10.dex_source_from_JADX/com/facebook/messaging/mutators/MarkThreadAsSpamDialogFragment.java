package com.facebook.messaging.mutators;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.cache.SpamThreadManager;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.facebook.ui.dialogs.FbDialogFragment;

/* compiled from: rphhowhordsaatmfrcjkfhamhapbnfazxosiveyvenvehiphgzwttyukuukksamoutaxwfvjfvgacchevhecdfkvidvitjewjetbhjhgfrfvrfzcrycracrfcrexavvorvoygjkbvctrotraevyodizigzioiexcksdbxszxgbsetmuntxedyguvskkrubrjbraersfatkimuddnixepprnjrnyfouguauzuibgghbsongbdfffmypdzxmpumpsjrjcesassputpuppushjdrusutcnatozovbybcdarrarturbyanbiuzyfdudmetovevfytyrompmccnyazsbutktufoioreeiucggybkfhfvpackotcfvujigazpenpecdawrevzzwudehfnmitjnjwyofytrcepipubypieentimpbszcybzboggzjyjicktwinnennammeroncnhthedefardmsurkyfczpotjuiiggunnandtemtevdgdfgjudyrixrisdruzzzdraedwnumbyjjoryjxjoetarmys */
public class MarkThreadAsSpamDialogFragment extends FbDialogFragment {
    public ThreadSummary am;
    public Lazy<SpamThreadManager> an;

    /* compiled from: rphhowhordsaatmfrcjkfhamhapbnfazxosiveyvenvehiphgzwttyukuukksamoutaxwfvjfvgacchevhecdfkvidvitjewjetbhjhgfrfvrfzcrycracrfcrexavvorvoygjkbvctrotraevyodizigzioiexcksdbxszxgbsetmuntxedyguvskkrubrjbraersfatkimuddnixepprnjrnyfouguauzuibgghbsongbdfffmypdzxmpumpsjrjcesassputpuppushjdrusutcnatozovbybcdarrarturbyanbiuzyfdudmetovevfytyrompmccnyazsbutktufoioreeiucggybkfhfvpackotcfvujigazpenpecdawrevzzwudehfnmitjnjwyofytrcepipubypieentimpbszcybzboggzjyjicktwinnennammeroncnhthedefardmsurkyfczpotjuiiggunnandtemtevdgdfgjudyrixrisdruzzzdraedwnumbyjjoryjxjoetarmys */
    class C05371 implements OnClickListener {
        final /* synthetic */ MarkThreadAsSpamDialogFragment f3328a;

        C05371(MarkThreadAsSpamDialogFragment markThreadAsSpamDialogFragment) {
            this.f3328a = markThreadAsSpamDialogFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f3328a.a();
        }
    }

    /* compiled from: rphhowhordsaatmfrcjkfhamhapbnfazxosiveyvenvehiphgzwttyukuukksamoutaxwfvjfvgacchevhecdfkvidvitjewjetbhjhgfrfvrfzcrycracrfcrexavvorvoygjkbvctrotraevyodizigzioiexcksdbxszxgbsetmuntxedyguvskkrubrjbraersfatkimuddnixepprnjrnyfouguauzuibgghbsongbdfffmypdzxmpumpsjrjcesassputpuppushjdrusutcnatozovbybcdarrarturbyanbiuzyfdudmetovevfytyrompmccnyazsbutktufoioreeiucggybkfhfvpackotcfvujigazpenpecdawrevzzwudehfnmitjnjwyofytrcepipubypieentimpbszcybzboggzjyjicktwinnennammeroncnhthedefardmsurkyfczpotjuiiggunnandtemtevdgdfgjudyrixrisdruzzzdraedwnumbyjjoryjxjoetarmys */
    class C05382 implements OnClickListener {
        final /* synthetic */ MarkThreadAsSpamDialogFragment f3329a;

        C05382(MarkThreadAsSpamDialogFragment markThreadAsSpamDialogFragment) {
            this.f3329a = markThreadAsSpamDialogFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            MarkThreadAsSpamDialogFragment markThreadAsSpamDialogFragment = this.f3329a;
            ((SpamThreadManager) markThreadAsSpamDialogFragment.an.get()).a(markThreadAsSpamDialogFragment.am);
        }
    }

    public static void m3240a(Object obj, Context context) {
        ((MarkThreadAsSpamDialogFragment) obj).an = IdBasedLazy.a(FbInjector.get(context), 7704);
    }

    public final void m3241a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1666225502);
        super.a(bundle);
        Class cls = MarkThreadAsSpamDialogFragment.class;
        m3240a(this, getContext());
        Bundle bundle2 = this.s;
        if (bundle2 != null) {
            this.am = (ThreadSummary) bundle2.getParcelable("thread_summary");
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1214550467, a);
    }

    public final Dialog m3242c(Bundle bundle) {
        return new FbAlertDialogBuilder(getContext()).a(2131231033).b(2131231357).a(false).a(2131230735, new C05382(this)).b(2131230736, new C05371(this)).a();
    }
}
