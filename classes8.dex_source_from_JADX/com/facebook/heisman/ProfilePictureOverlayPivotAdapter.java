package com.facebook.heisman;

import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import android.widget.Filterable;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.util.StringLocaleUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.heisman.protocol.ProfileOverlayCategoryGraphQLInterfaces.ProfileOverlayCategoryPageFields;
import com.facebook.heisman.protocol.ProfileOverlayCategoryGraphQLModels.ProfileOverlayCategoryPageFieldsModel;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

/* compiled from: user_input */
public class ProfilePictureOverlayPivotAdapter extends Adapter<ViewHolder> implements Filterable {
    public final ImmutableList<ProfileOverlayCategoryPageFields> f755a;
    private final SingleCategoryFragmentController f756b;
    private final LayoutInflater f757c;
    private final Filter f758d = new FrameFilter(this);
    public List<ProfileOverlayCategoryPageFields> f759e;
    public String f760f;

    /* compiled from: user_input */
    class FrameFilter extends Filter {
        final /* synthetic */ ProfilePictureOverlayPivotAdapter f749a;
        private final FilterResults f750b = new FilterResults();
        private final List<ProfileOverlayCategoryPageFields> f751c = new ArrayList();

        public FrameFilter(ProfilePictureOverlayPivotAdapter profilePictureOverlayPivotAdapter) {
            this.f749a = profilePictureOverlayPivotAdapter;
        }

        protected FilterResults performFiltering(CharSequence charSequence) {
            this.f751c.clear();
            String a = m800a(charSequence);
            if (a.isEmpty() || StringUtil.a(a, this.f749a.f760f)) {
                int size = this.f749a.f755a.size();
                for (int i = 0; i < size; i++) {
                    this.f751c.add((ProfileOverlayCategoryPageFieldsModel) this.f749a.f755a.get(i));
                }
            } else if (TextUtils.isEmpty(this.f749a.f760f) || !a.startsWith(this.f749a.f760f)) {
                m801a(a, this.f749a.f755a.iterator(), this.f751c);
            } else {
                m801a(a, this.f749a.f759e.iterator(), this.f751c);
            }
            this.f750b.count = this.f751c.size();
            this.f750b.values = this.f751c;
            return this.f750b;
        }

        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            this.f749a.f759e.clear();
            this.f749a.f759e.addAll((List) filterResults.values);
            this.f749a.f760f = m800a(charSequence);
        }

        private static void m801a(String str, Iterator<ProfileOverlayCategoryPageFields> it, List<ProfileOverlayCategoryPageFields> list) {
            while (it.hasNext()) {
                ProfileOverlayCategoryPageFieldsModel profileOverlayCategoryPageFieldsModel = (ProfileOverlayCategoryPageFieldsModel) it.next();
                String a = StringLocaleUtil.a(profileOverlayCategoryPageFieldsModel.b());
                for (String startsWith : a.split("\\s")) {
                    if (startsWith.startsWith(str) || a.startsWith(str)) {
                        list.add(profileOverlayCategoryPageFieldsModel);
                        break;
                    }
                }
            }
        }

        private static String m800a(CharSequence charSequence) {
            return StringLocaleUtil.a(charSequence.toString().trim());
        }
    }

    /* compiled from: user_input */
    public class ViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder implements OnClickListener {
        public final ContentView f752l;
        private final SingleCategoryFragmentController f753m;
        public ProfileOverlayCategoryPageFieldsModel f754n;

        public ViewHolder(ContentView contentView, SingleCategoryFragmentController singleCategoryFragmentController) {
            super(contentView);
            this.f752l = contentView;
            this.f753m = singleCategoryFragmentController;
            this.f752l.setOnClickListener(this);
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1742168439);
            if (view == this.f752l) {
                SingleCategoryFragmentController singleCategoryFragmentController = this.f753m;
                ProfileOverlayCategoryPageFieldsModel profileOverlayCategoryPageFieldsModel = this.f754n;
                if (ProfileOverlayCategoryPageFieldsValidator.m645a(profileOverlayCategoryPageFieldsModel)) {
                    singleCategoryFragmentController.f790j.m667b(singleCategoryFragmentController.f789i.a());
                    singleCategoryFragmentController.f784d.mo16a(profileOverlayCategoryPageFieldsModel, singleCategoryFragmentController.f797q);
                } else {
                    ((AbstractFbErrorReporter) singleCategoryFragmentController.f792l.get()).a("pivot_invalid_overlays", "Missing ImageOverlay in fragment model: " + profileOverlayCategoryPageFieldsModel);
                }
            }
            Logger.a(2, EntryType.UI_INPUT_END, 277046462, a);
        }
    }

    public final void m803a(android.support.v7.widget.RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        ProfileOverlayCategoryPageFieldsModel profileOverlayCategoryPageFieldsModel = (ProfileOverlayCategoryPageFieldsModel) this.f759e.get(i);
        viewHolder2.f754n = profileOverlayCategoryPageFieldsModel;
        ProfilePictureOverlayPivotListItemBinder.m804a(profileOverlayCategoryPageFieldsModel, viewHolder2.f752l);
    }

    @Inject
    public ProfilePictureOverlayPivotAdapter(@Assisted ImmutableList<? extends ProfileOverlayCategoryPageFields> immutableList, @Assisted ListItemClickListener listItemClickListener, LayoutInflater layoutInflater) {
        this.f755a = new Builder().b(immutableList.iterator()).b();
        this.f756b = listItemClickListener;
        this.f757c = layoutInflater;
        this.f759e = Lists.a(this.f755a.iterator());
        this.f760f = null;
    }

    public Filter getFilter() {
        return this.f758d;
    }

    public final android.support.v7.widget.RecyclerView.ViewHolder m802a(ViewGroup viewGroup, int i) {
        return new ViewHolder((ContentView) this.f757c.inflate(2130906460, viewGroup, false), this.f756b);
    }

    public final int aZ_() {
        return this.f759e.size();
    }
}
