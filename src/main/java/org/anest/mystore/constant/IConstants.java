package org.anest.mystore.constant;

public interface IConstants {

    /**
     * REGEX -----------------------------------------------------------------------------------------------------------
     */
    String SORT_TYPE_REGEX = "\\b(asc|desc)\\b";

    /**
     * Vinaphone   : 081, 082, 083, 084, 085, 088, 091, 094
     * Viettel     : 032, 033, 034, 035, 036, 037, 038, 039, 086, 096, 097, 098
     * Mobilephone : 070, 076, 077, 078, 079, 089, 090, 093
     * Vietnamobile: 056, 058, 092
     * Gmobile     : 059, 099
     * iTel        : 087
     * Wintel      : 055
     * VNSKY       : 077
     * Local       : 089
     */
    String MOBILE_REGEX = "(\\+84|0)(3[2-9]|5[5689]|7[06-9]|8[1-9]|9[0-9])[0-9]{7}";

    /**
     * PAGINATION ------------------------------------------------------------------------------------------------------
     */
    String PAGINATION_PAGE = "PAGINATION_PAGE";
    String PAGINATION_SIZE = "PAGINATION_SIZE";

    /**
     * PRODUCT ---------------------------------------------------------------------------------------------------------
     */
    String TITLE_PRODUCT_LIST_TEXT = "Danh sách sản phẩm";
    String PRODUCT_LIST_DESCRIPTION = "Some quick example text to build on the card title and make up the bulk of the card's content. Some quick example text to build on the card title and make up the bulk of the card's content.";

    Integer LIMIT_PAGE_DISPLAY = 7;
    Integer LIMIT_PAGE = 999999;

    /**
     * CART ------------------------------------------------------------------------------------------------------------
     */
    String CART = "cart";
    String TOTAL_PRODUCT_IN_CART = "totalProductInCart";
    String TOTAL_AMOUNT_OF_CART = "totalAmountOfCart";

    /**
     * ORDER -----------------------------------------------------------------------------------------------------------
     */
    String ORDER_NUMBER_LENGTH = "ORDER_NUMBER_LENGTH";
    String ORDER_NUMBER_PAD = "ORDER_NUMBER_PAD";
    String ORDER_PREFIX = "ORDER_PREFIX";
}
