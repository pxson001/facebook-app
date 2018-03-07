package com.facebook.bookmark.ui;

import android.app.Activity;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.bookmark.abtest.ExperimentsForBookmarkExperimentsModule;
import com.facebook.bookmark.model.Bookmark;
import com.facebook.bookmark.model.BookmarkWithResourcePic;
import com.facebook.bookmark.model.BookmarksGroup;
import com.facebook.bookmark.ui.BookmarkAdapter.BaseViewItem;
import com.facebook.bookmark.ui.BookmarkAdapter.RowType;
import com.facebook.bookmark.ui.BookmarkAdapter.ViewItem;
import com.facebook.caspian.ui.bookmarks.BookmarkDividerView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.StringUtil;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.feed.thirdparty.instagram.InstagramUtils;
import com.facebook.inject.FbInjector;
import com.facebook.notifications.common.JewelCounters;
import com.facebook.notifications.common.JewelCounters.Jewel;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.widget.text.CustomFontHelper;
import com.facebook.widget.text.CustomFontHelper.FontFamily;
import com.facebook.widget.text.CustomFontHelper.FontWeight;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: receiverUserName */
public class BaseViewItemFactory {
    private static final Class f5720d = BaseViewItemFactory.class;
    private static final CallerContext f5721f = CallerContext.a(BaseViewItem.class, "bookmarks");
    public final Activity f5722a;
    protected final LayoutInflater f5723b;
    protected JewelCounters f5724c;
    public final QeAccessor f5725e;
    public final InstagramUtils f5726g;

    /* compiled from: receiverUserName */
    public class CaspianBookmarkViewItem extends BaseViewItem<ContentViewWithBadgeHolder, Bookmark> {
        public final /* synthetic */ BaseViewItemFactory f5709a;

        public CaspianBookmarkViewItem(BaseViewItemFactory baseViewItemFactory, RowType rowType, Bookmark bookmark) {
            this.f5709a = baseViewItemFactory;
            super(rowType, 2130903517, bookmark, baseViewItemFactory.f5723b);
        }

        public final Object mo227a(View view) {
            ((ContentView) view).setTitleTextAppearance(2131624398);
            return new ContentViewWithBadgeHolder(view);
        }

        private String m5938a(int i) {
            int i2;
            if (((Bookmark) this.f5707d).id == 2344061033L) {
                i2 = 2131689473;
            } else if (((Bookmark) this.f5707d).id == 245119965500321L) {
                i2 = 2131689474;
            } else {
                i2 = 2131689472;
            }
            return this.f5709a.f5722a.getResources().getQuantityString(i2, i, new Object[]{((Bookmark) this.f5707d).name, Integer.valueOf(i)});
        }

        private String m5939a(long j, int i) {
            if (j == 124024574287414L) {
                return m5941b(i);
            }
            if (j == 256002347743983L || j == 794956213882720L) {
                return m5942d(i);
            }
            return String.valueOf(i);
        }

        private String m5941b(int i) {
            if (!this.f5709a.f5726g.h()) {
                return m5942d(i);
            }
            return this.f5709a.f5722a.getResources().getQuantityString(2131689476, i, new Object[]{Integer.valueOf(i)});
        }

        private String m5942d(int i) {
            return this.f5709a.f5722a.getResources().getQuantityString(2131689475, i, new Object[]{Integer.valueOf(i)});
        }

