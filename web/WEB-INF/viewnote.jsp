<%-- 
    Document   : viewnote
    Created on : Jun 8, 2022, 5:47:16 PM
    Author     : barab
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple Note Keeper</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>View Note</h2>
        
        <p><b>Title: </b>${simpleNote.title}</p>
        <p><b>Contents:</b></p>
        <p>${simpleNote.content}</p>
        
        <a href="note?edit">Edit</a>
    </body>
</html>
