package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;

public class DateTimeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        PrintWriter printWriter = res.getWriter();
        String value = req.getParameter("value");

        if (value.equals("date")) {
            req.setAttribute("currentDate",LocalDate.now().toString());
            req.getRequestDispatcher("/date.jsp").forward(req,res);
        }
        if (value.equals("time")) {
            req.setAttribute("currentTime", LocalTime.now().toString());
            req.getRequestDispatcher("/time.jsp").forward(req,res);
        } else {
            printWriter.write("Please enter http://localhost:8080/webapp/req?value=date\n" +
                                 "or http://localhost:8080/webapp/req?value=time");
        }

    }

}
