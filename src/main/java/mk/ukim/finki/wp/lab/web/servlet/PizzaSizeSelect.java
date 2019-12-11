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

@WebServlet(name = "select-pizza-size", urlPatterns = "/pizzaSize")
public class PizzaSizeSelect extends HttpServlet {

    private final OrderService orderService;
    private final SpringTemplateEngine springTemplateEngine;

    public PizzaSizeSelect(SpringTemplateEngine springTemplateEngine, OrderService orderService) {
        this.springTemplateEngine = springTemplateEngine;
        this.orderService = orderService;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pizzaName = req.getParameter("pizza");

        if (pizzaName == null || pizzaName.isEmpty()) {
            resp.sendRedirect("");
            return;
        }

        Order order = new Order();
        order.setPizzaType(pizzaName);

        req.getSession().setAttribute("order", order);
        WebContext context = new WebContext(req, resp, req.getServletContext());
        this.springTemplateEngine.process("selectPizzaSize.html", context, resp.getWriter());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
