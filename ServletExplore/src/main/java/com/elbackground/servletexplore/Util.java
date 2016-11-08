package com.elbackground.servletexplore;

public abstract class Util {
    public static String defaultWrap(String title, String body) {
        return  "<!DOCTYPE html>"
                + "<html>"
                    + "<head>"
                        + "<title>" + title + " </title>"     
                    + "</head>"
                    + "<body>"
                        + "<dir style=\"margin: 100px 35% 0px 35%; padding: 10px 10px 10px 10px; "
                        + "width: 30%; background-color: #b097a7; text-align: center;\">"
                            + "<h1>" + title + "</h1>"
                            + body + "<br>"
                            + "<a href=\"http://localhost:8080/ServletExplore\">Main page</a>"
                        + "</dir>"
                    + "</body>"
                + "</html>";
    }
}
