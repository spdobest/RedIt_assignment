package sptechindia.redit_assignment.model;

import sptechindia.redit_assignment.base.view.ViewType;

public class BaseItem {
    public ViewType viewType = ViewType.ITEM;

    public BaseItem(ViewType type) {
        viewType = type;
    }

    public BaseItem(){}

    @Override
    public boolean equals(Object o) {
        return ((BaseItem) o).viewType == viewType;
    }
}
