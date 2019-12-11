package mk.ukim.finki.wp.lab.web.servlet;

import mk.ukim.finki.wp.lab.model.Order;
import mk.ukim.finki.wp.lab.service.OrderService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "confirmation-info", urlPatterns = "/ConfirmationInfo.do")
public class ConfirmationInfo extends HttpServlet {

    private final SpringTemplateEngine springTemplateEngine;
    private final OrderService orderService;

    public ConfirmationInfo(SpringTemplateEngine springTemplateEngine, OrderService orderService) {
        this.springTemplateEngine = springTemplateEngine;
        this.orderService = orderService;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("[WP-Log] {ConfirmationInfo :: doPost()}");

        String clientName = req.getParameter("clientName");
        String clientAddress = req.getParameter("clientAddress");
        Order order = (Order)req.getSession().getAttribute("order");
        order.setClientName(clientName);
        order.setClientAddress(clientAddress);
        req.getSession().setAttribute("clientBrowser", req.getHeader("User-Agent"));
        req.getSession().setAttribute("clientIP", req.getRemoteHost());
        req.getSession().setAttribute("order", order);

        this.springTemplateEngine.process("confirmationInfo.html", new WebContext(req, resp, req.getServletContext()), resp.getWriter());
    }

}
