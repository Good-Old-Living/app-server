package meru.app.server.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import meru.app.server.AppServer;

public class BootstrapServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        String appName = config.getServletContext().getServletContextName();
        
        System.out.println("############# "+appName+" Starting ##############");
        System.out.println("Starting " + config.getServletContext()
                                               .getServletContextName());
        try {
            HttpAppContext appContext = new HttpAppContext(config.getServletContext());
            AppServer appInstance = new AppServer(appContext);
            appInstance.init();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        System.out.println("******** "+appName+ " is up and running ********");
    }
}
