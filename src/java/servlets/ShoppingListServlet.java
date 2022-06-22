package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ShoppingListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("username");
        String action = "";
        
        if (request.getParameter("action") != null)
            action = request.getParameter("action");
        
        if (action.equals("logout")){
            session.invalidate();
            
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
        }
        
        if (user != null){
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            return;
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        ArrayList<String> list = (ArrayList<String>) session.getAttribute("list");
        String action = request.getParameter("action");
        
        if (list == null)
            list = new ArrayList<>();
        
        if (action.equals("register")){
            String user = request.getParameter("username");
        
            if (!user.equals("")) {
                session.setAttribute("username",user);
                
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
                return;
            }
        }else if (action.equals("add")){
            String item = request.getParameter("listInput");
            
            if (item != null && item.length() > 0 ){
                list.add(item);
                session.setAttribute("list",list);
                
                response.sendRedirect("ShoppingList");
                return;
            }
        }else if (action.equals("delete")){
            String item = request.getParameter("shoplist");
            
            if (item != null){
                list.remove(item);
                session.setAttribute("list",list);
                
                response.sendRedirect("ShoppingList");
                return;
            }
        }
        
     
        getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        return;
    }



}
