package mk.ukim.finki.wp.lab.web.servlet;

import mk.ukim.finki.wp.lab.model.Pizza;
import mk.ukim.finki.wp.lab.service.PizzaService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "show-pizza", urlPatterns = "")
public class ShowPizza extends HttpServlet {

    private final PizzaService pizzaService;
    private final SpringTemplateEngine springTemplateEngine;

    public ShowPizza(PizzaService pizzaService, SpringTemplateEngine springTemplateEngine) {
        this.pizzaService = pizzaService;
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context = new WebContext(req, resp, req.getServletContext());
        req.getSession().invalidate();
        List<Pizza> pizzas = pizzaService.findAll();
        context.setVariable("pizzas", pizzas);
        this.springTemplateEngine.process("listPizzas.html", context, resp.getWriter());
    }
}
