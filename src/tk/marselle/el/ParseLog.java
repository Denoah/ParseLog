package tk.marselle.el;

import java.io.IOException;


public class ParseLog extends javax.servlet.http.HttpServlet {

    private static final String inputFileName = "c://skat1";
    private static final String outputFileName = "c://textOutput";
    private static final String SUB_STRING = "RADIOSETDRIVER";

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String jsonObject = WorkWithFile.firstParse(inputFileName, outputFileName, SUB_STRING);
        response.getWriter().write(jsonObject);

    }
}
