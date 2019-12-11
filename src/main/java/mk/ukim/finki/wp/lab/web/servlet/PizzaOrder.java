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

@WebServlet(name = "pizza-order", urlPatterns = "/PizzaOrder.do")
public class PizzaOrder extends HttpServlet {

    private final SpringTemplateEngine springTemplateEngine;
    private final OrderService orderService;

    public PizzaOrder(SpringTemplateEngine springTemplateEngine, OrderService orderService) {
        this.springTemplateEngine = springTemplateEngine;
        this.orderService = orderService;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String pizzaSize = req.getParameter("pizza_size");
        Order order = (Order)req.getSession().getAttribute("order");
        order.setPizzaSize(pizzaSize);
        req.getSession().setAttribute("order", order);

        this.springTemplateEngine.process("deliveryInfo.html", new WebContext(req, resp, req.getServletContext()), resp.getWriter());
    }

}
