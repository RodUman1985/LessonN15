package com.step.name.filters;

import com.step.name.model.User;
import com.step.name.service.GoodService;
import com.step.name.service.UserService;
import com.step.name.service.impl.GoodServiceImpl;
import com.step.name.service.UtilsForShop;
import com.step.name.service.impl.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Optional;

@WebFilter(urlPatterns = {"/Shop.jsp"})
public class FilterForShop implements Filter {
    private static final Logger LOGGER = LogManager.getLogger(FilterForShop.class);
    private final GoodService goodService =new GoodServiceImpl();
    private final UserService userService = new UserServiceImpl();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse
            , FilterChain filterChain) {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        request.setAttribute("goods", goodService.printGoods());
        checkUser(request);
        checkFlag(servletResponse, request);
        try {
            filterChain.doFilter(request, servletResponse);
        } catch (IOException e) {
            LOGGER.error("IOException in doFilter " + e);
        } catch (ServletException e) {
            LOGGER.error("ServletException in doFilter " + e);
        }
    }

    private void checkFlag(ServletResponse servletResponse, HttpServletRequest request) {
        if (request.getSession().getAttribute("check") == null) {
            if (request.getParameter("check") != null) {
                UtilsForShop.setCheckStatus(request, request.getParameter("check"));
            } else {
                String path = "/ErrorPage.jsp";
                RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
                try {
                    requestDispatcher.forward(request, servletResponse);
                } catch (ServletException e) {
                    LOGGER.error("ServletException in checkFlag" + e);
                } catch (IOException e) {
                    LOGGER.error("IOException in checkFlag" + e);
                }
            }
        }
    }

    private void checkUser(HttpServletRequest request) {
        String name = request.getParameter("UserName");
        String password = request.getParameter("pass");
        User user = new User(name, password);
        if (name != null) {
            if (userService.getByName(name).isEmpty()) {
                userService.createUser(user);
            }
            Optional<User> newUser = userService.getByName(name);
            if (newUser.isPresent()) {
                if (request.getSession().getAttribute("user") == null) {
                    UtilsForShop.setUser(request, newUser.get());
                } else if (!UtilsForShop.isUsersEquals(request)) {
                    request.getSession().invalidate();
                    UtilsForShop.setUser(request, newUser.get());
                }
            }
        }
    }

}