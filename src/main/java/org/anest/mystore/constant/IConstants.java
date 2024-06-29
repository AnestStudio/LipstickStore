package org.anest.mystore.constant;

public interface IConstants {

    /*
     * REGEX -----------------------------------------------------------------------------------------------------------
     */
    String SORT_TYPE_REGEX = "\\b(asc|desc)\\b";

    /*
     * PAGINATION ------------------------------------------------------------------------------------------------------
     */
    String PAGINATION_PAGE = "PAGINATION_PAGE";
    String PAGINATION_SIZE = "PAGINATION_SIZE";

    /*
     * PRODUCT ---------------------------------------------------------------------------------------------------------
     */
    String TITLE_PRODUCT_LIST_TEXT = "Danh sách sản phẩm";
    String PRODUCT_LIST_DESCRIPTION = "Some quick example text to build on the card title and make up the bulk of the card's content. Some quick example text to build on the card title and make up the bulk of the card's content.";

    Integer LIMIT_PAGE_DISPLAY = 8;
    Integer LIMIT_PAGE = 999999;

    /*
     * CART ------------------------------------------------------------------------------------------------------------
     */
    String CART = "cart";
    String TOTAL_PRODUCT_IN_CART = "totalProductInCart";
    String TOTAL_AMOUNT_OF_CART = "totalAmountOfCart";

    /*
     * ORDER -----------------------------------------------------------------------------------------------------------
     */
    String ORDER_NUMBER_LENGTH = "ORDER_NUMBER_LENGTH";
    String ORDER_NUMBER_PAD = "ORDER_NUMBER_PAD";
    String ORDER_PREFIX = "ORDER_PREFIX";
}
