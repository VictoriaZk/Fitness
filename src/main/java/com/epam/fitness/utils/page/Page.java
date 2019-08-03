package com.epam.fitness.utils.page;

/**
 * The enum Page.
 */
public enum Page {

    /**
     * Home page page.
     */
    HOME_PAGE("/WEB-INF/home.jsp"),
    /**
     * Gyp photos page page.
     */
    GYP_PHOTOS_PAGE("/WEB-INF/gymPhotos.jsp"),
    /**
     * Login page.
     */
    LOGIN("/WEB-INF/login.jsp"),
    /**
     * Menu page.
     */
    MENU("/WEB-INF/menu.jsp"),
    /**
     * Order page page.
     */
    ORDER_PAGE("/WEB-INF/orderPage.jsp"),
    /**
     * Client exercise page page.
     */
    CLIENT_EXERCISE_PAGE("/WEB-INF/client/clientExercise.jsp"),
    /**
     * Client nutrition page page.
     */
    CLIENT_NUTRITION_PAGE("/WEB-INF/client/clientNutrition.jsp"),
    /**
     * Client profile page page.
     */
    CLIENT_PROFILE_PAGE("/WEB-INF/client/clientProfile.jsp"),
    /**
     * Coaches clients page page.
     */
    COACHES_CLIENTS_PAGE("/WEB-INF/coach/coachClients.jsp"),
    /**
     * Coach comments page page.
     */
    COACH_COMMENTS_PAGE("/WEB-INF/coach/coachCommentsPage.jsp"),
    /**
     * No access page page.
     */
    NO_ACCESS_PAGE("/WEB-INF/noAccessPage.jsp"),
    /**
     * All coaches page page.
     */
    ALL_COACHES_PAGE("/WEB-INF/coach/allCoaches.jsp"),
    /**
     * Clients orders page page.
     */
    CLIENTS_ORDERS_PAGE("/WEB-INF/client/clientOrders.jsp");

    private final String value;

    Page(String value) {
        this.value = value;
    }

    /**
     * Gets page.
     *
     * @return the page
     */
    public String getPage() {
        return value;
    }
}
