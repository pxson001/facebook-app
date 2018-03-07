package android.support.v4.widget;

import android.view.View;
import android.widget.ListView;

/* compiled from: user_question_history */
public class ListViewAutoScrollHelper extends AutoScrollHelper {
    private final ListView f478a;

    public ListViewAutoScrollHelper(ListView listView) {
        super(listView);
        this.f478a = listView;
    }

    public final void mo189a(int i) {
        ListView listView = this.f478a;
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        if (firstVisiblePosition != -1) {
            View childAt = listView.getChildAt(0);
            if (childAt != null) {
                listView.setSelectionFromTop(firstVisiblePosition, childAt.getTop() - i);
            }
        }
    }

    public final boolean mo190a() {
        return false;
    }

    public final boolean mo191b(int i) {
        ListView listView = this.f478a;
        int count = listView.getCount();
        if (count == 0) {
            return false;
        }
        int childCount = listView.getChildCount();
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        int i2 = firstVisiblePosition + childCount;
        if (i > 0) {
            if (i2 >= count && listView.getChildAt(childCount - 1).getBottom() <= listView.getHeight()) {
                return false;
            }
        } else if (i >= 0) {
            return false;
        } else {
            if (firstVisiblePosition <= 0 && listView.getChildAt(0).getTop() >= 0) {
                return false;
            }
        }
        return true;
    }
}
