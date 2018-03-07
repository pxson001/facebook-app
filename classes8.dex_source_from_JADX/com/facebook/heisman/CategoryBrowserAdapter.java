package com.facebook.heisman;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.graphql.cursor.ModelCursor;
import com.facebook.heisman.protocol.CategoryBrowserGraphQLModels.ProfileOverlayCategoryWithPageLimitFieldsModel;
import com.facebook.heisman.protocol.ProfileOverlayCategoryGraphQLModels.ProfileOverlayCategoryPageFieldsModel;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import com.facebook.ultralight.Inject;
import com.facebook.widget.recyclerview.cursor.CursorRecyclerViewAdapter;
import com.google.common.base.Preconditions;

/* compiled from: video_list_id */
public class CategoryBrowserAdapter extends CursorRecyclerViewAdapter<ModelCursor, ViewHolder> {
    @Inject
    public LayoutInflater f565a;
    private final CategoryBrowserFragmentController f566b;

    /* compiled from: video_list_id */
    public class CategoryPageViewHolder extends ViewHolder implements OnClickListener {
        public final ContentView f557l;
        private final CategoryBrowserFragmentController f558m;
        public ProfileOverlayCategoryPageFieldsModel f559n;

        public CategoryPageViewHolder(ContentView contentView, CategoryBrowserFragmentController categoryBrowserFragmentController) {
            super(contentView);
            this.f557l = contentView;
            this.f558m = categoryBrowserFragmentController;
            this.f557l.setOnClickListener(this);
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 988790884);
            if (view == this.f557l) {
                CategoryBrowserFragmentController categoryBrowserFragmentController = this.f558m;
                ProfileOverlayCategoryPageFieldsModel profileOverlayCategoryPageFieldsModel = this.f559n;
                if (ProfileOverlayCategoryPageFieldsValidator.m645a(profileOverlayCategoryPageFieldsModel)) {
                    categoryBrowserFragmentController.f595b.mo16a(profileOverlayCategoryPageFieldsModel, 1);
                } else {
                    ((AbstractFbErrorReporter) categoryBrowserFragmentController.f594a.get()).a("category_browser_invalid_overlays", "Missing ImageOverlay in fragment model: " + profileOverlayCategoryPageFieldsModel);
                }
            }
            Logger.a(2, EntryType.UI_INPUT_END, -13104948, a);
        }
    }

    /* compiled from: video_list_id */
    public class CategoryTitleViewHolder extends ViewHolder {
        public final TextView f560l;

        public CategoryTitleViewHolder(TextView textView) {
            super(textView);
            this.f560l = textView;
        }
    }

    /* compiled from: video_list_id */
    public class SeeMoreViewHolder extends ViewHolder implements OnClickListener {
        private final View f561l;
        private final CategoryBrowserFragmentController f562m;
        public ProfileOverlayCategoryWithPageLimitFieldsModel f563n;

        public SeeMoreViewHolder(View view, CategoryBrowserFragmentController categoryBrowserFragmentController) {
            super(view);
            this.f561l = view;
            this.f562m = categoryBrowserFragmentController;
            this.f561l.setOnClickListener(this);
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 2129710085);
            if (view == this.f561l) {
                CategoryBrowserFragmentController categoryBrowserFragmentController = this.f562m;
                ProfileOverlayCategoryWithPageLimitFieldsModel profileOverlayCategoryWithPageLimitFieldsModel = this.f563n;
                if (profileOverlayCategoryWithPageLimitFieldsModel.c() != null) {
                    categoryBrowserFragmentController.f595b.mo17b(profileOverlayCategoryWithPageLimitFieldsModel.c().a());
                }
                categoryBrowserFragmentController.f595b.m613a(profileOverlayCategoryWithPageLimitFieldsModel.b());
            }
            Logger.a(2, EntryType.UI_INPUT_END, 555818436, a);
        }
    }

    public final void m622a(ViewHolder viewHolder, int i) {
        ModelCursor modelCursor = (ModelCursor) this.f564a;
        Preconditions.checkState(modelCursor != null);
        modelCursor.moveToPosition(i);
        int f = modelCursor.f();
        ProfileOverlayCategoryWithPageLimitFieldsModel profileOverlayCategoryWithPageLimitFieldsModel;
        switch (f) {
            case 0:
                profileOverlayCategoryWithPageLimitFieldsModel = (ProfileOverlayCategoryWithPageLimitFieldsModel) modelCursor.d();
                Preconditions.checkState(viewHolder instanceof CategoryTitleViewHolder);
                ((CategoryTitleViewHolder) viewHolder).f560l.setText(profileOverlayCategoryWithPageLimitFieldsModel.c().a());
                return;
            case 1:
                ProfileOverlayCategoryPageFieldsModel profileOverlayCategoryPageFieldsModel = (ProfileOverlayCategoryPageFieldsModel) modelCursor.d();
                Preconditions.checkState(viewHolder instanceof CategoryPageViewHolder);
                CategoryPageViewHolder categoryPageViewHolder = (CategoryPageViewHolder) viewHolder;
                categoryPageViewHolder.f559n = profileOverlayCategoryPageFieldsModel;
                ProfilePictureOverlayPivotListItemBinder.m804a(profileOverlayCategoryPageFieldsModel, categoryPageViewHolder.f557l);
                return;
            case 2:
                profileOverlayCategoryWithPageLimitFieldsModel = (ProfileOverlayCategoryWithPageLimitFieldsModel) modelCursor.d();
                Preconditions.checkState(viewHolder instanceof SeeMoreViewHolder);
                ((SeeMoreViewHolder) viewHolder).f563n = profileOverlayCategoryWithPageLimitFieldsModel;
                return;
            default:
                throw new IllegalArgumentException("Unexpected viewType: " + f);
        }
    }

    public int getItemViewType(int i) {
        ModelCursor modelCursor = (ModelCursor) this.f564a;
        Preconditions.checkState(modelCursor != null);
        modelCursor.moveToPosition(i);
        return modelCursor.f();
    }

    @Inject
    public CategoryBrowserAdapter(@Assisted CategoryBrowserFragmentController categoryBrowserFragmentController) {
        this.f566b = categoryBrowserFragmentController;
    }

    public final ViewHolder m621a(ViewGroup viewGroup, int i) {
        switch (i) {
            case 0:
                return new CategoryTitleViewHolder((FbTextView) this.f565a.inflate(2130906457, viewGroup, false));
            case 1:
                return new CategoryPageViewHolder((ContentView) this.f565a.inflate(2130906460, viewGroup, false), this.f566b);
            case 2:
                return new SeeMoreViewHolder(this.f565a.inflate(2130906456, viewGroup, false), this.f566b);
            default:
                throw new IllegalArgumentException("Unexpected viewType: " + i);
        }
    }
}
