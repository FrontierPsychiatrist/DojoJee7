package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/StartServlet" })
public class StarterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void processRequest(HttpServletRequest request,
                                  HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<html><head><title>Starter Servlet</title></head><body><h1>Servlet TestServlet at ");
            out.println(request.getContextPath());
            out.println("</h1>About to start the job<br>");
            JobOperator jo = BatchRuntime.getJobOperator();
            out.println("Got the job operator: " + jo + "<br>");
            jo.start("SimplePayrollJob", new Properties());
            out.println("Job submitted<br></body></html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Starting a simple job";
    }
}