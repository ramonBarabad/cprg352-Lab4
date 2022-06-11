package servlets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.SimpleNote;

public class NoteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String edit;
        String title, content;
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        SimpleNote note;

        // to read files
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        title=  br.readLine();
        content = br.readLine();
        
        
        
        note = new SimpleNote(title, content);
        request.setAttribute("simpleNote",note);
        
        edit = request.getParameter("edit");
        if( edit == null ){
          getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
        }else{
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
        }
        
        br.close();
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        String title, content;
        
        title = request.getParameter("title");
        content = request.getParameter("content");              
        
        // to write to a file
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false))); 
        pw.println(title);
        pw.print(content);
        pw.close();      
       
        SimpleNote note = new SimpleNote(title, content);
        request.setAttribute("simpleNote", note);        
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
        
        
        
        return;
        
    }


}
