package com.facebook.groups.composer.groupspollcomposer.view;

import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.fbui.popover.PopoverMenuWindow;
import com.facebook.fbui.widget.layout.SegmentedLinearLayout;
import com.facebook.groups.composer.groupspollcomposer.GroupsPollDataModel;
import com.facebook.groups.composer.groupspollcomposer.GroupsPollDataModel.GroupsPollOptionUpdateAction;
import com.facebook.groups.composer.groupspollcomposer.GroupsPollOptionValidator;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbEditText;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.listview.FbBaseAdapter;

/* compiled from: view_event_posts */
public class GroupsPollComposerFooterView extends SegmentedLinearLayout {
    public FbEditText f484a;
    private BetterListView f485b;
    private GroupsPollOptionsAdapter f486c;
    public GroupsPollDataModel f487d;

    /* compiled from: view_event_posts */
    class C00591 implements OnKeyListener {
        final /* synthetic */ GroupsPollComposerFooterView f474a;

        C00591(GroupsPollComposerFooterView groupsPollComposerFooterView) {
            this.f474a = groupsPollComposerFooterView;
        }

        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (keyEvent.getAction() != 0 || i != 66) {
                return false;
            }
            this.f474a.m480a(this.f474a.f484a.getText().toString().trim());
            return true;
        }
    }

    /* compiled from: view_event_posts */
    class C00602 implements OnClickListener {
        final /* synthetic */ GroupsPollComposerFooterView f475a;

        C00602(GroupsPollComposerFooterView groupsPollComposerFooterView) {
            this.f475a = groupsPollComposerFooterView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -118264671);
            this.f475a.m480a(this.f475a.f484a.getText().toString().trim());
            Logger.a(2, EntryType.UI_INPUT_END, 572250919, a);
        }
    }

    /* compiled from: view_event_posts */
    class C00613 implements OnClickListener {
        final /* synthetic */ GroupsPollComposerFooterView f476a;

        C00613(GroupsPollComposerFooterView groupsPollComposerFooterView) {
            this.f476a = groupsPollComposerFooterView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1215567359);
            this.f476a.m477a(view);
            Logger.a(2, EntryType.UI_INPUT_END, -1620461754, a);
        }
    }

    /* compiled from: view_event_posts */
    class C00635 implements DialogInterface.OnClickListener {
        final /* synthetic */ GroupsPollComposerFooterView f480a;

        C00635(GroupsPollComposerFooterView groupsPollComposerFooterView) {
            this.f480a = groupsPollComposerFooterView;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    /* compiled from: view_event_posts */
    public class GroupsPollOptionsAdapter extends FbBaseAdapter {
        final /* synthetic */ GroupsPollComposerFooterView f483a;

        public GroupsPollOptionsAdapter(GroupsPollComposerFooterView groupsPollComposerFooterView) {
            this.f483a = groupsPollComposerFooterView;
        }

        public final View m473a(int i, ViewGroup viewGroup) {
            return new GroupsPollOptionItemView(viewGroup.getContext());
        }

        public final void m474a(int i, final Object obj, View view, int i2, ViewGroup viewGroup) {
            GroupsPollOptionItemView groupsPollOptionItemView = (GroupsPollOptionItemView) view;
            groupsPollOptionItemView.setOnClickListener(null);
            String str = (String) obj;
            OnClickListener c00641 = new OnClickListener(this) {
                final /* synthetic */ GroupsPollOptionsAdapter f482b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 1872226829);
                    this.f482b.f483a.m484b((String) obj);
                    Logger.a(2, EntryType.UI_INPUT_END, 2126220735, a);
                }
            };
            groupsPollOptionItemView.f488a.setText(str);
            groupsPollOptionItemView.f489b.setOnClickListener(c00641);
        }

        public int getCount() {
            return this.f483a.f487d.m459a();
        }

        public Object getItem(int i) {
            return this.f483a.f487d.m460a(i);
        }

        public long getItemId(int i) {
            return 0;
        }
    }

    public GroupsPollComposerFooterView(Context context) {
        super(context);
        m476a();
    }

    public GroupsPollComposerFooterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m476a();
    }

    private final void m476a() {
        setContentView(2130904736);
        setOrientation(1);
        this.f484a = (FbEditText) a(2131562807);
        this.f484a.setOnKeyListener(new C00591(this));
        ((GlyphView) a(2131562806)).setOnClickListener(new C00602(this));
        ((GlyphView) a(2131562808)).setOnClickListener(new C00613(this));
        this.f485b = (BetterListView) a(2131562804);
        this.f485b.addFooterView(new View(getContext()));
        this.f487d = new GroupsPollDataModel();
        this.f486c = new GroupsPollOptionsAdapter(this);
        this.f485b.setAdapter(this.f486c);
    }

    public final void m487a(GroupsPollDataModel groupsPollDataModel) {
        this.f487d = groupsPollDataModel;
        AdapterDetour.a(this.f486c, 1659849949);
    }

    private void m477a(View view) {
        final CharSequence string = getContext().getString(2131238473);
        final CharSequence string2 = getContext().getString(2131238474);
        PopoverMenuWindow popoverMenuWindow = new PopoverMenuWindow(getContext());
        GroupsPollPopoverMenu groupsPollPopoverMenu = new GroupsPollPopoverMenu(getContext(), new Object(this) {
            final /* synthetic */ GroupsPollComposerFooterView f479c;

            public final void m472a(MenuItem menuItem, boolean z) {
                if (string.equals(menuItem.getTitle())) {
                    this.f479c.f487d.m461a(z);
                } else if (string2.equals(menuItem.getTitle())) {
                    this.f479c.f487d.m464b(z);
                }
                menuItem.setChecked(z);
            }
        });
        popoverMenuWindow.a(groupsPollPopoverMenu);
        groupsPollPopoverMenu.a(string).setChecked(this.f487d.m465c());
        groupsPollPopoverMenu.a(string2).setChecked(this.f487d.m466d());
        popoverMenuWindow.c(view);
        popoverMenuWindow.d();
    }

    private void m480a(String str) {
        CharSequence a = GroupsPollOptionValidator.m471a(str, this.f487d.m463b(), getContext());
        if (a != null) {
            Builder builder = new Builder(getContext());
            builder.b(a);
            builder.a(17039370, new C00635(this));
            builder.a().show();
        } else if (this.f487d.m462a(str.trim(), GroupsPollOptionUpdateAction.ADD)) {
            m486d();
            m482b();
        }
    }

    private void m484b(String str) {
        if (this.f487d.m462a(str.trim(), GroupsPollOptionUpdateAction.REMOVE)) {
            m482b();
        }
    }

    private void m482b() {
        m485c();
        AdapterDetour.a(this.f486c, -1491843493);
    }

    private void m485c() {
        int a = this.f487d.m459a();
        if (a == 3 || a == 2) {
            LayoutParams layoutParams;
            if (a == 3) {
                layoutParams = new LinearLayout.LayoutParams(-1, (int) (((double) getResources().getDimensionPixelSize(2131432504)) * 2.5d));
            } else {
                layoutParams = new LinearLayout.LayoutParams(-1, -2);
            }
            this.f485b.setLayoutParams(layoutParams);
        }
    }

    private void m486d() {
        this.f484a.setText("");
        if (this.f487d.m459a() > 0) {
            this.f484a.setHint(2131238472);
        } else {
            this.f484a.setHint(2131238471);
        }
    }
}
