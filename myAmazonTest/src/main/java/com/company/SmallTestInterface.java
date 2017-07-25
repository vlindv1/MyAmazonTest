package com.company;

import org.graphwalker.java.annotation.Model;
import org.graphwalker.java.annotation.Vertex;
import org.graphwalker.java.annotation.Edge;

@Model(file = "com/company/AmazonModel.graphml")
public interface SmallTestInterface {

    @Edge()
    void e_StartBrowser();

    @Vertex()
    void v_Home();

    @Edge()
    void e_Deals();

    @Vertex()
    void v_Deals();

    @Edge()
    void e_Outlet();

    @Edge()
    void e_Watch();

    @Edge()
    void e_Coupons();

    @Vertex()
    void v_DealsWatching();

    @Vertex()
    void v_Coupons();

    @Vertex()
    void v_Outlet();

}
