import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servlet", urlPatterns="/name")                   //DON'T TRY TO RENAME THE SERVLET (SEE SERVLETS)
public class Servlet extends HttpServlet {
    public class nameServlet extends HttpServlet {
        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String person = request.getParameter("person");
            request.setAttribute("person", person);
            request.getRequestDispatcher("felicitations.jsp").forward(request, response);
        }

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.getRequestDispatcher("form.jsp").forward(request, response);
        }
    }
}
