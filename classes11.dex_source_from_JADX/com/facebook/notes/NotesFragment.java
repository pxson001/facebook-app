package com.facebook.notes;

import com.facebook.richdocument.RichDocumentDelegate;
import com.facebook.richdocument.RichDocumentFragment;

/* compiled from: Unexpected call to logCompleteLogin with null pendingAuthorizationRequest. */
public class NotesFragment extends RichDocumentFragment {
    private NotesDelegateImpl am;

    public final RichDocumentDelegate aq() {
        this.am = new NotesDelegateImpl();
        return this.am;
    }
}