        private void m5940a(ContentViewWithBadgeHolder contentViewWithBadgeHolder) {
            if (this.f5707d != null) {
                boolean z;
                CharSequence charSequence;
                boolean z2;
                int a = this.f5709a.m5952a((Bookmark) this.f5707d);
                if (a > 0) {
                    contentViewWithBadgeHolder.f5717a.setThumbnailUri(null);
                    contentViewWithBadgeHolder.f5717a.setThumbnailPlaceholderResource(a);
                } else {
                    contentViewWithBadgeHolder.f5717a.setThumbnailUri(((Bookmark) this.f5707d).pic == null ? null : Uri.parse(((Bookmark) this.f5707d).pic));
                    contentViewWithBadgeHolder.f5717a.setThumbnailPlaceholderDrawable(null);
                }
                if (((Bookmark) this.f5707d).id == 2344061033L) {
                    contentViewWithBadgeHolder.f5717a.setId(2131558410);
                } else {
                    contentViewWithBadgeHolder.f5717a.setId((int) ((Bookmark) this.f5707d).id);
                }
                contentViewWithBadgeHolder.f5717a.setTitleText(((Bookmark) this.f5707d).name);
                contentViewWithBadgeHolder.f5717a.setContentDescription(((Bookmark) this.f5707d).name);
                boolean equals = "page".equals(((Bookmark) this.f5707d).type);
                boolean a2 = ((Bookmark) this.f5707d).m5862a();
                int a3 = ((Bookmark) this.f5707d).id == 217974574879787L ? this.f5709a.f5724c.a(Jewel.INBOX) : ((Bookmark) this.f5707d).m5863b();
                CharSequence c = ((Bookmark) this.f5707d).m5864c();
                if (equals && !StringUtil.a(c) && this.f5709a.f5725e.a(ExperimentsForBookmarkExperimentsModule.f5599b, false)) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    charSequence = c;
                } else {
                    Object a4 = m5939a(((Bookmark) this.f5707d).id, a3);
                }
                if (!z) {
                    Object a5 = m5938a(a3);
                }
                if (a2 && equals && !this.f5709a.f5725e.a(ExperimentsForBookmarkExperimentsModule.f5598a, false)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (a3 <= 0 || r0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    contentViewWithBadgeHolder.f5718b.setVisibility(8);
                    return;
                }
                contentViewWithBadgeHolder.f5718b.setText(charSequence);
                contentViewWithBadgeHolder.f5717a.setContentDescription(c);
                if (((Bookmark) this.f5707d).id == 217974574879787L) {
                    contentViewWithBadgeHolder.f5718b.setBackgroundResource(2130837820);
                    CustomFontHelper.a(contentViewWithBadgeHolder.f5718b, FontFamily.ROBOTO, FontWeight.MEDIUM, contentViewWithBadgeHolder.f5718b.getTypeface());
                } else {
                    contentViewWithBadgeHolder.f5718b.setBackgroundResource(2130837818);
                    CustomFontHelper.a(contentViewWithBadgeHolder.f5718b, FontFamily.ROBOTO, FontWeight.REGULAR, contentViewWithBadgeHolder.f5718b.getTypeface());
                }
                contentViewWithBadgeHolder.f5718b.setVisibility(0);
            }
        }
    }

    /* compiled from: receiverUserName */
    public class CaspianDividerViewItem extends BaseViewItem<DividerViewHolder, BookmarksGroup> {
        final /* synthetic */ BaseViewItemFactory f5710a;
        private final boolean f5711f;

        public final void mo228a(Object obj) {
            DividerViewHolder dividerViewHolder = (DividerViewHolder) obj;
            if (this.f5707d != null) {
                dividerViewHolder.f5719a.setText(((BookmarksGroup) this.f5707d).name);
            } else {
                dividerViewHolder.f5719a.setText("");
            }
        }

        public CaspianDividerViewItem(BaseViewItemFactory baseViewItemFactory, RowType rowType, @Nullable BookmarksGroup bookmarksGroup, boolean z) {
            this.f5710a = baseViewItemFactory;
            super(rowType, 2130903516, bookmarksGroup, baseViewItemFactory.f5723b);
            this.f5711f = z;
        }

        public final Object mo227a(View view) {
            return new DividerViewHolder(view);
        }

        public final View mo224a(int i, @Nullable View view, ViewGroup viewGroup) {
            BookmarkDividerView bookmarkDividerView = (BookmarkDividerView) super.mo224a(i, view, viewGroup);
            bookmarkDividerView.setExtraPaddingEnabled(this.f5711f);
            return bookmarkDividerView;
        }
    }

    /* compiled from: receiverUserName */
    public class CaspianIconLabelView<D> extends BaseViewItem<ContentViewHolder, D> {
        final /* synthetic */ BaseViewItemFactory f5712a;
        private int f5713f;
        private CharSequence f5714g;

        public final void mo228a(Object obj) {
            ContentViewHolder contentViewHolder = (ContentViewHolder) obj;
            if (this.f5713f < 0) {
                contentViewHolder.f5716a.setShowThumbnail(false);
            } else {
                contentViewHolder.f5716a.setShowThumbnail(true);
                contentViewHolder.f5716a.setThumbnailResource(this.f5713f);
            }
            contentViewHolder.f5716a.setTitleText(this.f5714g);
            contentViewHolder.f5716a.setContentDescription(this.f5714g);
        }

