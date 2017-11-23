package by.tr.parser.controller;

import by.tr.parser.constant.JspPath;
import by.tr.parser.constant.ParserType;
import by.tr.parser.constant.RedirectQuery;
import by.tr.parser.controller.util.Pagination;
import by.tr.parser.controller.util.PaginationHelper;
import by.tr.parser.entity.Tariff;
import by.tr.parser.service.ServiceFactory;
import by.tr.parser.service.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static by.tr.parser.constant.AttributeName.*;

public class TariffController extends HttpServlet {
    private static final Logger logger = LogManager.getLogger(TariffController.class);

    private static final long serialVersionUID = -4628099127626697790L;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String parserType = request.getParameter(SET_PARSER);
        if (ParserType.contains(parserType)) {
            request.getSession(true).setAttribute(PARSER, parserType);
            response.sendRedirect(RedirectQuery.TO_FIRST_INFO_PAGE);
        } else {
            request.getRequestDispatcher(JspPath.ERROR_PAGE).forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object parserObj = request.getSession(false).getAttribute(PARSER);
        String parserString;
        if (parserObj != null) {
            parserString = String.valueOf(parserObj);
            ParserType parserType = ParserType.valueOf(parserString.toUpperCase().trim());
            try {
                List<Tariff> tariffList = ServiceFactory.getInstance().getTariffService().getTariffs(parserType);

                String current = request.getParameter(PAGE);
                int tariffListSize = tariffList.size();
                Pagination pagination = PaginationHelper.getPagination(current, tariffListSize);
                if (pagination == null) {
                    request.getRequestDispatcher(JspPath.ERROR_PAGE).forward(request, response);
                } else {
                    int firstElementOnPageIndex = PaginationHelper.getFirstElementIndex(pagination.getCurrent());
                    int lastElementOnPageIndex = PaginationHelper.getLastElementIndex(firstElementOnPageIndex, tariffListSize);
                    List<Tariff> tariffsOnOnePage = tariffList.subList(firstElementOnPageIndex, lastElementOnPageIndex);

                    request.setAttribute(PAGES, pagination);
                    request.setAttribute(TARIFFS, tariffsOnOnePage);

                    request.getRequestDispatcher(JspPath.INFO_PAGE).forward(request, response);
                }
            } catch (ServiceException e) {
                logger.error(e);
                request.getRequestDispatcher(JspPath.ERROR_PAGE).forward(request, response);
            }
        } else {
            response.sendRedirect(JspPath.START_PAGE);
        }


    }
}
