package by.tr.parser.controller;

import by.tr.parser.constant.ParserType;
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

public class TariffController extends HttpServlet {
    private static final long serialVersionUID = -4628099127626697790L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String parserType = request.getParameter("set_parser");
        if (ParserType.contains(parserType)){
            request.getSession(true).setAttribute("parser", parserType);
            response.sendRedirect("/TariffController?page=1");
        } else{
            System.out.println("not a parser");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object parserObj = request.getSession(false).getAttribute("parser");
        String parserString;
        if (parserObj != null){
            parserString = String.valueOf(parserObj);
            ParserType parserType = ParserType.valueOf(parserString.toUpperCase().trim());
            try{
                List<Tariff> tariffList = ServiceFactory.getInstance().getTariffService().getTariffs(parserType);

                Pagination pagination = new Pagination();


                String current = request.getParameter("page");
                if (current != null){
                    pagination.setCurrent(Integer.parseInt(current));
                }
                pagination.setLast(PaginationHelper.getLastPageNumber(tariffList.size()));


                int firstElementOnPageIndex = PaginationHelper.getFirstElementIndex(pagination.getCurrent());
                int lastElementOnPageIndex = PaginationHelper.getLastElementIndex(firstElementOnPageIndex, tariffList.size());
                List<Tariff> tariffsOnOnePage = tariffList.subList(firstElementOnPageIndex, lastElementOnPageIndex);


                request.setAttribute("pages", pagination);
                request.setAttribute("tariffs", tariffsOnOnePage);

                request.getRequestDispatcher("WEB-INF/jsp/info.jsp").forward(request,response);


            } catch (ServiceException e) {
                e.printStackTrace();
            }
        } else{
            response.sendRedirect("index.jsp");
        }


    }
}
