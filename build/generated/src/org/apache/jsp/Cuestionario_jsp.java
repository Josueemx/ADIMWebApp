package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Cuestionario_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/header.jsp");
    _jspx_dependants.add("/footer.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\n');
      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("    <title>ADIM</title>\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("    <!-- Estilo viejo\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n");
      out.write("    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\n");
      out.write("    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n");
      out.write("    -->\n");
      out.write("    <!-- Styles -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"styles/bootstrap.min.css\"/>\n");
      out.write("    <link rel=\"stylesheet\" href=\"styles/Style.css\"/>\n");
      out.write("    \n");
      out.write("    <!-- Scripts -->\n");
      out.write("    <script src=\"scripts/jquery-2.2.4.js\"> </script>\n");
      out.write("    <script src=\"scripts/bootstrap.min.js\"> </script>\n");
      out.write("    <script src=\"scripts/App.js\"> </script>\n");
      out.write("    \n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("<nav class=\"navbar navbar-inverse\">\n");
      out.write("  <div class=\"container-fluid\">\n");
      out.write("    <div class=\"navbar-header\">\n");
      out.write("      <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#myNavbar\">\n");
      out.write("        <span class=\"icon-bar\"></span>\n");
      out.write("        <span class=\"icon-bar\"></span>\n");
      out.write("        <span class=\"icon-bar\"></span>                        \n");
      out.write("      </button>\n");
      out.write("      <a class=\"navbar-brand\" href=\"#\">Logo</a>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"collapse navbar-collapse\" id=\"myNavbar\">\n");
      out.write("      <ul class=\"nav navbar-nav\">\n");
      out.write("        <li class=\"active\"><a href=\"Cuestionario.jsp\">Home</a></li>\n");
      out.write("        <li><a href=\"#\">About</a></li>\n");
      out.write("        \n");
      out.write("      </ul>\n");
      out.write("      <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("        <li><a href=\"#\"><span class=\"glyphicon glyphicon-log-in\"></span> Login</a></li>\n");
      out.write("      </ul>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("</nav>\n");
      out.write("\n");
      out.write("  \n");
      out.write("<div class=\"container-fluid text-center\">    \n");
      out.write("  <div class=\"row content\">\n");
      out.write("    <div class=\"col-sm-2 sidenav\">\n");
      out.write("      \n");
      out.write("    </div>\n");
      out.write("    <div class=\"col-sm-8 text-left\"> \n");
      out.write("        <h3>Ubicación del negocio</h3>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("            <input id=\"pac-input\" class=\"controls\" type=\"text\" placeholder=\"Introduce una ubicación\">\n");
      out.write("            <div id=\"map\"></div>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <hr>\n");
      out.write("        <h3>Información sobre segmentación</h3>\n");
      out.write("        <form action=\"Request\" method=\"post\">\n");
      out.write("            <div class=\"form-group\">\n");
      out.write("                <input type=\"hidden\" name=\"lat\" id=\"lat\">\n");
      out.write("                <input type=\"hidden\" name=\"lon\" id=\"lon\">\n");
      out.write("                <input type=\"hidden\" name=\"radius\" id=\"radius\" value=\"1000\"><!-- aqui puede cambiar -->\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-group\">\n");
      out.write("                <label for=\"minAge\">Edad:</label>\n");
      out.write("                <br>\n");
      out.write("                <select id=\"minAge\" name=\"minAge\">\n");
      out.write("                    <option value=\"18\" selected>18</option>\n");
      out.write("                    ");
 for(int i = 19; i < 65; i++){ 
      out.write("\n");
      out.write("                        <option value=\"");
      out.print(i);
      out.write('"');
      out.write('>');
      out.print(i);
      out.write("</option>\n");
      out.write("                    ");
 } 
      out.write("\n");
      out.write("                </select>\n");
      out.write("                <label> - </label>\n");
      out.write("                <select id=\"maxAge\" name=\"maxAge\">\n");
      out.write("                    ");
 for(int i = 18; i < 64; i++){ 
      out.write("\n");
      out.write("                        <option value=\"");
      out.print(i);
      out.write('"');
      out.write('>');
      out.print(i);
      out.write("</option>\n");
      out.write("                    ");
 } 
      out.write("\n");
      out.write("                    <option value=\"64\" selected>64</option>\n");
      out.write("                </select>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-group\">\n");
      out.write("                <label>Género:</label>\n");
      out.write("                <br>\n");
      out.write("                <label class=\"radio-inline\"> <!-- aqui checar los valores de los radios, en ingles? -->\n");
      out.write("                    <input type=\"radio\" name=\"gender\" value=\"Todos\" checked>Todos\n");
      out.write("                </label>\n");
      out.write("                <label class=\"radio-inline\">\n");
      out.write("                    <input type=\"radio\" name=\"gender\" value=\"Hombres\">Hombres\n");
      out.write("                </label>\n");
      out.write("                <label class=\"radio-inline\">\n");
      out.write("                    <input type=\"radio\" name=\"gender\" value=\"Mujeres\">Mujeres\n");
      out.write("                </label>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-group\">\n");
      out.write("                <label for=\"interests\">Intereses:</label>\n");
      out.write("                <input type=\"text\" name=\"interests\" id=\"interests\" placeholder=\"(separados por coma)\" autocomplete=\"off\" size=\"50\">\n");
      out.write("            </div>\n");
      out.write("            <input class=\"btn btn-default pull-right\" type=\"submit\" value=\"Terminar\">\n");
      out.write("            <br>\n");
      out.write("            <br>\n");
      out.write("        </form>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"col-sm-2 sidenav\">\n");
      out.write("      \n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<script defer async src=\"https://maps.googleapis.com/maps/api/js?key=AIzaSyDcUiD-WFZR5TVypnFv067CKIIjF4v7ptA&libraries=places,drawing&callback=initMap\">\n");
      out.write("</script>\n");
      out.write("<script>\n");
      out.write("    startMap(1);\n");
      out.write("</script>\n");
      out.write("                \n");
      out.write("\n");
      out.write("\n");
      out.write("<footer class=\"container-fluid text-center\">\n");
      out.write("    <p>Footer Text</p>\n");
      out.write("</footer>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write('\n');
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
