package com.facebook.events.create;

import android.view.inputmethod.InputMethodManager;
import com.facebook.common.android.InputMethodManagerMethodAutoProvider;
import com.facebook.events.create.ui.EventNameEditText;
import com.facebook.events.create.ui.EventNameEditText.OnDrawListener;
import com.facebook.inject.InjectorLike;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Inject;

/* compiled from: contact_upload_failed_not_now */
public class EventCreationAnimationHelper implements OnDrawListener {
    public final InputMethodManager f16100a;
    private int f16101b = 0;

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: contact_upload_failed_not_now */
    public @interface AnimState {
    }

    public static EventCreationAnimationHelper m16469b(InjectorLike injectorLike) {
        return new EventCreationAnimationHelper(InputMethodManagerMethodAutoProvider.b(injectorLike));
    }

    @Inject
    public EventCreationAnimationHelper(InputMethodManager inputMethodManager) {
        this.f16100a = inputMethodManager;
    }

    public final void mo775a(EventNameEditText eventNameEditText) {
        switch (this.f16101b) {
            case 0:
                this.f16101b = 1;
                return;
            case 1:
                this.f16101b = 2;
                return;
            case 2:
                m16471b(eventNameEditText);
                return;
            default:
                return;
        }
    }

    public static EventCreationAnimationHelper m16468a(InjectorLike injectorLike) {
        return m16469b(injectorLike);
    }

    public final void m16471b(final EventNameEditText eventNameEditText) {
        eventNameEditText.f16380h = null;
        eventNameEditText.post(new Runnable(this) {
            final /* synthetic */ EventCreationAnimationHelper f16099b;

            public void run() {
                this.f16099b.f16100a.showSoftInput(eventNameEditText, 0);
            }
        });
    }
}
