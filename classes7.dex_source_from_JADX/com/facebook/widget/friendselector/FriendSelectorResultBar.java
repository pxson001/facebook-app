package com.facebook.widget.friendselector;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ui.animations.ViewAnimator.SimpleListener;
import com.facebook.ui.animations.ViewHelperViewAnimator;
import com.facebook.ui.animations.ViewHelperViewAnimatorFactory;
import com.facebook.widget.CustomRelativeLayout;
import com.facebook.widget.friendselector.FriendSelectorResultContainer.ItemClickListener;
import com.facebook.widget.friendselector.FriendSelectorResultContainer.ItemSetChangeListener;
import com.facebook.widget.tokenizedtypeahead.model.BaseToken;
import com.facebook.widget.tokenizedtypeahead.model.SimpleUserToken;

/* compiled from: dd2d98cd9ea82f6e6f56e81e80d88f63 */
public class FriendSelectorResultBar extends CustomRelativeLayout {
    private FriendSelectorResultContainer f16048a;
    private SelectedFriendItemView f16049b;
    public View f16050c;
    private View f16051d;
    private View f16052e;
    public Listener f16053f;
    private ViewHelperViewAnimator f16054g;

    /* compiled from: dd2d98cd9ea82f6e6f56e81e80d88f63 */
    class C12441 implements ItemClickListener {
        final /* synthetic */ FriendSelectorResultBar f16041a;

        C12441(FriendSelectorResultBar friendSelectorResultBar) {
            this.f16041a = friendSelectorResultBar;
        }

        public final void mo1234a(SimpleUserToken simpleUserToken) {
            if (this.f16041a.f16053f != null) {
                this.f16041a.f16053f.mo1237a((BaseToken) simpleUserToken);
            }
        }
    }

    /* compiled from: dd2d98cd9ea82f6e6f56e81e80d88f63 */
    class C12452 implements ItemSetChangeListener {
        final /* synthetic */ FriendSelectorResultBar f16042a;

        C12452(FriendSelectorResultBar friendSelectorResultBar) {
            this.f16042a = friendSelectorResultBar;
        }

        public final void mo1235a() {
            this.f16042a.m20064b();
        }
    }

    /* compiled from: dd2d98cd9ea82f6e6f56e81e80d88f63 */
    class C12463 implements OnClickListener {
        final /* synthetic */ FriendSelectorResultBar f16043a;

        C12463(FriendSelectorResultBar friendSelectorResultBar) {
            this.f16043a = friendSelectorResultBar;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1704824451);
            if (this.f16043a.f16053f != null) {
                this.f16043a.f16053f.mo1236a();
            }
            Logger.a(2, EntryType.UI_INPUT_END, 1108749569, a);
        }
    }

    /* compiled from: dd2d98cd9ea82f6e6f56e81e80d88f63 */
    class C12474 extends SimpleListener {
        final /* synthetic */ FriendSelectorResultBar f16044a;

        C12474(FriendSelectorResultBar friendSelectorResultBar) {
            this.f16044a = friendSelectorResultBar;
        }

        public final void m20055b() {
            if (this.f16044a.f16053f != null) {
                this.f16044a.f16053f.mo1238a(true);
            }
        }
    }

    /* compiled from: dd2d98cd9ea82f6e6f56e81e80d88f63 */
    class C12485 extends SimpleListener {
        final /* synthetic */ FriendSelectorResultBar f16045a;

        C12485(FriendSelectorResultBar friendSelectorResultBar) {
            this.f16045a = friendSelectorResultBar;
        }

        public final void m20056a() {
            if (this.f16045a.f16053f != null) {
                this.f16045a.f16053f.mo1238a(false);
            }
        }

        public final void m20057b() {
            this.f16045a.setVisibility(8);
        }
    }

    /* compiled from: dd2d98cd9ea82f6e6f56e81e80d88f63 */
    public interface AddNoteButtonListener {
        void m20058a();
    }

    /* compiled from: dd2d98cd9ea82f6e6f56e81e80d88f63 */
    public interface Listener {
        void mo1236a();

        void mo1237a(BaseToken baseToken);

        void mo1238a(boolean z);
    }

    public FriendSelectorResultBar(Context context) {
        super(context);
        m20063a();
    }

    public FriendSelectorResultBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m20063a();
    }

    public FriendSelectorResultBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m20063a();
    }

    private void m20063a() {
        setContentView(2130904494);
        setVisibility(8);
        setClickable(true);
        this.f16048a = (FriendSelectorResultContainer) a(2131562279);
        this.f16049b = (SelectedFriendItemView) a(2131562280);
        this.f16048a.setBadgeView(this.f16049b);
        this.f16048a.setClickable(true);
        this.f16048a.f16065c = new C12441(this);
        this.f16048a.f16066d = new C12452(this);
        this.f16050c = a(2131562277);
        this.f16051d = a(2131562278);
        this.f16052e = a(2131562049);
        this.f16052e.setOnClickListener(new C12463(this));
        this.f16054g = ViewHelperViewAnimatorFactory.a(this.f).a(this);
        this.f16054g.a(200);
    }

    public final void m20069a(SimpleUserToken simpleUserToken) {
        if (this.f16048a.m20094a()) {
            m20066c();
        }
        this.f16048a.m20092a(simpleUserToken);
    }

    public final void m20070a(SimpleUserToken simpleUserToken, boolean z) {
        this.f16048a.m20093a(simpleUserToken, z);
    }

    private void m20064b() {
        if (this.f16048a.m20094a() && getVisibility() == 0) {
            m20067d();
        } else if (!this.f16048a.m20094a() && getVisibility() == 8) {
            m20066c();
        }
    }

    private void m20066c() {
        setVisibility(0);
        this.f16054g.a(new C12474(this));
        this.f16054g.j(0.0f);
    }

    private void m20067d() {
        this.f16054g.a(new C12485(this));
        this.f16054g.j((float) getHeight());
    }

    public void setListener(Listener listener) {
        this.f16053f = listener;
    }

    public final void m20068a(final AddNoteButtonListener addNoteButtonListener) {
        this.f16050c.setVisibility(0);
        this.f16050c.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FriendSelectorResultBar f16047b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -388949424);
                if (addNoteButtonListener != null) {
                    addNoteButtonListener.m20058a();
                }
                Logger.a(2, EntryType.UI_INPUT_END, 137464393, a);
            }
        });
    }

    public View getAddNoteButton() {
        return this.f16050c;
    }

    public final void m20071a(boolean z) {
        this.f16051d.setVisibility(z ? 0 : 8);
    }
}
