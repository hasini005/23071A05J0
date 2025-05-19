import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@WebServlet("/displayCookies")
public class DisplayCookiesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Cookies Display</title></head><body>");
        out.println("<h2>Cookies</h2>");
        out.println("<table border='1'>");
        out.println("<tr><th>Cookie Name</th><th>Cookie Value</th></tr>");

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                out.println("<tr><td>" + cookie.getName() + "</td><td>" + cookie.getValue() + "</td></tr>");
            }
        } else {
            out.println("<tr><td colspan='2'>No cookies found</td></tr>");
        }

        out.println("</table>");
        out.println("</body></html>");
    }
}
