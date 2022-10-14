package com.qiren.miniproj.manager;

import java.io.IOException;

import com.qiren.miniproj.tools.Constants;
import com.qiren.miniproj.tools.Utils;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ServletManager {
    
    public boolean refererCheck(HttpServletRequest request, HttpServletResponse response){
        String referrer = request.getHeader("referer");
        Utils.log("Referer: " + referrer);
        if (null == referrer) {
            try {
                request.setAttribute(Constants.PARAM_ERROR, "Oops, it seems that you are losing the page flow.");
                request.getRequestDispatcher(Constants.PAGE_FAILED).forward(request, response);
            } catch (ServletException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return false;
        }
        return true;
    }
    
    private ServletManager() {
        
    }
    
    public static ServletManager getInstance() {
        return Inner.instance;
    }
    
    private static class Inner {
        static ServletManager instance = new ServletManager();
    }
}