        public CaspianIconLabelView(BaseViewItemFactory baseViewItemFactory, RowType rowType, D d, int i, CharSequence charSequence) {
            this.f5712a = baseViewItemFactory;
            super(rowType, 2130903517, d, baseViewItemFactory.f5723b);
            this.f5713f = i;
            this.f5714g = charSequence;
        }

        public final Object mo227a(View view) {
            return new ContentViewHolder((ContentView) view);
        }
    }

    /* compiled from: receiverUserName */
    public class CaspianProfileViewItem extends BaseViewItem<ContentViewHolder, Bookmark> {
        final /* synthetic */ BaseViewItemFactory f5715a;

        public final void mo228a(Object obj) {
            Object string;
            ContentViewHolder contentViewHolder = (ContentViewHolder) obj;
            contentViewHolder.f5716a.setThumbnailPlaceholderResource(2130840424);
            if (((Bookmark) this.f5707d).pic != null) {
                try {
                    contentViewHolder.f5716a.setThumbnailUri(Uri.parse(((Bookmark) this.f5707d).pic));
                } catch (IllegalArgumentException e) {
                    contentViewHolder.f5716a.setThumbnailUri(null);
                }
            }
            if (((Bookmark) this.f5707d).type.equals("page")) {
                string = this.f5715a.f5722a.getString(2131230839);
            } else {
                String string2 = this.f5715a.f5722a.getString(2131230838);
            }
            contentViewHolder.f5716a.setTitleText(((Bookmark) this.f5707d).name);
            contentViewHolder.f5716a.setSubtitleText(string);
            CharSequence stringBuilder = new StringBuilder();
            stringBuilder.append(((Bookmark) this.f5707d).name).append(". ").append(string);
            contentViewHolder.f5716a.setContentDescription(stringBuilder);
        }

        public CaspianProfileViewItem(BaseViewItemFactory baseViewItemFactory, RowType rowType, Bookmark bookmark) {
            this.f5715a = baseViewItemFactory;
            super(rowType, 2130903422, bookmark, baseViewItemFactory.f5723b);
        }

        public final Object mo227a(View view) {
            ((ContentView) view).setTitleTextAppearance(2131624398);
            ((ContentView) view).setSubtitleTextAppearance(2131624399);
            return new ContentViewHolder(view);
        }
    }

    /* compiled from: receiverUserName */
    public class ContentViewHolder {
        public final ContentView f5716a;

        public ContentViewHolder(View view) {
            this.f5716a = (ContentView) view;
        }
    }

    /* compiled from: receiverUserName */
    public class ContentViewWithBadgeHolder {
        public final ContentView f5717a;
        public final TextView f5718b;

        public ContentViewWithBadgeHolder(View view) {
            this.f5717a = (ContentView) view;
            this.f5718b = (TextView) view.findViewById(2131560255);
        }
    }

    /* compiled from: receiverUserName */
    public class DividerViewHolder {
        public final BookmarkDividerView f5719a;

        public DividerViewHolder(View view) {
            this.f5719a = (BookmarkDividerView) view;
        }
    }

    public BaseViewItemFactory(Activity activity, LayoutInflater layoutInflater, JewelCounters jewelCounters) {
        this.f5722a = (Activity) Preconditions.checkNotNull(activity);
        this.f5723b = ((LayoutInflater) Preconditions.checkNotNull(layoutInflater)).cloneInContext(this.f5722a);
        this.f5724c = jewelCounters;
        FbInjector fbInjector = FbInjector.get(activity);
        this.f5726g = InstagramUtils.a(fbInjector);
        this.f5725e = (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector);
    }

    public final <D> ViewItem m5954a(RowType rowType, D d, int i, int i2) {
        return m5955a(rowType, (Object) d, i, this.f5722a.getResources().getText(i2));
    }

    public final <D> ViewItem m5955a(RowType rowType, D d, int i, CharSequence charSequence) {
        return new CaspianIconLabelView(this, rowType, d, i, charSequence);
    }

    public final ViewItem m5953a(RowType rowType, @Nullable BookmarksGroup bookmarksGroup, boolean z) {
        return new CaspianDividerViewItem(this, rowType, bookmarksGroup, z);
    }

    public final ViewItem m5956b(RowType rowType, Bookmark bookmark) {
        return new CaspianBookmarkViewItem(this, rowType, bookmark);
    }

    protected int m5952a(Bookmark bookmark) {
        if (bookmark instanceof BookmarkWithResourcePic) {
            return ((BookmarkWithResourcePic) bookmark).m5868a();
        }
        return 0;
    }
}
