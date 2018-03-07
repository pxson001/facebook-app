package com.facebook.saved.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import com.facebook.fbui.widget.contentview.ContentViewWithButton;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.saved.analytics.UndoAction;
import com.facebook.saved.data.SavedDashboardItem;
import com.facebook.saved.helper.SavedItemHelper;
import com.facebook.saved.helper.SavedItemHelper.C13931;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.base.Strings;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: invite_image */
public class SavedDashboardSavedItemView extends CustomLinearLayout {
    @Inject
    public SavedItemHelper f9351a;
    private ContentViewWithButton f9352b;
    private ViewStub f9353c;
    private ContentViewWithButton f9354d;
    public SavedItemEventListener f9355e;
    private Drawable f9356f;

    /* compiled from: invite_image */
    public interface SavedItemEventListener {
        void mo433a(SavedDashboardItem savedDashboardItem);

        void mo434a(SavedDashboardItem savedDashboardItem, View view);

        void mo435a(SavedDashboardItem savedDashboardItem, UndoAction undoAction);
    }

    /* compiled from: invite_image */
    /* synthetic */ class C14033 {
        static final /* synthetic */ int[] f9350a = new int[GraphQLSavedState.values().length];

        static {
            try {
                f9350a[GraphQLSavedState.ARCHIVED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f9350a[GraphQLSavedState.NOT_SAVED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f9350a[GraphQLSavedState.SAVED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    private static <T extends View> void m9506a(Class<T> cls, T t) {
        m9507a((Object) t, t.getContext());
    }

    private static void m9507a(Object obj, Context context) {
        ((SavedDashboardSavedItemView) obj).f9351a = SavedItemHelper.m9171a(FbInjector.get(context));
    }

    public SavedDashboardSavedItemView(Context context) {
        super(context);
        m9504a();
    }

    public SavedDashboardSavedItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m9504a();
    }

    public SavedDashboardSavedItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m9504a();
    }

    private void m9504a() {
        m9506a(SavedDashboardSavedItemView.class, (View) this);
        setContentView(2130906953);
        this.f9352b = (ContentViewWithButton) a(2131567231);
        this.f9353c = (ViewStub) a(2131567232);
        this.f9352b.setThumbnailSize(getResources().getDimensionPixelSize(2131432254));
        this.f9356f = getResources().getDrawable(2130840339);
        int dimensionPixelSize = getResources().getDimensionPixelSize(2131432255);
        this.f9352b.c(dimensionPixelSize, dimensionPixelSize);
    }

    public void setSavedItemEventListener(SavedItemEventListener savedItemEventListener) {
        this.f9355e = savedItemEventListener;
    }

    private void setUndoButtonOnClickListener(final SavedDashboardItem savedDashboardItem) {
        this.f9352b.setActionButtonOnClickListener(null);
        this.f9354d.setActionButtonOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SavedDashboardSavedItemView f9347b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1732812422);
                if (this.f9347b.f9355e != null) {
                    this.f9347b.f9355e.mo433a(savedDashboardItem);
                }
                Logger.a(2, EntryType.UI_INPUT_END, -264254301, a);
            }
        });
    }

    public final void m9511a(SavedDashboardItem savedDashboardItem) {
        if (savedDashboardItem.f9115j) {
            m9509c(savedDashboardItem);
            setUndoButtonOnClickListener(savedDashboardItem);
            return;
        }
        m9508b(savedDashboardItem);
        setItemActionButtonOnClickListener(savedDashboardItem);
    }

    private void setItemActionButtonOnClickListener(final SavedDashboardItem savedDashboardItem) {
        if (this.f9354d != null) {
            this.f9354d.setActionButtonOnClickListener(null);
        }
        this.f9352b.setActionButtonOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SavedDashboardSavedItemView f9349b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1854431819);
                if (this.f9349b.f9355e != null) {
                    this.f9349b.f9355e.mo434a(savedDashboardItem, view);
                }
                Logger.a(2, EntryType.UI_INPUT_END, 1631501665, a);
            }
        });
    }

    private void m9505a(SavedItemHelper savedItemHelper) {
        this.f9351a = savedItemHelper;
    }

    private void m9508b(SavedDashboardItem savedDashboardItem) {
        if (this.f9354d != null) {
            this.f9354d.setVisibility(8);
        }
        this.f9352b.setVisibility(0);
        this.f9352b.setThumbnailUri(savedDashboardItem.m9106i());
        this.f9352b.setTitleText(Strings.nullToEmpty(savedDashboardItem.f9106a));
        this.f9352b.setSubtitleText(Strings.nullToEmpty(savedDashboardItem.f9107b));
        this.f9352b.setMetaText(Strings.nullToEmpty(savedDashboardItem.f9108c));
        this.f9352b.setOverlayDrawable(savedDashboardItem.m9107m() ? this.f9356f : null);
        this.f9352b.setShowActionButton(true);
    }

    private void m9509c(SavedDashboardItem savedDashboardItem) {
        CharSequence charSequence;
        this.f9352b.setVisibility(8);
        if (this.f9354d == null) {
            this.f9354d = (ContentViewWithButton) this.f9353c.inflate();
        }
        this.f9354d.setVisibility(0);
        this.f9354d.setTitleText(Strings.nullToEmpty(savedDashboardItem.f9106a));
        this.f9354d.setSubtitleText(m9510d(savedDashboardItem));
        ContentViewWithButton contentViewWithButton = this.f9354d;
        if (Strings.isNullOrEmpty(savedDashboardItem.f9108c)) {
            charSequence = null;
        } else {
            charSequence = " ";
        }
        contentViewWithButton.setMetaText(charSequence);
        if (this.f9351a.m9176f(savedDashboardItem)) {
            this.f9354d.setShowActionButton(true);
            if (this.f9355e != null) {
                Optional of;
                SavedItemEventListener savedItemEventListener = this.f9355e;
                if (this.f9351a.m9176f(savedDashboardItem)) {
                    GraphQLSavedState d = SavedItemHelper.m9174d(savedDashboardItem);
                    if (d != null) {
                        switch (C13931.f9168a[d.ordinal()]) {
                            case 1:
                                of = Optional.of(UndoAction.UNDO_ARCHIVE);
                                break;
                            case 2:
                                of = Optional.of(UndoAction.UNDO_UNARCHIVE);
                                break;
                            default:
                                of = Absent.INSTANCE;
                                break;
                        }
                    }
                    of = Absent.INSTANCE;
                } else {
                    of = Absent.INSTANCE;
                }
                savedItemEventListener.mo435a(savedDashboardItem, (UndoAction) of.get());
                return;
            }
            return;
        }
        this.f9354d.setShowActionButton(false);
    }

    @Nullable
    private String m9510d(SavedDashboardItem savedDashboardItem) {
        switch (C14033.f9350a[SavedItemHelper.m9174d(savedDashboardItem).ordinal()]) {
            case 1:
                return getResources().getString(2131238157);
            case 2:
                return getResources().getString(2131238158);
            case 3:
                return getResources().getString(2131238159);
            default:
                return null;
        }
    }
}
