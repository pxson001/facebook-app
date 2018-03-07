package com.facebook.composer.tasks;

import java.util.EnumSet;

/* compiled from: photo_picker_gallery_return_to_grid */
public enum ComposerTaskId {
    FETCH_APP_NAME(EnumSet.of(DependantAction.SUBMISSION)),
    TIMEOUT_AUTOTAGGING(EnumSet.noneOf(DependantAction.class)),
    ENABLE_POST_AFTER_AUTOTAGGING(EnumSet.noneOf(DependantAction.class)),
    FETCH_PAGE_INFO(EnumSet.of(DependantAction.SUBMISSION)),
    FETCH_ROBOTEXT(EnumSet.of(DependantAction.SUBMISSION));
    
    private final EnumSet<DependantAction> mDependants;

    /* compiled from: photo_picker_gallery_return_to_grid */
    public enum DependantAction {
        private static final /* synthetic */ DependantAction[] $VALUES = null;
        public static final DependantAction SUBMISSION = null;

        private DependantAction(String str, int i) {
        }

        public static DependantAction valueOf(String str) {
            return (DependantAction) Enum.valueOf(DependantAction.class, str);
        }

        public static DependantAction[] values() {
            return (DependantAction[]) $VALUES.clone();
        }

        static {
            SUBMISSION = new DependantAction("SUBMISSION", 0);
            $VALUES = new DependantAction[]{SUBMISSION};
        }
    }

    private ComposerTaskId(EnumSet<DependantAction> enumSet) {
        this.mDependants = enumSet;
    }

    public final boolean isDependencyFor(DependantAction dependantAction) {
        return this.mDependants.contains(dependantAction);
    }
}
