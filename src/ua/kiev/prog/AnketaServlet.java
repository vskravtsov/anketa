package ua.kiev.prog;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class AnketaServlet extends javax.servlet.http.HttpServlet {
    private static AtomicInteger countMale = new AtomicInteger(0);
    private static AtomicInteger countFemale = new AtomicInteger(0);
    private static AtomicInteger countMaried = new AtomicInteger(0);
    private static AtomicInteger countSingle = new AtomicInteger(0);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String name = request.getParameter("name");
        String lastname = request.getParameter("lastname");
        int age = Integer.valueOf(request.getParameter("age"));
        String gender = request.getParameter("gender");
        String marriage = request.getParameter("marriage");

        if (gender != null && gender.equals("male"))
            countMale.incrementAndGet();
        if (gender != null && gender.equals("female"))
            countFemale.incrementAndGet();
        if (marriage != null && marriage.equals("yes"))
            countMaried.incrementAndGet();
        if (marriage != null && marriage.equals("no"))
            countSingle.incrementAndGet();

        request.setAttribute("male", countMale);
        request.setAttribute("female", countFemale);
        request.setAttribute("married", countMaried);
        request.setAttribute("single", countSingle);

        RequestDispatcher rDisp =
                getServletContext().getRequestDispatcher("/stat.jsp");
        rDisp.forward(request, response);

    }
}