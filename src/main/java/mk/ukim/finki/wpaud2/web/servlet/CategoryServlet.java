package mk.ukim.finki.wpaud2.web.servlet;

import mk.ukim.finki.wpaud2.model.Category;
import mk.ukim.finki.wpaud2.service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
//Initial code, messy and includes everything, should be divided in proper places (include layered architecture)
@WebServlet(name = "categoryServlet",urlPatterns = "/servlet/category")
public class CategoryServlet extends HttpServlet {
/*
Already added as a model in the model package
    class Category
    {
        String name;
        String desc;

        public String getName() {
            return name;
        }

        public String getDesc() {
            return desc;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public Category(String name, String desc) {
            this.name = name;
            this.desc = desc;
        }
    }
*/
/*
 //created a temporaty data holder class in the bootstrap package, later on will be changed by a db
 @Override
 public void init() throws ServletException {
     super.init();
     categoryList= new ArrayList<>();
     categoryList.add(new Category("Software","Neshto software babush"));
     categoryList.add(new Category("Books","Neshto chitam ja Svetle"));
 }

 private List<Category> categoryList = null;
*/
    private final CategoryService categoryService;
    public CategoryServlet(CategoryService categoryService)
    {
        this.categoryService= categoryService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ipAddress= req.getRemoteAddr();
        String clientAgent = req.getHeader("User-Agent");

        PrintWriter writer= resp.getWriter();
        writer.println("<html>");
        writer.println("<head>");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("<h3>User Info</h3>");
        writer.format("IP Address: %s",ipAddress);
        writer.println("</br>");
        writer.format("Client Agent: %s",clientAgent);
        writer.println("</br>");
        writer.println("<h3>Category list</h3>");
        writer.println("<ul>");
        categoryService.listCategories().forEach(i->writer.format("<li>%s (%s)</li>",i.getName(),i.getDescription()));
        writer.println("</ul>");
        writer.println("<h3>Add Category</h3>");

        writer.println("<form method='POST' action='/servlet/category'>");

        writer.println("<label for='name'>Name:</label>");
        writer.println("<input id='name' type='text' name='name'/>");

        writer.println("<label for='desc'>Description:</label>");
        writer.println("<input id='desc' type='text' name='desc'/>");

        writer.println("<input type='submit' value='Submit'/>");

        writer.println("</form>");
        writer.println("</body>");
        writer.println("</html>");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String Catname= req.getParameter("name");
        String Descname= req.getParameter("desc");
        categoryService.create(Catname,Descname);
        resp.sendRedirect("/servlet/category");
    }
/*
    public void addCategory(String name,String desc) //part of data access layer
    {
        if(name !=null && !name.isEmpty() && desc!=null && !desc.isEmpty())
        {
            categoryList.add(new Category(name,desc));
        }
    }
*/
}
