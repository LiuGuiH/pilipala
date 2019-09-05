package filter;

import util.WordUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebFilter(filterName = "BadWordsFilter", urlPatterns = "/*")
public class BadWordsFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        BWHttpServletRequest bwRequest = new BWHttpServletRequest(request);
        chain.doFilter(bwRequest, response);
    }

    public void init(FilterConfig config) throws ServletException {

    }
}

class BWHttpServletRequest extends HttpServletRequestWrapper {
    private List<String> strs = WordUtil.readTxt();

    /**
     * Constructs a request object wrapping the given request.
     *
     * @param request
     * @throws IllegalArgumentException if the request is null
     */
    public BWHttpServletRequest(HttpServletRequest request) {
        super(request);
    }

    public String getParameter(String name) {
        String value = super.getParameter(name);
        if (value == null) {
            return value;
        }
        for (String s : strs) {
            value = value.replace(s, "**");
        }
        return value;
    }
}

