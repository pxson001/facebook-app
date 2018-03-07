package it.sephiroth.android.library.util.v11;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import it.sephiroth.android.library.widget.AbsHListView;

/* compiled from: viewer_group_marketplace_cross_post_nux_seen */
public class MultiChoiceModeWrapper implements MultiChoiceModeListener {
    public MultiChoiceModeListener f369a;
    private AbsHListView f370b;

    public MultiChoiceModeWrapper(AbsHListView absHListView) {
        this.f370b = absHListView;
    }

    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (!this.f369a.onCreateActionMode(actionMode, menu)) {
            return false;
        }
        this.f370b.setLongClickable(false);
        return true;
    }

    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.f369a.onPrepareActionMode(actionMode, menu);
    }

    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.f369a.onActionItemClicked(actionMode, menuItem);
    }

    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.f369a.onDestroyActionMode(actionMode);
        this.f370b.f446c = null;
        this.f370b.m447a();
        this.f370b.aj = true;
        this.f370b.m406o();
        this.f370b.requestLayout();
        this.f370b.setLongClickable(true);
    }

    @TargetApi(11)
    public final void mo6a(ActionMode actionMode, int i, long j, boolean z) {
        this.f369a.mo6a(actionMode, i, j, z);
        if (this.f370b.f448e == 0) {
            actionMode.finish();
        }
    }
}
