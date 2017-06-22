package sptechindia.redit_assignment.base.view;

public enum ViewType {
    ITEM(0), FOOTER(1), COUPON(2), ORDER_SUMMARY(3), EMPTY_VIEW(4), HEADER_VIEW(5), BUTTON_VIEW(6),COD_AVAILABLE(7),COD_NOT_AVAILABLE(8),DELIVERY_ADDRESS(9);
    private final int value;

    ViewType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static ViewType valueOf(int value) {
        for (ViewType view : ViewType.values()) {
	        if ( view.value == value ) {
		        return view;
	        }
        }
        return FOOTER;
    }
}